package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbo.zza.zzb;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzfb extends zzfl {
    private List<Long> zzaaf = null;

    public zzfb(zzdx zzdx, String str, String str2, zzb zzb, int i, int i2) {
        super(zzdx, str, str2, zzb, i, 31);
    }

    /* access modifiers changed from: protected */
    public final void zzcu() throws IllegalAccessException, InvocationTargetException {
        this.zzaaa.zzax(-1);
        this.zzaaa.zzay(-1);
        if (this.zzaaf == null) {
            this.zzaaf = (List) this.zzaal.invoke(null, new Object[]{this.zzvo.getContext()});
        }
        List<Long> list = this.zzaaf;
        if (list != null && list.size() == 2) {
            synchronized (this.zzaaa) {
                this.zzaaa.zzax(((Long) this.zzaaf.get(0)).longValue());
                this.zzaaa.zzay(((Long) this.zzaaf.get(1)).longValue());
            }
        }
    }
}
