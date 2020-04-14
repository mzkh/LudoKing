package com.facebook.ads.internal.util.process;

import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import java.lang.reflect.Field;

@AnyThread
@Keep
public final class ProcessUtils {
    public static boolean sCurrentProcessCheckCalled = false;
    @Nullable
    private static String sProcessName = null;
    public static boolean sRemoteProcess = false;

    private ProcessUtils() {
    }

    @Nullable
    public static String getProcessName(Context context) {
        String str = sProcessName;
        if (str != null) {
            return str;
        }
        if (VERSION.SDK_INT >= 28) {
            return getProcessNameAPI28();
        }
        Context applicationContext = context.getApplicationContext();
        if (!(applicationContext instanceof Application)) {
            return null;
        }
        sProcessName = getProcessNameViaReflection((Application) applicationContext);
        return sProcessName;
    }

    @Nullable
    private static String getProcessNameAPI28() {
        try {
            return (String) Application.class.getMethod("getProcessName", null).invoke(null, null);
        } catch (Exception unused) {
            return null;
        }
    }

    @Nullable
    private static String getProcessNameViaReflection(Application application) {
        try {
            Field field = application.getClass().getField("mLoadedApk");
            field.setAccessible(true);
            Object obj = field.get(application);
            Field declaredField = obj.getClass().getDeclaredField("mActivityThread");
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            return (String) obj2.getClass().getDeclaredMethod("getProcessName", null).invoke(obj2, null);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getProcessSpecificName(String str, Context context) {
        String packageName = context.getPackageName();
        String processName = getProcessName(context);
        if (TextUtils.isEmpty(processName) || packageName.equals(processName)) {
            return str;
        }
        String str2 = ":";
        if (processName.contains(str2)) {
            processName = processName.split(str2)[1];
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("_");
        sb.append(processName);
        return sb.toString();
    }
}
