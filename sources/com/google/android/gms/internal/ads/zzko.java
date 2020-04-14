package com.google.android.gms.internal.ads;

import android.media.MediaCodec.CodecException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzko extends Exception {
    private final String mimeType;
    private final boolean zzazb;
    private final String zzazc;
    private final String zzazd;

    public zzko(zzgo zzgo, Throwable th, boolean z, int i) {
        String valueOf = String.valueOf(zzgo);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 36);
        sb.append("Decoder init failed: [");
        sb.append(i);
        sb.append("], ");
        sb.append(valueOf);
        super(sb.toString(), th);
        this.mimeType = zzgo.zzafc;
        this.zzazb = false;
        this.zzazc = null;
        String str = i < 0 ? "neg_" : "";
        int abs = Math.abs(i);
        StringBuilder sb2 = new StringBuilder(str.length() + 64);
        sb2.append("com.google.android.exoplayer.MediaCodecTrackRenderer_");
        sb2.append(str);
        sb2.append(abs);
        this.zzazd = sb2.toString();
    }

    public zzko(zzgo zzgo, Throwable th, boolean z, String str) {
        String valueOf = String.valueOf(zzgo);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 23 + String.valueOf(valueOf).length());
        sb.append("Decoder init failed: ");
        sb.append(str);
        sb.append(", ");
        sb.append(valueOf);
        super(sb.toString(), th);
        this.mimeType = zzgo.zzafc;
        this.zzazb = false;
        this.zzazc = str;
        String str2 = null;
        if (zzof.SDK_INT >= 21 && (th instanceof CodecException)) {
            str2 = ((CodecException) th).getDiagnosticInfo();
        }
        this.zzazd = str2;
    }
}
