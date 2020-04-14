package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbap {
    private long zzcu;

    public final long zzl(ByteBuffer byteBuffer) {
        zzbg zzbg;
        zzbd zzbd;
        long j = this.zzcu;
        if (j > 0) {
            return j;
        }
        try {
            ByteBuffer duplicate = byteBuffer.duplicate();
            duplicate.flip();
            Iterator it = new zzaz(new zzbaq(duplicate), zzbar.zzedb).zzbdc().iterator();
            while (true) {
                zzbg = null;
                if (!it.hasNext()) {
                    zzbd = null;
                    break;
                }
                zzbb zzbb = (zzbb) it.next();
                if (zzbb instanceof zzbd) {
                    zzbd = (zzbd) zzbb;
                    break;
                }
            }
            Iterator it2 = zzbd.zzbdc().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                zzbb zzbb2 = (zzbb) it2.next();
                if (zzbb2 instanceof zzbg) {
                    zzbg = (zzbg) zzbb2;
                    break;
                }
            }
            this.zzcu = (zzbg.getDuration() * 1000) / zzbg.zzq();
            return this.zzcu;
        } catch (IOException | RuntimeException unused) {
            return 0;
        }
    }
}
