package com.inmobi.media;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/* renamed from: com.inmobi.media.fx */
/* compiled from: DbStore */
public final class C2493fx {

    /* renamed from: a */
    private static final String f5465a = "fx";

    /* renamed from: b */
    private static volatile C2493fx f5466b;

    /* renamed from: c */
    private static final Object f5467c = new Object();

    /* renamed from: d */
    private static final Object f5468d = new Object();

    /* renamed from: e */
    private static int f5469e = 0;

    /* renamed from: f */
    private SQLiteDatabase f5470f;

    private C2493fx() {
        try {
            this.f5470f = new C2492fw(C2505gd.m5298c()).getWritableDatabase();
            f5466b = this;
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public static synchronized C2493fx m5237a() {
        C2493fx fxVar;
        C2493fx fxVar2;
        synchronized (C2493fx.class) {
            synchronized (f5468d) {
                f5469e++;
            }
            fxVar = f5466b;
            if (fxVar == null) {
                synchronized (f5467c) {
                    fxVar2 = f5466b;
                    if (fxVar2 == null) {
                        fxVar2 = new C2493fx();
                        f5466b = fxVar2;
                    }
                }
                fxVar = fxVar2;
            }
        }
        return fxVar;
    }

    /* renamed from: a */
    public final synchronized void mo28430a(String str, ContentValues contentValues, String str2, String[] strArr) {
        try {
            if (-1 == mo28428a(str, contentValues)) {
                mo28432b(str, contentValues, str2, strArr);
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public final synchronized long mo28428a(String str, ContentValues contentValues) {
        try {
        } catch (Exception unused) {
            return -1;
        }
        return this.f5470f.insertWithOnConflict(str, null, contentValues, 4);
    }

    /* renamed from: a */
    public final synchronized int mo28427a(String str, String str2, String[] strArr) {
        try {
        } catch (Exception unused) {
            return -1;
        }
        return this.f5470f.delete(str, str2, strArr);
    }

    /* renamed from: b */
    public final synchronized int mo28432b(String str, ContentValues contentValues, String str2, String[] strArr) {
        try {
        } catch (Exception unused) {
            return -1;
        }
        return this.f5470f.updateWithOnConflict(str, contentValues, str2, strArr, 4);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0035, code lost:
        if (r2 != null) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0042, code lost:
        if (r2 == null) goto L_0x0045;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.util.List<android.content.ContentValues> mo28429a(java.lang.String r13, java.lang.String[] r14, java.lang.String r15, java.lang.String[] r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20) {
        /*
            r12 = this;
            r1 = r12
            monitor-enter(r12)
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0047 }
            r0.<init>()     // Catch:{ all -> 0x0047 }
            r2 = 0
            android.database.sqlite.SQLiteDatabase r3 = r1.f5470f     // Catch:{ Exception -> 0x0042, all -> 0x003b }
            r4 = r13
            r5 = r14
            r6 = r15
            r7 = r16
            r8 = r17
            r9 = r18
            r10 = r19
            r11 = r20
            android.database.Cursor r2 = r3.query(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x0042, all -> 0x003b }
            boolean r3 = r2.moveToFirst()     // Catch:{ Exception -> 0x0042, all -> 0x003b }
            if (r3 == 0) goto L_0x0032
        L_0x0021:
            android.content.ContentValues r3 = new android.content.ContentValues     // Catch:{ Exception -> 0x0042, all -> 0x003b }
            r3.<init>()     // Catch:{ Exception -> 0x0042, all -> 0x003b }
            android.database.DatabaseUtils.cursorRowToContentValues(r2, r3)     // Catch:{ Exception -> 0x0042, all -> 0x003b }
            r0.add(r3)     // Catch:{ Exception -> 0x0042, all -> 0x003b }
            boolean r3 = r2.moveToNext()     // Catch:{ Exception -> 0x0042, all -> 0x003b }
            if (r3 != 0) goto L_0x0021
        L_0x0032:
            r2.close()     // Catch:{ Exception -> 0x0042, all -> 0x003b }
            if (r2 == 0) goto L_0x0045
        L_0x0037:
            r2.close()     // Catch:{ all -> 0x0047 }
            goto L_0x0045
        L_0x003b:
            r0 = move-exception
            if (r2 == 0) goto L_0x0041
            r2.close()     // Catch:{ all -> 0x0047 }
        L_0x0041:
            throw r0     // Catch:{ all -> 0x0047 }
        L_0x0042:
            if (r2 == 0) goto L_0x0045
            goto L_0x0037
        L_0x0045:
            monitor-exit(r12)
            return r0
        L_0x0047:
            r0 = move-exception
            monitor-exit(r12)
            throw r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2493fx.mo28429a(java.lang.String, java.lang.String[], java.lang.String, java.lang.String[], java.lang.String, java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    /* renamed from: a */
    public final synchronized int mo28426a(String str) {
        int i;
        try {
            StringBuilder sb = new StringBuilder("SELECT COUNT(*) FROM ");
            sb.append(str);
            sb.append(" ; ");
            Cursor rawQuery = this.f5470f.rawQuery(sb.toString(), null);
            rawQuery.moveToFirst();
            i = rawQuery.getInt(0);
            rawQuery.close();
        } catch (Exception unused) {
            return -1;
        }
        return i;
    }

    /* renamed from: b */
    public final synchronized int mo28433b(String str, String str2, String[] strArr) {
        int i;
        try {
            StringBuilder sb = new StringBuilder("SELECT COUNT(*) FROM ");
            sb.append(str);
            sb.append(" WHERE ");
            sb.append(str2);
            sb.append(" ; ");
            Cursor rawQuery = this.f5470f.rawQuery(sb.toString(), strArr);
            rawQuery.moveToFirst();
            i = rawQuery.getInt(0);
            rawQuery.close();
        } catch (Exception unused) {
            return -1;
        }
        return i;
    }

    /* renamed from: b */
    public final synchronized void mo28435b(String str) {
        try {
            StringBuilder sb = new StringBuilder("DROP TABLE IF EXISTS \"");
            sb.append(str);
            sb.append("\"");
            this.f5470f.execSQL(sb.toString());
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public final synchronized void mo28431a(String str, String str2) {
        try {
            StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
            sb.append(str);
            sb.append(str2);
            sb.append(";");
            this.f5470f.execSQL(sb.toString());
        } catch (Exception unused) {
        }
    }

    /* renamed from: b */
    public final synchronized void mo28436b(String str, String str2) {
        try {
            this.f5470f.execSQL("DROP TRIGGER IF EXISTS ".concat(String.valueOf(str)));
            StringBuilder sb = new StringBuilder("CREATE TRIGGER ");
            sb.append(str);
            sb.append(" ");
            sb.append(str2);
            sb.append(" END");
            this.f5470f.execSQL(sb.toString());
        } catch (Exception unused) {
        }
    }

    /* renamed from: b */
    public final synchronized void mo28434b() {
        try {
            synchronized (f5468d) {
                int i = f5469e - 1;
                f5469e = i;
                if (i == 0) {
                    this.f5470f.close();
                    f5466b = null;
                }
            }
        } catch (Exception unused) {
        }
    }
}
