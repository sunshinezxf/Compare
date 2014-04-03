package security;

import java.net.URLConnection;

public class CookieIdentifier {
	public static Cookie identifyCookie(URLConnection http) {
		String key = null;
		for (int i = 1; (key = http.getHeaderFieldKey(i)) != null; i++) {
			if (key.equalsIgnoreCase("set-cookie"))
				;
			String cookie = http.getHeaderField(i);
			int i1 = cookie.indexOf("=");
			int i2 = cookie.indexOf(";");
			if (i1 != -1 && i2 != -1) {
				String _value = cookie.substring(i1 + 1, i2);
				String _key = cookie.substring(0, i1);
				return new Cookie(_key, _value);
			}
		}
		return null;
	}
}
