package experimental.interaction;

/**
 * An Interaction encapsulates the logic for one use case. It is responsible for
 * extracting parameters fromt the Request, have the objects interact, capture
 * and report any errors, and return a proper Response.
 * 
 * @param <REQ>
 * 		Type of handled {@link Request}
 * @param <RESP>
 * 		Type of handled {@link Response}
 */
public interface Interaction<REQ extends Request, RESP extends Response> {

	RESP execute(REQ request);
}
