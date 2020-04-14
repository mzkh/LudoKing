package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzahg implements Runnable {
    private final /* synthetic */ String zzczl;
    private final /* synthetic */ zzahc zzczm;

    zzahg(zzahc zzahc, String str) {
        this.zzczm = zzahc;
        this.zzczl = str;
    }

    public final void run() {
        this.zzczm.zzczi.loadData(this.zzczl, "text/html", "UTF-8");
    }
}
