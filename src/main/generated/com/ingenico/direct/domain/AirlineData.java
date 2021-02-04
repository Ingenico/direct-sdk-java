/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference
 */
package com.ingenico.direct.domain;

import java.util.List;

/**
 * Object that holds airline specific data
 */
public class AirlineData {

	private String agentNumericCode = null;

	private String code = null;

	private String flightDate = null;

	private List<AirlineFlightLeg> flightLegs = null;

	private String invoiceNumber = null;

	private Boolean isETicket = null;

	private Boolean isRestrictedTicket = null;

	private Boolean isThirdParty = null;

	private String issueDate = null;

	private String merchantCustomerId = null;

	private String name = null;

	private String passengerName = null;

	private List<AirlinePassenger> passengers = null;

	private String placeOfIssue = null;

	private String pnr = null;

	private String pointOfSale = null;

	private String posCityCode = null;

	private String ticketDeliveryMethod = null;

	private String ticketNumber = null;

	private Integer totalFare = null;

	private Integer totalFee = null;

	private Integer totalTaxes = null;

	private String travelAgencyName = null;

	/**
	 * Numeric code identifying the agent
	 */
	public String getAgentNumericCode() {
		return agentNumericCode;
	}

	/**
	 * Numeric code identifying the agent
	 */
	public void setAgentNumericCode(String value) {
		this.agentNumericCode = value;
	}

	/**
	 * Airline numeric code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Airline numeric code
	 */
	public void setCode(String value) {
		this.code = value;
	}

	/**
	 * Date of the Flight
	 * Format: YYYYMMDD
	 */
	public String getFlightDate() {
		return flightDate;
	}

	/**
	 * Date of the Flight
	 * Format: YYYYMMDD
	 */
	public void setFlightDate(String value) {
		this.flightDate = value;
	}

	/**
	 * Object that holds the data on the individual legs of the flight ticket
	 */
	public List<AirlineFlightLeg> getFlightLegs() {
		return flightLegs;
	}

	/**
	 * Object that holds the data on the individual legs of the flight ticket
	 */
	public void setFlightLegs(List<AirlineFlightLeg> value) {
		this.flightLegs = value;
	}

	/**
	 * Airline tracing number
	 */
	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	/**
	 * Airline tracing number
	 */
	public void setInvoiceNumber(String value) {
		this.invoiceNumber = value;
	}

	/**
	 * * true = The ticket is an E-Ticket
	 * * false = the ticket is not an E-Ticket'
	 */
	public Boolean getIsETicket() {
		return isETicket;
	}

	/**
	 * * true = The ticket is an E-Ticket
	 * * false = the ticket is not an E-Ticket'
	 */
	public void setIsETicket(Boolean value) {
		this.isETicket = value;
	}

	/**
	 * * true - Restricted, the ticket is non-refundable
	 * * false - No restrictions, the ticket is (partially) refundable
	 */
	public Boolean getIsRestrictedTicket() {
		return isRestrictedTicket;
	}

	/**
	 * * true - Restricted, the ticket is non-refundable
	 * * false - No restrictions, the ticket is (partially) refundable
	 */
	public void setIsRestrictedTicket(Boolean value) {
		this.isRestrictedTicket = value;
	}

	/**
	 * * true - The payer is the ticket holder
	 * * false - The payer is not the ticket holder
	 */
	public Boolean getIsThirdParty() {
		return isThirdParty;
	}

	/**
	 * * true - The payer is the ticket holder
	 * * false - The payer is not the ticket holder
	 */
	public void setIsThirdParty(Boolean value) {
		this.isThirdParty = value;
	}

	/**
	 * This is the date of issue recorded in the airline system In a case of multiple issuances of the same ticket to a cardholder, you should use the last ticket date.
	 * Format: YYYYMMDD
	 */
	public String getIssueDate() {
		return issueDate;
	}

	/**
	 * This is the date of issue recorded in the airline system In a case of multiple issuances of the same ticket to a cardholder, you should use the last ticket date.
	 * Format: YYYYMMDD
	 */
	public void setIssueDate(String value) {
		this.issueDate = value;
	}

	/**
	 * Your ID of the customer in the context of the airline data
	 */
	public String getMerchantCustomerId() {
		return merchantCustomerId;
	}

	/**
	 * Your ID of the customer in the context of the airline data
	 */
	public void setMerchantCustomerId(String value) {
		this.merchantCustomerId = value;
	}

	/**
	 * Name of the airline
	 */
	public String getName() {
		return name;
	}

	/**
	 * Name of the airline
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * Name of passenger
	 */
	public String getPassengerName() {
		return passengerName;
	}

