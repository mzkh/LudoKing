package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaah;
import com.google.android.gms.internal.ads.zzant;
import com.google.android.gms.internal.ads.zzanz;
import com.google.android.gms.internal.ads.zzaqi;
import com.google.android.gms.internal.ads.zzaug;
import com.google.android.gms.internal.ads.zzawy;
import com.google.android.gms.internal.ads.zzaxl;
import com.google.android.gms.internal.ads.zzaxn;
import com.google.android.gms.internal.ads.zzdf;
import com.google.android.gms.internal.ads.zzdi;
import com.google.android.gms.internal.ads.zzqx;
import com.google.android.gms.internal.ads.zztx;
import com.google.android.gms.internal.ads.zzua;
import com.google.android.gms.internal.ads.zzuf;
import com.google.android.gms.internal.ads.zzuv;
import com.google.android.gms.internal.ads.zzux;
import com.google.android.gms.internal.ads.zzuy;
import com.google.android.gms.internal.ads.zzvk;
import com.google.android.gms.internal.ads.zzvo;
import com.google.android.gms.internal.ads.zzvt;
import com.google.android.gms.internal.ads.zzvz;
import com.google.android.gms.internal.ads.zzwr;
import com.google.android.gms.internal.ads.zzwx;
import com.google.android.gms.internal.ads.zzyj;
import com.google.android.gms.internal.ads.zzza;
import java.util.Map;
import java.util.concurrent.Future;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzl extends zzvk {
    /* access modifiers changed from: private */
    public final zzaxl zzblk;
    private final zzua zzbll;
    /* access modifiers changed from: private */
    public final Future<zzdf> zzblm = zzaxn.zzdwi.zzd(new zzm(this));
    private final zzo zzbln;
    /* access modifiers changed from: private */
    @Nullable
    public WebView zzblo = new WebView(this.zzlk);
    /* access modifiers changed from: private */
    @Nullable
    public zzuy zzblp;
    /* access modifiers changed from: private */
    @Nullable
    public zzdf zzblq;
    private AsyncTask<Void, Void, String> zzblr;
    /* access modifiers changed from: private */
    public final Context zzlk;

    public zzl(Context context, zzua zzua, String str, zzaxl zzaxl) {
        this.zzlk = context;
        this.zzblk = zzaxl;
        this.zzbll = zzua;
        this.zzbln = new zzo(str);
        zzbl(0);
        this.zzblo.setVerticalScrollBarEnabled(false);
        this.zzblo.getSettings().setJavaScriptEnabled(true);
        this.zzblo.setWebViewClient(new zzk(this));
        this.zzblo.setOnTouchListener(new zzn(this));
    }

    @Nullable
    public final String getMediationAdapterClassName() throws RemoteException {
        return null;
    }

    @Nullable
    public final zzwr getVideoController() {
        return null;
    }

    public final boolean isLoading() throws RemoteException {
        return false;
    }

    public final boolean isReady() throws RemoteException {
        return false;
    }

    public final void setManualImpressionsEnabled(boolean z) throws RemoteException {
    }

    public final void stopLoading() throws RemoteException {
    }

    @Nullable
    public final String zzju() throws RemoteException {
        return null;
    }

    public final IObjectWrapper zzjr() throws RemoteException {
        Preconditions.checkMainThread("getAdFrame must be called on the main UI thread.");
        return ObjectWrapper.wrap(this.zzblo);
    }

    public final void destroy() throws RemoteException {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.zzblr.cancel(true);
        this.zzblm.cancel(true);
        this.zzblo.destroy();
        this.zzblo = null;
    }

    public final boolean zza(zztx zztx) throws RemoteException {
        Preconditions.checkNotNull(this.zzblo, "This Search Ad has already been torn down");
        this.zzbln.zza(zztx, this.zzblk);
        this.zzblr = new zzp(this, null).execute(new Void[0]);
        return true;
    }

    public final void pause() throws RemoteException {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
    }

    public final void resume() throws RemoteException {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
    }

    public final void zza(zzuy zzuy) throws RemoteException {
        this.zzblp = zzuy;
    }

    public final void zza(zzvt zzvt) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zza(zzvo zzvo) {
        throw new IllegalStateException("Unused method");
    }

    public final Bundle getAdMetadata() {
        throw new IllegalStateException("Unused method");
    }

    public final void showInterstitial() throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zzjs() throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final zzua zzjt() throws RemoteException {
        return this.zzbll;
    }

    public final void zza(zzua zzua) throws RemoteException {
        throw new IllegalStateException("AdSize must be set before initialization");
    }

    public final void zza(zzant zzant) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zza(zzanz zzanz, String str) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final String getAdUnitId() {
        throw new IllegalStateException("getAdUnitId not implemented");
    }

    public final zzvt zzjv() {
        throw new IllegalStateException("getIAppEventListener not implemented");
    }

    public final zzuy zzjw() {
        throw new IllegalStateException("getIAdListener not implemented");
    }

    public final void zza(zzaah zzaah) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zza(zzux zzux) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zza(zzvz zzvz) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zza(zzaqi zzaqi) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void setUserId(String str) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zzbm(String str) {
        throw new IllegalStateException("Unused method");
    }

    public final void zza(zzyj zzyj) {
        throw new IllegalStateException("Unused method");
    }

    public final void zza(zzwx zzwx) {
        throw new IllegalStateException("Unused method");
    }

    public final void zza(zzuf zzuf) {
        throw new IllegalStateException("Unused method");
    }

    public final void zza(zzqx zzqx) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void setImmersiveMode(boolean z) {
        throw new IllegalStateException("Unused method");
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    public final int zzbn(String str) {
        String queryParameter = Uri.parse(str).getQueryParameter("height");
        if (TextUtils.isEmpty(queryParameter)) {
            return 0;
        }
        try {
            zzuv.zzoj();
            return zzawy.zza(this.zzlk, Integer.parseInt(queryParameter));
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    public final void zzbl(int i) {
        if (this.zzblo != null) {
            this.zzblo.setLayoutParams(new LayoutParams(-1, i));
        }
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    public final String zzjx() {
        Builder builder = new Builder();
        builder.scheme("https://").appendEncodedPath((String) zzuv.zzon().zzd(zzza.zzcpd));
        builder.appendQueryParameter("query", this.zzbln.getQuery());
        builder.appendQueryParameter("pubId", this.zzbln.zzka());
        Map zzkb = this.zzbln.zzkb();
        for (String str : zzkb.keySet()) {
            builder.appendQueryParameter(str, (String) zzkb.get(str));
        }
        Uri build = builder.build();
        zzdf zzdf = this.zzblq;
        if (zzdf != null) {
            try {
                build = zzdf.zza(build, this.zzlk);
            } catch (zzdi e) {
                zzaug.zzd("Unable to process ad data", e);
            }
        }
        String zzjy = zzjy();
        String encodedQuery = build.getEncodedQuery();
        StringBuilder sb = new StringBuilder(String.valueOf(zzjy).length() + 1 + String.valueOf(encodedQuery).length());
        sb.append(zzjy);
        sb.append("#");
        sb.append(encodedQuery);
        return sb.toString();
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    public final String zzjy() {
        String zzjz = this.zzbln.zzjz();
        if (TextUtils.isEmpty(zzjz)) {
            zzjz = "www.google.com";
        }
        String str = (String) zzuv.zzon().zzd(zzza.zzcpd);
        StringBuilder sb = new StringBuilder(String.valueOf(zzjz).length() + 8 + String.valueOf(str).length());
        sb.append("https://");
        sb.append(zzjz);
        sb.append(str);
        return sb.toString();
    }

    /* access modifiers changed from: private */
    public final String zzbo(String str) {
        if (this.zzblq == null) {
            return str;
        }
        Uri parse = Uri.parse(str);
        try {
            parse = this.zzblq.zzb(parse, this.zzlk);
        } catch (zzdi e) {
            zzaug.zzd("Unable to process ad data", e);
        }
        return parse.toString();
    }

    /* access modifiers changed from: private */
    public final void zzbp(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        this.zzlk.startActivity(intent);
    }
}
