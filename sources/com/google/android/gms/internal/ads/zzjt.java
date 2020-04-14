package com.google.android.gms.internal.ads;

import android.util.Pair;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.internal.ads.zzkx.zza;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzjt {
    private static final int zzaty = zzof.zzbi("meta");
    private static final int zzaum = zzof.zzbi("vide");
    private static final int zzaun = zzof.zzbi("soun");
    private static final int zzauo = zzof.zzbi(ViewHierarchyConstants.TEXT_KEY);
    private static final int zzaup = zzof.zzbi("sbtl");
    private static final int zzauq = zzof.zzbi("subt");
    private static final int zzaur = zzof.zzbi("clcp");
    private static final int zzaus = zzof.zzbi("cenc");

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00a3, code lost:
        if (r14 == 0) goto L_0x0093;
     */
    /* JADX WARNING: Removed duplicated region for block: B:388:0x06ee A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:389:0x06ef  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzkh zza(com.google.android.gms.internal.ads.zzjr r43, com.google.android.gms.internal.ads.zzju r44, long r45, com.google.android.gms.internal.ads.zzin r47, boolean r48) throws com.google.android.gms.internal.ads.zzgv {
        /*
            r0 = r43
            int r1 = com.google.android.gms.internal.ads.zzjs.zzasb
            com.google.android.gms.internal.ads.zzjr r1 = r0.zzal(r1)
            int r2 = com.google.android.gms.internal.ads.zzjs.zzasp
            com.google.android.gms.internal.ads.zzju r2 = r1.zzak(r2)
            com.google.android.gms.internal.ads.zzoc r2 = r2.zzaut
            r3 = 16
            r2.zzbg(r3)
            int r2 = r2.readInt()
            int r4 = zzaun
            r5 = 4
            r6 = 3
            r8 = -1
            if (r2 != r4) goto L_0x0022
            r12 = 1
            goto L_0x0042
        L_0x0022:
            int r4 = zzaum
            if (r2 != r4) goto L_0x0028
            r12 = 2
            goto L_0x0042
        L_0x0028:
            int r4 = zzauo
            if (r2 == r4) goto L_0x0041
            int r4 = zzaup
            if (r2 == r4) goto L_0x0041
            int r4 = zzauq
            if (r2 == r4) goto L_0x0041
            int r4 = zzaur
            if (r2 != r4) goto L_0x0039
            goto L_0x0041
        L_0x0039:
            int r4 = zzaty
            if (r2 != r4) goto L_0x003f
            r12 = 4
            goto L_0x0042
        L_0x003f:
            r12 = -1
            goto L_0x0042
        L_0x0041:
            r12 = 3
        L_0x0042:
            r2 = 0
            if (r12 != r8) goto L_0x0046
            return r2
        L_0x0046:
            int r4 = com.google.android.gms.internal.ads.zzjs.zzasl
            com.google.android.gms.internal.ads.zzju r4 = r0.zzak(r4)
            com.google.android.gms.internal.ads.zzoc r4 = r4.zzaut
            r10 = 8
            r4.zzbg(r10)
            int r11 = r4.readInt()
            int r11 = com.google.android.gms.internal.ads.zzjs.zzam(r11)
            if (r11 != 0) goto L_0x0060
            r13 = 8
            goto L_0x0062
        L_0x0060:
            r13 = 16
        L_0x0062:
            r4.zzbh(r13)
            int r13 = r4.readInt()
            r4.zzbh(r5)
            int r14 = r4.getPosition()
            if (r11 != 0) goto L_0x0074
            r15 = 4
            goto L_0x0076
        L_0x0074:
            r15 = 8
        L_0x0076:
            r9 = 0
        L_0x0077:
            if (r9 >= r15) goto L_0x0086
            byte[] r7 = r4.data
            int r16 = r14 + r9
            byte r7 = r7[r16]
            if (r7 == r8) goto L_0x0083
            r7 = 0
            goto L_0x0087
        L_0x0083:
            int r9 = r9 + 1
            goto L_0x0077
        L_0x0086:
            r7 = 1
        L_0x0087:
            r16 = 0
            r18 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r7 == 0) goto L_0x0096
            r4.zzbh(r15)
        L_0x0093:
            r14 = r18
            goto L_0x00a6
        L_0x0096:
            if (r11 != 0) goto L_0x009d
            long r14 = r4.zzio()
            goto L_0x00a1
        L_0x009d:
            long r14 = r4.zzis()
        L_0x00a1:
            int r7 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r7 != 0) goto L_0x00a6
            goto L_0x0093
        L_0x00a6:
            r4.zzbh(r3)
            int r7 = r4.readInt()
            int r9 = r4.readInt()
            r4.zzbh(r5)
            int r11 = r4.readInt()
            int r4 = r4.readInt()
            r5 = -65536(0xffffffffffff0000, float:NaN)
            if (r7 != 0) goto L_0x00cb
            r3 = 65536(0x10000, float:9.18355E-41)
            if (r9 != r3) goto L_0x00cb
            if (r11 != r5) goto L_0x00cb
            if (r4 != 0) goto L_0x00cb
            r7 = 90
            goto L_0x00e4
        L_0x00cb:
            if (r7 != 0) goto L_0x00d8
            if (r9 != r5) goto L_0x00d8
            r3 = 65536(0x10000, float:9.18355E-41)
            if (r11 != r3) goto L_0x00d8
            if (r4 != 0) goto L_0x00d8
            r7 = 270(0x10e, float:3.78E-43)
            goto L_0x00e4
        L_0x00d8:
            if (r7 != r5) goto L_0x00e3
            if (r9 != 0) goto L_0x00e3
            if (r11 != 0) goto L_0x00e3
            if (r4 != r5) goto L_0x00e3
            r7 = 180(0xb4, float:2.52E-43)
            goto L_0x00e4
        L_0x00e3:
            r7 = 0
        L_0x00e4:
            com.google.android.gms.internal.ads.zzjz r3 = new com.google.android.gms.internal.ads.zzjz
            r3.<init>(r13, r14, r7)
            long r22 = r3.zzcu
            r4 = r44
            com.google.android.gms.internal.ads.zzoc r4 = r4.zzaut
            r4.zzbg(r10)
            int r5 = r4.readInt()
            int r5 = com.google.android.gms.internal.ads.zzjs.zzam(r5)
            if (r5 != 0) goto L_0x0101
            r5 = 8
            goto L_0x0103
        L_0x0101:
            r5 = 16
        L_0x0103:
            r4.zzbh(r5)
            long r4 = r4.zzio()
            int r7 = (r22 > r18 ? 1 : (r22 == r18 ? 0 : -1))
            if (r7 != 0) goto L_0x010f
            goto L_0x011a
        L_0x010f:
            r24 = 1000000(0xf4240, double:4.940656E-318)
            r26 = r4
            long r13 = com.google.android.gms.internal.ads.zzof.zza(r22, r24, r26)
            r18 = r13
        L_0x011a:
            int r7 = com.google.android.gms.internal.ads.zzjs.zzasc
            com.google.android.gms.internal.ads.zzjr r7 = r1.zzal(r7)
            int r9 = com.google.android.gms.internal.ads.zzjs.zzasd
            com.google.android.gms.internal.ads.zzjr r7 = r7.zzal(r9)
            int r9 = com.google.android.gms.internal.ads.zzjs.zzaso
            com.google.android.gms.internal.ads.zzju r1 = r1.zzak(r9)
            com.google.android.gms.internal.ads.zzoc r1 = r1.zzaut
            r1.zzbg(r10)
            int r9 = r1.readInt()
            int r9 = com.google.android.gms.internal.ads.zzjs.zzam(r9)
            if (r9 != 0) goto L_0x013e
            r11 = 8
            goto L_0x0140
        L_0x013e:
            r11 = 16
        L_0x0140:
            r1.zzbh(r11)
            long r13 = r1.zzio()
            if (r9 != 0) goto L_0x014b
            r9 = 4
            goto L_0x014d
        L_0x014b:
            r9 = 8
        L_0x014d:
            r1.zzbh(r9)
            int r1 = r1.readUnsignedShort()
            int r9 = r1 >> 10
            r9 = r9 & 31
            int r9 = r9 + 96
            char r9 = (char) r9
            int r11 = r1 >> 5
            r11 = r11 & 31
            int r11 = r11 + 96
            char r11 = (char) r11
            r1 = r1 & 31
            int r1 = r1 + 96
            char r1 = (char) r1
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>(r6)
            r15.append(r9)
            r15.append(r11)
            r15.append(r1)
            java.lang.String r1 = r15.toString()
            java.lang.Long r9 = java.lang.Long.valueOf(r13)
            android.util.Pair r1 = android.util.Pair.create(r9, r1)
            int r9 = com.google.android.gms.internal.ads.zzjs.zzasq
            com.google.android.gms.internal.ads.zzju r7 = r7.zzak(r9)
            com.google.android.gms.internal.ads.zzoc r7 = r7.zzaut
            int r9 = r3.f3920id
            int r11 = r3.zzafh
            java.lang.Object r13 = r1.second
            java.lang.String r13 = (java.lang.String) r13
            r14 = 12
            r7.zzbg(r14)
            int r14 = r7.readInt()
            com.google.android.gms.internal.ads.zzjy r15 = new com.google.android.gms.internal.ads.zzjy
            r15.<init>(r14)
            r6 = 0
        L_0x01a4:
            if (r6 >= r14) goto L_0x0678
            int r10 = r7.getPosition()
            int r2 = r7.readInt()
            if (r2 <= 0) goto L_0x01b4
            r44 = r14
            r8 = 1
            goto L_0x01b7
        L_0x01b4:
            r44 = r14
            r8 = 0
        L_0x01b7:
            java.lang.String r14 = "childAtomSize should be positive"
            com.google.android.gms.internal.ads.zznr.checkArgument(r8, r14)
            int r8 = r7.readInt()
            r37 = r4
            int r4 = com.google.android.gms.internal.ads.zzjs.zzaqy
            if (r8 == r4) goto L_0x04c9
            int r4 = com.google.android.gms.internal.ads.zzjs.zzaqz
            if (r8 == r4) goto L_0x04c9
            int r4 = com.google.android.gms.internal.ads.zzjs.zzasw
            if (r8 == r4) goto L_0x04c9
            int r4 = com.google.android.gms.internal.ads.zzjs.zzati
            if (r8 == r4) goto L_0x04c9
            int r4 = com.google.android.gms.internal.ads.zzjs.zzara
            if (r8 == r4) goto L_0x04c9
            int r4 = com.google.android.gms.internal.ads.zzjs.zzarb
            if (r8 == r4) goto L_0x04c9
            int r4 = com.google.android.gms.internal.ads.zzjs.zzarc
            if (r8 == r4) goto L_0x04c9
            int r4 = com.google.android.gms.internal.ads.zzjs.zzauh
            if (r8 == r4) goto L_0x04c9
            int r4 = com.google.android.gms.internal.ads.zzjs.zzaui
            if (r8 != r4) goto L_0x01e8
            goto L_0x04c9
        L_0x01e8:
            int r4 = com.google.android.gms.internal.ads.zzjs.zzarf
            if (r8 == r4) goto L_0x02ba
            int r4 = com.google.android.gms.internal.ads.zzjs.zzasx
            if (r8 == r4) goto L_0x02ba
            int r4 = com.google.android.gms.internal.ads.zzjs.zzark
            if (r8 == r4) goto L_0x02ba
            int r4 = com.google.android.gms.internal.ads.zzjs.zzarm
            if (r8 == r4) goto L_0x02ba
            int r4 = com.google.android.gms.internal.ads.zzjs.zzaro
            if (r8 == r4) goto L_0x02ba
            int r4 = com.google.android.gms.internal.ads.zzjs.zzarr
            if (r8 == r4) goto L_0x02ba
            int r4 = com.google.android.gms.internal.ads.zzjs.zzarp
            if (r8 == r4) goto L_0x02ba
            int r4 = com.google.android.gms.internal.ads.zzjs.zzarq
            if (r8 == r4) goto L_0x02ba
            int r4 = com.google.android.gms.internal.ads.zzjs.zzatv
            if (r8 == r4) goto L_0x02ba
            int r4 = com.google.android.gms.internal.ads.zzjs.zzatw
            if (r8 == r4) goto L_0x02ba
            int r4 = com.google.android.gms.internal.ads.zzjs.zzari
            if (r8 == r4) goto L_0x02ba
            int r4 = com.google.android.gms.internal.ads.zzjs.zzarj
            if (r8 == r4) goto L_0x02ba
            int r4 = com.google.android.gms.internal.ads.zzjs.zzarg
            if (r8 == r4) goto L_0x02ba
            int r4 = com.google.android.gms.internal.ads.zzjs.zzaul
            if (r8 != r4) goto L_0x0222
            goto L_0x02ba
        L_0x0222:
            int r4 = com.google.android.gms.internal.ads.zzjs.zzatg
            if (r8 == r4) goto L_0x024b
            int r4 = com.google.android.gms.internal.ads.zzjs.zzatr
            if (r8 == r4) goto L_0x024b
            int r4 = com.google.android.gms.internal.ads.zzjs.zzats
            if (r8 == r4) goto L_0x024b
            int r4 = com.google.android.gms.internal.ads.zzjs.zzatt
            if (r8 == r4) goto L_0x024b
            int r4 = com.google.android.gms.internal.ads.zzjs.zzatu
            if (r8 != r4) goto L_0x0237
            goto L_0x024b
        L_0x0237:
            int r4 = com.google.android.gms.internal.ads.zzjs.zzauk
            if (r8 != r4) goto L_0x02fa
            java.lang.String r4 = java.lang.Integer.toString(r9)
            java.lang.String r5 = "application/x-camera-motion"
            r8 = -1
            r14 = 0
            com.google.android.gms.internal.ads.zzgo r4 = com.google.android.gms.internal.ads.zzgo.zza(r4, r5, r14, r8, r14)
            r15.zzafx = r4
            goto L_0x02fa
        L_0x024b:
            int r4 = r10 + 8
            r5 = 8
            int r4 = r4 + r5
            r7.zzbg(r4)
            r22 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r4 = com.google.android.gms.internal.ads.zzjs.zzatg
            if (r8 != r4) goto L_0x0265
            java.lang.String r4 = "application/ttml+xml"
        L_0x025e:
            r30 = r22
            r32 = 0
            r23 = r4
            goto L_0x029d
        L_0x0265:
            int r4 = com.google.android.gms.internal.ads.zzjs.zzatr
            if (r8 != r4) goto L_0x027f
            int r4 = r2 + -8
            int r4 = r4 - r5
            byte[] r5 = new byte[r4]
            r8 = 0
            r7.zze(r5, r8, r4)
            java.util.List r4 = java.util.Collections.singletonList(r5)
            java.lang.String r5 = "application/x-quicktime-tx3g"
            r32 = r4
            r30 = r22
            r23 = r5
            goto L_0x029d
        L_0x027f:
            int r4 = com.google.android.gms.internal.ads.zzjs.zzats
            if (r8 != r4) goto L_0x0286
            java.lang.String r4 = "application/x-mp4-vtt"
            goto L_0x025e
        L_0x0286:
            int r4 = com.google.android.gms.internal.ads.zzjs.zzatt
            if (r8 != r4) goto L_0x0293
            java.lang.String r4 = "application/ttml+xml"
            r23 = r4
            r30 = r16
            r32 = 0
            goto L_0x029d
        L_0x0293:
            int r4 = com.google.android.gms.internal.ads.zzjs.zzatu
            if (r8 != r4) goto L_0x02b4
            r4 = 1
            r15.zzave = r4
            java.lang.String r4 = "application/x-mp4-cea-608"
            goto L_0x025e
        L_0x029d:
            java.lang.String r22 = java.lang.Integer.toString(r9)
            r24 = 0
            r25 = -1
            r26 = 0
            r28 = -1
            r29 = 0
            r27 = r13
            com.google.android.gms.internal.ads.zzgo r4 = com.google.android.gms.internal.ads.zzgo.zza(r22, r23, r24, r25, r26, r27, r28, r29, r30, r32)
            r15.zzafx = r4
            goto L_0x02fa
        L_0x02b4:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>()
            throw r0
        L_0x02ba:
            int r4 = r10 + 8
            r5 = 8
            int r4 = r4 + r5
            r7.zzbg(r4)
            if (r48 == 0) goto L_0x02cd
            int r4 = r7.readUnsignedShort()
            r5 = 6
            r7.zzbh(r5)
            goto L_0x02d3
        L_0x02cd:
            r4 = 8
            r7.zzbh(r4)
            r4 = 0
        L_0x02d3:
            if (r4 == 0) goto L_0x0305
            r5 = 1
            if (r4 != r5) goto L_0x02d9
            goto L_0x0305
        L_0x02d9:
            r5 = 2
            if (r4 != r5) goto L_0x02fa
            r4 = 16
            r7.zzbh(r4)
            long r4 = r7.readLong()
            double r4 = java.lang.Double.longBitsToDouble(r4)
            long r4 = java.lang.Math.round(r4)
            int r5 = (int) r4
            int r4 = r7.zzir()
            r22 = r4
            r4 = 20
            r7.zzbh(r4)
            goto L_0x031f
        L_0x02fa:
            r40 = r1
            r41 = r3
            r42 = r11
            r39 = r12
        L_0x0302:
            r1 = 3
            goto L_0x065e
        L_0x0305:
            int r5 = r7.readUnsignedShort()
            r22 = r5
            r5 = 6
            r7.zzbh(r5)
            int r5 = r7.zziq()
            r23 = r5
            r5 = 1
            if (r4 != r5) goto L_0x031d
            r4 = 16
            r7.zzbh(r4)
        L_0x031d:
            r5 = r23
        L_0x031f:
            int r4 = r7.getPosition()
            r23 = r5
            int r5 = com.google.android.gms.internal.ads.zzjs.zzasx
            if (r8 != r5) goto L_0x0330
            int r8 = zza(r7, r10, r2, r15, r6)
            r7.zzbg(r4)
        L_0x0330:
            int r5 = com.google.android.gms.internal.ads.zzjs.zzark
            if (r8 != r5) goto L_0x0337
            java.lang.String r5 = "audio/ac3"
            goto L_0x0381
        L_0x0337:
            int r5 = com.google.android.gms.internal.ads.zzjs.zzarm
            if (r8 != r5) goto L_0x033e
            java.lang.String r5 = "audio/eac3"
            goto L_0x0381
        L_0x033e:
            int r5 = com.google.android.gms.internal.ads.zzjs.zzaro
            if (r8 != r5) goto L_0x0345
            java.lang.String r5 = "audio/vnd.dts"
            goto L_0x0381
        L_0x0345:
            int r5 = com.google.android.gms.internal.ads.zzjs.zzarp
            if (r8 == r5) goto L_0x037f
            int r5 = com.google.android.gms.internal.ads.zzjs.zzarq
            if (r8 != r5) goto L_0x034e
            goto L_0x037f
        L_0x034e:
            int r5 = com.google.android.gms.internal.ads.zzjs.zzarr
            if (r8 != r5) goto L_0x0355
            java.lang.String r5 = "audio/vnd.dts.hd;profile=lbr"
            goto L_0x0381
        L_0x0355:
            int r5 = com.google.android.gms.internal.ads.zzjs.zzatv
            if (r8 != r5) goto L_0x035c
            java.lang.String r5 = "audio/3gpp"
            goto L_0x0381
        L_0x035c:
            int r5 = com.google.android.gms.internal.ads.zzjs.zzatw
            if (r8 != r5) goto L_0x0363
            java.lang.String r5 = "audio/amr-wb"
            goto L_0x0381
        L_0x0363:
            int r5 = com.google.android.gms.internal.ads.zzjs.zzari
            if (r8 == r5) goto L_0x037c
            int r5 = com.google.android.gms.internal.ads.zzjs.zzarj
            if (r8 != r5) goto L_0x036c
            goto L_0x037c
        L_0x036c:
            int r5 = com.google.android.gms.internal.ads.zzjs.zzarg
            if (r8 != r5) goto L_0x0373
            java.lang.String r5 = "audio/mpeg"
            goto L_0x0381
        L_0x0373:
            int r5 = com.google.android.gms.internal.ads.zzjs.zzaul
            if (r8 != r5) goto L_0x037a
            java.lang.String r5 = "audio/alac"
            goto L_0x0381
        L_0x037a:
            r5 = 0
            goto L_0x0381
        L_0x037c:
            java.lang.String r5 = "audio/raw"
            goto L_0x0381
        L_0x037f:
            java.lang.String r5 = "audio/vnd.dts.hd"
        L_0x0381:
            r8 = r4
            r39 = r12
            r4 = r22
            r33 = r23
            r34 = 0
        L_0x038a:
            int r12 = r8 - r10
            if (r12 >= r2) goto L_0x0486
            r7.zzbg(r8)
            int r12 = r7.readInt()
            if (r12 <= 0) goto L_0x039b
            r40 = r1
            r1 = 1
            goto L_0x039e
        L_0x039b:
            r40 = r1
            r1 = 0
        L_0x039e:
            com.google.android.gms.internal.ads.zznr.checkArgument(r1, r14)
            int r1 = r7.readInt()
            r41 = r3
            int r3 = com.google.android.gms.internal.ads.zzjs.zzasg
            if (r1 == r3) goto L_0x0414
            if (r48 == 0) goto L_0x03b2
            int r3 = com.google.android.gms.internal.ads.zzjs.zzarh
            if (r1 != r3) goto L_0x03b2
            goto L_0x0414
        L_0x03b2:
            int r3 = com.google.android.gms.internal.ads.zzjs.zzarl
            if (r1 != r3) goto L_0x03c8
            int r1 = r8 + 8
            r7.zzbg(r1)
            java.lang.String r1 = java.lang.Integer.toString(r9)
            r3 = 0
            com.google.android.gms.internal.ads.zzgo r1 = com.google.android.gms.internal.ads.zzhc.zza(r7, r1, r13, r3)
            r15.zzafx = r1
        L_0x03c6:
            r3 = 0
            goto L_0x040f
        L_0x03c8:
            int r3 = com.google.android.gms.internal.ads.zzjs.zzarn
            if (r1 != r3) goto L_0x03dd
            int r1 = r8 + 8
            r7.zzbg(r1)
            java.lang.String r1 = java.lang.Integer.toString(r9)
            r3 = 0
            com.google.android.gms.internal.ads.zzgo r1 = com.google.android.gms.internal.ads.zzhc.zzb(r7, r1, r13, r3)
            r15.zzafx = r1
            goto L_0x03c6
        L_0x03dd:
            int r3 = com.google.android.gms.internal.ads.zzjs.zzars
            if (r1 != r3) goto L_0x0400
            java.lang.String r22 = java.lang.Integer.toString(r9)
            r24 = 0
            r25 = -1
            r26 = -1
            r29 = 0
            r30 = 0
            r31 = 0
            r23 = r5
            r27 = r4
            r28 = r33
            r32 = r13
            com.google.android.gms.internal.ads.zzgo r1 = com.google.android.gms.internal.ads.zzgo.zza(r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32)
            r15.zzafx = r1
            goto L_0x03c6
        L_0x0400:
            int r3 = com.google.android.gms.internal.ads.zzjs.zzaul
            if (r1 != r3) goto L_0x03c6
            byte[] r1 = new byte[r12]
            r7.zzbg(r8)
            r3 = 0
            r7.zze(r1, r3, r12)
            r34 = r1
        L_0x040f:
            r42 = r11
            r0 = -1
            goto L_0x047b
        L_0x0414:
            int r3 = com.google.android.gms.internal.ads.zzjs.zzasg
            if (r1 != r3) goto L_0x041d
            r1 = r8
            r42 = r11
        L_0x041b:
            r0 = -1
            goto L_0x0449
        L_0x041d:
            int r1 = r7.getPosition()
        L_0x0421:
            int r3 = r1 - r8
            if (r3 >= r12) goto L_0x0445
            r7.zzbg(r1)
            int r3 = r7.readInt()
            if (r3 <= 0) goto L_0x0430
            r0 = 1
            goto L_0x0431
        L_0x0430:
            r0 = 0
        L_0x0431:
            com.google.android.gms.internal.ads.zznr.checkArgument(r0, r14)
            int r0 = r7.readInt()
            r42 = r11
            int r11 = com.google.android.gms.internal.ads.zzjs.zzasg
            if (r0 != r11) goto L_0x043f
            goto L_0x041b
        L_0x043f:
            int r1 = r1 + r3
            r0 = r43
            r11 = r42
            goto L_0x0421
        L_0x0445:
            r42 = r11
            r0 = -1
            r1 = -1
        L_0x0449:
            if (r1 == r0) goto L_0x047b
            android.util.Pair r1 = zzb(r7, r1)
            java.lang.Object r3 = r1.first
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r1 = r1.second
            r34 = r1
            byte[] r34 = (byte[]) r34
            java.lang.String r1 = "audio/mp4a-latm"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x047a
            android.util.Pair r1 = com.google.android.gms.internal.ads.zznu.zze(r34)
            java.lang.Object r4 = r1.first
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            java.lang.Object r1 = r1.second
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            r5 = r3
            r33 = r4
            r4 = r1
            goto L_0x047b
        L_0x047a:
            r5 = r3
        L_0x047b:
            int r8 = r8 + r12
            r0 = r43
            r1 = r40
            r3 = r41
            r11 = r42
            goto L_0x038a
        L_0x0486:
            r40 = r1
            r41 = r3
            r42 = r11
            r0 = -1
            com.google.android.gms.internal.ads.zzgo r1 = r15.zzafx
            if (r1 != 0) goto L_0x0302
            if (r5 == 0) goto L_0x0302
            java.lang.String r1 = "audio/raw"
            boolean r1 = r1.equals(r5)
            if (r1 == 0) goto L_0x049e
            r29 = 2
            goto L_0x04a0
        L_0x049e:
            r29 = -1
        L_0x04a0:
            java.lang.String r22 = java.lang.Integer.toString(r9)
            r24 = 0
            r25 = -1
            r26 = -1
            if (r34 != 0) goto L_0x04af
            r30 = 0
            goto L_0x04b5
        L_0x04af:
            java.util.List r1 = java.util.Collections.singletonList(r34)
            r30 = r1
        L_0x04b5:
            r31 = 0
            r32 = 0
            r23 = r5
            r27 = r4
            r28 = r33
            r33 = r13
            com.google.android.gms.internal.ads.zzgo r1 = com.google.android.gms.internal.ads.zzgo.zza(r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33)
            r15.zzafx = r1
            goto L_0x0302
        L_0x04c9:
            r40 = r1
            r41 = r3
            r42 = r11
            r39 = r12
            r0 = -1
            int r1 = r10 + 8
            r3 = 8
            int r1 = r1 + r3
            r7.zzbg(r1)
            r1 = 16
            r7.zzbh(r1)
            int r27 = r7.readUnsignedShort()
            int r28 = r7.readUnsignedShort()
            r3 = 1065353216(0x3f800000, float:1.0)
            r4 = 50
            r7.zzbh(r4)
            int r4 = r7.getPosition()
            int r5 = com.google.android.gms.internal.ads.zzjs.zzasw
            if (r8 != r5) goto L_0x04fd
            int r8 = zza(r7, r10, r2, r15, r6)
            r7.zzbg(r4)
        L_0x04fd:
            r3 = 0
            r23 = 0
            r30 = 0
            r32 = 1065353216(0x3f800000, float:1.0)
            r33 = 0
            r34 = -1
        L_0x0508:
            int r5 = r4 - r10
            if (r5 >= r2) goto L_0x0643
            r7.zzbg(r4)
            int r5 = r7.getPosition()
            int r11 = r7.readInt()
            if (r11 != 0) goto L_0x0520
            int r12 = r7.getPosition()
            int r12 = r12 - r10
            if (r12 == r2) goto L_0x0643
        L_0x0520:
            if (r11 <= 0) goto L_0x0524
            r12 = 1
            goto L_0x0525
        L_0x0524:
            r12 = 0
        L_0x0525:
            com.google.android.gms.internal.ads.zznr.checkArgument(r12, r14)
            int r12 = r7.readInt()
            int r0 = com.google.android.gms.internal.ads.zzjs.zzase
            if (r12 != r0) goto L_0x0550
            if (r23 != 0) goto L_0x0534
            r0 = 1
            goto L_0x0535
        L_0x0534:
            r0 = 0
        L_0x0535:
            com.google.android.gms.internal.ads.zznr.checkState(r0)
            int r5 = r5 + 8
            r7.zzbg(r5)
            com.google.android.gms.internal.ads.zzoh r0 = com.google.android.gms.internal.ads.zzoh.zzf(r7)
            java.util.List<byte[]> r5 = r0.zzafe
            int r12 = r0.zzaqq
            r15.zzaqq = r12
            if (r3 != 0) goto L_0x054d
            float r0 = r0.zzbgk
            r32 = r0
        L_0x054d:
            java.lang.String r0 = "video/avc"
            goto L_0x056d
        L_0x0550:
            int r0 = com.google.android.gms.internal.ads.zzjs.zzasf
            if (r12 != r0) goto L_0x0574
            if (r23 != 0) goto L_0x0558
            r0 = 1
            goto L_0x0559
        L_0x0558:
            r0 = 0
        L_0x0559:
            com.google.android.gms.internal.ads.zznr.checkState(r0)
            int r5 = r5 + 8
            r7.zzbg(r5)
            com.google.android.gms.internal.ads.zzon r0 = com.google.android.gms.internal.ads.zzon.zzh(r7)
            java.util.List<byte[]> r5 = r0.zzafe
            int r0 = r0.zzaqq
            r15.zzaqq = r0
            java.lang.String r0 = "video/hevc"
        L_0x056d:
            r23 = r0
            r30 = r5
        L_0x0571:
            r1 = 3
            goto L_0x063d
        L_0x0574:
            int r0 = com.google.android.gms.internal.ads.zzjs.zzauj
            if (r12 != r0) goto L_0x058a
            if (r23 != 0) goto L_0x057c
            r0 = 1
            goto L_0x057d
        L_0x057c:
            r0 = 0
        L_0x057d:
            com.google.android.gms.internal.ads.zznr.checkState(r0)
            int r0 = com.google.android.gms.internal.ads.zzjs.zzauh
            if (r8 != r0) goto L_0x0587
            java.lang.String r0 = "video/x-vnd.on2.vp8"
            goto L_0x0598
        L_0x0587:
            java.lang.String r0 = "video/x-vnd.on2.vp9"
            goto L_0x0598
        L_0x058a:
            int r0 = com.google.android.gms.internal.ads.zzjs.zzard
            if (r12 != r0) goto L_0x059b
            if (r23 != 0) goto L_0x0592
            r0 = 1
            goto L_0x0593
        L_0x0592:
            r0 = 0
        L_0x0593:
            com.google.android.gms.internal.ads.zznr.checkState(r0)
            java.lang.String r0 = "video/3gpp"
        L_0x0598:
            r23 = r0
            goto L_0x0571
        L_0x059b:
            int r0 = com.google.android.gms.internal.ads.zzjs.zzasg
            if (r12 != r0) goto L_0x05bc
            if (r23 != 0) goto L_0x05a3
            r0 = 1
            goto L_0x05a4
        L_0x05a3:
            r0 = 0
        L_0x05a4:
            com.google.android.gms.internal.ads.zznr.checkState(r0)
            android.util.Pair r0 = zzb(r7, r5)
            java.lang.Object r5 = r0.first
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r0 = r0.second
            byte[] r0 = (byte[]) r0
            java.util.List r0 = java.util.Collections.singletonList(r0)
            r30 = r0
            r23 = r5
            goto L_0x0571
        L_0x05bc:
            int r0 = com.google.android.gms.internal.ads.zzjs.zzatf
            if (r12 != r0) goto L_0x05d5
            int r5 = r5 + 8
            r7.zzbg(r5)
            int r0 = r7.zzir()
            int r3 = r7.zzir()
            float r0 = (float) r0
            float r3 = (float) r3
            float r32 = r0 / r3
            r1 = 3
            r3 = 1
            goto L_0x063d
        L_0x05d5:
            int r0 = com.google.android.gms.internal.ads.zzjs.zzauf
            if (r12 != r0) goto L_0x0607
            int r0 = r5 + 8
        L_0x05db:
            int r12 = r0 - r5
            if (r12 >= r11) goto L_0x05fe
            r7.zzbg(r0)
            int r12 = r7.readInt()
            int r1 = r7.readInt()
            r22 = r3
            int r3 = com.google.android.gms.internal.ads.zzjs.zzaug
            if (r1 != r3) goto L_0x05f8
            byte[] r1 = r7.data
            int r12 = r12 + r0
            byte[] r0 = java.util.Arrays.copyOfRange(r1, r0, r12)
            goto L_0x0601
        L_0x05f8:
            int r0 = r0 + r12
            r3 = r22
            r1 = 16
            goto L_0x05db
        L_0x05fe:
            r22 = r3
            r0 = 0
        L_0x0601:
            r33 = r0
            r3 = r22
            goto L_0x0571
        L_0x0607:
            r22 = r3
            int r0 = com.google.android.gms.internal.ads.zzjs.zzaue
            if (r12 != r0) goto L_0x063a
            int r0 = r7.readUnsignedByte()
            r1 = 3
            r7.zzbh(r1)
            if (r0 != 0) goto L_0x063b
            int r0 = r7.readUnsignedByte()
            if (r0 == 0) goto L_0x0635
            r3 = 1
            if (r0 == r3) goto L_0x0630
            r3 = 2
            if (r0 == r3) goto L_0x062b
            if (r0 == r1) goto L_0x0626
            goto L_0x063b
        L_0x0626:
            r3 = r22
            r34 = 3
            goto L_0x063d
        L_0x062b:
            r3 = r22
            r34 = 2
            goto L_0x063d
        L_0x0630:
            r3 = r22
            r34 = 1
            goto L_0x063d
        L_0x0635:
            r3 = r22
            r34 = 0
            goto L_0x063d
        L_0x063a:
            r1 = 3
        L_0x063b:
            r3 = r22
        L_0x063d:
            int r4 = r4 + r11
            r0 = -1
            r1 = 16
            goto L_0x0508
        L_0x0643:
            r1 = 3
            if (r23 == 0) goto L_0x065e
            java.lang.String r22 = java.lang.Integer.toString(r9)
            r24 = 0
            r25 = -1
            r26 = -1
            r29 = -1082130432(0xffffffffbf800000, float:-1.0)
            r35 = 0
            r36 = 0
            r31 = r42
            com.google.android.gms.internal.ads.zzgo r0 = com.google.android.gms.internal.ads.zzgo.zza(r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36)
            r15.zzafx = r0
        L_0x065e:
            int r10 = r10 + r2
            r7.zzbg(r10)
            int r6 = r6 + 1
            r0 = r43
            r14 = r44
            r4 = r37
            r12 = r39
            r1 = r40
            r3 = r41
            r11 = r42
            r2 = 0
            r8 = -1
            r10 = 8
            goto L_0x01a4
        L_0x0678:
            r40 = r1
            r41 = r3
            r37 = r4
            r39 = r12
            int r0 = com.google.android.gms.internal.ads.zzjs.zzasm
            r1 = r43
            com.google.android.gms.internal.ads.zzjr r0 = r1.zzal(r0)
            if (r0 == 0) goto L_0x06e5
            int r1 = com.google.android.gms.internal.ads.zzjs.zzasn
            com.google.android.gms.internal.ads.zzju r0 = r0.zzak(r1)
            if (r0 != 0) goto L_0x0693
            goto L_0x06e5
        L_0x0693:
            com.google.android.gms.internal.ads.zzoc r0 = r0.zzaut
            r1 = 8
            r0.zzbg(r1)
            int r1 = r0.readInt()
            int r1 = com.google.android.gms.internal.ads.zzjs.zzam(r1)
            int r2 = r0.zzir()
            long[] r3 = new long[r2]
            long[] r4 = new long[r2]
            r5 = 0
        L_0x06ab:
            if (r5 >= r2) goto L_0x06de
            r6 = 1
            if (r1 != r6) goto L_0x06b5
            long r7 = r0.zzis()
            goto L_0x06b9
        L_0x06b5:
            long r7 = r0.zzio()
        L_0x06b9:
            r3[r5] = r7
            if (r1 != r6) goto L_0x06c2
            long r7 = r0.readLong()
            goto L_0x06c7
        L_0x06c2:
            int r7 = r0.readInt()
            long r7 = (long) r7
        L_0x06c7:
            r4[r5] = r7
            short r7 = r0.readShort()
            if (r7 != r6) goto L_0x06d6
            r7 = 2
            r0.zzbh(r7)
            int r5 = r5 + 1
            goto L_0x06ab
        L_0x06d6:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Unsupported media rate."
            r0.<init>(r1)
            throw r0
        L_0x06de:
            android.util.Pair r0 = android.util.Pair.create(r3, r4)
            r1 = r0
            r0 = 0
            goto L_0x06ea
        L_0x06e5:
            r0 = 0
            android.util.Pair r1 = android.util.Pair.create(r0, r0)
        L_0x06ea:
            com.google.android.gms.internal.ads.zzgo r2 = r15.zzafx
            if (r2 != 0) goto L_0x06ef
            return r0
        L_0x06ef:
            com.google.android.gms.internal.ads.zzkh r0 = new com.google.android.gms.internal.ads.zzkh
            int r11 = r41.f3920id
            r2 = r40
            java.lang.Object r2 = r2.first
            java.lang.Long r2 = (java.lang.Long) r2
            long r13 = r2.longValue()
            com.google.android.gms.internal.ads.zzgo r2 = r15.zzafx
            int r3 = r15.zzave
            com.google.android.gms.internal.ads.zzkk[] r4 = r15.zzavd
            int r5 = r15.zzaqq
            java.lang.Object r6 = r1.first
            r23 = r6
            long[] r23 = (long[]) r23
            java.lang.Object r1 = r1.second
            r24 = r1
            long[] r24 = (long[]) r24
            r10 = r0
            r12 = r39
            r15 = r37
            r17 = r18
            r19 = r2
            r20 = r3
            r21 = r4
            r22 = r5
            r10.<init>(r11, r12, r13, r15, r17, r19, r20, r21, r22, r23, r24)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzjt.zza(com.google.android.gms.internal.ads.zzjr, com.google.android.gms.internal.ads.zzju, long, com.google.android.gms.internal.ads.zzin, boolean):com.google.android.gms.internal.ads.zzkh");
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0207  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzkj zza(com.google.android.gms.internal.ads.zzkh r43, com.google.android.gms.internal.ads.zzjr r44, com.google.android.gms.internal.ads.zzja r45) throws com.google.android.gms.internal.ads.zzgv {
        /*
            r0 = r43
            r1 = r44
            r2 = r45
            int r3 = com.google.android.gms.internal.ads.zzjs.zzatn
            com.google.android.gms.internal.ads.zzju r3 = r1.zzak(r3)
            if (r3 == 0) goto L_0x0014
            com.google.android.gms.internal.ads.zzjx r4 = new com.google.android.gms.internal.ads.zzjx
            r4.<init>(r3)
            goto L_0x0021
        L_0x0014:
            int r3 = com.google.android.gms.internal.ads.zzjs.zzato
            com.google.android.gms.internal.ads.zzju r3 = r1.zzak(r3)
            if (r3 == 0) goto L_0x04ef
            com.google.android.gms.internal.ads.zzka r4 = new com.google.android.gms.internal.ads.zzka
            r4.<init>(r3)
        L_0x0021:
            int r3 = r4.zzgj()
            r5 = 0
            if (r3 != 0) goto L_0x0038
            com.google.android.gms.internal.ads.zzkj r0 = new com.google.android.gms.internal.ads.zzkj
            long[] r7 = new long[r5]
            int[] r8 = new int[r5]
            r9 = 0
            long[] r10 = new long[r5]
            int[] r11 = new int[r5]
            r6 = r0
            r6.<init>(r7, r8, r9, r10, r11)
            return r0
        L_0x0038:
            int r6 = com.google.android.gms.internal.ads.zzjs.zzatp
            com.google.android.gms.internal.ads.zzju r6 = r1.zzak(r6)
            r7 = 1
            if (r6 != 0) goto L_0x0049
            int r6 = com.google.android.gms.internal.ads.zzjs.zzatq
            com.google.android.gms.internal.ads.zzju r6 = r1.zzak(r6)
            r8 = 1
            goto L_0x004a
        L_0x0049:
            r8 = 0
        L_0x004a:
            com.google.android.gms.internal.ads.zzoc r6 = r6.zzaut
            int r9 = com.google.android.gms.internal.ads.zzjs.zzatm
            com.google.android.gms.internal.ads.zzju r9 = r1.zzak(r9)
            com.google.android.gms.internal.ads.zzoc r9 = r9.zzaut
            int r10 = com.google.android.gms.internal.ads.zzjs.zzatj
            com.google.android.gms.internal.ads.zzju r10 = r1.zzak(r10)
            com.google.android.gms.internal.ads.zzoc r10 = r10.zzaut
            int r11 = com.google.android.gms.internal.ads.zzjs.zzatk
            com.google.android.gms.internal.ads.zzju r11 = r1.zzak(r11)
            r12 = 0
            if (r11 == 0) goto L_0x0068
            com.google.android.gms.internal.ads.zzoc r11 = r11.zzaut
            goto L_0x0069
        L_0x0068:
            r11 = r12
        L_0x0069:
            int r13 = com.google.android.gms.internal.ads.zzjs.zzatl
            com.google.android.gms.internal.ads.zzju r1 = r1.zzak(r13)
            if (r1 == 0) goto L_0x0074
            com.google.android.gms.internal.ads.zzoc r1 = r1.zzaut
            goto L_0x0075
        L_0x0074:
            r1 = r12
        L_0x0075:
            com.google.android.gms.internal.ads.zzjw r13 = new com.google.android.gms.internal.ads.zzjw
            r13.<init>(r9, r6, r8)
            r6 = 12
            r10.zzbg(r6)
            int r8 = r10.zzir()
            int r8 = r8 - r7
            int r9 = r10.zzir()
            int r14 = r10.zzir()
            if (r1 == 0) goto L_0x0096
            r1.zzbg(r6)
            int r15 = r1.zzir()
            goto L_0x0097
        L_0x0096:
            r15 = 0
        L_0x0097:
            r16 = -1
            if (r11 == 0) goto L_0x00ad
            r11.zzbg(r6)
            int r6 = r11.zzir()
            if (r6 <= 0) goto L_0x00ab
            int r12 = r11.zzir()
            int r16 = r12 + -1
            goto L_0x00ae
        L_0x00ab:
            r11 = r12
            goto L_0x00ae
        L_0x00ad:
            r6 = 0
        L_0x00ae:
            boolean r12 = r4.zzgl()
            if (r12 == 0) goto L_0x00c8
            com.google.android.gms.internal.ads.zzgo r12 = r0.zzafx
            java.lang.String r12 = r12.zzafc
            java.lang.String r5 = "audio/raw"
            boolean r5 = r5.equals(r12)
            if (r5 == 0) goto L_0x00c8
            if (r8 != 0) goto L_0x00c8
            if (r15 != 0) goto L_0x00c8
            if (r6 != 0) goto L_0x00c8
            r5 = 1
            goto L_0x00c9
        L_0x00c8:
            r5 = 0
        L_0x00c9:
            r18 = 0
            if (r5 != 0) goto L_0x0207
            long[] r5 = new long[r3]
            int[] r12 = new int[r3]
            long[] r7 = new long[r3]
            r44 = r6
            int[] r6 = new int[r3]
            r0 = r44
            r27 = r10
            r10 = r14
            r25 = r15
            r2 = r16
            r21 = r18
            r23 = r21
            r44 = 0
            r15 = 0
            r16 = 0
            r26 = 0
            r14 = r9
            r9 = r8
            r8 = 0
        L_0x00ee:
            if (r8 >= r3) goto L_0x0194
            r28 = r21
            r21 = r44
        L_0x00f4:
            if (r21 != 0) goto L_0x010e
            boolean r21 = r13.zzgm()
            com.google.android.gms.internal.ads.zznr.checkState(r21)
            r22 = r9
            r30 = r10
            long r9 = r13.zzauv
            r28 = r9
            int r9 = r13.zzauu
            r21 = r9
            r9 = r22
            r10 = r30
            goto L_0x00f4
        L_0x010e:
            r22 = r9
            r30 = r10
            if (r1 == 0) goto L_0x0125
        L_0x0114:
            if (r26 != 0) goto L_0x0123
            if (r25 <= 0) goto L_0x0123
            int r26 = r1.zzir()
            int r16 = r1.readInt()
            int r25 = r25 + -1
            goto L_0x0114
        L_0x0123:
            int r26 = r26 + -1
        L_0x0125:
            r9 = r16
            r5[r8] = r28
            int r10 = r4.zzgk()
            r12[r8] = r10
            r10 = r12[r8]
            if (r10 <= r15) goto L_0x0139
            r10 = r12[r8]
            r16 = r3
            r15 = r10
            goto L_0x013b
        L_0x0139:
            r16 = r3
        L_0x013b:
            r10 = r4
            long r3 = (long) r9
            long r3 = r23 + r3
            r7[r8] = r3
            if (r11 != 0) goto L_0x0145
            r3 = 1
            goto L_0x0146
        L_0x0145:
            r3 = 0
        L_0x0146:
            r6[r8] = r3
            if (r8 != r2) goto L_0x0156
            r3 = 1
            r6[r8] = r3
            int r0 = r0 + -1
            if (r0 <= 0) goto L_0x0156
            int r2 = r11.zzir()
            int r2 = r2 - r3
        L_0x0156:
            r4 = r0
            r44 = r2
            r0 = r30
            long r2 = (long) r0
            long r23 = r23 + r2
            int r14 = r14 + -1
            if (r14 != 0) goto L_0x0171
            if (r22 <= 0) goto L_0x0171
            int r0 = r27.zzir()
            int r2 = r27.zzir()
            int r3 = r22 + -1
            r14 = r0
            r0 = r2
            goto L_0x0173
        L_0x0171:
            r3 = r22
        L_0x0173:
            r2 = r12[r8]
            r22 = r3
            long r2 = (long) r2
            long r2 = r28 + r2
            int r21 = r21 + -1
            int r8 = r8 + 1
            r40 = r2
            r2 = r44
            r3 = r16
            r44 = r21
            r16 = r9
            r9 = r22
            r21 = r40
            r42 = r10
            r10 = r0
            r0 = r4
            r4 = r42
            goto L_0x00ee
        L_0x0194:
            r16 = r3
            r22 = r9
            if (r26 != 0) goto L_0x019c
            r2 = 1
            goto L_0x019d
        L_0x019c:
            r2 = 0
        L_0x019d:
            com.google.android.gms.internal.ads.zznr.checkArgument(r2)
        L_0x01a0:
            if (r25 <= 0) goto L_0x01b4
            int r2 = r1.zzir()
            if (r2 != 0) goto L_0x01aa
            r2 = 1
            goto L_0x01ab
        L_0x01aa:
            r2 = 0
        L_0x01ab:
            com.google.android.gms.internal.ads.zznr.checkArgument(r2)
            r1.readInt()
            int r25 = r25 + -1
            goto L_0x01a0
        L_0x01b4:
            if (r0 != 0) goto L_0x01c0
            if (r14 != 0) goto L_0x01c0
            if (r44 != 0) goto L_0x01c0
            if (r22 == 0) goto L_0x01bd
            goto L_0x01c0
        L_0x01bd:
            r0 = r43
            goto L_0x0201
        L_0x01c0:
            r4 = r0
            r0 = r43
            int r1 = r0.f3921id
            r2 = 215(0xd7, float:3.01E-43)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r2 = "Inconsistent stbl box for track "
            r3.append(r2)
            r3.append(r1)
            java.lang.String r1 = ": remainingSynchronizationSamples "
            r3.append(r1)
            r3.append(r4)
            java.lang.String r1 = ", remainingSamplesAtTimestampDelta "
            r3.append(r1)
            r3.append(r14)
            java.lang.String r1 = ", remainingSamplesInChunk "
            r3.append(r1)
            r1 = r44
            r3.append(r1)
            java.lang.String r1 = ", remainingTimestampDeltaChanges "
            r3.append(r1)
            r8 = r22
            r3.append(r8)
            java.lang.String r1 = r3.toString()
            java.lang.String r2 = "AtomParsers"
            android.util.Log.w(r2, r1)
        L_0x0201:
            r1 = r23
            r24 = r15
            goto L_0x02aa
        L_0x0207:
            r16 = r3
            r10 = r4
            int r1 = r13.length
            long[] r1 = new long[r1]
            int r2 = r13.length
            int[] r2 = new int[r2]
        L_0x0212:
            boolean r3 = r13.zzgm()
            if (r3 == 0) goto L_0x0225
            int r3 = r13.index
            long r4 = r13.zzauv
            r1[r3] = r4
            int r3 = r13.index
            int r4 = r13.zzauu
            r2[r3] = r4
            goto L_0x0212
        L_0x0225:
            int r3 = r10.zzgk()
            long r4 = (long) r14
            r6 = 8192(0x2000, float:1.14794E-41)
            int r6 = r6 / r3
            int r7 = r2.length
            r8 = 0
            r9 = 0
        L_0x0230:
            if (r8 >= r7) goto L_0x023c
            r10 = r2[r8]
            int r10 = com.google.android.gms.internal.ads.zzof.zze(r10, r6)
            int r9 = r9 + r10
            int r8 = r8 + 1
            goto L_0x0230
        L_0x023c:
            long[] r7 = new long[r9]
            int[] r8 = new int[r9]
            long[] r10 = new long[r9]
            int[] r9 = new int[r9]
            r11 = 0
            r12 = 0
            r13 = 0
            r24 = 0
        L_0x0249:
            int r14 = r2.length
            if (r11 >= r14) goto L_0x028b
            r14 = r2[r11]
            r21 = r1[r11]
            r15 = r12
            r12 = r24
        L_0x0253:
            if (r14 <= 0) goto L_0x0281
            int r23 = java.lang.Math.min(r6, r14)
            r7[r13] = r21
            int r24 = r3 * r23
            r8[r13] = r24
            r25 = r1
            r1 = r8[r13]
            int r12 = java.lang.Math.max(r12, r1)
            r26 = r2
            long r1 = (long) r15
            long r1 = r1 * r4
            r10[r13] = r1
            r1 = 1
            r9[r13] = r1
            r1 = r8[r13]
            long r1 = (long) r1
            long r21 = r21 + r1
            int r15 = r15 + r23
            int r14 = r14 - r23
            int r13 = r13 + 1
            r1 = r25
            r2 = r26
            goto L_0x0253
        L_0x0281:
            r25 = r1
            r26 = r2
            int r11 = r11 + 1
            r24 = r12
            r12 = r15
            goto L_0x0249
        L_0x028b:
            com.google.android.gms.internal.ads.zzkb r1 = new com.google.android.gms.internal.ads.zzkb
            r27 = 0
            r21 = r1
            r22 = r7
            r23 = r8
            r25 = r10
            r26 = r9
            r21.<init>(r22, r23, r24, r25, r26)
            long[] r5 = r1.zzamv
            int[] r12 = r1.zzamu
            int r2 = r1.zzavi
            long[] r7 = r1.zzavj
            int[] r6 = r1.zzavk
            r24 = r2
            r1 = r18
        L_0x02aa:
            long[] r3 = r0.zzaxf
            if (r3 == 0) goto L_0x04d2
            boolean r3 = r45.zzgf()
            if (r3 == 0) goto L_0x02b6
            goto L_0x04d2
        L_0x02b6:
            long[] r3 = r0.zzaxf
            int r3 = r3.length
            r4 = 1
            if (r3 != r4) goto L_0x034b
            int r3 = r0.type
            if (r3 != r4) goto L_0x034b
            int r3 = r7.length
            r4 = 2
            if (r3 < r4) goto L_0x034b
            long[] r3 = r0.zzaxg
            r4 = 0
            r10 = r3[r4]
            long[] r3 = r0.zzaxf
            r25 = r3[r4]
            long r13 = r0.zzct
            long r8 = r0.zzaxc
            r27 = r13
            r29 = r8
            long r8 = com.google.android.gms.internal.ads.zzof.zza(r25, r27, r29)
            long r8 = r8 + r10
            r13 = r7[r4]
            int r3 = (r13 > r10 ? 1 : (r13 == r10 ? 0 : -1))
            if (r3 > 0) goto L_0x034b
            r3 = 1
            r13 = r7[r3]
            int r4 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r4 >= 0) goto L_0x034b
            int r4 = r7.length
            int r4 = r4 - r3
            r3 = r7[r4]
            int r13 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r13 >= 0) goto L_0x034b
            int r3 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r3 > 0) goto L_0x034b
            long r25 = r1 - r8
            r1 = 0
            r2 = r7[r1]
            long r27 = r10 - r2
            com.google.android.gms.internal.ads.zzgo r1 = r0.zzafx
            int r1 = r1.zzafn
            long r1 = (long) r1
            long r3 = r0.zzct
            r29 = r1
            r31 = r3
            long r1 = com.google.android.gms.internal.ads.zzof.zza(r27, r29, r31)
            com.google.android.gms.internal.ads.zzgo r3 = r0.zzafx
            int r3 = r3.zzafn
            long r3 = (long) r3
            long r8 = r0.zzct
            r27 = r3
            r29 = r8
            long r3 = com.google.android.gms.internal.ads.zzof.zza(r25, r27, r29)
            int r8 = (r1 > r18 ? 1 : (r1 == r18 ? 0 : -1))
            if (r8 != 0) goto L_0x0320
            int r8 = (r3 > r18 ? 1 : (r3 == r18 ? 0 : -1))
            if (r8 == 0) goto L_0x034b
        L_0x0320:
            r8 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r10 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r10 > 0) goto L_0x034b
            int r10 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r10 > 0) goto L_0x034b
            int r2 = (int) r1
            r1 = r45
            r1.zzafp = r2
            int r2 = (int) r3
            r1.zzafq = r2
            long r0 = r0.zzct
            r2 = 1000000(0xf4240, double:4.940656E-318)
            com.google.android.gms.internal.ads.zzof.zza(r7, r2, r0)
            com.google.android.gms.internal.ads.zzkj r0 = new com.google.android.gms.internal.ads.zzkj
            r21 = r0
            r22 = r5
            r23 = r12
            r25 = r7
            r26 = r6
            r21.<init>(r22, r23, r24, r25, r26)
            return r0
        L_0x034b:
            long[] r1 = r0.zzaxf
            int r1 = r1.length
            r2 = 1
            if (r1 != r2) goto L_0x0389
            long[] r1 = r0.zzaxf
            r17 = 0
            r2 = r1[r17]
            int r1 = (r2 > r18 ? 1 : (r2 == r18 ? 0 : -1))
            if (r1 != 0) goto L_0x0389
            r1 = 0
        L_0x035c:
            int r2 = r7.length
            if (r1 >= r2) goto L_0x0379
            r2 = r7[r1]
            long[] r4 = r0.zzaxg
            r8 = r4[r17]
            long r18 = r2 - r8
            r20 = 1000000(0xf4240, double:4.940656E-318)
            long r2 = r0.zzct
            r22 = r2
            long r2 = com.google.android.gms.internal.ads.zzof.zza(r18, r20, r22)
            r7[r1] = r2
            int r1 = r1 + 1
            r17 = 0
            goto L_0x035c
        L_0x0379:
            com.google.android.gms.internal.ads.zzkj r0 = new com.google.android.gms.internal.ads.zzkj
            r21 = r0
            r22 = r5
            r23 = r12
            r25 = r7
            r26 = r6
            r21.<init>(r22, r23, r24, r25, r26)
            return r0
        L_0x0389:
            int r1 = r0.type
            r2 = 1
            if (r1 != r2) goto L_0x0390
            r1 = 1
            goto L_0x0391
        L_0x0390:
            r1 = 0
        L_0x0391:
            r2 = 0
            r3 = 0
            r4 = 0
            r8 = 0
        L_0x0395:
            long[] r9 = r0.zzaxf
            int r9 = r9.length
            r10 = -1
            if (r2 >= r9) goto L_0x03d3
            long[] r9 = r0.zzaxg
            r13 = r9[r2]
            int r9 = (r13 > r10 ? 1 : (r13 == r10 ? 0 : -1))
            if (r9 == 0) goto L_0x03cc
            long[] r9 = r0.zzaxf
            r25 = r9[r2]
            long r9 = r0.zzct
            r44 = r12
            long r11 = r0.zzaxc
            r27 = r9
            r29 = r11
            long r9 = com.google.android.gms.internal.ads.zzof.zza(r25, r27, r29)
            r11 = 1
            int r12 = com.google.android.gms.internal.ads.zzof.zzb(r7, r13, r11, r11)
            long r13 = r13 + r9
            r9 = 0
            int r10 = com.google.android.gms.internal.ads.zzof.zzb(r7, r13, r1, r9)
            int r9 = r10 - r12
            int r4 = r4 + r9
            if (r8 == r12) goto L_0x03c8
            r8 = 1
            goto L_0x03c9
        L_0x03c8:
            r8 = 0
        L_0x03c9:
            r3 = r3 | r8
            r8 = r10
            goto L_0x03ce
        L_0x03cc:
            r44 = r12
        L_0x03ce:
            int r2 = r2 + 1
            r12 = r44
            goto L_0x0395
        L_0x03d3:
            r44 = r12
            r2 = r16
            if (r4 == r2) goto L_0x03db
            r2 = 1
            goto L_0x03dc
        L_0x03db:
            r2 = 0
        L_0x03dc:
            r2 = r2 | r3
            if (r2 == 0) goto L_0x03e2
            long[] r3 = new long[r4]
            goto L_0x03e3
        L_0x03e2:
            r3 = r5
        L_0x03e3:
            if (r2 == 0) goto L_0x03e8
            int[] r12 = new int[r4]
            goto L_0x03ea
        L_0x03e8:
            r12 = r44
        L_0x03ea:
            if (r2 == 0) goto L_0x03ee
            r24 = 0
        L_0x03ee:
            if (r2 == 0) goto L_0x03f3
            int[] r8 = new int[r4]
            goto L_0x03f4
        L_0x03f3:
            r8 = r6
        L_0x03f4:
            long[] r4 = new long[r4]
            r28 = r24
            r9 = 0
            r13 = 0
        L_0x03fa:
            long[] r14 = r0.zzaxf
            int r14 = r14.length
            if (r9 >= r14) goto L_0x04a3
            long[] r14 = r0.zzaxg
            r10 = r14[r9]
            long[] r14 = r0.zzaxf
            r29 = r14[r9]
            r14 = -1
            int r16 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1))
            if (r16 == 0) goto L_0x0487
            long r14 = r0.zzct
            r16 = r8
            r27 = r9
            long r8 = r0.zzaxc
            r21 = r29
            r23 = r14
            r25 = r8
            long r8 = com.google.android.gms.internal.ads.zzof.zza(r21, r23, r25)
            long r8 = r8 + r10
            r14 = 1
            int r15 = com.google.android.gms.internal.ads.zzof.zzb(r7, r10, r14, r14)
            r14 = 0
            int r8 = com.google.android.gms.internal.ads.zzof.zzb(r7, r8, r1, r14)
            if (r2 == 0) goto L_0x043e
            int r9 = r8 - r15
            java.lang.System.arraycopy(r5, r15, r3, r13, r9)
            r14 = r44
            java.lang.System.arraycopy(r14, r15, r12, r13, r9)
            r44 = r1
            r1 = r16
            java.lang.System.arraycopy(r6, r15, r1, r13, r9)
            goto L_0x0444
        L_0x043e:
            r14 = r44
            r44 = r1
            r1 = r16
        L_0x0444:
            r9 = r28
        L_0x0446:
            if (r15 >= r8) goto L_0x0480
            r23 = 1000000(0xf4240, double:4.940656E-318)
            r16 = r5
            r33 = r6
            long r5 = r0.zzaxc
            r21 = r18
            r25 = r5
            long r5 = com.google.android.gms.internal.ads.zzof.zza(r21, r23, r25)
            r21 = r7[r15]
            long r34 = r21 - r10
            r36 = 1000000(0xf4240, double:4.940656E-318)
            r21 = r10
            long r10 = r0.zzct
            r38 = r10
            long r10 = com.google.android.gms.internal.ads.zzof.zza(r34, r36, r38)
            long r5 = r5 + r10
            r4[r13] = r5
            if (r2 == 0) goto L_0x0475
            r5 = r12[r13]
            if (r5 <= r9) goto L_0x0475
            r9 = r14[r15]
        L_0x0475:
            int r13 = r13 + 1
            int r15 = r15 + 1
            r5 = r16
            r10 = r21
            r6 = r33
            goto L_0x0446
        L_0x0480:
            r16 = r5
            r33 = r6
            r28 = r9
            goto L_0x0492
        L_0x0487:
            r14 = r44
            r44 = r1
            r16 = r5
            r33 = r6
            r1 = r8
            r27 = r9
        L_0x0492:
            long r18 = r18 + r29
            int r9 = r27 + 1
            r8 = r1
            r5 = r16
            r6 = r33
            r10 = -1
            r1 = r44
            r44 = r14
            goto L_0x03fa
        L_0x04a3:
            r1 = r8
            r0 = 0
            r2 = 0
        L_0x04a6:
            int r5 = r1.length
            if (r0 >= r5) goto L_0x04b8
            if (r2 != 0) goto L_0x04b8
            r5 = r1[r0]
            r6 = 1
            r5 = r5 & r6
            if (r5 == 0) goto L_0x04b3
            r5 = 1
            goto L_0x04b4
        L_0x04b3:
            r5 = 0
        L_0x04b4:
            r2 = r2 | r5
            int r0 = r0 + 1
            goto L_0x04a6
        L_0x04b8:
            if (r2 == 0) goto L_0x04ca
            com.google.android.gms.internal.ads.zzkj r0 = new com.google.android.gms.internal.ads.zzkj
            r25 = r0
            r26 = r3
            r27 = r12
            r29 = r4
            r30 = r1
            r25.<init>(r26, r27, r28, r29, r30)
            return r0
        L_0x04ca:
            com.google.android.gms.internal.ads.zzgv r0 = new com.google.android.gms.internal.ads.zzgv
            java.lang.String r1 = "The edited sample sequence does not contain a sync sample."
            r0.<init>(r1)
            throw r0
        L_0x04d2:
            r16 = r5
            r33 = r6
            r14 = r12
            long r0 = r0.zzct
            r2 = 1000000(0xf4240, double:4.940656E-318)
            com.google.android.gms.internal.ads.zzof.zza(r7, r2, r0)
            com.google.android.gms.internal.ads.zzkj r0 = new com.google.android.gms.internal.ads.zzkj
            r21 = r0
            r22 = r16
            r23 = r14
            r25 = r7
            r26 = r33
            r21.<init>(r22, r23, r24, r25, r26)
            return r0
        L_0x04ef:
            com.google.android.gms.internal.ads.zzgv r0 = new com.google.android.gms.internal.ads.zzgv
            java.lang.String r1 = "Track has no sample table size information"
            r0.<init>(r1)
            throw r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzjt.zza(com.google.android.gms.internal.ads.zzkh, com.google.android.gms.internal.ads.zzjr, com.google.android.gms.internal.ads.zzja):com.google.android.gms.internal.ads.zzkj");
    }

    public static zzkx zza(zzju zzju, boolean z) {
        if (z) {
            return null;
        }
        zzoc zzoc = zzju.zzaut;
        zzoc.zzbg(8);
        while (zzoc.zzim() >= 8) {
            int position = zzoc.getPosition();
            int readInt = zzoc.readInt();
            if (zzoc.readInt() == zzjs.zzaty) {
                zzoc.zzbg(position);
                int i = position + readInt;
                zzoc.zzbh(12);
                while (true) {
                    if (zzoc.getPosition() >= i) {
                        break;
                    }
                    int position2 = zzoc.getPosition();
                    int readInt2 = zzoc.readInt();
                    if (zzoc.readInt() == zzjs.zzatz) {
                        zzoc.zzbg(position2);
                        int i2 = position2 + readInt2;
                        zzoc.zzbh(8);
                        ArrayList arrayList = new ArrayList();
                        while (zzoc.getPosition() < i2) {
                            zza zzd = zzke.zzd(zzoc);
                            if (zzd != null) {
                                arrayList.add(zzd);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            return new zzkx((List<? extends zza>) arrayList);
                        }
                    } else {
                        zzoc.zzbh(readInt2 - 8);
                    }
                }
                return null;
            }
            zzoc.zzbh(readInt - 8);
        }
        return null;
    }

    private static Pair<String, byte[]> zzb(zzoc zzoc, int i) {
        zzoc.zzbg(i + 8 + 4);
        zzoc.zzbh(1);
        zzc(zzoc);
        zzoc.zzbh(2);
        int readUnsignedByte = zzoc.readUnsignedByte();
        if ((readUnsignedByte & 128) != 0) {
            zzoc.zzbh(2);
        }
        if ((readUnsignedByte & 64) != 0) {
            zzoc.zzbh(zzoc.readUnsignedShort());
        }
        if ((readUnsignedByte & 32) != 0) {
            zzoc.zzbh(2);
        }
        zzoc.zzbh(1);
        zzc(zzoc);
        int readUnsignedByte2 = zzoc.readUnsignedByte();
        String str = null;
        if (readUnsignedByte2 == 32) {
            str = "video/mp4v-es";
        } else if (readUnsignedByte2 == 33) {
            str = "video/avc";
        } else if (readUnsignedByte2 != 35) {
            if (readUnsignedByte2 != 64) {
                if (readUnsignedByte2 == 107) {
                    return Pair.create("audio/mpeg", null);
                }
                if (readUnsignedByte2 == 165) {
                    str = "audio/ac3";
                } else if (readUnsignedByte2 != 166) {
                    switch (readUnsignedByte2) {
                        case 102:
                        case 103:
                        case 104:
                            break;
                        default:
                            switch (readUnsignedByte2) {
                                case 169:
                                case 172:
                                    return Pair.create("audio/vnd.dts", null);
                                case 170:
                                case 171:
                                    return Pair.create("audio/vnd.dts.hd", null);
                            }
                    }
                } else {
                    str = "audio/eac3";
                }
            }
            str = "audio/mp4a-latm";
        } else {
            str = "video/hevc";
        }
        zzoc.zzbh(12);
        zzoc.zzbh(1);
        int zzc = zzc(zzoc);
        byte[] bArr = new byte[zzc];
        zzoc.zze(bArr, 0, zzc);
        return Pair.create(str, bArr);
    }

    private static int zza(zzoc zzoc, int i, int i2, zzjy zzjy, int i3) {
        Object obj;
        zzoc zzoc2 = zzoc;
        int position = zzoc.getPosition();
        while (true) {
            boolean z = false;
            if (position - i >= i2) {
                return 0;
            }
            zzoc.zzbg(position);
            int readInt = zzoc.readInt();
            zznr.checkArgument(readInt > 0, "childAtomSize should be positive");
            if (zzoc.readInt() == zzjs.zzass) {
                int i4 = position + 8;
                Pair pair = null;
                Object obj2 = null;
                Object obj3 = null;
                boolean z2 = false;
                while (i4 - position < readInt) {
                    zzoc.zzbg(i4);
                    int readInt2 = zzoc.readInt();
                    int readInt3 = zzoc.readInt();
                    if (readInt3 == zzjs.zzasy) {
                        obj2 = Integer.valueOf(zzoc.readInt());
                    } else if (readInt3 == zzjs.zzast) {
                        zzoc.zzbh(4);
                        z2 = zzoc.readInt() == zzaus;
                    } else if (readInt3 == zzjs.zzasu) {
                        int i5 = i4 + 8;
                        while (true) {
                            if (i5 - i4 >= readInt2) {
                                obj = null;
                                break;
                            }
                            zzoc.zzbg(i5);
                            int readInt4 = zzoc.readInt();
                            if (zzoc.readInt() == zzjs.zzasv) {
                                zzoc.zzbh(6);
                                boolean z3 = zzoc.readUnsignedByte() == 1;
                                int readUnsignedByte = zzoc.readUnsignedByte();
                                byte[] bArr = new byte[16];
                                zzoc.zze(bArr, 0, 16);
                                obj = new zzkk(z3, readUnsignedByte, bArr);
                            } else {
                                i5 += readInt4;
                            }
                        }
                        obj3 = obj;
                    }
                    i4 += readInt2;
                }
                if (z2) {
                    zznr.checkArgument(obj2 != null, "frma atom is mandatory");
                    if (obj3 != null) {
                        z = true;
                    }
                    zznr.checkArgument(z, "schi->tenc atom is mandatory");
                    pair = Pair.create(obj2, obj3);
                }
                if (pair != null) {
                    zzjy.zzavd[i3] = (zzkk) pair.second;
                    return ((Integer) pair.first).intValue();
                }
            }
            zzjy zzjy2 = zzjy;
            position += readInt;
        }
    }

    private static int zzc(zzoc zzoc) {
        int readUnsignedByte = zzoc.readUnsignedByte();
        int i = readUnsignedByte & Notifications.NOTIFICATION_TYPES_ALL;
        while ((readUnsignedByte & 128) == 128) {
            readUnsignedByte = zzoc.readUnsignedByte();
            i = (i << 7) | (readUnsignedByte & Notifications.NOTIFICATION_TYPES_ALL);
        }
        return i;
    }
}
