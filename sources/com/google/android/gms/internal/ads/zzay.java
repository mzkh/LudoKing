package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public abstract class zzay implements zzba {
    private static Logger zzcn = Logger.getLogger(zzay.class.getName());
    private ThreadLocal<ByteBuffer> zzco = new zzax(this);

    public abstract zzbb zza(String str, byte[] bArr, String str2);

    public final zzbb zza(zzdvn zzdvn, zzbe zzbe) throws IOException {
        int read;
        long j;
        zzdvn zzdvn2 = zzdvn;
        zzbe zzbe2 = zzbe;
        long position = zzdvn.position();
        ((ByteBuffer) this.zzco.get()).rewind().limit(8);
        do {
            read = zzdvn2.read((ByteBuffer) this.zzco.get());
            if (read == 8) {
                ((ByteBuffer) this.zzco.get()).rewind();
                long zza = zzbc.zza((ByteBuffer) this.zzco.get());
                byte[] bArr = null;
                if (zza >= 8 || zza <= 1) {
                    String zzf = zzbc.zzf((ByteBuffer) this.zzco.get());
                    if (zza == 1) {
                        ((ByteBuffer) this.zzco.get()).limit(16);
                        zzdvn2.read((ByteBuffer) this.zzco.get());
                        ((ByteBuffer) this.zzco.get()).position(8);
                        j = zzbc.zzc((ByteBuffer) this.zzco.get()) - 16;
                    } else {
                        j = zza == 0 ? zzdvn.size() - zzdvn.position() : zza - 8;
                    }
                    if ("uuid".equals(zzf)) {
                        ((ByteBuffer) this.zzco.get()).limit(((ByteBuffer) this.zzco.get()).limit() + 16);
                        zzdvn2.read((ByteBuffer) this.zzco.get());
                        bArr = new byte[16];
                        for (int position2 = ((ByteBuffer) this.zzco.get()).position() - 16; position2 < ((ByteBuffer) this.zzco.get()).position(); position2++) {
                            bArr[position2 - (((ByteBuffer) this.zzco.get()).position() - 16)] = ((ByteBuffer) this.zzco.get()).get(position2);
                        }
                        j -= 16;
                    }
                    long j2 = j;
                    zzbb zza2 = zza(zzf, bArr, zzbe2 instanceof zzbb ? ((zzbb) zzbe2).getType() : "");
                    zza2.zza(zzbe2);
                    ((ByteBuffer) this.zzco.get()).rewind();
                    zza2.zza(zzdvn, (ByteBuffer) this.zzco.get(), j2, this);
                    return zza2;
                }
                Logger logger = zzcn;
                Level level = Level.SEVERE;
                StringBuilder sb = new StringBuilder(80);
                sb.append("Plausibility check failed: size < 8 (size = ");
                sb.append(zza);
                sb.append("). Stop parsing!");
                logger.logp(level, "com.coremedia.iso.AbstractBoxParser", "parseBox", sb.toString());
                return null;
            }
        } while (read >= 0);
        zzdvn2.zzew(position);
        throw new EOFException();
    }
}
