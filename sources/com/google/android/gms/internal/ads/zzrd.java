package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.appopen.AppOpenAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzrd extends AppOpenAd {
    private final zzqw zzbqw;

    public zzrd(zzqw zzqw) {
        this.zzbqw = zzqw;
    }

    /* access modifiers changed from: protected */
    public final zzvl zzdg() {
        try {
            return this.zzbqw.zzdg();
        } catch (RemoteException e) {
            zzaxi.zzc("", e);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final void zza(zzrc zzrc) {
        try {
            this.zzbqw.zza(zzrc);
        } catch (RemoteException e) {
            zzaxi.zzc("", e);
        }
    }
}
