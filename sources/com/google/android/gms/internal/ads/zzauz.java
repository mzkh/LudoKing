package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.telephony.TelephonyManager;
import com.google.android.gms.ads.internal.zzq;

@TargetApi(26)
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public class zzauz extends zzava {
    public final zzsv zza(Context context, TelephonyManager telephonyManager) {
        zzq.zzkj();
        if (zzaul.zzq(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return telephonyManager.isDataEnabled() ? zzsv.ENUM_TRUE : zzsv.ENUM_FALSE;
        }
        return zzsv.ENUM_FALSE;
    }
}
