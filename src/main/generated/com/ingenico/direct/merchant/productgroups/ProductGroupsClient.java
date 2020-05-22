/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference/index.html
 */
package com.ingenico.direct.merchant.productgroups;

import java.util.Map;
import java.util.TreeMap;

import com.ingenico.direct.ApiException;
import com.ingenico.direct.ApiResource;
import com.ingenico.direct.AuthorizationException;
import com.ingenico.direct.CallContext;
import com.ingenico.direct.DirectException;
import com.ingenico.direct.IdempotenceException;
import com.ingenico.direct.ReferenceException;
import com.ingenico.direct.ResponseException;
import com.ingenico.direct.ValidationException;
import com.ingenico.direct.domain.ErrorResponse;
import com.ingenico.direct.domain.GetPaymentProductGroupsResponse;
import com.ingenico.direct.domain.PaymentProductGroup;

/**
 * ProductGroups client. Thread-safe.
 */
public class ProductGroupsClient extends ApiResource implements ProductGroupsClientInterface {

	public ProductGroupsClient(ApiResource parent, Map<String, String> pathContext) {
		super(parent, pathContext);
	}

	/**
	 * Resource /v2/{merchantId}/productgroups
	 * - <a href="https://support.direct.ingenico.com/documentation/api/reference/index.html#operation/GetProductGroups">Get product groups</a>
	 *
	 * @throws ValidationException if the request was not correct and couldn't be processed (HTTP status code 400)
	 * @throws AuthorizationException if the request was not allowed (HTTP status code 403)
	 * @throws ReferenceException if an object was attempted to be referenced that doesn't exist or has been removed,
	 *            or there was a conflict (HTTP status code 404, 409 or 410)
	 * @throws DirectException if something went wrong at the Ingenico ePayments platform,
	 *            the Ingenico ePayments platform was unable to process a message from a downstream partner/acquirer,
	 *            or the service that you're trying to reach is temporary unavailable (HTTP status code 500, 502 or 503)
	 * @throws ApiException if the Ingenico ePayments platform returned any other error
	 */
	@Override
	public GetPaymentProductGroupsResponse getProductGroups(GetProductGroupsParams query) {
		return getProductGroups(query, null);
	}

	/**
	 * Resource /v2/{merchantId}/productgroups
	 * - <a href="https://support.direct.ingenico.com/documentation/api/reference/index.html#operation/GetProductGroups">Get product groups</a>
	 *
	 * @throws ValidationException if the request was not correct and couldn't be processed (HTTP status code 400)
	 * @throws AuthorizationException if the request was not allowed (HTTP status code 403)
	 * @throws IdempotenceException if an idempotent request caused a conflict (HTTP status code 409)
	 * @throws ReferenceException if an object was attempted to be referenced that doesn't exist or has been removed,
	 *            or there was a conflict (HTTP status code 404, 409 or 410)
	 * @throws DirectException if something went wrong at the Ingenico ePayments platform,
	 *            the Ingenico ePayments platform was unable to process a message from a downstream partner/acquirer,
	 *            or the service that you're trying to reach is temporary unavailable (HTTP status code 500, 502 or 503)
	 * @throws ApiException if the Ingenico ePayments platform returned any other error
	 */
	@Override
	public GetPaymentProductGroupsResponse getProductGroups(GetProductGroupsParams query, CallContext context) {
		String uri = instantiateUri("/v2/{merchantId}/productgroups", null);
		try {
			return communicator.get(
					uri,
					getClientHeaders(),
					query,
					GetPaymentProductGroupsResponse.class,
					context);
		} catch (ResponseException e) {
			final Class<?> errorType = ErrorResponse.class;
			final Object errorObject = communicator.getMarshaller().unmarshal(e.getBody(), errorType);
			throw createException(e.getStatusCode(), e.getBody(), errorObject, context);
		}
	}

	/**
	 * Resource /v2/{merchantId}/productgroups/{paymentProductGroupId}
	 * - <a href="https://support.direct.ingenico.com/documentation/api/reference/index.html#operation/GetProductGroup">Get product group</a>
	 *
	 * @throws ValidationException if the request was not correct and couldn't be processed (HTTP status code 400)
	 * @throws AuthorizationException if the request was not allowed (HTTP status code 403)
	 * @throws ReferenceException if an object was attempted to be referenced that doesn't exist or has been removed,
	 *            or there was a conflict (HTTP status code 404, 409 or 410)
	 * @throws DirectException if something went wrong at the Ingenico ePayments platform,
	 *            the Ingenico ePayments platform was unable to process a message from a downstream partner/acquirer,
	 *            or the service that you're trying to reach is temporary unavailable (HTTP status code 500, 502 or 503)
	 * @throws ApiException if the Ingenico ePayments platform returned any other error
	 */
	@Override
	public PaymentProductGroup getProductGroup(String paymentProductGroupId, GetProductGroupParams query) {
		return getProductGroup(paymentProductGroupId, query, null);
	}

	/**
	 * Resource /v2/{merchantId}/productgroups/{paymentProductGroupId}
	 * - <a href="https://support.direct.ingenico.com/documentation/api/reference/index.html#operation/GetProductGroup">Get product group</a>
	 *
	 * @throws ValidationException if the request was not correct and couldn't be processed (HTTP status code 400)
	 * @throws AuthorizationException if the request was not allowed (HTTP status code 403)
	 * @throws IdempotenceException if an idempotent request caused a conflict (HTTP status code 409)
	 * @throws ReferenceException if an object was attempted to be referenced that doesn't exist or has been removed,
	 *            or there was a conflict (HTTP status code 404, 409 or 410)
	 * @throws DirectException if something went wrong at the Ingenico ePayments platform,
	 *            the Ingenico ePayments platform was unable to process a message from a downstream partner/acquirer,
	 *            or the service that you're trying to reach is temporary unavailable (HTTP status code 500, 502 or 503)
	 * @throws ApiException if the Ingenico ePayments platform returned any other error
	 */
	@Override
	public PaymentProductGroup getProductGroup(String paymentProductGroupId, GetProductGroupParams query, CallContext context) {
		Map<String, String> pathContext = new TreeMap<String, String>();
		pathContext.put("paymentProductGroupId", paymentProductGroupId);
		String uri = instantiateUri("/v2/{merchantId}/productgroups/{paymentProductGroupId}", pathContext);
		try {
			return communicator.get(
					uri,
					getClientHeaders(),
					query,
					PaymentProductGroup.class,
					context);
		} catch (ResponseException e) {
			final Class<?> errorType = ErrorResponse.class;
			final Object errorObject = communicator.getMarshaller().unmarshal(e.getBody(), errorType);
			throw createException(e.getStatusCode(), e.getBody(), errorObject, context);
		}
	}
}
