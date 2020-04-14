package com.applovin.impl.adview;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.PointF;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import com.applovin.impl.adview.AppLovinTouchToClickListener.OnClickListener;
import com.applovin.impl.adview.C0892v.C0893a;
import com.applovin.impl.p005a.C0769a;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.C1227o;
import com.applovin.impl.sdk.p017a.C1068b;
import com.applovin.impl.sdk.p018ad.C1078a;
import com.applovin.impl.sdk.p018ad.C1084f;
import com.applovin.impl.sdk.p018ad.C1088h;
import com.applovin.impl.sdk.p018ad.C1089i;
import com.applovin.impl.sdk.p019b.C1096c;
import com.applovin.impl.sdk.p019b.C1098e;
import com.applovin.impl.sdk.p020c.C1108d;
import com.applovin.impl.sdk.utils.C1239a;
import com.applovin.impl.sdk.utils.C1245f;
import com.applovin.impl.sdk.utils.C1248i;
import com.applovin.impl.sdk.utils.C1277l;
import com.applovin.impl.sdk.utils.C1278m;
import com.applovin.impl.sdk.utils.C1281o;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.applovin.impl.adview.m */
public abstract class C0842m extends Activity implements C0832j {
    public static final String KEY_WRAPPER_ID = "com.applovin.interstitial.wrapper_id";
    public static volatile C0876n lastKnownWrapper;
    /* access modifiers changed from: private */

    /* renamed from: A */
    public final Handler f1486A = new Handler(Looper.getMainLooper());

    /* renamed from: B */
    private FrameLayout f1487B;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public C0826h f1488C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public View f1489D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public C0826h f1490E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public View f1491F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public C0823f f1492G;

    /* renamed from: H */
    private ImageView f1493H;
    /* access modifiers changed from: private */

    /* renamed from: I */
    public WeakReference<MediaPlayer> f1494I = new WeakReference<>(null);

    /* renamed from: J */
    private C1068b f1495J;
    /* access modifiers changed from: private */

    /* renamed from: K */
    public C0891u f1496K;
    /* access modifiers changed from: private */

    /* renamed from: L */
    public ProgressBar f1497L;

    /* renamed from: M */
    private C0893a f1498M;

    /* renamed from: N */
    private C0799a f1499N;

    /* renamed from: O */
    private C1278m f1500O;

    /* renamed from: P */
    private C1239a f1501P;

    /* renamed from: a */
    private C0841l f1502a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C0876n f1503b;

    /* renamed from: c */
    private volatile boolean f1504c = false;
    protected int computedLengthSeconds = 0;
    protected C0828i countdownManager;
    public volatile C1084f currentAd;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C1108d f1505d;

    /* renamed from: e */
    private volatile boolean f1506e = false;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public volatile boolean f1507f = false;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public volatile boolean f1508g = false;

    /* renamed from: h */
    private volatile boolean f1509h = false;

    /* renamed from: i */
    private volatile boolean f1510i = false;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public volatile boolean f1511j = false;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public volatile boolean f1512k = false;

    /* renamed from: l */
    private boolean f1513l = false;
    public C1227o logger;

    /* renamed from: m */
    private volatile boolean f1514m = false;

    /* renamed from: n */
    private boolean f1515n = true;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public boolean f1516o = false;

    /* renamed from: p */
    private long f1517p = 0;
    protected volatile boolean poststitialWasDisplayed = false;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public long f1518q = 0;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public long f1519r = 0;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public long f1520s = 0;
    public C1192i sdk;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public long f1521t = -2;

    /* renamed from: u */
    private int f1522u = 0;

    /* renamed from: v */
    private int f1523v = Integer.MIN_VALUE;
    protected volatile boolean videoMuted = false;
    public C0890t videoView;

    /* renamed from: w */
    private AtomicBoolean f1524w = new AtomicBoolean(false);

    /* renamed from: x */
    private AtomicBoolean f1525x = new AtomicBoolean(false);

    /* renamed from: y */
    private AtomicBoolean f1526y = new AtomicBoolean(false);

    /* renamed from: z */
    private final Handler f1527z = new Handler(Looper.getMainLooper());

    /* access modifiers changed from: private */
    /* renamed from: A */
    public void m1204A() {
        if (m1209C()) {
            m1222M();
            pauseReportRewardTask();
            this.logger.mo10378b("InterActivity", "Prompting incentivized ad close warning");
            this.f1495J.mo9761b();
            return;
        }
        skipVideo();
    }

    /* access modifiers changed from: private */
    /* renamed from: B */
    public void m1207B() {
        if (this.currentAd.mo9885W()) {
            C0801c adWebView = ((AdViewControllerImpl) this.f1502a.getAdViewController()).getAdWebView();
            if (adWebView != null) {
                adWebView.mo9005a("javascript:al_onCloseButtonTapped();");
            }
        }
        if (m1210D()) {
            this.logger.mo10378b("InterActivity", "Prompting incentivized non-video ad close warning");
            this.f1495J.mo9762c();
            return;
        }
        dismiss();
    }

    /* renamed from: C */
    private boolean m1209C() {
        return m1216G() && !isFullyWatched() && ((Boolean) this.sdk.mo10202a(C1096c.f2353bO)).booleanValue() && this.f1495J != null;
    }

    /* renamed from: D */
    private boolean m1210D() {
        return m1217H() && !m1215F() && ((Boolean) this.sdk.mo10202a(C1096c.f2358bT)).booleanValue() && this.f1495J != null;
    }

    /* renamed from: E */
    private int m1212E() {
        if (!(this.currentAd instanceof C1078a)) {
            return 0;
        }
        float h = ((C1078a) this.currentAd).mo9834h();
        if (h <= 0.0f) {
            h = this.currentAd.mo9926n();
        }
        double a = C1281o.m3061a(System.currentTimeMillis() - this.f1517p);
        double d = (double) h;
        Double.isNaN(d);
        return (int) Math.min((a / d) * 100.0d, 100.0d);
    }

    /* renamed from: F */
    private boolean m1215F() {
        return m1212E() >= this.currentAd.mo9882T();
    }

    /* renamed from: G */
    private boolean m1216G() {
        return AppLovinAdType.INCENTIVIZED.equals(this.currentAd.getType());
    }

