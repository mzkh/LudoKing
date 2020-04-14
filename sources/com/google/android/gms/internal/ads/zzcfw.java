package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.internal.ads.zzsf.zza.C3512zza;
import com.google.android.gms.internal.ads.zzsp.zzj;
import com.google.android.gms.internal.ads.zzsp.zzj.zza;
import com.google.android.gms.internal.ads.zzsp.zzj.zzb;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcfw {
    private zzaxl zzdio;
    private zzcfj zzfws;
    private zzsd zzfxa;
    private Context zzlk;

    public zzcfw(Context context, zzaxl zzaxl, zzsd zzsd, zzcfj zzcfj) {
        this.zzlk = context;
        this.zzdio = zzaxl;
        this.zzfxa = zzsd;
        this.zzfws = zzcfj;
    }

    public final void zzakr() {
        try {
            this.zzfws.zza(new zzcfz(this));
        } catch (Exception e) {
            String str = "Error in offline signals database startup: ";
            String valueOf = String.valueOf(e.getMessage());
            zzaug.zzes(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ Void zza(SQLiteDatabase sQLiteDatabase) throws Exception {
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        ArrayList zzb = zzcfx.zzb(sQLiteDatabase);
        zzb zzbw = zzj.zznd().zzbv(this.zzlk.getPackageName()).zzbw(Build.MODEL);
        Integer valueOf = Integer.valueOf(0);
        zzj zzj = (zzj) ((zzdqw) zzbw.zzbz(zzcfx.zza(sQLiteDatabase2, 0)).zzc(zzb).zzca(zzcfx.zza(sQLiteDatabase2, 1)).zzem(zzq.zzkq().currentTimeMillis()).zzen(zzcfx.zzb(sQLiteDatabase2, 2)).zzazr());
        ArrayList arrayList = zzb;
        int size = arrayList.size();
        long j = 0;
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            zza zza = (zza) obj;
            if (zza.zznf() == zzsv.ENUM_TRUE && zza.getTimestamp() > j) {
                j = zza.getTimestamp();
            }
        }
        String str = "offline_signal_statistics";
        String str2 = "value";
        if (j != 0) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(str2, Long.valueOf(j));
            sQLiteDatabase2.update(str, contentValues, "statistic_name = 'last_successful_request_time'", null);
        }
        this.zzfxa.zza((zzsg) new zzcfy(zzj));
        zztk zztk = new zztk();
        zztk.zzcal = Integer.valueOf(this.zzdio.zzdwe);
        zztk.zzcam = Integer.valueOf(this.zzdio.zzdwf);
        zztk.zzcan = Integer.valueOf(this.zzdio.zzdwg ? 0 : 2);
        this.zzfxa.zza((zzsg) new zzcgb(zztk));
        this.zzfxa.zza(C3512zza.OFFLINE_UPLOAD);
        sQLiteDatabase2.delete("offline_signal_contents", null, null);
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put(str2, valueOf);
        String str3 = "statistic_name = ?";
        sQLiteDatabase2.update(str, contentValues2, str3, new String[]{"failed_requests"});
        ContentValues contentValues3 = new ContentValues();
        contentValues3.put(str2, valueOf);
        sQLiteDatabase2.update(str, contentValues3, str3, new String[]{"total_requests"});
        return null;
    }
}
