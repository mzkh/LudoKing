package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.internal.ads.zzczh.zza;
import com.google.android.gms.internal.ads.zzczl.zzb;

@ShowFirstParty
/* compiled from: com.google.android.gms:play-services-gass@@18.2.0 */
public final class zzczf {
    private final Looper zzgnn;
    private final Context zzlk;

    public zzczf(@NonNull Context context, @NonNull Looper looper) {
        this.zzlk = context;
        this.zzgnn = looper;
    }

    public final void zzgl(@NonNull String str) {
        new zzcze(this.zzlk, this.zzgnn, (zzczl) ((zzdqw) zzczl.zzanz().zzgo(this.zzlk.getPackageName()).zzb(zzb.BLOCKED_IMPRESSION).zzb(zzczh.zzanx().zzgn(str).zzb(zza.BLOCKED_REASON_BACKGROUND)).zzazr())).zzanw();
    }
}
