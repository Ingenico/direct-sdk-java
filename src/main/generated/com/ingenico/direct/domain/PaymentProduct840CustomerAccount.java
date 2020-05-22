/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference/index.html
 */
package com.ingenico.direct.domain;

/**
 * Object containing the details of the PayPal account
 */
public class PaymentProduct840CustomerAccount {

	private String accountId = null;

	private String companyName = null;

	private String countryCode = null;

	private String customerAccountStatus = null;

	private String customerAddressStatus = null;

	private String firstName = null;

	private String payerId = null;

	private String surname = null;

	/**
	 * Username with which the PayPal account holder has registered at PayPal
	 */
	public String getAccountId() {
		return accountId;
	}

	/**
	 * Username with which the PayPal account holder has registered at PayPal
	 */
	public void setAccountId(String value) {
		this.accountId = value;
	}

	/**
	 * Name of the company in case the PayPal account is owned by a business
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * Name of the company in case the PayPal account is owned by a business
	 */
	public void setCompanyName(String value) {
		this.companyName = value;
	}

	/**
	 * ISO 3166-1 alpha-2 country code
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * ISO 3166-1 alpha-2 country code
	 */
	public void setCountryCode(String value) {
		this.countryCode = value;
	}

	/**
	 * Status of the PayPal account
	 * * verified - PayPal has verified the funding means for this account
	 * * unverified - PayPal has not verified the funding means for this account
	 */
	public String getCustomerAccountStatus() {
		return customerAccountStatus;
	}

	/**
	 * Status of the PayPal account
	 * * verified - PayPal has verified the funding means for this account
	 * * unverified - PayPal has not verified the funding means for this account
	 */
	public void setCustomerAccountStatus(String value) {
		this.customerAccountStatus = value;
	}

	/**
	 * Status of the customer's shipping address as registered by PayPal
	 * * none - Status is unknown at PayPal
	 * * confirmed - The address has been confirmed
	 * * unconfirmed - The address has not been confirmed
	 */
	public String getCustomerAddressStatus() {
		return customerAddressStatus;
	}

	/**
	 * Status of the customer's shipping address as registered by PayPal
	 * * none - Status is unknown at PayPal
	 * * confirmed - The address has been confirmed
	 * * unconfirmed - The address has not been confirmed
	 */
	public void setCustomerAddressStatus(String value) {
		this.customerAddressStatus = value;
	}

	/**
	 * First name of the PayPal account holder
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * First name of the PayPal account holder
	 */
	public void setFirstName(String value) {
		this.firstName = value;
	}

	/**
	 * The unique identifier of a PayPal account and will never change in the life cycle of a PayPal account
	 */
	public String getPayerId() {
		return payerId;
	}

	/**
	 * The unique identifier of a PayPal account and will never change in the life cycle of a PayPal account
	 */
	public void setPayerId(String value) {
		this.payerId = value;
	}

	/**
	 * Surname of the PayPal account holder
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * Surname of the PayPal account holder
	 */
	public void setSurname(String value) {
		this.surname = value;
	}
}
