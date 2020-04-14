package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbay implements Iterable<zzbaw> {
    private final List<zzbaw> zzedg = new ArrayList();

    public static boolean zzc(zzazj zzazj) {
        zzbaw zzd = zzd(zzazj);
        if (zzd == null) {
            return false;
        }
        zzd.zzede.abort();
        return true;
    }

    static zzbaw zzd(zzazj zzazj) {
        Iterator it = zzq.zzlf().iterator();
        while (it.hasNext()) {
            zzbaw zzbaw = (zzbaw) it.next();
            if (zzbaw.zzdya == zzazj) {
                return zzbaw;
            }
        }
        return null;
    }

    public final void zza(zzbaw zzbaw) {
        this.zzedg.add(zzbaw);
    }

    public final void zzb(zzbaw zzbaw) {
        this.zzedg.remove(zzbaw);
    }

    public final Iterator<zzbaw> iterator() {
        return this.zzedg.iterator();
    }
}
