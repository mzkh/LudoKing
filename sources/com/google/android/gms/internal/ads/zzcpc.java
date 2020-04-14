package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcpc implements zzcru<zzcoz> {
    private final zzddl zzfoa;
    private final Context zzlk;

    public zzcpc(zzddl zzddl, Context context) {
        this.zzfoa = zzddl;
        this.zzlk = context;
    }

    public final zzddi<zzcoz> zzalv() {
        return this.zzfoa.zzd(new zzcpb(this));
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ zzcoz zzalz() throws Exception {
        double d;
        Intent registerReceiver = this.zzlk.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        boolean z = false;
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("status", -1);
            double intExtra2 = (double) registerReceiver.getIntExtra("level", -1);
            double intExtra3 = (double) registerReceiver.getIntExtra("scale", -1);
            Double.isNaN(intExtra2);
            Double.isNaN(intExtra3);
            d = intExtra2 / intExtra3;
            if (intExtra == 2 || intExtra == 5) {
                z = true;
            }
        } else {
            d = -1.0d;
        }
        return new zzcoz(d, z);
    }
}
