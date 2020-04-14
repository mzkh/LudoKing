package com.inmobi.media;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.inmobi.media.gf */
/* compiled from: ApplicationFocusChangeObserver */
public class C2507gf {

    /* renamed from: a */
    public static List<C2512c> f5503a = new ArrayList();

    /* renamed from: b */
    public static HandlerThread f5504b = null;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final String f5505c = "gf";
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static boolean f5506d = false;

    /* renamed from: com.inmobi.media.gf$a */
    /* compiled from: ApplicationFocusChangeObserver */
    static class C2510a extends Handler {

        /* renamed from: a */
        boolean f5511a = true;

        C2510a(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            if (!C2507gf.f5506d) {
                if (message.what != 1001 || !this.f5511a) {
                    if (message.what == 1002 && !this.f5511a) {
                        this.f5511a = true;
                        C2507gf.m5326a(true);
                        C2507gf.f5505c;
                    }
                    return;
                }
                this.f5511a = false;
                C2507gf.m5326a(false);
                C2507gf.f5505c;
            }
        }
    }

    /* renamed from: com.inmobi.media.gf$b */
    /* compiled from: ApplicationFocusChangeObserver */
    static class C2511b {

        /* renamed from: a */
        static final C2507gf f5512a = new C2507gf(0);
    }

    /* renamed from: com.inmobi.media.gf$c */
    /* compiled from: ApplicationFocusChangeObserver */
    public interface C2512c {
        /* renamed from: a */
        void mo28465a(boolean z);
    }

    /* synthetic */ C2507gf(byte b) {
        this();
    }

    /* renamed from: a */
    public static C2507gf m5325a() {
        return C2511b.f5512a;
    }

    private C2507gf() {
    }

    /* renamed from: b */
    public static void m5327b() {
        f5506d = true;
    }

    /* renamed from: c */
    public static void m5328c() {
        f5506d = false;
    }

    /* renamed from: a */
    static /* synthetic */ void m5326a(final boolean z) {
        Context c = C2505gd.m5298c();
        if (c != null) {
            new Handler(c.getMainLooper()).post(new Runnable() {
                public final void run() {
                    for (C2512c a : C2507gf.f5503a) {
                        try {
                            a.mo28465a(z);
                        } catch (Exception unused) {
                            C2507gf.f5505c;
                        }
                    }
                }
            });
        }
    }
}
