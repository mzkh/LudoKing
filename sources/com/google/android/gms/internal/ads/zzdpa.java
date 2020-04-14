package com.google.android.gms.internal.ads;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
final class zzdpa {
    private final ConcurrentHashMap<zzdoz, List<Throwable>> zzhfk = new ConcurrentHashMap<>(16, 0.75f, 10);
    private final ReferenceQueue<Throwable> zzhfl = new ReferenceQueue<>();

    zzdpa() {
    }

    public final List<Throwable> zza(Throwable th, boolean z) {
        Reference poll = this.zzhfl.poll();
        while (poll != null) {
            this.zzhfk.remove(poll);
            poll = this.zzhfl.poll();
        }
        List<Throwable> list = (List) this.zzhfk.get(new zzdoz(th, null));
        if (!z || list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List<Throwable> list2 = (List) this.zzhfk.putIfAbsent(new zzdoz(th, this.zzhfl), vector);
        return list2 == null ? vector : list2;
    }
}
