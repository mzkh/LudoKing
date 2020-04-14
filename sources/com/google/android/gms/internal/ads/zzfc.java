package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbo.zza.zzb;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzfc extends zzfl {
    public zzfc(zzdx zzdx, String str, String str2, zzb zzb, int i, int i2) {
        super(zzdx, str, str2, zzb, i, 51);
    }

    /* access modifiers changed from: protected */
    public final void zzcu() throws IllegalAccessException, InvocationTargetException {
        synchronized (this.zzaaa) {
            zzdy zzdy = new zzdy((String) this.zzaal.invoke(null, new Object[0]));
            this.zzaaa.zzbj(zzdy.zzyh.longValue());
            this.zzaaa.zzbk(zzdy.zzyi.longValue());
        }
    }
}
