/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference
 */
package com.ingenico.direct.domain;

/**
 * This object has the numeric representation of the current refund status, timestamp of last status change and performable action on the current refund resource. In case of a rejected refund, detailed error information is listed.
 */
public class RefundResponse {

	private String id = null;

	private RefundOutput refundOutput = null;

	private String status = null;

	private OrderStatusOutput statusOutput = null;

	public String getId() {
		return id;
	}

	public void setId(String value) {
		this.id = value;
	}

	public RefundResponse withId(String value) {
		this.id = value;
		return this;
	}

	/**
	 * Object containing refund details
	 */
	public RefundOutput getRefundOutput() {
		return refundOutput;
	}

	/**
	 * Object containing refund details
	 */
	public void setRefundOutput(RefundOutput value) {
		this.refundOutput = value;
	}

	/**
	 * Object containing refund details
	 */
	public RefundResponse withRefundOutput(RefundOutput value) {
		this.refundOutput = value;
		return this;
	}

	/**
	 * Current high-level status of the payment in a human-readable form.
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Current high-level status of the payment in a human-readable form.
	 */
	public void setStatus(String value) {
		this.status = value;
	}

	/**
	 * Current high-level status of the payment in a human-readable form.
	 */
	public RefundResponse withStatus(String value) {
		this.status = value;
		return this;
	}

	public OrderStatusOutput getStatusOutput() {
		return statusOutput;
	}

	public void setStatusOutput(OrderStatusOutput value) {
		this.statusOutput = value;
	}

	public RefundResponse withStatusOutput(OrderStatusOutput value) {
		this.statusOutput = value;
		return this;
	}
}
