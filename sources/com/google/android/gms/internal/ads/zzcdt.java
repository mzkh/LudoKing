package com.google.android.gms.internal.ads;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcdt extends zzcdr {
    /* access modifiers changed from: private */
    public static final Pattern zzfur = Pattern.compile("Received error HTTP response code: (.*)");
    private final ScheduledExecutorService zzffn;
    private final zzcwe zzfga;
    private final zzddl zzfoa;
    private final zzccx zzfup;
    /* access modifiers changed from: private */
    public final zzcfp zzfuq;

    zzcdt(zzbox zzbox, zzcwe zzcwe, zzccx zzccx, zzddl zzddl, ScheduledExecutorService scheduledExecutorService, zzcfp zzcfp) {
        super(zzbox);
        this.zzfga = zzcwe;
        this.zzfup = zzccx;
        this.zzfoa = zzddl;
        this.zzffn = scheduledExecutorService;
        this.zzfuq = zzcfp;
    }

    public final zzddi<zzcvz> zze(zzape zzape) throws zzccu {
        zzddi<zzcvz> zzb = zzdcy.zzb(this.zzfup.zzc(zzape), (zzdcj<? super I, ? extends O>) new zzcds<Object,Object>(this), (Executor) this.zzfoa);
        if (((Boolean) zzuv.zzon().zzd(zzza.zzcrp)).booleanValue()) {
            zzb = zzdcy.zzb(zzdcy.zza(zzb, (long) ((Integer) zzuv.zzon().zzd(zzza.zzcrq)).intValue(), TimeUnit.SECONDS, this.zzffn), TimeoutException.class, zzcdv.zzbkv, zzaxn.zzdwn);
        }
        zzdcy.zza(zzb, new zzcdu(this), zzaxn.zzdwn);
        return zzb;
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ zzddi zzd(InputStream inputStream) throws Exception {
        return zzdcy.zzah(new zzcvz(new zzcvy(this.zzfga), zzcvx.zza(new InputStreamReader(inputStream))));
    }
}
