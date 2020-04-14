package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomClickListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzadr extends zzacr {
    private final OnCustomClickListener zzcwv;

    public zzadr(OnCustomClickListener onCustomClickListener) {
        this.zzcwv = onCustomClickListener;
    }

    public final void zza(zzace zzace, String str) {
        this.zzcwv.onCustomClick(zzacj.zza(zzace), str);
    }
}
