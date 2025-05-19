package network;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class EncodeEx {
	public static void main(String[] args) {
		try {
			System.out.println(URLEncoder.encode("my name is kim", "utf-8"));
			System.out.println(URLDecoder.decode("my+name+is+kim", "utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
