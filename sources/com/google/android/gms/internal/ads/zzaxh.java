package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzaxh {
    public static <T> T zza(Context context, String str, zzaxk<IBinder, T> zzaxk) throws zzaxj {
        try {
            return zzaxk.apply(zzbq(context).instantiate(str));
        } catch (Exception e) {
            throw new zzaxj(e);
        }
    }

    public static Context zzbp(Context context) throws zzaxj {
        return zzbq(context).getModuleContext();
    }

    private static DynamiteModule zzbq(Context context) throws zzaxj {
        try {
            return DynamiteModule.load(context, DynamiteModule.PREFER_REMOTE, ModuleDescriptor.MODULE_ID);
        } catch (Exception e) {
            throw new zzaxj(e);
        }
    }
}
