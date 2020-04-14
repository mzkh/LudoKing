package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzcfl implements zzdcz<SQLiteDatabase> {
    private final /* synthetic */ zzcxn zzfvz;

    zzcfl(zzcfj zzcfj, zzcxn zzcxn) {
        this.zzfvz = zzcxn;
    }

    public final void zzb(Throwable th) {
        String valueOf = String.valueOf(th.getMessage());
        String str = "Failed to get offline signal database: ";
        zzaug.zzes(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        try {
            this.zzfvz.apply((SQLiteDatabase) obj);
        } catch (Exception e) {
            String str = "Error executing function on offline signal database: ";
            String valueOf = String.valueOf(e.getMessage());
            zzaug.zzes(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
    }
}
