package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import java.nio.ByteBuffer;

@TargetApi(16)
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzib extends zzkl implements zznv {
    private int zzafm;
    private int zzafo;
    /* access modifiers changed from: private */
    public final zzhj zzako;
    private final zzho zzakp;
    private boolean zzakq;
    private boolean zzakr;
    private MediaFormat zzaks;
    private long zzakt;
    /* access modifiers changed from: private */
    public boolean zzaku;

    public zzib(zzkn zzkn) {
        this(zzkn, null, true);
    }

    protected static void zza(int i, long j, long j2) {
    }

    protected static void zzfn() {
    }

    protected static void zzq(int i) {
    }

    public final zznv zzdk() {
        return this;
    }

    private zzib(zzkn zzkn, zzis<Object> zzis, boolean z) {
        this(zzkn, null, true, null, null);
    }

    private zzib(zzkn zzkn, zzis<Object> zzis, boolean z, Handler handler, zzhg zzhg) {
        this(zzkn, null, true, null, null, null, new zzhe[0]);
    }

    private zzib(zzkn zzkn, zzis<Object> zzis, boolean z, Handler handler, zzhg zzhg, zzhf zzhf, zzhe... zzheArr) {
        super(1, zzkn, zzis, z);
        this.zzakp = new zzho(null, zzheArr, new zzid(this));
        this.zzako = new zzhj(null, null);
    }

    /* access modifiers changed from: protected */
    public final int zza(zzkn zzkn, zzgo zzgo) throws zzkt {
        String str = zzgo.zzafc;
        if (!zzny.zzbc(str)) {
            return 0;
        }
        int i = zzof.SDK_INT >= 21 ? 16 : 0;
        int i2 = 3;
        if (zzax(str) && zzkn.zzgv() != null) {
            return i | 4 | 3;
        }
        zzkm zzc = zzkn.zzc(str, false);
        boolean z = true;
        if (zzc == null) {
            return 1;
        }
        if (zzof.SDK_INT >= 21 && ((zzgo.zzafn != -1 && !zzc.zzap(zzgo.zzafn)) || (zzgo.zzafm != -1 && !zzc.zzaq(zzgo.zzafm)))) {
            z = false;
        }
        if (!z) {
            i2 = 2;
        }
        return i | 4 | i2;
    }

    /* access modifiers changed from: protected */
    public final zzkm zza(zzkn zzkn, zzgo zzgo, boolean z) throws zzkt {
        if (zzax(zzgo.zzafc)) {
            zzkm zzgv = zzkn.zzgv();
            if (zzgv != null) {
                this.zzakq = true;
                return zzgv;
            }
        }
        this.zzakq = false;
        return super.zza(zzkn, zzgo, z);
    }

    private final boolean zzax(String str) {
        return this.zzakp.zzav(str);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.internal.ads.zzkm r4, android.media.MediaCodec r5, com.google.android.gms.internal.ads.zzgo r6, android.media.MediaCrypto r7) {
        /*
            r3 = this;
            java.lang.String r4 = r4.name
            int r7 = com.google.android.gms.internal.ads.zzof.SDK_INT
            r0 = 0
            r1 = 24
            if (r7 >= r1) goto L_0x003b
            java.lang.String r7 = "OMX.SEC.aac.dec"
            boolean r4 = r7.equals(r4)
            if (r4 == 0) goto L_0x003b
            java.lang.String r4 = com.google.android.gms.internal.ads.zzof.MANUFACTURER
            java.lang.String r7 = "samsung"
            boolean r4 = r7.equals(r4)
            if (r4 == 0) goto L_0x003b
            java.lang.String r4 = com.google.android.gms.internal.ads.zzof.DEVICE
            java.lang.String r7 = "zeroflte"
            boolean r4 = r4.startsWith(r7)
            if (r4 != 0) goto L_0x0039
            java.lang.String r4 = com.google.android.gms.internal.ads.zzof.DEVICE
            java.lang.String r7 = "herolte"
            boolean r4 = r4.startsWith(r7)
            if (r4 != 0) goto L_0x0039
            java.lang.String r4 = com.google.android.gms.internal.ads.zzof.DEVICE
            java.lang.String r7 = "heroqlte"
            boolean r4 = r4.startsWith(r7)
            if (r4 == 0) goto L_0x003b
        L_0x0039:
            r4 = 1
            goto L_0x003c
        L_0x003b:
            r4 = 0
        L_0x003c:
            r3.zzakr = r4
            boolean r4 = r3.zzakq
            r7 = 0
            if (r4 == 0) goto L_0x005f
            android.media.MediaFormat r4 = r6.zzek()
            r3.zzaks = r4
            android.media.MediaFormat r4 = r3.zzaks
            java.lang.String r1 = "mime"
            java.lang.String r2 = "audio/raw"
            r4.setString(r1, r2)
            android.media.MediaFormat r4 = r3.zzaks
            r5.configure(r4, r7, r7, r0)
            android.media.MediaFormat r4 = r3.zzaks
            java.lang.String r5 = r6.zzafc
            r4.setString(r1, r5)
            return
        L_0x005f:
            android.media.MediaFormat r4 = r6.zzek()
            r5.configure(r4, r7, r7, r0)
            r3.zzaks = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzib.zza(com.google.android.gms.internal.ads.zzkm, android.media.MediaCodec, com.google.android.gms.internal.ads.zzgo, android.media.MediaCrypto):void");
    }

    /* access modifiers changed from: protected */
    public final void zzc(String str, long j, long j2) {
        this.zzako.zzb(str, j, j2);
    }

    /* access modifiers changed from: protected */
    public final void zzd(zzgo zzgo) throws zzgd {
        super.zzd(zzgo);
        this.zzako.zzc(zzgo);
        this.zzafo = "audio/raw".equals(zzgo.zzafc) ? zzgo.zzafo : 2;
        this.zzafm = zzgo.zzafm;
    }

    /* access modifiers changed from: protected */
    public final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) throws zzgd {
        int[] iArr;
        boolean z = this.zzaks != null;
        String string = z ? this.zzaks.getString("mime") : "audio/raw";
        if (z) {
            mediaFormat = this.zzaks;
        }
        int integer = mediaFormat.getInteger("channel-count");
        int integer2 = mediaFormat.getInteger("sample-rate");
        if (this.zzakr && integer == 6) {
            int i = this.zzafm;
            if (i < 6) {
                iArr = new int[i];
                for (int i2 = 0; i2 < this.zzafm; i2++) {
                    iArr[i2] = i2;
                }
                this.zzakp.zza(string, integer, integer2, this.zzafo, 0, iArr);
            }
        }
        iArr = null;
        try {
            this.zzakp.zza(string, integer, integer2, this.zzafo, 0, iArr);
        } catch (zzhs e) {
            throw zzgd.zza(e, getIndex());
        }
    }

    /* access modifiers changed from: protected */
    public final void zzd(boolean z) throws zzgd {
        super.zzd(z);
        this.zzako.zzc(this.zzayw);
        int i = zzds().zzagf;
        if (i != 0) {
            this.zzakp.zzs(i);
        } else {
            this.zzakp.zzfd();
        }
    }

    /* access modifiers changed from: protected */
    public final void zza(long j, boolean z) throws zzgd {
        super.zza(j, z);
        this.zzakp.reset();
        this.zzakt = j;
        this.zzaku = true;
    }

    /* access modifiers changed from: protected */
    public final void onStarted() {
        super.onStarted();
        this.zzakp.play();
    }

    /* access modifiers changed from: protected */
    public final void onStopped() {
        this.zzakp.pause();
        super.onStopped();
    }

    /* access modifiers changed from: protected */
    public final void zzdr() {
        try {
            this.zzakp.release();
            try {
                super.zzdr();
            } finally {
                this.zzayw.zzfy();
                this.zzako.zzd(this.zzayw);
            }
        } catch (Throwable th) {
            super.zzdr();
            throw th;
        } finally {
            this.zzayw.zzfy();
            this.zzako.zzd(this.zzayw);
        }
    }

    public final boolean zzeo() {
        return super.zzeo() && this.zzakp.zzeo();
    }

    public final boolean isReady() {
        return this.zzakp.zzfb() || super.isReady();
    }

    public final long zzfj() {
        long zzi = this.zzakp.zzi(zzeo());
        if (zzi != Long.MIN_VALUE) {
            if (!this.zzaku) {
                zzi = Math.max(this.zzakt, zzi);
            }
            this.zzakt = zzi;
            this.zzaku = false;
        }
        return this.zzakt;
    }

    public final zzgu zzb(zzgu zzgu) {
        return this.zzakp.zzb(zzgu);
    }

    public final zzgu zzfc() {
        return this.zzakp.zzfc();
    }

    /* access modifiers changed from: protected */
    public final boolean zza(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) throws zzgd {
        if (this.zzakq && (i2 & 2) != 0) {
            mediaCodec.releaseOutputBuffer(i, false);
            return true;
        } else if (z) {
            mediaCodec.releaseOutputBuffer(i, false);
            this.zzayw.zzamh++;
            this.zzakp.zzey();
            return true;
        } else {
            try {
                if (!this.zzakp.zza(byteBuffer, j3)) {
                    return false;
                }
                mediaCodec.releaseOutputBuffer(i, false);
                this.zzayw.zzamg++;
                return true;
            } catch (zzhv | zzhw e) {
                throw zzgd.zza(e, getIndex());
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void zzfo() throws zzgd {
        try {
            this.zzakp.zzez();
        } catch (zzhw e) {
            throw zzgd.zza(e, getIndex());
        }
    }

    public final void zza(int i, Object obj) throws zzgd {
        if (i == 2) {
            this.zzakp.setVolume(((Float) obj).floatValue());
        } else if (i != 3) {
            super.zza(i, obj);
        } else {
            this.zzakp.setStreamType(((Integer) obj).intValue());
        }
    }
}
