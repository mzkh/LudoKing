package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;
import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcoy implements zzcru<zzcov> {
    private final zzddl zzfoa;
    private final Context zzlk;

    public zzcoy(zzddl zzddl, Context context) {
        this.zzfoa = zzddl;
        this.zzlk = context;
    }

    public final zzddi<zzcov> zzalv() {
        return this.zzfoa.zzd(new zzcox(this));
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ zzcov zzaly() throws Exception {
        AudioManager audioManager = (AudioManager) this.zzlk.getSystemService("audio");
        zzcov zzcov = new zzcov(audioManager.getMode(), audioManager.isMusicActive(), audioManager.isSpeakerphoneOn(), audioManager.getStreamVolume(3), audioManager.getRingerMode(), audioManager.getStreamVolume(2), zzq.zzko().zzos(), zzq.zzko().zzot());
        return zzcov;
    }
}
