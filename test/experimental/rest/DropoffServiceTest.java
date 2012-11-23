package experimental.rest;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import experimental.domain.Dropoff;
import experimental.domain.MockDropoffRepository;
import experimental.interaction.dropoff.GetPhi;
import experimental.interaction.dropoff.GetPhiRequest;
import experimental.interaction.dropoff.GetPhiResponse;

public class DropoffServiceTest {

	private boolean getPhiWasExecuted;
	private GetPhiResponse getPhiResponse;

	private class RecordingGetPhi extends GetPhi {

		public RecordingGetPhi() {
			super(new MockDropoffRepository());
		}

		@Override
		public GetPhiResponse execute(GetPhiRequest request) {
			getPhiWasExecuted = true;
			getPhiResponse = new GetPhiResponse(new Dropoff(request.getCampaignId(), 1.0d));
			return getPhiResponse;
		}
	}

	class TestableDropoffService extends DropoffService {

		@Override
		protected GetPhi newGetPhi() {
			return new RecordingGetPhi();
		}
	}

	@Test
	public void returnsDropoffOnGetPhi() throws Exception {
		String campaignId = "123";
		Dropoff dropoff = new TestableDropoffService().getPhi(campaignId);
		assertSame(getPhiResponse.getDropoff(), dropoff);
	}

	@Test
	public void executesGetPhiInteractionOnGetPhi() throws Exception {
		new TestableDropoffService().getPhi("123");
		assertTrue(getPhiWasExecuted);
	}
}
