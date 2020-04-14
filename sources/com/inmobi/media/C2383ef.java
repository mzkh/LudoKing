package com.inmobi.media;

import android.content.Context;
import android.widget.FrameLayout;

/* renamed from: com.inmobi.media.ef */
/* compiled from: NativeScrollableContainer */
public abstract class C2383ef extends FrameLayout {

    /* renamed from: a */
    private final int f5071a;

    /* renamed from: com.inmobi.media.ef$a */
    /* compiled from: NativeScrollableContainer */
    interface C2384a {
        /* renamed from: a */
        int mo28238a(int i);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public abstract void mo28256a(C2216be beVar, C2385eg egVar, int i, int i2, C2384a aVar);

    public C2383ef(Context context, int i) {
        super(context);
        this.f5071a = i;
    }

    public final int getType() {
        return this.f5071a;
    }
}
