package com.unity.purchasing.googleplay;

import org.json.JSONException;
import org.json.JSONObject;

public class SkuDetails {
    String freeTrialPeriod;
    String introductoryPrice;
    int introductoryPriceCycles;
    long introductoryPriceInMicros;
    String introductoryPricePeriod;
    String isoCurrencyCode;
    String mDescription;
    String mItemType;
    String mJson;
    String mPrice;
    String mSku;
    String mTitle;
    String mType;
    long priceInMicros;
    String subscriptionPeriod;

    public SkuDetails() {
    }

    public SkuDetails(String str) throws JSONException {
        this("inapp", str);
    }

    public SkuDetails(String str, String str2) throws JSONException {
        this.mItemType = str;
        this.mJson = str2;
        JSONObject jSONObject = new JSONObject(this.mJson);
        this.mSku = jSONObject.optString("productId");
        this.mType = jSONObject.optString("type");
        this.mPrice = jSONObject.optString("price");
        this.mTitle = jSONObject.optString("title");
        this.mDescription = jSONObject.optString("description");
        this.priceInMicros = jSONObject.optLong("price_amount_micros");
        this.isoCurrencyCode = jSONObject.optString("price_currency_code");
        this.subscriptionPeriod = jSONObject.optString("subscriptionPeriod");
        this.freeTrialPeriod = jSONObject.optString("freeTrialPeriod");
        this.introductoryPrice = jSONObject.optString("introductoryPrice");
        this.introductoryPricePeriod = jSONObject.optString("introductoryPricePeriod");
        this.introductoryPriceCycles = jSONObject.optInt("IntroductoryPriceCycles");
        this.introductoryPriceInMicros = jSONObject.optLong("introductoryPriceAmountMicros");
    }

    public String getSku() {
        return this.mSku;
    }

    public String getType() {
        return this.mType;
    }

    public String getPrice() {
        return this.mPrice;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public long getPriceInMicros() {
        return this.priceInMicros;
    }

    public String getISOCurrencyCode() {
        return this.isoCurrencyCode;
    }

    public String getSubscriptionPeriod() {
        return this.subscriptionPeriod;
    }

    public String getFreeTrialPeriod() {
        return this.freeTrialPeriod;
    }

    public String getIntroductoryPrice() {
        return this.introductoryPrice;
    }

    public String getIntroductoryPricePeriod() {
        return this.introductoryPricePeriod;
    }

    public int getIntroductoryPriceCycles() {
        return this.introductoryPriceCycles;
    }

    public long getIntroductoryPriceInMicros() {
        return this.introductoryPriceInMicros;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SkuDetails:");
        sb.append(this.mJson);
        return sb.toString();
    }

    public String getOriginalJSON() {
        return this.mJson;
    }
}
