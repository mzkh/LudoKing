package com.appsflyer.internal;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;
import com.appsflyer.AFLogger;
import java.util.HashMap;

/* renamed from: com.appsflyer.internal.j */
public final class C1372j implements InstallReferrerStateListener {

    /* renamed from: ˋ */
    private InstallReferrerClient f3573;

    /* renamed from: ˎ */
    private C1373m f3574;

    /* renamed from: ˏ */
    public final void mo10833(Context context, C1373m mVar) {
        this.f3574 = mVar;
        try {
            this.f3573 = InstallReferrerClient.newBuilder(context).build();
            this.f3573.startConnection(this);
        } catch (Throwable th) {
            AFLogger.afErrorLog("referrerClient -> startConnection", th);
        }
    }

    public final void onInstallReferrerSetupFinished(int i) {
        String str = "ReferrerClient: InstallReferrer is not ready";
        String str2 = "install";
        String str3 = "clk";
        String str4 = "val";
        String str5 = NotificationCompat.CATEGORY_ERROR;
        HashMap hashMap = new HashMap();
        hashMap.put("code", String.valueOf(i));
        ReferrerDetails referrerDetails = null;
        if (i != 0) {
            String str6 = "InstallReferrer not supported";
            if (i == 1) {
                AFLogger.afWarnLog(str6);
            } else if (i != 2) {
                AFLogger.afWarnLog("responseCode not found.");
            } else {
                AFLogger.afWarnLog(str6);
            }
        } else {
            try {
                AFLogger.afDebugLog("InstallReferrer connected");
                if (this.f3573.isReady()) {
                    referrerDetails = this.f3573.getInstallReferrer();
                    this.f3573.endConnection();
                } else {
                    AFLogger.afWarnLog(str);
                    hashMap.put(str5, str);
                }
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder("Failed to get install referrer: ");
                sb.append(th.getMessage());
                AFLogger.afWarnLog(sb.toString());
                hashMap.put(str5, th.getMessage());
            }
        }
        if (referrerDetails != null) {
            try {
                if (referrerDetails.getInstallReferrer() != null) {
                    hashMap.put(str4, referrerDetails.getInstallReferrer());
                }
                hashMap.put(str3, Long.toString(referrerDetails.getReferrerClickTimestampSeconds()));
                hashMap.put(str2, Long.toString(referrerDetails.getInstallBeginTimestampSeconds()));
                try {
                    hashMap.put("instant", Boolean.valueOf(referrerDetails.getGooglePlayInstantParam()));
                } catch (NoSuchMethodError unused) {
                }
            } catch (Exception e) {
                e.printStackTrace();
                String str7 = "-1";
                hashMap.put(str4, str7);
                hashMap.put(str3, str7);
                hashMap.put(str2, str7);
            }
        }
        C1373m mVar = this.f3574;
        if (mVar != null) {
            mVar.mo10735(hashMap);
        }
    }

    public final void onInstallReferrerServiceDisconnected() {
        AFLogger.afDebugLog("Install Referrer service disconnected");
    }
}
