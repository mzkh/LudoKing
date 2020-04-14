package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzqn {
    final long value;
    final int zzbqf;
    final String zzbqm;

    zzqn(long j, String str, int i) {
        this.value = j;
        this.zzbqm = str;
        this.zzbqf = i;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj != null && (obj instanceof zzqn)) {
            zzqn zzqn = (zzqn) obj;
            if (zzqn.value == this.value && zzqn.zzbqf == this.zzbqf) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (int) this.value;
    }
}
