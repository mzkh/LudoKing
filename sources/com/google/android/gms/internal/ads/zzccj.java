package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import com.google.android.gms.ads.internal.zzq;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzccj {
    /* access modifiers changed from: private */
    public final Executor executor;
    private final zzaxl zzblh;
    private final Context zzcfz;
    private final Executor zzfbx;
    private final ScheduledExecutorService zzfcx;
    private boolean zzfst = false;
    /* access modifiers changed from: private */
    @GuardedBy("this")
    public boolean zzfsu = false;
    /* access modifiers changed from: private */
    public final long zzfsv;
    /* access modifiers changed from: private */
    public final zzaxv<Boolean> zzfsw = new zzaxv<>();
    private final WeakReference<Context> zzfsx;
    private final zzchm zzfsy;
    /* access modifiers changed from: private */
    public final zzcbt zzfsz;
    private Map<String, zzafr> zzfta = new ConcurrentHashMap();

    public zzccj(Executor executor2, Context context, WeakReference<Context> weakReference, Executor executor3, zzchm zzchm, ScheduledExecutorService scheduledExecutorService, zzcbt zzcbt, zzaxl zzaxl) {
        this.zzfsy = zzchm;
        this.zzcfz = context;
        this.zzfsx = weakReference;
        this.executor = executor3;
        this.zzfcx = scheduledExecutorService;
        this.zzfbx = executor2;
        this.zzfsz = zzcbt;
        this.zzblh = zzaxl;
        this.zzfsv = zzq.zzkq().elapsedRealtime();
        zza("com.google.android.gms.ads.MobileAds", false, "", 0);
    }

    public final void zzb(zzafu zzafu) {
        this.zzfsw.addListener(new zzcci(this, zzafu), this.zzfbx);
    }

    public final void zzaka() {
        if (((Boolean) zzuv.zzon().zzd(zzza.zzcmo)).booleanValue()) {
            if (!((Boolean) zzuv.zzon().zzd(zzza.zzcmq)).booleanValue()) {
                if (this.zzblh.zzdwf >= ((Integer) zzuv.zzon().zzd(zzza.zzcmp)).intValue()) {
                    if (!this.zzfst) {
                        synchronized (this) {
                            if (!this.zzfst) {
                                this.zzfsz.zzajx();
                                this.zzfsw.addListener(new zzccl(this), this.executor);
                                this.zzfst = true;
                                zzddi zzakc = zzakc();
                                this.zzfcx.schedule(new zzccn(this), ((Long) zzuv.zzon().zzd(zzza.zzcms)).longValue(), TimeUnit.SECONDS);
                                zzdcy.zza(zzakc, new zzccq(this), this.executor);
                                return;
                            }
                            return;
                        }
                    }
                    return;
                }
            }
        }
        zza("com.google.android.gms.ads.MobileAds", true, "", 0);
        this.zzfsw.set(Boolean.valueOf(false));
    }

    public final List<zzafr> zzakb() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.zzfta.keySet()) {
            zzafr zzafr = (zzafr) this.zzfta.get(str);
            arrayList.add(new zzafr(str, zzafr.zzcyo, zzafr.zzcyp, zzafr.description));
        }
        return arrayList;
    }

    private final synchronized zzddi<String> zzakc() {
        String zzun = zzq.zzkn().zzuh().zzve().zzun();
        if (!TextUtils.isEmpty(zzun)) {
            return zzdcy.zzah(zzun);
        }
        zzaxv zzaxv = new zzaxv();
        zzq.zzkn().zzuh().zzb(new zzcck(this, zzaxv));
        return zzaxv;
    }

    /* access modifiers changed from: private */
    public final void zzga(String str) {
        String str2 = "data";
        try {
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = new JSONObject(str).getJSONObject("initializer_settings").getJSONObject("config");
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str3 = (String) keys.next();
                Object obj = new Object();
                zzaxv zzaxv = new zzaxv();
                zzddi zza = zzdcy.zza(zzaxv, ((Long) zzuv.zzon().zzd(zzza.zzcmr)).longValue(), TimeUnit.SECONDS, this.zzfcx);
                this.zzfsz.zzfy(str3);
                long elapsedRealtime = zzq.zzkq().elapsedRealtime();
                Iterator it = keys;
                zzccm zzccm = r1;
                zzccm zzccm2 = new zzccm(this, obj, zzaxv, str3, elapsedRealtime);
                zza.addListener(zzccm, this.executor);
                arrayList.add(zza);
                zzccs zzccs = new zzccs(this, obj, str3, elapsedRealtime, zzaxv);
                JSONObject optJSONObject = jSONObject.optJSONObject(str3);
                ArrayList arrayList2 = new ArrayList();
                String str4 = "";
                if (optJSONObject != null) {
                    try {
                        JSONArray jSONArray = optJSONObject.getJSONArray(str2);
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                            String optString = jSONObject2.optString("format", str4);
                            JSONObject optJSONObject2 = jSONObject2.optJSONObject(str2);
                            Bundle bundle = new Bundle();
                            if (optJSONObject2 != null) {
                                Iterator keys2 = optJSONObject2.keys();
                                while (keys2.hasNext()) {
                                    String str5 = (String) keys2.next();
                                    bundle.putString(str5, optJSONObject2.optString(str5, str4));
                                }
                            }
                            arrayList2.add(new zzagb(optString, bundle));
                        }
                    } catch (JSONException unused) {
                    }
                }
                zza(str3, false, str4, 0);
                try {
                    zzcwm zze = this.zzfsy.zze(str3, new JSONObject());
                    Executor executor2 = this.zzfbx;
                    zzcco zzcco = new zzcco(this, zze, zzccs, arrayList2, str3);
                    executor2.execute(zzcco);
                } catch (zzcwh unused2) {
                    try {
                        zzccs.onInitializationFailed("Failed to create Adapter.");
                    } catch (RemoteException e) {
                        zzaxi.zzc(str4, e);
                    }
                }
                keys = it;
            }
            zzdcy.zzh(arrayList).zza(new zzccp(this), this.executor);
        } catch (JSONException e2) {
            zzaug.zza("Malformed CLD response", e2);
        }
    }

    /* access modifiers changed from: private */
    public final void zza(String str, boolean z, String str2, int i) {
        this.zzfta.put(str, new zzafr(str, z, i, str2));
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:7|8|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0035, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0036, code lost:
        com.google.android.gms.internal.ads.zzaxi.zzc("", r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003b, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        r4 = new java.lang.StringBuilder(java.lang.String.valueOf(r5).length() + 74);
        r4.append("Failed to initialize adapter. ");
        r4.append(r5);
        r4.append(" does not implement the initialize() method.");
        r3.onInitializationFailed(r4.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0034, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void zza(com.google.android.gms.internal.ads.zzcwm r2, com.google.android.gms.internal.ads.zzaft r3, java.util.List r4, java.lang.String r5) {
        /*
            r1 = this;
            java.lang.ref.WeakReference<android.content.Context> r0 = r1.zzfsx     // Catch:{ zzcwh -> 0x0011 }
            java.lang.Object r0 = r0.get()     // Catch:{ zzcwh -> 0x0011 }
            android.content.Context r0 = (android.content.Context) r0     // Catch:{ zzcwh -> 0x0011 }
            if (r0 == 0) goto L_0x000b
            goto L_0x000d
        L_0x000b:
            android.content.Context r0 = r1.zzcfz     // Catch:{ zzcwh -> 0x0011 }
        L_0x000d:
            r2.zza(r0, r3, r4)     // Catch:{ zzcwh -> 0x0011 }
            return
        L_0x0011:
            java.lang.String r2 = java.lang.String.valueOf(r5)     // Catch:{ RemoteException -> 0x0035 }
            int r2 = r2.length()     // Catch:{ RemoteException -> 0x0035 }
            int r2 = r2 + 74
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ RemoteException -> 0x0035 }
            r4.<init>(r2)     // Catch:{ RemoteException -> 0x0035 }
            java.lang.String r2 = "Failed to initialize adapter. "
            r4.append(r2)     // Catch:{ RemoteException -> 0x0035 }
            r4.append(r5)     // Catch:{ RemoteException -> 0x0035 }
            java.lang.String r2 = " does not implement the initialize() method."
            r4.append(r2)     // Catch:{ RemoteException -> 0x0035 }
            java.lang.String r2 = r4.toString()     // Catch:{ RemoteException -> 0x0035 }
            r3.onInitializationFailed(r2)     // Catch:{ RemoteException -> 0x0035 }
            return
        L_0x0035:
            r2 = move-exception
            java.lang.String r3 = ""
            com.google.android.gms.internal.ads.zzaxi.zzc(r3, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzccj.zza(com.google.android.gms.internal.ads.zzcwm, com.google.android.gms.internal.ads.zzaft, java.util.List, java.lang.String):void");
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ Object zzakd() throws Exception {
        this.zzfsw.set(Boolean.valueOf(true));
        return null;
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zza(Object obj, zzaxv zzaxv, String str, long j) {
        synchronized (obj) {
            if (!zzaxv.isDone()) {
                zza(str, false, "Timeout.", (int) (zzq.zzkq().elapsedRealtime() - j));
                this.zzfsz.zzr(str, "timeout");
                zzaxv.set(Boolean.valueOf(false));
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzake() {
        synchronized (this) {
            if (!this.zzfsu) {
                zza("com.google.android.gms.ads.MobileAds", false, "Timeout.", (int) (zzq.zzkq().elapsedRealtime() - this.zzfsv));
                this.zzfsw.setException(new Exception());
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zza(zzaxv zzaxv) {
        this.executor.execute(new zzccr(this, zzaxv));
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzakf() {
        this.zzfsz.zzajy();
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzc(zzafu zzafu) {
        try {
            zzafu.zzc(zzakb());
        } catch (RemoteException e) {
            zzaxi.zzc("", e);
        }
    }
}
