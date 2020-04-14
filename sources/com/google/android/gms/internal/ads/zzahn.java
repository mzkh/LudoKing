package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzq;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzahn {
    /* access modifiers changed from: private */
    public final Object lock;
    /* access modifiers changed from: private */
    public int status;
    private final zzaxl zzblk;
    private final String zzczt;
    /* access modifiers changed from: private */
    public zzavr<zzaha> zzczu;
    private zzavr<zzaha> zzczv;
    /* access modifiers changed from: private */
    @Nullable
    public zzaie zzczw;
    private final Context zzlk;

    public zzahn(Context context, zzaxl zzaxl, String str) {
        this.lock = new Object();
        this.status = 1;
        this.zzczt = str;
        this.zzlk = context.getApplicationContext();
        this.zzblk = zzaxl;
        this.zzczu = new zzaib();
        this.zzczv = new zzaib();
    }

    public zzahn(Context context, zzaxl zzaxl, String str, zzavr<zzaha> zzavr, zzavr<zzaha> zzavr2) {
        this(context, zzaxl, str);
        this.zzczu = zzavr;
        this.zzczv = zzavr2;
    }

    /* access modifiers changed from: protected */
    public final zzaie zza(@Nullable zzdf zzdf) {
        zzaie zzaie = new zzaie(this.zzczv);
        zzaxn.zzdwm.execute(new zzahm(this, zzdf, zzaie));
        zzaie.zza(new zzahw(this, zzaie), new zzahz(this, zzaie));
        return zzaie;
    }

    public final zzaia zzb(@Nullable zzdf zzdf) {
        synchronized (this.lock) {
            synchronized (this.lock) {
                if (this.zzczw != null && this.status == 0) {
                    if (((Boolean) zzuv.zzon().zzd(zzza.zzcgl)).booleanValue()) {
                        this.zzczw.zza(new zzahp(this), zzaho.zzczx);
                    }
                }
            }
            if (this.zzczw != null) {
                if (this.zzczw.getStatus() != -1) {
                    if (this.status == 0) {
                        zzaia zzrg = this.zzczw.zzrg();
                        return zzrg;
                    } else if (this.status == 1) {
                        this.status = 2;
                        zza((zzdf) null);
                        zzaia zzrg2 = this.zzczw.zzrg();
                        return zzrg2;
                    } else if (this.status == 2) {
                        zzaia zzrg3 = this.zzczw.zzrg();
                        return zzrg3;
                    } else {
                        zzaia zzrg4 = this.zzczw.zzrg();
                        return zzrg4;
                    }
                }
            }
            this.status = 2;
            this.zzczw = zza((zzdf) null);
            zzaia zzrg5 = this.zzczw.zzrg();
            return zzrg5;
        }
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zza(zzaha zzaha) {
        if (zzaha.isDestroyed()) {
            this.status = 1;
        }
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zza(zzdf zzdf, zzaie zzaie) {
        zzaha zzaha;
        try {
            Context context = this.zzlk;
            zzaxl zzaxl = this.zzblk;
            if (((Boolean) zzuv.zzon().zzd(zzza.zzcjy)).booleanValue()) {
                zzaha = new zzagm(context, zzaxl);
            } else {
                zzaha = new zzahc(context, zzaxl, zzdf, null);
            }
            zzaha.zza(new zzahr(this, zzaie, zzaha));
            zzaha.zza("/jsLoaded", new zzahs(this, zzaie, zzaha));
            zzawn zzawn = new zzawn();
            zzahv zzahv = new zzahv(this, zzdf, zzaha, zzawn);
            zzawn.set(zzahv);
            zzaha.zza("/requestReload", zzahv);
            if (this.zzczt.endsWith(".js")) {
                zzaha.zzcq(this.zzczt);
            } else if (this.zzczt.startsWith("<html>")) {
                zzaha.zzcr(this.zzczt);
            } else {
                zzaha.zzcs(this.zzczt);
            }
            zzaul.zzdsu.postDelayed(new zzahu(this, zzaie, zzaha), (long) zzahy.zzdah);
        } catch (Throwable th) {
            zzaug.zzc("Error creating webview.", th);
            zzq.zzkn().zza(th, "SdkJavascriptFactory.loadJavascriptEngine");
            zzaie.reject();
        }
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0029, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void zza(com.google.android.gms.internal.ads.zzaie r4, com.google.android.gms.internal.ads.zzaha r5) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.lock
            monitor-enter(r0)
            int r1 = r4.getStatus()     // Catch:{ all -> 0x002a }
            r2 = -1
            if (r1 == r2) goto L_0x0028
            int r1 = r4.getStatus()     // Catch:{ all -> 0x002a }
            r2 = 1
            if (r1 != r2) goto L_0x0012
            goto L_0x0028
        L_0x0012:
            r4.reject()     // Catch:{ all -> 0x002a }
            com.google.android.gms.internal.ads.zzddl r4 = com.google.android.gms.internal.ads.zzaxn.zzdwm     // Catch:{ all -> 0x002a }
            r5.getClass()     // Catch:{ all -> 0x002a }
            java.lang.Runnable r5 = com.google.android.gms.internal.ads.zzaht.zzb(r5)     // Catch:{ all -> 0x002a }
            r4.execute(r5)     // Catch:{ all -> 0x002a }
            java.lang.String r4 = "Could not receive loaded message in a timely manner. Rejecting."
            com.google.android.gms.internal.ads.zzaug.zzdy(r4)     // Catch:{ all -> 0x002a }
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            return
        L_0x0028:
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            return
        L_0x002a:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzahn.zza(com.google.android.gms.internal.ads.zzaie, com.google.android.gms.internal.ads.zzaha):void");
    }
}
