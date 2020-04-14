package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzavf implements OnClickListener {
    private final zzavd zzdtj;
    private final int zzdtk;
    private final int zzdtl;
    private final int zzdtm;

    zzavf(zzavd zzavd, int i, int i2, int i3) {
        this.zzdtj = zzavd;
        this.zzdtk = i;
        this.zzdtl = i2;
        this.zzdtm = i3;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzdtj.zza(this.zzdtk, this.zzdtl, this.zzdtm, dialogInterface, i);
    }
}
