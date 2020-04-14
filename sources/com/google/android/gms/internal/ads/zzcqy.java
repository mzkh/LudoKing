package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcqy implements zzcru<zzcrr<Bundle>> {
    private final String zzfgt;
    private final Context zzlk;

    zzcqy(Context context, @Nullable String str) {
        this.zzlk = context;
        this.zzfgt = str;
    }

    public final zzddi<zzcrr<Bundle>> zzalv() {
        zzcqx zzcqx;
        if (this.zzfgt == null) {
            zzcqx = null;
        } else {
            zzcqx = new zzcqx(this);
        }
        return zzdcy.zzah(zzcqx);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzo(Bundle bundle) {
        bundle.putString("rewarded_sku_package", this.zzlk.getPackageName());
    }
}
