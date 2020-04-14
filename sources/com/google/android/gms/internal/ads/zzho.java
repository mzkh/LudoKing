package com.google.android.gms.internal.ads;

import android.media.AudioAttributes.Builder;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.SystemClock;
import android.support.p000v4.media.session.PlaybackStateCompat;
import android.util.Log;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedList;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzho {
    private static boolean zzahn = false;
    private static boolean zzaho = false;
    private int streamType;
    private zzgu zzadh;
    private int zzafn;
    private final zzhf zzahp = null;
    private final zzhz zzahq;
    private final zzie zzahr;
    private final zzhe[] zzahs;
    private final zzhu zzaht;
    /* access modifiers changed from: private */
    public final ConditionVariable zzahu;
    private final long[] zzahv;
    private final zzhq zzahw;
    private final LinkedList<zzhx> zzahx;
    private AudioTrack zzahy;
    private int zzahz;
    private int zzaia;
    private int zzaib;
    private boolean zzaic;
    private int zzaid;
    private long zzaie;
    private zzgu zzaif;
    private long zzaig;
    private long zzaih;
    private ByteBuffer zzaii;
    private int zzaij;
    private int zzaik;
    private int zzail;
    private long zzaim;
    private long zzain;
    private boolean zzaio;
    private long zzaip;
    private Method zzaiq;
    private int zzair;
    private long zzais;
    private long zzait;
    private int zzaiu;
    private long zzaiv;
    private long zzaiw;
    private int zzaix;
    private int zzaiy;
    private long zzaiz;
    private long zzaja;
    private long zzajb;
    private zzhe[] zzajc;
    private ByteBuffer[] zzajd;
    private ByteBuffer zzaje;
    private ByteBuffer zzajf;
    private byte[] zzajg;
    private int zzajh;
    private int zzaji;
    private boolean zzajj;
    private boolean zzajk;
    private int zzajl;
    private boolean zzajm;
    private boolean zzajn;
    private long zzajo;
    private float zzcw;

    public zzho(zzhf zzhf, zzhe[] zzheArr, zzhu zzhu) {
        this.zzaht = zzhu;
        this.zzahu = new ConditionVariable(true);
        if (zzof.SDK_INT >= 18) {
            try {
                this.zzaiq = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException unused) {
            }
        }
        if (zzof.SDK_INT >= 19) {
            this.zzahw = new zzht();
        } else {
            this.zzahw = new zzhq(null);
        }
        this.zzahq = new zzhz();
        this.zzahr = new zzie();
        this.zzahs = new zzhe[(zzheArr.length + 3)];
        this.zzahs[0] = new zzic();
        zzhe[] zzheArr2 = this.zzahs;
        zzheArr2[1] = this.zzahq;
        System.arraycopy(zzheArr, 0, zzheArr2, 2, zzheArr.length);
        this.zzahs[zzheArr.length + 2] = this.zzahr;
        this.zzahv = new long[10];
        this.zzcw = 1.0f;
        this.zzaiy = 0;
        this.streamType = 3;
        this.zzajl = 0;
        this.zzadh = zzgu.zzafz;
        this.zzaji = -1;
        this.zzajc = new zzhe[0];
        this.zzajd = new ByteBuffer[0];
        this.zzahx = new LinkedList<>();
    }

    public final boolean zzav(String str) {
        zzhf zzhf = this.zzahp;
        return zzhf != null && zzhf.zzp(zzaw(str));
    }

    public final long zzi(boolean z) {
        long j;
        long j2;
        long j3;
        long j4;
        if (!(isInitialized() && this.zzaiy != 0)) {
            return Long.MIN_VALUE;
        }
        if (this.zzahy.getPlayState() == 3) {
            long zzfj = this.zzahw.zzfj();
            if (zzfj != 0) {
                long nanoTime = System.nanoTime() / 1000;
                if (nanoTime - this.zzain >= 30000) {
                    long[] jArr = this.zzahv;
                    int i = this.zzaik;
                    jArr[i] = zzfj - nanoTime;
                    this.zzaik = (i + 1) % 10;
                    int i2 = this.zzail;
                    if (i2 < 10) {
                        this.zzail = i2 + 1;
                    }
                    this.zzain = nanoTime;
                    this.zzaim = 0;
                    int i3 = 0;
                    while (true) {
                        int i4 = this.zzail;
                        if (i3 >= i4) {
                            break;
                        }
                        this.zzaim += this.zzahv[i3] / ((long) i4);
                        i3++;
                    }
                }
                if (!zzfh() && nanoTime - this.zzaip >= 500000) {
                    this.zzaio = this.zzahw.zzfk();
                    String str = "AudioTrack";
                    if (this.zzaio) {
                        long zzfl = this.zzahw.zzfl() / 1000;
                        long zzfm = this.zzahw.zzfm();
                        if (zzfl < this.zzaja) {
                            this.zzaio = false;
                        } else {
                            String str2 = ", ";
                            if (Math.abs(zzfl - nanoTime) > 5000000) {
                                StringBuilder sb = new StringBuilder(136);
                                sb.append("Spurious audio timestamp (system clock mismatch): ");
                                sb.append(zzfm);
                                sb.append(str2);
                                sb.append(zzfl);
                                sb.append(str2);
                                sb.append(nanoTime);
                                sb.append(str2);
                                sb.append(zzfj);
                                Log.w(str, sb.toString());
                                this.zzaio = false;
                            } else if (Math.abs(zzdq(zzfm) - zzfj) > 5000000) {
                                StringBuilder sb2 = new StringBuilder(138);
                                sb2.append("Spurious audio timestamp (frame position mismatch): ");
                                sb2.append(zzfm);
                                sb2.append(str2);
                                sb2.append(zzfl);
                                sb2.append(str2);
                                sb2.append(nanoTime);
                                sb2.append(str2);
                                sb2.append(zzfj);
                                Log.w(str, sb2.toString());
                                this.zzaio = false;
                            }
                        }
                    }
                    Method method = this.zzaiq;
                    if (method != null && !this.zzaic) {
                        try {
                            this.zzajb = (((long) ((Integer) method.invoke(this.zzahy, null)).intValue()) * 1000) - this.zzaie;
                            this.zzajb = Math.max(this.zzajb, 0);
                            if (this.zzajb > 5000000) {
                                long j5 = this.zzajb;
                                StringBuilder sb3 = new StringBuilder(61);
                                sb3.append("Ignoring impossibly large audio latency: ");
                                sb3.append(j5);
                                Log.w(str, sb3.toString());
                                this.zzajb = 0;
                            }
                        } catch (Exception unused) {
                            this.zzaiq = null;
                        }
                    }
                    this.zzaip = nanoTime;
                }
            }
        }
        long nanoTime2 = System.nanoTime() / 1000;
        if (this.zzaio) {
            j = zzdq(this.zzahw.zzfm() + zzdr(nanoTime2 - (this.zzahw.zzfl() / 1000)));
        } else {
            if (this.zzail == 0) {
                j = this.zzahw.zzfj();
            } else {
                j = nanoTime2 + this.zzaim;
            }
            if (!z) {
                j -= this.zzajb;
            }
        }
        long j6 = this.zzaiz;
        while (!this.zzahx.isEmpty() && j >= ((zzhx) this.zzahx.getFirst()).zzaev) {
            zzhx zzhx = (zzhx) this.zzahx.remove();
            this.zzadh = zzhx.zzadh;
            this.zzaih = zzhx.zzaev;
            this.zzaig = zzhx.zzake - this.zzaiz;
        }
        if (this.zzadh.zzaga == 1.0f) {
            j2 = (j + this.zzaig) - this.zzaih;
        } else {
            if (!this.zzahx.isEmpty() || this.zzahr.zzfq() < PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) {
                j3 = this.zzaig;
                double d = (double) this.zzadh.zzaga;
                double d2 = (double) (j - this.zzaih);
                Double.isNaN(d);
                Double.isNaN(d2);
                j4 = (long) (d * d2);
            } else {
                j3 = this.zzaig;
                j4 = zzof.zza(j - this.zzaih, this.zzahr.zzfp(), this.zzahr.zzfq());
            }
            j2 = j4 + j3;
        }
        return j6 + j2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0142  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.String r8, int r9, int r10, int r11, int r12, int[] r13) throws com.google.android.gms.internal.ads.zzhs {
        /*
            r7 = this;
            java.lang.String r12 = "audio/raw"
            boolean r12 = r12.equals(r8)
            r0 = 1
            r12 = r12 ^ r0
            if (r12 == 0) goto L_0x000f
            int r8 = zzaw(r8)
            goto L_0x0010
        L_0x000f:
            r8 = r11
        L_0x0010:
            r1 = 0
            if (r12 != 0) goto L_0x004f
            int r11 = com.google.android.gms.internal.ads.zzof.zzf(r11, r9)
            r7.zzair = r11
            com.google.android.gms.internal.ads.zzhz r11 = r7.zzahq
            r11.zzb(r13)
            com.google.android.gms.internal.ads.zzhe[] r11 = r7.zzahs
            int r13 = r11.length
            r3 = r8
            r2 = r9
            r8 = 0
            r9 = 0
        L_0x0025:
            if (r8 >= r13) goto L_0x0046
            r4 = r11[r8]
            boolean r5 = r4.zzb(r10, r2, r3)     // Catch:{ zzhh -> 0x003f }
            r9 = r9 | r5
            boolean r5 = r4.isActive()
            if (r5 == 0) goto L_0x003c
            int r2 = r4.zzet()
            int r3 = r4.zzeu()
        L_0x003c:
            int r8 = r8 + 1
            goto L_0x0025
        L_0x003f:
            r8 = move-exception
            com.google.android.gms.internal.ads.zzhs r9 = new com.google.android.gms.internal.ads.zzhs
            r9.<init>(r8)
            throw r9
        L_0x0046:
            if (r9 == 0) goto L_0x004b
            r7.zzex()
        L_0x004b:
            r11 = r9
            r9 = r2
            r8 = r3
            goto L_0x0050
        L_0x004f:
            r11 = 0
        L_0x0050:
            r13 = 252(0xfc, float:3.53E-43)
            r2 = 12
            switch(r9) {
                case 1: goto L_0x0085;
                case 2: goto L_0x0082;
                case 3: goto L_0x007f;
                case 4: goto L_0x007c;
                case 5: goto L_0x0079;
                case 6: goto L_0x0076;
                case 7: goto L_0x0073;
                case 8: goto L_0x0070;
                default: goto L_0x0057;
            }
        L_0x0057:
            com.google.android.gms.internal.ads.zzhs r8 = new com.google.android.gms.internal.ads.zzhs
            r10 = 38
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>(r10)
            java.lang.String r10 = "Unsupported channel count: "
            r11.append(r10)
            r11.append(r9)
            java.lang.String r9 = r11.toString()
            r8.<init>(r9)
            throw r8
        L_0x0070:
            int r3 = com.google.android.gms.internal.ads.zzga.CHANNEL_OUT_7POINT1_SURROUND
            goto L_0x0086
        L_0x0073:
            r3 = 1276(0x4fc, float:1.788E-42)
            goto L_0x0086
        L_0x0076:
            r3 = 252(0xfc, float:3.53E-43)
            goto L_0x0086
        L_0x0079:
            r3 = 220(0xdc, float:3.08E-43)
            goto L_0x0086
        L_0x007c:
            r3 = 204(0xcc, float:2.86E-43)
            goto L_0x0086
        L_0x007f:
            r3 = 28
            goto L_0x0086
        L_0x0082:
            r3 = 12
            goto L_0x0086
        L_0x0085:
            r3 = 4
        L_0x0086:
            int r4 = com.google.android.gms.internal.ads.zzof.SDK_INT
            r5 = 23
            r6 = 5
            if (r4 > r5) goto L_0x00ad
            java.lang.String r4 = com.google.android.gms.internal.ads.zzof.DEVICE
            java.lang.String r5 = "foster"
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L_0x00ad
            java.lang.String r4 = com.google.android.gms.internal.ads.zzof.MANUFACTURER
            java.lang.String r5 = "NVIDIA"
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L_0x00ad
            r4 = 3
            if (r9 == r4) goto L_0x00ae
            if (r9 == r6) goto L_0x00ae
            r13 = 7
            if (r9 == r13) goto L_0x00aa
            goto L_0x00ad
        L_0x00aa:
            int r13 = com.google.android.gms.internal.ads.zzga.CHANNEL_OUT_7POINT1_SURROUND
            goto L_0x00ae
        L_0x00ad:
            r13 = r3
        L_0x00ae:
            int r3 = com.google.android.gms.internal.ads.zzof.SDK_INT
            r4 = 25
            if (r3 > r4) goto L_0x00c4
            java.lang.String r3 = com.google.android.gms.internal.ads.zzof.DEVICE
            java.lang.String r4 = "fugu"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x00c4
            if (r12 == 0) goto L_0x00c4
            if (r9 != r0) goto L_0x00c4
            r13 = 12
        L_0x00c4:
            if (r11 != 0) goto L_0x00d9
            boolean r11 = r7.isInitialized()
            if (r11 == 0) goto L_0x00d9
            int r11 = r7.zzaia
            if (r11 != r8) goto L_0x00d9
            int r11 = r7.zzafn
            if (r11 != r10) goto L_0x00d9
            int r11 = r7.zzahz
            if (r11 != r13) goto L_0x00d9
            return
        L_0x00d9:
            r7.reset()
            r7.zzaia = r8
            r7.zzaic = r12
            r7.zzafn = r10
            r7.zzahz = r13
            r11 = 2
            if (r12 == 0) goto L_0x00e8
            goto L_0x00e9
        L_0x00e8:
            r8 = 2
        L_0x00e9:
            r7.zzaib = r8
            int r8 = com.google.android.gms.internal.ads.zzof.zzf(r11, r9)
            r7.zzaiu = r8
            if (r12 == 0) goto L_0x0102
            int r8 = r7.zzaib
            if (r8 == r6) goto L_0x00ff
            r9 = 6
            if (r8 != r9) goto L_0x00fb
            goto L_0x00ff
        L_0x00fb:
            r8 = 49152(0xc000, float:6.8877E-41)
            goto L_0x0138
        L_0x00ff:
            r8 = 20480(0x5000, float:2.8699E-41)
            goto L_0x0138
        L_0x0102:
            int r8 = r7.zzaib
            int r8 = android.media.AudioTrack.getMinBufferSize(r10, r13, r8)
            r9 = -2
            if (r8 == r9) goto L_0x010c
            goto L_0x010d
        L_0x010c:
            r0 = 0
        L_0x010d:
            com.google.android.gms.internal.ads.zznr.checkState(r0)
            int r9 = r8 << 2
            r10 = 250000(0x3d090, double:1.235164E-318)
            long r10 = r7.zzdr(r10)
            int r11 = (int) r10
            int r10 = r7.zzaiu
            int r10 = r10 * r11
            long r0 = (long) r8
            r2 = 750000(0xb71b0, double:3.70549E-318)
            long r2 = r7.zzdr(r2)
            int r8 = r7.zzaiu
            long r4 = (long) r8
            long r2 = r2 * r4
            long r0 = java.lang.Math.max(r0, r2)
            int r8 = (int) r0
            if (r9 >= r10) goto L_0x0134
            r8 = r10
            goto L_0x0138
        L_0x0134:
            if (r9 <= r8) goto L_0x0137
            goto L_0x0138
        L_0x0137:
            r8 = r9
        L_0x0138:
            r7.zzaid = r8
            if (r12 == 0) goto L_0x0142
            r8 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            goto L_0x014c
        L_0x0142:
            int r8 = r7.zzaid
            int r9 = r7.zzaiu
            int r8 = r8 / r9
            long r8 = (long) r8
            long r8 = r7.zzdq(r8)
        L_0x014c:
            r7.zzaie = r8
            com.google.android.gms.internal.ads.zzgu r8 = r7.zzadh
            r7.zzb(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzho.zza(java.lang.String, int, int, int, int, int[]):void");
    }

    private final void zzex() {
        zzhe[] zzheArr;
        ArrayList arrayList = new ArrayList();
        for (zzhe zzhe : this.zzahs) {
            if (zzhe.isActive()) {
                arrayList.add(zzhe);
            } else {
                zzhe.flush();
            }
        }
        int size = arrayList.size();
        this.zzajc = (zzhe[]) arrayList.toArray(new zzhe[size]);
        this.zzajd = new ByteBuffer[size];
        for (int i = 0; i < size; i++) {
            zzhe zzhe2 = this.zzajc[i];
            zzhe2.flush();
            this.zzajd[i] = zzhe2.zzew();
        }
    }

    public final void play() {
        this.zzajk = true;
        if (isInitialized()) {
            this.zzaja = System.nanoTime() / 1000;
            this.zzahy.play();
        }
    }

    public final void zzey() {
        if (this.zzaiy == 1) {
            this.zzaiy = 2;
        }
    }

    public final boolean zza(ByteBuffer byteBuffer, long j) throws zzhv, zzhw {
        int i;
        int i2;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j2 = j;
        ByteBuffer byteBuffer3 = this.zzaje;
        zznr.checkArgument(byteBuffer3 == null || byteBuffer2 == byteBuffer3);
        if (!isInitialized()) {
            this.zzahu.block();
            if (this.zzajm) {
                AudioTrack audioTrack = new AudioTrack(new Builder().setUsage(1).setContentType(3).setFlags(16).build(), new AudioFormat.Builder().setChannelMask(this.zzahz).setEncoding(this.zzaib).setSampleRate(this.zzafn).build(), this.zzaid, 1, this.zzajl);
                this.zzahy = audioTrack;
            } else {
                int i3 = this.zzajl;
                if (i3 == 0) {
                    AudioTrack audioTrack2 = new AudioTrack(this.streamType, this.zzafn, this.zzahz, this.zzaib, this.zzaid, 1);
                    this.zzahy = audioTrack2;
                } else {
                    AudioTrack audioTrack3 = new AudioTrack(this.streamType, this.zzafn, this.zzahz, this.zzaib, this.zzaid, 1, i3);
                    this.zzahy = audioTrack3;
                }
            }
            int state = this.zzahy.getState();
            if (state == 1) {
                int audioSessionId = this.zzahy.getAudioSessionId();
                if (this.zzajl != audioSessionId) {
                    this.zzajl = audioSessionId;
                    this.zzaht.zzq(audioSessionId);
                }
                this.zzahw.zza(this.zzahy, zzfh());
                zzfe();
                this.zzajn = false;
                if (this.zzajk) {
                    play();
                }
            } else {
                try {
                    this.zzahy.release();
                } catch (Exception unused) {
                } finally {
                    this.zzahy = null;
                }
                throw new zzhv(state, this.zzafn, this.zzahz, this.zzaid);
            }
        }
        if (zzfh()) {
            if (this.zzahy.getPlayState() == 2) {
                this.zzajn = false;
                return false;
            } else if (this.zzahy.getPlayState() == 1 && this.zzahw.zzfi() != 0) {
                return false;
            }
        }
        boolean z = this.zzajn;
        this.zzajn = zzfb();
        if (z && !this.zzajn && this.zzahy.getPlayState() != 1) {
            this.zzaht.zzc(this.zzaid, zzga.zzdg(this.zzaie), SystemClock.elapsedRealtime() - this.zzajo);
        }
        if (this.zzaje == null) {
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            if (this.zzaic && this.zzaix == 0) {
                int i4 = this.zzaib;
                if (i4 == 7 || i4 == 8) {
                    i2 = zzhy.zzj(byteBuffer);
                } else if (i4 == 5) {
                    i2 = zzhc.zzes();
                } else if (i4 == 6) {
                    i2 = zzhc.zzh(byteBuffer);
                } else {
                    StringBuilder sb = new StringBuilder(38);
                    sb.append("Unexpected audio encoding: ");
                    sb.append(i4);
                    throw new IllegalStateException(sb.toString());
                }
                this.zzaix = i2;
            }
            if (this.zzaif != null) {
                if (!zzfa()) {
                    return false;
                }
                LinkedList<zzhx> linkedList = this.zzahx;
                zzhx zzhx = r11;
                zzhx zzhx2 = new zzhx(this.zzaif, Math.max(0, j2), zzdq(zzff()), null);
                linkedList.add(zzhx);
                this.zzaif = null;
                zzex();
            }
            if (this.zzaiy == 0) {
                this.zzaiz = Math.max(0, j2);
                this.zzaiy = 1;
            } else {
                long zzdq = this.zzaiz + zzdq(this.zzaic ? this.zzait : this.zzais / ((long) this.zzair));
                if (this.zzaiy != 1 || Math.abs(zzdq - j2) <= 200000) {
                    i = 2;
                } else {
                    StringBuilder sb2 = new StringBuilder(80);
                    sb2.append("Discontinuity detected [expected ");
                    sb2.append(zzdq);
                    sb2.append(", got ");
                    sb2.append(j2);
                    sb2.append("]");
                    Log.e("AudioTrack", sb2.toString());
                    i = 2;
                    this.zzaiy = 2;
                }
                if (this.zzaiy == i) {
                    this.zzaiz += j2 - zzdq;
                    this.zzaiy = 1;
                    this.zzaht.zzdx();
                }
            }
            if (this.zzaic) {
                this.zzait += (long) this.zzaix;
            } else {
                this.zzais += (long) byteBuffer.remaining();
            }
            this.zzaje = byteBuffer2;
        }
        if (this.zzaic) {
            zzb(this.zzaje, j2);
        } else {
            zzdp(j2);
        }
        if (this.zzaje.hasRemaining()) {
            return false;
        }
        this.zzaje = null;
        return true;
    }

    private final void zzdp(long j) throws zzhw {
        ByteBuffer byteBuffer;
        int length = this.zzajc.length;
        int i = length;
        while (i >= 0) {
            if (i > 0) {
                byteBuffer = this.zzajd[i - 1];
            } else {
                byteBuffer = this.zzaje;
                if (byteBuffer == null) {
                    byteBuffer = zzhe.zzagy;
                }
            }
            if (i == length) {
                zzb(byteBuffer, j);
            } else {
                zzhe zzhe = this.zzajc[i];
                zzhe.zzi(byteBuffer);
                ByteBuffer zzew = zzhe.zzew();
                this.zzajd[i] = zzew;
                if (zzew.hasRemaining()) {
                    i++;
                }
            }
            if (!byteBuffer.hasRemaining()) {
                i--;
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00d9, code lost:
        if (r11 < r10) goto L_0x0076;
     */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0117  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzb(java.nio.ByteBuffer r9, long r10) throws com.google.android.gms.internal.ads.zzhw {
        /*
            r8 = this;
            boolean r0 = r9.hasRemaining()
            r1 = 1
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            java.nio.ByteBuffer r0 = r8.zzajf
            r2 = 21
            r3 = 0
            if (r0 == 0) goto L_0x0018
            if (r0 != r9) goto L_0x0013
            r0 = 1
            goto L_0x0014
        L_0x0013:
            r0 = 0
        L_0x0014:
            com.google.android.gms.internal.ads.zznr.checkArgument(r0)
            goto L_0x003b
        L_0x0018:
            r8.zzajf = r9
            int r0 = com.google.android.gms.internal.ads.zzof.SDK_INT
            if (r0 >= r2) goto L_0x003b
            int r0 = r9.remaining()
            byte[] r4 = r8.zzajg
            if (r4 == 0) goto L_0x0029
            int r4 = r4.length
            if (r4 >= r0) goto L_0x002d
        L_0x0029:
            byte[] r4 = new byte[r0]
            r8.zzajg = r4
        L_0x002d:
            int r4 = r9.position()
            byte[] r5 = r8.zzajg
            r9.get(r5, r3, r0)
            r9.position(r4)
            r8.zzajh = r3
        L_0x003b:
            int r0 = r9.remaining()
            int r4 = com.google.android.gms.internal.ads.zzof.SDK_INT
            if (r4 >= r2) goto L_0x0079
            long r10 = r8.zzaiv
            com.google.android.gms.internal.ads.zzhq r2 = r8.zzahw
            long r4 = r2.zzfi()
            int r2 = r8.zzaiu
            long r6 = (long) r2
            long r4 = r4 * r6
            long r10 = r10 - r4
            int r11 = (int) r10
            int r10 = r8.zzaid
            int r10 = r10 - r11
            if (r10 <= 0) goto L_0x0076
            int r10 = java.lang.Math.min(r0, r10)
            android.media.AudioTrack r11 = r8.zzahy
            byte[] r2 = r8.zzajg
            int r4 = r8.zzajh
            int r10 = r11.write(r2, r4, r10)
            if (r10 <= 0) goto L_0x00f2
            int r11 = r8.zzajh
            int r11 = r11 + r10
            r8.zzajh = r11
            int r11 = r9.position()
            int r11 = r11 + r10
            r9.position(r11)
            goto L_0x00f2
        L_0x0076:
            r10 = 0
            goto L_0x00f2
        L_0x0079:
            boolean r2 = r8.zzajm
            if (r2 == 0) goto L_0x00ec
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r2 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0088
            r2 = 1
            goto L_0x0089
        L_0x0088:
            r2 = 0
        L_0x0089:
            com.google.android.gms.internal.ads.zznr.checkState(r2)
            android.media.AudioTrack r2 = r8.zzahy
            java.nio.ByteBuffer r4 = r8.zzaii
            if (r4 != 0) goto L_0x00a9
            r4 = 16
            java.nio.ByteBuffer r4 = java.nio.ByteBuffer.allocate(r4)
            r8.zzaii = r4
            java.nio.ByteBuffer r4 = r8.zzaii
            java.nio.ByteOrder r5 = java.nio.ByteOrder.BIG_ENDIAN
            r4.order(r5)
            java.nio.ByteBuffer r4 = r8.zzaii
            r5 = 1431633921(0x55550001, float:1.46372496E13)
            r4.putInt(r5)
        L_0x00a9:
            int r4 = r8.zzaij
            if (r4 != 0) goto L_0x00c5
            java.nio.ByteBuffer r4 = r8.zzaii
            r5 = 4
            r4.putInt(r5, r0)
            java.nio.ByteBuffer r4 = r8.zzaii
            r5 = 8
            r6 = 1000(0x3e8, double:4.94E-321)
            long r10 = r10 * r6
            r4.putLong(r5, r10)
            java.nio.ByteBuffer r10 = r8.zzaii
            r10.position(r3)
            r8.zzaij = r0
        L_0x00c5:
            java.nio.ByteBuffer r10 = r8.zzaii
            int r10 = r10.remaining()
            if (r10 <= 0) goto L_0x00dc
            java.nio.ByteBuffer r11 = r8.zzaii
            int r11 = r2.write(r11, r10, r1)
            if (r11 >= 0) goto L_0x00d9
            r8.zzaij = r3
            r10 = r11
            goto L_0x00f2
        L_0x00d9:
            if (r11 >= r10) goto L_0x00dc
            goto L_0x0076
        L_0x00dc:
            int r9 = r2.write(r9, r0, r1)
            if (r9 >= 0) goto L_0x00e5
            r8.zzaij = r3
            goto L_0x00ea
        L_0x00e5:
            int r10 = r8.zzaij
            int r10 = r10 - r9
            r8.zzaij = r10
        L_0x00ea:
            r10 = r9
            goto L_0x00f2
        L_0x00ec:
            android.media.AudioTrack r10 = r8.zzahy
            int r10 = r10.write(r9, r0, r1)
        L_0x00f2:
            long r4 = android.os.SystemClock.elapsedRealtime()
            r8.zzajo = r4
            if (r10 < 0) goto L_0x0117
            boolean r9 = r8.zzaic
            if (r9 != 0) goto L_0x0104
            long r4 = r8.zzaiv
            long r6 = (long) r10
            long r4 = r4 + r6
            r8.zzaiv = r4
        L_0x0104:
            if (r10 != r0) goto L_0x0116
            boolean r9 = r8.zzaic
            if (r9 == 0) goto L_0x0112
            long r9 = r8.zzaiw
            int r11 = r8.zzaix
            long r2 = (long) r11
            long r9 = r9 + r2
            r8.zzaiw = r9
        L_0x0112:
            r9 = 0
            r8.zzajf = r9
            return r1
        L_0x0116:
            return r3
        L_0x0117:
            com.google.android.gms.internal.ads.zzhw r9 = new com.google.android.gms.internal.ads.zzhw
            r9.<init>(r10)
            throw r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzho.zzb(java.nio.ByteBuffer, long):boolean");
    }

    public final void zzez() throws zzhw {
        if (!this.zzajj && isInitialized() && zzfa()) {
            this.zzahw.zzds(zzff());
            this.zzaij = 0;
            this.zzajj = true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzfa() throws com.google.android.gms.internal.ads.zzhw {
        /*
            r9 = this;
            int r0 = r9.zzaji
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 != r1) goto L_0x0014
            boolean r0 = r9.zzaic
            if (r0 == 0) goto L_0x000f
            com.google.android.gms.internal.ads.zzhe[] r0 = r9.zzajc
            int r0 = r0.length
            goto L_0x0010
        L_0x000f:
            r0 = 0
        L_0x0010:
            r9.zzaji = r0
        L_0x0012:
            r0 = 1
            goto L_0x0015
        L_0x0014:
            r0 = 0
        L_0x0015:
            int r4 = r9.zzaji
            com.google.android.gms.internal.ads.zzhe[] r5 = r9.zzajc
            int r6 = r5.length
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 >= r6) goto L_0x0038
            r4 = r5[r4]
            if (r0 == 0) goto L_0x0028
            r4.zzev()
        L_0x0028:
            r9.zzdp(r7)
            boolean r0 = r4.zzeo()
            if (r0 != 0) goto L_0x0032
            return r3
        L_0x0032:
            int r0 = r9.zzaji
            int r0 = r0 + r2
            r9.zzaji = r0
            goto L_0x0012
        L_0x0038:
            java.nio.ByteBuffer r0 = r9.zzajf
            if (r0 == 0) goto L_0x0044
            r9.zzb(r0, r7)
            java.nio.ByteBuffer r0 = r9.zzajf
            if (r0 == 0) goto L_0x0044
            return r3
        L_0x0044:
            r9.zzaji = r1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzho.zzfa():boolean");
    }

    public final boolean zzeo() {
        return !isInitialized() || (this.zzajj && !zzfb());
    }

    public final boolean zzfb() {
        if (isInitialized()) {
            if (zzff() <= this.zzahw.zzfi()) {
                if (zzfh() && this.zzahy.getPlayState() == 2 && this.zzahy.getPlaybackHeadPosition() == 0) {
                    return true;
                }
            }
            return true;
        }
        return false;
    }

    public final zzgu zzb(zzgu zzgu) {
        if (this.zzaic) {
            this.zzadh = zzgu.zzafz;
            return this.zzadh;
        }
        zzgu zzgu2 = new zzgu(this.zzahr.zza(zzgu.zzaga), this.zzahr.zzb(zzgu.zzagb));
        zzgu zzgu3 = this.zzaif;
        if (zzgu3 == null) {
            if (!this.zzahx.isEmpty()) {
                zzgu3 = ((zzhx) this.zzahx.getLast()).zzadh;
            } else {
                zzgu3 = this.zzadh;
            }
        }
        if (!zzgu2.equals(zzgu3)) {
            if (isInitialized()) {
                this.zzaif = zzgu2;
            } else {
                this.zzadh = zzgu2;
            }
        }
        return this.zzadh;
    }

    public final zzgu zzfc() {
        return this.zzadh;
    }

    public final void setStreamType(int i) {
        if (this.streamType != i) {
            this.streamType = i;
            if (!this.zzajm) {
                reset();
                this.zzajl = 0;
            }
        }
    }

    public final void zzs(int i) {
        zznr.checkState(zzof.SDK_INT >= 21);
        if (!this.zzajm || this.zzajl != i) {
            this.zzajm = true;
            this.zzajl = i;
            reset();
        }
    }

    public final void zzfd() {
        if (this.zzajm) {
            this.zzajm = false;
            this.zzajl = 0;
            reset();
        }
    }

    public final void setVolume(float f) {
        if (this.zzcw != f) {
            this.zzcw = f;
            zzfe();
        }
    }

    private final void zzfe() {
        if (isInitialized()) {
            if (zzof.SDK_INT >= 21) {
                this.zzahy.setVolume(this.zzcw);
                return;
            }
            AudioTrack audioTrack = this.zzahy;
            float f = this.zzcw;
            audioTrack.setStereoVolume(f, f);
        }
    }

    public final void pause() {
        this.zzajk = false;
        if (isInitialized()) {
            zzfg();
            this.zzahw.pause();
        }
    }

    public final void reset() {
        if (isInitialized()) {
            this.zzais = 0;
            this.zzait = 0;
            this.zzaiv = 0;
            this.zzaiw = 0;
            this.zzaix = 0;
            zzgu zzgu = this.zzaif;
            if (zzgu != null) {
                this.zzadh = zzgu;
                this.zzaif = null;
            } else if (!this.zzahx.isEmpty()) {
                this.zzadh = ((zzhx) this.zzahx.getLast()).zzadh;
            }
            this.zzahx.clear();
            this.zzaig = 0;
            this.zzaih = 0;
            this.zzaje = null;
            this.zzajf = null;
            int i = 0;
            while (true) {
                zzhe[] zzheArr = this.zzajc;
                if (i >= zzheArr.length) {
                    break;
                }
                zzhe zzhe = zzheArr[i];
                zzhe.flush();
                this.zzajd[i] = zzhe.zzew();
                i++;
            }
            this.zzajj = false;
            this.zzaji = -1;
            this.zzaii = null;
            this.zzaij = 0;
            this.zzaiy = 0;
            this.zzajb = 0;
            zzfg();
            if (this.zzahy.getPlayState() == 3) {
                this.zzahy.pause();
            }
            AudioTrack audioTrack = this.zzahy;
            this.zzahy = null;
            this.zzahw.zza(null, false);
            this.zzahu.close();
            new zzhr(this, audioTrack).start();
        }
    }

    public final void release() {
        reset();
        for (zzhe reset : this.zzahs) {
            reset.reset();
        }
        this.zzajl = 0;
        this.zzajk = false;
    }

    private final boolean isInitialized() {
        return this.zzahy != null;
    }

    private final long zzdq(long j) {
        return (j * 1000000) / ((long) this.zzafn);
    }

    private final long zzdr(long j) {
        return (j * ((long) this.zzafn)) / 1000000;
    }

    private final long zzff() {
        return this.zzaic ? this.zzaiw : this.zzaiv / ((long) this.zzaiu);
    }

    private final void zzfg() {
        this.zzaim = 0;
        this.zzail = 0;
        this.zzaik = 0;
        this.zzain = 0;
        this.zzaio = false;
        this.zzaip = 0;
    }

    private final boolean zzfh() {
        if (zzof.SDK_INT < 23) {
            int i = this.zzaib;
            if (i == 5 || i == 6) {
                return true;
            }
        }
        return false;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int zzaw(java.lang.String r5) {
        /*
            int r0 = r5.hashCode()
            r1 = 0
            r2 = 3
            r3 = 2
            r4 = 1
            switch(r0) {
                case -1095064472: goto L_0x002a;
                case 187078296: goto L_0x0020;
                case 1504578661: goto L_0x0016;
                case 1505942594: goto L_0x000c;
                default: goto L_0x000b;
            }
        L_0x000b:
            goto L_0x0034
        L_0x000c:
            java.lang.String r0 = "audio/vnd.dts.hd"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0034
            r5 = 3
            goto L_0x0035
        L_0x0016:
            java.lang.String r0 = "audio/eac3"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0034
            r5 = 1
            goto L_0x0035
        L_0x0020:
            java.lang.String r0 = "audio/ac3"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0034
            r5 = 0
            goto L_0x0035
        L_0x002a:
            java.lang.String r0 = "audio/vnd.dts"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0034
            r5 = 2
            goto L_0x0035
        L_0x0034:
            r5 = -1
        L_0x0035:
            if (r5 == 0) goto L_0x0045
            if (r5 == r4) goto L_0x0043
            if (r5 == r3) goto L_0x0041
            if (r5 == r2) goto L_0x003e
            return r1
        L_0x003e:
            r5 = 8
            return r5
        L_0x0041:
            r5 = 7
            return r5
        L_0x0043:
            r5 = 6
            return r5
        L_0x0045:
            r5 = 5
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzho.zzaw(java.lang.String):int");
    }
}
