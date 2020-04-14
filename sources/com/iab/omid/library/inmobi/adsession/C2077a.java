package com.iab.omid.library.inmobi.adsession;

import android.view.View;
import com.iab.omid.library.inmobi.p032b.C2079a;
import com.iab.omid.library.inmobi.p032b.C2086e;
import com.iab.omid.library.inmobi.p034d.C2097e;
import com.iab.omid.library.inmobi.p035e.C2099a;
import com.iab.omid.library.inmobi.publisher.AdSessionStatePublisher;
import com.iab.omid.library.inmobi.publisher.C2102a;
import com.iab.omid.library.inmobi.publisher.C2103b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

/* renamed from: com.iab.omid.library.inmobi.adsession.a */
public class C2077a extends AdSession {

    /* renamed from: a */
    private final AdSessionContext f4105a;

    /* renamed from: b */
    private final AdSessionConfiguration f4106b;

    /* renamed from: c */
    private final List<C2099a> f4107c = new ArrayList();

    /* renamed from: d */
    private C2099a f4108d;

    /* renamed from: e */
    private AdSessionStatePublisher f4109e;

    /* renamed from: f */
    private boolean f4110f = false;

    /* renamed from: g */
    private boolean f4111g = false;

    /* renamed from: h */
    private String f4112h;

    /* renamed from: i */
    private boolean f4113i;

    C2077a(AdSessionConfiguration adSessionConfiguration, AdSessionContext adSessionContext) {
        this.f4106b = adSessionConfiguration;
        this.f4105a = adSessionContext;
        this.f4112h = UUID.randomUUID().toString();
        m3947c(null);
        this.f4109e = adSessionContext.getAdSessionContextType() == AdSessionContextType.HTML ? new C2102a(adSessionContext.getWebView()) : new C2103b(adSessionContext.getVerificationScriptResources(), adSessionContext.getOmidJsScriptContent());
        this.f4109e.mo27594a();
        C2079a.m3964a().mo27554a(this);
        this.f4109e.mo27598a(adSessionConfiguration);
    }

    /* renamed from: a */
    private C2099a m3945a(View view) {
        for (C2099a aVar : this.f4107c) {
            if (aVar.get() == view) {
                return aVar;
            }
        }
        return null;
    }

    /* renamed from: b */
    private void m3946b(View view) {
        if (view == null) {
            throw new IllegalArgumentException("FriendlyObstruction is null");
        }
    }

    /* renamed from: c */
    private void m3947c(View view) {
        this.f4108d = new C2099a(view);
    }

    /* renamed from: d */
    private void m3948d(View view) {
        Collection<C2077a> b = C2079a.m3964a().mo27555b();
        if (b != null && b.size() > 0) {
            for (C2077a aVar : b) {
                if (aVar != this && aVar.mo27530c() == view) {
                    aVar.f4108d.clear();
                }
            }
        }
    }

    /* renamed from: i */
    private void m3949i() {
        if (this.f4113i) {
            throw new IllegalStateException("Impression event can only be sent once");
        }
    }

    /* renamed from: a */
    public List<C2099a> mo27528a() {
        return this.f4107c;
    }

    public void addFriendlyObstruction(View view) {
        if (!this.f4111g) {
            m3946b(view);
            if (m3945a(view) == null) {
                this.f4107c.add(new C2099a(view));
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo27529b() {
        m3949i();
        getAdSessionStatePublisher().mo27612g();
        this.f4113i = true;
    }

    /* renamed from: c */
    public View mo27530c() {
        return (View) this.f4108d.get();
    }

    /* renamed from: d */
    public boolean mo27531d() {
        return this.f4110f && !this.f4111g;
    }

    /* renamed from: e */
    public boolean mo27532e() {
        return this.f4110f;
    }

    public void error(ErrorType errorType, String str) {
        if (!this.f4111g) {
            C2097e.m4047a((Object) errorType, "Error type is null");
            C2097e.m4049a(str, "Message is null");
            getAdSessionStatePublisher().mo27599a(errorType, str);
            return;
        }
        throw new IllegalStateException("AdSession is finished");
    }

    /* renamed from: f */
    public boolean mo27533f() {
        return this.f4111g;
    }

    public void finish() {
        if (!this.f4111g) {
            this.f4108d.clear();
            removeAllFriendlyObstructions();
            this.f4111g = true;
            getAdSessionStatePublisher().mo27611f();
            C2079a.m3964a().mo27558c(this);
            getAdSessionStatePublisher().mo27606b();
            this.f4109e = null;
        }
    }

    /* renamed from: g */
    public boolean mo27534g() {
        return this.f4106b.isNativeImpressionOwner();
    }

    public String getAdSessionId() {
        return this.f4112h;
    }

    public AdSessionStatePublisher getAdSessionStatePublisher() {
        return this.f4109e;
    }

    /* renamed from: h */
    public boolean mo27535h() {
        return this.f4106b.isNativeVideoEventsOwner();
    }

    public void registerAdView(View view) {
        if (!this.f4111g) {
            C2097e.m4047a((Object) view, "AdView is null");
            if (mo27530c() != view) {
                m3947c(view);
                getAdSessionStatePublisher().mo27614h();
                m3948d(view);
            }
        }
    }

    public void removeAllFriendlyObstructions() {
        if (!this.f4111g) {
            this.f4107c.clear();
        }
    }

    public void removeFriendlyObstruction(View view) {
        if (!this.f4111g) {
            m3946b(view);
            C2099a a = m3945a(view);
            if (a != null) {
                this.f4107c.remove(a);
            }
        }
    }

    public void start() {
        if (!this.f4110f) {
            this.f4110f = true;
            C2079a.m3964a().mo27556b(this);
            this.f4109e.mo27595a(C2086e.m4001a().mo27587d());
            this.f4109e.mo27600a(this, this.f4105a);
        }
    }
}
