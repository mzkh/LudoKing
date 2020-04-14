package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import android.support.p000v4.media.session.PlaybackStateCompat;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzbo.zza;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-gass@@18.2.0 */
final class zzczc implements BaseConnectionCallbacks, BaseOnConnectionFailedListener {
    private final String packageName;
    private final HandlerThread zzduw = new HandlerThread("GassClient");
    @VisibleForTesting
    private zzczq zzgni;
    private final String zzgnj;
    private final LinkedBlockingQueue<zza> zzgnk;

    public zzczc(Context context, String str, String str2) {
        this.packageName = str;
        this.zzgnj = str2;
        this.zzduw.start();
        this.zzgni = new zzczq(context, this.zzduw.getLooper(), this, this);
        this.zzgnk = new LinkedBlockingQueue<>();
        this.zzgni.checkAvailabilityAndConnect();
    }

    public final zza zzdk(int i) {
        zza zza;
        try {
            zza = (zza) this.zzgnk.poll(5000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            zza = null;
        }
        return zza == null ? zzanv() : zza;
    }

    private final zzczx zzanu() {
        try {
            return this.zzgni.zzaob();
        } catch (DeadObjectException | IllegalStateException unused) {
            return null;
        }
    }

    public final void onConnectionSuspended(int i) {
        try {
            this.zzgnk.put(zzanv());
        } catch (InterruptedException unused) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0039, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003a, code lost:
        zzakj();
        r3.zzduw.quit();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0025, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        r3.zzgnk.put(zzanv());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0031, code lost:
        zzakj();
        r3.zzduw.quit();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0027 */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x0025 A[ExcHandler: all (r4v4 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:2:0x0006] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onConnected(android.os.Bundle r4) {
        /*
            r3 = this;
            com.google.android.gms.internal.ads.zzczx r4 = r3.zzanu()
            if (r4 == 0) goto L_0x0042
            com.google.android.gms.internal.ads.zzczt r0 = new com.google.android.gms.internal.ads.zzczt     // Catch:{ Throwable -> 0x0027, all -> 0x0025 }
            java.lang.String r1 = r3.packageName     // Catch:{ Throwable -> 0x0027, all -> 0x0025 }
            java.lang.String r2 = r3.zzgnj     // Catch:{ Throwable -> 0x0027, all -> 0x0025 }
            r0.<init>(r1, r2)     // Catch:{ Throwable -> 0x0027, all -> 0x0025 }
            com.google.android.gms.internal.ads.zzczv r4 = r4.zza(r0)     // Catch:{ Throwable -> 0x0027, all -> 0x0025 }
            com.google.android.gms.internal.ads.zzbo$zza r4 = r4.zzaoc()     // Catch:{ Throwable -> 0x0027, all -> 0x0025 }
            java.util.concurrent.LinkedBlockingQueue<com.google.android.gms.internal.ads.zzbo$zza> r0 = r3.zzgnk     // Catch:{ Throwable -> 0x0027, all -> 0x0025 }
            r0.put(r4)     // Catch:{ Throwable -> 0x0027, all -> 0x0025 }
            r3.zzakj()
            android.os.HandlerThread r4 = r3.zzduw
            r4.quit()
            return
        L_0x0025:
            r4 = move-exception
            goto L_0x0031
        L_0x0027:
            java.util.concurrent.LinkedBlockingQueue<com.google.android.gms.internal.ads.zzbo$zza> r4 = r3.zzgnk     // Catch:{ InterruptedException -> 0x003a, all -> 0x0025 }
            com.google.android.gms.internal.ads.zzbo$zza r0 = zzanv()     // Catch:{ InterruptedException -> 0x003a, all -> 0x0025 }
            r4.put(r0)     // Catch:{ InterruptedException -> 0x003a, all -> 0x0025 }
            goto L_0x003a
        L_0x0031:
            r3.zzakj()
            android.os.HandlerThread r0 = r3.zzduw
            r0.quit()
            throw r4
        L_0x003a:
            r3.zzakj()
            android.os.HandlerThread r4 = r3.zzduw
            r4.quit()
        L_0x0042:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzczc.onConnected(android.os.Bundle):void");
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        try {
            this.zzgnk.put(zzanv());
        } catch (InterruptedException unused) {
        }
    }

    private final void zzakj() {
        zzczq zzczq = this.zzgni;
        if (zzczq == null) {
            return;
        }
        if (zzczq.isConnected() || this.zzgni.isConnecting()) {
            this.zzgni.disconnect();
        }
    }

    @VisibleForTesting
    private static zza zzanv() {
        return (zza) ((zzdqw) zza.zzal().zzau(PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID).zzazr());
    }
}
