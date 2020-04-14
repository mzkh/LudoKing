package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.internal.ads.zzbfx.zza;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public abstract class zzbei implements zzbgq {
    @GuardedBy("AppComponent.class")
    private static zzbei zzejt;

    /* access modifiers changed from: protected */
    public abstract zzcsm zza(zzctp zzctp);

    public abstract Executor zzabb();

    public abstract ScheduledExecutorService zzabc();

    public abstract Executor zzabd();

    public abstract zzddl zzabe();

    public abstract zzbou zzabf();

    public abstract zzchm zzabg();

    public abstract zzbga zzabh();

    public abstract zzbjm zzabi();

    public abstract zzbih zzabj();

    public abstract zzbsr zzabk();

    public abstract zzbtk zzabl();

    public abstract zzbzf zzabm();

    public abstract zzcvm zzabn();

    public abstract zzcmy zzabo();

    public static zzbei zza(Context context, zzajx zzajx, int i) {
        zzbei zzd = zzd(context, i);
        zzd.zzabg().zzb(zzajx);
        return zzd;
    }

    @Deprecated
    public static zzbei zzd(Context context, int i) {
        synchronized (zzbei.class) {
            if (zzejt == null) {
                return zza(new zzaxl(15601000, i, true, false), context, (zza) new zzbex());
            }
            zzbei zzbei = zzejt;
            return zzbei;
        }
    }

    @Deprecated
    private static zzbei zza(zzaxl zzaxl, Context context, zza zza) {
        zzbei zzbei;
        synchronized (zzbei.class) {
            if (zzejt == null) {
                zzejt = new zzbfo().zzc(new zzbel(new zzbel.zza().zza(zzaxl).zzbs(context))).zza(new zzbfx(zza)).zzadg();
                zzza.initialize(context);
                zzq.zzkn().zzd(context, zzaxl);
                zzq.zzkp().initialize(context);
                zzq.zzkj().zzao(context);
                zzq.zzkj().zzap(context);
                zzaue.zzan(context);
                zzq.zzkm().initialize(context);
                zzq.zzle().initialize(context);
                if (((Boolean) zzuv.zzon().zzd(zzza.zzctc)).booleanValue()) {
                    new zzcfw(context, zzaxl, new zzsd(new zzsi(context)), new zzcfj(new zzcfh(context), zzejt.zzabe())).zzakr();
                }
            }
            zzbei = zzejt;
        }
        return zzbei;
    }

    public final zzcsm zza(zzape zzape) {
        return zza(new zzctp(zzape));
    }
}
