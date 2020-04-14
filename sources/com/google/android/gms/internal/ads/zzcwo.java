package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcwo {
    public static ParcelFileDescriptor zze(InputStream inputStream) throws IOException {
        ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
        ParcelFileDescriptor parcelFileDescriptor = createPipe[0];
        zzaxn.zzdwi.execute(new zzcwn(inputStream, createPipe[1]));
        return parcelFileDescriptor;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x002a, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x002f, code lost:
        if (r4 != null) goto L_0x0031;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        zza(r0, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0034, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0035, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:8:0x000e, B:29:0x002e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static final /* synthetic */ void zza(java.io.InputStream r4, android.os.ParcelFileDescriptor r5) {
        /*
            r0 = 0
            android.os.ParcelFileDescriptor$AutoCloseOutputStream r1 = new android.os.ParcelFileDescriptor$AutoCloseOutputStream     // Catch:{ Throwable -> 0x002c }
            r1.<init>(r5)     // Catch:{ Throwable -> 0x002c }
            com.google.android.gms.common.util.IOUtils.copyStream(r4, r1)     // Catch:{ Throwable -> 0x0015, all -> 0x0012 }
            r1.close()     // Catch:{ Throwable -> 0x002c }
            if (r4 == 0) goto L_0x0011
            zza(r0, r4)     // Catch:{ IOException -> 0x0035 }
        L_0x0011:
            return
        L_0x0012:
            r5 = move-exception
            r2 = r0
            goto L_0x001b
        L_0x0015:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x0017 }
        L_0x0017:
            r2 = move-exception
            r3 = r2
            r2 = r5
            r5 = r3
        L_0x001b:
            if (r2 == 0) goto L_0x0026
            r1.close()     // Catch:{ Throwable -> 0x0021 }
            goto L_0x0029
        L_0x0021:
            r1 = move-exception
            com.google.android.gms.internal.ads.zzdoy.zza(r2, r1)     // Catch:{ Throwable -> 0x002c }
            goto L_0x0029
        L_0x0026:
            r1.close()     // Catch:{ Throwable -> 0x002c }
        L_0x0029:
            throw r5     // Catch:{ Throwable -> 0x002c }
        L_0x002a:
            r5 = move-exception
            goto L_0x002f
        L_0x002c:
            r5 = move-exception
            r0 = r5
            throw r0     // Catch:{ all -> 0x002a }
        L_0x002f:
            if (r4 == 0) goto L_0x0034
            zza(r0, r4)     // Catch:{ IOException -> 0x0035 }
        L_0x0034:
            throw r5     // Catch:{ IOException -> 0x0035 }
        L_0x0035:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcwo.zza(java.io.InputStream, android.os.ParcelFileDescriptor):void");
    }

    private static /* synthetic */ void zza(Throwable th, InputStream inputStream) {
        if (th != null) {
            try {
                inputStream.close();
            } catch (Throwable th2) {
                zzdoy.zza(th, th2);
            }
        } else {
            inputStream.close();
        }
    }
}
