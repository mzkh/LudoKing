package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzcrw implements Runnable {
    private final zzcru zzggi;
    private final long zzggj;

    zzcrw(zzcru zzcru, long j) {
        this.zzggi = zzcru;
        this.zzggj = j;
    }

    public final void run() {
        zzcru zzcru = this.zzggi;
        long j = this.zzggj;
        String canonicalName = zzcru.getClass().getCanonicalName();
        long elapsedRealtime = zzq.zzkq().elapsedRealtime() - j;
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 40);
        sb.append("Signal runtime : ");
        sb.append(canonicalName);
        sb.append(" = ");
        sb.append(elapsedRealtime);
        zzaug.zzdy(sb.toString());
    }
}
