package com.google.firebase.iid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.util.Log;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.appsflyer.share.Constants;
import java.util.ArrayDeque;
import java.util.Queue;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.firebase:firebase-iid@@19.0.1 */
public final class zzan {
    private static zzan zza;
    @GuardedBy("this")
    @Nullable
    private String zzb = null;
    private Boolean zzc = null;
    private Boolean zzd = null;
    private final Queue<Intent> zze = new ArrayDeque();

    public static synchronized zzan zza() {
        zzan zzan;
        synchronized (zzan.class) {
            if (zza == null) {
                zza = new zzan();
            }
            zzan = zza;
        }
        return zzan;
    }

    private zzan() {
    }

    @MainThread
    public final Intent zzb() {
        return (Intent) this.zze.poll();
    }

    @MainThread
    public final int zza(Context context, Intent intent) {
        String str = "FirebaseInstanceId";
        if (Log.isLoggable(str, 3)) {
            Log.d(str, "Starting service");
        }
        this.zze.offer(intent);
        Intent intent2 = new Intent("com.google.firebase.MESSAGING_EVENT");
        intent2.setPackage(context.getPackageName());
        return zzb(context, intent2);
    }

    private final int zzb(Context context, Intent intent) {
        ComponentName componentName;
        String zzc2 = zzc(context, intent);
        String str = "FirebaseInstanceId";
        if (zzc2 != null) {
            if (Log.isLoggable(str, 3)) {
                String str2 = "Restricting intent to a specific service: ";
                String valueOf = String.valueOf(zzc2);
                Log.d(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            }
            intent.setClassName(context.getPackageName(), zzc2);
        }
        try {
            if (zza(context)) {
                componentName = WakefulBroadcastReceiver.startWakefulService(context, intent);
            } else {
                componentName = context.startService(intent);
                Log.d(str, "Missing wake lock permission, service start may be delayed");
            }
            if (componentName != null) {
                return -1;
            }
            Log.e(str, "Error while delivering the message: ServiceIntent not found.");
            return 404;
        } catch (SecurityException e) {
            Log.e(str, "Error while delivering the message to the serviceIntent", e);
            return 401;
        } catch (IllegalStateException e2) {
            String valueOf2 = String.valueOf(e2);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf2).length() + 45);
            sb.append("Failed to start service while in background: ");
            sb.append(valueOf2);
            Log.e(str, sb.toString());
            return 402;
        }
    }

    @Nullable
    private final synchronized String zzc(Context context, Intent intent) {
        if (this.zzb != null) {
            return this.zzb;
        }
        ResolveInfo resolveService = context.getPackageManager().resolveService(intent, 0);
        if (resolveService != null) {
            if (resolveService.serviceInfo != null) {
                ServiceInfo serviceInfo = resolveService.serviceInfo;
                if (context.getPackageName().equals(serviceInfo.packageName)) {
                    if (serviceInfo.name != null) {
                        if (serviceInfo.name.startsWith(".")) {
                            String valueOf = String.valueOf(context.getPackageName());
                            String valueOf2 = String.valueOf(serviceInfo.name);
                            this.zzb = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
                        } else {
                            this.zzb = serviceInfo.name;
                        }
                        return this.zzb;
                    }
                }
                String str = "FirebaseInstanceId";
                String str2 = serviceInfo.packageName;
                String str3 = serviceInfo.name;
                StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 94 + String.valueOf(str3).length());
                sb.append("Error resolving target intent service, skipping classname enforcement. Resolved service was: ");
                sb.append(str2);
                sb.append(Constants.URL_PATH_DELIMITER);
                sb.append(str3);
                Log.e(str, sb.toString());
                return null;
            }
        }
        Log.e("FirebaseInstanceId", "Failed to resolve target intent service, skipping classname enforcement");
        return null;
    }

    /* access modifiers changed from: 0000 */
    public final boolean zza(Context context) {
        if (this.zzc == null) {
            this.zzc = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0);
        }
        if (!this.zzc.booleanValue()) {
            String str = "FirebaseInstanceId";
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "Missing Permission: android.permission.WAKE_LOCK this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
            }
        }
        return this.zzc.booleanValue();
    }

    /* access modifiers changed from: 0000 */
    public final boolean zzb(Context context) {
        if (this.zzd == null) {
            this.zzd = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0);
        }
        if (!this.zzc.booleanValue()) {
            String str = "FirebaseInstanceId";
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "Missing Permission: android.permission.ACCESS_NETWORK_STATE this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
            }
        }
        return this.zzd.booleanValue();
    }
}
