package com.google.android.gms.internal.nearby;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

public class zzhe {
    private static final Uri CONTENT_URI = Uri.parse("content://com.google.android.gsf.gservices");
    private static final Uri zzjn = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    private static final Pattern zzjo = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
    private static final Pattern zzjp = Pattern.compile("^(0|false|f|off|no|n)$", 2);
    /* access modifiers changed from: private */
    public static final AtomicBoolean zzjq = new AtomicBoolean();
    private static HashMap<String, String> zzjr;
    private static final HashMap<String, Boolean> zzjs = new HashMap<>();
    private static final HashMap<String, Integer> zzjt = new HashMap<>();
    private static final HashMap<String, Long> zzju = new HashMap<>();
    private static final HashMap<String, Float> zzjv = new HashMap<>();
    private static Object zzjw;
    private static boolean zzjx;
    private static String[] zzjy = new String[0];

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0012, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static <T> T zza(java.util.HashMap<java.lang.String, T> r2, java.lang.String r3, T r4) {
        /*
            java.lang.Class<com.google.android.gms.internal.nearby.zzhe> r0 = com.google.android.gms.internal.nearby.zzhe.class
            monitor-enter(r0)
            boolean r1 = r2.containsKey(r3)     // Catch:{ all -> 0x0016 }
            if (r1 == 0) goto L_0x0013
            java.lang.Object r2 = r2.get(r3)     // Catch:{ all -> 0x0016 }
            if (r2 == 0) goto L_0x0010
            goto L_0x0011
        L_0x0010:
            r2 = r4
        L_0x0011:
            monitor-exit(r0)     // Catch:{ all -> 0x0016 }
            return r2
        L_0x0013:
            monitor-exit(r0)     // Catch:{ all -> 0x0016 }
            r2 = 0
            return r2
        L_0x0016:
            r2 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0016 }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.nearby.zzhe.zza(java.util.HashMap, java.lang.String, java.lang.Object):java.lang.Object");
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001e, code lost:
        return r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005d, code lost:
        return r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005f, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0064, code lost:
        r13 = r13.query(CONTENT_URI, null, null, new java.lang.String[]{r14}, null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0072, code lost:
        if (r13 == null) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0078, code lost:
        if (r13.moveToFirst() != false) goto L_0x007b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x007b, code lost:
        r15 = r13.getString(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x007f, code lost:
        if (r15 == null) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0085, code lost:
        if (r15.equals(null) == false) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0087, code lost:
        r15 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0088, code lost:
        zza(r0, r14, r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x008b, code lost:
        if (r15 == null) goto L_0x008e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x008e, code lost:
        r15 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x008f, code lost:
        if (r13 == null) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0091, code lost:
        r13.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0094, code lost:
        return r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        zza(r0, r14, (java.lang.String) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0098, code lost:
        if (r13 == null) goto L_0x009d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x009a, code lost:
        r13.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x009d, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x009e, code lost:
        r14 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x009f, code lost:
        if (r13 != null) goto L_0x00a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00a1, code lost:
        r13.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00a4, code lost:
        throw r14;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String zza(android.content.ContentResolver r13, java.lang.String r14, java.lang.String r15) {
        /*
            java.lang.Class<com.google.android.gms.internal.nearby.zzhe> r15 = com.google.android.gms.internal.nearby.zzhe.class
            monitor-enter(r15)
            zza(r13)     // Catch:{ all -> 0x00a5 }
            java.lang.Object r0 = zzjw     // Catch:{ all -> 0x00a5 }
            java.util.HashMap<java.lang.String, java.lang.String> r1 = zzjr     // Catch:{ all -> 0x00a5 }
            boolean r1 = r1.containsKey(r14)     // Catch:{ all -> 0x00a5 }
            r2 = 0
            if (r1 == 0) goto L_0x001f
            java.util.HashMap<java.lang.String, java.lang.String> r13 = zzjr     // Catch:{ all -> 0x00a5 }
            java.lang.Object r13 = r13.get(r14)     // Catch:{ all -> 0x00a5 }
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ all -> 0x00a5 }
            if (r13 == 0) goto L_0x001c
            goto L_0x001d
        L_0x001c:
            r13 = r2
        L_0x001d:
            monitor-exit(r15)     // Catch:{ all -> 0x00a5 }
            return r13
        L_0x001f:
            java.lang.String[] r1 = zzjy     // Catch:{ all -> 0x00a5 }
            int r3 = r1.length     // Catch:{ all -> 0x00a5 }
            r4 = 0
            r5 = 0
        L_0x0024:
            r6 = 1
            if (r5 >= r3) goto L_0x0063
            r7 = r1[r5]     // Catch:{ all -> 0x00a5 }
            boolean r7 = r14.startsWith(r7)     // Catch:{ all -> 0x00a5 }
            if (r7 == 0) goto L_0x0060
            boolean r0 = zzjx     // Catch:{ all -> 0x00a5 }
            if (r0 == 0) goto L_0x003b
            java.util.HashMap<java.lang.String, java.lang.String> r0 = zzjr     // Catch:{ all -> 0x00a5 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x00a5 }
            if (r0 == 0) goto L_0x005e
        L_0x003b:
            java.lang.String[] r0 = zzjy     // Catch:{ all -> 0x00a5 }
            java.util.HashMap<java.lang.String, java.lang.String> r1 = zzjr     // Catch:{ all -> 0x00a5 }
            java.util.Map r13 = zza(r13, r0)     // Catch:{ all -> 0x00a5 }
            r1.putAll(r13)     // Catch:{ all -> 0x00a5 }
            zzjx = r6     // Catch:{ all -> 0x00a5 }
            java.util.HashMap<java.lang.String, java.lang.String> r13 = zzjr     // Catch:{ all -> 0x00a5 }
            boolean r13 = r13.containsKey(r14)     // Catch:{ all -> 0x00a5 }
            if (r13 == 0) goto L_0x005e
            java.util.HashMap<java.lang.String, java.lang.String> r13 = zzjr     // Catch:{ all -> 0x00a5 }
            java.lang.Object r13 = r13.get(r14)     // Catch:{ all -> 0x00a5 }
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ all -> 0x00a5 }
            if (r13 == 0) goto L_0x005b
            goto L_0x005c
        L_0x005b:
            r13 = r2
        L_0x005c:
            monitor-exit(r15)     // Catch:{ all -> 0x00a5 }
            return r13
        L_0x005e:
            monitor-exit(r15)     // Catch:{ all -> 0x00a5 }
            return r2
        L_0x0060:
            int r5 = r5 + 1
            goto L_0x0024
        L_0x0063:
            monitor-exit(r15)     // Catch:{ all -> 0x00a5 }
            android.net.Uri r8 = CONTENT_URI
            r9 = 0
            r10 = 0
            java.lang.String[] r11 = new java.lang.String[r6]
            r11[r4] = r14
            r12 = 0
            r7 = r13
            android.database.Cursor r13 = r7.query(r8, r9, r10, r11, r12)
            if (r13 == 0) goto L_0x0095
            boolean r15 = r13.moveToFirst()     // Catch:{ all -> 0x009e }
            if (r15 != 0) goto L_0x007b
            goto L_0x0095
        L_0x007b:
            java.lang.String r15 = r13.getString(r6)     // Catch:{ all -> 0x009e }
            if (r15 == 0) goto L_0x0088
            boolean r1 = r15.equals(r2)     // Catch:{ all -> 0x009e }
            if (r1 == 0) goto L_0x0088
            r15 = r2
        L_0x0088:
            zza(r0, r14, r15)     // Catch:{ all -> 0x009e }
            if (r15 == 0) goto L_0x008e
            goto L_0x008f
        L_0x008e:
            r15 = r2
        L_0x008f:
            if (r13 == 0) goto L_0x0094
            r13.close()
        L_0x0094:
            return r15
        L_0x0095:
            zza(r0, r14, r2)     // Catch:{ all -> 0x009e }
            if (r13 == 0) goto L_0x009d
            r13.close()
        L_0x009d:
            return r2
        L_0x009e:
            r14 = move-exception
            if (r13 == 0) goto L_0x00a4
            r13.close()
        L_0x00a4:
            throw r14
        L_0x00a5:
            r13 = move-exception
            monitor-exit(r15)     // Catch:{ all -> 0x00a5 }
            throw r13
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.nearby.zzhe.zza(android.content.ContentResolver, java.lang.String, java.lang.String):java.lang.String");
    }

    private static Map<String, String> zza(ContentResolver contentResolver, String... strArr) {
        Cursor query = contentResolver.query(zzjn, null, null, strArr, null);
        TreeMap treeMap = new TreeMap();
        if (query == null) {
            return treeMap;
        }
        while (query.moveToNext()) {
            try {
                treeMap.put(query.getString(0), query.getString(1));
            } finally {
                query.close();
            }
        }
        return treeMap;
    }

    private static void zza(ContentResolver contentResolver) {
        if (zzjr == null) {
            zzjq.set(false);
            zzjr = new HashMap<>();
            zzjw = new Object();
            zzjx = false;
            contentResolver.registerContentObserver(CONTENT_URI, true, new zzhf(null));
            return;
        }
        if (zzjq.getAndSet(false)) {
            zzjr.clear();
            zzjs.clear();
            zzjt.clear();
            zzju.clear();
            zzjv.clear();
            zzjw = new Object();
            zzjx = false;
        }
    }

    private static void zza(Object obj, String str, String str2) {
        synchronized (zzhe.class) {
            if (obj == zzjw) {
                zzjr.put(str, str2);
            }
        }
    }

    public static boolean zza(ContentResolver contentResolver, String str, boolean z) {
        Object zzb = zzb(contentResolver);
        HashMap<String, Boolean> hashMap = zzjs;
        boolean z2 = true;
        Boolean valueOf = Boolean.valueOf(true);
        Boolean bool = (Boolean) zza(hashMap, str, (T) valueOf);
        if (bool != null) {
            return bool.booleanValue();
        }
        String zza = zza(contentResolver, str, (String) null);
        if (zza != null && !zza.equals("")) {
            if (zzjo.matcher(zza).matches()) {
                bool = valueOf;
            } else if (zzjp.matcher(zza).matches()) {
                bool = Boolean.valueOf(false);
                z2 = false;
            } else {
                StringBuilder sb = new StringBuilder("attempt to read gservices key ");
                sb.append(str);
                sb.append(" (value \"");
                sb.append(zza);
                sb.append("\") as boolean");
                Log.w("Gservices", sb.toString());
            }
        }
        HashMap<String, Boolean> hashMap2 = zzjs;
        synchronized (zzhe.class) {
            if (zzb == zzjw) {
                hashMap2.put(str, bool);
                zzjr.remove(str);
            }
        }
        return z2;
    }

    private static Object zzb(ContentResolver contentResolver) {
        Object obj;
        synchronized (zzhe.class) {
            zza(contentResolver);
            obj = zzjw;
        }
        return obj;
    }
}
