package com.appsflyer.share;

import android.content.Context;
import android.os.AsyncTask;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.ServerConfigHandler;
import com.appsflyer.ServerParameters;
import com.appsflyer.internal.C1357an;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class CrossPromotionHelper {

    /* renamed from: com.appsflyer.share.CrossPromotionHelper$a */
    static class C1397a extends AsyncTask<String, Void, Void> {

        /* renamed from: ˊ */
        private boolean f3641;

        /* renamed from: ˋ */
        private C1357an f3642;

        /* renamed from: ॱ */
        private WeakReference<Context> f3643;

        C1397a(C1357an anVar, Context context, boolean z) {
            this.f3642 = anVar;
            this.f3643 = new WeakReference<>(context);
            this.f3641 = z;
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x009c, code lost:
            if (r2 != null) goto L_0x00b0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x00ae, code lost:
            if (r2 != null) goto L_0x00b0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x00b0, code lost:
            r2.disconnect();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x00b3, code lost:
            return null;
         */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x00b7  */
        /* renamed from: ˋ */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Void doInBackground(java.lang.String... r6) {
            /*
                r5 = this;
                boolean r0 = r5.f3641
                r1 = 0
                if (r0 == 0) goto L_0x0006
                return r1
            L_0x0006:
                r0 = 0
                r6 = r6[r0]     // Catch:{ Throwable -> 0x00a4, all -> 0x00a1 }
                java.net.URL r2 = new java.net.URL     // Catch:{ Throwable -> 0x00a4, all -> 0x00a1 }
                r2.<init>(r6)     // Catch:{ Throwable -> 0x00a4, all -> 0x00a1 }
                java.net.URLConnection r2 = r2.openConnection()     // Catch:{ Throwable -> 0x00a4, all -> 0x00a1 }
                java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ Throwable -> 0x00a4, all -> 0x00a1 }
                r3 = 10000(0x2710, float:1.4013E-41)
                r2.setConnectTimeout(r3)     // Catch:{ Throwable -> 0x009f }
                r2.setInstanceFollowRedirects(r0)     // Catch:{ Throwable -> 0x009f }
                int r3 = r2.getResponseCode()     // Catch:{ Throwable -> 0x009f }
                r4 = 200(0xc8, float:2.8E-43)
                if (r3 != r4) goto L_0x0032
                java.lang.String r3 = "Cross promotion impressions success: "
                java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ Throwable -> 0x009f }
                java.lang.String r6 = r3.concat(r6)     // Catch:{ Throwable -> 0x009f }
                com.appsflyer.AFLogger.afInfoLog(r6, r0)     // Catch:{ Throwable -> 0x009f }
                goto L_0x009c
            L_0x0032:
                r4 = 301(0x12d, float:4.22E-43)
                if (r3 == r4) goto L_0x0055
                r4 = 302(0x12e, float:4.23E-43)
                if (r3 != r4) goto L_0x003b
                goto L_0x0055
            L_0x003b:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x009f }
                java.lang.String r4 = "call to "
                r0.<init>(r4)     // Catch:{ Throwable -> 0x009f }
                r0.append(r6)     // Catch:{ Throwable -> 0x009f }
                java.lang.String r6 = " failed: "
                r0.append(r6)     // Catch:{ Throwable -> 0x009f }
                r0.append(r3)     // Catch:{ Throwable -> 0x009f }
                java.lang.String r6 = r0.toString()     // Catch:{ Throwable -> 0x009f }
                com.appsflyer.AFLogger.afInfoLog(r6)     // Catch:{ Throwable -> 0x009f }
                goto L_0x009c
            L_0x0055:
                java.lang.String r3 = "Cross promotion redirection success: "
                java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ Throwable -> 0x009f }
                java.lang.String r6 = r3.concat(r6)     // Catch:{ Throwable -> 0x009f }
                com.appsflyer.AFLogger.afInfoLog(r6, r0)     // Catch:{ Throwable -> 0x009f }
                com.appsflyer.internal.an r6 = r5.f3642     // Catch:{ Throwable -> 0x009f }
                if (r6 == 0) goto L_0x009c
                java.lang.ref.WeakReference<android.content.Context> r6 = r5.f3643     // Catch:{ Throwable -> 0x009f }
                java.lang.Object r6 = r6.get()     // Catch:{ Throwable -> 0x009f }
                if (r6 == 0) goto L_0x009c
                java.lang.String r6 = "Location"
                java.lang.String r6 = r2.getHeaderField(r6)     // Catch:{ Throwable -> 0x009f }
                com.appsflyer.internal.an r0 = r5.f3642     // Catch:{ Throwable -> 0x009f }
                r0.f3500 = r6     // Catch:{ Throwable -> 0x009f }
                com.appsflyer.internal.an r6 = r5.f3642     // Catch:{ Throwable -> 0x009f }
                java.lang.ref.WeakReference<android.content.Context> r0 = r5.f3643     // Catch:{ Throwable -> 0x009f }
                java.lang.Object r0 = r0.get()     // Catch:{ Throwable -> 0x009f }
                android.content.Context r0 = (android.content.Context) r0     // Catch:{ Throwable -> 0x009f }
                java.lang.String r3 = r6.f3500     // Catch:{ Throwable -> 0x009f }
                if (r3 == 0) goto L_0x009c
                android.content.Intent r3 = new android.content.Intent     // Catch:{ Throwable -> 0x009f }
                java.lang.String r4 = "android.intent.action.VIEW"
                java.lang.String r6 = r6.f3500     // Catch:{ Throwable -> 0x009f }
                android.net.Uri r6 = android.net.Uri.parse(r6)     // Catch:{ Throwable -> 0x009f }
                r3.<init>(r4, r6)     // Catch:{ Throwable -> 0x009f }
                r6 = 268435456(0x10000000, float:2.5243549E-29)
                android.content.Intent r6 = r3.setFlags(r6)     // Catch:{ Throwable -> 0x009f }
                r0.startActivity(r6)     // Catch:{ Throwable -> 0x009f }
            L_0x009c:
                if (r2 == 0) goto L_0x00b3
                goto L_0x00b0
            L_0x009f:
                r6 = move-exception
                goto L_0x00a6
            L_0x00a1:
                r6 = move-exception
                r2 = r1
                goto L_0x00b5
            L_0x00a4:
                r6 = move-exception
                r2 = r1
            L_0x00a6:
                java.lang.String r0 = r6.getMessage()     // Catch:{ all -> 0x00b4 }
                r3 = 1
                com.appsflyer.AFLogger.afErrorLog(r0, r6, r3)     // Catch:{ all -> 0x00b4 }
                if (r2 == 0) goto L_0x00b3
            L_0x00b0:
                r2.disconnect()
            L_0x00b3:
                return r1
            L_0x00b4:
                r6 = move-exception
            L_0x00b5:
                if (r2 == 0) goto L_0x00ba
                r2.disconnect()
            L_0x00ba:
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.share.CrossPromotionHelper.C1397a.doInBackground(java.lang.String[]):java.lang.Void");
        }
    }

    public static void trackAndOpenStore(Context context, String str, String str2) {
        trackAndOpenStore(context, str, str2, null);
    }

    public static void trackAndOpenStore(Context context, String str, String str2, Map<String, String> map) {
        LinkGenerator r4 = m3371(context, str, str2, map, ServerConfigHandler.getUrl(Constants.BASE_URL_APP_APPSFLYER_COM));
        if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false)) {
            AFLogger.afInfoLog("CustomerUserId not set, track And Open Store is disabled", true);
            return;
        }
        HashMap hashMap = new HashMap();
        if (map != null) {
            hashMap.putAll(map);
        }
        hashMap.put("af_campaign", str2);
        AppsFlyerLib.getInstance().trackEvent(context, "af_cross_promotion", hashMap);
        new C1397a(new C1357an(), context, AppsFlyerLib.getInstance().isTrackingStopped()).execute(new String[]{r4.generateLink()});
    }

    public static void trackCrossPromoteImpression(Context context, String str, String str2) {
        if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false)) {
            AFLogger.afInfoLog("CustomerUserId not set, Promote Impression is disabled", true);
            return;
        }
        LinkGenerator r4 = m3371(context, str, str2, null, ServerConfigHandler.getUrl("https://%simpression.%s"));
        new C1397a(null, null, AppsFlyerLib.getInstance().isTrackingStopped()).execute(new String[]{r4.generateLink()});
    }

    /* renamed from: ˊ */
    private static LinkGenerator m3371(Context context, String str, String str2, Map<String, String> map, String str3) {
        LinkGenerator linkGenerator = new LinkGenerator("af_cross_promotion");
        linkGenerator.f3647 = str3;
        linkGenerator.f3649 = str;
        linkGenerator.addParameter(Constants.URL_SITE_ID, context.getPackageName());
        if (str2 != null) {
            linkGenerator.setCampaign(str2);
        }
        if (map != null) {
            linkGenerator.addParameters(map);
        }
        String string = AppsFlyerProperties.getInstance().getString(ServerParameters.ADVERTISING_ID_PARAM);
        if (string != null) {
            linkGenerator.addParameter("advertising_id", string);
        }
        return linkGenerator;
    }
}
