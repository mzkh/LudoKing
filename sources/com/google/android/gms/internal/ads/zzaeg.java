package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzc;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzaeg implements zzaer<zzbbw> {
    zzaeg() {
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzbbw zzbbw = (zzbbw) obj;
        if (zzbbw.zzaad() != null) {
            zzbbw.zzaad().zzmf();
        }
        zzc zzzl = zzbbw.zzzl();
        if (zzzl != null) {
            zzzl.close();
            return;
        }
        zzc zzzm = zzbbw.zzzm();
        if (zzzm != null) {
            zzzm.close();
        } else {
            zzaug.zzeu("A GMSG tried to close something that wasn't an overlay.");
        }
    }
}
