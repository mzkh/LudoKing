package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;

@TargetApi(14)
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzazo implements OnAudioFocusChangeListener {
    private float zzcw = 1.0f;
    private boolean zzdyg;
    private final AudioManager zzebf;
    private final zzazn zzebg;
    private boolean zzebh;
    private boolean zzebi;

    public zzazo(Context context, zzazn zzazn) {
        this.zzebf = (AudioManager) context.getSystemService("audio");
        this.zzebg = zzazn;
    }

    public final void setMuted(boolean z) {
        this.zzebi = z;
        zzxy();
    }

    public final void setVolume(float f) {
        this.zzcw = f;
        zzxy();
    }

    public final float getVolume() {
        float f = this.zzebi ? 0.0f : this.zzcw;
        if (this.zzebh) {
            return f;
        }
        return 0.0f;
    }

    public final void zzxw() {
        this.zzdyg = true;
        zzxy();
    }

    public final void zzxx() {
        this.zzdyg = false;
        zzxy();
    }

    public final void onAudioFocusChange(int i) {
        this.zzebh = i > 0;
        this.zzebg.zzwu();
    }

    private final void zzxy() {
        boolean z = false;
        boolean z2 = this.zzdyg && !this.zzebi && this.zzcw > 0.0f;
        if (z2) {
            boolean z3 = this.zzebh;
            if (!z3) {
                AudioManager audioManager = this.zzebf;
                if (audioManager != null && !z3) {
                    if (audioManager.requestAudioFocus(this, 3, 2) == 1) {
                        z = true;
                    }
                    this.zzebh = z;
                }
                this.zzebg.zzwu();
                return;
            }
        }
        if (!z2) {
            boolean z4 = this.zzebh;
            if (z4) {
                AudioManager audioManager2 = this.zzebf;
                if (audioManager2 != null && z4) {
                    if (audioManager2.abandonAudioFocus(this) == 0) {
                        z = true;
                    }
                    this.zzebh = z;
                }
                this.zzebg.zzwu();
            }
        }
    }
}
