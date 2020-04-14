package com.applovin.impl.sdk.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.C1205l;
import com.applovin.impl.sdk.C1227o;
import com.applovin.impl.sdk.p018ad.C1082d;
import com.applovin.impl.sdk.p018ad.C1087g;
import com.applovin.impl.sdk.p019b.C1096c;
import com.applovin.impl.sdk.p020c.C1101a;
import com.applovin.impl.sdk.p020c.C1113g;
import com.applovin.impl.sdk.p021d.C1159r.C1161a;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinSdk;
import com.facebook.appevents.AppEventsConstants;
import com.google.ads.mediation.adcolony.AdColonyAdapterUtils;
import com.google.android.gms.drive.DriveFile;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.utils.o */
public abstract class C1281o {

    /* renamed from: a */
    private static ApplicationInfo f3222a;

    /* renamed from: b */
    private static Boolean f3223b;

    /* renamed from: a */
    public static double m3061a(long j) {
        double d = (double) j;
        Double.isNaN(d);
        return d / 1000.0d;
    }

    /* renamed from: a */
    public static float m3062a(float f) {
        return f * 1000.0f;
    }

    /* renamed from: a */
    public static int m3063a(JSONObject jSONObject) {
        int b = C1247h.m2984b(jSONObject, "video_completion_percent", -1, (C1192i) null);
        if (b < 0 || b > 100) {
            return 95;
        }
        return b;
    }

    /* renamed from: a */
    public static long m3064a(C1192i iVar) {
        long longValue = ((Long) iVar.mo10202a(C1096c.f2509eO)).longValue();
        long longValue2 = ((Long) iVar.mo10202a(C1096c.f2510eP)).longValue();
        long currentTimeMillis = System.currentTimeMillis();
        return (longValue <= 0 || longValue2 <= 0) ? currentTimeMillis : currentTimeMillis + (longValue - longValue2);
    }

    /* renamed from: a */
    public static Activity m3065a(View view, C1192i iVar) {
        if (view == null) {
            return null;
        }
        int i = 0;
        while (i < 1000) {
            i++;
            try {
                Context context = view.getContext();
                if (context instanceof Activity) {
                    return (Activity) context;
                }
                ViewParent parent = view.getParent();
                if (!(parent instanceof View)) {
                    return null;
                }
                view = (View) parent;
            } catch (Throwable th) {
                iVar.mo10249v().mo10379b("Utils", "Encountered error while retrieving activity from view", th);
            }
        }
        return null;
    }

    /* renamed from: a */
    public static Bitmap m3066a(Context context, int i, int i2) {
        try {
            Options options = new Options();
            int i3 = 1;
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(context.getResources(), i);
            if (options.outHeight > i2 || options.outWidth > i2) {
                double d = (double) i2;
                double max = (double) Math.max(options.outHeight, options.outWidth);
                Double.isNaN(d);
                Double.isNaN(max);
                i3 = (int) Math.pow(2.0d, (double) ((int) Math.ceil(Math.log(d / max) / Math.log(0.5d))));
            }
            new Options().inSampleSize = i3;
            return BitmapFactory.decodeResource(context.getResources(), i);
        } catch (Exception unused) {
            return null;
        } finally {
            m3083a((Closeable) null, (C1192i) null);
            m3083a((Closeable) null, (C1192i) null);
        }
    }

