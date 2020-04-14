package com.google.android.gms.internal.ads;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.internal.ads.zzsp.zzj.zza;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcfx {
    public static ArrayList<zza> zzb(SQLiteDatabase sQLiteDatabase) {
        ArrayList<zza> arrayList = new ArrayList<>();
        String str = "serialized_proto_data";
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        Cursor query = sQLiteDatabase2.query("offline_signal_contents", new String[]{str}, null, null, null, null, null);
        while (query.moveToNext()) {
            try {
                arrayList.add(zza.zzg(query.getBlob(query.getColumnIndexOrThrow(str))));
            } catch (zzdrg e) {
                zzaug.zzes("Unable to deserialize proto from offline signals database:");
                zzaug.zzes(e.getMessage());
            }
        }
        query.close();
        return arrayList;
    }

    public static int zza(SQLiteDatabase sQLiteDatabase, int i) {
        int i2 = 0;
        if (i == 2) {
            return 0;
        }
        Cursor zzc = zzc(sQLiteDatabase, i);
        if (zzc.getCount() > 0) {
            zzc.moveToNext();
            i2 = 0 + zzc.getInt(zzc.getColumnIndexOrThrow("value"));
        }
        zzc.close();
        return i2;
    }

    public static long zzb(SQLiteDatabase sQLiteDatabase, int i) {
        Cursor zzc = zzc(sQLiteDatabase, 2);
        long j = 0;
        if (zzc.getCount() > 0) {
            zzc.moveToNext();
            j = 0 + zzc.getLong(zzc.getColumnIndexOrThrow("value"));
        }
        zzc.close();
        return j;
    }

    private static Cursor zzc(SQLiteDatabase sQLiteDatabase, int i) {
        String[] strArr = {"value"};
        String[] strArr2 = new String[1];
        if (i == 0) {
            strArr2[0] = "failed_requests";
        } else if (i == 1) {
            strArr2[0] = "total_requests";
        } else if (i == 2) {
            strArr2[0] = "last_successful_request_time";
        }
        return sQLiteDatabase.query("offline_signal_statistics", strArr, "statistic_name = ?", strArr2, null, null, null);
    }
}
