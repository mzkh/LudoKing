package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcwg {
    /* access modifiers changed from: private */
    public boolean zzbkg;
    /* access modifiers changed from: private */
    public zzua zzbll;
    /* access modifiers changed from: private */
    public zzaay zzdeh;
    /* access modifiers changed from: private */
    public zzagd zzdkl;
    /* access modifiers changed from: private */
    public int zzgdf = 1;
    /* access modifiers changed from: private */
    public zzvz zzgke;
    /* access modifiers changed from: private */
    public zzyj zzgkf;
    /* access modifiers changed from: private */
    public zztx zzgkg;
    /* access modifiers changed from: private */
    public String zzgkh;
    /* access modifiers changed from: private */
    public ArrayList<String> zzgki;
    /* access modifiers changed from: private */
    public ArrayList<String> zzgkj;
    /* access modifiers changed from: private */
    public zzuf zzgkk;
    /* access modifiers changed from: private */
    public PublisherAdViewOptions zzgkl;
    /* access modifiers changed from: private */
    @Nullable
    public zzvt zzgkm;
    public final Set<String> zzgkn = new HashSet();

    public final zzcwg zzg(zztx zztx) {
        this.zzgkg = zztx;
        return this;
    }

    public final zztx zzanc() {
        return this.zzgkg;
    }

    public final zzcwg zzd(zzua zzua) {
        this.zzbll = zzua;
        return this;
    }

    public final zzua zzjt() {
        return this.zzbll;
    }

    public final zzcwg zzc(zzvz zzvz) {
        this.zzgke = zzvz;
        return this;
    }

    public final zzcwg zzgf(String str) {
        this.zzgkh = str;
        return this;
    }

    public final String zzand() {
        return this.zzgkh;
    }

    public final zzcwg zzc(zzyj zzyj) {
        this.zzgkf = zzyj;
        return this;
    }

    public final zzcwg zzbe(boolean z) {
        this.zzbkg = z;
        return this;
    }

    public final zzcwg zzdi(int i) {
        this.zzgdf = i;
        return this;
    }

    public final zzcwg zzb(ArrayList<String> arrayList) {
        this.zzgki = arrayList;
        return this;
    }

    public final zzcwg zzc(ArrayList<String> arrayList) {
        this.zzgkj = arrayList;
        return this;
    }

    public final zzcwg zzb(zzaay zzaay) {
        this.zzdeh = zzaay;
        return this;
    }

    public final zzcwg zzb(zzuf zzuf) {
        this.zzgkk = zzuf;
        return this;
    }

    public final zzcwg zzb(zzagd zzagd) {
        this.zzdkl = zzagd;
        this.zzgkf = new zzyj(false, true, false);
        return this;
    }

    public final zzcwg zzb(PublisherAdViewOptions publisherAdViewOptions) {
        this.zzgkl = publisherAdViewOptions;
        if (publisherAdViewOptions != null) {
            this.zzbkg = publisherAdViewOptions.getManualImpressionsEnabled();
            this.zzgkm = publisherAdViewOptions.zzjg();
        }
        return this;
    }

    public final zzcwe zzane() {
        Preconditions.checkNotNull(this.zzgkh, "ad unit must not be null");
        Preconditions.checkNotNull(this.zzbll, "ad size must not be null");
        Preconditions.checkNotNull(this.zzgkg, "ad request must not be null");
        return new zzcwe(this);
    }
}
