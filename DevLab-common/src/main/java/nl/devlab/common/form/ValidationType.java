package nl.devlab.common.form;

/**
 * @author Marco Kortooms - Atos
 *
 */
public enum ValidationType {

	NOVALIDATION(0), NOTEMPTY(1);

	private int validationType;
	
	private ValidationType(int validationType) {
		this.validationType = validationType;
	}

	public int getValidationType() {
		return validationType;
	}

}
