package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.ads.internal.zzq;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzafl implements zzn {
    /* access modifiers changed from: private */
    public volatile zzafa zzcyl;
    private final Context zzlk;

    public zzafl(Context context) {
        this.zzlk = context;
    }

    public final zzo zzc(zzq<?> zzq) throws zzae {
        String str = "ms";
        String str2 = "Http assets remote cache took ";
        zzafd zzh = zzafd.zzh(zzq);
        long elapsedRealtime = zzq.zzkq().elapsedRealtime();
        try {
            zzaxv zzaxv = new zzaxv();
            this.zzcyl = new zzafa(this.zzlk, zzq.zzkx().zzwd(), new zzafp(this, zzaxv), new zzafo(this, zzaxv));
            this.zzcyl.checkAvailabilityAndConnect();
            zzddi zza = zzdcy.zza(zzdcy.zzb((zzddi<I>) zzaxv, (zzdcj<? super I, ? extends O>) new zzafk<Object,Object>(this, zzh), (Executor) zzaxn.zzdwi), (long) ((Integer) zzuv.zzon().zzd(zzza.zzcpx)).intValue(), TimeUnit.MILLISECONDS, zzaxn.zzdwl);
            zza.addListener(new zzafm(this), zzaxn.zzdwi);
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) zza.get();
            long elapsedRealtime2 = zzq.zzkq().elapsedRealtime() - elapsedRealtime;
            StringBuilder sb = new StringBuilder(52);
            sb.append(str2);
            sb.append(elapsedRealtime2);
            sb.append(str);
            zzaug.zzdy(sb.toString());
            zzaff zzaff = (zzaff) new zzaoz(parcelFileDescriptor).zza(zzaff.CREATOR);
            if (zzaff == null) {
                return null;
            }
            if (zzaff.zzcyi) {
                throw new zzae(zzaff.zzcyj);
            } else if (zzaff.zzcyg.length != zzaff.zzcyh.length) {
                return null;
            } else {
                HashMap hashMap = new HashMap();
                for (int i = 0; i < zzaff.zzcyg.length; i++) {
                    hashMap.put(zzaff.zzcyg[i], zzaff.zzcyh[i]);
                }
                zzo zzo = new zzo(zzaff.statusCode, zzaff.data, (Map<String, String>) hashMap, zzaff.zzac, zzaff.zzad);
                return zzo;
            }
        } catch (InterruptedException | ExecutionException unused) {
            long elapsedRealtime3 = zzq.zzkq().elapsedRealtime() - elapsedRealtime;
            StringBuilder sb2 = new StringBuilder(52);
            sb2.append(str2);
            sb2.append(elapsedRealtime3);
            sb2.append(str);
            zzaug.zzdy(sb2.toString());
            return null;
        } catch (Throwable th) {
            long elapsedRealtime4 = zzq.zzkq().elapsedRealtime() - elapsedRealtime;
            StringBuilder sb3 = new StringBuilder(52);
            sb3.append(str2);
            sb3.append(elapsedRealtime4);
            sb3.append(str);
            zzaug.zzdy(sb3.toString());
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public final void disconnect() {
        if (this.zzcyl != null) {
            this.zzcyl.disconnect();
            Binder.flushPendingCommands();
        }
    }
}
