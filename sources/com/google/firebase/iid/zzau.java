package com.google.firebase.iid;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.IOException;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-iid@@19.0.1 */
final class zzau {
    @GuardedBy("this")
    private int zza = 0;
    @GuardedBy("this")
    private final Map<Integer, TaskCompletionSource<Void>> zzb = new ArrayMap();
    @GuardedBy("itself")
    private final zzaq zzc;

    zzau(zzaq zzaq) {
        this.zzc = zzaq;
    }

    /* access modifiers changed from: 0000 */
    public final synchronized Task<Void> zza(String str) {
        String zza2;
        TaskCompletionSource taskCompletionSource;
        int i;
        synchronized (this.zzc) {
            zza2 = this.zzc.zza();
            zzaq zzaq = this.zzc;
            StringBuilder sb = new StringBuilder(String.valueOf(zza2).length() + 1 + String.valueOf(str).length());
            sb.append(zza2);
            sb.append(",");
            sb.append(str);
            zzaq.zza(sb.toString());
        }
        taskCompletionSource = new TaskCompletionSource();
        Map<Integer, TaskCompletionSource<Void>> map = this.zzb;
        if (TextUtils.isEmpty(zza2)) {
            i = 0;
        } else {
            i = zza2.split(",").length - 1;
        }
        map.put(Integer.valueOf(this.zza + i), taskCompletionSource);
        return taskCompletionSource.getTask();
    }

    /* access modifiers changed from: 0000 */
    public final synchronized boolean zza() {
        return zzb() != null;
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        if (zza(r5, r0) != false) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001f, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0020, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r2 = (com.google.android.gms.tasks.TaskCompletionSource) r4.zzb.remove(java.lang.Integer.valueOf(r4.zza));
        zzb(r0);
        r4.zza++;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0037, code lost:
        monitor-exit(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0038, code lost:
        if (r2 == null) goto L_0x0000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003a, code lost:
        r2.setResult(null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0016, code lost:
        return true;
     */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(com.google.firebase.iid.FirebaseInstanceId r5) throws java.io.IOException {
        /*
            r4 = this;
        L_0x0000:
            monitor-enter(r4)
            java.lang.String r0 = r4.zzb()     // Catch:{ all -> 0x0042 }
            r1 = 1
            if (r0 != 0) goto L_0x0017
            boolean r5 = com.google.firebase.iid.FirebaseInstanceId.zzd()     // Catch:{ all -> 0x0042 }
            if (r5 == 0) goto L_0x0015
            java.lang.String r5 = "FirebaseInstanceId"
            java.lang.String r0 = "topic sync succeeded"
            android.util.Log.d(r5, r0)     // Catch:{ all -> 0x0042 }
        L_0x0015:
            monitor-exit(r4)     // Catch:{ all -> 0x0042 }
            return r1
        L_0x0017:
            monitor-exit(r4)     // Catch:{ all -> 0x0042 }
            boolean r2 = zza(r5, r0)
            if (r2 != 0) goto L_0x0020
            r5 = 0
            return r5
        L_0x0020:
            monitor-enter(r4)
            java.util.Map<java.lang.Integer, com.google.android.gms.tasks.TaskCompletionSource<java.lang.Void>> r2 = r4.zzb     // Catch:{ all -> 0x003f }
            int r3 = r4.zza     // Catch:{ all -> 0x003f }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x003f }
            java.lang.Object r2 = r2.remove(r3)     // Catch:{ all -> 0x003f }
            com.google.android.gms.tasks.TaskCompletionSource r2 = (com.google.android.gms.tasks.TaskCompletionSource) r2     // Catch:{ all -> 0x003f }
            r4.zzb(r0)     // Catch:{ all -> 0x003f }
            int r0 = r4.zza     // Catch:{ all -> 0x003f }
            int r0 = r0 + r1
            r4.zza = r0     // Catch:{ all -> 0x003f }
            monitor-exit(r4)     // Catch:{ all -> 0x003f }
            if (r2 == 0) goto L_0x0000
            r0 = 0
            r2.setResult(r0)
            goto L_0x0000
        L_0x003f:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x003f }
            throw r5
        L_0x0042:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0042 }
            throw r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzau.zza(com.google.firebase.iid.FirebaseInstanceId):boolean");
    }

    @GuardedBy("this")
    @Nullable
    private final String zzb() {
        String zza2;
        synchronized (this.zzc) {
            zza2 = this.zzc.zza();
        }
        if (!TextUtils.isEmpty(zza2)) {
            String[] split = zza2.split(",");
            if (split.length > 1 && !TextUtils.isEmpty(split[1])) {
                return split[1];
            }
        }
        return null;
    }

    private final synchronized boolean zzb(String str) {
        synchronized (this.zzc) {
            String zza2 = this.zzc.zza();
            String str2 = ",";
            String valueOf = String.valueOf(str);
            if (!zza2.startsWith(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2))) {
                return false;
            }
            String str3 = ",";
            String valueOf2 = String.valueOf(str);
            this.zzc.zza(zza2.substring((valueOf2.length() != 0 ? str3.concat(valueOf2) : new String(str3)).length()));
            return true;
        }
    }

    @WorkerThread
    private static boolean zza(FirebaseInstanceId firebaseInstanceId, String str) throws IOException {
        String str2 = "FirebaseInstanceId";
        String[] split = str.split("!");
        if (split.length == 2) {
            String str3 = split[0];
            String str4 = split[1];
            char c = 65535;
            try {
                int hashCode = str3.hashCode();
                if (hashCode != 83) {
                    if (hashCode == 85) {
                        if (str3.equals("U")) {
                            c = 1;
                        }
                    }
                } else if (str3.equals(ExifInterface.LATITUDE_SOUTH)) {
                    c = 0;
                }
                if (c == 0) {
                    firebaseInstanceId.zzb(str4);
                    if (FirebaseInstanceId.zzd()) {
                        Log.d(str2, "subscribe operation succeeded");
                    }
                } else if (c == 1) {
                    firebaseInstanceId.zzc(str4);
                    if (FirebaseInstanceId.zzd()) {
                        Log.d(str2, "unsubscribe operation succeeded");
                    }
                }
            } catch (IOException e) {
                if (!"SERVICE_NOT_AVAILABLE".equals(e.getMessage())) {
                    if (!"INTERNAL_SERVER_ERROR".equals(e.getMessage())) {
                        if (e.getMessage() == null) {
                            Log.e(str2, "Topic operation failed without exception message. Will retry Topic operation.");
                            return false;
                        }
                        throw e;
                    }
                }
                String message = e.getMessage();
                StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 53);
                sb.append("Topic operation failed: ");
                sb.append(message);
                sb.append(". Will retry Topic operation.");
                Log.e(str2, sb.toString());
                return false;
            }
        }
        return true;
    }
}
