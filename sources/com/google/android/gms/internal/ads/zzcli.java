package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcli implements zzclc<zzbrs> {
    private final zzbso zzfxy;
    private final Context zzlk;

    public zzcli(Context context, zzbso zzbso) {
        this.zzlk = context;
        this.zzfxy = zzbso;
    }

    public final /* synthetic */ Object zza(zzcvz zzcvz, zzcvr zzcvr, View view, zzclj zzclj) {
        zzbru zza = this.zzfxy.zza(new zzbla(zzcvz, zzcvr, null), new zzclk(this, zzcll.zzgbd));
        zzclj.zza(new zzcln(this, zza));
        return zza.zzadh();
    }
}
