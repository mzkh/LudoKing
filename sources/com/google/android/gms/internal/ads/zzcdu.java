package com.google.android.gms.internal.ads;

import java.util.regex.Matcher;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzcdu implements zzdcz<zzcvz> {
    private final /* synthetic */ zzcdt zzfus;

    zzcdu(zzcdt zzcdt) {
        this.zzfus = zzcdt;
    }

    public final void zzb(Throwable th) {
        if (((Boolean) zzuv.zzon().zzd(zzza.zzctc)).booleanValue()) {
            Matcher matcher = zzcdt.zzfur.matcher(th.getMessage());
            if (matcher.matches()) {
                this.zzfus.zzfuq.zzdh(Integer.parseInt(matcher.group(1)));
            }
        }
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzcvz zzcvz = (zzcvz) obj;
        if (((Boolean) zzuv.zzon().zzd(zzza.zzctc)).booleanValue()) {
            this.zzfus.zzfuq.zzdh(zzcvz.zzgkb.zzgjy.responseCode);
            this.zzfus.zzfuq.zzek(zzcvz.zzgkb.zzgjy.zzfvu);
        }
    }
}
