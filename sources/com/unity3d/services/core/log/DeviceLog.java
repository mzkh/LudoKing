package com.unity3d.services.core.log;

import android.util.Log;
import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;

public class DeviceLog {
    private static boolean FORCE_DEBUG_LOG = true;
    public static final int LOGLEVEL_DEBUG = 8;
    private static final int LOGLEVEL_ERROR = 1;
    public static final int LOGLEVEL_INFO = 4;
    private static final int LOGLEVEL_WARNING = 2;
    private static boolean LOG_DEBUG = true;
    private static boolean LOG_ERROR = true;
    private static boolean LOG_INFO = true;
    private static boolean LOG_WARNING = true;
    private static final int MAX_DEBUG_MSG_LENGTH = 3072;
    private static final HashMap<UnityAdsLogLevel, DeviceLogLevel> _deviceLogLevel = new HashMap<>();

    /* renamed from: com.unity3d.services.core.log.DeviceLog$1 */
    static /* synthetic */ class C34521 {

        /* renamed from: $SwitchMap$com$unity3d$services$core$log$DeviceLog$UnityAdsLogLevel */
        static final /* synthetic */ int[] f8097xf32d8d1 = new int[UnityAdsLogLevel.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                com.unity3d.services.core.log.DeviceLog$UnityAdsLogLevel[] r0 = com.unity3d.services.core.log.DeviceLog.UnityAdsLogLevel.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8097xf32d8d1 = r0
                int[] r0 = f8097xf32d8d1     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.unity3d.services.core.log.DeviceLog$UnityAdsLogLevel r1 = com.unity3d.services.core.log.DeviceLog.UnityAdsLogLevel.INFO     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f8097xf32d8d1     // Catch:{ NoSuchFieldError -> 0x001f }
                com.unity3d.services.core.log.DeviceLog$UnityAdsLogLevel r1 = com.unity3d.services.core.log.DeviceLog.UnityAdsLogLevel.DEBUG     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f8097xf32d8d1     // Catch:{ NoSuchFieldError -> 0x002a }
                com.unity3d.services.core.log.DeviceLog$UnityAdsLogLevel r1 = com.unity3d.services.core.log.DeviceLog.UnityAdsLogLevel.WARNING     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f8097xf32d8d1     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.unity3d.services.core.log.DeviceLog$UnityAdsLogLevel r1 = com.unity3d.services.core.log.DeviceLog.UnityAdsLogLevel.ERROR     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.log.DeviceLog.C34521.<clinit>():void");
        }
    }

    public enum UnityAdsLogLevel {
        INFO,
        DEBUG,
        WARNING,
        ERROR
    }

    static {
        if (_deviceLogLevel.size() == 0) {
            _deviceLogLevel.put(UnityAdsLogLevel.INFO, new DeviceLogLevel("i"));
            _deviceLogLevel.put(UnityAdsLogLevel.DEBUG, new DeviceLogLevel("d"));
            _deviceLogLevel.put(UnityAdsLogLevel.WARNING, new DeviceLogLevel("w"));
            _deviceLogLevel.put(UnityAdsLogLevel.ERROR, new DeviceLogLevel("e"));
        }
        if (new File("/data/local/tmp/UnityAdsForceDebugMode").exists()) {
        }
    }

    public static void setLogLevel(int i) {
        if (i >= 8) {
            LOG_ERROR = true;
            LOG_WARNING = true;
            LOG_INFO = true;
            LOG_DEBUG = true;
        } else if (i >= 4) {
            LOG_ERROR = true;
            LOG_WARNING = true;
            LOG_INFO = true;
            LOG_DEBUG = false;
        } else if (i >= 2) {
            LOG_ERROR = true;
            LOG_WARNING = true;
            LOG_INFO = false;
            LOG_DEBUG = false;
        } else if (i >= 1) {
            LOG_ERROR = true;
            LOG_WARNING = false;
            LOG_INFO = false;
            LOG_DEBUG = false;
        } else {
            LOG_ERROR = false;
            LOG_WARNING = false;
            LOG_INFO = false;
            LOG_DEBUG = false;
        }
    }

    public static void entered() {
        debug("ENTERED METHOD");
    }

    public static void info(String str) {
        write(UnityAdsLogLevel.INFO, checkMessage(str));
    }

