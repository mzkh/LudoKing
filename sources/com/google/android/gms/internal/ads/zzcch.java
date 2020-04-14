package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.internal.zzq;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcch implements AppEventListener, zzbna, zzbnb, zzbnj, zzbnm, zzbog, zzbpc, zzcym, zztp {
    private long startTime;
    private final List<Object> zzdwa;
    private final zzcbv zzfsq;

    public zzcch(zzcbv zzcbv, zzbei zzbei) {
        this.zzfsq = zzcbv;
        this.zzdwa = Collections.singletonList(zzbei);
    }

    public final void zza(zzcvz zzcvz) {
    }

    public final void zzbu(Context context) {
        zza(zzbnm.class, "onPause", context);
    }

    public final void zzbv(Context context) {
        zza(zzbnm.class, "onResume", context);
    }

    public final void zzbw(Context context) {
        zza(zzbnm.class, "onDestroy", context);
    }

    public final void onAppEvent(String str, String str2) {
        zza(AppEventListener.class, "onAppEvent", str, str2);
    }

    public final void onAdLoaded() {
        long elapsedRealtime = zzq.zzkq().elapsedRealtime() - this.startTime;
        StringBuilder sb = new StringBuilder(41);
        sb.append("Ad Request Latency : ");
        sb.append(elapsedRealtime);
        zzaug.zzdy(sb.toString());
        zza(zzbog.class, "onAdLoaded", new Object[0]);
    }

    public final void onAdFailedToLoad(int i) {
        zza(zzbnb.class, "onAdFailedToLoad", Integer.valueOf(i));
    }

    public final void onAdOpened() {
        zza(zzbna.class, "onAdOpened", new Object[0]);
    }

    public final void onAdClosed() {
        zza(zzbna.class, "onAdClosed", new Object[0]);
    }

    public final void onAdLeftApplication() {
        zza(zzbna.class, "onAdLeftApplication", new Object[0]);
    }

    public final void onAdClicked() {
        zza(zztp.class, "onAdClicked", new Object[0]);
    }

    public final void onAdImpression() {
        zza(zzbnj.class, "onAdImpression", new Object[0]);
    }

    public final void onRewardedVideoStarted() {
        zza(zzbna.class, "onRewardedVideoStarted", new Object[0]);
    }

    @ParametersAreNonnullByDefault
    public final void zzb(zzapy zzapy, String str, String str2) {
        zza(zzbna.class, "onRewarded", zzapy, str, str2);
    }

    public final void onRewardedVideoCompleted() {
        zza(zzbna.class, "onRewardedVideoCompleted", new Object[0]);
    }

    public final void zza(zzcyd zzcyd, String str) {
        zza(zzcye.class, "onTaskCreated", str);
    }

    public final void zzb(zzcyd zzcyd, String str) {
        zza(zzcye.class, "onTaskStarted", str);
    }

    public final void zza(zzcyd zzcyd, String str, Throwable th) {
        zza(zzcye.class, "onTaskFailed", str, th.getClass().getSimpleName());
    }

    public final void zzc(zzcyd zzcyd, String str) {
        zza(zzcye.class, "onTaskSucceeded", str);
    }

    private final void zza(Class<?> cls, String str, Object... objArr) {
        zzcbv zzcbv = this.zzfsq;
        List<Object> list = this.zzdwa;
        String valueOf = String.valueOf(cls.getSimpleName());
        String str2 = "Event-";
        zzcbv.zza(list, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), str, objArr);
    }

    public final void zzb(zzape zzape) {
        this.startTime = zzq.zzkq().elapsedRealtime();
        zza(zzbpc.class, "onAdRequest", new Object[0]);
    }
}
