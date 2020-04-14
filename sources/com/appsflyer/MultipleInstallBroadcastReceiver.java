package com.appsflyer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.tapjoy.TapjoyConstants;

public class MultipleInstallBroadcastReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String str;
        String str2 = "error in BroadcastReceiver ";
        String str3 = TapjoyConstants.TJC_REFERRER;
        if (intent != null) {
            try {
                str = intent.getStringExtra(str3);
            } catch (Throwable th) {
                AFLogger.afErrorLog(str2, th);
                str = null;
            }
            if (str != null) {
                if ("AppsFlyer_Test".equals(str) && intent.getStringExtra("TestIntegrationMode") != null) {
                    AppsFlyerLibCore.getInstance().mo10733(context, intent);
                    return;
                } else if (AppsFlyerLibCore.m3225(context).getString(str3, null) != null) {
                    AppsFlyerLibCore.getInstance();
                    AppsFlyerLibCore.m3190(context, str);
                    return;
                }
            }
            AFLogger.afInfoLog("MultipleInstallBroadcastReceiver called");
            AppsFlyerLibCore.getInstance().mo10733(context, intent);
            String str4 = "com.android.vending.INSTALL_REFERRER";
            for (ResolveInfo resolveInfo : context.getPackageManager().queryBroadcastReceivers(new Intent(str4), 0)) {
                String action = intent.getAction();
                if (resolveInfo.activityInfo.packageName.equals(context.getPackageName()) && str4.equals(action) && !getClass().getName().equals(resolveInfo.activityInfo.name)) {
                    StringBuilder sb = new StringBuilder("trigger onReceive: class: ");
                    sb.append(resolveInfo.activityInfo.name);
                    AFLogger.afInfoLog(sb.toString());
                    try {
                        ((BroadcastReceiver) Class.forName(resolveInfo.activityInfo.name).newInstance()).onReceive(context, intent);
                    } catch (Throwable th2) {
                        StringBuilder sb2 = new StringBuilder(str2);
                        sb2.append(resolveInfo.activityInfo.name);
                        AFLogger.afErrorLog(sb2.toString(), th2);
                    }
                }
            }
        }
    }
}
