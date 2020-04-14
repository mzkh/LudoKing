package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.view.Surface;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzov {
    private final Handler handler;
    /* access modifiers changed from: private */
    public final zzow zzbjf;

    public zzov(Handler handler2, zzow zzow) {
        this.handler = zzow != null ? (Handler) zznr.checkNotNull(handler2) : null;
        this.zzbjf = zzow;
    }

    public final void zzc(zzil zzil) {
        if (this.zzbjf != null) {
            this.handler.post(new zzoy(this, zzil));
        }
    }

    public final void zzb(String str, long j, long j2) {
        if (this.zzbjf != null) {
            Handler handler2 = this.handler;
            zzox zzox = new zzox(this, str, j, j2);
            handler2.post(zzox);
        }
    }

    public final void zzc(zzgo zzgo) {
        if (this.zzbjf != null) {
            this.handler.post(new zzpa(this, zzgo));
        }
    }

    public final void zze(int i, long j) {
        if (this.zzbjf != null) {
            this.handler.post(new zzoz(this, i, j));
        }
    }

    public final void zza(int i, int i2, int i3, float f) {
        if (this.zzbjf != null) {
            Handler handler2 = this.handler;
            zzpc zzpc = new zzpc(this, i, i2, i3, f);
            handler2.post(zzpc);
        }
    }

    public final void zza(Surface surface) {
        if (this.zzbjf != null) {
            this.handler.post(new zzpb(this, surface));
        }
    }

    public final void zzd(zzil zzil) {
        if (this.zzbjf != null) {
            this.handler.post(new zzpd(this, zzil));
        }
    }
}
