package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcqm implements zzcrr<Bundle> {
    private final String zzlt;

    /* access modifiers changed from: private */
    public static boolean zzd(Set<String> set) {
        return set.contains("rewarded") || set.contains("interstitial") || set.contains("native") || set.contains("banner");
    }

    public zzcqm(String str) {
        this.zzlt = str;
    }

    public final /* synthetic */ void zzr(Object obj) {
        zzcwk.zza((Bundle) obj, "omid_v", this.zzlt);
    }
}
