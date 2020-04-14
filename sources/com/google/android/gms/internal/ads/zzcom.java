package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzcom implements zzcrr {
    private final ArrayList zzgei;

    zzcom(ArrayList arrayList) {
        this.zzgei = arrayList;
    }

    public final void zzr(Object obj) {
        ((Bundle) obj).putStringArrayList("android_permissions", this.zzgei);
    }
}
