package nl.devlab.devLapp.form;

import nl.devlab.form.DestinationForm;

import org.springframework.validation.BindingResult;

public class NameForm extends DestinationForm {

	private Long nameId;
	private String name;
	
	
	public Long getNameId() {
		return nameId;
	}
	public void setNameId(Long nameId) {
		this.nameId = nameId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	public BindingResult validate(BindingResult result) {

		if (name == null) {
			result.rejectValue("name", "error.anEntryIsRequired");
		}
		
		return result;
	}
}
