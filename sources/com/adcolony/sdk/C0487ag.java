package com.adcolony.sdk;

import android.webkit.WebView;
import com.facebook.appevents.AppEventsConstants;
import com.iab.omid.library.adcolony.adsession.AdEvents;
import com.iab.omid.library.adcolony.adsession.AdSession;
import com.iab.omid.library.adcolony.adsession.AdSessionConfiguration;
import com.iab.omid.library.adcolony.adsession.AdSessionContext;
import com.iab.omid.library.adcolony.adsession.Owner;
import com.iab.omid.library.adcolony.adsession.VerificationScriptResource;
import com.iab.omid.library.adcolony.adsession.video.InteractionType;
import com.iab.omid.library.adcolony.adsession.video.Position;
import com.iab.omid.library.adcolony.adsession.video.VastProperties;
import com.iab.omid.library.adcolony.adsession.video.VideoEvents;
import com.tapjoy.TJAdUnitConstants.String;
import com.tapjoy.TapjoyConstants;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.adcolony.sdk.ag */
class C0487ag {

    /* renamed from: a */
    private AdSessionContext f178a;

    /* renamed from: b */
    private AdSessionConfiguration f179b;

    /* renamed from: c */
    private AdSession f180c;

    /* renamed from: d */
    private AdEvents f181d;

    /* renamed from: e */
    private VideoEvents f182e;

    /* renamed from: f */
    private AdColonyCustomMessageListener f183f;

    /* renamed from: g */
    private List<VerificationScriptResource> f184g = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f185h = -1;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public String f186i;

    /* renamed from: j */
    private int f187j;

    /* renamed from: k */
    private boolean f188k;

    /* renamed from: l */
    private boolean f189l;

    /* renamed from: m */
    private boolean f190m;

    /* renamed from: n */
    private boolean f191n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public boolean f192o;

    /* renamed from: p */
    private int f193p;

    /* renamed from: q */
    private int f194q;

    /* renamed from: r */
    private String f195r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public String f196s;

    C0487ag(JSONObject jSONObject, String str) {
        VerificationScriptResource verificationScriptResource;
        String str2 = "";
        this.f186i = str2;
        this.f195r = str2;
        this.f196s = str2;
        this.f185h = m130a(jSONObject);
        this.f191n = C0746u.m918d(jSONObject, "skippable");
        this.f193p = C0746u.m914c(jSONObject, "skip_offset");
        this.f194q = C0746u.m914c(jSONObject, "video_duration");
        JSONArray g = C0746u.m922g(jSONObject, "js_resources");
        JSONArray g2 = C0746u.m922g(jSONObject, "verification_params");
        JSONArray g3 = C0746u.m922g(jSONObject, "vendor_keys");
        this.f196s = str;
        for (int i = 0; i < g.length(); i++) {
            try {
                String c = C0746u.m915c(g2, i);
                String c2 = C0746u.m915c(g3, i);
                URL url = new URL(C0746u.m915c(g, i));
                if (!c.equals(str2) && !c2.equals(str2)) {
                    verificationScriptResource = VerificationScriptResource.createVerificationScriptResourceWithParameters(c2, url, c);
                } else if (!c2.equals(str2)) {
                    verificationScriptResource = VerificationScriptResource.createVerificationScriptResourceWithoutParameters(c2, url);
                } else {
                    verificationScriptResource = VerificationScriptResource.createVerificationScriptResourceWithoutParameters(url);
                }
                this.f184g.add(verificationScriptResource);
            } catch (MalformedURLException unused) {
                new C0749a().mo8726a("Invalid js resource url passed to Omid").mo8728a(C0748w.f1172h);
            }
        }
        try {
            this.f195r = C0476a.m77a().mo8576j().mo8691a(C0746u.m908b(jSONObject, "filepath"), true).toString();
        } catch (IOException unused2) {
            new C0749a().mo8726a("Error loading IAB JS Client").mo8728a(C0748w.f1172h);
        }
    }

