package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzbch implements Runnable {
    private final /* synthetic */ zzbci zzefv;

    zzbch(zzbci zzbci) {
        this.zzefv = zzbci;
    }

    public final void run() {
        this.zzefv.zzefw.destroy();
    }
}
