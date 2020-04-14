package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Looper;
import android.os.SystemClock;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@TargetApi(16)
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public abstract class zzkl extends zzgb {
    private static final byte[] zzaxm = zzof.zzbj("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
    private zzgo zzafx;
    private ByteBuffer[] zzajd;
    private final zzkn zzaxn;
    private final zzis<Object> zzaxo;
    private final boolean zzaxp;
    private final zzik zzaxq;
    private final zzik zzaxr;
    private final zzgq zzaxs;
    private final List<Long> zzaxt;
    private final BufferInfo zzaxu;
    private zziq<Object> zzaxv;
    private zziq<Object> zzaxw;
    private MediaCodec zzaxx;
    private zzkm zzaxy;
    private boolean zzaxz;
    private boolean zzaya;
    private boolean zzayb;
    private boolean zzayc;
    private boolean zzayd;
    private boolean zzaye;
    private boolean zzayf;
    private boolean zzayg;
    private boolean zzayh;
    private ByteBuffer[] zzayi;
    private long zzayj;
    private int zzayk;
    private int zzayl;
    private boolean zzaym;
    private boolean zzayn;
    private int zzayo;
    private int zzayp;
    private boolean zzayq;
    private boolean zzayr;
    private boolean zzays;
    private boolean zzayt;
    private boolean zzayu;
    private boolean zzayv;
    protected zzil zzayw;

    public zzkl(int i, zzkn zzkn, zzis<Object> zzis, boolean z) {
        super(i);
        zznr.checkState(zzof.SDK_INT >= 16);
        this.zzaxn = (zzkn) zznr.checkNotNull(zzkn);
        this.zzaxo = zzis;
        this.zzaxp = z;
        this.zzaxq = new zzik(0);
        this.zzaxr = new zzik(0);
        this.zzaxs = new zzgq();
        this.zzaxt = new ArrayList();
        this.zzaxu = new BufferInfo();
        this.zzayo = 0;
        this.zzayp = 0;
    }

    /* access modifiers changed from: protected */
    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) throws zzgd {
    }

    /* access modifiers changed from: protected */
    public void onStarted() {
    }

    /* access modifiers changed from: protected */
    public void onStopped() {
    }

    /* access modifiers changed from: protected */
    public abstract int zza(zzkn zzkn, zzgo zzgo) throws zzkt;

    /* access modifiers changed from: protected */
    public void zza(zzik zzik) {
    }

    /* access modifiers changed from: protected */
    public abstract void zza(zzkm zzkm, MediaCodec mediaCodec, zzgo zzgo, MediaCrypto mediaCrypto) throws zzkt;

    /* access modifiers changed from: protected */
    public abstract boolean zza(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) throws zzgd;

    /* access modifiers changed from: protected */
    public boolean zza(MediaCodec mediaCodec, boolean z, zzgo zzgo, zzgo zzgo2) {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean zza(zzkm zzkm) {
        return true;
    }

    /* access modifiers changed from: protected */
    public void zzc(String str, long j, long j2) {
    }

    public final int zzdq() {
        return 4;
    }

    /* access modifiers changed from: protected */
    public void zzfo() throws zzgd {
    }

    public final int zza(zzgo zzgo) throws zzgd {
        try {
            return zza(this.zzaxn, zzgo);
        } catch (zzkt e) {
            throw zzgd.zza(e, getIndex());
        }
    }

    /* access modifiers changed from: protected */
    public zzkm zza(zzkn zzkn, zzgo zzgo, boolean z) throws zzkt {
        return zzkn.zzc(zzgo.zzafc, z);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0114, code lost:
        if ("tilapia".equals(com.google.android.gms.internal.ads.zzof.DEVICE) != false) goto L_0x0116;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0160, code lost:
        if ("OMX.amlogic.avc.decoder.awesome.secure".equals(r0) != false) goto L_0x0162;
     */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x017e  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x019f A[Catch:{ Exception -> 0x01f0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x01a4 A[Catch:{ Exception -> 0x01f0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0202  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x020a  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x016b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzgo() throws com.google.android.gms.internal.ads.zzgd {
        /*
            r10 = this;
            android.media.MediaCodec r0 = r10.zzaxx
            if (r0 != 0) goto L_0x021f
            com.google.android.gms.internal.ads.zzgo r0 = r10.zzafx
            if (r0 != 0) goto L_0x000a
            goto L_0x021f
        L_0x000a:
            com.google.android.gms.internal.ads.zziq<java.lang.Object> r1 = r10.zzaxw
            r10.zzaxv = r1
            java.lang.String r0 = r0.zzafc
            com.google.android.gms.internal.ads.zziq<java.lang.Object> r0 = r10.zzaxv
            if (r0 == 0) goto L_0x003b
            int r0 = r0.getState()
            if (r0 == 0) goto L_0x002c
            r1 = 3
            if (r0 == r1) goto L_0x0021
            r1 = 4
            if (r0 == r1) goto L_0x0021
            return
        L_0x0021:
            com.google.android.gms.internal.ads.zziq<java.lang.Object> r0 = r10.zzaxv
            r0.zzfz()
            java.lang.NoSuchMethodError r0 = new java.lang.NoSuchMethodError
            r0.<init>()
            throw r0
        L_0x002c:
            com.google.android.gms.internal.ads.zziq<java.lang.Object> r0 = r10.zzaxv
            com.google.android.gms.internal.ads.zzip r0 = r0.zzga()
            int r1 = r10.getIndex()
            com.google.android.gms.internal.ads.zzgd r0 = com.google.android.gms.internal.ads.zzgd.zza(r0, r1)
            throw r0
        L_0x003b:
            com.google.android.gms.internal.ads.zzkm r0 = r10.zzaxy
            r1 = 0
            r2 = 0
            if (r0 != 0) goto L_0x006d
            com.google.android.gms.internal.ads.zzkn r0 = r10.zzaxn     // Catch:{ zzkt -> 0x004e }
            com.google.android.gms.internal.ads.zzgo r3 = r10.zzafx     // Catch:{ zzkt -> 0x004e }
            com.google.android.gms.internal.ads.zzkm r0 = r10.zza(r0, r3, r2)     // Catch:{ zzkt -> 0x004e }
            r10.zzaxy = r0     // Catch:{ zzkt -> 0x004e }
            com.google.android.gms.internal.ads.zzkm r0 = r10.zzaxy     // Catch:{ zzkt -> 0x004e }
            goto L_0x005c
        L_0x004e:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzko r3 = new com.google.android.gms.internal.ads.zzko
            com.google.android.gms.internal.ads.zzgo r4 = r10.zzafx
            r5 = -49998(0xffffffffffff3cb2, float:NaN)
            r3.<init>(r4, r0, r2, r5)
            r10.zza(r3)
        L_0x005c:
            com.google.android.gms.internal.ads.zzkm r0 = r10.zzaxy
            if (r0 != 0) goto L_0x006d
            com.google.android.gms.internal.ads.zzko r0 = new com.google.android.gms.internal.ads.zzko
            com.google.android.gms.internal.ads.zzgo r3 = r10.zzafx
            r4 = -49999(0xffffffffffff3cb1, float:NaN)
            r0.<init>(r3, r1, r2, r4)
            r10.zza(r0)
        L_0x006d:
            com.google.android.gms.internal.ads.zzkm r0 = r10.zzaxy
            boolean r0 = r10.zza(r0)
            if (r0 != 0) goto L_0x0076
            return
        L_0x0076:
            com.google.android.gms.internal.ads.zzkm r0 = r10.zzaxy
            java.lang.String r0 = r0.name
            com.google.android.gms.internal.ads.zzgo r3 = r10.zzafx
            int r4 = com.google.android.gms.internal.ads.zzof.SDK_INT
            r5 = 21
            r9 = 1
            if (r4 >= r5) goto L_0x0095
            java.util.List<byte[]> r3 = r3.zzafe
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x0095
            java.lang.String r3 = "OMX.MTK.VIDEO.DECODER.AVC"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0095
            r3 = 1
            goto L_0x0096
        L_0x0095:
            r3 = 0
        L_0x0096:
            r10.zzaxz = r3
            int r3 = com.google.android.gms.internal.ads.zzof.SDK_INT
            r4 = 19
            r6 = 18
            if (r3 < r6) goto L_0x00d5
            int r3 = com.google.android.gms.internal.ads.zzof.SDK_INT
            if (r3 != r6) goto L_0x00b4
            java.lang.String r3 = "OMX.SEC.avc.dec"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L_0x00d5
            java.lang.String r3 = "OMX.SEC.avc.dec.secure"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L_0x00d5
        L_0x00b4:
            int r3 = com.google.android.gms.internal.ads.zzof.SDK_INT
            if (r3 != r4) goto L_0x00d3
            java.lang.String r3 = com.google.android.gms.internal.ads.zzof.MODEL
            java.lang.String r7 = "SM-G800"
            boolean r3 = r3.startsWith(r7)
            if (r3 == 0) goto L_0x00d3
            java.lang.String r3 = "OMX.Exynos.avc.dec"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L_0x00d5
            java.lang.String r3 = "OMX.Exynos.avc.dec.secure"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x00d3
            goto L_0x00d5
        L_0x00d3:
            r3 = 0
            goto L_0x00d6
        L_0x00d5:
            r3 = 1
        L_0x00d6:
            r10.zzaya = r3
            int r3 = com.google.android.gms.internal.ads.zzof.SDK_INT
            r7 = 24
            if (r3 >= r7) goto L_0x0118
            java.lang.String r3 = "OMX.Nvidia.h264.decode"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L_0x00ee
            java.lang.String r3 = "OMX.Nvidia.h264.decode.secure"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0118
        L_0x00ee:
            java.lang.String r3 = com.google.android.gms.internal.ads.zzof.DEVICE
            java.lang.String r7 = "flounder"
            boolean r3 = r7.equals(r3)
            if (r3 != 0) goto L_0x0116
            java.lang.String r3 = com.google.android.gms.internal.ads.zzof.DEVICE
            java.lang.String r7 = "flounder_lte"
            boolean r3 = r7.equals(r3)
            if (r3 != 0) goto L_0x0116
            java.lang.String r3 = com.google.android.gms.internal.ads.zzof.DEVICE
            java.lang.String r7 = "grouper"
            boolean r3 = r7.equals(r3)
            if (r3 != 0) goto L_0x0116
            java.lang.String r3 = com.google.android.gms.internal.ads.zzof.DEVICE
            java.lang.String r7 = "tilapia"
            boolean r3 = r7.equals(r3)
            if (r3 == 0) goto L_0x0118
        L_0x0116:
            r3 = 1
            goto L_0x0119
        L_0x0118:
            r3 = 0
        L_0x0119:
            r10.zzayb = r3
            int r3 = com.google.android.gms.internal.ads.zzof.SDK_INT
            r7 = 17
            if (r3 > r7) goto L_0x0133
            java.lang.String r3 = "OMX.rk.video_decoder.avc"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L_0x0131
            java.lang.String r3 = "OMX.allwinner.video.decoder.avc"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0133
        L_0x0131:
            r3 = 1
            goto L_0x0134
        L_0x0133:
            r3 = 0
        L_0x0134:
            r10.zzayc = r3
            int r3 = com.google.android.gms.internal.ads.zzof.SDK_INT
            r7 = 23
            if (r3 > r7) goto L_0x0144
            java.lang.String r3 = "OMX.google.vorbis.decoder"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L_0x0162
        L_0x0144:
            int r3 = com.google.android.gms.internal.ads.zzof.SDK_INT
            if (r3 > r4) goto L_0x0164
            java.lang.String r3 = com.google.android.gms.internal.ads.zzof.DEVICE
            java.lang.String r4 = "hb2000"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x0164
            java.lang.String r3 = "OMX.amlogic.avc.decoder.awesome"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L_0x0162
            java.lang.String r3 = "OMX.amlogic.avc.decoder.awesome.secure"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0164
        L_0x0162:
            r3 = 1
            goto L_0x0165
        L_0x0164:
            r3 = 0
        L_0x0165:
            r10.zzayd = r3
            int r3 = com.google.android.gms.internal.ads.zzof.SDK_INT
            if (r3 != r5) goto L_0x0175
            java.lang.String r3 = "OMX.google.aac.decoder"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0175
            r3 = 1
            goto L_0x0176
        L_0x0175:
            r3 = 0
        L_0x0176:
            r10.zzaye = r3
            com.google.android.gms.internal.ads.zzgo r3 = r10.zzafx
            int r4 = com.google.android.gms.internal.ads.zzof.SDK_INT
            if (r4 > r6) goto L_0x018c
            int r3 = r3.zzafm
            if (r3 != r9) goto L_0x018c
            java.lang.String r3 = "OMX.MTK.AUDIO.DECODER.MP3"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x018c
            r3 = 1
            goto L_0x018d
        L_0x018c:
            r3 = 0
        L_0x018d:
            r10.zzayf = r3
            long r3 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x01f0 }
            java.lang.String r5 = "createCodec:"
            java.lang.String r6 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x01f0 }
            int r7 = r6.length()     // Catch:{ Exception -> 0x01f0 }
            if (r7 == 0) goto L_0x01a4
            java.lang.String r5 = r5.concat(r6)     // Catch:{ Exception -> 0x01f0 }
            goto L_0x01aa
        L_0x01a4:
            java.lang.String r6 = new java.lang.String     // Catch:{ Exception -> 0x01f0 }
            r6.<init>(r5)     // Catch:{ Exception -> 0x01f0 }
            r5 = r6
        L_0x01aa:
            com.google.android.gms.internal.ads.zzog.beginSection(r5)     // Catch:{ Exception -> 0x01f0 }
            android.media.MediaCodec r5 = android.media.MediaCodec.createByCodecName(r0)     // Catch:{ Exception -> 0x01f0 }
            r10.zzaxx = r5     // Catch:{ Exception -> 0x01f0 }
            com.google.android.gms.internal.ads.zzog.endSection()     // Catch:{ Exception -> 0x01f0 }
            java.lang.String r5 = "configureCodec"
            com.google.android.gms.internal.ads.zzog.beginSection(r5)     // Catch:{ Exception -> 0x01f0 }
            com.google.android.gms.internal.ads.zzkm r5 = r10.zzaxy     // Catch:{ Exception -> 0x01f0 }
            android.media.MediaCodec r6 = r10.zzaxx     // Catch:{ Exception -> 0x01f0 }
            com.google.android.gms.internal.ads.zzgo r7 = r10.zzafx     // Catch:{ Exception -> 0x01f0 }
            r10.zza(r5, r6, r7, r1)     // Catch:{ Exception -> 0x01f0 }
            com.google.android.gms.internal.ads.zzog.endSection()     // Catch:{ Exception -> 0x01f0 }
            java.lang.String r1 = "startCodec"
            com.google.android.gms.internal.ads.zzog.beginSection(r1)     // Catch:{ Exception -> 0x01f0 }
            android.media.MediaCodec r1 = r10.zzaxx     // Catch:{ Exception -> 0x01f0 }
            r1.start()     // Catch:{ Exception -> 0x01f0 }
            com.google.android.gms.internal.ads.zzog.endSection()     // Catch:{ Exception -> 0x01f0 }
            long r5 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x01f0 }
            long r7 = r5 - r3
            r3 = r10
            r4 = r0
            r3.zzc(r4, r5, r7)     // Catch:{ Exception -> 0x01f0 }
            android.media.MediaCodec r1 = r10.zzaxx     // Catch:{ Exception -> 0x01f0 }
            java.nio.ByteBuffer[] r1 = r1.getInputBuffers()     // Catch:{ Exception -> 0x01f0 }
            r10.zzayi = r1     // Catch:{ Exception -> 0x01f0 }
            android.media.MediaCodec r1 = r10.zzaxx     // Catch:{ Exception -> 0x01f0 }
            java.nio.ByteBuffer[] r1 = r1.getOutputBuffers()     // Catch:{ Exception -> 0x01f0 }
            r10.zzajd = r1     // Catch:{ Exception -> 0x01f0 }
            goto L_0x01fb
        L_0x01f0:
            r1 = move-exception
            com.google.android.gms.internal.ads.zzko r3 = new com.google.android.gms.internal.ads.zzko
            com.google.android.gms.internal.ads.zzgo r4 = r10.zzafx
            r3.<init>(r4, r1, r2, r0)
            r10.zza(r3)
        L_0x01fb:
            int r0 = r10.getState()
            r1 = 2
            if (r0 != r1) goto L_0x020a
            long r0 = android.os.SystemClock.elapsedRealtime()
            r2 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 + r2
            goto L_0x020f
        L_0x020a:
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L_0x020f:
            r10.zzayj = r0
            r0 = -1
            r10.zzayk = r0
            r10.zzayl = r0
            r10.zzayv = r9
            com.google.android.gms.internal.ads.zzil r0 = r10.zzayw
            int r1 = r0.zzamd
            int r1 = r1 + r9
            r0.zzamd = r1
        L_0x021f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkl.zzgo():void");
    }

    private final void zza(zzko zzko) throws zzgd {
        throw zzgd.zza(zzko, getIndex());
    }

    /* access modifiers changed from: protected */
    public final MediaCodec zzgp() {
        return this.zzaxx;
    }

    /* access modifiers changed from: protected */
    public final zzkm zzgq() {
        return this.zzaxy;
    }

    /* access modifiers changed from: protected */
    public void zzd(boolean z) throws zzgd {
        this.zzayw = new zzil();
    }

    /* access modifiers changed from: protected */
    public void zza(long j, boolean z) throws zzgd {
        this.zzays = false;
        this.zzayt = false;
        if (this.zzaxx != null) {
            this.zzayj = -9223372036854775807L;
            this.zzayk = -1;
            this.zzayl = -1;
            this.zzayv = true;
            this.zzayu = false;
            this.zzaym = false;
            this.zzaxt.clear();
            this.zzayg = false;
            this.zzayh = false;
            if (this.zzaya || (this.zzayd && this.zzayr)) {
                zzgr();
                zzgo();
            } else if (this.zzayp != 0) {
                zzgr();
                zzgo();
            } else {
                this.zzaxx.flush();
                this.zzayq = false;
            }
            if (this.zzayn && this.zzafx != null) {
                this.zzayo = 1;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void zzdr() {
        this.zzafx = null;
        try {
            zzgr();
            try {
                if (this.zzaxv != null) {
                    this.zzaxo.zza(this.zzaxv);
                }
                try {
                    if (!(this.zzaxw == null || this.zzaxw == this.zzaxv)) {
                        this.zzaxo.zza(this.zzaxw);
                    }
                } finally {
                    this.zzaxv = null;
                    this.zzaxw = null;
                }
            } catch (Throwable th) {
                if (!(this.zzaxw == null || this.zzaxw == this.zzaxv)) {
                    this.zzaxo.zza(this.zzaxw);
                }
                throw th;
            } finally {
                this.zzaxv = null;
                this.zzaxw = null;
            }
        } catch (Throwable th2) {
            try {
                if (!(this.zzaxw == null || this.zzaxw == this.zzaxv)) {
                    this.zzaxo.zza(this.zzaxw);
                }
                throw th2;
            } finally {
                this.zzaxv = null;
                this.zzaxw = null;
            }
        } finally {
            this.zzaxv = null;
            this.zzaxw = null;
        }
    }

    /* access modifiers changed from: protected */
    public void zzgr() {
        this.zzayj = -9223372036854775807L;
        this.zzayk = -1;
        this.zzayl = -1;
        this.zzayu = false;
        this.zzaym = false;
        this.zzaxt.clear();
        this.zzayi = null;
        this.zzajd = null;
        this.zzaxy = null;
        this.zzayn = false;
        this.zzayq = false;
        this.zzaxz = false;
        this.zzaya = false;
        this.zzayb = false;
        this.zzayc = false;
        this.zzayd = false;
        this.zzayf = false;
        this.zzayg = false;
        this.zzayh = false;
        this.zzayr = false;
        this.zzayo = 0;
        this.zzayp = 0;
        this.zzaxq.zzcq = null;
        if (this.zzaxx != null) {
            this.zzayw.zzame++;
            try {
                this.zzaxx.stop();
                try {
                    this.zzaxx.release();
                    this.zzaxx = null;
                    zziq<Object> zziq = this.zzaxv;
                    if (zziq != null && this.zzaxw != zziq) {
                        try {
                            this.zzaxo.zza(zziq);
                        } finally {
                            this.zzaxv = null;
                        }
                    }
                } catch (Throwable th) {
                    this.zzaxx = null;
                    zziq<Object> zziq2 = this.zzaxv;
                    if (!(zziq2 == null || this.zzaxw == zziq2)) {
                        this.zzaxo.zza(zziq2);
                    }
                    throw th;
                } finally {
                    this.zzaxv = null;
                }
            } catch (Throwable th2) {
                this.zzaxx = null;
                zziq<Object> zziq3 = this.zzaxv;
                if (!(zziq3 == null || this.zzaxw == zziq3)) {
                    try {
                        this.zzaxo.zza(zziq3);
                    } finally {
                        this.zzaxv = null;
                    }
                }
                throw th2;
            } finally {
                this.zzaxv = null;
            }
        }
    }

    public final void zzb(long j, long j2) throws zzgd {
        if (this.zzayt) {
            zzfo();
            return;
        }
        if (this.zzafx == null) {
            this.zzaxr.clear();
            int zza = zza(this.zzaxs, this.zzaxr, true);
            if (zza == -5) {
                zzd(this.zzaxs.zzafx);
            } else {
                if (zza == -4) {
                    zznr.checkState(this.zzaxr.zzfv());
                    this.zzays = true;
                    zzgt();
                }
                return;
            }
        }
        zzgo();
        if (this.zzaxx != null) {
            zzog.beginSection("drainAndFeed");
            do {
            } while (zzd(j, j2));
            do {
            } while (zzgs());
            zzog.endSection();
        } else {
            zzdj(j);
            this.zzaxr.clear();
            int zza2 = zza(this.zzaxs, this.zzaxr, false);
            if (zza2 == -5) {
                zzd(this.zzaxs.zzafx);
            } else if (zza2 == -4) {
                zznr.checkState(this.zzaxr.zzfv());
                this.zzays = true;
                zzgt();
            }
        }
        this.zzayw.zzfy();
    }

    /* JADX WARNING: Removed duplicated region for block: B:84:0x014b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x014c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzgs() throws com.google.android.gms.internal.ads.zzgd {
        /*
            r14 = this;
            android.media.MediaCodec r0 = r14.zzaxx
            r1 = 0
            if (r0 == 0) goto L_0x01d6
            int r2 = r14.zzayp
            r3 = 2
            if (r2 == r3) goto L_0x01d6
            boolean r2 = r14.zzays
            if (r2 == 0) goto L_0x0010
            goto L_0x01d6
        L_0x0010:
            int r2 = r14.zzayk
            if (r2 >= 0) goto L_0x002c
            r4 = 0
            int r0 = r0.dequeueInputBuffer(r4)
            r14.zzayk = r0
            int r0 = r14.zzayk
            if (r0 >= 0) goto L_0x0021
            return r1
        L_0x0021:
            com.google.android.gms.internal.ads.zzik r2 = r14.zzaxq
            java.nio.ByteBuffer[] r4 = r14.zzayi
            r0 = r4[r0]
            r2.zzcq = r0
            r2.clear()
        L_0x002c:
            int r0 = r14.zzayp
            r2 = -1
            r4 = 1
            if (r0 != r4) goto L_0x0049
            boolean r0 = r14.zzayc
            if (r0 != 0) goto L_0x0046
            r14.zzayr = r4
            android.media.MediaCodec r5 = r14.zzaxx
            int r6 = r14.zzayk
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 4
            r5.queueInputBuffer(r6, r7, r8, r9, r11)
            r14.zzayk = r2
        L_0x0046:
            r14.zzayp = r3
            return r1
        L_0x0049:
            boolean r0 = r14.zzayg
            if (r0 == 0) goto L_0x006b
            r14.zzayg = r1
            com.google.android.gms.internal.ads.zzik r0 = r14.zzaxq
            java.nio.ByteBuffer r0 = r0.zzcq
            byte[] r1 = zzaxm
            r0.put(r1)
            android.media.MediaCodec r5 = r14.zzaxx
            int r6 = r14.zzayk
            r7 = 0
            byte[] r0 = zzaxm
            int r8 = r0.length
            r9 = 0
            r11 = 0
            r5.queueInputBuffer(r6, r7, r8, r9, r11)
            r14.zzayk = r2
            r14.zzayq = r4
            return r4
        L_0x006b:
            boolean r0 = r14.zzayu
            if (r0 == 0) goto L_0x0072
            r0 = -4
            r5 = 0
            goto L_0x00aa
        L_0x0072:
            int r0 = r14.zzayo
            if (r0 != r4) goto L_0x0097
            r0 = 0
        L_0x0077:
            com.google.android.gms.internal.ads.zzgo r5 = r14.zzafx
            java.util.List<byte[]> r5 = r5.zzafe
            int r5 = r5.size()
            if (r0 >= r5) goto L_0x0095
            com.google.android.gms.internal.ads.zzgo r5 = r14.zzafx
            java.util.List<byte[]> r5 = r5.zzafe
            java.lang.Object r5 = r5.get(r0)
            byte[] r5 = (byte[]) r5
            com.google.android.gms.internal.ads.zzik r6 = r14.zzaxq
            java.nio.ByteBuffer r6 = r6.zzcq
            r6.put(r5)
            int r0 = r0 + 1
            goto L_0x0077
        L_0x0095:
            r14.zzayo = r3
        L_0x0097:
            com.google.android.gms.internal.ads.zzik r0 = r14.zzaxq
            java.nio.ByteBuffer r0 = r0.zzcq
            int r0 = r0.position()
            com.google.android.gms.internal.ads.zzgq r5 = r14.zzaxs
            com.google.android.gms.internal.ads.zzik r6 = r14.zzaxq
            int r5 = r14.zza(r5, r6, r1)
            r13 = r5
            r5 = r0
            r0 = r13
        L_0x00aa:
            r6 = -3
            if (r0 != r6) goto L_0x00ae
            return r1
        L_0x00ae:
            r6 = -5
            if (r0 != r6) goto L_0x00c4
            int r0 = r14.zzayo
            if (r0 != r3) goto L_0x00bc
            com.google.android.gms.internal.ads.zzik r0 = r14.zzaxq
            r0.clear()
            r14.zzayo = r4
        L_0x00bc:
            com.google.android.gms.internal.ads.zzgq r0 = r14.zzaxs
            com.google.android.gms.internal.ads.zzgo r0 = r0.zzafx
            r14.zzd(r0)
            return r4
        L_0x00c4:
            com.google.android.gms.internal.ads.zzik r0 = r14.zzaxq
            boolean r0 = r0.zzfv()
            if (r0 == 0) goto L_0x0100
            int r0 = r14.zzayo
            if (r0 != r3) goto L_0x00d7
            com.google.android.gms.internal.ads.zzik r0 = r14.zzaxq
            r0.clear()
            r14.zzayo = r4
        L_0x00d7:
            r14.zzays = r4
            boolean r0 = r14.zzayq
            if (r0 != 0) goto L_0x00e1
            r14.zzgt()
            return r1
        L_0x00e1:
            boolean r0 = r14.zzayc     // Catch:{ CryptoException -> 0x00f6 }
            if (r0 != 0) goto L_0x00f5
            r14.zzayr = r4     // Catch:{ CryptoException -> 0x00f6 }
            android.media.MediaCodec r5 = r14.zzaxx     // Catch:{ CryptoException -> 0x00f6 }
            int r6 = r14.zzayk     // Catch:{ CryptoException -> 0x00f6 }
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 4
            r5.queueInputBuffer(r6, r7, r8, r9, r11)     // Catch:{ CryptoException -> 0x00f6 }
            r14.zzayk = r2     // Catch:{ CryptoException -> 0x00f6 }
        L_0x00f5:
            return r1
        L_0x00f6:
            r0 = move-exception
            int r1 = r14.getIndex()
            com.google.android.gms.internal.ads.zzgd r0 = com.google.android.gms.internal.ads.zzgd.zza(r0, r1)
            throw r0
        L_0x0100:
            boolean r0 = r14.zzayv
            if (r0 == 0) goto L_0x0118
            com.google.android.gms.internal.ads.zzik r0 = r14.zzaxq
            boolean r0 = r0.zzfw()
            if (r0 != 0) goto L_0x0118
            com.google.android.gms.internal.ads.zzik r0 = r14.zzaxq
            r0.clear()
            int r0 = r14.zzayo
            if (r0 != r3) goto L_0x0117
            r14.zzayo = r4
        L_0x0117:
            return r4
        L_0x0118:
            r14.zzayv = r1
            com.google.android.gms.internal.ads.zzik r0 = r14.zzaxq
            boolean r0 = r0.zzfx()
            com.google.android.gms.internal.ads.zziq<java.lang.Object> r3 = r14.zzaxv
            if (r3 == 0) goto L_0x0144
            int r3 = r3.getState()
            if (r3 == 0) goto L_0x0135
            r6 = 4
            if (r3 == r6) goto L_0x0144
            if (r0 != 0) goto L_0x0133
            boolean r3 = r14.zzaxp
            if (r3 != 0) goto L_0x0144
        L_0x0133:
            r3 = 1
            goto L_0x0145
        L_0x0135:
            com.google.android.gms.internal.ads.zziq<java.lang.Object> r0 = r14.zzaxv
            com.google.android.gms.internal.ads.zzip r0 = r0.zzga()
            int r1 = r14.getIndex()
            com.google.android.gms.internal.ads.zzgd r0 = com.google.android.gms.internal.ads.zzgd.zza(r0, r1)
            throw r0
        L_0x0144:
            r3 = 0
        L_0x0145:
            r14.zzayu = r3
            boolean r3 = r14.zzayu
            if (r3 == 0) goto L_0x014c
            return r1
        L_0x014c:
            boolean r3 = r14.zzaxz
            if (r3 == 0) goto L_0x0166
            if (r0 != 0) goto L_0x0166
            com.google.android.gms.internal.ads.zzik r3 = r14.zzaxq
            java.nio.ByteBuffer r3 = r3.zzcq
            com.google.android.gms.internal.ads.zznx.zzk(r3)
            com.google.android.gms.internal.ads.zzik r3 = r14.zzaxq
            java.nio.ByteBuffer r3 = r3.zzcq
            int r3 = r3.position()
            if (r3 != 0) goto L_0x0164
            return r4
        L_0x0164:
            r14.zzaxz = r1
        L_0x0166:
            com.google.android.gms.internal.ads.zzik r3 = r14.zzaxq     // Catch:{ CryptoException -> 0x01cc }
            long r10 = r3.zzamb     // Catch:{ CryptoException -> 0x01cc }
            com.google.android.gms.internal.ads.zzik r3 = r14.zzaxq     // Catch:{ CryptoException -> 0x01cc }
            boolean r3 = r3.zzfu()     // Catch:{ CryptoException -> 0x01cc }
            if (r3 == 0) goto L_0x017b
            java.util.List<java.lang.Long> r3 = r14.zzaxt     // Catch:{ CryptoException -> 0x01cc }
            java.lang.Long r6 = java.lang.Long.valueOf(r10)     // Catch:{ CryptoException -> 0x01cc }
            r3.add(r6)     // Catch:{ CryptoException -> 0x01cc }
        L_0x017b:
            com.google.android.gms.internal.ads.zzik r3 = r14.zzaxq     // Catch:{ CryptoException -> 0x01cc }
            java.nio.ByteBuffer r3 = r3.zzcq     // Catch:{ CryptoException -> 0x01cc }
            r3.flip()     // Catch:{ CryptoException -> 0x01cc }
            com.google.android.gms.internal.ads.zzik r3 = r14.zzaxq     // Catch:{ CryptoException -> 0x01cc }
            r14.zza(r3)     // Catch:{ CryptoException -> 0x01cc }
            if (r0 == 0) goto L_0x01ad
            com.google.android.gms.internal.ads.zzik r0 = r14.zzaxq     // Catch:{ CryptoException -> 0x01cc }
            com.google.android.gms.internal.ads.zzig r0 = r0.zzama     // Catch:{ CryptoException -> 0x01cc }
            android.media.MediaCodec$CryptoInfo r9 = r0.zzft()     // Catch:{ CryptoException -> 0x01cc }
            if (r5 != 0) goto L_0x0194
            goto L_0x01a3
        L_0x0194:
            int[] r0 = r9.numBytesOfClearData     // Catch:{ CryptoException -> 0x01cc }
            if (r0 != 0) goto L_0x019c
            int[] r0 = new int[r4]     // Catch:{ CryptoException -> 0x01cc }
            r9.numBytesOfClearData = r0     // Catch:{ CryptoException -> 0x01cc }
        L_0x019c:
            int[] r0 = r9.numBytesOfClearData     // Catch:{ CryptoException -> 0x01cc }
            r3 = r0[r1]     // Catch:{ CryptoException -> 0x01cc }
            int r3 = r3 + r5
            r0[r1] = r3     // Catch:{ CryptoException -> 0x01cc }
        L_0x01a3:
            android.media.MediaCodec r6 = r14.zzaxx     // Catch:{ CryptoException -> 0x01cc }
            int r7 = r14.zzayk     // Catch:{ CryptoException -> 0x01cc }
            r8 = 0
            r12 = 0
            r6.queueSecureInputBuffer(r7, r8, r9, r10, r12)     // Catch:{ CryptoException -> 0x01cc }
            goto L_0x01be
        L_0x01ad:
            android.media.MediaCodec r6 = r14.zzaxx     // Catch:{ CryptoException -> 0x01cc }
            int r7 = r14.zzayk     // Catch:{ CryptoException -> 0x01cc }
            r8 = 0
            com.google.android.gms.internal.ads.zzik r0 = r14.zzaxq     // Catch:{ CryptoException -> 0x01cc }
            java.nio.ByteBuffer r0 = r0.zzcq     // Catch:{ CryptoException -> 0x01cc }
            int r9 = r0.limit()     // Catch:{ CryptoException -> 0x01cc }
            r12 = 0
            r6.queueInputBuffer(r7, r8, r9, r10, r12)     // Catch:{ CryptoException -> 0x01cc }
        L_0x01be:
            r14.zzayk = r2     // Catch:{ CryptoException -> 0x01cc }
            r14.zzayq = r4     // Catch:{ CryptoException -> 0x01cc }
            r14.zzayo = r1     // Catch:{ CryptoException -> 0x01cc }
            com.google.android.gms.internal.ads.zzil r0 = r14.zzayw     // Catch:{ CryptoException -> 0x01cc }
            int r1 = r0.zzamf     // Catch:{ CryptoException -> 0x01cc }
            int r1 = r1 + r4
            r0.zzamf = r1     // Catch:{ CryptoException -> 0x01cc }
            return r4
        L_0x01cc:
            r0 = move-exception
            int r1 = r14.getIndex()
            com.google.android.gms.internal.ads.zzgd r0 = com.google.android.gms.internal.ads.zzgd.zza(r0, r1)
            throw r0
        L_0x01d6:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkl.zzgs():boolean");
    }

    /* access modifiers changed from: protected */
    public void zzd(zzgo zzgo) throws zzgd {
        Object obj;
        zzgo zzgo2 = this.zzafx;
        this.zzafx = zzgo;
        zzin zzin = this.zzafx.zzaff;
        if (zzgo2 == null) {
            obj = null;
        } else {
            obj = zzgo2.zzaff;
        }
        boolean zza = zzof.zza(zzin, obj);
        boolean z = true;
        if (!zza) {
            if (this.zzafx.zzaff != null) {
                zzis<Object> zzis = this.zzaxo;
                if (zzis != null) {
                    this.zzaxw = zzis.zza(Looper.myLooper(), this.zzafx.zzaff);
                    zziq<Object> zziq = this.zzaxw;
                    if (zziq == this.zzaxv) {
                        this.zzaxo.zza(zziq);
                    }
                } else {
                    throw zzgd.zza(new IllegalStateException("Media requires a DrmSessionManager"), getIndex());
                }
            } else {
                this.zzaxw = null;
            }
        }
        if (this.zzaxw == this.zzaxv) {
            MediaCodec mediaCodec = this.zzaxx;
            if (mediaCodec != null && zza(mediaCodec, this.zzaxy.zzayx, zzgo2, this.zzafx)) {
                this.zzayn = true;
                this.zzayo = 1;
                if (!(this.zzayb && this.zzafx.width == zzgo2.width && this.zzafx.height == zzgo2.height)) {
                    z = false;
                }
                this.zzayg = z;
                return;
            }
        }
        if (this.zzayq) {
            this.zzayp = 1;
            return;
        }
        zzgr();
        zzgo();
    }

    public boolean zzeo() {
        return this.zzayt;
    }

    public boolean isReady() {
        return this.zzafx != null && !this.zzayu && (zzdt() || this.zzayl >= 0 || (this.zzayj != -9223372036854775807L && SystemClock.elapsedRealtime() < this.zzayj));
    }

    private final boolean zzd(long j, long j2) throws zzgd {
        boolean z;
        boolean z2;
        if (this.zzayl < 0) {
            if (!this.zzaye || !this.zzayr) {
                this.zzayl = this.zzaxx.dequeueOutputBuffer(this.zzaxu, 0);
            } else {
                try {
                    this.zzayl = this.zzaxx.dequeueOutputBuffer(this.zzaxu, 0);
                } catch (IllegalStateException unused) {
                    zzgt();
                    if (this.zzayt) {
                        zzgr();
                    }
                    return false;
                }
            }
            int i = this.zzayl;
            if (i >= 0) {
                if (this.zzayh) {
                    this.zzayh = false;
                    this.zzaxx.releaseOutputBuffer(i, false);
                    this.zzayl = -1;
                    return true;
                } else if ((this.zzaxu.flags & 4) != 0) {
                    zzgt();
                    this.zzayl = -1;
                    return false;
                } else {
                    ByteBuffer byteBuffer = this.zzajd[this.zzayl];
                    if (byteBuffer != null) {
                        byteBuffer.position(this.zzaxu.offset);
                        byteBuffer.limit(this.zzaxu.offset + this.zzaxu.size);
                    }
                    long j3 = this.zzaxu.presentationTimeUs;
                    int size = this.zzaxt.size();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size) {
                            z2 = false;
                            break;
                        } else if (((Long) this.zzaxt.get(i2)).longValue() == j3) {
                            this.zzaxt.remove(i2);
                            z2 = true;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    this.zzaym = z2;
                }
            } else if (i == -2) {
                MediaFormat outputFormat = this.zzaxx.getOutputFormat();
                if (this.zzayb && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
                    this.zzayh = true;
                } else {
                    if (this.zzayf) {
                        outputFormat.setInteger("channel-count", 1);
                    }
                    onOutputFormatChanged(this.zzaxx, outputFormat);
                }
                return true;
            } else if (i == -3) {
                this.zzajd = this.zzaxx.getOutputBuffers();
                return true;
            } else {
                if (this.zzayc && (this.zzays || this.zzayp == 2)) {
                    zzgt();
                }
                return false;
            }
        }
        if (!this.zzaye || !this.zzayr) {
            MediaCodec mediaCodec = this.zzaxx;
            ByteBuffer[] byteBufferArr = this.zzajd;
            int i3 = this.zzayl;
            z = zza(j, j2, mediaCodec, byteBufferArr[i3], i3, this.zzaxu.flags, this.zzaxu.presentationTimeUs, this.zzaym);
        } else {
            try {
                z = zza(j, j2, this.zzaxx, this.zzajd[this.zzayl], this.zzayl, this.zzaxu.flags, this.zzaxu.presentationTimeUs, this.zzaym);
            } catch (IllegalStateException unused2) {
                zzgt();
                if (this.zzayt) {
                    zzgr();
                }
                return false;
            }
        }
        if (!z) {
            return false;
        }
        long j4 = this.zzaxu.presentationTimeUs;
        this.zzayl = -1;
        return true;
    }

    private final void zzgt() throws zzgd {
        if (this.zzayp == 2) {
            zzgr();
            zzgo();
            return;
        }
        this.zzayt = true;
        zzfo();
    }
}
