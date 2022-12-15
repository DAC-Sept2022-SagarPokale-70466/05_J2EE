package dependency;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

//spring bean : generic 
//singleton n eager
@Component("test")		// mandatory class lvl anno to tell sc : following  is a sprint bean -- to be managed by sc
//@Lazy(true)
public class TestTransport implements Transport {
	public TestTransport() {
		System.out.println("in cnstr of " +getClass().getName());
	}

	@Override
	public void informBank(byte[] data) {
		System.out.println("informing bank using " + getClass().getName() + " layer");

	}

}
