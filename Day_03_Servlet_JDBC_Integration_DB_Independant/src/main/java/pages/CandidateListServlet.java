package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CandidateDaoImpl;
import pojos.Candidate;
import pojos.User;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/candidate_list")
public class CandidateListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			pw.print("<h5>Welcome Voter !!!</h5>");
			// get user details from HttpSession
			// 1. get HttpSession from WC
			HttpSession hs = request.getSession();
			System.out.println("From candidate servlet : is new " + hs.isNew()); // false : provided cookies are enabled
																					// , o.w true
			System.out.println("session id " + hs.getId());// same session id : if cookies are enabled
			// 2. get details from session scope
			User details = (User) hs.getAttribute("user_info");
			if (details != null) {
				pw.print("<h4>Hello ,  " + details.getFirstName() + "</h4>");
				// get candidate dao from sesison scope
				CandidateDaoImpl canDao = (CandidateDaoImpl) hs.getAttribute("candidate_dao");
				// invoke dao's method to get a candidate list
				List<Candidate> candidates = canDao.getAllCandidates();
				// dynamic form generation
				pw.print("<form action='logout'>");
				for (Candidate c : candidates)
					pw.print("<h5><input type='radio' name='candidateId' value='" + c.getCandidateId() + "'/>"
							+ c.getName()+"</h5>");
				pw.print("<h4><input type='submit' value='Vote'/></h4>");
				pw.print("</form>");

			}

			else
				pw.print("<h4> No Cookies , No Session Tracking!!!!!!!!!!!!!!</h4>");
			// pw.print("Hello "+request.getParameter("email"));
		} catch (Exception e) {
			// inform WC about the exc
			throw new ServletException("err in do-get of " + getClass(), e);

		}
	}

}
