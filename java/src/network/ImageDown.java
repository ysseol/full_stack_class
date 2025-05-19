package network;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class ImageDown {
	public static void main(String[] args) throws Exception {
		String img = "https://cdn.pixabay.com/photo/2024/02/23/23/58/dog-8593014_640.jpg";
		URL url = new URL(img);
		byte[] buffer = new byte[4096];
		InputStream in = url.openStream();
		OutputStream out = new FileOutputStream("c:/work/test.jpg");
		int length = 0;
		while ((length = in.read(buffer)) != -1) {
			System.out.println(length + "바이트 읽음");
			out.write(buffer, 0, length);
		}
		System.out.println("done");
		in.close();
		out.close();
	}
}
