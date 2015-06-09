package nl.devlab.common.form;

/**
 * @author Marco Kortooms - Atos
 *
 */
public enum FormElementType {

	FORM("form"), TAB("Tab"), FIELD("Field");

	private String formElementType;
	
	private FormElementType(String formElementType) {
		this.formElementType = formElementType;
	}

	public String getFormElementType() {
		return formElementType;
	}

}
