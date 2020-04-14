package com.inmobi.media;

import java.lang.Thread.UncaughtExceptionHandler;

/* renamed from: com.inmobi.media.fg */
/* compiled from: InMobiCrashHandler */
public class C2470fg implements UncaughtExceptionHandler {

    /* renamed from: b */
    private static final String f5378b = "fg";

    /* renamed from: a */
    private UncaughtExceptionHandler f5379a;

    C2470fg(UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f5379a = uncaughtExceptionHandler;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        int length = stackTrace.length;
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            StackTraceElement stackTraceElement = stackTrace[i];
            if (stackTraceElement.getClassName().contains("com.inmobi.") || stackTraceElement.getClassName().contains("com.aerserv.")) {
                z = true;
            } else {
                i++;
            }
        }
        if (z) {
            try {
                C2463fd.m5161a().mo28381a(new C2469ff(thread, th));
            } catch (Exception unused) {
            }
        }
        this.f5379a.uncaughtException(thread, th);
    }
}
