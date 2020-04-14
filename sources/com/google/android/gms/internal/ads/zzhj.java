package com.google.android.gms.internal.ads;

import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzhj {
    private final Handler handler;
    /* access modifiers changed from: private */
    public final zzhg zzahe;

    public zzhj(Handler handler2, zzhg zzhg) {
        this.handler = zzhg != null ? (Handler) zznr.checkNotNull(handler2) : null;
        this.zzahe = zzhg;
    }

    public final void zzc(zzil zzil) {
        if (this.zzahe != null) {
            this.handler.post(new zzhi(this, zzil));
        }
    }

    public final void zzb(String str, long j, long j2) {
        if (this.zzahe != null) {
            Handler handler2 = this.handler;
            zzhl zzhl = new zzhl(this, str, j, j2);
            handler2.post(zzhl);
        }
    }

    public final void zzc(zzgo zzgo) {
        if (this.zzahe != null) {
            this.handler.post(new zzhk(this, zzgo));
        }
    }

    public final void zzb(int i, long j, long j2) {
        if (this.zzahe != null) {
            Handler handler2 = this.handler;
            zzhn zzhn = new zzhn(this, i, j, j2);
            handler2.post(zzhn);
        }
    }

    public final void zzd(zzil zzil) {
        if (this.zzahe != null) {
            this.handler.post(new zzhm(this, zzil));
        }
    }

    public final void zzr(int i) {
        if (this.zzahe != null) {
            this.handler.post(new zzhp(this, i));
        }
    }
}
