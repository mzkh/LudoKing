package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzcoe implements zzcrr {
    private final ArrayList zzgei;

    zzcoe(ArrayList arrayList) {
        this.zzgei = arrayList;
    }

    public final void zzr(Object obj) {
        ((Bundle) obj).putStringArrayList("ad_types", this.zzgei);
    }
}
