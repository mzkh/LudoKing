package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzast implements zzatb {
    private final String zzcyz;
    private final Context zzdpy;

    zzast(Context context, String str) {
        this.zzdpy = context;
        this.zzcyz = str;
    }

    public final void zzb(zzbeb zzbeb) {
        Context context = this.zzdpy;
        zzbeb.zzb(ObjectWrapper.wrap(context), this.zzcyz, context.getPackageName());
    }
}
