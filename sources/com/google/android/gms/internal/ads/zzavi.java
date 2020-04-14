package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzavi implements OnClickListener {
    private final String zzcyz;
    private final zzavd zzdtj;

    zzavi(zzavd zzavd, String str) {
        this.zzdtj = zzavd;
        this.zzcyz = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzdtj.zza(this.zzcyz, dialogInterface, i);
    }
}
