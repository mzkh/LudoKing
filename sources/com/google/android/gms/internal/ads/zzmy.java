package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public abstract class zzmy {
    private zzmx zzbed;

    public abstract zzna zza(zzgw[] zzgwArr, zzmk zzmk) throws zzgd;

    public abstract void zzd(Object obj);

    public final void zza(zzmx zzmx) {
        this.zzbed = zzmx;
    }

    /* access modifiers changed from: protected */
    public final void invalidate() {
        zzmx zzmx = this.zzbed;
        if (zzmx != null) {
            zzmx.zzec();
        }
    }
}
