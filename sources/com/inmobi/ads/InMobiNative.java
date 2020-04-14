package com.inmobi.ads;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.inmobi.ads.InMobiAdRequestStatus.StatusCode;
import com.inmobi.ads.listeners.NativeAdEventListener;
import com.inmobi.ads.listeners.VideoEventListener;
import com.inmobi.media.C2205au;
import com.inmobi.media.C2463fd;
import com.inmobi.media.C2495fz;
import com.inmobi.media.C2505gd;
import com.inmobi.media.C2514gh;
import com.inmobi.media.C2528gq;
import com.inmobi.media.C2666x;
import com.inmobi.media.C2674z;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

public final class InMobiNative {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f4236a = "InMobiNative";

    /* renamed from: b */
    private C2666x f4237b;

    /* renamed from: c */
    private C2127a f4238c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public NativeAdEventListener f4239d;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: e */
    public VideoEventListener f4240e;

    /* renamed from: f */
    private WeakReference<View> f4241f;

    /* renamed from: g */
    private boolean f4242g;

    /* renamed from: h */
    private boolean f4243h = true;
    @NonNull

    /* renamed from: i */
    private C2205au f4244i = new C2205au();

    /* renamed from: j */
    private WeakReference<Context> f4245j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public LockScreenListener f4246k;

    public interface LockScreenListener {
        void onActionRequired(InMobiNative inMobiNative);
    }

    /* renamed from: com.inmobi.ads.InMobiNative$a */
    static class C2127a extends C2674z {

        /* renamed from: a */
        boolean f4247a = true;

        /* renamed from: b */
        private WeakReference<InMobiNative> f4248b;

        C2127a(@NonNull InMobiNative inMobiNative) {
            this.f4248b = new WeakReference<>(inMobiNative);
        }

        /* renamed from: e */
        public final void mo27706e() {
            InMobiNative inMobiNative = (InMobiNative) this.f4248b.get();
            if (inMobiNative == null) {
                C2514gh.m5342a(1, InMobiNative.f4236a, "Lost reference to InMobiNative! callback cannot be given");
                return;
            }
            if (inMobiNative.f4239d != null) {
                inMobiNative.f4239d.onAdReceived(inMobiNative);
            }
        }

        /* renamed from: a */
        public final void mo27685a() {
            InMobiNative inMobiNative = (InMobiNative) this.f4248b.get();
            if (inMobiNative == null) {
                C2514gh.m5342a(1, InMobiNative.f4236a, "Lost reference to InMobiNative! callback cannot be given");
                return;
            }
            if (!this.f4247a) {
                this.f4247a = true;
                if (inMobiNative.f4239d != null) {
                    inMobiNative.f4239d.onAdLoadSucceeded(inMobiNative);
                }
            }
        }

        /* renamed from: a */
        public final void mo27686a(InMobiAdRequestStatus inMobiAdRequestStatus) {
            InMobiNative inMobiNative = (InMobiNative) this.f4248b.get();
            if (inMobiNative == null) {
                C2514gh.m5342a(1, InMobiNative.f4236a, "Lost reference to InMobiNative! callback cannot be given");
                return;
            }
            if (!this.f4247a) {
                this.f4247a = true;
                if (inMobiNative.f4239d != null) {
                    inMobiNative.f4239d.onAdLoadFailed(inMobiNative, inMobiAdRequestStatus);
                }
            }
        }

        /* renamed from: f */
        public final void mo27707f() {
            InMobiNative inMobiNative = (InMobiNative) this.f4248b.get();
            if (inMobiNative == null) {
                C2514gh.m5342a(1, InMobiNative.f4236a, "Lost reference to InMobiNative! callback cannot be given");
                return;
            }
            if (inMobiNative.f4246k != null) {
                inMobiNative.f4246k.onActionRequired(inMobiNative);
            }
            if (inMobiNative.f4239d != null) {
                inMobiNative.f4239d.onAdFullScreenWillDisplay(inMobiNative);
            }
        }

