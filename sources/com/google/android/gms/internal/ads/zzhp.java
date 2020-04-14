package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzhp implements Runnable {
    private final /* synthetic */ zzhj zzahd;
    private final /* synthetic */ int zzajp;

    zzhp(zzhj zzhj, int i) {
        this.zzahd = zzhj;
        this.zzajp = i;
    }

    public final void run() {
        this.zzahd.zzahe.zzq(this.zzajp);
    }
}
