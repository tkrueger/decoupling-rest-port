package experimental.infrastructure;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

import experimental.domain.Dropoff;


public class ServiceLocatorTest {

	@After
	public void clearRegistry() {
		ServiceLocator.get().clear();
	}
	
	@Test
	public void returnsNullForUnkownServices() throws Exception {
		assertNull(ServiceLocator.get().lookup(Dropoff.class));
	}
	
	@Test
	public void canWireServices() throws Exception {
		Dropoff wired = new Dropoff(123, 1.0d);
		Class<Dropoff> type = Dropoff.class;
		ServiceLocator.get().wire(type, wired);
		
		assertSame(wired, ServiceLocator.get().lookup(type));
	}
	
	@Test
	public void multipleWritingsForSameTypeOverwrite() throws Exception {
		Dropoff wiredFirst = new Dropoff(123, 1.0d);
		Dropoff wiredLast = new Dropoff(456, .5d);
		Class<Dropoff> type = Dropoff.class;
		ServiceLocator.get().wire(type, wiredFirst);
		Dropoff pushedOff = ServiceLocator.get().wire(type, wiredLast);
		
		assertSame(wiredLast, ServiceLocator.get().lookup(type));
		assertSame(wiredFirst, pushedOff);
	}
	
	@Test
	public void clearRemovesWirings() throws Exception {
		Dropoff wired = new Dropoff(123, 1.0d);
		Class<Dropoff> type = Dropoff.class;
		ServiceLocator.get().wire(type, wired);
		
		ServiceLocator.get().clear();
		assertNull(ServiceLocator.get().lookup(type));
	}
}
