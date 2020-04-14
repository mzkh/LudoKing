package com.google.android.gms.internal.ads;

import java.lang.Thread.UncaughtExceptionHandler;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
final class zzaof implements UncaughtExceptionHandler {
    private final /* synthetic */ UncaughtExceptionHandler zzdip;
    private final /* synthetic */ zzaod zzdiq;

    zzaof(zzaod zzaod, UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.zzdiq = zzaod;
        this.zzdip = uncaughtExceptionHandler;
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        try {
            this.zzdiq.zza(thread, th);
            UncaughtExceptionHandler uncaughtExceptionHandler = this.zzdip;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            }
        } catch (Throwable th2) {
            UncaughtExceptionHandler uncaughtExceptionHandler2 = this.zzdip;
            if (uncaughtExceptionHandler2 != null) {
                uncaughtExceptionHandler2.uncaughtException(thread, th);
            }
            throw th2;
        }
    }
}
