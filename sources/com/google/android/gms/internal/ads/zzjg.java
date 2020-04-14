package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzjg {
    public final int zzanh = 1;
    public final byte[] zzani;

    public zzjg(int i, byte[] bArr) {
        this.zzani = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzjg zzjg = (zzjg) obj;
            return this.zzanh == zzjg.zzanh && Arrays.equals(this.zzani, zzjg.zzani);
        }
    }

    public final int hashCode() {
        return (this.zzanh * 31) + Arrays.hashCode(this.zzani);
    }
}
