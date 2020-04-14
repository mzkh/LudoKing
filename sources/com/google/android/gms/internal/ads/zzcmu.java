package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzbmk.zza;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcmu implements zzcmq<zzbkk> {
    private final zzbei zzfza;
    private final Context zzgbp;
    @GuardedBy("this")
    private final zzcwg zzgbq;
    private final zzcmo zzgdd;
    @GuardedBy("this")
    @Nullable
    private zzbkv zzgde;

    public zzcmu(zzbei zzbei, Context context, zzcmo zzcmo, zzcwg zzcwg) {
        this.zzfza = zzbei;
        this.zzgbp = context;
        this.zzgdd = zzcmo;
        this.zzgbq = zzcwg;
    }

    public final boolean isLoading() {
        zzbkv zzbkv = this.zzgde;
        return zzbkv != null && zzbkv.isLoading();
    }

    public final boolean zza(zztx zztx, String str, zzcmt zzcmt, zzcms<? super zzbkk> zzcms) throws RemoteException {
        if (str == null) {
            zzaug.zzes("Ad unit ID should not be null for NativeAdLoader.");
            this.zzfza.zzabb().execute(new zzcmx(this));
            return false;
        }
        zzcwj.zze(this.zzgbp, zztx.zzcca);
        zzcwe zzane = this.zzgbq.zzg(zztx).zzdi(zzcmt instanceof zzcmv ? ((zzcmv) zzcmt).zzgdf : 1).zzane();
        zzbtl zzacd = this.zzfza.zzabl().zza(new zza().zzby(this.zzgbp).zza(zzane).zzafy()).zza(new zzbpn.zza().zza(this.zzgdd.zzalm(), this.zzfza.zzabb()).zza(this.zzgdd.zzaln(), this.zzfza.zzabb()).zza(this.zzgdd.zzalo(), this.zzfza.zzabb()).zza(this.zzgdd.zzalp(), this.zzfza.zzabb()).zza(this.zzgdd.zzall(), this.zzfza.zzabb()).zza(zzane.zzgkm, this.zzfza.zzabb()).zzagm()).zza(this.zzgdd.zzalk()).zzacd();
        zzacd.zzacc().zzdj(1);
        this.zzgde = new zzbkv(this.zzfza.zzabd(), this.zzfza.zzabc(), zzacd.zzaca().zzafs());
        this.zzgde.zza((zzdcz<zzbkk>) new zzcmw<zzbkk>(this, zzcms, zzacd));
        return true;
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzalr() {
        this.zzgdd.zzaln().onAdFailedToLoad(1);
    }
}
