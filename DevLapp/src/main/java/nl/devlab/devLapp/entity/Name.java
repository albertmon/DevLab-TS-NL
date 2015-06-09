package nl.devlab.devLapp.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Marco Kortooms - Atos
 *
 */
@Entity
@Table(name="name")
public class Name implements Serializable {
	private static final long serialVersionUID = -7827289980509006493L;
	
	@Id
	@GeneratedValue
	@Column(name="nameId")
	private Long nameId;

	@Column(name="name")
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
	
}
