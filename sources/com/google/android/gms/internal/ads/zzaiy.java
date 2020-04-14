package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzq;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzaiy<I, O> implements zzaip<I, O> {
    private final zzahn zzdbd;
    /* access modifiers changed from: private */
    public final zzair<O> zzdbe;
    private final zzaiq<I> zzdbf;
    private final String zzdbg;

    zzaiy(zzahn zzahn, String str, zzaiq<I> zzaiq, zzair<O> zzair) {
        this.zzdbd = zzahn;
        this.zzdbg = str;
        this.zzdbf = zzaiq;
        this.zzdbe = zzair;
    }

    public final zzddi<O> zzi(I i) {
        zzaxv zzaxv = new zzaxv();
        zzaia zzb = this.zzdbd.zzb((zzdf) null);
        zzb.zza(new zzajb(this, zzb, i, zzaxv), new zzaja(this, zzaxv, zzb));
        return zzaxv;
    }

    /* access modifiers changed from: private */
    public final void zza(zzaia zzaia, zzail zzail, I i, zzaxv<O> zzaxv) {
        try {
            zzq.zzkj();
            String zzvm = zzaul.zzvm();
            zzaea.zzcxs.zza(zzvm, (zzaez) new zzajd(this, zzaia, zzaxv));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", zzvm);
            jSONObject.put("args", this.zzdbf.zzj(i));
            zzail.zza(this.zzdbg, jSONObject);
        } catch (Exception e) {
            zzaxv.setException(e);
            zzaug.zzc("Unable to invokeJavascript", e);
            zzaia.release();
        } catch (Throwable th) {
            zzaia.release();
            throw th;
        }
    }

    public final zzddi<O> zzf(@Nullable I i) throws Exception {
        return zzi(i);
    }
}
