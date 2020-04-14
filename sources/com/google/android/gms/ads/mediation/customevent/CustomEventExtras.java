package com.google.android.gms.ads.mediation.customevent;

import com.google.ads.mediation.NetworkExtras;
import java.util.HashMap;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class CustomEventExtras implements NetworkExtras {
    private final HashMap<String, Object> zzejr = new HashMap<>();

    public final Object getExtra(String str) {
        return this.zzejr.get(str);
    }

    public final void setExtra(String str, Object obj) {
        this.zzejr.put(str, obj);
    }
}
