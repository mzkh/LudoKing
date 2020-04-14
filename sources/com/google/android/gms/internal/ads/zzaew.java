package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzaew implements zzaez {
    private final /* synthetic */ zzaxv zzcyd;

    zzaew(zzaex zzaex, zzaxv zzaxv) {
        this.zzcyd = zzaxv;
    }

    public final void zzc(JSONObject jSONObject) {
        this.zzcyd.set(jSONObject);
    }

    public final void onFailure(@Nullable String str) {
        this.zzcyd.setException(new zzaim(str));
    }
}
