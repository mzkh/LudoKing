package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzr;
import com.google.android.gms.ads.internal.overlay.zzs;
import com.google.android.gms.ads.internal.overlay.zzu;
import com.google.android.gms.ads.internal.overlay.zzx;
import com.google.android.gms.ads.internal.overlay.zzz;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzabm;
import com.google.android.gms.internal.ads.zzabt;
import com.google.android.gms.internal.ads.zzajx;
import com.google.android.gms.internal.ads.zzano;
import com.google.android.gms.internal.ads.zzany;
import com.google.android.gms.internal.ads.zzaqb;
import com.google.android.gms.internal.ads.zzara;
import com.google.android.gms.internal.ads.zzaxl;
import com.google.android.gms.internal.ads.zzbei;
import com.google.android.gms.internal.ads.zzbve;
import com.google.android.gms.internal.ads.zzbvh;
import com.google.android.gms.internal.ads.zzcly;
import com.google.android.gms.internal.ads.zzcma;
import com.google.android.gms.internal.ads.zzcme;
import com.google.android.gms.internal.ads.zzcmk;
import com.google.android.gms.internal.ads.zzua;
import com.google.android.gms.internal.ads.zzve;
import com.google.android.gms.internal.ads.zzvl;
import com.google.android.gms.internal.ads.zzvx;
import com.google.android.gms.internal.ads.zzwb;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public class ClientApi extends zzvx {
    public final zzwb zzg(IObjectWrapper iObjectWrapper) {
        return null;
    }

    public final zzany zzh(IObjectWrapper iObjectWrapper) {
        return null;
    }

    public final zzvl zza(IObjectWrapper iObjectWrapper, zzua zzua, String str, zzajx zzajx, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        return new zzcme(zzbei.zza(context, zzajx, i), context, zzua, str);
    }

    public final zzvl zzb(IObjectWrapper iObjectWrapper, zzua zzua, String str, zzajx zzajx, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        return new zzcmk(zzbei.zza(context, zzajx, i), context, zzua, str);
    }

    public final zzve zza(IObjectWrapper iObjectWrapper, String str, zzajx zzajx, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        return new zzcly(zzbei.zza(context, zzajx, i), context, str);
    }

    public final zzabm zzc(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        return new zzbvh((FrameLayout) ObjectWrapper.unwrap(iObjectWrapper), (FrameLayout) ObjectWrapper.unwrap(iObjectWrapper2), 15601000);
    }

    public final zzaqb zza(IObjectWrapper iObjectWrapper, zzajx zzajx, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        return zzbei.zza(context, zzajx, i).zzabn().zzbt(context).zzadm().zzadk();
    }

    public final zzano zzf(IObjectWrapper iObjectWrapper) {
        Activity activity = (Activity) ObjectWrapper.unwrap(iObjectWrapper);
        AdOverlayInfoParcel zzc = AdOverlayInfoParcel.zzc(activity.getIntent());
        if (zzc == null) {
            return new zzr(activity);
        }
        int i = zzc.zzdid;
        if (i == 1) {
            return new zzs(activity);
        }
        if (i == 2) {
            return new zzx(activity);
        }
        if (i == 3) {
            return new zzz(activity);
        }
        if (i != 4) {
            return new zzr(activity);
        }
        return new zzu(activity, zzc);
    }

    public final zzwb zza(IObjectWrapper iObjectWrapper, int i) {
        return zzbei.zzd((Context) ObjectWrapper.unwrap(iObjectWrapper), i).zzabh();
    }

    public final zzvl zza(IObjectWrapper iObjectWrapper, zzua zzua, String str, int i) {
        return new zzl((Context) ObjectWrapper.unwrap(iObjectWrapper), zzua, str, new zzaxl(15601000, i, true, false));
    }

    public final zzabt zza(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        return new zzbve((View) ObjectWrapper.unwrap(iObjectWrapper), (HashMap) ObjectWrapper.unwrap(iObjectWrapper2), (HashMap) ObjectWrapper.unwrap(iObjectWrapper3));
    }

    public final zzara zzb(IObjectWrapper iObjectWrapper, String str, zzajx zzajx, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        return zzbei.zza(context, zzajx, i).zzabn().zzbt(context).zzfm(str).zzadm().zzadl();
    }

    public final zzvl zzc(IObjectWrapper iObjectWrapper, zzua zzua, String str, zzajx zzajx, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        return new zzcma(zzbei.zza(context, zzajx, i), context, zzua, str);
    }
}
