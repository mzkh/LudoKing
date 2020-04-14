package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Predicate;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzahe implements Predicate {
    private final zzaer zzczj;

    zzahe(zzaer zzaer) {
        this.zzczj = zzaer;
    }

    public final boolean apply(Object obj) {
        zzaer zzaer = (zzaer) obj;
        return (zzaer instanceof zzahl) && ((zzahl) zzaer).zzczp.equals(this.zzczj);
    }
}
