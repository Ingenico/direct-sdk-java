/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference
 */
package com.ingenico.direct.domain;

public class RangeValidator {

	private Integer maxValue = null;

	private Integer minValue = null;

	public Integer getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(Integer value) {
		this.maxValue = value;
	}

	public RangeValidator withMaxValue(Integer value) {
		this.maxValue = value;
		return this;
	}

	public Integer getMinValue() {
		return minValue;
	}

	public void setMinValue(Integer value) {
		this.minValue = value;
	}

	public RangeValidator withMinValue(Integer value) {
		this.minValue = value;
		return this;
	}
}
