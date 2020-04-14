package com.inmobi.media;

import android.os.SystemClock;
import androidx.annotation.Nullable;

/* renamed from: com.inmobi.media.br */
/* compiled from: AdNetworkClient */
public final class C2238br {

    /* renamed from: a */
    private static final String f4646a = "br";

    /* renamed from: b */
    private C2239bs f4647b;

    public C2238br(C2239bs bsVar) {
        this.f4647b = bsVar;
    }

    @Nullable
    /* renamed from: a */
    public final C2240bt mo27983a() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            C2487fs a = new C2488ft(this.f4647b).mo28422a();
            C2240bt btVar = new C2240bt(this.f4647b, a);
            try {
                C2566hi.m5571a().mo28564a(this.f4647b.mo28416i());
                C2566hi.m5571a().mo28565b(a.mo28421d());
                if (a.mo28417a()) {
                    return btVar;
                }
                C2566hi.m5571a().mo28566c(SystemClock.elapsedRealtime() - elapsedRealtime);
                return btVar;
            } catch (Exception unused) {
                return btVar;
            }
        } catch (Exception unused2) {
            return null;
        }
    }
}
