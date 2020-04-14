package com.inmobi.media;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* renamed from: com.inmobi.media.fw */
/* compiled from: DbHelper */
public final class C2492fw extends SQLiteOpenHelper {

    /* renamed from: a */
    public static final String f5464a;

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    static {
        StringBuilder sb = new StringBuilder("com.im_");
        sb.append(C2506ge.m5320b());
        sb.append(".db");
        f5464a = sb.toString();
    }

    public C2492fw(Context context) {
        super(context, f5464a, null, 1);
    }
}
