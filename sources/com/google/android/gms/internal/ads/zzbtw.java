package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbtw implements zzdwb<JSONObject> {
    private final zzdwo<zzbuv> zzete;
    private final zzbtx zzfkj;

    public zzbtw(zzbtx zzbtx, zzdwo<zzbuv> zzdwo) {
        this.zzfkj = zzbtx;
        this.zzete = zzdwo;
    }

    @Nullable
    public final /* synthetic */ Object get() {
        return ((zzbuv) this.zzete.get()).zzaia();
    }
}