    /* renamed from: a */
    public static Bitmap m3067a(File file, int i) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        Options options;
        try {
            Options options2 = new Options();
            int i2 = 1;
            options2.inJustDecodeBounds = true;
            fileInputStream = new FileInputStream(file);
            try {
                BitmapFactory.decodeStream(fileInputStream, null, options2);
                fileInputStream.close();
                if (options2.outHeight > i || options2.outWidth > i) {
                    double d = (double) i;
                    double max = (double) Math.max(options2.outHeight, options2.outWidth);
                    Double.isNaN(d);
                    Double.isNaN(max);
                    i2 = (int) Math.pow(2.0d, (double) ((int) Math.ceil(Math.log(d / max) / Math.log(0.5d))));
                }
                options = new Options();
                options.inSampleSize = i2;
                fileInputStream2 = new FileInputStream(file);
            } catch (Exception unused) {
                fileInputStream2 = null;
                m3083a((Closeable) fileInputStream, (C1192i) null);
                m3083a((Closeable) fileInputStream2, (C1192i) null);
                return null;
            } catch (Throwable th) {
                th = th;
                fileInputStream2 = null;
                m3083a((Closeable) fileInputStream, (C1192i) null);
                m3083a((Closeable) fileInputStream2, (C1192i) null);
                throw th;
            }
            try {
                Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream2, null, options);
                fileInputStream2.close();
                m3083a((Closeable) fileInputStream, (C1192i) null);
                m3083a((Closeable) fileInputStream2, (C1192i) null);
                return decodeStream;
            } catch (Exception unused2) {
                m3083a((Closeable) fileInputStream, (C1192i) null);
                m3083a((Closeable) fileInputStream2, (C1192i) null);
                return null;
            } catch (Throwable th2) {
                th = th2;
                m3083a((Closeable) fileInputStream, (C1192i) null);
                m3083a((Closeable) fileInputStream2, (C1192i) null);
                throw th;
            }
        } catch (Exception unused3) {
            fileInputStream2 = null;
            fileInputStream = null;
            m3083a((Closeable) fileInputStream, (C1192i) null);
            m3083a((Closeable) fileInputStream2, (C1192i) null);
            return null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream2 = null;
            fileInputStream = null;
            m3083a((Closeable) fileInputStream, (C1192i) null);
            m3083a((Closeable) fileInputStream2, (C1192i) null);
            throw th;
        }
    }

    /* renamed from: a */
    public static View m3068a(Context context, View view) {
        View e = m3111e(context);
        return e != null ? e : m3069a(view);
    }

    /* renamed from: a */
    public static View m3069a(View view) {
        if (view == null) {
            return null;
        }
        View rootView = view.getRootView();
        if (rootView == null) {
            return null;
        }
        View findViewById = rootView.findViewById(16908290);
        if (findViewById != null) {
            rootView = findViewById;
        }
        return rootView;
    }

    /* renamed from: a */
    public static C1082d m3070a(JSONObject jSONObject, C1192i iVar) {
        return C1082d.m1997a(AppLovinAdSize.fromString(C1247h.m2985b(jSONObject, "ad_size", (String) null, iVar)), AppLovinAdType.fromString(C1247h.m2985b(jSONObject, AppEventsConstants.EVENT_PARAM_AD_TYPE, (String) null, iVar)), C1247h.m2985b(jSONObject, AdColonyAdapterUtils.KEY_ZONE_ID, (String) null, iVar), iVar);
    }

    /* renamed from: a */
    public static C1192i m3071a(AppLovinSdk appLovinSdk) {
        try {
            Field declaredField = appLovinSdk.getClass().getDeclaredField("mSdkImpl");
            declaredField.setAccessible(true);
            return (C1192i) declaredField.get(appLovinSdk);
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("Internal error - unable to retrieve SDK implementation: ");
            sb.append(th);
            throw new IllegalStateException(sb.toString());
        }
    }

    /* renamed from: a */
    public static AppLovinAd m3072a(AppLovinAd appLovinAd, C1192i iVar) {
        if (appLovinAd instanceof C1087g) {
            C1087g gVar = (C1087g) appLovinAd;
            AppLovinAd dequeueAd = iVar.mo10241o().dequeueAd(gVar.getAdZone());
            C1227o v = iVar.mo10249v();
            StringBuilder sb = new StringBuilder();
            sb.append("Dequeued ad for dummy ad: ");
            sb.append(dequeueAd);
            v.mo10378b("Utils", sb.toString());
            if (dequeueAd != null) {
                gVar.mo9939a(dequeueAd);
                ((AppLovinAdBase) dequeueAd).setDummyAd(gVar);
                return dequeueAd;
            }
            appLovinAd = gVar.mo9938a();
        }
        return appLovinAd;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x008f, code lost:
        if (r0.length() > r4) goto L_0x00aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a8, code lost:
        if (r0.length() > r4) goto L_0x00aa;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object m3073a(java.lang.Object r4, com.applovin.impl.sdk.C1192i r5) {
        /*
            boolean r0 = r4 instanceof java.util.Map
            if (r0 == 0) goto L_0x003f
            java.util.Map r4 = (java.util.Map) r4
            java.util.HashMap r0 = new java.util.HashMap
            int r1 = r4.size()
            r0.<init>(r1)
            java.util.Set r4 = r4.entrySet()
            java.util.Iterator r4 = r4.iterator()
        L_0x0017:
            boolean r1 = r4.hasNext()
            if (r1 == 0) goto L_0x003e
            java.lang.Object r1 = r4.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            boolean r3 = r2 instanceof java.lang.String
            if (r3 == 0) goto L_0x002e
            java.lang.String r2 = (java.lang.String) r2
            goto L_0x0032
        L_0x002e:
            java.lang.String r2 = java.lang.String.valueOf(r2)
        L_0x0032:
            java.lang.Object r1 = r1.getValue()
            java.lang.Object r1 = m3073a(r1, r5)
            r0.put(r2, r1)
            goto L_0x0017
        L_0x003e:
            return r0
        L_0x003f:
            boolean r0 = r4 instanceof java.util.List
            if (r0 == 0) goto L_0x0065
            java.util.List r4 = (java.util.List) r4
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r4.size()
            r0.<init>(r1)
            java.util.Iterator r4 = r4.iterator()
        L_0x0052:
            boolean r1 = r4.hasNext()
            if (r1 == 0) goto L_0x0064
            java.lang.Object r1 = r4.next()
            java.lang.Object r1 = m3073a(r1, r5)
            r0.add(r1)
            goto L_0x0052
        L_0x0064:
            return r0
        L_0x0065:
            boolean r0 = r4 instanceof java.util.Date
            if (r0 == 0) goto L_0x0074
            java.util.Date r4 = (java.util.Date) r4
            long r4 = r4.getTime()
            java.lang.String r4 = java.lang.String.valueOf(r4)
            return r4
        L_0x0074:
            java.lang.String r0 = java.lang.String.valueOf(r4)
            boolean r1 = r4 instanceof java.lang.String
            r2 = 0
            if (r1 == 0) goto L_0x0092
            com.applovin.impl.sdk.b.c<java.lang.Integer> r4 = com.applovin.impl.sdk.p019b.C1096c.f2309aX
            java.lang.Object r4 = r5.mo10202a(r4)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            if (r4 <= 0) goto L_0x00ae
            int r5 = r0.length()
            if (r5 <= r4) goto L_0x00ae
            goto L_0x00aa
        L_0x0092:
            boolean r4 = r4 instanceof android.net.Uri
            if (r4 == 0) goto L_0x00ae
            com.applovin.impl.sdk.b.c<java.lang.Integer> r4 = com.applovin.impl.sdk.p019b.C1096c.f2310aY
            java.lang.Object r4 = r5.mo10202a(r4)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            if (r4 <= 0) goto L_0x00ae
            int r5 = r0.length()
            if (r5 <= r4) goto L_0x00ae
        L_0x00aa:
            java.lang.String r0 = r0.substring(r2, r4)
        L_0x00ae:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.utils.C1281o.m3073a(java.lang.Object, com.applovin.impl.sdk.i):java.lang.Object");
    }

    /* renamed from: a */
    public static String m3074a(Context context) {
        Bundle h = m3117h(context);
        if (h == null) {
            return null;
        }
        String string = h.getString("applovin.sdk.key");
        if (string == null) {
            string = "";
        }
        return string;
    }

    /* renamed from: a */
    public static String m3075a(String str) {
        return (str == null || str.length() <= 4) ? "NOKEY" : str.substring(str.length() - 4);
    }

    /* renamed from: a */
    public static String m3076a(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Entry entry : map.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static Field m3077a(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Class superclass = cls.getSuperclass();
            if (superclass == null) {
                return null;
            }
            return m3077a(superclass, str);
        }
    }

    /* renamed from: a */
    public static List<C1101a> m3078a(String str, JSONObject jSONObject, String str2, String str3, C1192i iVar) {
        return m3079a(str, jSONObject, str2, null, str3, iVar);
    }

    /* renamed from: a */
    public static List<C1101a> m3079a(String str, JSONObject jSONObject, String str2, String str3, String str4, C1192i iVar) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("{CLCODE}", str2);
        if (str3 == null) {
            str3 = "";
        }
        hashMap.put("{EVENT_ID}", str3);
        return m3080a(str, jSONObject, (Map<String, String>) hashMap, str4, iVar);
    }

    /* renamed from: a */
    public static List<C1101a> m3080a(String str, JSONObject jSONObject, Map<String, String> map, String str2, C1192i iVar) {
        JSONObject b = C1247h.m2989b(jSONObject, str, new JSONObject(), iVar);
        ArrayList arrayList = new ArrayList(b.length() + 1);
        if (C1277l.m3042b(str2)) {
            arrayList.add(new C1101a(str2, null));
        }
        if (b.length() > 0) {
            Iterator keys = b.keys();
            while (keys.hasNext()) {
                try {
                    String str3 = (String) keys.next();
                    if (!TextUtils.isEmpty(str3)) {
                        String optString = b.optString(str3);
                        String a = C1277l.m3037a(str3, map);
                        if (!TextUtils.isEmpty(optString)) {
                            optString = C1277l.m3037a(optString, map);
                        }
                        arrayList.add(new C1101a(a, optString));
                    }
                } catch (Throwable th) {
                    iVar.mo10249v().mo10379b("Utils", "Failed to create and add postback url.", th);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private static List<Class> m3081a(List<String> list, C1192i iVar) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (String str : list) {
            try {
                arrayList.add(Class.forName(str));
            } catch (ClassNotFoundException unused) {
                C1227o v = iVar.mo10249v();
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to create class for name: ");
                sb.append(str);
                v.mo10382e("Utils", sb.toString());
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static void m3082a(AppLovinAdLoadListener appLovinAdLoadListener, C1082d dVar, int i, C1192i iVar) {
        if (appLovinAdLoadListener != null) {
            try {
                if (appLovinAdLoadListener instanceof C1205l) {
                    ((C1205l) appLovinAdLoadListener).mo9974a(dVar, i);
                } else {
                    appLovinAdLoadListener.failedToReceiveAd(i);
                }
            } catch (Throwable th) {
                iVar.mo10249v().mo10379b("Utils", "Unable process a failure to receive an ad", th);
            }
        }
    }

    /* renamed from: a */
    public static void m3083a(Closeable closeable, C1192i iVar) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                if (iVar != null) {
                    C1227o v = iVar.mo10249v();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unable to close stream: ");
                    sb.append(closeable);
                    v.mo10379b("Utils", sb.toString(), th);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m3084a(String str, Boolean bool, Map<String, String> map) {
        if (bool.booleanValue()) {
            map.put(str, Boolean.toString(true));
        }
    }

    /* renamed from: a */
    public static void m3085a(String str, String str2, Map<String, String> map) {
        if (!TextUtils.isEmpty(str2)) {
            map.put(str, str2);
        }
    }

    /* renamed from: a */
    public static void m3086a(String str, JSONObject jSONObject, C1192i iVar) {
        String str2 = "no_fill_reason";
        if (jSONObject.has(str2)) {
            Object a = C1247h.m2966a(jSONObject, str2, new Object(), iVar);
            StringBuilder sb = new StringBuilder();
            sb.append("\n**************************************************\nNO FILL received:\n..ID: \"");
            sb.append(str);
            sb.append("\"\n..SDK KEY: \"");
            sb.append(iVar.mo10246t());
            sb.append("\"\n..Reason: ");
            sb.append(a);
            sb.append("\n**************************************************\n");
            C1227o.m2841i("AppLovinSdk", sb.toString());
        }
    }

    /* renamed from: a */
    public static void m3087a(HttpURLConnection httpURLConnection, C1192i iVar) {
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Throwable th) {
                if (iVar != null) {
                    C1227o v = iVar.mo10249v();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unable to disconnect connection: ");
                    sb.append(httpURLConnection);
                    v.mo10379b("Utils", sb.toString(), th);
                }
            }
        }
    }

    /* renamed from: a */
    public static boolean m3088a() {
        Context E = C1192i.m2558E();
        if (E == null) {
            return false;
        }
        Bundle h = m3117h(E);
        return h != null && h.containsKey("applovin.sdk.verbose_logging");
    }

    /* renamed from: a */
    public static boolean m3089a(long j, long j2) {
        return (j & j2) != 0;
    }

    /* renamed from: a */
    public static boolean m3090a(Context context, Uri uri, C1192i iVar) {
        boolean z;
        try {
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            if (!(context instanceof Activity)) {
                intent.setFlags(DriveFile.MODE_READ_ONLY);
            }
            iVar.mo10199Y().mo10397b();
            context.startActivity(intent);
            z = true;
        } catch (Throwable th) {
            C1227o v = iVar.mo10249v();
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to open \"");
            sb.append(uri);
            sb.append("\".");
            v.mo10379b("Utils", sb.toString(), th);
            z = false;
        }
        if (!z) {
            iVar.mo10199Y().mo10398c();
        }
        return z;
    }

    /* renamed from: a */
    public static boolean m3091a(View view, Activity activity) {
        View rootView;
        if (!(activity == null || view == null)) {
            Window window = activity.getWindow();
            if (window != null) {
                rootView = window.getDecorView();
            } else {
                View findViewById = activity.findViewById(16908290);
                if (findViewById != null) {
                    rootView = findViewById.getRootView();
                }
            }
            return m3092a(view, rootView);
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m3092a(View view, View view2) {
        if (view == view2) {
            return true;
        }
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                if (m3092a(view, viewGroup.getChildAt(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m3093a(Object obj, List<String> list, C1192i iVar) {
        String str;
        if (list == null) {
            return false;
        }
        Iterator it = m3081a(list, iVar).iterator();
        do {
            str = "Utils";
            if (!it.hasNext()) {
                C1227o v = iVar.mo10249v();
                StringBuilder sb = new StringBuilder();
                sb.append("Object '");
                sb.append(obj);
                sb.append("' does not match any of the required types '");
                sb.append(list);
                sb.append("'.");
                v.mo10378b(str, sb.toString());
                return false;
            }
        } while (!((Class) it.next()).isInstance(obj));
        if (obj instanceof Map) {
            for (Entry entry : ((Map) obj).entrySet()) {
                if (!(entry.getKey() instanceof String)) {
                    iVar.mo10249v().mo10378b(str, "Invalid key type used. Map keys should be of type String.");
                    return false;
                } else if (!m3093a(entry.getValue(), list, iVar)) {
                    return false;
                }
            }
        } else if (obj instanceof List) {
            for (Object a : (List) obj) {
                if (!m3093a(a, list, iVar)) {
                    return false;
                }
            }
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m3094a(String str, List<String> list) {
        for (String startsWith : list) {
            if (str.startsWith(startsWith)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public static long m3095b(float f) {
        return m3103c(m3062a(f));
    }

    /* renamed from: b */
    public static C1161a m3096b(C1192i iVar) {
        return ((Boolean) iVar.mo10202a(C1096c.f2468dZ)).booleanValue() ? C1161a.ADVERTISING_INFO_COLLECTION : C1161a.BACKGROUND;
    }

    /* renamed from: b */
    public static String m3097b(Class cls, String str) {
        try {
            Field a = m3077a(cls, str);
            a.setAccessible(true);
            return (String) a.get(null);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: b */
    public static String m3098b(String str) {
        return str.replace("{PLACEMENT}", "");
    }

    /* renamed from: b */
    public static Map<String, String> m3099b(Map<String, String> map) {
        HashMap hashMap = new HashMap(map);
        for (String str : hashMap.keySet()) {
            String str2 = (String) hashMap.get(str);
            if (str2 != null) {
                hashMap.put(str, C1277l.m3044d(str2));
            }
        }
        return hashMap;
    }

    /* renamed from: b */
    public static void m3100b(AppLovinAd appLovinAd, C1192i iVar) {
        if (appLovinAd instanceof AppLovinAdBase) {
            AppLovinAdBase appLovinAdBase = (AppLovinAdBase) appLovinAd;
            String t = iVar.mo10246t();
            String t2 = appLovinAdBase.getSdk().mo10246t();
            if (!t.equals(t2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Ad was loaded from sdk with key: ");
                sb.append(t2);
                sb.append(", but is being rendered from sdk with key: ");
                sb.append(t);
                C1227o.m2841i("AppLovinAd", sb.toString());
                iVar.mo10186L().mo10036a(C1113g.f2667l);
            }
        }
    }

    /* renamed from: b */
    public static boolean m3101b() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    /* renamed from: b */
    public static boolean m3102b(Context context) {
        if (context == null) {
            context = C1192i.m2558E();
        }
        if (context == null) {
            return false;
        }
        Bundle h = m3117h(context);
        return h != null && h.getBoolean("applovin.sdk.test_ads", false);
    }

    /* renamed from: c */
    private static long m3103c(float f) {
        return (long) Math.round(f);
    }

    /* renamed from: c */
    public static MaxAdFormat m3104c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.equalsIgnoreCase("banner")) {
            return MaxAdFormat.BANNER;
        }
        if (str.equalsIgnoreCase("mrec")) {
            return MaxAdFormat.MREC;
        }
        if (str.equalsIgnoreCase("leaderboard") || str.equalsIgnoreCase("leader")) {
            return MaxAdFormat.LEADER;
        }
        if (str.equalsIgnoreCase("interstitial") || str.equalsIgnoreCase("inter")) {
            return MaxAdFormat.INTERSTITIAL;
        }
        if (str.equalsIgnoreCase("rewarded") || str.equalsIgnoreCase("reward")) {
            return MaxAdFormat.REWARDED;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unknown format: ");
        sb.append(str);
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: c */
    public static boolean m3105c() {
        RunningAppProcessInfo runningAppProcessInfo = new RunningAppProcessInfo();
        ActivityManager.getMyMemoryState(runningAppProcessInfo);
        return runningAppProcessInfo.importance == 100 || runningAppProcessInfo.importance == 200;
    }

    /* renamed from: c */
    public static boolean m3106c(Context context) {
        if (context == null) {
            context = C1192i.m2558E();
        }
        if (context == null) {
            return false;
        }
        Bundle h = m3117h(context);
        return h != null && h.getBoolean("applovin.sdk.verbose_logging", false);
    }

    /* renamed from: c */
    public static boolean m3107c(C1192i iVar) {
        if (f3223b == null) {
            try {
                Context E = C1192i.m2558E();
                StringBuilder sb = new StringBuilder();
                sb.append(E.getPackageName());
                sb.append(".BuildConfig");
                f3223b = Boolean.valueOf(Class.forName(sb.toString()).getField("DEBUG").getBoolean(null));
            } catch (Throwable th) {
                iVar.mo10249v().mo10379b("Utils", "Failed to retrieve BuildConfig.DEBUG", th);
                f3223b = Boolean.valueOf(false);
            }
        }
        return f3223b.booleanValue();
    }

    /* renamed from: d */
    public static int m3108d(Context context) {
        if (context != null) {
            Resources resources = context.getResources();
            if (resources != null) {
                Configuration configuration = resources.getConfiguration();
                if (configuration != null) {
                    return configuration.orientation;
                }
            }
        }
        return 0;
    }

    /* renamed from: d */
    public static String m3109d(String str) {
        Uri parse = Uri.parse(str);
        return new Builder().scheme(parse.getScheme()).authority(parse.getAuthority()).path(parse.getPath()).build().toString();
    }

    /* renamed from: d */
    public static boolean m3110d() {
        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                String displayName = ((NetworkInterface) networkInterfaces.nextElement()).getDisplayName();
                if (displayName.contains("tun") || displayName.contains("ppp")) {
                    return true;
                }
                if (displayName.contains("ipsec")) {
                    return true;
                }
            }
        } catch (Throwable th) {
            C1227o.m2837c("Utils", "Unable to check Network Interfaces", th);
        }
        return false;
    }

    /* renamed from: e */
    public static View m3111e(Context context) {
        if (!(context instanceof Activity)) {
            return null;
        }
        return ((Activity) context).getWindow().getDecorView().findViewById(16908290);
    }

    /* renamed from: e */
    public static boolean m3112e(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Class.forName(str);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: f */
    public static long m3113f(String str) {
        if (C1277l.m3042b(str)) {
            try {
                return (long) Color.parseColor(str);
            } catch (Throwable unused) {
            }
        }
        return Long.MAX_VALUE;
    }

    /* renamed from: f */
    public static String m3114f(Context context) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setPackage(context.getPackageName());
        List queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (!queryIntentActivities.isEmpty()) {
            return ((ResolveInfo) queryIntentActivities.get(0)).activityInfo.name;
        }
        return null;
    }

    /* renamed from: g */
    public static int m3115g(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            return 0;
        }
        return windowManager.getDefaultDisplay().getRotation();
    }

    /* renamed from: g */
    public static int m3116g(String str) {
        String[] split;
        int i = 0;
        for (String str2 : str.split("\\.")) {
            if (str2.length() > 2) {
                StringBuilder sb = new StringBuilder();
                sb.append("Version number components cannot be longer than two digits -> ");
                sb.append(str);
                C1227o.m2841i("Utils", sb.toString());
                return i;
            }
            i = (i * 100) + Integer.valueOf(str2).intValue();
        }
        return i;
    }

    /* renamed from: h */
    private static Bundle m3117h(Context context) {
        ApplicationInfo applicationInfo = f3222a;
        if (applicationInfo != null) {
            return applicationInfo.metaData;
        }
        try {
            f3222a = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            return f3222a.metaData;
        } catch (NameNotFoundException unused) {
            return null;
        }
    }
}
