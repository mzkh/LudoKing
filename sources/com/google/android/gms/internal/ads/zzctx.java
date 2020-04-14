package com.google.android.gms.internal.ads;

import java.util.HashSet;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzctx implements zzdwb<zzcrt<JSONObject>> {
    public static zzcrt<JSONObject> zza(Object obj, zzcso zzcso, zzctf zzctf, zzdvv<zzcsi> zzdvv, zzdvv<zzcss> zzdvv2, zzdvv<zzcsw> zzdvv3, zzdvv<zzctb> zzdvv4, zzdvv<zzctk> zzdvv5, zzdvv<zzcto> zzdvv6, zzdvv<zzctz> zzdvv7, Executor executor) {
        zzcsx zzcsx = (zzcsx) obj;
        HashSet hashSet = new HashSet();
        hashSet.add(zzcsx);
        hashSet.add(zzcso);
        hashSet.add(zzctf);
        if (((Boolean) zzuv.zzon().zzd(zzza.zzcsa)).booleanValue()) {
            hashSet.add((zzcru) zzdvv.get());
        }
        if (((Boolean) zzuv.zzon().zzd(zzza.zzcsb)).booleanValue()) {
            hashSet.add((zzcru) zzdvv2.get());
        }
        if (((Boolean) zzuv.zzon().zzd(zzza.zzcsc)).booleanValue()) {
            hashSet.add((zzcru) zzdvv3.get());
        }
        if (((Boolean) zzuv.zzon().zzd(zzza.zzcsd)).booleanValue()) {
            hashSet.add((zzcru) zzdvv4.get());
        }
        if (((Boolean) zzuv.zzon().zzd(zzza.zzcsg)).booleanValue()) {
            hashSet.add((zzcru) zzdvv5.get());
        }
        if (((Boolean) zzuv.zzon().zzd(zzza.zzcsi)).booleanValue()) {
            hashSet.add((zzcru) zzdvv6.get());
        }
        if (((Boolean) zzuv.zzon().zzd(zzza.zzcsj)).booleanValue()) {
            hashSet.add((zzcru) zzdvv7.get());
        }
        return (zzcrt) zzdwh.zza(new zzcrt(executor, hashSet), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        throw new NoSuchMethodError();
    }
}
