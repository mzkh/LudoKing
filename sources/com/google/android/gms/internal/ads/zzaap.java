package com.google.android.gms.internal.ads;

import com.tapjoy.TapjoyConstants;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzaap {
    private static zzaak<Boolean> zzcve = zzaam.zzf("gads:consent:gmscore:dsid:enabled", true);
    private static zzaak<Boolean> zzcvf = zzaam.zzf("gads:consent:gmscore:lat:enabled", true);
    private static zzaak<String> zzcvg = new zzaam("gads:consent:gmscore:backend_url", "https://adservice.google.com/getconfig/pubvendors", zzaan.zzcvc);
    private static zzaak<Long> zzcvh = new zzaam("gads:consent:gmscore:time_out", Long.valueOf(TapjoyConstants.TIMER_INCREMENT), zzaan.zzcva);
    private static zzaak<Boolean> zzcvi = zzaam.zzf("gads:consent:gmscore:enabled", true);

    public static final void zza(zzaaq zzaaq) {
    }
}
