package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzbmi;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcue<RequestComponentT extends zzbmi<AdT>, AdT> implements zzcud<RequestComponentT, AdT> {
    @GuardedBy("this")
    @Nullable
    private RequestComponentT zzght;

    public final zzddi<AdT> zza(zzbml<RequestComponentT> zzbml, Executor executor) {
        this.zzght = (zzbmi) zzbml.zzace();
        return this.zzght.zzaca().zzafs();
    }

    public final /* synthetic */ Object zzamt() {
        return this.zzght;
    }
}
