package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcdh implements zzdwb<zzddi<zzape>> {
    private final zzdwo<zzaui> zzemh;
    private final zzdwo<zzaxl> zzfcq;
    private final zzdwo<zzcyg> zzfek;
    private final zzdwo<String> zzfrb;
    private final zzdwo<zzddi<Bundle>> zzfuc;
    private final zzdwo<ApplicationInfo> zzfud;
    private final zzdwo<List<String>> zzfue;
    private final zzdwo<PackageInfo> zzfuf;
    private final zzdwo<zzddi<String>> zzfug;
    private final zzdwo<String> zzfuh;

    private zzcdh(zzdwo<zzcyg> zzdwo, zzdwo<zzddi<Bundle>> zzdwo2, zzdwo<zzaxl> zzdwo3, zzdwo<ApplicationInfo> zzdwo4, zzdwo<String> zzdwo5, zzdwo<List<String>> zzdwo6, zzdwo<PackageInfo> zzdwo7, zzdwo<zzddi<String>> zzdwo8, zzdwo<zzaui> zzdwo9, zzdwo<String> zzdwo10) {
        this.zzfek = zzdwo;
        this.zzfuc = zzdwo2;
        this.zzfcq = zzdwo3;
        this.zzfud = zzdwo4;
        this.zzfrb = zzdwo5;
        this.zzfue = zzdwo6;
        this.zzfuf = zzdwo7;
        this.zzfug = zzdwo8;
        this.zzemh = zzdwo9;
        this.zzfuh = zzdwo10;
    }

    public static zzcdh zza(zzdwo<zzcyg> zzdwo, zzdwo<zzddi<Bundle>> zzdwo2, zzdwo<zzaxl> zzdwo3, zzdwo<ApplicationInfo> zzdwo4, zzdwo<String> zzdwo5, zzdwo<List<String>> zzdwo6, zzdwo<PackageInfo> zzdwo7, zzdwo<zzddi<String>> zzdwo8, zzdwo<zzaui> zzdwo9, zzdwo<String> zzdwo10) {
        zzcdh zzcdh = new zzcdh(zzdwo, zzdwo2, zzdwo3, zzdwo4, zzdwo5, zzdwo6, zzdwo7, zzdwo8, zzdwo9, zzdwo10);
        return zzcdh;
    }

    public final /* synthetic */ Object get() {
        zzddi zzddi = (zzddi) this.zzfuc.get();
        zzaxl zzaxl = (zzaxl) this.zzfcq.get();
        ApplicationInfo applicationInfo = (ApplicationInfo) this.zzfud.get();
        String str = (String) this.zzfrb.get();
        List list = (List) this.zzfue.get();
        PackageInfo packageInfo = (PackageInfo) this.zzfuf.get();
        zzddi zzddi2 = (zzddi) this.zzfug.get();
        zzaui zzaui = (zzaui) this.zzemh.get();
        String str2 = (String) this.zzfuh.get();
        zzcxu zza = ((zzcyg) this.zzfek.get()).zza(zzcyd.REQUEST_PARCEL, (zzddi<?>[]) new zzddi[]{zzddi, zzddi2});
        zzcde zzcde = new zzcde(zzddi, zzaxl, applicationInfo, str, list, packageInfo, zzddi2, zzaui, str2);
        return (zzddi) zzdwh.zza(zza.zzb(zzcde).zzant(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
