package com.applovin.impl.sdk.p020c;

/* renamed from: com.applovin.impl.sdk.c.e */
public final class C1109e {

    /* renamed from: a */
    private long f2643a;

    /* renamed from: b */
    private long f2644b;

    /* renamed from: c */
    private boolean f2645c;

    /* renamed from: d */
    private long f2646d;

    /* renamed from: e */
    private long f2647e;

    /* renamed from: a */
    public void mo10019a() {
        this.f2645c = true;
    }

    /* renamed from: a */
    public void mo10020a(long j) {
        this.f2643a += j;
    }

    /* renamed from: b */
    public void mo10021b(long j) {
        this.f2644b += j;
    }

    /* renamed from: b */
    public boolean mo10022b() {
        return this.f2645c;
    }

    /* renamed from: c */
    public long mo10023c() {
        return this.f2643a;
    }

    /* renamed from: d */
    public long mo10024d() {
        return this.f2644b;
    }

    /* renamed from: e */
    public void mo10025e() {
        this.f2646d++;
    }

    /* renamed from: f */
    public void mo10026f() {
        this.f2647e++;
    }

    /* renamed from: g */
    public long mo10027g() {
        return this.f2646d;
    }

    /* renamed from: h */
    public long mo10028h() {
        return this.f2647e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CacheStatsTracker{totalDownloadedBytes=");
        sb.append(this.f2643a);
        sb.append(", totalCachedBytes=");
        sb.append(this.f2644b);
        sb.append(", isHTMLCachingCancelled=");
        sb.append(this.f2645c);
        sb.append(", htmlResourceCacheSuccessCount=");
        sb.append(this.f2646d);
        sb.append(", htmlResourceCacheFailureCount=");
        sb.append(this.f2647e);
        sb.append('}');
        return sb.toString();
    }
}
