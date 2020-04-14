package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import androidx.annotation.GuardedBy;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.drive.DriveFile;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzapv extends ContextWrapper {
    @GuardedBy("this")
    private Context zzdnt;
    @GuardedBy("this")
    private WeakReference<Activity> zzdnu = new WeakReference<>(null);

    private zzapv(Context context) {
        super(context);
    }

    public final Context getApplicationContext() {
        return this;
    }

    public final synchronized void setAppPackageName(String str) throws NameNotFoundException {
        this.zzdnt = super.createPackageContext(str, 0);
    }

    public final synchronized ApplicationInfo getApplicationInfo() {
        if (this.zzdnt != null) {
            return this.zzdnt.getApplicationInfo();
        }
        return super.getApplicationInfo();
    }

    public final synchronized String getPackageName() {
        if (this.zzdnt != null) {
            return this.zzdnt.getPackageName();
        }
        return super.getPackageName();
    }

    public final synchronized String getPackageResourcePath() {
        if (this.zzdnt != null) {
            return this.zzdnt.getPackageResourcePath();
        }
        return super.getPackageResourcePath();
    }

    public final synchronized void startActivity(Intent intent) {
        zze(zzd(intent));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0038, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized android.content.Intent zzd(android.content.Intent r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            android.content.Context r0 = r2.zzdnt     // Catch:{ all -> 0x0039 }
            if (r0 == 0) goto L_0x0037
            android.content.ComponentName r0 = r3.getComponent()     // Catch:{ all -> 0x0039 }
            if (r0 == 0) goto L_0x0037
            android.content.ComponentName r0 = r3.getComponent()     // Catch:{ all -> 0x0039 }
            java.lang.String r0 = r0.getPackageName()     // Catch:{ all -> 0x0039 }
            android.content.Context r1 = r2.zzdnt     // Catch:{ all -> 0x0039 }
            java.lang.String r1 = r1.getPackageName()     // Catch:{ all -> 0x0039 }
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x0039 }
            if (r0 != 0) goto L_0x0020
            goto L_0x0037
        L_0x0020:
            java.lang.Object r0 = r3.clone()     // Catch:{ all -> 0x0039 }
            android.content.Intent r0 = (android.content.Intent) r0     // Catch:{ all -> 0x0039 }
            java.lang.String r1 = super.getPackageName()     // Catch:{ all -> 0x0039 }
            android.content.ComponentName r3 = r3.getComponent()     // Catch:{ all -> 0x0039 }
            java.lang.String r3 = r3.getClassName()     // Catch:{ all -> 0x0039 }
            r0.setClassName(r1, r3)     // Catch:{ all -> 0x0039 }
            monitor-exit(r2)
            return r0
        L_0x0037:
            monitor-exit(r2)
            return r3
        L_0x0039:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzapv.zzd(android.content.Intent):android.content.Intent");
    }

    private final synchronized void zze(Intent intent) {
        Activity activity = (Activity) this.zzdnu.get();
        if (activity == null) {
            intent.addFlags(DriveFile.MODE_READ_ONLY);
            super.startActivity(intent);
            return;
        }
        try {
            Intent intent2 = (Intent) intent.clone();
            intent2.setFlags(intent.getFlags() & -268435457);
            activity.startActivity(intent2);
        } catch (Throwable th) {
            zzq.zzkn().zza(th, "");
            intent.addFlags(DriveFile.MODE_READ_ONLY);
            super.startActivity(intent);
        }
    }

    public static zzapv zzz(Context context) {
        return new zzapv(zzl(context));
    }

    public static Context zzaa(Context context) {
        if (context instanceof zzapv) {
            return ((zzapv) context).getBaseContext();
        }
        return zzl(context);
    }

    private static Context zzl(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }
}
