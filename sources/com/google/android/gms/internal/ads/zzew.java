package com.google.android.gms.internal.ads;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.internal.ads.zzbo.zza.zzb;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzew extends zzfl {
    private static volatile String zzaac;
    private static final Object zzzz = new Object();

    public zzew(zzdx zzdx, String str, String str2, zzb zzb, int i, int i2) {
        super(zzdx, str, str2, zzb, i, 1);
    }

    /* access modifiers changed from: protected */
    public final void zzcu() throws IllegalAccessException, InvocationTargetException {
        this.zzaaa.zzz(ExifInterface.LONGITUDE_EAST);
        if (zzaac == null) {
            synchronized (zzzz) {
                if (zzaac == null) {
                    zzaac = (String) this.zzaal.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.zzaaa) {
            this.zzaaa.zzz(zzaac);
        }
    }
}
