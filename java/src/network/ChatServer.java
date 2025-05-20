package network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer {
	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(5555);
			System.out.println("started...");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error...");
			System.exit(1);
		}
		Socket clientSocket = null;
		try {
			clientSocket = serverSocket.accept();
			System.out.println("client's ip:" + clientSocket.getInetAddress().getHostAddress());
		} catch (Exception e) {
			e.printStackTrace();
		}
		PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
		BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		String receive = "";
		String send = "Welcome!!!";
		writer.println(send);
		Scanner sc = new Scanner(System.in);
		while (true) {
			receive = reader.readLine();
			if (receive == null || receive.equals("q")) {
				break;
			}
			System.out.println("[client] " + receive);
			System.out.println("input(quit:q):");
			send = sc.nextLine();
			writer.println(send);
			if (send.equals("q")) {
				break;
			}
		}
		sc.close();
		writer.close();
		reader.close();
		clientSocket.close();
		serverSocket.close();
	}
}
