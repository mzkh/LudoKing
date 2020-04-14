package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzbpi implements zzbpo {
    private final String zzcyz;
    private final String zzczh;

    zzbpi(String str, String str2) {
        this.zzczh = str;
        this.zzcyz = str2;
    }

    public final void zzp(Object obj) {
        ((AppEventListener) obj).onAppEvent(this.zzczh, this.zzcyz);
    }
}
