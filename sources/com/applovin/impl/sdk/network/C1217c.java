package com.applovin.impl.sdk.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.applovin.impl.sdk.network.c */
public class C1217c extends BroadcastReceiver {

    /* renamed from: a */
    private final List<C1218a> f3082a = Collections.synchronizedList(new ArrayList());

    /* renamed from: com.applovin.impl.sdk.network.c$a */
    public interface C1218a {
        /* renamed from: a */
        void mo10256a();

        /* renamed from: b */
        void mo10257b();
    }

    public C1217c(Context context) {
        context.getApplicationContext().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    /* renamed from: a */
    private static boolean m2763a(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            Object obj = extras.get("networkInfo");
            if (obj instanceof NetworkInfo) {
                return ((NetworkInfo) obj).isConnected();
            }
        }
        return false;
    }

    /* renamed from: a */
    public void mo10334a(C1218a aVar) {
        this.f3082a.add(aVar);
    }

    /* renamed from: b */
    public void mo10335b(C1218a aVar) {
        this.f3082a.remove(aVar);
    }

    public void onReceive(Context context, Intent intent) {
        if (intent.getAction() != null && intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE") && !isInitialStickyBroadcast()) {
            ArrayList<C1218a> arrayList = new ArrayList<>(this.f3082a);
            if (m2763a(intent)) {
                for (C1218a a : arrayList) {
                    a.mo10256a();
                }
            } else {
                for (C1218a b : arrayList) {
                    b.mo10257b();
                }
            }
        }
    }
}
