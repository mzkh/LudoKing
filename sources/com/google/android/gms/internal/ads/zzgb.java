package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public abstract class zzgb implements zzgw, zzgx {
    private int index;
    private int state;
    private final int zzace;
    private zzgz zzacf;
    private zzmd zzacg;
    private long zzach;
    private boolean zzaci = true;
    private boolean zzacj;

    public zzgb(int i) {
        this.zzace = i;
    }

    /* access modifiers changed from: protected */
    public void onStarted() throws zzgd {
    }

    /* access modifiers changed from: protected */
    public void onStopped() throws zzgd {
    }

    public void zza(int i, Object obj) throws zzgd {
    }

    /* access modifiers changed from: protected */
    public void zza(long j, boolean z) throws zzgd {
    }

    /* access modifiers changed from: protected */
    public void zza(zzgo[] zzgoArr, long j) throws zzgd {
    }

    /* access modifiers changed from: protected */
    public void zzd(boolean z) throws zzgd {
    }

    public final zzgw zzdj() {
        return this;
    }

    public zznv zzdk() {
        return null;
    }

    public int zzdq() throws zzgd {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void zzdr() {
    }

    public final int getTrackType() {
        return this.zzace;
    }

    public final void setIndex(int i) {
        this.index = i;
    }

    public final int getState() {
        return this.state;
    }

    public final void zza(zzgz zzgz, zzgo[] zzgoArr, zzmd zzmd, long j, boolean z, long j2) throws zzgd {
        zznr.checkState(this.state == 0);
        this.zzacf = zzgz;
        this.state = 1;
        zzd(z);
        zza(zzgoArr, zzmd, j2);
        zza(j, z);
    }

    public final void start() throws zzgd {
        boolean z = true;
        if (this.state != 1) {
            z = false;
        }
        zznr.checkState(z);
        this.state = 2;
        onStarted();
    }

    public final void zza(zzgo[] zzgoArr, zzmd zzmd, long j) throws zzgd {
        zznr.checkState(!this.zzacj);
        this.zzacg = zzmd;
        this.zzaci = false;
        this.zzach = j;
        zza(zzgoArr, j);
    }

    public final zzmd zzdl() {
        return this.zzacg;
    }

    public final boolean zzdm() {
        return this.zzaci;
    }

    public final void zzdn() {
        this.zzacj = true;
    }

    public final boolean zzdo() {
        return this.zzacj;
    }

    public final void zzdp() throws IOException {
        this.zzacg.zzhe();
    }

    public final void zzdi(long j) throws zzgd {
        this.zzacj = false;
        this.zzaci = false;
        zza(j, false);
    }

    public final void stop() throws zzgd {
        zznr.checkState(this.state == 2);
        this.state = 1;
        onStopped();
    }

    public final void disable() {
        boolean z = true;
        if (this.state != 1) {
            z = false;
        }
        zznr.checkState(z);
        this.state = 0;
        this.zzacg = null;
        this.zzacj = false;
        zzdr();
    }

    /* access modifiers changed from: protected */
    public final zzgz zzds() {
        return this.zzacf;
    }

    /* access modifiers changed from: protected */
    public final int getIndex() {
        return this.index;
    }

    /* access modifiers changed from: protected */
    public final int zza(zzgq zzgq, zzik zzik, boolean z) {
        int zzb = this.zzacg.zzb(zzgq, zzik, z);
        if (zzb == -4) {
            if (zzik.zzfv()) {
                this.zzaci = true;
                if (this.zzacj) {
                    return -4;
                }
                return -3;
            }
            zzik.zzamb += this.zzach;
        } else if (zzb == -5) {
            zzgo zzgo = zzgq.zzafx;
            if (zzgo.zzafr != Long.MAX_VALUE) {
                zzgq.zzafx = zzgo.zzdm(zzgo.zzafr + this.zzach);
            }
        }
        return zzb;
    }

    /* access modifiers changed from: protected */
    public final void zzdj(long j) {
        this.zzacg.zzeb(j - this.zzach);
    }

    /* access modifiers changed from: protected */
    public final boolean zzdt() {
        return this.zzaci ? this.zzacj : this.zzacg.isReady();
    }
}
