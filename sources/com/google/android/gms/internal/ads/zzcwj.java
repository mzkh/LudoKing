package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcwj {
    public static void zzc(Throwable th, String str) {
        int zzd = zzccu.zzd(th);
        StringBuilder sb = new StringBuilder(31);
        sb.append("Ad failed to load : ");
        sb.append(zzd);
        zzaug.zzet(sb.toString());
        zzaug.zza(str, th);
        if (zzccu.zzd(th) != 3) {
            zzq.zzkn().zzb(th, str);
        }
    }

    public static void zze(Context context, boolean z) {
        if (z) {
            zzaug.zzet("This request is sent from a test device.");
            return;
        }
        zzuv.zzoj();
        String zzbi = zzawy.zzbi(context);
        StringBuilder sb = new StringBuilder(String.valueOf(zzbi).length() + 71);
        sb.append("Use AdRequest.Builder.addTestDevice(\"");
        sb.append(zzbi);
        sb.append("\") to get test ads on this device.");
        zzaug.zzet(sb.toString());
    }
}
