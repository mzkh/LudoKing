package com.inmobi.media;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.facebook.share.internal.ShareConstants;
import com.iab.omid.library.inmobi.adsession.video.Position;
import com.iab.omid.library.inmobi.adsession.video.VastProperties;
import com.inmobi.media.C2319dd.C2323a;
import com.inmobi.media.C2452f.C2453a;
import com.inmobi.media.C2542h.C2552c;
import com.tapjoy.TJAdUnitConstants.String;
import java.lang.ref.WeakReference;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* renamed from: com.inmobi.media.i */
/* compiled from: NativeVideoAdContainer */
public class C2596i extends C2542h {
    /* access modifiers changed from: private */

    /* renamed from: x */
    public static final String f5747x = "i";

    /* renamed from: w */
    public final C2323a f5748w = new C2323a() {
        /* renamed from: a */
        public final void mo28179a(View view, boolean z) {
            C2596i.this.mo28493a(z);
            C2596i.m5669a(C2596i.this, view, z);
        }
    };

    /* renamed from: y */
    private WeakReference<View> f5749y;

    /* renamed from: z */
    private final C2453a f5750z = new C2453a() {
        /* renamed from: a */
        public final void mo28374a() {
            C2596i.f5747x;
            C2552c h = C2596i.this.mo28497h();
            if (h != null) {
                h.mo28542a();
            }
        }

        /* renamed from: a */
        public final void mo28375a(@NonNull Object obj) {
            if (C2596i.this.mo28504o() != null) {
                C2235bp bpVar = (C2235bp) obj;
                C2596i.f5747x;
                String str = "didRequestFullScreen";
                bpVar.f4542v.put(str, Boolean.TRUE);
                String str2 = "isFullScreen";
                bpVar.f4542v.put(str2, Boolean.TRUE);
                String str3 = "shouldAutoPlay";
                bpVar.f4542v.put(str3, Boolean.TRUE);
                if (bpVar.f4545y != null) {
                    bpVar.f4545y.f4542v.put(str, Boolean.TRUE);
                    bpVar.f4545y.f4542v.put(str2, Boolean.TRUE);
                    bpVar.f4545y.f4542v.put(str3, Boolean.TRUE);
                }
                if (C2596i.this.getPlacementType() == 0) {
                    C2596i.this.getViewableAd().mo28146a(1);
                    bpVar.mo27940a("fullscreen", C2596i.this.m5675h(bpVar));
                }
                C2552c h = C2596i.this.mo28497h();
                if (h != null) {
                    h.mo28545b();
                }
            }
        }

        /* renamed from: b */
        public final void mo28376b(@NonNull Object obj) {
            C2596i.f5747x;
            C2235bp bpVar = (C2235bp) obj;
            String str = "didRequestFullScreen";
            bpVar.f4542v.put(str, Boolean.FALSE);
            String str2 = "isFullScreen";
            bpVar.f4542v.put(str2, Boolean.FALSE);
            if (bpVar.f4545y != null) {
                bpVar.f4545y.f4542v.put(str, Boolean.FALSE);
                bpVar.f4545y.f4542v.put(str2, Boolean.FALSE);
                bpVar.f4545y.f4545y = null;
            }
            bpVar.f4545y = null;
            if (C2596i.this.getPlacementType() == 0) {
                C2596i.this.getViewableAd().mo28146a(2);
                if (C2596i.this.f5597l != null) {
                    C2596i.this.f5597l.getViewableAd().mo28146a(16);
                }
                bpVar.mo27940a("exitFullscreen", C2596i.this.m5675h(bpVar));
            } else {
                C2596i.this.getViewableAd().mo28146a(3);
            }
            C2552c h = C2596i.this.mo28497h();
            if (h != null) {
                h.mo28549f();
            }
        }
    };

    /* renamed from: b */
    private void m5672b(C2390ej ejVar) {
        int videoVolume = ejVar.getVideoVolume();
        int lastVolume = ejVar.getLastVolume();
        if (videoVolume != lastVolume && lastVolume > 0) {
            m5674b(true);
            ejVar.setLastVolume(videoVolume);
        }
    }

