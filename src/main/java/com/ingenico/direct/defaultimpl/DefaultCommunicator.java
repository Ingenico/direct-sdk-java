package com.ingenico.direct.defaultimpl;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpStatus;
import org.apache.http.client.utils.URIBuilder;

import com.ingenico.direct.ApiException;
import com.ingenico.direct.Authenticator;
import com.ingenico.direct.BodyHandler;
import com.ingenico.direct.BodyHandlerException;
import com.ingenico.direct.CallContext;
import com.ingenico.direct.CommunicationException;
import com.ingenico.direct.Communicator;
import com.ingenico.direct.Connection;
import com.ingenico.direct.Marshaller;
import com.ingenico.direct.MetaDataProvider;
import com.ingenico.direct.MultipartFormDataObject;
import com.ingenico.direct.MultipartFormDataRequest;
import com.ingenico.direct.NotFoundException;
import com.ingenico.direct.ParamRequest;
import com.ingenico.direct.PooledConnection;
import com.ingenico.direct.RequestHeader;
import com.ingenico.direct.RequestParam;
import com.ingenico.direct.ResponseException;
import com.ingenico.direct.ResponseHandler;
import com.ingenico.direct.ResponseHeader;
import com.ingenico.direct.logging.CommunicatorLogger;

/**
 * Used to communicate with the Ingenico ePayments platform web services.
 * <p>
 * It contains all the logic to transform a request object to a HTTP request and
 * a HTTP response to a response object.
 * <p>
 * Thread-safe.
 */
public class DefaultCommunicator implements Communicator {

	private static final Charset CHARSET = Charset.forName("UTF-8");

	private final URI apiEndpoint;
	private final Connection connection;
	private final Authenticator authenticator;
	private final MetaDataProvider metaDataProvider;
	private final Marshaller marshaller;

	public DefaultCommunicator(URI apiEndpoint, Connection connection, Authenticator authenticator, MetaDataProvider metaDataProvider, Marshaller marshaller) {
		if (apiEndpoint == null) {
			throw new IllegalArgumentException("apiEndpoint is required");
		}
		if (apiEndpoint.getPath() != null && !apiEndpoint.getPath().isEmpty()) {
			throw new IllegalArgumentException("apiEndpoint should not contain a path");
		}
		if (apiEndpoint.getUserInfo() != null
				|| apiEndpoint.getQuery() != null
				|| apiEndpoint.getFragment() != null) {

			throw new IllegalArgumentException("apiEndpoint should not contain user info, query or fragment");
		}

		if (connection == null) {
			throw new IllegalArgumentException("connection is required");
		}
		if (authenticator == null) {
			throw new IllegalArgumentException("authenticator is required");
		}
		if (metaDataProvider == null) {
			throw new IllegalArgumentException("metaDataProvider is required");
		}
		if (marshaller == null) {
			throw new IllegalArgumentException("marshaller is required");
		}
		this.apiEndpoint = apiEndpoint;
		this.connection = connection;
		this.authenticator = authenticator;
		this.metaDataProvider = metaDataProvider;
		this.marshaller = marshaller;
	}

	/**
	 * Releases any system resources associated with this object.
	 */
	@Override
	public void close() throws IOException {
		connection.close();
	}

	/**
	 * Corresponds to the HTTP GET method.
	 *
	 * @param relativePath The path to call, relative to the base URI.
	 * @param requestHeaders An optional list of request headers.
	 * @param requestParameters An optional set of request parameters.
	 * @param responseType The type of response to return.
	 * @param context The optional call context to use.
	 * @throws CommunicationException when an exception occurred communicating with the Ingenico ePayments platform
	 * @throws ResponseException when an error response was received from the Ingenico ePayments platform
	 * @throws ApiException when an error response was received from the Ingenico ePayments platform which contained a list of errors
	 */
	@Override
	@SuppressWarnings("resource")
	public <O> O get(final String relativePath, List<RequestHeader> requestHeaders, ParamRequest requestParameters,
			final Class<O> responseType, final CallContext context) {

		List<RequestParam> requestParameterList = requestParameters == null ? null : requestParameters.toRequestParameters();
		URI uri = toAbsoluteURI(relativePath, requestParameterList);

		if (requestHeaders == null) {
			requestHeaders = new ArrayList<RequestHeader>();
		}

		addGenericHeaders("GET", uri, requestHeaders, context);

		return connection.get(uri, requestHeaders, new ResponseHandler<O>() {

			@Override
			public O handleResponse(int statusCode, InputStream bodyStream, List<ResponseHeader> headers) {
				return processResponse(statusCode, bodyStream, headers, responseType, relativePath, context);
			}
		});
	}

