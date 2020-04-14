package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzavw {
    public final int count;
    public final String name;
    private final double zzduf;
    private final double zzdug;
    public final double zzduh;

    public zzavw(String str, double d, double d2, double d3, int i) {
        this.name = str;
        this.zzdug = d;
        this.zzduf = d2;
        this.zzduh = d3;
        this.count = i;
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("name", this.name).add("minBound", Double.valueOf(this.zzdug)).add("maxBound", Double.valueOf(this.zzduf)).add("percent", Double.valueOf(this.zzduh)).add("count", Integer.valueOf(this.count)).toString();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzavw)) {
            return false;
        }
        zzavw zzavw = (zzavw) obj;
        if (Objects.equal(this.name, zzavw.name) && this.zzduf == zzavw.zzduf && this.zzdug == zzavw.zzdug && this.count == zzavw.count && Double.compare(this.zzduh, zzavw.zzduh) == 0) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.name, Double.valueOf(this.zzduf), Double.valueOf(this.zzdug), Double.valueOf(this.zzduh), Integer.valueOf(this.count));
    }
}
