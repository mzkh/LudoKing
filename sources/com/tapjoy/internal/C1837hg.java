package com.tapjoy.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import javax.annotation.Nullable;

/* renamed from: com.tapjoy.internal.hg */
public abstract class C1837hg {

    /* renamed from: c */
    long f3848c;

    /* renamed from: d */
    boolean f3849d;

    /* renamed from: e */
    public C3117gs f3850e;

    /* renamed from: f */
    public String f3851f;

    /* renamed from: g */
    C3078fq f3852g;

    /* renamed from: a */
    public abstract void mo18173a(C3128ha haVar, C3085fw fwVar);

    /* renamed from: b */
    public abstract void mo18174b();

    /* renamed from: c */
    public boolean mo18175c() {
        return true;
    }

    /* renamed from: a */
    static void m3626a(Context context, @Nullable String str) {
        if (!C1852jq.m3669c(str)) {
            try {
                context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            } catch (Exception unused) {
            }
        }
    }
}