	/**
	 * Corresponds to the HTTP GET method.
	 *
	 * @param relativePath The path to call, relative to the base URI.
	 * @param requestHeaders An optional list of request headers.
	 * @param requestParameters An optional set of request parameters.
	 * @param bodyHandler The handler for the response body.
	 * @param context The optional call context to use.
	 * @throws CommunicationException when an exception occurred communicating with the Ingenico ePayments platform
	 * @throws ResponseException when an error response was received from the Ingenico ePayments platform
	 * @throws ApiException when an error response was received from the Ingenico ePayments platform which contained a list of errors
	 */
	@Override
	@SuppressWarnings("resource")
	public void get(final String relativePath, List<RequestHeader> requestHeaders, ParamRequest requestParameters,
			final BodyHandler bodyHandler, final CallContext context) {

		List<RequestParam> requestParameterList = requestParameters == null ? null : requestParameters.toRequestParameters();
		URI uri = toAbsoluteURI(relativePath, requestParameterList);

		if (requestHeaders == null) {
			requestHeaders = new ArrayList<RequestHeader>();
		}

		addGenericHeaders("GET", uri, requestHeaders, context);

		connection.get(uri, requestHeaders, new ResponseHandler<Void>() {

			@Override
			public Void handleResponse(int statusCode, InputStream bodyStream, List<ResponseHeader> headers) {
				processResponse(statusCode, bodyStream, headers, bodyHandler, relativePath, context);
				return null;
			}
		});
	}

	/**
	 * Corresponds to the HTTP DELETE method.
	 *
	 * @param relativePath The path to call, relative to the base URI.
	 * @param requestHeaders An optional list of request headers.
	 * @param requestParameters An optional set of request parameters.
	 * @param responseType The type of response to return.
	 * @param context The optional call context to use.
	 * @throws CommunicationException when an exception occurred communicating with the Ingenico ePayments platform
	 * @throws ResponseException when an error response was received from the Ingenico ePayments platform
	 * @throws ApiException when an error response was received from the Ingenico ePayments platform which contained a list of errors
	 */
	@Override
	@SuppressWarnings("resource")
	public <O> O delete(final String relativePath, List<RequestHeader> requestHeaders, ParamRequest requestParameters,
			final Class<O> responseType, final CallContext context) {

		List<RequestParam> requestParameterList = requestParameters == null ? null : requestParameters.toRequestParameters();
		URI uri = toAbsoluteURI(relativePath, requestParameterList);

		if (requestHeaders == null) {
			requestHeaders = new ArrayList<RequestHeader>();
		}

		addGenericHeaders("DELETE", uri, requestHeaders, context);

		return connection.delete(uri, requestHeaders, new ResponseHandler<O>() {

			@Override
			public O handleResponse(int statusCode, InputStream bodyStream, List<ResponseHeader> headers) {
				return processResponse(statusCode, bodyStream, headers, responseType, relativePath, context);
			}
		});
	}

