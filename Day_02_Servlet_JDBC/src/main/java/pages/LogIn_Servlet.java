package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import static DBUtil.DbUtil.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoImplementaion;
import dao.UserDao;
import pojo.User;

@WebServlet(value = "/validate", loadOnStartup = 1)

public class LogIn_Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private DaoImplementaion userDao;

	@Override
	public void init(ServletConfig config) throws ServletException {

		try {
			openConnection();
			userDao = new DaoImplementaion();
			System.out.println("init Complete for " + getClass());

		} catch (Exception e) {

			throw new ServletException("err in init of " + getClass(), e);
		}
	}

	public void destroy() {

		try {
			userDao.cleanUp();
			closeConnection(); // From DbUtil
		} catch (SQLException e) {
			// System.out.println("err in destroy of "+getClass()+" err "+e);
			throw new RuntimeException("err in destroy " + getClass(), e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		try (PrintWriter pw = response.getWriter()) {

			String em = request.getParameter("email");
			String pwd = request.getParameter("pass");

			User user = userDao.authenticateUser(em, pwd);

			if (user == null)
				pw.print("<h4> Invalid Login , Please <a href='login.html'>Retry</a></h4>");
			else {

				Cookie c = new Cookie("user_detils", user.toString()); // Saving Cookie

				response.addCookie(c);

				pw.print("from login page!!!!!!!!!!!!!!!!!");

				if (user.getRole().equals("admin")) {
					response.sendRedirect("admin");
				} else {

					if (user.isVotingStatus())
						response.sendRedirect("logout");
					else {
						response.sendRedirect("candidate_list");
					}
				}
			}

		} catch (SQLException e) {

			throw new ServletException("Error in doPost Method", e);
		}

	}

}
