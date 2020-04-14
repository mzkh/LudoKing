package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzzy {
    private final Map<String, zzzz> zzcum = new HashMap();
    @Nullable
    private final zzaab zzcun;

    public zzzy(@Nullable zzaab zzaab) {
        this.zzcun = zzaab;
    }

    public final void zza(String str, zzzz zzzz) {
        this.zzcum.put(str, zzzz);
    }

    public final void zza(String str, String str2, long j) {
        zzzz zzzz;
        zzaab zzaab = this.zzcun;
        zzzz zzzz2 = (zzzz) this.zzcum.get(str2);
        String[] strArr = {str};
        if (!(zzaab == null || zzzz2 == null)) {
            zzaab.zza(zzzz2, j, strArr);
        }
        Map<String, zzzz> map = this.zzcum;
        zzaab zzaab2 = this.zzcun;
        if (zzaab2 == null) {
            zzzz = null;
        } else {
            zzzz = zzaab2.zzer(j);
        }
        map.put(str, zzzz);
    }

    @Nullable
    public final zzaab zzpy() {
        return this.zzcun;
    }
}
