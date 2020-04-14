package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcov implements zzcrr<Bundle> {
    private final float zzdjk;
    private final int zzdme;
    private final boolean zzdmm;
    private final boolean zzdmn;
    private final int zzdmr;
    private final int zzdmv;
    private final int zzdmw;
    private final boolean zzgeu;

    public zzcov(int i, boolean z, boolean z2, int i2, int i3, int i4, float f, boolean z3) {
        this.zzdme = i;
        this.zzdmm = z;
        this.zzdmn = z2;
        this.zzdmr = i2;
        this.zzdmv = i3;
        this.zzdmw = i4;
        this.zzdjk = f;
        this.zzgeu = z3;
    }

    public final /* synthetic */ void zzr(Object obj) {
        Bundle bundle = (Bundle) obj;
        bundle.putInt("am", this.zzdme);
        bundle.putBoolean("ma", this.zzdmm);
        bundle.putBoolean("sp", this.zzdmn);
        bundle.putInt("muv", this.zzdmr);
        bundle.putInt("rm", this.zzdmv);
        bundle.putInt("riv", this.zzdmw);
        bundle.putFloat("android_app_volume", this.zzdjk);
        bundle.putBoolean("android_app_muted", this.zzgeu);
    }
}
