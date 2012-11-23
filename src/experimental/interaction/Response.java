package experimental.interaction;

public interface Response {

	/**
	 * Signals if there were any errors during request processing that resultet
	 * in a failure.
	 * 
	 * @return <code>true</code> if there were errors.
	 * @see
	 */
	boolean isFailure();

	/**
	 * Returns the error during processing, if any
	 * 
	 * @return {@link InstantiationError} or <code>null</code>
	 */
	InteractionError error();
}
