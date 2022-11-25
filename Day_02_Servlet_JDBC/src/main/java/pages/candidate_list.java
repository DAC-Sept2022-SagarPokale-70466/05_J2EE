package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/candidate_list")
public class candidate_list extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		try (PrintWriter pw = response.getWriter()) {

			pw.print("<h5>Welcome Voter !!!</h5>");

			Cookie[] cookie = request.getCookies();

			if (cookie != null) {
				for (Cookie c : cookie) {
					if (c.getName().equals("user_detils")) {
						pw.print("<h4> User details from a Cookie " + c.getValue() + "</h4>");
					} else {
						pw.print("<h4> No Cookies , No Session Tracking!!!!!!!!!!!!!!</h4>");
					}
				}
			}
		}
	}
}
