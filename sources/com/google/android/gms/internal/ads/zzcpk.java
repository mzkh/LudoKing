package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcpk implements zzcru<zzcpl> {
    private final zzddl zzfoa;
    private final Context zzzc;

    zzcpk(Context context, zzddl zzddl) {
        this.zzzc = context;
        this.zzfoa = zzddl;
    }

    public final zzddi<zzcpl> zzalv() {
        return this.zzfoa.zzd(new zzcpj(this));
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ zzcpl zzama() throws Exception {
        zzq.zzkj();
        String zzaz = zzaul.zzaz(this.zzzc);
        zzq.zzkj();
        return new zzcpl(zzaz, zzaul.zzba(this.zzzc));
    }
}
