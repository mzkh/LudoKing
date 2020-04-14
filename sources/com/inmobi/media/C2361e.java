package com.inmobi.media;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.browser.customtabs.CustomTabsService;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.inmobi.media.e */
/* compiled from: CustomTabsPackageHelper */
public final class C2361e {

    /* renamed from: a */
    private static final String f5009a = "e";

    /* renamed from: b */
    private static String f5010b;

    private C2361e() {
    }

    /* renamed from: a */
    public static String m4920a(@Nullable Context context) {
        if (context == null || f5010b != null) {
            return f5010b;
        }
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.google.com"));
        ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 0);
        String str = resolveActivity != null ? resolveActivity.activityInfo.packageName : null;
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
        ArrayList arrayList = new ArrayList();
        for (ResolveInfo resolveInfo : queryIntentActivities) {
            Intent intent2 = new Intent();
            intent2.setAction(CustomTabsService.ACTION_CUSTOM_TABS_CONNECTION);
            intent2.setPackage(resolveInfo.activityInfo.packageName);
            if (packageManager.resolveService(intent2, 0) != null) {
                arrayList.add(resolveInfo.activityInfo.packageName);
            }
        }
        if (arrayList.isEmpty()) {
            f5010b = null;
        } else if (arrayList.size() == 1) {
            f5010b = (String) arrayList.get(0);
        } else if (TextUtils.isEmpty(str) || m4921a(context, intent) || !arrayList.contains(str)) {
            String str2 = "com.android.chrome";
            if (arrayList.contains(str2)) {
                f5010b = str2;
            } else {
                String str3 = "com.chrome.beta";
                if (arrayList.contains(str3)) {
                    f5010b = str3;
                } else {
                    String str4 = "com.chrome.dev";
                    if (arrayList.contains(str4)) {
                        f5010b = str4;
                    } else {
                        String str5 = "com.google.android.apps.chrome";
                        if (arrayList.contains(str5)) {
                            f5010b = str5;
                        }
                    }
                }
            }
        } else {
            f5010b = str;
        }
        return f5010b;
    }

    /* renamed from: a */
    private static boolean m4921a(Context context, Intent intent) {
        try {
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 64);
            if (queryIntentActivities != null) {
                if (queryIntentActivities.size() != 0) {
                    for (ResolveInfo resolveInfo : queryIntentActivities) {
                        IntentFilter intentFilter = resolveInfo.filter;
                        if (intentFilter != null && intentFilter.countDataAuthorities() != 0 && intentFilter.countDataPaths() != 0 && resolveInfo.activityInfo != null) {
                            return true;
                        }
                    }
                    return false;
                }
            }
            return false;
        } catch (RuntimeException unused) {
            Log.e(f5009a, "Runtime exception while getting specialized handlers");
        }
    }
}
