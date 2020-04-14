package com.google.android.gms.internal.ads;

import android.location.Location;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import java.util.Date;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzakq implements MediationAdRequest {
    private final String zzabl;
    private final int zzcby;
    private final boolean zzccj;
    private final int zzddp;
    private final int zzddq;
    private final Date zznc;
    private final Set<String> zzne;
    private final boolean zznf;
    private final Location zzng;

    public zzakq(@Nullable Date date, int i, @Nullable Set<String> set, @Nullable Location location, boolean z, int i2, boolean z2, int i3, String str) {
        this.zznc = date;
        this.zzcby = i;
        this.zzne = set;
        this.zzng = location;
        this.zznf = z;
        this.zzddp = i2;
        this.zzccj = z2;
        this.zzddq = i3;
        this.zzabl = str;
    }

    @Deprecated
    public final Date getBirthday() {
        return this.zznc;
    }

    @Deprecated
    public final int getGender() {
        return this.zzcby;
    }

    public final Set<String> getKeywords() {
        return this.zzne;
    }

    public final Location getLocation() {
        return this.zzng;
    }

    public final boolean isTesting() {
        return this.zznf;
    }

    public final int taggedForChildDirectedTreatment() {
        return this.zzddp;
    }

    @Deprecated
    public final boolean isDesignedForFamilies() {
        return this.zzccj;
    }
}
