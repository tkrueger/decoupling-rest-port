package experimental.interaction;

public class BaseResponse implements Response {

	private InteractionError error = null;

	@Override
	public boolean isFailure() {
		return error != null;
	}
	
	@Override
	public InteractionError error() {
		return error;
	}
	
	public void error(InteractionError error) {
		this.error = error;
	}
}
