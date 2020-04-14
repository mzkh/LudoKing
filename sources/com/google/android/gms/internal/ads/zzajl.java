package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzajl implements zzaez {
    private final zzaxv<O> zzdbn;
    private final /* synthetic */ zzajj zzdbq;

    public zzajl(zzajj zzajj, zzaxv<O> zzaxv) {
        this.zzdbq = zzajj;
        this.zzdbn = zzaxv;
    }

    public final void zzc(JSONObject jSONObject) {
        try {
            this.zzdbn.set(this.zzdbq.zzdbe.zzd(jSONObject));
        } catch (IllegalStateException unused) {
        } catch (JSONException e) {
            this.zzdbn.setException(e);
        }
    }

    public final void onFailure(@Nullable String str) {
        if (str == null) {
            try {
                this.zzdbn.setException(new zzaim());
            } catch (IllegalStateException unused) {
            }
        } else {
            this.zzdbn.setException(new zzaim(str));
        }
    }
}
