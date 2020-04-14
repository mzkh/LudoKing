package com.applovin.impl.sdk.p021d;

import android.content.Context;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.C1227o;
import com.applovin.impl.sdk.p020c.C1115i;

/* renamed from: com.applovin.impl.sdk.d.a */
public abstract class C1122a implements Runnable {

    /* renamed from: a */
    private final String f2744a;
    /* access modifiers changed from: protected */

    /* renamed from: b */
    public final C1192i f2745b;

    /* renamed from: c */
    private final C1227o f2746c;

    /* renamed from: d */
    private final Context f2747d;

    /* renamed from: e */
    private final boolean f2748e;

    public C1122a(String str, C1192i iVar) {
        this(str, iVar, false);
    }

    public C1122a(String str, C1192i iVar, boolean z) {
        this.f2744a = str;
        this.f2745b = iVar;
        this.f2746c = iVar.mo10249v();
        this.f2747d = iVar.mo10179D();
        this.f2748e = z;
    }

    /* renamed from: a */
    public abstract C1115i mo9338a();

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo10068a(String str) {
        this.f2746c.mo10378b(this.f2744a, str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo10069a(String str, Throwable th) {
        this.f2746c.mo10379b(this.f2744a, str, th);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo10070b(String str) {
        this.f2746c.mo10380c(this.f2744a, str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo10071c(String str) {
        this.f2746c.mo10381d(this.f2744a, str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo10072d(String str) {
        this.f2746c.mo10382e(this.f2744a, str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public C1192i mo10073e() {
        return this.f2745b;
    }

    /* renamed from: f */
    public String mo10074f() {
        return this.f2744a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public Context mo10075g() {
        return this.f2747d;
    }

    /* renamed from: h */
    public boolean mo10076h() {
        return this.f2748e;
    }
}
