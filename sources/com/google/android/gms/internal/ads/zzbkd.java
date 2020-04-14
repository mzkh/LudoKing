package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.google.android.gms.dynamic.IObjectWrapper;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbkd implements zzbnj, zzbog {
    private final zzaxl zzblk;
    @Nullable
    private final zzbbw zzczi;
    private final zzcvr zzfet;
    @GuardedBy("this")
    @Nullable
    private IObjectWrapper zzfeu;
    @GuardedBy("this")
    private boolean zzfev;
    private final Context zzlk;

    public zzbkd(Context context, @Nullable zzbbw zzbbw, zzcvr zzcvr, zzaxl zzaxl) {
        this.zzlk = context;
        this.zzczi = zzbbw;
        this.zzfet = zzcvr;
        this.zzblk = zzaxl;
    }

    public final synchronized void onAdLoaded() {
        if (!this.zzfev) {
            zzafj();
        }
    }

    public final synchronized void onAdImpression() {
        if (!this.zzfev) {
            zzafj();
        }
        if (!(!this.zzfet.zzdlo || this.zzfeu == null || this.zzczi == null)) {
            this.zzczi.zza("onSdkImpression", new ArrayMap());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void zzafj() {
        /*
            r10 = this;
            monitor-enter(r10)
            com.google.android.gms.internal.ads.zzcvr r0 = r10.zzfet     // Catch:{ all -> 0x008b }
            boolean r0 = r0.zzdlo     // Catch:{ all -> 0x008b }
            if (r0 != 0) goto L_0x0009
            monitor-exit(r10)
            return
        L_0x0009:
            com.google.android.gms.internal.ads.zzbbw r0 = r10.zzczi     // Catch:{ all -> 0x008b }
            if (r0 != 0) goto L_0x000f
            monitor-exit(r10)
            return
        L_0x000f:
            com.google.android.gms.internal.ads.zzanl r0 = com.google.android.gms.ads.internal.zzq.zzky()     // Catch:{ all -> 0x008b }
            android.content.Context r1 = r10.zzlk     // Catch:{ all -> 0x008b }
            boolean r0 = r0.zzp(r1)     // Catch:{ all -> 0x008b }
            if (r0 != 0) goto L_0x001d
            monitor-exit(r10)
            return
        L_0x001d:
            com.google.android.gms.internal.ads.zzaxl r0 = r10.zzblk     // Catch:{ all -> 0x008b }
            int r0 = r0.zzdwe     // Catch:{ all -> 0x008b }
            com.google.android.gms.internal.ads.zzaxl r1 = r10.zzblk     // Catch:{ all -> 0x008b }
            int r1 = r1.zzdwf     // Catch:{ all -> 0x008b }
            r2 = 23
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x008b }
            r3.<init>(r2)     // Catch:{ all -> 0x008b }
            r3.append(r0)     // Catch:{ all -> 0x008b }
            java.lang.String r0 = "."
            r3.append(r0)     // Catch:{ all -> 0x008b }
            r3.append(r1)     // Catch:{ all -> 0x008b }
            java.lang.String r5 = r3.toString()     // Catch:{ all -> 0x008b }
            com.google.android.gms.internal.ads.zzcvr r0 = r10.zzfet     // Catch:{ all -> 0x008b }
            org.json.JSONObject r0 = r0.zzgjo     // Catch:{ all -> 0x008b }
            java.lang.String r1 = "media_type"
            r2 = -1
            int r0 = r0.optInt(r1, r2)     // Catch:{ all -> 0x008b }
            if (r0 != 0) goto L_0x004a
            r0 = 0
            goto L_0x004c
        L_0x004a:
            java.lang.String r0 = "javascript"
        L_0x004c:
            r9 = r0
            com.google.android.gms.internal.ads.zzanl r4 = com.google.android.gms.ads.internal.zzq.zzky()     // Catch:{ all -> 0x008b }
            com.google.android.gms.internal.ads.zzbbw r0 = r10.zzczi     // Catch:{ all -> 0x008b }
            android.webkit.WebView r6 = r0.getWebView()     // Catch:{ all -> 0x008b }
            java.lang.String r7 = ""
            java.lang.String r8 = "javascript"
            com.google.android.gms.dynamic.IObjectWrapper r0 = r4.zza(r5, r6, r7, r8, r9)     // Catch:{ all -> 0x008b }
            r10.zzfeu = r0     // Catch:{ all -> 0x008b }
            com.google.android.gms.internal.ads.zzbbw r0 = r10.zzczi     // Catch:{ all -> 0x008b }
            android.view.View r0 = r0.getView()     // Catch:{ all -> 0x008b }
            com.google.android.gms.dynamic.IObjectWrapper r1 = r10.zzfeu     // Catch:{ all -> 0x008b }
            if (r1 == 0) goto L_0x0089
            if (r0 == 0) goto L_0x0089
            com.google.android.gms.internal.ads.zzanl r1 = com.google.android.gms.ads.internal.zzq.zzky()     // Catch:{ all -> 0x008b }
            com.google.android.gms.dynamic.IObjectWrapper r2 = r10.zzfeu     // Catch:{ all -> 0x008b }
            r1.zza(r2, r0)     // Catch:{ all -> 0x008b }
            com.google.android.gms.internal.ads.zzbbw r0 = r10.zzczi     // Catch:{ all -> 0x008b }
            com.google.android.gms.dynamic.IObjectWrapper r1 = r10.zzfeu     // Catch:{ all -> 0x008b }
            r0.zzaq(r1)     // Catch:{ all -> 0x008b }
            com.google.android.gms.internal.ads.zzanl r0 = com.google.android.gms.ads.internal.zzq.zzky()     // Catch:{ all -> 0x008b }
            com.google.android.gms.dynamic.IObjectWrapper r1 = r10.zzfeu     // Catch:{ all -> 0x008b }
            r0.zzae(r1)     // Catch:{ all -> 0x008b }
            r0 = 1
            r10.zzfev = r0     // Catch:{ all -> 0x008b }
        L_0x0089:
            monitor-exit(r10)
            return
        L_0x008b:
            r0 = move-exception
            monitor-exit(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbkd.zzafj():void");
    }
}
