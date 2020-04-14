package com.google.android.gms.internal.ads;

import java.lang.Thread.UncaughtExceptionHandler;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
final class zzaoi implements UncaughtExceptionHandler {
    private final /* synthetic */ zzaod zzdiq;
    private final /* synthetic */ UncaughtExceptionHandler zzdis;

    zzaoi(zzaod zzaod, UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.zzdiq = zzaod;
        this.zzdis = uncaughtExceptionHandler;
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        try {
            this.zzdiq.zza(thread, th);
            UncaughtExceptionHandler uncaughtExceptionHandler = this.zzdis;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            }
        } catch (Throwable th2) {
            UncaughtExceptionHandler uncaughtExceptionHandler2 = this.zzdis;
            if (uncaughtExceptionHandler2 != null) {
                uncaughtExceptionHandler2.uncaughtException(thread, th);
            }
            throw th2;
        }
    }
}
