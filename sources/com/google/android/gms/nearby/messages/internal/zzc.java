package com.google.android.gms.nearby.messages.internal;

import java.util.Arrays;

public class zzc {
    private static final char[] zzhd = "0123456789abcdef".toCharArray();
    private final byte[] zzy;

    protected zzc(byte[] bArr) {
        this.zzy = bArr;
    }

    public static String zzf(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            sb.append(zzhd[(b >> 4) & 15]);
            sb.append(zzhd[b & 15]);
        }
        return sb.toString();
    }

    public static byte[] zzm(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) ((Character.digit(str.charAt(i2), 16) << 4) + Character.digit(str.charAt(i2 + 1), 16));
        }
        return bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!obj.getClass().isAssignableFrom(getClass())) {
            return false;
        }
        return Arrays.equals(this.zzy, ((zzc) obj).zzy);
    }

    public final byte[] getBytes() {
        return this.zzy;
    }

    public final String getHex() {
        return zzf(this.zzy);
    }

    public int hashCode() {
        return Arrays.hashCode(this.zzy);
    }

    public String toString() {
        return zzf(this.zzy);
    }
}
