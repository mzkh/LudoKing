package com.google.android.gms.internal.ads;

import android.os.Build.VERSION;
import java.util.HashMap;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzcuc implements Callable {
    static final Callable zzgfh = new zzcuc();

    private zzcuc() {
    }

    public final Object call() {
        String[] split;
        HashMap hashMap = new HashMap();
        String str = (String) zzuv.zzon().zzd(zzza.zzchw);
        if (str != null && !str.isEmpty()) {
            if (VERSION.SDK_INT >= ((Integer) zzuv.zzon().zzd(zzza.zzchx)).intValue()) {
                for (String str2 : str.split(",", -1)) {
                    hashMap.put(str2, zzaww.zzem(str2));
                }
            }
        }
        return new zzcua(hashMap);
    }
}
