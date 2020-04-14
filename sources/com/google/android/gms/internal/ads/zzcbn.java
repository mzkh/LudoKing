package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcbn implements zzcym {
    private final Clock zzbmp;
    private final Map<zzcyd, Long> zzfsb = new HashMap();
    private final zzcbl zzfsc;
    private final Map<zzcyd, zzcbm> zzfsd = new HashMap();

    public zzcbn(zzcbl zzcbl, Set<zzcbm> set, Clock clock) {
        this.zzfsc = zzcbl;
        for (zzcbm zzcbm : set) {
            this.zzfsd.put(zzcbm.zzfsa, zzcbm);
        }
        this.zzbmp = clock;
    }

    public final void zza(zzcyd zzcyd, String str) {
    }

    public final void zzb(zzcyd zzcyd, String str) {
        this.zzfsb.put(zzcyd, Long.valueOf(this.zzbmp.elapsedRealtime()));
    }

    public final void zza(zzcyd zzcyd, String str, Throwable th) {
        if (this.zzfsb.containsKey(zzcyd)) {
            long elapsedRealtime = this.zzbmp.elapsedRealtime() - ((Long) this.zzfsb.get(zzcyd)).longValue();
            Map zzqd = this.zzfsc.zzqd();
            String str2 = "task.";
            String valueOf = String.valueOf(str);
            String concat = valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2);
            String str3 = "f.";
            String valueOf2 = String.valueOf(Long.toString(elapsedRealtime));
            zzqd.put(concat, valueOf2.length() != 0 ? str3.concat(valueOf2) : new String(str3));
        }
        if (this.zzfsd.containsKey(zzcyd)) {
            zza(zzcyd, false);
        }
    }

    public final void zzc(zzcyd zzcyd, String str) {
        if (this.zzfsb.containsKey(zzcyd)) {
            long elapsedRealtime = this.zzbmp.elapsedRealtime() - ((Long) this.zzfsb.get(zzcyd)).longValue();
            Map zzqd = this.zzfsc.zzqd();
            String str2 = "task.";
            String valueOf = String.valueOf(str);
            String concat = valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2);
            String str3 = "s.";
            String valueOf2 = String.valueOf(Long.toString(elapsedRealtime));
            zzqd.put(concat, valueOf2.length() != 0 ? str3.concat(valueOf2) : new String(str3));
        }
        if (this.zzfsd.containsKey(zzcyd)) {
            zza(zzcyd, true);
        }
    }

    private final void zza(zzcyd zzcyd, boolean z) {
        zzcyd zzb = ((zzcbm) this.zzfsd.get(zzcyd)).zzfrz;
        String str = z ? "s." : "f.";
        if (this.zzfsb.containsKey(zzb)) {
            long elapsedRealtime = this.zzbmp.elapsedRealtime() - ((Long) this.zzfsb.get(zzb)).longValue();
            Map zzqd = this.zzfsc.zzqd();
            String str2 = "label.";
            String valueOf = String.valueOf(((zzcbm) this.zzfsd.get(zzcyd)).label);
            String concat = valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2);
            String valueOf2 = String.valueOf(Long.toString(elapsedRealtime));
            zzqd.put(concat, valueOf2.length() != 0 ? str.concat(valueOf2) : new String(str));
        }
    }
}
