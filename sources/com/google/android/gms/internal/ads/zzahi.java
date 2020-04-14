package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzahi implements Runnable {
    private final /* synthetic */ zzahc zzczm;
    private final /* synthetic */ String zzczo;

    zzahi(zzahc zzahc, String str) {
        this.zzczm = zzahc;
        this.zzczo = str;
    }

    public final void run() {
        this.zzczm.zzczi.loadUrl(this.zzczo);
    }
}
