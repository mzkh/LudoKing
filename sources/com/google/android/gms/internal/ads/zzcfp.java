package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcfp {
    private int responseCode = 0;
    private long zzfwf = 0;
    private long zzfwg = 0;
    private long zzfwh = 0;
    private final Object zzfwi = new Object();
    private final Object zzfwj = new Object();
    private final Object zzfwk = new Object();
    private final Object zzfwl = new Object();

    public final void zzdh(int i) {
        synchronized (this.zzfwi) {
            this.responseCode = i;
        }
    }

    public final int getResponseCode() {
        int i;
        synchronized (this.zzfwi) {
            i = this.responseCode;
        }
        return i;
    }

    public final void zzek(long j) {
        synchronized (this.zzfwj) {
            this.zzfwf = j;
        }
    }

    public final long zzako() {
        long j;
        synchronized (this.zzfwj) {
            j = this.zzfwf;
        }
        return j;
    }

    public final synchronized void zzey(long j) {
        synchronized (this.zzfwk) {
            this.zzfwg = j;
        }
    }

    public final synchronized long zzakp() {
        long j;
        synchronized (this.zzfwk) {
            j = this.zzfwg;
        }
        return j;
    }

    public final synchronized void zzel(long j) {
        synchronized (this.zzfwl) {
            this.zzfwh = j;
        }
    }

    public final synchronized long zzakq() {
        long j;
        synchronized (this.zzfwl) {
            j = this.zzfwh;
        }
        return j;
    }
}