	/**
	 * Corresponds to the HTTP DELETE method.
	 *
	 * @param relativePath The path to call, relative to the base URI.
	 * @param requestHeaders An optional list of request headers.
	 * @param requestParameters An optional set of request parameters.
	 * @param bodyHandler The handler for the response body.
	 * @param context The optional call context to use.
	 * @throws CommunicationException when an exception occurred communicating with the Ingenico ePayments platform
	 * @throws ResponseException when an error response was received from the Ingenico ePayments platform
	 * @throws ApiException when an error response was received from the Ingenico ePayments platform which contained a list of errors
	 */
	@Override
	@SuppressWarnings("resource")
	public void delete(final String relativePath, List<RequestHeader> requestHeaders, ParamRequest requestParameters,
			final BodyHandler bodyHandler, final CallContext context) {

		List<RequestParam> requestParameterList = requestParameters == null ? null : requestParameters.toRequestParameters();
		URI uri = toAbsoluteURI(relativePath, requestParameterList);

		if (requestHeaders == null) {
			requestHeaders = new ArrayList<RequestHeader>();
		}

		addGenericHeaders("DELETE", uri, requestHeaders, context);

		connection.delete(uri, requestHeaders, new ResponseHandler<Void>() {

			@Override
			public Void handleResponse(int statusCode, InputStream bodyStream, List<ResponseHeader> headers) {
				processResponse(statusCode, bodyStream, headers, bodyHandler, relativePath, context);
				return null;
			}
		});
	}

	/**
	 * Corresponds to the HTTP POST method.
	 *
	 * @param relativePath The path to call, relative to the base URI.
	 * @param requestHeaders An optional list of request headers.
	 * @param requestParameters An optional set of request parameters.
	 * @param requestBody The optional request body to send.
	 * @param responseType The type of response to return.
	 * @param context The optional call context to use.
	 * @throws CommunicationException when an exception occurred communicating with the Ingenico ePayments platform
	 * @throws ResponseException when an error response was received from the Ingenico ePayments platform
	 * @throws ApiException when an error response was received from the Ingenico ePayments platform which contained a list of errors
	 */
	@Override
	@SuppressWarnings("resource")
	public <O> O post(final String relativePath, List<RequestHeader> requestHeaders, ParamRequest requestParameters, Object requestBody,
			final Class<O> responseType, final CallContext context) {

		if (requestBody instanceof MultipartFormDataObject) {
			return post(relativePath, requestHeaders, requestParameters, (MultipartFormDataObject) requestBody, responseType, context);
		}
		if (requestBody instanceof MultipartFormDataRequest) {
			MultipartFormDataObject multipart = ((MultipartFormDataRequest) requestBody).toMultipartFormDataObject();
			return post(relativePath, requestHeaders, requestParameters, multipart, responseType, context);
		}

		List<RequestParam> requestParameterList = requestParameters == null ? null : requestParameters.toRequestParameters();
		URI uri = toAbsoluteURI(relativePath, requestParameterList);

		if (requestHeaders == null) {
			requestHeaders = new ArrayList<RequestHeader>();
		}

		String requestJson = null;
		if (requestBody != null) {
			requestHeaders.add(new RequestHeader("Content-Type", "application/json"));
			requestJson = marshaller.marshal(requestBody);
		}

		addGenericHeaders("POST", uri, requestHeaders, context);

		return connection.post(uri, requestHeaders, requestJson, new ResponseHandler<O>() {

			@Override
			public O handleResponse(int statusCode, InputStream bodyStream, List<ResponseHeader> headers) {
				return processResponse(statusCode, bodyStream, headers, responseType, relativePath, context);
			}
		});
	}

	@SuppressWarnings("resource")
	private <O> O post(final String relativePath, List<RequestHeader> requestHeaders, ParamRequest requestParameters, MultipartFormDataObject multipart,
			final Class<O> responseType, final CallContext context) {

		List<RequestParam> requestParameterList = requestParameters == null ? null : requestParameters.toRequestParameters();
		URI uri = toAbsoluteURI(relativePath, requestParameterList);

		if (requestHeaders == null) {
			requestHeaders = new ArrayList<RequestHeader>();
		}

		requestHeaders.add(new RequestHeader("Content-Type", multipart.getContentType()));

		addGenericHeaders("POST", uri, requestHeaders, context);

		return connection.post(uri, requestHeaders, multipart, new ResponseHandler<O>() {

			@Override
			public O handleResponse(int statusCode, InputStream bodyStream, List<ResponseHeader> headers) {
				return processResponse(statusCode, bodyStream, headers, responseType, relativePath, context);
			}
		});
	}

