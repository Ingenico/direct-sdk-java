package com.ingenico.direct.merchant.productgroups;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import com.ingenico.direct.RequestParam;
import com.ingenico.direct.util.RequestParamMatcher;

public class GetProductgroupParamsTest {

	@Test
	public void testToRequestParameters() {
		GetProductGroupParams params = new GetProductGroupParams();
		List<Matcher<? super RequestParam>> matchers = new ArrayList<Matcher<? super RequestParam>>();

		MatcherAssert.assertThat(params.toRequestParameters(), Matchers.containsInAnyOrder(matchers));

		params.setAmount(1000L);
		matchers.add(new RequestParamMatcher("amount", "1000"));
		MatcherAssert.assertThat(params.toRequestParameters(), Matchers.containsInAnyOrder(matchers));

		params.setCountryCode("NL");
		matchers.add(new RequestParamMatcher("countryCode", "NL"));
		MatcherAssert.assertThat(params.toRequestParameters(), Matchers.containsInAnyOrder(matchers));

		params.setCurrencyCode("EUR");
		matchers.add(new RequestParamMatcher("currencyCode", "EUR"));
		MatcherAssert.assertThat(params.toRequestParameters(), Matchers.containsInAnyOrder(matchers));

		params.setIsRecurring(true);
		matchers.add(new RequestParamMatcher("isRecurring", "true"));
		MatcherAssert.assertThat(params.toRequestParameters(), Matchers.containsInAnyOrder(matchers));

		params.setLocale("nl_NL");
		matchers.add(new RequestParamMatcher("locale", "nl_NL"));
		MatcherAssert.assertThat(params.toRequestParameters(), Matchers.containsInAnyOrder(matchers));

		params.addHide("fields");
		matchers.add(new RequestParamMatcher("hide", "fields"));
		MatcherAssert.assertThat(params.toRequestParameters(), Matchers.containsInAnyOrder(matchers));

		params.addHide("accountsOnFile");
		matchers.add(new RequestParamMatcher("hide", "accountsOnFile"));
		MatcherAssert.assertThat(params.toRequestParameters(), Matchers.containsInAnyOrder(matchers));

		params.setAmount(null);
		matchers.remove(0);
		MatcherAssert.assertThat(params.toRequestParameters(), Matchers.containsInAnyOrder(matchers));
	}
}
