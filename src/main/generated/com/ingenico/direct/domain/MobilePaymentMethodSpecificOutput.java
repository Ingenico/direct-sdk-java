/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference
 */
package com.ingenico.direct.domain;

/**
 * Object containing the mobile payment method details
 */
public class MobilePaymentMethodSpecificOutput {

	private String authorisationCode = null;

	private CardFraudResults fraudResults = null;

	private String network = null;

	private MobilePaymentData paymentData = null;

	private Integer paymentProductId = null;

	private ThreeDSecureResults threeDSecureResults = null;

	/**
	 * Card Authorization code as returned by the acquirer
	 */
	public String getAuthorisationCode() {
		return authorisationCode;
	}

	/**
	 * Card Authorization code as returned by the acquirer
	 */
	public void setAuthorisationCode(String value) {
		this.authorisationCode = value;
	}

	/**
	 * Card Authorization code as returned by the acquirer
	 */
	public MobilePaymentMethodSpecificOutput withAuthorisationCode(String value) {
		this.authorisationCode = value;
		return this;
	}

	/**
	 * Fraud results contained in the CardFraudResults object
	 */
	public CardFraudResults getFraudResults() {
		return fraudResults;
	}

	/**
	 * Fraud results contained in the CardFraudResults object
	 */
	public void setFraudResults(CardFraudResults value) {
		this.fraudResults = value;
	}

	/**
	 * Fraud results contained in the CardFraudResults object
	 */
	public MobilePaymentMethodSpecificOutput withFraudResults(CardFraudResults value) {
		this.fraudResults = value;
		return this;
	}

	/**
	 * Deprecated: This field is not used by any payment product
	 */
	public String getNetwork() {
		return network;
	}

	/**
	 * Deprecated: This field is not used by any payment product
	 */
	public void setNetwork(String value) {
		this.network = value;
	}

	/**
	 * Deprecated: This field is not used by any payment product
	 */
	public MobilePaymentMethodSpecificOutput withNetwork(String value) {
		this.network = value;
		return this;
	}

	/**
	 * Object containing payment details
	 */
	public MobilePaymentData getPaymentData() {
		return paymentData;
	}

	/**
	 * Object containing payment details
	 */
	public void setPaymentData(MobilePaymentData value) {
		this.paymentData = value;
	}

	/**
	 * Object containing payment details
	 */
	public MobilePaymentMethodSpecificOutput withPaymentData(MobilePaymentData value) {
		this.paymentData = value;
		return this;
	}

	/**
	 * Payment product identifier - Please see [payment products](https://support.direct.ingenico.com/documentation/api/reference/index.html#tag/Products) for a full overview of possible values.
	 */
	public Integer getPaymentProductId() {
		return paymentProductId;
	}

	/**
	 * Payment product identifier - Please see [payment products](https://support.direct.ingenico.com/documentation/api/reference/index.html#tag/Products) for a full overview of possible values.
	 */
	public void setPaymentProductId(Integer value) {
		this.paymentProductId = value;
	}

	/**
	 * Payment product identifier - Please see [payment products](https://support.direct.ingenico.com/documentation/api/reference/index.html#tag/Products) for a full overview of possible values.
	 */
	public MobilePaymentMethodSpecificOutput withPaymentProductId(Integer value) {
		this.paymentProductId = value;
		return this;
	}

	/**
	 * 3D Secure results object
	 */
	public ThreeDSecureResults getThreeDSecureResults() {
		return threeDSecureResults;
	}

	/**
	 * 3D Secure results object
	 */
	public void setThreeDSecureResults(ThreeDSecureResults value) {
		this.threeDSecureResults = value;
	}

	/**
	 * 3D Secure results object
	 */
	public MobilePaymentMethodSpecificOutput withThreeDSecureResults(ThreeDSecureResults value) {
		this.threeDSecureResults = value;
		return this;
	}
}
