package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzapq extends zzaps {
    private final Object lock = new Object();
    @Nullable
    private SharedPreferences zzdnq;
    private final zzaip<JSONObject, JSONObject> zzdnr;
    private final Context zzzc;

    public zzapq(Context context, zzaip<JSONObject, JSONObject> zzaip) {
        this.zzzc = context.getApplicationContext();
        this.zzdnr = zzaip;
    }

    public final zzddi<Void> zztj() {
        synchronized (this.lock) {
            if (this.zzdnq == null) {
                this.zzdnq = this.zzzc.getSharedPreferences("google_ads_flags_meta", 0);
            }
        }
        if (zzq.zzkq().currentTimeMillis() - this.zzdnq.getLong("js_last_update", 0) < ((Long) zzuv.zzon().zzd(zzza.zzcnw)).longValue()) {
            return zzdcy.zzah(null);
        }
        return zzdcy.zzb(this.zzdnr.zzi(zzy(this.zzzc)), (zzdal<? super I, ? extends O>) new zzapp<Object,Object>(this), (Executor) zzaxn.zzdwn);
    }

    public static JSONObject zzy(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("js", zzaxl.zzwo().zzblz);
            jSONObject.put("mf", zzuv.zzon().zzd(zzza.zzcnx));
            jSONObject.put("cl", "265976736");
            jSONObject.put("rapid_rc", "dev");
            jSONObject.put("rapid_rollup", "HEAD");
            jSONObject.put("admob_module_version", 20360);
            jSONObject.put("dynamite_local_version", ModuleDescriptor.MODULE_VERSION);
            jSONObject.put("dynamite_version", DynamiteModule.getRemoteVersion(context, ModuleDescriptor.MODULE_ID));
            jSONObject.put("container_version", 12451009);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ Void zzf(JSONObject jSONObject) {
        zzza.zza(this.zzzc, 1, jSONObject);
        this.zzdnq.edit().putLong("js_last_update", zzq.zzkq().currentTimeMillis()).apply();
        return null;
    }
}
