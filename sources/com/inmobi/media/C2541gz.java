package com.inmobi.media;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import androidx.annotation.NonNull;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.inmobi.media.gz */
/* compiled from: FileManager */
public final class C2541gz {

    /* renamed from: a */
    private static final String f5573a = "gz";

    @SuppressLint({"SdCardPath"})
    /* renamed from: a */
    public static boolean m5443a(@NonNull Context context) {
        String str;
        String str2;
        String str3;
        String str4 = "inmobiAppAnalyticsSession";
        String str5 = "IMAdTrackerStatusUpload";
        Iterator it = Arrays.asList(new String[]{"carbpreference", "IMAdMLtvpRuleCache", str4, "aeskeygenerate", "impref", str5, "IMAdMMediationCache", "inmobiAppAnalyticsAppId", str4, "inmobisdkaid", str5, "testAppPref"}).iterator();
        while (true) {
            str = ".xml";
            str2 = "/shared_prefs/";
            str3 = "/data/data/";
            if (!it.hasNext()) {
                break;
            }
            String str6 = (String) it.next();
            StringBuilder sb = new StringBuilder(str3);
            sb.append(context.getPackageName());
            sb.append(str2);
            sb.append(str6);
            sb.append(str);
            File file = new File(sb.toString());
            if (file.exists()) {
                file.delete();
            }
        }
        List<String> asList = Arrays.asList(new String[]{C2494fy.m5250a("carb_store"), C2494fy.m5250a("aes_key_store"), C2494fy.m5250a("mraid_js_store"), C2494fy.m5250a("omid_js_store"), C2494fy.m5250a("user_info_store"), C2494fy.m5250a("coppa_store"), C2494fy.m5250a("gesture_info_store")});
        if (VERSION.SDK_INT >= 24) {
            for (String deleteSharedPreferences : asList) {
                context.deleteSharedPreferences(deleteSharedPreferences);
            }
        } else {
            for (String str7 : asList) {
                StringBuilder sb2 = new StringBuilder(str3);
                sb2.append(context.getPackageName());
                sb2.append(str2);
                sb2.append(str7);
                sb2.append(str);
                File file2 = new File(sb2.toString());
                if (file2.exists()) {
                    file2.delete();
                }
            }
        }
        for (String str8 : Arrays.asList(new String[]{"inmobi.cache", "inmobi.cache.data", "inmobi.cache.data.events.number", "inmobi.cache.data.events.timestamp"})) {
            if (context.getCacheDir() != null) {
                File file3 = new File(context.getCacheDir(), str8);
                if (file3.exists()) {
                    file3.delete();
                }
            }
        }
        for (String str9 : Arrays.asList(new String[]{"eventlog", "imai_click_events"})) {
            String str10 = "data";
            if (context.getDir(str10, 0) != null) {
                File file4 = new File(context.getDir(str10, 0), str9);
                if (file4.exists()) {
                    file4.delete();
                }
            }
        }
        return m5445b(context).size() != 0;
    }

    /* renamed from: a */
    private static boolean m5444a(Context context, String str) {
        File databasePath = context.getDatabasePath(str);
        return databasePath == null || !databasePath.exists() || context.deleteDatabase(str);
    }

    /* renamed from: b */
    public static List<String> m5445b(Context context) {
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        hashSet.add("adcache.db");
        hashSet.add("appengage.db");
        hashSet.add("im.db");
        hashSet.add("ltvp.db");
        hashSet.add("analytics.db");
        hashSet.add("com.im.db");
        hashSet.add("IMInitialization.db");
        String[] databaseList = context.databaseList();
        if (databaseList != null && databaseList.length > 0) {
            for (String str : databaseList) {
                if (hashSet.contains(str) && !m5444a(context, str)) {
                    arrayList.add(str);
                } else if (str.matches("com\\.im_([0-9]+\\.){3}db") && !str.equals(C2492fw.f5464a) && !m5444a(context, str)) {
                    arrayList.add(str);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static void m5442a(File file) {
        try {
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        if (file2.isDirectory()) {
                            m5442a(file2);
                        } else {
                            file2.delete();
                        }
                    }
                }
                file.delete();
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public static long m5441a(String str) {
        try {
            File file = new File(Uri.parse(str).getPath());
            if (file.exists()) {
                return file.length();
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }
}
