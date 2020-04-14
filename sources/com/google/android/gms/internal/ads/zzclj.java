package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.zze;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzclj implements zze {
    @GuardedBy("this")
    private zze zzgbc;

    public final synchronized void zza(zze zze) {
        this.zzgbc = zze;
    }

    public final synchronized void zzg(View view) {
        if (this.zzgbc != null) {
            this.zzgbc.zzg(view);
        }
    }

    public final synchronized void zzjl() {
        if (this.zzgbc != null) {
            this.zzgbc.zzjl();
        }
    }

    public final synchronized void zzjm() {
        if (this.zzgbc != null) {
            this.zzgbc.zzjm();
        }
    }
}
