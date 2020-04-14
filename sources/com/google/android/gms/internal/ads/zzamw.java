package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzamw implements OnClickListener {
    private final /* synthetic */ zzamu zzdfn;

    zzamw(zzamu zzamu) {
        this.zzdfn = zzamu;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzdfn.zzdn("Operation denied by user.");
    }
}
