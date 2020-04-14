package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.util.SparseIntArray;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@SuppressLint({"InlinedApi"})
@TargetApi(16)
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzkp {
    private static final zzkm zzaze = zzkm.zzay("OMX.google.raw.decoder");
    private static final Pattern zzazf = Pattern.compile("^\\D?(\\d+)$");
    private static final HashMap<zza, List<zzkm>> zzazg = new HashMap<>();
    private static final SparseIntArray zzazh;
    private static final SparseIntArray zzazi;
    private static final Map<String, Integer> zzazj;
    private static int zzazk = -1;

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    static final class zza {
        public final String mimeType;
        public final boolean zzayy;

        public zza(String str, boolean z) {
            this.mimeType = str;
            this.zzayy = z;
        }

        public final int hashCode() {
            String str = this.mimeType;
            return (((str == null ? 0 : str.hashCode()) + 31) * 31) + (this.zzayy ? 1231 : 1237);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && obj.getClass() == zza.class) {
                zza zza = (zza) obj;
                return TextUtils.equals(this.mimeType, zza.mimeType) && this.zzayy == zza.zzayy;
            }
        }
    }

    public static zzkm zzgv() {
        return zzaze;
    }

    public static zzkm zzc(String str, boolean z) throws zzkt {
        List zzd = zzd(str, z);
        if (zzd.isEmpty()) {
            return null;
        }
        return (zzkm) zzd.get(0);
    }

    private static synchronized List<zzkm> zzd(String str, boolean z) throws zzkt {
        synchronized (zzkp.class) {
            zza zza2 = new zza(str, z);
            List<zzkm> list = (List) zzazg.get(zza2);
            if (list != null) {
                return list;
            }
            List zza3 = zza(zza2, zzof.SDK_INT >= 21 ? new zzku(z) : new zzkv());
            if (z && zza3.isEmpty() && 21 <= zzof.SDK_INT && zzof.SDK_INT <= 23) {
                zza3 = zza(zza2, (zzks) new zzkv());
                if (!zza3.isEmpty()) {
                    String str2 = ((zzkm) zza3.get(0)).name;
                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 63 + String.valueOf(str2).length());
                    sb.append("MediaCodecList API didn't list secure decoder for: ");
                    sb.append(str);
                    sb.append(". Assuming: ");
                    sb.append(str2);
                    Log.w("MediaCodecUtil", sb.toString());
                }
            }
            List<zzkm> unmodifiableList = Collections.unmodifiableList(zza3);
            zzazg.put(zza2, unmodifiableList);
            return unmodifiableList;
        }
    }

    public static int zzgw() throws zzkt {
        int i;
        if (zzazk == -1) {
            int i2 = 0;
            zzkm zzc = zzc("video/avc", false);
            if (zzc != null) {
                CodecProfileLevel[] zzgu = zzc.zzgu();
                int length = zzgu.length;
                int i3 = 0;
                while (i2 < length) {
                    int i4 = zzgu[i2].level;
                    if (i4 != 1 && i4 != 2) {
                        switch (i4) {
                            case 8:
                            case 16:
                            case 32:
                                i = 101376;
                                break;
                            case 64:
                                i = 202752;
                                break;
                            case 128:
                            case 256:
                                i = 414720;
                                break;
                            case 512:
                                i = 921600;
                                break;
                            case 1024:
                                i = 1310720;
                                break;
                            case 2048:
                            case 4096:
                                i = 2097152;
                                break;
                            case 8192:
                                i = 2228224;
                                break;
                            case 16384:
                                i = 5652480;
                                break;
                            case 32768:
                            case 65536:
                                i = 9437184;
                                break;
                            default:
                                i = -1;
                                break;
                        }
                    } else {
                        i = 25344;
                    }
                    i3 = Math.max(i, i3);
                    i2++;
                }
                i2 = Math.max(i3, zzof.SDK_INT >= 21 ? 345600 : 172800);
            }
            zzazk = i2;
        }
        return zzazk;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0029, code lost:
        if (r3.equals("hev1") != false) goto L_0x0041;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> zzbb(java.lang.String r9) {
        /*
            r0 = 0
            if (r9 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.String r1 = "\\."
            java.lang.String[] r1 = r9.split(r1)
            r2 = 0
            r3 = r1[r2]
            r4 = -1
            int r5 = r3.hashCode()
            r6 = 3
            r7 = 2
            r8 = 1
            switch(r5) {
                case 3006243: goto L_0x0036;
                case 3006244: goto L_0x002c;
                case 3199032: goto L_0x0023;
                case 3214780: goto L_0x0019;
                default: goto L_0x0018;
            }
        L_0x0018:
            goto L_0x0040
        L_0x0019:
            java.lang.String r2 = "hvc1"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0040
            r2 = 1
            goto L_0x0041
        L_0x0023:
            java.lang.String r5 = "hev1"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0040
            goto L_0x0041
        L_0x002c:
            java.lang.String r2 = "avc2"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0040
            r2 = 3
            goto L_0x0041
        L_0x0036:
            java.lang.String r2 = "avc1"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0040
            r2 = 2
            goto L_0x0041
        L_0x0040:
            r2 = -1
        L_0x0041:
            if (r2 == 0) goto L_0x004f
            if (r2 == r8) goto L_0x004f
            if (r2 == r7) goto L_0x004a
            if (r2 == r6) goto L_0x004a
            return r0
        L_0x004a:
            android.util.Pair r9 = zza(r9, r1)
            return r9
        L_0x004f:
            int r2 = r1.length
            r3 = 4
            java.lang.String r4 = "Ignoring malformed HEVC codec string: "
            java.lang.String r5 = "MediaCodecUtil"
            if (r2 >= r3) goto L_0x006f
            java.lang.String r9 = java.lang.String.valueOf(r9)
            int r1 = r9.length()
            if (r1 == 0) goto L_0x0066
            java.lang.String r9 = r4.concat(r9)
            goto L_0x006b
        L_0x0066:
            java.lang.String r9 = new java.lang.String
            r9.<init>(r4)
        L_0x006b:
            android.util.Log.w(r5, r9)
            return r0
        L_0x006f:
            java.util.regex.Pattern r2 = zzazf
            r3 = r1[r8]
            java.util.regex.Matcher r2 = r2.matcher(r3)
            boolean r3 = r2.matches()
            if (r3 != 0) goto L_0x0095
            java.lang.String r9 = java.lang.String.valueOf(r9)
            int r1 = r9.length()
            if (r1 == 0) goto L_0x008c
            java.lang.String r9 = r4.concat(r9)
            goto L_0x0091
        L_0x008c:
            java.lang.String r9 = new java.lang.String
            r9.<init>(r4)
        L_0x0091:
            android.util.Log.w(r5, r9)
            return r0
        L_0x0095:
            java.lang.String r9 = r2.group(r8)
            java.lang.String r3 = "1"
            boolean r3 = r3.equals(r9)
            if (r3 == 0) goto L_0x00a3
            r7 = 1
            goto L_0x00ab
        L_0x00a3:
            java.lang.String r3 = "2"
            boolean r3 = r3.equals(r9)
            if (r3 == 0) goto L_0x00e0
        L_0x00ab:
            java.util.Map<java.lang.String, java.lang.Integer> r9 = zzazj
            r1 = r1[r6]
            java.lang.Object r9 = r9.get(r1)
            java.lang.Integer r9 = (java.lang.Integer) r9
            if (r9 != 0) goto L_0x00d6
            java.lang.String r9 = "Unknown HEVC level string: "
            java.lang.String r1 = r2.group(r8)
            java.lang.String r1 = java.lang.String.valueOf(r1)
            int r2 = r1.length()
            if (r2 == 0) goto L_0x00cc
            java.lang.String r9 = r9.concat(r1)
            goto L_0x00d2
        L_0x00cc:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r9)
            r9 = r1
        L_0x00d2:
            android.util.Log.w(r5, r9)
            return r0
        L_0x00d6:
            android.util.Pair r0 = new android.util.Pair
            java.lang.Integer r1 = java.lang.Integer.valueOf(r7)
            r0.<init>(r1, r9)
            return r0
        L_0x00e0:
            java.lang.String r1 = "Unknown HEVC profile string: "
            java.lang.String r9 = java.lang.String.valueOf(r9)
            int r2 = r9.length()
            if (r2 == 0) goto L_0x00f1
            java.lang.String r9 = r1.concat(r9)
            goto L_0x00f6
        L_0x00f1:
            java.lang.String r9 = new java.lang.String
            r9.<init>(r1)
        L_0x00f6:
            android.util.Log.w(r5, r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkp.zzbb(java.lang.String):android.util.Pair");
    }

    /* JADX WARNING: Removed duplicated region for block: B:111:0x01b2 A[Catch:{ Exception -> 0x02ae }] */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x01fd A[Catch:{ Exception -> 0x01f8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x023a A[SYNTHETIC, Splitter:B:159:0x023a] */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0264 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x02a3 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.List<com.google.android.gms.internal.ads.zzkm> zza(com.google.android.gms.internal.ads.zzkp.zza r17, com.google.android.gms.internal.ads.zzks r18) throws com.google.android.gms.internal.ads.zzkt {
        /*
            r1 = r17
            r2 = r18
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x02ae }
            r3.<init>()     // Catch:{ Exception -> 0x02ae }
            java.lang.String r4 = r1.mimeType     // Catch:{ Exception -> 0x02ae }
            int r5 = r18.getCodecCount()     // Catch:{ Exception -> 0x02ae }
            boolean r6 = r18.zzgx()     // Catch:{ Exception -> 0x02ae }
            r8 = 0
        L_0x0014:
            if (r8 >= r5) goto L_0x02ad
            android.media.MediaCodecInfo r9 = r2.getCodecInfoAt(r8)     // Catch:{ Exception -> 0x02ae }
            java.lang.String r10 = r9.getName()     // Catch:{ Exception -> 0x02ae }
            boolean r0 = r9.isEncoder()     // Catch:{ Exception -> 0x02ae }
            java.lang.String r11 = ".secure"
            if (r0 != 0) goto L_0x01af
            if (r6 != 0) goto L_0x0030
            boolean r0 = r10.endsWith(r11)     // Catch:{ Exception -> 0x02ae }
            if (r0 == 0) goto L_0x0030
            goto L_0x01af
        L_0x0030:
            int r0 = com.google.android.gms.internal.ads.zzof.SDK_INT     // Catch:{ Exception -> 0x02ae }
            r13 = 21
            if (r0 >= r13) goto L_0x0068
            java.lang.String r0 = "CIPAACDecoder"
            boolean r0 = r0.equals(r10)     // Catch:{ Exception -> 0x02ae }
            if (r0 != 0) goto L_0x01af
            java.lang.String r0 = "CIPMP3Decoder"
            boolean r0 = r0.equals(r10)     // Catch:{ Exception -> 0x02ae }
            if (r0 != 0) goto L_0x01af
            java.lang.String r0 = "CIPVorbisDecoder"
            boolean r0 = r0.equals(r10)     // Catch:{ Exception -> 0x02ae }
            if (r0 != 0) goto L_0x01af
            java.lang.String r0 = "CIPAMRNBDecoder"
            boolean r0 = r0.equals(r10)     // Catch:{ Exception -> 0x02ae }
            if (r0 != 0) goto L_0x01af
            java.lang.String r0 = "AACDecoder"
            boolean r0 = r0.equals(r10)     // Catch:{ Exception -> 0x02ae }
            if (r0 != 0) goto L_0x01af
            java.lang.String r0 = "MP3Decoder"
            boolean r0 = r0.equals(r10)     // Catch:{ Exception -> 0x02ae }
            if (r0 == 0) goto L_0x0068
            goto L_0x01af
        L_0x0068:
            int r0 = com.google.android.gms.internal.ads.zzof.SDK_INT     // Catch:{ Exception -> 0x02ae }
            r13 = 18
            if (r0 >= r13) goto L_0x0078
            java.lang.String r0 = "OMX.SEC.MP3.Decoder"
            boolean r0 = r0.equals(r10)     // Catch:{ Exception -> 0x02ae }
            if (r0 == 0) goto L_0x0078
            goto L_0x01af
        L_0x0078:
            int r0 = com.google.android.gms.internal.ads.zzof.SDK_INT     // Catch:{ Exception -> 0x02ae }
            if (r0 >= r13) goto L_0x0090
            java.lang.String r0 = "OMX.MTK.AUDIO.DECODER.AAC"
            boolean r0 = r0.equals(r10)     // Catch:{ Exception -> 0x02ae }
            if (r0 == 0) goto L_0x0090
            java.lang.String r0 = "a70"
            java.lang.String r13 = com.google.android.gms.internal.ads.zzof.DEVICE     // Catch:{ Exception -> 0x02ae }
            boolean r0 = r0.equals(r13)     // Catch:{ Exception -> 0x02ae }
            if (r0 == 0) goto L_0x0090
            goto L_0x01af
        L_0x0090:
            int r0 = com.google.android.gms.internal.ads.zzof.SDK_INT     // Catch:{ Exception -> 0x02ae }
            r13 = 16
            if (r0 != r13) goto L_0x0118
            java.lang.String r0 = "OMX.qcom.audio.decoder.mp3"
            boolean r0 = r0.equals(r10)     // Catch:{ Exception -> 0x02ae }
            if (r0 == 0) goto L_0x0118
            java.lang.String r0 = "dlxu"
            java.lang.String r14 = com.google.android.gms.internal.ads.zzof.DEVICE     // Catch:{ Exception -> 0x02ae }
            boolean r0 = r0.equals(r14)     // Catch:{ Exception -> 0x02ae }
            if (r0 != 0) goto L_0x01af
            java.lang.String r0 = "protou"
            java.lang.String r14 = com.google.android.gms.internal.ads.zzof.DEVICE     // Catch:{ Exception -> 0x02ae }
            boolean r0 = r0.equals(r14)     // Catch:{ Exception -> 0x02ae }
            if (r0 != 0) goto L_0x01af
            java.lang.String r0 = "ville"
            java.lang.String r14 = com.google.android.gms.internal.ads.zzof.DEVICE     // Catch:{ Exception -> 0x02ae }
            boolean r0 = r0.equals(r14)     // Catch:{ Exception -> 0x02ae }
            if (r0 != 0) goto L_0x01af
            java.lang.String r0 = "villeplus"
            java.lang.String r14 = com.google.android.gms.internal.ads.zzof.DEVICE     // Catch:{ Exception -> 0x02ae }
            boolean r0 = r0.equals(r14)     // Catch:{ Exception -> 0x02ae }
            if (r0 != 0) goto L_0x01af
            java.lang.String r0 = "villec2"
            java.lang.String r14 = com.google.android.gms.internal.ads.zzof.DEVICE     // Catch:{ Exception -> 0x02ae }
            boolean r0 = r0.equals(r14)     // Catch:{ Exception -> 0x02ae }
            if (r0 != 0) goto L_0x01af
            java.lang.String r0 = com.google.android.gms.internal.ads.zzof.DEVICE     // Catch:{ Exception -> 0x02ae }
            java.lang.String r14 = "gee"
            boolean r0 = r0.startsWith(r14)     // Catch:{ Exception -> 0x02ae }
            if (r0 != 0) goto L_0x01af
            java.lang.String r0 = "C6602"
            java.lang.String r14 = com.google.android.gms.internal.ads.zzof.DEVICE     // Catch:{ Exception -> 0x02ae }
            boolean r0 = r0.equals(r14)     // Catch:{ Exception -> 0x02ae }
            if (r0 != 0) goto L_0x01af
            java.lang.String r0 = "C6603"
            java.lang.String r14 = com.google.android.gms.internal.ads.zzof.DEVICE     // Catch:{ Exception -> 0x02ae }
            boolean r0 = r0.equals(r14)     // Catch:{ Exception -> 0x02ae }
            if (r0 != 0) goto L_0x01af
            java.lang.String r0 = "C6606"
            java.lang.String r14 = com.google.android.gms.internal.ads.zzof.DEVICE     // Catch:{ Exception -> 0x02ae }
            boolean r0 = r0.equals(r14)     // Catch:{ Exception -> 0x02ae }
            if (r0 != 0) goto L_0x01af
            java.lang.String r0 = "C6616"
            java.lang.String r14 = com.google.android.gms.internal.ads.zzof.DEVICE     // Catch:{ Exception -> 0x02ae }
            boolean r0 = r0.equals(r14)     // Catch:{ Exception -> 0x02ae }
            if (r0 != 0) goto L_0x01af
            java.lang.String r0 = "L36h"
            java.lang.String r14 = com.google.android.gms.internal.ads.zzof.DEVICE     // Catch:{ Exception -> 0x02ae }
            boolean r0 = r0.equals(r14)     // Catch:{ Exception -> 0x02ae }
            if (r0 != 0) goto L_0x01af
            java.lang.String r0 = "SO-02E"
            java.lang.String r14 = com.google.android.gms.internal.ads.zzof.DEVICE     // Catch:{ Exception -> 0x02ae }
            boolean r0 = r0.equals(r14)     // Catch:{ Exception -> 0x02ae }
            if (r0 == 0) goto L_0x0118
            goto L_0x01af
        L_0x0118:
            int r0 = com.google.android.gms.internal.ads.zzof.SDK_INT     // Catch:{ Exception -> 0x02ae }
            if (r0 != r13) goto L_0x014d
            java.lang.String r0 = "OMX.qcom.audio.decoder.aac"
            boolean r0 = r0.equals(r10)     // Catch:{ Exception -> 0x02ae }
            if (r0 == 0) goto L_0x014d
            java.lang.String r0 = "C1504"
            java.lang.String r13 = com.google.android.gms.internal.ads.zzof.DEVICE     // Catch:{ Exception -> 0x02ae }
            boolean r0 = r0.equals(r13)     // Catch:{ Exception -> 0x02ae }
            if (r0 != 0) goto L_0x01af
            java.lang.String r0 = "C1505"
            java.lang.String r13 = com.google.android.gms.internal.ads.zzof.DEVICE     // Catch:{ Exception -> 0x02ae }
            boolean r0 = r0.equals(r13)     // Catch:{ Exception -> 0x02ae }
            if (r0 != 0) goto L_0x01af
            java.lang.String r0 = "C1604"
            java.lang.String r13 = com.google.android.gms.internal.ads.zzof.DEVICE     // Catch:{ Exception -> 0x02ae }
            boolean r0 = r0.equals(r13)     // Catch:{ Exception -> 0x02ae }
            if (r0 != 0) goto L_0x01af
            java.lang.String r0 = "C1605"
            java.lang.String r13 = com.google.android.gms.internal.ads.zzof.DEVICE     // Catch:{ Exception -> 0x02ae }
            boolean r0 = r0.equals(r13)     // Catch:{ Exception -> 0x02ae }
            if (r0 == 0) goto L_0x014d
            goto L_0x01af
        L_0x014d:
            int r0 = com.google.android.gms.internal.ads.zzof.SDK_INT     // Catch:{ Exception -> 0x02ae }
            java.lang.String r13 = "jflte"
            r14 = 19
            if (r0 > r14) goto L_0x0198
            java.lang.String r0 = "OMX.SEC.vp8.dec"
            boolean r0 = r0.equals(r10)     // Catch:{ Exception -> 0x02ae }
            if (r0 == 0) goto L_0x0198
            java.lang.String r0 = "samsung"
            java.lang.String r15 = com.google.android.gms.internal.ads.zzof.MANUFACTURER     // Catch:{ Exception -> 0x02ae }
            boolean r0 = r0.equals(r15)     // Catch:{ Exception -> 0x02ae }
            if (r0 == 0) goto L_0x0198
            java.lang.String r0 = com.google.android.gms.internal.ads.zzof.DEVICE     // Catch:{ Exception -> 0x02ae }
            java.lang.String r15 = "d2"
            boolean r0 = r0.startsWith(r15)     // Catch:{ Exception -> 0x02ae }
            if (r0 != 0) goto L_0x01af
            java.lang.String r0 = com.google.android.gms.internal.ads.zzof.DEVICE     // Catch:{ Exception -> 0x02ae }
            java.lang.String r15 = "serrano"
            boolean r0 = r0.startsWith(r15)     // Catch:{ Exception -> 0x02ae }
            if (r0 != 0) goto L_0x01af
            java.lang.String r0 = com.google.android.gms.internal.ads.zzof.DEVICE     // Catch:{ Exception -> 0x02ae }
            boolean r0 = r0.startsWith(r13)     // Catch:{ Exception -> 0x02ae }
            if (r0 != 0) goto L_0x01af
            java.lang.String r0 = com.google.android.gms.internal.ads.zzof.DEVICE     // Catch:{ Exception -> 0x02ae }
            java.lang.String r15 = "santos"
            boolean r0 = r0.startsWith(r15)     // Catch:{ Exception -> 0x02ae }
            if (r0 != 0) goto L_0x01af
            java.lang.String r0 = com.google.android.gms.internal.ads.zzof.DEVICE     // Catch:{ Exception -> 0x02ae }
            java.lang.String r15 = "t0"
            boolean r0 = r0.startsWith(r15)     // Catch:{ Exception -> 0x02ae }
            if (r0 == 0) goto L_0x0198
            goto L_0x01af
        L_0x0198:
            int r0 = com.google.android.gms.internal.ads.zzof.SDK_INT     // Catch:{ Exception -> 0x02ae }
            if (r0 > r14) goto L_0x01ad
            java.lang.String r0 = com.google.android.gms.internal.ads.zzof.DEVICE     // Catch:{ Exception -> 0x02ae }
            boolean r0 = r0.startsWith(r13)     // Catch:{ Exception -> 0x02ae }
            if (r0 == 0) goto L_0x01ad
            java.lang.String r0 = "OMX.qcom.video.decoder.vp8"
            boolean r0 = r0.equals(r10)     // Catch:{ Exception -> 0x02ae }
            if (r0 == 0) goto L_0x01ad
            goto L_0x01af
        L_0x01ad:
            r0 = 1
            goto L_0x01b0
        L_0x01af:
            r0 = 0
        L_0x01b0:
            if (r0 == 0) goto L_0x02a3
            java.lang.String[] r13 = r9.getSupportedTypes()     // Catch:{ Exception -> 0x02ae }
            int r14 = r13.length     // Catch:{ Exception -> 0x02ae }
            r15 = 0
        L_0x01b8:
            if (r15 >= r14) goto L_0x02a3
            r12 = r13[r15]     // Catch:{ Exception -> 0x02ae }
            boolean r0 = r12.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x02ae }
            if (r0 == 0) goto L_0x0299
            android.media.MediaCodecInfo$CodecCapabilities r0 = r9.getCapabilitiesForType(r12)     // Catch:{ Exception -> 0x022e }
            boolean r7 = r2.zza(r4, r0)     // Catch:{ Exception -> 0x022e }
            int r2 = com.google.android.gms.internal.ads.zzof.SDK_INT     // Catch:{ Exception -> 0x022e }
            r16 = r5
            r5 = 22
            if (r2 > r5) goto L_0x01fa
            java.lang.String r2 = com.google.android.gms.internal.ads.zzof.MODEL     // Catch:{ Exception -> 0x01f8 }
            java.lang.String r5 = "ODROID-XU3"
            boolean r2 = r2.equals(r5)     // Catch:{ Exception -> 0x01f8 }
            if (r2 != 0) goto L_0x01e6
            java.lang.String r2 = com.google.android.gms.internal.ads.zzof.MODEL     // Catch:{ Exception -> 0x01f8 }
            java.lang.String r5 = "Nexus 10"
            boolean r2 = r2.equals(r5)     // Catch:{ Exception -> 0x01f8 }
            if (r2 == 0) goto L_0x01fa
        L_0x01e6:
            java.lang.String r2 = "OMX.Exynos.AVC.Decoder"
            boolean r2 = r2.equals(r10)     // Catch:{ Exception -> 0x01f8 }
            if (r2 != 0) goto L_0x01f6
            java.lang.String r2 = "OMX.Exynos.AVC.Decoder.secure"
            boolean r2 = r2.equals(r10)     // Catch:{ Exception -> 0x01f8 }
            if (r2 == 0) goto L_0x01fa
        L_0x01f6:
            r2 = 1
            goto L_0x01fb
        L_0x01f8:
            r0 = move-exception
            goto L_0x0231
        L_0x01fa:
            r2 = 0
        L_0x01fb:
            if (r6 == 0) goto L_0x0204
            boolean r5 = r1.zzayy     // Catch:{ Exception -> 0x01f8 }
            if (r5 == r7) goto L_0x0202
            goto L_0x0204
        L_0x0202:
            r5 = 0
            goto L_0x020b
        L_0x0204:
            if (r6 != 0) goto L_0x0214
            boolean r5 = r1.zzayy     // Catch:{ Exception -> 0x01f8 }
            if (r5 != 0) goto L_0x0214
            goto L_0x0202
        L_0x020b:
            com.google.android.gms.internal.ads.zzkm r0 = com.google.android.gms.internal.ads.zzkm.zza(r10, r4, r0, r2, r5)     // Catch:{ Exception -> 0x01f8 }
            r3.add(r0)     // Catch:{ Exception -> 0x01f8 }
            goto L_0x029b
        L_0x0214:
            r5 = 0
            if (r6 != 0) goto L_0x022c
            if (r7 == 0) goto L_0x022c
            java.lang.String r7 = java.lang.String.valueOf(r10)     // Catch:{ Exception -> 0x01f8 }
            java.lang.String r7 = r7.concat(r11)     // Catch:{ Exception -> 0x01f8 }
            r5 = 1
            com.google.android.gms.internal.ads.zzkm r0 = com.google.android.gms.internal.ads.zzkm.zza(r7, r4, r0, r2, r5)     // Catch:{ Exception -> 0x022a }
            r3.add(r0)     // Catch:{ Exception -> 0x022a }
            return r3
        L_0x022a:
            r0 = move-exception
            goto L_0x0232
        L_0x022c:
            r5 = 1
            goto L_0x029b
        L_0x022e:
            r0 = move-exception
            r16 = r5
        L_0x0231:
            r5 = 1
        L_0x0232:
            int r2 = com.google.android.gms.internal.ads.zzof.SDK_INT     // Catch:{ Exception -> 0x02ae }
            r7 = 23
            java.lang.String r5 = "MediaCodecUtil"
            if (r2 > r7) goto L_0x0264
            boolean r2 = r3.isEmpty()     // Catch:{ Exception -> 0x02ae }
            if (r2 != 0) goto L_0x0264
            java.lang.String r0 = java.lang.String.valueOf(r10)     // Catch:{ Exception -> 0x02ae }
            int r0 = r0.length()     // Catch:{ Exception -> 0x02ae }
            int r0 = r0 + 46
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02ae }
            r2.<init>(r0)     // Catch:{ Exception -> 0x02ae }
            java.lang.String r0 = "Skipping codec "
            r2.append(r0)     // Catch:{ Exception -> 0x02ae }
            r2.append(r10)     // Catch:{ Exception -> 0x02ae }
            java.lang.String r0 = " (failed to query capabilities)"
            r2.append(r0)     // Catch:{ Exception -> 0x02ae }
            java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x02ae }
            android.util.Log.e(r5, r0)     // Catch:{ Exception -> 0x02ae }
            goto L_0x029b
        L_0x0264:
            java.lang.String r1 = java.lang.String.valueOf(r10)     // Catch:{ Exception -> 0x02ae }
            int r1 = r1.length()     // Catch:{ Exception -> 0x02ae }
            int r1 = r1 + 25
            java.lang.String r2 = java.lang.String.valueOf(r12)     // Catch:{ Exception -> 0x02ae }
            int r2 = r2.length()     // Catch:{ Exception -> 0x02ae }
            int r1 = r1 + r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02ae }
            r2.<init>(r1)     // Catch:{ Exception -> 0x02ae }
            java.lang.String r1 = "Failed to query codec "
            r2.append(r1)     // Catch:{ Exception -> 0x02ae }
            r2.append(r10)     // Catch:{ Exception -> 0x02ae }
            java.lang.String r1 = " ("
            r2.append(r1)     // Catch:{ Exception -> 0x02ae }
            r2.append(r12)     // Catch:{ Exception -> 0x02ae }
            java.lang.String r1 = ")"
            r2.append(r1)     // Catch:{ Exception -> 0x02ae }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x02ae }
            android.util.Log.e(r5, r1)     // Catch:{ Exception -> 0x02ae }
            throw r0     // Catch:{ Exception -> 0x02ae }
        L_0x0299:
            r16 = r5
        L_0x029b:
            int r15 = r15 + 1
            r2 = r18
            r5 = r16
            goto L_0x01b8
        L_0x02a3:
            r16 = r5
            int r8 = r8 + 1
            r2 = r18
            r5 = r16
            goto L_0x0014
        L_0x02ad:
            return r3
        L_0x02ae:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzkt r1 = new com.google.android.gms.internal.ads.zzkt
            r2 = 0
            r1.<init>(r0)
            throw r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkp.zza(com.google.android.gms.internal.ads.zzkp$zza, com.google.android.gms.internal.ads.zzks):java.util.List");
    }

    private static Pair<Integer, Integer> zza(String str, String[] strArr) {
        Integer num;
        Integer num2;
        String str2 = "Ignoring malformed AVC codec string: ";
        String str3 = "MediaCodecUtil";
        if (strArr.length < 2) {
            String valueOf = String.valueOf(str);
            Log.w(str3, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            return null;
        }
        try {
            if (strArr[1].length() == 6) {
                Integer valueOf2 = Integer.valueOf(Integer.parseInt(strArr[1].substring(0, 2), 16));
                num = Integer.valueOf(Integer.parseInt(strArr[1].substring(4), 16));
                num2 = valueOf2;
            } else if (strArr.length >= 3) {
                num2 = Integer.valueOf(Integer.parseInt(strArr[1]));
                num = Integer.valueOf(Integer.parseInt(strArr[2]));
            } else {
                String valueOf3 = String.valueOf(str);
                Log.w(str3, valueOf3.length() != 0 ? str2.concat(valueOf3) : new String(str2));
                return null;
            }
            Integer valueOf4 = Integer.valueOf(zzazh.get(num2.intValue()));
            if (valueOf4 == null) {
                String valueOf5 = String.valueOf(num2);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf5).length() + 21);
                sb.append("Unknown AVC profile: ");
                sb.append(valueOf5);
                Log.w(str3, sb.toString());
                return null;
            }
            Integer valueOf6 = Integer.valueOf(zzazi.get(num.intValue()));
            if (valueOf6 != null) {
                return new Pair<>(valueOf4, valueOf6);
            }
            String valueOf7 = String.valueOf(num);
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf7).length() + 19);
            sb2.append("Unknown AVC level: ");
            sb2.append(valueOf7);
            Log.w(str3, sb2.toString());
            return null;
        } catch (NumberFormatException unused) {
            String valueOf8 = String.valueOf(str);
            Log.w(str3, valueOf8.length() != 0 ? str2.concat(valueOf8) : new String(str2));
            return null;
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        zzazh = sparseIntArray;
        sparseIntArray.put(66, 1);
        zzazh.put(77, 2);
        zzazh.put(88, 4);
        zzazh.put(100, 8);
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        zzazi = sparseIntArray2;
        sparseIntArray2.put(10, 1);
        zzazi.put(11, 4);
        zzazi.put(12, 8);
        zzazi.put(13, 16);
        zzazi.put(20, 32);
        zzazi.put(21, 64);
        zzazi.put(22, 128);
        zzazi.put(30, 256);
        zzazi.put(31, 512);
        zzazi.put(32, 1024);
        zzazi.put(40, 2048);
        zzazi.put(41, 4096);
        zzazi.put(42, 8192);
        zzazi.put(50, 16384);
        zzazi.put(51, 32768);
        zzazi.put(52, 65536);
        HashMap hashMap = new HashMap();
        zzazj = hashMap;
        hashMap.put("L30", Integer.valueOf(1));
        zzazj.put("L60", Integer.valueOf(4));
        zzazj.put("L63", Integer.valueOf(16));
        zzazj.put("L90", Integer.valueOf(64));
        zzazj.put("L93", Integer.valueOf(256));
        zzazj.put("L120", Integer.valueOf(1024));
        zzazj.put("L123", Integer.valueOf(4096));
        zzazj.put("L150", Integer.valueOf(16384));
        zzazj.put("L153", Integer.valueOf(65536));
        zzazj.put("L156", Integer.valueOf(262144));
        zzazj.put("L180", Integer.valueOf(1048576));
        zzazj.put("L183", Integer.valueOf(4194304));
        zzazj.put("L186", Integer.valueOf(16777216));
        zzazj.put("H30", Integer.valueOf(2));
        zzazj.put("H60", Integer.valueOf(8));
        zzazj.put("H63", Integer.valueOf(32));
        zzazj.put("H90", Integer.valueOf(128));
        zzazj.put("H93", Integer.valueOf(512));
        zzazj.put("H120", Integer.valueOf(2048));
        zzazj.put("H123", Integer.valueOf(8192));
        zzazj.put("H150", Integer.valueOf(32768));
        zzazj.put("H153", Integer.valueOf(131072));
        zzazj.put("H156", Integer.valueOf(524288));
        zzazj.put("H180", Integer.valueOf(2097152));
        zzazj.put("H183", Integer.valueOf(8388608));
        zzazj.put("H186", Integer.valueOf(33554432));
    }
}
