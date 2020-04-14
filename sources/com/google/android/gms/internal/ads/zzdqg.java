package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdqw.zzd;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
final class zzdqg implements zzduk {
    private final zzdqf zzhgh;

    public static zzdqg zza(zzdqf zzdqf) {
        if (zzdqf.zzhgy != null) {
            return zzdqf.zzhgy;
        }
        return new zzdqg(zzdqf);
    }

    private zzdqg(zzdqf zzdqf) {
        this.zzhgh = (zzdqf) zzdqx.zza(zzdqf, "output");
    }

    public final int zzayy() {
        return zzd.zzhlg;
    }

    public final void zzak(int i, int i2) throws IOException {
        this.zzhgh.zzad(i, i2);
    }

    public final void zzo(int i, long j) throws IOException {
        this.zzhgh.zzg(i, j);
    }

    public final void zzp(int i, long j) throws IOException {
        this.zzhgh.zzi(i, j);
    }

    public final void zza(int i, float f) throws IOException {
        this.zzhgh.zza(i, f);
    }

    public final void zzb(int i, double d) throws IOException {
        this.zzhgh.zzb(i, d);
    }

    public final void zzal(int i, int i2) throws IOException {
        this.zzhgh.zzaa(i, i2);
    }

    public final void zzg(int i, long j) throws IOException {
        this.zzhgh.zzg(i, j);
    }

    public final void zzaa(int i, int i2) throws IOException {
        this.zzhgh.zzaa(i, i2);
    }

    public final void zzi(int i, long j) throws IOException {
        this.zzhgh.zzi(i, j);
    }

    public final void zzad(int i, int i2) throws IOException {
        this.zzhgh.zzad(i, i2);
    }

    public final void zzg(int i, boolean z) throws IOException {
        this.zzhgh.zzg(i, z);
    }

    public final void zzg(int i, String str) throws IOException {
        this.zzhgh.zzg(i, str);
    }

    public final void zza(int i, zzdpm zzdpm) throws IOException {
        this.zzhgh.zza(i, zzdpm);
    }

    public final void zzab(int i, int i2) throws IOException {
        this.zzhgh.zzab(i, i2);
    }

    public final void zzac(int i, int i2) throws IOException {
        this.zzhgh.zzac(i, i2);
    }

    public final void zzh(int i, long j) throws IOException {
        this.zzhgh.zzh(i, j);
    }

    public final void zza(int i, Object obj, zzdsv zzdsv) throws IOException {
        this.zzhgh.zza(i, (zzdsg) obj, zzdsv);
    }

    public final void zzb(int i, Object obj, zzdsv zzdsv) throws IOException {
        zzdqf zzdqf = this.zzhgh;
        zzdsg zzdsg = (zzdsg) obj;
        zzdqf.zzz(i, 3);
        zzdsv.zza(zzdsg, zzdqf.zzhgy);
        zzdqf.zzz(i, 4);
    }

    public final void zzgm(int i) throws IOException {
        this.zzhgh.zzz(i, 3);
    }

    public final void zzgn(int i) throws IOException {
        this.zzhgh.zzz(i, 4);
    }

    public final void zzb(int i, Object obj) throws IOException {
        if (obj instanceof zzdpm) {
            this.zzhgh.zzb(i, (zzdpm) obj);
        } else {
            this.zzhgh.zzb(i, (zzdsg) obj);
        }
    }

