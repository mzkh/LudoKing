package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbo.zza.zzb;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzev extends zzfl {
    private static volatile Long zzaab;
    private static final Object zzzz = new Object();

    public zzev(zzdx zzdx, String str, String str2, zzb zzb, int i, int i2) {
        super(zzdx, str, str2, zzb, i, 22);
    }

    /* access modifiers changed from: protected */
    public final void zzcu() throws IllegalAccessException, InvocationTargetException {
        if (zzaab == null) {
            synchronized (zzzz) {
                if (zzaab == null) {
                    zzaab = (Long) this.zzaal.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.zzaaa) {
            this.zzaaa.zzav(zzaab.longValue());
        }
    }
}
