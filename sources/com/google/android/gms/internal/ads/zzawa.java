package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzawa implements zzy {
    private final /* synthetic */ String zzduo;
    private final /* synthetic */ zzawb zzdup;

    zzawa(zzavy zzavy, String str, zzawb zzawb) {
        this.zzduo = str;
        this.zzdup = zzawb;
    }

    public final void zzc(zzae zzae) {
        String str = this.zzduo;
        String zzae2 = zzae.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 21 + String.valueOf(zzae2).length());
        sb.append("Failed to load URL: ");
        sb.append(str);
        sb.append("\n");
        sb.append(zzae2);
        zzaug.zzeu(sb.toString());
        this.zzdup.zzb(null);
    }
}
