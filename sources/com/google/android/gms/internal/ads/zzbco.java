package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbco extends zzwq {
    private final Object lock = new Object();
    @GuardedBy("lock")
    private boolean zzabq;
    @GuardedBy("lock")
    private boolean zzabr;
    @GuardedBy("lock")
    private int zzacz;
    @GuardedBy("lock")
    private zzws zzddr;
    private final zzazj zzdya;
    private final boolean zzehl;
    private final boolean zzehm;
    @GuardedBy("lock")
    private boolean zzehn;
    @GuardedBy("lock")
    private boolean zzeho = true;
    @GuardedBy("lock")
    private float zzehp;
    @GuardedBy("lock")
    private float zzehq;
    @GuardedBy("lock")
    private float zzehr;

    public zzbco(zzazj zzazj, float f, boolean z, boolean z2) {
        this.zzdya = zzazj;
        this.zzehp = f;
        this.zzehl = z;
        this.zzehm = z2;
    }

    public final void play() {
        zzf("play", null);
    }

    public final void pause() {
        zzf("pause", null);
    }

    public final void stop() {
        zzf("stop", null);
    }

    public final void mute(boolean z) {
        zzf(z ? "mute" : "unmute", null);
    }

    public final void zzb(zzyj zzyj) {
        boolean z = zzyj.zzabp;
        boolean z2 = zzyj.zzabq;
        boolean z3 = zzyj.zzabr;
        synchronized (this.lock) {
            this.zzabq = z2;
            this.zzabr = z3;
        }
        zzf("initialState", CollectionUtils.mapOf("muteStart", z ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO, "customControlsRequested", z2 ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO, "clickToExpandRequested", z3 ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO));
    }

    private final void zzf(String str, @Nullable Map<String, String> map) {
        HashMap hashMap = map == null ? new HashMap() : new HashMap(map);
        hashMap.put(NativeProtocol.WEB_DIALOG_ACTION, str);
        zzaxn.zzdwm.execute(new zzbcn(this, hashMap));
    }

    public final boolean isMuted() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzeho;
        }
        return z;
    }

    public final int getPlaybackState() {
        int i;
        synchronized (this.lock) {
            i = this.zzacz;
        }
        return i;
    }

    public final float getAspectRatio() {
        float f;
        synchronized (this.lock) {
            f = this.zzehr;
        }
        return f;
    }

    public final float zzox() {
        float f;
        synchronized (this.lock) {
            f = this.zzehp;
        }
        return f;
    }

    public final float zzoy() {
        float f;
        synchronized (this.lock) {
            f = this.zzehq;
        }
        return f;
    }

    public final void zza(zzws zzws) {
        synchronized (this.lock) {
            this.zzddr = zzws;
        }
    }

    public final zzws zzoz() throws RemoteException {
        zzws zzws;
        synchronized (this.lock) {
            zzws = this.zzddr;
        }
        return zzws;
    }

    public final boolean isCustomControlsEnabled() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzehl && this.zzabq;
        }
        return z;
    }

    public final boolean isClickToExpandEnabled() {
        boolean z;
        boolean isCustomControlsEnabled = isCustomControlsEnabled();
        synchronized (this.lock) {
            if (!isCustomControlsEnabled) {
                try {
                    if (this.zzabr && this.zzehm) {
                        z = true;
                    }
                } finally {
                }
            }
            z = false;
        }
        return z;
    }

    public final void zze(float f) {
        synchronized (this.lock) {
            this.zzehq = f;
        }
    }

    public final void zzaap() {
        boolean z;
        int i;
        synchronized (this.lock) {
            z = this.zzeho;
            i = this.zzacz;
            this.zzacz = 3;
        }
        zza(i, 3, z, z);
    }

    public final void zza(float f, float f2, int i, boolean z, float f3) {
        boolean z2;
        int i2;
        synchronized (this.lock) {
            this.zzehp = f2;
            this.zzehq = f;
            z2 = this.zzeho;
            this.zzeho = z;
            i2 = this.zzacz;
            this.zzacz = i;
            float f4 = this.zzehr;
            this.zzehr = f3;
            if (Math.abs(this.zzehr - f4) > 1.0E-4f) {
                this.zzdya.getView().invalidate();
            }
        }
        zza(i2, i, z2, z);
    }

    private final void zza(int i, int i2, boolean z, boolean z2) {
        zzddl zzddl = zzaxn.zzdwm;
        zzbcq zzbcq = new zzbcq(this, i, i2, z, z2);
        zzddl.execute(zzbcq);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzb(int i, int i2, boolean z, boolean z2) {
        synchronized (this.lock) {
            boolean z3 = false;
            boolean z4 = i != i2;
            boolean z5 = !this.zzehn && i2 == 1;
            boolean z6 = z4 && i2 == 1;
            boolean z7 = z4 && i2 == 2;
            boolean z8 = z4 && i2 == 3;
            boolean z9 = z != z2;
            if (this.zzehn || z5) {
                z3 = true;
            }
            this.zzehn = z3;
            if (z5) {
                try {
                    if (this.zzddr != null) {
                        this.zzddr.onVideoStart();
                    }
                } catch (RemoteException e) {
                    zzaxi.zze("#007 Could not call remote method.", e);
                }
            }
            if (z6 && this.zzddr != null) {
                this.zzddr.onVideoPlay();
            }
            if (z7 && this.zzddr != null) {
                this.zzddr.onVideoPause();
            }
            if (z8) {
                if (this.zzddr != null) {
                    this.zzddr.onVideoEnd();
                }
                this.zzdya.zzxu();
            }
            if (z9 && this.zzddr != null) {
                this.zzddr.onVideoMute(z2);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzj(Map map) {
        this.zzdya.zza("pubVideoCmd", map);
    }
}
