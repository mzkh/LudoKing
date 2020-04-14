package com.google.android.gms.internal.ads;

import android.view.View;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzaaa extends zzaaf {
    private final zze zzcuq;
    @Nullable
    private final String zzcur;
    private final String zzcus;

    public zzaaa(zze zze, @Nullable String str, String str2) {
        this.zzcuq = zze;
        this.zzcur = str;
        this.zzcus = str2;
    }

    public final String zzqb() {
        return this.zzcur;
    }

    public final String getContent() {
        return this.zzcus;
    }

    public final void zzs(@Nullable IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper != null) {
            this.zzcuq.zzg((View) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public final void recordClick() {
        this.zzcuq.zzjl();
    }

    public final void recordImpression() {
        this.zzcuq.zzjm();
    }
}
