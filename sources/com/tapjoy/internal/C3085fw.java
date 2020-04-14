package com.tapjoy.internal;

import com.facebook.internal.ServerProtocol;
import com.tapjoy.internal.C1823gf.C1825a;

/* renamed from: com.tapjoy.internal.fw */
public final class C3085fw {

    /* renamed from: a */
    public C3078fq f7271a;

    /* renamed from: b */
    public volatile C1825a f7272b;

    /* renamed from: c */
    public int f7273c;

    /* renamed from: d */
    public volatile C1825a f7274d;

    /* renamed from: e */
    public volatile C1825a f7275e;

    /* renamed from: a */
    public final void mo30148a() {
        mo30149a(16);
        C1825a aVar = this.f7274d;
        if (aVar != null) {
            this.f7274d = null;
            aVar.mo18101b().mo18104c();
        }
    }

    /* renamed from: a */
    public final synchronized void mo30149a(int i) {
        C1825a aVar = this.f7272b;
        if (aVar != null && this.f7273c < i) {
            this.f7273c = i | this.f7273c;
            aVar.mo18099a(ServerProtocol.DIALOG_PARAM_STATE, (Object) Integer.valueOf(this.f7273c)).mo18101b().mo18104c();
        }
    }
}
