package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
final /* synthetic */ class zzaog implements Runnable {
    private final String zzcyz;
    private final zzaxm zzdir;

    zzaog(zzaxm zzaxm, String str) {
        this.zzdir = zzaxm;
        this.zzcyz = str;
    }

    public final void run() {
        this.zzdir.zzei(this.zzcyz);
    }
}
