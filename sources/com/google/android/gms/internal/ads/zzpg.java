package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.ArrayList;
import java.util.WeakHashMap;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzpg {
    private final Object lock = new Object();
    private final zzaxl zzblk;
    private final WeakHashMap<Object, Object> zzbns = new WeakHashMap<>();
    private final ArrayList<Object> zzbnt = new ArrayList<>();
    private final zzahn zzbnu;
    private final Context zzzc;

    public zzpg(Context context, zzaxl zzaxl) {
        this.zzzc = context.getApplicationContext();
        this.zzblk = zzaxl;
        this.zzbnu = new zzahn(context.getApplicationContext(), zzaxl, (String) zzuv.zzon().zzd(zzza.zzcgg));
    }
}
