package com.google.android.gms.ads.mediation;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class VersionInfo {
    private final int zzejg;
    private final int zzejh;
    private final int zzeji;

    public VersionInfo(int i, int i2, int i3) {
        this.zzejg = i;
        this.zzejh = i2;
        this.zzeji = i3;
    }

    public final int getMajorVersion() {
        return this.zzejg;
    }

    public final int getMinorVersion() {
        return this.zzejh;
    }

    public final int getMicroVersion() {
        return this.zzeji;
    }
}
