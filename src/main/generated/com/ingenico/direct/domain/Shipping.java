/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference/index.html
 */
package com.ingenico.direct.domain;

/**
 * Object containing information regarding shipping / delivery
 */
public class Shipping {

	private AddressPersonal address = null;

	private String addressIndicator = null;

	private String emailAddress = null;

	private String firstUsageDate = null;

	private Boolean isFirstUsage = null;

	private String type = null;

	/**
	 * Object containing address information
	 */
	public AddressPersonal getAddress() {
		return address;
	}

	/**
	 * Object containing address information
	 */
	public void setAddress(AddressPersonal value) {
		this.address = value;
	}

	/**
	 * Indicates shipping method chosen for the transaction. Possible values:
	 *  * same-as-billing = the shipping address is the same as the billing address
	 *  * another-verified-address-on-file-with-merchant = the address used for shipping is another verified address of the customer that is on file with you
	 *  * different-than-billing = shipping address is different from the billing address
	 *  * ship-to-store = goods are shipped to a store (shipping address = store address)
	 *  * digital-goods = electronic delivery of digital goods
	 *  * travel-and-event-tickets-not-shipped = travel and/or event tickets that are not shipped
	 *  * other = other means of delivery
	 */
	public String getAddressIndicator() {
		return addressIndicator;
	}

	/**
	 * Indicates shipping method chosen for the transaction. Possible values:
	 *  * same-as-billing = the shipping address is the same as the billing address
	 *  * another-verified-address-on-file-with-merchant = the address used for shipping is another verified address of the customer that is on file with you
	 *  * different-than-billing = shipping address is different from the billing address
	 *  * ship-to-store = goods are shipped to a store (shipping address = store address)
	 *  * digital-goods = electronic delivery of digital goods
	 *  * travel-and-event-tickets-not-shipped = travel and/or event tickets that are not shipped
	 *  * other = other means of delivery
	 */
	public void setAddressIndicator(String value) {
		this.addressIndicator = value;
	}

	/**
	 * Email address linked to the shipping
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * Email address linked to the shipping
	 */
	public void setEmailAddress(String value) {
		this.emailAddress = value;
	}

	/**
	 * Date (YYYYMMDD) when the shipping details for this transaction were first used.
	 */
	public String getFirstUsageDate() {
		return firstUsageDate;
	}

	/**
	 * Date (YYYYMMDD) when the shipping details for this transaction were first used.
	 */
	public void setFirstUsageDate(String value) {
		this.firstUsageDate = value;
	}

	/**
	 * Indicator if this shipping address is used for the first time to ship an order
	 * 
	 * true = the shipping details are used for the first time with this transaction
	 * 
	 * false = the shipping details have been used for other transactions in the past
	 */
	public Boolean getIsFirstUsage() {
		return isFirstUsage;
	}

	/**
	 * Indicator if this shipping address is used for the first time to ship an order
	 * 
	 * true = the shipping details are used for the first time with this transaction
	 * 
	 * false = the shipping details have been used for other transactions in the past
	 */
	public void setIsFirstUsage(Boolean value) {
		this.isFirstUsage = value;
	}

	/**
	 * Indicates the merchandise delivery timeframe. Possible values:
	 *  * electronic = For electronic delivery (services or digital goods
	 *  * same-day = For same day deliveries
	 *  * overnight = For overnight deliveries
	 *  * 2-day-or-more = For two day or more delivery time
	 */
	public String getType() {
		return type;
	}

	/**
	 * Indicates the merchandise delivery timeframe. Possible values:
	 *  * electronic = For electronic delivery (services or digital goods
	 *  * same-day = For same day deliveries
	 *  * overnight = For overnight deliveries
	 *  * 2-day-or-more = For two day or more delivery time
	 */
	public void setType(String value) {
		this.type = value;
	}
}