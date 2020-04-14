package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbuc implements zzdwb<zzpe> {
    private final zzdwo<zzaxl> zzfcq;
    private final zzdwo<String> zzfcr;

    public zzbuc(zzdwo<zzaxl> zzdwo, zzdwo<String> zzdwo2) {
        this.zzfcq = zzdwo;
        this.zzfcr = zzdwo2;
    }

    public final /* synthetic */ Object get() {
        zzaxl zzaxl = (zzaxl) this.zzfcq.get();
        String str = (String) this.zzfcr.get();
        zzq.zzkj();
        zzpe zzpe = new zzpe(zzaul.zzvm(), zzaxl, str, new JSONObject(), false, true);
        return (zzpe) zzdwh.zza(zzpe, "Cannot return null from a non-@Nullable @Provides method");
    }
}
