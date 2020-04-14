package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcse implements zzcru<zzcsb> {
    private final zzddl zzfoa;
    private final Context zzlk;

    public zzcse(zzddl zzddl, Context context) {
        this.zzfoa = zzddl;
        this.zzlk = context;
    }

    public final zzddi<zzcsb> zzalv() {
        return this.zzfoa.zzd(new zzcsd(this));
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ zzcsb zzamj() throws Exception {
        int i;
        boolean z;
        int i2;
        int i3;
        TelephonyManager telephonyManager = (TelephonyManager) this.zzlk.getSystemService("phone");
        String networkOperator = telephonyManager.getNetworkOperator();
        int networkType = telephonyManager.getNetworkType();
        int phoneType = telephonyManager.getPhoneType();
        zzq.zzkj();
        int i4 = -1;
        if (zzaul.zzq(this.zzlk, "android.permission.ACCESS_NETWORK_STATE")) {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.zzlk.getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                int type = activeNetworkInfo.getType();
                int ordinal = activeNetworkInfo.getDetailedState().ordinal();
                i3 = type;
                i4 = ordinal;
            } else {
                i3 = -1;
            }
            if (VERSION.SDK_INT >= 16) {
                i = i4;
                i2 = i3;
                z = connectivityManager.isActiveNetworkMetered();
            } else {
                i = i4;
                i2 = i3;
                z = false;
            }
        } else {
            i2 = -2;
            z = false;
            i = -1;
        }
        zzcsb zzcsb = new zzcsb(networkOperator, i2, networkType, phoneType, z, i);
        return zzcsb;
    }
}