	/**
	 * Corresponds to the HTTP POST method.
	 *
	 * @param relativePath The path to call, relative to the base URI.
	 * @param requestHeaders An optional list of request headers.
	 * @param requestParameters An optional set of request parameters.
	 * @param requestBody The optional request body to send.
	 * @param bodyHandler The handler for the response body.
	 * @param context The optional call context to use.
	 * @throws CommunicationException when an exception occurred communicating with the Ingenico ePayments platform
	 * @throws ResponseException when an error response was received from the Ingenico ePayments platform
	 * @throws ApiException when an error response was received from the Ingenico ePayments platform which contained a list of errors
	 */
	@Override
	@SuppressWarnings("resource")
	public void post(final String relativePath, List<RequestHeader> requestHeaders, ParamRequest requestParameters, Object requestBody,
			final BodyHandler bodyHandler, final CallContext context) {

		if (requestBody instanceof MultipartFormDataObject) {
			post(relativePath, requestHeaders, requestParameters, (MultipartFormDataObject) requestBody, bodyHandler, context);
			return;
		}
		if (requestBody instanceof MultipartFormDataRequest) {
			MultipartFormDataObject multipart = ((MultipartFormDataRequest) requestBody).toMultipartFormDataObject();
			post(relativePath, requestHeaders, requestParameters, multipart, bodyHandler, context);
			return;
		}

		List<RequestParam> requestParameterList = requestParameters == null ? null : requestParameters.toRequestParameters();
		URI uri = toAbsoluteURI(relativePath, requestParameterList);

		if (requestHeaders == null) {
			requestHeaders = new ArrayList<RequestHeader>();
		}

		String requestJson = null;
		if (requestBody != null) {
			requestHeaders.add(new RequestHeader("Content-Type", "application/json"));
			requestJson = marshaller.marshal(requestBody);
		}

		addGenericHeaders("POST", uri, requestHeaders, context);

		connection.post(uri, requestHeaders, requestJson, new ResponseHandler<Void>() {

			@Override
			public Void handleResponse(int statusCode, InputStream bodyStream, List<ResponseHeader> headers) {
				processResponse(statusCode, bodyStream, headers, bodyHandler, relativePath, context);
				return null;
			}
		});
	}

	@SuppressWarnings("resource")
	private void post(final String relativePath, List<RequestHeader> requestHeaders, ParamRequest requestParameters, MultipartFormDataObject multipart,
			final BodyHandler bodyHandler, final CallContext context) {

		List<RequestParam> requestParameterList = requestParameters == null ? null : requestParameters.toRequestParameters();
		URI uri = toAbsoluteURI(relativePath, requestParameterList);

		if (requestHeaders == null) {
			requestHeaders = new ArrayList<RequestHeader>();
		}

		requestHeaders.add(new RequestHeader("Content-Type", multipart.getContentType()));

		addGenericHeaders("POST", uri, requestHeaders, context);

		connection.post(uri, requestHeaders, multipart, new ResponseHandler<Void>() {

			@Override
			public Void handleResponse(int statusCode, InputStream bodyStream, List<ResponseHeader> headers) {
				processResponse(statusCode, bodyStream, headers, bodyHandler, relativePath, context);
				return null;
			}
		});
	}

