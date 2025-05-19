package network;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateServer {
	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(9100);
		System.out.println("서비스가 시작되었습니다.");
		while (true) {
			Socket socket = ss.accept();
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
			String str = sdf.format(new Date());
			out.println(str);
			socket.close();
		}
	}
}
