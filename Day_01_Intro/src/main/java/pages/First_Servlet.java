package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Test_01")
// Map : Key :  /Test_01
//			Value : pages.FirstServlet
public class First_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() throws ServletException {
		System.out.println("Yoooooooooooooooooooooooooooo");
	}

	public void destroy() {
		System.out.println("Destorrryyyyy");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Inside doGet...............");

		response.setContentType("text/html");
//		1. Set Content Type

//		2. Get the PrintWriter to send the response to Client
		try (PrintWriter pw = response.getWriter()) {

			pw.print("<h3>HEHEHEHEHEHEHEHEHEHEHE  " + new Date() + "</h3>");

		} // pw.close(); -> pw.flush() -> Response is send the client(Committed)
	}

}
