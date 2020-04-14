package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbo.zza.zzb;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzfd extends zzfl {
    private final StackTraceElement[] zzaag;

    public zzfd(zzdx zzdx, String str, String str2, zzb zzb, int i, int i2, StackTraceElement[] stackTraceElementArr) {
        super(zzdx, str, str2, zzb, i, 45);
        this.zzaag = stackTraceElementArr;
    }

    /* access modifiers changed from: protected */
    public final void zzcu() throws IllegalAccessException, InvocationTargetException {
        zzbz zzbz;
        if (this.zzaag != null) {
            zzdv zzdv = new zzdv((String) this.zzaal.invoke(null, new Object[]{this.zzaag}));
            synchronized (this.zzaaa) {
                this.zzaaa.zzbi(zzdv.zzxo.longValue());
                if (zzdv.zzxp.booleanValue()) {
                    zzb zzb = this.zzaaa;
                    if (zzdv.zzxq.booleanValue()) {
                        zzbz = zzbz.ENUM_FALSE;
                    } else {
                        zzbz = zzbz.ENUM_TRUE;
                    }
                    zzb.zzg(zzbz);
                } else {
                    this.zzaaa.zzg(zzbz.ENUM_FAILURE);
                }
            }
        }
    }
}
