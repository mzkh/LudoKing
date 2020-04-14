package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
final class zzdsc implements zzdrz {
    zzdsc() {
    }

    public final Map<?, ?> zzan(Object obj) {
        return (zzdsa) obj;
    }

    public final zzdrx<?, ?> zzas(Object obj) {
        throw new NoSuchMethodError();
    }

    public final Map<?, ?> zzao(Object obj) {
        return (zzdsa) obj;
    }

    public final boolean zzap(Object obj) {
        return !((zzdsa) obj).isMutable();
    }

    public final Object zzaq(Object obj) {
        ((zzdsa) obj).zzaxj();
        return obj;
    }

    public final Object zzar(Object obj) {
        return zzdsa.zzbas().zzbat();
    }

    public final Object zze(Object obj, Object obj2) {
        zzdsa zzdsa = (zzdsa) obj;
        zzdsa zzdsa2 = (zzdsa) obj2;
        if (!zzdsa2.isEmpty()) {
            if (!zzdsa.isMutable()) {
                zzdsa = zzdsa.zzbat();
            }
            zzdsa.zza(zzdsa2);
        }
        return zzdsa;
    }

    public final int zzb(int i, Object obj, Object obj2) {
        zzdsa zzdsa = (zzdsa) obj;
        if (zzdsa.isEmpty()) {
            return 0;
        }
        Iterator it = zzdsa.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Entry entry = (Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}
