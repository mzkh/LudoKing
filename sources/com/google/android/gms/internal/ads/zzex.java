package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbo.zza.zzb;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzex extends zzfl {
    private long zzaad = -1;

    public zzex(zzdx zzdx, String str, String str2, zzb zzb, int i, int i2) {
        super(zzdx, str, str2, zzb, i, 12);
    }

    /* access modifiers changed from: protected */
    public final void zzcu() throws IllegalAccessException, InvocationTargetException {
        this.zzaaa.zzap(-1);
        this.zzaaa.zzap(((Long) this.zzaal.invoke(null, new Object[]{this.zzvo.getContext()})).longValue());
    }
}
