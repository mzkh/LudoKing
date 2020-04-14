package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.os.Environment;
import android.os.StatFs;
import android.support.p000v4.media.session.PlaybackStateCompat;
import android.view.View;

@TargetApi(18)
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public class zzauv extends zzauw {
    public final int zzvq() {
        return 14;
    }

    public boolean isAttachedToWindow(View view) {
        return super.isAttachedToWindow(view) || view.getWindowId() != null;
    }

    public final long zzvu() {
        if (!((Boolean) zzuv.zzon().zzd(zzza.zzcnt)).booleanValue()) {
            return -1;
        }
        return new StatFs(Environment.getDataDirectory().getAbsolutePath()).getAvailableBytes() / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
    }
}
