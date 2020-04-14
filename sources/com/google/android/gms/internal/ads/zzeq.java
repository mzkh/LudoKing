package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbo.zza.zzb;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzeq extends zzfl {
    private long startTime;

    public zzeq(zzdx zzdx, String str, String str2, zzb zzb, long j, int i, int i2) {
        super(zzdx, str, str2, zzb, i, 25);
        this.startTime = j;
    }

    /* access modifiers changed from: protected */
    public final void zzcu() throws IllegalAccessException, InvocationTargetException {
        long longValue = ((Long) this.zzaal.invoke(null, new Object[0])).longValue();
        synchronized (this.zzaaa) {
            this.zzaaa.zzbr(longValue);
            if (this.startTime != 0) {
                this.zzaaa.zzat(longValue - this.startTime);
                this.zzaaa.zzaw(this.startTime);
            }
        }
    }
}
