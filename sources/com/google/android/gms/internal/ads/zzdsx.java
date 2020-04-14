package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
final class zzdsx {
    private static final Class<?> zzhnx = zzbbm();
    private static final zzdtn<?, ?> zzhny = zzbk(false);
    private static final zzdtn<?, ?> zzhnz = zzbk(true);
    private static final zzdtn<?, ?> zzhoa = new zzdtp();

    public static void zzi(Class<?> cls) {
        if (!zzdqw.class.isAssignableFrom(cls)) {
            Class<?> cls2 = zzhnx;
            if (cls2 != null && !cls2.isAssignableFrom(cls)) {
                throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
            }
        }
    }

    public static void zza(int i, List<Double> list, zzduk zzduk, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzduk.zzg(i, list, z);
        }
    }

    public static void zzb(int i, List<Float> list, zzduk zzduk, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzduk.zzf(i, list, z);
        }
    }

    public static void zzc(int i, List<Long> list, zzduk zzduk, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzduk.zzc(i, list, z);
        }
    }

    public static void zzd(int i, List<Long> list, zzduk zzduk, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzduk.zzd(i, list, z);
        }
    }

    public static void zze(int i, List<Long> list, zzduk zzduk, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzduk.zzn(i, list, z);
        }
    }

    public static void zzf(int i, List<Long> list, zzduk zzduk, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzduk.zze(i, list, z);
        }
    }

    public static void zzg(int i, List<Long> list, zzduk zzduk, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzduk.zzl(i, list, z);
        }
    }

    public static void zzh(int i, List<Integer> list, zzduk zzduk, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzduk.zza(i, list, z);
        }
    }

    public static void zzi(int i, List<Integer> list, zzduk zzduk, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzduk.zzj(i, list, z);
        }
    }

    public static void zzj(int i, List<Integer> list, zzduk zzduk, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzduk.zzm(i, list, z);
        }
    }

    public static void zzk(int i, List<Integer> list, zzduk zzduk, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzduk.zzb(i, list, z);
        }
    }

    public static void zzl(int i, List<Integer> list, zzduk zzduk, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzduk.zzk(i, list, z);
        }
    }

    public static void zzm(int i, List<Integer> list, zzduk zzduk, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzduk.zzh(i, list, z);
        }
    }

    public static void zzn(int i, List<Boolean> list, zzduk zzduk, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzduk.zzi(i, list, z);
        }
    }

    public static void zza(int i, List<String> list, zzduk zzduk) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzduk.zza(i, list);
        }
    }

    public static void zzb(int i, List<zzdpm> list, zzduk zzduk) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzduk.zzb(i, list);
        }
    }

    public static void zza(int i, List<?> list, zzduk zzduk, zzdsv zzdsv) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzduk.zza(i, list, zzdsv);
        }
    }

    public static void zzb(int i, List<?> list, zzduk zzduk, zzdsv zzdsv) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzduk.zzb(i, list, zzdsv);
        }
    }

    static int zzaa(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzdru) {
            zzdru zzdru = (zzdru) list;
            i = 0;
            while (i2 < size) {
                i += zzdqf.zzfd(zzdru.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzdqf.zzfd(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzo(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zzaa(list) + (list.size() * zzdqf.zzgd(i));
    }

    static int zzab(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzdru) {
            zzdru zzdru = (zzdru) list;
            i = 0;
            while (i2 < size) {
                i += zzdqf.zzfe(zzdru.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzdqf.zzfe(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzp(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzab(list) + (size * zzdqf.zzgd(i));
    }

    static int zzac(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzdru) {
            zzdru zzdru = (zzdru) list;
            i = 0;
            while (i2 < size) {
                i += zzdqf.zzff(zzdru.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzdqf.zzff(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzq(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzac(list) + (size * zzdqf.zzgd(i));
    }

    static int zzad(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzdqy) {
            zzdqy zzdqy = (zzdqy) list;
            i = 0;
            while (i2 < size) {
                i += zzdqf.zzgj(zzdqy.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzdqf.zzgj(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzr(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzad(list) + (size * zzdqf.zzgd(i));
    }

    static int zzae(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzdqy) {
            zzdqy zzdqy = (zzdqy) list;
            i = 0;
            while (i2 < size) {
                i += zzdqf.zzge(zzdqy.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzdqf.zzge(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzs(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzae(list) + (size * zzdqf.zzgd(i));
    }

    static int zzaf(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzdqy) {
            zzdqy zzdqy = (zzdqy) list;
            i = 0;
            while (i2 < size) {
                i += zzdqf.zzgf(zzdqy.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzdqf.zzgf(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzt(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzaf(list) + (size * zzdqf.zzgd(i));
    }

    static int zzag(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzdqy) {
            zzdqy zzdqy = (zzdqy) list;
            i = 0;
            while (i2 < size) {
                i += zzdqf.zzgg(zzdqy.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzdqf.zzgg(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzu(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzag(list) + (size * zzdqf.zzgd(i));
    }

    static int zzah(List<?> list) {
        return list.size() << 2;
    }

    static int zzv(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzdqf.zzah(i, 0);
    }

    static int zzai(List<?> list) {
        return list.size() << 3;
    }

    static int zzw(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzdqf.zzm(i, 0);
    }

    static int zzaj(List<?> list) {
        return list.size();
    }

    static int zzx(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzdqf.zzh(i, true);
    }

    static int zzc(int i, List<?> list) {
        int i2;
        int i3;
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        int zzgd = zzdqf.zzgd(i) * size;
        if (list instanceof zzdrn) {
            zzdrn zzdrn = (zzdrn) list;
            while (i4 < size) {
                Object zzgq = zzdrn.zzgq(i4);
                if (zzgq instanceof zzdpm) {
                    i3 = zzdqf.zzda((zzdpm) zzgq);
                } else {
                    i3 = zzdqf.zzhj((String) zzgq);
                }
                zzgd += i3;
                i4++;
            }
        } else {
            while (i4 < size) {
                Object obj = list.get(i4);
                if (obj instanceof zzdpm) {
                    i2 = zzdqf.zzda((zzdpm) obj);
                } else {
                    i2 = zzdqf.zzhj((String) obj);
                }
                zzgd += i2;
                i4++;
            }
        }
        return zzgd;
    }

    static int zzc(int i, Object obj, zzdsv zzdsv) {
        if (obj instanceof zzdrl) {
            return zzdqf.zza(i, (zzdrl) obj);
        }
        return zzdqf.zzb(i, (zzdsg) obj, zzdsv);
    }

    static int zzc(int i, List<?> list, zzdsv zzdsv) {
        int i2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzgd = zzdqf.zzgd(i) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof zzdrl) {
                i2 = zzdqf.zza((zzdrl) obj);
            } else {
                i2 = zzdqf.zzb((zzdsg) obj, zzdsv);
            }
            zzgd += i2;
        }
        return zzgd;
    }

    static int zzd(int i, List<zzdpm> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzgd = size * zzdqf.zzgd(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzgd += zzdqf.zzda((zzdpm) list.get(i2));
        }
        return zzgd;
    }

    static int zzd(int i, List<zzdsg> list, zzdsv zzdsv) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzdqf.zzc(i, (zzdsg) list.get(i3), zzdsv);
        }
        return i2;
    }

    public static zzdtn<?, ?> zzbbj() {
        return zzhny;
    }

    public static zzdtn<?, ?> zzbbk() {
        return zzhnz;
    }

    public static zzdtn<?, ?> zzbbl() {
        return zzhoa;
    }

    private static zzdtn<?, ?> zzbk(boolean z) {
        try {
            Class zzbbn = zzbbn();
            if (zzbbn == null) {
                return null;
            }
            return (zzdtn) zzbbn.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zzbbm() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zzbbn() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    static boolean zzg(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    static <T> void zza(zzdrz zzdrz, T t, T t2, long j) {
        zzdtt.zza((Object) t, j, zzdrz.zze(zzdtt.zzp(t, j), zzdtt.zzp(t2, j)));
    }

    static <T, FT extends zzdqo<FT>> void zza(zzdql<FT> zzdql, T t, T t2) {
        zzdqm zzai = zzdql.zzai(t2);
        if (!zzai.zzhhp.isEmpty()) {
            zzdql.zzaj(t).zza(zzai);
        }
    }

    static <T, UT, UB> void zza(zzdtn<UT, UB> zzdtn, T t, T t2) {
        zzdtn.zzh(t, zzdtn.zzj(zzdtn.zzay(t), zzdtn.zzay(t2)));
    }

    static <UT, UB> UB zza(int i, List<Integer> list, zzdrc zzdrc, UB ub, zzdtn<UT, UB> zzdtn) {
        UB ub2;
        if (zzdrc == null) {
            return ub;
        }
        if (!(list instanceof RandomAccess)) {
            Iterator it = list.iterator();
            loop1:
            while (true) {
                ub2 = ub;
                while (it.hasNext()) {
                    int intValue = ((Integer) it.next()).intValue();
                    if (!zzdrc.zzf(intValue)) {
                        ub = zza(i, intValue, ub2, zzdtn);
                        it.remove();
                    }
                }
                break loop1;
            }
        } else {
            int size = list.size();
            ub2 = ub;
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue2 = ((Integer) list.get(i3)).intValue();
                if (zzdrc.zzf(intValue2)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue2));
                    }
                    i2++;
                } else {
                    ub2 = zza(i, intValue2, ub2, zzdtn);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        }
        return ub2;
    }

    static <UT, UB> UB zza(int i, int i2, UB ub, zzdtn<UT, UB> zzdtn) {
        if (ub == null) {
            ub = zzdtn.zzbbw();
        }
        zzdtn.zza(ub, i, (long) i2);
        return ub;
    }
}
