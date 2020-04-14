package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import java.util.concurrent.ThreadFactory;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzoi implements ThreadFactory {
    private final /* synthetic */ String zzbgy;

    zzoi(String str) {
        this.zzbgy = str;
    }

    public final Thread newThread(@NonNull Runnable runnable) {
        return new Thread(runnable, this.zzbgy);
    }
}
