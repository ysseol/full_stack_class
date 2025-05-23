package common;

import jakarta.servlet.http.Cookie;

public class MyCookie {

	public static String getCookie(Cookie[] cookies, String name) {
		String result = "";
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals(name)) {
					result = cookies[i].getValue();
					break;
				}
			}
		}
		return result;
	}
}
