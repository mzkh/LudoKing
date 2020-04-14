package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.reward.AdMetadataListener;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcui extends AdMetadataListener implements zzbna, zzbnb, zzbnf, zzbog {
    private final AtomicReference<AdMetadataListener> zzghv = new AtomicReference<>();
    private final AtomicReference<zzari> zzghw = new AtomicReference<>();
    private final AtomicReference<zzarb> zzghx = new AtomicReference<>();
    private final AtomicReference<zzaqi> zzghy = new AtomicReference<>();
    private final AtomicReference<zzarj> zzghz = new AtomicReference<>();
    private final AtomicReference<zzapz> zzgia = new AtomicReference<>();

    public final void zza(zzari zzari) {
        this.zzghw.set(zzari);
    }

    public final void zzb(zzarb zzarb) {
        this.zzghx.set(zzarb);
    }

    public final void zzb(zzarj zzarj) {
        this.zzghz.set(zzarj);
    }

    public final void zza(AdMetadataListener adMetadataListener) {
        this.zzghv.set(adMetadataListener);
    }

    @Deprecated
    public final void zzb(zzaqi zzaqi) {
        this.zzghy.set(zzaqi);
    }

    @Deprecated
    public final void zzb(zzapz zzapz) {
        this.zzgia.set(zzapz);
    }

    public final void onAdLoaded() {
        zza(this.zzghw, zzcuh.zzghu);
        zza(this.zzghy, zzcuk.zzghu);
    }

    public final void onAdFailedToLoad(int i) {
        zza(this.zzghw, new zzcus(i));
        zza(this.zzghy, new zzcur(i));
    }

    public final void onAdOpened() {
        zza(this.zzghx, zzcuu.zzghu);
        zza(this.zzghy, zzcut.zzghu);
    }

    public final void onAdClosed() {
        zza(this.zzghx, zzcuw.zzghu);
        zza(this.zzghy, zzcuv.zzghu);
    }

    public final void onAdLeftApplication() {
        zza(this.zzghy, zzcuy.zzghu);
    }

    public final void onRewardedVideoStarted() {
        zza(this.zzghy, zzcux.zzghu);
    }

    public final void zzb(zzapy zzapy, String str, String str2) {
        zza(this.zzghx, new zzcuj(zzapy));
        zza(this.zzghz, new zzcum(zzapy, str, str2));
        zza(this.zzghy, new zzcul(zzapy));
        zza(this.zzgia, new zzcuo(zzapy, str, str2));
    }

    public final void onRewardedVideoCompleted() {
        zza(this.zzghy, zzcun.zzghu);
    }

    public final void zzcl(int i) {
        zza(this.zzghx, new zzcuq(i));
    }

    public final void onAdMetadataChanged() {
        zza(this.zzghv, zzcup.zzghu);
    }

    private static <T> void zza(AtomicReference<T> atomicReference, zzcva<T> zzcva) {
        Object obj = atomicReference.get();
        if (obj != null) {
            try {
                zzcva.zzt(obj);
            } catch (RemoteException e) {
                zzaug.zze("#007 Could not call remote method.", e);
            }
        }
    }
}
