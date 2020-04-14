package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzaia extends zzayc<zzail> {
    private final Object lock = new Object();
    /* access modifiers changed from: private */
    public final zzaie zzdaj;
    private boolean zzdak;

    public zzaia(zzaie zzaie) {
        this.zzdaj = zzaie;
    }

    public final void release() {
        synchronized (this.lock) {
            if (!this.zzdak) {
                this.zzdak = true;
                zza(new zzaid(this), new zzaya());
                zza(new zzaic(this), new zzaif(this));
            }
        }
    }
}
