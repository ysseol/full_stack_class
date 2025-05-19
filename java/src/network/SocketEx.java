package network;

import java.io.IOException;
import java.net.ServerSocket;

public class SocketEx {
	public static void main(String[] args) {
		ServerSocket socket = null;
		for (int i = 0; i <= 1000; i++) {
			try {
				socket = new ServerSocket(i);
				socket.close();
			} catch (IOException e) {
				System.out.println(i + "번 포트는 사용중입니다.");
			}
		}
	}
}
