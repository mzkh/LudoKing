package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
final class zzzd implements Callable<Void> {
    private final /* synthetic */ Context val$context;

    zzzd(Context context) {
        this.val$context = context;
    }

    public final /* synthetic */ Object call() throws Exception {
        zzuv.zzon().initialize(this.val$context);
        return null;
    }
}
