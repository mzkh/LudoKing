package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbwa implements zzbuz {
    private final zzaxl zzblk;
    private final zzcvr zzfet;
    private final zzcwe zzfga;
    private final zzbni zzfjm;
    private final zzbmv zzfjn;
    private boolean zzfjr = false;
    private boolean zzfju = false;
    @Nullable
    private final zzakg zzfnq;
    @Nullable
    private final zzakl zzfnr;
    @Nullable
    private final zzakm zzfns;
    private final Context zzlk;

    public zzbwa(@Nullable zzakg zzakg, @Nullable zzakl zzakl, @Nullable zzakm zzakm, zzbni zzbni, zzbmv zzbmv, Context context, zzcvr zzcvr, zzaxl zzaxl, zzcwe zzcwe) {
        this.zzfnq = zzakg;
        this.zzfnr = zzakl;
        this.zzfns = zzakm;
        this.zzfjm = zzbni;
        this.zzfjn = zzbmv;
        this.zzlk = context;
        this.zzfet = zzcvr;
        this.zzblk = zzaxl;
        this.zzfga = zzcwe;
    }

    public final void cancelUnconfirmedClick() {
    }

    public final void destroy() {
    }

    public final void setClickConfirmingView(View view) {
    }

    public final void zza(View view, MotionEvent motionEvent, @Nullable View view2) {
    }

    public final void zza(zzadf zzadf) {
    }

    public final void zzahd() {
    }

    public final void zzahf() {
    }

    public final void zzf(Bundle bundle) {
    }

    public final void zzfp(String str) {
    }

    public final void zzg(Bundle bundle) {
    }

    public final boolean zzh(Bundle bundle) {
        return false;
    }

    public final void zza(View view, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2, OnTouchListener onTouchListener, OnClickListener onClickListener) {
        try {
            IObjectWrapper wrap = ObjectWrapper.wrap(view);
            HashMap zzb = zzb(map);
            HashMap zzb2 = zzb(map2);
            if (this.zzfns != null) {
                this.zzfns.zzc(wrap, ObjectWrapper.wrap(zzb), ObjectWrapper.wrap(zzb2));
            } else if (this.zzfnq != null) {
                this.zzfnq.zzc(wrap, ObjectWrapper.wrap(zzb), ObjectWrapper.wrap(zzb2));
                this.zzfnq.zzz(wrap);
            } else {
                if (this.zzfnr != null) {
                    this.zzfnr.zzc(wrap, ObjectWrapper.wrap(zzb), ObjectWrapper.wrap(zzb2));
                    this.zzfnr.zzz(wrap);
                }
            }
        } catch (RemoteException e) {
            zzaug.zzd("Failed to call trackView", e);
        }
    }

    private static HashMap<String, View> zzb(Map<String, WeakReference<View>> map) {
        HashMap<String, View> hashMap = new HashMap<>();
        if (map == null) {
            return hashMap;
        }
        synchronized (map) {
            for (Entry entry : map.entrySet()) {
                View view = (View) ((WeakReference) entry.getValue()).get();
                if (view != null) {
                    hashMap.put((String) entry.getKey(), view);
                }
            }
        }
        return hashMap;
    }

    public final void zza(View view, @Nullable Map<String, WeakReference<View>> map) {
        try {
            IObjectWrapper wrap = ObjectWrapper.wrap(view);
            if (this.zzfns != null) {
                this.zzfns.zzaa(wrap);
            } else if (this.zzfnq != null) {
                this.zzfnq.zzaa(wrap);
            } else {
                if (this.zzfnr != null) {
                    this.zzfnr.zzaa(wrap);
                }
            }
        } catch (RemoteException e) {
            zzaug.zzd("Failed to call untrackView", e);
        }
    }

    public final void zza(View view, @Nullable View view2, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2, boolean z) {
        if (!this.zzfju || !this.zzfet.zzdcn) {
            zzab(view);
        }
    }

    private final void zzab(View view) {
        try {
            if (this.zzfns != null && !this.zzfns.getOverrideClickHandling()) {
                this.zzfns.zzy(ObjectWrapper.wrap(view));
                this.zzfjn.onAdClicked();
            } else if (this.zzfnq == null || this.zzfnq.getOverrideClickHandling()) {
                if (this.zzfnr != null && !this.zzfnr.getOverrideClickHandling()) {
                    this.zzfnr.zzy(ObjectWrapper.wrap(view));
                    this.zzfjn.onAdClicked();
                }
            } else {
                this.zzfnq.zzy(ObjectWrapper.wrap(view));
                this.zzfjn.onAdClicked();
            }
        } catch (RemoteException e) {
            zzaug.zzd("Failed to call handleClick", e);
        }
    }

    public final void zza(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        if (!this.zzfju) {
            zzaug.zzeu("Custom click reporting for 3p ads failed. enableCustomClickGesture is not set.");
        } else if (!this.zzfet.zzdcn) {
            zzaug.zzeu("Custom click reporting for 3p ads failed. Ad unit id not whitelisted.");
        } else {
            zzab(view);
        }
    }

    public final void zzqw() {
        this.zzfju = true;
    }

    public final boolean isCustomClickGestureEnabled() {
        return this.zzfet.zzdcn;
    }

    public final void zza(@Nullable View view, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2) {
        try {
            if (!this.zzfjr && this.zzfet.zzgjj != null) {
                this.zzfjr |= zzq.zzkt().zzb(this.zzlk, this.zzblk.zzblz, this.zzfet.zzgjj.toString(), this.zzfga.zzgkh);
            }
            if (this.zzfns != null && !this.zzfns.getOverrideImpressionRecording()) {
                this.zzfns.recordImpression();
                this.zzfjm.onAdImpression();
            } else if (this.zzfnq == null || this.zzfnq.getOverrideImpressionRecording()) {
                if (this.zzfnr != null && !this.zzfnr.getOverrideImpressionRecording()) {
                    this.zzfnr.recordImpression();
                    this.zzfjm.onAdImpression();
                }
            } else {
                this.zzfnq.recordImpression();
                this.zzfjm.onAdImpression();
            }
        } catch (RemoteException e) {
            zzaug.zzd("Failed to call recordImpression", e);
        }
    }

    public final void zza(@Nullable zzwi zzwi) {
        zzaug.zzeu("Mute This Ad is not supported for 3rd party ads");
    }

    public final void zza(zzwe zzwe) {
        zzaug.zzeu("Mute This Ad is not supported for 3rd party ads");
    }

    public final void zzahe() {
        zzaug.zzeu("Mute This Ad is not supported for 3rd party ads");
    }
}
