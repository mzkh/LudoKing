package com.iab.omid.library.inmobi.p032b;

import android.annotation.SuppressLint;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import com.iab.omid.library.inmobi.adsession.C2077a;

/* renamed from: com.iab.omid.library.inmobi.b.b */
public class C2080b {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a */
    private static C2080b f4124a = new C2080b();

    /* renamed from: b */
    private Context f4125b;

    /* renamed from: c */
    private BroadcastReceiver f4126c;

    /* renamed from: d */
    private boolean f4127d;

    /* renamed from: e */
    private boolean f4128e;

    /* renamed from: f */
    private C2082a f4129f;

    /* renamed from: com.iab.omid.library.inmobi.b.b$a */
    public interface C2082a {
        /* renamed from: a */
        void mo27566a(boolean z);
    }

    private C2080b() {
    }

    /* renamed from: a */
    public static C2080b m3971a() {
        return f4124a;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m3973a(boolean z) {
        if (this.f4128e != z) {
            this.f4128e = z;
            if (this.f4127d) {
                m3976g();
                C2082a aVar = this.f4129f;
                if (aVar != null) {
                    aVar.mo27566a(mo27564d());
                }
            }
        }
    }

    /* renamed from: e */
    private void m3974e() {
        this.f4126c = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                if (intent != null) {
                    if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                        C2080b.this.m3973a(true);
                        return;
                    }
                    if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                        C2080b.this.m3973a(false);
                        return;
                    }
                    if ("android.intent.action.SCREEN_ON".equals(intent.getAction())) {
                        KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
                        if (keyguardManager != null && !keyguardManager.inKeyguardRestrictedInputMode()) {
                            C2080b.this.m3973a(false);
                        }
                    }
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        this.f4125b.registerReceiver(this.f4126c, intentFilter);
    }

    /* renamed from: f */
    private void m3975f() {
        Context context = this.f4125b;
        if (context != null) {
            BroadcastReceiver broadcastReceiver = this.f4126c;
            if (broadcastReceiver != null) {
                context.unregisterReceiver(broadcastReceiver);
                this.f4126c = null;
            }
        }
    }

    /* renamed from: g */
    private void m3976g() {
        boolean z = !this.f4128e;
        for (C2077a adSessionStatePublisher : C2079a.m3964a().mo27555b()) {
            adSessionStatePublisher.getAdSessionStatePublisher().mo27605a(z);
        }
    }

    /* renamed from: a */
    public void mo27560a(@NonNull Context context) {
        this.f4125b = context.getApplicationContext();
    }

    /* renamed from: a */
    public void mo27561a(C2082a aVar) {
        this.f4129f = aVar;
    }

    /* renamed from: b */
    public void mo27562b() {
        m3974e();
        this.f4127d = true;
        m3976g();
    }

    /* renamed from: c */
    public void mo27563c() {
        m3975f();
        this.f4127d = false;
        this.f4128e = false;
        this.f4129f = null;
    }

    /* renamed from: d */
    public boolean mo27564d() {
        return !this.f4128e;
    }
}
