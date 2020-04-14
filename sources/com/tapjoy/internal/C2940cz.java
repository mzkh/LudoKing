package com.tapjoy.internal;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.provider.Settings.System;
import android.view.View;
import android.webkit.WebView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;

/* renamed from: com.tapjoy.internal.cz */
public final class C2940cz extends C2933cs {

    /* renamed from: a */
    public final C2934ct f6779a;

    /* renamed from: b */
    public final List f6780b = new ArrayList();

    /* renamed from: c */
    public C2964ds f6781c;

    /* renamed from: d */
    public boolean f6782d = false;

    /* renamed from: e */
    public boolean f6783e = false;

    /* renamed from: f */
    public String f6784f;

    /* renamed from: g */
    boolean f6785g;

    /* renamed from: h */
    private final C2935cu f6786h;

    /* renamed from: i */
    private C2962dq f6787i;

    /* renamed from: b */
    private void m6696b(View view) {
        this.f6787i = new C2962dq(view);
    }

    /* renamed from: c */
    public final View mo29926c() {
        return (View) this.f6787i.get();
    }

    /* renamed from: d */
    public final boolean mo29927d() {
        return this.f6782d && !this.f6783e;
    }

    C2940cz(C2934ct ctVar, C2935cu cuVar) {
        this.f6779a = ctVar;
        this.f6786h = cuVar;
        this.f6784f = UUID.randomUUID().toString();
        m6696b(null);
        if (cuVar.f6764f == C2936cv.HTML) {
            this.f6781c = new C2966dt(cuVar.f6760b);
        } else {
            this.f6781c = new C2967du(Collections.unmodifiableList(cuVar.f6761c), cuVar.f6762d);
        }
        this.f6781c.mo29954a();
        C2944dd.m6718a().f6800a.add(this);
        C2964ds dsVar = this.f6781c;
        C2949dg a = C2949dg.m6726a();
        WebView c = dsVar.mo29961c();
        JSONObject jSONObject = new JSONObject();
        C2957dm.m6746a(jSONObject, "impressionOwner", ctVar.f6756a);
        C2957dm.m6746a(jSONObject, "videoEventsOwner", ctVar.f6757b);
        C2957dm.m6746a(jSONObject, "isolateVerificationScripts", Boolean.valueOf(ctVar.f6758c));
        a.mo29948a(c, "init", jSONObject);
    }

    /* renamed from: a */
    public final void mo29921a() {
        if (!this.f6782d) {
            this.f6782d = true;
            C2944dd a = C2944dd.m6718a();
            boolean b = a.mo29942b();
            a.f6801b.add(this);
            if (!b) {
                C2951dh a2 = C2951dh.m6732a();
                C2945de.m6720a().f6807e = a2;
                C2945de a3 = C2945de.m6720a();
                a3.f6804b = new BroadcastReceiver() {
                    public final void onReceive(Context context, Intent intent) {
                        if (intent != null) {
                            if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                                C2945de.m6721a(C2945de.this, true);
                                return;
                            }
                            if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                                C2945de.m6721a(C2945de.this, false);
                                return;
                            }
                            if ("android.intent.action.SCREEN_ON".equals(intent.getAction())) {
                                KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
                                if (keyguardManager != null && !keyguardManager.inKeyguardRestrictedInputMode()) {
                                    C2945de.m6721a(C2945de.this, false);
                                }
                            }
                        }
                    }
                };
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.USER_PRESENT");
                a3.f6803a.registerReceiver(a3.f6804b, intentFilter);
                a3.f6805c = true;
                a3.mo29944c();
                if (C2945de.m6720a().mo29943b()) {
                    C2969dv.m6771a();
                    C2969dv.m6775b();
                }
                C2930cp cpVar = a2.f6817b;
                cpVar.f6751b = cpVar.mo29917a();
                cpVar.mo29918b();
                cpVar.f6750a.getContentResolver().registerContentObserver(System.CONTENT_URI, true, cpVar);
            }
            this.f6781c.mo29955a(C2951dh.m6732a().f6816a);
            this.f6781c.mo29957a(this, this.f6786h);
        }
    }

    /* renamed from: a */
    public final void mo29922a(View view) {
        if (!this.f6783e) {
            C2960do.m6754a((Object) view, "AdView is null");
            if (mo29926c() != view) {
                m6696b(view);
                this.f6781c.mo29962d();
                Collection<C2940cz> unmodifiableCollection = Collections.unmodifiableCollection(C2944dd.m6718a().f6800a);
                if (unmodifiableCollection != null && unmodifiableCollection.size() > 0) {
                    for (C2940cz czVar : unmodifiableCollection) {
                        if (czVar != this && czVar.mo29926c() == view) {
                            czVar.f6787i.clear();
                        }
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public final void mo29923b() {
        if (!this.f6783e) {
            this.f6787i.clear();
            if (!this.f6783e) {
                this.f6780b.clear();
            }
            this.f6783e = true;
            String str = "finishSession";
            C2949dg.m6726a().mo29948a(this.f6781c.mo29961c(), str, new Object[0]);
            C2944dd a = C2944dd.m6718a();
            boolean b = a.mo29942b();
            a.f6800a.remove(this);
            a.f6801b.remove(this);
            if (b && !a.mo29942b()) {
                C2951dh a2 = C2951dh.m6732a();
                C2969dv a3 = C2969dv.m6771a();
                C2969dv.m6777c();
                a3.f6849b.clear();
                C2969dv.f6844a.post(new Runnable() {
                    public final void run() {
                        C2969dv.this.f6853h.mo29977b();
                    }
                });
                C2945de a4 = C2945de.m6720a();
                if (!(a4.f6803a == null || a4.f6804b == null)) {
                    a4.f6803a.unregisterReceiver(a4.f6804b);
                    a4.f6804b = null;
                }
                a4.f6805c = false;
                a4.f6806d = false;
                a4.f6807e = null;
                C2930cp cpVar = a2.f6817b;
                cpVar.f6750a.getContentResolver().unregisterContentObserver(cpVar);
            }
            this.f6781c.mo29960b();
            this.f6781c = null;
        }
    }
}
