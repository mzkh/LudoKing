package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbxn {
    private final Executor zzfbx;
    private final zzbqv zzfjq;
    private final zzbhx zzfpf;

    zzbxn(Executor executor, zzbhx zzbhx, zzbqv zzbqv) {
        this.zzfbx = executor;
        this.zzfjq = zzbqv;
        this.zzfpf = zzbhx;
    }

    public final void zzl(zzbbw zzbbw) {
        if (zzbbw != null) {
            this.zzfjq.zzq(zzbbw.getView());
            this.zzfjq.zza(new zzbxm(zzbbw), this.zzfbx);
            this.zzfjq.zza(new zzbxp(zzbbw), this.zzfbx);
            this.zzfjq.zza(this.zzfpf, this.zzfbx);
            this.zzfpf.zzg(zzbbw);
            zzbbw.zza("/trackActiveViewUnit", (zzaer<? super zzbbw>) new zzbxo<Object>(this));
            zzbbw.zza("/untrackActiveViewUnit", (zzaer<? super zzbbw>) new zzbxr<Object>(this));
        }
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zze(zzbbw zzbbw, Map map) {
        this.zzfpf.disable();
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzf(zzbbw zzbbw, Map map) {
        this.zzfpf.enable();
    }
}
