package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbxc {
    public final int type = 2;
    public final String zzce;
    public final String zzfpa;
    public final zzaau zzfpb;

    @VisibleForTesting
    public zzbxc(String str, String str2) {
        this.zzce = str;
        this.zzfpa = str2;
        this.zzfpb = null;
    }

    @VisibleForTesting
    public zzbxc(String str, zzaau zzaau) {
        this.zzce = str;
        this.zzfpa = null;
        this.zzfpb = zzaau;
    }
}
