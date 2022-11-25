package pages;

import static DBUtil.DbUtil.closeConnection;
import static DBUtil.DbUtil.openConnection;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Candidate_Dao_Implementation;
import dao.User_Dao_Implementaion;
import pojo.User;

@WebServlet(value="/register", loadOnStartup = 2)
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private User_Dao_Implementaion userDao;
	
	public void init(ServletConfig config) throws ServletException {
		try {
			openConnection();
			userDao = new User_Dao_Implementaion();
			
			System.out.println("SignUP init Complete for  " + getClass());

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
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		System.out.println("Inside DoPost");
		
		try(PrintWriter pw = response.getWriter()){
			
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String dob = request.getParameter("dob");
			Date date = Date.valueOf(dob);
			String role = request.getParameter("role");
			System.out.println("Before InsertValues Calling");
			int rowCount = userDao.insertValues(fname, lname, email, password, date, role);
			System.out.println("After InsertValues Calling");
			if(rowCount == 1) {
				pw.print("<h3>Succussfully Added User</h3>");
				pw.print("<h4> LogIn , Please <a href='login.html'>LogIn</a></h4>");
			}
			else {
//				pw.print("<h4> Invalid SignUp , Please <a href='register.html'>Retry</a></h4>");
				response.sendRedirect("Error.html");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
