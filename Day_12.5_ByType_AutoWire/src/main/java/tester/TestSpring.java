package tester;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import dependent.ATMImpl;

public class TestSpring {

	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext ctx =
				new ClassPathXmlApplicationContext("bean-config.xml")) {
			System.out.println("SC booted !!!!!!!!!!!!!");
			//withdraw 1000
			//get ready to use(loc--load-inst--D.I --init) spring bean from SC
			ATMImpl ref1=ctx.getBean("my_atm", ATMImpl.class);
			ref1.withdraw(1000);
			ATMImpl ref2=ctx.getBean("my_atm", ATMImpl.class);
			System.out.println(ref1==ref2);//true : singleton
			
		} //JVM : ctx.close => SC shut down --> singletone bean : destroy --> GC 
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
