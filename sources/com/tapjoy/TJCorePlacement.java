package com.tapjoy;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import com.facebook.internal.ServerProtocol;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import com.tapjoy.TJAdUnit.TJAdUnitVideoListener;
import com.tapjoy.TJAdUnit.TJAdUnitWebViewListener;
import com.tapjoy.TapjoyErrorMessage.ErrorType;
import com.tapjoy.internal.C1809b;
import com.tapjoy.internal.C1823gf;
import com.tapjoy.internal.C1823gf.C1825a;
import com.tapjoy.internal.C1831gz;
import com.tapjoy.internal.C1837hg;
import com.tapjoy.internal.C1852jq;
import com.tapjoy.internal.C2917cb;
import com.tapjoy.internal.C3065fi;
import com.tapjoy.internal.C3071fm;
import com.tapjoy.internal.C3078fq;
import com.tapjoy.internal.C3083fu;
import com.tapjoy.internal.C3084fv;
import com.tapjoy.internal.C3085fw;
import com.tapjoy.internal.C3091ga;
import com.tapjoy.internal.C3107gi;
import com.tapjoy.internal.C3120gv;
import com.tapjoy.internal.C3124gw;
import com.tapjoy.internal.C3136he;
import com.tapjoy.internal.C3143hi;
import com.tapjoy.internal.C3181ij;
import com.tapjoy.internal.C3181ij.C3182a;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class TJCorePlacement {
    /* access modifiers changed from: 0000 */

    /* renamed from: a */
    public static final String f6303a = "TJCorePlacement";

    /* renamed from: A */
    private boolean f6304A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public Handler f6305B;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public Runnable f6306C;

    /* renamed from: D */
    private TJAdUnitWebViewListener f6307D = new TJAdUnitWebViewListener() {
        public final void onContentReady() {
            TJCorePlacement.this.m6455e();
        }

        public final void onClosed() {
            if (TJCorePlacement.this.f6315h) {
                TJPlacementManager.decrementPlacementCacheCount();
                TJCorePlacement.this.f6315h = false;
            }
            if (TJCorePlacement.this.f6329v) {
                TJPlacementManager.decrementPlacementPreRenderCount();
                TJCorePlacement.this.f6329v = false;
            }
        }

        public final void onClick() {
            TJCorePlacement.m6456e(TJCorePlacement.this);
        }
    };

    /* renamed from: E */
    private TJAdUnitVideoListener f6308E = new TJAdUnitVideoListener() {
        public final void onVideoStart() {
            TJPlacement a = TJCorePlacement.this.mo29544a("SHOW");
            if (a != null && a.getVideoListener() != null) {
                a.getVideoListener().onVideoStart(a);
            }
        }

        public final void onVideoCompleted() {
            TJPlacement a = TJCorePlacement.this.mo29544a("SHOW");
            if (a != null && a.getVideoListener() != null) {
                a.getVideoListener().onVideoComplete(a);
            }
        }

        public final void onVideoError(String str) {
            TJPlacement a = TJCorePlacement.this.mo29544a("SHOW");
            if (a != null && a.getVideoListener() != null) {
                a.getVideoListener().onVideoError(a, str);
            }
        }
    };
    /* access modifiers changed from: 0000 */

    /* renamed from: b */
    public Context f6309b = C1809b.m3455c();
    /* access modifiers changed from: 0000 */

    /* renamed from: c */
    public TJPlacementData f6310c;

    /* renamed from: d */
    String f6311d;
    /* access modifiers changed from: 0000 */

    /* renamed from: e */
    public long f6312e;

    /* renamed from: f */
    final C3085fw f6313f = new C3085fw();

    /* renamed from: g */
    TJAdUnit f6314g;
    /* access modifiers changed from: 0000 */

    /* renamed from: h */
    public boolean f6315h = false;
    /* access modifiers changed from: 0000 */

    /* renamed from: i */
    public C1837hg f6316i = null;

    /* renamed from: j */
    boolean f6317j;

    /* renamed from: k */
    volatile boolean f6318k = false;

    /* renamed from: l */
    volatile boolean f6319l = false;

    /* renamed from: m */
    String f6320m;

    /* renamed from: n */
    String f6321n;

    /* renamed from: o */
    String f6322o;

    /* renamed from: p */
    String f6323p;

    /* renamed from: q */
    HashMap f6324q;

    /* renamed from: r */
    private Map f6325r = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: s */
    public Map f6326s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public TapjoyURLConnection f6327t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public C3071fm f6328u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public boolean f6329v = false;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public C3181ij f6330w = null;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public boolean f6331x = false;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public volatile boolean f6332y = false;

    /* renamed from: z */
    private volatile boolean f6333z = false;

    TJCorePlacement(String str, String str2, boolean z) {
        if (this.f6309b == null) {
            TapjoyLog.m6550d(f6303a, "getVisibleActivity() is NULL. Activity can be explicitly set via `Tapjoy.setActivity(Activity)`");
        }
        this.f6304A = z;
        this.f6310c = new TJPlacementData(str2, getPlacementContentUrl());
        this.f6310c.setPlacementName(str);
        this.f6311d = UUID.randomUUID().toString();
        this.f6314g = new TJAdUnit();
        this.f6314g.setWebViewListener(this.f6307D);
        this.f6314g.setVideoListener(this.f6308E);
        this.f6306C = new Runnable() {
            public final void run() {
                TapjoyLog.m6553i(TJCorePlacement.f6303a, "Placement request timed out");
                TJCorePlacement.this.m6457f();
                TJCorePlacement.this.f6331x = true;
                TJCorePlacement.m6459g(TJCorePlacement.this);
            }
        };
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo29546a(TJPlacement tJPlacement) {
        boolean z = false;
        if (tJPlacement == null) {
            mo29548a(ErrorType.SDK_ERROR, new TJError(0, "Cannot request content from a NULL placement"));
            return;
        }
        mo29549a("REQUEST", tJPlacement);
        String str = "TJPlacement.requestContent";
        if (this.f6312e - SystemClock.elapsedRealtime() > 0) {
            String str2 = f6303a;
            StringBuilder sb = new StringBuilder("Content has not expired yet for ");
            sb.append(this.f6310c.getPlacementName());
            TapjoyLog.m6550d(str2, sb.toString());
            boolean z2 = this.f6318k;
            String str3 = "cache";
            String str4 = "from";
            String str5 = Param.CONTENT_TYPE;
            if (z2) {
                C1823gf.m3520b(str).mo18099a(str5, (Object) mo29545a()).mo18099a(str4, (Object) str3).mo18104c();
                this.f6333z = false;
                m6446b(tJPlacement);
                m6455e();
                return;
            }
            C1823gf.m3520b(str).mo18099a(str5, (Object) "none").mo18099a(str4, (Object) str3).mo18104c();
            m6446b(tJPlacement);
            return;
        }
        if (this.f6318k) {
            C1823gf.m3522c(str).mo18099a("was_available", (Object) Boolean.valueOf(true));
        }
        if (this.f6319l) {
            C1823gf.m3522c(str).mo18099a("was_ready", (Object) Boolean.valueOf(true));
        }
        if (!C1852jq.m3669c(this.f6322o)) {
            HashMap hashMap = new HashMap();
            hashMap.put(TJAdUnitConstants.PARAM_PLACEMENT_MEDIATION_AGENT, this.f6322o);
            hashMap.put(TJAdUnitConstants.PARAM_PLACEMENT_MEDIATION_ID, this.f6323p);
            HashMap hashMap2 = this.f6324q;
            if (hashMap2 != null && !hashMap2.isEmpty()) {
                z = true;
            }
            if (z) {
                for (String str6 : this.f6324q.keySet()) {
                    StringBuilder sb2 = new StringBuilder(TJAdUnitConstants.AUCTION_PARAM_PREFIX);
                    sb2.append(str6);
                    hashMap.put(sb2.toString(), this.f6324q.get(str6));
                }
                m6444a(this.f6310c.getAuctionMediationURL(), (Map) hashMap);
                return;
            }
            m6444a(this.f6310c.getMediationURL(), (Map) hashMap);
            return;
        }
        m6453d();
    }

    /* renamed from: d */
    private synchronized void m6453d() {
        String url = this.f6310c.getUrl();
        if (C1852jq.m3669c(url)) {
            url = getPlacementContentUrl();
            if (C1852jq.m3669c(url)) {
                String str = "TJPlacement is missing APP_ID";
                C1823gf.m3520b("TJPlacement.requestContent").mo18097a(str).mo18104c();
                mo29548a(ErrorType.SDK_ERROR, new TJError(0, str));
                return;
            }
            this.f6310c.updateUrl(url);
        }
        String str2 = f6303a;
        StringBuilder sb = new StringBuilder("sendContentRequest -- URL: ");
        sb.append(url);
        sb.append(" name: ");
        sb.append(this.f6310c.getPlacementName());
        TapjoyLog.m6550d(str2, sb.toString());
        m6444a(url, (Map) null);
    }

    /* renamed from: a */
    private synchronized void m6444a(String str, Map map) {
        if (this.f6332y) {
            String str2 = f6303a;
            StringBuilder sb = new StringBuilder("Placement ");
            sb.append(this.f6310c.getPlacementName());
            sb.append(" is already requesting content");
            TapjoyLog.m6553i(str2, sb.toString());
            C1823gf.m3520b("TJPlacement.requestContent").mo18102b("already doing").mo18104c();
            return;
        }
        this.f6310c.resetPlacementRequestData();
        C3085fw fwVar = this.f6313f;
        String str3 = null;
        fwVar.f7272b = null;
        fwVar.f7274d = null;
        fwVar.f7271a = null;
        this.f6314g.resetContentLoadState();
        this.f6332y = false;
        this.f6333z = false;
        this.f6318k = false;
        this.f6319l = false;
        this.f6316i = null;
        this.f6330w = null;
        this.f6332y = true;
        final TJPlacement a = mo29544a("REQUEST");
        if (!this.f6304A) {
            this.f6326s = TapjoyConnectCore.getGenericURLParams();
            this.f6326s.putAll(TapjoyConnectCore.getTimeStampAndVerifierParams());
        } else {
            this.f6326s = TapjoyConnectCore.getLimitedGenericURLParams();
            this.f6326s.putAll(TapjoyConnectCore.getLimitedTimeStampAndVerifierParams());
        }
        TapjoyUtil.safePut(this.f6326s, "event_name", this.f6310c.getPlacementName(), true);
        TapjoyUtil.safePut(this.f6326s, TJAdUnitConstants.PARAM_PLACEMENT_PRELOAD, "true", true);
        TapjoyUtil.safePut(this.f6326s, "debug", Boolean.toString(C3124gw.f7370a), true);
        C1831gz a2 = C1831gz.m3554a();
        Map map2 = this.f6326s;
        String str4 = TJAdUnitConstants.PARAM_ACTION_ID_EXCLUSION;
        if (a2.f3818b != null) {
            C3143hi hiVar = a2.f3818b;
            hiVar.mo30216b();
            str3 = hiVar.f7422b.mo30368a();
        }
        TapjoyUtil.safePut(map2, str4, str3, true);
        TapjoyUtil.safePut(this.f6326s, TJAdUnitConstants.PARAM_PLACEMENT_BY_SDK, String.valueOf(this.f6317j), true);
        TapjoyUtil.safePut(this.f6326s, TJAdUnitConstants.PARAM_PUSH_ID, a.pushId, true);
        TapjoyUtil.safePut(this.f6326s, TapjoyConstants.TJC_MEDIATION_SOURCE, this.f6320m, true);
        TapjoyUtil.safePut(this.f6326s, TapjoyConstants.TJC_ADAPTER_VERSION, this.f6321n, true);
        if (!C1852jq.m3669c(TapjoyConnectCore.getCustomParameter())) {
            TapjoyUtil.safePut(this.f6326s, TapjoyConstants.TJC_CUSTOM_PARAMETER, TapjoyConnectCore.getCustomParameter(), true);
        }
        if (map != null) {
            this.f6326s.putAll(map);
        }
        final C3065fi fiVar = new C3065fi(C3091ga.m7138b().mo18108b("placement_request_content_retry_timeout"));
        final C3107gi c = C3091ga.m7138b().mo18109c("placement_request_content_retry_backoff");
        final C1825a d = C1823gf.m3523d("TJPlacement.requestContent");
        final String str5 = str;
        C28144 r3 = new Thread() {
            public final void run() {
                C1823gf.m3515a("TJPlacement.requestContent", d);
                int i = 0;
                while (!m6480a()) {
                    i++;
                    TJCorePlacement.this.f6326s.put(TapjoyConstants.TJC_RETRY, Integer.toString(i));
                    if (i == 1) {
                        d.mo18099a("retry_timeout", (Object) Long.valueOf(fiVar.f7231b));
                    }
                    d.mo18098a("retry_count", (long) i);
                }
            }

            /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
            /* JADX WARNING: Missing exception handler attribute for start block: B:69:0x035e */
            /* renamed from: a */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private boolean m6480a() {
                /*
                    r12 = this;
                    java.lang.String r0 = com.tapjoy.TJCorePlacement.f6303a
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    java.lang.String r2 = "Sending content request for placement "
                    r1.<init>(r2)
                    com.tapjoy.TJCorePlacement r2 = com.tapjoy.TJCorePlacement.this
                    java.lang.String r2 = r2.f6310c.getPlacementName()
                    r1.append(r2)
                    java.lang.String r1 = r1.toString()
                    com.tapjoy.TapjoyLog.m6553i(r0, r1)
                    com.tapjoy.TJCorePlacement r0 = com.tapjoy.TJCorePlacement.this
                    com.tapjoy.internal.gz r1 = com.tapjoy.internal.C1831gz.m3554a()
                    com.tapjoy.TJCorePlacement r2 = com.tapjoy.TJCorePlacement.this
                    java.lang.String r8 = r2.f6310c.getPlacementName()
                    com.tapjoy.TJCorePlacement r2 = com.tapjoy.TJCorePlacement.this
                    android.content.Context r9 = r2.f6309b
                    com.tapjoy.internal.hh r1 = r1.f3817a
                    com.tapjoy.internal.gz r2 = r1.f7417a
                    r10 = 0
                    com.tapjoy.internal.fb r2 = r2.mo18118a(r10)
                    com.tapjoy.internal.ij r11 = new com.tapjoy.internal.ij
                    com.tapjoy.internal.gz r4 = r1.f7417a
                    com.tapjoy.internal.fa r5 = r2.f7101d
                    com.tapjoy.internal.eu r6 = r2.f7102e
                    com.tapjoy.internal.fh r7 = r2.f7103f
                    r3 = r11
                    r3.<init>(r4, r5, r6, r7, r8, r9)
                    r0.f6330w = r11
                    com.tapjoy.TJCorePlacement r0 = com.tapjoy.TJCorePlacement.this
                    com.tapjoy.TapjoyURLConnection r1 = new com.tapjoy.TapjoyURLConnection
                    r1.<init>()
                    r0.f6327t = r1
                    com.tapjoy.TJCorePlacement r0 = com.tapjoy.TJCorePlacement.this
                    android.os.Handler r0 = r0.f6305B
                    if (r0 != 0) goto L_0x0067
                    com.tapjoy.TJCorePlacement r0 = com.tapjoy.TJCorePlacement.this
                    android.os.Handler r1 = new android.os.Handler
                    android.os.Looper r2 = android.os.Looper.getMainLooper()
                    r1.<init>(r2)
                    r0.f6305B = r1
                L_0x0067:
                    com.tapjoy.TJCorePlacement r0 = com.tapjoy.TJCorePlacement.this
                    r0.f6331x = r10
                    com.tapjoy.TJCorePlacement r0 = com.tapjoy.TJCorePlacement.this
                    android.os.Handler r0 = r0.f6305B
                    com.tapjoy.TJCorePlacement r1 = com.tapjoy.TJCorePlacement.this
                    java.lang.Runnable r1 = r1.f6306C
                    int r2 = com.tapjoy.TJPlacementManager.getPlacementResponseTimeOut()
                    long r2 = (long) r2
                    r0.postDelayed(r1, r2)
                    com.tapjoy.TJCorePlacement r0 = com.tapjoy.TJCorePlacement.this
                    com.tapjoy.TapjoyURLConnection r1 = r0.f6327t
                    java.lang.String r2 = r7
                    r3 = 0
                    r4 = 0
                    com.tapjoy.TJCorePlacement r0 = com.tapjoy.TJCorePlacement.this
                    java.util.Map r5 = r0.f6326s
                    int r6 = com.tapjoy.TJPlacementManager.getPlacementResponseTimeOut()
                    com.tapjoy.TapjoyHttpURLResponse r0 = r1.getResponseFromURL(r2, r3, r4, r5, r6)
                    com.tapjoy.TJCorePlacement r1 = com.tapjoy.TJCorePlacement.this
                    com.tapjoy.TJPlacementData r1 = r1.f6310c
                    int r2 = r0.statusCode
                    r1.setHttpStatusCode(r2)
                    com.tapjoy.TJCorePlacement r1 = com.tapjoy.TJCorePlacement.this
                    com.tapjoy.TJPlacementData r1 = r1.f6310c
                    java.lang.String r2 = r0.response
                    r1.setHttpResponse(r2)
                    java.lang.String r1 = "x-tapjoy-prerender"
                    java.lang.String r1 = r0.getHeaderFieldAsString(r1)
                    java.lang.String r2 = "0"
                    boolean r1 = r1.equals(r2)
                    r2 = 1
                    if (r1 != 0) goto L_0x00c6
                    com.tapjoy.TJCorePlacement r1 = com.tapjoy.TJCorePlacement.this
                    com.tapjoy.TJPlacementData r1 = r1.f6310c
                    r1.setPrerenderingRequested(r2)
                L_0x00c6:
                    java.lang.String r1 = "X-Tapjoy-Debug"
                    java.lang.String r1 = r0.getHeaderFieldAsString(r1)
                    if (r1 == 0) goto L_0x00e3
                    java.lang.String r3 = com.tapjoy.TJCorePlacement.f6303a
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder
                    java.lang.String r5 = "Tapjoy-Server-Debug: "
                    r4.<init>(r5)
                    r4.append(r1)
                    java.lang.String r1 = r4.toString()
                    com.tapjoy.TapjoyLog.m6554v(r3, r1)
                L_0x00e3:
                    long r3 = r0.expires
                    r5 = 0
                    int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                    if (r1 <= 0) goto L_0x010a
                    long r3 = r0.expires
                    long r7 = r0.date
                    int r1 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
                    if (r1 <= 0) goto L_0x00f6
                    long r7 = r0.date
                    goto L_0x00fa
                L_0x00f6:
                    long r7 = com.tapjoy.internal.C3256v.m7569b()
                L_0x00fa:
                    long r3 = r3 - r7
                    int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                    if (r1 <= 0) goto L_0x010f
                    com.tapjoy.TJCorePlacement r1 = com.tapjoy.TJCorePlacement.this
                    long r7 = android.os.SystemClock.elapsedRealtime()
                    long r7 = r7 + r3
                    r1.f6312e = r7
                    goto L_0x010f
                L_0x010a:
                    com.tapjoy.TJCorePlacement r1 = com.tapjoy.TJCorePlacement.this
                    r1.f6312e = r5
                L_0x010f:
                    if (r0 == 0) goto L_0x0363
                    com.tapjoy.TJPlacement r1 = r8
                    com.tapjoy.TJPlacementListener r1 = r1.getListener()
                    if (r1 == 0) goto L_0x0363
                    com.tapjoy.TJCorePlacement r1 = com.tapjoy.TJCorePlacement.this
                    boolean r1 = r1.f6331x
                    if (r1 != 0) goto L_0x0363
                    int r1 = r0.statusCode
                    if (r1 == 0) goto L_0x02f5
                    r3 = 200(0xc8, float:2.8E-43)
                    if (r1 == r3) goto L_0x014f
                    java.lang.String r1 = "TJPlacement.requestContent"
                    com.tapjoy.internal.gf$a r1 = com.tapjoy.internal.C1823gf.m3520b(r1)
                    java.lang.String r3 = "content_type"
                    java.lang.String r4 = "none"
                    com.tapjoy.internal.gf$a r1 = r1.mo18099a(r3, r4)
                    int r0 = r0.statusCode
                    java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
                    java.lang.String r3 = "code"
                    com.tapjoy.internal.gf$a r0 = r1.mo18099a(r3, r0)
                    r0.mo18104c()
                    com.tapjoy.TJCorePlacement r0 = com.tapjoy.TJCorePlacement.this
                    com.tapjoy.TJPlacement r1 = r8
                    r0.m6446b(r1)
                    goto L_0x0363
                L_0x014f:
                    com.tapjoy.TJCorePlacement r1 = com.tapjoy.TJCorePlacement.this
                    com.tapjoy.TJCorePlacement.m6468p(r1)
                    java.lang.String r1 = "Content-Type"
                    java.lang.String r1 = r0.getHeaderFieldAsString(r1)
                    boolean r3 = com.tapjoy.internal.C1852jq.m3669c(r1)
                    if (r3 != 0) goto L_0x0230
                    java.lang.String r3 = "json"
                    boolean r1 = r1.contains(r3)
                    if (r1 == 0) goto L_0x0230
                    java.lang.String r1 = "X-Tapjoy-Disable-Preload"
                    java.lang.String r1 = r0.getHeaderFieldAsString(r1)
                    java.lang.String r3 = "1"
                    boolean r1 = r1.equals(r3)
                    if (r1 == 0) goto L_0x01e6
                    com.tapjoy.TJCorePlacement r1 = com.tapjoy.TJCorePlacement.this     // Catch:{ TapjoyException -> 0x01a6 }
                    java.lang.String r3 = r0.response     // Catch:{ TapjoyException -> 0x01a6 }
                    com.tapjoy.TJCorePlacement.m6443a(r1, r3)     // Catch:{ TapjoyException -> 0x01a6 }
                    java.lang.String r1 = "TJPlacement.requestContent"
                    com.tapjoy.internal.gf$a r1 = com.tapjoy.internal.C1823gf.m3520b(r1)     // Catch:{ TapjoyException -> 0x01a6 }
                    java.lang.String r3 = "content_type"
                    java.lang.String r4 = "ad"
                    com.tapjoy.internal.gf$a r1 = r1.mo18099a(r3, r4)     // Catch:{ TapjoyException -> 0x01a6 }
                    r1.mo18104c()     // Catch:{ TapjoyException -> 0x01a6 }
                    com.tapjoy.TJCorePlacement r1 = com.tapjoy.TJCorePlacement.this     // Catch:{ TapjoyException -> 0x01a6 }
                    com.tapjoy.internal.fw r1 = r1.f6313f     // Catch:{ TapjoyException -> 0x01a6 }
                    com.tapjoy.TJCorePlacement r3 = com.tapjoy.TJCorePlacement.this     // Catch:{ TapjoyException -> 0x01a6 }
                    com.tapjoy.internal.fm r3 = r3.f6328u     // Catch:{ TapjoyException -> 0x01a6 }
                    r1.f7271a = r3     // Catch:{ TapjoyException -> 0x01a6 }
                    com.tapjoy.TJCorePlacement r1 = com.tapjoy.TJCorePlacement.this     // Catch:{ TapjoyException -> 0x01a6 }
                    com.tapjoy.TJCorePlacement.m6470r(r1)     // Catch:{ TapjoyException -> 0x01a6 }
                    com.tapjoy.TJCorePlacement r1 = com.tapjoy.TJCorePlacement.this     // Catch:{ TapjoyException -> 0x01a6 }
                    r1.m6455e()     // Catch:{ TapjoyException -> 0x01a6 }
                    goto L_0x0363
                L_0x01a6:
                    r1 = move-exception
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder
                    r3.<init>()
                    java.lang.String r1 = r1.getMessage()
                    r3.append(r1)
                    java.lang.String r1 = " for placement "
                    r3.append(r1)
                    com.tapjoy.TJCorePlacement r1 = com.tapjoy.TJCorePlacement.this
                    java.lang.String r1 = r1.f6310c.getPlacementName()
                    r3.append(r1)
                    java.lang.String r1 = r3.toString()
                    java.lang.String r3 = "TJPlacement.requestContent"
                    com.tapjoy.internal.gf$a r3 = com.tapjoy.internal.C1823gf.m3520b(r3)
                    java.lang.String r4 = "server error"
                    com.tapjoy.internal.gf$a r3 = r3.mo18097a(r4)
                    r3.mo18104c()
                    com.tapjoy.TJCorePlacement r3 = com.tapjoy.TJCorePlacement.this
                    com.tapjoy.TJPlacement r4 = r8
                    com.tapjoy.TapjoyErrorMessage$ErrorType r5 = com.tapjoy.TapjoyErrorMessage.ErrorType.SERVER_ERROR
                    com.tapjoy.TJError r6 = new com.tapjoy.TJError
                    int r0 = r0.statusCode
                    r6.<init>(r0, r1)
                    r3.mo29547a(r4, r5, r6)
                    goto L_0x0363
                L_0x01e6:
                    com.tapjoy.TJCorePlacement r1 = com.tapjoy.TJCorePlacement.this
                    java.lang.String r3 = r0.response
                    boolean r1 = r1.m6450b(r3)
                    if (r1 == 0) goto L_0x020d
                    java.lang.String r0 = "TJPlacement.requestContent"
                    com.tapjoy.internal.gf$a r0 = com.tapjoy.internal.C1823gf.m3520b(r0)
                    java.lang.String r1 = "content_type"
                    java.lang.String r3 = "mm"
                    com.tapjoy.internal.gf$a r0 = r0.mo18099a(r1, r3)
                    r0.mo18104c()
                    com.tapjoy.TJCorePlacement r0 = com.tapjoy.TJCorePlacement.this
                    com.tapjoy.TJCorePlacement.m6470r(r0)
                    com.tapjoy.TJCorePlacement r0 = com.tapjoy.TJCorePlacement.this
                    r0.m6455e()
                    goto L_0x0363
                L_0x020d:
                    java.lang.String r1 = "TJPlacement.requestContent"
                    com.tapjoy.internal.gf$a r1 = com.tapjoy.internal.C1823gf.m3520b(r1)
                    java.lang.String r3 = "asset error"
                    com.tapjoy.internal.gf$a r1 = r1.mo18097a(r3)
                    r1.mo18104c()
                    com.tapjoy.TJCorePlacement r1 = com.tapjoy.TJCorePlacement.this
                    com.tapjoy.TJPlacement r3 = r8
                    com.tapjoy.TapjoyErrorMessage$ErrorType r4 = com.tapjoy.TapjoyErrorMessage.ErrorType.SERVER_ERROR
                    com.tapjoy.TJError r5 = new com.tapjoy.TJError
                    int r6 = r0.statusCode
                    java.lang.String r0 = r0.response
                    r5.<init>(r6, r0)
                    r1.mo29547a(r3, r4, r5)
                    goto L_0x0363
                L_0x0230:
                    java.lang.String r1 = "TJPlacement.requestContent"
                    com.tapjoy.internal.gf$a r1 = com.tapjoy.internal.C1823gf.m3520b(r1)
                    java.lang.String r3 = "content_type"
                    java.lang.String r4 = "ad"
                    com.tapjoy.internal.gf$a r1 = r1.mo18099a(r3, r4)
                    r1.mo18104c()
                    com.tapjoy.TJCorePlacement r1 = com.tapjoy.TJCorePlacement.this
                    com.tapjoy.internal.fw r1 = r1.f6313f
                    com.tapjoy.TJCorePlacement r3 = com.tapjoy.TJCorePlacement.this
                    com.tapjoy.internal.fm r3 = r3.f6328u
                    r1.f7271a = r3
                    com.tapjoy.TJCorePlacement r1 = com.tapjoy.TJCorePlacement.this
                    com.tapjoy.TJCorePlacement.m6470r(r1)
                    com.tapjoy.TJCorePlacement r1 = com.tapjoy.TJCorePlacement.this
                    com.tapjoy.TJCorePlacement$4$1 r3 = new com.tapjoy.TJCorePlacement$4$1
                    r3.<init>()
                    java.lang.String r4 = com.tapjoy.TJCorePlacement.f6303a
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder
                    java.lang.String r6 = "Checking if there is content to cache for placement "
                    r5.<init>(r6)
                    com.tapjoy.TJPlacementData r6 = r1.f6310c
                    java.lang.String r6 = r6.getPlacementName()
                    r5.append(r6)
                    java.lang.String r5 = r5.toString()
                    com.tapjoy.TapjoyLog.m6553i(r4, r5)
                    java.lang.String r4 = "x-tapjoy-cacheable-assets"
                    java.lang.String r0 = r0.getHeaderFieldAsString(r4)
                    r4 = 2
                    boolean r5 = com.tapjoy.TJPlacementManager.canCachePlacement()     // Catch:{ Exception -> 0x02d9 }
                    if (r5 != 0) goto L_0x029d
                    java.lang.String r0 = com.tapjoy.TJCorePlacement.f6303a     // Catch:{ Exception -> 0x02d9 }
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02d9 }
                    java.lang.String r6 = "Placement caching limit reached. No content will be cached for placement "
                    r5.<init>(r6)     // Catch:{ Exception -> 0x02d9 }
                    com.tapjoy.TJPlacementData r1 = r1.f6310c     // Catch:{ Exception -> 0x02d9 }
                    java.lang.String r1 = r1.getPlacementName()     // Catch:{ Exception -> 0x02d9 }
                    r5.append(r1)     // Catch:{ Exception -> 0x02d9 }
                    java.lang.String r1 = r5.toString()     // Catch:{ Exception -> 0x02d9 }
                    com.tapjoy.TapjoyLog.m6553i(r0, r1)     // Catch:{ Exception -> 0x02d9 }
                    r3.onCachingComplete(r4)     // Catch:{ Exception -> 0x02d9 }
                    goto L_0x0363
                L_0x029d:
                    org.json.JSONArray r5 = new org.json.JSONArray     // Catch:{ Exception -> 0x02d9 }
                    r5.<init>(r0)     // Catch:{ Exception -> 0x02d9 }
                    int r0 = r5.length()     // Catch:{ Exception -> 0x02d9 }
                    if (r0 <= 0) goto L_0x02d4
                    java.lang.String r0 = com.tapjoy.TJCorePlacement.f6303a     // Catch:{ Exception -> 0x02d9 }
                    java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02d9 }
                    java.lang.String r7 = "Begin caching content for placement "
                    r6.<init>(r7)     // Catch:{ Exception -> 0x02d9 }
                    com.tapjoy.TJPlacementData r7 = r1.f6310c     // Catch:{ Exception -> 0x02d9 }
                    java.lang.String r7 = r7.getPlacementName()     // Catch:{ Exception -> 0x02d9 }
                    r6.append(r7)     // Catch:{ Exception -> 0x02d9 }
                    java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x02d9 }
                    com.tapjoy.TapjoyLog.m6553i(r0, r6)     // Catch:{ Exception -> 0x02d9 }
                    com.tapjoy.TJPlacementManager.incrementPlacementCacheCount()     // Catch:{ Exception -> 0x02d9 }
                    r1.f6315h = r2     // Catch:{ Exception -> 0x02d9 }
                    com.tapjoy.TapjoyCache r0 = com.tapjoy.TapjoyCache.getInstance()     // Catch:{ Exception -> 0x02d9 }
                    com.tapjoy.TJCorePlacement$7 r6 = new com.tapjoy.TJCorePlacement$7     // Catch:{ Exception -> 0x02d9 }
                    r6.<init>(r3)     // Catch:{ Exception -> 0x02d9 }
                    r0.cacheAssetGroup(r5, r6)     // Catch:{ Exception -> 0x02d9 }
                    goto L_0x0363
                L_0x02d4:
                    r3.onCachingComplete(r2)     // Catch:{ Exception -> 0x02d9 }
                    goto L_0x0363
                L_0x02d9:
                    r0 = move-exception
                    r3.onCachingComplete(r4)
                    java.lang.String r1 = com.tapjoy.TJCorePlacement.f6303a
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder
                    java.lang.String r4 = "Error while handling placement cache: "
                    r3.<init>(r4)
                    java.lang.String r0 = r0.getMessage()
                    r3.append(r0)
                    java.lang.String r0 = r3.toString()
                    com.tapjoy.TapjoyLog.m6550d(r1, r0)
                    goto L_0x0363
                L_0x02f5:
                    com.tapjoy.internal.fi r1 = r6
                    com.tapjoy.internal.gi r3 = r9
                    long r3 = r3.f7341e
                    boolean r1 = r1.mo30121a(r3)
                    if (r1 == 0) goto L_0x0331
                    java.lang.String r1 = "TJPlacement.requestContent"
                    com.tapjoy.internal.gf$a r1 = com.tapjoy.internal.C1823gf.m3520b(r1)
                    java.lang.String r3 = "network error"
                    com.tapjoy.internal.gf$a r1 = r1.mo18097a(r3)
                    com.tapjoy.internal.fi r3 = r6
                    long r3 = r3.f7231b
                    java.lang.Long r3 = java.lang.Long.valueOf(r3)
                    java.lang.String r4 = "retry_timeout"
                    com.tapjoy.internal.gf$a r1 = r1.mo18099a(r4, r3)
                    r1.mo18104c()
                    com.tapjoy.TJCorePlacement r1 = com.tapjoy.TJCorePlacement.this
                    com.tapjoy.TJPlacement r3 = r8
                    com.tapjoy.TapjoyErrorMessage$ErrorType r4 = com.tapjoy.TapjoyErrorMessage.ErrorType.NETWORK_ERROR
                    com.tapjoy.TJError r5 = new com.tapjoy.TJError
                    int r6 = r0.statusCode
                    java.lang.String r0 = r0.response
                    r5.<init>(r6, r0)
                    r1.mo29547a(r3, r4, r5)
                    goto L_0x0363
                L_0x0331:
                    com.tapjoy.internal.gi r0 = r9
                    long r1 = r0.f7341e
                    long r3 = r0.f7341e
                    double r3 = (double) r3
                    double r7 = r0.f7340d
                    java.lang.Double.isNaN(r3)
                    double r3 = r3 * r7
                    long r3 = (long) r3
                    long r7 = r0.f7338b
                    int r9 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
                    if (r9 >= 0) goto L_0x0349
                    long r3 = r0.f7338b
                    goto L_0x0351
                L_0x0349:
                    long r7 = r0.f7339c
                    int r9 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
                    if (r9 <= 0) goto L_0x0351
                    long r3 = r0.f7339c
                L_0x0351:
                    r0.f7341e = r3
                    int r3 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
                    if (r3 <= 0) goto L_0x0362
                    monitor-enter(r0)
                    r0.wait(r1)     // Catch:{ InterruptedException -> 0x035e }
                    goto L_0x035e
                L_0x035c:
                    r1 = move-exception
                    goto L_0x0360
                L_0x035e:
                    monitor-exit(r0)     // Catch:{ all -> 0x035c }
                    goto L_0x0362
                L_0x0360:
                    monitor-exit(r0)     // Catch:{ all -> 0x035c }
                    throw r1
                L_0x0362:
                    return r10
                L_0x0363:
                    com.tapjoy.TJCorePlacement r0 = com.tapjoy.TJCorePlacement.this
                    r0.f6332y = false
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.TJCorePlacement.C28144.m6480a():boolean");
            }
        };
        r3.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m6450b(String str) {
        try {
            C3182a aVar = (C3182a) this.f6330w.mo18080a(URI.create(this.f6310c.getUrl()), new ByteArrayInputStream(str.getBytes()));
            this.f6316i = aVar.f7579a;
            aVar.f7579a.mo18174b();
            if (!aVar.f7579a.mo18175c()) {
                TapjoyLog.m6552e(f6303a, "Failed to load fiverocks placement");
                return false;
            }
            C3078fq fqVar = null;
            if (this.f6316i instanceof C3136he) {
                fqVar = new C3083fu(this.f6310c.getPlacementName(), this.f6310c.getPlacementType(), this.f6328u);
            } else if (this.f6316i instanceof C3120gv) {
                fqVar = new C3084fv(this.f6310c.getPlacementName(), this.f6310c.getPlacementType(), this.f6328u);
            }
            this.f6313f.f7271a = fqVar;
            return true;
        } catch (IOException e) {
            TapjoyLog.m6552e(f6303a, e.toString());
            e.printStackTrace();
            return false;
        } catch (C2917cb e2) {
            TapjoyLog.m6552e(f6303a, e2.toString());
            e2.printStackTrace();
            return false;
        }
    }

    public Context getContext() {
        return this.f6309b;
    }

    public void setContext(Context context) {
        this.f6309b = context;
    }

    public TJAdUnit getAdUnit() {
        return this.f6314g;
    }

    public TJPlacementData getPlacementData() {
        return this.f6310c;
    }

    public boolean isContentReady() {
        return this.f6319l;
    }

    public boolean isContentAvailable() {
        return this.f6318k;
    }

    public String getPlacementContentUrl() {
        String b = mo29550b();
        if (!C1852jq.m3669c(b)) {
            StringBuilder sb = new StringBuilder();
            sb.append(TapjoyConnectCore.getPlacementURL());
            sb.append("v1/apps/");
            sb.append(b);
            sb.append("/content?");
            return sb.toString();
        }
        TapjoyLog.m6553i(f6303a, "Placement content URL cannot be generated for null app ID");
        return "";
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final String mo29545a() {
        if (this.f6316i != null) {
            return "mm";
        }
        return this.f6318k ? "ad" : "none";
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo29549a(String str, TJPlacement tJPlacement) {
        synchronized (this.f6325r) {
            this.f6325r.put(str, tJPlacement);
            if (tJPlacement != null) {
                String str2 = f6303a;
                StringBuilder sb = new StringBuilder("Setting ");
                sb.append(str);
                sb.append(" placement: ");
                sb.append(tJPlacement.getGUID());
                TapjoyLog.m6550d(str2, sb.toString());
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final TJPlacement mo29544a(String str) {
        TJPlacement tJPlacement;
        synchronized (this.f6325r) {
            tJPlacement = (TJPlacement) this.f6325r.get(str);
            if (tJPlacement != null) {
                String str2 = f6303a;
                StringBuilder sb = new StringBuilder("Returning ");
                sb.append(str);
                sb.append(" placement: ");
                sb.append(tJPlacement.getGUID());
                TapjoyLog.m6550d(str2, sb.toString());
            }
        }
        return tJPlacement;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m6446b(TJPlacement tJPlacement) {
        m6457f();
        C3085fw fwVar = this.f6313f;
        String placementName = this.f6310c.getPlacementName();
        String placementType = this.f6310c.getPlacementType();
        String a = mo29545a();
        fwVar.f7273c = 0;
        String str = "placement";
        String str2 = "placement_type";
        C1825a a2 = C1823gf.m3524e("PlacementContent.funnel").mo18096a().mo18099a(str, (Object) placementName).mo18099a(str2, (Object) placementType);
        String str3 = Param.CONTENT_TYPE;
        fwVar.f7272b = a2.mo18099a(str3, (Object) a).mo18099a(ServerProtocol.DIALOG_PARAM_STATE, (Object) Integer.valueOf(fwVar.f7273c));
        fwVar.f7272b.mo18104c();
        if (!"none".equals(a)) {
            fwVar.f7275e = C1823gf.m3524e("PlacementContent.ready").mo18096a().mo18099a(str, (Object) placementName).mo18099a(str2, (Object) placementType).mo18099a(str3, (Object) a);
        }
        if (tJPlacement != null && tJPlacement.getListener() != null) {
            String str4 = f6303a;
            StringBuilder sb = new StringBuilder("Content request delivered successfully for placement ");
            sb.append(this.f6310c.getPlacementName());
            sb.append(", contentAvailable: ");
            sb.append(isContentAvailable());
            sb.append(", mediationAgent: ");
            sb.append(this.f6322o);
            TapjoyLog.m6553i(str4, sb.toString());
            tJPlacement.getListener().onRequestSuccess(tJPlacement);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo29548a(ErrorType errorType, TJError tJError) {
        mo29547a(mo29544a("REQUEST"), errorType, tJError);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo29547a(TJPlacement tJPlacement, ErrorType errorType, TJError tJError) {
        m6457f();
        String str = f6303a;
        StringBuilder sb = new StringBuilder("Content request failed for placement ");
        sb.append(this.f6310c.getPlacementName());
        sb.append("; Reason= ");
        sb.append(tJError.message);
        TapjoyLog.m6551e(str, new TapjoyErrorMessage(errorType, sb.toString()));
        if (tJPlacement != null && tJPlacement.getListener() != null) {
            tJPlacement.getListener().onRequestFailure(tJPlacement, tJError);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m6455e() {
        if (!this.f6333z) {
            this.f6319l = true;
            String str = f6303a;
            StringBuilder sb = new StringBuilder("Content is ready for placement ");
            sb.append(this.f6310c.getPlacementName());
            TapjoyLog.m6553i(str, sb.toString());
            if (this.f6314g.isPrerendered()) {
                C3085fw fwVar = this.f6313f;
                String str2 = "prerendered";
                Boolean valueOf = Boolean.valueOf(true);
                C1825a aVar = fwVar.f7272b;
                if (aVar != null) {
                    aVar.mo18099a(str2, (Object) valueOf);
                }
                C1825a aVar2 = fwVar.f7275e;
                if (aVar2 != null) {
                    aVar2.mo18099a(str2, (Object) valueOf);
                }
            }
            C3085fw fwVar2 = this.f6313f;
            C1825a aVar3 = fwVar2.f7275e;
            if (aVar3 != null) {
                fwVar2.f7275e = null;
                aVar3.mo18101b().mo18104c();
            }
            TJPlacement a = mo29544a("REQUEST");
            if (a != null && a.getListener() != null) {
                a.getListener().onContentReady(a);
                this.f6333z = true;
            }
        }
    }

    public boolean isLimited() {
        return this.f6304A;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final String mo29550b() {
        if (!this.f6304A) {
            return TapjoyConnectCore.getAppID();
        }
        return TapjoyConnectCore.getLimitedAppID();
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m6457f() {
        try {
            this.f6305B.removeCallbacks(this.f6306C);
        } catch (NullPointerException unused) {
        }
    }

    /* renamed from: e */
    static /* synthetic */ void m6456e(TJCorePlacement tJCorePlacement) {
        TJPlacement a = tJCorePlacement.mo29544a("SHOW");
        String str = f6303a;
        StringBuilder sb = new StringBuilder("Handle onClick for placement ");
        sb.append(tJCorePlacement.f6310c.getPlacementName());
        TapjoyLog.m6553i(str, sb.toString());
        if (a != null && a.getListener() != null) {
            a.getListener().onClick(a);
        }
    }

    /* renamed from: g */
    static /* synthetic */ void m6459g(TJCorePlacement tJCorePlacement) {
        String str = "network error";
        tJCorePlacement.mo29548a(ErrorType.NETWORK_ERROR, new TJError(0, str));
        C1823gf.m3520b("TJPlacement.requestContent").mo18097a(str).mo18104c();
        tJCorePlacement.f6327t.disconnect();
    }

    /* renamed from: p */
    static /* synthetic */ void m6468p(TJCorePlacement tJCorePlacement) {
        tJCorePlacement.f6328u = new C3071fm(tJCorePlacement.f6310c.getPlacementName(), tJCorePlacement.f6310c.getPlacementType());
        tJCorePlacement.f6314g.setAdContentTracker(tJCorePlacement.f6328u);
    }

    /* renamed from: a */
    static /* synthetic */ void m6443a(TJCorePlacement tJCorePlacement, String str) {
        if (str != null) {
            try {
                String str2 = f6303a;
                StringBuilder sb = new StringBuilder("Disable preload flag is set for placement ");
                sb.append(tJCorePlacement.f6310c.getPlacementName());
                TapjoyLog.m6550d(str2, sb.toString());
                tJCorePlacement.f6310c.setRedirectURL(new JSONObject(str).getString(TapjoyConstants.TJC_REDIRECT_URL));
                tJCorePlacement.f6310c.setPreloadDisabled(true);
                tJCorePlacement.f6310c.setHasProgressSpinner(true);
                String str3 = f6303a;
                StringBuilder sb2 = new StringBuilder("redirect_url:");
                sb2.append(tJCorePlacement.f6310c.getRedirectURL());
                TapjoyLog.m6550d(str3, sb2.toString());
            } catch (JSONException unused) {
                throw new TapjoyException("TJPlacement request failed, malformed server response");
            }
        } else {
            throw new TapjoyException("TJPlacement request failed due to null response");
        }
    }

    /* renamed from: r */
    static /* synthetic */ void m6470r(TJCorePlacement tJCorePlacement) {
        tJCorePlacement.f6318k = true;
        tJCorePlacement.m6446b(tJCorePlacement.mo29544a("REQUEST"));
    }
}
