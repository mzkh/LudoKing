package com.google.android.gms.internal.nearby;

import android.os.ParcelUuid;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.Hex;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

public final class zzgr {
    private static final ParcelUuid zzgm = ParcelUuid.fromString("00000000-0000-1000-8000-00805F9B34FB");
    private final int zzgn;
    @Nullable
    private final List<ParcelUuid> zzgo;
    @Nullable
    private final SparseArray<byte[]> zzgp;
    @Nullable
    private final Map<ParcelUuid, byte[]> zzgq;
    private final int zzgr;
    @Nullable
    private final String zzgs;
    private final byte[] zzgt;

    private zzgr(@Nullable List<ParcelUuid> list, @Nullable SparseArray<byte[]> sparseArray, @Nullable Map<ParcelUuid, byte[]> map, int i, int i2, @Nullable String str, byte[] bArr) {
        this.zzgo = list;
        this.zzgp = sparseArray;
        this.zzgq = map;
        this.zzgs = str;
        this.zzgn = i;
        this.zzgr = i2;
        this.zzgt = bArr;
    }

    private static int zza(byte[] bArr, int i, int i2, int i3, List<ParcelUuid> list) {
        while (i2 > 0) {
            list.add(zze(zza(bArr, i, i3)));
            i2 -= i3;
            i += i3;
        }
        return i;
    }

