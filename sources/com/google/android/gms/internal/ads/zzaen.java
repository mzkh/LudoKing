package com.google.android.gms.internal.ads;

import com.facebook.internal.NativeProtocol;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzaen implements zzaer<zzbbw> {
    zzaen() {
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzbbw zzbbw = (zzbbw) obj;
        String str = (String) map.get(NativeProtocol.WEB_DIALOG_ACTION);
        if ("pause".equals(str)) {
            zzbbw.zzjp();
            return;
        }
        if ("resume".equals(str)) {
            zzbbw.zzjq();
        }
    }
}