        /* renamed from: b */
        public final void mo27689b() {
            InMobiNative inMobiNative = (InMobiNative) this.f4248b.get();
            if (inMobiNative == null) {
                C2514gh.m5342a(1, InMobiNative.f4236a, "Lost reference to InMobiNative! callback cannot be given");
                return;
            }
            if (inMobiNative.f4239d != null) {
                inMobiNative.f4239d.onAdFullScreenDisplayed(inMobiNative);
            }
        }

        /* renamed from: c */
        public final void mo27692c() {
            InMobiNative inMobiNative = (InMobiNative) this.f4248b.get();
            if (inMobiNative == null) {
                C2514gh.m5342a(1, InMobiNative.f4236a, "Lost reference to InMobiNative! callback cannot be given");
                return;
            }
            if (inMobiNative.f4239d != null) {
                inMobiNative.f4239d.onAdFullScreenDismissed(inMobiNative);
            }
        }

        /* renamed from: a */
        public final void mo27687a(@NonNull Map<Object, Object> map) {
            InMobiNative inMobiNative = (InMobiNative) this.f4248b.get();
            if (inMobiNative == null) {
                C2514gh.m5342a(1, InMobiNative.f4236a, "Lost reference to InMobiNative! callback cannot be given");
                return;
            }
            if (inMobiNative.f4239d != null) {
                inMobiNative.f4239d.onAdClicked(inMobiNative);
            }
        }

        /* renamed from: d */
        public final void mo27693d() {
            InMobiNative inMobiNative = (InMobiNative) this.f4248b.get();
            if (inMobiNative == null) {
                C2514gh.m5342a(1, InMobiNative.f4236a, "Lost reference to InMobiNative! callback cannot be given");
                return;
            }
            if (inMobiNative.f4246k != null) {
                inMobiNative.f4246k.onActionRequired(inMobiNative);
            }
            if (inMobiNative.f4239d != null) {
                inMobiNative.f4239d.onUserWillLeaveApplication(inMobiNative);
            }
        }

        /* renamed from: h */
        public final void mo27739h() {
            InMobiNative inMobiNative = (InMobiNative) this.f4248b.get();
            if (inMobiNative == null) {
                C2514gh.m5342a(1, InMobiNative.f4236a, "Lost reference to InMobiNative! callback cannot be given");
                return;
            }
            if (inMobiNative.f4239d != null) {
                inMobiNative.f4239d.onAdImpressed(inMobiNative);
            }
        }

        /* renamed from: i */
        public final void mo27740i() {
            InMobiNative inMobiNative = (InMobiNative) this.f4248b.get();
            if (inMobiNative == null) {
                C2514gh.m5342a(1, InMobiNative.f4236a, "Lost reference to InMobiNative! callback cannot be given");
                return;
            }
            if (inMobiNative.f4240e != null) {
                inMobiNative.f4240e.onVideoCompleted(inMobiNative);
            }
        }

        /* renamed from: j */
        public final void mo27741j() {
            InMobiNative inMobiNative = (InMobiNative) this.f4248b.get();
            if (inMobiNative == null) {
                C2514gh.m5342a(1, InMobiNative.f4236a, "Lost reference to InMobiNative! callback cannot be given");
                return;
            }
            if (inMobiNative.f4240e != null) {
                inMobiNative.f4240e.onVideoSkipped(inMobiNative);
            }
        }

        /* renamed from: a */
        public final void mo27738a(boolean z) {
            InMobiNative inMobiNative = (InMobiNative) this.f4248b.get();
            if (inMobiNative == null) {
                C2514gh.m5342a(1, InMobiNative.f4236a, "Lost reference to InMobiNative! callback cannot be given");
                return;
            }
            if (inMobiNative.f4240e != null) {
                inMobiNative.f4240e.onAudioStateChanged(inMobiNative, z);
            }
        }

