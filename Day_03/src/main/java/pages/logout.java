package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Candidate_Dao_Implementation;
import dao.User_Dao_Implementaion;
import pojo.User;

/**
 * Servlet implementation class logout
 */
@WebServlet("/logout")
public class logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			pw.print("<h5>Logout page </h5>");

			HttpSession session = request.getSession();

			User userDetails = (User) session.getAttribute("user_info");

			if (userDetails != null) {
				pw.print("<h5>Hello : ) " + userDetails.getFirstName() + "</h5>");

				if (userDetails.isVotingStatus()) {
					pw.print("<h5>You have already voted , Can't cast a vote again !</h5>");
				} else {
					int candidate = Integer.parseInt(request.getParameter("candidateId"));

					User_Dao_Implementaion userDao = (User_Dao_Implementaion) session.getAttribute("user_dao");

					Candidate_Dao_Implementation candidateDao = (Candidate_Dao_Implementation) session
							.getAttribute("candidate_dao");

					pw.print("<h5> " + userDao.updateVotingStatus(userDetails.getUserId()) + "</h5>");

					pw.print("<h5> " + candidateDao.incrementVotes(candidate) + "</h5>");
				}

			} else
				pw.print("<h5>No Cookies , Session Tracking Failed !!!!!</h5>");
			// discard session
			session.invalidate(); // Marked for GC
			pw.print("<h5> You have logged out.....</h5>");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
