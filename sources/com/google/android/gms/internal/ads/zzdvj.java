package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public class zzdvj extends zzdvl implements zzbb {
    private String type;
    private long zzauv;
    private zzbe zzhwm;
    private boolean zzhwn;

    public zzdvj(String str) {
        this.type = str;
    }

    public final void zza(zzbe zzbe) {
        this.zzhwm = zzbe;
    }

    public final String getType() {
        return this.type;
    }

    public final void zza(zzdvn zzdvn, ByteBuffer byteBuffer, long j, zzba zzba) throws IOException {
        this.zzauv = zzdvn.position() - ((long) byteBuffer.remaining());
        this.zzhwn = byteBuffer.remaining() == 16;
        zza(zzdvn, j, zzba);
    }

    public final void zza(zzdvn zzdvn, long j, zzba zzba) throws IOException {
        this.zzhwt = zzdvn;
        this.zzhwy = zzdvn.position();
        this.zzbch = this.zzhwy - ((long) ((this.zzhwn || 8 + j >= 4294967296L) ? 16 : 8));
        zzdvn.zzew(zzdvn.position() + j);
        this.zzaqu = zzdvn.position();
        this.zzhww = zzba;
    }
}
