package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzckr implements zzboc {
    private final /* synthetic */ zzcgf zzfzw;
    private final /* synthetic */ zzaxv zzgak;

    zzckr(zzckm zzckm, zzaxv zzaxv, zzcgf zzcgf) {
        this.zzgak = zzaxv;
        this.zzfzw = zzcgf;
    }

    public final synchronized void onAdFailedToLoad(int i) {
        if (((Boolean) zzuv.zzon().zzd(zzza.zzcrm)).booleanValue()) {
            i = 3;
        }
        zzaxv zzaxv = this.zzgak;
        String str = this.zzfzw.zzffi;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 23);
        sb.append("adapter ");
        sb.append(str);
        sb.append(" failed to load");
        zzaxv.setException(new zzcjh(sb.toString(), i));
    }

    public final synchronized void onAdLoaded() {
        this.zzgak.set(null);
    }
}
