package com.tapjoy;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.drive.DriveFile;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import com.tapjoy.TapjoyErrorMessage.ErrorType;
import com.tapjoy.internal.C1823gf;
import com.tapjoy.internal.C1823gf.C1825a;
import com.tapjoy.internal.C1831gz;
import com.tapjoy.internal.C1852jq;
import com.tapjoy.internal.C3072fn;
import com.tapjoy.internal.C3078fq;
import com.tapjoy.internal.C3085fw;
import com.tapjoy.internal.C3104ge;
import com.tapjoy.internal.C3117gs;
import com.tapjoy.internal.C3120gv;
import com.tapjoy.internal.C3136he;
import java.util.HashMap;
import java.util.UUID;

public class TJPlacement {

    /* renamed from: a */
    TJPlacementListener f6372a;

    /* renamed from: b */
    private TJCorePlacement f6373b;

    /* renamed from: c */
    private TJPlacementListener f6374c;

    /* renamed from: d */
    private TJPlacementVideoListener f6375d;

    /* renamed from: e */
    private String f6376e;
    public String pushId;

    @Deprecated
    public TJPlacement(Context context, String str, TJPlacementListener tJPlacementListener) {
        TJCorePlacement a = TJPlacementManager.m6493a(str);
        if (a == null) {
            String str2 = "";
            a = TJPlacementManager.m6494a(str, str2, str2, false, false);
        }
        a.setContext(context);
        m6491a(a, tJPlacementListener);
    }

    TJPlacement(TJCorePlacement tJCorePlacement, TJPlacementListener tJPlacementListener) {
        m6491a(tJCorePlacement, tJPlacementListener);
    }

    /* renamed from: a */
    private void m6491a(TJCorePlacement tJCorePlacement, TJPlacementListener tJPlacementListener) {
        this.f6373b = tJCorePlacement;
        this.f6376e = UUID.randomUUID().toString();
        this.f6374c = tJPlacementListener;
        this.f6372a = tJPlacementListener != null ? (TJPlacementListener) C3072fn.m7099a(tJPlacementListener, TJPlacementListener.class) : null;
        FiveRocksIntegration.addPlacementCallback(getName(), this);
    }

    public TJPlacementListener getListener() {
        return this.f6374c;
    }

    public void setVideoListener(TJPlacementVideoListener tJPlacementVideoListener) {
        this.f6375d = tJPlacementVideoListener;
    }

    public TJPlacementVideoListener getVideoListener() {
        return this.f6375d;
    }

    public String getName() {
        return this.f6373b.getPlacementData() != null ? this.f6373b.getPlacementData().getPlacementName() : "";
    }

    public boolean isLimited() {
        return this.f6373b.isLimited();
    }

    public boolean isContentReady() {
        boolean isContentReady = this.f6373b.isContentReady();
        C3085fw fwVar = this.f6373b.f6313f;
        if (isContentReady) {
            fwVar.mo30149a(4);
        } else {
            fwVar.mo30149a(2);
        }
        return isContentReady;
    }

    public boolean isContentAvailable() {
        this.f6373b.f6313f.mo30149a(1);
        return this.f6373b.isContentAvailable();
    }

    public void setMediationId(String str) {
        this.f6373b.f6323p = str;
    }

    public void requestContent() {
        boolean z;
        String name = getName();
        StringBuilder sb = new StringBuilder("requestContent() called for placement ");
        sb.append(name);
        String str = "TJPlacement";
        TapjoyLog.m6553i(str, sb.toString());
        String str2 = "TJPlacement.requestContent";
        C1823gf.m3513a(str2).mo18099a("placement", (Object) name).mo18099a("placement_type", (Object) this.f6373b.f6310c.getPlacementType());
        if (C3104ge.m7159a() != null && C1852jq.m3669c(C3104ge.m7159a().f7326b)) {
            TapjoyLog.m6555w(str, "[INFO] Your application calls requestContent without having previously called setUserConsent. You can review Tapjoy supported consent API here - https://dev.tapjoy.com/sdk-integration/#sdk11122_gdpr_release.");
        }
        if (!isLimited()) {
            z = TapjoyConnectCore.isConnected();
        } else {
            z = TapjoyConnectCore.isLimitedConnected();
        }
        if (!z) {
            C1823gf.m3520b(str2).mo18102b("not connected").mo18104c();
            m6492a(new TJError(0, "SDK not connected -- connect must be called first with a successful callback"));
        } else if (this.f6373b.getContext() == null) {
            C1823gf.m3520b(str2).mo18102b("no context").mo18104c();
            m6492a(new TJError(0, "Context is null -- TJPlacement requires a valid Context."));
        } else if (C1852jq.m3669c(name)) {
            C1823gf.m3520b(str2).mo18102b("invalid name").mo18104c();
            m6492a(new TJError(0, "Invalid placement name -- TJPlacement requires a valid placement name."));
        } else {
            try {
                this.f6373b.mo29546a(this);
            } finally {
                C1823gf.m3523d(str2);
            }
        }
    }

