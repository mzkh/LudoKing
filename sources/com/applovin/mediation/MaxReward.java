package com.applovin.mediation;

public class MaxReward {
    public static final int DEFAULT_AMOUNT = 0;
    public static final String DEFAULT_LABEL = "";

    /* renamed from: a */
    private final String f3252a;

    /* renamed from: b */
    private final int f3253b;

    private MaxReward(int i, String str) {
        if (i >= 0) {
            this.f3252a = str;
            this.f3253b = i;
            return;
        }
        throw new IllegalArgumentException("Reward amount must be greater than or equal to 0");
    }

    public static MaxReward create(int i, String str) {
        return new MaxReward(i, str);
    }

    public static MaxReward createDefault() {
        return create(0, "");
    }

    public final int getAmount() {
        return this.f3253b;
    }

    public final String getLabel() {
        return this.f3252a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MaxReward{amount=");
        sb.append(this.f3253b);
        sb.append(", label='");
        sb.append(this.f3252a);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
