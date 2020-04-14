package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzawj {
    private Map<Integer, Bitmap> zzduu = new ConcurrentHashMap();
    private AtomicInteger zzduv = new AtomicInteger(0);

    public final Bitmap zza(Integer num) {
        return (Bitmap) this.zzduu.get(num);
    }
}
