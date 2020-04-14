package com.inmobi.media;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.inmobi.media.aq */
/* compiled from: Click */
public final class C2183aq {

    /* renamed from: a */
    int f4446a;

    /* renamed from: b */
    public String f4447b;

    /* renamed from: c */
    public Map<String, String> f4448c;

    /* renamed from: d */
    long f4449d;

    /* renamed from: e */
    long f4450e;

    /* renamed from: f */
    int f4451f;

    /* renamed from: g */
    AtomicBoolean f4452g;

    /* renamed from: h */
    boolean f4453h;

    /* renamed from: i */
    boolean f4454i;

    C2183aq(String str, boolean z, boolean z2, int i) {
        this(new Random().nextInt() & Integer.MAX_VALUE, str, new HashMap(), z, z2, i, System.currentTimeMillis(), System.currentTimeMillis());
    }

    C2183aq(String str, Map<String, String> map, boolean z, int i) {
        this(new Random().nextInt() & Integer.MAX_VALUE, str, map, z, false, i, System.currentTimeMillis(), System.currentTimeMillis());
    }

    C2183aq(int i, String str, Map<String, String> map, boolean z, boolean z2, int i2, long j, long j2) {
        this.f4446a = i;
        this.f4447b = str;
        this.f4448c = map;
        this.f4449d = j;
        this.f4450e = j2;
        this.f4451f = i2;
        this.f4452g = new AtomicBoolean(false);
        this.f4454i = z;
        this.f4453h = z2;
    }

    /* renamed from: a */
    public final boolean mo27906a(long j) {
        return System.currentTimeMillis() - this.f4450e > j * 1000;
    }
}
