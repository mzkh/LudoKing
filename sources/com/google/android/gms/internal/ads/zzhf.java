package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import java.util.Arrays;

@TargetApi(21)
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzhf {
    private static final zzhf zzagz = new zzhf(new int[]{2}, 2);
    private final int[] zzaha;
    private final int zzahb = 2;

    private zzhf(int[] iArr, int i) {
        this.zzaha = Arrays.copyOf(iArr, iArr.length);
        Arrays.sort(this.zzaha);
    }

    public final boolean zzp(int i) {
        return Arrays.binarySearch(this.zzaha, i) >= 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzhf)) {
            return false;
        }
        zzhf zzhf = (zzhf) obj;
        return Arrays.equals(this.zzaha, zzhf.zzaha) && this.zzahb == zzhf.zzahb;
    }

    public final int hashCode() {
        return this.zzahb + (Arrays.hashCode(this.zzaha) * 31);
    }

    public final String toString() {
        int i = this.zzahb;
        String arrays = Arrays.toString(this.zzaha);
        StringBuilder sb = new StringBuilder(String.valueOf(arrays).length() + 67);
        sb.append("AudioCapabilities[maxChannelCount=");
        sb.append(i);
        sb.append(", supportedEncodings=");
        sb.append(arrays);
        sb.append("]");
        return sb.toString();
    }
}
