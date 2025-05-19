package network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TextDown {
	public static void main(String[] args) {
		URL url = null;
		try {
			url = new URL("https://raw.githubusercontent.com/selva86/datasets/master/ozone.csv");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			if (conn != null) {
				conn.setConnectTimeout(3000);
				if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
					BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
					BufferedWriter bw = new BufferedWriter(new FileWriter(new File("c:/work/ozone.csv")));
					while (true) {
						String line = br.readLine();
						if (line == null)
							break;
						bw.write(line + "\n");
					}
					br.close();
					bw.close();
					System.out.println("done");
				}
				conn.disconnect();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
