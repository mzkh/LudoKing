package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.TextureView;

@TargetApi(14)
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public abstract class zzayu extends TextureView implements zzazn {
    protected final zzaze zzdxx = new zzaze();
    protected final zzazo zzdxy;

    public zzayu(Context context) {
        super(context);
        this.zzdxy = new zzazo(context, this);
    }

    public abstract int getCurrentPosition();

    public abstract int getDuration();

    public abstract int getVideoHeight();

    public abstract int getVideoWidth();

    public abstract void pause();

    public abstract void play();

    public abstract void seekTo(int i);

    public abstract void setVideoPath(String str);

    public abstract void stop();

    public abstract void zza(float f, float f2);

    public abstract void zza(zzayr zzayr);

    public void zzcs(int i) {
    }

    public void zzct(int i) {
    }

    public void zzcu(int i) {
    }

    public void zzcv(int i) {
    }

    public void zzcw(int i) {
    }

    public abstract String zzwq();

    public abstract void zzwu();

    public void zzb(String str, String[] strArr) {
        setVideoPath(str);
    }
}