	/**
	 * Name of passenger
	 */
	public void setPassengerName(String value) {
		this.passengerName = value;
	}

	/**
	 * Object that holds the data on the individual passengers (this object is used for fraud screening on the Ogone Payment Platform)
	 */
	public List<AirlinePassenger> getPassengers() {
		return passengers;
	}

	/**
	 * Object that holds the data on the individual passengers (this object is used for fraud screening on the Ogone Payment Platform)
	 */
	public void setPassengers(List<AirlinePassenger> value) {
		this.passengers = value;
	}

	/**
	 * Place of issue
	 * For sales in the US the last two characters (pos 14-15) must be the US state code.
	 */
	public String getPlaceOfIssue() {
		return placeOfIssue;
	}

	/**
	 * Place of issue
	 * For sales in the US the last two characters (pos 14-15) must be the US state code.
	 */
	public void setPlaceOfIssue(String value) {
		this.placeOfIssue = value;
	}

	/**
	 * Passenger name record
	 */
	public String getPnr() {
		return pnr;
	}

	/**
	 * Passenger name record
	 */
	public void setPnr(String value) {
		this.pnr = value;
	}

	/**
	 * IATA point of sale name
	 */
	public String getPointOfSale() {
		return pointOfSale;
	}

	/**
	 * IATA point of sale name
	 */
	public void setPointOfSale(String value) {
		this.pointOfSale = value;
	}

	/**
	 * city code of the point of sale
	 */
	public String getPosCityCode() {
		return posCityCode;
	}

	/**
	 * city code of the point of sale
	 */
	public void setPosCityCode(String value) {
		this.posCityCode = value;
	}

	public String getTicketDeliveryMethod() {
		return ticketDeliveryMethod;
	}

	public void setTicketDeliveryMethod(String value) {
		this.ticketDeliveryMethod = value;
	}

	/**
	 * The ticket or document number contains:
	 *  * Airline code: 3-digit airline code number
	 *  * Form code: A maximum of 3 digits indicating the type of document, the source of issue and the number of coupons it contains
	 *  * Serial number: A maximum of 8 digits allocated on a sequential basis, provided that the total number of digits allocated to the form code and serial number shall not exceed ten
	 *  * TICKETNUMBER can be replaced with PNR if the ticket number is unavailable
	 */
	public String getTicketNumber() {
		return ticketNumber;
	}

	/**
	 * The ticket or document number contains:
	 *  * Airline code: 3-digit airline code number
	 *  * Form code: A maximum of 3 digits indicating the type of document, the source of issue and the number of coupons it contains
	 *  * Serial number: A maximum of 8 digits allocated on a sequential basis, provided that the total number of digits allocated to the form code and serial number shall not exceed ten
	 *  * TICKETNUMBER can be replaced with PNR if the ticket number is unavailable
	 */
	public void setTicketNumber(String value) {
		this.ticketNumber = value;
	}

	/**
	 * Total fare for all legs on the ticket, excluding taxes and fees. If multiple tickets are purchased, this is the total fare for all tickets
	 */
	public Integer getTotalFare() {
		return totalFare;
	}

	/**
	 * Total fare for all legs on the ticket, excluding taxes and fees. If multiple tickets are purchased, this is the total fare for all tickets
	 */
	public void setTotalFare(Integer value) {
		this.totalFare = value;
	}

	/**
	 * Total fee for all legs on the ticket. If multiple tickets are purchased, this is the total fee for all tickets
	 */
	public Integer getTotalFee() {
		return totalFee;
	}

	/**
	 * Total fee for all legs on the ticket. If multiple tickets are purchased, this is the total fee for all tickets
	 */
	public void setTotalFee(Integer value) {
		this.totalFee = value;
	}

	/**
	 * Total taxes for all legs on the ticket. If multiple tickets are purchased, this is the total taxes for all tickets
	 */
	public Integer getTotalTaxes() {
		return totalTaxes;
	}

	/**
	 * Total taxes for all legs on the ticket. If multiple tickets are purchased, this is the total taxes for all tickets
	 */
	public void setTotalTaxes(Integer value) {
		this.totalTaxes = value;
	}

	/**
	 * Name of the travel agency issuing the ticket. For direct airline integration, leave this property blank
	 */
	public String getTravelAgencyName() {
		return travelAgencyName;
	}

	/**
	 * Name of the travel agency issuing the ticket. For direct airline integration, leave this property blank
	 */
	public void setTravelAgencyName(String value) {
		this.travelAgencyName = value;
	}
}
