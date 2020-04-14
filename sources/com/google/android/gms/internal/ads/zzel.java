package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.View;
import com.google.android.gms.internal.ads.zzbo.zza.zzb;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzel extends zzfl {
    private final Activity zzzr;
    private final View zzzs;

    public zzel(zzdx zzdx, String str, String str2, zzb zzb, int i, int i2, View view, Activity activity) {
        super(zzdx, str, str2, zzb, i, 62);
        this.zzzs = view;
        this.zzzr = activity;
    }

    /* access modifiers changed from: protected */
    public final void zzcu() throws IllegalAccessException, InvocationTargetException {
        if (this.zzzs != null) {
            boolean booleanValue = ((Boolean) zzuv.zzon().zzd(zzza.zzcna)).booleanValue();
            Object[] objArr = (Object[]) this.zzaal.invoke(null, new Object[]{this.zzzs, this.zzzr, Boolean.valueOf(booleanValue)});
            synchronized (this.zzaaa) {
                this.zzaaa.zzbp(((Long) objArr[0]).longValue());
                this.zzaaa.zzbq(((Long) objArr[1]).longValue());
                if (booleanValue) {
                    this.zzaaa.zzag((String) objArr[2]);
                }
            }
        }
    }
}
