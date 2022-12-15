package tester;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import dependent.ATMImpl;

public class TestSpring {

	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("bean-config.xml")) {
			System.out.println("SC booted !!!!!!!!!!!!!");
//			ATMImpl aa = ctx.getBean("my_atm", ATMImpl.class);
//			System.out.println(aa);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
