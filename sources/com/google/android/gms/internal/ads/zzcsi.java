package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcsi implements zzcru<zzcsf> {
    private final Executor executor;
    private final ScheduledExecutorService zzffn;
    private final zzatn zzggu;
    private final Context zzlk;

    public zzcsi(zzatn zzatn, Context context, ScheduledExecutorService scheduledExecutorService, Executor executor2) {
        this.zzggu = zzatn;
        this.zzlk = context;
        this.zzffn = scheduledExecutorService;
        this.executor = executor2;
    }

    public final zzddi<zzcsf> zzalv() {
        if (!((Boolean) zzuv.zzon().zzd(zzza.zzckp)).booleanValue()) {
            return zzdcy.zzi(new Exception("Did not ad Ad ID into query param."));
        }
        zzaxv zzaxv = new zzaxv();
        zzddi zzak = this.zzggu.zzak(this.zzlk);
        zzak.addListener(new zzcsh(this, zzak, zzaxv), this.executor);
        this.zzffn.schedule(new zzcsk(zzak), ((Long) zzuv.zzon().zzd(zzza.zzckq)).longValue(), TimeUnit.MILLISECONDS);
        return zzaxv;
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zza(zzddi zzddi, zzaxv zzaxv) {
        String str;
        try {
            Info info = (Info) zzddi.get();
            if (info == null || !TextUtils.isEmpty(info.getId())) {
                str = null;
            } else {
                zzuv.zzoj();
                str = zzawy.zzbj(this.zzlk);
            }
            zzaxv.set(new zzcsf(info, this.zzlk, str));
        } catch (InterruptedException | CancellationException | ExecutionException unused) {
            zzuv.zzoj();
            zzaxv.set(new zzcsf(null, this.zzlk, zzawy.zzbj(this.zzlk)));
        }
    }
}
