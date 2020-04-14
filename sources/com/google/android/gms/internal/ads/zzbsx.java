package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbsx implements zzo, zzbog {
    private final zzaxl zzblk;
    @Nullable
    private final zzbbw zzczi;
    private final zzcvr zzfet;
    @Nullable
    @VisibleForTesting
    private IObjectWrapper zzfeu;
    private final int zzfis;
    private final Context zzlk;

    public zzbsx(Context context, @Nullable zzbbw zzbbw, zzcvr zzcvr, zzaxl zzaxl, int i) {
        this.zzlk = context;
        this.zzczi = zzbbw;
        this.zzfet = zzcvr;
        this.zzblk = zzaxl;
        this.zzfis = i;
    }

    public final void onPause() {
    }

    public final void onResume() {
    }

    public final void onAdLoaded() {
        int i = this.zzfis;
        if ((i == 7 || i == 3) && this.zzfet.zzdlo && this.zzczi != null && zzq.zzky().zzp(this.zzlk)) {
            int i2 = this.zzblk.zzdwe;
            int i3 = this.zzblk.zzdwf;
            StringBuilder sb = new StringBuilder(23);
            sb.append(i2);
            sb.append(".");
            sb.append(i3);
            this.zzfeu = zzq.zzky().zza(sb.toString(), this.zzczi.getWebView(), "", "javascript", this.zzfet.zzgjo.optInt(MessengerShareContentUtility.MEDIA_TYPE, -1) == 0 ? null : "javascript");
            if (this.zzfeu != null && this.zzczi.getView() != null) {
                zzq.zzky().zza(this.zzfeu, this.zzczi.getView());
                this.zzczi.zzaq(this.zzfeu);
                zzq.zzky().zzae(this.zzfeu);
            }
        }
    }

    public final void zzsi() {
        this.zzfeu = null;
    }

    public final void zzsj() {
        if (this.zzfeu != null) {
            zzbbw zzbbw = this.zzczi;
            if (zzbbw != null) {
                zzbbw.zza("onSdkImpression", new HashMap());
            }
        }
    }
}
