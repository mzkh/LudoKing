package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.media.MediaCodecInfo.AudioCapabilities;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecInfo.VideoCapabilities;
import android.util.Log;

@TargetApi(16)
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzkm {
    private final String mimeType;
    public final String name;
    public final boolean zzajm;
    public final boolean zzayx;
    public final boolean zzayy;
    private final CodecCapabilities zzayz;

    public static zzkm zzay(String str) {
        zzkm zzkm = new zzkm(str, null, null, false, false);
        return zzkm;
    }

    public static zzkm zza(String str, String str2, CodecCapabilities codecCapabilities, boolean z, boolean z2) {
        zzkm zzkm = new zzkm(str, str2, codecCapabilities, z, z2);
        return zzkm;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x005a, code lost:
        if ((com.google.android.gms.internal.ads.zzof.SDK_INT >= 21 && r4.isFeatureSupported("secure-playback")) != false) goto L_0x005e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0049  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private zzkm(java.lang.String r2, java.lang.String r3, android.media.MediaCodecInfo.CodecCapabilities r4, boolean r5, boolean r6) {
        /*
            r1 = this;
            r1.<init>()
            java.lang.Object r2 = com.google.android.gms.internal.ads.zznr.checkNotNull(r2)
            java.lang.String r2 = (java.lang.String) r2
            r1.name = r2
            r1.mimeType = r3
            r1.zzayz = r4
            r2 = 1
            r3 = 0
            if (r5 != 0) goto L_0x002a
            if (r4 == 0) goto L_0x002a
            int r5 = com.google.android.gms.internal.ads.zzof.SDK_INT
            r0 = 19
            if (r5 < r0) goto L_0x0025
            java.lang.String r5 = "adaptive-playback"
            boolean r5 = r4.isFeatureSupported(r5)
            if (r5 == 0) goto L_0x0025
            r5 = 1
            goto L_0x0026
        L_0x0025:
            r5 = 0
        L_0x0026:
            if (r5 == 0) goto L_0x002a
            r5 = 1
            goto L_0x002b
        L_0x002a:
            r5 = 0
        L_0x002b:
            r1.zzayx = r5
            r5 = 21
            if (r4 == 0) goto L_0x0044
            int r0 = com.google.android.gms.internal.ads.zzof.SDK_INT
            if (r0 < r5) goto L_0x003f
            java.lang.String r0 = "tunneled-playback"
            boolean r0 = r4.isFeatureSupported(r0)
            if (r0 == 0) goto L_0x003f
            r0 = 1
            goto L_0x0040
        L_0x003f:
            r0 = 0
        L_0x0040:
            if (r0 == 0) goto L_0x0044
            r0 = 1
            goto L_0x0045
        L_0x0044:
            r0 = 0
        L_0x0045:
            r1.zzajm = r0
            if (r6 != 0) goto L_0x005e
            if (r4 == 0) goto L_0x005d
            int r6 = com.google.android.gms.internal.ads.zzof.SDK_INT
            if (r6 < r5) goto L_0x0059
            java.lang.String r5 = "secure-playback"
            boolean r4 = r4.isFeatureSupported(r5)
            if (r4 == 0) goto L_0x0059
            r4 = 1
            goto L_0x005a
        L_0x0059:
            r4 = 0
        L_0x005a:
            if (r4 == 0) goto L_0x005d
            goto L_0x005e
        L_0x005d:
            r2 = 0
        L_0x005e:
            r1.zzayy = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkm.<init>(java.lang.String, java.lang.String, android.media.MediaCodecInfo$CodecCapabilities, boolean, boolean):void");
    }

    public final CodecProfileLevel[] zzgu() {
        CodecCapabilities codecCapabilities = this.zzayz;
        if (codecCapabilities == null || codecCapabilities.profileLevels == null) {
            return new CodecProfileLevel[0];
        }
        return this.zzayz.profileLevels;
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x00c6 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00c7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzaz(java.lang.String r12) {
        /*
            r11 = this;
            r0 = 1
            if (r12 == 0) goto L_0x015b
            java.lang.String r1 = r11.mimeType
            if (r1 != 0) goto L_0x0009
            goto L_0x015b
        L_0x0009:
            if (r12 == 0) goto L_0x00c3
            java.lang.String r1 = r12.trim()
            java.lang.String r2 = "avc1"
            boolean r2 = r1.startsWith(r2)
            if (r2 != 0) goto L_0x00c0
            java.lang.String r2 = "avc3"
            boolean r2 = r1.startsWith(r2)
            if (r2 == 0) goto L_0x0021
            goto L_0x00c0
        L_0x0021:
            java.lang.String r2 = "hev1"
            boolean r2 = r1.startsWith(r2)
            if (r2 != 0) goto L_0x00bd
            java.lang.String r2 = "hvc1"
            boolean r2 = r1.startsWith(r2)
            if (r2 == 0) goto L_0x0033
            goto L_0x00bd
        L_0x0033:
            java.lang.String r2 = "vp9"
            boolean r2 = r1.startsWith(r2)
            if (r2 == 0) goto L_0x003f
            java.lang.String r1 = "video/x-vnd.on2.vp9"
            goto L_0x00c4
        L_0x003f:
            java.lang.String r2 = "vp8"
            boolean r2 = r1.startsWith(r2)
            if (r2 == 0) goto L_0x004b
            java.lang.String r1 = "video/x-vnd.on2.vp8"
            goto L_0x00c4
        L_0x004b:
            java.lang.String r2 = "mp4a"
            boolean r2 = r1.startsWith(r2)
            if (r2 == 0) goto L_0x0057
            java.lang.String r1 = "audio/mp4a-latm"
            goto L_0x00c4
        L_0x0057:
            java.lang.String r2 = "ac-3"
            boolean r2 = r1.startsWith(r2)
            if (r2 != 0) goto L_0x00ba
            java.lang.String r2 = "dac3"
            boolean r2 = r1.startsWith(r2)
            if (r2 == 0) goto L_0x0068
            goto L_0x00ba
        L_0x0068:
            java.lang.String r2 = "ec-3"
            boolean r2 = r1.startsWith(r2)
            if (r2 != 0) goto L_0x00b7
            java.lang.String r2 = "dec3"
            boolean r2 = r1.startsWith(r2)
            if (r2 == 0) goto L_0x0079
            goto L_0x00b7
        L_0x0079:
            java.lang.String r2 = "dtsc"
            boolean r2 = r1.startsWith(r2)
            if (r2 != 0) goto L_0x00b4
            java.lang.String r2 = "dtse"
            boolean r2 = r1.startsWith(r2)
            if (r2 == 0) goto L_0x008a
            goto L_0x00b4
        L_0x008a:
            java.lang.String r2 = "dtsh"
            boolean r2 = r1.startsWith(r2)
            if (r2 != 0) goto L_0x00b1
            java.lang.String r2 = "dtsl"
            boolean r2 = r1.startsWith(r2)
            if (r2 == 0) goto L_0x009b
            goto L_0x00b1
        L_0x009b:
            java.lang.String r2 = "opus"
            boolean r2 = r1.startsWith(r2)
            if (r2 == 0) goto L_0x00a6
            java.lang.String r1 = "audio/opus"
            goto L_0x00c4
        L_0x00a6:
            java.lang.String r2 = "vorbis"
            boolean r1 = r1.startsWith(r2)
            if (r1 == 0) goto L_0x00c3
            java.lang.String r1 = "audio/vorbis"
            goto L_0x00c4
        L_0x00b1:
            java.lang.String r1 = "audio/vnd.dts.hd"
            goto L_0x00c4
        L_0x00b4:
            java.lang.String r1 = "audio/vnd.dts"
            goto L_0x00c4
        L_0x00b7:
            java.lang.String r1 = "audio/eac3"
            goto L_0x00c4
        L_0x00ba:
            java.lang.String r1 = "audio/ac3"
            goto L_0x00c4
        L_0x00bd:
            java.lang.String r1 = "video/hevc"
            goto L_0x00c4
        L_0x00c0:
            java.lang.String r1 = "video/avc"
            goto L_0x00c4
        L_0x00c3:
            r1 = 0
        L_0x00c4:
            if (r1 != 0) goto L_0x00c7
            return r0
        L_0x00c7:
            java.lang.String r2 = r11.mimeType
            boolean r2 = r2.equals(r1)
            java.lang.String r3 = ", "
            r4 = 0
            if (r2 != 0) goto L_0x0100
            java.lang.String r0 = java.lang.String.valueOf(r12)
            int r0 = r0.length()
            int r0 = r0 + 13
            java.lang.String r2 = java.lang.String.valueOf(r1)
            int r2 = r2.length()
            int r0 = r0 + r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r0)
            java.lang.String r0 = "codec.mime "
            r2.append(r0)
            r2.append(r12)
            r2.append(r3)
            r2.append(r1)
            java.lang.String r12 = r2.toString()
            r11.zzba(r12)
            return r4
        L_0x0100:
            android.util.Pair r2 = com.google.android.gms.internal.ads.zzkp.zzbb(r12)
            if (r2 != 0) goto L_0x0107
            return r0
        L_0x0107:
            android.media.MediaCodecInfo$CodecProfileLevel[] r5 = r11.zzgu()
            int r6 = r5.length
            r7 = 0
        L_0x010d:
            if (r7 >= r6) goto L_0x012d
            r8 = r5[r7]
            int r9 = r8.profile
            java.lang.Object r10 = r2.first
            java.lang.Integer r10 = (java.lang.Integer) r10
            int r10 = r10.intValue()
            if (r9 != r10) goto L_0x012a
            int r8 = r8.level
            java.lang.Object r9 = r2.second
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r9 = r9.intValue()
            if (r8 < r9) goto L_0x012a
            return r0
        L_0x012a:
            int r7 = r7 + 1
            goto L_0x010d
        L_0x012d:
            java.lang.String r0 = java.lang.String.valueOf(r12)
            int r0 = r0.length()
            int r0 = r0 + 22
            java.lang.String r2 = java.lang.String.valueOf(r1)
            int r2 = r2.length()
            int r0 = r0 + r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r0)
            java.lang.String r0 = "codec.profileLevel, "
            r2.append(r0)
            r2.append(r12)
            r2.append(r3)
            r2.append(r1)
            java.lang.String r12 = r2.toString()
            r11.zzba(r12)
            return r4
        L_0x015b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkm.zzaz(java.lang.String):boolean");
    }

    @TargetApi(21)
    public final boolean zza(int i, int i2, double d) {
        CodecCapabilities codecCapabilities = this.zzayz;
        if (codecCapabilities == null) {
            zzba("sizeAndRate.caps");
            return false;
        }
        VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            zzba("sizeAndRate.vCaps");
            return false;
        }
        if (!zza(videoCapabilities, i, i2, d)) {
            String str = "x";
            if (i >= i2 || !zza(videoCapabilities, i2, i, d)) {
                StringBuilder sb = new StringBuilder(69);
                sb.append("sizeAndRate.support, ");
                sb.append(i);
                sb.append(str);
                sb.append(i2);
                sb.append(str);
                sb.append(d);
                zzba(sb.toString());
                return false;
            }
            StringBuilder sb2 = new StringBuilder(69);
            sb2.append("sizeAndRate.rotated, ");
            sb2.append(i);
            sb2.append(str);
            sb2.append(i2);
            sb2.append(str);
            sb2.append(d);
            String sb3 = sb2.toString();
            String str2 = this.name;
            String str3 = this.mimeType;
            String str4 = zzof.zzbgt;
            StringBuilder sb4 = new StringBuilder(String.valueOf(sb3).length() + 25 + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length());
            sb4.append("AssumedSupport [");
            sb4.append(sb3);
            String str5 = "] [";
            sb4.append(str5);
            sb4.append(str2);
            sb4.append(", ");
            sb4.append(str3);
            sb4.append(str5);
            sb4.append(str4);
            sb4.append("]");
            Log.d("MediaCodecInfo", sb4.toString());
        }
        return true;
    }

    @TargetApi(21)
    public final Point zzc(int i, int i2) {
        CodecCapabilities codecCapabilities = this.zzayz;
        if (codecCapabilities == null) {
            zzba("align.caps");
            return null;
        }
        VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            zzba("align.vCaps");
            return null;
        }
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        return new Point(zzof.zze(i, widthAlignment) * widthAlignment, zzof.zze(i2, heightAlignment) * heightAlignment);
    }

    @TargetApi(21)
    public final boolean zzap(int i) {
        CodecCapabilities codecCapabilities = this.zzayz;
        if (codecCapabilities == null) {
            zzba("sampleRate.caps");
            return false;
        }
        AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            zzba("sampleRate.aCaps");
            return false;
        } else if (audioCapabilities.isSampleRateSupported(i)) {
            return true;
        } else {
            StringBuilder sb = new StringBuilder(31);
            sb.append("sampleRate.support, ");
            sb.append(i);
            zzba(sb.toString());
            return false;
        }
    }

    @TargetApi(21)
    public final boolean zzaq(int i) {
        CodecCapabilities codecCapabilities = this.zzayz;
        if (codecCapabilities == null) {
            zzba("channelCount.caps");
            return false;
        }
        AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            zzba("channelCount.aCaps");
            return false;
        } else if (audioCapabilities.getMaxInputChannelCount() >= i) {
            return true;
        } else {
            StringBuilder sb = new StringBuilder(33);
            sb.append("channelCount.support, ");
            sb.append(i);
            zzba(sb.toString());
            return false;
        }
    }

    private final void zzba(String str) {
        String str2 = this.name;
        String str3 = this.mimeType;
        String str4 = zzof.zzbgt;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 20 + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length());
        sb.append("NoSupport [");
        sb.append(str);
        String str5 = "] [";
        sb.append(str5);
        sb.append(str2);
        sb.append(", ");
        sb.append(str3);
        sb.append(str5);
        sb.append(str4);
        sb.append("]");
        Log.d("MediaCodecInfo", sb.toString());
    }

    @TargetApi(21)
    private static boolean zza(VideoCapabilities videoCapabilities, int i, int i2, double d) {
        if (d == -1.0d || d <= 0.0d) {
            return videoCapabilities.isSizeSupported(i, i2);
        }
        return videoCapabilities.areSizeAndRateSupported(i, i2, d);
    }
}
