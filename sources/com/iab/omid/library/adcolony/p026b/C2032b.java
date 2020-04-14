package com.iab.omid.library.adcolony.p026b;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import com.iab.omid.library.adcolony.adsession.C2029a;

/* renamed from: com.iab.omid.library.adcolony.b.b */
public class C2032b {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a */
    private static C2032b f4025a = new C2032b();

    /* renamed from: b */
    private Context f4026b;

    /* renamed from: c */
    private BroadcastReceiver f4027c;

    /* renamed from: d */
    private boolean f4028d;

    /* renamed from: e */
    private boolean f4029e;

    /* renamed from: f */
    private C2034a f4030f;

    /* renamed from: com.iab.omid.library.adcolony.b.b$a */
    public interface C2034a {
        /* renamed from: a */
        void mo27403a(boolean z);
    }

    private C2032b() {
    }

    /* renamed from: a */
    public static C2032b m3767a() {
        return f4025a;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m3769a(boolean z) {
        if (this.f4029e != z) {
            this.f4029e = z;
            if (this.f4028d) {
                m3772g();
                C2034a aVar = this.f4030f;
                if (aVar != null) {
                    aVar.mo27403a(mo27401d());
                }
            }
        }
    }

    /* renamed from: e */
    private void m3770e() {
        this.f4027c = new BroadcastReceiver() {
            /* JADX WARNING: Code restructure failed: missing block: B:13:0x0043, code lost:
                if (r3.inKeyguardRestrictedInputMode() == false) goto L_0x0023;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onReceive(android.content.Context r3, android.content.Intent r4) {
                /*
                    r2 = this;
                    if (r4 != 0) goto L_0x0003
                    return
                L_0x0003:
                    java.lang.String r0 = r4.getAction()
                    java.lang.String r1 = "android.intent.action.SCREEN_OFF"
                    boolean r0 = r1.equals(r0)
                    if (r0 == 0) goto L_0x0016
                    com.iab.omid.library.adcolony.b.b r3 = com.iab.omid.library.adcolony.p026b.C2032b.this
                    r4 = 1
                    r3.m3769a(r4)
                    goto L_0x0046
                L_0x0016:
                    java.lang.String r0 = r4.getAction()
                    java.lang.String r1 = "android.intent.action.USER_PRESENT"
                    boolean r0 = r1.equals(r0)
                    r1 = 0
                    if (r0 == 0) goto L_0x0029
                L_0x0023:
                    com.iab.omid.library.adcolony.b.b r3 = com.iab.omid.library.adcolony.p026b.C2032b.this
                    r3.m3769a(r1)
                    goto L_0x0046
                L_0x0029:
                    java.lang.String r4 = r4.getAction()
                    java.lang.String r0 = "android.intent.action.SCREEN_ON"
                    boolean r4 = r0.equals(r4)
                    if (r4 == 0) goto L_0x0046
                    java.lang.String r4 = "keyguard"
                    java.lang.Object r3 = r3.getSystemService(r4)
                    android.app.KeyguardManager r3 = (android.app.KeyguardManager) r3
                    if (r3 == 0) goto L_0x0046
                    boolean r3 = r3.inKeyguardRestrictedInputMode()
                    if (r3 != 0) goto L_0x0046
                    goto L_0x0023
                L_0x0046:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.iab.omid.library.adcolony.p026b.C2032b.C20331.onReceive(android.content.Context, android.content.Intent):void");
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        this.f4026b.registerReceiver(this.f4027c, intentFilter);
    }

    /* renamed from: f */
    private void m3771f() {
        Context context = this.f4026b;
        if (context != null) {
            BroadcastReceiver broadcastReceiver = this.f4027c;
            if (broadcastReceiver != null) {
                context.unregisterReceiver(broadcastReceiver);
                this.f4027c = null;
            }
        }
    }

    /* renamed from: g */
    private void m3772g() {
        boolean z = !this.f4029e;
        for (C2029a adSessionStatePublisher : C2031a.m3760a().mo27392b()) {
            adSessionStatePublisher.getAdSessionStatePublisher().mo27441a(z);
        }
    }

    /* renamed from: a */
    public void mo27397a(@NonNull Context context) {
        this.f4026b = context.getApplicationContext();
    }

    /* renamed from: a */
    public void mo27398a(C2034a aVar) {
        this.f4030f = aVar;
    }

    /* renamed from: b */
    public void mo27399b() {
        m3770e();
        this.f4028d = true;
        m3772g();
    }

    /* renamed from: c */
    public void mo27400c() {
        m3771f();
        this.f4028d = false;
        this.f4029e = false;
        this.f4030f = null;
    }

    /* renamed from: d */
    public boolean mo27401d() {
        return !this.f4029e;
    }
}
