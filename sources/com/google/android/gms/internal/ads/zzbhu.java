package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzo;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbhu implements zzdwb<Set<zzbqs<zzo>>> {
    private final zzdwo<Executor> zzfck;
    private final zzdwo<zzbhk> zzfcs;
    private final zzdwo<JSONObject> zzfct;

    private zzbhu(zzdwo<zzbhk> zzdwo, zzdwo<Executor> zzdwo2, zzdwo<JSONObject> zzdwo3) {
        this.zzfcs = zzdwo;
        this.zzfck = zzdwo2;
        this.zzfct = zzdwo3;
    }

    public static zzbhu zze(zzdwo<zzbhk> zzdwo, zzdwo<Executor> zzdwo2, zzdwo<JSONObject> zzdwo3) {
        return new zzbhu(zzdwo, zzdwo2, zzdwo3);
    }

    public final /* synthetic */ Object get() {
        Set set;
        zzbhk zzbhk = (zzbhk) this.zzfcs.get();
        Executor executor = (Executor) this.zzfck.get();
        if (((JSONObject) this.zzfct.get()) == null) {
            set = Collections.emptySet();
        } else {
            set = Collections.singleton(new zzbqs(zzbhk, executor));
        }
        return (Set) zzdwh.zza(set, "Cannot return null from a non-@Nullable @Provides method");
    }
}
