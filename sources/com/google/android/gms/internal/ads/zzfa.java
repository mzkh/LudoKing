package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbo.zza.zzb;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzfa extends zzfl {
    private final boolean zzaae;

    public zzfa(zzdx zzdx, String str, String str2, zzb zzb, int i, int i2) {
        super(zzdx, str, str2, zzb, i, 61);
        this.zzaae = zzdx.zzcl();
    }

    /* access modifiers changed from: protected */
    public final void zzcu() throws IllegalAccessException, InvocationTargetException {
        long longValue = ((Long) this.zzaal.invoke(null, new Object[]{this.zzvo.getContext(), Boolean.valueOf(this.zzaae)})).longValue();
        synchronized (this.zzaaa) {
            this.zzaaa.zzbo(longValue);
        }
    }
}
