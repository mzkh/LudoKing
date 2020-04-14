package com.google.android.gms.internal.ads;

import android.provider.Settings.SettingNotFoundException;
import com.google.android.gms.internal.ads.zzbo.zza.zzb;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzek extends zzfl {
    public zzek(zzdx zzdx, String str, String str2, zzb zzb, int i, int i2) {
        super(zzdx, str, str2, zzb, i, 49);
    }

    /* access modifiers changed from: protected */
    public final void zzcu() throws IllegalAccessException, InvocationTargetException {
        this.zzaaa.zzf(zzbz.ENUM_FAILURE);
        try {
            this.zzaaa.zzf(((Boolean) this.zzaal.invoke(null, new Object[]{this.zzvo.getContext()})).booleanValue() ? zzbz.ENUM_TRUE : zzbz.ENUM_FALSE);
        } catch (InvocationTargetException e) {
            if (!(e.getTargetException() instanceof SettingNotFoundException)) {
                throw e;
            }
        }
    }
}
