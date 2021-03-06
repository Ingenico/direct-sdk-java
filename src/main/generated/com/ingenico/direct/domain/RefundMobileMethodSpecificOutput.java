/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference
 */
package com.ingenico.direct.domain;

public class RefundMobileMethodSpecificOutput {

	private String network = null;

	private Long totalAmountPaid = null;

	private Long totalAmountRefunded = null;

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String value) {
		this.network = value;
	}

	public RefundMobileMethodSpecificOutput withNetwork(String value) {
		this.network = value;
		return this;
	}

	public Long getTotalAmountPaid() {
		return totalAmountPaid;
	}

	public void setTotalAmountPaid(Long value) {
		this.totalAmountPaid = value;
	}

	public RefundMobileMethodSpecificOutput withTotalAmountPaid(Long value) {
		this.totalAmountPaid = value;
		return this;
	}

	public Long getTotalAmountRefunded() {
		return totalAmountRefunded;
	}

	public void setTotalAmountRefunded(Long value) {
		this.totalAmountRefunded = value;
	}

	public RefundMobileMethodSpecificOutput withTotalAmountRefunded(Long value) {
		this.totalAmountRefunded = value;
		return this;
	}
}
