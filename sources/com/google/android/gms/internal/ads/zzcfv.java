package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.internal.ads.zzsp.zzh;
import com.google.android.gms.internal.ads.zzsp.zzj.zzc;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzcfv implements zzcxn {
    private final boolean zzdyt;
    private final zzcfs zzfww;
    private final ArrayList zzfwx;
    private final zzh zzfwy;
    private final zzc zzfwz;

    zzcfv(zzcfs zzcfs, boolean z, ArrayList arrayList, zzh zzh, zzc zzc) {
        this.zzfww = zzcfs;
        this.zzdyt = z;
        this.zzfwx = arrayList;
        this.zzfwy = zzh;
        this.zzfwz = zzc;
    }

    public final Object apply(Object obj) {
        zzcfs zzcfs = this.zzfww;
        boolean z = this.zzdyt;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        byte[] zza = zzcfs.zzfwp.zza(z, this.zzfwx, this.zzfwy, this.zzfwz);
        ContentValues contentValues = new ContentValues();
        contentValues.put("timestamp", Long.valueOf(zzq.zzkq().currentTimeMillis()));
        contentValues.put("serialized_proto_data", zza);
        sQLiteDatabase.insert("offline_signal_contents", null, contentValues);
        String str = "UPDATE offline_signal_statistics SET value = value+1 WHERE statistic_name = '%s'";
        sQLiteDatabase.execSQL(String.format(str, new Object[]{"total_requests"}));
        if (!z) {
            sQLiteDatabase.execSQL(String.format(str, new Object[]{"failed_requests"}));
        }
        return null;
    }
}
