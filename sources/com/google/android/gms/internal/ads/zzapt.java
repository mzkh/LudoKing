package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzq;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzapt implements zzapi {
    private zzaip<JSONObject, JSONObject> zzdnr;
    private zzaip<JSONObject, JSONObject> zzdns;

    public zzapt(Context context) {
        this.zzdns = zzq.zzkw().zza(context, zzaxl.zzwo()).zza("google.afma.request.getAdDictionary", zzais.zzday, zzais.zzday);
        this.zzdnr = zzq.zzkw().zza(context, zzaxl.zzwo()).zza("google.afma.sdkConstants.getSdkConstants", zzais.zzday, zzais.zzday);
    }

    public final zzaip<JSONObject, JSONObject> zztc() {
        return this.zzdnr;
    }
}
