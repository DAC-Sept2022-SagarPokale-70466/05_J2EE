package dependent;

import dependency.HttpTransport;
import dependency.Transport;

public class ATMImpl implements ATM {
	private Transport myTransport ;//= new HttpTransport();// creating dependency n linking it with the dep. obj

	public ATMImpl() {
		System.out.println("In Constructor of " + getClass().getName() + " " + myTransport);
	}

	@Override
	public void deposit(double amt) {
		System.out.println("depositing " + amt);
		byte[] data = ("depositing " + amt).getBytes();
		myTransport.informBank(data);

	}

	@Override
	public void withdraw(double amt) {
		System.out.println("withdrawing " + amt);
		byte[] data = ("withdrawing " + amt).getBytes();
		myTransport.informBank(data);
	}
	//setter

	public void setMyTransport(Transport myTransport) {		
		this.myTransport = myTransport;		
		System.out.println("in set transport "+this.myTransport);
	}
	

}