        /* renamed from: a */
        public final void mo27688a(byte[] bArr) {
            InMobiNative inMobiNative = (InMobiNative) this.f4248b.get();
            if (inMobiNative == null) {
                C2514gh.m5342a(1, InMobiNative.f4236a, "Lost reference to InMobiNative! callback cannot be given");
                return;
            }
            if (inMobiNative.f4239d != null) {
                inMobiNative.f4239d.onRequestPayloadCreated(bArr);
            }
        }

        /* renamed from: b */
        public final void mo27690b(InMobiAdRequestStatus inMobiAdRequestStatus) {
            InMobiNative inMobiNative = (InMobiNative) this.f4248b.get();
            if (inMobiNative == null) {
                C2514gh.m5342a(1, InMobiNative.f4236a, "Lost reference to InMobiNative! callback cannot be given");
                return;
            }
            if (inMobiNative.f4239d != null) {
                inMobiNative.f4239d.onRequestPayloadCreationFailed(inMobiAdRequestStatus);
            }
        }
    }

    public InMobiNative(@NonNull Context context, long j, @NonNull NativeAdEventListener nativeAdEventListener) {
        if (!C2505gd.m5297b()) {
            C2514gh.m5342a(1, f4236a, "Please initialize the SDK before creating a Native ad");
            return;
        }
        this.f4244i.f4505a = j;
        this.f4245j = new WeakReference<>(context);
        this.f4239d = nativeAdEventListener;
        this.f4238c = new C2127a(this);
        this.f4237b = new C2666x(this.f4238c);
    }

    public final void setListener(@NonNull NativeAdEventListener nativeAdEventListener) {
        this.f4239d = nativeAdEventListener;
    }

    public final void setVideoEventListener(@NonNull VideoEventListener videoEventListener) {
        this.f4240e = videoEventListener;
    }

    /* renamed from: a */
    private boolean m4189a(boolean z) {
        if (!C2505gd.m5297b()) {
            C2514gh.m5342a(1, f4236a, "InMobiNative is not initialized, your call is ignored.");
        } else if (!z ? this.f4239d != null : !(this.f4237b == null && this.f4239d == null)) {
            WeakReference<Context> weakReference = this.f4245j;
            if (weakReference != null && weakReference.get() != null) {
                return true;
            }
            C2514gh.m5342a(1, f4236a, "Context supplied is null, your call is ignored.");
        } else {
            C2514gh.m5342a(1, f4236a, "Listener supplied is null, your call is ignored.");
        }
        return false;
    }

    public final void getSignals() {
        if (m4189a(false)) {
            this.f4238c.f4247a = false;
            m4191b();
            this.f4237b.mo27775H();
        }
    }

    public final void load(byte[] bArr) {
        if (m4189a(false)) {
            if (this.f4237b.mo27795p() == null) {
                C2514gh.m5342a(1, f4236a, "Either getSignals() is not called or InMobiNative is not initialized, your call is ignored.");
                return;
            }
            this.f4237b.mo27788b(bArr);
        }
    }

    /* renamed from: b */
    private void m4191b() {
        WeakReference<Context> weakReference = this.f4245j;
        Context context = weakReference == null ? null : (Context) weakReference.get();
        if (context != null) {
            this.f4237b.mo28883a(this.f4244i, context);
        }
    }

    public final void load() {
        try {
            if (m4189a(true)) {
                this.f4238c.f4247a = false;
                if (this.f4242g) {
                    this.f4237b.mo27778a(this.f4237b.mo27795p(), new InMobiAdRequestStatus(StatusCode.REPETITIVE_LOAD));
                    C2514gh.m5342a(1, f4236a, "You can call load() on an instance of InMobiNative only once if the ad request has been successful. Ignoring InMobiNative.load()");
                    return;
                }
                if (VERSION.SDK_INT >= 29) {
                    if ((this.f4245j == null ? null : (Context) this.f4245j.get()) != null) {
                        C2528gq.m5394a((Context) this.f4245j.get());
                    }
                }
                m4191b();
                this.f4237b.mo28886q();
            }
        } catch (Exception e) {
            C2463fd.m5161a().mo28382a(new C2495fz(e));
            C2514gh.m5342a(1, "InMobi", "Could not load ad; SDK encountered an unexpected error");
        }
    }

