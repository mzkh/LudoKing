package com.appsflyer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tapjoy.TapjoyConstants;

public class SingleInstallBroadcastReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String str;
        String str2 = TapjoyConstants.TJC_REFERRER;
        if (intent != null) {
            try {
                str = intent.getStringExtra(str2);
            } catch (Throwable th) {
                AFLogger.afErrorLog("error in BroadcastReceiver ", th);
                str = null;
            }
            if (str != null) {
                if (str.contains("AppsFlyer_Test") && intent.getStringExtra("TestIntegrationMode") != null) {
                    AppsFlyerLibCore.getInstance().mo10733(context, intent);
                    return;
                } else if (AppsFlyerLibCore.m3225(context).getString(str2, null) != null) {
                    AppsFlyerLibCore.getInstance();
                    AppsFlyerLibCore.m3190(context, str);
                    return;
                }
            }
            String str3 = "referrer_timestamp";
            String string = AppsFlyerProperties.getInstance().getString(str3);
            long currentTimeMillis = System.currentTimeMillis();
            if (string == null || currentTimeMillis - Long.valueOf(string).longValue() >= 2000) {
                AFLogger.afInfoLog("SingleInstallBroadcastReceiver called");
                AppsFlyerLibCore.getInstance().mo10733(context, intent);
                AppsFlyerProperties.getInstance().set(str3, String.valueOf(System.currentTimeMillis()));
            }
        }
    }
}
