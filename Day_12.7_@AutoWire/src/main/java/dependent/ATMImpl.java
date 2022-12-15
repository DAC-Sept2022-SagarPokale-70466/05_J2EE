package dependent;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import dependency.Transport;

//singleton n eager
@Component("my_atm")
public class ATMImpl implements ATM {
	// field level D.IC
	@Autowired // (required = false) // required=true , //autowrire -> byType
	@Qualifier("soapTransport") // autowire=byName : w/o a setter
	private Transport myTransport;// = new HttpTransport();// creating dependency n linking it with the dep. obj

	public ATMImpl() {

		System.out.println("in cnstr of " + getClass().getName() + " " + myTransport);// null
	}

	@Override 
	public void deposit(double amt) {
		System.out.println("depositing " + amt);
		byte[] data = ("depositing " + amt).getBytes();
		myTransport.informBank(data);// using dependency layer

	}

	@Override
	public void withdraw(double amt) {
		System.out.println("withdrawing " + amt);
		byte[] data = ("withdrawing " + amt).getBytes();
		myTransport.informBank(data);// using dependency layer
	}

	// custom init method
	@PostConstruct // Method level to tell SC follow is custom init method --to be called , after
					// D.I
	public void myInit() {
		System.out.println("in init " + myTransport);// not null!
	}

	// custom destroy method
	@PreDestroy // to tell SC follow is custom destroy method : to be called for onlt for
				// singleton beans before GC
	public void myDestroy() {
		System.out.println("in destroy " + myTransport);// not null!
	}

}