    /* renamed from: b */
    private void m5674b(boolean z) {
        if (getPlacementType() == 0 && !mo28501l()) {
            C2552c h = mo28497h();
            if (h != null) {
                h.mo28544a(z);
            }
        }
    }

    C2596i(@NonNull Context context, int i, @NonNull C2220bg bgVar, @NonNull String str, @Nullable Set<C2298cs> set, @NonNull C2426eq eqVar, long j, boolean z, String str2) {
        super(context, i, bgVar, str, set, eqVar, j, z, str2);
        this.f5586a = bgVar;
    }

    /* renamed from: a */
    public final void mo28487a(View view) {
        if (!mo28503n() && !this.f5595j && (view instanceof C2390ej)) {
            C2390ej ejVar = (C2390ej) view;
            this.f5594i = true;
            C2235bp bpVar = (C2235bp) ejVar.getTag();
            String str = "didImpressionFire";
            if (!((Boolean) bpVar.f4542v.get(str)).booleanValue()) {
                List<C2234bo> list = bpVar.f4541u;
                Map h = m5675h(bpVar);
                List<String> arrayList = new ArrayList<>();
                for (C2234bo boVar : list) {
                    if ("VideoImpression".equals(boVar.f4631d)) {
                        if (boVar.f4629b.startsWith("http")) {
                            C2235bp.m4470a(boVar, h);
                        }
                        arrayList = (List) boVar.f4633f.get("referencedEvents");
                        if (arrayList != null) {
                            for (String a : arrayList) {
                                bpVar.mo27940a(a, h);
                            }
                        }
                    }
                }
                boolean isEmpty = arrayList.isEmpty();
                String str2 = "Impression";
                if (isEmpty) {
                    bpVar.mo27940a(String.VIDEO_START, h);
                    bpVar.mo27940a(str2, h);
                }
                this.f5586a.f4567d.mo27940a(str2, m5675h(bpVar));
                bpVar.f4542v.put(str, Boolean.TRUE);
                this.f5593h.mo28146a(0);
                if (mo28497h() != null) {
                    mo28497h().mo28547d();
                }
            }
        }
    }

    /* renamed from: l */
    public final boolean mo28501l() {
        return getPlacementType() == 0 && mo28504o() != null;
    }

    @SuppressLint({"SwitchIntDef"})
    public C2300cu getViewableAd() {
        String str;
        VastProperties vastProperties;
        Context m = mo28502m();
        if (this.f5593h == null && m != null) {
            mo28499j();
            this.f5593h = new C2318dc(this, new C2304cx(this));
            if (this.f5592g != null) {
                for (C2298cs csVar : this.f5592g) {
                    try {
                        int i = csVar.f4851a;
                        if (i == 1) {
                            C2300cu cuVar = this.f5593h;
                            Map<String, Object> map = csVar.f4852b;
                            C2235bp bpVar = (C2235bp) this.f5586a.mo27962c(ShareConstants.VIDEO_URL).get(0);
                            StringBuilder sb = new StringBuilder();
                            Iterator it = bpVar.f4541u.iterator();
                            while (true) {
                                str = "zMoatVASTIDs";
                                if (!it.hasNext()) {
                                    break;
                                }
                                C2234bo boVar = (C2234bo) it.next();
                                if (str.equals(boVar.f4631d)) {
                                    sb.append(boVar.f4629b);
                                }
                            }
                            if (sb.length() > 0) {
                                map.put(str, sb.toString());
                            }
                            this.f5593h = new C2334dj(m, cuVar, this, map);
                        } else if (i == 3) {
                            C2336dl dlVar = (C2336dl) csVar.f4852b.get("omidAdSession");
                            boolean booleanValue = ((Boolean) csVar.f4852b.get("videoAutoPlay")).booleanValue();
                            boolean booleanValue2 = ((Boolean) csVar.f4852b.get("videoSkippable")).booleanValue();
                            int intValue = ((Integer) csVar.f4852b.get("videoSkipOffset")).intValue();
                            if (booleanValue2) {
                                vastProperties = VastProperties.createVastPropertiesForSkippableVideo((float) intValue, booleanValue, Position.STANDALONE);
                            } else {
                                vastProperties = VastProperties.createVastPropertiesForNonSkippableVideo(booleanValue, Position.STANDALONE);
                            }
                            VastProperties vastProperties2 = vastProperties;
                            if (dlVar != null) {
                                C2343dr drVar = new C2343dr(m, this.f5593h, this, dlVar, vastProperties2);
                                this.f5593h = drVar;
                            }
                        }
                    } catch (Exception e) {
                        C2463fd.m5161a().mo28382a(new C2495fz(e));
                    }
                }
            }
        }
        return this.f5593h;
    }