    /* renamed from: a */
    private int m130a(JSONObject jSONObject) {
        if (this.f185h == -1) {
            this.f187j = C0746u.m914c(jSONObject, "ad_unit_type");
            String b = C0746u.m908b(jSONObject, AppEventsConstants.EVENT_PARAM_AD_TYPE);
            int i = this.f187j;
            if (i == 0) {
                return 0;
            }
            if (i == 1) {
                if (b.equals("video")) {
                    return 0;
                }
                if (b.equals("display")) {
                    return 1;
                }
                if (b.equals("banner_display") || b.equals("interstitial_display")) {
                    return 2;
                }
            }
        }
        return this.f185h;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8246a(C0580c cVar) {
        VideoEvents videoEvents;
        VastProperties vastProperties;
        if (!this.f190m && this.f185h >= 0 && this.f180c != null) {
            m133b(cVar);
            m136f();
            if (this.f185h != 0) {
                videoEvents = null;
            } else {
                videoEvents = VideoEvents.createVideoEvents(this.f180c);
            }
            this.f182e = videoEvents;
            this.f180c.start();
            this.f181d = AdEvents.createAdEvents(this.f180c);
            m134b("start_session");
            if (this.f182e != null) {
                Position position = Position.PREROLL;
                if (this.f191n) {
                    vastProperties = VastProperties.createVastPropertiesForSkippableVideo((float) this.f193p, true, position);
                } else {
                    vastProperties = VastProperties.createVastPropertiesForNonSkippableVideo(true, position);
                }
                this.f182e.loaded(vastProperties);
            }
            this.f190m = true;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8244a() {
        AdColony.removeCustomMessageListener("viewability_ad_event");
        this.f180c.finish();
        m134b("end_session");
        this.f180c = null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo8249b() throws IllegalArgumentException {
        mo8245a((WebView) null);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8245a(WebView webView) throws IllegalArgumentException {
        if (this.f185h >= 0) {
            String str = this.f195r;
            if (str != null) {
                String str2 = "";
                if (!str.equals(str2)) {
                    List<VerificationScriptResource> list = this.f184g;
                    if (list == null) {
                        return;
                    }
                    if (!list.isEmpty() || mo8250c() == 2) {
                        C0666j a = C0476a.m77a();
                        Owner owner = Owner.NATIVE;
                        int c = mo8250c();
                        String str3 = "inject_javascript";
                        if (c == 0) {
                            this.f178a = AdSessionContext.createNativeAdSessionContext(a.mo8546D(), this.f195r, this.f184g, null);
                            this.f179b = AdSessionConfiguration.createAdSessionConfiguration(owner, owner, false);
                            this.f180c = AdSession.createAdSession(this.f179b, this.f178a);
                            this.f186i = this.f180c.getAdSessionId();
                            m134b(str3);
                        } else if (c == 1) {
                            this.f178a = AdSessionContext.createNativeAdSessionContext(a.mo8546D(), this.f195r, this.f184g, null);
                            this.f179b = AdSessionConfiguration.createAdSessionConfiguration(owner, null, false);
                            this.f180c = AdSession.createAdSession(this.f179b, this.f178a);
                            this.f186i = this.f180c.getAdSessionId();
                            m134b(str3);
                        } else if (c == 2) {
                            this.f178a = AdSessionContext.createHtmlAdSessionContext(a.mo8546D(), webView, str2);
                            this.f179b = AdSessionConfiguration.createAdSessionConfiguration(owner, null, false);
                            this.f180c = AdSession.createAdSession(this.f179b, this.f178a);
                            this.f186i = this.f180c.getAdSessionId();
                        }
                    }
                }
            }
        }
    }

    /* renamed from: b */
    private void m134b(final String str) {
        C0543at.f402b.execute(new Runnable() {
            public void run() {
                JSONObject a = C0746u.m892a();
                JSONObject a2 = C0746u.m892a();
                C0746u.m912b(a2, "session_type", C0487ag.this.f185h);
                C0746u.m902a(a2, TapjoyConstants.TJC_SESSION_ID, C0487ag.this.f186i);
                C0746u.m902a(a2, "event", str);
                C0746u.m902a(a, "type", "iab_hook");
                C0746u.m902a(a, "message", a2.toString());
                new C0480ab("CustomMessage.controller_send", 0, a).mo8217b();
            }
        });
    }

    /* renamed from: b */
    private void m133b(C0580c cVar) {
        m134b("register_ad_view");
        C0557av avVar = (C0557av) C0476a.m77a().mo8591y().get(Integer.valueOf(cVar.mo8467c()));
        if (avVar == null && !cVar.mo8477g().isEmpty()) {
            avVar = (C0557av) ((Entry) cVar.mo8477g().entrySet().iterator().next()).getValue();
        }
        AdSession adSession = this.f180c;
        if (adSession == null || avVar == null) {
            AdSession adSession2 = this.f180c;
            if (adSession2 != null) {
                adSession2.registerAdView(cVar);
                cVar.mo8459a(this.f180c);
                m134b("register_obstructions");
                return;
            }
            return;
        }
        adSession.registerAdView(avVar);
        avVar.mo8413i();
    }

    /* renamed from: f */
    private void m136f() {
        this.f183f = new AdColonyCustomMessageListener() {
            public void onAdColonyCustomMessage(AdColonyCustomMessage adColonyCustomMessage) {
                JSONObject a = C0746u.m893a(adColonyCustomMessage.getMessage());
                final String b = C0746u.m908b(a, "event_type");
                final float floatValue = BigDecimal.valueOf(C0746u.m919e(a, "duration")).floatValue();
                boolean d = C0746u.m918d(a, "replay");
                boolean equals = C0746u.m908b(a, "skip_type").equals("dec");
                final String b2 = C0746u.m908b(a, "asi");
                if (!b.equals("skip") || !equals) {
                    if (!d || (!b.equals(String.VIDEO_START) && !b.equals("first_quartile") && !b.equals(String.VIDEO_MIDPOINT) && !b.equals("third_quartile") && !b.equals(String.VIDEO_COMPLETE))) {
                        C0543at.m309a((Runnable) new Runnable() {
                            public void run() {
                                if (b2.equals(C0487ag.this.f196s)) {
                                    C0487ag.this.mo8248a(b, floatValue);
                                    return;
                                }
                                AdColonyAdView adColonyAdView = (AdColonyAdView) C0476a.m77a().mo8578l().mo8512e().get(b2);
                                C0487ag omidManager = adColonyAdView != null ? adColonyAdView.getOmidManager() : null;
                                if (omidManager != null) {
                                    omidManager.mo8248a(b, floatValue);
                                }
                            }
                        });
                    }
                    return;
                }
                C0487ag.this.f192o = true;
            }
        };
        AdColony.addCustomMessageListener(this.f183f, "viewability_ad_event");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8247a(String str) {
        mo8248a(str, 0.0f);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8248a(String str, float f) {
        if (C0476a.m86d() && this.f180c != null) {
            VideoEvents videoEvents = this.f182e;
            String str2 = "continue";
            String str3 = "cancel";
            String str4 = "skip";
            String str5 = String.VIDEO_START;
            if (videoEvents != null || str.equals(str5) || str.equals(str4) || str.equals(str2) || str.equals(str3)) {
                char c = 65535;
                try {
                    String str6 = "pause";
                    switch (str.hashCode()) {
                        case -1941887438:
                            if (str.equals("first_quartile")) {
                                c = 1;
                                break;
                            }
                            break;
                        case -1710060637:
                            if (str.equals("buffer_start")) {
                                c = 12;
                                break;
                            }
                            break;
                        case -1638835128:
                            if (str.equals(String.VIDEO_MIDPOINT)) {
                                c = 2;
                                break;
                            }
                            break;
                        case -1367724422:
                            if (str.equals(str3)) {
                                c = 7;
                                break;
                            }
                            break;
                        case -934426579:
                            if (str.equals("resume")) {
                                c = 11;
                                break;
                            }
                            break;
                        case -651914917:
                            if (str.equals("third_quartile")) {
                                c = 3;
                                break;
                            }
                            break;
                        case -599445191:
                            if (str.equals(String.VIDEO_COMPLETE)) {
                                c = 4;
                                break;
                            }
                            break;
                        case -567202649:
                            if (str.equals(str2)) {
                                c = 5;
                                break;
                            }
                            break;
                        case -342650039:
                            if (str.equals("sound_mute")) {
                                c = 8;
                                break;
                            }
                            break;
                        case 3532159:
                            if (str.equals(str4)) {
                                c = 6;
                                break;
                            }
                            break;
                        case 106440182:
                            if (str.equals(str6)) {
                                c = 10;
                                break;
                            }
                            break;
                        case 109757538:
                            if (str.equals(str5)) {
                                c = 0;
                                break;
                            }
                            break;
                        case 583742045:
                            if (str.equals("in_video_engagement")) {
                                c = 14;
                                break;
                            }
                            break;
                        case 823102269:
                            if (str.equals("html5_interaction")) {
                                c = 15;
                                break;
                            }
                            break;
                        case 1648173410:
                            if (str.equals("sound_unmute")) {
                                c = 9;
                                break;
                            }
                            break;
                        case 1906584668:
                            if (str.equals("buffer_end")) {
                                c = 13;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            this.f181d.impressionOccurred();
                            if (this.f182e != null) {
                                VideoEvents videoEvents2 = this.f182e;
                                if (f <= 0.0f) {
                                    f = (float) this.f194q;
                                }
                                videoEvents2.start(f, 1.0f);
                            }
                            m134b(str);
                            break;
                        case 1:
                            this.f182e.firstQuartile();
                            m134b(str);
                            break;
                        case 2:
                            this.f182e.midpoint();
                            m134b(str);
                            break;
                        case 3:
                            this.f182e.thirdQuartile();
                            m134b(str);
                            break;
                        case 4:
                            this.f192o = true;
                            this.f182e.complete();
                            m134b(str);
                            break;
                        case 5:
                            m134b(str);
                            mo8244a();
                            break;
                        case 6:
                        case 7:
                            if (this.f182e != null) {
                                this.f182e.skipped();
                            }
                            m134b(str);
                            mo8244a();
                            break;
                        case 8:
                            this.f182e.volumeChange(0.0f);
                            m134b(str);
                            break;
                        case 9:
                            this.f182e.volumeChange(1.0f);
                            m134b(str);
                            break;
                        case 10:
                            if (!this.f188k && !this.f189l && !this.f192o) {
                                this.f182e.pause();
                                m134b(str);
                                this.f188k = true;
                                this.f189l = false;
                                break;
                            }
                        case 11:
                            if (this.f188k && !this.f192o) {
                                this.f182e.resume();
                                m134b(str);
                                this.f188k = false;
                                break;
                            }
                        case 12:
                            this.f182e.bufferStart();
                            m134b(str);
                            break;
                        case 13:
                            this.f182e.bufferFinish();
                            m134b(str);
                            break;
                        case 14:
                        case 15:
                            this.f182e.adUserInteraction(InteractionType.CLICK);
                            m134b(str);
                            if (this.f189l && !this.f188k && !this.f192o) {
                                this.f182e.pause();
                                m134b(str6);
                                this.f188k = true;
                                this.f189l = false;
                                break;
                            }
                    }
                } catch (IllegalArgumentException | IllegalStateException e) {
                    C0749a a = new C0749a().mo8726a("Recording IAB event for ").mo8726a(str);
                    StringBuilder sb = new StringBuilder();
                    sb.append(" caused ");
                    sb.append(e.getClass());
                    a.mo8726a(sb.toString()).mo8728a(C0748w.f1170f);
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public int mo8250c() {
        return this.f185h;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo8251d() {
        this.f189l = true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public AdSession mo8252e() {
        return this.f180c;
    }
}
