package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.util.Predicate;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzahc implements zzagv, zzaha {
    /* access modifiers changed from: private */
    public final zzbbw zzczi;
    private final Context zzlk;

    public zzahc(Context context, zzaxl zzaxl, @Nullable zzdf zzdf, zza zza) throws zzbcf {
        Context context2 = context;
        this.zzlk = context2;
        zzq.zzkk();
        this.zzczi = zzbcb.zza(context2, zzbdj.zzaar(), "", false, false, zzdf, zzaxl, null, null, null, zzsd.zzmm(), null, false);
        this.zzczi.getView().setWillNotDraw(true);
    }

    public final void zza(String str, Map map) {
        zzagu.zza((zzagv) this, str, map);
    }

    public final void zza(String str, JSONObject jSONObject) {
        zzagu.zza((zzagv) this, str, jSONObject);
    }

    public final void zzb(String str, JSONObject jSONObject) {
        zzagu.zzb(this, str, jSONObject);
    }

    public final void zzk(String str, String str2) {
        zzagu.zza((zzagv) this, str, str2);
    }

    private static void runOnUiThread(Runnable runnable) {
        zzuv.zzoj();
        if (zzawy.zzwk()) {
            runnable.run();
        } else {
            zzaul.zzdsu.post(runnable);
        }
    }

    public final void zzct(String str) {
        runOnUiThread(new zzahf(this, str));
    }

    public final void zzcq(String str) {
        runOnUiThread(new zzahg(this, String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head><body></body></html>", new Object[]{str})));
    }

    public final void zzcr(String str) {
        runOnUiThread(new zzahj(this, str));
    }

    public final void zzcs(String str) {
        runOnUiThread(new zzahi(this, str));
    }

    public final void zza(String str, zzaer<? super zzail> zzaer) {
        this.zzczi.zza(str, (zzaer<? super zzbbw>) new zzahl<Object>(this, zzaer));
    }

    public final void zzb(String str, zzaer<? super zzail> zzaer) {
        this.zzczi.zza(str, (Predicate<zzaer<? super zzbbw>>) new zzahe<zzaer<? super zzbbw>>(zzaer));
    }

    public final void zza(zzahd zzahd) {
        zzbdg zzzp = this.zzczi.zzzp();
        zzahd.getClass();
        zzzp.zza(zzahh.zzb(zzahd));
    }

    public final zzaik zzrd() {
        return new zzain(this);
    }

    public final void destroy() {
        this.zzczi.destroy();
    }

    public final boolean isDestroyed() {
        return this.zzczi.isDestroyed();
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzcy(String str) {
        this.zzczi.zzct(str);
    }
}
