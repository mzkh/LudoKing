package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public class zzckt extends zzakc {
    private final zzbob zzffh;
    private final zzbnr zzffv;
    private final zzboo zzfio;
    private final zzbni zzfjm;
    private final zzbmv zzfjn;
    private final zzbpf zzfpz;
    private final zzbrl zzgan;

    public zzckt(zzbmv zzbmv, zzbni zzbni, zzbnr zzbnr, zzbob zzbob, zzbpf zzbpf, zzboo zzboo, zzbrl zzbrl) {
        this.zzfjn = zzbmv;
        this.zzfjm = zzbni;
        this.zzffv = zzbnr;
        this.zzffh = zzbob;
        this.zzfpz = zzbpf;
        this.zzfio = zzboo;
        this.zzgan = zzbrl;
    }

    public final void onAdFailedToLoad(int i) {
    }

    public final void zza(zzace zzace, String str) {
    }

    public final void zza(zzake zzake) {
    }

    public void zza(zzaqv zzaqv) throws RemoteException {
    }

    public void zzb(Bundle bundle) throws RemoteException {
    }

    public void zzb(zzaqt zzaqt) {
    }

    public void zzcl(int i) throws RemoteException {
    }

    public final void zzde(String str) {
    }

    public void zzrx() throws RemoteException {
    }

    public final void onAdClicked() {
        this.zzfjn.onAdClicked();
    }

    public final void onAdClosed() {
        this.zzfio.zzsi();
    }

    public final void onAdLeftApplication() {
        this.zzffv.onAdLeftApplication();
    }

    public final void onAdOpened() {
        this.zzfio.zzsj();
    }

    public final void onAppEvent(String str, String str2) {
        this.zzfpz.onAppEvent(str, str2);
    }

    public final void onAdLoaded() {
        this.zzffh.onAdLoaded();
    }

    public final void onAdImpression() {
        this.zzfjm.onAdImpression();
    }

    public final void onVideoPause() {
        this.zzgan.onVideoPause();
    }

    public void zzrw() {
        this.zzgan.onVideoStart();
    }

    public void onVideoEnd() {
        this.zzgan.onVideoEnd();
    }

    public final void onVideoPlay() throws RemoteException {
        this.zzgan.onVideoPlay();
    }
}
