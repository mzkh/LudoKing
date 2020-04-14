package com.google.android.gms.internal.ads;

import android.app.AlertDialog.Builder;
import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzavl implements Runnable {
    final /* synthetic */ Context val$context;
    private final /* synthetic */ String zzdto;
    private final /* synthetic */ boolean zzdtp;
    private final /* synthetic */ boolean zzdtq;

    zzavl(zzavm zzavm, Context context, String str, boolean z, boolean z2) {
        this.val$context = context;
        this.zzdto = str;
        this.zzdtp = z;
        this.zzdtq = z2;
    }

    public final void run() {
        Builder builder = new Builder(this.val$context);
        builder.setMessage(this.zzdto);
        if (this.zzdtp) {
            builder.setTitle("Error");
        } else {
            builder.setTitle("Info");
        }
        String str = "Dismiss";
        if (this.zzdtq) {
            builder.setNeutralButton(str, null);
        } else {
            builder.setPositiveButton("Learn More", new zzavo(this));
            builder.setNegativeButton(str, null);
        }
        builder.create().show();
    }
}
