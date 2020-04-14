package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzctb implements zzcru<zzctc> {
    private String packageName;
    private zzddl zzfoa;
    private zzatj zzghg;

    public zzctb(zzatj zzatj, zzddl zzddl, String str) {
        this.zzghg = zzatj;
        this.zzfoa = zzddl;
        this.packageName = str;
    }

    public final zzddi<zzctc> zzalv() {
        new zzaxv();
        zzddi zzah = zzdcy.zzah(null);
        if (((Boolean) zzuv.zzon().zzd(zzza.zzcse)).booleanValue()) {
            zzah = this.zzghg.zzdw(this.packageName);
        }
        zzddi zzdx = this.zzghg.zzdx(this.packageName);
        return zzdcy.zza(zzah, zzdx).zza(new zzcte(zzah, zzdx), zzaxn.zzdwi);
    }
}
