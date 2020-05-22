package com.ingenico.direct;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.ingenico.direct.util.RequestHeaderMatcher;

@RunWith(Parameterized.class)
public class MetaDataProviderBuilderTest {

	private final String additionalHeaderName;
	private final boolean isAllowed;

	public MetaDataProviderBuilderTest(String additionalHeaderName, boolean isAllowed) {
		this.additionalHeaderName = additionalHeaderName;
		this.isAllowed = isAllowed;
	}

	@Parameters(name = "Header {0} is allowed: {1}")
	public static Iterable<Object[]> getParameters() {
		List<Object[]> parameters = new ArrayList<Object[]>();
		for (String prohibitedHeaders : MetaDataProvider.PROHIBITED_HEADERS) {
			parameters.add(new Object[] { prohibitedHeaders, false });
		}
		parameters.add(new Object[] { "Dummy",             true, });
		parameters.add(new Object[] { "Accept",            true, });
		parameters.add(new Object[] { "If-None-Match",     true, });
		parameters.add(new Object[] { "If-Modified-Since", true, });
		return parameters;
	}

	@Test
	public void testWithAdditionalRequestHeader() {
		RequestHeader additionalRequestHeader = new RequestHeader(additionalHeaderName, UUID.randomUUID().toString());

		MetaDataProviderBuilder builder = new MetaDataProviderBuilder("Ingenico");
		if (isAllowed) {
			MetaDataProvider metaDataProvider = builder.withAdditionalRequestHeader(additionalRequestHeader).build();
			Collection<RequestHeader> requestHeaders = metaDataProvider.getServerMetaDataHeaders();
			Assert.assertEquals(2, requestHeaders.size());

			Iterator<RequestHeader> requestHeaderIterator = requestHeaders.iterator();
			RequestHeader requestHeader = requestHeaderIterator.next();
			Assert.assertEquals("X-GCS-ServerMetaInfo", requestHeader.getName());

			requestHeader = requestHeaderIterator.next();
			Assert.assertThat(requestHeader, new RequestHeaderMatcher(additionalRequestHeader));
		} else {
			try {
				builder.withAdditionalRequestHeader(additionalRequestHeader);
				Assert.fail("expected IllegalArgumentException");
			} catch (IllegalArgumentException e) {
				Assert.assertThat(e.getMessage(), Matchers.containsString(additionalHeaderName));
			}
		}
	}
}
