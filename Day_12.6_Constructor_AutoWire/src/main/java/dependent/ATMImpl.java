package dependent;

import dependency.Transport;

public class ATMImpl implements ATM {
	private Transport myTransport;// = new HttpTransport();// creating dependency n linking it with the dep. obj

	//implicit(auto wire) ctor based D.I
	public ATMImpl(Transport t) {
		this.myTransport = t;
		System.out.println("in cnstr of " + getClass().getName() + " " + myTransport);// not null
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
	public void myInit() {
		System.out.println("myInit " + myTransport);// not null!
	}

	// custom destroy method
	public void myDestroy() {
		System.out.println("in destroy " + myTransport);// not null!
	}

}
