package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import com.google.android.gms.internal.ads.zzin.zza;
import com.google.firebase.FirebaseError;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzjm implements zziw {
    private static final zzix zzank = new zzjl();
    private static final byte[] zzanl = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    private static final byte[] zzanm = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
    /* access modifiers changed from: private */
    public static final UUID zzann = new UUID(72057594037932032L, -9223371306706625679L);
    private long zzagh;
    private final zzjp zzanc;
    private final zzjk zzano;
    private final SparseArray<zzjn> zzanp;
    private final boolean zzanq;
    private final zzoc zzanr;
    private final zzoc zzans;
    private final zzoc zzant;
    private final zzoc zzanu;
    private final zzoc zzanv;
    private final zzoc zzanw;
    private final zzoc zzanx;
    private final zzoc zzany;
    private final zzoc zzanz;
    private ByteBuffer zzaoa;
    private long zzaob;
    private long zzaoc;
    private long zzaod;
    private long zzaoe;
    private zzjn zzaof;
    private boolean zzaog;
    private int zzaoh;
    private long zzaoi;
    private boolean zzaoj;
    private long zzaok;
    private long zzaol;
    private long zzaom;
    private zznw zzaon;
    private zznw zzaoo;
    private boolean zzaop;
    private int zzaoq;
    private long zzaor;
    private long zzaos;
    private int zzaot;
    private int zzaou;
    private int[] zzaov;
    private int zzaow;
    private int zzaox;
    private int zzaoy;
    private int zzaoz;
    private boolean zzapa;
    private boolean zzapb;
    private boolean zzapc;
    private boolean zzapd;
    private byte zzape;
    private int zzapf;
    private int zzapg;
    private int zzaph;
    private boolean zzapi;
    private boolean zzapj;
    private zziy zzapk;

    public zzjm() {
        this(0);
    }

    static int zzag(int i) {
        switch (i) {
            case 131:
            case 136:
            case 155:
            case 159:
            case 176:
            case 179:
            case 186:
            case 215:
            case 231:
            case 241:
            case 251:
            case 16980:
            case 17029:
            case 17143:
            case 18401:
            case 18408:
            case 20529:
            case 20530:
            case 21420:
            case 21432:
            case 21680:
            case 21682:
            case 21690:
            case 21930:
            case 21945:
            case 21946:
            case 21947:
            case 21948:
            case 21949:
            case 22186:
            case 22203:
            case 25188:
            case 2352003:
            case 2807729:
                return 2;
            case 134:
            case FirebaseError.ERROR_WEAK_PASSWORD /*17026*/:
            case 2274716:
                return 3;
            case 160:
            case 174:
            case 183:
            case 187:
            case 224:
            case 225:
            case 18407:
            case 19899:
            case 20532:
            case 20533:
            case 21936:
            case 21968:
            case 25152:
            case 28032:
            case 30320:
            case 290298740:
            case 357149030:
            case 374648427:
            case 408125543:
            case 440786851:
            case 475249515:
            case 524531317:
                return 1;
            case 161:
            case 163:
            case 16981:
            case 18402:
            case 21419:
            case 25506:
            case 30322:
                return 4;
            case 181:
            case 17545:
            case 21969:
            case 21970:
            case 21971:
            case 21972:
            case 21973:
            case 21974:
            case 21975:
            case 21976:
            case 21977:
            case 21978:
                return 5;
            default:
                return 0;
        }
    }

    static boolean zzah(int i) {
        return i == 357149030 || i == 524531317 || i == 475249515 || i == 374648427;
    }

    public final void release() {
    }

    private zzjm(int i) {
        this(new zzjf(), 0);
    }

    private zzjm(zzjk zzjk, int i) {
        this.zzaoc = -1;
        this.zzaod = -9223372036854775807L;
        this.zzaoe = -9223372036854775807L;
        this.zzagh = -9223372036854775807L;
        this.zzaok = -1;
        this.zzaol = -1;
        this.zzaom = -9223372036854775807L;
        this.zzano = zzjk;
        this.zzano.zza(new zzjo(this, null));
        this.zzanq = true;
        this.zzanc = new zzjp();
        this.zzanp = new SparseArray<>();
        this.zzant = new zzoc(4);
        this.zzanu = new zzoc(ByteBuffer.allocate(4).putInt(-1).array());
        this.zzanv = new zzoc(4);
        this.zzanr = new zzoc(zznx.zzbfz);
        this.zzans = new zzoc(4);
        this.zzanw = new zzoc();
        this.zzanx = new zzoc();
        this.zzany = new zzoc(8);
        this.zzanz = new zzoc();
    }

    public final boolean zza(zziv zziv) throws IOException, InterruptedException {
        return new zzjq().zza(zziv);
    }

    public final void zza(zziy zziy) {
        this.zzapk = zziy;
    }

    public final void zzc(long j, long j2) {
        this.zzaom = -9223372036854775807L;
        this.zzaoq = 0;
        this.zzano.reset();
        this.zzanc.reset();
        zzgg();
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0039 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0005 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(com.google.android.gms.internal.ads.zziv r9, com.google.android.gms.internal.ads.zzjc r10) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r8 = this;
            r0 = 0
            r8.zzapi = r0
            r1 = 1
            r2 = 1
        L_0x0005:
            if (r2 == 0) goto L_0x003a
            boolean r3 = r8.zzapi
            if (r3 != 0) goto L_0x003a
            com.google.android.gms.internal.ads.zzjk r2 = r8.zzano
            boolean r2 = r2.zzb(r9)
            if (r2 == 0) goto L_0x0005
            long r3 = r9.getPosition()
            boolean r5 = r8.zzaoj
            if (r5 == 0) goto L_0x0025
            r8.zzaol = r3
            long r3 = r8.zzaok
            r10.zzamq = r3
            r8.zzaoj = r0
        L_0x0023:
            r3 = 1
            goto L_0x0037
        L_0x0025:
            boolean r3 = r8.zzaog
            if (r3 == 0) goto L_0x0036
            long r3 = r8.zzaol
            r5 = -1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x0036
            r10.zzamq = r3
            r8.zzaol = r5
            goto L_0x0023
        L_0x0036:
            r3 = 0
        L_0x0037:
            if (r3 == 0) goto L_0x0005
            return r1
        L_0x003a:
            if (r2 == 0) goto L_0x003d
            return r0
        L_0x003d:
            r9 = -1
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzjm.zza(com.google.android.gms.internal.ads.zziv, com.google.android.gms.internal.ads.zzjc):int");
    }

    /* access modifiers changed from: 0000 */
    public final void zzd(int i, long j, long j2) throws zzgv {
        if (i == 160) {
            this.zzapj = false;
        } else if (i == 174) {
            this.zzaof = new zzjn(null);
        } else if (i == 187) {
            this.zzaop = false;
        } else if (i == 19899) {
            this.zzaoh = -1;
            this.zzaoi = -1;
        } else if (i != 20533) {
            if (i != 21968) {
                if (i != 25152) {
                    if (i == 408125543) {
                        long j3 = this.zzaoc;
                        if (j3 == -1 || j3 == j) {
                            this.zzaoc = j;
                            this.zzaob = j2;
                        } else {
                            throw new zzgv("Multiple Segment elements not supported");
                        }
                    } else if (i == 475249515) {
                        this.zzaon = new zznw();
                        this.zzaoo = new zznw();
                        return;
                    } else if (i == 524531317 && !this.zzaog) {
                        if (!this.zzanq || this.zzaok == -1) {
                            this.zzapk.zza(new zzje(this.zzagh));
                            this.zzaog = true;
                            return;
                        }
                        this.zzaoj = true;
                        return;
                    }
                }
                return;
            }
            this.zzaof.zzapu = true;
        } else {
            this.zzaof.zzapn = true;
        }
    }

    /* access modifiers changed from: 0000 */
    public final void zzai(int i) throws zzgv {
        zzjb zzjb;
        int i2;
        int i3 = 0;
        if (i != 160) {
            if (i != 174) {
                if (i == 19899) {
                    int i4 = this.zzaoh;
                    if (i4 != -1) {
                        long j = this.zzaoi;
                        if (j != -1) {
                            if (i4 == 475249515) {
                                this.zzaok = j;
                            }
                        }
                    }
                    throw new zzgv("Mandatory element SeekID or SeekPosition not found");
                } else if (i != 25152) {
                    if (i != 28032) {
                        if (i == 357149030) {
                            if (this.zzaod == -9223372036854775807L) {
                                this.zzaod = 1000000;
                            }
                            long j2 = this.zzaoe;
                            if (j2 != -9223372036854775807L) {
                                this.zzagh = zzdu(j2);
                                return;
                            }
                        } else if (i != 374648427) {
                            if (i == 475249515 && !this.zzaog) {
                                zziy zziy = this.zzapk;
                                if (!(this.zzaoc == -1 || this.zzagh == -9223372036854775807L)) {
                                    zznw zznw = this.zzaon;
                                    if (!(zznw == null || zznw.size() == 0)) {
                                        zznw zznw2 = this.zzaoo;
                                        if (zznw2 != null && zznw2.size() == this.zzaon.size()) {
                                            int size = this.zzaon.size();
                                            int[] iArr = new int[size];
                                            long[] jArr = new long[size];
                                            long[] jArr2 = new long[size];
                                            long[] jArr3 = new long[size];
                                            for (int i5 = 0; i5 < size; i5++) {
                                                jArr3[i5] = this.zzaon.get(i5);
                                                jArr[i5] = this.zzaoc + this.zzaoo.get(i5);
                                            }
                                            while (true) {
                                                i2 = size - 1;
                                                if (i3 >= i2) {
                                                    break;
                                                }
                                                int i6 = i3 + 1;
                                                iArr[i3] = (int) (jArr[i6] - jArr[i3]);
                                                jArr2[i3] = jArr3[i6] - jArr3[i3];
                                                i3 = i6;
                                            }
                                            iArr[i2] = (int) ((this.zzaoc + this.zzaob) - jArr[i2]);
                                            jArr2[i2] = this.zzagh - jArr3[i2];
                                            this.zzaon = null;
                                            this.zzaoo = null;
                                            zzjb = new zziu(iArr, jArr, jArr2, jArr3);
                                            zziy.zza(zzjb);
                                            this.zzaog = true;
                                            return;
                                        }
                                    }
                                }
                                this.zzaon = null;
                                this.zzaoo = null;
                                zzjb = new zzje(this.zzagh);
                                zziy.zza(zzjb);
                                this.zzaog = true;
                                return;
                            }
                        } else if (this.zzanp.size() != 0) {
                            this.zzapk.zzge();
                        } else {
                            throw new zzgv("No valid tracks were found");
                        }
                    } else if (this.zzaof.zzapn && this.zzaof.zzapo != null) {
                        throw new zzgv("Combining encryption and compression is not supported");
                    }
                } else if (this.zzaof.zzapn) {
                    if (this.zzaof.zzapp != null) {
                        this.zzaof.zzaff = new zzin(new zza(zzga.zzaca, "video/webm", this.zzaof.zzapp.zzani));
                        return;
                    }
                    throw new zzgv("Encrypted Track found but ContentEncKeyID was not found");
                }
                return;
            }
            String str = this.zzaof.zzapl;
            if ("V_VP8".equals(str) || "V_VP9".equals(str) || "V_MPEG2".equals(str) || "V_MPEG4/ISO/SP".equals(str) || "V_MPEG4/ISO/ASP".equals(str) || "V_MPEG4/ISO/AP".equals(str) || "V_MPEG4/ISO/AVC".equals(str) || "V_MPEGH/ISO/HEVC".equals(str) || "V_MS/VFW/FOURCC".equals(str) || "V_THEORA".equals(str) || "A_OPUS".equals(str) || "A_VORBIS".equals(str) || "A_AAC".equals(str) || "A_MPEG/L2".equals(str) || "A_MPEG/L3".equals(str) || "A_AC3".equals(str) || "A_EAC3".equals(str) || "A_TRUEHD".equals(str) || "A_DTS".equals(str) || "A_DTS/EXPRESS".equals(str) || "A_DTS/LOSSLESS".equals(str) || "A_FLAC".equals(str) || "A_MS/ACM".equals(str) || "A_PCM/INT/LIT".equals(str) || "S_TEXT/UTF8".equals(str) || "S_VOBSUB".equals(str) || "S_HDMV/PGS".equals(str) || "S_DVBSUB".equals(str)) {
                i3 = 1;
            }
            if (i3 != 0) {
                zzjn zzjn = this.zzaof;
                zzjn.zza(this.zzapk, zzjn.number);
                this.zzanp.put(this.zzaof.number, this.zzaof);
            }
            this.zzaof = null;
        } else if (this.zzaoq == 2) {
            if (!this.zzapj) {
                this.zzaoy |= 1;
            }
            zza((zzjn) this.zzanp.get(this.zzaow), this.zzaor);
            this.zzaoq = 0;
        }
    }

    /* access modifiers changed from: 0000 */
    public final void zzc(int i, long j) throws zzgv {
        String str = " not supported";
        if (i != 20529) {
            if (i != 20530) {
                boolean z = false;
                switch (i) {
                    case 131:
                        this.zzaof.type = (int) j;
                        return;
                    case 136:
                        zzjn zzjn = this.zzaof;
                        if (j == 1) {
                            z = true;
                        }
                        zzjn.zzaqn = z;
                        return;
                    case 155:
                        this.zzaos = zzdu(j);
                        return;
                    case 159:
                        this.zzaof.zzafm = (int) j;
                        return;
                    case 176:
                        this.zzaof.width = (int) j;
                        return;
                    case 179:
                        this.zzaon.add(zzdu(j));
                        return;
                    case 186:
                        this.zzaof.height = (int) j;
                        return;
                    case 215:
                        this.zzaof.number = (int) j;
                        return;
                    case 231:
                        this.zzaom = zzdu(j);
                        return;
                    case 241:
                        if (!this.zzaop) {
                            this.zzaoo.add(j);
                            this.zzaop = true;
                            return;
                        }
                        break;
                    case 251:
                        this.zzapj = true;
                        return;
                    case 16980:
                        if (j != 3) {
                            StringBuilder sb = new StringBuilder(50);
                            sb.append("ContentCompAlgo ");
                            sb.append(j);
                            sb.append(str);
                            throw new zzgv(sb.toString());
                        }
                        break;
                    case 17029:
                        if (j < 1 || j > 2) {
                            StringBuilder sb2 = new StringBuilder(53);
                            sb2.append("DocTypeReadVersion ");
                            sb2.append(j);
                            sb2.append(str);
                            throw new zzgv(sb2.toString());
                        }
                    case 17143:
                        if (j != 1) {
                            StringBuilder sb3 = new StringBuilder(50);
                            sb3.append("EBMLReadVersion ");
                            sb3.append(j);
                            sb3.append(str);
                            throw new zzgv(sb3.toString());
                        }
                        break;
                    case 18401:
                        if (j != 5) {
                            StringBuilder sb4 = new StringBuilder(49);
                            sb4.append("ContentEncAlgo ");
                            sb4.append(j);
                            sb4.append(str);
                            throw new zzgv(sb4.toString());
                        }
                        break;
                    case 18408:
                        if (j != 1) {
                            StringBuilder sb5 = new StringBuilder(56);
                            sb5.append("AESSettingsCipherMode ");
                            sb5.append(j);
                            sb5.append(str);
                            throw new zzgv(sb5.toString());
                        }
                        break;
                    case 21420:
                        this.zzaoi = j + this.zzaoc;
                        return;
                    case 21432:
                        int i2 = (int) j;
                        if (i2 == 0) {
                            this.zzaof.zzafj = 0;
                            return;
                        } else if (i2 == 1) {
                            this.zzaof.zzafj = 2;
                            return;
                        } else if (i2 == 3) {
                            this.zzaof.zzafj = 1;
                            return;
                        } else if (i2 == 15) {
                            this.zzaof.zzafj = 3;
                            return;
                        } else {
                            return;
                        }
                    case 21680:
                        this.zzaof.zzapr = (int) j;
                        return;
                    case 21682:
                        this.zzaof.zzapt = (int) j;
                        return;
                    case 21690:
                        this.zzaof.zzaps = (int) j;
                        return;
                    case 21930:
                        zzjn zzjn2 = this.zzaof;
                        if (j == 1) {
                            z = true;
                        }
                        zzjn2.zzaqo = z;
                        return;
                    case 22186:
                        this.zzaof.zzaql = j;
                        return;
                    case 22203:
                        this.zzaof.zzaqm = j;
                        return;
                    case 25188:
                        this.zzaof.zzaqk = (int) j;
                        return;
                    case 2352003:
                        this.zzaof.zzapm = (int) j;
                        return;
                    case 2807729:
                        this.zzaod = j;
                        return;
                    default:
                        switch (i) {
                            case 21945:
                                int i3 = (int) j;
                                if (i3 == 1) {
                                    this.zzaof.zzapx = 2;
                                    return;
                                } else if (i3 == 2) {
                                    this.zzaof.zzapx = 1;
                                    return;
                                } else {
                                    return;
                                }
                            case 21946:
                                int i4 = (int) j;
                                if (i4 != 1) {
                                    if (i4 == 16) {
                                        this.zzaof.zzapw = 6;
                                        return;
                                    } else if (i4 == 18) {
                                        this.zzaof.zzapw = 7;
                                        return;
                                    } else if (!(i4 == 6 || i4 == 7)) {
                                        return;
                                    }
                                }
                                this.zzaof.zzapw = 3;
                                return;
                            case 21947:
                                zzjn zzjn3 = this.zzaof;
                                zzjn3.zzapu = true;
                                int i5 = (int) j;
                                if (i5 == 1) {
                                    zzjn3.zzapv = 1;
                                    return;
                                } else if (i5 == 9) {
                                    zzjn3.zzapv = 6;
                                    return;
                                } else if (i5 == 4 || i5 == 5 || i5 == 6 || i5 == 7) {
                                    this.zzaof.zzapv = 2;
                                    return;
                                } else {
                                    return;
                                }
                            case 21948:
                                this.zzaof.zzapy = (int) j;
                                return;
                            case 21949:
                                this.zzaof.zzapz = (int) j;
                                break;
                        }
                }
            } else if (j != 1) {
                StringBuilder sb6 = new StringBuilder(55);
                sb6.append("ContentEncodingScope ");
                sb6.append(j);
                sb6.append(str);
                throw new zzgv(sb6.toString());
            }
        } else if (j != 0) {
            StringBuilder sb7 = new StringBuilder(55);
            sb7.append("ContentEncodingOrder ");
            sb7.append(j);
            sb7.append(str);
            throw new zzgv(sb7.toString());
        }
    }

    /* access modifiers changed from: 0000 */
    public final void zza(int i, double d) {
        if (i == 181) {
            this.zzaof.zzafn = (int) d;
        } else if (i != 17545) {
            switch (i) {
                case 21969:
                    this.zzaof.zzaqa = (float) d;
                    return;
                case 21970:
                    this.zzaof.zzaqb = (float) d;
                    return;
                case 21971:
                    this.zzaof.zzaqc = (float) d;
                    return;
                case 21972:
                    this.zzaof.zzaqd = (float) d;
                    return;
                case 21973:
                    this.zzaof.zzaqe = (float) d;
                    return;
                case 21974:
                    this.zzaof.zzaqf = (float) d;
                    return;
                case 21975:
                    this.zzaof.zzaqg = (float) d;
                    return;
                case 21976:
                    this.zzaof.zzaqh = (float) d;
                    return;
                case 21977:
                    this.zzaof.zzaqi = (float) d;
                    return;
                case 21978:
                    this.zzaof.zzaqj = (float) d;
                    break;
            }
        } else {
            this.zzaoe = (long) d;
        }
    }

    /* access modifiers changed from: 0000 */
    public final void zza(int i, String str) throws zzgv {
        if (i != 134) {
            if (i != 17026) {
                if (i == 2274716) {
                    this.zzaof.zzaft = str;
                }
            } else if (!"webm".equals(str) && !"matroska".equals(str)) {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 22);
                sb.append("DocType ");
                sb.append(str);
                sb.append(" not supported");
                throw new zzgv(sb.toString());
            }
            return;
        }
        this.zzaof.zzapl = str;
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x01fe, code lost:
        throw new com.google.android.gms.internal.ads.zzgv("EBML lacing sample size out of range.");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(int r20, int r21, com.google.android.gms.internal.ads.zziv r22) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r21
            r3 = r22
            r4 = 161(0xa1, float:2.26E-43)
            r5 = 163(0xa3, float:2.28E-43)
            r6 = 4
            r7 = 0
            r8 = 1
            if (r1 == r4) goto L_0x0091
            if (r1 == r5) goto L_0x0091
            r4 = 16981(0x4255, float:2.3795E-41)
            if (r1 == r4) goto L_0x0085
            r4 = 18402(0x47e2, float:2.5787E-41)
            if (r1 == r4) goto L_0x0076
            r4 = 21419(0x53ab, float:3.0014E-41)
            if (r1 == r4) goto L_0x0058
            r4 = 25506(0x63a2, float:3.5742E-41)
            if (r1 == r4) goto L_0x004c
            r4 = 30322(0x7672, float:4.249E-41)
            if (r1 != r4) goto L_0x0033
            com.google.android.gms.internal.ads.zzjn r1 = r0.zzaof
            byte[] r4 = new byte[r2]
            r1.zzafk = r4
            byte[] r1 = r1.zzafk
            r3.readFully(r1, r7, r2)
            return
        L_0x0033:
            com.google.android.gms.internal.ads.zzgv r2 = new com.google.android.gms.internal.ads.zzgv
            r3 = 26
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            java.lang.String r3 = "Unexpected id: "
            r4.append(r3)
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            r2.<init>(r1)
            throw r2
        L_0x004c:
            com.google.android.gms.internal.ads.zzjn r1 = r0.zzaof
            byte[] r4 = new byte[r2]
            r1.zzapq = r4
            byte[] r1 = r1.zzapq
            r3.readFully(r1, r7, r2)
            return
        L_0x0058:
            com.google.android.gms.internal.ads.zzoc r1 = r0.zzanv
            byte[] r1 = r1.data
            java.util.Arrays.fill(r1, r7)
            com.google.android.gms.internal.ads.zzoc r1 = r0.zzanv
            byte[] r1 = r1.data
            int r6 = r6 - r2
            r3.readFully(r1, r6, r2)
            com.google.android.gms.internal.ads.zzoc r1 = r0.zzanv
            r1.zzbg(r7)
            com.google.android.gms.internal.ads.zzoc r1 = r0.zzanv
            long r1 = r1.zzio()
            int r2 = (int) r1
            r0.zzaoh = r2
            return
        L_0x0076:
            byte[] r1 = new byte[r2]
            r3.readFully(r1, r7, r2)
            com.google.android.gms.internal.ads.zzjn r2 = r0.zzaof
            com.google.android.gms.internal.ads.zzjg r3 = new com.google.android.gms.internal.ads.zzjg
            r3.<init>(r8, r1)
            r2.zzapp = r3
            return
        L_0x0085:
            com.google.android.gms.internal.ads.zzjn r1 = r0.zzaof
            byte[] r4 = new byte[r2]
            r1.zzapo = r4
            byte[] r1 = r1.zzapo
            r3.readFully(r1, r7, r2)
            return
        L_0x0091:
            int r4 = r0.zzaoq
            r9 = 8
            if (r4 != 0) goto L_0x00b6
            com.google.android.gms.internal.ads.zzjp r4 = r0.zzanc
            long r10 = r4.zza(r3, r7, r8, r9)
            int r4 = (int) r10
            r0.zzaow = r4
            com.google.android.gms.internal.ads.zzjp r4 = r0.zzanc
            int r4 = r4.zzgi()
            r0.zzaox = r4
            r10 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r0.zzaos = r10
            r0.zzaoq = r8
            com.google.android.gms.internal.ads.zzoc r4 = r0.zzant
            r4.reset()
        L_0x00b6:
            android.util.SparseArray<com.google.android.gms.internal.ads.zzjn> r4 = r0.zzanp
            int r10 = r0.zzaow
            java.lang.Object r4 = r4.get(r10)
            com.google.android.gms.internal.ads.zzjn r4 = (com.google.android.gms.internal.ads.zzjn) r4
            if (r4 != 0) goto L_0x00cc
            int r1 = r0.zzaox
            int r1 = r2 - r1
            r3.zzab(r1)
            r0.zzaoq = r7
            return
        L_0x00cc:
            int r10 = r0.zzaoq
            if (r10 != r8) goto L_0x0285
            r10 = 3
            r0.zzb(r3, r10)
            com.google.android.gms.internal.ads.zzoc r11 = r0.zzant
            byte[] r11 = r11.data
            r12 = 2
            byte r11 = r11[r12]
            r11 = r11 & 6
            int r11 = r11 >> r8
            r13 = 255(0xff, float:3.57E-43)
            if (r11 != 0) goto L_0x00f6
            r0.zzaou = r8
            int[] r6 = r0.zzaov
            int[] r6 = zza(r6, r8)
            r0.zzaov = r6
            int[] r6 = r0.zzaov
            int r11 = r0.zzaox
            int r2 = r2 - r11
            int r2 = r2 - r10
            r6[r7] = r2
            goto L_0x0212
        L_0x00f6:
            if (r1 != r5) goto L_0x027d
            r0.zzb(r3, r6)
            com.google.android.gms.internal.ads.zzoc r14 = r0.zzant
            byte[] r14 = r14.data
            byte r14 = r14[r10]
            r14 = r14 & r13
            int r14 = r14 + r8
            r0.zzaou = r14
            int[] r14 = r0.zzaov
            int r15 = r0.zzaou
            int[] r14 = zza(r14, r15)
            r0.zzaov = r14
            if (r11 != r12) goto L_0x011f
            int r10 = r0.zzaox
            int r2 = r2 - r10
            int r2 = r2 - r6
            int r6 = r0.zzaou
            int r2 = r2 / r6
            int[] r10 = r0.zzaov
            java.util.Arrays.fill(r10, r7, r6, r2)
            goto L_0x0212
        L_0x011f:
            if (r11 != r8) goto L_0x0157
            r6 = 0
            r10 = 4
            r11 = 0
        L_0x0124:
            int r14 = r0.zzaou
            int r15 = r14 + -1
            if (r6 >= r15) goto L_0x014b
            int[] r14 = r0.zzaov
            r14[r6] = r7
        L_0x012e:
            int r10 = r10 + r8
            r0.zzb(r3, r10)
            com.google.android.gms.internal.ads.zzoc r14 = r0.zzant
            byte[] r14 = r14.data
            int r15 = r10 + -1
            byte r14 = r14[r15]
            r14 = r14 & r13
            int[] r15 = r0.zzaov
            r16 = r15[r6]
            int r16 = r16 + r14
            r15[r6] = r16
            if (r14 == r13) goto L_0x012e
            r14 = r15[r6]
            int r11 = r11 + r14
            int r6 = r6 + 1
            goto L_0x0124
        L_0x014b:
            int[] r6 = r0.zzaov
            int r14 = r14 - r8
            int r15 = r0.zzaox
            int r2 = r2 - r15
            int r2 = r2 - r10
            int r2 = r2 - r11
            r6[r14] = r2
            goto L_0x0212
        L_0x0157:
            if (r11 != r10) goto L_0x0264
            r6 = 0
            r10 = 4
            r11 = 0
        L_0x015c:
            int r14 = r0.zzaou
            int r15 = r14 + -1
            if (r6 >= r15) goto L_0x0207
            int[] r14 = r0.zzaov
            r14[r6] = r7
            int r10 = r10 + 1
            r0.zzb(r3, r10)
            com.google.android.gms.internal.ads.zzoc r14 = r0.zzant
            byte[] r14 = r14.data
            int r15 = r10 + -1
            byte r14 = r14[r15]
            if (r14 == 0) goto L_0x01ff
            r16 = 0
            r14 = 0
        L_0x0178:
            if (r14 >= r9) goto L_0x01ca
            int r18 = 7 - r14
            int r18 = r8 << r18
            com.google.android.gms.internal.ads.zzoc r5 = r0.zzant
            byte[] r5 = r5.data
            byte r5 = r5[r15]
            r5 = r5 & r18
            if (r5 == 0) goto L_0x01c0
            int r10 = r10 + r14
            r0.zzb(r3, r10)
            com.google.android.gms.internal.ads.zzoc r5 = r0.zzant
            byte[] r5 = r5.data
            int r16 = r15 + 1
            byte r5 = r5[r15]
            r5 = r5 & r13
            r15 = r18 ^ -1
            r5 = r5 & r15
            long r7 = (long) r5
            r5 = r16
        L_0x019b:
            r16 = r7
            if (r5 >= r10) goto L_0x01b2
            long r7 = r16 << r9
            com.google.android.gms.internal.ads.zzoc r15 = r0.zzant
            byte[] r15 = r15.data
            int r16 = r5 + 1
            byte r5 = r15[r5]
            r5 = r5 & r13
            long r12 = (long) r5
            long r7 = r7 | r12
            r5 = r16
            r12 = 2
            r13 = 255(0xff, float:3.57E-43)
            goto L_0x019b
        L_0x01b2:
            if (r6 <= 0) goto L_0x01ca
            int r14 = r14 * 7
            int r14 = r14 + 6
            r7 = 1
            long r12 = r7 << r14
            long r12 = r12 - r7
            long r16 = r16 - r12
            goto L_0x01ca
        L_0x01c0:
            int r14 = r14 + 1
            r5 = 163(0xa3, float:2.28E-43)
            r7 = 0
            r8 = 1
            r12 = 2
            r13 = 255(0xff, float:3.57E-43)
            goto L_0x0178
        L_0x01ca:
            r7 = r16
            r12 = -2147483648(0xffffffff80000000, double:NaN)
            int r5 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
            if (r5 < 0) goto L_0x01f7
            r12 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r5 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
            if (r5 > 0) goto L_0x01f7
            int r5 = (int) r7
            int[] r7 = r0.zzaov
            if (r6 != 0) goto L_0x01e0
            goto L_0x01e5
        L_0x01e0:
            int r8 = r6 + -1
            r8 = r7[r8]
            int r5 = r5 + r8
        L_0x01e5:
            r7[r6] = r5
            int[] r5 = r0.zzaov
            r5 = r5[r6]
            int r11 = r11 + r5
            int r6 = r6 + 1
            r5 = 163(0xa3, float:2.28E-43)
            r7 = 0
            r8 = 1
            r12 = 2
            r13 = 255(0xff, float:3.57E-43)
            goto L_0x015c
        L_0x01f7:
            com.google.android.gms.internal.ads.zzgv r1 = new com.google.android.gms.internal.ads.zzgv
            java.lang.String r2 = "EBML lacing sample size out of range."
            r1.<init>(r2)
            throw r1
        L_0x01ff:
            com.google.android.gms.internal.ads.zzgv r1 = new com.google.android.gms.internal.ads.zzgv
            java.lang.String r2 = "No valid varint length mask found"
            r1.<init>(r2)
            throw r1
        L_0x0207:
            int[] r5 = r0.zzaov
            r6 = 1
            int r14 = r14 - r6
            int r6 = r0.zzaox
            int r2 = r2 - r6
            int r2 = r2 - r10
            int r2 = r2 - r11
            r5[r14] = r2
        L_0x0212:
            com.google.android.gms.internal.ads.zzoc r2 = r0.zzant
            byte[] r2 = r2.data
            r5 = 0
            byte r2 = r2[r5]
            int r2 = r2 << r9
            com.google.android.gms.internal.ads.zzoc r5 = r0.zzant
            byte[] r5 = r5.data
            r6 = 1
            byte r5 = r5[r6]
            r6 = 255(0xff, float:3.57E-43)
            r5 = r5 & r6
            r2 = r2 | r5
            long r5 = r0.zzaom
            long r7 = (long) r2
            long r7 = r0.zzdu(r7)
            long r5 = r5 + r7
            r0.zzaor = r5
            com.google.android.gms.internal.ads.zzoc r2 = r0.zzant
            byte[] r2 = r2.data
            r5 = 2
            byte r2 = r2[r5]
            r2 = r2 & r9
            if (r2 != r9) goto L_0x023b
            r2 = 1
            goto L_0x023c
        L_0x023b:
            r2 = 0
        L_0x023c:
            int r6 = r4.type
            if (r6 == r5) goto L_0x0252
            r6 = 163(0xa3, float:2.28E-43)
            if (r1 != r6) goto L_0x0250
            com.google.android.gms.internal.ads.zzoc r6 = r0.zzant
            byte[] r6 = r6.data
            byte r6 = r6[r5]
            r5 = 128(0x80, float:1.794E-43)
            r6 = r6 & r5
            if (r6 != r5) goto L_0x0250
            goto L_0x0252
        L_0x0250:
            r5 = 0
            goto L_0x0253
        L_0x0252:
            r5 = 1
        L_0x0253:
            if (r2 == 0) goto L_0x0258
            r7 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L_0x0259
        L_0x0258:
            r7 = 0
        L_0x0259:
            r2 = r5 | r7
            r0.zzaoy = r2
            r2 = 2
            r0.zzaoq = r2
            r2 = 0
            r0.zzaot = r2
            goto L_0x0285
        L_0x0264:
            com.google.android.gms.internal.ads.zzgv r1 = new com.google.android.gms.internal.ads.zzgv
            r2 = 36
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r2 = "Unexpected lacing value: "
            r3.append(r2)
            r3.append(r11)
            java.lang.String r2 = r3.toString()
            r1.<init>(r2)
            throw r1
        L_0x027d:
            com.google.android.gms.internal.ads.zzgv r1 = new com.google.android.gms.internal.ads.zzgv
            java.lang.String r2 = "Lacing only supported in SimpleBlocks."
            r1.<init>(r2)
            throw r1
        L_0x0285:
            r2 = 163(0xa3, float:2.28E-43)
            if (r1 != r2) goto L_0x02b0
        L_0x0289:
            int r1 = r0.zzaot
            int r2 = r0.zzaou
            if (r1 >= r2) goto L_0x02ac
            int[] r2 = r0.zzaov
            r1 = r2[r1]
            r0.zza(r3, r4, r1)
            long r1 = r0.zzaor
            int r5 = r0.zzaot
            int r6 = r4.zzapm
            int r5 = r5 * r6
            int r5 = r5 / 1000
            long r5 = (long) r5
            long r1 = r1 + r5
            r0.zza(r4, r1)
            int r1 = r0.zzaot
            r2 = 1
            int r1 = r1 + r2
            r0.zzaot = r1
            goto L_0x0289
        L_0x02ac:
            r1 = 0
            r0.zzaoq = r1
            return
        L_0x02b0:
            r1 = 0
            int[] r2 = r0.zzaov
            r1 = r2[r1]
            r0.zza(r3, r4, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzjm.zza(int, int, com.google.android.gms.internal.ads.zziv):void");
    }

    private final void zza(zzjn zzjn, long j) {
        byte[] bArr;
        if ("S_TEXT/UTF8".equals(zzjn.zzapl)) {
            byte[] bArr2 = this.zzanx.data;
            long j2 = this.zzaos;
            if (j2 == -9223372036854775807L) {
                bArr = zzanm;
            } else {
                int i = (int) (j2 / 3600000000L);
                long j3 = j2 - (((long) i) * 3600000000L);
                int i2 = (int) (j3 / 60000000);
                long j4 = j3 - ((long) (60000000 * i2));
                int i3 = (int) (j4 / 1000000);
                int i4 = (int) ((j4 - ((long) (1000000 * i3))) / 1000);
                bArr = zzof.zzbh(String.format(Locale.US, "%02d:%02d:%02d,%03d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}));
            }
            System.arraycopy(bArr, 0, bArr2, 19, 12);
            zzjd zzjd = zzjn.zzaqp;
            zzoc zzoc = this.zzanx;
            zzjd.zza(zzoc, zzoc.limit());
            this.zzaph += this.zzanx.limit();
        }
        zzjn.zzaqp.zza(j, this.zzaoy, this.zzaph, 0, zzjn.zzapp);
        this.zzapi = true;
        zzgg();
    }

    private final void zzgg() {
        this.zzaoz = 0;
        this.zzaph = 0;
        this.zzapg = 0;
        this.zzapa = false;
        this.zzapb = false;
        this.zzapd = false;
        this.zzapf = 0;
        this.zzape = 0;
        this.zzapc = false;
        this.zzanw.reset();
    }

    private final void zzb(zziv zziv, int i) throws IOException, InterruptedException {
        if (this.zzant.limit() < i) {
            if (this.zzant.capacity() < i) {
                zzoc zzoc = this.zzant;
                zzoc.zzb(Arrays.copyOf(zzoc.data, Math.max(this.zzant.data.length << 1, i)), this.zzant.limit());
            }
            zziv.readFully(this.zzant.data, this.zzant.limit(), i - this.zzant.limit());
            this.zzant.zzbf(i);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:75:0x0210  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zza(com.google.android.gms.internal.ads.zziv r10, com.google.android.gms.internal.ads.zzjn r11, int r12) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r9 = this;
            java.lang.String r0 = r11.zzapl
            java.lang.String r1 = "S_TEXT/UTF8"
            boolean r0 = r1.equals(r0)
            r1 = 0
            if (r0 == 0) goto L_0x0038
            byte[] r11 = zzanl
            int r11 = r11.length
            int r11 = r11 + r12
            com.google.android.gms.internal.ads.zzoc r0 = r9.zzanx
            int r0 = r0.capacity()
            if (r0 >= r11) goto L_0x0023
            com.google.android.gms.internal.ads.zzoc r0 = r9.zzanx
            byte[] r2 = zzanl
            int r3 = r11 + r12
            byte[] r2 = java.util.Arrays.copyOf(r2, r3)
            r0.data = r2
        L_0x0023:
            com.google.android.gms.internal.ads.zzoc r0 = r9.zzanx
            byte[] r0 = r0.data
            byte[] r2 = zzanl
            int r2 = r2.length
            r10.readFully(r0, r2, r12)
            com.google.android.gms.internal.ads.zzoc r10 = r9.zzanx
            r10.zzbg(r1)
            com.google.android.gms.internal.ads.zzoc r10 = r9.zzanx
            r10.zzbf(r11)
            return
        L_0x0038:
            com.google.android.gms.internal.ads.zzjd r0 = r11.zzaqp
            boolean r2 = r9.zzapa
            r3 = 2
            r4 = 1
            if (r2 != 0) goto L_0x0185
            boolean r2 = r11.zzapn
            if (r2 == 0) goto L_0x0175
            int r2 = r9.zzaoy
            r5 = -1073741825(0xffffffffbfffffff, float:-1.9999999)
            r2 = r2 & r5
            r9.zzaoy = r2
            boolean r2 = r9.zzapb
            r5 = 128(0x80, float:1.794E-43)
            if (r2 != 0) goto L_0x007a
            com.google.android.gms.internal.ads.zzoc r2 = r9.zzant
            byte[] r2 = r2.data
            r10.readFully(r2, r1, r4)
            int r2 = r9.zzaoz
            int r2 = r2 + r4
            r9.zzaoz = r2
            com.google.android.gms.internal.ads.zzoc r2 = r9.zzant
            byte[] r2 = r2.data
            byte r2 = r2[r1]
            r2 = r2 & r5
            if (r2 == r5) goto L_0x0072
            com.google.android.gms.internal.ads.zzoc r2 = r9.zzant
            byte[] r2 = r2.data
            byte r2 = r2[r1]
            r9.zzape = r2
            r9.zzapb = r4
            goto L_0x007a
        L_0x0072:
            com.google.android.gms.internal.ads.zzgv r10 = new com.google.android.gms.internal.ads.zzgv
            java.lang.String r11 = "Extension bit is set in signal byte"
            r10.<init>(r11)
            throw r10
        L_0x007a:
            byte r2 = r9.zzape
            r6 = r2 & 1
            if (r6 != r4) goto L_0x0183
            r2 = r2 & r3
            if (r2 != r3) goto L_0x0085
            r2 = 1
            goto L_0x0086
        L_0x0085:
            r2 = 0
        L_0x0086:
            int r6 = r9.zzaoy
            r7 = 1073741824(0x40000000, float:2.0)
            r6 = r6 | r7
            r9.zzaoy = r6
            boolean r6 = r9.zzapc
            if (r6 != 0) goto L_0x00cb
            com.google.android.gms.internal.ads.zzoc r6 = r9.zzany
            byte[] r6 = r6.data
            r7 = 8
            r10.readFully(r6, r1, r7)
            int r6 = r9.zzaoz
            int r6 = r6 + r7
            r9.zzaoz = r6
            r9.zzapc = r4
            com.google.android.gms.internal.ads.zzoc r6 = r9.zzant
            byte[] r6 = r6.data
            if (r2 == 0) goto L_0x00a8
            goto L_0x00a9
        L_0x00a8:
            r5 = 0
        L_0x00a9:
            r5 = r5 | r7
            byte r5 = (byte) r5
            r6[r1] = r5
            com.google.android.gms.internal.ads.zzoc r5 = r9.zzant
            r5.zzbg(r1)
            com.google.android.gms.internal.ads.zzoc r5 = r9.zzant
            r0.zza(r5, r4)
            int r5 = r9.zzaph
            int r5 = r5 + r4
            r9.zzaph = r5
            com.google.android.gms.internal.ads.zzoc r5 = r9.zzany
            r5.zzbg(r1)
            com.google.android.gms.internal.ads.zzoc r5 = r9.zzany
            r0.zza(r5, r7)
            int r5 = r9.zzaph
            int r5 = r5 + r7
            r9.zzaph = r5
        L_0x00cb:
            if (r2 == 0) goto L_0x0183
            boolean r2 = r9.zzapd
            if (r2 != 0) goto L_0x00ec
            com.google.android.gms.internal.ads.zzoc r2 = r9.zzant
            byte[] r2 = r2.data
            r10.readFully(r2, r1, r4)
            int r2 = r9.zzaoz
            int r2 = r2 + r4
            r9.zzaoz = r2
            com.google.android.gms.internal.ads.zzoc r2 = r9.zzant
            r2.zzbg(r1)
            com.google.android.gms.internal.ads.zzoc r2 = r9.zzant
            int r2 = r2.readUnsignedByte()
            r9.zzapf = r2
            r9.zzapd = r4
        L_0x00ec:
            int r2 = r9.zzapf
            int r2 = r2 << r3
            com.google.android.gms.internal.ads.zzoc r5 = r9.zzant
            r5.reset(r2)
            com.google.android.gms.internal.ads.zzoc r5 = r9.zzant
            byte[] r5 = r5.data
            r10.readFully(r5, r1, r2)
            int r5 = r9.zzaoz
            int r5 = r5 + r2
            r9.zzaoz = r5
            int r2 = r9.zzapf
            int r2 = r2 / r3
            int r2 = r2 + r4
            short r2 = (short) r2
            int r5 = r2 * 6
            int r5 = r5 + r3
            java.nio.ByteBuffer r6 = r9.zzaoa
            if (r6 == 0) goto L_0x0112
            int r6 = r6.capacity()
            if (r6 >= r5) goto L_0x0118
        L_0x0112:
            java.nio.ByteBuffer r6 = java.nio.ByteBuffer.allocate(r5)
            r9.zzaoa = r6
        L_0x0118:
            java.nio.ByteBuffer r6 = r9.zzaoa
            r6.position(r1)
            java.nio.ByteBuffer r6 = r9.zzaoa
            r6.putShort(r2)
            r2 = 0
            r6 = 0
        L_0x0124:
            int r7 = r9.zzapf
            if (r2 >= r7) goto L_0x0146
            com.google.android.gms.internal.ads.zzoc r7 = r9.zzant
            int r7 = r7.zzir()
            int r8 = r2 % 2
            if (r8 != 0) goto L_0x013b
            java.nio.ByteBuffer r8 = r9.zzaoa
            int r6 = r7 - r6
            short r6 = (short) r6
            r8.putShort(r6)
            goto L_0x0142
        L_0x013b:
            java.nio.ByteBuffer r8 = r9.zzaoa
            int r6 = r7 - r6
            r8.putInt(r6)
        L_0x0142:
            int r2 = r2 + 1
            r6 = r7
            goto L_0x0124
        L_0x0146:
            int r2 = r9.zzaoz
            int r2 = r12 - r2
            int r2 = r2 - r6
            int r7 = r7 % r3
            if (r7 != r4) goto L_0x0154
            java.nio.ByteBuffer r6 = r9.zzaoa
            r6.putInt(r2)
            goto L_0x015f
        L_0x0154:
            java.nio.ByteBuffer r6 = r9.zzaoa
            short r2 = (short) r2
            r6.putShort(r2)
            java.nio.ByteBuffer r2 = r9.zzaoa
            r2.putInt(r1)
        L_0x015f:
            com.google.android.gms.internal.ads.zzoc r2 = r9.zzanz
            java.nio.ByteBuffer r6 = r9.zzaoa
            byte[] r6 = r6.array()
            r2.zzb(r6, r5)
            com.google.android.gms.internal.ads.zzoc r2 = r9.zzanz
            r0.zza(r2, r5)
            int r2 = r9.zzaph
            int r2 = r2 + r5
            r9.zzaph = r2
            goto L_0x0183
        L_0x0175:
            byte[] r2 = r11.zzapo
            if (r2 == 0) goto L_0x0183
            com.google.android.gms.internal.ads.zzoc r2 = r9.zzanw
            byte[] r5 = r11.zzapo
            byte[] r6 = r11.zzapo
            int r6 = r6.length
            r2.zzb(r5, r6)
        L_0x0183:
            r9.zzapa = r4
        L_0x0185:
            com.google.android.gms.internal.ads.zzoc r2 = r9.zzanw
            int r2 = r2.limit()
            int r12 = r12 + r2
            java.lang.String r2 = r11.zzapl
            java.lang.String r5 = "V_MPEG4/ISO/AVC"
            boolean r2 = r5.equals(r2)
            r5 = 4
            if (r2 != 0) goto L_0x01ac
            java.lang.String r2 = r11.zzapl
            java.lang.String r6 = "V_MPEGH/ISO/HEVC"
            boolean r2 = r6.equals(r2)
            if (r2 == 0) goto L_0x01a2
            goto L_0x01ac
        L_0x01a2:
            int r2 = r9.zzaoz
            if (r2 >= r12) goto L_0x0206
            int r2 = r12 - r2
            r9.zza(r10, r0, r2)
            goto L_0x01a2
        L_0x01ac:
            com.google.android.gms.internal.ads.zzoc r2 = r9.zzans
            byte[] r2 = r2.data
            r2[r1] = r1
            r2[r4] = r1
            r2[r3] = r1
            int r3 = r11.zzaqq
            int r4 = r11.zzaqq
            int r4 = 4 - r4
        L_0x01bc:
            int r6 = r9.zzaoz
            if (r6 >= r12) goto L_0x0206
            int r6 = r9.zzapg
            if (r6 != 0) goto L_0x01fe
            com.google.android.gms.internal.ads.zzoc r6 = r9.zzanw
            int r6 = r6.zzim()
            int r6 = java.lang.Math.min(r3, r6)
            int r7 = r4 + r6
            int r8 = r3 - r6
            r10.readFully(r2, r7, r8)
            if (r6 <= 0) goto L_0x01dc
            com.google.android.gms.internal.ads.zzoc r7 = r9.zzanw
            r7.zze(r2, r4, r6)
        L_0x01dc:
            int r6 = r9.zzaoz
            int r6 = r6 + r3
            r9.zzaoz = r6
            com.google.android.gms.internal.ads.zzoc r6 = r9.zzans
            r6.zzbg(r1)
            com.google.android.gms.internal.ads.zzoc r6 = r9.zzans
            int r6 = r6.zzir()
            r9.zzapg = r6
            com.google.android.gms.internal.ads.zzoc r6 = r9.zzanr
            r6.zzbg(r1)
            com.google.android.gms.internal.ads.zzoc r6 = r9.zzanr
            r0.zza(r6, r5)
            int r6 = r9.zzaph
            int r6 = r6 + r5
            r9.zzaph = r6
            goto L_0x01bc
        L_0x01fe:
            int r7 = r9.zza(r10, r0, r6)
            int r6 = r6 - r7
            r9.zzapg = r6
            goto L_0x01bc
        L_0x0206:
            java.lang.String r10 = r11.zzapl
            java.lang.String r11 = "A_VORBIS"
            boolean r10 = r11.equals(r10)
            if (r10 == 0) goto L_0x021f
            com.google.android.gms.internal.ads.zzoc r10 = r9.zzanu
            r10.zzbg(r1)
            com.google.android.gms.internal.ads.zzoc r10 = r9.zzanu
            r0.zza(r10, r5)
            int r10 = r9.zzaph
            int r10 = r10 + r5
            r9.zzaph = r10
        L_0x021f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzjm.zza(com.google.android.gms.internal.ads.zziv, com.google.android.gms.internal.ads.zzjn, int):void");
    }

    private final int zza(zziv zziv, zzjd zzjd, int i) throws IOException, InterruptedException {
        int i2;
        int zzim = this.zzanw.zzim();
        if (zzim > 0) {
            i2 = Math.min(i, zzim);
            zzjd.zza(this.zzanw, i2);
        } else {
            i2 = zzjd.zza(zziv, i, false);
        }
        this.zzaoz += i2;
        this.zzaph += i2;
        return i2;
    }

    private final long zzdu(long j) throws zzgv {
        long j2 = this.zzaod;
        if (j2 != -9223372036854775807L) {
            return zzof.zza(j, j2, 1000);
        }
        throw new zzgv("Can't scale timecode prior to timecodeScale being set.");
    }

    private static int[] zza(int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        if (iArr.length >= i) {
            return iArr;
        }
        return new int[Math.max(iArr.length << 1, i)];
    }
}