    /* renamed from: H */
    private boolean m1217H() {
        return !this.currentAd.hasVideoUrl() && m1216G();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0066, code lost:
        if (r0 > 0) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0098, code lost:
        if (r0 > 0) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x009a, code lost:
        r0 = java.util.concurrent.TimeUnit.SECONDS.toMillis((long) r0);
     */
    /* renamed from: I */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m1218I() {
        /*
            r7 = this;
            com.applovin.impl.sdk.ad.f r0 = r7.currentAd
            if (r0 == 0) goto L_0x00e6
            com.applovin.impl.sdk.ad.f r0 = r7.currentAd
            long r0 = r0.mo9902ag()
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L_0x0018
            com.applovin.impl.sdk.ad.f r0 = r7.currentAd
            int r0 = r0.mo9903ah()
            if (r0 < 0) goto L_0x00e6
        L_0x0018:
            com.applovin.impl.sdk.utils.m r0 = r7.f1500O
            if (r0 != 0) goto L_0x00e6
            com.applovin.impl.sdk.ad.f r0 = r7.currentAd
            long r0 = r0.mo9902ag()
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 < 0) goto L_0x002e
            com.applovin.impl.sdk.ad.f r0 = r7.currentAd
            long r0 = r0.mo9902ag()
            goto L_0x00b6
        L_0x002e:
            boolean r0 = r7.isVastAd()
            if (r0 == 0) goto L_0x0069
            com.applovin.impl.sdk.ad.f r0 = r7.currentAd
            com.applovin.impl.a.a r0 = (com.applovin.impl.p005a.C0769a) r0
            com.applovin.impl.a.j r1 = r0.mo8892h()
            if (r1 == 0) goto L_0x0051
            int r4 = r1.mo8949b()
            if (r4 <= 0) goto L_0x0051
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.SECONDS
            int r1 = r1.mo8949b()
            long r5 = (long) r1
            long r4 = r4.toMillis(r5)
            long r2 = r2 + r4
            goto L_0x005b
        L_0x0051:
            com.applovin.impl.adview.t r1 = r7.videoView
            int r1 = r1.getDuration()
            if (r1 <= 0) goto L_0x005b
            long r4 = (long) r1
            long r2 = r2 + r4
        L_0x005b:
            boolean r1 = r0.mo9904ai()
            if (r1 == 0) goto L_0x00a2
            float r0 = r0.mo9926n()
            int r0 = (int) r0
            if (r0 <= 0) goto L_0x00a2
            goto L_0x009a
        L_0x0069:
            com.applovin.impl.sdk.ad.f r0 = r7.currentAd
            boolean r0 = r0 instanceof com.applovin.impl.sdk.p018ad.C1078a
            if (r0 == 0) goto L_0x00a2
            com.applovin.impl.sdk.ad.f r0 = r7.currentAd
            com.applovin.impl.sdk.ad.a r0 = (com.applovin.impl.sdk.p018ad.C1078a) r0
            com.applovin.impl.adview.t r1 = r7.videoView
            int r1 = r1.getDuration()
            if (r1 <= 0) goto L_0x007d
            long r4 = (long) r1
            long r2 = r2 + r4
        L_0x007d:
            boolean r1 = r0.mo9904ai()
            if (r1 == 0) goto L_0x00a2
            float r1 = r0.mo9834h()
            int r1 = (int) r1
            if (r1 <= 0) goto L_0x0093
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.SECONDS
            long r4 = (long) r1
            long r0 = r0.toMillis(r4)
        L_0x0091:
            long r2 = r2 + r0
            goto L_0x00a2
        L_0x0093:
            float r0 = r0.mo9926n()
            int r0 = (int) r0
            if (r0 <= 0) goto L_0x00a2
        L_0x009a:
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.SECONDS
            long r4 = (long) r0
            long r0 = r1.toMillis(r4)
            goto L_0x0091
        L_0x00a2:
            double r0 = (double) r2
            com.applovin.impl.sdk.ad.f r2 = r7.currentAd
            int r2 = r2.mo9903ah()
            double r2 = (double) r2
            r4 = 4636737291354636288(0x4059000000000000, double:100.0)
            java.lang.Double.isNaN(r2)
            double r2 = r2 / r4
            java.lang.Double.isNaN(r0)
            double r0 = r0 * r2
            long r0 = (long) r0
        L_0x00b6:
            com.applovin.impl.sdk.o r2 = r7.logger
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Scheduling report reward in "
            r3.append(r4)
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS
            long r4 = r4.toSeconds(r0)
            r3.append(r4)
            java.lang.String r4 = " seconds..."
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "InterActivity"
            r2.mo10378b(r4, r3)
            com.applovin.impl.sdk.i r2 = r7.sdk
            com.applovin.impl.adview.m$16 r3 = new com.applovin.impl.adview.m$16
            r3.<init>()
            com.applovin.impl.sdk.utils.m r0 = com.applovin.impl.sdk.utils.C1278m.m3045a(r0, r2, r3)
            r7.f1500O = r0
        L_0x00e6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.adview.C0842m.m1218I():void");
    }

    /* renamed from: J */
    private void m1219J() {
        String str;
        StringBuilder sb;
        C1227o oVar;
        C0841l lVar = this.f1502a;
        if (lVar != null) {
            lVar.setAdDisplayListener(new AppLovinAdDisplayListener() {
                public void adDisplayed(AppLovinAd appLovinAd) {
                    if (!C0842m.this.f1507f) {
                        C0842m.this.m1238a(appLovinAd);
                    }
                }

                public void adHidden(AppLovinAd appLovinAd) {
                    C0842m.this.m1251b(appLovinAd);
                }
            });
            this.f1502a.setAdClickListener(new AppLovinAdClickListener() {
                public void adClicked(AppLovinAd appLovinAd) {
                    C1248i.m2998a(C0842m.this.f1503b.mo9173e(), appLovinAd);
                }
            });
            this.currentAd = (C1084f) this.f1503b.mo9170b();
            if (this.f1525x.compareAndSet(false, true)) {
                this.sdk.mo10241o().trackImpression(this.currentAd);
                this.currentAd.setHasShown(true);
            }
            LayoutParams layoutParams = new LayoutParams(-1, -1);
            this.f1487B = new FrameLayout(this);
            this.f1487B.setLayoutParams(layoutParams);
            this.f1487B.setBackgroundColor(this.currentAd.mo9865C());
            this.countdownManager = new C0828i(this.f1527z, this.sdk);
            m1276j();
            if (this.currentAd.isVideoAd()) {
                this.f1514m = this.currentAd.mo8884b();
                String str2 = "InterActivity";
                if (this.f1514m) {
                    oVar = this.logger;
                    sb = new StringBuilder();
                    str = "Preparing stream for ";
                } else {
                    oVar = this.logger;
                    sb = new StringBuilder();
                    str = "Preparing cached video playback for ";
                }
                sb.append(str);
                sb.append(this.currentAd.mo8886d());
                oVar.mo10378b(str2, sb.toString());
                C1108d dVar = this.f1505d;
                if (dVar != null) {
                    dVar.mo10008b(this.f1514m ? 1 : 0);
                }
            }
            this.videoMuted = m1275i();
            Uri d = this.currentAd.mo8886d();
            m1232a(d);
            if (d == null) {
                m1218I();
            }
            this.f1488C.bringToFront();
            if (m1285n()) {
                View view = this.f1489D;
                if (view != null) {
                    view.bringToFront();
                }
            }
            C0826h hVar = this.f1490E;
            if (hVar != null) {
                hVar.bringToFront();
            }
            this.f1502a.renderAd(this.currentAd);
            this.f1503b.mo9169a(true);
            if (!this.currentAd.hasVideoUrl()) {
                if (m1217H() && ((Boolean) this.sdk.mo10202a(C1096c.f2363bY)).booleanValue()) {
                    m1265d((AppLovinAd) this.currentAd);
                }
                showPoststitial();
                return;
            }
            return;
        }
        exitWithError("AdView was null");
    }

    /* renamed from: K */
    private void m1220K() {
        if (this.videoView != null) {
            this.f1522u = getVideoPercentViewed();
            this.videoView.stopPlayback();
        }
    }

    /* renamed from: L */
    private boolean m1221L() {
        return this.videoMuted;
    }

    /* renamed from: M */
    private void m1222M() {
        C0890t tVar = this.videoView;
        this.sdk.mo10209a(C1098e.f2574t, Integer.valueOf(tVar != null ? tVar.getCurrentPosition() : 0));
        this.sdk.mo10209a(C1098e.f2575u, Boolean.valueOf(true));
        try {
            this.countdownManager.mo9086c();
        } catch (Throwable th) {
            this.logger.mo10379b("InterActivity", "Unable to pause countdown timers", th);
        }
        this.videoView.pause();
    }

    /* renamed from: N */
    private void m1223N() {
        long max = Math.max(0, ((Long) this.sdk.mo10202a(C1096c.f2480dl)).longValue());
        String str = "InterActivity";
        if (max > 0) {
            C1227o v = this.sdk.mo10249v();
            StringBuilder sb = new StringBuilder();
            sb.append("Resuming video with delay of ");
            sb.append(max);
            v.mo10378b(str, sb.toString());
            this.f1486A.postDelayed(new Runnable() {
                public void run() {
                    C0842m.this.m1224O();
                }
            }, max);
            return;
        }
        this.sdk.mo10249v().mo10378b(str, "Resuming video immediately");
        m1224O();
    }

    /* access modifiers changed from: private */
    /* renamed from: O */
    public void m1224O() {
        if (!this.poststitialWasDisplayed) {
            C0890t tVar = this.videoView;
            if (tVar != null && !tVar.isPlaying()) {
                this.videoView.seekTo(((Integer) this.sdk.mo10222b(C1098e.f2574t, Integer.valueOf(this.videoView.getDuration()))).intValue());
                this.videoView.start();
                this.countdownManager.mo9083a();
            }
        }
    }

    /* renamed from: P */
    private void m1225P() {
        String str = "InterActivity";
        if (!this.f1510i) {
            try {
                int videoPercentViewed = getVideoPercentViewed();
                if (this.currentAd.hasVideoUrl()) {
                    m1239a((AppLovinAd) this.currentAd, (double) videoPercentViewed, isFullyWatched());
                    if (this.f1505d != null) {
                        this.f1505d.mo10010c((long) videoPercentViewed);
                    }
                } else if ((this.currentAd instanceof C1078a) && m1217H() && ((Boolean) this.sdk.mo10202a(C1096c.f2363bY)).booleanValue()) {
                    int E = m1212E();
                    C1227o oVar = this.logger;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Rewarded playable engaged at ");
                    sb.append(E);
                    sb.append(" percent");
                    oVar.mo10378b(str, sb.toString());
                    m1239a((AppLovinAd) this.currentAd, (double) E, E >= this.currentAd.mo9882T());
                }
                this.sdk.mo10241o().trackVideoEnd(this.currentAd, TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.f1517p), videoPercentViewed, this.f1514m);
                this.sdk.mo10241o().trackFullScreenAdClosed(this.currentAd, SystemClock.elapsedRealtime() - this.f1519r, this.f1521t);
            } catch (Throwable th) {
                C1227o oVar2 = this.logger;
                if (oVar2 != null) {
                    oVar2.mo10379b(str, "Failed to notify end listener.", th);
                }
            }
        }
    }

    /* renamed from: a */
    private int m1226a(int i) {
        return AppLovinSdkUtils.dpToPx(this, i);
    }

    /* renamed from: a */
    private int m1227a(int i, boolean z) {
        if (z) {
            if (i == 0) {
                return 0;
            }
            if (i == 1) {
                return 9;
            }
            if (i == 2) {
                return 8;
            }
            if (i == 3) {
                return 1;
            }
        } else if (i == 0) {
            return 1;
        } else {
            if (i == 1) {
                return 0;
            }
            if (i == 2) {
                return 9;
            }
            if (i == 3) {
                return 8;
            }
        }
        return -1;
    }

    /* renamed from: a */
    private void m1230a(long j, final C0826h hVar) {
        this.f1486A.postDelayed(new Runnable() {
            public void run() {
                if (hVar.equals(C0842m.this.f1488C)) {
                    C0842m.this.m1282m();
                } else if (hVar.equals(C0842m.this.f1490E)) {
                    C0842m.this.m1286o();
                }
            }
        }, j);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1231a(PointF pointF) {
        if (!this.currentAd.mo8899u() || this.currentAd.mo8890g() == null) {
            m1267e();
            m1268f();
            return;
        }
        this.sdk.mo10249v().mo10378b("InterActivity", "Clicking through video...");
        clickThroughFromVideo(pointF);
    }

    /* renamed from: a */
    private void m1232a(Uri uri) {
        this.videoView = this.currentAd.mo9916av() ? new C0883p(this.sdk, this, new C0885a() {
            /* renamed from: a */
            public void mo9151a(String str) {
                C0842m.this.handleMediaError(str);
            }
        }) : new AppLovinVideoView(this, this.sdk);
        if (uri != null) {
            this.videoView.setOnPreparedListener(new OnPreparedListener() {
                public void onPrepared(MediaPlayer mediaPlayer) {
                    C0842m.this.f1494I = new WeakReference(mediaPlayer);
                    boolean c = C0842m.this.m1275i();
                    float f = c ^ true ? 1.0f : 0.0f;
                    mediaPlayer.setVolume(f, f);
                    if (C0842m.this.f1505d != null) {
                        C0842m.this.f1505d.mo10014e(c ? 1 : 0);
                    }
                    int videoWidth = mediaPlayer.getVideoWidth();
                    int videoHeight = mediaPlayer.getVideoHeight();
                    C0842m.this.computedLengthSeconds = (int) TimeUnit.MILLISECONDS.toSeconds((long) mediaPlayer.getDuration());
                    C0842m.this.videoView.setVideoSize(videoWidth, videoHeight);
                    if (C0842m.this.videoView instanceof AppLovinVideoView) {
                        mediaPlayer.setDisplay(((AppLovinVideoView) C0842m.this.videoView).getHolder());
                    }
                    mediaPlayer.setOnErrorListener(new OnErrorListener() {
                        public boolean onError(MediaPlayer mediaPlayer, final int i, final int i2) {
                            C0842m.this.f1486A.post(new Runnable() {
                                public void run() {
                                    C0842m mVar = C0842m.this;
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("Media player error (");
                                    sb.append(i);
                                    sb.append(",");
                                    sb.append(i2);
                                    sb.append(")");
                                    mVar.handleMediaError(sb.toString());
                                }
                            });
                            return true;
                        }
                    });
                    mediaPlayer.setOnInfoListener(new OnInfoListener() {
                        /* JADX WARNING: Code restructure failed: missing block: B:9:0x002e, code lost:
                            if (r2 == 702) goto L_0x0003;
                         */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public boolean onInfo(android.media.MediaPlayer r1, int r2, int r3) {
                            /*
                                r0 = this;
                                r1 = 3
                                if (r2 != r1) goto L_0x000b
                            L_0x0003:
                                com.applovin.impl.adview.m$25 r1 = com.applovin.impl.adview.C0842m.C086125.this
                                com.applovin.impl.adview.m r1 = com.applovin.impl.adview.C0842m.this
                                r1.m1309z()
                                goto L_0x0031
                            L_0x000b:
                                r1 = 701(0x2bd, float:9.82E-43)
                                if (r2 != r1) goto L_0x002c
                                com.applovin.impl.adview.m$25 r1 = com.applovin.impl.adview.C0842m.C086125.this
                                com.applovin.impl.adview.m r1 = com.applovin.impl.adview.C0842m.this
                                r1.m1306y()
                                com.applovin.impl.adview.m$25 r1 = com.applovin.impl.adview.C0842m.C086125.this
                                com.applovin.impl.adview.m r1 = com.applovin.impl.adview.C0842m.this
                                com.applovin.impl.sdk.c.d r1 = r1.f1505d
                                if (r1 == 0) goto L_0x0031
                                com.applovin.impl.adview.m$25 r1 = com.applovin.impl.adview.C0842m.C086125.this
                                com.applovin.impl.adview.m r1 = com.applovin.impl.adview.C0842m.this
                                com.applovin.impl.sdk.c.d r1 = r1.f1505d
                                r1.mo10017h()
                                goto L_0x0031
                            L_0x002c:
                                r1 = 702(0x2be, float:9.84E-43)
                                if (r2 != r1) goto L_0x0031
                                goto L_0x0003
                            L_0x0031:
                                r1 = 0
                                return r1
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.adview.C0842m.C086125.C08642.onInfo(android.media.MediaPlayer, int, int):boolean");
                        }
                    });
                    if (C0842m.this.f1518q == 0) {
                        C0842m.this.m1291q();
                        C0842m.this.m1278k();
                        C0842m.this.m1300v();
                        C0842m.this.m1299u();
                        C0842m.this.playVideo();
                        C0842m.this.m1218I();
                    }
                }
            });
            this.videoView.setOnCompletionListener(new OnCompletionListener() {
                public void onCompletion(MediaPlayer mediaPlayer) {
                    C0842m.this.m1273h();
                }
            });
            this.videoView.setOnErrorListener(new OnErrorListener() {
                public boolean onError(MediaPlayer mediaPlayer, final int i, final int i2) {
                    C0842m.this.f1486A.post(new Runnable() {
                        public void run() {
                            C0842m mVar = C0842m.this;
                            StringBuilder sb = new StringBuilder();
                            sb.append("Video view error (");
                            sb.append(i);
                            sb.append(",");
                            sb.append(i2);
                            mVar.handleMediaError(sb.toString());
                        }
                    });
                    return true;
                }
            });
            ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
            this.videoView.setVideoURI(uri);
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
        this.videoView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
        this.videoView.setOnTouchListener(new AppLovinTouchToClickListener(this.sdk, this, new OnClickListener() {
            public void onClick(View view, PointF pointF) {
                C0842m.this.m1231a(pointF);
            }
        }));
        this.f1487B.addView((View) this.videoView);
        setContentView(this.f1487B);
        m1288p();
        m1304x();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1233a(final View view, final boolean z, long j) {
        float f = 0.0f;
        float f2 = z ? 0.0f : 1.0f;
        if (z) {
            f = 1.0f;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(f2, f);
        alphaAnimation.setDuration(j);
        alphaAnimation.setAnimationListener(new AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                if (!z) {
                    view.setVisibility(4);
                }
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
                view.setVisibility(0);
            }
        });
        view.startAnimation(alphaAnimation);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1238a(AppLovinAd appLovinAd) {
        C1248i.m2999a(this.f1503b.mo9172d(), appLovinAd);
        this.f1507f = true;
        this.sdk.mo10200Z().mo10285c();
        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
            public void run() {
                C0842m mVar = C0842m.this;
                mVar.m1253b(mVar.videoMuted);
            }
        }, ((Long) this.sdk.mo10202a(C1096c.f2484dp)).longValue());
    }

    /* renamed from: a */
    private void m1239a(AppLovinAd appLovinAd, double d, boolean z) {
        this.f1510i = true;
        C1248i.m3004a(this.f1503b.mo9171c(), appLovinAd, d, z);
    }

    /* renamed from: a */
    private void m1240a(final String str) {
        C0876n nVar = this.f1503b;
        if (nVar != null) {
            final AppLovinAdDisplayListener d = nVar.mo9172d();
            if ((d instanceof C1089i) && this.f1526y.compareAndSet(false, true)) {
                runOnUiThread(new Runnable() {
                    public void run() {
                        ((C1089i) d).onAdDisplayFailed(str);
                    }
                });
            }
        }
    }

    /* renamed from: a */
    private void m1241a(boolean z) {
        Uri ay = z ? this.currentAd.mo9919ay() : this.currentAd.mo9920az();
        int a = m1226a(((Integer) this.sdk.mo10202a(C1096c.f2473de)).intValue());
        ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        AppLovinSdkUtils.safePopulateImageView(this.f1493H, ay, a);
        StrictMode.setThreadPolicy(allowThreadDiskReads);
    }

    /* renamed from: a */
    private boolean m1242a() {
        int identifier = getResources().getIdentifier((String) this.sdk.mo10202a(C1096c.f2414cX), "bool", "android");
        return identifier > 0 && getResources().getBoolean(identifier);
    }

    /* access modifiers changed from: private */
    @TargetApi(16)
    /* renamed from: b */
    public void m1246b() {
        getWindow().getDecorView().setSystemUiVisibility(5894);
    }

    /* renamed from: b */
    private void m1247b(int i) {
        try {
            setRequestedOrientation(i);
        } catch (Throwable th) {
            this.sdk.mo10249v().mo10379b("InterActivity", "Failed to set requested orientation", th);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0052, code lost:
        if (r7 == 2) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0063, code lost:
        if (r7 == 1) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0026, code lost:
        if (r7 == 1) goto L_0x0028;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m1248b(int r7, boolean r8) {
        /*
            r6 = this;
            com.applovin.impl.sdk.i r0 = r6.sdk
            com.applovin.impl.sdk.b.c<java.lang.Boolean> r1 = com.applovin.impl.sdk.p019b.C1096c.f2412cV
            java.lang.Object r0 = r0.mo10202a(r1)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            com.applovin.impl.adview.n r1 = r6.f1503b
            com.applovin.impl.sdk.ad.f$b r1 = r1.mo9174f()
            com.applovin.impl.sdk.ad.f$b r2 = com.applovin.impl.sdk.p018ad.C1084f.C1086b.ACTIVITY_PORTRAIT
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 != r2) goto L_0x003c
            r1 = 9
            if (r8 == 0) goto L_0x002c
            if (r7 == r5) goto L_0x0024
            if (r7 == r3) goto L_0x0024
            goto L_0x0030
        L_0x0024:
            if (r0 == 0) goto L_0x0066
            if (r7 != r5) goto L_0x0032
        L_0x0028:
            r6.m1247b(r1)
            goto L_0x0066
        L_0x002c:
            if (r7 == 0) goto L_0x0036
            if (r7 == r4) goto L_0x0036
        L_0x0030:
            r6.f1504c = r5
        L_0x0032:
            r6.m1247b(r5)
            goto L_0x0066
        L_0x0036:
            if (r0 == 0) goto L_0x0066
            if (r7 != 0) goto L_0x0028
            r1 = 1
            goto L_0x0028
        L_0x003c:
            com.applovin.impl.adview.n r1 = r6.f1503b
            com.applovin.impl.sdk.ad.f$b r1 = r1.mo9174f()
            com.applovin.impl.sdk.ad.f$b r2 = com.applovin.impl.sdk.p018ad.C1084f.C1086b.ACTIVITY_LANDSCAPE
            if (r1 != r2) goto L_0x0066
            r1 = 8
            r2 = 0
            if (r8 == 0) goto L_0x0057
            if (r7 == 0) goto L_0x0050
            if (r7 == r4) goto L_0x0050
            goto L_0x005b
        L_0x0050:
            if (r0 == 0) goto L_0x0066
            if (r7 != r4) goto L_0x0055
            goto L_0x0028
        L_0x0055:
            r1 = 0
            goto L_0x0028
        L_0x0057:
            if (r7 == r5) goto L_0x0061
            if (r7 == r3) goto L_0x0061
        L_0x005b:
            r6.f1504c = r5
            r6.m1247b(r2)
            goto L_0x0066
        L_0x0061:
            if (r0 == 0) goto L_0x0066
            if (r7 != r5) goto L_0x0028
            goto L_0x0055
        L_0x0066:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.adview.C0842m.m1248b(int, boolean):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m1251b(AppLovinAd appLovinAd) {
        dismiss();
        m1256c(appLovinAd);
    }

    /* renamed from: b */
    private void m1252b(String str) {
        C1084f fVar = this.currentAd;
        if (fVar != null && fVar.mo9887Y()) {
            m1257c(str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m1253b(boolean z) {
        if (this.currentAd.mo9884V()) {
            C0801c adWebView = ((AdViewControllerImpl) this.f1502a.getAdViewController()).getAdWebView();
            if (adWebView != null) {
                try {
                    adWebView.mo9005a(z ? "javascript:al_mute();" : "javascript:al_unmute();");
                } catch (Throwable th) {
                    this.logger.mo10379b("InterActivity", "Unable to forward mute setting to template.", th);
                }
            }
        }
    }

    /* renamed from: c */
    private void m1256c(AppLovinAd appLovinAd) {
        if (!this.f1508g) {
            this.f1508g = true;
            C0876n nVar = this.f1503b;
            if (nVar != null) {
                C1248i.m3010b(nVar.mo9172d(), appLovinAd);
            }
            this.sdk.mo10200Z().mo10286d();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m1257c(String str) {
        C0801c adWebView = ((AdViewControllerImpl) this.f1502a.getAdViewController()).getAdWebView();
        if (adWebView != null && C1277l.m3042b(str)) {
            adWebView.mo9005a(str);
        }
    }

    /* renamed from: c */
    private void m1258c(boolean z) {
        this.videoMuted = z;
        MediaPlayer mediaPlayer = (MediaPlayer) this.f1494I.get();
        if (mediaPlayer != null) {
            float f = (float) (z ? 0 : 1);
            try {
                mediaPlayer.setVolume(f, f);
            } catch (IllegalStateException e) {
                C1227o oVar = this.logger;
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to set MediaPlayer muted: ");
                sb.append(z);
                oVar.mo10379b("InterActivity", sb.toString(), e);
            }
        }
    }

    /* renamed from: c */
    private boolean m1259c() {
        boolean z = true;
        if (this.f1503b != null) {
            C1192i iVar = this.sdk;
            if (iVar != null) {
                if (((Boolean) iVar.mo10202a(C1096c.f2406cP)).booleanValue()) {
                    return true;
                }
                if (((Boolean) this.sdk.mo10202a(C1096c.f2407cQ)).booleanValue() && this.f1511j) {
                    return true;
                }
                if (!((Boolean) this.sdk.mo10202a(C1096c.f2408cR)).booleanValue() || !this.poststitialWasDisplayed) {
                    z = false;
                }
            }
        }
        return z;
    }

    @SuppressLint({"WrongConstant"})
    /* renamed from: d */
    private void m1263d() {
        if (this.sdk == null || !isFinishing()) {
            if (this.currentAd != null) {
                int i = this.f1523v;
                if (i != Integer.MIN_VALUE) {
                    setRequestedOrientation(i);
                }
            }
            finish();
        }
    }

    /* renamed from: d */
    private void m1265d(AppLovinAd appLovinAd) {
        if (!this.f1509h) {
            this.f1509h = true;
            C1248i.m3003a(this.f1503b.mo9171c(), appLovinAd);
        }
    }

    /* renamed from: e */
    private void m1267e() {
        if (((Boolean) this.sdk.mo10202a(C1096c.f2415cY)).booleanValue()) {
            C0823f fVar = this.f1492G;
            if (fVar != null && fVar.getVisibility() != 8) {
                m1233a((View) this.f1492G, this.f1492G.getVisibility() == 4, 750);
            }
        }
    }

    /* renamed from: f */
    private void m1268f() {
        C0889s t = this.currentAd.mo9932t();
        if (t != null && t.mo9209e() && !this.poststitialWasDisplayed) {
            C0891u uVar = this.f1496K;
            if (uVar != null) {
                m1233a((View) this.f1496K, uVar.getVisibility() == 4, t.mo9211f());
            }
        }
    }

    /* renamed from: g */
    private void m1270g() {
        C1192i iVar = this.sdk;
        if (iVar != null) {
            iVar.mo10209a(C1098e.f2575u, Boolean.valueOf(false));
            this.sdk.mo10209a(C1098e.f2574t, Integer.valueOf(0));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m1273h() {
        this.f1506e = true;
        showPoststitial();
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public boolean m1275i() {
        return ((Integer) this.sdk.mo10222b(C1098e.f2574t, Integer.valueOf(0))).intValue() > 0 ? this.videoMuted : ((Boolean) this.sdk.mo10202a(C1096c.f2472dd)).booleanValue() ? this.sdk.mo10238l().isMuted() : ((Boolean) this.sdk.mo10202a(C1096c.f2470db)).booleanValue();
    }

    /* renamed from: j */
    private void m1276j() {
        this.f1488C = C0826h.m1172a(this.sdk, this, this.currentAd.mo9927o());
        this.f1488C.setVisibility(8);
        this.f1488C.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                C0842m.this.m1207B();
            }
        });
        int a = m1226a(this.currentAd.mo9888Z());
        int i = 3;
        int i2 = (this.currentAd.mo9898ac() ? 3 : 5) | 48;
        if (!this.currentAd.mo9899ad()) {
            i = 5;
        }
        int i3 = i | 48;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a, a, i2 | 48);
        this.f1488C.mo9078a(a);
        int a2 = m1226a(this.currentAd.mo9896aa());
        int a3 = m1226a(this.currentAd.mo9897ab());
        layoutParams.setMargins(a3, a2, a3, a2);
        this.f1487B.addView(this.f1488C, layoutParams);
        this.f1490E = C0826h.m1172a(this.sdk, this, this.currentAd.mo9928p());
        this.f1490E.setVisibility(8);
        this.f1490E.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                C0842m.this.m1204A();
            }
        });
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(a, a, i3);
        layoutParams2.setMargins(a3, a2, a3, a2);
        this.f1490E.mo9078a(a);
        this.f1487B.addView(this.f1490E, layoutParams2);
        this.f1490E.bringToFront();
        if (m1285n()) {
            int a4 = m1226a(((Integer) this.sdk.mo10202a(C1096c.f2421ce)).intValue());
            this.f1489D = new View(this);
            this.f1489D.setBackgroundColor(0);
            this.f1489D.setVisibility(8);
            this.f1491F = new View(this);
            this.f1491F.setBackgroundColor(0);
            this.f1491F.setVisibility(8);
            int i4 = a + a4;
            int a5 = a2 - m1226a(5);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(i4, i4, i2);
            layoutParams3.setMargins(a5, a5, a5, a5);
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(i4, i4, i3);
            layoutParams4.setMargins(a5, a5, a5, a5);
            this.f1489D.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    C0842m.this.f1488C.performClick();
                }
            });
            this.f1491F.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    C0842m.this.f1490E.performClick();
                }
            });
            this.f1487B.addView(this.f1489D, layoutParams3);
            this.f1489D.bringToFront();
            this.f1487B.addView(this.f1491F, layoutParams4);
            this.f1491F.bringToFront();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public void m1278k() {
        String str = "InterActivity";
        if (this.f1493H == null) {
            try {
                this.videoMuted = m1275i();
                this.f1493H = new ImageView(this);
                if (!m1281l()) {
                    int a = m1226a(((Integer) this.sdk.mo10202a(C1096c.f2473de)).intValue());
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a, a, ((Integer) this.sdk.mo10202a(C1096c.f2475dg)).intValue());
                    this.f1493H.setScaleType(ScaleType.FIT_CENTER);
                    int a2 = m1226a(((Integer) this.sdk.mo10202a(C1096c.f2474df)).intValue());
                    layoutParams.setMargins(a2, a2, a2, a2);
                    if ((this.videoMuted ? this.currentAd.mo9919ay() : this.currentAd.mo9920az()) != null) {
                        C1227o v = this.sdk.mo10249v();
                        StringBuilder sb = new StringBuilder();
                        sb.append("Added mute button with params: ");
                        sb.append(layoutParams);
                        v.mo10378b(str, sb.toString());
                        m1241a(this.videoMuted);
                        this.f1493H.setClickable(true);
                        this.f1493H.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View view) {
                                C0842m.this.toggleMute();
                            }
                        });
                        this.f1487B.addView(this.f1493H, layoutParams);
                        this.f1493H.bringToFront();
                        return;
                    }
                    this.sdk.mo10249v().mo10382e(str, "Attempting to add mute button but could not find uri");
                    return;
                }
                this.sdk.mo10249v().mo10378b(str, "Mute button should be hidden");
            } catch (Exception e) {
                this.sdk.mo10249v().mo10377a(str, "Failed to attach mute button", (Throwable) e);
            }
        }
    }

    /* renamed from: l */
    private boolean m1281l() {
        if (!((Boolean) this.sdk.mo10202a(C1096c.f2416cZ)).booleanValue()) {
            return true;
        }
        if (!((Boolean) this.sdk.mo10202a(C1096c.f2469da)).booleanValue() || m1275i()) {
            return false;
        }
        return !((Boolean) this.sdk.mo10202a(C1096c.f2471dc)).booleanValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public void m1282m() {
        runOnUiThread(new Runnable() {
            public void run() {
                try {
                    if (C0842m.this.f1511j) {
                        C0842m.this.f1488C.setVisibility(0);
                        return;
                    }
                    C0842m.this.f1519r = SystemClock.elapsedRealtime();
                    C0842m.this.f1511j = true;
                    if (C0842m.this.m1285n() && C0842m.this.f1489D != null) {
                        C0842m.this.f1489D.setVisibility(0);
                        C0842m.this.f1489D.bringToFront();
                    }
                    C0842m.this.f1488C.setVisibility(0);
                    C0842m.this.f1488C.bringToFront();
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                    alphaAnimation.setDuration((long) ((Integer) C0842m.this.sdk.mo10202a(C1096c.f2398cH)).intValue());
                    alphaAnimation.setRepeatCount(0);
                    C0842m.this.f1488C.startAnimation(alphaAnimation);
                } catch (Throwable unused) {
                    C0842m.this.dismiss();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public boolean m1285n() {
        return ((Integer) this.sdk.mo10202a(C1096c.f2421ce)).intValue() > 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public void m1286o() {
        runOnUiThread(new Runnable() {
            public void run() {
                try {
                    if (!C0842m.this.f1512k && C0842m.this.f1490E != null) {
                        C0842m.this.f1521t = -1;
                        C0842m.this.f1520s = SystemClock.elapsedRealtime();
                        C0842m.this.f1512k = true;
                        C0842m.this.f1490E.setVisibility(0);
                        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                        alphaAnimation.setDuration((long) ((Integer) C0842m.this.sdk.mo10202a(C1096c.f2398cH)).intValue());
                        alphaAnimation.setRepeatCount(0);
                        C0842m.this.f1490E.startAnimation(alphaAnimation);
                        if (C0842m.this.m1285n() && C0842m.this.f1491F != null) {
                            C0842m.this.f1491F.setVisibility(0);
                            C0842m.this.f1491F.bringToFront();
                        }
                    }
                } catch (Throwable th) {
                    C1227o oVar = C0842m.this.logger;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unable to show skip button: ");
                    sb.append(th);
                    oVar.mo10381d("InterActivity", sb.toString());
                }
            }
        });
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0011, code lost:
        if (r0 != null) goto L_0x0016;
     */
    /* renamed from: p */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m1288p() {
        /*
            r3 = this;
            com.applovin.impl.sdk.ad.f r0 = r3.currentAd
            float r0 = r0.mo9925m()
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x0023
            boolean r0 = r3.f1513l
            if (r0 == 0) goto L_0x0014
            com.applovin.impl.adview.h r0 = r3.f1490E
            if (r0 == 0) goto L_0x0014
            goto L_0x0016
        L_0x0014:
            com.applovin.impl.adview.h r0 = r3.f1488C
        L_0x0016:
            com.applovin.impl.sdk.ad.f r1 = r3.currentAd
            float r1 = r1.mo9925m()
            long r1 = com.applovin.impl.sdk.utils.C1281o.m3095b(r1)
            r3.m1230a(r1, r0)
        L_0x0023:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.adview.C0842m.m1288p():void");
    }

    /* access modifiers changed from: private */
    /* renamed from: q */
    public void m1291q() {
        boolean z = ((Boolean) this.sdk.mo10202a(C1096c.f2405cO)).booleanValue() && m1296t() > 0;
        if (this.f1492G == null && z) {
            this.f1492G = new C0823f(this);
            int B = this.currentAd.mo9864B();
            this.f1492G.setTextColor(B);
            this.f1492G.setTextSize((float) ((Integer) this.sdk.mo10202a(C1096c.f2404cN)).intValue());
            this.f1492G.setFinishedStrokeColor(B);
            this.f1492G.setFinishedStrokeWidth((float) ((Integer) this.sdk.mo10202a(C1096c.f2403cM)).intValue());
            this.f1492G.setMax(m1296t());
            this.f1492G.setProgress(m1296t());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(m1226a(((Integer) this.sdk.mo10202a(C1096c.f2402cL)).intValue()), m1226a(((Integer) this.sdk.mo10202a(C1096c.f2402cL)).intValue()), ((Integer) this.sdk.mo10202a(C1096c.f2401cK)).intValue());
            int a = m1226a(((Integer) this.sdk.mo10202a(C1096c.f2400cJ)).intValue());
            layoutParams.setMargins(a, a, a, a);
            this.f1487B.addView(this.f1492G, layoutParams);
            this.f1492G.bringToFront();
            this.f1492G.setVisibility(0);
            final long s = m1294s();
            this.countdownManager.mo9084a("COUNTDOWN_CLOCK", 1000, (C0830a) new C0830a() {
                /* renamed from: a */
                public void mo9088a() {
                    if (C0842m.this.f1492G != null) {
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(s - ((long) C0842m.this.videoView.getCurrentPosition()));
                        if (seconds <= 0) {
                            C0842m.this.f1492G.setVisibility(8);
                            C0842m.this.f1516o = true;
                        } else if (C0842m.this.m1293r()) {
                            C0842m.this.f1492G.setProgress((int) seconds);
                        }
                    }
                }

                /* renamed from: b */
                public boolean mo9089b() {
                    return C0842m.this.m1293r();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: r */
    public boolean m1293r() {
        return !this.f1516o && !this.poststitialWasDisplayed && this.videoView.isPlaying();
    }

    /* renamed from: s */
    private long m1294s() {
        return TimeUnit.SECONDS.toMillis((long) m1296t());
    }

    /* renamed from: t */
    private int m1296t() {
        int A = this.currentAd.mo9863A();
        if (A > 0) {
            return A;
        }
        if (((Boolean) this.sdk.mo10202a(C1096c.f2483do)).booleanValue()) {
            A = this.computedLengthSeconds + 1;
        }
        return A;
    }

    /* access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    /* renamed from: u */
    public void m1299u() {
        if (this.f1497L == null && this.currentAd.mo9874L()) {
            String str = "InterActivity";
            this.logger.mo10380c(str, "Attaching video progress bar...");
            this.f1497L = new ProgressBar(this, null, 16842872);
            this.f1497L.setMax(((Integer) this.sdk.mo10202a(C1096c.f2478dj)).intValue());
            this.f1497L.setPadding(0, 0, 0, 0);
            if (C1245f.m2935f()) {
                try {
                    this.f1497L.setProgressTintList(ColorStateList.valueOf(this.currentAd.mo9875M()));
                } catch (Throwable th) {
                    this.logger.mo10379b(str, "Unable to update progress bar color.", th);
                }
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.videoView.getWidth(), 20, 80);
            layoutParams.setMargins(0, 0, 0, ((Integer) this.sdk.mo10202a(C1096c.f2479dk)).intValue());
            this.f1487B.addView(this.f1497L, layoutParams);
            this.f1497L.bringToFront();
            String str2 = "PROGRESS_BAR";
            this.countdownManager.mo9084a(str2, ((Long) this.sdk.mo10202a(C1096c.f2477di)).longValue(), (C0830a) new C0830a() {
                /* renamed from: a */
                public void mo9088a() {
                    if (C0842m.this.f1497L == null) {
                        return;
                    }
                    if (C0842m.this.shouldContinueFullLengthVideoCountdown()) {
                        C0842m.this.f1497L.setProgress((int) ((((float) C0842m.this.videoView.getCurrentPosition()) / ((float) C0842m.this.videoView.getDuration())) * ((float) ((Integer) C0842m.this.sdk.mo10202a(C1096c.f2478dj)).intValue())));
                        return;
                    }
                    C0842m.this.f1497L.setVisibility(8);
                }

                /* renamed from: b */
                public boolean mo9089b() {
                    return C0842m.this.shouldContinueFullLengthVideoCountdown();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: v */
    public void m1300v() {
        final C0889s t = this.currentAd.mo9932t();
        if (C1277l.m3042b(this.currentAd.mo9931s()) && t != null && this.f1496K == null) {
            this.logger.mo10380c("InterActivity", "Attaching video button...");
            this.f1496K = m1303w();
            double a = (double) t.mo9205a();
            Double.isNaN(a);
            double d = a / 100.0d;
            double b = (double) t.mo9206b();
            Double.isNaN(b);
            double d2 = b / 100.0d;
            int width = this.videoView.getWidth();
            int height = this.videoView.getHeight();
            double d3 = (double) width;
            Double.isNaN(d3);
            int i = (int) (d * d3);
            double d4 = (double) height;
            Double.isNaN(d4);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, (int) (d2 * d4), t.mo9208d());
            int a2 = m1226a(t.mo9207c());
            layoutParams.setMargins(a2, a2, a2, a2);
            this.f1487B.addView(this.f1496K, layoutParams);
            this.f1496K.bringToFront();
            if (t.mo9215i() > 0.0f) {
                this.f1496K.setVisibility(4);
                this.f1486A.postDelayed(new Runnable() {
                    public void run() {
                        long g = t.mo9212g();
                        C0842m mVar = C0842m.this;
                        mVar.m1233a((View) mVar.f1496K, true, g);
                        C0842m.this.f1496K.bringToFront();
                    }
                }, C1281o.m3095b(t.mo9215i()));
            }
            if (t.mo9216j() > 0.0f) {
                this.f1486A.postDelayed(new Runnable() {
                    public void run() {
                        long h = t.mo9213h();
                        C0842m mVar = C0842m.this;
                        mVar.m1233a((View) mVar.f1496K, false, h);
                    }
                }, C1281o.m3095b(t.mo9216j()));
            }
        }
    }

    /* renamed from: w */
    private C0891u m1303w() {
        C1227o oVar = this.logger;
        StringBuilder sb = new StringBuilder();
        sb.append("Create video button with HTML = ");
        sb.append(this.currentAd.mo9931s());
        oVar.mo10378b("InterActivity", sb.toString());
        C0892v vVar = new C0892v(this.sdk);
        this.f1498M = new C0893a() {
            /* renamed from: a */
            public void mo9136a(C0891u uVar) {
                C0842m.this.logger.mo10378b("InterActivity", "Clicking through from video button...");
                C0842m.this.clickThroughFromVideo(uVar.getAndClearLastClickLocation());
            }

            /* renamed from: b */
            public void mo9137b(C0891u uVar) {
                C0842m.this.logger.mo10378b("InterActivity", "Closing ad from video button...");
                C0842m.this.dismiss();
            }

            /* renamed from: c */
            public void mo9138c(C0891u uVar) {
                C0842m.this.logger.mo10378b("InterActivity", "Skipping video from video button...");
                C0842m.this.skipVideo();
            }
        };
        vVar.mo9223a(new WeakReference(this.f1498M));
        C0891u uVar = new C0891u(vVar, getApplicationContext());
        uVar.mo9222a(this.currentAd.mo9931s());
        return uVar;
    }

    /* renamed from: x */
    private void m1304x() {
        if (this.f1514m && this.currentAd.mo9876N()) {
            this.f1499N = new C0799a(this, ((Integer) this.sdk.mo10202a(C1096c.f2482dn)).intValue(), this.currentAd.mo9878P());
            this.f1499N.setColor(this.currentAd.mo9879Q());
            this.f1499N.setBackgroundColor(this.currentAd.mo9880R());
            this.f1499N.setVisibility(8);
            this.f1487B.addView(this.f1499N, new FrameLayout.LayoutParams(-1, -1, 17));
            this.f1487B.bringChildToFront(this.f1499N);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: y */
    public void m1306y() {
        C0799a aVar = this.f1499N;
        if (aVar != null) {
            aVar.mo8994a();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: z */
    public void m1309z() {
        C0799a aVar = this.f1499N;
        if (aVar != null) {
            aVar.mo8995b();
        }
    }

    public void clickThroughFromVideo(PointF pointF) {
        try {
            if (this.currentAd.mo9906ak() && this.f1513l) {
                m1286o();
            }
            this.sdk.mo10241o().trackAndLaunchVideoClick(this.currentAd, this.f1502a, this.currentAd.mo8890g(), pointF);
            C1248i.m2998a(this.f1503b.mo9173e(), (AppLovinAd) this.currentAd);
            if (this.f1505d != null) {
                this.f1505d.mo10007b();
            }
        } catch (Throwable th) {
            this.sdk.mo10249v().mo10379b("InterActivity", "Encountered error while clicking through video.", th);
        }
    }

    public void continueVideo() {
        m1224O();
    }

    public void dismiss() {
        long currentTimeMillis = System.currentTimeMillis() - this.f1517p;
        StringBuilder sb = new StringBuilder();
        sb.append("Dismissing ad after ");
        sb.append(currentTimeMillis);
        sb.append(" milliseconds elapsed");
        C1227o.m2838f("InterActivity", sb.toString());
        m1270g();
        m1225P();
        if (this.f1503b != null) {
            if (this.currentAd != null) {
                m1256c((AppLovinAd) this.currentAd);
                C1108d dVar = this.f1505d;
                if (dVar != null) {
                    dVar.mo10009c();
                    this.f1505d = null;
                }
            }
            this.f1503b.mo9169a(false);
            this.f1503b.mo9175g();
        }
        lastKnownWrapper = null;
        m1263d();
    }

    public void exitWithError(String str) {
        String str2 = "InterActivity";
        m1240a(str);
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("Initialized = ");
            sb.append(C0876n.f1573b);
            sb.append("; CleanedUp = ");
            sb.append(C0876n.f1574c);
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Failed to properly render an Interstitial Activity, due to error: ");
            sb3.append(str);
            C1227o.m2837c(str2, sb3.toString(), new Throwable(sb2));
            m1256c((AppLovinAd) new C1088h());
        } catch (Exception e) {
            C1227o.m2837c(str2, "Failed to show a video ad due to error:", e);
        }
        dismiss();
    }

    public boolean getPoststitialWasDisplayed() {
        return this.poststitialWasDisplayed;
    }

    public int getVideoPercentViewed() {
        if (this.f1506e) {
            return 100;
        }
        C0890t tVar = this.videoView;
        if (tVar != null) {
            int duration = tVar.getDuration();
            if (duration <= 0) {
                return this.f1522u;
            }
            double currentPosition = (double) this.videoView.getCurrentPosition();
            double d = (double) duration;
            Double.isNaN(currentPosition);
            Double.isNaN(d);
            return (int) ((currentPosition / d) * 100.0d);
        }
        this.logger.mo10382e("InterActivity", "No video view detected on video end");
        return 0;
    }

    public void handleMediaError(String str) {
        this.logger.mo10382e("InterActivity", str);
        if (this.f1524w.compareAndSet(false, true) && this.currentAd.mo9870H()) {
            m1240a(str);
            dismiss();
        }
    }

    /* access modifiers changed from: protected */
    public boolean isFullyWatched() {
        return getVideoPercentViewed() >= this.currentAd.mo9882T();
    }

    /* access modifiers changed from: protected */
    public boolean isVastAd() {
        return this.currentAd instanceof C0769a;
    }

    public void onBackPressed() {
        C0826h hVar;
        if (this.currentAd != null) {
            if (this.currentAd.mo9917aw() && !this.poststitialWasDisplayed) {
                return;
            }
            if (this.currentAd.mo9918ax() && this.poststitialWasDisplayed) {
                return;
            }
        }
        String str = "InterActivity";
        if (m1259c()) {
            this.logger.mo10378b(str, "Back button was pressed; forwarding to Android for handling...");
        } else {
            try {
                if (!this.poststitialWasDisplayed && this.f1513l && this.f1490E != null && this.f1490E.getVisibility() == 0 && this.f1490E.getAlpha() > 0.0f) {
                    this.logger.mo10378b(str, "Back button was pressed; forwarding as a click to skip button.");
                    hVar = this.f1490E;
                } else if (this.f1488C == null || this.f1488C.getVisibility() != 0 || this.f1488C.getAlpha() <= 0.0f) {
                    this.logger.mo10378b(str, "Back button was pressed, but was not eligible for dismissal.");
                    m1252b("javascript:al_onBackPressed();");
                } else {
                    this.logger.mo10378b(str, "Back button was pressed; forwarding as a click to close button.");
                    hVar = this.f1488C;
                }
                hVar.performClick();
                m1252b("javascript:al_onBackPressed();");
            } catch (Exception unused) {
            }
        }
        super.onBackPressed();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation != 0 && (this.videoView instanceof C0883p) && this.f1494I.get() != null) {
            MediaPlayer mediaPlayer = (MediaPlayer) this.f1494I.get();
            this.videoView.setVideoSize(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0185  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r8) {
        /*
            r7 = this;
            java.lang.String r0 = "InterActivity"
            super.onCreate(r8)
            if (r8 == 0) goto L_0x0012
            java.lang.String r1 = "instance_impression_tracked"
            boolean r1 = r8.getBoolean(r1)
            java.util.concurrent.atomic.AtomicBoolean r2 = r7.f1525x
            r2.set(r1)
        L_0x0012:
            r1 = 1
            r7.requestWindowFeature(r1)
            android.os.StrictMode$ThreadPolicy r1 = android.os.StrictMode.allowThreadDiskReads()
            android.content.Intent r2 = r7.getIntent()     // Catch:{ Throwable -> 0x016a }
            java.lang.String r3 = "com.applovin.interstitial.wrapper_id"
            java.lang.String r2 = r2.getStringExtra(r3)     // Catch:{ Throwable -> 0x016a }
            if (r2 == 0) goto L_0x0165
            boolean r3 = r2.isEmpty()     // Catch:{ Throwable -> 0x016a }
            if (r3 != 0) goto L_0x0165
            com.applovin.impl.adview.n r2 = com.applovin.impl.adview.C0876n.m1318a(r2)     // Catch:{ Throwable -> 0x016a }
            r7.f1503b = r2     // Catch:{ Throwable -> 0x016a }
            com.applovin.impl.adview.n r2 = r7.f1503b     // Catch:{ Throwable -> 0x016a }
            if (r2 != 0) goto L_0x003e
            com.applovin.impl.adview.n r2 = lastKnownWrapper     // Catch:{ Throwable -> 0x016a }
            if (r2 == 0) goto L_0x003e
            com.applovin.impl.adview.n r2 = lastKnownWrapper     // Catch:{ Throwable -> 0x016a }
            r7.f1503b = r2     // Catch:{ Throwable -> 0x016a }
        L_0x003e:
            com.applovin.impl.adview.n r2 = r7.f1503b     // Catch:{ Throwable -> 0x016a }
            if (r2 == 0) goto L_0x0151
            com.applovin.impl.adview.n r2 = r7.f1503b     // Catch:{ Throwable -> 0x016a }
            com.applovin.sdk.AppLovinAd r2 = r2.mo9170b()     // Catch:{ Throwable -> 0x016a }
            com.applovin.impl.adview.n r3 = r7.f1503b     // Catch:{ Throwable -> 0x016a }
            com.applovin.impl.sdk.i r3 = r3.mo9166a()     // Catch:{ Throwable -> 0x016a }
            r7.sdk = r3     // Catch:{ Throwable -> 0x016a }
            com.applovin.impl.adview.n r3 = r7.f1503b     // Catch:{ Throwable -> 0x016a }
            com.applovin.impl.sdk.i r3 = r3.mo9166a()     // Catch:{ Throwable -> 0x016a }
            com.applovin.impl.sdk.o r3 = r3.mo10249v()     // Catch:{ Throwable -> 0x016a }
            r7.logger = r3     // Catch:{ Throwable -> 0x016a }
            if (r2 == 0) goto L_0x014b
            com.applovin.impl.sdk.ad.f r2 = (com.applovin.impl.sdk.p018ad.C1084f) r2     // Catch:{ Throwable -> 0x016a }
            com.applovin.impl.sdk.c.d r3 = new com.applovin.impl.sdk.c.d     // Catch:{ Throwable -> 0x016a }
            com.applovin.impl.sdk.i r4 = r7.sdk     // Catch:{ Throwable -> 0x016a }
            r3.<init>(r2, r4)     // Catch:{ Throwable -> 0x016a }
            r7.f1505d = r3     // Catch:{ Throwable -> 0x016a }
            r3 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r3 = r7.findViewById(r3)     // Catch:{ Throwable -> 0x016a }
            if (r3 == 0) goto L_0x0085
            boolean r4 = r2.hasVideoUrl()     // Catch:{ Throwable -> 0x016a }
            if (r4 == 0) goto L_0x0080
            int r4 = r2.mo9865C()     // Catch:{ Throwable -> 0x016a }
        L_0x007c:
            r3.setBackgroundColor(r4)     // Catch:{ Throwable -> 0x016a }
            goto L_0x0085
        L_0x0080:
            int r4 = r2.mo9866D()     // Catch:{ Throwable -> 0x016a }
            goto L_0x007c
        L_0x0085:
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x016a }
            r7.f1517p = r3     // Catch:{ Throwable -> 0x016a }
            boolean r3 = r2.mo9933v()     // Catch:{ Throwable -> 0x016a }
            if (r3 == 0) goto L_0x009a
            android.view.Window r3 = r7.getWindow()     // Catch:{ Throwable -> 0x016a }
            r4 = 16777216(0x1000000, float:2.3509887E-38)
            r3.setFlags(r4, r4)     // Catch:{ Throwable -> 0x016a }
        L_0x009a:
            boolean r3 = r2.mo9934w()     // Catch:{ Throwable -> 0x016a }
            if (r3 == 0) goto L_0x00a9
            android.view.Window r3 = r7.getWindow()     // Catch:{ Throwable -> 0x016a }
            r4 = 128(0x80, float:1.794E-43)
            r3.addFlags(r4)     // Catch:{ Throwable -> 0x016a }
        L_0x00a9:
            int r3 = com.applovin.impl.sdk.utils.C1281o.m3115g(r7)     // Catch:{ Throwable -> 0x016a }
            boolean r4 = com.applovin.sdk.AppLovinSdkUtils.isTablet(r7)     // Catch:{ Throwable -> 0x016a }
            int r5 = r7.m1227a(r3, r4)     // Catch:{ Throwable -> 0x016a }
            if (r8 != 0) goto L_0x00ba
            r7.f1523v = r5     // Catch:{ Throwable -> 0x016a }
            goto L_0x00c2
        L_0x00ba:
            java.lang.String r6 = "original_orientation"
            int r8 = r8.getInt(r6, r5)     // Catch:{ Throwable -> 0x016a }
            r7.f1523v = r8     // Catch:{ Throwable -> 0x016a }
        L_0x00c2:
            boolean r8 = r2.mo9937z()     // Catch:{ Throwable -> 0x016a }
            if (r8 == 0) goto L_0x00f0
            r8 = -1
            if (r5 == r8) goto L_0x00e5
            com.applovin.impl.sdk.o r8 = r7.logger     // Catch:{ Throwable -> 0x016a }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x016a }
            r2.<init>()     // Catch:{ Throwable -> 0x016a }
            java.lang.String r3 = "Locking activity orientation to current orientation: "
            r2.append(r3)     // Catch:{ Throwable -> 0x016a }
            r2.append(r5)     // Catch:{ Throwable -> 0x016a }
            java.lang.String r2 = r2.toString()     // Catch:{ Throwable -> 0x016a }
            r8.mo10378b(r0, r2)     // Catch:{ Throwable -> 0x016a }
            r7.m1247b(r5)     // Catch:{ Throwable -> 0x016a }
            goto L_0x00f8
        L_0x00e5:
            com.applovin.impl.sdk.o r8 = r7.logger     // Catch:{ Throwable -> 0x016a }
            java.lang.String r2 = "Unable to detect current orientation. Locking to targeted orientation..."
            r8.mo10382e(r0, r2)     // Catch:{ Throwable -> 0x016a }
        L_0x00ec:
            r7.m1248b(r3, r4)     // Catch:{ Throwable -> 0x016a }
            goto L_0x00f8
        L_0x00f0:
            com.applovin.impl.sdk.o r8 = r7.logger     // Catch:{ Throwable -> 0x016a }
            java.lang.String r2 = "Locking activity orientation to targeted orientation..."
            r8.mo10378b(r0, r2)     // Catch:{ Throwable -> 0x016a }
            goto L_0x00ec
        L_0x00f8:
            com.applovin.impl.adview.l r8 = new com.applovin.impl.adview.l     // Catch:{ Throwable -> 0x016a }
            com.applovin.impl.sdk.i r2 = r7.sdk     // Catch:{ Throwable -> 0x016a }
            com.applovin.sdk.AppLovinSdk r2 = r2.mo10193S()     // Catch:{ Throwable -> 0x016a }
            com.applovin.sdk.AppLovinAdSize r3 = com.applovin.sdk.AppLovinAdSize.INTERSTITIAL     // Catch:{ Throwable -> 0x016a }
            r8.<init>(r2, r3, r7)     // Catch:{ Throwable -> 0x016a }
            r7.f1502a = r8     // Catch:{ Throwable -> 0x016a }
            com.applovin.impl.adview.l r8 = r7.f1502a     // Catch:{ Throwable -> 0x016a }
            r2 = 0
            r8.setAutoDestroy(r2)     // Catch:{ Throwable -> 0x016a }
            com.applovin.impl.adview.l r8 = r7.f1502a     // Catch:{ Throwable -> 0x016a }
            com.applovin.adview.AdViewController r8 = r8.getAdViewController()     // Catch:{ Throwable -> 0x016a }
            com.applovin.impl.adview.AdViewControllerImpl r8 = (com.applovin.impl.adview.AdViewControllerImpl) r8     // Catch:{ Throwable -> 0x016a }
            com.applovin.impl.sdk.c.d r2 = r7.f1505d     // Catch:{ Throwable -> 0x016a }
            r8.setStatsManagerHelper(r2)     // Catch:{ Throwable -> 0x016a }
            com.applovin.impl.adview.n r8 = r7.f1503b     // Catch:{ Throwable -> 0x016a }
            r8.mo9167a(r7)     // Catch:{ Throwable -> 0x016a }
            com.applovin.impl.sdk.i r8 = r7.sdk     // Catch:{ Throwable -> 0x016a }
            com.applovin.impl.sdk.b.c<java.lang.Boolean> r2 = com.applovin.impl.sdk.p019b.C1096c.f2481dm     // Catch:{ Throwable -> 0x016a }
            java.lang.Object r8 = r8.mo10202a(r2)     // Catch:{ Throwable -> 0x016a }
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch:{ Throwable -> 0x016a }
            boolean r8 = r8.booleanValue()     // Catch:{ Throwable -> 0x016a }
            r7.f1513l = r8     // Catch:{ Throwable -> 0x016a }
            com.applovin.impl.sdk.a.b r8 = new com.applovin.impl.sdk.a.b     // Catch:{ Throwable -> 0x016a }
            com.applovin.impl.sdk.i r2 = r7.sdk     // Catch:{ Throwable -> 0x016a }
            r8.<init>(r7, r2)     // Catch:{ Throwable -> 0x016a }
            r7.f1495J = r8     // Catch:{ Throwable -> 0x016a }
            com.applovin.impl.adview.m$1 r8 = new com.applovin.impl.adview.m$1     // Catch:{ Throwable -> 0x016a }
            r8.<init>()     // Catch:{ Throwable -> 0x016a }
            r7.f1501P = r8     // Catch:{ Throwable -> 0x016a }
            com.applovin.impl.sdk.i r8 = r7.sdk     // Catch:{ Throwable -> 0x016a }
            com.applovin.impl.sdk.a r8 = r8.mo10217aa()     // Catch:{ Throwable -> 0x016a }
            com.applovin.impl.sdk.utils.a r2 = r7.f1501P     // Catch:{ Throwable -> 0x016a }
            r8.mo9736a(r2)     // Catch:{ Throwable -> 0x016a }
            goto L_0x017b
        L_0x014b:
            java.lang.String r8 = "No current ad found."
        L_0x014d:
            r7.exitWithError(r8)     // Catch:{ Throwable -> 0x016a }
            goto L_0x017b
        L_0x0151:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x016a }
            r8.<init>()     // Catch:{ Throwable -> 0x016a }
            java.lang.String r2 = "Wrapper is null; initialized state: "
            r8.append(r2)     // Catch:{ Throwable -> 0x016a }
            boolean r2 = com.applovin.impl.adview.C0876n.f1573b     // Catch:{ Throwable -> 0x016a }
            r8.append(r2)     // Catch:{ Throwable -> 0x016a }
            java.lang.String r8 = r8.toString()     // Catch:{ Throwable -> 0x016a }
            goto L_0x014d
        L_0x0165:
            java.lang.String r8 = "Wrapper ID is null"
            goto L_0x014d
        L_0x0168:
            r8 = move-exception
            goto L_0x018c
        L_0x016a:
            r8 = move-exception
            com.applovin.impl.sdk.o r2 = r7.logger     // Catch:{ all -> 0x0168 }
            if (r2 == 0) goto L_0x0176
            com.applovin.impl.sdk.o r2 = r7.logger     // Catch:{ all -> 0x0168 }
            java.lang.String r3 = "Encountered error during onCreate."
            r2.mo10379b(r0, r3, r8)     // Catch:{ all -> 0x0168 }
        L_0x0176:
            java.lang.String r8 = "An error was encountered during interstitial ad creation."
            r7.exitWithError(r8)     // Catch:{ all -> 0x0168 }
        L_0x017b:
            android.os.StrictMode.setThreadPolicy(r1)
            r7.m1270g()
            com.applovin.impl.sdk.c.d r8 = r7.f1505d
            if (r8 == 0) goto L_0x0188
            r8.mo10005a()
        L_0x0188:
            r7.m1219J()
            return
        L_0x018c:
            android.os.StrictMode.setThreadPolicy(r1)
            throw r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.adview.C0842m.onCreate(android.os.Bundle):void");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0064, code lost:
        if (r4.currentAd != null) goto L_0x007b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0079, code lost:
        if (r4.currentAd == null) goto L_0x0083;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x007b, code lost:
        m1225P();
        m1256c((com.applovin.sdk.AppLovinAd) r4.currentAd);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0083, code lost:
        super.onDestroy();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0086, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDestroy() {
        /*
            r4 = this;
            com.applovin.impl.adview.l r0 = r4.f1502a     // Catch:{ Throwable -> 0x0069 }
            r1 = 0
            if (r0 == 0) goto L_0x001d
            com.applovin.impl.adview.l r0 = r4.f1502a     // Catch:{ Throwable -> 0x0069 }
            android.view.ViewParent r0 = r0.getParent()     // Catch:{ Throwable -> 0x0069 }
            boolean r2 = r0 instanceof android.view.ViewGroup     // Catch:{ Throwable -> 0x0069 }
            if (r2 == 0) goto L_0x0016
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0     // Catch:{ Throwable -> 0x0069 }
            com.applovin.impl.adview.l r2 = r4.f1502a     // Catch:{ Throwable -> 0x0069 }
            r0.removeView(r2)     // Catch:{ Throwable -> 0x0069 }
        L_0x0016:
            com.applovin.impl.adview.l r0 = r4.f1502a     // Catch:{ Throwable -> 0x0069 }
            r0.destroy()     // Catch:{ Throwable -> 0x0069 }
            r4.f1502a = r1     // Catch:{ Throwable -> 0x0069 }
        L_0x001d:
            com.applovin.impl.adview.t r0 = r4.videoView     // Catch:{ Throwable -> 0x0069 }
            if (r0 == 0) goto L_0x002b
            com.applovin.impl.adview.t r0 = r4.videoView     // Catch:{ Throwable -> 0x0069 }
            r0.pause()     // Catch:{ Throwable -> 0x0069 }
            com.applovin.impl.adview.t r0 = r4.videoView     // Catch:{ Throwable -> 0x0069 }
            r0.stopPlayback()     // Catch:{ Throwable -> 0x0069 }
        L_0x002b:
            com.applovin.impl.sdk.i r0 = r4.sdk     // Catch:{ Throwable -> 0x0069 }
            if (r0 == 0) goto L_0x0047
            java.lang.ref.WeakReference<android.media.MediaPlayer> r0 = r4.f1494I     // Catch:{ Throwable -> 0x0069 }
            java.lang.Object r0 = r0.get()     // Catch:{ Throwable -> 0x0069 }
            android.media.MediaPlayer r0 = (android.media.MediaPlayer) r0     // Catch:{ Throwable -> 0x0069 }
            if (r0 == 0) goto L_0x003c
            r0.release()     // Catch:{ Throwable -> 0x0069 }
        L_0x003c:
            com.applovin.impl.sdk.i r0 = r4.sdk     // Catch:{ Throwable -> 0x0069 }
            com.applovin.impl.sdk.a r0 = r0.mo10217aa()     // Catch:{ Throwable -> 0x0069 }
            com.applovin.impl.sdk.utils.a r2 = r4.f1501P     // Catch:{ Throwable -> 0x0069 }
            r0.mo9737b(r2)     // Catch:{ Throwable -> 0x0069 }
        L_0x0047:
            com.applovin.impl.adview.i r0 = r4.countdownManager     // Catch:{ Throwable -> 0x0069 }
            if (r0 == 0) goto L_0x0050
            com.applovin.impl.adview.i r0 = r4.countdownManager     // Catch:{ Throwable -> 0x0069 }
            r0.mo9085b()     // Catch:{ Throwable -> 0x0069 }
        L_0x0050:
            android.os.Handler r0 = r4.f1486A     // Catch:{ Throwable -> 0x0069 }
            if (r0 == 0) goto L_0x0059
            android.os.Handler r0 = r4.f1486A     // Catch:{ Throwable -> 0x0069 }
            r0.removeCallbacksAndMessages(r1)     // Catch:{ Throwable -> 0x0069 }
        L_0x0059:
            android.os.Handler r0 = r4.f1527z     // Catch:{ Throwable -> 0x0069 }
            if (r0 == 0) goto L_0x0062
            android.os.Handler r0 = r4.f1527z     // Catch:{ Throwable -> 0x0069 }
            r0.removeCallbacksAndMessages(r1)     // Catch:{ Throwable -> 0x0069 }
        L_0x0062:
            com.applovin.impl.sdk.ad.f r0 = r4.currentAd
            if (r0 == 0) goto L_0x0083
            goto L_0x007b
        L_0x0067:
            r0 = move-exception
            goto L_0x0087
        L_0x0069:
            r0 = move-exception
            com.applovin.impl.sdk.o r1 = r4.logger     // Catch:{ all -> 0x0067 }
            if (r1 == 0) goto L_0x0077
            com.applovin.impl.sdk.o r1 = r4.logger     // Catch:{ all -> 0x0067 }
            java.lang.String r2 = "InterActivity"
            java.lang.String r3 = "Unable to destroy video view"
            r1.mo10377a(r2, r3, r0)     // Catch:{ all -> 0x0067 }
        L_0x0077:
            com.applovin.impl.sdk.ad.f r0 = r4.currentAd
            if (r0 == 0) goto L_0x0083
        L_0x007b:
            r4.m1225P()
            com.applovin.impl.sdk.ad.f r0 = r4.currentAd
            r4.m1256c(r0)
        L_0x0083:
            super.onDestroy()
            return
        L_0x0087:
            com.applovin.impl.sdk.ad.f r1 = r4.currentAd
            if (r1 == 0) goto L_0x0093
            r4.m1225P()
            com.applovin.impl.sdk.ad.f r1 = r4.currentAd
            r4.m1256c(r1)
        L_0x0093:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.adview.C0842m.onDestroy():void");
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if ((i == 25 || i == 24) && this.currentAd.mo9886X() && m1221L()) {
            toggleMute();
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.logger.mo10378b("InterActivity", "App paused...");
        this.f1518q = System.currentTimeMillis();
        if (this.poststitialWasDisplayed) {
            m1222M();
        }
        this.f1503b.mo9169a(false);
        this.f1495J.mo9760a();
        pauseReportRewardTask();
        m1252b("javascript:al_onAppPaused();");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0073, code lost:
        if (r0 != null) goto L_0x00ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00ac, code lost:
        if (r1 == false) goto L_0x00ae;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onResume() {
        /*
            r6 = this;
            super.onResume()
            com.applovin.impl.sdk.o r0 = r6.logger
            java.lang.String r1 = "InterActivity"
            java.lang.String r2 = "App resumed..."
            r0.mo10378b(r1, r2)
            com.applovin.impl.adview.n r0 = r6.f1503b
            r1 = 1
            r0.mo9169a(r1)
            boolean r0 = r6.f1515n
            if (r0 != 0) goto L_0x00b5
            com.applovin.impl.sdk.c.d r0 = r6.f1505d
            if (r0 == 0) goto L_0x0024
            long r2 = java.lang.System.currentTimeMillis()
            long r4 = r6.f1518q
            long r2 = r2 - r4
            r0.mo10012d(r2)
        L_0x0024:
            com.applovin.impl.sdk.i r0 = r6.sdk
            com.applovin.impl.sdk.b.e<java.lang.Boolean> r2 = com.applovin.impl.sdk.p019b.C1098e.f2575u
            r3 = 0
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r3)
            java.lang.Object r0 = r0.mo10222b(r2, r4)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r4 = 0
            if (r0 == 0) goto L_0x0076
            com.applovin.impl.sdk.a.b r0 = r6.f1495J
            boolean r0 = r0.mo9763d()
            if (r0 != 0) goto L_0x0076
            boolean r0 = r6.poststitialWasDisplayed
            if (r0 != 0) goto L_0x0076
            r6.m1223N()
            r6.m1306y()
            com.applovin.impl.sdk.ad.f r0 = r6.currentAd
            if (r0 == 0) goto L_0x00b1
            com.applovin.impl.sdk.i r0 = r6.sdk
            com.applovin.impl.sdk.b.c<java.lang.Boolean> r1 = com.applovin.impl.sdk.p019b.C1096c.f2399cI
            java.lang.Object r0 = r0.mo10202a(r1)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x00b1
            com.applovin.impl.sdk.ad.f r0 = r6.currentAd
            boolean r0 = r0.mo9936y()
            if (r0 != 0) goto L_0x00b1
            boolean r0 = r6.poststitialWasDisplayed
            if (r0 != 0) goto L_0x00b1
            boolean r0 = r6.f1513l
            if (r0 == 0) goto L_0x00b1
            com.applovin.impl.adview.h r0 = r6.f1490E
            if (r0 == 0) goto L_0x00b1
            goto L_0x00ae
        L_0x0076:
            com.applovin.impl.sdk.ad.f r0 = r6.currentAd
            boolean r0 = r0 instanceof com.applovin.impl.sdk.p018ad.C1078a
            if (r0 == 0) goto L_0x0087
            com.applovin.impl.sdk.ad.f r0 = r6.currentAd
            com.applovin.impl.sdk.ad.a r0 = (com.applovin.impl.sdk.p018ad.C1078a) r0
            boolean r0 = r0.mo9835i()
            if (r0 == 0) goto L_0x0087
            goto L_0x0088
        L_0x0087:
            r1 = 0
        L_0x0088:
            com.applovin.impl.sdk.ad.f r0 = r6.currentAd
            if (r0 == 0) goto L_0x00b1
            com.applovin.impl.sdk.i r0 = r6.sdk
            com.applovin.impl.sdk.b.c<java.lang.Boolean> r2 = com.applovin.impl.sdk.p019b.C1096c.f2399cI
            java.lang.Object r0 = r0.mo10202a(r2)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x00b1
            com.applovin.impl.sdk.ad.f r0 = r6.currentAd
            boolean r0 = r0.mo9935x()
            if (r0 != 0) goto L_0x00b1
            boolean r0 = r6.poststitialWasDisplayed
            if (r0 == 0) goto L_0x00b1
            com.applovin.impl.adview.h r0 = r6.f1488C
            if (r0 == 0) goto L_0x00b1
            if (r1 != 0) goto L_0x00b1
        L_0x00ae:
            r6.m1230a(r4, r0)
        L_0x00b1:
            r6.resumeReportRewardTask()
            goto L_0x00d0
        L_0x00b5:
            com.applovin.impl.sdk.a.b r0 = r6.f1495J
            boolean r0 = r0.mo9763d()
            if (r0 != 0) goto L_0x00d0
            boolean r0 = r6.poststitialWasDisplayed
            if (r0 != 0) goto L_0x00d0
            com.applovin.impl.sdk.ad.f r0 = r6.currentAd
            if (r0 == 0) goto L_0x00d0
            com.applovin.impl.sdk.ad.f r0 = r6.currentAd
            boolean r0 = r0.mo9877O()
            if (r0 == 0) goto L_0x00d0
            r6.m1306y()
        L_0x00d0:
            java.lang.String r0 = "javascript:al_onAppResumed();"
            r6.m1252b(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.adview.C0842m.onResume():void");
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("instance_impression_tracked", this.f1525x.get());
        bundle.putInt("original_orientation", this.f1523v);
    }

    public void onWindowFocusChanged(boolean z) {
        String str;
        super.onWindowFocusChanged(z);
        String str2 = "InterActivity";
        if (z) {
            if (this.sdk != null) {
                this.logger.mo10378b(str2, "Window gained focus");
                try {
                    if (!C1245f.m2934e() || !((Boolean) this.sdk.mo10202a(C1096c.f2476dh)).booleanValue() || !m1242a()) {
                        getWindow().setFlags(1024, 1024);
                    } else {
                        m1246b();
                        if (((Long) this.sdk.mo10202a(C1096c.f2409cS)).longValue() > 0) {
                            this.f1486A.postDelayed(new Runnable() {
                                public void run() {
                                    C0842m.this.m1246b();
                                }
                            }, ((Long) this.sdk.mo10202a(C1096c.f2409cS)).longValue());
                        }
                    }
                    if (((Boolean) this.sdk.mo10202a(C1096c.f2410cT)).booleanValue() && !this.poststitialWasDisplayed) {
                        m1223N();
                        resumeReportRewardTask();
                    }
                } catch (Throwable th) {
                    this.logger.mo10379b(str2, "Setting window flags failed.", th);
                }
                this.f1515n = false;
                StringBuilder sb = new StringBuilder();
                sb.append("javascript:al_onWindowFocusChanged( ");
                sb.append(z);
                sb.append(" );");
                m1252b(sb.toString());
            }
            str = "Window gained focus. SDK is null.";
        } else if (this.sdk != null) {
            this.logger.mo10378b(str2, "Window lost focus");
            if (((Boolean) this.sdk.mo10202a(C1096c.f2410cT)).booleanValue() && !this.poststitialWasDisplayed) {
                m1222M();
                pauseReportRewardTask();
            }
            this.f1515n = false;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("javascript:al_onWindowFocusChanged( ");
            sb2.append(z);
            sb2.append(" );");
            m1252b(sb2.toString());
        } else {
            str = "Window lost focus. SDK is null.";
        }
        C1227o.m2838f(str2, str);
        this.f1515n = false;
        StringBuilder sb22 = new StringBuilder();
        sb22.append("javascript:al_onWindowFocusChanged( ");
        sb22.append(z);
        sb22.append(" );");
        m1252b(sb22.toString());
    }

    public void pauseReportRewardTask() {
        C1278m mVar = this.f1500O;
        if (mVar != null) {
            mVar.mo10439b();
        }
    }

    /* access modifiers changed from: protected */
    public void playVideo() {
        m1265d((AppLovinAd) this.currentAd);
        this.videoView.start();
        this.countdownManager.mo9083a();
    }

    public void resumeReportRewardTask() {
        C1278m mVar = this.f1500O;
        if (mVar != null) {
            mVar.mo10440c();
        }
    }

    /* access modifiers changed from: protected */
    public boolean shouldContinueFullLengthVideoCountdown() {
        return !this.f1506e && !this.poststitialWasDisplayed;
    }

    public void showPoststitial() {
        long j;
        C0826h hVar;
        String str = "InterActivity";
        try {
            if (this.f1505d != null) {
                this.f1505d.mo10016g();
            }
            if (!this.currentAd.mo9900ae()) {
                m1220K();
            }
            if (this.f1502a != null) {
                ViewParent parent = this.f1502a.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(this.f1502a);
                }
                FrameLayout frameLayout = new FrameLayout(this);
                frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                frameLayout.setBackgroundColor(this.currentAd.mo9866D());
                frameLayout.addView(this.f1502a);
                if (this.currentAd.mo9900ae()) {
                    m1220K();
                }
                if (this.f1487B != null) {
                    this.f1487B.removeAllViewsInLayout();
                }
                if (m1285n() && this.f1489D != null) {
                    if (this.f1489D.getParent() instanceof ViewGroup) {
                        ((ViewGroup) this.f1489D.getParent()).removeView(this.f1489D);
                    }
                    frameLayout.addView(this.f1489D);
                    this.f1489D.bringToFront();
                }
                if (this.f1488C != null) {
                    ViewParent parent2 = this.f1488C.getParent();
                    if (parent2 instanceof ViewGroup) {
                        ((ViewGroup) parent2).removeView(this.f1488C);
                    }
                    frameLayout.addView(this.f1488C);
                    this.f1488C.bringToFront();
                }
                setContentView(frameLayout);
                if (((Boolean) this.sdk.mo10202a(C1096c.f2514eT)).booleanValue()) {
                    this.f1502a.setVisibility(4);
                    this.f1502a.setVisibility(0);
                }
                int U = this.currentAd.mo9883U();
                if (U >= 0) {
                    this.f1486A.postDelayed(new Runnable() {
                        public void run() {
                            C0842m.this.m1257c("javascript:al_onPoststitialShow();");
                        }
                    }, (long) U);
                }
            }
            if (!((this.currentAd instanceof C1078a) && ((C1078a) this.currentAd).mo9835i())) {
                if (this.currentAd.mo9926n() >= 0.0f) {
                    j = C1281o.m3095b(this.currentAd.mo9926n());
                    hVar = this.f1488C;
                } else if (this.currentAd.mo9926n() == -2.0f) {
                    this.f1488C.setVisibility(0);
                } else {
                    j = 0;
                    hVar = this.f1488C;
                }
                m1230a(j, hVar);
            } else {
                this.logger.mo10378b(str, "Skip showing of close button");
            }
            this.poststitialWasDisplayed = true;
        } catch (Throwable th) {
            this.logger.mo10379b(str, "Encountered error while showing poststitial. Dismissing...", th);
            dismiss();
        }
    }

    public void skipVideo() {
        this.f1521t = SystemClock.elapsedRealtime() - this.f1520s;
        C1108d dVar = this.f1505d;
        if (dVar != null) {
            dVar.mo10015f();
        }
        if (this.currentAd.mo9929q()) {
            dismiss();
        } else {
            showPoststitial();
        }
    }

    public void toggleMute() {
        boolean z = !m1221L();
        C1108d dVar = this.f1505d;
        if (dVar != null) {
            dVar.mo10018i();
        }
        try {
            m1258c(z);
            m1241a(z);
            m1253b(z);
        } catch (Throwable th) {
            C1227o oVar = this.logger;
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to set volume to ");
            sb.append(z);
            oVar.mo10379b("InterActivity", sb.toString(), th);
        }
    }
}
