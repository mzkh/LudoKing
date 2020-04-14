package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzq;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcql implements zzcru<zzcqm> {
    private final zzddl zzfoa;
    private final Set<String> zzgef;
    private final Context zzlk;

    public zzcql(zzddl zzddl, Context context, Set<String> set) {
        this.zzfoa = zzddl;
        this.zzlk = context;
        this.zzgef = set;
    }

    public final zzddi<zzcqm> zzalv() {
        return this.zzfoa.zzd(new zzcqo(this));
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ zzcqm zzamd() throws Exception {
        if (!((Boolean) zzuv.zzon().zzd(zzza.zzcqu)).booleanValue() || !zzcqm.zzd(this.zzgef)) {
            return new zzcqm(null);
        }
        return new zzcqm(zzq.zzky().getVersion(this.zzlk));
    }
}
