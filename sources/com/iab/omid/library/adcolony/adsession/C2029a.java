package com.iab.omid.library.adcolony.adsession;

import android.view.View;
import com.iab.omid.library.adcolony.p026b.C2031a;
import com.iab.omid.library.adcolony.p026b.C2038e;
import com.iab.omid.library.adcolony.p028d.C2049e;
import com.iab.omid.library.adcolony.p029e.C2051a;
import com.iab.omid.library.adcolony.publisher.AdSessionStatePublisher;
import com.iab.omid.library.adcolony.publisher.C2054a;
import com.iab.omid.library.adcolony.publisher.C2055b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

/* renamed from: com.iab.omid.library.adcolony.adsession.a */
public class C2029a extends AdSession {

    /* renamed from: a */
    private final AdSessionContext f3994a;

    /* renamed from: b */
    private final AdSessionConfiguration f3995b;

    /* renamed from: c */
    private final List<C2051a> f3996c = new ArrayList();

    /* renamed from: d */
    private C2051a f3997d;

    /* renamed from: e */
    private AdSessionStatePublisher f3998e;

    /* renamed from: f */
    private boolean f3999f = false;

    /* renamed from: g */
    private boolean f4000g = false;

    /* renamed from: h */
    private String f4001h;

    /* renamed from: i */
    private boolean f4002i;

    C2029a(AdSessionConfiguration adSessionConfiguration, AdSessionContext adSessionContext) {
        this.f3995b = adSessionConfiguration;
        this.f3994a = adSessionContext;
        this.f4001h = UUID.randomUUID().toString();
        m3740c(null);
        this.f3998e = adSessionContext.getAdSessionContextType() == AdSessionContextType.HTML ? new C2054a(adSessionContext.getWebView()) : new C2055b(adSessionContext.getVerificationScriptResources(), adSessionContext.getOmidJsScriptContent());
        this.f3998e.mo27430a();
        C2031a.m3760a().mo27391a(this);
        this.f3998e.mo27434a(adSessionConfiguration);
    }

    /* renamed from: a */
    private C2051a m3738a(View view) {
        for (C2051a aVar : this.f3996c) {
            if (aVar.get() == view) {
                return aVar;
            }
        }
        return null;
    }

    /* renamed from: b */
    private void m3739b(View view) {
        if (view == null) {
            throw new IllegalArgumentException("FriendlyObstruction is null");
        }
    }

    /* renamed from: c */
    private void m3740c(View view) {
        this.f3997d = new C2051a(view);
    }

    /* renamed from: d */
    private void m3741d(View view) {
        Collection<C2029a> b = C2031a.m3760a().mo27392b();
        if (b != null && b.size() > 0) {
            for (C2029a aVar : b) {
                if (aVar != this && aVar.mo27367c() == view) {
                    aVar.f3997d.clear();
                }
            }
        }
    }

    /* renamed from: i */
    private void m3742i() {
        if (this.f4002i) {
            throw new IllegalStateException("Impression event can only be sent once");
        }
    }

    /* renamed from: a */
    public List<C2051a> mo27365a() {
        return this.f3996c;
    }

    public void addFriendlyObstruction(View view) {
        if (!this.f4000g) {
            m3739b(view);
            if (m3738a(view) == null) {
                this.f3996c.add(new C2051a(view));
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo27366b() {
        m3742i();
        getAdSessionStatePublisher().mo27448g();
        this.f4002i = true;
    }

    /* renamed from: c */
    public View mo27367c() {
        return (View) this.f3997d.get();
    }

    /* renamed from: d */
    public boolean mo27368d() {
        return this.f3999f && !this.f4000g;
    }

    /* renamed from: e */
    public boolean mo27369e() {
        return this.f3999f;
    }

    public void error(ErrorType errorType, String str) {
        if (!this.f4000g) {
            C2049e.m3841a((Object) errorType, "Error type is null");
            C2049e.m3843a(str, "Message is null");
            getAdSessionStatePublisher().mo27435a(errorType, str);
            return;
        }
        throw new IllegalStateException("AdSession is finished");
    }

    /* renamed from: f */
    public boolean mo27370f() {
        return this.f4000g;
    }

    public void finish() {
        if (!this.f4000g) {
            this.f3997d.clear();
            removeAllFriendlyObstructions();
            this.f4000g = true;
            getAdSessionStatePublisher().mo27447f();
            C2031a.m3760a().mo27395c(this);
            getAdSessionStatePublisher().mo27442b();
            this.f3998e = null;
        }
    }

    /* renamed from: g */
    public boolean mo27371g() {
        return this.f3995b.isNativeImpressionOwner();
    }

    public String getAdSessionId() {
        return this.f4001h;
    }

    public AdSessionStatePublisher getAdSessionStatePublisher() {
        return this.f3998e;
    }

    /* renamed from: h */
    public boolean mo27372h() {
        return this.f3995b.isNativeVideoEventsOwner();
    }

    public void registerAdView(View view) {
        if (!this.f4000g) {
            C2049e.m3841a((Object) view, "AdView is null");
            if (mo27367c() != view) {
                m3740c(view);
                getAdSessionStatePublisher().mo27450h();
                m3741d(view);
            }
        }
    }

    public void removeAllFriendlyObstructions() {
        if (!this.f4000g) {
            this.f3996c.clear();
        }
    }

    public void removeFriendlyObstruction(View view) {
        if (!this.f4000g) {
            m3739b(view);
            C2051a a = m3738a(view);
            if (a != null) {
                this.f3996c.remove(a);
            }
        }
    }

    public void start() {
        if (!this.f3999f) {
            this.f3999f = true;
            C2031a.m3760a().mo27393b(this);
            this.f3998e.mo27431a(C2038e.m3797a().mo27424d());
            this.f3998e.mo27436a(this, this.f3994a);
        }
    }
}
