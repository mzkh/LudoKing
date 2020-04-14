package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.internal.ads.zzbpn.zza;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcvb implements zzcmq<zzbyz> {
    private final Executor zzfbx;
    private final zzcwc zzfgu;
    @GuardedBy("this")
    private final zzcwg zzgbq;
    private final zzbei zzgdl;
    private final Context zzgic;
    /* access modifiers changed from: private */
    public final zzcui zzgid;
    /* access modifiers changed from: private */
    public final zzcud<zzbzc, zzbyz> zzgie;
    @GuardedBy("this")
    private zzddi<zzbyz> zzgif;

    public zzcvb(Context context, Executor executor, zzbei zzbei, zzcud<zzbzc, zzbyz> zzcud, zzcui zzcui, zzcwg zzcwg, zzcwc zzcwc) {
        this.zzgic = context;
        this.zzfbx = executor;
        this.zzgdl = zzbei;
        this.zzgie = zzcud;
        this.zzgid = zzcui;
        this.zzgbq = zzcwg;
        this.zzfgu = zzcwc;
    }

    public final boolean isLoading() {
        zzddi<zzbyz> zzddi = this.zzgif;
        return zzddi != null && !zzddi.isDone();
    }

    public final boolean zza(zztx zztx, String str, zzcmt zzcmt, zzcms<? super zzbyz> zzcms) throws RemoteException {
        zzaqo zzaqo = new zzaqo(zztx, str);
        String str2 = zzcmt instanceof zzcvc ? ((zzcvc) zzcmt).zzgig : null;
        if (zzaqo.zzbqy == null) {
            zzaug.zzes("Ad unit ID should not be null for rewarded video ad.");
            this.zzfbx.execute(new zzcve(this));
            return false;
        }
        zzddi<zzbyz> zzddi = this.zzgif;
        if (zzddi != null && !zzddi.isDone()) {
            return false;
        }
        zzcwj.zze(this.zzgic, zzaqo.zzdiu.zzcca);
        zzcwe zzane = this.zzgbq.zzgf(zzaqo.zzbqy).zzd(zzua.zzoa()).zzg(zzaqo.zzdiu).zzane();
        zza zza = new zza();
        zza.zza((zzbna) this.zzgid, this.zzfbx);
        zza.zza((zzbog) this.zzgid, this.zzfbx);
        zza.zza((zzbnb) this.zzgid, this.zzfbx);
        zza.zza((AdMetadataListener) this.zzgid, this.zzfbx);
        zza.zza((zzbnf) this.zzgid, this.zzfbx);
        this.zzgif = this.zzgie.zza(this.zzgdl.zzabm().zze(new zzbmk.zza().zzby(this.zzgic).zza(zzane).zzfn(str2).zza(this.zzfgu).zzafy()).zze(zza.zzagm()), this.zzfbx);
        zzdcy.zza(this.zzgif, new zzcvd(this, zzcms), this.zzfbx);
        return true;
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzamv() {
        this.zzgid.onAdFailedToLoad(1);
    }
}
