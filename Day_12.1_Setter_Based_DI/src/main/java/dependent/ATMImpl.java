package dependent;

import dependency.HttpTransport;
import dependency.Transport;

public class ATMImpl implements ATM {
	private Transport myTransport;// = new HttpTransport();// creating dependency n linking it with the dep. obj

	public ATMImpl() {
		System.out.println("In Constructor of " + getClass().getName() + " " + myTransport);// null
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

	// setter based D.I : invoked auto by SC : after creating instance n before
	// invoking custom init method
	public void setMyTransport12(Transport myTransport) {		// One Per depedency
		this.myTransport = myTransport;
		System.out.println("in setMyTransport " + this.myTransport);
	}

	// custom init method
	public void myInit() {
		System.out.println("in init " + myTransport);// not null!
	}

	// custom destroy method
	public void myDestroy() {
		System.out.println("in destroy " + myTransport);// not null!
	}

}
