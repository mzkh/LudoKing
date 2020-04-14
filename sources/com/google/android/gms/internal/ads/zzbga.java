package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbga extends zzwa {
    private final zzaxl zzblk;
    private final zzasl zzbnf;
    private final zzchm zzfah;
    private final zzcge<zzcwm, zzchn> zzfai;
    private final zzclr zzfaj;
    private final zzccj zzfak;
    private final Context zzlk;
    @GuardedBy("this")
    private boolean zzye = false;

    zzbga(Context context, zzaxl zzaxl, zzchm zzchm, zzcge<zzcwm, zzchn> zzcge, zzclr zzclr, zzccj zzccj, zzasl zzasl) {
        this.zzlk = context;
        this.zzblk = zzaxl;
        this.zzfah = zzchm;
        this.zzfai = zzcge;
        this.zzfaj = zzclr;
        this.zzfak = zzccj;
        this.zzbnf = zzasl;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0045, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void initialize() {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.zzye     // Catch:{ all -> 0x0046 }
            if (r0 == 0) goto L_0x000c
            java.lang.String r0 = "Mobile ads is initialized already."
            com.google.android.gms.internal.ads.zzaug.zzeu(r0)     // Catch:{ all -> 0x0046 }
            monitor-exit(r3)
            return
        L_0x000c:
            android.content.Context r0 = r3.zzlk     // Catch:{ all -> 0x0046 }
            com.google.android.gms.internal.ads.zzza.initialize(r0)     // Catch:{ all -> 0x0046 }
            com.google.android.gms.internal.ads.zzatr r0 = com.google.android.gms.ads.internal.zzq.zzkn()     // Catch:{ all -> 0x0046 }
            android.content.Context r1 = r3.zzlk     // Catch:{ all -> 0x0046 }
            com.google.android.gms.internal.ads.zzaxl r2 = r3.zzblk     // Catch:{ all -> 0x0046 }
            r0.zzd(r1, r2)     // Catch:{ all -> 0x0046 }
            com.google.android.gms.internal.ads.zzrh r0 = com.google.android.gms.ads.internal.zzq.zzkp()     // Catch:{ all -> 0x0046 }
            android.content.Context r1 = r3.zzlk     // Catch:{ all -> 0x0046 }
            r0.initialize(r1)     // Catch:{ all -> 0x0046 }
            r0 = 1
            r3.zzye = r0     // Catch:{ all -> 0x0046 }
            com.google.android.gms.internal.ads.zzccj r0 = r3.zzfak     // Catch:{ all -> 0x0046 }
            r0.zzaka()     // Catch:{ all -> 0x0046 }
            com.google.android.gms.internal.ads.zzyp<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzza.zzcmj     // Catch:{ all -> 0x0046 }
            com.google.android.gms.internal.ads.zzyw r1 = com.google.android.gms.internal.ads.zzuv.zzon()     // Catch:{ all -> 0x0046 }
            java.lang.Object r0 = r1.zzd(r0)     // Catch:{ all -> 0x0046 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x0046 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0046 }
            if (r0 == 0) goto L_0x0044
            com.google.android.gms.internal.ads.zzclr r0 = r3.zzfaj     // Catch:{ all -> 0x0046 }
            r0.zzaky()     // Catch:{ all -> 0x0046 }
        L_0x0044:
            monitor-exit(r3)
            return
        L_0x0046:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbga.initialize():void");
    }

    public final synchronized void setAppVolume(float f) {
        zzq.zzko().setAppVolume(f);
    }

    public final synchronized float zzos() {
        return zzq.zzko().zzos();
    }

    public final synchronized void setAppMuted(boolean z) {
        zzq.zzko().setAppMuted(z);
    }

    public final synchronized boolean zzot() {
        return zzq.zzko().zzot();
    }

    public final synchronized void zzby(String str) {
        zzza.initialize(this.zzlk);
        if (!TextUtils.isEmpty(str)) {
            if (((Boolean) zzuv.zzon().zzd(zzza.zzcow)).booleanValue()) {
                zzq.zzkr().zza(this.zzlk, this.zzblk, str, (Runnable) null);
            }
        }
    }

    public final void zzc(IObjectWrapper iObjectWrapper, String str) {
        if (iObjectWrapper == null) {
            zzaug.zzes("Wrapped context is null. Failed to open debug menu.");
            return;
        }
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        if (context == null) {
            zzaug.zzes("Context is null. Failed to open debug menu.");
            return;
        }
        zzavd zzavd = new zzavd(context);
        zzavd.setAdUnitId(str);
        zzavd.zzr(this.zzblk.zzblz);
        zzavd.showDialog();
    }

    public final void zzb(@Nullable String str, IObjectWrapper iObjectWrapper) {
        zzza.initialize(this.zzlk);
        String zzadu = ((Boolean) zzuv.zzon().zzd(zzza.zzcox)).booleanValue() ? zzadu() : "";
        if (!TextUtils.isEmpty(zzadu)) {
            str = zzadu;
        }
        if (!TextUtils.isEmpty(str)) {
            boolean booleanValue = ((Boolean) zzuv.zzon().zzd(zzza.zzcow)).booleanValue() | ((Boolean) zzuv.zzon().zzd(zzza.zzckj)).booleanValue();
            zzbgd zzbgd = null;
            if (((Boolean) zzuv.zzon().zzd(zzza.zzckj)).booleanValue()) {
                booleanValue = true;
                zzbgd = new zzbgd(this, (Runnable) ObjectWrapper.unwrap(iObjectWrapper));
            }
            if (booleanValue) {
                zzq.zzkr().zza(this.zzlk, this.zzblk, str, (Runnable) zzbgd);
            }
        }
    }

    public final String getVersionString() {
        return this.zzblk.zzblz;
    }

    public final void zzbz(String str) {
        this.zzfaj.zzgd(str);
    }

    public final void zza(zzajx zzajx) throws RemoteException {
        this.zzfah.zzb(zzajx);
    }

    public final void zza(zzafu zzafu) throws RemoteException {
        this.zzfak.zzb(zzafu);
    }

    public final List<zzafr> zzou() throws RemoteException {
        return this.zzfak.zzakb();
    }

    private final String zzadu() {
        String str = "";
        Context applicationContext = this.zzlk.getApplicationContext() == null ? this.zzlk : this.zzlk.getApplicationContext();
        try {
            String string = Wrappers.packageManager(applicationContext).getApplicationInfo(applicationContext.getPackageName(), 128).metaData.getString("com.google.android.gms.ads.APPLICATION_ID");
            if (TextUtils.isEmpty(string)) {
                return str;
            }
            return (string.matches("^ca-app-pub-[0-9]{16}~[0-9]{10}$") || string.matches("^/\\d+~.+$")) ? string : str;
        } catch (NameNotFoundException | NullPointerException e) {
            zzaug.zza("Error getting metadata", e);
            return str;
        }
    }

    public final void zza(zzyd zzyd) throws RemoteException {
        this.zzbnf.zza(this.zzlk, zzyd);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzd(Runnable runnable) {
        Preconditions.checkMainThread("Adapters must be initialized on the main thread.");
        Map zzup = zzq.zzkn().zzuh().zzve().zzup();
        if (zzup != null && !zzup.isEmpty()) {
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Throwable th) {
                    zzaug.zzd("Could not initialize rewarded ads.", th);
                    return;
                }
            }
            if (this.zzfah.zzakt()) {
                HashMap hashMap = new HashMap();
                for (zzajs zzajs : zzup.values()) {
                    for (zzajt zzajt : zzajs.zzdbw) {
                        String str = zzajt.zzddb;
                        for (String str2 : zzajt.zzdct) {
                            if (!hashMap.containsKey(str2)) {
                                hashMap.put(str2, new ArrayList());
                            }
                            if (str != null) {
                                ((Collection) hashMap.get(str2)).add(str);
                            }
                        }
                    }
                }
                JSONObject jSONObject = new JSONObject();
                for (Entry entry : hashMap.entrySet()) {
                    String str3 = (String) entry.getKey();
                    try {
                        zzcgf zzd = this.zzfai.zzd(str3, jSONObject);
                        if (zzd != null) {
                            zzcwm zzcwm = (zzcwm) zzd.zzddv;
                            if (!zzcwm.isInitialized()) {
                                if (zzcwm.zzrt()) {
                                    zzcwm.zza(this.zzlk, (zzaqp) (zzchn) zzd.zzfxg, (List) entry.getValue());
                                    String str4 = "Initialized rewarded video mediation adapter ";
                                    String valueOf = String.valueOf(str3);
                                    zzaug.zzdv(valueOf.length() != 0 ? str4.concat(valueOf) : new String(str4));
                                }
                            }
                        }
                    } catch (zzcwh e) {
                        StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 56);
                        sb.append("Failed to initialize rewarded video mediation adapter \"");
                        sb.append(str3);
                        sb.append("\"");
                        zzaug.zzd(sb.toString(), e);
                    }
                }
            }
        }
    }
}
