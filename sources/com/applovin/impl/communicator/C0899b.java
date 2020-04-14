package com.applovin.impl.communicator;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.sdk.C1227o;
import java.lang.ref.WeakReference;
import java.util.LinkedHashSet;
import java.util.Set;

/* renamed from: com.applovin.impl.communicator.b */
public class C0899b extends BroadcastReceiver {

    /* renamed from: a */
    private boolean f1640a = true;

    /* renamed from: b */
    private final String f1641b;

    /* renamed from: c */
    private final WeakReference<AppLovinCommunicatorSubscriber> f1642c;

    /* renamed from: d */
    private final Set<CommunicatorMessageImpl> f1643d = new LinkedHashSet();

    /* renamed from: e */
    private final Object f1644e = new Object();

    C0899b(String str, AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber) {
        this.f1641b = str;
        this.f1642c = new WeakReference<>(appLovinCommunicatorSubscriber);
    }

    /* renamed from: a */
    public String mo9254a() {
        return this.f1641b;
    }

    /* renamed from: a */
    public void mo9255a(boolean z) {
        this.f1640a = z;
    }

    /* renamed from: b */
    public AppLovinCommunicatorSubscriber mo9256b() {
        return (AppLovinCommunicatorSubscriber) this.f1642c.get();
    }

    /* renamed from: c */
    public boolean mo9257c() {
        return this.f1640a;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0899b)) {
            return false;
        }
        C0899b bVar = (C0899b) obj;
        if (!mo9254a().equals(bVar.mo9254a()) || (this.f1642c.get() == null ? this.f1642c.get() != bVar.f1642c.get() : !((AppLovinCommunicatorSubscriber) this.f1642c.get()).equals(bVar.f1642c.get()))) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return (this.f1641b.hashCode() * 31) + (this.f1642c.get() != null ? ((AppLovinCommunicatorSubscriber) this.f1642c.get()).hashCode() : 0);
    }

    public void onReceive(Context context, Intent intent) {
        if (mo9256b() == null) {
            C1227o.m2841i("AppLovinCommunicator", "Message received for GC'd subscriber");
            return;
        }
        CommunicatorMessageImpl communicatorMessageImpl = (CommunicatorMessageImpl) intent;
        boolean z = false;
        synchronized (this.f1644e) {
            if (!this.f1643d.contains(communicatorMessageImpl)) {
                this.f1643d.add(communicatorMessageImpl);
                z = true;
            }
        }
        if (z) {
            mo9256b().onMessageReceived((AppLovinCommunicatorMessage) communicatorMessageImpl);
        }
    }
}
