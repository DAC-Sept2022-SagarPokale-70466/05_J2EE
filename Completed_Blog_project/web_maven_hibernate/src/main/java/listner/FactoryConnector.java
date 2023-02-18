package listner;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import static utils.HibernateUtils.*;
/**
 * Application Lifecycle Listener implementation class FactoryConnector
 *
 */
@WebListener
public class FactoryConnector implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent sce)  { 
        System.out.println("Ctx Destroyed");
    	getFactory().close();
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("Ctx init");
        getFactory();
    }
	
}
