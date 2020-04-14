package com.google.android.gms.games.internal;

import android.os.Bundle;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import java.util.Arrays;

public final class zzc {
    /* JADX WARNING: Removed duplicated region for block: B:131:0x014a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x00f4 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x0029 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x0029 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean zza(@androidx.annotation.Nullable android.os.Bundle r10, @androidx.annotation.Nullable android.os.Bundle r11) {
        /*
            r0 = 1
            if (r10 != r11) goto L_0x0004
            return r0
        L_0x0004:
            r1 = 0
            if (r10 == 0) goto L_0x0153
            if (r11 != 0) goto L_0x000b
            goto L_0x0153
        L_0x000b:
            int r2 = r10.size()
            int r3 = r11.size()
            if (r2 == r3) goto L_0x0016
            return r1
        L_0x0016:
            java.util.Set r2 = r10.keySet()
            java.util.Set r3 = r11.keySet()
            boolean r3 = r2.equals(r3)
            if (r3 != 0) goto L_0x0025
            return r1
        L_0x0025:
            java.util.Iterator r2 = r2.iterator()
        L_0x0029:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0152
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r4 = r10.get(r3)
            java.lang.Object r3 = r11.get(r3)
            if (r4 != 0) goto L_0x0042
            if (r3 == 0) goto L_0x0029
            return r1
        L_0x0042:
            boolean r5 = r4 instanceof android.os.Bundle
            if (r5 == 0) goto L_0x0055
            boolean r5 = r3 instanceof android.os.Bundle
            if (r5 == 0) goto L_0x0054
            android.os.Bundle r4 = (android.os.Bundle) r4
            android.os.Bundle r3 = (android.os.Bundle) r3
            boolean r3 = zza(r4, r3)
            if (r3 != 0) goto L_0x0029
        L_0x0054:
            return r1
        L_0x0055:
            boolean r5 = r4 instanceof byte[]
            if (r5 == 0) goto L_0x0068
            boolean r5 = r3 instanceof byte[]
            if (r5 == 0) goto L_0x0067
            byte[] r4 = (byte[]) r4
            byte[] r3 = (byte[]) r3
            boolean r3 = java.util.Arrays.equals(r4, r3)
            if (r3 != 0) goto L_0x0029
        L_0x0067:
            return r1
        L_0x0068:
            boolean r5 = r4 instanceof char[]
            if (r5 == 0) goto L_0x007b
            boolean r5 = r3 instanceof char[]
            if (r5 == 0) goto L_0x007a
            char[] r4 = (char[]) r4
            char[] r3 = (char[]) r3
            boolean r3 = java.util.Arrays.equals(r4, r3)
            if (r3 != 0) goto L_0x0029
        L_0x007a:
            return r1
        L_0x007b:
            boolean r5 = r4 instanceof short[]
            if (r5 == 0) goto L_0x008e
            boolean r5 = r3 instanceof short[]
            if (r5 == 0) goto L_0x008d
            short[] r4 = (short[]) r4
            short[] r3 = (short[]) r3
            boolean r3 = java.util.Arrays.equals(r4, r3)
            if (r3 != 0) goto L_0x0029
        L_0x008d:
            return r1
        L_0x008e:
            boolean r5 = r4 instanceof float[]
            if (r5 == 0) goto L_0x00a1
            boolean r5 = r3 instanceof float[]
            if (r5 == 0) goto L_0x00a0
            float[] r4 = (float[]) r4
            float[] r3 = (float[]) r3
            boolean r3 = java.util.Arrays.equals(r4, r3)
            if (r3 != 0) goto L_0x0029
        L_0x00a0:
            return r1
        L_0x00a1:
            boolean r5 = r4 instanceof java.lang.CharSequence[]
            if (r5 == 0) goto L_0x00b4
            boolean r5 = r3 instanceof java.lang.CharSequence[]
            if (r5 == 0) goto L_0x00b3
            java.lang.CharSequence[] r4 = (java.lang.CharSequence[]) r4
            java.lang.CharSequence[] r3 = (java.lang.CharSequence[]) r3
            boolean r3 = java.util.Arrays.equals(r4, r3)
            if (r3 != 0) goto L_0x0029
        L_0x00b3:
            return r1
        L_0x00b4:
            boolean r5 = r4 instanceof java.lang.Object[]
            if (r5 == 0) goto L_0x00f5
            boolean r5 = r3 instanceof java.lang.Object[]
            if (r5 == 0) goto L_0x00f4
            android.os.Parcelable[] r4 = (android.os.Parcelable[]) r4
            android.os.Parcelable[] r3 = (android.os.Parcelable[]) r3
            if (r4 == r3) goto L_0x00f1
            int r5 = r4.length
            int r6 = r3.length
            if (r6 == r5) goto L_0x00c8
        L_0x00c6:
            r3 = 0
            goto L_0x00f2
        L_0x00c8:
            r6 = 0
        L_0x00c9:
            if (r6 >= r5) goto L_0x00f1
            r7 = r4[r6]
            r8 = r3[r6]
            if (r7 != 0) goto L_0x00d4
            if (r8 == 0) goto L_0x00ee
            goto L_0x00c6
        L_0x00d4:
            boolean r9 = r7 instanceof android.os.Bundle
            if (r9 == 0) goto L_0x00e7
            boolean r9 = r8 instanceof android.os.Bundle
            if (r9 == 0) goto L_0x00c6
            android.os.Bundle r7 = (android.os.Bundle) r7
            android.os.Bundle r8 = (android.os.Bundle) r8
            boolean r7 = zza(r7, r8)
            if (r7 != 0) goto L_0x00ee
            goto L_0x00c6
        L_0x00e7:
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L_0x00ee
            goto L_0x00c6
        L_0x00ee:
            int r6 = r6 + 1
            goto L_0x00c9
        L_0x00f1:
            r3 = 1
        L_0x00f2:
            if (r3 != 0) goto L_0x0029
        L_0x00f4:
            return r1
        L_0x00f5:
            boolean r5 = r4 instanceof android.util.SparseArray
            if (r5 == 0) goto L_0x014b
            boolean r5 = r3 instanceof android.util.SparseArray
            if (r5 == 0) goto L_0x014a
            android.util.SparseArray r4 = (android.util.SparseArray) r4
            android.util.SparseArray r3 = (android.util.SparseArray) r3
            if (r4 == r3) goto L_0x0147
            int r5 = r4.size()
            int r6 = r3.size()
            if (r6 == r5) goto L_0x010f
        L_0x010d:
            r3 = 0
            goto L_0x0148
        L_0x010f:
            r6 = 0
        L_0x0110:
            if (r6 >= r5) goto L_0x0147
            int r7 = r4.keyAt(r6)
            int r8 = r3.keyAt(r6)
            if (r7 == r8) goto L_0x011d
            goto L_0x010d
        L_0x011d:
            java.lang.Object r7 = r4.valueAt(r6)
            java.lang.Object r8 = r3.valueAt(r6)
            if (r7 != 0) goto L_0x012a
            if (r8 == 0) goto L_0x0144
            goto L_0x010d
        L_0x012a:
            boolean r9 = r7 instanceof android.os.Bundle
            if (r9 == 0) goto L_0x013d
            boolean r9 = r8 instanceof android.os.Bundle
            if (r9 == 0) goto L_0x010d
            android.os.Bundle r7 = (android.os.Bundle) r7
            android.os.Bundle r8 = (android.os.Bundle) r8
            boolean r7 = zza(r7, r8)
            if (r7 != 0) goto L_0x0144
            goto L_0x010d
        L_0x013d:
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L_0x0144
            goto L_0x010d
        L_0x0144:
            int r6 = r6 + 1
            goto L_0x0110
        L_0x0147:
            r3 = 1
        L_0x0148:
            if (r3 != 0) goto L_0x0029
        L_0x014a:
            return r1
        L_0x014b:
            boolean r3 = r4.equals(r3)
            if (r3 != 0) goto L_0x0029
            return r1
        L_0x0152:
            return r0
        L_0x0153:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.games.internal.zzc.zza(android.os.Bundle, android.os.Bundle):boolean");
    }

    public static int zza(@Nullable Bundle bundle) {
        int hashCode;
        int i;
        int hashCode2;
        Object[] objArr;
        int hashCode3;
        if (bundle == null) {
            return 0;
        }
        int size = bundle.size();
        if (size == 0) {
            return 0;
        }
        String[] strArr = (String[]) bundle.keySet().toArray(new String[size]);
        Arrays.sort(strArr);
        int i2 = 1;
        for (String str : strArr) {
            i2 *= 31;
            Object obj = bundle.get(str);
            if (obj != null) {
                if (obj instanceof Bundle) {
                    hashCode = zza((Bundle) obj);
                } else if (obj instanceof byte[]) {
                    hashCode = Arrays.hashCode((byte[]) obj);
                } else if (obj instanceof char[]) {
                    hashCode = Arrays.hashCode((char[]) obj);
                } else if (obj instanceof short[]) {
                    hashCode = Arrays.hashCode((short[]) obj);
                } else if (obj instanceof float[]) {
                    hashCode = Arrays.hashCode((float[]) obj);
                } else if (obj instanceof CharSequence[]) {
                    hashCode = Arrays.hashCode((CharSequence[]) obj);
                } else {
                    if (obj instanceof Object[]) {
                        i = 1;
                        for (Object obj2 : (Object[]) obj) {
                            i *= 31;
                            if (obj2 instanceof Bundle) {
                                hashCode3 = zza((Bundle) obj2);
                            } else if (obj2 != null) {
                                hashCode3 = obj2.hashCode();
                            }
                            i += hashCode3;
                        }
                    } else if (obj instanceof SparseArray) {
                        SparseArray sparseArray = (SparseArray) obj;
                        int size2 = sparseArray.size();
                        int i3 = 1;
                        for (int i4 = 0; i4 < size2; i4++) {
                            i3 = ((i * 31) + sparseArray.keyAt(i4)) * 31;
                            Object valueAt = sparseArray.valueAt(i4);
                            if (valueAt instanceof Bundle) {
                                hashCode2 = zza((Bundle) valueAt);
                            } else if (valueAt != null) {
                                hashCode2 = valueAt.hashCode();
                            }
                            i3 += hashCode2;
                        }
                    } else {
                        hashCode = obj.hashCode();
                    }
                    i2 += i;
                }
                i2 += hashCode;
            }
        }
        return i2;
    }
}
