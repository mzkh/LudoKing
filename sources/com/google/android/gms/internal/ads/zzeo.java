package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbo.zza.zzb;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzeo extends zzfl {
    public zzeo(zzdx zzdx, String str, String str2, zzb zzb, int i, int i2) {
        super(zzdx, str, str2, zzb, i, 5);
    }

    /* access modifiers changed from: protected */
    public final void zzcu() throws IllegalAccessException, InvocationTargetException {
        this.zzaaa.zzam(-1);
        this.zzaaa.zzan(-1);
        int[] iArr = (int[]) this.zzaal.invoke(null, new Object[]{this.zzvo.getContext()});
        synchronized (this.zzaaa) {
            this.zzaaa.zzam((long) iArr[0]);
            this.zzaaa.zzan((long) iArr[1]);
            if (iArr[2] != Integer.MIN_VALUE) {
                this.zzaaa.zzbm((long) iArr[2]);
            }
        }
    }
}
