package com.applovin.mediation;

public class MaxAdFormat {
    public static final MaxAdFormat BANNER = new MaxAdFormat("BANNER");
    public static final MaxAdFormat INTERSTITIAL = new MaxAdFormat("INTER");
    public static final MaxAdFormat LEADER = new MaxAdFormat("LEADER");
    public static final MaxAdFormat MREC = new MaxAdFormat("MREC");
    public static final MaxAdFormat NATIVE = new MaxAdFormat("NATIVE");
    public static final MaxAdFormat REWARDED = new MaxAdFormat("REWARDED");

    /* renamed from: a */
    private final String f3251a;

    private MaxAdFormat(String str) {
        this.f3251a = str;
    }

    public String getLabel() {
        return this.f3251a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MaxAdFormat{label='");
        sb.append(this.f3251a);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
