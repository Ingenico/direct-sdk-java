/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference/index.html
 */
package com.ingenico.direct.domain;

public class DirectoryEntry {

	private String issuerId = null;

	private String issuerList = null;

	private String issuerName = null;

	/**
	 * Unique ID of the issuing bank of the customer
	 */
	public String getIssuerId() {
		return issuerId;
	}

	/**
	 * Unique ID of the issuing bank of the customer
	 */
	public void setIssuerId(String value) {
		this.issuerId = value;
	}

	/**
	 * To be used to sort the issuers.
	 *   short - These issuers should be presented at the top of the list
	 *   long - These issuers should be presented after the issuers marked as short
	 *   Note this is only filled if supported by the payment product. Currently only iDeal (809) support this. Sorting within the groups should be done alphabetically
	 */
	public String getIssuerList() {
		return issuerList;
	}

	/**
	 * To be used to sort the issuers.
	 *   short - These issuers should be presented at the top of the list
	 *   long - These issuers should be presented after the issuers marked as short
	 *   Note this is only filled if supported by the payment product. Currently only iDeal (809) support this. Sorting within the groups should be done alphabetically
	 */
	public void setIssuerList(String value) {
		this.issuerList = value;
	}

	/**
	 * Name of the issuing bank as it should be presented to the customer
	 */
	public String getIssuerName() {
		return issuerName;
	}

	/**
	 * Name of the issuing bank as it should be presented to the customer
	 */
	public void setIssuerName(String value) {
		this.issuerName = value;
	}
}
