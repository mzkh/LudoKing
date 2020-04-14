package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzaja implements zzaxx {
    private final /* synthetic */ zzaxv zzcyd;
    private final /* synthetic */ zzaia zzdbh;

    zzaja(zzaiy zzaiy, zzaxv zzaxv, zzaia zzaia) {
        this.zzcyd = zzaxv;
        this.zzdbh = zzaia;
    }

    public final void run() {
        this.zzcyd.setException(new zzaim("Unable to obtain a JavascriptEngine."));
        this.zzdbh.release();
    }
}
