package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbo.zza.zzb;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzff extends zzfl {
    private final zzeg zzws;
    private long zzzl;

    public zzff(zzdx zzdx, String str, String str2, zzb zzb, int i, int i2, zzeg zzeg) {
        super(zzdx, str, str2, zzb, i, 53);
        this.zzws = zzeg;
        if (zzeg != null) {
            this.zzzl = zzeg.zzcs();
        }
    }

    /* access modifiers changed from: protected */
    public final void zzcu() throws IllegalAccessException, InvocationTargetException {
        if (this.zzws != null) {
            this.zzaaa.zzbl(((Long) this.zzaal.invoke(null, new Object[]{Long.valueOf(this.zzzl)})).longValue());
        }
    }
}
