package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcfn implements zzbnb, zzbog {
    private static final Object zzfwb = new Object();
    private static int zzfwc = 0;
    private final zzcft zzfwd;

    public zzcfn(zzcft zzcft) {
        this.zzfwd = zzcft;
    }

    public final void onAdLoaded() {
        if (((Boolean) zzuv.zzon().zzd(zzza.zzctc)).booleanValue() && zzakm()) {
            this.zzfwd.zzbb(true);
            zzakl();
        }
    }

    public final void onAdFailedToLoad(int i) {
        if (((Boolean) zzuv.zzon().zzd(zzza.zzctc)).booleanValue() && zzakm()) {
            this.zzfwd.zzbb(false);
            zzakl();
        }
    }

    private static void zzakl() {
        synchronized (zzfwb) {
            zzfwc++;
        }
    }

    private static boolean zzakm() {
        boolean z;
        synchronized (zzfwb) {
            z = zzfwc < ((Integer) zzuv.zzon().zzd(zzza.zzctd)).intValue();
        }
        return z;
    }
}