    public final void zza(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzhgh.zzz(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzdqf.zzge(((Integer) list.get(i4)).intValue());
            }
            this.zzhgh.zzga(i3);
            while (i2 < list.size()) {
                this.zzhgh.zzfz(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzhgh.zzaa(i, ((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public final void zzb(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzhgh.zzz(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzdqf.zzgh(((Integer) list.get(i4)).intValue());
            }
            this.zzhgh.zzga(i3);
            while (i2 < list.size()) {
                this.zzhgh.zzgc(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzhgh.zzad(i, ((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public final void zzc(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzhgh.zzz(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzdqf.zzfd(((Long) list.get(i4)).longValue());
            }
            this.zzhgh.zzga(i3);
            while (i2 < list.size()) {
                this.zzhgh.zzfa(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzhgh.zzg(i, ((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public final void zzd(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzhgh.zzz(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzdqf.zzfe(((Long) list.get(i4)).longValue());
            }
            this.zzhgh.zzga(i3);
            while (i2 < list.size()) {
                this.zzhgh.zzfa(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzhgh.zzg(i, ((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public final void zze(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzhgh.zzz(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzdqf.zzfg(((Long) list.get(i4)).longValue());
            }
            this.zzhgh.zzga(i3);
            while (i2 < list.size()) {
                this.zzhgh.zzfc(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzhgh.zzi(i, ((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public final void zzf(int i, List<Float> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzhgh.zzz(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzdqf.zzg(((Float) list.get(i4)).floatValue());
            }
            this.zzhgh.zzga(i3);
            while (i2 < list.size()) {
                this.zzhgh.zzf(((Float) list.get(i2)).floatValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzhgh.zza(i, ((Float) list.get(i2)).floatValue());
            i2++;
        }
    }

    public final void zzg(int i, List<Double> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzhgh.zzz(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzdqf.zzc(((Double) list.get(i4)).doubleValue());
            }
            this.zzhgh.zzga(i3);
            while (i2 < list.size()) {
                this.zzhgh.zzb(((Double) list.get(i2)).doubleValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzhgh.zzb(i, ((Double) list.get(i2)).doubleValue());
            i2++;
        }
    }

    public final void zzh(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzhgh.zzz(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzdqf.zzgj(((Integer) list.get(i4)).intValue());
            }
            this.zzhgh.zzga(i3);
            while (i2 < list.size()) {
                this.zzhgh.zzfz(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzhgh.zzaa(i, ((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public final void zzi(int i, List<Boolean> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzhgh.zzz(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzdqf.zzbi(((Boolean) list.get(i4)).booleanValue());
            }
            this.zzhgh.zzga(i3);
            while (i2 < list.size()) {
                this.zzhgh.zzbh(((Boolean) list.get(i2)).booleanValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzhgh.zzg(i, ((Boolean) list.get(i2)).booleanValue());
            i2++;
        }
    }

    public final void zza(int i, List<String> list) throws IOException {
        int i2 = 0;
        if (list instanceof zzdrn) {
            zzdrn zzdrn = (zzdrn) list;
            while (i2 < list.size()) {
                Object zzgq = zzdrn.zzgq(i2);
                if (zzgq instanceof String) {
                    this.zzhgh.zzg(i, (String) zzgq);
                } else {
                    this.zzhgh.zza(i, (zzdpm) zzgq);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzhgh.zzg(i, (String) list.get(i2));
            i2++;
        }
    }

    public final void zzb(int i, List<zzdpm> list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zzhgh.zza(i, (zzdpm) list.get(i2));
        }
    }

    public final void zzj(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzhgh.zzz(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzdqf.zzgf(((Integer) list.get(i4)).intValue());
            }
            this.zzhgh.zzga(i3);
            while (i2 < list.size()) {
                this.zzhgh.zzga(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzhgh.zzab(i, ((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public final void zzk(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzhgh.zzz(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzdqf.zzgi(((Integer) list.get(i4)).intValue());
            }
            this.zzhgh.zzga(i3);
            while (i2 < list.size()) {
                this.zzhgh.zzgc(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzhgh.zzad(i, ((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public final void zzl(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzhgh.zzz(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzdqf.zzfh(((Long) list.get(i4)).longValue());
            }
            this.zzhgh.zzga(i3);
            while (i2 < list.size()) {
                this.zzhgh.zzfc(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzhgh.zzi(i, ((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public final void zzm(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzhgh.zzz(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzdqf.zzgg(((Integer) list.get(i4)).intValue());
            }
            this.zzhgh.zzga(i3);
            while (i2 < list.size()) {
                this.zzhgh.zzgb(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzhgh.zzac(i, ((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public final void zzn(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzhgh.zzz(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzdqf.zzff(((Long) list.get(i4)).longValue());
            }
            this.zzhgh.zzga(i3);
            while (i2 < list.size()) {
                this.zzhgh.zzfb(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzhgh.zzh(i, ((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public final void zza(int i, List<?> list, zzdsv zzdsv) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zza(i, list.get(i2), zzdsv);
        }
    }

    public final void zzb(int i, List<?> list, zzdsv zzdsv) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzb(i, list.get(i2), zzdsv);
        }
    }

    public final <K, V> void zza(int i, zzdrx<K, V> zzdrx, Map<K, V> map) throws IOException {
        for (Entry entry : map.entrySet()) {
            this.zzhgh.zzz(i, 2);
            this.zzhgh.zzga(zzdry.zza(zzdrx, entry.getKey(), entry.getValue()));
            zzdry.zza(this.zzhgh, zzdrx, entry.getKey(), entry.getValue());
        }
    }
}
