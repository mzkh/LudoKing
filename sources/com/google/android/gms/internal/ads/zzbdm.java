package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.appsflyer.share.Constants;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.overlay.zzt;
import com.google.android.gms.ads.internal.zzc;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map.Entry;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@ParametersAreNonnullByDefault
@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbdm extends zzbdv implements zzbdg {
    private final Object lock = new Object();
    private volatile boolean zzbma;
    private zztp zzcbs;
    private zzadw zzcxc;
    private zzady zzcxd;
    private zzc zzcxx;
    private zzamz zzcxy;
    private zzo zzdhy;
    private zzt zzdic;
    private boolean zzdlr;
    protected zzbbw zzeem;
    private zzbdf zzeep;
    private zzbdi zzeeq;
    private zzbdh zzeer;
    private boolean zzees = false;
    @GuardedBy("lock")
    private boolean zzeet;
    @GuardedBy("lock")
    private boolean zzeeu;
    private zzang zzeev;
    @Nullable
    private zzasi zzeew;
    private boolean zzeex;
    private boolean zzeey;
    private int zzeez;
    private OnAttachStateChangeListener zzefa;
    private final zzagz<zzbbw> zzeia = new zzagz<>();

    /* access modifiers changed from: 0000 */
    public final void zza(zzbbw zzbbw, boolean z) {
        zzang zzang = new zzang(zzbbw, zzbbw.zzzk(), new zzyl(zzbbw.getContext()));
        this.zzeem = zzbbw;
        this.zzbma = z;
        this.zzeev = zzang;
        this.zzcxy = null;
        this.zzeia.zzg(zzbbw);
    }

    public final void zza(int i, int i2, boolean z) {
        this.zzeev.zzi(i, i2);
        zzamz zzamz = this.zzcxy;
        if (zzamz != null) {
            zzamz.zza(i, i2, false);
        }
    }

    public final void zza(String str, zzaer<? super zzbbw> zzaer) {
        this.zzeia.zza(str, zzaer);
    }

    public final void zzb(String str, zzaer<? super zzbbw> zzaer) {
        this.zzeia.zzb(str, zzaer);
    }

    public final void zza(String str, Predicate<zzaer<? super zzbbw>> predicate) {
        this.zzeia.zza(str, predicate);
    }

    public final void zza(zztp zztp, zzadw zzadw, zzo zzo, zzady zzady, zzt zzt, boolean z, @Nullable zzaeq zzaeq, zzc zzc, zzani zzani, @Nullable zzasi zzasi) {
        if (zzc == null) {
            zzc = new zzc(this.zzeem.getContext(), zzasi, null);
        }
        this.zzcxy = new zzamz(this.zzeem, zzani);
        this.zzeew = zzasi;
        if (((Boolean) zzuv.zzon().zzd(zzza.zzckl)).booleanValue()) {
            zza("/adMetadata", (zzaer<? super zzbbw>) new zzadx<Object>(zzadw));
        }
        zza("/appEvent", (zzaer<? super zzbbw>) new zzadz<Object>(zzady));
        zza("/backButton", zzaea.zzcxn);
        zza("/refresh", zzaea.zzcxo);
        zza("/canOpenURLs", zzaea.zzcxe);
        zza("/canOpenIntents", zzaea.zzcxf);
        zza("/click", zzaea.zzcxg);
        zza("/close", zzaea.zzcxh);
        zza("/customClose", zzaea.zzcxi);
        zza("/instrument", zzaea.zzcxr);
        zza("/delayPageLoaded", zzaea.zzcxt);
        zza("/delayPageClosed", zzaea.zzcxu);
        zza("/getLocationInfo", zzaea.zzcxv);
        zza("/httpTrack", zzaea.zzcxj);
        zza("/log", zzaea.zzcxk);
        zza("/mraid", (zzaer<? super zzbbw>) new zzaes<Object>(zzc, this.zzcxy, zzani));
        zza("/mraidLoaded", (zzaer<? super zzbbw>) this.zzeev);
        zza("/open", (zzaer<? super zzbbw>) new zzaev<Object>(zzc, this.zzcxy));
        zza("/precache", (zzaer<? super zzbbw>) new zzbbg<Object>());
        zza("/touch", zzaea.zzcxm);
        zza("/video", zzaea.zzcxp);
        zza("/videoMeta", zzaea.zzcxq);
        if (zzq.zzlh().zzab(this.zzeem.getContext())) {
            zza("/logScionEvent", (zzaer<? super zzbbw>) new zzaet<Object>(this.zzeem.getContext()));
        }
        this.zzcbs = zztp;
        this.zzdhy = zzo;
        this.zzcxc = zzadw;
        this.zzcxd = zzady;
        this.zzdic = zzt;
        this.zzcxx = zzc;
        this.zzees = z;
    }

    public final zzc zzyv() {
        return this.zzcxx;
    }

    public final boolean zzyw() {
        return this.zzbma;
    }

    public final boolean zzyx() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzeet;
        }
        return z;
    }

    public final OnGlobalLayoutListener zzyy() {
        synchronized (this.lock) {
        }
        return null;
    }

    public final OnScrollChangedListener zzyz() {
        synchronized (this.lock) {
        }
        return null;
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        zzrf zzaaf = this.zzeem.zzaaf();
        if (zzaaf != null && webView == zzaaf.getWebView()) {
            zzaaf.onPageStarted(webView, str, bitmap);
        }
        super.onPageStarted(webView, str, bitmap);
    }

    public final void zza(zzbdy zzbdy) {
        this.zzeex = true;
        zzbdi zzbdi = this.zzeeq;
        if (zzbdi != null) {
            zzbdi.zzrf();
            this.zzeeq = null;
        }
        zzzf();
    }

    /* access modifiers changed from: private */
    public final void zza(View view, zzasi zzasi, int i) {
        if (zzasi.zztn() && i > 0) {
            zzasi.zzj(view);
            if (zzasi.zztn()) {
                zzaul.zzdsu.postDelayed(new zzbdo(this, view, zzasi, i), 100);
            }
        }
    }

    private final void zzza() {
        if (this.zzefa != null) {
            this.zzeem.getView().removeOnAttachStateChangeListener(this.zzefa);
        }
    }

    public final void zzzb() {
        zzasi zzasi = this.zzeew;
        if (zzasi != null) {
            WebView webView = this.zzeem.getWebView();
            if (ViewCompat.isAttachedToWindow(webView)) {
                zza((View) webView, zzasi, 10);
                return;
            }
            zzza();
            this.zzefa = new zzbdn(this, zzasi);
            this.zzeem.getView().addOnAttachStateChangeListener(this.zzefa);
        }
    }

    public final void zzzc() {
        synchronized (this.lock) {
            this.zzeeu = true;
        }
        this.zzeez++;
        zzzf();
    }

    public final void zzzd() {
        this.zzeez--;
        zzzf();
    }

    public final void zzze() {
        this.zzeey = true;
        zzzf();
    }

    private final void zzzf() {
        if (this.zzeep != null && ((this.zzeex && this.zzeez <= 0) || this.zzeey)) {
            this.zzeep.zzad(!this.zzeey);
            this.zzeep = null;
        }
        this.zzeem.zzzz();
    }

    public final void zza(zzd zzd) {
        zzo zzo;
        boolean zzzu = this.zzeem.zzzu();
        zztp zztp = (!zzzu || this.zzeem.zzzn().zzaau()) ? this.zzcbs : null;
        if (zzzu) {
            zzo = null;
        } else {
            zzo = this.zzdhy;
        }
        AdOverlayInfoParcel adOverlayInfoParcel = new AdOverlayInfoParcel(zzd, zztp, zzo, this.zzdic, this.zzeem.zzxr());
        zza(adOverlayInfoParcel);
    }

    public final void zzb(boolean z, int i) {
        zztp zztp = (!this.zzeem.zzzu() || this.zzeem.zzzn().zzaau()) ? this.zzcbs : null;
        zzo zzo = this.zzdhy;
        zzt zzt = this.zzdic;
        zzbbw zzbbw = this.zzeem;
        AdOverlayInfoParcel adOverlayInfoParcel = new AdOverlayInfoParcel(zztp, zzo, zzt, zzbbw, z, i, zzbbw.zzxr());
        zza(adOverlayInfoParcel);
    }

    public final void zza(boolean z, int i, String str) {
        zzo zzo;
        boolean zzzu = this.zzeem.zzzu();
        zztp zztp = (!zzzu || this.zzeem.zzzn().zzaau()) ? this.zzcbs : null;
        if (zzzu) {
            zzo = null;
        } else {
            zzo = new zzbdq(this.zzeem, this.zzdhy);
        }
        zzadw zzadw = this.zzcxc;
        zzady zzady = this.zzcxd;
        zzt zzt = this.zzdic;
        zzbbw zzbbw = this.zzeem;
        AdOverlayInfoParcel adOverlayInfoParcel = new AdOverlayInfoParcel(zztp, zzo, zzadw, zzady, zzt, zzbbw, z, i, str, zzbbw.zzxr());
        zza(adOverlayInfoParcel);
    }

    public final void zza(boolean z, int i, String str, String str2) {
        zzo zzo;
        boolean zzzu = this.zzeem.zzzu();
        zztp zztp = (!zzzu || this.zzeem.zzzn().zzaau()) ? this.zzcbs : null;
        if (zzzu) {
            zzo = null;
        } else {
            zzo = new zzbdq(this.zzeem, this.zzdhy);
        }
        zzadw zzadw = this.zzcxc;
        zzady zzady = this.zzcxd;
        zzt zzt = this.zzdic;
        zzbbw zzbbw = this.zzeem;
        AdOverlayInfoParcel adOverlayInfoParcel = new AdOverlayInfoParcel(zztp, zzo, zzadw, zzady, zzt, zzbbw, z, i, str, str2, zzbbw.zzxr());
        zza(adOverlayInfoParcel);
    }

    private final void zza(AdOverlayInfoParcel adOverlayInfoParcel) {
        zzamz zzamz = this.zzcxy;
        boolean z = false;
        boolean zzsk = zzamz != null ? zzamz.zzsk() : false;
        zzq.zzki();
        Context context = this.zzeem.getContext();
        if (!zzsk) {
            z = true;
        }
        zzn.zza(context, adOverlayInfoParcel, z);
        if (this.zzeew != null) {
            String str = adOverlayInfoParcel.url;
            if (str == null && adOverlayInfoParcel.zzdhx != null) {
                str = adOverlayInfoParcel.zzdhx.url;
            }
            this.zzeew.zzdq(str);
        }
    }

    public final void destroy() {
        zzasi zzasi = this.zzeew;
        if (zzasi != null) {
            zzasi.zztp();
            this.zzeew = null;
        }
        zzza();
        this.zzeia.reset();
        this.zzeia.zzg(null);
        synchronized (this.lock) {
            this.zzcbs = null;
            this.zzdhy = null;
            this.zzeep = null;
            this.zzeeq = null;
            this.zzcxc = null;
            this.zzcxd = null;
            this.zzdic = null;
            this.zzeer = null;
            if (this.zzcxy != null) {
                this.zzcxy.zzv(true);
                this.zzcxy = null;
            }
        }
    }

    public final void zza(zzbdf zzbdf) {
        this.zzeep = zzbdf;
    }

    public final void zza(zzbdi zzbdi) {
        this.zzeeq = zzbdi;
    }

    public final void zzb(zzbdy zzbdy) {
        this.zzeia.zzg(zzbdy.uri);
    }

    public final boolean zzc(zzbdy zzbdy) {
        String valueOf = String.valueOf(zzbdy.url);
        String str = "AdWebView shouldOverrideUrlLoading: ";
        zzaug.zzdy(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        Uri uri = zzbdy.uri;
        if (this.zzeia.zzg(uri)) {
            return true;
        }
        if (this.zzees) {
            String scheme = uri.getScheme();
            if ("http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
                zztp zztp = this.zzcbs;
                if (zztp != null) {
                    zztp.onAdClicked();
                    zzasi zzasi = this.zzeew;
                    if (zzasi != null) {
                        zzasi.zzdq(zzbdy.url);
                    }
                    this.zzcbs = null;
                }
                return false;
            }
        }
        if (!this.zzeem.getWebView().willNotDraw()) {
            try {
                zzdf zzzs = this.zzeem.zzzs();
                if (zzzs != null && zzzs.zzc(uri)) {
                    uri = zzzs.zza(uri, this.zzeem.getContext(), this.zzeem.getView(), this.zzeem.zzxn());
                }
            } catch (zzdi unused) {
                String str2 = "Unable to append parameter to URL: ";
                String valueOf2 = String.valueOf(zzbdy.url);
                zzaug.zzeu(valueOf2.length() != 0 ? str2.concat(valueOf2) : new String(str2));
            }
            zzc zzc = this.zzcxx;
            if (zzc == null || zzc.zzjk()) {
                zzd zzd = new zzd("android.intent.action.VIEW", uri.toString(), null, null, null, null, null);
                zza(zzd);
            } else {
                this.zzcxx.zzbl(zzbdy.url);
            }
        } else {
            String str3 = "AdWebView unable to handle URL: ";
            String valueOf3 = String.valueOf(zzbdy.url);
            zzaug.zzeu(valueOf3.length() != 0 ? str3.concat(valueOf3) : new String(str3));
        }
        return true;
    }

    @Nullable
    public final WebResourceResponse zzd(zzbdy zzbdy) {
        WebResourceResponse webResourceResponse;
        String str;
        String str2 = "";
        zzasi zzasi = this.zzeew;
        if (zzasi != null) {
            zzasi.zza(zzbdy.url, zzbdy.zzab, 1);
        }
        if (!"mraid.js".equalsIgnoreCase(new File(zzbdy.url).getName())) {
            webResourceResponse = null;
        } else {
            zzsq();
            if (this.zzeem.zzzn().zzaau()) {
                str = (String) zzuv.zzon().zzd(zzza.zzcig);
            } else if (this.zzeem.zzzu()) {
                str = (String) zzuv.zzon().zzd(zzza.zzcif);
            } else {
                str = (String) zzuv.zzon().zzd(zzza.zzcie);
            }
            zzq.zzkj();
            webResourceResponse = zzaul.zzd(this.zzeem.getContext(), this.zzeem.zzxr().zzblz, str);
        }
        if (webResourceResponse != null) {
            return webResourceResponse;
        }
        try {
            if (!zzate.zzd(zzbdy.url, this.zzeem.getContext(), this.zzdlr).equals(zzbdy.url)) {
                return zze(zzbdy);
            }
            zzrp zzbt = zzrp.zzbt(zzbdy.url);
            if (zzbt != null) {
                zzro zza = zzq.zzkp().zza(zzbt);
                if (zza != null && zza.zzmi()) {
                    return new WebResourceResponse(str2, str2, zza.zzmj());
                }
            }
            if (zzaxc.isEnabled()) {
                if (((Boolean) zzuv.zzon().zzd(zzza.zzcls)).booleanValue()) {
                    return zze(zzbdy);
                }
            }
            return null;
        } catch (Exception | NoClassDefFoundError e) {
            zzq.zzkn().zza(e, "AdWebViewClient.interceptRequest");
            return zzzg();
        }
    }

    private static WebResourceResponse zzzg() {
        if (!((Boolean) zzuv.zzon().zzd(zzza.zzcka)).booleanValue()) {
            return null;
        }
        String str = "";
        return new WebResourceResponse(str, str, new ByteArrayInputStream(new byte[0]));
    }

    private final WebResourceResponse zze(zzbdy zzbdy) throws IOException {
        HttpURLConnection httpURLConnection;
        URL url = new URL(zzbdy.url);
        int i = 0;
        while (true) {
            i++;
            if (i <= 20) {
                URLConnection openConnection = url.openConnection();
                openConnection.setConnectTimeout(10000);
                openConnection.setReadTimeout(10000);
                for (Entry entry : zzbdy.zzab.entrySet()) {
                    openConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
                if (openConnection instanceof HttpURLConnection) {
                    httpURLConnection = (HttpURLConnection) openConnection;
                    zzq.zzkj().zza(this.zzeem.getContext(), this.zzeem.zzxr().zzblz, false, httpURLConnection);
                    zzaxc zzaxc = new zzaxc();
                    zzaxc.zza(httpURLConnection, (byte[]) null);
                    int responseCode = httpURLConnection.getResponseCode();
                    zzaxc.zza(httpURLConnection, responseCode);
                    if (responseCode < 300 || responseCode >= 400) {
                        zzq.zzkj();
                    } else {
                        String headerField = httpURLConnection.getHeaderField(Constants.HTTP_REDIRECT_URL_HEADER_FIELD);
                        if (headerField != null) {
                            URL url2 = new URL(url, headerField);
                            String protocol = url2.getProtocol();
                            if (protocol == null) {
                                zzaug.zzeu("Protocol is null");
                                return zzzg();
                            } else if (protocol.equals("http") || protocol.equals("https")) {
                                String str = "Redirecting to ";
                                String valueOf = String.valueOf(headerField);
                                zzaug.zzdv(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                                httpURLConnection.disconnect();
                                url = url2;
                            } else {
                                String str2 = "Unsupported scheme: ";
                                String valueOf2 = String.valueOf(protocol);
                                zzaug.zzeu(valueOf2.length() != 0 ? str2.concat(valueOf2) : new String(str2));
                                return zzzg();
                            }
                        } else {
                            throw new IOException("Missing Location header in redirect");
                        }
                    }
                } else {
                    throw new IOException("Invalid protocol.");
                }
            } else {
                StringBuilder sb = new StringBuilder(32);
                sb.append("Too many redirects (20)");
                throw new IOException(sb.toString());
            }
        }
        zzq.zzkj();
        return zzaul.zzd(httpURLConnection);
    }

    public final void zzao(boolean z) {
        this.zzees = z;
    }

    public final zzasi zzzh() {
        return this.zzeew;
    }

    public final void zzsq() {
        synchronized (this.lock) {
            this.zzees = false;
            this.zzbma = true;
            zzaxn.zzdwm.execute(new zzbdl(this));
        }
    }

    public final void zzaq(boolean z) {
        this.zzdlr = z;
    }

    public final void zzh(int i, int i2) {
        zzamz zzamz = this.zzcxy;
        if (zzamz != null) {
            zzamz.zzh(i, i2);
        }
    }

    public final void zzar(boolean z) {
        synchronized (this.lock) {
            this.zzeet = true;
        }
    }

    public final void zzh(Uri uri) {
        this.zzeia.zzh(uri);
    }

    @TargetApi(26)
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return this.zzeem.zzc(renderProcessGoneDetail.didCrash(), renderProcessGoneDetail.rendererPriorityAtExit());
    }
}
