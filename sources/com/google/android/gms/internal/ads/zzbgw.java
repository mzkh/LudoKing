package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbgw implements zzbgs {
    private final zzcvp zzfbb;

    public zzbgw(zzcvp zzcvp) {
        this.zzfbb = zzcvp;
    }

    public final void zzk(Map<String, String> map) {
        String str = (String) map.get("render_in_browser");
        if (!TextUtils.isEmpty(str)) {
            try {
                this.zzfbb.zzbd(Boolean.parseBoolean(str));
            } catch (Exception unused) {
                throw new IllegalStateException("Invalid render_in_browser state");
            }
        }
    }
}
