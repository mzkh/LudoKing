package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzbiq extends zzbio {
    private final View view;
    @Nullable
    private final zzbbw zzczi;
    private final Executor zzfbx;
    private final zzcvu zzfde;
    private final zzbkl zzfdn;
    private final zzbuy zzfdo;
    private final zzbqw zzfdp;
    private final zzdvv<zzclw> zzfdq;
    private zzua zzfdr;
    private final Context zzlk;

    zzbiq(zzbkn zzbkn, Context context, zzcvu zzcvu, View view2, @Nullable zzbbw zzbbw, zzbkl zzbkl, zzbuy zzbuy, zzbqw zzbqw, zzdvv<zzclw> zzdvv, Executor executor) {
        super(zzbkn);
        this.zzlk = context;
        this.view = view2;
        this.zzczi = zzbbw;
        this.zzfde = zzcvu;
        this.zzfdn = zzbkl;
        this.zzfdo = zzbuy;
        this.zzfdp = zzbqw;
        this.zzfdq = zzdvv;
        this.zzfbx = executor;
    }

    public final View zzaeu() {
        return this.view;
    }

    public final void zza(ViewGroup viewGroup, zzua zzua) {
        if (viewGroup != null) {
            zzbbw zzbbw = this.zzczi;
            if (zzbbw != null) {
                zzbbw.zza(zzbdj.zzb(zzua));
                viewGroup.setMinimumHeight(zzua.heightPixels);
                viewGroup.setMinimumWidth(zzua.widthPixels);
                this.zzfdr = zzua;
            }
        }
    }

    public final zzwr getVideoController() {
        try {
            return this.zzfdn.getVideoController();
        } catch (zzcwh unused) {
            return null;
        }
    }

    public final zzcvu zzaet() {
        zzua zzua = this.zzfdr;
        if (zzua != null) {
            return zzcwi.zze(zzua);
        }
        return zzcwi.zza(this.zzfet.zzgjd, this.zzfde);
    }

    public final int zzaez() {
        return this.zzfbd.zzgkb.zzgjy.zzgju;
    }

    public final void zzjs() {
        this.zzfdp.zzagq();
    }

    public final void zzafa() {
        this.zzfbx.execute(new zzbit(this));
        super.zzafa();
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzafb() {
        if (this.zzfdo.zzaih() != null) {
            try {
                this.zzfdo.zzaih().zza((zzvl) this.zzfdq.get(), ObjectWrapper.wrap(this.zzlk));
            } catch (RemoteException e) {
                zzaug.zzc("RemoteException when notifyAdLoad is called", e);
            }
        }
    }
}
