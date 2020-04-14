package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbo.zza;
import com.google.android.gms.internal.ads.zzbo.zza.zzb;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzes implements Callable {
    private final zzb zzaaa;
    private final zzdx zzvo;

    public zzes(zzdx zzdx, zzb zzb) {
        this.zzvo = zzdx;
        this.zzaaa = zzb;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzcw */
    public final Void call() throws Exception {
        if (this.zzvo.zzcn() != null) {
            this.zzvo.zzcn().get();
        }
        zza zzcm = this.zzvo.zzcm();
        if (zzcm != null) {
            try {
                synchronized (this.zzaaa) {
                    zzb zzb = this.zzaaa;
                    byte[] byteArray = zzcm.toByteArray();
                    zzb.zza(byteArray, 0, byteArray.length, zzdqj.zzazb());
                }
            } catch (zzdrg unused) {
            }
        }
        return null;
    }
}
