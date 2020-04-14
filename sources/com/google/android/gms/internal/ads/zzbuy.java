package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbuy {
    public static final zzbuy zzfmf = new zzbva().zzail();
    @Nullable
    private final zzacn zzfly;
    @Nullable
    private final zzaci zzflz;
    @Nullable
    private final zzacz zzfma;
    @Nullable
    private final zzacu zzfmb;
    @Nullable
    private final zzagj zzfmc;
    private final SimpleArrayMap<String, zzact> zzfmd;
    private final SimpleArrayMap<String, zzaco> zzfme;

    @Nullable
    public final zzacn zzaie() {
        return this.zzfly;
    }

    @Nullable
    public final zzaci zzaif() {
        return this.zzflz;
    }

    @Nullable
    public final zzacz zzaig() {
        return this.zzfma;
    }

    @Nullable
    public final zzacu zzaih() {
        return this.zzfmb;
    }

    @Nullable
    public final zzagj zzaii() {
        return this.zzfmc;
    }

    @Nullable
    public final zzact zzfu(String str) {
        return (zzact) this.zzfmd.get(str);
    }

    @Nullable
    public final zzaco zzfv(String str) {
        return (zzaco) this.zzfme.get(str);
    }

    public final ArrayList<String> zzaij() {
        ArrayList<String> arrayList = new ArrayList<>();
        if (this.zzfma != null) {
            arrayList.add(Integer.toString(6));
        }
        if (this.zzfly != null) {
            arrayList.add(Integer.toString(1));
        }
        if (this.zzflz != null) {
            arrayList.add(Integer.toString(2));
        }
        if (this.zzfmd.size() > 0) {
            arrayList.add(Integer.toString(3));
        }
        if (this.zzfmc != null) {
            arrayList.add(Integer.toString(7));
        }
        return arrayList;
    }

    public final ArrayList<String> zzaik() {
        ArrayList<String> arrayList = new ArrayList<>(this.zzfmd.size());
        for (int i = 0; i < this.zzfmd.size(); i++) {
            arrayList.add((String) this.zzfmd.keyAt(i));
        }
        return arrayList;
    }

    private zzbuy(zzbva zzbva) {
        this.zzfly = zzbva.zzfly;
        this.zzflz = zzbva.zzflz;
        this.zzfma = zzbva.zzfma;
        this.zzfmd = new SimpleArrayMap<>(zzbva.zzfmd);
        this.zzfme = new SimpleArrayMap<>(zzbva.zzfme);
        this.zzfmb = zzbva.zzfmb;
        this.zzfmc = zzbva.zzfmc;
    }
}
