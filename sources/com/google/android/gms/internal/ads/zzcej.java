package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzcej implements zzbpc {
    private final zzasl zzbnf;
    private final Context zzlk;

    zzcej(Context context, zzasl zzasl) {
        this.zzlk = context;
        this.zzbnf = zzasl;
    }

    public final void zzb(zzape zzape) {
    }

    public final void zza(zzcvz zzcvz) {
        if (!TextUtils.isEmpty(zzcvz.zzgkb.zzgjy.zzdlq)) {
            this.zzbnf.zza(this.zzlk, zzcvz.zzgka.zzfga.zzgkg);
            this.zzbnf.zzj(this.zzlk, zzcvz.zzgkb.zzgjy.zzdlq);
        }
    }
}
