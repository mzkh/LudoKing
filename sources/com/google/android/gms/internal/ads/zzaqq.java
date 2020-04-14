package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzaqq implements RewardedVideoAd {
    private final Object lock = new Object();
    @NonNull
    private final zzaqb zzdnx;
    private final zzaql zzdny = new zzaql(null);
    private String zzdnz;
    private String zzdoa;
    private final Context zzlk;

    public zzaqq(Context context, @Nullable zzaqb zzaqb) {
        if (zzaqb == null) {
            zzaqb = new zzxy();
        }
        this.zzdnx = zzaqb;
        this.zzlk = context.getApplicationContext();
    }

    private final void zza(String str, zzwz zzwz) {
        synchronized (this.lock) {
            if (this.zzdnx != null) {
                try {
                    this.zzdnx.zza(zzty.zza(this.zzlk, zzwz, str));
                } catch (RemoteException e) {
                    zzaxi.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final void loadAd(String str, AdRequest adRequest) {
        zza(str, adRequest.zzdb());
    }

    public final void loadAd(String str, PublisherAdRequest publisherAdRequest) {
        zza(str, publisherAdRequest.zzdb());
    }

    public final void show() {
        synchronized (this.lock) {
            if (this.zzdnx != null) {
                try {
                    this.zzdnx.show();
                } catch (RemoteException e) {
                    zzaxi.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        synchronized (this.lock) {
            this.zzdny.setRewardedVideoAdListener(rewardedVideoAdListener);
            if (this.zzdnx != null) {
                try {
                    this.zzdnx.zza((zzaqi) this.zzdny);
                } catch (RemoteException e) {
                    zzaxi.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final void setAdMetadataListener(AdMetadataListener adMetadataListener) {
        synchronized (this.lock) {
            if (this.zzdnx != null) {
                try {
                    this.zzdnx.zza((zzvo) new zztu(adMetadataListener));
                } catch (RemoteException e) {
                    zzaxi.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final Bundle getAdMetadata() {
        synchronized (this.lock) {
            if (this.zzdnx != null) {
                try {
                    Bundle adMetadata = this.zzdnx.getAdMetadata();
                    return adMetadata;
                } catch (RemoteException e) {
                    zzaxi.zze("#007 Could not call remote method.", e);
                }
            }
            Bundle bundle = new Bundle();
            return bundle;
        }
    }

    public final void setUserId(String str) {
        synchronized (this.lock) {
            this.zzdnz = str;
            if (this.zzdnx != null) {
                try {
                    this.zzdnx.setUserId(str);
                } catch (RemoteException e) {
                    zzaxi.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final boolean isLoaded() {
        synchronized (this.lock) {
            if (this.zzdnx == null) {
                return false;
            }
            try {
                boolean isLoaded = this.zzdnx.isLoaded();
                return isLoaded;
            } catch (RemoteException e) {
                zzaxi.zze("#007 Could not call remote method.", e);
                return false;
            }
        }
    }

    public final void pause() {
        pause(null);
    }

    public final void pause(Context context) {
        synchronized (this.lock) {
            if (this.zzdnx != null) {
                try {
                    this.zzdnx.zzn(ObjectWrapper.wrap(context));
                } catch (RemoteException e) {
                    zzaxi.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final void resume() {
        resume(null);
    }

    public final void resume(Context context) {
        synchronized (this.lock) {
            if (this.zzdnx != null) {
                try {
                    this.zzdnx.zzo(ObjectWrapper.wrap(context));
                } catch (RemoteException e) {
                    zzaxi.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final void destroy() {
        destroy(null);
    }

    public final void destroy(Context context) {
        synchronized (this.lock) {
            this.zzdny.setRewardedVideoAdListener(null);
            if (this.zzdnx != null) {
                try {
                    this.zzdnx.zzp(ObjectWrapper.wrap(context));
                } catch (RemoteException e) {
                    zzaxi.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final RewardedVideoAdListener getRewardedVideoAdListener() {
        RewardedVideoAdListener rewardedVideoAdListener;
        synchronized (this.lock) {
            rewardedVideoAdListener = this.zzdny.getRewardedVideoAdListener();
        }
        return rewardedVideoAdListener;
    }

    public final String getUserId() {
        String str;
        synchronized (this.lock) {
            str = this.zzdnz;
        }
        return str;
    }

    public final String getMediationAdapterClassName() {
        try {
            if (this.zzdnx != null) {
                return this.zzdnx.getMediationAdapterClassName();
            }
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
        return null;
    }

    public final void setImmersiveMode(boolean z) {
        synchronized (this.lock) {
            if (this.zzdnx != null) {
                try {
                    this.zzdnx.setImmersiveMode(z);
                } catch (RemoteException e) {
                    zzaxi.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final void setCustomData(String str) {
        synchronized (this.lock) {
            if (this.zzdnx != null) {
                try {
                    this.zzdnx.setCustomData(str);
                    this.zzdoa = str;
                } catch (RemoteException e) {
                    zzaxi.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final String getCustomData() {
        String str;
        synchronized (this.lock) {
            str = this.zzdoa;
        }
        return str;
    }
}
