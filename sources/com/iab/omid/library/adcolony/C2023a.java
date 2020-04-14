package com.iab.omid.library.adcolony;

import android.content.Context;
import com.iab.omid.library.adcolony.p026b.C2032b;
import com.iab.omid.library.adcolony.p026b.C2035c;
import com.iab.omid.library.adcolony.p026b.C2038e;
import com.iab.omid.library.adcolony.p028d.C2045b;
import com.iab.omid.library.adcolony.p028d.C2049e;

/* renamed from: com.iab.omid.library.adcolony.a */
public class C2023a {

    /* renamed from: a */
    private boolean f3967a;

    /* renamed from: b */
    private void m3723b(Context context) {
        C2049e.m3841a((Object) context, "Application Context cannot be null");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo27326a() {
        return "1.2.17-Adcolony";
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo27327a(Context context) {
        m3723b(context);
        if (!mo27330b()) {
            mo27328a(true);
            C2038e.m3797a().mo27421a(context);
            C2032b.m3767a().mo27397a(context);
            C2045b.m3822a(context);
            C2035c.m3779a().mo27404a(context);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo27328a(boolean z) {
        this.f3967a = z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo27329a(String str) {
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo27330b() {
        return this.f3967a;
    }
}
