package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcbl {
    private ConcurrentHashMap<String, String> zzfry;

    public zzcbl(zzcbo zzcbo) {
        this.zzfry = zzcbo.zzajw();
    }

    public final void zzb(zzcvz zzcvz) {
        if (zzcvz.zzgkb.zzgjx.size() > 0) {
            int i = ((zzcvr) zzcvz.zzgkb.zzgjx.get(0)).zzfis;
            String str = "ad_format";
            if (i == 1) {
                this.zzfry.put(str, "banner");
            } else if (i == 2) {
                this.zzfry.put(str, "interstitial");
            } else if (i == 3) {
                this.zzfry.put(str, "native_express");
            } else if (i == 4) {
                this.zzfry.put(str, "native_advanced");
            } else if (i != 5) {
                this.zzfry.put(str, "unknown");
            } else {
                this.zzfry.put(str, "rewarded");
            }
            if (!TextUtils.isEmpty(zzcvz.zzgkb.zzgjy.zzbzn)) {
                this.zzfry.put("gqi", zzcvz.zzgkb.zzgjy.zzbzn);
            }
        }
    }

    public final void zzi(Bundle bundle) {
        String str = "cnt";
        if (bundle.containsKey(str)) {
            this.zzfry.put("network_coarse", Integer.toString(bundle.getInt(str)));
        }
        String str2 = "gnt";
        if (bundle.containsKey(str2)) {
            this.zzfry.put("network_fine", Integer.toString(bundle.getInt(str2)));
        }
    }

    public final Map<String, String> zzqd() {
        return this.zzfry;
    }
}
