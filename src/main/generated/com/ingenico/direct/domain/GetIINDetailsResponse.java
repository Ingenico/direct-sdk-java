/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference
 */
package com.ingenico.direct.domain;

import java.util.List;

public class GetIINDetailsResponse {

	private List<IINDetail> coBrands = null;

	private String countryCode = null;

	private Boolean isAllowedInContext = null;

	private Integer paymentProductId = null;

	/**
	 * List of IIN details
	 */
	public List<IINDetail> getCoBrands() {
		return coBrands;
	}

	/**
	 * List of IIN details
	 */
	public void setCoBrands(List<IINDetail> value) {
		this.coBrands = value;
	}

	/**
	 * List of IIN details
	 */
	public GetIINDetailsResponse withCoBrands(List<IINDetail> value) {
		this.coBrands = value;
		return this;
	}

	/**
	 * The ISO 3166-1 alpha-2 country code of the country where the card was issued. If we don't know where the card was issued, then the countryCode will return the value '99'.
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * The ISO 3166-1 alpha-2 country code of the country where the card was issued. If we don't know where the card was issued, then the countryCode will return the value '99'.
	 */
	public void setCountryCode(String value) {
		this.countryCode = value;
	}

	/**
	 * The ISO 3166-1 alpha-2 country code of the country where the card was issued. If we don't know where the card was issued, then the countryCode will return the value '99'.
	 */
	public GetIINDetailsResponse withCountryCode(String value) {
		this.countryCode = value;
		return this;
	}

	/**
	 * Populated only if you submitted a payment context.
	 * * true - The payment product is allowed in the submitted context.
	 * * false - The payment product is not allowed in the submitted context. Note that in this case, none of the brands of the card will be allowed in the submitted context.
	 */
	public Boolean getIsAllowedInContext() {
		return isAllowedInContext;
	}

	/**
	 * Populated only if you submitted a payment context.
	 * * true - The payment product is allowed in the submitted context.
	 * * false - The payment product is not allowed in the submitted context. Note that in this case, none of the brands of the card will be allowed in the submitted context.
	 */
	public void setIsAllowedInContext(Boolean value) {
		this.isAllowedInContext = value;
	}

	/**
	 * Populated only if you submitted a payment context.
	 * * true - The payment product is allowed in the submitted context.
	 * * false - The payment product is not allowed in the submitted context. Note that in this case, none of the brands of the card will be allowed in the submitted context.
	 */
	public GetIINDetailsResponse withIsAllowedInContext(Boolean value) {
		this.isAllowedInContext = value;
		return this;
	}

	/**
	 * The payment product identifier associated with the card. If the card has multiple brands, then we select the most appropriate payment product based on your configuration and the payment context, if you submitted one.
	 */
	public Integer getPaymentProductId() {
		return paymentProductId;
	}

	/**
	 * The payment product identifier associated with the card. If the card has multiple brands, then we select the most appropriate payment product based on your configuration and the payment context, if you submitted one.
	 */
	public void setPaymentProductId(Integer value) {
		this.paymentProductId = value;
	}

	/**
	 * The payment product identifier associated with the card. If the card has multiple brands, then we select the most appropriate payment product based on your configuration and the payment context, if you submitted one.
	 */
	public GetIINDetailsResponse withPaymentProductId(Integer value) {
		this.paymentProductId = value;
		return this;
	}
}
