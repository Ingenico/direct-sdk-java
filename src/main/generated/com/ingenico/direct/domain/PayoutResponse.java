/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference
 */
package com.ingenico.direct.domain;

public class PayoutResponse {

	private String id = null;

	private PayoutOutput payoutOutput = null;

	private String status = null;

	private PayoutStatusOutput statusOutput = null;

	public String getId() {
		return id;
	}

	public void setId(String value) {
		this.id = value;
	}

	public PayoutResponse withId(String value) {
		this.id = value;
		return this;
	}

	public PayoutOutput getPayoutOutput() {
		return payoutOutput;
	}

	public void setPayoutOutput(PayoutOutput value) {
		this.payoutOutput = value;
	}

	public PayoutResponse withPayoutOutput(PayoutOutput value) {
		this.payoutOutput = value;
		return this;
	}

	/**
	 * Current high-level status of the payout in a human-readable form.
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Current high-level status of the payout in a human-readable form.
	 */
	public void setStatus(String value) {
		this.status = value;
	}

	/**
	 * Current high-level status of the payout in a human-readable form.
	 */
	public PayoutResponse withStatus(String value) {
		this.status = value;
		return this;
	}

	public PayoutStatusOutput getStatusOutput() {
		return statusOutput;
	}

	public void setStatusOutput(PayoutStatusOutput value) {
		this.statusOutput = value;
	}

	public PayoutResponse withStatusOutput(PayoutStatusOutput value) {
		this.statusOutput = value;
		return this;
	}
}
