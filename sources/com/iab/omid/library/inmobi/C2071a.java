package com.iab.omid.library.inmobi;

import android.content.Context;
import com.iab.omid.library.inmobi.p032b.C2080b;
import com.iab.omid.library.inmobi.p032b.C2083c;
import com.iab.omid.library.inmobi.p032b.C2086e;
import com.iab.omid.library.inmobi.p034d.C2093b;
import com.iab.omid.library.inmobi.p034d.C2097e;

/* renamed from: com.iab.omid.library.inmobi.a */
public class C2071a {

    /* renamed from: a */
    private boolean f4099a;

    /* renamed from: b */
    private void m3930b(Context context) {
        C2097e.m4047a((Object) context, "Application Context cannot be null");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo27489a() {
        return "1.2.19-Inmobi";
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo27490a(Context context) {
        m3930b(context);
        if (!mo27493b()) {
            mo27491a(true);
            C2086e.m4001a().mo27584a(context);
            C2080b.m3971a().mo27560a(context);
            C2093b.m4027a(context);
            C2083c.m3983a().mo27567a(context);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo27491a(boolean z) {
        this.f4099a = z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo27492a(String str) {
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo27493b() {
        return this.f4099a;
    }
}
