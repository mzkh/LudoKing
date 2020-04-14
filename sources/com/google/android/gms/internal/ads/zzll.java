package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzll implements zznq {
    private final Uri uri;
    private final zzne zzamo;
    private final /* synthetic */ zzli zzazs;
    private final zzlo zzbaa;
    private final zznt zzbab;
    private final zzjc zzbau = new zzjc();
    private volatile boolean zzbav;
    private boolean zzbaw = true;
    private long zzbax;
    /* access modifiers changed from: private */
    public long zzcb = -1;

    public zzll(zzli zzli, Uri uri2, zzne zzne, zzlo zzlo, zznt zznt) {
        this.zzazs = zzli;
        this.uri = (Uri) zznr.checkNotNull(uri2);
        this.zzamo = (zzne) zznr.checkNotNull(zzne);
        this.zzbaa = (zzlo) zznr.checkNotNull(zzlo);
        this.zzbab = zznt;
    }

    public final void zze(long j, long j2) {
        this.zzbau.zzamq = j;
        this.zzbax = j2;
        this.zzbaw = true;
    }

    public final void cancelLoad() {
        this.zzbav = true;
    }

    public final boolean zzhj() {
        return this.zzbav;
    }

    public final void zzhk() throws IOException, InterruptedException {
        zzit zzit;
        int i = 0;
        while (i == 0 && !this.zzbav) {
            try {
                long j = this.zzbau.zzamq;
                zzne zzne = this.zzamo;
                zznf zznf = new zznf(this.uri, j, -1, this.zzazs.zzazx);
                this.zzcb = zzne.zza(zznf);
                if (this.zzcb != -1) {
                    this.zzcb += j;
                }
                zzit = new zzit(this.zzamo, j, this.zzcb);
                try {
                    zziw zza = this.zzbaa.zza(zzit, this.zzamo.getUri());
                    if (this.zzbaw) {
                        zza.zzc(j, this.zzbax);
                        this.zzbaw = false;
                    }
                    while (i == 0 && !this.zzbav) {
                        this.zzbab.block();
                        i = zza.zza(zzit, this.zzbau);
                        if (zzit.getPosition() > this.zzazs.zzazy + j) {
                            j = zzit.getPosition();
                            this.zzbab.zzig();
                            this.zzazs.handler.post(this.zzazs.zzbad);
                        }
                    }
                    if (i == 1) {
                        i = 0;
                    } else {
                        this.zzbau.zzamq = zzit.getPosition();
                    }
                    zzof.zza(this.zzamo);
                } catch (Throwable th) {
                    th = th;
                    if (!(i == 1 || zzit == null)) {
                        this.zzbau.zzamq = zzit.getPosition();
                    }
                    zzof.zza(this.zzamo);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                zzit = null;
                this.zzbau.zzamq = zzit.getPosition();
                zzof.zza(this.zzamo);
                throw th;
            }
        }
    }
}
