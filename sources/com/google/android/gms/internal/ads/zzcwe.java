package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.formats.NativeAdOptions.Builder;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import java.util.ArrayList;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcwe {
    public final zzua zzbll;
    public final zzaay zzdeh;
    @Nullable
    public final zzagd zzdkl;
    public final int zzgdf;
    @Nullable
    public final zzvz zzgke;
    @Nullable
    public final zzyj zzgkf;
    public final zztx zzgkg;
    public final String zzgkh;
    public final ArrayList<String> zzgki;
    public final ArrayList<String> zzgkj;
    public final zzuf zzgkk;
    public final PublisherAdViewOptions zzgkl;
    public final zzvt zzgkm;
    public final Set<String> zzgkn;

    private zzcwe(zzcwg zzcwg) {
        this.zzbll = zzcwg.zzbll;
        this.zzgkh = zzcwg.zzgkh;
        this.zzgke = zzcwg.zzgke;
        zztx zztx = new zztx(zzcwg.zzgkg.versionCode, zzcwg.zzgkg.zzcbx, zzcwg.zzgkg.extras, zzcwg.zzgkg.zzcby, zzcwg.zzgkg.zzcbz, zzcwg.zzgkg.zzcca, zzcwg.zzgkg.zzabj, zzcwg.zzgkg.zzbkg || zzcwg.zzbkg, zzcwg.zzgkg.zzccb, zzcwg.zzgkg.zzccc, zzcwg.zzgkg.zzng, zzcwg.zzgkg.zzccd, zzcwg.zzgkg.zzcce, zzcwg.zzgkg.zzccf, zzcwg.zzgkg.zzccg, zzcwg.zzgkg.zzcch, zzcwg.zzgkg.zzcci, zzcwg.zzgkg.zzccj, zzcwg.zzgkg.zzcck, zzcwg.zzgkg.zzabk, zzcwg.zzgkg.zzabl);
        this.zzgkg = zztx;
        zzaay zzaay = null;
        zzyj zzyj = zzcwg.zzgkf != null ? zzcwg.zzgkf : zzcwg.zzdeh != null ? zzcwg.zzdeh.zzcwa : null;
        this.zzgkf = zzyj;
        this.zzgki = zzcwg.zzgki;
        this.zzgkj = zzcwg.zzgkj;
        if (zzcwg.zzgki != null) {
            if (zzcwg.zzdeh == null) {
                zzaay = new zzaay(new Builder().build());
            } else {
                zzaay = zzcwg.zzdeh;
            }
        }
        this.zzdeh = zzaay;
        this.zzgkk = zzcwg.zzgkk;
        this.zzgdf = zzcwg.zzgdf;
        this.zzgkl = zzcwg.zzgkl;
        this.zzgkm = zzcwg.zzgkm;
        this.zzdkl = zzcwg.zzdkl;
        this.zzgkn = zzcwg.zzgkn;
    }

    public final zzada zzana() {
        PublisherAdViewOptions publisherAdViewOptions = this.zzgkl;
        if (publisherAdViewOptions == null) {
            return null;
        }
        return publisherAdViewOptions.zzjh();
    }
}
