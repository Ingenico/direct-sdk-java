/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference
 */
package com.ingenico.direct.domain;

public class TokenCardData {

	private CardWithoutCvv cardWithoutCvv = null;

	public CardWithoutCvv getCardWithoutCvv() {
		return cardWithoutCvv;
	}

	public void setCardWithoutCvv(CardWithoutCvv value) {
		this.cardWithoutCvv = value;
	}

	public TokenCardData withCardWithoutCvv(CardWithoutCvv value) {
		this.cardWithoutCvv = value;
		return this;
	}
}
