package com.applovin.impl.sdk;

import com.applovin.impl.sdk.p018ad.C1090j;
import java.util.LinkedList;
import java.util.Queue;

/* renamed from: com.applovin.impl.sdk.r */
class C1232r {

    /* renamed from: a */
    private int f3118a;

    /* renamed from: b */
    private final Queue<C1090j> f3119b = new LinkedList();

    /* renamed from: c */
    private final Object f3120c = new Object();

    C1232r(int i) {
        mo10388a(i);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public int mo10387a() {
        int size;
        synchronized (this.f3120c) {
            size = this.f3119b.size();
        }
        return size;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo10388a(int i) {
        if (i > 25) {
            i = 25;
        }
        this.f3118a = i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo10389a(C1090j jVar) {
        synchronized (this.f3120c) {
            if (mo10387a() <= 25) {
                this.f3119b.offer(jVar);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public int mo10390b() {
        return this.f3118a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public boolean mo10391c() {
        boolean z;
        synchronized (this.f3120c) {
            z = mo10387a() >= this.f3118a;
        }
        return z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public boolean mo10392d() {
        boolean z;
        synchronized (this.f3120c) {
            z = mo10387a() == 0;
        }
        return z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public C1090j mo10393e() {
        C1090j jVar;
        try {
            synchronized (this.f3120c) {
                jVar = !mo10392d() ? (C1090j) this.f3119b.poll() : null;
            }
            return jVar;
        } catch (Exception unused) {
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public C1090j mo10394f() {
        C1090j jVar;
        synchronized (this.f3120c) {
            jVar = (C1090j) this.f3119b.peek();
        }
        return jVar;
    }
}
