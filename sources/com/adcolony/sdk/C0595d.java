package com.adcolony.sdk;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import com.applovin.mediation.AppLovinNativeAdapter;
import com.google.ads.mediation.adcolony.AdColonyAdapterUtils;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* renamed from: com.adcolony.sdk.d */
class C0595d {

    /* renamed from: a */
    private HashMap<String, C0580c> f590a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ConcurrentHashMap<String, AdColonyInterstitial> f591b;

    /* renamed from: c */
    private HashMap<String, AdColonyAdViewListener> f592c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public HashMap<String, AdColonyAdView> f593d;

    /* renamed from: e */
    private HashMap<String, C0629e> f594e;

    C0595d() {
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public boolean m558d(C0480ab abVar) {
        final String b = C0746u.m908b(abVar.mo8220c(), "id");
        final AdColonyAdViewListener adColonyAdViewListener = (AdColonyAdViewListener) this.f592c.remove(b);
        if (adColonyAdViewListener == null) {
            mo8505a(abVar.mo8221d(), b);
            return false;
        }
        final Context c = C0476a.m85c();
        if (c == null) {
            return false;
        }
        final C0480ab abVar2 = abVar;
        C05961 r2 = new Runnable() {
            public void run() {
                AdColonyAdView adColonyAdView = new AdColonyAdView(c, abVar2, adColonyAdViewListener);
                C0595d.this.f593d.put(b, adColonyAdView);
                adColonyAdView.setOmidManager(adColonyAdViewListener.mo8074c());
                adColonyAdView.mo8035a();
                adColonyAdViewListener.mo8071a((C0487ag) null);
                adColonyAdViewListener.onRequestFilled(adColonyAdView);
            }
        };
        C0543at.m309a((Runnable) r2);
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public boolean m560e(C0480ab abVar) {
        String b = C0746u.m908b(abVar.mo8220c(), "id");
        final AdColonyAdViewListener adColonyAdViewListener = (AdColonyAdViewListener) this.f592c.remove(b);
        if (adColonyAdViewListener == null) {
            mo8505a(abVar.mo8221d(), b);
            return false;
        }
        C0543at.m309a((Runnable) new Runnable() {
            public void run() {
                String a = adColonyAdViewListener.mo8069a();
                AdColonyZone adColonyZone = (AdColonyZone) C0476a.m77a().mo8572f().get(a);
                if (adColonyZone == null) {
                    adColonyZone = new AdColonyZone(a);
                    adColonyZone.mo8193b(6);
                }
                adColonyAdViewListener.onRequestNotFilled(adColonyZone);
            }
        });
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8501a() {
        this.f590a = new HashMap<>();
        this.f591b = new ConcurrentHashMap<>();
        this.f592c = new HashMap<>();
        this.f593d = new HashMap<>();
        this.f594e = new HashMap<>();
        C0476a.m81a("AdContainer.create", (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(final C0480ab abVar) {
                C0543at.m309a((Runnable) new Runnable() {
                    public void run() {
                        C0595d.this.m570j(abVar);
                    }
                });
            }
        });
        C0476a.m81a("AdContainer.destroy", (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(final C0480ab abVar) {
                C0543at.m309a((Runnable) new Runnable() {
                    public void run() {
                        C0595d.this.m572k(abVar);
                    }
                });
            }
        });
        C0476a.m81a("AdContainer.move_view_to_index", (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                C0595d.this.m574l(abVar);
            }
        });
        C0476a.m81a("AdContainer.move_view_to_front", (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                C0595d.this.m576m(abVar);
            }
        });
        C0476a.m81a("AdSession.finish_fullscreen_ad", (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                C0595d.this.m568i(abVar);
            }
        });
        C0476a.m81a("AdSession.start_fullscreen_ad", (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                C0595d.this.m566h(abVar);
            }
        });
        C0476a.m81a("AdSession.ad_view_available", (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                C0595d.this.m558d(abVar);
            }
        });
        C0476a.m81a("AdSession.ad_view_unavailable", (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                C0595d.this.m560e(abVar);
            }
        });
        C0476a.m81a("AdSession.expiring", (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                C0595d.this.mo8506a(abVar);
            }
        });
        C0476a.m81a("AdSession.audio_stopped", (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(final C0480ab abVar) {
                C0543at.m309a((Runnable) new Runnable() {
                    public void run() {
                        AdColonyInterstitial adColonyInterstitial = (AdColonyInterstitial) C0595d.this.f591b.get(C0746u.m908b(abVar.mo8220c(), "id"));
                        if (adColonyInterstitial != null && adColonyInterstitial.getListener() != null) {
                            adColonyInterstitial.getListener().onAudioStopped(adColonyInterstitial);
                        }
                    }
                });
            }
        });
        C0476a.m81a("AdSession.audio_started", (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(final C0480ab abVar) {
                C0543at.m309a((Runnable) new Runnable() {
                    public void run() {
                        AdColonyInterstitial adColonyInterstitial = (AdColonyInterstitial) C0595d.this.f591b.get(C0746u.m908b(abVar.mo8220c(), "id"));
                        if (adColonyInterstitial != null && adColonyInterstitial.getListener() != null) {
                            adColonyInterstitial.getListener().onAudioStarted(adColonyInterstitial);
                        }
                    }
                });
            }
        });
        C0476a.m81a("AudioPlayer.create", (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                C0595d.this.m578n(abVar);
            }
        });
        C0476a.m81a("AudioPlayer.destroy", (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                if (C0595d.this.mo8510c(abVar)) {
                    C0595d.this.m580o(abVar);
                }
            }
        });
        C0476a.m81a("AudioPlayer.play", (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                if (C0595d.this.mo8510c(abVar)) {
                    C0595d.this.m582p(abVar);
                }
            }
        });
        C0476a.m81a("AudioPlayer.pause", (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                if (C0595d.this.mo8510c(abVar)) {
                    C0595d.this.m583q(abVar);
                }
            }
        });
        C0476a.m81a("AudioPlayer.stop", (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                if (C0595d.this.mo8510c(abVar)) {
                    C0595d.this.m584r(abVar);
                }
            }
        });
        C0476a.m81a("AdSession.interstitial_available", (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                C0595d.this.m564g(abVar);
            }
        });
        C0476a.m81a("AdSession.interstitial_unavailable", (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                C0595d.this.mo8508b(abVar);
            }
        });
        C0476a.m81a("AdSession.has_audio", (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                C0595d.this.m562f(abVar);
            }
        });
        C0476a.m81a("WebView.prepare", (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                JSONObject a = C0746u.m892a();
                C0746u.m913b(a, "success", true);
                abVar.mo8216a(a).mo8217b();
            }
        });
        C0476a.m81a("AdSession.expanded", (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(final C0480ab abVar) {
                C0543at.m309a((Runnable) new Runnable() {
                    public void run() {
                        C0480ab abVar = abVar;
                        abVar.mo8216a(abVar.mo8220c()).mo8217b();
                    }
                });
            }
        });
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo8506a(C0480ab abVar) {
        final AdColonyInterstitialListener adColonyInterstitialListener;
        JSONObject c = abVar.mo8220c();
        String b = C0746u.m908b(c, "id");
        if (C0746u.m914c(c, "type") == 0) {
            final AdColonyInterstitial adColonyInterstitial = (AdColonyInterstitial) this.f591b.remove(b);
            if (adColonyInterstitial == null) {
                adColonyInterstitialListener = null;
            } else {
                adColonyInterstitialListener = adColonyInterstitial.getListener();
            }
            if (adColonyInterstitialListener == null) {
                mo8505a(abVar.mo8221d(), b);
                return false;
            } else if (!C0476a.m86d()) {
                return false;
            } else {
                C0543at.m309a((Runnable) new Runnable() {
                    public void run() {
                        adColonyInterstitial.mo8130a(true);
                        adColonyInterstitialListener.onExpiring(adColonyInterstitial);
                        C0697m r = C0476a.m77a().mo8584r();
                        if (r.mo8660b() != null) {
                            r.mo8660b().dismiss();
                            r.mo8658a((AlertDialog) null);
                        }
                    }
                });
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public boolean m562f(C0480ab abVar) {
        String str = "id";
        String b = C0746u.m908b(abVar.mo8220c(), str);
        JSONObject a = C0746u.m892a();
        C0746u.m902a(a, str, b);
        Context c = C0476a.m85c();
        String str2 = "has_audio";
        if (c == null) {
            C0746u.m913b(a, str2, false);
            abVar.mo8216a(a).mo8217b();
            return false;
        }
        boolean a2 = C0543at.m308a(C0543at.m299a(c));
        double b2 = C0543at.m314b(C0543at.m299a(c));
        C0746u.m913b(a, str2, a2);
        C0746u.m900a(a, "volume", b2);
        abVar.mo8216a(a).mo8217b();
        return a2;
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public boolean m564g(final C0480ab abVar) {
        final AdColonyInterstitialListener adColonyInterstitialListener;
        String b = C0746u.m908b(abVar.mo8220c(), "id");
        final AdColonyInterstitial adColonyInterstitial = (AdColonyInterstitial) this.f591b.get(b);
        if (adColonyInterstitial == null) {
            adColonyInterstitialListener = null;
        } else {
            adColonyInterstitialListener = adColonyInterstitial.getListener();
        }
        if (adColonyInterstitialListener == null) {
            mo8505a(abVar.mo8221d(), b);
            return false;
        } else if (!C0476a.m86d()) {
            return false;
        } else {
            C0543at.m309a((Runnable) new Runnable() {
                public void run() {
                    if (adColonyInterstitial.mo8146h() == null) {
                        adColonyInterstitial.mo8129a(C0746u.m921f(abVar.mo8220c(), "iab"));
                    }
                    adColonyInterstitial.mo8128a(C0746u.m908b(abVar.mo8220c(), AppLovinNativeAdapter.KEY_EXTRA_AD_ID));
                    adColonyInterstitial.mo8135b(C0746u.m908b(abVar.mo8220c(), "creative_id"));
                    C0487ag h = adColonyInterstitial.mo8146h();
                    if (!(h == null || h.mo8250c() == 2)) {
                        try {
                            h.mo8249b();
                        } catch (IllegalArgumentException unused) {
                            new C0749a().mo8726a("IllegalArgumentException when creating omid session").mo8728a(C0748w.f1172h);
                        }
                    }
                    adColonyInterstitialListener.onRequestFilled(adColonyInterstitial);
                }
            });
            return true;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo8508b(C0480ab abVar) {
        final AdColonyInterstitialListener adColonyInterstitialListener;
        String b = C0746u.m908b(abVar.mo8220c(), "id");
        final AdColonyInterstitial adColonyInterstitial = (AdColonyInterstitial) this.f591b.remove(b);
        if (adColonyInterstitial == null) {
            adColonyInterstitialListener = null;
        } else {
            adColonyInterstitialListener = adColonyInterstitial.getListener();
        }
        if (adColonyInterstitialListener == null) {
            mo8505a(abVar.mo8221d(), b);
            return false;
        } else if (!C0476a.m86d()) {
            return false;
        } else {
            C0543at.m309a((Runnable) new Runnable() {
                public void run() {
                    AdColonyZone adColonyZone = (AdColonyZone) C0476a.m77a().mo8572f().get(adColonyInterstitial.getZoneID());
                    if (adColonyZone == null) {
                        adColonyZone = new AdColonyZone(adColonyInterstitial.getZoneID());
                        adColonyZone.mo8193b(6);
                    }
                    adColonyInterstitialListener.onRequestNotFilled(adColonyZone);
                }
            });
            return true;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public boolean mo8510c(C0480ab abVar) {
        String b = C0746u.m908b(abVar.mo8220c(), "ad_session_id");
        C0580c cVar = (C0580c) this.f590a.get(b);
        C0629e eVar = (C0629e) this.f594e.get(b);
        if (cVar != null && eVar != null) {
            return true;
        }
        new C0749a().mo8726a("Invalid AudioPlayer message!").mo8728a(C0748w.f1171g);
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8503a(String str, AdColonyAdViewListener adColonyAdViewListener, AdColonyAdSize adColonyAdSize, AdColonyAdOptions adColonyAdOptions) {
        String e = C0543at.m326e();
        JSONObject a = C0746u.m892a();
        float p = C0476a.m77a().mo8579m().mo8640p();
        C0746u.m902a(a, AdColonyAdapterUtils.KEY_ZONE_ID, str);
        C0746u.m912b(a, "type", 1);
        C0746u.m912b(a, "width_pixels", (int) (((float) adColonyAdSize.getWidth()) * p));
        C0746u.m912b(a, "height_pixels", (int) (((float) adColonyAdSize.getHeight()) * p));
        C0746u.m912b(a, "width", adColonyAdSize.getWidth());
        C0746u.m912b(a, "height", adColonyAdSize.getHeight());
        C0746u.m902a(a, "id", e);
        adColonyAdViewListener.mo8072a(str);
        adColonyAdViewListener.mo8070a(adColonyAdSize);
        if (!(adColonyAdOptions == null || adColonyAdOptions.f67d == null)) {
            C0746u.m904a(a, "options", adColonyAdOptions.f67d);
        }
        this.f592c.put(e, adColonyAdViewListener);
        new C0480ab("AdSession.on_request", 1, a).mo8217b();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8504a(String str, AdColonyInterstitialListener adColonyInterstitialListener, AdColonyAdOptions adColonyAdOptions) {
        String e = C0543at.m326e();
        C0666j a = C0476a.m77a();
        JSONObject a2 = C0746u.m892a();
        C0746u.m902a(a2, AdColonyAdapterUtils.KEY_ZONE_ID, str);
        C0746u.m913b(a2, "fullscreen", true);
        C0746u.m912b(a2, "width", a.mo8579m().mo8641q());
        C0746u.m912b(a2, "height", a.mo8579m().mo8642r());
        C0746u.m912b(a2, "type", 0);
        C0746u.m902a(a2, "id", e);
        new C0749a().mo8726a("AdSession request with id = ").mo8726a(e).mo8728a(C0748w.f1166b);
        AdColonyInterstitial adColonyInterstitial = new AdColonyInterstitial(e, adColonyInterstitialListener, str);
        this.f591b.put(e, adColonyInterstitial);
        if (!(adColonyAdOptions == null || adColonyAdOptions.f67d == null)) {
            adColonyInterstitial.mo8126a(adColonyAdOptions);
            C0746u.m904a(a2, "options", adColonyAdOptions.f67d);
        }
        new C0749a().mo8726a("Requesting AdColony interstitial advertisement.").mo8728a(C0748w.f1165a);
        new C0480ab("AdSession.on_request", 1, a2).mo8217b();
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public boolean m566h(C0480ab abVar) {
        JSONObject c = abVar.mo8220c();
        String str = "id";
        String b = C0746u.m908b(c, str);
        AdColonyInterstitial adColonyInterstitial = (AdColonyInterstitial) this.f591b.get(b);
        AdColonyAdView adColonyAdView = (AdColonyAdView) this.f593d.get(b);
        int a = C0746u.m888a(c, "orientation", -1);
        boolean z = adColonyAdView != null;
        if (adColonyInterstitial != null || z) {
            JSONObject a2 = C0746u.m892a();
            C0746u.m902a(a2, str, b);
            if (adColonyInterstitial != null) {
                adColonyInterstitial.mo8125a(C0746u.m914c(a2, "module_id"));
                if (a == 0 || a == 1) {
                    adColonyInterstitial.mo8134b(a);
                }
                adColonyInterstitial.mo8131a();
            }
            return true;
        }
        mo8505a(abVar.mo8221d(), b);
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public boolean m568i(C0480ab abVar) {
        final AdColonyInterstitialListener adColonyInterstitialListener;
        JSONObject c = abVar.mo8220c();
        int c2 = C0746u.m914c(c, "status");
        if (c2 == 5 || c2 == 1 || c2 == 0 || c2 == 6) {
            return false;
        }
        String b = C0746u.m908b(c, "id");
        final AdColonyInterstitial adColonyInterstitial = (AdColonyInterstitial) this.f591b.remove(b);
        if (adColonyInterstitial == null) {
            adColonyInterstitialListener = null;
        } else {
            adColonyInterstitialListener = adColonyInterstitial.getListener();
        }
        if (adColonyInterstitialListener == null) {
            mo8505a(abVar.mo8221d(), b);
            return false;
        }
        C0543at.m309a((Runnable) new Runnable() {
            public void run() {
                C0476a.m77a().mo8566c(false);
                adColonyInterstitialListener.onClosed(adColonyInterstitial);
            }
        });
        adColonyInterstitial.mo8127a((C0580c) null);
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public boolean m570j(C0480ab abVar) {
        Context c = C0476a.m85c();
        if (c == null) {
            return false;
        }
        JSONObject c2 = abVar.mo8220c();
        String b = C0746u.m908b(c2, "ad_session_id");
        C0580c cVar = new C0580c(c.getApplicationContext(), b);
        cVar.mo8465b(abVar);
        this.f590a.put(b, cVar);
        if (C0746u.m914c(c2, "width") != 0) {
            cVar.mo8461a(false);
        } else if (((AdColonyInterstitial) this.f591b.get(b)) == null) {
            mo8505a(abVar.mo8221d(), b);
            return false;
        } else {
            ((AdColonyInterstitial) this.f591b.get(b)).mo8127a(cVar);
        }
        JSONObject a = C0746u.m892a();
        C0746u.m913b(a, "success", true);
        abVar.mo8216a(a).mo8217b();
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public boolean m572k(C0480ab abVar) {
        String b = C0746u.m908b(abVar.mo8220c(), "ad_session_id");
        C0580c cVar = (C0580c) this.f590a.get(b);
        if (cVar == null) {
            mo8505a(abVar.mo8221d(), b);
            return false;
        }
        mo8502a(cVar);
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8502a(final C0580c cVar) {
        C0543at.m309a((Runnable) new Runnable() {
            public void run() {
                for (int i = 0; i < cVar.mo8488m().size(); i++) {
                    C0476a.m83b((String) cVar.mo8489n().get(i), (C0484ad) cVar.mo8488m().get(i));
                }
                cVar.mo8489n().clear();
                cVar.mo8488m().clear();
                cVar.removeAllViews();
                C0580c cVar = cVar;
                cVar.f549d = null;
                cVar.f548c = null;
                new C0749a().mo8726a("Destroying container tied to ad_session_id = ").mo8726a(cVar.mo8463b()).mo8728a(C0748w.f1168d);
                for (C0557av avVar : cVar.mo8477g().values()) {
                    if (!avVar.mo8417m()) {
                        int b = avVar.mo8238b();
                        if (b <= 0) {
                            b = avVar.mo8236a();
                        }
                        C0476a.m77a().mo8557a(b);
                        avVar.loadUrl("about:blank");
                        avVar.clearCache(true);
                        avVar.removeAllViews();
                        avVar.mo8404a(true);
                    }
                }
                new C0749a().mo8726a("Stopping and releasing all media players associated with ").mo8726a("VideoViews tied to ad_session_id = ").mo8726a(cVar.mo8463b()).mo8728a(C0748w.f1168d);
                for (C0546au auVar : cVar.mo8473e().values()) {
                    auVar.mo8380d();
                    auVar.mo8383g();
                }
                cVar.mo8473e().clear();
                cVar.mo8474f().clear();
                cVar.mo8477g().clear();
                cVar.mo8482j().clear();
                cVar.mo8486l().clear();
                cVar.mo8481i().clear();
                cVar.mo8485k().clear();
                cVar.f546a = true;
            }
        });
        AdColonyAdView adColonyAdView = (AdColonyAdView) this.f593d.get(cVar.mo8463b());
        if (adColonyAdView == null || adColonyAdView.mo8038d()) {
            new C0749a().mo8726a("Removing ad 4").mo8728a(C0748w.f1166b);
            this.f590a.remove(cVar.mo8463b());
            cVar.f548c = null;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8505a(String str, String str2) {
        new C0749a().mo8726a("Message '").mo8726a(str).mo8726a("' sent with invalid id: ").mo8726a(str2).mo8728a(C0748w.f1171g);
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public boolean m574l(C0480ab abVar) {
        JSONObject c = abVar.mo8220c();
        String d = abVar.mo8221d();
        String b = C0746u.m908b(c, "ad_session_id");
        int c2 = C0746u.m914c(c, "view_id");
        C0580c cVar = (C0580c) this.f590a.get(b);
        View view = (View) cVar.mo8486l().get(Integer.valueOf(c2));
        if (cVar == null) {
            mo8505a(d, b);
            return false;
        } else if (view == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(c2);
            mo8505a(d, sb.toString());
            return false;
        } else {
            view.bringToFront();
            return true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public boolean m576m(C0480ab abVar) {
        JSONObject c = abVar.mo8220c();
        String d = abVar.mo8221d();
        String b = C0746u.m908b(c, "ad_session_id");
        int c2 = C0746u.m914c(c, "view_id");
        C0580c cVar = (C0580c) this.f590a.get(b);
        if (cVar == null) {
            mo8505a(d, b);
            return false;
        }
        View view = (View) cVar.mo8486l().get(Integer.valueOf(c2));
        if (view == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(c2);
            mo8505a(d, sb.toString());
            return false;
        }
        cVar.removeView(view);
        cVar.addView(view, view.getLayoutParams());
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public boolean m578n(C0480ab abVar) {
        String b = C0746u.m908b(abVar.mo8220c(), "ad_session_id");
        C0580c cVar = (C0580c) this.f590a.get(b);
        if (cVar == null) {
            mo8505a(abVar.mo8221d(), b);
            return false;
        }
        C0629e eVar = (C0629e) this.f594e.get(b);
        if (eVar == null) {
            eVar = new C0629e(b, cVar.mo8467c());
            this.f594e.put(b, eVar);
        }
        eVar.mo8527a(abVar);
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public boolean m580o(C0480ab abVar) {
        String b = C0746u.m908b(abVar.mo8220c(), "ad_session_id");
        C0629e eVar = (C0629e) this.f594e.get(b);
        if (eVar == null) {
            mo8505a(abVar.mo8221d(), b);
            return false;
        }
        eVar.mo8533d(abVar);
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: p */
    public boolean m582p(C0480ab abVar) {
        String b = C0746u.m908b(abVar.mo8220c(), "ad_session_id");
        C0629e eVar = (C0629e) this.f594e.get(b);
        if (eVar == null) {
            mo8505a(abVar.mo8221d(), b);
            return false;
        }
        eVar.mo8531c(abVar);
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: q */
    public boolean m583q(C0480ab abVar) {
        String b = C0746u.m908b(abVar.mo8220c(), "ad_session_id");
        C0629e eVar = (C0629e) this.f594e.get(b);
        if (eVar == null) {
            mo8505a(abVar.mo8221d(), b);
            return false;
        }
        eVar.mo8529b(abVar);
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: r */
    public boolean m584r(C0480ab abVar) {
        String b = C0746u.m908b(abVar.mo8220c(), "ad_session_id");
        C0629e eVar = (C0629e) this.f594e.get(b);
        if (eVar == null) {
            mo8505a(abVar.mo8221d(), b);
            return false;
        }
        eVar.mo8534e(abVar);
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public HashMap<String, C0580c> mo8507b() {
        return this.f590a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public ConcurrentHashMap<String, AdColonyInterstitial> mo8509c() {
        return this.f591b;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public HashMap<String, AdColonyAdViewListener> mo8511d() {
        return this.f592c;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public HashMap<String, AdColonyAdView> mo8512e() {
        return this.f593d;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public HashMap<String, C0629e> mo8513f() {
        return this.f594e;
    }
}
