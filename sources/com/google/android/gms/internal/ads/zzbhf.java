package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbhf {
    /* access modifiers changed from: private */
    public final Executor executor;
    private final String zzbly;
    private final zzajc zzfbm;
    /* access modifiers changed from: private */
    public zzbhk zzfbn;
    private final zzaer<Object> zzfbo = new zzbhe(this);
    private final zzaer<Object> zzfbp = new zzbhg(this);

    public zzbhf(String str, zzajc zzajc, Executor executor2) {
        this.zzbly = str;
        this.zzfbm = zzajc;
        this.executor = executor2;
    }

    public final void zza(zzbhk zzbhk) {
        this.zzfbm.zzc("/updateActiveView", this.zzfbo);
        this.zzfbm.zzc("/untrackActiveViewUnit", this.zzfbp);
        this.zzfbn = zzbhk;
    }

    public final void zzd(zzbbw zzbbw) {
        zzbbw.zza("/updateActiveView", this.zzfbo);
        zzbbw.zza("/untrackActiveViewUnit", this.zzfbp);
    }

    public final void zze(zzbbw zzbbw) {
        zzbbw.zzb("/updateActiveView", this.zzfbo);
        zzbbw.zzb("/untrackActiveViewUnit", this.zzfbp);
    }

    public final void zzaeh() {
        this.zzfbm.zzd("/updateActiveView", this.zzfbo);
        this.zzfbm.zzd("/untrackActiveViewUnit", this.zzfbp);
    }

    /* access modifiers changed from: private */
    public final boolean zzl(@Nullable Map<String, String> map) {
        if (map == null) {
            return false;
        }
        String str = (String) map.get("hashCode");
        if (TextUtils.isEmpty(str) || !str.equals(this.zzbly)) {
            return false;
        }
        return true;
    }
}
