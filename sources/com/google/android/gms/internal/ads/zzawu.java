package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzawu {
    @GuardedBy("this")
    private final BroadcastReceiver zzdvg = new zzawt(this);
    @GuardedBy("this")
    private final Map<BroadcastReceiver, IntentFilter> zzdvh = new WeakHashMap();
    private boolean zzdvi;
    private boolean zzye = false;
    private Context zzzc;

    public final synchronized void initialize(Context context) {
        if (!this.zzye) {
            this.zzzc = context.getApplicationContext();
            if (this.zzzc == null) {
                this.zzzc = context;
            }
            zzza.initialize(this.zzzc);
            this.zzdvi = ((Boolean) zzuv.zzon().zzd(zzza.zzcok)).booleanValue();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            this.zzzc.registerReceiver(this.zzdvg, intentFilter);
            this.zzye = true;
        }
    }

    public final synchronized void zza(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (this.zzdvi) {
            this.zzdvh.put(broadcastReceiver, intentFilter);
        } else {
            context.registerReceiver(broadcastReceiver, intentFilter);
        }
    }

    public final synchronized void zza(Context context, BroadcastReceiver broadcastReceiver) {
        if (this.zzdvi) {
            this.zzdvh.remove(broadcastReceiver);
        } else {
            context.unregisterReceiver(broadcastReceiver);
        }
    }

    /* access modifiers changed from: private */
    public final synchronized void zzc(Context context, Intent intent) {
        for (Entry entry : this.zzdvh.entrySet()) {
            if (((IntentFilter) entry.getValue()).hasAction(intent.getAction())) {
                ((BroadcastReceiver) entry.getKey()).onReceive(context, intent);
            }
        }
    }
}
