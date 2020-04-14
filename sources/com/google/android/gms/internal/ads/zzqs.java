package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzqs implements Comparator<zzqg> {
    public zzqs(zzqp zzqp) {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzqg zzqg = (zzqg) obj;
        zzqg zzqg2 = (zzqg) obj2;
        if (zzqg.zzmb() < zzqg2.zzmb()) {
            return -1;
        }
        if (zzqg.zzmb() > zzqg2.zzmb()) {
            return 1;
        }
        if (zzqg.zzma() < zzqg2.zzma()) {
            return -1;
        }
        if (zzqg.zzma() > zzqg2.zzma()) {
            return 1;
        }
        float zzmd = (zzqg.zzmd() - zzqg.zzmb()) * (zzqg.zzmc() - zzqg.zzma());
        float zzmd2 = (zzqg2.zzmd() - zzqg2.zzmb()) * (zzqg2.zzmc() - zzqg2.zzma());
        if (zzmd > zzmd2) {
            return -1;
        }
        if (zzmd < zzmd2) {
            return 1;
        }
        return 0;
    }
}