    public void showContent() {
        String name = getName();
        StringBuilder sb = new StringBuilder("showContent() called for placement ");
        sb.append(name);
        String sb2 = sb.toString();
        String str = "TJPlacement";
        TapjoyLog.m6553i(str, sb2);
        TJCorePlacement tJCorePlacement = this.f6373b;
        String str2 = "TJPlacement.showContent";
        C1823gf.m3513a(str2).mo18099a("placement", (Object) tJCorePlacement.f6310c.getPlacementName()).mo18099a("placement_type", (Object) tJCorePlacement.f6310c.getPlacementType()).mo18099a(Param.CONTENT_TYPE, (Object) tJCorePlacement.mo29545a());
        C3085fw fwVar = tJCorePlacement.f6313f;
        fwVar.mo30149a(8);
        C3078fq fqVar = fwVar.f7271a;
        if (fqVar != null) {
            fqVar.mo30141a();
        }
        if (!this.f6373b.isContentAvailable()) {
            TapjoyLog.m6551e(str, new TapjoyErrorMessage(ErrorType.INTEGRATION_ERROR, "No placement content available. Can not show content for non-200 placement."));
            C1823gf.m3520b(str2).mo18102b("no content").mo18104c();
            return;
        }
        try {
            TJCorePlacement tJCorePlacement2 = this.f6373b;
            if (TapjoyConnectCore.isFullScreenViewOpen()) {
                TapjoyLog.m6555w(TJCorePlacement.f6303a, "Only one view can be presented at a time.");
                C1823gf.m3520b(str2).mo18102b("another content showing").mo18104c();
            } else {
                if (TapjoyConnectCore.isViewOpen()) {
                    TapjoyLog.m6555w(TJCorePlacement.f6303a, "Will close N2E content.");
                    TJPlacementManager.dismissContentShowing(false);
                }
                tJCorePlacement2.mo29549a("SHOW", this);
                C1825a d = C1823gf.m3523d(str2);
                if (tJCorePlacement2.f6314g.isPrerendered()) {
                    d.mo18099a("prerendered", (Object) Boolean.valueOf(true));
                }
                if (tJCorePlacement2.isContentReady()) {
                    d.mo18099a("content_ready", (Object) Boolean.valueOf(true));
                }
                tJCorePlacement2.f6313f.f7274d = d;
                String uuid = UUID.randomUUID().toString();
                if (tJCorePlacement2.f6316i != null) {
                    tJCorePlacement2.f6316i.f3851f = uuid;
                    int i = tJCorePlacement2.f6316i == null ? 1 : tJCorePlacement2.f6316i instanceof C3120gv ? 3 : tJCorePlacement2.f6316i instanceof C3136he ? 2 : 0;
                    TapjoyConnectCore.viewWillOpen(uuid, i);
                    tJCorePlacement2.f6316i.f3850e = new C3117gs(uuid) {

                        /* renamed from: a */
                        final /* synthetic */ String f6344a;

                        {
                            this.f6344a = r2;
                        }

                        /* renamed from: a */
                        public final void mo29561a(Context context, String str, String str2) {
                            if (str2 == null) {
                                TJCorePlacement.this.f6310c.setRedirectURL(str);
                            } else {
                                TJCorePlacement.this.f6310c.setBaseURL(str);
                                TJCorePlacement.this.f6310c.setHttpResponse(str2);
                            }
                            TJCorePlacement.this.f6310c.setHasProgressSpinner(true);
                            TJCorePlacement.this.f6310c.setContentViewId(this.f6344a);
                            Intent intent = new Intent(TJCorePlacement.this.f6309b, TJAdUnitActivity.class);
                            intent.putExtra(TJAdUnitConstants.EXTRA_TJ_PLACEMENT_DATA, TJCorePlacement.this.f6310c);
                            intent.setFlags(DriveFile.MODE_READ_ONLY);
                            context.startActivity(intent);
                        }
                    };
                    C1831gz.m3558a((Runnable) new Runnable() {
                        public final void run() {
                            TJCorePlacement.this.f6316i.mo18173a(C1831gz.m3554a().f3832p, TJCorePlacement.this.f6313f);
                        }
                    });
                } else {
                    tJCorePlacement2.f6310c.setContentViewId(uuid);
                    Intent intent = new Intent(tJCorePlacement2.f6309b, TJAdUnitActivity.class);
                    intent.putExtra(TJAdUnitConstants.EXTRA_TJ_PLACEMENT_DATA, tJCorePlacement2.f6310c);
                    intent.setFlags(DriveFile.MODE_READ_ONLY);
                    tJCorePlacement2.f6309b.startActivity(intent);
                }
                tJCorePlacement2.f6312e = 0;
                tJCorePlacement2.f6318k = false;
                tJCorePlacement2.f6319l = false;
            }
        } finally {
            C1823gf.m3523d(str2);
        }
    }

