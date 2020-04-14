package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzbca implements Runnable {
    private final /* synthetic */ View val$view;
    private final /* synthetic */ zzasi zzefc;
    private final /* synthetic */ zzbbv zzefd;
    private final /* synthetic */ int zzefe;

    zzbca(zzbbv zzbbv, View view, zzasi zzasi, int i) {
        this.zzefd = zzbbv;
        this.val$view = view;
        this.zzefc = zzasi;
        this.zzefe = i;
    }

    public final void run() {
        this.zzefd.zza(this.val$view, this.zzefc, this.zzefe - 1);
    }
}
