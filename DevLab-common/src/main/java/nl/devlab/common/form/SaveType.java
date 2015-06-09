package nl.devlab.common.form;

/**
 * @author Marco Kortooms - Atos
 *
 */
public enum SaveType {

	NOSAVE(0), SAVE(1);

	private int saveType;
	
	private SaveType(int saveType) {
		this.saveType = saveType;
	}

	public int getSaveType() {
		return saveType;
	}

}
