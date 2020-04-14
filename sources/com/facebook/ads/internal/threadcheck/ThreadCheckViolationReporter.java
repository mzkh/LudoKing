package com.facebook.ads.internal.threadcheck;

import android.os.Looper;
import android.util.Log;
import java.util.Locale;

public class ThreadCheckViolationReporter {
    private static final String TAG = "THREADCHECK";

    private ThreadCheckViolationReporter() {
    }

    public static void uiThreadViolationDetected(Class<?> cls, String str, String str2) {
        Looper mainLooper = Looper.getMainLooper();
        Looper myLooper = Looper.myLooper();
        Log.e(TAG, String.format(Locale.US, "@UiThread annotation violation detected in %s.%s%s. Current looper is %s and main looper is %s.", new Object[]{cls.getName(), str, str2, myLooper, mainLooper}), new Exception());
    }

    public static void workerThreadViolationDetected(Class<?> cls, String str, String str2) {
        Looper mainLooper = Looper.getMainLooper();
        Looper myLooper = Looper.myLooper();
        Log.e(TAG, String.format(Locale.US, "@WorkerThread annotation violation detected in %s.%s%s. Current looper is %s and main looper is %s.", new Object[]{cls.getName(), str, str2, myLooper, mainLooper}), new Exception());
    }
}
