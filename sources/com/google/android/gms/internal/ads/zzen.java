package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.internal.ads.zzbo.zza.zzb;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzen extends zzfl {
    private static zzfk<String> zzzw = new zzfk<>();
    private final Context zzzu;

    public zzen(zzdx zzdx, String str, String str2, zzb zzb, int i, int i2, Context context) {
        super(zzdx, str, str2, zzb, i, 29);
        this.zzzu = context;
    }

    /* access modifiers changed from: protected */
    public final void zzcu() throws IllegalAccessException, InvocationTargetException {
        this.zzaaa.zzac(ExifInterface.LONGITUDE_EAST);
        AtomicReference zzau = zzzw.zzau(this.zzzu.getPackageName());
        if (zzau.get() == null) {
            synchronized (zzau) {
                if (zzau.get() == null) {
                    zzau.set((String) this.zzaal.invoke(null, new Object[]{this.zzzu}));
                }
            }
        }
        String str = (String) zzau.get();
        synchronized (this.zzaaa) {
            this.zzaaa.zzac(zzcg.zza(str.getBytes(), true));
        }
    }
}
