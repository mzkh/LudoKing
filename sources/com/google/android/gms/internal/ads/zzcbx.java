package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcbx {
    public static Set<zzbqs<zzbnm>> zza(zzcch zzcch, Executor executor) {
        return zzc((T) zzcch, executor);
    }

    public static Set<zzbqs<AppEventListener>> zzb(zzcch zzcch, Executor executor) {
        return zzc((T) zzcch, executor);
    }

    public static Set<zzbqs<zzbog>> zzc(zzcch zzcch, Executor executor) {
        return zzc((T) zzcch, executor);
    }

    public static Set<zzbqs<zzbnb>> zzd(zzcch zzcch, Executor executor) {
        return zzc((T) zzcch, executor);
    }

    public static Set<zzbqs<zzbna>> zze(zzcch zzcch, Executor executor) {
        return zzc((T) zzcch, executor);
    }

    public static Set<zzbqs<zzbnj>> zzf(zzcch zzcch, Executor executor) {
        return zzc((T) zzcch, executor);
    }

    public static Set<zzbqs<zztp>> zzg(zzcch zzcch, Executor executor) {
        return zzc((T) zzcch, executor);
    }

    public static Set<zzbqs<zzcym>> zzh(zzcch zzcch, Executor executor) {
        return zzc((T) zzcch, executor);
    }

    public static Set<zzbqs<zzbpc>> zzi(zzcch zzcch, Executor executor) {
        return zzc((T) zzcch, executor);
    }

    private static <T> Set<zzbqs<T>> zzc(T t, Executor executor) {
        if (((Boolean) zzuv.zzon().zzd(zzza.zzclv)).booleanValue()) {
            return Collections.singleton(new zzbqs(t, executor));
        }
        return Collections.emptySet();
    }
}
