package com.google.android.gms.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzaxi;
import com.google.android.gms.internal.ads.zzwr;
import com.google.android.gms.internal.ads.zzyg;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class VideoController {
    @KeepForSdk
    public static final int PLAYBACK_STATE_ENDED = 3;
    @KeepForSdk
    public static final int PLAYBACK_STATE_PAUSED = 2;
    @KeepForSdk
    public static final int PLAYBACK_STATE_PLAYING = 1;
    @KeepForSdk
    public static final int PLAYBACK_STATE_READY = 5;
    @KeepForSdk
    public static final int PLAYBACK_STATE_UNKNOWN = 0;
    private final Object lock = new Object();
    @GuardedBy("lock")
    @Nullable
    private zzwr zzabn;
    @GuardedBy("lock")
    @Nullable
    private VideoLifecycleCallbacks zzabo;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
    public static abstract class VideoLifecycleCallbacks {
        public void onVideoEnd() {
        }

        public void onVideoMute(boolean z) {
        }

        public void onVideoPause() {
        }

        public void onVideoPlay() {
        }

        public void onVideoStart() {
        }
    }

    public final void zza(zzwr zzwr) {
        synchronized (this.lock) {
            this.zzabn = zzwr;
            if (this.zzabo != null) {
                setVideoLifecycleCallbacks(this.zzabo);
            }
        }
    }

    public final zzwr zzde() {
        zzwr zzwr;
        synchronized (this.lock) {
            zzwr = this.zzabn;
        }
        return zzwr;
    }

    public final void play() {
        synchronized (this.lock) {
            if (this.zzabn != null) {
                try {
                    this.zzabn.play();
                } catch (RemoteException e) {
                    zzaxi.zzc("Unable to call play on video controller.", e);
                }
            }
        }
    }

    public final void pause() {
        synchronized (this.lock) {
            if (this.zzabn != null) {
                try {
                    this.zzabn.pause();
                } catch (RemoteException e) {
                    zzaxi.zzc("Unable to call pause on video controller.", e);
                }
            }
        }
    }

    public final void stop() {
        synchronized (this.lock) {
            if (this.zzabn != null) {
                try {
                    this.zzabn.stop();
                } catch (RemoteException e) {
                    zzaxi.zzc("Unable to call stop on video controller.", e);
                }
            }
        }
    }

    public final void mute(boolean z) {
        synchronized (this.lock) {
            if (this.zzabn != null) {
                try {
                    this.zzabn.mute(z);
                } catch (RemoteException e) {
                    zzaxi.zzc("Unable to call mute on video controller.", e);
                }
            }
        }
    }

    public final boolean isMuted() {
        synchronized (this.lock) {
            if (this.zzabn == null) {
                return true;
            }
            try {
                boolean isMuted = this.zzabn.isMuted();
                return isMuted;
            } catch (RemoteException e) {
                zzaxi.zzc("Unable to call isMuted on video controller.", e);
                return true;
            }
        }
    }

    @KeepForSdk
    public final int getPlaybackState() {
        synchronized (this.lock) {
            if (this.zzabn == null) {
                return 0;
            }
            try {
                int playbackState = this.zzabn.getPlaybackState();
                return playbackState;
            } catch (RemoteException e) {
                zzaxi.zzc("Unable to call getPlaybackState on video controller.", e);
                return 0;
            }
        }
    }

    public final boolean isCustomControlsEnabled() {
        synchronized (this.lock) {
            if (this.zzabn == null) {
                return false;
            }
            try {
                boolean isCustomControlsEnabled = this.zzabn.isCustomControlsEnabled();
                return isCustomControlsEnabled;
            } catch (RemoteException e) {
                zzaxi.zzc("Unable to call isUsingCustomPlayerControls.", e);
                return false;
            }
        }
    }

    public final boolean isClickToExpandEnabled() {
        synchronized (this.lock) {
            if (this.zzabn == null) {
                return false;
            }
            try {
                boolean isClickToExpandEnabled = this.zzabn.isClickToExpandEnabled();
                return isClickToExpandEnabled;
            } catch (RemoteException e) {
                zzaxi.zzc("Unable to call isClickToExpandEnabled.", e);
                return false;
            }
        }
    }

    public final void setVideoLifecycleCallbacks(VideoLifecycleCallbacks videoLifecycleCallbacks) {
        Preconditions.checkNotNull(videoLifecycleCallbacks, "VideoLifecycleCallbacks may not be null.");
        synchronized (this.lock) {
            this.zzabo = videoLifecycleCallbacks;
            if (this.zzabn != null) {
                try {
                    this.zzabn.zza(new zzyg(videoLifecycleCallbacks));
                } catch (RemoteException e) {
                    zzaxi.zzc("Unable to call setVideoLifecycleCallbacks on video controller.", e);
                }
            }
        }
    }

    @Nullable
    public final VideoLifecycleCallbacks getVideoLifecycleCallbacks() {
        VideoLifecycleCallbacks videoLifecycleCallbacks;
        synchronized (this.lock) {
            videoLifecycleCallbacks = this.zzabo;
        }
        return videoLifecycleCallbacks;
    }

    public final boolean hasVideoContent() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzabn != null;
        }
        return z;
    }

    public final float getAspectRatio() {
        synchronized (this.lock) {
            if (this.zzabn == null) {
                return 0.0f;
            }
            try {
                float aspectRatio = this.zzabn.getAspectRatio();
                return aspectRatio;
            } catch (RemoteException e) {
                zzaxi.zzc("Unable to call getAspectRatio on video controller.", e);
                return 0.0f;
            }
        }
    }
}
