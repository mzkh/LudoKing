package com.inmobi.unification.sdk.model;

public final class ASRequestParams {

    /* renamed from: a */
    public String f5972a;

    /* renamed from: b */
    public String f5973b;

    /* renamed from: c */
    public String f5974c;

    /* renamed from: d */
    public boolean f5975d;

    public static class Builder {
        private String a9Params;
        private boolean hasDynamicMediation;
        private String pubKeys;
        private String vcUserId;

        public Builder setPubKeys(String str) {
            this.pubKeys = str;
            return this;
        }

        public Builder setA9Params(String str) {
            this.a9Params = str;
            return this;
        }

        public Builder setVcUserId(String str) {
            this.vcUserId = str;
            return this;
        }

        public Builder setHasDynamicMediation(boolean z) {
            this.hasDynamicMediation = z;
            return this;
        }

        public ASRequestParams build() {
            ASRequestParams aSRequestParams = new ASRequestParams();
            aSRequestParams.f5972a = this.pubKeys;
            aSRequestParams.f5973b = this.a9Params;
            aSRequestParams.f5974c = this.vcUserId;
            aSRequestParams.f5975d = this.hasDynamicMediation;
            return aSRequestParams;
        }
    }
}
