package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbo.zza.zzb;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzfh extends zzfl {
    public zzfh(zzdx zzdx, String str, String str2, zzb zzb, int i, int i2) {
        super(zzdx, str, str2, zzb, i, 48);
    }

    /* access modifiers changed from: protected */
    public final void zzcu() throws IllegalAccessException, InvocationTargetException {
        this.zzaaa.zze(zzbz.ENUM_FAILURE);
        boolean booleanValue = ((Boolean) this.zzaal.invoke(null, new Object[]{this.zzvo.getContext()})).booleanValue();
        synchronized (this.zzaaa) {
            if (booleanValue) {
                this.zzaaa.zze(zzbz.ENUM_TRUE);
            } else {
                this.zzaaa.zze(zzbz.ENUM_FALSE);
            }
        }
    }
}
