package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzbwt implements zzdal {
    static final zzdal zzdos = new zzbwt();

    private zzbwt() {
    }

    public final Object apply(Object obj) {
        List<zzaau> list = (List) obj;
        ArrayList arrayList = new ArrayList();
        for (zzaau zzaau : list) {
            if (zzaau != null) {
                arrayList.add(zzaau);
            }
        }
        return arrayList;
    }
}
