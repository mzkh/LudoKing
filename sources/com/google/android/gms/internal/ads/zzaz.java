package com.google.android.gms.internal.ads;

import java.io.Closeable;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public class zzaz extends zzdvl implements Closeable {
    private static zzdvt zzcp = zzdvt.zzn(zzaz.class);

    public zzaz(zzdvn zzdvn, zzba zzba) throws IOException {
        zza(zzdvn, zzdvn.size(), zzba);
    }

    public void close() throws IOException {
        this.zzhwt.close();
    }

    public String toString() {
        String obj = this.zzhwt.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 7);
        sb.append("model(");
        sb.append(obj);
        sb.append(")");
        return sb.toString();
    }
}
