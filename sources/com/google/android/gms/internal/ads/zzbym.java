package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.overlay.zzt;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzbym implements zzo, zzt, zzadw, zzady, zztp {
    private zztp zzcbs;
    private zzadw zzcxc;
    private zzady zzcxd;
    private zzo zzdhy;
    private zzt zzdic;

    private zzbym() {
    }

    public final synchronized void onAdClicked() {
        if (this.zzcbs != null) {
            this.zzcbs.onAdClicked();
        }
    }

    public final synchronized void zzsi() {
        if (this.zzdhy != null) {
            this.zzdhy.zzsi();
        }
    }

    public final synchronized void onPause() {
        if (this.zzdhy != null) {
            this.zzdhy.onPause();
        }
    }

    public final synchronized void onResume() {
        if (this.zzdhy != null) {
            this.zzdhy.onResume();
        }
    }

    public final synchronized void zzsj() {
        if (this.zzdhy != null) {
            this.zzdhy.zzsj();
        }
    }

    public final synchronized void zzsy() {
        if (this.zzdic != null) {
            this.zzdic.zzsy();
        }
    }

    public final synchronized void zza(String str, Bundle bundle) {
        if (this.zzcxc != null) {
            this.zzcxc.zza(str, bundle);
        }
    }

    public final synchronized void onAppEvent(String str, @Nullable String str2) {
        if (this.zzcxd != null) {
            this.zzcxd.onAppEvent(str, str2);
        }
    }

    /* access modifiers changed from: private */
    public final synchronized void zza(zztp zztp, zzadw zzadw, zzo zzo, zzady zzady, zzt zzt) {
        this.zzcbs = zztp;
        this.zzcxc = zzadw;
        this.zzdhy = zzo;
        this.zzcxd = zzady;
        this.zzdic = zzt;
    }

    /* synthetic */ zzbym(zzbyi zzbyi) {
        this();
    }
}
