package com.ingenico.direct;

import java.util.List;

import com.ingenico.direct.domain.APIError;

/**
 * Represents an error response from the Ingenico ePayments platform when validation of requests failed.
 */
@SuppressWarnings("serial")
public class ValidationException extends ApiException {

	public ValidationException(int statusCode, String responseBody, String errorId, List<APIError> errors) {
		super("the Ingenico ePayments platform returned an incorrect request error response", statusCode, responseBody, errorId, errors);
	}

	public ValidationException(String message, int statusCode, String responseBody, String errorId, List<APIError> errors) {
		super(message, statusCode, responseBody, errorId, errors);
	}
}
