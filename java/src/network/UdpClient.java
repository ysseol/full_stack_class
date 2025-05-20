package network;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UdpClient {
	public static void main(String[] args) {
		try {
			InetAddress address = InetAddress.getByName("localhost");
			System.out.println("서버에 전송할 메시지를 입력하세요.");
			Scanner scan = new Scanner(System.in);
			String data = scan.next();
			scan.close();
			byte[] send = data.getBytes();
			DatagramPacket packet = new DatagramPacket(send, send.length, address, 7777);
			DatagramSocket socket = new DatagramSocket();
			socket.send(packet);
			socket.close();
			System.out.println("전송이 완료되었습니다.");
			
			DatagramSocket socket2 = new DatagramSocket(8888);
			byte[] data2 = new byte[200];
			DatagramPacket packet2 = new DatagramPacket(data2, data2.length);
			socket2.receive(packet2);
			socket2.close();
			String message = new String(data2);
			System.out.println("수신한 메시지:" + message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
