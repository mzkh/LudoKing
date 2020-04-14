package com.google.android.gms.internal.ads;

import android.view.View;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public class zzbrx {
    @Nullable
    private final zzbbw zzczi;
    private final zzbsu zzfim;

    public zzbrx(zzbsu zzbsu) {
        this(zzbsu, null);
    }

    public zzbrx(zzbsu zzbsu, @Nullable zzbbw zzbbw) {
        this.zzfim = zzbsu;
        this.zzczi = zzbbw;
    }

    public final zzbsu zzagu() {
        return this.zzfim;
    }

    @Nullable
    public final zzbbw zzaeo() {
        return this.zzczi;
    }

    @Nullable
    public final View zzagv() {
        zzbbw zzbbw = this.zzczi;
        if (zzbbw == null) {
            return null;
        }
        return zzbbw.getWebView();
    }

    public Set<zzbqs<zzbna>> zza(zzbsz zzbsz) {
        return Collections.singleton(zzbqs.zzb(zzbsz, zzaxn.zzdwn));
    }

    public final zzbqs<zzbpg> zzb(Executor executor) {
        return new zzbqs<>(new zzbrz(this.zzczi), executor);
    }
}
