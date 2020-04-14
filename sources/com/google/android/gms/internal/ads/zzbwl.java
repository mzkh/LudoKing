package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.os.Looper;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbwl {
    private final Executor executor;
    private final Clock zzbmp;
    private final zzavy zzfnz;

    public zzbwl(zzavy zzavy, Clock clock, Executor executor2) {
        this.zzfnz = zzavy;
        this.zzbmp = clock;
        this.executor = executor2;
    }

    public final zzddi<Bitmap> zza(String str, double d, boolean z) {
        return zzdcy.zzb(zzavy.zzel(str), (zzdal<? super I, ? extends O>) new zzbwk<Object,Object>(this, d, z), this.executor);
    }

    /* access modifiers changed from: private */
    public final Bitmap zza(byte[] bArr, double d, boolean z) {
        Options options = new Options();
        options.inDensity = (int) (d * 160.0d);
        if (!z) {
            options.inPreferredConfig = Config.RGB_565;
        }
        if (((Boolean) zzuv.zzon().zzd(zzza.zzcsv)).booleanValue()) {
            options.inJustDecodeBounds = true;
            zza(bArr, options);
            options.inJustDecodeBounds = false;
            int i = options.outWidth * options.outHeight;
            if (i > 0) {
                int i2 = i - 1;
                options.inSampleSize = 1 << ((33 - Integer.numberOfLeadingZeros(i2 / ((Integer) zzuv.zzon().zzd(zzza.zzcsw)).intValue())) / 2);
            }
        }
        return zza(bArr, options);
    }

    private final Bitmap zza(byte[] bArr, Options options) {
        long elapsedRealtime = this.zzbmp.elapsedRealtime();
        boolean z = false;
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        long elapsedRealtime2 = this.zzbmp.elapsedRealtime();
        if (VERSION.SDK_INT >= 19 && decodeByteArray != null) {
            int width = decodeByteArray.getWidth();
            int height = decodeByteArray.getHeight();
            int allocationByteCount = decodeByteArray.getAllocationByteCount();
            long j = elapsedRealtime2 - elapsedRealtime;
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                z = true;
            }
            StringBuilder sb = new StringBuilder(108);
            sb.append("Decoded image w: ");
            sb.append(width);
            sb.append(" h:");
            sb.append(height);
            sb.append(" bytes: ");
            sb.append(allocationByteCount);
            sb.append(" time: ");
            sb.append(j);
            sb.append(" on ui thread: ");
            sb.append(z);
            zzaug.zzdy(sb.toString());
        }
        return decodeByteArray;
    }
}
