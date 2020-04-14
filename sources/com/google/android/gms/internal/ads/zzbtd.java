package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import androidx.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbtd implements zzbna, zzbqk {
    @Nullable
    private final View view;
    private final zzasl zzbnf;
    private final zzasm zzfff;
    private final int zzfis;
    private String zzfiy;
    private final Context zzlk;

    public zzbtd(zzasm zzasm, Context context, zzasl zzasl, @Nullable View view2, int i) {
        this.zzfff = zzasm;
        this.zzlk = context;
        this.zzbnf = zzasl;
        this.view = view2;
        this.zzfis = i;
    }

    public final void onAdLeftApplication() {
    }

    public final void onRewardedVideoCompleted() {
    }

    public final void onRewardedVideoStarted() {
    }

    public final void onAdOpened() {
        View view2 = this.view;
        if (!(view2 == null || this.zzfiy == null)) {
            this.zzbnf.zzg(view2.getContext(), this.zzfiy);
        }
        this.zzfff.zzaf(true);
    }

    public final void onAdClosed() {
        this.zzfff.zzaf(false);
    }

    public final void zzagn() {
        this.zzfiy = this.zzbnf.zzad(this.zzlk);
        String valueOf = String.valueOf(this.zzfiy);
        String str = this.zzfis == 7 ? "/Rewarded" : "/Interstitial";
        this.zzfiy = str.length() != 0 ? valueOf.concat(str) : new String(valueOf);
    }

    @ParametersAreNonnullByDefault
    public final void zzb(zzapy zzapy, String str, String str2) {
        if (this.zzbnf.zzab(this.zzlk)) {
            try {
                this.zzbnf.zza(this.zzlk, this.zzbnf.zzag(this.zzlk), this.zzfff.getAdUnitId(), zzapy.getType(), zzapy.getAmount());
            } catch (RemoteException e) {
                zzaug.zzd("Remote Exception to get reward item.", e);
            }
        }
    }
}
