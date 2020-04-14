package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.AdSize;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcwi {
    public static zzcvu zza(List<zzcvu> list, zzcvu zzcvu) {
        return (zzcvu) list.get(0);
    }

    public static zzua zza(Context context, List<zzcvu> list) {
        ArrayList arrayList = new ArrayList();
        for (zzcvu zzcvu : list) {
            if (zzcvu.zzgjv) {
                arrayList.add(AdSize.FLUID);
            } else {
                arrayList.add(new AdSize(zzcvu.width, zzcvu.height));
            }
        }
        return new zzua(context, (AdSize[]) arrayList.toArray(new AdSize[arrayList.size()]));
    }

    public static zzcvu zze(zzua zzua) {
        if (zzua.zzcco) {
            return new zzcvu(-3, 0, true);
        }
        return new zzcvu(zzua.width, zzua.height, false);
    }
}
