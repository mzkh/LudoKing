package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzanc implements OnClickListener {
    private final /* synthetic */ zzana zzdge;

    zzanc(zzana zzana) {
        this.zzdge = zzana;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzdge.zzdn("User canceled the download.");
    }
}
