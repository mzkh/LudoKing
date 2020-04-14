package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcrm implements zzcrr<Bundle> {
    private final String zzblz;
    private final int zzdjl;
    private final boolean zzdki;
    private final boolean zzdwh;
    private final boolean zzggb;
    private final int zzggc;
    private final int zzggd;

    public zzcrm(boolean z, boolean z2, String str, boolean z3, int i, int i2, int i3) {
        this.zzggb = z;
        this.zzdwh = z2;
        this.zzblz = str;
        this.zzdki = z3;
        this.zzdjl = i;
        this.zzggc = i2;
        this.zzggd = i3;
    }

    public final /* synthetic */ void zzr(Object obj) {
        Bundle bundle = (Bundle) obj;
        bundle.putString("js", this.zzblz);
        bundle.putBoolean("is_nonagon", true);
        String str = "extra_caps";
        bundle.putString(str, (String) zzuv.zzon().zzd(zzza.zzcnv));
        bundle.putInt("target_api", this.zzdjl);
        bundle.putInt("dv", this.zzggc);
        bundle.putInt("lv", this.zzggd);
        String str2 = "sdk_env";
        Bundle zza = zzcwk.zza(bundle, str2);
        String str3 = "mf";
        zza.putBoolean(str3, ((Boolean) zzuv.zzon().zzd(zzza.zzcnx)).booleanValue());
        zza.putBoolean("instant_app", this.zzggb);
        zza.putBoolean("lite", this.zzdwh);
        zza.putBoolean("is_privileged_process", this.zzdki);
        bundle.putBundle(str2, zza);
        String str4 = "build_meta";
        Bundle zza2 = zzcwk.zza(zza, str4);
        zza2.putString("cl", "265976736");
        zza2.putString("rapid_rc", "dev");
        zza2.putString("rapid_rollup", "HEAD");
        zza.putBundle(str4, zza2);
    }
}