    @NonNull
    public C2453a getFullScreenEventsListener() {
        return this.f5750z;
    }

    @Nullable
    public View getVideoContainerView() {
        WeakReference<View> weakReference = this.f5749y;
        if (weakReference == null) {
            return null;
        }
        return (View) weakReference.get();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: q */
    public final boolean mo28513q() {
        return !this.f5601p;
    }

    /* renamed from: z */
    public final void mo28621z() {
        this.f5593h.mo28146a(5);
    }

    /* renamed from: B */
    private void m5665B() {
        this.f5593h.mo28146a(15);
    }

    /* renamed from: t */
    public final void mo28516t() {
        super.mo28516t();
        C2403ek ekVar = (C2403ek) getVideoContainerView();
        if (ekVar != null) {
            C2390ej videoView = ekVar.getVideoView();
            if (getPlacementType() == 0 && !mo28501l() && videoView.getVideoVolume() > 0) {
                videoView.setLastVolume(-2);
                m5674b(true);
            }
            videoView.pause();
        }
    }

    @VisibleForTesting
    /* renamed from: C */
    private static String m5666C() {
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i == 0) {
            i = (secureRandom.nextInt() & Integer.MAX_VALUE) % 10;
        }
        sb.append(i);
        for (int i2 = 1; i2 < 8; i2++) {
            sb.append((secureRandom.nextInt() & Integer.MAX_VALUE) % 10);
        }
        return sb.toString();
    }

