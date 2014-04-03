package security;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecurityManager1
 */
@WebServlet("/SecurityManager1")
public class SecurityManager extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static HashMap<String, String> cookies = new HashMap<String, String>();

	@SuppressWarnings("static-access")
	public void check(URLConnection http) {
		final Cookie cookie = CookieIdentifier.identifyCookie(http);
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					if (cookies.containsKey(cookie.get_key()))
						return;
					else {
						// do the task
					}
				}
			}
		});
		try {
			t.sleep(60000);
			t.start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SecurityManager() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String address = request.getRemoteAddr();
		URL url = new URL(address);
		URLConnection http = url.openConnection();
		check(http);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String address = request.getRemoteAddr();
		URL url = new URL(address);
		URLConnection http = url.openConnection();
		check(http);
	}

}
