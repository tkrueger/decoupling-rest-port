package experimental.rest;

import experimental.domain.Dropoff;
import experimental.domain.DropoffRepository;
import experimental.infrastructure.ServiceLocator;
import experimental.interaction.dropoff.GetPhi;
import experimental.interaction.dropoff.GetPhiRequest;
import experimental.interaction.dropoff.GetPhiResponse;

/**
 * The Rest service.
 */
public class DropoffService {

	/**
	 * This Method would be annotated to leverage Jersey, for example.
	 * <p>
	 * Transforms REST request into an application request, has that processed,
	 * converts the application's response, and returns the data.
	 * <p>
	 * All REST Port's method work after this pattern.
	 * 
	 * @param campaignId
	 *            campaign id. As a string, because the API works that way (not
	 *            important in this context)
	 * @return
	 */
	// TODO parameter parsing
	// TODO error handling
	public Dropoff getPhi(String campaignId) {
		Integer campaign = new Integer(campaignId);
		GetPhiResponse response = newGetPhi().execute(new GetPhiRequest(campaign));
		return response.getDropoff();
	}

	// overwritable for tests
	protected GetPhi newGetPhi() {
		return new GetPhi(ServiceLocator.get().lookup(DropoffRepository.class));
	}

}
