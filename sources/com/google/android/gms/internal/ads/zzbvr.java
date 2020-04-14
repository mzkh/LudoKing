package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbvr {
    private final zzbuz zzfkp;
    private final zzbyh zzfnd;
    private final zzbzl zzfnm;
    private final zzbhx zzfnn;
    private final Context zzlk;

    public zzbvr(Context context, zzbzl zzbzl, zzbyh zzbyh, zzbhx zzbhx, zzbuz zzbuz) {
        this.zzlk = context;
        this.zzfnm = zzbzl;
        this.zzfnd = zzbyh;
        this.zzfnn = zzbhx;
        this.zzfkp = zzbuz;
    }

    public final View zzaiy() throws zzbcf {
        zzbbw zza = this.zzfnm.zza(zzua.zzg(this.zzlk), false);
        zza.getView().setVisibility(8);
        zza.zza("/sendMessageToSdk", (zzaer<? super zzbbw>) new zzbvq<Object>(this));
        zza.zza("/adMuted", (zzaer<? super zzbbw>) new zzbvt<Object>(this));
        this.zzfnd.zza(new WeakReference<>(zza), "/loadHtml", (zzaer<T>) new zzbvs<T>(this));
        this.zzfnd.zza(new WeakReference<>(zza), "/showOverlay", (zzaer<T>) new zzbvv<T>(this));
        this.zzfnd.zza(new WeakReference<>(zza), "/hideOverlay", (zzaer<T>) new zzbvu<T>(this));
        return zza.getView();
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zza(zzbbw zzbbw, Map map) {
        zzaug.zzet("Hiding native ads overlay.");
        zzbbw.getView().setVisibility(8);
        this.zzfnn.zzax(false);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzb(zzbbw zzbbw, Map map) {
        zzaug.zzet("Showing native ads overlay.");
        zzbbw.getView().setVisibility(0);
        this.zzfnn.zzax(true);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zza(Map map, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("messageType", "htmlLoaded");
        String str = "id";
        hashMap.put(str, (String) map.get(str));
        this.zzfnd.zza("sendMessageToNativeJs", (Map<String, ?>) hashMap);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzc(zzbbw zzbbw, Map map) {
        this.zzfkp.zzahe();
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzd(zzbbw zzbbw, Map map) {
        this.zzfnd.zza("sendMessageToNativeJs", map);
    }
}
