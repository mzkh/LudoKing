package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcfh extends SQLiteOpenHelper {
    public zzcfh(Context context) {
        super(context, "OfflineUpload.db", null, 1);
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE offline_signal_contents (timestamp INTEGER PRIMARY_KEY, serialized_proto_data BLOB)");
        sQLiteDatabase.execSQL("CREATE TABLE offline_signal_statistics (statistic_name TEXT PRIMARY_KEY, value INTEGER)");
        ContentValues contentValues = new ContentValues();
        String str = "statistic_name";
        contentValues.put(str, "failed_requests");
        Integer valueOf = Integer.valueOf(0);
        String str2 = "value";
        contentValues.put(str2, valueOf);
        String str3 = "offline_signal_statistics";
        sQLiteDatabase.insert(str3, null, contentValues);
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put(str, "total_requests");
        contentValues2.put(str2, valueOf);
        sQLiteDatabase.insert(str3, null, contentValues2);
        ContentValues contentValues3 = new ContentValues();
        contentValues3.put(str, "last_successful_request_time");
        contentValues3.put(str2, Long.valueOf(0));
        sQLiteDatabase.insert(str3, null, contentValues3);
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS offline_signal_contents");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS offline_signal_statistics");
    }
}
