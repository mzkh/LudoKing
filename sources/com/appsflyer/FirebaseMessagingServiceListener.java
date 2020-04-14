package com.appsflyer;

import com.appsflyer.internal.C1363d.C1364b.C1365e;
import com.appsflyer.internal.C1376r.C13773;
import com.google.firebase.messaging.FirebaseMessagingService;

public class FirebaseMessagingServiceListener extends FirebaseMessagingService {
    public void onNewToken(String str) {
        super.onNewToken(str);
        long currentTimeMillis = System.currentTimeMillis();
        if (str != null) {
            AFLogger.afInfoLog("Firebase Refreshed Token = ".concat(String.valueOf(str)));
            C1365e r2 = C1365e.m3328(AppsFlyerProperties.getInstance().getString("afUninstallToken"));
            C1365e eVar = new C1365e(currentTimeMillis, str);
            if (r2.mo10830(eVar.f3543, eVar.f3542)) {
                C13773.m3342(getApplicationContext(), eVar.f3542);
            }
        }
    }
}
