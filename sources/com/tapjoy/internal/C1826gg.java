package com.tapjoy.internal;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import java.io.File;

/* renamed from: com.tapjoy.internal.gg */
class C1826gg extends C1823gf {

    /* renamed from: b */
    private final File f3798b;

    /* renamed from: c */
    private final C1830gy f3799c;

    /* renamed from: d */
    private volatile SQLiteDatabase f3800d;

    /* renamed from: e */
    private long f3801e;

    /* renamed from: f */
    private long f3802f;

    /* renamed from: g */
    private long f3803g;

    public C1826gg(File file, C1830gy gyVar) {
        this.f3798b = file;
        this.f3799c = gyVar;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        if (this.f3800d != null) {
            C1854jz.m3672a(this.f3800d);
            this.f3800d = null;
        }
        super.finalize();
    }

    /* access modifiers changed from: protected */
    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    public void mo18093a(long j) {
        if (this.f3800d == null) {
            this.f3800d = SQLiteDatabase.openOrCreateDatabase(this.f3798b, null);
            int version = this.f3800d.getVersion();
            if (version == 0) {
                this.f3800d.beginTransaction();
                try {
                    this.f3800d.execSQL("CREATE TABLE IF NOT EXISTS UsageStats(name TEXT,dimensions TEXT,count INTEGER,first_time INTEGER,last_time INTEGER,PRIMARY KEY(name, dimensions))");
                    this.f3800d.execSQL("CREATE TABLE IF NOT EXISTS UsageStatValues(stat_id LONG,name TEXT,count INTEGER,avg REAL,max INTEGER,PRIMARY KEY(stat_id, name))");
                    this.f3800d.setVersion(1);
                    this.f3800d.setTransactionSuccessful();
                } finally {
                    this.f3800d.endTransaction();
                }
            } else if (version != 1) {
                StringBuilder sb = new StringBuilder("Unknown database version: ");
                sb.append(version);
                throw new SQLException(sb.toString());
            }
            Cursor rawQuery = this.f3800d.rawQuery("SELECT MIN(first_time), MAX(last_time) FROM UsageStats", null);
            try {
                if (rawQuery.moveToNext()) {
                    this.f3802f = rawQuery.getLong(0);
                    this.f3803g = rawQuery.getLong(1);
                }
                rawQuery.close();
                long j2 = this.f3802f;
                if (j2 > 0 && j2 + 86400000 <= j) {
                    m3537b();
                }
            } catch (Throwable th) {
                rawQuery.close();
                throw th;
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo18092a() {
        if (this.f3800d != null) {
            C1854jz.m3672a(this.f3800d);
            this.f3800d = null;
        }
        this.f3798b.delete();
        this.f3803g = 0;
        this.f3802f = 0;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: type inference failed for: r5v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r9v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r9v2 */
    /* JADX WARNING: type inference failed for: r5v2 */
    /* JADX WARNING: type inference failed for: r9v3, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r5v3 */
    /* JADX WARNING: type inference failed for: r5v4 */
    /* JADX WARNING: type inference failed for: r9v6 */
    /* JADX WARNING: type inference failed for: r9v7, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r9v8 */
    /* JADX WARNING: type inference failed for: r9v9 */
    /* JADX WARNING: type inference failed for: r9v11 */
    /* JADX WARNING: type inference failed for: r5v6 */
    /* JADX WARNING: type inference failed for: r9v12 */
    /* JADX WARNING: type inference failed for: r9v18 */
    /* JADX WARNING: type inference failed for: r5v16 */
    /* JADX WARNING: type inference failed for: r5v17 */
    /* JADX WARNING: type inference failed for: r5v18 */
    /* JADX WARNING: type inference failed for: r9v19 */
    /* JADX WARNING: type inference failed for: r9v20 */
    /* JADX WARNING: type inference failed for: r9v21 */
    /* JADX WARNING: type inference failed for: r9v22 */
    /* JADX WARNING: type inference failed for: r9v23 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r5v4
      assigns: []
      uses: []
      mth insns count: 210
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 10 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo18094a(long r28, java.lang.String r30, @javax.annotation.Nullable java.lang.String r31, @javax.annotation.Nullable java.util.Map r32) {
        /*
            r27 = this;
            r1 = r27
            r2 = r28
            r0 = r30
            android.database.sqlite.SQLiteDatabase r4 = r1.f3800d
            if (r4 != 0) goto L_0x000b
            return
        L_0x000b:
            long r4 = r1.f3801e
            r6 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x0018
            r1.f3803g = r2
            r1.f3801e = r2
            goto L_0x0044
        L_0x0018:
            r6 = 86400000(0x5265c00, double:4.2687272E-316)
            int r8 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r8 < 0) goto L_0x002d
            long r4 = r4 + r6
            int r8 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r8 >= 0) goto L_0x002d
            long r4 = r1.f3803g
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x0044
            r1.f3803g = r2
            goto L_0x0044
        L_0x002d:
            long r4 = r1.f3801e
            int r8 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r8 >= 0) goto L_0x003d
            long r4 = r1.f3803g
            long r4 = r4 - r2
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 >= 0) goto L_0x003d
            r1.f3801e = r2
            goto L_0x0044
        L_0x003d:
            r27.m3537b()
            r1.f3803g = r2
            r1.f3801e = r2
        L_0x0044:
            if (r31 != 0) goto L_0x0049
            java.lang.String r4 = ""
            goto L_0x004b
        L_0x0049:
            r4 = r31
        L_0x004b:
            android.database.sqlite.SQLiteDatabase r5 = r1.f3800d
            r6 = 2
            java.lang.String[] r7 = new java.lang.String[r6]
            r8 = 0
            r7[r8] = r0
            r9 = 1
            r7[r9] = r4
            java.lang.String r10 = "SELECT ROWID,count,first_time,last_time FROM UsageStats WHERE name = ? AND dimensions = ?"
            android.database.Cursor r5 = r5.rawQuery(r10, r7)
            android.content.ContentValues r7 = new android.content.ContentValues     // Catch:{ all -> 0x01f6 }
            r7.<init>()     // Catch:{ all -> 0x01f6 }
            boolean r10 = r5.moveToNext()     // Catch:{ all -> 0x01f6 }
            java.lang.String r11 = "ROWID = "
            java.lang.String r12 = "UsageStats"
            java.lang.String r13 = "last_time"
            java.lang.String r14 = "first_time"
            java.lang.String r15 = "name"
            java.lang.String r6 = "count"
            if (r10 == 0) goto L_0x00bf
            r17 = r11
            long r10 = r5.getLong(r8)     // Catch:{ all -> 0x01f6 }
            int r0 = r5.getInt(r9)     // Catch:{ all -> 0x01f6 }
            r4 = 2
            long r18 = r5.getLong(r4)     // Catch:{ all -> 0x01f6 }
            r4 = 3
            long r20 = r5.getLong(r4)     // Catch:{ all -> 0x01f6 }
            int r0 = r0 + r9
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x01f6 }
            r7.put(r6, r0)     // Catch:{ all -> 0x01f6 }
            int r0 = (r2 > r18 ? 1 : (r2 == r18 ? 0 : -1))
            if (r0 >= 0) goto L_0x009a
            java.lang.Long r0 = java.lang.Long.valueOf(r28)     // Catch:{ all -> 0x01f6 }
            r7.put(r14, r0)     // Catch:{ all -> 0x01f6 }
        L_0x009a:
            int r0 = (r2 > r20 ? 1 : (r2 == r20 ? 0 : -1))
            if (r0 <= 0) goto L_0x00a5
            java.lang.Long r0 = java.lang.Long.valueOf(r28)     // Catch:{ all -> 0x01f6 }
            r7.put(r13, r0)     // Catch:{ all -> 0x01f6 }
        L_0x00a5:
            android.database.sqlite.SQLiteDatabase r0 = r1.f3800d     // Catch:{ all -> 0x01f6 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01f6 }
            r3 = r17
            r2.<init>(r3)     // Catch:{ all -> 0x01f6 }
            r2.append(r10)     // Catch:{ all -> 0x01f6 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x01f6 }
            r4 = 0
            r0.update(r12, r7, r2, r4)     // Catch:{ all -> 0x01f6 }
            r25 = r10
            r10 = r3
            r3 = r25
            goto L_0x00e4
        L_0x00bf:
            r10 = r11
            r7.put(r15, r0)     // Catch:{ all -> 0x01f6 }
            java.lang.String r0 = "dimensions"
            r7.put(r0, r4)     // Catch:{ all -> 0x01f6 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x01f6 }
            r7.put(r6, r0)     // Catch:{ all -> 0x01f6 }
            java.lang.Long r0 = java.lang.Long.valueOf(r28)     // Catch:{ all -> 0x01f6 }
            r7.put(r14, r0)     // Catch:{ all -> 0x01f6 }
            java.lang.Long r0 = java.lang.Long.valueOf(r28)     // Catch:{ all -> 0x01f6 }
            r7.put(r13, r0)     // Catch:{ all -> 0x01f6 }
            android.database.sqlite.SQLiteDatabase r0 = r1.f3800d     // Catch:{ all -> 0x01f6 }
            r2 = 0
            long r3 = r0.insert(r12, r2, r7)     // Catch:{ all -> 0x01f6 }
        L_0x00e4:
            if (r32 == 0) goto L_0x01f1
            boolean r0 = r32.isEmpty()     // Catch:{ all -> 0x01f6 }
            if (r0 != 0) goto L_0x01f1
            java.util.Set r0 = r32.entrySet()     // Catch:{ all -> 0x01f6 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x01f6 }
        L_0x00f4:
            boolean r2 = r0.hasNext()     // Catch:{ all -> 0x01f6 }
            if (r2 == 0) goto L_0x01f1
            java.lang.Object r2 = r0.next()     // Catch:{ all -> 0x01f6 }
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ all -> 0x01f6 }
            java.lang.Object r11 = r2.getValue()     // Catch:{ all -> 0x01f6 }
            if (r11 == 0) goto L_0x01ea
            java.lang.Object r11 = r2.getKey()     // Catch:{ all -> 0x01f6 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x01f6 }
            java.lang.Object r2 = r2.getValue()     // Catch:{ all -> 0x01f6 }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ all -> 0x01f6 }
            long r12 = r2.longValue()     // Catch:{ all -> 0x01f6 }
            r2 = 2
            java.lang.String[] r14 = new java.lang.String[r2]     // Catch:{ all -> 0x01f6 }
            java.lang.String r16 = java.lang.Long.toString(r3)     // Catch:{ all -> 0x01f6 }
            r14[r8] = r16     // Catch:{ all -> 0x01f6 }
            r14[r9] = r11     // Catch:{ all -> 0x01f6 }
            android.database.sqlite.SQLiteDatabase r2 = r1.f3800d     // Catch:{ all -> 0x01f6 }
            java.lang.String r9 = "SELECT ROWID, * FROM UsageStatValues WHERE stat_id = ? AND name = ?"
            android.database.Cursor r2 = r2.rawQuery(r9, r14)     // Catch:{ all -> 0x01f6 }
            boolean r9 = r2.moveToNext()     // Catch:{ all -> 0x01e2 }
            java.lang.String r14 = "UsageStatValues"
            java.lang.String r8 = "max"
            r28 = r0
            java.lang.String r0 = "avg"
            if (r9 == 0) goto L_0x019c
            r29 = r3
            r9 = 0
            long r3 = r2.getLong(r9)     // Catch:{ all -> 0x01e2 }
            r11 = 3
            int r18 = r2.getInt(r11)     // Catch:{ all -> 0x01e2 }
            r9 = 4
            double r20 = r2.getDouble(r9)     // Catch:{ all -> 0x01e2 }
            r9 = 5
            long r22 = r2.getLong(r9)     // Catch:{ all -> 0x01e2 }
            r7.clear()     // Catch:{ all -> 0x01e2 }
            r9 = 1
            int r11 = r18 + 1
            java.lang.Integer r9 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x01e2 }
            r7.put(r6, r9)     // Catch:{ all -> 0x01e2 }
            r9 = r5
            r18 = r6
            double r5 = (double) r12
            java.lang.Double.isNaN(r5)
            double r5 = r5 - r20
            r32 = r14
            r24 = r15
            double r14 = (double) r11
            java.lang.Double.isNaN(r14)
            double r5 = r5 / r14
            double r20 = r20 + r5
            java.lang.Double r5 = java.lang.Double.valueOf(r20)     // Catch:{ all -> 0x01e0 }
            r7.put(r0, r5)     // Catch:{ all -> 0x01e0 }
            int r0 = (r12 > r22 ? 1 : (r12 == r22 ? 0 : -1))
            if (r0 <= 0) goto L_0x0180
            java.lang.Long r0 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x01e0 }
            r7.put(r8, r0)     // Catch:{ all -> 0x01e0 }
        L_0x0180:
            android.database.sqlite.SQLiteDatabase r0 = r1.f3800d     // Catch:{ all -> 0x01e0 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x01e0 }
            r5.<init>(r10)     // Catch:{ all -> 0x01e0 }
            r5.append(r3)     // Catch:{ all -> 0x01e0 }
            java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x01e0 }
            r4 = r32
            r5 = 0
            r0.update(r4, r7, r3, r5)     // Catch:{ all -> 0x01e0 }
            r14 = r18
            r5 = r24
            r3 = 3
            r6 = 1
            r8 = 0
            goto L_0x01d4
        L_0x019c:
            r29 = r3
            r9 = r5
            r18 = r6
            r4 = r14
            r24 = r15
            r3 = 3
            r7.clear()     // Catch:{ all -> 0x01e0 }
            java.lang.String r5 = "stat_id"
            java.lang.Long r6 = java.lang.Long.valueOf(r29)     // Catch:{ all -> 0x01e0 }
            r7.put(r5, r6)     // Catch:{ all -> 0x01e0 }
            r5 = r24
            r7.put(r5, r11)     // Catch:{ all -> 0x01e0 }
            r6 = 1
            java.lang.Integer r11 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x01e0 }
            r14 = r18
            r7.put(r14, r11)     // Catch:{ all -> 0x01e0 }
            java.lang.Long r11 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x01e0 }
            r7.put(r0, r11)     // Catch:{ all -> 0x01e0 }
            java.lang.Long r0 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x01e0 }
            r7.put(r8, r0)     // Catch:{ all -> 0x01e0 }
            android.database.sqlite.SQLiteDatabase r0 = r1.f3800d     // Catch:{ all -> 0x01e0 }
            r8 = 0
            r0.insert(r4, r8, r7)     // Catch:{ all -> 0x01e0 }
        L_0x01d4:
            r2.close()     // Catch:{ all -> 0x01e8 }
            r0 = r28
            r3 = r29
            r15 = r5
            r5 = r9
            r6 = r14
            r8 = 0
            goto L_0x01ee
        L_0x01e0:
            r0 = move-exception
            goto L_0x01e4
        L_0x01e2:
            r0 = move-exception
            r9 = r5
        L_0x01e4:
            r2.close()     // Catch:{ all -> 0x01e8 }
            throw r0     // Catch:{ all -> 0x01e8 }
        L_0x01e8:
            r0 = move-exception
            goto L_0x01f8
        L_0x01ea:
            r9 = r5
            r14 = r6
            r6 = 1
            r6 = r14
        L_0x01ee:
            r9 = 1
            goto L_0x00f4
        L_0x01f1:
            r9 = r5
            r9.close()
            return
        L_0x01f6:
            r0 = move-exception
            r9 = r5
        L_0x01f8:
            r9.close()
            throw r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C1826gg.mo18094a(long, java.lang.String, java.lang.String, java.util.Map):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00c3, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00c7, code lost:
        throw r0;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m3537b() {
        /*
            r23 = this;
            r1 = r23
            java.util.Set r0 = com.tapjoy.internal.C1823gf.f3790a
            android.database.sqlite.SQLiteDatabase r2 = r1.f3800d
            r3 = 0
            java.lang.String r4 = "SELECT ROWID, * FROM UsageStats ORDER BY ROWID ASC"
            android.database.Cursor r2 = r2.rawQuery(r4, r3)
            android.database.sqlite.SQLiteDatabase r4 = r1.f3800d     // Catch:{ all -> 0x00c8 }
            java.lang.String r5 = "SELECT * FROM UsageStatValues ORDER BY stat_id ASC"
            android.database.Cursor r4 = r4.rawQuery(r5, r3)     // Catch:{ all -> 0x00c8 }
            r4.moveToNext()     // Catch:{ all -> 0x00c3 }
        L_0x0018:
            boolean r5 = r2.moveToNext()     // Catch:{ all -> 0x00c3 }
            if (r5 == 0) goto L_0x00a8
            r5 = 0
            long r6 = r2.getLong(r5)     // Catch:{ all -> 0x00c3 }
            r8 = 1
            java.lang.String r10 = r2.getString(r8)     // Catch:{ all -> 0x00c3 }
            r9 = 2
            java.lang.String r9 = r2.getString(r9)     // Catch:{ all -> 0x00c3 }
            boolean r11 = r9.isEmpty()     // Catch:{ all -> 0x00c3 }
            if (r11 == 0) goto L_0x0035
            r11 = r3
            goto L_0x0036
        L_0x0035:
            r11 = r9
        L_0x0036:
            r9 = 3
            int r12 = r2.getInt(r9)     // Catch:{ all -> 0x00c3 }
            r13 = 4
            long r14 = r2.getLong(r13)     // Catch:{ all -> 0x00c3 }
            r3 = 5
            long r16 = r2.getLong(r3)     // Catch:{ all -> 0x00c3 }
            boolean r3 = r4.isAfterLast()     // Catch:{ all -> 0x00c3 }
            if (r3 != 0) goto L_0x0090
            r3 = 0
        L_0x004c:
            long r18 = r4.getLong(r5)     // Catch:{ all -> 0x00c3 }
            int r20 = (r18 > r6 ? 1 : (r18 == r6 ? 0 : -1))
            if (r20 != 0) goto L_0x0091
            if (r3 != 0) goto L_0x005b
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ all -> 0x00c3 }
            r3.<init>()     // Catch:{ all -> 0x00c3 }
        L_0x005b:
            java.lang.String r5 = r4.getString(r8)     // Catch:{ all -> 0x00c3 }
            long r19 = r4.getLong(r9)     // Catch:{ all -> 0x00c3 }
            long r21 = r4.getLong(r13)     // Catch:{ all -> 0x00c3 }
            java.lang.Long r8 = java.lang.Long.valueOf(r19)     // Catch:{ all -> 0x00c3 }
            r3.put(r5, r8)     // Catch:{ all -> 0x00c3 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c3 }
            r8.<init>()     // Catch:{ all -> 0x00c3 }
            r8.append(r5)     // Catch:{ all -> 0x00c3 }
            java.lang.String r5 = "_max"
            r8.append(r5)     // Catch:{ all -> 0x00c3 }
            java.lang.String r5 = r8.toString()     // Catch:{ all -> 0x00c3 }
            java.lang.Long r8 = java.lang.Long.valueOf(r21)     // Catch:{ all -> 0x00c3 }
            r3.put(r5, r8)     // Catch:{ all -> 0x00c3 }
            boolean r5 = r4.moveToNext()     // Catch:{ all -> 0x00c3 }
            if (r5 != 0) goto L_0x008d
            goto L_0x0091
        L_0x008d:
            r5 = 0
            r8 = 1
            goto L_0x004c
        L_0x0090:
            r3 = 0
        L_0x0091:
            if (r0 == 0) goto L_0x009d
            boolean r5 = r0.contains(r10)     // Catch:{ all -> 0x00c3 }
            if (r5 != 0) goto L_0x009a
            goto L_0x009d
        L_0x009a:
            r3 = 0
            goto L_0x0018
        L_0x009d:
            com.tapjoy.internal.gy r9 = r1.f3799c     // Catch:{ all -> 0x00c3 }
            r13 = r14
            r15 = r16
            r17 = r3
            r9.mo18116a(r10, r11, r12, r13, r15, r17)     // Catch:{ all -> 0x00c3 }
            goto L_0x009a
        L_0x00a8:
            r4.close()     // Catch:{ all -> 0x00c8 }
            r2.close()
            android.database.sqlite.SQLiteDatabase r0 = r1.f3800d
            java.lang.String r2 = "DELETE FROM UsageStats"
            r0.execSQL(r2)
            android.database.sqlite.SQLiteDatabase r0 = r1.f3800d
            java.lang.String r2 = "DELETE FROM UsageStatValues"
            r0.execSQL(r2)
            r2 = 0
            r1.f3803g = r2
            r1.f3802f = r2
            return
        L_0x00c3:
            r0 = move-exception
            r4.close()     // Catch:{ all -> 0x00c8 }
            throw r0     // Catch:{ all -> 0x00c8 }
        L_0x00c8:
            r0 = move-exception
            r2.close()
            throw r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C1826gg.m3537b():void");
    }
}
