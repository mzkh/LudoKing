package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzgj implements zzgc {
    private int repeatMode;
    private final zzgx[] zzacp;
    private final zzmy zzacq;
    private final zzmv zzacr;
    private final Handler zzacs;
    private final zzgl zzact;
    private final CopyOnWriteArraySet<zzgf> zzacu;
    private final zzhd zzacv;
    private final zzha zzacw;
    private boolean zzacx;
    private boolean zzacy;
    private int zzacz;
    private int zzada;
    private int zzadb;
    private boolean zzadc;
    private zzgy zzadd;
    private Object zzade;
    private zzmk zzadf;
    private zzmv zzadg;
    private zzgu zzadh;
    private zzgn zzadi;
    private int zzadj;
    private int zzadk;
    private long zzadl;

    @SuppressLint({"HandlerLeak"})
    public zzgj(zzgx[] zzgxArr, zzmy zzmy, zzgs zzgs) {
        String str = zzof.zzbgt;
        String str2 = "Init ExoPlayerLib/2.4.2 [";
        StringBuilder sb = new StringBuilder(str2.length() + 1 + String.valueOf(str).length());
        sb.append(str2);
        sb.append(str);
        sb.append("]");
        Log.i("ExoPlayerImpl", sb.toString());
        zznr.checkState(zzgxArr.length > 0);
        this.zzacp = (zzgx[]) zznr.checkNotNull(zzgxArr);
        this.zzacq = (zzmy) zznr.checkNotNull(zzmy);
        this.zzacy = false;
        this.repeatMode = 0;
        this.zzacz = 1;
        this.zzacu = new CopyOnWriteArraySet<>();
        this.zzacr = new zzmv(new zzmt[zzgxArr.length]);
        this.zzadd = zzgy.zzagd;
        this.zzacv = new zzhd();
        this.zzacw = new zzha();
        this.zzadf = zzmk.zzbdc;
        this.zzadg = this.zzacr;
        this.zzadh = zzgu.zzafz;
        this.zzacs = new zzgi(this, Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper());
        this.zzadi = new zzgn(0, 0);
        zzgl zzgl = new zzgl(zzgxArr, zzmy, zzgs, this.zzacy, 0, this.zzacs, this.zzadi, this);
        this.zzact = zzgl;
    }

    public final void zza(zzgf zzgf) {
        this.zzacu.add(zzgf);
    }

    public final void zzb(zzgf zzgf) {
        this.zzacu.remove(zzgf);
    }

    public final int getPlaybackState() {
        return this.zzacz;
    }

    public final void zza(zzlu zzlu) {
        if (!this.zzadd.isEmpty() || this.zzade != null) {
            this.zzadd = zzgy.zzagd;
            this.zzade = null;
            Iterator it = this.zzacu.iterator();
            while (it.hasNext()) {
                ((zzgf) it.next()).zza(this.zzadd, this.zzade);
            }
        }
        if (this.zzacx) {
            this.zzacx = false;
            this.zzadf = zzmk.zzbdc;
            this.zzadg = this.zzacr;
            this.zzacq.zzd(null);
            Iterator it2 = this.zzacu.iterator();
            while (it2.hasNext()) {
                ((zzgf) it2.next()).zza(this.zzadf, this.zzadg);
            }
        }
        this.zzadb++;
        this.zzact.zza(zzlu, true);
    }

    public final void zze(boolean z) {
        if (this.zzacy != z) {
            this.zzacy = z;
            this.zzact.zze(z);
            Iterator it = this.zzacu.iterator();
            while (it.hasNext()) {
                ((zzgf) it.next()).zza(z, this.zzacz);
            }
        }
    }

    public final boolean zzdu() {
        return this.zzacy;
    }

    public final void seekTo(long j) {
        long j2;
        int zzdy = zzdy();
        if (zzdy < 0 || (!this.zzadd.isEmpty() && zzdy >= this.zzadd.zzep())) {
            throw new zzgt(this.zzadd, zzdy, j);
        }
        this.zzada++;
        this.zzadj = zzdy;
        if (!this.zzadd.isEmpty()) {
            this.zzadd.zza(zzdy, this.zzacv, false);
            if (j == -9223372036854775807L) {
                j2 = this.zzacv.zzagw;
            } else {
                j2 = zzga.zzdh(j);
            }
            long j3 = this.zzacv.zzagx + j2;
            long j4 = this.zzadd.zza(0, this.zzacw, false).zzagh;
            if (j4 != -9223372036854775807L) {
                int i = (j3 > j4 ? 1 : (j3 == j4 ? 0 : -1));
            }
        }
        this.zzadk = 0;
        if (j == -9223372036854775807L) {
            this.zzadl = 0;
            this.zzact.zza(this.zzadd, zzdy, -9223372036854775807L);
            return;
        }
        this.zzadl = j;
        this.zzact.zza(this.zzadd, zzdy, zzga.zzdh(j));
        Iterator it = this.zzacu.iterator();
        while (it.hasNext()) {
            ((zzgf) it.next()).zzdx();
        }
    }

    public final void stop() {
        this.zzact.stop();
    }

    public final void release() {
        this.zzact.release();
        this.zzacs.removeCallbacksAndMessages(null);
    }

    public final void zza(zzgh... zzghArr) {
        this.zzact.zza(zzghArr);
    }

    public final void zzb(zzgh... zzghArr) {
        this.zzact.zzb(zzghArr);
    }

    private final int zzdy() {
        if (this.zzadd.isEmpty() || this.zzada > 0) {
            return this.zzadj;
        }
        this.zzadd.zza(this.zzadi.zzadr, this.zzacw, false);
        return 0;
    }

    public final long getDuration() {
        if (this.zzadd.isEmpty()) {
            return -9223372036854775807L;
        }
        return zzga.zzdg(this.zzadd.zza(zzdy(), this.zzacv, false).zzagh);
    }

    public final long zzdw() {
        if (this.zzadd.isEmpty() || this.zzada > 0) {
            return this.zzadl;
        }
        this.zzadd.zza(this.zzadi.zzadr, this.zzacw, false);
        return this.zzacw.zzer() + zzga.zzdg(this.zzadi.zzaev);
    }

    public final long getBufferedPosition() {
        if (this.zzadd.isEmpty() || this.zzada > 0) {
            return this.zzadl;
        }
        this.zzadd.zza(this.zzadi.zzadr, this.zzacw, false);
        return this.zzacw.zzer() + zzga.zzdg(this.zzadi.zzaew);
    }

    public final int zzdv() {
        return this.zzacp.length;
    }

    /* access modifiers changed from: 0000 */
    public final void zza(Message message) {
        boolean z = true;
        switch (message.what) {
            case 0:
                this.zzadb--;
                return;
            case 1:
                this.zzacz = message.arg1;
                Iterator it = this.zzacu.iterator();
                while (it.hasNext()) {
                    ((zzgf) it.next()).zza(this.zzacy, this.zzacz);
                }
                return;
            case 2:
                if (message.arg1 == 0) {
                    z = false;
                }
                this.zzadc = z;
                Iterator it2 = this.zzacu.iterator();
                while (it2.hasNext()) {
                    ((zzgf) it2.next()).zzf(this.zzadc);
                }
                return;
            case 3:
                if (this.zzadb == 0) {
                    zzna zzna = (zzna) message.obj;
                    this.zzacx = true;
                    this.zzadf = zzna.zzbee;
                    this.zzadg = zzna.zzbef;
                    this.zzacq.zzd(zzna.zzbeg);
                    Iterator it3 = this.zzacu.iterator();
                    while (it3.hasNext()) {
                        ((zzgf) it3.next()).zza(this.zzadf, this.zzadg);
                    }
                    break;
                }
                break;
            case 4:
                int i = this.zzada - 1;
                this.zzada = i;
                if (i == 0) {
                    this.zzadi = (zzgn) message.obj;
                    if (message.arg1 != 0) {
                        Iterator it4 = this.zzacu.iterator();
                        while (it4.hasNext()) {
                            ((zzgf) it4.next()).zzdx();
                        }
                        return;
                    }
                }
                break;
            case 5:
                if (this.zzada == 0) {
                    this.zzadi = (zzgn) message.obj;
                    Iterator it5 = this.zzacu.iterator();
                    while (it5.hasNext()) {
                        ((zzgf) it5.next()).zzdx();
                    }
                    return;
                }
                break;
            case 6:
                zzgp zzgp = (zzgp) message.obj;
                this.zzada -= zzgp.zzafw;
                if (this.zzadb == 0) {
                    this.zzadd = zzgp.zzadd;
                    this.zzade = zzgp.zzade;
                    this.zzadi = zzgp.zzadi;
                    Iterator it6 = this.zzacu.iterator();
                    while (it6.hasNext()) {
                        ((zzgf) it6.next()).zza(this.zzadd, this.zzade);
                    }
                    return;
                }
                break;
            case 7:
                zzgu zzgu = (zzgu) message.obj;
                if (!this.zzadh.equals(zzgu)) {
                    this.zzadh = zzgu;
                    Iterator it7 = this.zzacu.iterator();
                    while (it7.hasNext()) {
                        ((zzgf) it7.next()).zza(zzgu);
                    }
                    return;
                }
                break;
            case 8:
                zzgd zzgd = (zzgd) message.obj;
                Iterator it8 = this.zzacu.iterator();
                while (it8.hasNext()) {
                    ((zzgf) it8.next()).zza(zzgd);
                }
                return;
            default:
                throw new IllegalStateException();
        }
    }
}
