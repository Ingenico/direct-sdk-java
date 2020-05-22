package com.ingenico.direct;

/**
 * Indicates an exception regarding the communication with the Ingenico ePayments platform such as a connection exception.
 */
@SuppressWarnings("serial")
public class CommunicationException extends RuntimeException {

	public CommunicationException(Exception e) {
		super(e);
	}
}
