package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzbxa implements zzdal {
    static final zzdal zzdos = new zzbxa();

    private zzbxa() {
    }

    public final Object apply(Object obj) {
        List<zzbxc> list = (List) obj;
        ArrayList arrayList = new ArrayList();
        for (zzbxc zzbxc : list) {
            if (zzbxc != null) {
                arrayList.add(zzbxc);
            }
        }
        return arrayList;
    }
}
