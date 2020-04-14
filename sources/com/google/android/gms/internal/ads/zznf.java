package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zznf {
    public final int flags;
    public final Uri uri;
    public final long zzamq;
    public final byte[] zzbek;
    public final long zzbel;
    public final long zzcb;
    public final String zzce;

    public zznf(Uri uri2) {
        this(uri2, 0);
    }

    private zznf(Uri uri2, int i) {
        this(uri2, 0, -1, null, 0);
    }

    public zznf(Uri uri2, long j, long j2, String str) {
        this(uri2, j, j, j2, str, 0);
    }

    private zznf(Uri uri2, long j, long j2, String str, int i) {
        this(uri2, 0, 0, -1, null, 0);
    }

    private zznf(Uri uri2, long j, long j2, long j3, String str, int i) {
        this(uri2, null, j, j2, j3, str, i);
    }

    public zznf(Uri uri2, byte[] bArr, long j, long j2, long j3, String str, int i) {
        boolean z = true;
        zznr.checkArgument(j >= 0);
        zznr.checkArgument(j2 >= 0);
        if (j3 <= 0 && j3 != -1) {
            z = false;
        }
        zznr.checkArgument(z);
        this.uri = uri2;
        this.zzbek = bArr;
        this.zzbel = j;
        this.zzamq = j2;
        this.zzcb = j3;
        this.zzce = str;
        this.flags = i;
    }

    public final boolean zzaz(int i) {
        return (this.flags & 1) == 1;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.uri);
        String arrays = Arrays.toString(this.zzbek);
        long j = this.zzbel;
        long j2 = this.zzamq;
        long j3 = this.zzcb;
        String str = this.zzce;
        int i = this.flags;
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 93 + String.valueOf(arrays).length() + String.valueOf(str).length());
        sb.append("DataSpec[");
        sb.append(valueOf);
        String str2 = ", ";
        sb.append(str2);
        sb.append(arrays);
        sb.append(str2);
        sb.append(j);
        sb.append(str2);
        sb.append(j2);
        sb.append(str2);
        sb.append(j3);
        sb.append(str2);
        sb.append(str);
        sb.append(str2);
        sb.append(i);
        sb.append("]");
        return sb.toString();
    }
}
