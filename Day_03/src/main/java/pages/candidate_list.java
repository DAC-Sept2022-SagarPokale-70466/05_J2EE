package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Candidate_Dao_Implementation;
import pojo.Candidate;
import pojo.User;

@WebServlet("/candidate_list")
public class candidate_list extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			pw.print("<h5>Welcome Voter !!!</h5>");
//			Cookie[] cookie = request.getCookies();

			HttpSession session = request.getSession();

			System.out.println("From candidate servlet : is new " + session.isNew()); // false : provided cookies are
																						// enabled
			// , o.w true
			System.out.println("session id " + session.getId());// same session id : if cookies are enabled
			// 2. get details from session scope
			User details = (User) session.getAttribute("user_info");

			if (details != null) {

				pw.print("<h4>Hello ,  " + details.getFirstName() + "</h4>");

				Candidate_Dao_Implementation canDao = (Candidate_Dao_Implementation) session
						.getAttribute("candidate_dao");

				List<Candidate> candidates = canDao.getAllCandidates();

				// dynamic form generation
				pw.print("<form action='logout'>");
				for (Candidate c : candidates)
					pw.print("<h5><input type='radio' name='candidateId' value='" + c.getCandidateId() + "'/>"
							+ c.getName() + "</h5>"); // getName from pojo
				pw.print("<h4><input type='submit' value='Vote'/></h4>");
				pw.print("</form>");

			} else {
				pw.print("<h4> No Cookies , No Session Tracking!!!!!!!!!!!!!!</h4>");
			}
		} catch (SQLException e) {
			// inform WC about the exc
			throw new ServletException("err in do-get of " + getClass(), e);

		}
	}
}
