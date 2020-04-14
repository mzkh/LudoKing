package com.tapjoy.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;

/* renamed from: com.tapjoy.internal.g */
public final class C3090g extends C2881at implements C2886ax, Closeable {

    /* renamed from: a */
    private SQLiteDatabase f7284a;

    /* renamed from: b */
    private final C2892bd f7285b;

    /* renamed from: c */
    private int f7286c;

    public C3090g(File file, C2892bd bdVar) {
        this.f7284a = SQLiteDatabase.openOrCreateDatabase(file, null);
        this.f7285b = bdVar;
        if (this.f7284a.getVersion() != 1) {
            this.f7284a.beginTransaction();
            try {
                this.f7284a.execSQL("CREATE TABLE IF NOT EXISTS List(value BLOB)");
                this.f7284a.setVersion(1);
                this.f7284a.setTransactionSuccessful();
            } finally {
                this.f7284a.endTransaction();
            }
        }
        this.f7286c = m7133a();
    }

    /* access modifiers changed from: protected */
    public final void finalize() {
        close();
        super.finalize();
    }

    public final void close() {
        SQLiteDatabase sQLiteDatabase = this.f7284a;
        if (sQLiteDatabase != null) {
            sQLiteDatabase.close();
            this.f7284a = null;
        }
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [java.lang.String[], android.database.Cursor] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v0, types: [java.lang.String[], android.database.Cursor]
      assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY]]
      uses: [android.database.Cursor, java.lang.String[]]
      mth insns count: 15
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
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int m7133a() {
        /*
            r3 = this;
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r3.f7284a     // Catch:{ all -> 0x001c }
            java.lang.String r2 = "SELECT COUNT(1) FROM List"
            android.database.Cursor r0 = r1.rawQuery(r2, r0)     // Catch:{ all -> 0x001c }
            boolean r1 = r0.moveToNext()     // Catch:{ all -> 0x001c }
            r2 = 0
            if (r1 == 0) goto L_0x0018
            int r1 = r0.getInt(r2)     // Catch:{ all -> 0x001c }
            m7134a(r0)
            return r1
        L_0x0018:
            m7134a(r0)
            return r2
        L_0x001c:
            r1 = move-exception
            m7134a(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C3090g.m7133a():int");
    }

    public final int size() {
        return this.f7286c;
    }

    public final void clear() {
        this.f7284a.delete("List", "1", null);
        this.f7286c = 0;
    }

    public final boolean offer(Object obj) {
        C3226jp.m7500a(obj);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            this.f7285b.mo18182a(byteArrayOutputStream, obj);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            C1854jz.m3672a(byteArrayOutputStream);
            ContentValues contentValues = new ContentValues();
            contentValues.put("value", byteArray);
            if (this.f7284a.insert("List", null, contentValues) == -1) {
                return false;
            }
            this.f7286c++;
            return true;
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        } catch (Throwable th) {
            C1854jz.m3672a(byteArrayOutputStream);
            throw th;
        }
    }

    public final Object poll() {
        if (this.f7286c <= 0) {
            return null;
        }
        Object peek = peek();
        mo29818b(1);
        return peek;
    }

    public final Object peek() {
        if (this.f7286c > 0) {
            return mo29817a(0);
        }
        return null;
    }

    /* renamed from: a */
    public final Object mo29817a(int i) {
        ByteArrayInputStream byteArrayInputStream;
        if (i < 0 || i >= this.f7286c) {
            throw new IndexOutOfBoundsException();
        }
        Cursor cursor = null;
        try {
            SQLiteDatabase sQLiteDatabase = this.f7284a;
            StringBuilder sb = new StringBuilder("SELECT value FROM List ORDER BY rowid LIMIT ");
            sb.append(i);
            sb.append(",1");
            cursor = sQLiteDatabase.rawQuery(sb.toString(), null);
            if (cursor.moveToNext()) {
                byteArrayInputStream = new ByteArrayInputStream(cursor.getBlob(0));
                Object b = this.f7285b.mo18183b(byteArrayInputStream);
                C1854jz.m3672a(byteArrayInputStream);
                m7134a(cursor);
                return b;
            }
            throw new NoSuchElementException();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        } catch (Throwable th) {
            m7134a(cursor);
            throw th;
        }
    }

    /* renamed from: b */
    public final void mo29818b(int i) {
        if (i > 0) {
            int i2 = this.f7286c;
            if (i <= i2) {
                if (i == i2) {
                    clear();
                    return;
                }
                Cursor cursor = null;
                try {
                    SQLiteDatabase sQLiteDatabase = this.f7284a;
                    StringBuilder sb = new StringBuilder("SELECT rowid FROM List ORDER BY rowid LIMIT ");
                    sb.append(i - 1);
                    sb.append(",1");
                    Cursor rawQuery = sQLiteDatabase.rawQuery(sb.toString(), null);
                    try {
                        if (rawQuery.moveToNext()) {
                            long j = rawQuery.getLong(0);
                            rawQuery.close();
                            StringBuilder sb2 = new StringBuilder("rowid <= ");
                            sb2.append(j);
                            int delete = this.f7284a.delete("List", sb2.toString(), null);
                            this.f7286c -= delete;
                            if (delete == i) {
                                m7134a((Cursor) null);
                                return;
                            }
                            StringBuilder sb3 = new StringBuilder("Try to delete ");
                            sb3.append(i);
                            sb3.append(", but deleted ");
                            sb3.append(delete);
                            throw new IllegalStateException(sb3.toString());
                        }
                        throw new IllegalStateException();
                    } catch (Throwable th) {
                        th = th;
                        cursor = rawQuery;
                        m7134a(cursor);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    m7134a(cursor);
                    throw th;
                }
            }
        }
        throw new IndexOutOfBoundsException();
    }

    /* renamed from: a */
    private static Cursor m7134a(Cursor cursor) {
        if (cursor != null) {
            cursor.close();
        }
        return null;
    }
}
