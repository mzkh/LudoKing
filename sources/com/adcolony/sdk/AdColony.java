package com.adcolony.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import com.appsflyer.ServerParameters;
import com.google.ads.mediation.adcolony.AdColonyAdapterUtils;
import com.tapjoy.TapjoyConstants;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import org.json.JSONObject;

public class AdColony {

    /* renamed from: a */
    static ExecutorService f41a = Executors.newSingleThreadExecutor();

    public static boolean disable() {
        if (!C0476a.m87e()) {
            return false;
        }
        Context c = C0476a.m85c();
        if (c != null && (c instanceof C0578b)) {
            ((Activity) c).finish();
        }
        final C0666j a = C0476a.m77a();
        for (final AdColonyInterstitial adColonyInterstitial : a.mo8578l().mo8509c().values()) {
            C0543at.m309a((Runnable) new Runnable() {
                public void run() {
                    AdColonyInterstitialListener listener = adColonyInterstitial.getListener();
                    adColonyInterstitial.mo8130a(true);
                    if (listener != null) {
                        listener.onExpiring(adColonyInterstitial);
                    }
                }
            });
        }
        C0543at.m309a((Runnable) new Runnable() {
            public void run() {
                ArrayList arrayList = new ArrayList();
                Iterator it = a.mo8583q().mo8230c().iterator();
                while (it.hasNext()) {
                    arrayList.add((C0485ae) it.next());
                }
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    C0485ae aeVar = (C0485ae) it2.next();
                    a.mo8557a(aeVar.mo8236a());
                    if (aeVar instanceof C0557av) {
                        C0557av avVar = (C0557av) aeVar;
                        if (!avVar.mo8417m()) {
                            avVar.loadUrl("about:blank");
                            avVar.clearCache(true);
                            avVar.removeAllViews();
                            avVar.mo8404a(true);
                        }
                    }
                }
            }
        });
        C0476a.m77a().mo8556a(true);
        return true;
    }

    public static boolean configure(Activity activity, @NonNull String str, @NonNull String... strArr) {
        return m12a(activity, null, str, strArr);
    }

    public static boolean configure(Activity activity, AdColonyAppOptions adColonyAppOptions, @NonNull String str, @NonNull String... strArr) {
        return m12a(activity, adColonyAppOptions, str, strArr);
    }

    public static boolean configure(Application application, @NonNull String str, @NonNull String... strArr) {
        return configure(application, (AdColonyAppOptions) null, str, strArr);
    }

    public static boolean configure(Application application, AdColonyAppOptions adColonyAppOptions, @NonNull String str, @NonNull String... strArr) {
        return m12a(application, adColonyAppOptions, str, strArr);
    }

    /* renamed from: a */
    private static boolean m12a(Context context, AdColonyAppOptions adColonyAppOptions, @NonNull String str, @NonNull String... strArr) {
        String str2;
        if (C0491ah.m146a(0, null)) {
            new C0749a().mo8726a("Cannot configure AdColony; configuration mechanism requires 5 ").mo8726a("seconds between attempts.").mo8728a(C0748w.f1169e);
            return false;
        }
        if (context == null) {
            context = C0476a.m85c();
        }
        if (context == null) {
            new C0749a().mo8726a("Ignoring call to AdColony.configure() as the provided Activity or ").mo8726a("Application context is null and we do not currently hold a ").mo8726a("reference to either for our use.").mo8728a(C0748w.f1169e);
            return false;
        }
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        if (adColonyAppOptions == null) {
            adColonyAppOptions = new AdColonyAppOptions();
        }
        if (C0476a.m84b() && !C0746u.m918d(C0476a.m77a().mo8567d().mo8086d(), "reconfigurable")) {
            C0666j a = C0476a.m77a();
            if (!a.mo8567d().mo8083a().equals(str)) {
                new C0749a().mo8726a("Ignoring call to AdColony.configure() as the app id does not ").mo8726a("match what was used during the initial configuration.").mo8728a(C0748w.f1169e);
                return false;
            } else if (C0543at.m313a(strArr, a.mo8567d().mo8084b())) {
                new C0749a().mo8726a("Ignoring call to AdColony.configure() as the same zone ids ").mo8726a("were used during the previous configuration.").mo8728a(C0748w.f1169e);
                return true;
            }
        }
        adColonyAppOptions.mo8081a(str);
        adColonyAppOptions.mo8082a(strArr);
        adColonyAppOptions.mo8088f();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss:SSS", Locale.US);
        long currentTimeMillis = System.currentTimeMillis();
        String format = simpleDateFormat.format(new Date(currentTimeMillis));
        int i = 0;
        boolean z = true;
        while (true) {
            str2 = "";
            if (i >= strArr.length) {
                break;
            }
            if (strArr[i] != null && !strArr[i].equals(str2)) {
                z = false;
            }
            i++;
        }
        if (str.equals(str2) || z) {
            new C0749a().mo8726a("AdColony.configure() called with an empty app or zone id String.").mo8728a(C0748w.f1171g);
            return false;
        }
        C0476a.f150a = true;
        if (VERSION.SDK_INT < 14) {
            new C0749a().mo8726a("The minimum API level for the AdColony SDK is 14.").mo8728a(C0748w.f1169e);
            C0476a.m79a(context, adColonyAppOptions, true);
        } else {
            C0476a.m79a(context, adColonyAppOptions, false);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(C0476a.m77a().mo8581o().mo8314c());
        sb.append("/adc3/AppInfo");
        String sb2 = sb.toString();
        JSONObject a2 = C0746u.m892a();
        if (new File(sb2).exists()) {
            a2 = C0746u.m916c(sb2);
        }
        JSONObject a3 = C0746u.m892a();
        String str3 = "appId";
        String str4 = "zoneIds";
        if (C0746u.m908b(a2, str3).equals(str)) {
            C0746u.m903a(a3, str4, C0746u.m890a(C0746u.m922g(a2, str4), strArr, true));
            C0746u.m902a(a3, str3, str);
        } else {
            C0746u.m903a(a3, str4, C0746u.m891a(strArr));
            C0746u.m902a(a3, str3, str);
        }
        C0746u.m923h(a3, sb2);
        C0749a a4 = new C0749a().mo8726a("Configure: Total Time (ms): ");
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str2);
        sb3.append(System.currentTimeMillis() - currentTimeMillis);
        C0749a a5 = a4.mo8726a(sb3.toString());
        StringBuilder sb4 = new StringBuilder();
        sb4.append(" and started at ");
        sb4.append(format);
        a5.mo8726a(sb4.toString()).mo8728a(C0748w.f1170f);
        return true;
    }

    public static AdColonyZone getZone(@NonNull String str) {
        if (!C0476a.m87e()) {
            new C0749a().mo8726a("Ignoring call to AdColony.getZone() as AdColony has not yet been ").mo8726a("configured.").mo8728a(C0748w.f1169e);
            return null;
        }
        HashMap f = C0476a.m77a().mo8572f();
        if (f.containsKey(str)) {
            return (AdColonyZone) f.get(str);
        }
        AdColonyZone adColonyZone = new AdColonyZone(str);
        C0476a.m77a().mo8572f().put(str, adColonyZone);
        return adColonyZone;
    }

    public static boolean notifyIAPComplete(@NonNull String str, @NonNull String str2) {
        return notifyIAPComplete(str, str2, null, 0.0d);
    }

    public static boolean notifyIAPComplete(@NonNull String str, @NonNull String str2, String str3, @FloatRange(from = 0.0d) double d) {
        if (!C0476a.m87e()) {
            new C0749a().mo8726a("Ignoring call to notifyIAPComplete as AdColony has not yet been ").mo8726a("configured.").mo8728a(C0748w.f1169e);
            return false;
        } else if (!C0543at.m325d(str) || !C0543at.m325d(str2)) {
            new C0749a().mo8726a("Ignoring call to notifyIAPComplete as one of the passed Strings ").mo8726a("is greater than ").mo8724a(128).mo8726a(" characters.").mo8728a(C0748w.f1169e);
            return false;
        } else {
            if (str3 != null && str3.length() > 3) {
                new C0749a().mo8726a("You are trying to report an IAP event with a currency String ").mo8726a("containing more than 3 characters.").mo8728a(C0748w.f1169e);
            }
            final double d2 = d;
            final String str4 = str3;
            final String str5 = str;
            final String str6 = str2;
            C04685 r2 = new Runnable() {
                public void run() {
                    AdColony.m11a();
                    JSONObject a = C0746u.m892a();
                    double d = d2;
                    if (d >= 0.0d) {
                        C0746u.m900a(a, "price", d);
                    }
                    String str = str4;
                    if (str != null && str.length() <= 3) {
                        C0746u.m902a(a, "currency_code", str4);
                    }
                    C0746u.m902a(a, "product_id", str5);
                    C0746u.m902a(a, "transaction_id", str6);
                    new C0480ab("AdColony.on_iap_report", 1, a).mo8217b();
                }
            };
            f41a.execute(r2);
            return true;
        }
    }

    public static boolean requestAdView(@NonNull String str, @NonNull AdColonyAdViewListener adColonyAdViewListener, @NonNull AdColonyAdSize adColonyAdSize) {
        return requestAdView(str, adColonyAdViewListener, adColonyAdSize, null);
    }

    public static boolean requestAdView(@NonNull final String str, @NonNull final AdColonyAdViewListener adColonyAdViewListener, @NonNull final AdColonyAdSize adColonyAdSize, final AdColonyAdOptions adColonyAdOptions) {
        if (!C0476a.m87e()) {
            new C0749a().mo8726a("Ignoring call to requestAdView as AdColony has not yet been").mo8726a(" configured.").mo8728a(C0748w.f1169e);
            m13a(adColonyAdViewListener, str);
            return false;
        } else if (adColonyAdSize.getHeight() <= 0 || adColonyAdSize.getWidth() <= 0) {
            new C0749a().mo8726a("Ignoring call to requestAdView as you've provided an AdColonyAdSize").mo8726a(" object with an invalid width or height.").mo8728a(C0748w.f1169e);
            return false;
        } else {
            Bundle bundle = new Bundle();
            bundle.putString(AdColonyAdapterUtils.KEY_ZONE_ID, str);
            if (C0491ah.m146a(1, bundle)) {
                m13a(adColonyAdViewListener, str);
                return false;
            }
            try {
                f41a.execute(new Runnable() {
                    public void run() {
                        C0666j a = C0476a.m77a();
                        if (a.mo8573g() || a.mo8574h()) {
                            AdColony.m15b();
                            AdColony.m13a(adColonyAdViewListener, str);
                        }
                        if (!AdColony.m11a() && C0476a.m86d()) {
                            AdColony.m13a(adColonyAdViewListener, str);
                        }
                        if (((AdColonyZone) a.mo8572f().get(str)) == null) {
                            new AdColonyZone(str);
                            new C0749a().mo8726a("Zone info for ").mo8726a(str).mo8726a(" doesn't exist in hashmap").mo8728a(C0748w.f1166b);
                        }
                        a.mo8578l().mo8503a(str, adColonyAdViewListener, adColonyAdSize, adColonyAdOptions);
                    }
                });
                return true;
            } catch (RejectedExecutionException unused) {
                m13a(adColonyAdViewListener, str);
                return false;
            }
        }
    }

    public static boolean setAppOptions(@NonNull final AdColonyAppOptions adColonyAppOptions) {
        if (!C0476a.m87e()) {
            new C0749a().mo8726a("Ignoring call to AdColony.setAppOptions() as AdColony has not yet").mo8726a(" been configured.").mo8728a(C0748w.f1169e);
            return false;
        }
        C0476a.m77a().mo8561b(adColonyAppOptions);
        adColonyAppOptions.mo8088f();
        try {
            f41a.execute(new Runnable() {
                public void run() {
                    AdColony.m11a();
                    JSONObject a = C0746u.m892a();
                    C0746u.m904a(a, "options", adColonyAppOptions.mo8086d());
                    new C0480ab("Options.set_options", 1, a).mo8217b();
                }
            });
            return true;
        } catch (RejectedExecutionException unused) {
            return false;
        }
    }

    public static AdColonyAppOptions getAppOptions() {
        if (!C0476a.m87e()) {
            return null;
        }
        return C0476a.m77a().mo8567d();
    }

    public static boolean setRewardListener(@NonNull AdColonyRewardListener adColonyRewardListener) {
        if (!C0476a.m87e()) {
            new C0749a().mo8726a("Ignoring call to AdColony.setRewardListener() as AdColony has not").mo8726a(" yet been configured.").mo8728a(C0748w.f1169e);
            return false;
        }
        C0476a.m77a().mo8552a(adColonyRewardListener);
        return true;
    }

    public static boolean removeRewardListener() {
        if (!C0476a.m87e()) {
            new C0749a().mo8726a("Ignoring call to AdColony.removeRewardListener() as AdColony has ").mo8726a("not yet been configured.").mo8728a(C0748w.f1169e);
            return false;
        }
        C0476a.m77a().mo8552a((AdColonyRewardListener) null);
        return true;
    }

    public static String getSDKVersion() {
        if (!C0476a.m87e()) {
            return "";
        }
        return C0476a.m77a().mo8579m().mo8615F();
    }

    public static AdColonyRewardListener getRewardListener() {
        if (!C0476a.m87e()) {
            return null;
        }
        return C0476a.m77a().mo8575i();
    }

    public static boolean addCustomMessageListener(@NonNull AdColonyCustomMessageListener adColonyCustomMessageListener, final String str) {
        if (!C0476a.m87e()) {
            new C0749a().mo8726a("Ignoring call to AdColony.addCustomMessageListener as AdColony ").mo8726a("has not yet been configured.").mo8728a(C0748w.f1169e);
            return false;
        } else if (!C0543at.m325d(str)) {
            new C0749a().mo8726a("Ignoring call to AdColony.addCustomMessageListener.").mo8728a(C0748w.f1169e);
            return false;
        } else {
            try {
                C0476a.m77a().mo8544A().put(str, adColonyCustomMessageListener);
                f41a.execute(new Runnable() {
                    public void run() {
                        AdColony.m11a();
                        JSONObject a = C0746u.m892a();
                        C0746u.m902a(a, "type", str);
                        new C0480ab("CustomMessage.register", 1, a).mo8217b();
                    }
                });
                return true;
            } catch (RejectedExecutionException unused) {
                return false;
            }
        }
    }

    public static AdColonyCustomMessageListener getCustomMessageListener(@NonNull String str) {
        if (!C0476a.m87e()) {
            return null;
        }
        return (AdColonyCustomMessageListener) C0476a.m77a().mo8544A().get(str);
    }

    public static boolean removeCustomMessageListener(@NonNull final String str) {
        if (!C0476a.m87e()) {
            new C0749a().mo8726a("Ignoring call to AdColony.removeCustomMessageListener as AdColony").mo8726a(" has not yet been configured.").mo8728a(C0748w.f1169e);
            return false;
        }
        C0476a.m77a().mo8544A().remove(str);
        f41a.execute(new Runnable() {
            public void run() {
                AdColony.m11a();
                JSONObject a = C0746u.m892a();
                C0746u.m902a(a, "type", str);
                new C0480ab("CustomMessage.unregister", 1, a).mo8217b();
            }
        });
        return true;
    }

    public static boolean clearCustomMessageListeners() {
        if (!C0476a.m87e()) {
            new C0749a().mo8726a("Ignoring call to AdColony.clearCustomMessageListeners as AdColony").mo8726a(" has not yet been configured.").mo8728a(C0748w.f1169e);
            return false;
        }
        C0476a.m77a().mo8544A().clear();
        f41a.execute(new Runnable() {
            public void run() {
                AdColony.m11a();
                for (String str : C0476a.m77a().mo8544A().keySet()) {
                    JSONObject a = C0746u.m892a();
                    C0746u.m902a(a, "type", str);
                    new C0480ab("CustomMessage.unregister", 1, a).mo8217b();
                }
            }
        });
        return true;
    }

    public static boolean requestInterstitial(@NonNull String str, @NonNull AdColonyInterstitialListener adColonyInterstitialListener) {
        return requestInterstitial(str, adColonyInterstitialListener, null);
    }

    public static boolean requestInterstitial(@NonNull final String str, @NonNull final AdColonyInterstitialListener adColonyInterstitialListener, final AdColonyAdOptions adColonyAdOptions) {
        if (!C0476a.m87e()) {
            new C0749a().mo8726a("Ignoring call to AdColony.requestInterstitial as AdColony has not").mo8726a(" yet been configured.").mo8728a(C0748w.f1169e);
            adColonyInterstitialListener.onRequestNotFilled(new AdColonyZone(str));
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putString(AdColonyAdapterUtils.KEY_ZONE_ID, str);
        if (C0491ah.m146a(1, bundle)) {
            AdColonyZone adColonyZone = (AdColonyZone) C0476a.m77a().mo8572f().get(str);
            if (adColonyZone == null) {
                adColonyZone = new AdColonyZone(str);
                C0749a a = new C0749a().mo8726a("Zone info for ");
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(" doesn't exist in hashmap");
                a.mo8726a(sb.toString()).mo8728a(C0748w.f1166b);
            }
            adColonyInterstitialListener.onRequestNotFilled(adColonyZone);
            return false;
        }
        try {
            f41a.execute(new Runnable() {
                public void run() {
                    C0666j a = C0476a.m77a();
                    if (a.mo8573g() || a.mo8574h()) {
                        AdColony.m15b();
                        AdColony.m14a(adColonyInterstitialListener, str);
                    } else if (AdColony.m11a() || !C0476a.m86d()) {
                        final AdColonyZone adColonyZone = (AdColonyZone) a.mo8572f().get(str);
                        if (adColonyZone == null) {
                            adColonyZone = new AdColonyZone(str);
                            C0749a a2 = new C0749a().mo8726a("Zone info for ");
                            StringBuilder sb = new StringBuilder();
                            sb.append(str);
                            sb.append(" doesn't exist in hashmap");
                            a2.mo8726a(sb.toString()).mo8728a(C0748w.f1166b);
                        }
                        if (adColonyZone.getZoneType() == 2 || adColonyZone.getZoneType() == 1) {
                            C0543at.m309a((Runnable) new Runnable() {
                                public void run() {
                                    adColonyInterstitialListener.onRequestNotFilled(adColonyZone);
                                }
                            });
                        } else {
                            a.mo8578l().mo8504a(str, adColonyInterstitialListener, adColonyAdOptions);
                        }
                    } else {
                        AdColony.m14a(adColonyInterstitialListener, str);
                    }
                }
            });
            return true;
        } catch (RejectedExecutionException unused) {
            m14a(adColonyInterstitialListener, str);
            return false;
        }
    }

    /* renamed from: a */
    static boolean m11a() {
        C0545a aVar = new C0545a(15.0d);
        C0666j a = C0476a.m77a();
        while (!a.mo8545B() && !aVar.mo8374b()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException unused) {
            }
        }
        return a.mo8545B();
    }

    /* renamed from: a */
    static boolean m14a(final AdColonyInterstitialListener adColonyInterstitialListener, final String str) {
        if (adColonyInterstitialListener != null && C0476a.m86d()) {
            C0543at.m309a((Runnable) new Runnable() {
                public void run() {
                    AdColonyZone adColonyZone = (AdColonyZone) C0476a.m77a().mo8572f().get(str);
                    if (adColonyZone == null) {
                        adColonyZone = new AdColonyZone(str);
                    }
                    adColonyInterstitialListener.onRequestNotFilled(adColonyZone);
                }
            });
        }
        return false;
    }

    /* renamed from: a */
    static boolean m13a(final AdColonyAdViewListener adColonyAdViewListener, final String str) {
        if (adColonyAdViewListener != null && C0476a.m86d()) {
            C0543at.m309a((Runnable) new Runnable() {
                public void run() {
                    AdColonyZone adColonyZone;
                    if (!C0476a.m84b()) {
                        adColonyZone = null;
                    } else {
                        adColonyZone = (AdColonyZone) C0476a.m77a().mo8572f().get(str);
                    }
                    if (adColonyZone == null) {
                        adColonyZone = new AdColonyZone(str);
                    }
                    adColonyAdViewListener.onRequestNotFilled(adColonyZone);
                }
            });
        }
        return false;
    }

    /* renamed from: a */
    static void m10a(Context context, AdColonyAppOptions adColonyAppOptions) {
        if (adColonyAppOptions != null && context != null) {
            String b = C0543at.m318b(context);
            String b2 = C0543at.m317b();
            int c = C0543at.m320c();
            String i = C0476a.m77a().mo8579m().mo8633i();
            String str = C0476a.m77a().mo8582p().mo8241a() ? TapjoyConstants.TJC_CONNECTION_TYPE_WIFI : C0476a.m77a().mo8582p().mo8242b() ? TapjoyConstants.TJC_CONNECTION_TYPE_MOBILE : "none";
            HashMap hashMap = new HashMap();
            String str2 = "unknown";
            hashMap.put("sessionId", str2);
            hashMap.put(ServerParameters.ADVERTISING_ID_PARAM, str2);
            StringBuilder sb = new StringBuilder();
            sb.append(Locale.getDefault().getDisplayLanguage());
            sb.append(" (");
            sb.append(Locale.getDefault().getDisplayCountry());
            sb.append(")");
            hashMap.put("countryLocale", sb.toString());
            hashMap.put("countryLocalShort", C0476a.m77a().mo8579m().mo8647w());
            hashMap.put("manufacturer", C0476a.m77a().mo8579m().mo8650z());
            hashMap.put("model", C0476a.m77a().mo8579m().mo8610A());
            hashMap.put("osVersion", C0476a.m77a().mo8579m().mo8611B());
            hashMap.put("carrierName", i);
            hashMap.put("networkType", str);
            hashMap.put(TapjoyConstants.TJC_PLATFORM, "android");
            hashMap.put("appName", b);
            hashMap.put("appVersion", b2);
            hashMap.put("appBuildNumber", Integer.valueOf(c));
            StringBuilder sb2 = new StringBuilder();
            String str3 = "";
            sb2.append(str3);
            sb2.append(adColonyAppOptions.mo8083a());
            hashMap.put("appId", sb2.toString());
            hashMap.put("apiLevel", Integer.valueOf(VERSION.SDK_INT));
            hashMap.put("sdkVersion", C0476a.m77a().mo8579m().mo8615F());
            hashMap.put("controllerVersion", str2);
            hashMap.put("zoneIds", adColonyAppOptions.mo8085c());
            JSONObject mediationInfo = adColonyAppOptions.getMediationInfo();
            JSONObject pluginInfo = adColonyAppOptions.getPluginInfo();
            String str4 = "mediation_network";
            if (!C0746u.m908b(mediationInfo, str4).equals(str3)) {
                hashMap.put("mediationNetwork", C0746u.m908b(mediationInfo, str4));
                hashMap.put("mediationNetworkVersion", C0746u.m908b(mediationInfo, "mediation_network_version"));
            }
            String str5 = TapjoyConstants.TJC_PLUGIN;
            if (!C0746u.m908b(pluginInfo, str5).equals(str3)) {
                hashMap.put(str5, C0746u.m908b(pluginInfo, str5));
                hashMap.put("pluginVersion", C0746u.m908b(pluginInfo, "plugin_version"));
            }
            C0752y.m956a(hashMap);
        }
    }

    /* renamed from: b */
    static void m15b() {
        new C0749a().mo8726a("The AdColony API is not available while AdColony is disabled.").mo8728a(C0748w.f1171g);
    }
}
