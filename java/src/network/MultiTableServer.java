package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class MultiTableServer implements Runnable {
	private ServerSocket serverSocket;
	private Socket socket;
	private DataInputStream dis;
	private DataOutputStream dos;

	public MultiTableServer() {
		try {
			serverSocket = new ServerSocket(9999);
			System.out.println("started...");
		} catch (Exception e) {
			e.printStackTrace();
		}
		while (true) {
			try {
				socket = serverSocket.accept();
				InetAddress ip = socket.getInetAddress();
				System.out.println("client's ip:" + ip);
				dis = new DataInputStream(socket.getInputStream());
				dos = new DataOutputStream(socket.getOutputStream());
				Thread th = new Thread(this);
				th.start();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void run() {
		try {
			while (true) {
				int table = dis.readInt();
				StringBuilder sb = new StringBuilder();
				for (int i = 1; i <= 9; i++) {
					sb.append(table + "x" + i + "=" + table * i + "\n");
				}
				dos.writeUTF(sb.toString());
			}
		} catch (SocketException e) {
			System.out.println("클라이언트의 연결이 끊어졌습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new MultiTableServer();
	}
}
