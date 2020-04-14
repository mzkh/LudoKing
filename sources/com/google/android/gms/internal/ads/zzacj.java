package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd.DisplayOpenMeasurement;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;
import java.util.WeakHashMap;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzacj implements NativeCustomTemplateAd {
    private static WeakHashMap<IBinder, zzacj> zzcwl = new WeakHashMap<>();
    private final VideoController zzcen = new VideoController();
    private final zzace zzcwm;
    private final MediaView zzcwn;
    private DisplayOpenMeasurement zzcwo;

    @VisibleForTesting
    private zzacj(zzace zzace) {
        Context context;
        String str = "";
        this.zzcwm = zzace;
        MediaView mediaView = null;
        try {
            context = (Context) ObjectWrapper.unwrap(zzace.zzqr());
        } catch (RemoteException | NullPointerException e) {
            zzaxi.zzc(str, e);
            context = null;
        }
        if (context != null) {
            MediaView mediaView2 = new MediaView(context);
            try {
                if (this.zzcwm.zzu(ObjectWrapper.wrap(mediaView2))) {
                    mediaView = mediaView2;
                }
            } catch (RemoteException e2) {
                zzaxi.zzc(str, e2);
            }
        }
        this.zzcwn = mediaView;
    }

    public static zzacj zza(zzace zzace) {
        synchronized (zzcwl) {
            zzacj zzacj = (zzacj) zzcwl.get(zzace.asBinder());
            if (zzacj != null) {
                return zzacj;
            }
            zzacj zzacj2 = new zzacj(zzace);
            zzcwl.put(zzace.asBinder(), zzacj2);
            return zzacj2;
        }
    }

    public final zzace zzqv() {
        return this.zzcwm;
    }

    public final CharSequence getText(String str) {
        try {
            return this.zzcwm.zzco(str);
        } catch (RemoteException e) {
            zzaxi.zzc("", e);
            return null;
        }
    }

    public final Image getImage(String str) {
        try {
            zzabi zzcp = this.zzcwm.zzcp(str);
            if (zzcp != null) {
                return new zzabn(zzcp);
            }
        } catch (RemoteException e) {
            zzaxi.zzc("", e);
        }
        return null;
    }

    public final VideoController getVideoController() {
        try {
            zzwr videoController = this.zzcwm.getVideoController();
            if (videoController != null) {
                this.zzcen.zza(videoController);
            }
        } catch (RemoteException e) {
            zzaxi.zzc("Exception occurred while getting video controller", e);
        }
        return this.zzcen;
    }

    public final MediaView getVideoMediaView() {
        return this.zzcwn;
    }

    public final List<String> getAvailableAssetNames() {
        try {
            return this.zzcwm.getAvailableAssetNames();
        } catch (RemoteException e) {
            zzaxi.zzc("", e);
            return null;
        }
    }

    public final String getCustomTemplateId() {
        try {
            return this.zzcwm.getCustomTemplateId();
        } catch (RemoteException e) {
            zzaxi.zzc("", e);
            return null;
        }
    }

    public final void performClick(String str) {
        try {
            this.zzcwm.performClick(str);
        } catch (RemoteException e) {
            zzaxi.zzc("", e);
        }
    }

    public final void recordImpression() {
        try {
            this.zzcwm.recordImpression();
        } catch (RemoteException e) {
            zzaxi.zzc("", e);
        }
    }

    public final DisplayOpenMeasurement getDisplayOpenMeasurement() {
        try {
            if (this.zzcwo == null && this.zzcwm.zzqs()) {
                this.zzcwo = new zzabe(this.zzcwm);
            }
        } catch (RemoteException e) {
            zzaxi.zzc("", e);
        }
        return this.zzcwo;
    }

    public final void destroy() {
        try {
            this.zzcwm.destroy();
        } catch (RemoteException e) {
            zzaxi.zzc("", e);
        }
    }
}
