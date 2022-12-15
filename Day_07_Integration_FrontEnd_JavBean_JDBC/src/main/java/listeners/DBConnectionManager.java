package listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import static utils.DBUtils.*;

import java.sql.SQLException;

/**
 * Application Lifecycle Listener implementation class DBConnectionManager
 *
 */
@WebListener
public class DBConnectionManager implements ServletContextListener {

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("in ctx destroyed");
		try {
			closeConnection();
		} catch (SQLException e) {
			System.out.println("err in ctx destroyed "+e);
		}
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("in ctx inited");
		// get servlet ctx from servlet ctx event
		ServletContext ctx = sce.getServletContext();
		try {
			openConnection(ctx.getInitParameter("url"), ctx.getInitParameter("user_name"),
					ctx.getInitParameter("password"));
		} catch (SQLException e) {
			System.out.println("err in ctx inited "+e);
		}

	}

}
