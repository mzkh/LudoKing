package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzqh implements Comparator<zzqn> {
    zzqh(zzqi zzqi) {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzqn zzqn = (zzqn) obj;
        zzqn zzqn2 = (zzqn) obj2;
        int i = zzqn.zzbqf - zzqn2.zzbqf;
        if (i != 0) {
            return i;
        }
        return (int) (zzqn.value - zzqn2.value);
    }
}
