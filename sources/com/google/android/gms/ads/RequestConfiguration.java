package com.google.android.gms.ads;

import com.google.android.gms.internal.ads.zzaxi;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public class RequestConfiguration {
    public static final String MAX_AD_CONTENT_RATING_G = "G";
    public static final String MAX_AD_CONTENT_RATING_MA = "MA";
    public static final String MAX_AD_CONTENT_RATING_PG = "PG";
    public static final String MAX_AD_CONTENT_RATING_T = "T";
    public static final String MAX_AD_CONTENT_RATING_UNSPECIFIED = "";
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_FALSE = 0;
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_TRUE = 1;
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_UNSPECIFIED = -1;
    public static final int TAG_FOR_UNDER_AGE_OF_CONSENT_FALSE = 0;
    public static final int TAG_FOR_UNDER_AGE_OF_CONSENT_TRUE = 1;
    public static final int TAG_FOR_UNDER_AGE_OF_CONSENT_UNSPECIFIED = -1;
    public static final List<String> zzabm = Arrays.asList(new String[]{"MA", "T", "PG", "G"});
    private final int zzabj;
    private final int zzabk;
    private final String zzabl;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
    public static class Builder {
        private int zzabj = -1;
        private int zzabk = -1;
        private String zzabl = null;

        public RequestConfiguration build() {
            return new RequestConfiguration(this.zzabj, this.zzabk, this.zzabl);
        }

        public Builder setTagForChildDirectedTreatment(int i) {
            if (i == -1 || i == 0 || i == 1) {
                this.zzabj = i;
            } else {
                StringBuilder sb = new StringBuilder(68);
                sb.append("Invalid value passed to setTagForChildDirectedTreatment: ");
                sb.append(i);
                zzaxi.zzeu(sb.toString());
            }
            return this;
        }

        public Builder setTagForUnderAgeOfConsent(int i) {
            if (i == -1 || i == 0 || i == 1) {
                this.zzabk = i;
            } else {
                StringBuilder sb = new StringBuilder(63);
                sb.append("Invalid value passed to setTagForUnderAgeOfConsent: ");
                sb.append(i);
                zzaxi.zzeu(sb.toString());
            }
            return this;
        }

        public Builder setMaxAdContentRating(String str) {
            if (str == null || "".equals(str)) {
                this.zzabl = null;
            } else if ("G".equals(str) || "PG".equals(str) || "T".equals(str) || "MA".equals(str)) {
                this.zzabl = str;
            } else {
                String str2 = "Invalid value passed to setMaxAdContentRating: ";
                String valueOf = String.valueOf(str);
                zzaxi.zzeu(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            }
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
    public @interface MaxAdContentRating {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
    public @interface TagForChildDirectedTreatment {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
    public @interface TagForUnderAgeOfConsent {
    }

    private RequestConfiguration(int i, int i2, String str) {
        this.zzabj = i;
        this.zzabk = i2;
        this.zzabl = str;
    }

    public int getTagForChildDirectedTreatment() {
        return this.zzabj;
    }

    public int getTagForUnderAgeOfConsent() {
        return this.zzabk;
    }

    public String getMaxAdContentRating() {
        String str = this.zzabl;
        return str == null ? "" : str;
    }

    public Builder toBuilder() {
        return new Builder().setTagForChildDirectedTreatment(this.zzabj).setTagForUnderAgeOfConsent(this.zzabk).setMaxAdContentRating(this.zzabl);
    }
}
