package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.customtabs.CustomTabsIntent.Builder;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzchd implements zzcga<zzbrs> {
    private final zzcvp zzfbb;
    private final Executor zzfbx;
    private final zzbso zzfxy;
    private final Context zzlk;

    public zzchd(Context context, Executor executor, zzbso zzbso, zzcvp zzcvp) {
        this.zzlk = context;
        this.zzfxy = zzbso;
        this.zzfbx = executor;
        this.zzfbb = zzcvp;
    }

    public final boolean zza(zzcvz zzcvz, zzcvr zzcvr) {
        return (this.zzlk instanceof Activity) && PlatformVersion.isAtLeastIceCreamSandwichMR1() && zzaal.zzk(this.zzlk) && !TextUtils.isEmpty(zzc(zzcvr));
    }

    public final zzddi<zzbrs> zzb(zzcvz zzcvz, zzcvr zzcvr) {
        String zzc = zzc(zzcvr);
        return zzdcy.zzb(zzdcy.zzah(null), (zzdcj<? super I, ? extends O>) new zzchc<Object,Object>(this, zzc != null ? Uri.parse(zzc) : null, zzcvz, zzcvr), this.zzfbx);
    }

    private static String zzc(zzcvr zzcvr) {
        try {
            return zzcvr.zzgjh.getString("tab_url");
        } catch (Exception unused) {
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ zzddi zza(Uri uri, zzcvz zzcvz, zzcvr zzcvr, Object obj) throws Exception {
        try {
            CustomTabsIntent build = new Builder().build();
            build.intent.setData(uri);
            zzd zzd = new zzd(build.intent);
            zzaxv zzaxv = new zzaxv();
            zzbru zza = this.zzfxy.zza(new zzbla(zzcvz, zzcvr, null), new zzbrx(new zzchf(zzaxv)));
            AdOverlayInfoParcel adOverlayInfoParcel = new AdOverlayInfoParcel(zzd, null, zza.zzadi(), null, new zzaxl(0, 0, false));
            zzaxv.set(adOverlayInfoParcel);
            this.zzfbb.zzud();
            return zzdcy.zzah(zza.zzadh());
        } catch (Throwable th) {
            zzaug.zzc("Error in CustomTabsAdRenderer", th);
            throw th;
        }
    }
}
