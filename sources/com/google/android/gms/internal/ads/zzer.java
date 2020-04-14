package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbo.zza.zzb;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzer extends zzfl {
    private static volatile Long zzzy;
    private static final Object zzzz = new Object();

    public zzer(zzdx zzdx, String str, String str2, zzb zzb, int i, int i2) {
        super(zzdx, str, str2, zzb, i, 44);
    }

    /* access modifiers changed from: protected */
    public final void zzcu() throws IllegalAccessException, InvocationTargetException {
        if (zzzy == null) {
            synchronized (zzzz) {
                if (zzzy == null) {
                    zzzy = (Long) this.zzaal.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.zzaaa) {
            this.zzaaa.zzbh(zzzy.longValue());
        }
    }
}
