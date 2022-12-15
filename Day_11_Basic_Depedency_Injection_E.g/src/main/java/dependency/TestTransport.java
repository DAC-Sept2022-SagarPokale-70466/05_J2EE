package dependency;

public class TestTransport implements Transport {
	public TestTransport() {
		System.out.println("In Constructor of " + getClass().getName());
	}

	@Override
	public void informBank(byte[] data) {
		System.out.println("informing bank using " + getClass().getName() + " layer");

	}

}
