package com.google.android.gms.internal.measurement;

public final class zzjo implements zzjl {
    private static final zzcm<Boolean> zzapv;
    private static final zzcm<Long> zzapw;

    public final boolean zzxm() {
        return ((Boolean) zzapv.get()).booleanValue();
    }

    static {
        zzct zzct = new zzct(zzcn.zzdh("com.google.android.gms.measurement"));
        zzapv = zzct.zzb("measurement.app_launch.event_ordering_fix", false);
        zzapw = zzct.zze("measurement.id.app_launch.event_ordering_fix", 0);
    }
}