	/**
	 * Corresponds to the HTTP PUT method.
	 *
	 * @param relativePath The path to call, relative to the base URI.
	 * @param requestHeaders An optional list of request headers.
	 * @param requestParameters An optional set of request parameters.
	 * @param requestBody The optional request body to send.
	 * @param responseType The type of response to return.
	 * @param context The optional call context to use.
	 * @throws CommunicationException when an exception occurred communicating with the Ingenico ePayments platform
	 * @throws ResponseException when an error response was received from the Ingenico ePayments platform
	 * @throws ApiException when an error response was received from the Ingenico ePayments platform which contained a list of errors
	 */
	@Override
	@SuppressWarnings("resource")
	public <O> O put(final String relativePath, List<RequestHeader> requestHeaders, ParamRequest requestParameters, Object requestBody,
			final Class<O> responseType, final CallContext context) {

		if (requestBody instanceof MultipartFormDataObject) {
			return put(relativePath, requestHeaders, requestParameters, (MultipartFormDataObject) requestBody, responseType, context);
		}
		if (requestBody instanceof MultipartFormDataRequest) {
			MultipartFormDataObject multipart = ((MultipartFormDataRequest) requestBody).toMultipartFormDataObject();
			return put(relativePath, requestHeaders, requestParameters, multipart, responseType, context);
		}

		List<RequestParam> requestParameterList = requestParameters == null ? null : requestParameters.toRequestParameters();
		URI uri = toAbsoluteURI(relativePath, requestParameterList);

		if (requestHeaders == null) {
			requestHeaders = new ArrayList<RequestHeader>();
		}

		String requestJson = null;
		if (requestBody != null) {
			requestHeaders.add(new RequestHeader("Content-Type", "application/json"));
			requestJson = marshaller.marshal(requestBody);
		}

		addGenericHeaders("PUT", uri, requestHeaders, context);

		return connection.put(uri, requestHeaders, requestJson, new ResponseHandler<O>() {

			@Override
			public O handleResponse(int statusCode, InputStream bodyStream, List<ResponseHeader> headers) {
				return processResponse(statusCode, bodyStream, headers, responseType, relativePath, context);
			}
		});
	}

	@SuppressWarnings("resource")
	private <O> O put(final String relativePath, List<RequestHeader> requestHeaders, ParamRequest requestParameters, MultipartFormDataObject multipart,
			final Class<O> responseType, final CallContext context) {

		List<RequestParam> requestParameterList = requestParameters == null ? null : requestParameters.toRequestParameters();
		URI uri = toAbsoluteURI(relativePath, requestParameterList);

		if (requestHeaders == null) {
			requestHeaders = new ArrayList<RequestHeader>();
		}

		requestHeaders.add(new RequestHeader("Content-Type", multipart.getContentType()));

		addGenericHeaders("PUT", uri, requestHeaders, context);

		return connection.put(uri, requestHeaders, multipart, new ResponseHandler<O>() {

			@Override
			public O handleResponse(int statusCode, InputStream bodyStream, List<ResponseHeader> headers) {
				return processResponse(statusCode, bodyStream, headers, responseType, relativePath, context);
			}
		});
	}

	/**
	 * Corresponds to the HTTP PUT method.
	 *
	 * @param relativePath The path to call, relative to the base URI.
	 * @param requestHeaders An optional list of request headers.
	 * @param requestParameters An optional set of request parameters.
	 * @param requestBody The optional request body to send.
	 * @param bodyHandler The handler for the response body.
	 * @param context The optional call context to use.
	 * @throws CommunicationException when an exception occurred communicating with the Ingenico ePayments platform
	 * @throws ResponseException when an error response was received from the Ingenico ePayments platform
	 * @throws ApiException when an error response was received from the Ingenico ePayments platform which contained a list of errors
	 */
	@Override
	@SuppressWarnings("resource")
	public void put(final String relativePath, List<RequestHeader> requestHeaders, ParamRequest requestParameters, Object requestBody,
			final BodyHandler bodyHandler, final CallContext context) {

		if (requestBody instanceof MultipartFormDataObject) {
			put(relativePath, requestHeaders, requestParameters, (MultipartFormDataObject) requestBody, bodyHandler, context);
			return;
		}
		if (requestBody instanceof MultipartFormDataRequest) {
			MultipartFormDataObject multipart = ((MultipartFormDataRequest) requestBody).toMultipartFormDataObject();
			put(relativePath, requestHeaders, requestParameters, multipart, bodyHandler, context);
			return;
		}

		List<RequestParam> requestParameterList = requestParameters == null ? null : requestParameters.toRequestParameters();
		URI uri = toAbsoluteURI(relativePath, requestParameterList);

		if (requestHeaders == null) {
			requestHeaders = new ArrayList<RequestHeader>();
		}

		String requestJson = null;
		if (requestBody != null) {
			requestHeaders.add(new RequestHeader("Content-Type", "application/json"));
			requestJson = marshaller.marshal(requestBody);
		}

		addGenericHeaders("PUT", uri, requestHeaders, context);

		connection.put(uri, requestHeaders, requestJson, new ResponseHandler<Void>() {

			@Override
			public Void handleResponse(int statusCode, InputStream bodyStream, List<ResponseHeader> headers) {
				processResponse(statusCode, bodyStream, headers, bodyHandler, relativePath, context);
				return null;
			}
		});
	}

