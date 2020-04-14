package com.applovin.impl.sdk.p021d;

import android.text.TextUtils;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.C1227o;
import com.applovin.impl.sdk.network.C1211a;
import com.applovin.impl.sdk.network.C1211a.C1212a;
import com.applovin.impl.sdk.network.C1211a.C1214c;
import com.applovin.impl.sdk.network.C1215b;
import com.applovin.impl.sdk.p019b.C1096c;
import com.applovin.impl.sdk.p019b.C1097d;
import com.applovin.impl.sdk.p020c.C1115i;
import com.applovin.impl.sdk.p021d.C1159r.C1161a;
import com.applovin.impl.sdk.utils.C1277l;
import com.applovin.sdk.AppLovinErrorCodes;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.sdk.d.x */
public abstract class C1173x<T> extends C1122a implements C1214c<T> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C1215b<T> f2870a;

    /* renamed from: c */
    private final C1214c<T> f2871c;

    /* renamed from: d */
    protected C1212a f2872d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C1161a f2873e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C1096c<String> f2874f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public C1096c<String> f2875g;

    public C1173x(C1215b<T> bVar, C1192i iVar) {
        this(bVar, iVar, false);
    }

    public C1173x(C1215b<T> bVar, final C1192i iVar, boolean z) {
        super("TaskRepeatRequest", iVar, z);
        this.f2873e = C1161a.BACKGROUND;
        this.f2874f = null;
        this.f2875g = null;
        if (bVar != null) {
            this.f2870a = bVar;
            this.f2872d = new C1212a();
            this.f2871c = new C1214c<T>() {
                /* renamed from: a */
                public void mo9301a(int i) {
                    C1096c cVar;
                    C1173x xVar;
                    boolean z = false;
                    boolean z2 = i < 200 || i >= 500;
                    boolean z3 = i == 429;
                    if (i != -103) {
                        z = true;
                    }
                    if (z && (z2 || z3)) {
                        String f = C1173x.this.f2870a.mo10311f();
                        if (C1173x.this.f2870a.mo10316j() > 0) {
                            C1173x xVar2 = C1173x.this;
                            StringBuilder sb = new StringBuilder();
                            sb.append("Unable to send request due to server failure (code ");
                            sb.append(i);
                            sb.append("). ");
                            sb.append(C1173x.this.f2870a.mo10316j());
                            sb.append(" attempts left, retrying in ");
                            sb.append(TimeUnit.MILLISECONDS.toSeconds((long) C1173x.this.f2870a.mo10318l()));
                            sb.append(" seconds...");
                            xVar2.mo10071c(sb.toString());
                            int j = C1173x.this.f2870a.mo10316j() - 1;
                            C1173x.this.f2870a.mo10303a(j);
                            if (j == 0) {
                                C1173x xVar3 = C1173x.this;
                                xVar3.m2498c(xVar3.f2874f);
                                if (C1277l.m3042b(f) && f.length() >= 4) {
                                    C1173x.this.f2870a.mo10304a(f);
                                    C1173x xVar4 = C1173x.this;
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append("Switching to backup endpoint ");
                                    sb2.append(f);
                                    xVar4.mo10070b(sb2.toString());
                                }
                            }
                            C1159r K = iVar.mo10185K();
                            C1173x xVar5 = C1173x.this;
                            K.mo10132a(xVar5, xVar5.f2873e, (long) C1173x.this.f2870a.mo10318l());
                            return;
                        }
                        if (f == null || !f.equals(C1173x.this.f2870a.mo10302a())) {
                            xVar = C1173x.this;
                            cVar = xVar.f2874f;
                        } else {
                            xVar = C1173x.this;
                            cVar = xVar.f2875g;
                        }
                        xVar.m2498c(cVar);
                    }
                    C1173x.this.mo9301a(i);
                }

                /* renamed from: a */
                public void mo9302a(T t, int i) {
                    C1173x.this.f2870a.mo10303a(0);
                    C1173x.this.mo9302a(t, i);
                }
            };
            return;
        }
        throw new IllegalArgumentException("No request specified");
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public <ST> void m2498c(C1096c<ST> cVar) {
        if (cVar != null) {
            C1097d C = mo10073e().mo10178C();
            C.mo9953a(cVar, cVar.mo9948b());
            C.mo9952a();
        }
    }

    /* renamed from: a */
    public C1115i mo9338a() {
        return C1115i.f2696e;
    }

    /* renamed from: a */
    public abstract void mo9301a(int i);

    /* renamed from: a */
    public void mo10153a(C1096c<String> cVar) {
        this.f2874f = cVar;
    }

    /* renamed from: a */
    public void mo10154a(C1161a aVar) {
        this.f2873e = aVar;
    }

    /* renamed from: a */
    public abstract void mo9302a(T t, int i);

    /* renamed from: b */
    public void mo10155b(C1096c<String> cVar) {
        this.f2875g = cVar;
    }

    public void run() {
        int i;
        C1211a J = mo10073e().mo10184J();
        if (!mo10073e().mo10229c() && !mo10073e().mo10230d()) {
            String str = "AppLovin SDK is disabled: please check your connection";
            mo10072d(str);
            C1227o.m2841i("AppLovinSdk", str);
            i = -22;
        } else if (!C1277l.m3042b(this.f2870a.mo10302a()) || this.f2870a.mo10302a().length() < 4) {
            mo10072d("Task has an invalid or null request endpoint.");
            i = AppLovinErrorCodes.INVALID_URL;
        } else {
            if (TextUtils.isEmpty(this.f2870a.mo10305b())) {
                this.f2870a.mo10306b(this.f2870a.mo10309e() != null ? "POST" : "GET");
            }
            J.mo10294a(this.f2870a, this.f2872d, this.f2871c);
            return;
        }
        mo9301a(i);
    }
}
