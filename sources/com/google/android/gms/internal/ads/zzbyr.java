package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbyr implements Callable<zzbyh> {
    /* access modifiers changed from: private */
    public final zzbcb zzbmi;
    /* access modifiers changed from: private */
    public final zzaxl zzdio;
    /* access modifiers changed from: private */
    public final zzdf zzegb;
    /* access modifiers changed from: private */
    public final Executor zzfbx;
    /* access modifiers changed from: private */
    public final zza zzfop;
    /* access modifiers changed from: private */
    public final Context zzlk;

    public zzbyr(Context context, Executor executor, zzdf zzdf, zzaxl zzaxl, zza zza, zzbcb zzbcb) {
        this.zzlk = context;
        this.zzfbx = executor;
        this.zzegb = zzdf;
        this.zzdio = zzaxl;
        this.zzfop = zza;
        this.zzbmi = zzbcb;
    }

    public final /* synthetic */ Object call() throws Exception {
        zzbyh zzbyh = new zzbyh(this);
        zzbyh.zzajg();
        return zzbyh;
    }
}
