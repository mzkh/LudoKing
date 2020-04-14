package com.facebook.appevents.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.AppEventsLogger.FlushBehavior;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.Logger;
import com.facebook.internal.security.CertificateUtil;
import com.tapjoy.TapjoyConstants;
import java.util.Locale;

class SessionLogger {
    private static final long[] INACTIVE_SECONDS_QUANTA = {300000, TapjoyConstants.PAID_APP_TIME, TapjoyConstants.SESSION_ID_INACTIVITY_TIME, 3600000, 21600000, 43200000, 86400000, 172800000, 259200000, 604800000, 1209600000, 1814400000, 2419200000L, 5184000000L, 7776000000L, 10368000000L, 12960000000L, 15552000000L, 31536000000L};
    private static final String PACKAGE_CHECKSUM = "PCKGCHKSUM";
    private static final String TAG = "com.facebook.appevents.internal.SessionLogger";

    SessionLogger() {
    }

    public static void logActivateApp(String str, SourceApplicationInfo sourceApplicationInfo, String str2, Context context) {
        String sourceApplicationInfo2 = sourceApplicationInfo != null ? sourceApplicationInfo.toString() : "Unclassified";
        Bundle bundle = new Bundle();
        bundle.putString(AppEventsConstants.EVENT_PARAM_SOURCE_APPLICATION, sourceApplicationInfo2);
        bundle.putString(AppEventsConstants.EVENT_PARAM_PACKAGE_FP, computePackageChecksum(context));
        bundle.putString(AppEventsConstants.EVENT_PARAM_APP_CERT_HASH, CertificateUtil.getCertificateHash(context));
        InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(str, str2, null);
        internalAppEventsLogger.logEvent(AppEventsConstants.EVENT_NAME_ACTIVATED_APP, bundle);
        if (InternalAppEventsLogger.getFlushBehavior() != FlushBehavior.EXPLICIT_ONLY) {
            internalAppEventsLogger.flush();
        }
    }

    public static void logDeactivateApp(String str, SessionInfo sessionInfo, String str2) {
        Long valueOf = Long.valueOf(sessionInfo.getDiskRestoreTime() - sessionInfo.getSessionLastEventTime().longValue());
        long longValue = valueOf.longValue();
        Long valueOf2 = Long.valueOf(0);
        if (longValue < 0) {
            logClockSkewEvent();
            valueOf = valueOf2;
        }
        Long valueOf3 = Long.valueOf(sessionInfo.getSessionLength());
        if (valueOf3.longValue() < 0) {
            logClockSkewEvent();
            valueOf3 = valueOf2;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(AppEventsConstants.EVENT_NAME_SESSION_INTERRUPTIONS, sessionInfo.getInterruptionCount());
        bundle.putString(AppEventsConstants.EVENT_NAME_TIME_BETWEEN_SESSIONS, String.format(Locale.ROOT, "session_quanta_%d", new Object[]{Integer.valueOf(getQuantaIndex(valueOf.longValue()))}));
        SourceApplicationInfo sourceApplicationInfo = sessionInfo.getSourceApplicationInfo();
        bundle.putString(AppEventsConstants.EVENT_PARAM_SOURCE_APPLICATION, sourceApplicationInfo != null ? sourceApplicationInfo.toString() : "Unclassified");
        bundle.putLong(Constants.LOG_TIME_APP_EVENT_KEY, sessionInfo.getSessionLastEventTime().longValue() / 1000);
        InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(str, str2, null);
        double longValue2 = (double) valueOf3.longValue();
        Double.isNaN(longValue2);
        internalAppEventsLogger.logEvent(AppEventsConstants.EVENT_NAME_DEACTIVATED_APP, longValue2 / 1000.0d, bundle);
    }

    private static void logClockSkewEvent() {
        Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Clock skew detected");
    }

    private static int getQuantaIndex(long j) {
        int i = 0;
        while (true) {
            long[] jArr = INACTIVE_SECONDS_QUANTA;
            if (i >= jArr.length || jArr[i] >= j) {
                return i;
            }
            i++;
        }
        return i;
    }

    @Nullable
    private static String computePackageChecksum(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            String str = packageManager.getPackageInfo(context.getPackageName(), 0).versionName;
            StringBuilder sb = new StringBuilder();
            sb.append("PCKGCHKSUM;");
            sb.append(str);
            String sb2 = sb.toString();
            SharedPreferences sharedPreferences = context.getSharedPreferences(FacebookSdk.APP_EVENT_PREFERENCES, 0);
            String string = sharedPreferences.getString(sb2, null);
            if (string != null && string.length() == 32) {
                return string;
            }
            String computeChecksum = HashUtils.computeChecksum(packageManager.getApplicationInfo(context.getPackageName(), 0).sourceDir);
            sharedPreferences.edit().putString(sb2, computeChecksum).apply();
            return computeChecksum;
        } catch (Exception unused) {
            return null;
        }
    }
}
