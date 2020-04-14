package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.content.ContextCompat;
import com.google.android.gms.internal.firebase_messaging.zzn;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Properties;

/* compiled from: com.google.firebase:firebase-iid@@19.0.1 */
final class zzp {
    zzp() {
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final zzr zza(Context context, String str) throws zzs {
        zzr zzc = zzc(context, str);
        if (zzc != null) {
            return zzc;
        }
        return zzb(context, str);
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final zzr zzb(Context context, String str) {
        zzr zzr = new zzr(zzaf.zza(zza.zza().getPublic()), System.currentTimeMillis());
        zzr zza = zza(context, str, zzr, true);
        String str2 = "FirebaseInstanceId";
        if (zza == null || zza.equals(zzr)) {
            if (Log.isLoggable(str2, 3)) {
                Log.d(str2, "Generated new key");
            }
            zza(context, str, zzr);
            return zzr;
        }
        if (Log.isLoggable(str2, 3)) {
            Log.d(str2, "Loaded key after generating new one, using loaded one");
        }
        return zza;
    }

    static void zza(Context context) {
        File[] listFiles;
        for (File file : zzb(context).listFiles()) {
            if (file.getName().startsWith("com.google.InstanceId")) {
                file.delete();
            }
        }
    }

    @Nullable
    private final zzr zzc(Context context, String str) throws zzs {
        try {
            zzr zzd = zzd(context, str);
            if (zzd != null) {
                zza(context, str, zzd);
                return zzd;
            }
            e = null;
            try {
                zzr zza = zza(context.getSharedPreferences("com.google.android.gms.appid", 0), str);
                if (zza != null) {
                    zza(context, str, zza, false);
                    return zza;
                }
            } catch (zzs e) {
                e = e;
            }
            if (e == null) {
                return null;
            }
            throw e;
        } catch (zzs e2) {
            e = e2;
        }
    }

    private static PublicKey zza(String str) throws zzs {
        try {
            try {
                return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 8)));
            } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
                String valueOf = String.valueOf(e);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 19);
                sb.append("Invalid key stored ");
                sb.append(valueOf);
                Log.w("FirebaseInstanceId", sb.toString());
                throw new zzs((Exception) e);
            }
        } catch (IllegalArgumentException e2) {
            throw new zzs((Exception) e2);
        }
    }

    @Nullable
    private final zzr zzd(Context context, String str) throws zzs {
        File zze = zze(context, str);
        if (!zze.exists()) {
            return null;
        }
        try {
            return zza(zze);
        } catch (zzs | IOException e) {
            String str2 = "FirebaseInstanceId";
            if (Log.isLoggable(str2, 3)) {
                String valueOf = String.valueOf(e);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 39);
                sb.append("Failed to read ID from file, retrying: ");
                sb.append(valueOf);
                Log.d(str2, sb.toString());
            }
            try {
                return zza(zze);
            } catch (IOException e2) {
                String valueOf2 = String.valueOf(e2);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 45);
                sb2.append("IID file exists, but failed to read from it: ");
                sb2.append(valueOf2);
                Log.w(str2, sb2.toString());
                throw new zzs((Exception) e2);
            }
        }
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:52:0x00b1=Splitter:B:52:0x00b1, B:31:0x0095=Splitter:B:31:0x0095, B:19:0x0057=Splitter:B:19:0x0057} */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.firebase.iid.zzr zza(android.content.Context r10, java.lang.String r11, com.google.firebase.iid.zzr r12, boolean r13) {
        /*
            r9 = this;
            r0 = 3
            java.lang.String r1 = "FirebaseInstanceId"
            boolean r2 = android.util.Log.isLoggable(r1, r0)
            if (r2 == 0) goto L_0x000e
            java.lang.String r2 = "Writing ID to properties file"
            android.util.Log.d(r1, r2)
        L_0x000e:
            java.util.Properties r2 = new java.util.Properties
            r2.<init>()
            java.lang.String r3 = r12.zza()
            java.lang.String r4 = "id"
            r2.setProperty(r4, r3)
            long r3 = r12.zzb
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r4 = "cre"
            r2.setProperty(r4, r3)
            java.io.File r10 = zze(r10, r11)
            r11 = 0
            r10.createNewFile()     // Catch:{ IOException -> 0x00b5 }
            java.io.RandomAccessFile r3 = new java.io.RandomAccessFile     // Catch:{ IOException -> 0x00b5 }
            java.lang.String r4 = "rw"
            r3.<init>(r10, r4)     // Catch:{ IOException -> 0x00b5 }
            java.nio.channels.FileChannel r10 = r3.getChannel()     // Catch:{ Throwable -> 0x00ab, all -> 0x00a8 }
            r10.lock()     // Catch:{ Throwable -> 0x009c, all -> 0x0099 }
            r4 = 0
            if (r13 == 0) goto L_0x0086
            long r6 = r10.size()     // Catch:{ Throwable -> 0x009c, all -> 0x0099 }
            int r13 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r13 <= 0) goto L_0x0086
            r10.position(r4)     // Catch:{ IOException -> 0x005d, zzs -> 0x005b }
            com.google.firebase.iid.zzr r12 = zza(r10)     // Catch:{ IOException -> 0x005d, zzs -> 0x005b }
            if (r10 == 0) goto L_0x0057
            zza(r11, r10)     // Catch:{ Throwable -> 0x00ab, all -> 0x00a8 }
        L_0x0057:
            zza(r11, r3)     // Catch:{ IOException -> 0x00b5 }
            return r12
        L_0x005b:
            r13 = move-exception
            goto L_0x005e
        L_0x005d:
            r13 = move-exception
        L_0x005e:
            boolean r0 = android.util.Log.isLoggable(r1, r0)     // Catch:{ Throwable -> 0x009c, all -> 0x0099 }
            if (r0 == 0) goto L_0x0086
            java.lang.String r13 = java.lang.String.valueOf(r13)     // Catch:{ Throwable -> 0x009c, all -> 0x0099 }
            java.lang.String r0 = java.lang.String.valueOf(r13)     // Catch:{ Throwable -> 0x009c, all -> 0x0099 }
            int r0 = r0.length()     // Catch:{ Throwable -> 0x009c, all -> 0x0099 }
            int r0 = r0 + 58
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x009c, all -> 0x0099 }
            r6.<init>(r0)     // Catch:{ Throwable -> 0x009c, all -> 0x0099 }
            java.lang.String r0 = "Tried reading ID before writing new one, but failed with: "
            r6.append(r0)     // Catch:{ Throwable -> 0x009c, all -> 0x0099 }
            r6.append(r13)     // Catch:{ Throwable -> 0x009c, all -> 0x0099 }
            java.lang.String r13 = r6.toString()     // Catch:{ Throwable -> 0x009c, all -> 0x0099 }
            android.util.Log.d(r1, r13)     // Catch:{ Throwable -> 0x009c, all -> 0x0099 }
        L_0x0086:
            r10.truncate(r4)     // Catch:{ Throwable -> 0x009c, all -> 0x0099 }
            java.io.OutputStream r13 = java.nio.channels.Channels.newOutputStream(r10)     // Catch:{ Throwable -> 0x009c, all -> 0x0099 }
            r2.store(r13, r11)     // Catch:{ Throwable -> 0x009c, all -> 0x0099 }
            if (r10 == 0) goto L_0x0095
            zza(r11, r10)     // Catch:{ Throwable -> 0x00ab, all -> 0x00a8 }
        L_0x0095:
            zza(r11, r3)     // Catch:{ IOException -> 0x00b5 }
            return r12
        L_0x0099:
            r12 = move-exception
            r13 = r11
            goto L_0x00a2
        L_0x009c:
            r12 = move-exception
            throw r12     // Catch:{ all -> 0x009e }
        L_0x009e:
            r13 = move-exception
            r8 = r13
            r13 = r12
            r12 = r8
        L_0x00a2:
            if (r10 == 0) goto L_0x00a7
            zza(r13, r10)     // Catch:{ Throwable -> 0x00ab, all -> 0x00a8 }
        L_0x00a7:
            throw r12     // Catch:{ Throwable -> 0x00ab, all -> 0x00a8 }
        L_0x00a8:
            r10 = move-exception
            r12 = r11
            goto L_0x00b1
        L_0x00ab:
            r10 = move-exception
            throw r10     // Catch:{ all -> 0x00ad }
        L_0x00ad:
            r12 = move-exception
            r8 = r12
            r12 = r10
            r10 = r8
        L_0x00b1:
            zza(r12, r3)     // Catch:{ IOException -> 0x00b5 }
            throw r10     // Catch:{ IOException -> 0x00b5 }
        L_0x00b5:
            r10 = move-exception
            java.lang.String r10 = java.lang.String.valueOf(r10)
            java.lang.String r12 = java.lang.String.valueOf(r10)
            int r12 = r12.length()
            int r12 = r12 + 21
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r12)
            java.lang.String r12 = "Failed to write key: "
            r13.append(r12)
            r13.append(r10)
            java.lang.String r10 = r13.toString()
            android.util.Log.w(r1, r10)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzp.zza(android.content.Context, java.lang.String, com.google.firebase.iid.zzr, boolean):com.google.firebase.iid.zzr");
    }

    private static File zzb(Context context) {
        File noBackupFilesDir = ContextCompat.getNoBackupFilesDir(context);
        if (noBackupFilesDir != null && noBackupFilesDir.isDirectory()) {
            return noBackupFilesDir;
        }
        Log.w("FirebaseInstanceId", "noBackupFilesDir doesn't exist, using regular files directory instead");
        return context.getFilesDir();
    }

    private static File zze(Context context, String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "com.google.InstanceId.properties";
        } else {
            try {
                String encodeToString = Base64.encodeToString(str.getBytes("UTF-8"), 11);
                StringBuilder sb = new StringBuilder(String.valueOf(encodeToString).length() + 33);
                sb.append("com.google.InstanceId_");
                sb.append(encodeToString);
                sb.append(".properties");
                str2 = sb.toString();
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            }
        }
        return new File(zzb(context), str2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0032, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0036, code lost:
        zza(r10, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0039, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.firebase.iid.zzr zza(java.io.File r10) throws com.google.firebase.iid.zzs, java.io.IOException {
        /*
            r9 = this;
            java.io.FileInputStream r0 = new java.io.FileInputStream
            r0.<init>(r10)
            r10 = 0
            java.nio.channels.FileChannel r7 = r0.getChannel()     // Catch:{ Throwable -> 0x0034 }
            r2 = 0
            r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r6 = 1
            r1 = r7
            r1.lock(r2, r4, r6)     // Catch:{ Throwable -> 0x0026, all -> 0x0023 }
            com.google.firebase.iid.zzr r1 = zza(r7)     // Catch:{ Throwable -> 0x0026, all -> 0x0023 }
            if (r7 == 0) goto L_0x001f
            zza(r10, r7)     // Catch:{ Throwable -> 0x0034 }
        L_0x001f:
            zza(r10, r0)
            return r1
        L_0x0023:
            r1 = move-exception
            r2 = r10
            goto L_0x002c
        L_0x0026:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0028 }
        L_0x0028:
            r2 = move-exception
            r8 = r2
            r2 = r1
            r1 = r8
        L_0x002c:
            if (r7 == 0) goto L_0x0031
            zza(r2, r7)     // Catch:{ Throwable -> 0x0034 }
        L_0x0031:
            throw r1     // Catch:{ Throwable -> 0x0034 }
        L_0x0032:
            r1 = move-exception
            goto L_0x0036
        L_0x0034:
            r10 = move-exception
            throw r10     // Catch:{ all -> 0x0032 }
        L_0x0036:
            zza(r10, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzp.zza(java.io.File):com.google.firebase.iid.zzr");
    }

    private static zzr zza(FileChannel fileChannel) throws zzs, IOException {
        Properties properties = new Properties();
        properties.load(Channels.newInputStream(fileChannel));
        try {
            long parseLong = Long.parseLong(properties.getProperty("cre"));
            String property = properties.getProperty("id");
            if (property == null) {
                String property2 = properties.getProperty("pub");
                if (property2 != null) {
                    property = zzaf.zza(zza(property2));
                } else {
                    throw new zzs("Invalid properties file");
                }
            }
            return new zzr(property, parseLong);
        } catch (NumberFormatException e) {
            throw new zzs((Exception) e);
        }
    }

    @Nullable
    private static zzr zza(SharedPreferences sharedPreferences, String str) throws zzs {
        long zzb = zzb(sharedPreferences, str);
        String string = sharedPreferences.getString(zzaq.zza(str, "id"), null);
        if (string == null) {
            String string2 = sharedPreferences.getString(zzaq.zza(str, "|P|"), null);
            if (string2 == null) {
                return null;
            }
            string = zzaf.zza(zza(string2));
        }
        return new zzr(string, zzb);
    }

    private final void zza(Context context, String str, zzr zzr) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gms.appid", 0);
        try {
            if (zzr.equals(zza(sharedPreferences, str))) {
                return;
            }
        } catch (zzs unused) {
        }
        String str2 = "FirebaseInstanceId";
        if (Log.isLoggable(str2, 3)) {
            Log.d(str2, "Writing key to shared preferences");
        }
        Editor edit = sharedPreferences.edit();
        edit.putString(zzaq.zza(str, "id"), zzr.zza());
        edit.putString(zzaq.zza(str, "cre"), String.valueOf(zzr.zzb));
        edit.commit();
    }

    private static long zzb(SharedPreferences sharedPreferences, String str) {
        String string = sharedPreferences.getString(zzaq.zza(str, "cre"), null);
        if (string != null) {
            try {
                return Long.parseLong(string);
            } catch (NumberFormatException unused) {
            }
        }
        return 0;
    }

    private static /* synthetic */ void zza(Throwable th, FileChannel fileChannel) {
        if (th != null) {
            try {
                fileChannel.close();
            } catch (Throwable th2) {
                zzn.zza(th, th2);
            }
        } else {
            fileChannel.close();
        }
    }

    private static /* synthetic */ void zza(Throwable th, RandomAccessFile randomAccessFile) {
        if (th != null) {
            try {
                randomAccessFile.close();
            } catch (Throwable th2) {
                zzn.zza(th, th2);
            }
        } else {
            randomAccessFile.close();
        }
    }

    private static /* synthetic */ void zza(Throwable th, FileInputStream fileInputStream) {
        if (th != null) {
            try {
                fileInputStream.close();
            } catch (Throwable th2) {
                zzn.zza(th, th2);
            }
        } else {
            fileInputStream.close();
        }
    }
}
