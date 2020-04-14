package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzq;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzagm extends zzagz<zzail> implements zzagv, zzaha {
    private final zzbdx zzcyw;
    /* access modifiers changed from: private */
    public zzahd zzcyx;

    public zzagm(Context context, zzaxl zzaxl) throws zzbcf {
        try {
            this.zzcyw = new zzbdx(context, new zzags(this));
            this.zzcyw.setWillNotDraw(true);
            this.zzcyw.addJavascriptInterface(new zzagt(this), "GoogleJsInterface");
            zzq.zzkj().zza(context, zzaxl.zzblz, this.zzcyw.getSettings());
            super.zzg(this);
        } catch (Throwable th) {
            throw new zzbcf("Init failed.", th);
        }
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

    public final void zzcq(String str) {
        zzcr(String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head></html>", new Object[]{str}));
    }

    public final void zzcr(String str) {
        zzaxn.zzdwm.execute(new zzagp(this, str));
    }

    public final void zzcs(String str) {
        zzaxn.zzdwm.execute(new zzago(this, str));
    }

    public final void zza(zzahd zzahd) {
        this.zzcyx = zzahd;
    }

    public final void destroy() {
        this.zzcyw.destroy();
    }

    public final boolean isDestroyed() {
        return this.zzcyw.isDestroyed();
    }

    public final zzaik zzrd() {
        return new zzain(this);
    }

    public final void zzct(String str) {
        zzaxn.zzdwm.execute(new zzagr(this, str));
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzcu(String str) {
        this.zzcyw.zzct(str);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzcv(String str) {
        this.zzcyw.loadUrl(str);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzcw(String str) {
        this.zzcyw.loadData(str, "text/html", "UTF-8");
    }
}
