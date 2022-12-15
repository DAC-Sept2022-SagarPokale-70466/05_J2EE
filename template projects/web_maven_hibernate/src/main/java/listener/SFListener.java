package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import utils.HibernateUtils;

@WebListener
public class SFListener implements ServletContextListener {

	public SFListener() {

	}

	public void contextDestroyed(ServletContextEvent sce) {

	}

	public void contextInitialized(ServletContextEvent sce) {
			System.out.println("In Context Listener ");
//			Create singleton, immutable, thread safe SF instance
			HibernateUtils.getFactory();
	}

}
