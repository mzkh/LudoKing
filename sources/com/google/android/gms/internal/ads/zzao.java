package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzao {
    long zzcd;
    final String zzce;
    final String zzg;
    final long zzh;
    final long zzi;
    final long zzj;
    final long zzk;
    final List<zzk> zzm;

    private zzao(String str, String str2, long j, long j2, long j3, long j4, List<zzk> list) {
        this.zzce = str;
        if ("".equals(str2)) {
            str2 = null;
        }
        this.zzg = str2;
        this.zzh = j;
        this.zzi = j2;
        this.zzj = j3;
        this.zzk = j4;
        this.zzm = list;
    }

    zzao(String str, zzd zzd) {
        List list;
        String str2 = zzd.zzg;
        long j = zzd.zzh;
        long j2 = zzd.zzi;
        long j3 = zzd.zzj;
        long j4 = zzd.zzk;
        if (zzd.zzm != null) {
            list = zzd.zzm;
        } else {
            Map<String, String> map = zzd.zzl;
            ArrayList arrayList = new ArrayList(map.size());
            for (Entry entry : map.entrySet()) {
                arrayList.add(new zzk((String) entry.getKey(), (String) entry.getValue()));
            }
            list = arrayList;
        }
        this(str, str2, j, j2, j3, j4, list);
    }

    static zzao zzc(zzan zzan) throws IOException {
        if (zzal.zzb((InputStream) zzan) == 538247942) {
            zzao zzao = new zzao(zzal.zza(zzan), zzal.zza(zzan), zzal.zzc(zzan), zzal.zzc(zzan), zzal.zzc(zzan), zzal.zzc(zzan), zzal.zzb(zzan));
            return zzao;
        }
        throw new IOException();
    }

    /* access modifiers changed from: 0000 */
    public final boolean zza(OutputStream outputStream) {
        try {
            zzal.zza(outputStream, 538247942);
            zzal.zza(outputStream, this.zzce);
            zzal.zza(outputStream, this.zzg == null ? "" : this.zzg);
            zzal.zza(outputStream, this.zzh);
            zzal.zza(outputStream, this.zzi);
            zzal.zza(outputStream, this.zzj);
            zzal.zza(outputStream, this.zzk);
            List<zzk> list = this.zzm;
            if (list != null) {
                zzal.zza(outputStream, list.size());
                for (zzk zzk2 : list) {
                    zzal.zza(outputStream, zzk2.getName());
                    zzal.zza(outputStream, zzk2.getValue());
                }
            } else {
                zzal.zza(outputStream, 0);
            }
            outputStream.flush();
            return true;
        } catch (IOException e) {
            zzag.m3711d("%s", e.toString());
            return false;
        }
    }
}