	@SuppressWarnings("resource")
	private void put(final String relativePath, List<RequestHeader> requestHeaders, ParamRequest requestParameters, MultipartFormDataObject multipart,
			final BodyHandler bodyHandler, final CallContext context) {

		List<RequestParam> requestParameterList = requestParameters == null ? null : requestParameters.toRequestParameters();
		URI uri = toAbsoluteURI(relativePath, requestParameterList);

		if (requestHeaders == null) {
			requestHeaders = new ArrayList<RequestHeader>();
		}

		requestHeaders.add(new RequestHeader("Content-Type", multipart.getContentType()));

		addGenericHeaders("PUT", uri, requestHeaders, context);

		connection.put(uri, requestHeaders, multipart, new ResponseHandler<Void>() {

			@Override
			public Void handleResponse(int statusCode, InputStream bodyStream, List<ResponseHeader> headers) {
				processResponse(statusCode, bodyStream, headers, bodyHandler, relativePath, context);
				return null;
			}
		});
	}

	public URI getApiEndpoint() {
		return apiEndpoint;
	}

	@Override
	public Connection getConnection() {
		return connection;
	}

	@Override
	public Authenticator getAuthenticator() {
		return authenticator;
	}

	@Override
	public MetaDataProvider getMetaDataProvider() {
		return metaDataProvider;
	}

	@Override
	public Marshaller getMarshaller() {
		return marshaller;
	}

	protected URI toAbsoluteURI(String relativePath, List<RequestParam> requestParameters) {

		if (apiEndpoint.getPath() != null && !apiEndpoint.getPath().isEmpty()) {
			throw new IllegalStateException("apiEndpoint should not contain a path");
		}
		if (apiEndpoint.getUserInfo() != null
				|| apiEndpoint.getQuery() != null
				|| apiEndpoint.getFragment() != null) {

			throw new IllegalStateException("apiEndpoint should not contain user info, query or fragment");
		}

		String absolutePath;
		if (relativePath.startsWith("/")) {
			absolutePath = relativePath;
		} else {
			absolutePath = "/" + relativePath;
		}

		URIBuilder uriBuilder = new URIBuilder()
				.setScheme(apiEndpoint.getScheme())
				.setHost(apiEndpoint.getHost())
				.setPort(apiEndpoint.getPort())
				.setPath(absolutePath);

		if (requestParameters != null) {
			for (RequestParam nvp: requestParameters) {
				uriBuilder.addParameter(nvp.getName(), nvp.getValue());
			}
		}

		try {
			return uriBuilder.build();
		} catch (URISyntaxException e) {
			throw new IllegalArgumentException("Unable to construct URI", e);
		}
	}

	/**
	 * Adds the necessary headers to the given list of headers. This includes the authorization header, which uses
	 * other headers, so when you need to override this method, make sure to call {@code super.addGenericHeaders}
	 * at the <i>end</i> of your overridden method.
	 */
	protected void addGenericHeaders(String httpMethod, URI uri, List<RequestHeader> requestHeaders, CallContext context) {

		// add server meta info headers
		requestHeaders.addAll(metaDataProvider.getServerMetaDataHeaders());

		// add date header
		requestHeaders.add(new RequestHeader("Date", getHeaderDateString()));

		// add context specific headers
		if (context != null && context.getIdempotenceKey() != null) {
			requestHeaders.add(new RequestHeader("X-GCS-Idempotence-Key", context.getIdempotenceKey()));
		}

		// add signature
		String authenticationSignature = authenticator.createSimpleAuthenticationSignature(httpMethod, uri, requestHeaders);
		requestHeaders.add(new RequestHeader("Authorization", authenticationSignature));
	}

