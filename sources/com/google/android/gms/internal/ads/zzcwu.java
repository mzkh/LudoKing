package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import java.util.HashSet;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcwu implements zzatx, zzbnb {
    private final zzatz zzdqe;
    @GuardedBy("this")
    private final HashSet<zzatq> zzgkw = new HashSet<>();
    private final Context zzlk;

    public zzcwu(Context context, zzatz zzatz) {
        this.zzlk = context;
        this.zzdqe = zzatz;
    }

    public final synchronized void onAdFailedToLoad(int i) {
        if (i != 3) {
            this.zzdqe.zzb(this.zzgkw);
        }
    }

    public final synchronized void zza(HashSet<zzatq> hashSet) {
        this.zzgkw.clear();
        this.zzgkw.addAll(hashSet);
    }

    public final Bundle zzang() {
        return this.zzdqe.zza(this.zzlk, (zzatx) this);
    }
}
