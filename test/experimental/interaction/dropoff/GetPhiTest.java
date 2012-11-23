package experimental.interaction.dropoff;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

import experimental.domain.Dropoff;
import experimental.domain.MockDropoffRepository;
import experimental.interaction.dropoff.GetPhi;
import experimental.interaction.dropoff.GetPhiRequest;
import experimental.interaction.dropoff.GetPhiResponse;


public class GetPhiTest {

	MockDropoffRepository dropoffRepo;
	
	@Before
	public void setUp() {
		dropoffRepo = new MockDropoffRepository();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void requiresRepo() throws Exception {
		new GetPhi(null);
	}
	
	@Test
	public void usesRepositoryToSatisfyRequest() throws Exception {
		int campaignId = 123;
		Dropoff wiredDropoff = new Dropoff(campaignId, 1.0d);
		dropoffRepo.wire(campaignId, wiredDropoff);
		GetPhiResponse response = new GetPhi(dropoffRepo).execute(new GetPhiRequest(campaignId));
		assertNotNull(response);
		assertSame(wiredDropoff, response.getDropoff());
	}
}
