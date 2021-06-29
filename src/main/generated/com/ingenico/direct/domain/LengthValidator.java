/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference
 */
package com.ingenico.direct.domain;

public class LengthValidator {

	private Integer maxLength = null;

	private Integer minLength = null;

	public Integer getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(Integer value) {
		this.maxLength = value;
	}

	public LengthValidator withMaxLength(Integer value) {
		this.maxLength = value;
		return this;
	}

	public Integer getMinLength() {
		return minLength;
	}

	public void setMinLength(Integer value) {
		this.minLength = value;
	}

	public LengthValidator withMinLength(Integer value) {
		this.minLength = value;
		return this;
	}
}
