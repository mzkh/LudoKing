package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcss implements zzcru<zzcsp> {
    private final String packageName;
    private final zzddl zzfoa;
    private final zzaph zzgha;
    private final Context zzlk;

    public zzcss(@Nullable zzaph zzaph, Context context, String str, zzddl zzddl) {
        this.zzgha = zzaph;
        this.zzlk = context;
        this.packageName = str;
        this.zzfoa = zzddl;
    }

    public final zzddi<zzcsp> zzalv() {
        return this.zzfoa.zzd(new zzcsr(this));
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ zzcsp zzamk() throws Exception {
        JSONObject jSONObject = new JSONObject();
        zzaph zzaph = this.zzgha;
        if (zzaph != null) {
            zzaph.zza(this.zzlk, this.packageName, jSONObject);
        }
        return new zzcsp(jSONObject);
    }
}
