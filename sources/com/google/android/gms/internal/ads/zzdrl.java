package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
public class zzdrl {
    private static final zzdqj zzhfs = zzdqj.zzaza();
    private zzdpm zzhme;
    private volatile zzdsg zzhmf;
    private volatile zzdpm zzhmg;

    public int hashCode() {
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzdrl)) {
            return false;
        }
        zzdrl zzdrl = (zzdrl) obj;
        zzdsg zzdsg = this.zzhmf;
        zzdsg zzdsg2 = zzdrl.zzhmf;
        if (zzdsg == null && zzdsg2 == null) {
            return zzaxg().equals(zzdrl.zzaxg());
        }
        if (zzdsg != null && zzdsg2 != null) {
            return zzdsg.equals(zzdsg2);
        }
        if (zzdsg != null) {
            return zzdsg.equals(zzdrl.zzp(zzdsg.zzazs()));
        }
        return zzp(zzdsg2.zzazs()).equals(zzdsg2);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:7|8|9|10|11|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0012 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.ads.zzdsg zzp(com.google.android.gms.internal.ads.zzdsg r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.ads.zzdsg r0 = r1.zzhmf
            if (r0 != 0) goto L_0x001d
            monitor-enter(r1)
            com.google.android.gms.internal.ads.zzdsg r0 = r1.zzhmf     // Catch:{ all -> 0x001a }
            if (r0 == 0) goto L_0x000b
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x000b:
            r1.zzhmf = r2     // Catch:{ zzdrg -> 0x0012 }
            com.google.android.gms.internal.ads.zzdpm r0 = com.google.android.gms.internal.ads.zzdpm.zzhgb     // Catch:{ zzdrg -> 0x0012 }
            r1.zzhmg = r0     // Catch:{ zzdrg -> 0x0012 }
            goto L_0x0018
        L_0x0012:
            r1.zzhmf = r2     // Catch:{ all -> 0x001a }
            com.google.android.gms.internal.ads.zzdpm r2 = com.google.android.gms.internal.ads.zzdpm.zzhgb     // Catch:{ all -> 0x001a }
            r1.zzhmg = r2     // Catch:{ all -> 0x001a }
        L_0x0018:
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x001a:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            throw r2
        L_0x001d:
            com.google.android.gms.internal.ads.zzdsg r2 = r1.zzhmf
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdrl.zzp(com.google.android.gms.internal.ads.zzdsg):com.google.android.gms.internal.ads.zzdsg");
    }

    public final zzdsg zzq(zzdsg zzdsg) {
        zzdsg zzdsg2 = this.zzhmf;
        this.zzhme = null;
        this.zzhmg = null;
        this.zzhmf = zzdsg;
        return zzdsg2;
    }

    public final int zzazu() {
        if (this.zzhmg != null) {
            return this.zzhmg.size();
        }
        if (this.zzhmf != null) {
            return this.zzhmf.zzazu();
        }
        return 0;
    }

    public final zzdpm zzaxg() {
        if (this.zzhmg != null) {
            return this.zzhmg;
        }
        synchronized (this) {
            if (this.zzhmg != null) {
                zzdpm zzdpm = this.zzhmg;
                return zzdpm;
            }
            if (this.zzhmf == null) {
                this.zzhmg = zzdpm.zzhgb;
            } else {
                this.zzhmg = this.zzhmf.zzaxg();
            }
            zzdpm zzdpm2 = this.zzhmg;
            return zzdpm2;
        }
    }
}
