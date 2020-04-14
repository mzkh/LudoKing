package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzbyq<T> implements zzaer<Object> {
    private final WeakReference<T> zzfqa;
    private final String zzfqb;
    private final zzaer<T> zzfqc;
    private final /* synthetic */ zzbyh zzfqd;

    private zzbyq(zzbyh zzbyh, WeakReference<T> weakReference, String str, zzaer<T> zzaer) {
        this.zzfqd = zzbyh;
        this.zzfqa = weakReference;
        this.zzfqb = str;
        this.zzfqc = zzaer;
    }

    public final void zza(Object obj, Map<String, String> map) {
        Object obj2 = this.zzfqa.get();
        if (obj2 == null) {
            this.zzfqd.zzb(this.zzfqb, this);
        } else {
            this.zzfqc.zza(obj2, map);
        }
    }

    /* synthetic */ zzbyq(zzbyh zzbyh, WeakReference weakReference, String str, zzaer zzaer, zzbyi zzbyi) {
        this(zzbyh, weakReference, str, zzaer);
    }
}
