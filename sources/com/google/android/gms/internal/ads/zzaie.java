package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzaie extends zzayc<zzaha> {
    private final Object lock = new Object();
    /* access modifiers changed from: private */
    public zzavr<zzaha> zzczv;
    private boolean zzdam;
    private int zzdan;

    public zzaie(zzavr<zzaha> zzavr) {
        this.zzczv = zzavr;
        this.zzdam = false;
        this.zzdan = 0;
    }

    public final zzaia zzrg() {
        zzaia zzaia = new zzaia(this);
        synchronized (this.lock) {
            zza(new zzaih(this, zzaia), new zzaig(this, zzaia));
            Preconditions.checkState(this.zzdan >= 0);
            this.zzdan++;
        }
        return zzaia;
    }

    /* access modifiers changed from: protected */
    public final void zzrh() {
        synchronized (this.lock) {
            Preconditions.checkState(this.zzdan > 0);
            zzaug.zzdy("Releasing 1 reference for JS Engine");
            this.zzdan--;
            zzrj();
        }
    }

    public final void zzri() {
        synchronized (this.lock) {
            Preconditions.checkState(this.zzdan >= 0);
            zzaug.zzdy("Releasing root reference. JS Engine will be destroyed once other references are released.");
            this.zzdam = true;
            zzrj();
        }
    }

    private final void zzrj() {
        synchronized (this.lock) {
            Preconditions.checkState(this.zzdan >= 0);
            if (!this.zzdam || this.zzdan != 0) {
                zzaug.zzdy("There are still references to the engine. Not destroying.");
            } else {
                zzaug.zzdy("No reference is left (including root). Cleaning up engine.");
                zza(new zzaij(this), new zzaya());
            }
        }
    }
}
