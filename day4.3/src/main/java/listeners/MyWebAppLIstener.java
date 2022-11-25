package listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener // MANDATORY cls level annotation to tell WC following is web app listener
public class MyWebAppLIstener implements ServletContextListener, HttpSessionListener, ServletRequestListener {
	
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("in sess created !");
	}

	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("in re destroyed");
	}

	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("in req inited");
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("in sess destroyed !");
	}

	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("in ctx destroyed !");
	}

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("in ctx inited");
	}

}
