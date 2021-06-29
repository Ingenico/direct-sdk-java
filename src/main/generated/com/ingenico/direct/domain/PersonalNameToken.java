/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference
 */
package com.ingenico.direct.domain;

public class PersonalNameToken {

	private String firstName = null;

	private String surname = null;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String value) {
		this.firstName = value;
	}

	public PersonalNameToken withFirstName(String value) {
		this.firstName = value;
		return this;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String value) {
		this.surname = value;
	}

	public PersonalNameToken withSurname(String value) {
		this.surname = value;
		return this;
	}
}
