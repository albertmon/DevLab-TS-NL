package nl.devlab.common;

public class GenericException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final String customMsg;

	// getter and setter methods

	/**
	 * @param customMsg
	 *            construnctor
	 */
	public GenericException(final String customMsg) {
		this.customMsg = customMsg;
	}

	/**
	 * @return getCustommerMsg
	 */
	public final String getCustomMsg() {
		return customMsg;
	}

}
