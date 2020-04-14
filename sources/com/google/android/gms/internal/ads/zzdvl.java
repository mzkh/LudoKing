package com.google.android.gms.internal.ads;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public class zzdvl implements zzbe, Closeable, Iterator<zzbb> {
    private static zzdvt zzcp = zzdvt.zzn(zzdvl.class);
    private static final zzbb zzhwv = new zzdvo("eof ");
    long zzaqu = 0;
    long zzbch = 0;
    protected zzdvn zzhwt;
    protected zzba zzhww;
    private zzbb zzhwx = null;
    long zzhwy = 0;
    private List<zzbb> zzhwz = new ArrayList();

    public final List<zzbb> zzbdc() {
        if (this.zzhwt == null || this.zzhwx == zzhwv) {
            return this.zzhwz;
        }
        return new zzdvr(this.zzhwz, this);
    }

    public void zza(zzdvn zzdvn, long j, zzba zzba) throws IOException {
        this.zzhwt = zzdvn;
        long position = zzdvn.position();
        this.zzbch = position;
        this.zzhwy = position;
        zzdvn.zzew(zzdvn.position() + j);
        this.zzaqu = zzdvn.position();
        this.zzhww = zzba;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }

    public boolean hasNext() {
        zzbb zzbb = this.zzhwx;
        if (zzbb == zzhwv) {
            return false;
        }
        if (zzbb != null) {
            return true;
        }
        try {
            this.zzhwx = (zzbb) next();
            return true;
        } catch (NoSuchElementException unused) {
            this.zzhwx = zzhwv;
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: zzbdd */
    public final zzbb next() {
        zzbb zza;
        zzbb zzbb = this.zzhwx;
        if (zzbb == null || zzbb == zzhwv) {
            zzdvn zzdvn = this.zzhwt;
            if (zzdvn == null || this.zzhwy >= this.zzaqu) {
                this.zzhwx = zzhwv;
                throw new NoSuchElementException();
            }
            try {
                synchronized (zzdvn) {
                    this.zzhwt.zzew(this.zzhwy);
                    zza = this.zzhww.zza(this.zzhwt, this);
                    this.zzhwy = this.zzhwt.position();
                }
                return zza;
            } catch (EOFException unused) {
                throw new NoSuchElementException();
            } catch (IOException unused2) {
                throw new NoSuchElementException();
            }
        } else {
            this.zzhwx = null;
            return zzbb;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        for (int i = 0; i < this.zzhwz.size(); i++) {
            if (i > 0) {
                sb.append(";");
            }
            sb.append(((zzbb) this.zzhwz.get(i)).toString());
        }
        sb.append("]");
        return sb.toString();
    }

    public void close() throws IOException {
        this.zzhwt.close();
    }
}
