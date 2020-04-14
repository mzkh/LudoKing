package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzrh {
    /* access modifiers changed from: private */
    public final Object lock = new Object();
    private final Runnable zzbrb = new zzrk(this);
    /* access modifiers changed from: private */
    @GuardedBy("lock")
    @Nullable
    public zzrq zzbrc;
    /* access modifiers changed from: private */
    @GuardedBy("lock")
    @Nullable
    public zzru zzbrd;
    @GuardedBy("lock")
    @Nullable
    private Context zzlk;

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0047, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void initialize(android.content.Context r3) {
        /*
            r2 = this;
            if (r3 != 0) goto L_0x0003
            return
        L_0x0003:
            java.lang.Object r0 = r2.lock
            monitor-enter(r0)
            android.content.Context r1 = r2.zzlk     // Catch:{ all -> 0x0048 }
            if (r1 == 0) goto L_0x000c
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            return
        L_0x000c:
            android.content.Context r3 = r3.getApplicationContext()     // Catch:{ all -> 0x0048 }
            r2.zzlk = r3     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzyp<java.lang.Boolean> r3 = com.google.android.gms.internal.ads.zzza.zzcpo     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzyw r1 = com.google.android.gms.internal.ads.zzuv.zzon()     // Catch:{ all -> 0x0048 }
            java.lang.Object r3 = r1.zzd(r3)     // Catch:{ all -> 0x0048 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ all -> 0x0048 }
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x0048 }
            if (r3 == 0) goto L_0x0028
            r2.connect()     // Catch:{ all -> 0x0048 }
            goto L_0x0046
        L_0x0028:
            com.google.android.gms.internal.ads.zzyp<java.lang.Boolean> r3 = com.google.android.gms.internal.ads.zzza.zzcpn     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzyw r1 = com.google.android.gms.internal.ads.zzuv.zzon()     // Catch:{ all -> 0x0048 }
            java.lang.Object r3 = r1.zzd(r3)     // Catch:{ all -> 0x0048 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ all -> 0x0048 }
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x0048 }
            if (r3 == 0) goto L_0x0046
            com.google.android.gms.internal.ads.zzrj r3 = new com.google.android.gms.internal.ads.zzrj     // Catch:{ all -> 0x0048 }
            r3.<init>(r2)     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzpv r1 = com.google.android.gms.ads.internal.zzq.zzkm()     // Catch:{ all -> 0x0048 }
            r1.zza(r3)     // Catch:{ all -> 0x0048 }
        L_0x0046:
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            return
        L_0x0048:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzrh.initialize(android.content.Context):void");
    }

    public final void zzmh() {
        if (((Boolean) zzuv.zzon().zzd(zzza.zzcpp)).booleanValue()) {
            synchronized (this.lock) {
                connect();
                zzq.zzkj();
                zzaul.zzdsu.removeCallbacks(this.zzbrb);
                zzq.zzkj();
                zzaul.zzdsu.postDelayed(this.zzbrb, ((Long) zzuv.zzon().zzd(zzza.zzcpq)).longValue());
            }
        }
    }

    public final zzro zza(zzrp zzrp) {
        synchronized (this.lock) {
            if (this.zzbrd == null) {
                zzro zzro = new zzro();
                return zzro;
            }
            try {
                zzro zza = this.zzbrd.zza(zzrp);
                return zza;
            } catch (RemoteException e) {
                zzaug.zzc("Unable to call into cache service.", e);
                return new zzro();
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0024, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void connect() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.lock
            monitor-enter(r0)
            android.content.Context r1 = r3.zzlk     // Catch:{ all -> 0x0025 }
            if (r1 == 0) goto L_0x0023
            com.google.android.gms.internal.ads.zzrq r1 = r3.zzbrc     // Catch:{ all -> 0x0025 }
            if (r1 == 0) goto L_0x000c
            goto L_0x0023
        L_0x000c:
            com.google.android.gms.internal.ads.zzrm r1 = new com.google.android.gms.internal.ads.zzrm     // Catch:{ all -> 0x0025 }
            r1.<init>(r3)     // Catch:{ all -> 0x0025 }
            com.google.android.gms.internal.ads.zzrl r2 = new com.google.android.gms.internal.ads.zzrl     // Catch:{ all -> 0x0025 }
            r2.<init>(r3)     // Catch:{ all -> 0x0025 }
            com.google.android.gms.internal.ads.zzrq r1 = r3.zza(r1, r2)     // Catch:{ all -> 0x0025 }
            r3.zzbrc = r1     // Catch:{ all -> 0x0025 }
            com.google.android.gms.internal.ads.zzrq r1 = r3.zzbrc     // Catch:{ all -> 0x0025 }
            r1.checkAvailabilityAndConnect()     // Catch:{ all -> 0x0025 }
            monitor-exit(r0)     // Catch:{ all -> 0x0025 }
            return
        L_0x0023:
            monitor-exit(r0)     // Catch:{ all -> 0x0025 }
            return
        L_0x0025:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0025 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzrh.connect():void");
    }

    @VisibleForTesting
    private final synchronized zzrq zza(BaseConnectionCallbacks baseConnectionCallbacks, BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        return new zzrq(this.zzlk, zzq.zzkx().zzwd(), baseConnectionCallbacks, baseOnConnectionFailedListener);
    }

    /* access modifiers changed from: private */
    public final void disconnect() {
        synchronized (this.lock) {
            if (this.zzbrc != null) {
                if (this.zzbrc.isConnected() || this.zzbrc.isConnecting()) {
                    this.zzbrc.disconnect();
                }
                this.zzbrc = null;
                this.zzbrd = null;
                Binder.flushPendingCommands();
            }
        }
    }
}
