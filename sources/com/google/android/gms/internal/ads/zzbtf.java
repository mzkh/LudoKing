package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzbtf implements zzbkp<zzbkq> {
    private final zzbuy zzfdo;
    private final Map<String, zzcga<zzbkq>> zzffj;
    private final zzdwo<zzbkp<zzbio>> zzfjb;
    private final Map<String, zzcga<zzbuj>> zzfjc;
    private final Map<String, zzcih<zzbuj>> zzfjd;

    zzbtf(Map<String, zzcga<zzbkq>> map, Map<String, zzcga<zzbuj>> map2, Map<String, zzcih<zzbuj>> map3, zzdwo<zzbkp<zzbio>> zzdwo, zzbuy zzbuy) {
        this.zzffj = map;
        this.zzfjc = map2;
        this.zzfjd = map3;
        this.zzfjb = zzdwo;
        this.zzfdo = zzbuy;
    }

    @Nullable
    public final zzcga<zzbkq> zze(int i, String str) {
        zzcga<zzbkq> zzcga = (zzcga) this.zzffj.get(str);
        if (zzcga != null) {
            return zzcga;
        }
        if (i != 1) {
            if (i != 4) {
                return null;
            }
            zzcih zzcih = (zzcih) this.zzfjd.get(str);
            if (zzcih != null) {
                return zzbkq.zza(zzcih);
            }
            zzcga zzcga2 = (zzcga) this.zzfjc.get(str);
            if (zzcga2 != null) {
                return zzbkq.zza(zzcga2);
            }
            return null;
        } else if (this.zzfdo.zzaih() == null) {
            return null;
        } else {
            zzcga zze = ((zzbkp) this.zzfjb.get()).zze(i, str);
            if (zze == null) {
                return null;
            }
            return zzbkq.zza(zze);
        }
    }
}
