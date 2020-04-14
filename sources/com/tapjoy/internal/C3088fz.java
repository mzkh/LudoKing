package com.tapjoy.internal;

import android.content.Context;
import com.tapjoy.TJActionRequest;
import com.tapjoy.TJError;
import com.tapjoy.TJPlacement;
import com.tapjoy.TJPlacementListener;
import com.tapjoy.TapjoyConnectCore;
import com.tapjoy.TapjoyConstants;
import com.tapjoy.TapjoyLog;
import java.util.Observable;
import java.util.Observer;

/* renamed from: com.tapjoy.internal.fz */
abstract class C3088fz {

    /* renamed from: b */
    volatile C3089a f7278b;

    /* renamed from: com.tapjoy.internal.fz$a */
    class C3089a implements TJPlacementListener, Observer {

        /* renamed from: b */
        private final Object f7280b;

        /* renamed from: c */
        private final C3065fi f7281c;

        /* renamed from: d */
        private volatile boolean f7282d;

        /* renamed from: e */
        private TJPlacement f7283e;

        public final void onClick(TJPlacement tJPlacement) {
        }

        public final void onContentDismiss(TJPlacement tJPlacement) {
        }

        public final void onContentShow(TJPlacement tJPlacement) {
        }

        public final void onPurchaseRequest(TJPlacement tJPlacement, TJActionRequest tJActionRequest, String str) {
        }

        public final void onRequestSuccess(TJPlacement tJPlacement) {
        }

        public final void onRewardRequest(TJPlacement tJPlacement, TJActionRequest tJActionRequest, String str, int i) {
        }

        C3089a(C3088fz fzVar, Object obj) {
            this(obj, new C3065fi(TapjoyConstants.TIMER_INCREMENT));
        }

        C3089a(Object obj, C3065fi fiVar) {
            this.f7280b = obj;
            this.f7281c = fiVar;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public final void mo30155a() {
            synchronized (this) {
                if (!this.f7282d) {
                    if (this.f7281c.mo30120a()) {
                        m7131a("Timed out");
                        return;
                    }
                    if (!TapjoyConnectCore.isConnected()) {
                        C3081fs.f7264a.addObserver(this);
                        if (TapjoyConnectCore.isConnected()) {
                            C3081fs.f7264a.deleteObserver(this);
                        } else {
                            return;
                        }
                    }
                    if (this.f7283e == null) {
                        if (!C3088fz.this.mo30140a()) {
                            m7131a("Cannot request");
                            return;
                        }
                        this.f7283e = C3088fz.this.mo30138a(TapjoyConnectCore.getContext(), this, this.f7280b);
                        this.f7283e.requestContent();
                    } else if (this.f7283e.isContentReady()) {
                        if (C3088fz.this.mo30152a((Observer) this)) {
                            this.f7283e.showContent();
                            m7131a(null);
                        }
                    }
                }
            }
        }

        /* renamed from: a */
        private void m7131a(String str) {
            synchronized (this) {
                String a = C3088fz.this.mo30139a(this.f7280b);
                if (str == null) {
                    StringBuilder sb = new StringBuilder("Placement ");
                    sb.append(a);
                    sb.append(" is presented now");
                    TapjoyLog.m6553i("SystemPlacement", sb.toString());
                } else {
                    StringBuilder sb2 = new StringBuilder("Cannot show placement ");
                    sb2.append(a);
                    sb2.append(" now (");
                    sb2.append(str);
                    sb2.append(")");
                    TapjoyLog.m6553i("SystemPlacement", sb2.toString());
                }
                this.f7282d = true;
                this.f7283e = null;
                C3081fs.f7264a.deleteObserver(this);
                C3081fs.f7268e.deleteObserver(this);
                C3081fs.f7266c.deleteObserver(this);
            }
            C3088fz fzVar = C3088fz.this;
            synchronized (fzVar) {
                if (fzVar.f7278b == this) {
                    fzVar.f7278b = null;
                }
            }
        }

        public final void update(Observable observable, Object obj) {
            mo30155a();
        }

        public final void onRequestFailure(TJPlacement tJPlacement, TJError tJError) {
            m7131a(tJError.message);
        }

        public final void onContentReady(TJPlacement tJPlacement) {
            mo30155a();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract TJPlacement mo30138a(Context context, TJPlacementListener tJPlacementListener, Object obj);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract String mo30139a(Object obj);

    C3088fz() {
    }

    /* renamed from: c */
    public final boolean mo30154c(Object obj) {
        if (!mo30140a()) {
            return false;
        }
        C3089a aVar = null;
        synchronized (this) {
            if (this.f7278b == null) {
                aVar = mo30153b(obj);
                this.f7278b = aVar;
            }
        }
        if (aVar == null) {
            return false;
        }
        aVar.mo30155a();
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C3089a mo30153b(Object obj) {
        return new C3089a(this, obj);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo30140a() {
        return !TapjoyConnectCore.isFullScreenViewOpen();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo30152a(Observer observer) {
        if (TapjoyConnectCore.isFullScreenViewOpen()) {
            C3081fs.f7268e.addObserver(observer);
            if (TapjoyConnectCore.isFullScreenViewOpen()) {
                return false;
            }
            C3081fs.f7268e.deleteObserver(observer);
        }
        if (!C1831gz.m3554a().mo18131d()) {
            C3081fs.f7266c.addObserver(observer);
            if (!C1831gz.m3554a().mo18131d()) {
                return false;
            }
            C3081fs.f7266c.deleteObserver(observer);
        }
        return true;
    }
}
