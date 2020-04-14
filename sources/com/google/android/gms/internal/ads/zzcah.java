package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcah implements zzdwb<zzsd> {
    private final zzdwo<Context> zzejy;
    private final zzdwo<Integer> zzfcr;
    private final zzdwo<zzaxl> zzfgx;
    private final zzdwo<String> zzfrb;
    private final zzdwo<String> zzfrc;

    private zzcah(zzdwo<Context> zzdwo, zzdwo<String> zzdwo2, zzdwo<zzaxl> zzdwo3, zzdwo<Integer> zzdwo4, zzdwo<String> zzdwo5) {
        this.zzejy = zzdwo;
        this.zzfrb = zzdwo2;
        this.zzfgx = zzdwo3;
        this.zzfcr = zzdwo4;
        this.zzfrc = zzdwo5;
    }

    public static zzcah zzf(zzdwo<Context> zzdwo, zzdwo<String> zzdwo2, zzdwo<zzaxl> zzdwo3, zzdwo<Integer> zzdwo4, zzdwo<String> zzdwo5) {
        zzcah zzcah = new zzcah(zzdwo, zzdwo2, zzdwo3, zzdwo4, zzdwo5);
        return zzcah;
    }

    public final /* synthetic */ Object get() {
        Context context = (Context) this.zzejy.get();
        String str = (String) this.zzfrb.get();
        zzaxl zzaxl = (zzaxl) this.zzfgx.get();
        int intValue = ((Integer) this.zzfcr.get()).intValue();
        String str2 = (String) this.zzfrc.get();
        zzsd zzsd = new zzsd(new zzsi(context));
        zztk zztk = new zztk();
        zztk.zzcal = Integer.valueOf(zzaxl.zzdwe);
        zztk.zzcam = Integer.valueOf(zzaxl.zzdwf);
        zztk.zzcan = Integer.valueOf(zzaxl.zzdwg ? 0 : 2);
        zzsd.zza((zzsg) new zzcae(intValue, str, zztk, str2));
        return (zzsd) zzdwh.zza(zzsd, "Cannot return null from a non-@Nullable @Provides method");
    }
}
