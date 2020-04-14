package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzawl extends zzauc {
    private final String url;
    private final zzaxm zzduy;

    public zzawl(Context context, String str, String str2) {
        this(str2, zzq.zzkj().zzr(context, str));
    }

    private zzawl(String str, String str2) {
        this.zzduy = new zzaxm(str2);
        this.url = str;
    }

    public final void zzsx() {
        this.zzduy.zzei(this.url);
    }
}
