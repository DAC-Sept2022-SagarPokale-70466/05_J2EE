package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CandidateDaoImpl;
import dao.UserDaoImpl;
import pojos.User;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			pw.print("<h5>Logout page </h5>");
			// hello user name
			// get HttpSession from WC
			HttpSession session = request.getSession();
			// get user details from the session scope
			User userDetails = (User) session.getAttribute("user_info");
			if (userDetails != null) {
				//greeting mesg
				pw.print("<h5> Hello ,"+userDetails.getFirstName()+"</h5>");
				// chk the voting status
				if (userDetails.isVotingStatus()) {
//voter has already voted
					pw.print("<h5>You have already voted , Can't cast a vote again !</h5>");
				}
				else {
				// not yet voted , get candidate id from req param
					int cId=Integer.parseInt(request.getParameter("candidateId"));
					//get daos from session scope
					UserDaoImpl userDao=(UserDaoImpl)session.getAttribute("user_dao");
					CandidateDaoImpl candidateDao=(CandidateDaoImpl)session.getAttribute("candidate_dao");
					//invoke dao's method to update voting status
					pw.print("<h5> "+userDao.updateVotingStatus(userDetails.getUserId())+"</h5>");
					//invoke candidate dao's method ot incr votes
					pw.print("<h5> "+candidateDao.incrementVotes(cId)+"</h5>");			}
				
			} else
				pw.print("<h5>No Cookies , Session Tracking Failed !!!!!</h5>");
			//discard session
			session.invalidate();
			pw.print("<h5> You have logged out.....</h5>");
			

		} catch (Exception e) {
			throw new ServletException("err in do-get of "+getClass(), e);
		}
	}

}