    public final void load(@NonNull Context context) {
        if (m4189a(true)) {
            this.f4245j = new WeakReference<>(context);
            load();
        }
    }

    public final void showOnLockScreen(@NonNull LockScreenListener lockScreenListener) {
        if (!C2505gd.m5297b()) {
            C2514gh.m5342a(1, f4236a, "Please initialize the SDK before calling showOnLockScreen.");
            return;
        }
        WeakReference<Context> weakReference = this.f4245j;
        if (weakReference == null || weakReference.get() == null) {
            C2514gh.m5342a(1, f4236a, "InMobiNative is not initialized. Provided context is null. Ignoring showOnLockScreen");
            return;
        }
        try {
            this.f4237b.mo28884b(this.f4244i, (Context) this.f4245j.get());
            this.f4246k = lockScreenListener;
        } catch (Exception unused) {
            C2514gh.m5342a(1, f4236a, "SDK encountered unexpected error in showOnLockScreen");
        }
    }

    public final void takeAction() {
        if (!C2505gd.m5297b()) {
            C2514gh.m5342a(1, f4236a, "Please initialize the SDK before calling takeAction.");
            return;
        }
        try {
            this.f4237b.mo28888s();
        } catch (Exception unused) {
            C2514gh.m5342a(1, f4236a, "SDK encountered unexpected error in takeAction");
        }
    }

    public final void pause() {
        try {
            this.f4237b.mo28889t();
        } catch (Exception unused) {
            C2514gh.m5342a(1, f4236a, "Could not pause ad; SDK encountered an unexpected error");
        }
    }

