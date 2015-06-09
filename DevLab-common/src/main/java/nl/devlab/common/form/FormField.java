package nl.devlab.common.form;

/**
 * @author Marco Kortooms - Atos
 *
 */
public class FormField extends FormElement {

	private String blockId = "";
	private String groupId = "";
	private String subtypeId = "";
	private String title = "";
	private String description = "";
	private ValidationType validationType = ValidationType.NOTEMPTY; // Set default validation of field to NOTEMPTY
	private SaveType saveType = SaveType.SAVE; // set default of all field to SAVE
	private String value = "";
	private FormFieldType type = FormFieldType.TEXT;
	private String[] comboboxValues;
	private String modalFormName;
	
	public FormField(String name) {
		super(FormElementType.FIELD, name);
	}
	public FormField(String blockId,
			String groupId, String subtypeId, String name, String title,
			String description) {
		
		super(FormElementType.FIELD, name);
		
		this.blockId = blockId;
		this.groupId = groupId;
		this.subtypeId = subtypeId;
		this.title = title;
		this.description = description;
		this.validationType = ValidationType.NOTEMPTY;
		this.saveType = SaveType.SAVE;
	}
	public FormField(String blockId,
			String groupId, String subtypeId, String name,
			String title, String description, 
			ValidationType validationType, SaveType saveType) {
		
		super(FormElementType.FIELD, name);
		
		this.blockId = blockId;
		this.groupId = groupId;
		this.subtypeId = subtypeId;
		this.title = title;
		this.description = description;
		this.validationType = validationType;
		this.saveType = saveType;
	}
	public FormField(String blockId,
			String groupId, String subtypeId, String name, String title,
			String description, String[] comboboxValues) {
		
		super(FormElementType.FIELD, name);
		
		this.blockId = blockId;
		this.groupId = groupId;
		this.subtypeId = subtypeId;
		this.title = title;
		this.description = description;
		this.validationType = ValidationType.NOTEMPTY;
		this.saveType = SaveType.SAVE;
		this.type=FormFieldType.COMBOBOX;
		this.comboboxValues=comboboxValues;
	}
	public FormField(String blockId,
			String groupId, String subtypeId, String name, String title,
			String description, String modalFormName) {
		
		super(FormElementType.FIELD, name);
		
		this.blockId = blockId;
		this.groupId = groupId;
		this.subtypeId = subtypeId;
		this.title = title;
		this.description = description;
		this.validationType = ValidationType.NOTEMPTY;
		this.saveType = SaveType.SAVE;
		this.type=FormFieldType.MODALFORM;
		this.modalFormName=modalFormName;
	}
	
	public String getBlockId() {
		return blockId;
	}
	public void setBlockId(String blockId) {
		this.blockId = blockId;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getSubtypeId() {
		return subtypeId;
	}
	public void setSubtypeId(String subtypeId) {
		this.subtypeId = subtypeId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getValue() {
		FormElement parentForm = getParent();
		while (!(parentForm instanceof Form) && parentForm != null) {
			parentForm = parentForm.getParent();
		}
		if (parentForm == null) {
			return value;
		} else {
			return parentForm.getFieldMap().get(getUuid()); // Formfield is added, return fieldMap value
		}
	}
	public void setValue(String value) {
		FormElement parentForm = getParent();
		while (!(parentForm instanceof Form) && parentForm != null) {
			parentForm = parentForm.getParent();
		}
		if (parentForm == null) {
			this.value = value;
		} else {
			parentForm.getFieldMap().put(getUuid(), value); // Formfield is added, set fieldMap value
		}
	}
	public ValidationType getValidationType() {
		return validationType;
	}
	public void setValidationType(ValidationType validationType) {
		this.validationType = validationType;
	}
	public SaveType getSaveType() {
		return saveType;
	}
	public void setSaveType(SaveType saveType) {
		this.saveType = saveType;
	}
	public FormFieldType getType() {
		return type;
	}
	public void setType(FormFieldType type) {
		this.type = type;
	}
	public String[] getComboboxValues() {
		return comboboxValues;
	}
	public void setComboboxValues(String[] comboboxValues) {
		this.comboboxValues = comboboxValues;
	}
	public String getModalFormName() {
		return modalFormName;
	}
	public void setModalFormName(String modalFormName) {
		this.modalFormName = modalFormName;
	}
	
	public String toString() {
		StringBuffer strBuf = new StringBuffer();
		strBuf.append(blockId);
		strBuf.append(", ");
		strBuf.append(groupId);
		strBuf.append(", ");
		strBuf.append(subtypeId);
		strBuf.append(", ");
		strBuf.append(getName());
		strBuf.append(", ");
		strBuf.append(title);
		strBuf.append(", ");
		strBuf.append(description);
		strBuf.append(", ");
		strBuf.append(getUuid());
		strBuf.append(", ");
		strBuf.append(getValue());
		strBuf.append(", ");
		strBuf.append(getValidationType());
		strBuf.append(", ");
		strBuf.append(getType().toString());
		strBuf.append(", ");
		strBuf.append(getComboboxValues());
		strBuf.append(", ");
		strBuf.append(getModalFormName());
		return strBuf.toString();
	}
}
