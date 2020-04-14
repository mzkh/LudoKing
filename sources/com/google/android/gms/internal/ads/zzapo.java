package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzq;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzapo implements Callable<zzapj> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzapl zzdno;

    zzapo(zzapl zzapl, Context context) {
        this.zzdno = zzapl;
        this.val$context = context;
    }

    public final /* synthetic */ Object call() throws Exception {
        zzapj zzapj;
        zzapn zzapn = (zzapn) this.zzdno.zzdnl.get(this.val$context);
        if (zzapn != null) {
            if (!(zzapn.zzdnm + ((Long) zzuv.zzon().zzd(zzza.zzcmb)).longValue() < zzq.zzkq().currentTimeMillis())) {
                zzapj = new zzapm(this.val$context, zzapn.zzdnn).zzti();
                this.zzdno.zzdnl.put(this.val$context, new zzapn(this.zzdno, zzapj));
                return zzapj;
            }
        }
        zzapj = new zzapm(this.val$context).zzti();
        this.zzdno.zzdnl.put(this.val$context, new zzapn(this.zzdno, zzapj));
        return zzapj;
    }
}
