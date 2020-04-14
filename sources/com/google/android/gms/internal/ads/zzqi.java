package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzqi {
    private final int zzbqf;
    private final int zzbqg;
    private final int zzbqh;
    private final zzqf zzbqi = new zzqm();

    public zzqi(int i) {
        this.zzbqg = i;
        this.zzbqf = 6;
        this.zzbqh = 0;
    }

    public final String zza(ArrayList<String> arrayList) {
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            sb.append(((String) obj).toLowerCase(Locale.US));
            sb.append(10);
        }
        return zzbr(sb.toString());
    }

    @VisibleForTesting
    private final String zzbr(String str) {
        String[] split = str.split("\n");
        if (split.length == 0) {
            return "";
        }
        zzqk zzqk = new zzqk();
        PriorityQueue priorityQueue = new PriorityQueue(this.zzbqg, new zzqh(this));
        for (String zze : split) {
            String[] zze2 = zzqj.zze(zze, false);
            if (zze2.length != 0) {
                zzqo.zza(zze2, this.zzbqg, this.zzbqf, priorityQueue);
            }
        }
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            try {
                zzqk.write(this.zzbqi.zzbq(((zzqn) it.next()).zzbqm));
            } catch (IOException e) {
                zzaug.zzc("Error while writing hash to byteStream", e);
            }
        }
        return zzqk.toString();
    }
}
