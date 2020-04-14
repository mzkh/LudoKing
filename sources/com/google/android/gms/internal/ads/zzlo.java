package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzlo {
    private final zziy zzapk;
    private final zziw[] zzbaz;
    private zziw zzbba;

    public zzlo(zziw[] zziwArr, zziy zziy) {
        this.zzbaz = zziwArr;
        this.zzapk = zziy;
    }

    public final zziw zza(zziv zziv, Uri uri) throws IOException, InterruptedException {
        zziw zziw = this.zzbba;
        if (zziw != null) {
            return zziw;
        }
        zziw[] zziwArr = this.zzbaz;
        int length = zziwArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            zziw zziw2 = zziwArr[i];
            try {
                if (zziw2.zza(zziv)) {
                    this.zzbba = zziw2;
                    zziv.zzgb();
                    break;
                }
                i++;
            } catch (EOFException unused) {
            } finally {
                zziv.zzgb();
            }
        }
        zziw zziw3 = this.zzbba;
        if (zziw3 != null) {
            zziw3.zza(this.zzapk);
            return this.zzbba;
        }
        String zza = zzof.zza((Object[]) this.zzbaz);
        StringBuilder sb = new StringBuilder(String.valueOf(zza).length() + 58);
        sb.append("None of the available extractors (");
        sb.append(zza);
        sb.append(") could read the stream.");
        throw new zzmj(sb.toString(), uri);
    }

    public final void release() {
        zziw zziw = this.zzbba;
        if (zziw != null) {
            zziw.release();
            this.zzbba = null;
        }
    }
}
