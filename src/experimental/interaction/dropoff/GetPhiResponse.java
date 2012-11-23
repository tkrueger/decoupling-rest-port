package experimental.interaction.dropoff;

import experimental.domain.Dropoff;
import experimental.interaction.BaseResponse;
import experimental.interaction.Response;

public class GetPhiResponse extends BaseResponse implements Response {

	private Dropoff dropoff;

	public GetPhiResponse(Dropoff dropoff) {
		this.dropoff = dropoff;
	}

	public Dropoff getDropoff() {
		return dropoff;
	}

}
