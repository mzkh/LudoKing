package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzh;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcww {
    private final zzaxl zzblh;
    private final zzatr zzbml;
    private final Map<String, zzcwy> zzgkx = new HashMap();
    private final zzdf zzgky;
    private final Context zzzc;

    public zzcww(Context context, zzaxl zzaxl, zzatr zzatr) {
        this.zzzc = context;
        this.zzblh = zzaxl;
        this.zzbml = zzatr;
        this.zzgky = new zzdf(new zzh(context, zzaxl));
    }

    public final zzcwy zzgg(@Nullable String str) {
        if (str == null) {
            return zzanh();
        }
        if (this.zzgkx.containsKey(str)) {
            return (zzcwy) this.zzgkx.get(str);
        }
        zzcwy zzgh = zzgh(str);
        this.zzgkx.put(str, zzgh);
        return zzgh;
    }

    private final zzcwy zzanh() {
        zzcwy zzcwy = new zzcwy(this.zzzc, this.zzbml.zzuh(), this.zzbml.zzuj(), this.zzgky);
        return zzcwy;
    }

    private final zzcwy zzgh(String str) {
        zzapv zzz = zzapv.zzz(this.zzzc);
        try {
            zzz.setAppPackageName(str);
            zzauh zzauh = new zzauh();
            zzauh.zza(this.zzzc, str, false);
            zzaum zzaum = new zzaum(this.zzbml.zzuh(), zzauh);
            zzcwy zzcwy = new zzcwy(zzz, zzaum, new zzatz(zzawy.zzwl(), zzaum), new zzdf(new zzh(this.zzzc, this.zzblh)));
            return zzcwy;
        } catch (NameNotFoundException unused) {
            return zzanh();
        }
    }
}
