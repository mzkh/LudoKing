package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzamx implements OnClickListener {
    private final /* synthetic */ zzamu zzdfn;

    zzamx(zzamu zzamu) {
        this.zzdfn = zzamu;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent createIntent = this.zzdfn.createIntent();
        zzq.zzkj();
        zzaul.zza(this.zzdfn.zzlk, createIntent);
    }
}
