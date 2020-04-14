package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
final class zzdpo implements Comparator<zzdpm> {
    zzdpo() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzdpm zzdpm = (zzdpm) obj;
        zzdpm zzdpm2 = (zzdpm) obj2;
        zzdpv zzdpv = (zzdpv) zzdpm.iterator();
        zzdpv zzdpv2 = (zzdpv) zzdpm2.iterator();
        while (zzdpv.hasNext() && zzdpv2.hasNext()) {
            int compare = Integer.compare(zzdpm.zzb(zzdpv.nextByte()), zzdpm.zzb(zzdpv2.nextByte()));
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzdpm.size(), zzdpm2.size());
    }
}
