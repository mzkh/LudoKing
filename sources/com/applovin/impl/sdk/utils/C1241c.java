package com.applovin.impl.sdk.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.applovin.impl.sdk.C1192i;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.applovin.impl.sdk.utils.c */
public class C1241c extends BroadcastReceiver {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final Set<C1241c> f3136a = new HashSet();

    /* renamed from: b */
    private final C1278m f3137b;

    private C1241c(long j, final C1192i iVar, final Runnable runnable) {
        iVar.mo10199Y();
        this.f3137b = C1278m.m3045a(j, iVar, new Runnable() {
            public void run() {
                iVar.mo10220ad().unregisterReceiver(C1241c.this);
                C1241c.this.mo10409a();
                Runnable runnable = runnable;
                if (runnable != null) {
                    runnable.run();
                }
                C1241c.f3136a.remove(C1241c.this);
            }
        });
        f3136a.add(this);
        iVar.mo10220ad().registerReceiver(this, new IntentFilter("com.applovin.application_paused"));
        iVar.mo10220ad().registerReceiver(this, new IntentFilter("com.applovin.application_resumed"));
    }

    /* renamed from: a */
    public static C1241c m2918a(long j, C1192i iVar, Runnable runnable) {
        return new C1241c(j, iVar, runnable);
    }

    /* renamed from: a */
    public void mo10409a() {
        this.f3137b.mo10441d();
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("com.applovin.application_paused".equals(action)) {
            this.f3137b.mo10439b();
        } else if ("com.applovin.application_resumed".equals(action)) {
            this.f3137b.mo10440c();
        }
    }
}
