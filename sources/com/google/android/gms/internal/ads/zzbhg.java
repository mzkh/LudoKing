package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzbhg implements zzaer<Object> {
    final /* synthetic */ zzbhf zzfbl;

    zzbhg(zzbhf zzbhf) {
        this.zzfbl = zzbhf;
    }

    public final void zza(Object obj, Map<String, String> map) {
        if (this.zzfbl.zzl(map)) {
            this.zzfbl.executor.execute(new zzbhj(this));
        }
    }
}
