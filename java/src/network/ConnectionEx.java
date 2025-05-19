package network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConnectionEx {
	public static void main(String[] args) {
		URL url = null;
		try {
			url = new URL("http://google.com");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			if (conn != null) {
				conn.setConnectTimeout(1000);
				StringBuilder sb = new StringBuilder();
				if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
					BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
					while (true) {
						String line = br.readLine();
						if (line == null)
							break;
						sb.append(line + "\r\n");
					}
					br.close();
				}
				conn.disconnect();
				System.out.println(sb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
