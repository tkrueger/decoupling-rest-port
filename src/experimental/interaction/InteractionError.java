package experimental.interaction;

/**
 * Represents any Error that was captured during processing of a {@link Request}.
 */
public class InteractionError {

	private final int errorCode;
	private String message;

	public InteractionError(int errorCode, String message) {
		super();
		this.errorCode = errorCode;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getErrorCode() {
		return errorCode;
	}

}
