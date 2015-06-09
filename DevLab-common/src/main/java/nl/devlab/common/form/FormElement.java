package nl.devlab.common.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author Marco Kortooms - Atos
 *
 */
public class FormElement {

	private List<FormElement> formElementList = null;
	private Map<String, String> fieldMap = null;
	private FormElementType formElementType;
	private String name = "";
	private String uuid = "";
	private FormElement parent = null;

	public FormElement(FormElementType formElementType, String name) {
		super();
		formElementList = new ArrayList<FormElement>();
		fieldMap = new HashMap<String, String>();
		this.name = name;
		this.uuid = "element-" + UUID.randomUUID().toString();
	}
	
	
	
	
	
	public String getUuid() {
		return uuid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public FormElementType getFormElementType() {
		return formElementType;
	}


	
	
	
	public List<FormElement> getFormElementList() {
		return formElementList;
	}
	public void setFormElementList(List<FormElement> formElementList) {
		this.formElementList = formElementList;
	}
	public Map<String, String> getFieldMap() {
		return fieldMap;
	}
	public FormElement getParent() {
		return parent;
	}
	

	
	




	public void addFormElement(FormElement formElement) {
		if (formElement instanceof FormField) {
			this.fieldMap.put(formElement.getUuid(), ((FormField)formElement).getValue());
		}
		formElement.parent = this;
		this.formElementList.add(formElement);
	}
	public void addFormElement(int index, FormElement formElement) {
		if (formElement instanceof FormField) {
			this.fieldMap.put(formElement.getUuid(), ((FormField)formElement).getValue());
		}
		formElement.parent = this;
		this.formElementList.add(index, formElement);
	}
	public boolean removeFormElementbyName(String name) {
		boolean result = false;
		for (FormElement formElement: formElementList) {
			if (formElement.getName().equals(name)) { 
				result = formElementList.remove(formElement);
				if (formElement instanceof FormField) {
					this.fieldMap.remove(formElement.getUuid());
				}
				return result;
			}
		}
		return result;		
	}
	public boolean removeFormElementbyUuid(String uuid) {
		boolean result = false;
		for (FormElement formElement: formElementList) {
			if (formElement.getUuid().equals(uuid)) { 
				result = formElementList.remove(formElement);
				if (formElement instanceof FormField) {
					this.fieldMap.remove(formElement.getUuid());
				}
				return result;
			}
			if (formElement instanceof Tab) {
				result = ((Tab)formElement).removeFormElementbyUuid(uuid);
				if (result) {
					break;
				}
			}
		}
		return result;		
	}
	public FormElement getFormElementByUUID(String uuid) {
		FormElement result = null;		
		for (FormElement formElement: formElementList) {
			if (formElement.getUuid().equals(uuid)) { 
				result = formElement;
				break;
			}
			if (formElement instanceof Tab) {
				result = ((Tab)formElement).getFormElementByUUID(uuid);
				if (result != null) {
					break;
				}
			}
		}
		return result;
	}
	public void removeFormElements() {
		this.formElementList.clear();
		this.fieldMap.clear();
	}
	
	
	
	
	
	public List<FormField> getFormFieldList() {		
		List<FormField> result = new ArrayList<FormField>();
		for (FormElement formElement: formElementList) {
			if (formElement instanceof FormField) { 
				result.add((FormField)formElement);
			}
		}
		return result;
	}
	public List<FormField> getFormFieldList(String blockId) {		
		List<FormField> result = new ArrayList<FormField>();
		for (FormElement formElement: formElementList) {
			if (formElement instanceof FormField && 
					((FormField) formElement).getBlockId().equals(blockId)) { 
				result.add((FormField)formElement);
			}
		}
		return result;
	}
	public List<Tab> getFormTabList() {		
		List<Tab> result = new ArrayList<Tab>();
		for (FormElement formElement: formElementList) {
			if (formElement instanceof Tab) { 
				result.add((Tab)formElement);
			}
		}
		return result;
	}
	public FormField getFormFieldByName(String name) {
		FormField result = null;
		for (FormElement formElement: formElementList) {
			if (formElement instanceof FormField	&& formElement.getName().equals(name)) {
				result = (FormField)formElement;
				break;
			}
		}
		return result;
	}
}
