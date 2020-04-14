package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzaxu implements zzdcz<Object> {
    private final /* synthetic */ String zzdwr;

    zzaxu(String str) {
        this.zzdwr = str;
    }

    public final void onSuccess(@Nullable Object obj) {
    }

    public final void zzb(Throwable th) {
        zzq.zzkn().zza(th, this.zzdwr);
    }
}
