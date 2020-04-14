package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.internal.ads.zzbk.zza;
import com.google.android.gms.internal.ads.zzbo.zza.zzb;
import com.google.android.gms.internal.ads.zzbo.zza.zzc;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public class zzde extends zzdd {
    private static final String TAG = "zzde";
    private Info zzwt;

    public static zzde zzb(Context context) {
        zza(context, true);
        return new zzde(context);
    }

    /* access modifiers changed from: protected */
    public final zzb zza(Context context, View view, Activity activity) {
        return null;
    }

    /* access modifiers changed from: protected */
    public final zzb zzb(Context context, View view, Activity activity) {
        return null;
    }

    private zzde(Context context) {
        super(context, "");
    }

    public static String zza(String str, String str2) {
        return zzci.zza(str, str2, true);
    }

    /* access modifiers changed from: protected */
    public final void zzb(zzdx zzdx, Context context, zzb zzb, zza zza) {
        if (zzdx.zzyb) {
            Info info = this.zzwt;
            if (info != null) {
                String id = info.getId();
                if (!TextUtils.isEmpty(id)) {
                    zzb.zzah(zzee.zzas(id));
                    zzb.zzb(zzc.DEVICE_IDENTIFIER_ANDROID_AD_ID);
                    zzb.zzb(this.zzwt.isLimitAdTrackingEnabled());
                }
                this.zzwt = null;
            }
        } else {
            zza(zza(zzdx, context, zzb, zza));
        }
    }

    /* access modifiers changed from: protected */
    public final List<Callable<Void>> zza(zzdx zzdx, Context context, zzb zzb, zza zza) {
        ArrayList arrayList = new ArrayList();
        if (zzdx.zzce() == null) {
            return arrayList;
        }
        zzdx zzdx2 = zzdx;
        zzet zzet = new zzet(zzdx2, "1ZdlqvbjLHrlsj3y/9QBfBegKjUOs/o1A88UhYHQ4Jmy6BR/w0ghZ+Zr+YvoOH1m", "dIiWdqkuIrENjYXIlbMEe8d+ulqMtIBUuOR2KqmaBXc=", zzb, zzdx.zzbz(), 24);
        arrayList.add(zzet);
        return arrayList;
    }

    public final void zza(Info info) {
        this.zzwt = info;
    }
}
