package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.consent.ConsentSdkUtil.ConsentInformationCallback;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
final class zzzm extends zzze {
    private final ConsentInformationCallback zzcua;

    public zzzm(ConsentInformationCallback consentInformationCallback) {
        this.zzcua = consentInformationCallback;
    }

    public final void onSuccess(String str) {
        this.zzcua.onSuccess(str);
    }

    public final void onFailure(int i) {
        this.zzcua.onFailure(i);
    }
}
