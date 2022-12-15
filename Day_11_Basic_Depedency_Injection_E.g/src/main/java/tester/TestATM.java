package tester;

import dependency.HttpTransport;
import dependency.SoapTransport;
import dependent.ATMImpl;

public class TestATM {

	public static void main(String[] args) {
		//withdraw funds : 1000
		ATMImpl atm=new ATMImpl();// creating dependent obj
		atm.setMyTransport(new SoapTransport());
		atm.withdraw(1000);

	}

}
