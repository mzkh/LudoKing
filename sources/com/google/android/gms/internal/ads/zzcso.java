package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import androidx.annotation.Nullable;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcso implements zzcru<zzcsl> {
    private final Executor executor;
    @Nullable
    private final PackageInfo zzdiv;
    private final zzatn zzggu;
    private final String zzggw;

    public zzcso(zzatn zzatn, Executor executor2, String str, @Nullable PackageInfo packageInfo) {
        this.zzggu = zzatn;
        this.executor = executor2;
        this.zzggw = str;
        this.zzdiv = packageInfo;
    }

    public final zzddi<zzcsl> zzalv() {
        return zzdcy.zzb(zzdcy.zzb(this.zzggu.zza(this.zzggw, this.zzdiv), zzcsn.zzdos, this.executor), Throwable.class, new zzcsq(this), this.executor);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ zzddi zze(Throwable th) throws Exception {
        return zzdcy.zzah(new zzcsl(this.zzggw));
    }
}
