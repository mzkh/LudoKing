package com.inmobi.media;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;

/* renamed from: com.inmobi.media.gk */
/* compiled from: PrefDao */
public final class C2517gk {
    @NonNull

    /* renamed from: a */
    public final C2494fy f5517a;

    public C2517gk(@NonNull Context context, @NonNull String str) {
        this.f5517a = C2494fy.m5249a(context, str);
    }

    /* renamed from: a */
    public final void mo28469a(@NonNull String str, @NonNull String str2) {
        this.f5517a.mo28439a(str, str2);
        mo28468a(System.currentTimeMillis() / 1000);
    }

    @WorkerThread
    /* renamed from: a */
    public final String mo28467a(@NonNull String str) {
        return this.f5517a.mo28442b(str);
    }

    @WorkerThread
    /* renamed from: a */
    public final long mo28466a() {
        return this.f5517a.mo28441b("last_ts", 0);
    }

    /* renamed from: a */
    public final void mo28468a(long j) {
        this.f5517a.mo28438a("last_ts", j);
    }
}
