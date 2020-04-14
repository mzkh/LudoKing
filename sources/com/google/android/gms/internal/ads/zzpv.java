package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.PlatformVersion;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzpv {
    private final Object zzbox = new Object();
    @GuardedBy("activityTrackerLock")
    private zzpy zzboy = null;
    @GuardedBy("activityTrackerLock")
    private boolean zzboz = false;

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void initialize(android.content.Context r5) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.zzbox
            monitor-enter(r0)
            boolean r1 = r4.zzboz     // Catch:{ all -> 0x003c }
            if (r1 != 0) goto L_0x003a
            boolean r1 = com.google.android.gms.common.util.PlatformVersion.isAtLeastIceCreamSandwich()     // Catch:{ all -> 0x003c }
            if (r1 != 0) goto L_0x000f
            monitor-exit(r0)     // Catch:{ all -> 0x003c }
            return
        L_0x000f:
            r1 = 0
            android.content.Context r2 = r5.getApplicationContext()     // Catch:{ all -> 0x003c }
            if (r2 != 0) goto L_0x0017
            r2 = r5
        L_0x0017:
            boolean r3 = r2 instanceof android.app.Application     // Catch:{ all -> 0x003c }
            if (r3 == 0) goto L_0x001e
            r1 = r2
            android.app.Application r1 = (android.app.Application) r1     // Catch:{ all -> 0x003c }
        L_0x001e:
            if (r1 != 0) goto L_0x0027
            java.lang.String r5 = "Can not cast Context to Application"
            com.google.android.gms.internal.ads.zzaug.zzeu(r5)     // Catch:{ all -> 0x003c }
            monitor-exit(r0)     // Catch:{ all -> 0x003c }
            return
        L_0x0027:
            com.google.android.gms.internal.ads.zzpy r2 = r4.zzboy     // Catch:{ all -> 0x003c }
            if (r2 != 0) goto L_0x0032
            com.google.android.gms.internal.ads.zzpy r2 = new com.google.android.gms.internal.ads.zzpy     // Catch:{ all -> 0x003c }
            r2.<init>()     // Catch:{ all -> 0x003c }
            r4.zzboy = r2     // Catch:{ all -> 0x003c }
        L_0x0032:
            com.google.android.gms.internal.ads.zzpy r2 = r4.zzboy     // Catch:{ all -> 0x003c }
            r2.zza(r1, r5)     // Catch:{ all -> 0x003c }
            r5 = 1
            r4.zzboz = r5     // Catch:{ all -> 0x003c }
        L_0x003a:
            monitor-exit(r0)     // Catch:{ all -> 0x003c }
            return
        L_0x003c:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003c }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpv.initialize(android.content.Context):void");
    }

    public final void zza(zzqa zzqa) {
        synchronized (this.zzbox) {
            if (PlatformVersion.isAtLeastIceCreamSandwich()) {
                if (this.zzboy == null) {
                    this.zzboy = new zzpy();
                }
                this.zzboy.zza(zzqa);
            }
        }
    }

    public final void zzb(zzqa zzqa) {
        synchronized (this.zzbox) {
            if (this.zzboy != null) {
                this.zzboy.zzb(zzqa);
            }
        }
    }

    @Nullable
    public final Activity getActivity() {
        synchronized (this.zzbox) {
            if (!PlatformVersion.isAtLeastIceCreamSandwich()) {
                return null;
            }
            if (this.zzboy == null) {
                return null;
            }
            Activity activity = this.zzboy.getActivity();
            return activity;
        }
    }

    @Nullable
    public final Context getContext() {
        synchronized (this.zzbox) {
            if (!PlatformVersion.isAtLeastIceCreamSandwich()) {
                return null;
            }
            if (this.zzboy == null) {
                return null;
            }
            Context context = this.zzboy.getContext();
            return context;
        }
    }
}
