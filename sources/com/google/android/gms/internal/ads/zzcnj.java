package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzcnj implements zzdcj {
    private final zzape zzfhh;

    zzcnj(zzape zzape) {
        this.zzfhh = zzape;
    }

    public final zzddi zzf(Object obj) {
        return zzdcy.zzah(new zzcnl(new JsonReader(new InputStreamReader((InputStream) obj))).zzn(this.zzfhh.zzdma));
    }
}
