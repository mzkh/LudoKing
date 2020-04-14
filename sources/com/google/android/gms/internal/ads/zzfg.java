package com.google.android.gms.internal.ads;

import android.util.DisplayMetrics;
import android.view.View;
import com.google.android.gms.internal.ads.zzbo.zza.zzb;
import com.google.android.gms.internal.ads.zzbo.zza.zzf;
import com.google.android.gms.internal.ads.zzbo.zza.zzf.C3503zza;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzfg extends zzfl {
    private final View zzzs;

    public zzfg(zzdx zzdx, String str, String str2, zzb zzb, int i, int i2, View view) {
        super(zzdx, str, str2, zzb, i, 57);
        this.zzzs = view;
    }

    /* access modifiers changed from: protected */
    public final void zzcu() throws IllegalAccessException, InvocationTargetException {
        if (this.zzzs != null) {
            Boolean bool = (Boolean) zzuv.zzon().zzd(zzza.zzcno);
            DisplayMetrics displayMetrics = this.zzvo.getContext().getResources().getDisplayMetrics();
            zzeh zzeh = new zzeh((String) this.zzaal.invoke(null, new Object[]{this.zzzs, displayMetrics, bool}));
            C3503zza zzar = zzf.zzar();
            zzar.zzdc(zzeh.zzzm.longValue()).zzdd(zzeh.zzzn.longValue()).zzde(zzeh.zzzo.longValue());
            if (bool.booleanValue()) {
                zzar.zzdf(zzeh.zzzp.longValue());
            }
            this.zzaaa.zzb((zzf) ((zzdqw) zzar.zzazr()));
        }
    }
}
