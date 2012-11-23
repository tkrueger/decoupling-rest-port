package experimental.interaction.dropoff;

import experimental.interaction.Request;

public class GetPhiRequest implements Request {

	private final Integer campaignId;
	
	public GetPhiRequest(Integer campaignId) {
		super();
		this.campaignId = campaignId;
	}

	public Integer getCampaignId() {
		return campaignId;
	}

}
