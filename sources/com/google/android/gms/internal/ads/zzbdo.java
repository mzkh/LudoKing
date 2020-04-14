package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzbdo implements Runnable {
    private final /* synthetic */ View val$view;
    private final /* synthetic */ zzasi zzefc;
    private final /* synthetic */ int zzefe;
    private final /* synthetic */ zzbdm zzeib;

    zzbdo(zzbdm zzbdm, View view, zzasi zzasi, int i) {
        this.zzeib = zzbdm;
        this.val$view = view;
        this.zzefc = zzasi;
        this.zzefe = i;
    }

    public final void run() {
        this.zzeib.zza(this.val$view, this.zzefc, this.zzefe - 1);
    }
}
