package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import android.util.SparseArray;
import com.tapjoy.TapjoyConstants;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzli implements zziy, zzls, zzme, zzno<zzll> {
    /* access modifiers changed from: private */
    public final Handler handler;
    private final Uri uri;
    private final Handler zzacs;
    private boolean zzadu;
    /* access modifiers changed from: private */
    public boolean zzaei;
    private long zzagh;
    private final zzne zzamo;
    private final int zzazt;
    /* access modifiers changed from: private */
    public final zzlp zzazu;
    private final zzlt zzazv;
    private final zznc zzazw;
    /* access modifiers changed from: private */
    public final String zzazx;
    /* access modifiers changed from: private */
    public final long zzazy;
    private final zznl zzazz = new zznl("Loader:ExtractorMediaPeriod");
    private final zzlo zzbaa;
    private final zznt zzbab;
    private final Runnable zzbac;
    /* access modifiers changed from: private */
    public final Runnable zzbad;
    /* access modifiers changed from: private */
    public final SparseArray<zzmc> zzbae;
    /* access modifiers changed from: private */
    public zzlr zzbaf;
    private zzjb zzbag;
    private boolean zzbah;
    private boolean zzbai;
    private boolean zzbaj;
    private int zzbak;
    private zzmk zzbal;
    private boolean[] zzbam;
    private boolean[] zzban;
    private boolean zzbao;
    private long zzbap;
    private long zzbaq;
    private int zzbar;
    private boolean zzbas;
    private long zzcb;

    public zzli(Uri uri2, zzne zzne, zziw[] zziwArr, int i, Handler handler2, zzlp zzlp, zzlt zzlt, zznc zznc, String str, int i2) {
        this.uri = uri2;
        this.zzamo = zzne;
        this.zzazt = i;
        this.zzacs = handler2;
        this.zzazu = zzlp;
        this.zzazv = zzlt;
        this.zzazw = zznc;
        this.zzazx = str;
        this.zzazy = (long) i2;
        this.zzbaa = new zzlo(zziwArr, this);
        this.zzbab = new zznt();
        this.zzbac = new zzlh(this);
        this.zzbad = new zzlk(this);
        this.handler = new Handler();
        this.zzbaq = -9223372036854775807L;
        this.zzbae = new SparseArray<>();
        this.zzcb = -1;
    }

    public final void zzdz(long j) {
    }

    public final void release() {
        this.zzazz.zza((Runnable) new zzlj(this, this.zzbaa));
        this.handler.removeCallbacksAndMessages(null);
        this.zzaei = true;
    }

    public final void zza(zzlr zzlr, long j) {
        this.zzbaf = zzlr;
        this.zzbab.open();
        startLoading();
    }

    public final void zzha() throws IOException {
        this.zzazz.zzbb(Integer.MIN_VALUE);
    }

    public final zzmk zzhb() {
        return this.zzbal;
    }

    public final long zza(zzmt[] zzmtArr, boolean[] zArr, zzmd[] zzmdArr, boolean[] zArr2, long j) {
        zznr.checkState(this.zzadu);
        for (int i = 0; i < zzmtArr.length; i++) {
            if (zzmdArr[i] != null && (zzmtArr[i] == null || !zArr[i])) {
                int zza = zzmdArr[i].track;
                zznr.checkState(this.zzbam[zza]);
                this.zzbak--;
                this.zzbam[zza] = false;
                ((zzmc) this.zzbae.valueAt(zza)).disable();
                zzmdArr[i] = null;
            }
        }
        boolean z = false;
        for (int i2 = 0; i2 < zzmtArr.length; i2++) {
            if (zzmdArr[i2] == null && zzmtArr[i2] != null) {
                zzmt zzmt = zzmtArr[i2];
                zznr.checkState(zzmt.length() == 1);
                zznr.checkState(zzmt.zzaw(0) == 0);
                int zza2 = this.zzbal.zza(zzmt.zzhx());
                zznr.checkState(!this.zzbam[zza2]);
                this.zzbak++;
                this.zzbam[zza2] = true;
                zzmdArr[i2] = new zzln(this, zza2);
                zArr2[i2] = true;
                z = true;
            }
        }
        if (!this.zzbai) {
            int size = this.zzbae.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (!this.zzbam[i3]) {
                    ((zzmc) this.zzbae.valueAt(i3)).disable();
                }
            }
        }
        if (this.zzbak == 0) {
            this.zzbaj = false;
            if (this.zzazz.isLoading()) {
                this.zzazz.zzie();
            }
        } else if (!this.zzbai ? j != 0 : z) {
            j = zzea(j);
            for (int i4 = 0; i4 < zzmdArr.length; i4++) {
                if (zzmdArr[i4] != null) {
                    zArr2[i4] = true;
                }
            }
        }
        this.zzbai = true;
        return j;
    }

    public final boolean zzdy(long j) {
        if (this.zzbas || (this.zzadu && this.zzbak == 0)) {
            return false;
        }
        boolean open = this.zzbab.open();
        if (!this.zzazz.isLoading()) {
            startLoading();
            open = true;
        }
        return open;
    }

    public final long zzgz() {
        if (this.zzbak == 0) {
            return Long.MIN_VALUE;
        }
        return zzhd();
    }

    public final long zzhc() {
        if (!this.zzbaj) {
            return -9223372036854775807L;
        }
        this.zzbaj = false;
        return this.zzbap;
    }

    public final long zzhd() {
        long j;
        if (this.zzbas) {
            return Long.MIN_VALUE;
        }
        if (zzhi()) {
            return this.zzbaq;
        }
        if (this.zzbao) {
            j = Long.MAX_VALUE;
            int size = this.zzbae.size();
            for (int i = 0; i < size; i++) {
                if (this.zzban[i]) {
                    j = Math.min(j, ((zzmc) this.zzbae.valueAt(i)).zzhh());
                }
            }
        } else {
            j = zzhh();
        }
        return j == Long.MIN_VALUE ? this.zzbap : j;
    }

    public final long zzea(long j) {
        if (!this.zzbag.zzgc()) {
            j = 0;
        }
        this.zzbap = j;
        int size = this.zzbae.size();
        boolean z = !zzhi();
        int i = 0;
        while (z && i < size) {
            if (this.zzbam[i]) {
                z = ((zzmc) this.zzbae.valueAt(i)).zze(j, false);
            }
            i++;
        }
        if (!z) {
            this.zzbaq = j;
            this.zzbas = false;
            if (this.zzazz.isLoading()) {
                this.zzazz.zzie();
            } else {
                for (int i2 = 0; i2 < size; i2++) {
                    ((zzmc) this.zzbae.valueAt(i2)).zzj(this.zzbam[i2]);
                }
            }
        }
        this.zzbaj = false;
        return j;
    }

    /* access modifiers changed from: 0000 */
    public final boolean zzas(int i) {
        return this.zzbas || (!zzhi() && ((zzmc) this.zzbae.valueAt(i)).zzhq());
    }

    /* access modifiers changed from: 0000 */
    public final void zzhe() throws IOException {
        this.zzazz.zzbb(Integer.MIN_VALUE);
    }

    /* access modifiers changed from: 0000 */
    public final int zza(int i, zzgq zzgq, zzik zzik, boolean z) {
        if (this.zzbaj || zzhi()) {
            return -3;
        }
        return ((zzmc) this.zzbae.valueAt(i)).zza(zzgq, zzik, z, this.zzbas, this.zzbap);
    }

    /* access modifiers changed from: 0000 */
    public final void zzd(int i, long j) {
        zzmc zzmc = (zzmc) this.zzbae.valueAt(i);
        if (!this.zzbas || j <= zzmc.zzhh()) {
            zzmc.zze(j, true);
        } else {
            zzmc.zzhu();
        }
    }

    public final zzjd zzb(int i, int i2) {
        zzmc zzmc = (zzmc) this.zzbae.get(i);
        if (zzmc != null) {
            return zzmc;
        }
        zzmc zzmc2 = new zzmc(this.zzazw);
        zzmc2.zza(this);
        this.zzbae.put(i, zzmc2);
        return zzmc2;
    }

    public final void zzge() {
        this.zzbah = true;
        this.handler.post(this.zzbac);
    }

    public final void zza(zzjb zzjb) {
        this.zzbag = zzjb;
        this.handler.post(this.zzbac);
    }

    public final void zzf(zzgo zzgo) {
        this.handler.post(this.zzbac);
    }

    /* access modifiers changed from: private */
    public final void zzhf() {
        if (!this.zzaei && !this.zzadu && this.zzbag != null && this.zzbah) {
            int size = this.zzbae.size();
            int i = 0;
            while (i < size) {
                if (((zzmc) this.zzbae.valueAt(i)).zzhr() != null) {
                    i++;
                } else {
                    return;
                }
            }
            this.zzbab.zzig();
            zzmh[] zzmhArr = new zzmh[size];
            this.zzban = new boolean[size];
            this.zzbam = new boolean[size];
            this.zzagh = this.zzbag.getDurationUs();
            int i2 = 0;
            while (true) {
                boolean z = true;
                if (i2 >= size) {
                    break;
                }
                zzgo zzhr = ((zzmc) this.zzbae.valueAt(i2)).zzhr();
                zzmhArr[i2] = new zzmh(zzhr);
                String str = zzhr.zzafc;
                if (!zzny.zzbd(str) && !zzny.zzbc(str)) {
                    z = false;
                }
                this.zzban[i2] = z;
                this.zzbao = z | this.zzbao;
                i2++;
            }
            this.zzbal = new zzmk(zzmhArr);
            this.zzadu = true;
            this.zzazv.zzb(new zzmi(this.zzagh, this.zzbag.zzgc()), null);
            this.zzbaf.zza(this);
        }
    }

    private final void zza(zzll zzll) {
        if (this.zzcb == -1) {
            this.zzcb = zzll.zzcb;
        }
    }

    private final void startLoading() {
        zzll zzll = new zzll(this, this.uri, this.zzamo, this.zzbaa, this.zzbab);
        if (this.zzadu) {
            zznr.checkState(zzhi());
            long j = this.zzagh;
            if (j == -9223372036854775807L || this.zzbaq < j) {
                zzll.zze(this.zzbag.zzdt(this.zzbaq), this.zzbaq);
                this.zzbaq = -9223372036854775807L;
            } else {
                this.zzbas = true;
                this.zzbaq = -9223372036854775807L;
                return;
            }
        }
        this.zzbar = zzhg();
        int i = this.zzazt;
        if (i == -1) {
            if (this.zzadu && this.zzcb == -1) {
                zzjb zzjb = this.zzbag;
                if (zzjb == null || zzjb.getDurationUs() == -9223372036854775807L) {
                    i = 6;
                }
            }
            i = 3;
        }
        this.zzazz.zza(zzll, this, i);
    }

    private final int zzhg() {
        int i = 0;
        for (int i2 = 0; i2 < this.zzbae.size(); i2++) {
            i += ((zzmc) this.zzbae.valueAt(i2)).zzhp();
        }
        return i;
    }

    private final long zzhh() {
        int size = this.zzbae.size();
        long j = Long.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            j = Math.max(j, ((zzmc) this.zzbae.valueAt(i)).zzhh());
        }
        return j;
    }

    private final boolean zzhi() {
        return this.zzbaq != -9223372036854775807L;
    }

    public final /* synthetic */ int zza(zznq zznq, long j, long j2, IOException iOException) {
        zzll zzll = (zzll) zznq;
        zza(zzll);
        Handler handler2 = this.zzacs;
        if (!(handler2 == null || this.zzazu == null)) {
            handler2.post(new zzlm(this, iOException));
        }
        if (iOException instanceof zzmj) {
            return 3;
        }
        boolean z = zzhg() > this.zzbar;
        if (this.zzcb == -1) {
            zzjb zzjb = this.zzbag;
            if (zzjb == null || zzjb.getDurationUs() == -9223372036854775807L) {
                this.zzbap = 0;
                this.zzbaj = this.zzadu;
                int size = this.zzbae.size();
                for (int i = 0; i < size; i++) {
                    ((zzmc) this.zzbae.valueAt(i)).zzj(!this.zzadu || this.zzbam[i]);
                }
                zzll.zze(0, 0);
            }
        }
        this.zzbar = zzhg();
        return z ? 1 : 0;
    }

    public final /* synthetic */ void zza(zznq zznq, long j, long j2, boolean z) {
        zza((zzll) zznq);
        if (!z && this.zzbak > 0) {
            int size = this.zzbae.size();
            for (int i = 0; i < size; i++) {
                ((zzmc) this.zzbae.valueAt(i)).zzj(this.zzbam[i]);
            }
            this.zzbaf.zza(this);
        }
    }

    public final /* synthetic */ void zza(zznq zznq, long j, long j2) {
        zza((zzll) zznq);
        this.zzbas = true;
        if (this.zzagh == -9223372036854775807L) {
            long zzhh = zzhh();
            this.zzagh = zzhh == Long.MIN_VALUE ? 0 : zzhh + TapjoyConstants.TIMER_INCREMENT;
            this.zzazv.zzb(new zzmi(this.zzagh, this.zzbag.zzgc()), null);
        }
        this.zzbaf.zza(this);
    }
}