    private static byte[] zza(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x008e A[Catch:{ Exception -> 0x0099 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0090 A[Catch:{ Exception -> 0x0099 }] */
    @com.google.android.gms.common.util.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.nearby.zzgr zzd(@androidx.annotation.Nullable byte[] r13) {
        /*
            r0 = 0
            if (r13 != 0) goto L_0x0004
            return r0
        L_0x0004:
            r1 = 0
            r2 = -1
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            android.util.SparseArray r7 = new android.util.SparseArray
            r7.<init>()
            java.util.HashMap r8 = new java.util.HashMap
            r8.<init>()
            r11 = r0
            r9 = -1
            r10 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x001b:
            int r2 = r13.length     // Catch:{ Exception -> 0x0099 }
            if (r1 >= r2) goto L_0x0088
            int r2 = r1 + 1
            byte r1 = r13[r1]     // Catch:{ Exception -> 0x0099 }
            r4 = 255(0xff, float:3.57E-43)
            r1 = r1 & r4
            if (r1 == 0) goto L_0x0088
            int r1 = r1 + -1
            int r5 = r2 + 1
            byte r2 = r13[r2]     // Catch:{ Exception -> 0x0099 }
            r2 = r2 & r4
            r6 = 22
            r12 = 2
            if (r2 == r6) goto L_0x0073
            if (r2 == r4) goto L_0x005c
            switch(r2) {
                case 1: goto L_0x0057;
                case 2: goto L_0x0053;
                case 3: goto L_0x0053;
                case 4: goto L_0x004e;
                case 5: goto L_0x004e;
                case 6: goto L_0x0048;
                case 7: goto L_0x0048;
                case 8: goto L_0x003d;
                case 9: goto L_0x003d;
                case 10: goto L_0x0039;
                default: goto L_0x0038;
            }     // Catch:{ Exception -> 0x0099 }
        L_0x0038:
            goto L_0x0086
        L_0x0039:
            byte r2 = r13[r5]     // Catch:{ Exception -> 0x0099 }
            r10 = r2
            goto L_0x0086
        L_0x003d:
            java.lang.String r2 = new java.lang.String     // Catch:{ Exception -> 0x0099 }
            byte[] r4 = zza(r13, r5, r1)     // Catch:{ Exception -> 0x0099 }
            r2.<init>(r4)     // Catch:{ Exception -> 0x0099 }
            r11 = r2
            goto L_0x0086
        L_0x0048:
            r2 = 16
            zza(r13, r5, r1, r2, r3)     // Catch:{ Exception -> 0x0099 }
            goto L_0x0086
        L_0x004e:
            r2 = 4
            zza(r13, r5, r1, r2, r3)     // Catch:{ Exception -> 0x0099 }
            goto L_0x0086
        L_0x0053:
            zza(r13, r5, r1, r12, r3)     // Catch:{ Exception -> 0x0099 }
            goto L_0x0086
        L_0x0057:
            byte r2 = r13[r5]     // Catch:{ Exception -> 0x0099 }
            r2 = r2 & r4
            r9 = r2
            goto L_0x0086
        L_0x005c:
            int r2 = r5 + 1
            byte r2 = r13[r2]     // Catch:{ Exception -> 0x0099 }
            r2 = r2 & r4
            int r2 = r2 << 8
            byte r6 = r13[r5]     // Catch:{ Exception -> 0x0099 }
            r4 = r4 & r6
            int r2 = r2 + r4
            int r4 = r5 + 2
            int r6 = r1 + -2
            byte[] r4 = zza(r13, r4, r6)     // Catch:{ Exception -> 0x0099 }
            r7.put(r2, r4)     // Catch:{ Exception -> 0x0099 }
            goto L_0x0086
        L_0x0073:
            byte[] r2 = zza(r13, r5, r12)     // Catch:{ Exception -> 0x0099 }
            android.os.ParcelUuid r2 = zze(r2)     // Catch:{ Exception -> 0x0099 }
            int r4 = r5 + 2
            int r6 = r1 + -2
            byte[] r4 = zza(r13, r4, r6)     // Catch:{ Exception -> 0x0099 }
            r8.put(r2, r4)     // Catch:{ Exception -> 0x0099 }
        L_0x0086:
            int r1 = r1 + r5
            goto L_0x001b
        L_0x0088:
            boolean r1 = r3.isEmpty()     // Catch:{ Exception -> 0x0099 }
            if (r1 == 0) goto L_0x0090
            r6 = r0
            goto L_0x0091
        L_0x0090:
            r6 = r3
        L_0x0091:
            com.google.android.gms.internal.nearby.zzgr r1 = new com.google.android.gms.internal.nearby.zzgr     // Catch:{ Exception -> 0x0099 }
            r5 = r1
            r12 = r13
            r5.<init>(r6, r7, r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x0099 }
            return r1
        L_0x0099:
            r1 = move-exception
            java.lang.String r2 = "Unable to parse scan record: "
            java.lang.String r13 = java.util.Arrays.toString(r13)
            java.lang.String r13 = java.lang.String.valueOf(r13)
            int r3 = r13.length()
            if (r3 == 0) goto L_0x00af
            java.lang.String r13 = r2.concat(r13)
            goto L_0x00b4
        L_0x00af:
            java.lang.String r13 = new java.lang.String
            r13.<init>(r2)
        L_0x00b4:
            java.lang.String r2 = "BleRecord"
            android.util.Log.w(r2, r13, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.nearby.zzgr.zzd(byte[]):com.google.android.gms.internal.nearby.zzgr");
    }

    private static ParcelUuid zze(byte[] bArr) {
        long j;
        if (bArr != null) {
            int length = bArr.length;
            if (length != 2 && length != 4 && length != 16) {
                StringBuilder sb = new StringBuilder(38);
                sb.append("uuidBytes length invalid - ");
                sb.append(length);
                throw new IllegalArgumentException(sb.toString());
            } else if (length == 16) {
                ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                return new ParcelUuid(new UUID(order.getLong(8), order.getLong(0)));
            } else {
                if (length == 2) {
                    j = ((long) (bArr[0] & 255)) + ((long) ((bArr[1] & 255) << 8));
                } else {
                    j = ((long) ((bArr[3] & 255) << 24)) + ((long) (bArr[0] & 255)) + ((long) ((bArr[1] & 255) << 8)) + ((long) ((bArr[2] & 255) << 16));
                }
                return new ParcelUuid(new UUID(zzgm.getUuid().getMostSignificantBits() + (j << 32), zzgm.getUuid().getLeastSignificantBits()));
            }
        } else {
            throw new IllegalArgumentException("uuidBytes cannot be null");
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgr)) {
            return false;
        }
        return Arrays.equals(this.zzgt, ((zzgr) obj).zzgt);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zzgt);
    }

    public final String toString() {
        String str;
        int i = this.zzgn;
        String valueOf = String.valueOf(this.zzgo);
        SparseArray<byte[]> sparseArray = this.zzgp;
        StringBuilder sb = new StringBuilder();
        String str2 = ", ";
        String str3 = "{}";
        int i2 = 0;
        if (sparseArray.size() <= 0) {
            str = str3;
        } else {
            sb.append('{');
            for (int i3 = 0; i3 < sparseArray.size(); i3++) {
                if (i3 > 0) {
                    sb.append(str2);
                }
                byte[] bArr = (byte[]) sparseArray.valueAt(i3);
                sb.append(sparseArray.keyAt(i3));
                sb.append('=');
                sb.append(bArr == null ? null : Hex.bytesToStringUppercase(bArr));
            }
            sb.append('}');
            str = sb.toString();
        }
        Map<ParcelUuid, byte[]> map = this.zzgq;
        StringBuilder sb2 = new StringBuilder();
        if (map.keySet().size() > 0) {
            sb2.append('{');
            for (Entry entry : map.entrySet()) {
                if (i2 > 0) {
                    sb2.append(str2);
                }
                sb2.append(entry.getKey());
                sb2.append('=');
                byte[] bArr2 = (byte[]) entry.getValue();
                sb2.append(bArr2 == null ? null : Hex.bytesToStringUppercase(bArr2));
                i2++;
            }
            sb2.append('}');
            str3 = sb2.toString();
        }
        int i4 = this.zzgr;
        String str4 = this.zzgs;
        StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf).length() + 139 + String.valueOf(str).length() + String.valueOf(str3).length() + String.valueOf(str4).length());
        sb3.append("BleRecord [mAdvertiseFlags=");
        sb3.append(i);
        sb3.append(", mServiceUuids=");
        sb3.append(valueOf);
        sb3.append(", mManufacturerSpecificData=");
        sb3.append(str);
        sb3.append(", mServiceData=");
        sb3.append(str3);
        sb3.append(", mTxPowerLevel=");
        sb3.append(i4);
        sb3.append(", mDeviceName=");
        sb3.append(str4);
        sb3.append("]");
        return sb3.toString();
    }
}
