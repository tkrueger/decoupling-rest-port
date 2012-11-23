package experimental.domain;

import java.util.HashMap;

public class MockDropoffRepository implements DropoffRepository {

	HashMap<Integer, Dropoff> wiredDropoffs = new HashMap<Integer, Dropoff>();
	
	@Override
	public Dropoff getPhi(Integer campaign) {
		return wiredDropoffs.get(campaign);
	}
	
	public void wire(Integer capmpaign, Dropoff dropoff) {
		wiredDropoffs.put(capmpaign, dropoff);
	}
}
