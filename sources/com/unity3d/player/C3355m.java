package com.unity3d.player;

/* renamed from: com.unity3d.player.m */
final class C3355m {

    /* renamed from: a */
    private static boolean f8029a = false;

    /* renamed from: b */
    private boolean f8030b = false;

    /* renamed from: c */
    private boolean f8031c = false;

    /* renamed from: d */
    private boolean f8032d = true;

    /* renamed from: e */
    private boolean f8033e = false;

    C3355m() {
    }

    /* renamed from: a */
    static void m7752a() {
        f8029a = true;
    }

    /* renamed from: b */
    static void m7753b() {
        f8029a = false;
    }

    /* renamed from: c */
    static boolean m7754c() {
        return f8029a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo30741a(boolean z) {
        this.f8030b = z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final void mo30742b(boolean z) {
        this.f8032d = z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public final void mo30743c(boolean z) {
        this.f8033e = z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public final void mo30744d(boolean z) {
        this.f8031c = z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public final boolean mo30745d() {
        return this.f8032d;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public final boolean mo30746e() {
        return this.f8033e;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public final boolean mo30747f() {
        return f8029a && this.f8030b && !this.f8032d && !this.f8031c;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public final boolean mo30748g() {
        return this.f8031c;
    }

    public final String toString() {
        return super.toString();
    }
}
