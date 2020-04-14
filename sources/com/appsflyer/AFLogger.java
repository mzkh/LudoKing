package com.appsflyer;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import com.appsflyer.internal.C1356am;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class AFLogger {

    /* renamed from: ˋ */
    private static long f3324 = System.currentTimeMillis();

    public enum LogLevel {
        NONE(0),
        ERROR(1),
        WARNING(2),
        INFO(3),
        DEBUG(4),
        VERBOSE(5);
        

        /* renamed from: ॱ */
        private int f3326;

        private LogLevel(int i) {
            this.f3326 = i;
        }

        public final int getLevel() {
            return this.f3326;
        }
    }

    public static void afInfoLog(String str, boolean z) {
        if (LogLevel.INFO.getLevel() <= AppsFlyerProperties.getInstance().getInt("logLevel", LogLevel.NONE.getLevel())) {
            Log.i(AppsFlyerLibCore.LOG_TAG, m3175(str, false));
        }
        if (z) {
            if (C1356am.f3467 == null) {
                C1356am.f3467 = new C1356am();
            }
            C1356am.f3467.mo10812(null, "I", m3175(str, true));
        }
    }

    public static void resetDeltaTime() {
        f3324 = System.currentTimeMillis();
    }

    @NonNull
    /* renamed from: ˋ */
    private static String m3175(String str, boolean z) {
        if (!z) {
            if (LogLevel.VERBOSE.getLevel() > AppsFlyerProperties.getInstance().getInt("logLevel", LogLevel.NONE.getLevel())) {
                return str;
            }
        }
        StringBuilder sb = new StringBuilder("(");
        sb.append(m3174(System.currentTimeMillis() - f3324));
        sb.append(") [");
        sb.append(Thread.currentThread().getName());
        sb.append("] ");
        sb.append(str);
        return sb.toString();
    }

    /* renamed from: ˏ */
    private static void m3176(String str, Throwable th, boolean z) {
        String[] strArr;
        if ((LogLevel.ERROR.getLevel() <= AppsFlyerProperties.getInstance().getInt("logLevel", LogLevel.NONE.getLevel())) && z) {
            Log.e(AppsFlyerLibCore.LOG_TAG, m3175(str, false), th);
        }
        if (C1356am.f3467 == null) {
            C1356am.f3467 = new C1356am();
        }
        C1356am amVar = C1356am.f3467;
        Throwable cause = th.getCause();
        String simpleName = th.getClass().getSimpleName();
        String message = cause == null ? th.getMessage() : cause.getMessage();
        StackTraceElement[] stackTrace = cause == null ? th.getStackTrace() : cause.getStackTrace();
        if (stackTrace == null) {
            strArr = new String[]{message};
        } else {
            String[] strArr2 = new String[(stackTrace.length + 1)];
            strArr2[0] = message;
            for (int i = 1; i < stackTrace.length; i++) {
                strArr2[i] = stackTrace[i].toString();
            }
            strArr = strArr2;
        }
        amVar.mo10812("exception", simpleName, strArr);
    }

    /* renamed from: ॱ */
    static void m3177(String str) {
        if (LogLevel.WARNING.getLevel() <= AppsFlyerProperties.getInstance().getInt("logLevel", LogLevel.NONE.getLevel())) {
            Log.w(AppsFlyerLibCore.LOG_TAG, m3175(str, false));
        }
        if (C1356am.f3467 == null) {
            C1356am.f3467 = new C1356am();
        }
        C1356am.f3467.mo10812(null, ExifInterface.LONGITUDE_WEST, m3175(str, true));
    }

    public static void afRDLog(String str) {
        if (LogLevel.VERBOSE.getLevel() <= AppsFlyerProperties.getInstance().getInt("logLevel", LogLevel.NONE.getLevel())) {
            Log.v(AppsFlyerLibCore.LOG_TAG, m3175(str, false));
        }
        if (C1356am.f3467 == null) {
            C1356am.f3467 = new C1356am();
        }
        C1356am.f3467.mo10812(null, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, m3175(str, true));
    }

    public static void afInfoLog(String str) {
        afInfoLog(str, true);
    }

    public static void afErrorLog(String str, Throwable th) {
        m3176(str, th, false);
    }

    public static void afErrorLog(String str, Throwable th, boolean z) {
        m3176(str, th, z);
    }

    public static void afWarnLog(String str) {
        m3177(str);
    }

    /* renamed from: ˋ */
    private static String m3174(long j) {
        long hours = TimeUnit.MILLISECONDS.toHours(j);
        long millis = j - TimeUnit.HOURS.toMillis(hours);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);
        long millis2 = millis - TimeUnit.MINUTES.toMillis(minutes);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(millis2);
        long millis3 = TimeUnit.MILLISECONDS.toMillis(millis2 - TimeUnit.SECONDS.toMillis(seconds));
        return String.format(Locale.getDefault(), "%02d:%02d:%02d:%03d", new Object[]{Long.valueOf(hours), Long.valueOf(minutes), Long.valueOf(seconds), Long.valueOf(millis3)});
    }

    /* renamed from: ˊ */
    static void m3173(String str) {
        if (!AppsFlyerProperties.getInstance().isLogsDisabledCompletely()) {
            Log.d(AppsFlyerLibCore.LOG_TAG, m3175(str, false));
        }
        if (C1356am.f3467 == null) {
            C1356am.f3467 = new C1356am();
        }
        C1356am.f3467.mo10812(null, "F", str);
    }

    public static void afDebugLog(String str) {
        if (LogLevel.DEBUG.getLevel() <= AppsFlyerProperties.getInstance().getInt("logLevel", LogLevel.NONE.getLevel())) {
            Log.d(AppsFlyerLibCore.LOG_TAG, m3175(str, false));
        }
        if (C1356am.f3467 == null) {
            C1356am.f3467 = new C1356am();
        }
        C1356am.f3467.mo10812(null, "D", m3175(str, true));
    }
}
