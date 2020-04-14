package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import com.tapjoy.TapjoyConstants;
import java.nio.ByteBuffer;

@TargetApi(16)
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzoq extends zzkl {
    private static final int[] zzbhj = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    private int zzagf;
    private boolean zzajm;
    private final zzou zzbhk;
    private final zzov zzbhl;
    private final long zzbhm;
    private final int zzbhn;
    private final boolean zzbho;
    private final long[] zzbhp;
    private zzgo[] zzbhq;
    private zzos zzbhr;
    private Surface zzbhs;
    private Surface zzbht;
    private int zzbhu;
    private boolean zzbhv;
    private long zzbhw;
    private long zzbhx;
    private int zzbhy;
    private int zzbhz;
    private int zzbia;
    private float zzbib;
    private int zzbic;
    private int zzbid;
    private int zzbie;
    private float zzbif;
    private int zzbig;
    private int zzbih;
    private int zzbii;
    private float zzbij;
    zzor zzbik;
    private long zzbil;
    private int zzbim;
    private final Context zzlk;

    public zzoq(Context context, zzkn zzkn, long j, Handler handler, zzow zzow, int i) {
        this(context, zzkn, 0, null, false, handler, zzow, -1);
    }

    private static boolean zzeg(long j) {
        return j < -30000;
    }

    private zzoq(Context context, zzkn zzkn, long j, zzis<Object> zzis, boolean z, Handler handler, zzow zzow, int i) {
        boolean z2 = false;
        super(2, zzkn, null, false);
        this.zzbhm = 0;
        this.zzbhn = -1;
        this.zzlk = context.getApplicationContext();
        this.zzbhk = new zzou(context);
        this.zzbhl = new zzov(handler, zzow);
        if (zzof.SDK_INT <= 22) {
            if ("foster".equals(zzof.DEVICE)) {
                if ("NVIDIA".equals(zzof.MANUFACTURER)) {
                    z2 = true;
                }
            }
        }
        this.zzbho = z2;
        this.zzbhp = new long[10];
        this.zzbil = -9223372036854775807L;
        this.zzbhw = -9223372036854775807L;
        this.zzbic = -1;
        this.zzbid = -1;
        this.zzbif = -1.0f;
        this.zzbib = -1.0f;
        this.zzbhu = 1;
        zziw();
    }

    /* access modifiers changed from: protected */
    public final int zza(zzkn zzkn, zzgo zzgo) throws zzkt {
        boolean z;
        String str = zzgo.zzafc;
        int i = 0;
        if (!zzny.zzbd(str)) {
            return 0;
        }
        zzin zzin = zzgo.zzaff;
        if (zzin != null) {
            z = false;
            for (int i2 = 0; i2 < zzin.zzaml; i2++) {
                z |= zzin.zzz(i2).zzamm;
            }
        } else {
            z = false;
        }
        zzkm zzc = zzkn.zzc(str, z);
        if (zzc == null) {
            return 1;
        }
        boolean zzaz = zzc.zzaz(zzgo.zzaez);
        if (zzaz && zzgo.width > 0 && zzgo.height > 0) {
            if (zzof.SDK_INT >= 21) {
                zzaz = zzc.zza(zzgo.width, zzgo.height, (double) zzgo.zzafg);
            } else {
                zzaz = zzgo.width * zzgo.height <= zzkp.zzgw();
                if (!zzaz) {
                    int i3 = zzgo.width;
                    int i4 = zzgo.height;
                    String str2 = zzof.zzbgt;
                    StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 56);
                    sb.append("FalseCheck [legacyFrameSize, ");
                    sb.append(i3);
                    sb.append("x");
                    sb.append(i4);
                    sb.append("] [");
                    sb.append(str2);
                    sb.append("]");
                    Log.d("MediaCodecVideoRenderer", sb.toString());
                }
            }
        }
        int i5 = zzc.zzayx ? 8 : 4;
        if (zzc.zzajm) {
            i = 16;
        }
        return (zzaz ? 3 : 2) | i5 | i;
    }

    /* access modifiers changed from: protected */
    public final void zzd(boolean z) throws zzgd {
        super.zzd(z);
        this.zzagf = zzds().zzagf;
        this.zzajm = this.zzagf != 0;
        this.zzbhl.zzc(this.zzayw);
        this.zzbhk.enable();
    }

    /* access modifiers changed from: protected */
    public final void zza(zzgo[] zzgoArr, long j) throws zzgd {
        this.zzbhq = zzgoArr;
        if (this.zzbil == -9223372036854775807L) {
            this.zzbil = j;
        } else {
            int i = this.zzbim;
            long[] jArr = this.zzbhp;
            if (i == jArr.length) {
                long j2 = jArr[i - 1];
                StringBuilder sb = new StringBuilder(65);
                sb.append("Too many stream changes, so dropping offset: ");
                sb.append(j2);
                Log.w("MediaCodecVideoRenderer", sb.toString());
            } else {
                this.zzbim = i + 1;
            }
            this.zzbhp[this.zzbim - 1] = j;
        }
        super.zza(zzgoArr, j);
    }

    /* access modifiers changed from: protected */
    public final void zza(long j, boolean z) throws zzgd {
        super.zza(j, z);
        zziu();
        this.zzbhz = 0;
        int i = this.zzbim;
        if (i != 0) {
            this.zzbil = this.zzbhp[i - 1];
            this.zzbim = 0;
        }
        if (z) {
            zzit();
        } else {
            this.zzbhw = -9223372036854775807L;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0016, code lost:
        if (r9.zzbhs == r0) goto L_0x001e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001c, code lost:
        if (zzgp() == null) goto L_0x001e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isReady() {
        /*
            r9 = this;
            boolean r0 = super.isReady()
            r1 = 1
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r0 == 0) goto L_0x0021
            boolean r0 = r9.zzbhv
            if (r0 != 0) goto L_0x001e
            android.view.Surface r0 = r9.zzbht
            if (r0 == 0) goto L_0x0018
            android.view.Surface r4 = r9.zzbhs
            if (r4 == r0) goto L_0x001e
        L_0x0018:
            android.media.MediaCodec r0 = r9.zzgp()
            if (r0 != 0) goto L_0x0021
        L_0x001e:
            r9.zzbhw = r2
            return r1
        L_0x0021:
            long r4 = r9.zzbhw
            r0 = 0
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 != 0) goto L_0x0029
            return r0
        L_0x0029:
            long r4 = android.os.SystemClock.elapsedRealtime()
            long r6 = r9.zzbhw
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 >= 0) goto L_0x0034
            return r1
        L_0x0034:
            r9.zzbhw = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzoq.isReady():boolean");
    }

    /* access modifiers changed from: protected */
    public final void onStarted() {
        super.onStarted();
        this.zzbhy = 0;
        this.zzbhx = SystemClock.elapsedRealtime();
        this.zzbhw = -9223372036854775807L;
    }

    /* access modifiers changed from: protected */
    public final void onStopped() {
        zziz();
        super.onStopped();
    }

    /* access modifiers changed from: protected */
    public final void zzdr() {
        this.zzbic = -1;
        this.zzbid = -1;
        this.zzbif = -1.0f;
        this.zzbib = -1.0f;
        this.zzbil = -9223372036854775807L;
        this.zzbim = 0;
        zziw();
        zziu();
        this.zzbhk.disable();
        this.zzbik = null;
        this.zzajm = false;
        try {
            super.zzdr();
        } finally {
            this.zzayw.zzfy();
            this.zzbhl.zzd(this.zzayw);
        }
    }

    public final void zza(int i, Object obj) throws zzgd {
        if (i == 1) {
            Surface surface = (Surface) obj;
            if (surface == null) {
                Surface surface2 = this.zzbht;
                if (surface2 != null) {
                    surface = surface2;
                } else {
                    zzkm zzgq = zzgq();
                    if (zzgq != null && zzm(zzgq.zzayy)) {
                        this.zzbht = zzom.zzc(this.zzlk, zzgq.zzayy);
                        surface = this.zzbht;
                    }
                }
            }
            if (this.zzbhs != surface) {
                this.zzbhs = surface;
                int state = getState();
                if (state == 1 || state == 2) {
                    MediaCodec zzgp = zzgp();
                    if (zzof.SDK_INT < 23 || zzgp == null || surface == null) {
                        zzgr();
                        zzgo();
                    } else {
                        zzgp.setOutputSurface(surface);
                    }
                }
                if (surface == null || surface == this.zzbht) {
                    zziw();
                    zziu();
                } else {
                    zziy();
                    zziu();
                    if (state == 2) {
                        zzit();
                        return;
                    }
                }
                return;
            }
            if (!(surface == null || surface == this.zzbht)) {
                zziy();
                if (this.zzbhv) {
                    this.zzbhl.zza(this.zzbhs);
                }
            }
        } else if (i == 4) {
            this.zzbhu = ((Integer) obj).intValue();
            MediaCodec zzgp2 = zzgp();
            if (zzgp2 != null) {
                zzgp2.setVideoScalingMode(this.zzbhu);
            }
        } else {
            super.zza(i, obj);
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zza(zzkm zzkm) {
        return this.zzbhs != null || zzm(zzkm.zzayy);
    }

    /* access modifiers changed from: protected */
    public final void zza(zzkm zzkm, MediaCodec mediaCodec, zzgo zzgo, MediaCrypto mediaCrypto) throws zzkt {
        zzos zzos;
        int i;
        Point point;
        float f;
        zzkm zzkm2 = zzkm;
        MediaCodec mediaCodec2 = mediaCodec;
        zzgo zzgo2 = zzgo;
        zzgo[] zzgoArr = this.zzbhq;
        int i2 = zzgo2.width;
        int i3 = zzgo2.height;
        int zzi = zzi(zzgo);
        if (zzgoArr.length == 1) {
            zzos = new zzos(i2, i3, zzi);
        } else {
            int i4 = i3;
            int i5 = zzi;
            boolean z = false;
            int i6 = i2;
            for (zzgo zzgo3 : zzgoArr) {
                if (zza(zzkm2.zzayx, zzgo2, zzgo3)) {
                    z |= zzgo3.width == -1 || zzgo3.height == -1;
                    i6 = Math.max(i6, zzgo3.width);
                    int max = Math.max(i4, zzgo3.height);
                    i5 = Math.max(i5, zzi(zzgo3));
                    i4 = max;
                }
            }
            if (z) {
                StringBuilder sb = new StringBuilder(66);
                sb.append("Resolutions unknown. Codec max resolution: ");
                sb.append(i6);
                String str = "x";
                sb.append(str);
                sb.append(i4);
                String str2 = "MediaCodecVideoRenderer";
                Log.w(str2, sb.toString());
                boolean z2 = zzgo2.height > zzgo2.width;
                int i7 = z2 ? zzgo2.height : zzgo2.width;
                int i8 = z2 ? zzgo2.width : zzgo2.height;
                float f2 = ((float) i8) / ((float) i7);
                int[] iArr = zzbhj;
                int length = iArr.length;
                int i9 = 0;
                while (true) {
                    if (i9 >= length) {
                        break;
                    }
                    int i10 = length;
                    int i11 = iArr[i9];
                    int[] iArr2 = iArr;
                    int i12 = (int) (((float) i11) * f2);
                    if (i11 <= i7 || i12 <= i8) {
                        break;
                    }
                    int i13 = i7;
                    int i14 = i8;
                    if (zzof.SDK_INT >= 21) {
                        int i15 = z2 ? i12 : i11;
                        if (z2) {
                            i12 = i11;
                        }
                        Point zzc = zzkm2.zzc(i15, i12);
                        i = i5;
                        f = f2;
                        if (zzkm2.zza(zzc.x, zzc.y, (double) zzgo2.zzafg)) {
                            point = zzc;
                            break;
                        }
                    } else {
                        i = i5;
                        f = f2;
                        int zze = zzof.zze(i11, 16) << 4;
                        int zze2 = zzof.zze(i12, 16) << 4;
                        if (zze * zze2 <= zzkp.zzgw()) {
                            int i16 = z2 ? zze2 : zze;
                            if (z2) {
                                zze2 = zze;
                            }
                            point = new Point(i16, zze2);
                        }
                    }
                    i9++;
                    length = i10;
                    iArr = iArr2;
                    i7 = i13;
                    i8 = i14;
                    i5 = i;
                    f2 = f;
                }
                i = i5;
                point = null;
                if (point != null) {
                    i6 = Math.max(i6, point.x);
                    i4 = Math.max(i4, point.y);
                    i5 = Math.max(i, zza(zzgo2.zzafc, i6, i4));
                    StringBuilder sb2 = new StringBuilder(57);
                    sb2.append("Codec max resolution adjusted to: ");
                    sb2.append(i6);
                    sb2.append(str);
                    sb2.append(i4);
                    Log.w(str2, sb2.toString());
                } else {
                    i5 = i;
                }
            }
            zzos = new zzos(i6, i4, i5);
        }
        this.zzbhr = zzos;
        zzos zzos2 = this.zzbhr;
        boolean z3 = this.zzbho;
        int i17 = this.zzagf;
        MediaFormat zzek = zzgo.zzek();
        zzek.setInteger("max-width", zzos2.width);
        zzek.setInteger("max-height", zzos2.height);
        if (zzos2.zzbio != -1) {
            zzek.setInteger("max-input-size", zzos2.zzbio);
        }
        if (z3) {
            zzek.setInteger("auto-frc", 0);
        }
        if (i17 != 0) {
            zzek.setFeatureEnabled("tunneled-playback", true);
            zzek.setInteger("audio-session-id", i17);
        }
        if (this.zzbhs == null) {
            zznr.checkState(zzm(zzkm2.zzayy));
            if (this.zzbht == null) {
                this.zzbht = zzom.zzc(this.zzlk, zzkm2.zzayy);
            }
            this.zzbhs = this.zzbht;
        }
        mediaCodec2.configure(zzek, this.zzbhs, null, 0);
        if (zzof.SDK_INT >= 23 && this.zzajm) {
            this.zzbik = new zzor(this, mediaCodec2);
        }
    }

    /* access modifiers changed from: protected */
    public final void zzgr() {
        try {
            super.zzgr();
        } finally {
            Surface surface = this.zzbht;
            if (surface != null) {
                if (this.zzbhs == surface) {
                    this.zzbhs = null;
                }
                this.zzbht.release();
                this.zzbht = null;
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void zzc(String str, long j, long j2) {
        this.zzbhl.zzb(str, j, j2);
    }

    /* access modifiers changed from: protected */
    public final void zzd(zzgo zzgo) throws zzgd {
        super.zzd(zzgo);
        this.zzbhl.zzc(zzgo);
        this.zzbib = zzgo.zzafi == -1.0f ? 1.0f : zzgo.zzafi;
        this.zzbia = zzj(zzgo);
    }

    /* access modifiers changed from: protected */
    public final void zza(zzik zzik) {
        if (zzof.SDK_INT < 23 && this.zzajm) {
            zziv();
        }
    }

    /* access modifiers changed from: protected */
    public final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int i;
        int i2;
        String str = "crop-right";
        String str2 = "crop-top";
        String str3 = "crop-bottom";
        String str4 = "crop-left";
        boolean z = mediaFormat.containsKey(str) && mediaFormat.containsKey(str4) && mediaFormat.containsKey(str3) && mediaFormat.containsKey(str2);
        if (z) {
            i = (mediaFormat.getInteger(str) - mediaFormat.getInteger(str4)) + 1;
        } else {
            i = mediaFormat.getInteger("width");
        }
        this.zzbic = i;
        if (z) {
            i2 = (mediaFormat.getInteger(str3) - mediaFormat.getInteger(str2)) + 1;
        } else {
            i2 = mediaFormat.getInteger("height");
        }
        this.zzbid = i2;
        this.zzbif = this.zzbib;
        if (zzof.SDK_INT >= 21) {
            int i3 = this.zzbia;
            if (i3 == 90 || i3 == 270) {
                int i4 = this.zzbic;
                this.zzbic = this.zzbid;
                this.zzbid = i4;
                this.zzbif = 1.0f / this.zzbif;
            }
        } else {
            this.zzbie = this.zzbia;
        }
        mediaCodec.setVideoScalingMode(this.zzbhu);
    }

    /* access modifiers changed from: protected */
    public final boolean zza(MediaCodec mediaCodec, boolean z, zzgo zzgo, zzgo zzgo2) {
        return zza(z, zzgo, zzgo2) && zzgo2.width <= this.zzbhr.width && zzgo2.height <= this.zzbhr.height && zzgo2.zzafd <= this.zzbhr.zzbio;
    }

    /* access modifiers changed from: protected */
    public final boolean zza(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) {
        MediaCodec mediaCodec2 = mediaCodec;
        int i3 = i;
        long j4 = j3;
        while (true) {
            int i4 = this.zzbim;
            if (i4 == 0) {
                break;
            }
            long[] jArr = this.zzbhp;
            if (j4 < jArr[0]) {
                break;
            }
            this.zzbil = jArr[0];
            this.zzbim = i4 - 1;
            System.arraycopy(jArr, 1, jArr, 0, this.zzbim);
        }
        long j5 = j4 - this.zzbil;
        if (z) {
            zza(mediaCodec2, i3, j5);
            return true;
        }
        long j6 = j4 - j;
        if (this.zzbhs == this.zzbht) {
            if (!zzeg(j6)) {
                return false;
            }
            zza(mediaCodec2, i3, j5);
            return true;
        } else if (!this.zzbhv) {
            if (zzof.SDK_INT >= 21) {
                zza(mediaCodec, i, j5, System.nanoTime());
            } else {
                zzb(mediaCodec2, i3, j5);
            }
            return true;
        } else if (getState() != 2) {
            return false;
        } else {
            long elapsedRealtime = j6 - ((SystemClock.elapsedRealtime() * 1000) - j2);
            long nanoTime = System.nanoTime();
            long zzf = this.zzbhk.zzf(j4, (elapsedRealtime * 1000) + nanoTime);
            long j7 = (zzf - nanoTime) / 1000;
            if (zzeg(j7)) {
                zzog.beginSection("dropVideoBuffer");
                mediaCodec2.releaseOutputBuffer(i3, false);
                zzog.endSection();
                this.zzayw.zzami++;
                this.zzbhy++;
                this.zzbhz++;
                this.zzayw.zzamj = Math.max(this.zzbhz, this.zzayw.zzamj);
                if (this.zzbhy == this.zzbhn) {
                    zziz();
                }
                return true;
            }
            if (zzof.SDK_INT >= 21) {
                if (j7 < 50000) {
                    zza(mediaCodec, i, j5, zzf);
                    return true;
                }
            } else if (j7 < 30000) {
                if (j7 > 11000) {
                    try {
                        Thread.sleep((j7 - TapjoyConstants.TIMER_INCREMENT) / 1000);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
                zzb(mediaCodec2, i3, j5);
                return true;
            }
            return false;
        }
    }

    private final void zza(MediaCodec mediaCodec, int i, long j) {
        zzog.beginSection("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        zzog.endSection();
        this.zzayw.zzamh++;
    }

    private final void zzb(MediaCodec mediaCodec, int i, long j) {
        zzix();
        zzog.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, true);
        zzog.endSection();
        this.zzayw.zzamg++;
        this.zzbhz = 0;
        zziv();
    }

    @TargetApi(21)
    private final void zza(MediaCodec mediaCodec, int i, long j, long j2) {
        zzix();
        zzog.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, j2);
        zzog.endSection();
        this.zzayw.zzamg++;
        this.zzbhz = 0;
        zziv();
    }

    private final boolean zzm(boolean z) {
        return zzof.SDK_INT >= 23 && !this.zzajm && (!z || zzom.zzc(this.zzlk));
    }

    private final void zzit() {
        this.zzbhw = this.zzbhm > 0 ? SystemClock.elapsedRealtime() + this.zzbhm : -9223372036854775807L;
    }

    private final void zziu() {
        this.zzbhv = false;
        if (zzof.SDK_INT >= 23 && this.zzajm) {
            MediaCodec zzgp = zzgp();
            if (zzgp != null) {
                this.zzbik = new zzor(this, zzgp);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public final void zziv() {
        if (!this.zzbhv) {
            this.zzbhv = true;
            this.zzbhl.zza(this.zzbhs);
        }
    }

    private final void zziw() {
        this.zzbig = -1;
        this.zzbih = -1;
        this.zzbij = -1.0f;
        this.zzbii = -1;
    }

    private final void zzix() {
        if (this.zzbig != this.zzbic || this.zzbih != this.zzbid || this.zzbii != this.zzbie || this.zzbij != this.zzbif) {
            this.zzbhl.zza(this.zzbic, this.zzbid, this.zzbie, this.zzbif);
            this.zzbig = this.zzbic;
            this.zzbih = this.zzbid;
            this.zzbii = this.zzbie;
            this.zzbij = this.zzbif;
        }
    }

    private final void zziy() {
        if (this.zzbig != -1 || this.zzbih != -1) {
            this.zzbhl.zza(this.zzbic, this.zzbid, this.zzbie, this.zzbif);
        }
    }

    private final void zziz() {
        if (this.zzbhy > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.zzbhl.zze(this.zzbhy, elapsedRealtime - this.zzbhx);
            this.zzbhy = 0;
            this.zzbhx = elapsedRealtime;
        }
    }

    private static int zzi(zzgo zzgo) {
        if (zzgo.zzafd != -1) {
            return zzgo.zzafd;
        }
        return zza(zzgo.zzafc, zzgo.width, zzgo.height);
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int zza(java.lang.String r7, int r8, int r9) {
        /*
            r0 = -1
            if (r8 == r0) goto L_0x0086
            if (r9 != r0) goto L_0x0007
            goto L_0x0086
        L_0x0007:
            int r1 = r7.hashCode()
            r2 = 5
            r3 = 1
            r4 = 3
            r5 = 4
            r6 = 2
            switch(r1) {
                case -1664118616: goto L_0x0046;
                case -1662541442: goto L_0x003c;
                case 1187890754: goto L_0x0032;
                case 1331836730: goto L_0x0028;
                case 1599127256: goto L_0x001e;
                case 1599127257: goto L_0x0014;
                default: goto L_0x0013;
            }
        L_0x0013:
            goto L_0x0050
        L_0x0014:
            java.lang.String r1 = "video/x-vnd.on2.vp9"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L_0x0050
            r7 = 5
            goto L_0x0051
        L_0x001e:
            java.lang.String r1 = "video/x-vnd.on2.vp8"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L_0x0050
            r7 = 3
            goto L_0x0051
        L_0x0028:
            java.lang.String r1 = "video/avc"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L_0x0050
            r7 = 2
            goto L_0x0051
        L_0x0032:
            java.lang.String r1 = "video/mp4v-es"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L_0x0050
            r7 = 1
            goto L_0x0051
        L_0x003c:
            java.lang.String r1 = "video/hevc"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L_0x0050
            r7 = 4
            goto L_0x0051
        L_0x0046:
            java.lang.String r1 = "video/3gpp"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L_0x0050
            r7 = 0
            goto L_0x0051
        L_0x0050:
            r7 = -1
        L_0x0051:
            if (r7 == 0) goto L_0x007d
            if (r7 == r3) goto L_0x007d
            if (r7 == r6) goto L_0x0061
            if (r7 == r4) goto L_0x007d
            if (r7 == r5) goto L_0x005e
            if (r7 == r2) goto L_0x005e
            return r0
        L_0x005e:
            int r8 = r8 * r9
            goto L_0x0080
        L_0x0061:
            java.lang.String r7 = com.google.android.gms.internal.ads.zzof.MODEL
            java.lang.String r1 = "BRAVIA 4K 2015"
            boolean r7 = r1.equals(r7)
            if (r7 == 0) goto L_0x006c
            return r0
        L_0x006c:
            r7 = 16
            int r8 = com.google.android.gms.internal.ads.zzof.zze(r8, r7)
            int r7 = com.google.android.gms.internal.ads.zzof.zze(r9, r7)
            int r8 = r8 * r7
            int r7 = r8 << 4
            int r8 = r7 << 4
            goto L_0x007f
        L_0x007d:
            int r8 = r8 * r9
        L_0x007f:
            r5 = 2
        L_0x0080:
            int r8 = r8 * 3
            int r5 = r5 * 2
            int r8 = r8 / r5
            return r8
        L_0x0086:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzoq.zza(java.lang.String, int, int):int");
    }

    private static boolean zza(boolean z, zzgo zzgo, zzgo zzgo2) {
        return zzgo.zzafc.equals(zzgo2.zzafc) && zzj(zzgo) == zzj(zzgo2) && (z || (zzgo.width == zzgo2.width && zzgo.height == zzgo2.height));
    }

    private static int zzj(zzgo zzgo) {
        if (zzgo.zzafh == -1) {
            return 0;
        }
        return zzgo.zzafh;
    }
}
