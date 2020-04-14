package com.adcolony.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Vibrator;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.drive.DriveFile;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TJAdUnitConstants.String;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.adcolony.sdk.aq */
class C0511aq {
    C0511aq() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8325a() {
        C0476a.m81a("System.open_store", (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                C0511aq.this.mo8329b(abVar);
            }
        });
        C0476a.m81a("System.save_screenshot", (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                C0511aq.this.mo8330c(abVar);
            }
        });
        C0476a.m81a("System.telephone", (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                C0511aq.this.mo8331d(abVar);
            }
        });
        C0476a.m81a("System.sms", (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                C0511aq.this.mo8332e(abVar);
            }
        });
        C0476a.m81a("System.vibrate", (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                C0511aq.this.mo8333f(abVar);
            }
        });
        C0476a.m81a("System.open_browser", (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                C0511aq.this.mo8334g(abVar);
            }
        });
        C0476a.m81a("System.mail", (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                C0511aq.this.mo8335h(abVar);
            }
        });
        C0476a.m81a("System.launch_app", (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                C0511aq.this.mo8336i(abVar);
            }
        });
        C0476a.m81a("System.create_calendar_event", (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                C0511aq.this.mo8337j(abVar);
            }
        });
        C0476a.m81a("System.check_app_presence", (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                C0511aq.this.mo8338k(abVar);
            }
        });
        C0476a.m81a("System.check_social_presence", (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                C0511aq.this.mo8339l(abVar);
            }
        });
        C0476a.m81a("System.social_post", (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                C0511aq.this.mo8340m(abVar);
            }
        });
        C0476a.m81a("System.make_in_app_purchase", (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                C0511aq.this.m226q(abVar);
            }
        });
        C0476a.m81a("System.close", (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                C0511aq.this.m225p(abVar);
            }
        });
        C0476a.m81a("System.expand", (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                C0511aq.this.mo8327a(abVar);
            }
        });
        C0476a.m81a("System.use_custom_close", (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                C0511aq.this.m224o(abVar);
            }
        });
        C0476a.m81a("System.set_orientation_properties", (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                C0511aq.this.m223n(abVar);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public boolean m223n(C0480ab abVar) {
        JSONObject c = abVar.mo8220c();
        String b = C0746u.m908b(c, "ad_session_id");
        int c2 = C0746u.m914c(c, "orientation");
        C0595d l = C0476a.m77a().mo8578l();
        AdColonyAdView adColonyAdView = (AdColonyAdView) l.mo8512e().get(b);
        AdColonyInterstitial adColonyInterstitial = (AdColonyInterstitial) l.mo8509c().get(b);
        Context c3 = C0476a.m85c();
        if (adColonyAdView != null) {
            adColonyAdView.setOrientation(c2);
        } else if (adColonyInterstitial != null) {
            adColonyInterstitial.mo8134b(c2);
        }
        if (c3 instanceof C0578b) {
            ((C0578b) c3).mo8453a(adColonyAdView == null ? adColonyInterstitial.mo8141e() : adColonyAdView.getOrientation());
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo8327a(C0480ab abVar) {
        JSONObject c = abVar.mo8220c();
        Context c2 = C0476a.m85c();
        if (c2 != null && C0476a.m84b()) {
            String b = C0746u.m908b(c, "ad_session_id");
            C0666j a = C0476a.m77a();
            AdColonyAdView adColonyAdView = (AdColonyAdView) a.mo8578l().mo8512e().get(b);
            if (adColonyAdView != null && ((adColonyAdView.getTrustedDemandSource() || adColonyAdView.getUserInteraction()) && a.mo8587u() != adColonyAdView)) {
                adColonyAdView.setExpandMessage(abVar);
                adColonyAdView.setExpandedWidth(C0746u.m914c(c, "width"));
                adColonyAdView.setExpandedHeight(C0746u.m914c(c, "height"));
                adColonyAdView.setOrientation(C0746u.m888a(c, "orientation", -1));
                adColonyAdView.setNoCloseButton(C0746u.m918d(c, "use_custom_close"));
                a.mo8548a(adColonyAdView);
                a.mo8553a(adColonyAdView.getContainer());
                Intent intent = new Intent(c2, AdColonyAdViewActivity.class);
                if (c2 instanceof Application) {
                    intent.addFlags(DriveFile.MODE_READ_ONLY);
                }
                m220c(b);
                mo8328b(b);
                c2.startActivity(intent);
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public boolean m224o(C0480ab abVar) {
        AdColonyAdView adColonyAdView = (AdColonyAdView) C0476a.m77a().mo8578l().mo8512e().get(C0746u.m908b(abVar.mo8220c(), "ad_session_id"));
        if (adColonyAdView == null) {
            return false;
        }
        adColonyAdView.setNoCloseButton(C0746u.m918d(abVar.mo8220c(), "use_custom_close"));
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: p */
    public boolean m225p(C0480ab abVar) {
        String b = C0746u.m908b(abVar.mo8220c(), "ad_session_id");
        Activity activity = C0476a.m85c() instanceof Activity ? (Activity) C0476a.m85c() : null;
        boolean z = activity instanceof AdColonyAdViewActivity;
        if (!(activity instanceof C0578b)) {
            return false;
        }
        if (z) {
            ((AdColonyAdViewActivity) activity).mo8060b();
        } else {
            JSONObject a = C0746u.m892a();
            C0746u.m902a(a, "id", b);
            new C0480ab("AdSession.on_request_close", ((C0578b) activity).f535f, a).mo8217b();
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: q */
    public boolean m226q(C0480ab abVar) {
        JSONObject c = abVar.mo8220c();
        C0595d l = C0476a.m77a().mo8578l();
        String b = C0746u.m908b(c, "ad_session_id");
        AdColonyInterstitial adColonyInterstitial = (AdColonyInterstitial) l.mo8509c().get(b);
        AdColonyAdView adColonyAdView = (AdColonyAdView) l.mo8512e().get(b);
        if ((adColonyInterstitial == null || adColonyInterstitial.getListener() == null || adColonyInterstitial.mo8139d() == null) && (adColonyAdView == null || adColonyAdView.getListener() == null)) {
            return false;
        }
        if (adColonyAdView == null) {
            new C0480ab("AdUnit.make_in_app_purchase", adColonyInterstitial.mo8139d().mo8467c()).mo8217b();
        }
        mo8328b(b);
        m220c(b);
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo8329b(C0480ab abVar) {
        JSONObject a = C0746u.m892a();
        JSONObject c = abVar.mo8220c();
        String b = C0746u.m908b(c, "product_id");
        String b2 = C0746u.m908b(c, "ad_session_id");
        if (b.equals("")) {
            b = C0746u.m908b(c, "handle");
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(b));
        m221d(b);
        String str = "success";
        if (C0543at.m306a(intent)) {
            C0746u.m913b(a, str, true);
            abVar.mo8216a(a).mo8217b();
            mo8326a(b2);
            mo8328b(b2);
            m220c(b2);
            return true;
        }
        C0543at.m311a("Unable to open.", 0);
        C0746u.m913b(a, str, false);
        abVar.mo8216a(a).mo8217b();
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:8|9|10|11|12|13) */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        com.adcolony.sdk.C0543at.m311a(r1, 0);
        com.adcolony.sdk.C0746u.m913b(r4, r0, false);
        r13.mo8216a(r4).mo8217b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x00e1, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00e2, code lost:
        com.adcolony.sdk.C0543at.m311a(r1, 0);
        com.adcolony.sdk.C0746u.m913b(r4, r0, false);
        r13.mo8216a(r4).mo8217b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00ef, code lost:
        return false;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x00af */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x00d4 */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo8330c(final com.adcolony.sdk.C0480ab r13) {
        /*
            r12 = this;
            java.lang.String r0 = "success"
            java.lang.String r1 = "Error saving screenshot."
            android.content.Context r2 = com.adcolony.sdk.C0476a.m85c()
            r3 = 0
            if (r2 == 0) goto L_0x0113
            boolean r4 = r2 instanceof android.app.Activity
            if (r4 != 0) goto L_0x0011
            goto L_0x0113
        L_0x0011:
            java.lang.String r4 = "android.permission.WRITE_EXTERNAL_STORAGE"
            int r4 = androidx.core.app.ActivityCompat.checkSelfPermission(r2, r4)     // Catch:{ NoClassDefFoundError -> 0x0102 }
            if (r4 != 0) goto L_0x00f0
            org.json.JSONObject r4 = r13.mo8220c()     // Catch:{ NoClassDefFoundError -> 0x0102 }
            java.lang.String r5 = "ad_session_id"
            java.lang.String r4 = com.adcolony.sdk.C0746u.m908b(r4, r5)     // Catch:{ NoClassDefFoundError -> 0x0102 }
            r12.mo8328b(r4)     // Catch:{ NoClassDefFoundError -> 0x0102 }
            org.json.JSONObject r4 = com.adcolony.sdk.C0746u.m892a()     // Catch:{ NoClassDefFoundError -> 0x0102 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ NoClassDefFoundError -> 0x0102 }
            r5.<init>()     // Catch:{ NoClassDefFoundError -> 0x0102 }
            java.io.File r6 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ NoClassDefFoundError -> 0x0102 }
            java.lang.String r6 = r6.toString()     // Catch:{ NoClassDefFoundError -> 0x0102 }
            r5.append(r6)     // Catch:{ NoClassDefFoundError -> 0x0102 }
            java.lang.String r6 = "/Pictures/AdColony_Screenshots/AdColony_Screenshot_"
            r5.append(r6)     // Catch:{ NoClassDefFoundError -> 0x0102 }
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ NoClassDefFoundError -> 0x0102 }
            r5.append(r6)     // Catch:{ NoClassDefFoundError -> 0x0102 }
            java.lang.String r6 = ".jpg"
            r5.append(r6)     // Catch:{ NoClassDefFoundError -> 0x0102 }
            java.lang.String r5 = r5.toString()     // Catch:{ NoClassDefFoundError -> 0x0102 }
            r6 = r2
            android.app.Activity r6 = (android.app.Activity) r6     // Catch:{ NoClassDefFoundError -> 0x0102 }
            android.view.Window r6 = r6.getWindow()     // Catch:{ NoClassDefFoundError -> 0x0102 }
            android.view.View r6 = r6.getDecorView()     // Catch:{ NoClassDefFoundError -> 0x0102 }
            android.view.View r6 = r6.getRootView()     // Catch:{ NoClassDefFoundError -> 0x0102 }
            r7 = 1
            r6.setDrawingCacheEnabled(r7)     // Catch:{ NoClassDefFoundError -> 0x0102 }
            android.graphics.Bitmap r8 = r6.getDrawingCache()     // Catch:{ NoClassDefFoundError -> 0x0102 }
            android.graphics.Bitmap r8 = android.graphics.Bitmap.createBitmap(r8)     // Catch:{ NoClassDefFoundError -> 0x0102 }
            r6.setDrawingCacheEnabled(r3)     // Catch:{ NoClassDefFoundError -> 0x0102 }
            java.io.File r6 = new java.io.File     // Catch:{ Exception -> 0x00af }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00af }
            r9.<init>()     // Catch:{ Exception -> 0x00af }
            java.io.File r10 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ Exception -> 0x00af }
            java.lang.String r10 = r10.getPath()     // Catch:{ Exception -> 0x00af }
            r9.append(r10)     // Catch:{ Exception -> 0x00af }
            java.lang.String r10 = "/Pictures"
            r9.append(r10)     // Catch:{ Exception -> 0x00af }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x00af }
            r6.<init>(r9)     // Catch:{ Exception -> 0x00af }
            java.io.File r9 = new java.io.File     // Catch:{ Exception -> 0x00af }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00af }
            r10.<init>()     // Catch:{ Exception -> 0x00af }
            java.io.File r11 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ Exception -> 0x00af }
            java.lang.String r11 = r11.getPath()     // Catch:{ Exception -> 0x00af }
            r10.append(r11)     // Catch:{ Exception -> 0x00af }
            java.lang.String r11 = "/Pictures/AdColony_Screenshots"
            r10.append(r11)     // Catch:{ Exception -> 0x00af }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x00af }
            r9.<init>(r10)     // Catch:{ Exception -> 0x00af }
            r6.mkdirs()     // Catch:{ Exception -> 0x00af }
            r9.mkdirs()     // Catch:{ Exception -> 0x00af }
        L_0x00af:
            java.io.File r6 = new java.io.File     // Catch:{ FileNotFoundException -> 0x00e2, IOException -> 0x00d4 }
            r6.<init>(r5)     // Catch:{ FileNotFoundException -> 0x00e2, IOException -> 0x00d4 }
            java.io.FileOutputStream r9 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x00e2, IOException -> 0x00d4 }
            r9.<init>(r6)     // Catch:{ FileNotFoundException -> 0x00e2, IOException -> 0x00d4 }
            android.graphics.Bitmap$CompressFormat r6 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ FileNotFoundException -> 0x00e2, IOException -> 0x00d4 }
            r10 = 90
            r8.compress(r6, r10, r9)     // Catch:{ FileNotFoundException -> 0x00e2, IOException -> 0x00d4 }
            r9.flush()     // Catch:{ FileNotFoundException -> 0x00e2, IOException -> 0x00d4 }
            r9.close()     // Catch:{ FileNotFoundException -> 0x00e2, IOException -> 0x00d4 }
            java.lang.String[] r6 = new java.lang.String[r7]     // Catch:{ FileNotFoundException -> 0x00e2, IOException -> 0x00d4 }
            r6[r3] = r5     // Catch:{ FileNotFoundException -> 0x00e2, IOException -> 0x00d4 }
            r5 = 0
            com.adcolony.sdk.aq$10 r8 = new com.adcolony.sdk.aq$10     // Catch:{ FileNotFoundException -> 0x00e2, IOException -> 0x00d4 }
            r8.<init>(r4, r13)     // Catch:{ FileNotFoundException -> 0x00e2, IOException -> 0x00d4 }
            android.media.MediaScannerConnection.scanFile(r2, r6, r5, r8)     // Catch:{ FileNotFoundException -> 0x00e2, IOException -> 0x00d4 }
            return r7
        L_0x00d4:
            com.adcolony.sdk.C0543at.m311a(r1, r3)     // Catch:{ NoClassDefFoundError -> 0x0102 }
            com.adcolony.sdk.C0746u.m913b(r4, r0, r3)     // Catch:{ NoClassDefFoundError -> 0x0102 }
            com.adcolony.sdk.ab r2 = r13.mo8216a(r4)     // Catch:{ NoClassDefFoundError -> 0x0102 }
            r2.mo8217b()     // Catch:{ NoClassDefFoundError -> 0x0102 }
            return r3
        L_0x00e2:
            com.adcolony.sdk.C0543at.m311a(r1, r3)     // Catch:{ NoClassDefFoundError -> 0x0102 }
            com.adcolony.sdk.C0746u.m913b(r4, r0, r3)     // Catch:{ NoClassDefFoundError -> 0x0102 }
            com.adcolony.sdk.ab r2 = r13.mo8216a(r4)     // Catch:{ NoClassDefFoundError -> 0x0102 }
            r2.mo8217b()     // Catch:{ NoClassDefFoundError -> 0x0102 }
            return r3
        L_0x00f0:
            com.adcolony.sdk.C0543at.m311a(r1, r3)     // Catch:{ NoClassDefFoundError -> 0x0102 }
            org.json.JSONObject r2 = r13.mo8220c()     // Catch:{ NoClassDefFoundError -> 0x0102 }
            com.adcolony.sdk.C0746u.m913b(r2, r0, r3)     // Catch:{ NoClassDefFoundError -> 0x0102 }
            com.adcolony.sdk.ab r2 = r13.mo8216a(r2)     // Catch:{ NoClassDefFoundError -> 0x0102 }
            r2.mo8217b()     // Catch:{ NoClassDefFoundError -> 0x0102 }
            return r3
        L_0x0102:
            com.adcolony.sdk.C0543at.m311a(r1, r3)
            org.json.JSONObject r1 = r13.mo8220c()
            com.adcolony.sdk.C0746u.m913b(r1, r0, r3)
            com.adcolony.sdk.ab r13 = r13.mo8216a(r1)
            r13.mo8217b()
        L_0x0113:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.C0511aq.mo8330c(com.adcolony.sdk.ab):boolean");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public boolean mo8331d(C0480ab abVar) {
        JSONObject a = C0746u.m892a();
        JSONObject c = abVar.mo8220c();
        Intent intent = new Intent("android.intent.action.DIAL");
        StringBuilder sb = new StringBuilder();
        sb.append("tel:");
        sb.append(C0746u.m908b(c, "phone_number"));
        Intent data = intent.setData(Uri.parse(sb.toString()));
        String b = C0746u.m908b(c, "ad_session_id");
        String str = "success";
        if (C0543at.m306a(data)) {
            C0746u.m913b(a, str, true);
            abVar.mo8216a(a).mo8217b();
            mo8326a(b);
            mo8328b(b);
            m220c(b);
            return true;
        }
        C0543at.m311a("Failed to dial number.", 0);
        C0746u.m913b(a, str, false);
        abVar.mo8216a(a).mo8217b();
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public boolean mo8332e(C0480ab abVar) {
        JSONObject c = abVar.mo8220c();
        JSONObject a = C0746u.m892a();
        String b = C0746u.m908b(c, "ad_session_id");
        JSONArray g = C0746u.m922g(c, "recipients");
        String str = "";
        for (int i = 0; i < g.length(); i++) {
            if (i != 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(";");
                str = sb.toString();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(C0746u.m915c(g, i));
            str = sb2.toString();
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("smsto:");
        sb3.append(str);
        boolean a2 = C0543at.m306a(new Intent("android.intent.action.VIEW", Uri.parse(sb3.toString())).putExtra("sms_body", C0746u.m908b(c, "body")));
        String str2 = "success";
        if (a2) {
            C0746u.m913b(a, str2, true);
            abVar.mo8216a(a).mo8217b();
            mo8326a(b);
            mo8328b(b);
            m220c(b);
            return true;
        }
        C0543at.m311a("Failed to create sms.", 0);
        C0746u.m913b(a, str2, false);
        abVar.mo8216a(a).mo8217b();
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public boolean mo8333f(C0480ab abVar) {
        Context c = C0476a.m85c();
        if (c == null) {
            return false;
        }
        int a = C0746u.m888a(abVar.mo8220c(), "length_ms", (int) TJAdUnitConstants.DEFAULT_VOLUME_CHECK_INTERVAL);
        JSONObject a2 = C0746u.m892a();
        JSONArray d = C0543at.m324d(c);
        boolean z = false;
        for (int i = 0; i < d.length(); i++) {
            if (C0746u.m915c(d, i).equals("android.permission.VIBRATE")) {
                z = true;
            }
        }
        String str = "success";
        if (!z) {
            new C0749a().mo8726a("No vibrate permission detected.").mo8728a(C0748w.f1169e);
            C0746u.m913b(a2, str, false);
            abVar.mo8216a(a2).mo8217b();
            return false;
        }
        try {
            ((Vibrator) c.getSystemService("vibrator")).vibrate((long) a);
            C0746u.m913b(a2, str, false);
            abVar.mo8216a(a2).mo8217b();
            return true;
        } catch (Exception unused) {
            new C0749a().mo8726a("Vibrate command failed.").mo8728a(C0748w.f1169e);
            C0746u.m913b(a2, str, false);
            abVar.mo8216a(a2).mo8217b();
            return false;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public boolean mo8334g(C0480ab abVar) {
        JSONObject a = C0746u.m892a();
        JSONObject c = abVar.mo8220c();
        String b = C0746u.m908b(c, "url");
        String b2 = C0746u.m908b(c, "ad_session_id");
        AdColonyAdView adColonyAdView = (AdColonyAdView) C0476a.m77a().mo8578l().mo8512e().get(b2);
        if (adColonyAdView != null && !adColonyAdView.getTrustedDemandSource() && !adColonyAdView.getUserInteraction()) {
            return false;
        }
        String str = "browser";
        String str2 = "http";
        if (b.startsWith(str)) {
            b = b.replaceFirst(str, str2);
        }
        String str3 = "safari";
        if (b.startsWith(str3)) {
            b = b.replaceFirst(str3, str2);
        }
        m221d(b);
        boolean a2 = C0543at.m306a(new Intent("android.intent.action.VIEW", Uri.parse(b)));
        String str4 = "success";
        if (a2) {
            C0746u.m913b(a, str4, true);
            abVar.mo8216a(a).mo8217b();
            mo8326a(b2);
            mo8328b(b2);
            m220c(b2);
            return true;
        }
        C0543at.m311a("Failed to launch browser.", 0);
        C0746u.m913b(a, str4, false);
        abVar.mo8216a(a).mo8217b();
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public boolean mo8335h(C0480ab abVar) {
        JSONObject a = C0746u.m892a();
        JSONObject c = abVar.mo8220c();
        JSONArray g = C0746u.m922g(c, "recipients");
        boolean d = C0746u.m918d(c, String.HTML);
        String b = C0746u.m908b(c, "subject");
        String b2 = C0746u.m908b(c, "body");
        String b3 = C0746u.m908b(c, "ad_session_id");
        String[] strArr = new String[g.length()];
        for (int i = 0; i < g.length(); i++) {
            strArr[i] = C0746u.m915c(g, i);
        }
        Intent intent = new Intent("android.intent.action.SEND");
        if (!d) {
            intent.setType("plain/text");
        }
        intent.putExtra("android.intent.extra.SUBJECT", b).putExtra("android.intent.extra.TEXT", b2).putExtra("android.intent.extra.EMAIL", strArr);
        String str = "success";
        if (C0543at.m306a(intent)) {
            C0746u.m913b(a, str, true);
            abVar.mo8216a(a).mo8217b();
            mo8326a(b3);
            mo8328b(b3);
            m220c(b3);
            return true;
        }
        C0543at.m311a("Failed to send email.", 0);
        C0746u.m913b(a, str, false);
        abVar.mo8216a(a).mo8217b();
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public boolean mo8336i(C0480ab abVar) {
        JSONObject a = C0746u.m892a();
        JSONObject c = abVar.mo8220c();
        String b = C0746u.m908b(c, "ad_session_id");
        if (C0746u.m918d(c, "deep_link")) {
            return mo8329b(abVar);
        }
        Context c2 = C0476a.m85c();
        if (c2 == null) {
            return false;
        }
        boolean a2 = C0543at.m306a(c2.getPackageManager().getLaunchIntentForPackage(C0746u.m908b(c, "handle")));
        String str = "success";
        if (a2) {
            C0746u.m913b(a, str, true);
            abVar.mo8216a(a).mo8217b();
            mo8326a(b);
            mo8328b(b);
            m220c(b);
            return true;
        }
        C0543at.m311a("Failed to launch external application.", 0);
        C0746u.m913b(a, str, false);
        abVar.mo8216a(a).mo8217b();
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01ce  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x01ed  */
    /* renamed from: j */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo8337j(com.adcolony.sdk.C0480ab r25) {
        /*
            r24 = this;
            r0 = r24
            r1 = r25
            org.json.JSONObject r2 = com.adcolony.sdk.C0746u.m892a()
            org.json.JSONObject r3 = r25.mo8220c()
            java.lang.String r4 = "ad_session_id"
            java.lang.String r4 = com.adcolony.sdk.C0746u.m908b(r3, r4)
            java.lang.String r5 = "params"
            org.json.JSONObject r3 = com.adcolony.sdk.C0746u.m921f(r3, r5)
            java.lang.String r5 = "recurrence"
            org.json.JSONObject r5 = com.adcolony.sdk.C0746u.m921f(r3, r5)
            org.json.JSONArray r6 = com.adcolony.sdk.C0746u.m909b()
            org.json.JSONArray r7 = com.adcolony.sdk.C0746u.m909b()
            org.json.JSONArray r8 = com.adcolony.sdk.C0746u.m909b()
            java.lang.String r9 = "description"
            java.lang.String r10 = com.adcolony.sdk.C0746u.m908b(r3, r9)
            java.lang.String r11 = "location"
            com.adcolony.sdk.C0746u.m908b(r3, r11)
            java.lang.String r11 = "start"
            java.lang.String r11 = com.adcolony.sdk.C0746u.m908b(r3, r11)
            java.lang.String r12 = "end"
            java.lang.String r12 = com.adcolony.sdk.C0746u.m908b(r3, r12)
            java.lang.String r13 = "summary"
            java.lang.String r3 = com.adcolony.sdk.C0746u.m908b(r3, r13)
            java.lang.String r13 = ""
            if (r5 == 0) goto L_0x0078
            int r14 = r5.length()
            if (r14 <= 0) goto L_0x0078
            java.lang.String r6 = "expires"
            java.lang.String r6 = com.adcolony.sdk.C0746u.m908b(r5, r6)
            java.lang.String r7 = "frequency"
            java.lang.String r7 = com.adcolony.sdk.C0746u.m908b(r5, r7)
            java.util.Locale r8 = java.util.Locale.getDefault()
            java.lang.String r7 = r7.toUpperCase(r8)
            java.lang.String r8 = "daysInWeek"
            org.json.JSONArray r8 = com.adcolony.sdk.C0746u.m922g(r5, r8)
            java.lang.String r14 = "daysInMonth"
            org.json.JSONArray r14 = com.adcolony.sdk.C0746u.m922g(r5, r14)
            java.lang.String r15 = "daysInYear"
            org.json.JSONArray r15 = com.adcolony.sdk.C0746u.m922g(r5, r15)
            goto L_0x007d
        L_0x0078:
            r14 = r7
            r15 = r8
            r7 = r13
            r8 = r6
            r6 = r7
        L_0x007d:
            boolean r13 = r3.equals(r13)
            if (r13 == 0) goto L_0x0084
            r3 = r10
        L_0x0084:
            java.util.Date r11 = com.adcolony.sdk.C0543at.m333h(r11)
            java.util.Date r12 = com.adcolony.sdk.C0543at.m333h(r12)
            java.util.Date r6 = com.adcolony.sdk.C0543at.m333h(r6)
            java.lang.String r13 = "success"
            if (r11 == 0) goto L_0x0206
            if (r12 != 0) goto L_0x0098
            goto L_0x0206
        L_0x0098:
            long r0 = r11.getTime()
            r16 = r13
            long r12 = r12.getTime()
            r17 = 0
            if (r6 == 0) goto L_0x00b5
            long r19 = r6.getTime()
            long r21 = r11.getTime()
            long r19 = r19 - r21
            r21 = 1000(0x3e8, double:4.94E-321)
            long r19 = r19 / r21
            goto L_0x00b7
        L_0x00b5:
            r19 = r17
        L_0x00b7:
            java.lang.String r6 = "DAILY"
            boolean r6 = r7.equals(r6)
            r21 = 1
            if (r6 == 0) goto L_0x00cd
            r17 = 86400(0x15180, double:4.26873E-319)
            long r19 = r19 / r17
        L_0x00c6:
            long r17 = r19 + r21
        L_0x00c8:
            r19 = r12
            r11 = r17
            goto L_0x00f7
        L_0x00cd:
            java.lang.String r6 = "WEEKLY"
            boolean r6 = r7.equals(r6)
            if (r6 == 0) goto L_0x00db
            r17 = 604800(0x93a80, double:2.98811E-318)
            long r19 = r19 / r17
            goto L_0x00c6
        L_0x00db:
            java.lang.String r6 = "MONTHLY"
            boolean r6 = r7.equals(r6)
            if (r6 == 0) goto L_0x00e9
            r17 = 2629800(0x2820a8, double:1.299294E-317)
            long r19 = r19 / r17
            goto L_0x00c6
        L_0x00e9:
            java.lang.String r6 = "YEARLY"
            boolean r6 = r7.equals(r6)
            if (r6 == 0) goto L_0x00c8
            r17 = 31557600(0x1e187e0, double:1.5591526E-316)
            long r19 = r19 / r17
            goto L_0x00c6
        L_0x00f7:
            java.lang.String r6 = "endTime"
            java.lang.String r13 = "beginTime"
            r17 = r4
            java.lang.String r4 = "title"
            r18 = r2
            java.lang.String r2 = "vnd.android.cursor.item/event"
            r21 = r6
            java.lang.String r6 = "android.intent.action.EDIT"
            if (r5 == 0) goto L_0x01aa
            int r5 = r5.length()
            if (r5 <= 0) goto L_0x01aa
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r22 = r0
            java.lang.String r0 = "FREQ="
            r5.append(r0)
            r5.append(r7)
            java.lang.String r0 = ";COUNT="
            r5.append(r0)
            r5.append(r11)
            java.lang.String r0 = r5.toString()
            int r1 = r8.length()     // Catch:{ JSONException -> 0x0184 }
            if (r1 == 0) goto L_0x0148
            java.lang.String r1 = com.adcolony.sdk.C0543at.m302a(r8)     // Catch:{ JSONException -> 0x0184 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0184 }
            r5.<init>()     // Catch:{ JSONException -> 0x0184 }
            r5.append(r0)     // Catch:{ JSONException -> 0x0184 }
            java.lang.String r7 = ";BYDAY="
            r5.append(r7)     // Catch:{ JSONException -> 0x0184 }
            r5.append(r1)     // Catch:{ JSONException -> 0x0184 }
            java.lang.String r0 = r5.toString()     // Catch:{ JSONException -> 0x0184 }
        L_0x0148:
            int r1 = r14.length()     // Catch:{ JSONException -> 0x0184 }
            if (r1 == 0) goto L_0x0166
            java.lang.String r1 = com.adcolony.sdk.C0543at.m319b(r14)     // Catch:{ JSONException -> 0x0184 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0184 }
            r5.<init>()     // Catch:{ JSONException -> 0x0184 }
            r5.append(r0)     // Catch:{ JSONException -> 0x0184 }
            java.lang.String r7 = ";BYMONTHDAY="
            r5.append(r7)     // Catch:{ JSONException -> 0x0184 }
            r5.append(r1)     // Catch:{ JSONException -> 0x0184 }
            java.lang.String r0 = r5.toString()     // Catch:{ JSONException -> 0x0184 }
        L_0x0166:
            int r1 = r15.length()     // Catch:{ JSONException -> 0x0184 }
            if (r1 == 0) goto L_0x0184
            java.lang.String r1 = com.adcolony.sdk.C0543at.m319b(r15)     // Catch:{ JSONException -> 0x0184 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0184 }
            r5.<init>()     // Catch:{ JSONException -> 0x0184 }
            r5.append(r0)     // Catch:{ JSONException -> 0x0184 }
            java.lang.String r7 = ";BYYEARDAY="
            r5.append(r7)     // Catch:{ JSONException -> 0x0184 }
            r5.append(r1)     // Catch:{ JSONException -> 0x0184 }
            java.lang.String r0 = r5.toString()     // Catch:{ JSONException -> 0x0184 }
        L_0x0184:
            android.content.Intent r1 = new android.content.Intent
            r1.<init>(r6)
            android.content.Intent r1 = r1.setType(r2)
            android.content.Intent r1 = r1.putExtra(r4, r3)
            android.content.Intent r1 = r1.putExtra(r9, r10)
            r7 = r22
            android.content.Intent r1 = r1.putExtra(r13, r7)
            r11 = r19
            r5 = r21
            android.content.Intent r1 = r1.putExtra(r5, r11)
            java.lang.String r2 = "rrule"
            android.content.Intent r0 = r1.putExtra(r2, r0)
            goto L_0x01c8
        L_0x01aa:
            r7 = r0
            r11 = r19
            r5 = r21
            android.content.Intent r0 = new android.content.Intent
            r0.<init>(r6)
            android.content.Intent r0 = r0.setType(r2)
            android.content.Intent r0 = r0.putExtra(r4, r3)
            android.content.Intent r0 = r0.putExtra(r9, r10)
            android.content.Intent r0 = r0.putExtra(r13, r7)
            android.content.Intent r0 = r0.putExtra(r5, r11)
        L_0x01c8:
            boolean r0 = com.adcolony.sdk.C0543at.m306a(r0)
            if (r0 == 0) goto L_0x01ed
            r0 = 1
            r2 = r16
            r1 = r18
            com.adcolony.sdk.C0746u.m913b(r1, r2, r0)
            r3 = r25
            com.adcolony.sdk.ab r1 = r3.mo8216a(r1)
            r1.mo8217b()
            r4 = r24
            r1 = r17
            r4.mo8326a(r1)
            r4.mo8328b(r1)
            r4.m220c(r1)
            return r0
        L_0x01ed:
            r4 = r24
            r3 = r25
            r2 = r16
            r1 = r18
            r0 = 0
            java.lang.String r5 = "Unable to create Calendar Event."
            com.adcolony.sdk.C0543at.m311a(r5, r0)
            com.adcolony.sdk.C0746u.m913b(r1, r2, r0)
            com.adcolony.sdk.ab r1 = r3.mo8216a(r1)
            r1.mo8217b()
            return r0
        L_0x0206:
            r4 = r24
            r3 = r1
            r1 = r2
            r2 = r13
            r0 = 0
            java.lang.String r5 = "Unable to create Calendar Event"
            com.adcolony.sdk.C0543at.m311a(r5, r0)
            com.adcolony.sdk.C0746u.m913b(r1, r2, r0)
            com.adcolony.sdk.ab r1 = r3.mo8216a(r1)
            r1.mo8217b()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.C0511aq.mo8337j(com.adcolony.sdk.ab):boolean");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: k */
    public boolean mo8338k(C0480ab abVar) {
        JSONObject a = C0746u.m892a();
        String str = "name";
        String b = C0746u.m908b(abVar.mo8220c(), str);
        boolean a2 = C0543at.m310a(b);
        C0746u.m913b(a, "success", true);
        C0746u.m913b(a, "result", a2);
        C0746u.m902a(a, str, b);
        C0746u.m902a(a, NotificationCompat.CATEGORY_SERVICE, b);
        abVar.mo8216a(a).mo8217b();
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: l */
    public boolean mo8339l(C0480ab abVar) {
        return mo8338k(abVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: m */
    public boolean mo8340m(C0480ab abVar) {
        JSONObject a = C0746u.m892a();
        JSONObject c = abVar.mo8220c();
        Intent type = new Intent("android.intent.action.SEND").setType("text/plain");
        StringBuilder sb = new StringBuilder();
        sb.append(C0746u.m908b(c, ViewHierarchyConstants.TEXT_KEY));
        sb.append(" ");
        sb.append(C0746u.m908b(c, "url"));
        Intent putExtra = type.putExtra("android.intent.extra.TEXT", sb.toString());
        String b = C0746u.m908b(c, "ad_session_id");
        String str = "success";
        if (C0543at.m307a(putExtra, true)) {
            C0746u.m913b(a, str, true);
            abVar.mo8216a(a).mo8217b();
            mo8326a(b);
            mo8328b(b);
            m220c(b);
            return true;
        }
        C0543at.m311a("Unable to create social post.", 0);
        C0746u.m913b(a, str, false);
        abVar.mo8216a(a).mo8217b();
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8326a(String str) {
        C0595d l = C0476a.m77a().mo8578l();
        AdColonyInterstitial adColonyInterstitial = (AdColonyInterstitial) l.mo8509c().get(str);
        if (adColonyInterstitial == null || adColonyInterstitial.getListener() == null) {
            AdColonyAdView adColonyAdView = (AdColonyAdView) l.mo8512e().get(str);
            AdColonyAdViewListener listener = adColonyAdView != null ? adColonyAdView.getListener() : null;
            if (!(adColonyAdView == null || listener == null)) {
                listener.onLeftApplication(adColonyAdView);
            }
            return;
        }
        adColonyInterstitial.getListener().onLeftApplication(adColonyInterstitial);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo8328b(String str) {
        C0595d l = C0476a.m77a().mo8578l();
        AdColonyInterstitial adColonyInterstitial = (AdColonyInterstitial) l.mo8509c().get(str);
        if (adColonyInterstitial == null || adColonyInterstitial.getListener() == null) {
            AdColonyAdView adColonyAdView = (AdColonyAdView) l.mo8512e().get(str);
            AdColonyAdViewListener listener = adColonyAdView != null ? adColonyAdView.getListener() : null;
            if (!(adColonyAdView == null || listener == null)) {
                listener.onClicked(adColonyAdView);
            }
            return;
        }
        adColonyInterstitial.getListener().onClicked(adColonyInterstitial);
    }

    /* renamed from: c */
    private boolean m220c(@NonNull String str) {
        if (((AdColonyAdView) C0476a.m77a().mo8578l().mo8512e().get(str)) == null) {
            return false;
        }
        JSONObject a = C0746u.m892a();
        C0746u.m902a(a, "ad_session_id", str);
        new C0480ab("MRAID.on_event", 1, a).mo8217b();
        return true;
    }

    /* renamed from: d */
    private void m221d(final String str) {
        C0543at.f402b.execute(new Runnable() {
            public void run() {
                JSONObject a = C0746u.m892a();
                C0746u.m902a(a, "type", "open_hook");
                C0746u.m902a(a, "message", str);
                new C0480ab("CustomMessage.controller_send", 0, a).mo8217b();
            }
        });
    }
}
