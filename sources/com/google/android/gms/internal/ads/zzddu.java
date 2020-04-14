package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzddu<V> implements Runnable {
    @NullableDecl
    private zzdds<V> zzgse;

    zzddu(zzdds<V> zzdds) {
        this.zzgse = zzdds;
    }

    public final void run() {
        String str;
        zzdds<V> zzdds = this.zzgse;
        if (zzdds != null) {
            zzddi zza = zzdds.zzgsc;
            if (zza != null) {
                this.zzgse = null;
                if (zza.isDone()) {
                    zzdds.setFuture(zza);
                    return;
                }
                try {
                    ScheduledFuture zzb = zzdds.zzgsd;
                    zzdds.zzgsd = null;
                    str = "Timed out";
                    if (zzb != null) {
                        long abs = Math.abs(zzb.getDelay(TimeUnit.MILLISECONDS));
                        if (abs > 10) {
                            StringBuilder sb = new StringBuilder(str.length() + 66);
                            sb.append(str);
                            sb.append(" (timeout delayed by ");
                            sb.append(abs);
                            sb.append(" ms after scheduled time)");
                            str = sb.toString();
                        }
                    }
                    String valueOf = String.valueOf(str);
                    String valueOf2 = String.valueOf(zza);
                    StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 2 + String.valueOf(valueOf2).length());
                    sb2.append(valueOf);
                    sb2.append(": ");
                    sb2.append(valueOf2);
                    zzdds.setException(new zzddx(sb2.toString()));
                    zza.cancel(true);
                } catch (Throwable th) {
                    zza.cancel(true);
                    throw th;
                }
            }
        }
    }
}
