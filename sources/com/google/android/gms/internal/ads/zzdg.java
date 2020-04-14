package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzbk.zza;
import com.google.android.gms.internal.ads.zzbo.zza.zzb;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdg extends zzdd {
    public static zzdg zza(String str, Context context, boolean z) {
        zza(context, z);
        return new zzdg(context, str, z);
    }

    private zzdg(Context context, String str, boolean z) {
        super(context, str, z);
    }

    /* access modifiers changed from: protected */
    public final List<Callable<Void>> zza(zzdx zzdx, Context context, zzb zzb, zza zza) {
        if (zzdx.zzce() == null || !this.zzwo) {
            return super.zza(zzdx, context, zzb, zza);
        }
        int zzbz = zzdx.zzbz();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(super.zza(zzdx, context, zzb, zza));
        zzet zzet = new zzet(zzdx, "1ZdlqvbjLHrlsj3y/9QBfBegKjUOs/o1A88UhYHQ4Jmy6BR/w0ghZ+Zr+YvoOH1m", "dIiWdqkuIrENjYXIlbMEe8d+ulqMtIBUuOR2KqmaBXc=", zzb, zzbz, 24);
        arrayList.add(zzet);
        return arrayList;
    }
}
