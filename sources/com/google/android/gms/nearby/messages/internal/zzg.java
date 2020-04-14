package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.ArrayUtils;

public final class zzg extends zzc {
    public zzg(String str) {
        this(zzm(str));
    }

    public zzg(String str, String str2) {
        this(zzm(str), zzm(str2));
    }

    public zzg(byte[] bArr) {
        Preconditions.checkArgument(bArr.length == 10 || bArr.length == 16, "Bytes must be a namespace (10 bytes), or a namespace plus instance (16 bytes).");
        super(bArr);
    }

    private zzg(byte[] bArr, byte[] bArr2) {
        byte[][] bArr3 = new byte[2][];
        boolean z = false;
        boolean z2 = bArr.length == 10;
        int length = bArr.length;
        StringBuilder sb = new StringBuilder(53);
        sb.append("Namespace length(");
        sb.append(length);
        sb.append(" bytes) must be 10 bytes.");
        Preconditions.checkArgument(z2, sb.toString());
        bArr3[0] = bArr;
        if (bArr2.length == 6) {
            z = true;
        }
        int length2 = bArr2.length;
        StringBuilder sb2 = new StringBuilder(51);
        sb2.append("Instance length(");
        sb2.append(length2);
        sb2.append(" bytes) must be 6 bytes.");
        Preconditions.checkArgument(z, sb2.toString());
        bArr3[1] = bArr2;
        this(ArrayUtils.concatByteArrays(bArr3));
    }

    public final String toString() {
        String hex = getHex();
        StringBuilder sb = new StringBuilder(String.valueOf(hex).length() + 26);
        sb.append("EddystoneUidPrefix{bytes=");
        sb.append(hex);
        sb.append('}');
        return sb.toString();
    }
}
