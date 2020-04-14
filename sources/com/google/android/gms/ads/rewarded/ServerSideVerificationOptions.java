package com.google.android.gms.ads.rewarded;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public class ServerSideVerificationOptions {
    private final String zzdnz;
    private final String zzdoa;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
    public static final class Builder {
        /* access modifiers changed from: private */
        public String zzdnz;
        /* access modifiers changed from: private */
        public String zzdoa;

        public Builder() {
            String str = "";
            this.zzdnz = str;
            this.zzdoa = str;
        }

        public final Builder setUserId(String str) {
            this.zzdnz = str;
            return this;
        }

        public final Builder setCustomData(String str) {
            this.zzdoa = str;
            return this;
        }

        public final ServerSideVerificationOptions build() {
            return new ServerSideVerificationOptions(this);
        }
    }

    private ServerSideVerificationOptions(Builder builder) {
        this.zzdnz = builder.zzdnz;
        this.zzdoa = builder.zzdoa;
    }

    public String getUserId() {
        return this.zzdnz;
    }

    public String getCustomData() {
        return this.zzdoa;
    }
}
