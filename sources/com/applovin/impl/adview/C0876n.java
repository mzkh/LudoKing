package com.applovin.impl.adview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import com.applovin.adview.AppLovinInterstitialActivity;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.C1227o;
import com.applovin.impl.sdk.p018ad.C1084f;
import com.applovin.impl.sdk.p018ad.C1084f.C1086b;
import com.applovin.impl.sdk.p018ad.C1089i;
import com.applovin.impl.sdk.p019b.C1096c;
import com.applovin.impl.sdk.utils.C1281o;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.google.android.gms.drive.DriveFile;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* renamed from: com.applovin.impl.adview.n */
public class C0876n implements AppLovinInterstitialAdDialog {

    /* renamed from: b */
    public static volatile boolean f1573b = false;

    /* renamed from: c */
    public static volatile boolean f1574c = false;

    /* renamed from: d */
    private static final Map<String, C0876n> f1575d = Collections.synchronizedMap(new HashMap());

    /* renamed from: n */
    private static volatile boolean f1576n;

    /* renamed from: a */
    protected final C1192i f1577a;

    /* renamed from: e */
    private final String f1578e;

    /* renamed from: f */
    private final WeakReference<Context> f1579f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public volatile AppLovinAdLoadListener f1580g;

    /* renamed from: h */
    private volatile AppLovinAdDisplayListener f1581h;

    /* renamed from: i */
    private volatile AppLovinAdVideoPlaybackListener f1582i;

    /* renamed from: j */
    private volatile AppLovinAdClickListener f1583j;

    /* renamed from: k */
    private volatile C1084f f1584k;

    /* renamed from: l */
    private volatile C1086b f1585l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public volatile C0832j f1586m;

