package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public abstract class zzdvk implements zzbb {
    private static zzdvt zzcp = zzdvt.zzn(zzdvk.class);
    private String type;
    private long zzauv;
    private zzbe zzhwm;
    boolean zzhwo;
    private boolean zzhwp;
    private ByteBuffer zzhwq;
    private long zzhwr;
    private long zzhws = -1;
    private zzdvn zzhwt;
    private ByteBuffer zzhwu = null;

    private final synchronized void zzbda() {
        if (!this.zzhwp) {
            try {
                zzdvt zzdvt = zzcp;
                String str = "mem mapping ";
                String valueOf = String.valueOf(this.type);
                zzdvt.zzhr(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                this.zzhwq = this.zzhwt.zzh(this.zzhwr, this.zzhws);
                this.zzhwp = true;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract void zzg(ByteBuffer byteBuffer);

    protected zzdvk(String str) {
        this.type = str;
        this.zzhwp = true;
        this.zzhwo = true;
    }

    public final void zza(zzdvn zzdvn, ByteBuffer byteBuffer, long j, zzba zzba) throws IOException {
        this.zzhwr = zzdvn.position();
        this.zzauv = this.zzhwr - ((long) byteBuffer.remaining());
        this.zzhws = j;
        this.zzhwt = zzdvn;
        zzdvn.zzew(zzdvn.position() + j);
        this.zzhwp = false;
        this.zzhwo = false;
        zzbdb();
    }

    public final synchronized void zzbdb() {
        zzbda();
        zzdvt zzdvt = zzcp;
        String str = "parsing details of ";
        String valueOf = String.valueOf(this.type);
        zzdvt.zzhr(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        if (this.zzhwq != null) {
            ByteBuffer byteBuffer = this.zzhwq;
            this.zzhwo = true;
            byteBuffer.rewind();
            zzg(byteBuffer);
            if (byteBuffer.remaining() > 0) {
                this.zzhwu = byteBuffer.slice();
            }
            this.zzhwq = null;
        }
    }

    public final String getType() {
        return this.type;
    }

    public final void zza(zzbe zzbe) {
        this.zzhwm = zzbe;
    }
}
