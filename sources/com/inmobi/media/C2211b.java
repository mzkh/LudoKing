package com.inmobi.media;

import android.os.Handler;
import android.os.Message;
import com.inmobi.ads.InMobiBanner;

/* renamed from: com.inmobi.media.b */
/* compiled from: BannerRefreshHandler */
public final class C2211b extends Handler {

    /* renamed from: a */
    private static final String f4512a = "b";

    /* renamed from: b */
    private InMobiBanner f4513b;

    public C2211b(InMobiBanner inMobiBanner) {
        this.f4513b = inMobiBanner;
    }

    public final void handleMessage(Message message) {
        if (message.what != 1) {
            int i = message.what;
        } else {
            this.f4513b.mo27658a(true);
        }
    }
}