    C0876n(AppLovinSdk appLovinSdk, Context context) {
        if (appLovinSdk == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else if (context != null) {
            this.f1577a = C1281o.m3071a(appLovinSdk);
            this.f1578e = UUID.randomUUID().toString();
            this.f1579f = new WeakReference<>(context);
            f1573b = true;
            f1574c = false;
        } else {
            throw new IllegalArgumentException("No context specified");
        }
    }

    /* renamed from: a */
    public static C0876n m1318a(String str) {
        return (C0876n) f1575d.get(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1320a(final int i) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                if (C0876n.this.f1580g != null) {
                    C0876n.this.f1580g.failedToReceiveAd(i);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1321a(Context context) {
        Intent intent = new Intent(context, AppLovinInterstitialActivity.class);
        intent.putExtra(C0842m.KEY_WRAPPER_ID, this.f1578e);
        C0842m.lastKnownWrapper = this;
        ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        if (context instanceof Activity) {
            try {
                context.startActivity(intent);
                ((Activity) context).overridePendingTransition(0, 0);
            } catch (Throwable th) {
                this.f1577a.mo10249v().mo10379b("InterstitialAdDialogWrapper", "Unable to remove pending transition animations", th);
            }
        } else {
            intent.setFlags(DriveFile.MODE_READ_ONLY);
            context.startActivity(intent);
        }
        StrictMode.setThreadPolicy(allowThreadDiskReads);
        mo9169a(true);
    }

    /* renamed from: a */
    private void m1325a(C1084f fVar, final Context context) {
        f1575d.put(this.f1578e, this);
        this.f1584k = fVar;
        this.f1585l = this.f1584k != null ? this.f1584k.mo9924l() : C1086b.DEFAULT;
        long max = Math.max(0, ((Long) this.f1577a.mo10202a(C1096c.f2411cU)).longValue());
        C1227o v = this.f1577a.mo10249v();
        StringBuilder sb = new StringBuilder();
        sb.append("Presenting ad with delay of ");
        sb.append(max);
        v.mo10378b("InterstitialAdDialogWrapper", sb.toString());
        new Handler(context.getMainLooper()).postDelayed(new Runnable() {
            public void run() {
                C0876n.this.m1321a(context);
            }
        }, max);
    }

    /* renamed from: a */
    private void m1326a(AppLovinAd appLovinAd) {
        if (this.f1581h != null) {
            this.f1581h.adHidden(appLovinAd);
        }
        f1576n = false;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m1328b(final AppLovinAd appLovinAd) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                if (C0876n.this.f1580g != null) {
                    C0876n.this.f1580g.adReceived(appLovinAd);
                }
            }
        });
    }

    /* renamed from: h */
    private Context m1329h() {
        WeakReference<Context> weakReference = this.f1579f;
        if (weakReference != null) {
            return (Context) weakReference.get();
        }
        return null;
    }

    /* renamed from: a */
    public C1192i mo9166a() {
        return this.f1577a;
    }

    /* renamed from: a */
    public void mo9167a(C0832j jVar) {
        this.f1586m = jVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9168a(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f1577a.mo10241o().loadNextAd(AppLovinAdSize.INTERSTITIAL, appLovinAdLoadListener);
    }

    /* renamed from: a */
    public void mo9169a(boolean z) {
        f1576n = z;
    }

    /* renamed from: b */
    public AppLovinAd mo9170b() {
        return this.f1584k;
    }

    /* renamed from: c */
    public AppLovinAdVideoPlaybackListener mo9171c() {
        return this.f1582i;
    }

    /* renamed from: d */
    public AppLovinAdDisplayListener mo9172d() {
        return this.f1581h;
    }

    public void dismiss() {
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                if (C0876n.this.f1586m != null) {
                    C0876n.this.f1586m.dismiss();
                }
            }
        });
    }

    /* renamed from: e */
    public AppLovinAdClickListener mo9173e() {
        return this.f1583j;
    }

    /* renamed from: f */
    public C1086b mo9174f() {
        return this.f1585l;
    }

    /* renamed from: g */
    public void mo9175g() {
        f1573b = false;
        f1574c = true;
        f1575d.remove(this.f1578e);
        if (this.f1584k != null && this.f1584k.mo9881S()) {
            this.f1586m = null;
        }
    }

    public boolean isAdReadyToDisplay() {
        return this.f1577a.mo10241o().hasPreloadedAd(AppLovinAdSize.INTERSTITIAL);
    }

    public boolean isShowing() {
        return f1576n;
    }

    public void setAdClickListener(AppLovinAdClickListener appLovinAdClickListener) {
        this.f1583j = appLovinAdClickListener;
    }

    public void setAdDisplayListener(AppLovinAdDisplayListener appLovinAdDisplayListener) {
        this.f1581h = appLovinAdDisplayListener;
    }

    public void setAdLoadListener(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f1580g = appLovinAdLoadListener;
    }

    public void setAdVideoPlaybackListener(AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        this.f1582i = appLovinAdVideoPlaybackListener;
    }

    public void show() {
        show(null);
    }

    public void show(final String str) {
        mo9168a((AppLovinAdLoadListener) new AppLovinAdLoadListener() {
            public void adReceived(AppLovinAd appLovinAd) {
                C0876n.this.m1328b(appLovinAd);
                C0876n.this.showAndRender(appLovinAd, str);
            }

            public void failedToReceiveAd(int i) {
                C0876n.this.m1320a(i);
            }
        });
    }

    public void showAndRender(AppLovinAd appLovinAd) {
        showAndRender(appLovinAd, null);
    }

    public void showAndRender(AppLovinAd appLovinAd, String str) {
        C1227o oVar;
        String str2;
        if (!isShowing() || ((Boolean) this.f1577a.mo10202a(C1096c.f2515eU)).booleanValue()) {
            Context h = m1329h();
            String str3 = "InterstitialAdDialogWrapper";
            if (h != null) {
                AppLovinAd a = C1281o.m3072a(appLovinAd, this.f1577a);
                if (a != null) {
                    if (a instanceof C1084f) {
                        m1325a((C1084f) a, h);
                    } else {
                        C1227o v = this.f1577a.mo10249v();
                        StringBuilder sb = new StringBuilder();
                        sb.append("Failed to show interstitial: unknown ad type provided: '");
                        sb.append(a);
                        sb.append("'");
                        v.mo10382e(str3, sb.toString());
                        m1326a(a);
                    }
                    return;
                }
                oVar = this.f1577a.mo10249v();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Failed to show ad: ");
                sb2.append(appLovinAd);
                str2 = sb2.toString();
            } else {
                oVar = this.f1577a.mo10249v();
                str2 = "Failed to show interstitial: stale activity reference provided";
            }
            oVar.mo10382e(str3, str2);
            m1326a(appLovinAd);
            return;
        }
        String str4 = "Attempted to show an interstitial while one is already displayed; ignoring.";
        C1227o.m2841i("AppLovinInterstitialAdDialog", str4);
        if (this.f1581h instanceof C1089i) {
            ((C1089i) this.f1581h).onAdDisplayFailed(str4);
        }
    }

    public String toString() {
        return "AppLovinInterstitialAdDialog{}";
    }
}
