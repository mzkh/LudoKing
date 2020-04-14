package com.google.android.gms.internal.ads;

import java.util.Map.Entry;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzdbm<K, V> extends zzdbh<K, V> {
    private static final zzdbh<Object, Object> zzgpm = new zzdbm(null, new Object[0], 0);
    private final transient int size;
    private final transient Object zzgpn;
    private final transient Object[] zzgpo;

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0073, code lost:
        r10[r6] = (short) r3;
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a8, code lost:
        r10[r7] = r4;
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0035, code lost:
        r10[r6] = (byte) r3;
        r2 = r2 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static <K, V> com.google.android.gms.internal.ads.zzdbm<K, V> zzc(int r10, java.lang.Object[] r11) {
        /*
            int r10 = r11.length
            int r10 = r10 >> 1
            r0 = 5
            com.google.android.gms.internal.ads.zzdaq.zzs(r0, r10)
            int r10 = com.google.android.gms.internal.ads.zzdbg.zzdr(r0)
            int r1 = r10 + -1
            r2 = 0
            r3 = -1
            r4 = 128(0x80, float:1.794E-43)
            if (r10 > r4) goto L_0x004b
            byte[] r10 = new byte[r10]
            java.util.Arrays.fill(r10, r3)
        L_0x0018:
            if (r2 >= r0) goto L_0x00bd
            int r3 = r2 * 2
            r4 = r11[r3]
            r5 = r3 ^ 1
            r5 = r11[r5]
            com.google.android.gms.internal.ads.zzdax.zzb(r4, r5)
            int r6 = r4.hashCode()
            int r6 = com.google.android.gms.internal.ads.zzdaz.zzdp(r6)
        L_0x002d:
            r6 = r6 & r1
            byte r7 = r10[r6]
            r8 = 255(0xff, float:3.57E-43)
            r7 = r7 & r8
            if (r7 != r8) goto L_0x003b
            byte r3 = (byte) r3
            r10[r6] = r3
            int r2 = r2 + 1
            goto L_0x0018
        L_0x003b:
            r8 = r11[r7]
            boolean r8 = r8.equals(r4)
            if (r8 != 0) goto L_0x0046
            int r6 = r6 + 1
            goto L_0x002d
        L_0x0046:
            java.lang.IllegalArgumentException r10 = zza(r4, r5, r11, r7)
            throw r10
        L_0x004b:
            r4 = 32768(0x8000, float:4.5918E-41)
            if (r10 > r4) goto L_0x0089
            short[] r10 = new short[r10]
            java.util.Arrays.fill(r10, r3)
        L_0x0055:
            if (r2 >= r0) goto L_0x00bd
            int r3 = r2 * 2
            r4 = r11[r3]
            r5 = r3 ^ 1
            r5 = r11[r5]
            com.google.android.gms.internal.ads.zzdax.zzb(r4, r5)
            int r6 = r4.hashCode()
            int r6 = com.google.android.gms.internal.ads.zzdaz.zzdp(r6)
        L_0x006a:
            r6 = r6 & r1
            short r7 = r10[r6]
            r8 = 65535(0xffff, float:9.1834E-41)
            r7 = r7 & r8
            if (r7 != r8) goto L_0x0079
            short r3 = (short) r3
            r10[r6] = r3
            int r2 = r2 + 1
            goto L_0x0055
        L_0x0079:
            r8 = r11[r7]
            boolean r8 = r8.equals(r4)
            if (r8 != 0) goto L_0x0084
            int r6 = r6 + 1
            goto L_0x006a
        L_0x0084:
            java.lang.IllegalArgumentException r10 = zza(r4, r5, r11, r7)
            throw r10
        L_0x0089:
            int[] r10 = new int[r10]
            java.util.Arrays.fill(r10, r3)
        L_0x008e:
            if (r2 >= r0) goto L_0x00bd
            int r4 = r2 * 2
            r5 = r11[r4]
            r6 = r4 ^ 1
            r6 = r11[r6]
            com.google.android.gms.internal.ads.zzdax.zzb(r5, r6)
            int r7 = r5.hashCode()
            int r7 = com.google.android.gms.internal.ads.zzdaz.zzdp(r7)
        L_0x00a3:
            r7 = r7 & r1
            r8 = r10[r7]
            if (r8 != r3) goto L_0x00ad
            r10[r7] = r4
            int r2 = r2 + 1
            goto L_0x008e
        L_0x00ad:
            r9 = r11[r8]
            boolean r9 = r9.equals(r5)
            if (r9 != 0) goto L_0x00b8
            int r7 = r7 + 1
            goto L_0x00a3
        L_0x00b8:
            java.lang.IllegalArgumentException r10 = zza(r5, r6, r11, r8)
            throw r10
        L_0x00bd:
            com.google.android.gms.internal.ads.zzdbm r1 = new com.google.android.gms.internal.ads.zzdbm
            r1.<init>(r10, r11, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdbm.zzc(int, java.lang.Object[]):com.google.android.gms.internal.ads.zzdbm");
    }

    private static IllegalArgumentException zza(Object obj, Object obj2, Object[] objArr, int i) {
        String valueOf = String.valueOf(obj);
        String valueOf2 = String.valueOf(obj2);
        String valueOf3 = String.valueOf(objArr[i]);
        String valueOf4 = String.valueOf(objArr[i ^ 1]);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 39 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length() + String.valueOf(valueOf4).length());
        sb.append("Multiple entries with same key: ");
        sb.append(valueOf);
        String str = "=";
        sb.append(str);
        sb.append(valueOf2);
        sb.append(" and ");
        sb.append(valueOf3);
        sb.append(str);
        sb.append(valueOf4);
        return new IllegalArgumentException(sb.toString());
    }

    private zzdbm(Object obj, Object[] objArr, int i) {
        this.zzgpn = obj;
        this.zzgpo = objArr;
        this.size = i;
    }

    public final int size() {
        return this.size;
    }

    @NullableDecl
    public final V get(@NullableDecl Object obj) {
        Object obj2 = this.zzgpn;
        V[] vArr = this.zzgpo;
        int i = this.size;
        if (obj == null) {
            return null;
        }
        if (i == 1) {
            if (vArr[0].equals(obj)) {
                return vArr[1];
            }
            return null;
        } else if (obj2 == null) {
            return null;
        } else {
            if (obj2 instanceof byte[]) {
                byte[] bArr = (byte[]) obj2;
                int length = bArr.length - 1;
                int zzdp = zzdaz.zzdp(obj.hashCode());
                while (true) {
                    int i2 = zzdp & length;
                    byte b = bArr[i2] & 255;
                    if (b == 255) {
                        return null;
                    }
                    if (vArr[b].equals(obj)) {
                        return vArr[b ^ 1];
                    }
                    zzdp = i2 + 1;
                }
            } else if (obj2 instanceof short[]) {
                short[] sArr = (short[]) obj2;
                int length2 = sArr.length - 1;
                int zzdp2 = zzdaz.zzdp(obj.hashCode());
                while (true) {
                    int i3 = zzdp2 & length2;
                    short s = sArr[i3] & 65535;
                    if (s == 65535) {
                        return null;
                    }
                    if (vArr[s].equals(obj)) {
                        return vArr[s ^ 1];
                    }
                    zzdp2 = i3 + 1;
                }
            } else {
                int[] iArr = (int[]) obj2;
                int length3 = iArr.length - 1;
                int zzdp3 = zzdaz.zzdp(obj.hashCode());
                while (true) {
                    int i4 = zzdp3 & length3;
                    int i5 = iArr[i4];
                    if (i5 == -1) {
                        return null;
                    }
                    if (vArr[i5].equals(obj)) {
                        return vArr[i5 ^ 1];
                    }
                    zzdp3 = i4 + 1;
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public final zzdbg<Entry<K, V>> zzaos() {
        return new zzdbp(this, this.zzgpo, 0, this.size);
    }

    /* access modifiers changed from: 0000 */
    public final zzdbg<K> zzaot() {
        return new zzdbr(this, new zzdbq(this.zzgpo, 0, this.size));
    }

    /* access modifiers changed from: 0000 */
    public final zzday<V> zzaou() {
        return new zzdbq(this.zzgpo, 1, this.size);
    }
}