    public final void resume() {
        try {
            this.f4237b.mo28890w();
        } catch (Exception unused) {
            C2514gh.m5342a(1, f4236a, "Could not resume ad; SDK encountered an unexpected error");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00e5 A[Catch:{ Exception -> 0x00e9 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00e6 A[Catch:{ Exception -> 0x00e9 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View getPrimaryViewOfWidth(android.content.Context r7, android.view.View r8, android.view.ViewGroup r9, int r10) {
        /*
            r6 = this;
            java.lang.String r0 = "InMobi"
            r1 = 1
            r2 = 0
            boolean r3 = com.inmobi.media.C2505gd.m5297b()     // Catch:{ Exception -> 0x00e9 }
            if (r3 != 0) goto L_0x0012
            java.lang.String r7 = f4236a     // Catch:{ Exception -> 0x00e9 }
            java.lang.String r8 = "InMobiSdk is not initialized. Ignoring InMobiNative.getPrimaryView()"
            com.inmobi.media.C2514gh.m5342a(r1, r7, r8)     // Catch:{ Exception -> 0x00e9 }
            return r2
        L_0x0012:
            if (r7 != 0) goto L_0x001c
            java.lang.String r7 = f4236a     // Catch:{ Exception -> 0x00e9 }
            java.lang.String r8 = "View can not be rendered using null context"
            com.inmobi.media.C2514gh.m5342a(r1, r7, r8)     // Catch:{ Exception -> 0x00e9 }
            return r2
        L_0x001c:
            com.inmobi.media.x r3 = r6.f4237b     // Catch:{ Exception -> 0x00e9 }
            com.inmobi.media.l r3 = r3.mo27795p()     // Catch:{ Exception -> 0x00e9 }
            if (r3 != 0) goto L_0x0026
            r3 = r2
            goto L_0x002e
        L_0x0026:
            com.inmobi.media.x r3 = r6.f4237b     // Catch:{ Exception -> 0x00e9 }
            com.inmobi.media.l r3 = r3.mo27795p()     // Catch:{ Exception -> 0x00e9 }
            com.inmobi.media.v r3 = (com.inmobi.media.C2663v) r3     // Catch:{ Exception -> 0x00e9 }
        L_0x002e:
            if (r3 != 0) goto L_0x0038
            java.lang.String r7 = f4236a     // Catch:{ Exception -> 0x00e9 }
            java.lang.String r8 = "InMobiNative is not initialized. Ignoring InMobiNative.getPrimaryView()"
            com.inmobi.media.C2514gh.m5342a(r1, r7, r8)     // Catch:{ Exception -> 0x00e9 }
            return r2
        L_0x0038:
            java.lang.ref.WeakReference r4 = new java.lang.ref.WeakReference     // Catch:{ Exception -> 0x00e9 }
            r4.<init>(r7)     // Catch:{ Exception -> 0x00e9 }
            r6.f4245j = r4     // Catch:{ Exception -> 0x00e9 }
            r3.mo28740a(r7)     // Catch:{ Exception -> 0x00e9 }
            java.lang.ref.WeakReference r7 = new java.lang.ref.WeakReference     // Catch:{ Exception -> 0x00e9 }
            java.lang.Thread r4 = java.lang.Thread.currentThread()     // Catch:{ Exception -> 0x00e9 }
            android.os.Looper r5 = android.os.Looper.getMainLooper()     // Catch:{ Exception -> 0x00e9 }
            java.lang.Thread r5 = r5.getThread()     // Catch:{ Exception -> 0x00e9 }
            if (r4 != r5) goto L_0x00c5
            boolean r4 = com.inmobi.media.C2532gs.m5406e()     // Catch:{ Exception -> 0x00e9 }
            if (r4 != 0) goto L_0x005e
            r3.mo28818T()     // Catch:{ Exception -> 0x00e9 }
        L_0x005b:
            r8 = r2
            goto L_0x00d6
        L_0x005e:
            boolean r4 = r3.mo28779n()     // Catch:{ Exception -> 0x00e9 }
            if (r4 == 0) goto L_0x006d
            java.lang.String r8 = "Ad has expired, please create a new instance."
            com.inmobi.media.C2514gh.m5342a(r1, r0, r8)     // Catch:{ Exception -> 0x00e9 }
            r3.mo28818T()     // Catch:{ Exception -> 0x00e9 }
            goto L_0x005b
        L_0x006d:
            boolean r4 = r3.mo28819U()     // Catch:{ Exception -> 0x00e9 }
            if (r4 != 0) goto L_0x00a1
            int r4 = r3.mo28770f()     // Catch:{ Exception -> 0x00e9 }
            r5 = 7
            if (r4 == r5) goto L_0x00a1
            java.lang.String r8 = com.inmobi.media.C2663v.f5947r     // Catch:{ Exception -> 0x00e9 }
            java.lang.String r9 = "Ad Load is not complete. Please wait for the Ad to be in a ready state before calling getPrimaryView()."
            com.inmobi.media.C2514gh.m5342a(r1, r8, r9)     // Catch:{ Exception -> 0x00e9 }
            java.lang.ref.WeakReference<android.view.View> r8 = r3.f5948s     // Catch:{ Exception -> 0x00e9 }
            if (r8 == 0) goto L_0x005b
            java.lang.ref.WeakReference<android.view.View> r8 = r3.f5948s     // Catch:{ Exception -> 0x00e9 }
            java.lang.Object r8 = r8.get()     // Catch:{ Exception -> 0x00e9 }
            android.view.View r8 = (android.view.View) r8     // Catch:{ Exception -> 0x00e9 }
            if (r8 == 0) goto L_0x005b
            android.view.View r9 = new android.view.View     // Catch:{ Exception -> 0x00e9 }
            android.content.Context r10 = com.inmobi.media.C2505gd.m5298c()     // Catch:{ Exception -> 0x00e9 }
            r9.<init>(r10)     // Catch:{ Exception -> 0x00e9 }
            android.view.ViewGroup$LayoutParams r8 = r8.getLayoutParams()     // Catch:{ Exception -> 0x00e9 }
            r9.setLayoutParams(r8)     // Catch:{ Exception -> 0x00e9 }
            r8 = r9
            goto L_0x00d6
        L_0x00a1:
            com.inmobi.media.h r4 = r3.f5859g     // Catch:{ Exception -> 0x00e9 }
            if (r4 == 0) goto L_0x005b
            boolean r5 = r3.f5949t     // Catch:{ Exception -> 0x00e9 }
            r4.f5603r = r5     // Catch:{ Exception -> 0x00e9 }
            r4.f5602q = r10     // Catch:{ Exception -> 0x00e9 }
            com.inmobi.media.cu r10 = r4.getViewableAd()     // Catch:{ Exception -> 0x00e9 }
            android.view.View r8 = r10.mo28144a(r8, r9, r1)     // Catch:{ Exception -> 0x00e9 }
            java.lang.ref.WeakReference r9 = new java.lang.ref.WeakReference     // Catch:{ Exception -> 0x00e9 }
            r9.<init>(r8)     // Catch:{ Exception -> 0x00e9 }
            r3.f5948s = r9     // Catch:{ Exception -> 0x00e9 }
            android.os.Handler r9 = r3.f5862j     // Catch:{ Exception -> 0x00e9 }
            com.inmobi.media.v$1 r4 = new com.inmobi.media.v$1     // Catch:{ Exception -> 0x00e9 }
            r4.<init>(r10)     // Catch:{ Exception -> 0x00e9 }
            r9.post(r4)     // Catch:{ Exception -> 0x00e9 }
            goto L_0x00d6
        L_0x00c5:
            java.lang.String r8 = "Please ensure that you call getPrimaryView() on the UI thread"
            com.inmobi.media.C2514gh.m5342a(r1, r0, r8)     // Catch:{ Exception -> 0x00e9 }
            com.inmobi.ads.InMobiAdRequestStatus r8 = new com.inmobi.ads.InMobiAdRequestStatus     // Catch:{ Exception -> 0x00e9 }
            com.inmobi.ads.InMobiAdRequestStatus$StatusCode r9 = com.inmobi.ads.InMobiAdRequestStatus.StatusCode.CALLED_FROM_WRONG_THREAD     // Catch:{ Exception -> 0x00e9 }
            r8.<init>(r9)     // Catch:{ Exception -> 0x00e9 }
            r9 = 0
            r3.mo28743a(r8, r9)     // Catch:{ Exception -> 0x00e9 }
            goto L_0x005b
        L_0x00d6:
            r7.<init>(r8)     // Catch:{ Exception -> 0x00e9 }
            r6.f4241f = r7     // Catch:{ Exception -> 0x00e9 }
            java.lang.ref.WeakReference<android.view.View> r7 = r6.f4241f     // Catch:{ Exception -> 0x00e9 }
            java.lang.Object r7 = r7.get()     // Catch:{ Exception -> 0x00e9 }
            android.view.View r7 = (android.view.View) r7     // Catch:{ Exception -> 0x00e9 }
            if (r7 != 0) goto L_0x00e6
            return r2
        L_0x00e6:
            r6.f4242g = r1     // Catch:{ Exception -> 0x00e9 }
            return r7
        L_0x00e9:
            r7 = move-exception
            com.inmobi.media.fd r8 = com.inmobi.media.C2463fd.m5161a()
            com.inmobi.media.fz r9 = new com.inmobi.media.fz
            r9.<init>(r7)
            r8.mo28382a(r9)
            java.lang.String r7 = "Could not pause ad; SDK encountered an unexpected error"
            com.inmobi.media.C2514gh.m5342a(r1, r0, r7)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.ads.InMobiNative.getPrimaryViewOfWidth(android.content.Context, android.view.View, android.view.ViewGroup, int):android.view.View");
    }

    @Deprecated
    public final View getPrimaryViewOfWidth(View view, ViewGroup viewGroup, int i) {
        C2514gh.m5342a(1, f4236a, String.format("The %s API has been deprecated and API will be removed in the subsequent versions", new Object[]{"getPrimaryViewOfWidth(View, ViewGroup, int)"}));
        WeakReference<Context> weakReference = this.f4245j;
        if (weakReference != null && weakReference.get() != null) {
            return getPrimaryViewOfWidth((Context) this.f4245j.get(), view, viewGroup, i);
        }
        C2514gh.m5342a(1, f4236a, "InMobiNative is not initialized or provided context is null.");
        return null;
    }

    public final JSONObject getCustomAdContent() {
        if (!C2505gd.m5297b()) {
            C2514gh.m5342a(1, f4236a, "InMobiNative is not initialized.Ignoring InMobiNative.setExtras()");
            return null;
        }
        try {
            return this.f4237b.mo28891x();
        } catch (Exception e) {
            C2514gh.m5342a(1, f4236a, "Could not get the ad customJson ; SDK encountered unexpected error");
            C2463fd.m5161a().mo28382a(new C2495fz(e));
            return null;
        }
    }

    public final String getAdTitle() {
        if (!C2505gd.m5297b()) {
            C2514gh.m5342a(1, f4236a, "InMobiNative is not initialized.Ignoring InMobiNative.getAdTitle()");
            return null;
        }
        try {
            return this.f4237b.mo28892y();
        } catch (Exception e) {
            C2514gh.m5342a(1, f4236a, "Could not get the ad title; SDK encountered unexpected error");
            C2463fd.m5161a().mo28382a(new C2495fz(e));
            return null;
        }
    }

    public final String getAdDescription() {
        if (!C2505gd.m5297b()) {
            C2514gh.m5342a(1, f4236a, "InMobiNative is not initialized.Ignoring InMobiNative.getAdDescription()");
            return null;
        }
        try {
            return this.f4237b.mo28893z();
        } catch (Exception e) {
            C2514gh.m5342a(1, f4236a, "Could not get the description; SDK encountered unexpected error");
            C2463fd.m5161a().mo28382a(new C2495fz(e));
            return null;
        }
    }

    public final String getAdIconUrl() {
        if (!C2505gd.m5297b()) {
            C2514gh.m5342a(1, f4236a, "InMobiNative is not initialized.Ignoring InMobiNative.getAdIconUrl()");
            return null;
        }
        try {
            return this.f4237b.mo28876A();
        } catch (Exception e) {
            C2514gh.m5342a(1, f4236a, "Could not get the iconUrl; SDK encountered unexpected error");
            C2463fd.m5161a().mo28382a(new C2495fz(e));
            return null;
        }
    }

    public final String getAdLandingPageUrl() {
        if (!C2505gd.m5297b()) {
            C2514gh.m5342a(1, f4236a, "InMobiNative is not initialized.Ignoring InMobiNative.getAdLandingPageUrl()");
            return null;
        }
        try {
            return this.f4237b.mo28877B();
        } catch (Exception e) {
            C2514gh.m5342a(1, f4236a, "Could not get the adLandingPageUrl; SDK encountered unexpected error");
            C2463fd.m5161a().mo28382a(new C2495fz(e));
            return null;
        }
    }

    public final String getAdCtaText() {
        if (!C2505gd.m5297b()) {
            C2514gh.m5342a(1, f4236a, "InMobiNative is not initialized.Ignoring InMobiNative.getAdCtaText()");
            return null;
        }
        try {
            return this.f4237b.mo28878C();
        } catch (Exception e) {
            C2514gh.m5342a(1, f4236a, "Could not get the ctaText; SDK encountered unexpected error");
            C2463fd.m5161a().mo28382a(new C2495fz(e));
            return null;
        }
    }

    public final float getAdRating() {
        if (!C2505gd.m5297b()) {
            C2514gh.m5342a(1, f4236a, "InMobiNative is not initialized.Ignoring InMobiNative.getAdRating()");
            return 0.0f;
        }
        try {
            return this.f4237b.mo28879D();
        } catch (Exception e) {
            C2463fd.m5161a().mo28382a(new C2495fz(e));
            C2514gh.m5342a(1, "InMobi", "Could not get rating; SDK encountered an unexpected error");
            return 0.0f;
        }
    }

    public final boolean isAppDownload() {
        if (!C2505gd.m5297b()) {
            C2514gh.m5342a(1, f4236a, "InMobiNative is not initialized.Ignoring InMobiNative.isAppDownload()");
            return false;
        }
        try {
            return this.f4237b.mo28880E();
        } catch (Exception e) {
            C2514gh.m5342a(1, f4236a, "Could not get isAppDownload; SDK encountered unexpected error");
            C2463fd.m5161a().mo28382a(new C2495fz(e));
            return false;
        }
    }

    @Nullable
    public final Boolean isVideo() {
        if (!C2505gd.m5297b()) {
            C2514gh.m5342a(1, f4236a, "InMobiNative is not initialized.Ignoring InMobiNative.isVideo()");
            return null;
        }
        try {
            return this.f4237b.mo28881F();
        } catch (Exception e) {
            C2514gh.m5342a(1, f4236a, "Could not get isVideo; SDK encountered unexpected error");
            C2463fd.m5161a().mo28382a(new C2495fz(e));
            return null;
        }
    }

    public final void reportAdClickAndOpenLandingPage() {
        if (!C2505gd.m5297b()) {
            C2514gh.m5342a(1, f4236a, "InMobiNative is not initialized.Ignoring InMobiNative.reportAdClickAndOpenLandingPage()");
            return;
        }
        try {
            this.f4237b.mo28882G();
        } catch (Exception e) {
            C2514gh.m5342a(1, f4236a, "reportAdClickAndOpenLandingPage failed; SDK encountered unexpected error");
            C2463fd.m5161a().mo28382a(new C2495fz(e));
        }
    }

    public final boolean isReady() {
        if (C2505gd.m5297b()) {
            return this.f4237b.mo28885o();
        }
        C2514gh.m5342a(1, f4236a, "InMobiNative is not initialized.Ignoring InMobiNative.isReady()");
        return false;
    }

    public final JSONObject getAdMetaInfo() {
        return C2505gd.m5297b() ? this.f4237b.mo27797v() : new JSONObject();
    }

    public final void setExtras(Map<String, String> map) {
        if (!C2505gd.m5297b()) {
            C2514gh.m5342a(1, f4236a, "InMobiNative is not initialized.Ignoring InMobiNative.setExtras()");
        } else {
            this.f4244i.f4507c = map;
        }
    }

    public final void setKeywords(String str) {
        if (!C2505gd.m5297b()) {
            C2514gh.m5342a(1, f4236a, "InMobiNative is not initialized.Ignoring InMobiNative.setKeywords()");
        } else {
            this.f4244i.f4506b = str;
        }
    }

    public final void destroy() {
        try {
            if (!C2505gd.m5297b()) {
                C2514gh.m5342a(1, f4236a, "InMobiNative is not initialized. Ignoring InMobiNative.destroy()");
            }
            View view = this.f4241f == null ? null : (View) this.f4241f.get();
            if (view != null) {
                ((ViewGroup) view).removeAllViews();
            }
            this.f4237b.mo28887r();
            this.f4239d = null;
            this.f4240e = null;
            this.f4242g = false;
        } catch (Exception e) {
            C2514gh.m5342a(1, f4236a, "Failed to destroy ad; SDK encountered an unexpected error");
            C2463fd.m5161a().mo28382a(new C2495fz(e));
        }
    }

    public final String getCreativeId() {
        return C2505gd.m5297b() ? this.f4237b.mo27796u() : "";
    }
}
