package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzajd implements zzaez {
    private final /* synthetic */ zzaiy zzdbj;
    private final zzaia zzdbm;
    private final zzaxv<O> zzdbn;

    public zzajd(zzaiy zzaiy, zzaia zzaia, zzaxv<O> zzaxv) {
        this.zzdbj = zzaiy;
        this.zzdbm = zzaia;
        this.zzdbn = zzaxv;
    }

    public final void zzc(JSONObject jSONObject) {
        try {
            this.zzdbn.set(this.zzdbj.zzdbe.zzd(jSONObject));
        } catch (IllegalStateException unused) {
        } catch (JSONException e) {
            this.zzdbn.setException(e);
        } finally {
            this.zzdbm.release();
        }
    }

    public final void onFailure(@Nullable String str) {
        if (str == null) {
            try {
                this.zzdbn.setException(new zzaim());
            } catch (IllegalStateException unused) {
                this.zzdbm.release();
                return;
            } catch (Throwable th) {
                this.zzdbm.release();
                throw th;
            }
        } else {
            this.zzdbn.setException(new zzaim(str));
        }
        this.zzdbm.release();
    }
}
