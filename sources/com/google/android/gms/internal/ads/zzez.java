package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbo.zza.zzb;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzez extends zzfl {
    public zzez(zzdx zzdx, String str, String str2, zzb zzb, int i, int i2) {
        super(zzdx, str, str2, zzb, i, 3);
    }

    /* access modifiers changed from: protected */
    public final void zzcu() throws IllegalAccessException, InvocationTargetException {
        boolean booleanValue = ((Boolean) zzuv.zzon().zzd(zzza.zzcnd)).booleanValue();
        zzdj zzdj = new zzdj((String) this.zzaal.invoke(null, new Object[]{this.zzvo.getContext(), Boolean.valueOf(booleanValue)}));
        synchronized (this.zzaaa) {
            this.zzaaa.zzal(zzdj.zzxe);
            this.zzaaa.zzbn(zzdj.zzxf);
        }
    }
}
