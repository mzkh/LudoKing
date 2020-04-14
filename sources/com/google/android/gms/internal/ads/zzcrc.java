package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcrc implements zzcru<zzcqz> {
    private final ScheduledExecutorService zzffn;
    private final zzcwe zzfga;
    private final zzddl zzfoa;
    private final zzclp zzgae;
    private String zzgdm;
    private final zzclr zzgft;
    private final Context zzlk;

    public zzcrc(zzddl zzddl, ScheduledExecutorService scheduledExecutorService, String str, zzclr zzclr, Context context, zzcwe zzcwe, zzclp zzclp) {
        this.zzfoa = zzddl;
        this.zzffn = scheduledExecutorService;
        this.zzgdm = str;
        this.zzgft = zzclr;
        this.zzlk = context;
        this.zzfga = zzcwe;
        this.zzgae = zzclp;
    }

    public final zzddi<zzcqz> zzalv() {
        if (((Boolean) zzuv.zzon().zzd(zzza.zzcmi)).booleanValue()) {
            return zzdcy.zzb(this.zzfoa.zzd(new zzcrb(this)), (zzdcj<? super I, ? extends O>) new zzcre<Object,Object>(this), (Executor) this.zzfoa);
        }
        return zzdcy.zzah(null);
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<com.google.android.gms.internal.ads.zzddi>, for r2v0, types: [java.util.List, java.util.List<com.google.android.gms.internal.ads.zzddi>] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static final /* synthetic */ com.google.android.gms.internal.ads.zzcqz zzg(java.util.List<com.google.android.gms.internal.ads.zzddi> r2) throws java.lang.Exception {
        /*
            org.json.JSONArray r0 = new org.json.JSONArray
            r0.<init>()
            java.util.Iterator r2 = r2.iterator()
        L_0x0009:
            boolean r1 = r2.hasNext()
            if (r1 == 0) goto L_0x001f
            java.lang.Object r1 = r2.next()
            com.google.android.gms.internal.ads.zzddi r1 = (com.google.android.gms.internal.ads.zzddi) r1
            java.lang.Object r1 = r1.get()     // Catch:{ InterruptedException | ExecutionException -> 0x001d }
            r0.put(r1)     // Catch:{ InterruptedException | ExecutionException -> 0x001d }
            goto L_0x0009
        L_0x001d:
            goto L_0x0009
        L_0x001f:
            int r2 = r0.length()
            if (r2 != 0) goto L_0x0027
            r2 = 0
            return r2
        L_0x0027:
            com.google.android.gms.internal.ads.zzcqz r2 = new com.google.android.gms.internal.ads.zzcqz
            java.lang.String r0 = r0.toString()
            r2.<init>(r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcrc.zzg(java.util.List):com.google.android.gms.internal.ads.zzcqz");
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zza(String str, zzaxv zzaxv, Bundle bundle, List list) {
        try {
            this.zzgae.zzgb(str);
            zzamd zzgc = this.zzgae.zzgc(str);
            if (zzgc != null) {
                zzgc.zza(ObjectWrapper.wrap(this.zzlk), this.zzgdm, bundle, (Bundle) list.get(0), this.zzfga.zzbll, (zzame) new zzclx(str, zzgc, zzaxv));
                return;
            }
            throw new Exception("Missing Adapter.");
        } catch (Throwable th) {
            zzaxv.setException(new Exception("Error calling adapter"));
            String str2 = "Error calling adapter: ";
            String valueOf = String.valueOf(str);
            zzaug.zzc(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), th);
        }
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ zzddi zzh(List list) throws Exception {
        return zzdcy.zzh(list).zza(new zzcrg(list), this.zzfoa);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ List zzamf() throws Exception {
        ArrayList arrayList = new ArrayList();
        for (Entry entry : this.zzgft.zzs(this.zzgdm, this.zzfga.zzgkh).entrySet()) {
            String str = (String) entry.getKey();
            List list = (List) entry.getValue();
            zzaxv zzaxv = new zzaxv();
            Bundle bundle = this.zzfga.zzgkg.zzcce != null ? this.zzfga.zzgkg.zzcce.getBundle(str) : null;
            arrayList.add(zzdcy.zza(zzaxv, ((Long) zzuv.zzon().zzd(zzza.zzcmh)).longValue(), TimeUnit.MILLISECONDS, this.zzffn));
            zzddl zzddl = this.zzfoa;
            zzcrd zzcrd = new zzcrd(this, str, zzaxv, bundle, list);
            zzddl.execute(zzcrd);
        }
        return arrayList;
    }
}
