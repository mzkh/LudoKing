package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzazr implements Runnable {
    private final String zzcyz;
    private final zzazq zzebj;

    zzazr(zzazq zzazq, String str) {
        this.zzebj = zzazq;
        this.zzcyz = str;
    }

    public final void run() {
        this.zzebj.zzfa(this.zzcyz);
    }
}
