package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdqo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

/* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
final class zzdqm<FieldDescriptorType extends zzdqo<FieldDescriptorType>> {
    private static final zzdqm zzhhs = new zzdqm(true);
    final zzdta<FieldDescriptorType, Object> zzhhp = zzdta.zzgy(16);
    private boolean zzhhq;
    private boolean zzhhr = false;

    private zzdqm() {
    }

    private zzdqm(boolean z) {
        zzaxj();
    }

    public static <T extends zzdqo<T>> zzdqm<T> zzazc() {
        return zzhhs;
    }

    public final void zzaxj() {
        if (!this.zzhhq) {
            this.zzhhp.zzaxj();
            this.zzhhq = true;
        }
    }

    public final boolean isImmutable() {
        return this.zzhhq;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzdqm)) {
            return false;
        }
        return this.zzhhp.equals(((zzdqm) obj).zzhhp);
    }

    public final int hashCode() {
        return this.zzhhp.hashCode();
    }

    public final Iterator<Entry<FieldDescriptorType, Object>> iterator() {
        if (this.zzhhr) {
            return new zzdrm(this.zzhhp.entrySet().iterator());
        }
        return this.zzhhp.entrySet().iterator();
    }

    /* access modifiers changed from: 0000 */
    public final Iterator<Entry<FieldDescriptorType, Object>> descendingIterator() {
        if (this.zzhhr) {
            return new zzdrm(this.zzhhp.zzbbq().iterator());
        }
        return this.zzhhp.zzbbq().iterator();
    }

    private final Object zza(FieldDescriptorType fielddescriptortype) {
        Object obj = this.zzhhp.get(fielddescriptortype);
        return obj instanceof zzdrh ? zzdrh.zzbak() : obj;
    }

    private final void zza(FieldDescriptorType fielddescriptortype, Object obj) {
        if (!fielddescriptortype.zzazj()) {
            zza(fielddescriptortype.zzazh(), obj);
            r7 = obj;
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList2.get(i);
                i++;
                zza(fielddescriptortype.zzazh(), obj2);
            }
            r7 = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (r7 instanceof zzdrh) {
            this.zzhhr = true;
        }
        this.zzhhp.put(fielddescriptortype, r7);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        if ((r3 instanceof byte[]) == false) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001b, code lost:
        if ((r3 instanceof com.google.android.gms.internal.ads.zzdrh) == false) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0024, code lost:
        if ((r3 instanceof com.google.android.gms.internal.ads.zzdra) == false) goto L_0x0043;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zza(com.google.android.gms.internal.ads.zzdue r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.ads.zzdqx.checkNotNull(r3)
            int[] r0 = com.google.android.gms.internal.ads.zzdqp.zzhhv
            com.google.android.gms.internal.ads.zzduh r2 = r2.zzbcg()
            int r2 = r2.ordinal()
            r2 = r0[r2]
            r0 = 1
            r1 = 0
            switch(r2) {
                case 1: goto L_0x0040;
                case 2: goto L_0x003d;
                case 3: goto L_0x003a;
                case 4: goto L_0x0037;
                case 5: goto L_0x0034;
                case 6: goto L_0x0031;
                case 7: goto L_0x0028;
                case 8: goto L_0x001e;
                case 9: goto L_0x0015;
                default: goto L_0x0014;
            }
        L_0x0014:
            goto L_0x0043
        L_0x0015:
            boolean r2 = r3 instanceof com.google.android.gms.internal.ads.zzdsg
            if (r2 != 0) goto L_0x0026
            boolean r2 = r3 instanceof com.google.android.gms.internal.ads.zzdrh
            if (r2 == 0) goto L_0x0043
            goto L_0x0026
        L_0x001e:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L_0x0026
            boolean r2 = r3 instanceof com.google.android.gms.internal.ads.zzdra
            if (r2 == 0) goto L_0x0043
        L_0x0026:
            r1 = 1
            goto L_0x0043
        L_0x0028:
            boolean r2 = r3 instanceof com.google.android.gms.internal.ads.zzdpm
            if (r2 != 0) goto L_0x0026
            boolean r2 = r3 instanceof byte[]
            if (r2 == 0) goto L_0x0043
            goto L_0x0026
        L_0x0031:
            boolean r0 = r3 instanceof java.lang.String
            goto L_0x0042
        L_0x0034:
            boolean r0 = r3 instanceof java.lang.Boolean
            goto L_0x0042
        L_0x0037:
            boolean r0 = r3 instanceof java.lang.Double
            goto L_0x0042
        L_0x003a:
            boolean r0 = r3 instanceof java.lang.Float
            goto L_0x0042
        L_0x003d:
            boolean r0 = r3 instanceof java.lang.Long
            goto L_0x0042
        L_0x0040:
            boolean r0 = r3 instanceof java.lang.Integer
        L_0x0042:
            r1 = r0
        L_0x0043:
            if (r1 == 0) goto L_0x0046
            return
        L_0x0046:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Wrong object type used with protocol message reflection."
            r2.<init>(r3)
            throw r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdqm.zza(com.google.android.gms.internal.ads.zzdue, java.lang.Object):void");
    }

    public final boolean isInitialized() {
        for (int i = 0; i < this.zzhhp.zzbbo(); i++) {
            if (!zzb(this.zzhhp.zzgz(i))) {
                return false;
            }
        }
        for (Entry zzb : this.zzhhp.zzbbp()) {
            if (!zzb(zzb)) {
                return false;
            }
        }
        return true;
    }

    private static boolean zzb(Entry<FieldDescriptorType, Object> entry) {
        zzdqo zzdqo = (zzdqo) entry.getKey();
        if (zzdqo.zzazi() == zzduh.MESSAGE) {
            if (zzdqo.zzazj()) {
                for (zzdsg isInitialized : (List) entry.getValue()) {
                    if (!isInitialized.isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzdsg) {
                    if (!((zzdsg) value).isInitialized()) {
                        return false;
                    }
                } else if (value instanceof zzdrh) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public final void zza(zzdqm<FieldDescriptorType> zzdqm) {
        for (int i = 0; i < zzdqm.zzhhp.zzbbo(); i++) {
            zzc(zzdqm.zzhhp.zzgz(i));
        }
        for (Entry zzc : zzdqm.zzhhp.zzbbp()) {
            zzc(zzc);
        }
    }

    private static Object zzal(Object obj) {
        if (obj instanceof zzdsl) {
            return ((zzdsl) obj).zzbbb();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private final void zzc(Entry<FieldDescriptorType, Object> entry) {
        Object obj;
        zzdqo zzdqo = (zzdqo) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzdrh) {
            value = zzdrh.zzbak();
        }
        if (zzdqo.zzazj()) {
            Object zza = zza((FieldDescriptorType) zzdqo);
            if (zza == null) {
                zza = new ArrayList();
            }
            for (Object zzal : (List) value) {
                ((List) zza).add(zzal(zzal));
            }
            this.zzhhp.put(zzdqo, zza);
        } else if (zzdqo.zzazi() == zzduh.MESSAGE) {
            Object zza2 = zza((FieldDescriptorType) zzdqo);
            if (zza2 == null) {
                this.zzhhp.put(zzdqo, zzal(value));
                return;
            }
            if (zza2 instanceof zzdsl) {
                obj = zzdqo.zza((zzdsl) zza2, (zzdsl) value);
            } else {
                obj = zzdqo.zza(((zzdsg) zza2).zzazx(), (zzdsg) value).zzazr();
            }
            this.zzhhp.put(zzdqo, obj);
        } else {
            this.zzhhp.put(zzdqo, zzal(value));
        }
    }

    static void zza(zzdqf zzdqf, zzdue zzdue, int i, Object obj) throws IOException {
        if (zzdue == zzdue.GROUP) {
            zzdsg zzdsg = (zzdsg) obj;
            zzdqx.zzn(zzdsg);
            zzdqf.zzz(i, 3);
            zzdsg.zzb(zzdqf);
            zzdqf.zzz(i, 4);
            return;
        }
        zzdqf.zzz(i, zzdue.zzbch());
        switch (zzdqp.zzhgt[zzdue.ordinal()]) {
            case 1:
                zzdqf.zzb(((Double) obj).doubleValue());
                break;
            case 2:
                zzdqf.zzf(((Float) obj).floatValue());
                return;
            case 3:
                zzdqf.zzfa(((Long) obj).longValue());
                return;
            case 4:
                zzdqf.zzfa(((Long) obj).longValue());
                return;
            case 5:
                zzdqf.zzfz(((Integer) obj).intValue());
                return;
            case 6:
                zzdqf.zzfc(((Long) obj).longValue());
                return;
            case 7:
                zzdqf.zzgc(((Integer) obj).intValue());
                return;
            case 8:
                zzdqf.zzbh(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzdsg) obj).zzb(zzdqf);
                return;
            case 10:
                zzdqf.zzj((zzdsg) obj);
                return;
            case 11:
                if (obj instanceof zzdpm) {
                    zzdqf.zzcz((zzdpm) obj);
                    return;
                } else {
                    zzdqf.zzhi((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzdpm) {
                    zzdqf.zzcz((zzdpm) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zzdqf.zzk(bArr, 0, bArr.length);
                return;
            case 13:
                zzdqf.zzga(((Integer) obj).intValue());
                return;
            case 14:
                zzdqf.zzgc(((Integer) obj).intValue());
                return;
            case 15:
                zzdqf.zzfc(((Long) obj).longValue());
                return;
            case 16:
                zzdqf.zzgb(((Integer) obj).intValue());
                return;
            case 17:
                zzdqf.zzfb(((Long) obj).longValue());
                return;
            case 18:
                if (!(obj instanceof zzdra)) {
                    zzdqf.zzfz(((Integer) obj).intValue());
                    break;
                } else {
                    zzdqf.zzfz(((zzdra) obj).zzab());
                    return;
                }
        }
    }

    public final int zzazd() {
        int i = 0;
        for (int i2 = 0; i2 < this.zzhhp.zzbbo(); i2++) {
            i += zzd(this.zzhhp.zzgz(i2));
        }
        for (Entry zzd : this.zzhhp.zzbbp()) {
            i += zzd(zzd);
        }
        return i;
    }

    private static int zzd(Entry<FieldDescriptorType, Object> entry) {
        zzdqo zzdqo = (zzdqo) entry.getKey();
        Object value = entry.getValue();
        if (zzdqo.zzazi() != zzduh.MESSAGE || zzdqo.zzazj() || zzdqo.zzazk()) {
            return zzb(zzdqo, value);
        }
        if (value instanceof zzdrh) {
            return zzdqf.zzb(((zzdqo) entry.getKey()).zzab(), (zzdrl) (zzdrh) value);
        }
        return zzdqf.zzd(((zzdqo) entry.getKey()).zzab(), (zzdsg) value);
    }

    static int zza(zzdue zzdue, int i, Object obj) {
        int zzgd = zzdqf.zzgd(i);
        if (zzdue == zzdue.GROUP) {
            zzdqx.zzn((zzdsg) obj);
            zzgd <<= 1;
        }
        return zzgd + zzb(zzdue, obj);
    }

    private static int zzb(zzdue zzdue, Object obj) {
        switch (zzdqp.zzhgt[zzdue.ordinal()]) {
            case 1:
                return zzdqf.zzc(((Double) obj).doubleValue());
            case 2:
                return zzdqf.zzg(((Float) obj).floatValue());
            case 3:
                return zzdqf.zzfd(((Long) obj).longValue());
            case 4:
                return zzdqf.zzfe(((Long) obj).longValue());
            case 5:
                return zzdqf.zzge(((Integer) obj).intValue());
            case 6:
                return zzdqf.zzfg(((Long) obj).longValue());
            case 7:
                return zzdqf.zzgh(((Integer) obj).intValue());
            case 8:
                return zzdqf.zzbi(((Boolean) obj).booleanValue());
            case 9:
                return zzdqf.zzl((zzdsg) obj);
            case 10:
                if (obj instanceof zzdrh) {
                    return zzdqf.zza((zzdrh) obj);
                }
                return zzdqf.zzk((zzdsg) obj);
            case 11:
                if (obj instanceof zzdpm) {
                    return zzdqf.zzda((zzdpm) obj);
                }
                return zzdqf.zzhj((String) obj);
            case 12:
                if (obj instanceof zzdpm) {
                    return zzdqf.zzda((zzdpm) obj);
                }
                return zzdqf.zzab((byte[]) obj);
            case 13:
                return zzdqf.zzgf(((Integer) obj).intValue());
            case 14:
                return zzdqf.zzgi(((Integer) obj).intValue());
            case 15:
                return zzdqf.zzfh(((Long) obj).longValue());
            case 16:
                return zzdqf.zzgg(((Integer) obj).intValue());
            case 17:
                return zzdqf.zzff(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzdra) {
                    return zzdqf.zzgj(((zzdra) obj).zzab());
                }
                return zzdqf.zzgj(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int zzb(zzdqo<?> zzdqo, Object obj) {
        zzdue zzazh = zzdqo.zzazh();
        int zzab = zzdqo.zzab();
        if (!zzdqo.zzazj()) {
            return zza(zzazh, zzab, obj);
        }
        int i = 0;
        if (zzdqo.zzazk()) {
            for (Object zzb : (List) obj) {
                i += zzb(zzazh, zzb);
            }
            return zzdqf.zzgd(zzab) + i + zzdqf.zzgl(i);
        }
        for (Object zza : (List) obj) {
            i += zza(zzazh, zzab, zza);
        }
        return i;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzdqm zzdqm = new zzdqm();
        for (int i = 0; i < this.zzhhp.zzbbo(); i++) {
            Entry zzgz = this.zzhhp.zzgz(i);
            zzdqm.zza((FieldDescriptorType) (zzdqo) zzgz.getKey(), zzgz.getValue());
        }
        for (Entry entry : this.zzhhp.zzbbp()) {
            zzdqm.zza((FieldDescriptorType) (zzdqo) entry.getKey(), entry.getValue());
        }
        zzdqm.zzhhr = this.zzhhr;
        return zzdqm;
    }
}
