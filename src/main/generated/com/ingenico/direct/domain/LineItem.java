/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference/index.html
 */
package com.ingenico.direct.domain;

public class LineItem {

	private AmountOfMoney amountOfMoney = null;

	private LineItemInvoiceData invoiceData = null;

	private OrderLineDetails orderLineDetails = null;

	/**
	 * Object containing amount and ISO currency code attributes
	 */
	public AmountOfMoney getAmountOfMoney() {
		return amountOfMoney;
	}

	/**
	 * Object containing amount and ISO currency code attributes
	 */
	public void setAmountOfMoney(AmountOfMoney value) {
		this.amountOfMoney = value;
	}

	/**
	 * Object containing the line items of the invoice or shopping cart
	 */
	public LineItemInvoiceData getInvoiceData() {
		return invoiceData;
	}

	/**
	 * Object containing the line items of the invoice or shopping cart
	 */
	public void setInvoiceData(LineItemInvoiceData value) {
		this.invoiceData = value;
	}

	/**
	 * Object containing additional information that when supplied can have a beneficial effect on the discountrates
	 */
	public OrderLineDetails getOrderLineDetails() {
		return orderLineDetails;
	}

	/**
	 * Object containing additional information that when supplied can have a beneficial effect on the discountrates
	 */
	public void setOrderLineDetails(OrderLineDetails value) {
		this.orderLineDetails = value;
	}
}
