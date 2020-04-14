package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbhx implements zzpj {
    private final Clock zzbmp;
    private boolean zzbsc = false;
    private zzbbw zzczi;
    private final zzbhi zzfbu;
    private final Executor zzfbx;
    private zzbhm zzfbz = new zzbhm();
    private boolean zzfcw = false;

    public zzbhx(Executor executor, zzbhi zzbhi, Clock clock) {
        this.zzfbx = executor;
        this.zzfbu = zzbhi;
        this.zzbmp = clock;
    }

    private final void zzael() {
        try {
            JSONObject zza = this.zzfbu.zzj(this.zzfbz);
            if (this.zzczi != null) {
                this.zzfbx.execute(new zzbhw(this, zza));
            }
        } catch (JSONException e) {
            zzaug.zza("Failed to call video active view js", e);
        }
    }

    public final void zza(zzpk zzpk) {
        this.zzfbz.zzbnp = this.zzfcw ? false : zzpk.zzbnp;
        this.zzfbz.timestamp = this.zzbmp.elapsedRealtime();
        this.zzfbz.zzfcg = zzpk;
        if (this.zzbsc) {
            zzael();
        }
    }

    public final void zzg(zzbbw zzbbw) {
        this.zzczi = zzbbw;
    }

    public final void disable() {
        this.zzbsc = false;
    }

    public final void enable() {
        this.zzbsc = true;
        zzael();
    }

    public final void zzax(boolean z) {
        this.zzfcw = z;
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzh(JSONObject jSONObject) {
        this.zzczi.zza("AFMA_updateActiveView", jSONObject);
    }
}
