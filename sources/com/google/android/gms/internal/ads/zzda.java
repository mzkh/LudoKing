package com.google.android.gms.internal.ads;

import android.os.Build.VERSION;
import android.os.ConditionVariable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.internal.ads.zzbi.zza;
import com.google.android.gms.internal.ads.zzbi.zza.C3499zza;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public class zzda {
    /* access modifiers changed from: private */
    public static final ConditionVariable zzvp = new ConditionVariable();
    @VisibleForTesting
    protected static volatile zzsi zzvq = null;
    private static volatile Random zzvs = null;
    /* access modifiers changed from: private */
    public zzdx zzvo;
    @VisibleForTesting
    protected volatile Boolean zzvr;

    public zzda(zzdx zzdx) {
        this.zzvo = zzdx;
        zzdx.zzce().execute(new zzcz(this));
    }

    public final void zza(int i, int i2, long j) {
        zza(i, i2, j, null, null);
    }

    public final void zza(int i, int i2, long j, String str) {
        zza(i, -1, j, str, null);
    }

    public final void zza(int i, int i2, long j, String str, Exception exc) {
        try {
            zzvp.block();
            if (this.zzvr.booleanValue() && zzvq != null) {
                C3499zza zzc = zza.zzr().zzi(this.zzvo.zzlk.getPackageName()).zzc(j);
                if (str != null) {
                    zzc.zzl(str);
                }
                if (exc != null) {
                    StringWriter stringWriter = new StringWriter();
                    zzdoy.zza((Throwable) exc, new PrintWriter(stringWriter));
                    zzc.zzj(stringWriter.toString()).zzk(exc.getClass().getName());
                }
                zzsm zzf = zzvq.zzf(((zza) ((zzdqw) zzc.zzazr())).toByteArray());
                zzf.zzbq(i);
                if (i2 != -1) {
                    zzf.zzbp(i2);
                }
                zzf.zzdh();
            }
        } catch (Exception unused) {
        }
    }

    public static int zzbz() {
        try {
            if (VERSION.SDK_INT >= 21) {
                return ThreadLocalRandom.current().nextInt();
            }
            return zzca().nextInt();
        } catch (RuntimeException unused) {
            return zzca().nextInt();
        }
    }

    private static Random zzca() {
        if (zzvs == null) {
            synchronized (zzda.class) {
                if (zzvs == null) {
                    zzvs = new Random();
                }
            }
        }
        return zzvs;
    }
}