    public void setAuctionData(HashMap hashMap) {
        if (hashMap == null || hashMap.isEmpty()) {
            TapjoyLog.m6550d("TJPlacement", "auctionData can not be null or empty");
            return;
        }
        TJCorePlacement tJCorePlacement = this.f6373b;
        tJCorePlacement.f6324q = hashMap;
        String b = tJCorePlacement.mo29550b();
        if (!C1852jq.m3669c(b)) {
            StringBuilder sb = new StringBuilder();
            sb.append(TapjoyConnectCore.getPlacementURL());
            sb.append("v1/apps/");
            sb.append(b);
            sb.append("/bid_content?");
            tJCorePlacement.f6310c.setAuctionMediationURL(sb.toString());
            return;
        }
        TapjoyLog.m6553i(TJCorePlacement.f6303a, "Placement auction data can not be set for a null app ID");
    }

    public void setMediationName(String str) {
        StringBuilder sb = new StringBuilder("setMediationName=");
        sb.append(str);
        TapjoyLog.m6550d("TJPlacement", sb.toString());
        if (!C1852jq.m3669c(str)) {
            TJCorePlacement tJCorePlacement = this.f6373b;
            Context context = tJCorePlacement != null ? tJCorePlacement.getContext() : null;
            this.f6373b = TJPlacementManager.m6494a(getName(), str, "", false, isLimited());
            TJCorePlacement tJCorePlacement2 = this.f6373b;
            tJCorePlacement2.f6322o = str;
            tJCorePlacement2.f6320m = str;
            tJCorePlacement2.f6310c.setPlacementType(str);
            String b = tJCorePlacement2.mo29550b();
            if (!C1852jq.m3669c(b)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(TapjoyConnectCore.getPlacementURL());
                sb2.append("v1/apps/");
                sb2.append(b);
                sb2.append("/mediation_content?");
                tJCorePlacement2.f6310c.setMediationURL(sb2.toString());
            } else {
                TapjoyLog.m6553i(TJCorePlacement.f6303a, "Placement mediation name can not be set for a null app ID");
            }
            if (context != null) {
                this.f6373b.setContext(context);
            }
        }
    }

    public void setAdapterVersion(String str) {
        this.f6373b.f6321n = str;
    }

    public static void dismissContent() {
        TJPlacementManager.dismissContentShowing("true".equals(TapjoyConnectCore.getConnectFlagValue("TJC_OPTION_DISMISS_CONTENT_ALL")));
    }

    public String getGUID() {
        return this.f6376e;
    }

    /* renamed from: a */
    private void m6492a(TJError tJError) {
        this.f6373b.mo29547a(this, ErrorType.INTEGRATION_ERROR, tJError);
    }
}
