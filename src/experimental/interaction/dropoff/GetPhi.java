package experimental.interaction.dropoff;

import experimental.domain.Dropoff;
import experimental.domain.DropoffRepository;
import experimental.interaction.Interaction;

public class GetPhi implements Interaction<GetPhiRequest, GetPhiResponse>{

	private DropoffRepository repository;

	public GetPhi(DropoffRepository repository) {
		if (repository == null)
			throw new IllegalArgumentException("Argument repository is mandatory");
		
		this.repository = repository;
	}
	
	@Override
	public GetPhiResponse execute(GetPhiRequest request) {
		Integer campaignId = request.getCampaignId();
		Dropoff dropoff = repository.getPhi(campaignId);
		GetPhiResponse response = new GetPhiResponse(dropoff);
		return response;
	}
}