    public static void info(String str, Object... objArr) {
        info(String.format(str, objArr));
    }

    public static void debug(String str) {
        if (!LOG_DEBUG && !FORCE_DEBUG_LOG) {
            return;
        }
        if (str.length() > MAX_DEBUG_MSG_LENGTH) {
            debug(str.substring(0, MAX_DEBUG_MSG_LENGTH));
            if (str.length() < 30720) {
                debug(str.substring(MAX_DEBUG_MSG_LENGTH));
            }
            return;
        }
        write(UnityAdsLogLevel.DEBUG, checkMessage(str));
    }

    public static void debug(String str, Object... objArr) {
        debug(String.format(str, objArr));
    }

    public static void warning(String str) {
        write(UnityAdsLogLevel.WARNING, checkMessage(str));
    }

    public static void warning(String str, Object... objArr) {
        warning(String.format(str, objArr));
    }

    public static void error(String str) {
        write(UnityAdsLogLevel.ERROR, checkMessage(str));
    }

    public static void exception(String str, Exception exc) {
        String str2 = "";
        if (str != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(str);
            str2 = sb.toString();
        }
        String str3 = ": ";
        if (exc != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str2);
            sb2.append(str3);
            sb2.append(exc.getMessage());
            str2 = sb2.toString();
        }
        if (!(exc == null || exc.getCause() == null)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str2);
            sb3.append(str3);
            sb3.append(exc.getCause().getMessage());
            str2 = sb3.toString();
        }
        write(UnityAdsLogLevel.ERROR, str2);
    }

    public static void error(String str, Object... objArr) {
        error(String.format(str, objArr));
    }

    private static void write(UnityAdsLogLevel unityAdsLogLevel, String str) {
        int i = C34521.f8097xf32d8d1[unityAdsLogLevel.ordinal()];
        boolean z = i != 1 ? i != 2 ? i != 3 ? i != 4 ? true : LOG_ERROR : LOG_WARNING : LOG_DEBUG : LOG_INFO;
        if (FORCE_DEBUG_LOG) {
            z = true;
        }
        if (z) {
            writeToLog(createLogEntry(unityAdsLogLevel, str));
        }
    }

    private static String checkMessage(String str) {
        return (str == null || str.length() == 0) ? "DO NOT USE EMPTY MESSAGES, use DeviceLog.entered() instead" : str;
    }

    private static DeviceLogLevel getLogLevel(UnityAdsLogLevel unityAdsLogLevel) {
        return (DeviceLogLevel) _deviceLogLevel.get(unityAdsLogLevel);
    }

    private static DeviceLogEntry createLogEntry(UnityAdsLogLevel unityAdsLogLevel, String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        DeviceLogLevel logLevel = getLogLevel(unityAdsLogLevel);
        if (logLevel == null) {
            return null;
        }
        int i = 0;
        boolean z = false;
        while (i < stackTrace.length) {
            StackTraceElement stackTraceElement = stackTrace[i];
            if (stackTraceElement.getClassName().equals(DeviceLog.class.getName())) {
                z = true;
            }
            if (!stackTraceElement.getClassName().equals(DeviceLog.class.getName()) && z) {
                break;
            }
            i++;
        }
        StackTraceElement stackTraceElement2 = i < stackTrace.length ? stackTrace[i] : null;
        if (stackTraceElement2 != null) {
            return new DeviceLogEntry(logLevel, str, stackTraceElement2);
        }
        return null;
    }

    private static void writeToLog(DeviceLogEntry deviceLogEntry) {
        Method method;
        String str = "Writing to log failed!";
        String str2 = "UnityAds";
        if (deviceLogEntry != null && deviceLogEntry.getLogLevel() != null) {
            Class<Log> cls = Log.class;
            try {
                method = cls.getMethod(deviceLogEntry.getLogLevel().getReceivingMethodName(), new Class[]{String.class, String.class});
            } catch (Exception e) {
                Log.e(str2, str, e);
                method = null;
            }
            if (method != null) {
                try {
                    method.invoke(null, new Object[]{deviceLogEntry.getLogLevel().getLogTag(), deviceLogEntry.getParsedMessage()});
                } catch (Exception e2) {
                    Log.e(str2, str, e2);
                }
            }
        }
    }
}
