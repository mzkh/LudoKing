package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzzz {
    private final long time;
    @Nullable
    private final String zzcuo;
    @Nullable
    private final zzzz zzcup;

    public zzzz(long j, @Nullable String str, @Nullable zzzz zzzz) {
        this.time = j;
        this.zzcuo = str;
        this.zzcup = zzzz;
    }

    public final long getTime() {
        return this.time;
    }

    public final String zzpz() {
        return this.zzcuo;
    }

    @Nullable
    public final zzzz zzqa() {
        return this.zzcup;
    }
}
