package network;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Scanner;

public class UdpServer {
	public static void main(String[] args) {
		byte[] data = new byte[200];
		DatagramPacket packet = new DatagramPacket(data, data.length);
		try {
			DatagramSocket socket = new DatagramSocket(7777);
			System.out.println("서비스가 시작되었습니다.");
			socket.receive(packet);
			System.out.println("클라이언트의 ip주소:" + packet.getAddress().getHostAddress());
			String receive = new String(packet.getData());
			System.out.println("클라이언트의 메시지:" + receive);
			
			System.out.println("응답할 메시지를 입력하세요.");
			Scanner scan = new Scanner(System.in);
			String msg = scan.next();
			scan.close();
			packet = new DatagramPacket(msg.getBytes(), msg.getBytes().length, packet.getAddress(), 8888);
			socket.send(packet);
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
