package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzavo implements OnClickListener {
    private final /* synthetic */ zzavl zzdtv;

    zzavo(zzavl zzavl) {
        this.zzdtv = zzavl;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        zzq.zzkj();
        zzaul.zza(this.zzdtv.val$context, Uri.parse("https://support.google.com/dfp_premium/answer/7160685#push"));
    }
}