	/**
	 * Returns the date in the preferred format for the HTTP date header (RFC1123).
	 */
	protected String getHeaderDateString() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
		dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
		return dateFormat.format(calendar.getTime());
	}

	protected <O> O processResponse(int statusCode, InputStream bodyStream, List<ResponseHeader> headers, Class<O> responseType,
			String requestPath, CallContext context) {

		if (context != null) {
			updateContext(headers, context);
		}
		throwExceptionIfNecessary(statusCode, bodyStream, headers, requestPath);

		return marshaller.unmarshal(bodyStream, responseType);
	}

	protected void processResponse(int statusCode, InputStream bodyStream, List<ResponseHeader> headers, BodyHandler bodyHandler,
			String requestPath, CallContext context) {

		if (context != null) {
			updateContext(headers, context);
		}
		throwExceptionIfNecessary(statusCode, bodyStream, headers, requestPath);

		try {
			bodyHandler.handleBody(bodyStream, headers);
		} catch (IOException e) {
			throw new BodyHandlerException(e);
		}
	}

	/**
	 * Updates the given call context based on the contents of the given response.
	 */
	protected void updateContext(List<ResponseHeader> headers, CallContext context) {

		String idempotenceRequestTimestampValue = ResponseHeader.getHeaderValue(headers, "X-GCS-Idempotence-Request-Timestamp");
		if (idempotenceRequestTimestampValue != null) {
			Long idempotenceRequestTimestamp = Long.valueOf(idempotenceRequestTimestampValue);
			context.setIdempotenceRequestTimestamp(idempotenceRequestTimestamp);
		} else {
			context.setIdempotenceRequestTimestamp(null);
		}
	}

	/**
	 * Checks the status code and headers for errors and throws an exception if necessary.
	 */
	protected void throwExceptionIfNecessary(int statusCode, InputStream bodyStream, List<ResponseHeader> headers, String requestPath) {

		// status codes in the 100 or 300 range are not expected
		if (statusCode < 200 || statusCode >= 300) {
			String body = toString(bodyStream);

			if (body != null && !body.isEmpty() && !isJson(headers)) {
				ResponseException cause = new ResponseException(statusCode, body, headers);
				if (statusCode == HttpStatus.SC_NOT_FOUND) {
					throw new NotFoundException("The requested resource was not found; invalid path: " + requestPath, cause);
				} else {
					throw new CommunicationException(cause);
				}
			} else {
				throw new ResponseException(statusCode, body, headers);
			}
		}
	}

	private String toString(InputStream bodyStream) {
		try {
			Reader reader = new InputStreamReader(bodyStream, CHARSET);
			StringBuilder body = new StringBuilder();
			char[] buffer = new char[4096];
			int len;
			while ((len = reader.read(buffer)) != -1) {
				body.append(buffer, 0, len);
			}
			return body.toString();
		} catch (IOException e) {
			throw new CommunicationException(e);
		}
	}

	private boolean isJson(List<ResponseHeader> headers) {
		String contentType = ResponseHeader.getHeaderValue(headers, "Content-Type");
		return contentType == null || "application/json".equalsIgnoreCase(contentType) || contentType.toLowerCase().startsWith("application/json");
	}

	/**
	 * Utility method that delegates the call to this communicator's session's connection if that's an instance of
	 * {@link PooledConnection}. If not this method does nothing.
	 * @see PooledConnection#closeIdleConnections(long, TimeUnit)
	 */
	@Override
	public void closeIdleConnections(long idleTime, TimeUnit timeUnit) {
		if (connection instanceof PooledConnection) {
			((PooledConnection) connection).closeIdleConnections(idleTime, timeUnit);
		}
	}

	/**
	 * Utility method that delegates the call to this communicator's session's connection if that's an instance of
	 * {@link PooledConnection}. If not this method does nothing.
	 * @see PooledConnection#closeExpiredConnections()
	 */
	@Override
	public void closeExpiredConnections() {
		if (connection instanceof PooledConnection) {
			((PooledConnection) connection).closeExpiredConnections();
		}
	}

	@Override
	public void enableLogging(CommunicatorLogger communicatorLogger) {
		// delegate to the connection
		connection.enableLogging(communicatorLogger);
	}

	@Override
	public void disableLogging() {
		// delegate to the connection
		connection.disableLogging();
	}
}
