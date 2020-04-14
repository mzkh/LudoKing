package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzdut.zzb.C3507zzb;
import com.google.android.gms.internal.ads.zzdut.zzb.C3507zzb.zza;
import com.google.android.gms.internal.ads.zzdut.zzb.zzg;
import com.google.android.gms.internal.ads.zzdut.zzb.zzi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzarv implements zzasi {
    /* access modifiers changed from: private */
    public static List<Future<Void>> zzdog = Collections.synchronizedList(new ArrayList());
    /* access modifiers changed from: private */
    public final Object lock = new Object();
    private final zzasd zzdlj;
    /* access modifiers changed from: private */
    @GuardedBy("lock")
    public final zzdve zzdoh;
    @GuardedBy("lock")
    private final LinkedHashMap<String, zzdvh> zzdoi;
    @GuardedBy("lock")
    private final List<String> zzdoj = new ArrayList();
    @GuardedBy("lock")
    private final List<String> zzdok = new ArrayList();
    private final zzask zzdol;
    @VisibleForTesting
    private boolean zzdom;
    private final zzasj zzdon;
    private HashSet<String> zzdoo = new HashSet<>();
    private boolean zzdop = false;
    private boolean zzdoq = false;
    private boolean zzdor = false;
    private final Context zzlk;

    public zzarv(Context context, zzaxl zzaxl, zzasd zzasd, String str, zzask zzask) {
        Preconditions.checkNotNull(zzasd, "SafeBrowsing config is not present.");
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        this.zzlk = context;
        this.zzdoi = new LinkedHashMap<>();
        this.zzdol = zzask;
        this.zzdlj = zzasd;
        for (String lowerCase : this.zzdlj.zzdpa) {
            this.zzdoo.add(lowerCase.toLowerCase(Locale.ENGLISH));
        }
        this.zzdoo.remove("cookie".toLowerCase(Locale.ENGLISH));
        zzdve zzdve = new zzdve();
        zzdve.zzhvf = zzg.OCTAGON_AD;
        zzdve.url = str;
        zzdve.zzhvh = str;
        zza zzbcn = C3507zzb.zzbcn();
        if (this.zzdlj.zzdow != null) {
            zzbcn.zzhn(this.zzdlj.zzdow);
        }
        zzdve.zzhvj = (C3507zzb) ((zzdqw) zzbcn.zzazr());
        zzi.zza zzbm = zzi.zzbcx().zzbm(Wrappers.packageManager(this.zzlk).isCallerInstantApp());
        if (zzaxl.zzblz != null) {
            zzbm.zzhq(zzaxl.zzblz);
        }
        long apkVersion = (long) GoogleApiAvailabilityLight.getInstance().getApkVersion(this.zzlk);
        if (apkVersion > 0) {
            zzbm.zzfo(apkVersion);
        }
        zzdve.zzhvt = (zzi) ((zzdqw) zzbm.zzazr());
        this.zzdoh = zzdve;
        this.zzdon = new zzasj(this.zzlk, this.zzdlj.zzdpd, this);
    }

    static final /* synthetic */ Void zzdu(String str) {
        return null;
    }

    public final zzasd zztm() {
        return this.zzdlj;
    }

    public final void zzdq(String str) {
        synchronized (this.lock) {
            this.zzdoh.zzhvl = str;
        }
    }

    public final boolean zztn() {
        return PlatformVersion.isAtLeastKitKat() && this.zzdlj.zzdoy && !this.zzdoq;
    }

    public final void zzj(View view) {
        if (this.zzdlj.zzdoy && !this.zzdoq) {
            zzq.zzkj();
            Bitmap zzl = zzaul.zzl(view);
            if (zzl == null) {
                zzasf.zzdv("Failed to capture the webview bitmap.");
                return;
            }
            this.zzdoq = true;
            zzaul.zzc(new zzasa(this, zzl));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.String r7, java.util.Map<java.lang.String, java.lang.String> r8, int r9) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.lock
            monitor-enter(r0)
            r1 = 3
            if (r9 != r1) goto L_0x0009
            r2 = 1
            r6.zzdor = r2     // Catch:{ all -> 0x00c6 }
        L_0x0009:
            java.util.LinkedHashMap<java.lang.String, com.google.android.gms.internal.ads.zzdvh> r2 = r6.zzdoi     // Catch:{ all -> 0x00c6 }
            boolean r2 = r2.containsKey(r7)     // Catch:{ all -> 0x00c6 }
            if (r2 == 0) goto L_0x0023
            if (r9 != r1) goto L_0x0021
            java.util.LinkedHashMap<java.lang.String, com.google.android.gms.internal.ads.zzdvh> r8 = r6.zzdoi     // Catch:{ all -> 0x00c6 }
            java.lang.Object r7 = r8.get(r7)     // Catch:{ all -> 0x00c6 }
            com.google.android.gms.internal.ads.zzdvh r7 = (com.google.android.gms.internal.ads.zzdvh) r7     // Catch:{ all -> 0x00c6 }
            com.google.android.gms.internal.ads.zzdut$zzb$zzh$zza r8 = com.google.android.gms.internal.ads.zzdut.zzb.zzh.zza.zzhj(r9)     // Catch:{ all -> 0x00c6 }
            r7.zzhwi = r8     // Catch:{ all -> 0x00c6 }
        L_0x0021:
            monitor-exit(r0)     // Catch:{ all -> 0x00c6 }
            return
        L_0x0023:
            com.google.android.gms.internal.ads.zzdvh r1 = new com.google.android.gms.internal.ads.zzdvh     // Catch:{ all -> 0x00c6 }
            r1.<init>()     // Catch:{ all -> 0x00c6 }
            com.google.android.gms.internal.ads.zzdut$zzb$zzh$zza r9 = com.google.android.gms.internal.ads.zzdut.zzb.zzh.zza.zzhj(r9)     // Catch:{ all -> 0x00c6 }
            r1.zzhwi = r9     // Catch:{ all -> 0x00c6 }
            java.util.LinkedHashMap<java.lang.String, com.google.android.gms.internal.ads.zzdvh> r9 = r6.zzdoi     // Catch:{ all -> 0x00c6 }
            int r9 = r9.size()     // Catch:{ all -> 0x00c6 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x00c6 }
            r1.zzhwc = r9     // Catch:{ all -> 0x00c6 }
            r1.url = r7     // Catch:{ all -> 0x00c6 }
            com.google.android.gms.internal.ads.zzdvg r9 = new com.google.android.gms.internal.ads.zzdvg     // Catch:{ all -> 0x00c6 }
            r9.<init>()     // Catch:{ all -> 0x00c6 }
            r1.zzhwd = r9     // Catch:{ all -> 0x00c6 }
            java.util.HashSet<java.lang.String> r9 = r6.zzdoo     // Catch:{ all -> 0x00c6 }
            int r9 = r9.size()     // Catch:{ all -> 0x00c6 }
            if (r9 <= 0) goto L_0x00bf
            if (r8 == 0) goto L_0x00bf
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ all -> 0x00c6 }
            r9.<init>()     // Catch:{ all -> 0x00c6 }
            java.util.Set r8 = r8.entrySet()     // Catch:{ all -> 0x00c6 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x00c6 }
        L_0x005a:
            boolean r2 = r8.hasNext()     // Catch:{ all -> 0x00c6 }
            if (r2 == 0) goto L_0x00b2
            java.lang.Object r2 = r8.next()     // Catch:{ all -> 0x00c6 }
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ all -> 0x00c6 }
            java.lang.Object r3 = r2.getKey()     // Catch:{ all -> 0x00c6 }
            if (r3 == 0) goto L_0x0073
            java.lang.Object r3 = r2.getKey()     // Catch:{ all -> 0x00c6 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x00c6 }
            goto L_0x0075
        L_0x0073:
            java.lang.String r3 = ""
        L_0x0075:
            java.lang.Object r4 = r2.getValue()     // Catch:{ all -> 0x00c6 }
            if (r4 == 0) goto L_0x0082
            java.lang.Object r2 = r2.getValue()     // Catch:{ all -> 0x00c6 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x00c6 }
            goto L_0x0084
        L_0x0082:
            java.lang.String r2 = ""
        L_0x0084:
            java.util.Locale r4 = java.util.Locale.ENGLISH     // Catch:{ all -> 0x00c6 }
            java.lang.String r4 = r3.toLowerCase(r4)     // Catch:{ all -> 0x00c6 }
            java.util.HashSet<java.lang.String> r5 = r6.zzdoo     // Catch:{ all -> 0x00c6 }
            boolean r4 = r5.contains(r4)     // Catch:{ all -> 0x00c6 }
            if (r4 == 0) goto L_0x005a
            com.google.android.gms.internal.ads.zzdut$zzb$zzc$zza r4 = com.google.android.gms.internal.ads.zzdut.zzb.zzc.zzbcp()     // Catch:{ all -> 0x00c6 }
            com.google.android.gms.internal.ads.zzdpm r3 = com.google.android.gms.internal.ads.zzdpm.zzhh(r3)     // Catch:{ all -> 0x00c6 }
            com.google.android.gms.internal.ads.zzdut$zzb$zzc$zza r3 = r4.zzdd(r3)     // Catch:{ all -> 0x00c6 }
            com.google.android.gms.internal.ads.zzdpm r2 = com.google.android.gms.internal.ads.zzdpm.zzhh(r2)     // Catch:{ all -> 0x00c6 }
            com.google.android.gms.internal.ads.zzdut$zzb$zzc$zza r2 = r3.zzde(r2)     // Catch:{ all -> 0x00c6 }
            com.google.android.gms.internal.ads.zzdsg r2 = r2.zzazr()     // Catch:{ all -> 0x00c6 }
            com.google.android.gms.internal.ads.zzdqw r2 = (com.google.android.gms.internal.ads.zzdqw) r2     // Catch:{ all -> 0x00c6 }
            com.google.android.gms.internal.ads.zzdut$zzb$zzc r2 = (com.google.android.gms.internal.ads.zzdut.zzb.zzc) r2     // Catch:{ all -> 0x00c6 }
            r9.add(r2)     // Catch:{ all -> 0x00c6 }
            goto L_0x005a
        L_0x00b2:
            int r8 = r9.size()     // Catch:{ all -> 0x00c6 }
            com.google.android.gms.internal.ads.zzdut$zzb$zzc[] r8 = new com.google.android.gms.internal.ads.zzdut.zzb.zzc[r8]     // Catch:{ all -> 0x00c6 }
            r9.toArray(r8)     // Catch:{ all -> 0x00c6 }
            com.google.android.gms.internal.ads.zzdvg r9 = r1.zzhwd     // Catch:{ all -> 0x00c6 }
            r9.zzhvx = r8     // Catch:{ all -> 0x00c6 }
        L_0x00bf:
            java.util.LinkedHashMap<java.lang.String, com.google.android.gms.internal.ads.zzdvh> r8 = r6.zzdoi     // Catch:{ all -> 0x00c6 }
            r8.put(r7, r1)     // Catch:{ all -> 0x00c6 }
            monitor-exit(r0)     // Catch:{ all -> 0x00c6 }
            return
        L_0x00c6:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00c6 }
            throw r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzarv.zza(java.lang.String, java.util.Map, int):void");
    }

    /* access modifiers changed from: 0000 */
    public final void zzdr(String str) {
        synchronized (this.lock) {
            this.zzdoj.add(str);
        }
    }

    /* access modifiers changed from: 0000 */
    public final void zzds(String str) {
        synchronized (this.lock) {
            this.zzdok.add(str);
        }
    }

    public final String[] zza(String[] strArr) {
        return (String[]) this.zzdon.zzb(strArr).toArray(new String[0]);
    }

    public final void zzto() {
        this.zzdop = true;
    }

    @Nullable
    private final zzdvh zzdt(String str) {
        zzdvh zzdvh;
        synchronized (this.lock) {
            zzdvh = (zzdvh) this.zzdoi.get(str);
        }
        return zzdvh;
    }

    public final void zztp() {
        synchronized (this.lock) {
            zzddi zzb = zzdcy.zzb(this.zzdol.zza(this.zzlk, this.zzdoi.keySet()), (zzdcj<? super I, ? extends O>) new zzary<Object,Object>(this), (Executor) zzaxn.zzdwn);
            zzddi zza = zzdcy.zza(zzb, 10, TimeUnit.SECONDS, zzaxn.zzdwl);
            zzdcy.zza(zzb, new zzarz(this, zza), zzaxn.zzdwn);
            zzdog.add(zza);
        }
    }

    @VisibleForTesting
    private final zzddi<Void> zztq() {
        zzddi<Void> zzb;
        zzdvh[] zzdvhArr;
        if (!((this.zzdom && this.zzdlj.zzdpc) || (this.zzdor && this.zzdlj.zzdpb) || (!this.zzdom && this.zzdlj.zzdoz))) {
            return zzdcy.zzah(null);
        }
        synchronized (this.lock) {
            this.zzdoh.zzhvk = new zzdvh[this.zzdoi.size()];
            this.zzdoi.values().toArray(this.zzdoh.zzhvk);
            this.zzdoh.zzhvu = (String[]) this.zzdoj.toArray(new String[0]);
            this.zzdoh.zzhvv = (String[]) this.zzdok.toArray(new String[0]);
            if (zzasf.isEnabled()) {
                String str = this.zzdoh.url;
                String str2 = this.zzdoh.zzhvl;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 53 + String.valueOf(str2).length());
                sb.append("Sending SB report\n  url: ");
                sb.append(str);
                sb.append("\n  clickUrl: ");
                sb.append(str2);
                sb.append("\n  resources: \n");
                StringBuilder sb2 = new StringBuilder(sb.toString());
                for (zzdvh zzdvh : this.zzdoh.zzhvk) {
                    sb2.append("    [");
                    sb2.append(zzdvh.zzhwj.length);
                    sb2.append("] ");
                    sb2.append(zzdvh.url);
                }
                zzasf.zzdv(sb2.toString());
            }
            zzddi zza = new zzavy(this.zzlk).zza(1, this.zzdlj.zzdox, null, zzdus.zzb(this.zzdoh));
            if (zzasf.isEnabled()) {
                zza.addListener(new zzasc(this), zzaxn.zzdwi);
            }
            zzb = zzdcy.zzb(zza, zzarx.zzdos, (Executor) zzaxn.zzdwn);
        }
        return zzb;
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ zzddi zzh(Map map) throws Exception {
        if (map != null) {
            try {
                for (String str : map.keySet()) {
                    JSONArray optJSONArray = new JSONObject((String) map.get(str)).optJSONArray("matches");
                    if (optJSONArray != null) {
                        synchronized (this.lock) {
                            int length = optJSONArray.length();
                            zzdvh zzdt = zzdt(str);
                            if (zzdt == null) {
                                String str2 = "Cannot find the corresponding resource object for ";
                                String valueOf = String.valueOf(str);
                                zzasf.zzdv(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                            } else {
                                zzdt.zzhwj = new String[length];
                                boolean z = false;
                                for (int i = 0; i < length; i++) {
                                    zzdt.zzhwj[i] = optJSONArray.getJSONObject(i).getString("threat_type");
                                }
                                boolean z2 = this.zzdom;
                                if (length > 0) {
                                    z = true;
                                }
                                this.zzdom = z | z2;
                            }
                        }
                    }
                }
            } catch (JSONException e) {
                if (((Boolean) zzuv.zzon().zzd(zzza.zzcpj)).booleanValue()) {
                    zzaug.zzb("Failed to get SafeBrowsing metadata", e);
                }
                return zzdcy.zzi(new Exception("Safebrowsing report transmission failed."));
            }
        }
        if (this.zzdom) {
            synchronized (this.lock) {
                this.zzdoh.zzhvf = zzg.OCTAGON_AD_SB_MATCH;
            }
        }
        return zztq();
    }
}