    @VisibleForTesting
    /* renamed from: a */
    private static String m5667a(int i) {
        long j = (long) i;
        return String.format(Locale.US, "%02d:%02d:%02d.%03d", new Object[]{Long.valueOf(TimeUnit.MILLISECONDS.toHours(j)), Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(j) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(j))), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(j))), Long.valueOf(j - (TimeUnit.MILLISECONDS.toSeconds(j) * 1000))});
    }

    public void destroy() {
        if (!this.f5595j) {
            if (getVideoContainerView() != null) {
                C2403ek ekVar = (C2403ek) getVideoContainerView();
                if (ekVar != null) {
                    ekVar.getVideoView().mo28273c();
                }
            }
            super.destroy();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo28494b(@NonNull C2214bc bcVar) {
        String str = "didRequestFullScreen";
        String str2 = "shouldAutoPlay";
        int i = bcVar.f4532l;
        if (i != 0) {
            if (i != 1) {
                String str3 = ShareConstants.VIDEO_URL;
                String str4 = "InMobi";
                if (i != 3) {
                    String str5 = "seekPosition";
                    if (i == 4) {
                        try {
                            if (getPlacementType() == 0) {
                                C2403ek ekVar = (C2403ek) getVideoContainerView();
                                if (ekVar != null) {
                                    C2390ej videoView = ekVar.getVideoView();
                                    C2235bp bpVar = (C2235bp) videoView.getTag();
                                    if (videoView.getState() != 1) {
                                        try {
                                            if (!this.f5595j) {
                                                if (this.f5599n.get() != null) {
                                                    if (!((Boolean) bpVar.f4542v.get(str)).booleanValue()) {
                                                        bpVar.f4542v.put(str, Boolean.TRUE);
                                                        bpVar.f4542v.put(str5, Integer.valueOf(videoView.getCurrentPosition()));
                                                        bpVar.f4542v.put("lastMediaVolume", Integer.valueOf(videoView.getVolume()));
                                                        if (videoView.getMediaPlayer().isPlaying()) {
                                                            videoView.getMediaPlayer().pause();
                                                        }
                                                        videoView.getMediaPlayer().f5067a = 4;
                                                        bpVar.f4542v.put("isFullScreen", Boolean.TRUE);
                                                        bpVar.f4542v.put(str5, Integer.valueOf(videoView.getMediaPlayer().getCurrentPosition()));
                                                        mo28512p();
                                                    }
                                                }
                                            }
                                        } catch (Exception e) {
                                            C2463fd.m5161a().mo28382a(new C2495fz(e));
                                        }
                                    }
                                }
                            }
                        } catch (Exception e2) {
                            C2514gh.m5342a(2, str4, "SDK encountered unexpected error in expanding video to fullscreen");
                            C2463fd.m5161a().mo28382a(new C2495fz(e2));
                        }
                    } else if (i != 5) {
                        try {
                            if (1 == getPlacementType()) {
                                super.mo28494b(bcVar);
                                if (str3.equals(bcVar.f4522b)) {
                                    C2403ek ekVar2 = (C2403ek) getVideoContainerView();
                                    if (ekVar2 != null) {
                                        ekVar2.getVideoView().mo28277d();
                                        C2390ej videoView2 = ekVar2.getVideoView();
                                        if (videoView2.mo28272b() && videoView2.f5091a.isPlaying()) {
                                            videoView2.f5091a.pause();
                                            videoView2.f5091a.seekTo(0);
                                            if (videoView2.getTag() != null) {
                                                C2235bp bpVar2 = (C2235bp) videoView2.getTag();
                                                bpVar2.f4542v.put("didPause", Boolean.TRUE);
                                                bpVar2.f4542v.put(str5, Integer.valueOf(0));
                                                bpVar2.f4542v.put("didCompleteQ4", Boolean.TRUE);
                                            }
                                            videoView2.f5091a.f5067a = 4;
                                            videoView2.getPlaybackEventListener().mo28251a(4);
                                        }
                                        if (videoView2.f5091a != null) {
                                            videoView2.f5091a.f5068b = 4;
                                        }
                                    }
                                    m5665B();
                                    return;
                                }
                                return;
                            }
                            C2552c h = mo28497h();
                            if (h != null) {
                                h.mo28552i();
                            }
                            m5665B();
                        } catch (Exception e3) {
                            C2463fd.m5161a().mo28382a(new C2495fz(e3));
                        }
                    } else {
                        try {
                            C2403ek ekVar3 = (C2403ek) getVideoContainerView();
                            if (ekVar3 != null) {
                                C2235bp bpVar3 = (C2235bp) ekVar3.getVideoView().getTag();
                                bpVar3.f4542v.put(str2, Boolean.TRUE);
                                if (bpVar3.f4545y != null) {
                                    bpVar3.f4545y.f4542v.put(str2, Boolean.TRUE);
                                }
                                ekVar3.getVideoView().start();
                            }
                        } catch (Exception e4) {
                            C2514gh.m5342a(2, str4, "SDK encountered unexpected error in playing video");
                            C2463fd.m5161a().mo28382a(new C2495fz(e4));
                        }
                    }
                } else {
                    try {
                        if (str3.equals(bcVar.f4522b)) {
                            if (this.f5605t != null) {
                                this.f5605t.mo28633e("window.imraid.broadcastEvent('replay');");
                            }
                            if (mo28498i() != null) {
                                View i2 = mo28498i();
                                C2231bn b = C2542h.m5462b(i2);
                                if (b != null) {
                                    b.mo27969a();
                                }
                                ViewGroup viewGroup = (ViewGroup) i2.getParent();
                                if (viewGroup != null) {
                                    viewGroup.removeView(i2);
                                }
                            }
                            C2403ek ekVar4 = (C2403ek) getVideoContainerView();
                            if (ekVar4 != null) {
                                ekVar4.getVideoView().mo28278e();
                                ekVar4.getVideoView().start();
                            }
                        }
                    } catch (Exception e5) {
                        C2514gh.m5342a(2, str4, "SDK encountered unexpected error in replaying video");
                        C2463fd.m5161a().mo28382a(new C2495fz(e5));
                    }
                }
            } else {
                super.mo28494b(bcVar);
            }
        }
    }

    /* renamed from: a */
    public final void mo28614a(@NonNull C2390ej ejVar) {
        ejVar.setIsLockScreen(this.f5603r);
        C2403ek ekVar = (C2403ek) ejVar.getParent();
        this.f5749y = new WeakReference<>(ekVar);
        C2387ei mediaController = ekVar.getVideoView().getMediaController();
        if (mediaController != null) {
            mediaController.setVideoAd(this);
        }
    }

    /* renamed from: a */
    public final void mo28612a(C2235bp bpVar) {
        if (!this.f5595j) {
            bpVar.mo27940a("error", m5675h(bpVar));
            this.f5593h.mo28146a(17);
        }
    }

    /* renamed from: b */
    public final void mo28615b(C2235bp bpVar) {
        if (!this.f5595j) {
            if (getPlacementType() == 0) {
                String str = "currentMediaVolume";
                String str2 = "lastMediaVolume";
                if (((Integer) bpVar.f4542v.get(str)).intValue() > 0 && ((Integer) bpVar.f4542v.get(str2)).intValue() == 0) {
                    mo28619f(bpVar);
                }
                if (((Integer) bpVar.f4542v.get(str)).intValue() == 0 && ((Integer) bpVar.f4542v.get(str2)).intValue() > 0) {
                    mo28618e(bpVar);
                }
            }
            String str3 = "didStartPlaying";
            if (!((Boolean) bpVar.f4542v.get(str3)).booleanValue()) {
                bpVar.f4542v.put(str3, Boolean.TRUE);
                getViewableAd().mo28146a(6);
            }
        }
    }

    /* renamed from: c */
    public final void mo28616c(C2235bp bpVar) {
        if (!this.f5595j) {
            m5466c(mo28498i());
            bpVar.mo27940a("pause", m5675h(bpVar));
            this.f5593h.mo28146a(7);
        }
    }

    /* renamed from: d */
    public final void mo28617d(C2235bp bpVar) {
        if (!this.f5595j) {
            m5468d(mo28498i());
            bpVar.mo27940a("resume", m5675h(bpVar));
            this.f5593h.mo28146a(8);
        }
    }

    /* renamed from: e */
    public final void mo28618e(C2235bp bpVar) {
        if (!this.f5595j) {
            bpVar.f4542v.put("lastMediaVolume", Integer.valueOf(0));
            bpVar.mo27940a("mute", m5675h(bpVar));
            this.f5593h.mo28146a(13);
        }
    }

    /* renamed from: f */
    public final void mo28619f(C2235bp bpVar) {
        if (!this.f5595j) {
            bpVar.f4542v.put("lastMediaVolume", Integer.valueOf(15));
            bpVar.mo27940a("unmute", m5675h(bpVar));
            this.f5593h.mo28146a(14);
        }
    }

    /* renamed from: a */
    public final void mo28613a(C2235bp bpVar, int i) {
        if (!this.f5595j) {
            if (i == 0) {
                bpVar.mo27940a(String.VIDEO_FIRST_QUARTILE, m5675h(bpVar));
                this.f5593h.mo28146a(9);
            } else if (i == 1) {
                bpVar.mo27940a(String.VIDEO_MIDPOINT, m5675h(bpVar));
                this.f5593h.mo28146a(10);
            } else if (i != 2) {
                if (i == 3 && !((Boolean) bpVar.f4542v.get("didQ4Fire")).booleanValue()) {
                    mo28620g(bpVar);
                }
            } else {
                bpVar.mo27940a(String.VIDEO_THIRD_QUARTILE, m5675h(bpVar));
                this.f5593h.mo28146a(11);
            }
        }
    }

    /* renamed from: g */
    public final void mo28620g(C2235bp bpVar) {
        bpVar.f4542v.put("didQ4Fire", Boolean.TRUE);
        bpVar.mo27940a(String.VIDEO_COMPLETE, m5675h(bpVar));
        this.f5593h.mo28146a(12);
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public Map<String, String> m5675h(@NonNull C2235bp bpVar) {
        C2216be beVar = (C2216be) bpVar.f4540t;
        HashMap hashMap = new HashMap(4);
        C2403ek ekVar = (C2403ek) this.f5749y.get();
        if (ekVar != null) {
            double duration = (double) ekVar.getVideoView().getDuration();
            Double.isNaN(duration);
            hashMap.put("$MD", String.valueOf((int) Math.round((duration * 1.0d) / 1000.0d)));
        }
        hashMap.put("[ERRORCODE]", "405");
        hashMap.put("[CONTENTPLAYHEAD]", m5667a(((Integer) bpVar.f4542v.get("seekPosition")).intValue()));
        hashMap.put("[CACHEBUSTING]", m5666C());
        hashMap.put("[ASSETURI]", bpVar.mo27982b().mo28138b());
        hashMap.put("$TS", String.valueOf(System.currentTimeMillis()));
        hashMap.put("$LTS", String.valueOf(this.f5586a.f4567d.f4560z));
        if (beVar != null) {
            hashMap.put("$STS", String.valueOf(beVar.f4560z));
        }
        if (this.f5586a != null) {
            hashMap.putAll(this.f5586a.mo27958a());
        }
        return hashMap;
    }

    /* renamed from: a */
    static /* synthetic */ void m5669a(C2596i iVar, View view, final boolean z) {
        final C2390ej ejVar = (C2390ej) view.findViewById(Integer.MAX_VALUE);
        if (ejVar != null) {
            final C2235bp bpVar = (C2235bp) ejVar.getTag();
            if (bpVar != null) {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        bpVar.f4542v.put(String.VISIBLE, Boolean.valueOf(z));
                        if (!z || C2596i.this.f5596k) {
                            C2596i.m5673b(C2596i.this, ejVar);
                            C2390ej ejVar = ejVar;
                            int i = bpVar.f4639F;
                            if (!ejVar.f5093c && 4 != ejVar.getState()) {
                                if (ejVar.f5092b == null) {
                                    ejVar.f5092b = new Handler(Looper.getMainLooper());
                                }
                                if (i > 0) {
                                    ejVar.f5093c = true;
                                    ejVar.mo28277d();
                                    ejVar.f5092b.postDelayed(new Runnable() {
                                        public final void run() {
                                            C2390ej.this.pause();
                                        }
                                    }, (long) (i * 1000));
                                    return;
                                }
                                ejVar.pause();
                            }
                        } else {
                            bpVar.f4542v.put("lastVisibleTimestamp", Long.valueOf(SystemClock.uptimeMillis()));
                            if (ejVar.f5093c && ejVar.getMediaPlayer() != null) {
                                if (bpVar.mo27981a()) {
                                    ejVar.mo28278e();
                                } else {
                                    ejVar.mo28277d();
                                }
                            }
                            C2390ej ejVar2 = ejVar;
                            if (ejVar2.f5092b != null) {
                                ejVar2.f5092b.removeMessages(0);
                            }
                            ejVar2.f5093c = false;
                            C2596i.m5670a(C2596i.this, ejVar);
                            C2596i.m5671a(C2596i.this, ejVar, bpVar);
                            if (1 == ejVar.getState()) {
                                ejVar.getMediaPlayer().f5068b = 3;
                            } else if (2 == ejVar.getState() || 4 == ejVar.getState() || (5 == ejVar.getState() && bpVar.f4636C)) {
                                ejVar.start();
                            }
                        }
                    }
                });
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m5670a(C2596i iVar, C2390ej ejVar) {
        if (iVar.getPlacementType() == 0 && !iVar.mo28501l()) {
            int videoVolume = ejVar.getVideoVolume();
            if (videoVolume != ejVar.getLastVolume() && ejVar.isPlaying()) {
                iVar.m5674b(videoVolume <= 0);
                ejVar.setLastVolume(videoVolume);
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m5671a(C2596i iVar, C2390ej ejVar, C2235bp bpVar) {
        if (iVar.getPlacementType() == 0 && !iVar.mo28501l() && !bpVar.f4636C && !ejVar.isPlaying() && ejVar.getState() == 5) {
            iVar.m5672b(ejVar);
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m5673b(C2596i iVar, C2390ej ejVar) {
        if (iVar.getPlacementType() == 0 && !iVar.mo28501l() && !iVar.f5596k) {
            iVar.m5672b(ejVar);
        }
    }
}
