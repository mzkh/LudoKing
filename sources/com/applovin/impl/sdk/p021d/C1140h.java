package com.applovin.impl.sdk.p021d;

import android.net.Uri;
import android.webkit.URLUtil;
import com.applovin.impl.p005a.C0769a;
import com.applovin.impl.p005a.C0769a.C0772b;
import com.applovin.impl.p005a.C0774b;
import com.applovin.impl.p005a.C0777e;
import com.applovin.impl.p005a.C0777e.C0778a;
import com.applovin.impl.p005a.C0786k;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.p018ad.C1084f;
import com.applovin.impl.sdk.p020c.C1108d;
import com.applovin.impl.sdk.p020c.C1115i;
import com.applovin.impl.sdk.utils.C1277l;
import com.applovin.sdk.AppLovinAdLoadListener;
import java.util.Collections;

/* renamed from: com.applovin.impl.sdk.d.h */
class C1140h extends C1133c {

    /* renamed from: c */
    private final C0769a f2776c;

    public C1140h(C0769a aVar, C1192i iVar, AppLovinAdLoadListener appLovinAdLoadListener) {
        super("TaskCacheVastAd", aVar, iVar, appLovinAdLoadListener);
        this.f2776c = aVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m2386j() {
        String str = "...";
        if (this.f2776c.mo8878a()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Begin caching for VAST streaming ad #");
            sb.append(this.f2759a.getAdIdNumber());
            sb.append(str);
            mo10068a(sb.toString());
            mo10094d();
            if (this.f2776c.mo8887e()) {
                mo10097i();
            }
            if (this.f2776c.mo8885c() == C0772b.COMPANION_AD) {
                m2387k();
                m2389m();
            } else {
                m2388l();
            }
            if (!this.f2776c.mo8887e()) {
                mo10097i();
            }
            if (this.f2776c.mo8885c() == C0772b.COMPANION_AD) {
                m2388l();
            } else {
                m2387k();
                m2389m();
            }
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Begin caching for VAST ad #");
            sb2.append(this.f2759a.getAdIdNumber());
            sb2.append(str);
            mo10068a(sb2.toString());
            mo10094d();
            m2387k();
            m2388l();
            m2389m();
            mo10097i();
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Finished caching VAST ad #");
        sb3.append(this.f2776c.getAdIdNumber());
        mo10068a(sb3.toString());
        long currentTimeMillis = System.currentTimeMillis() - this.f2776c.getCreatedAtMillis();
        C1108d.m2212a(this.f2776c, this.f2745b);
        C1108d.m2211a(currentTimeMillis, (AppLovinAdBase) this.f2776c, this.f2745b);
        mo10090a((AppLovinAdBase) this.f2776c);
        mo10092b();
    }

    /* renamed from: k */
    private void m2387k() {
        String str;
        String str2;
        String sb;
        if (!mo10093c()) {
            if (this.f2776c.mo8881aF()) {
                C0774b j = this.f2776c.mo8896j();
                if (j != null) {
                    C0777e b = j.mo8914b();
                    if (b != null) {
                        Uri b2 = b.mo8933b();
                        String uri = b2 != null ? b2.toString() : "";
                        String c = b.mo8934c();
                        if (URLUtil.isValidUrl(uri) || C1277l.m3042b(c)) {
                            String str3 = "...";
                            if (b.mo8930a() == C0778a.STATIC) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("Caching static companion ad at ");
                                sb2.append(uri);
                                sb2.append(str3);
                                mo10068a(sb2.toString());
                                Uri b3 = mo10091b(uri, Collections.emptyList(), false);
                                if (b3 != null) {
                                    b.mo8931a(b3);
                                } else {
                                    str2 = "Failed to cache static companion ad";
                                }
                            } else if (b.mo8930a() == C0778a.HTML) {
                                if (C1277l.m3042b(uri)) {
                                    StringBuilder sb3 = new StringBuilder();
                                    sb3.append("Begin caching HTML companion ad. Fetching from ");
                                    sb3.append(uri);
                                    sb3.append(str3);
                                    mo10068a(sb3.toString());
                                    c = mo10096f(uri);
                                    if (C1277l.m3042b(c)) {
                                        sb = "HTML fetched. Caching HTML now...";
                                    } else {
                                        StringBuilder sb4 = new StringBuilder();
                                        sb4.append("Unable to load companion ad resources from ");
                                        sb4.append(uri);
                                        str2 = sb4.toString();
                                    }
                                } else {
                                    StringBuilder sb5 = new StringBuilder();
                                    sb5.append("Caching provided HTML for companion ad. No fetch required. HTML: ");
                                    sb5.append(c);
                                    sb = sb5.toString();
                                }
                                mo10068a(sb);
                                b.mo8932a(mo10089a(c, Collections.emptyList(), (C1084f) this.f2776c));
                            } else {
                                if (b.mo8930a() == C0778a.IFRAME) {
                                    str = "Skip caching of iFrame resource...";
                                }
                            }
                            this.f2776c.mo9892a(true);
                        }
                        mo10071c("Companion ad does not have any resources attached. Skipping...");
                    }
                    str2 = "Failed to retrieve non-video resources from companion ad. Skipping...";
                    mo10072d(str2);
                }
                str = "No companion ad provided. Skipping...";
            } else {
                str = "Companion ad caching disabled. Skipping...";
            }
            mo10068a(str);
        }
    }

    /* renamed from: l */
    private void m2388l() {
        if (!mo10093c()) {
            if (!this.f2776c.mo8882aG()) {
                mo10068a("Video caching disabled. Skipping...");
            } else if (this.f2776c.mo8892h() != null) {
                C0786k i = this.f2776c.mo8895i();
                if (i != null) {
                    Uri b = i.mo8960b();
                    if (b != null) {
                        Uri a = mo10087a(b.toString(), Collections.emptyList(), false);
                        if (a != null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Video file successfully cached into: ");
                            sb.append(a);
                            mo10068a(sb.toString());
                            i.mo8959a(a);
                        } else {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Failed to cache video file: ");
                            sb2.append(i);
                            mo10072d(sb2.toString());
                        }
                    }
                }
            }
        }
    }

    /* renamed from: m */
    private void m2389m() {
        String str;
        String str2;
        if (!mo10093c()) {
            if (this.f2776c.mo8880aE() != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Begin caching HTML template. Fetching from ");
                sb.append(this.f2776c.mo8880aE());
                sb.append("...");
                mo10068a(sb.toString());
                str = mo10088a(this.f2776c.mo8880aE().toString(), this.f2776c.mo9868F());
            } else {
                str = this.f2776c.mo8879aD();
            }
            if (C1277l.m3042b(str)) {
                C0769a aVar = this.f2776c;
                aVar.mo8877a(mo10089a(str, aVar.mo9868F(), (C1084f) this.f2776c));
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Finish caching HTML template ");
                sb2.append(this.f2776c.mo8879aD());
                sb2.append(" for ad #");
                sb2.append(this.f2776c.getAdIdNumber());
                str2 = sb2.toString();
            } else {
                str2 = "Unable to load HTML template";
            }
            mo10068a(str2);
        }
    }

    /* renamed from: a */
    public C1115i mo9338a() {
        return C1115i.f2703l;
    }

    public void run() {
        super.run();
        C11411 r0 = new Runnable() {
            public void run() {
                C1140h.this.m2386j();
            }
        };
        if (this.f2759a.mo9871I()) {
            this.f2745b.mo10185K().mo10136c().execute(r0);
        } else {
            r0.run();
        }
    }
}
