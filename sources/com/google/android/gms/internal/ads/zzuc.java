package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzuc extends zzvs {
    private final AppEventListener zzbki;

    public zzuc(AppEventListener appEventListener) {
        this.zzbki = appEventListener;
    }

    public final void onAppEvent(String str, String str2) {
        this.zzbki.onAppEvent(str, str2);
    }

    public final AppEventListener getAppEventListener() {
        return this.zzbki;
    }
}
