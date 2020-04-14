package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import androidx.annotation.Nullable;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzctp {
    private final zzape zzfuz;

    public zzctp(zzape zzape) {
        this.zzfuz = zzape;
    }

    public final String zzaml() {
        return this.zzfuz.packageName;
    }

    public final String zzamm() {
        return this.zzfuz.zzdma.getString("ms");
    }

    @Nullable
    public final PackageInfo zzamn() {
        return this.zzfuz.zzdiv;
    }

    public final boolean zzamo() {
        return this.zzfuz.zzdmb;
    }

    public final List<String> zzamp() {
        return this.zzfuz.zzdjf;
    }

    public final ApplicationInfo zzamq() {
        return this.zzfuz.applicationInfo;
    }

    public final String zzamr() {
        return this.zzfuz.zzdmc;
    }
}
