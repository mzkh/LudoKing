package com.google.android.gms.internal.ads;

import android.support.p000v4.media.session.PlaybackStateCompat;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzjq {
    private final zzoc zzant = new zzoc(8);
    private int zzaqt;

    public final boolean zza(zziv zziv) throws IOException, InterruptedException {
        zziv zziv2 = zziv;
        long length = zziv.getLength();
        long j = PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        if (length != -1 && length <= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) {
            j = length;
        }
        int i = (int) j;
        zziv2.zza(this.zzant.data, 0, 4);
        this.zzaqt = 4;
        for (long zzio = this.zzant.zzio(); zzio != 440786851; zzio = ((zzio << 8) & -256) | ((long) (this.zzant.data[0] & 255))) {
            int i2 = this.zzaqt + 1;
            this.zzaqt = i2;
            if (i2 == i) {
                return false;
            }
            zziv2.zza(this.zzant.data, 0, 1);
        }
        long zzc = zzc(zziv);
        long j2 = (long) this.zzaqt;
        if (zzc != Long.MIN_VALUE && (length == -1 || j2 + zzc < length)) {
            while (true) {
                int i3 = this.zzaqt;
                long j3 = j2 + zzc;
                if (((long) i3) < j3) {
                    if (zzc(zziv) == Long.MIN_VALUE) {
                        return false;
                    }
                    long zzc2 = zzc(zziv);
                    if (zzc2 < 0 || zzc2 > 2147483647L) {
                        return false;
                    }
                    if (zzc2 != 0) {
                        zziv2.zzac((int) zzc2);
                        this.zzaqt = (int) (((long) this.zzaqt) + zzc2);
                    }
                } else if (((long) i3) == j3) {
                    return true;
                }
            }
        }
        return false;
    }

    private final long zzc(zziv zziv) throws IOException, InterruptedException {
        int i = 0;
        zziv.zza(this.zzant.data, 0, 1);
        byte b = this.zzant.data[0] & 255;
        if (b == 0) {
            return Long.MIN_VALUE;
        }
        int i2 = 128;
        int i3 = 0;
        while ((b & i2) == 0) {
            i2 >>= 1;
            i3++;
        }
        int i4 = b & (i2 ^ -1);
        zziv.zza(this.zzant.data, 1, i3);
        while (i < i3) {
            i++;
            i4 = (this.zzant.data[i] & 255) + (i4 << 8);
        }
        this.zzaqt += i3 + 1;
        return (long) i4;
    }
}
