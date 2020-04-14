package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
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
import com.google.android.gms.games.Notifications;
import com.google.android.gms.internal.ads.zzsf.zza.C3512zza;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@ParametersAreNonnullByDefault
@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public class zzbbv extends WebViewClient implements zzbdg {
    private static final String[] zzeek = {"UNKNOWN", "HOST_LOOKUP", "UNSUPPORTED_AUTH_SCHEME", "AUTHENTICATION", "PROXY_AUTHENTICATION", "CONNECT", "IO", "TIMEOUT", "REDIRECT_LOOP", "UNSUPPORTED_SCHEME", "FAILED_SSL_HANDSHAKE", "BAD_URL", "FILE", "FILE_NOT_FOUND", "TOO_MANY_REQUESTS"};
    private static final String[] zzeel = {"NOT_YET_VALID", "EXPIRED", "ID_MISMATCH", "UNTRUSTED", "DATE_INVALID", "INVALID"};
    private final Object lock;
    @GuardedBy("lock")
    private boolean zzbma;
    private zztp zzcbs;
    private zzadw zzcxc;
    private zzady zzcxd;
    private zzc zzcxx;
    private zzamz zzcxy;
    private zzo zzdhy;
    private zzt zzdic;
    private boolean zzdlr;
    protected zzbbw zzeem;
    @Nullable
    private final zzsd zzeen;
    private final HashMap<String, List<zzaer<? super zzbbw>>> zzeeo;
    private zzbdf zzeep;
    private zzbdi zzeeq;
    private zzbdh zzeer;
    private boolean zzees;
    @GuardedBy("lock")
    private boolean zzeet;
    @GuardedBy("lock")
    private boolean zzeeu;
    private final zzang zzeev;
    @Nullable
    protected zzasi zzeew;
    private boolean zzeex;
    private boolean zzeey;
    private int zzeez;
    private OnAttachStateChangeListener zzefa;

    public zzbbv(zzbbw zzbbw, zzsd zzsd, boolean z) {
        this(zzbbw, zzsd, z, new zzang(zzbbw, zzbbw.zzzk(), new zzyl(zzbbw.getContext())), null);
    }

    @VisibleForTesting
    private zzbbv(zzbbw zzbbw, zzsd zzsd, boolean z, zzang zzang, zzamz zzamz) {
        this.zzeeo = new HashMap<>();
        this.lock = new Object();
        this.zzees = false;
        this.zzeen = zzsd;
        this.zzeem = zzbbw;
        this.zzbma = z;
        this.zzeev = zzang;
        this.zzcxy = null;
    }

    public final void zza(int i, int i2, boolean z) {
        this.zzeev.zzi(i, i2);
        zzamz zzamz = this.zzcxy;
        if (zzamz != null) {
            zzamz.zza(i, i2, false);
        }
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
        boolean z;
        synchronized (this.lock) {
            z = this.zzbma;
        }
        return z;
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

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        zzrf zzaaf = this.zzeem.zzaaf();
        if (zzaaf != null && webView == zzaaf.getWebView()) {
            zzaaf.onPageStarted(webView, str, bitmap);
        }
        super.onPageStarted(webView, str, bitmap);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001d, code lost:
        if (r1 == null) goto L_0x0025;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001f, code lost:
        r1.zzrf();
        r0.zzeeq = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0025, code lost:
        zzzf();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0028, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0018, code lost:
        r0.zzeex = true;
        r1 = r0.zzeeq;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onPageFinished(android.webkit.WebView r1, java.lang.String r2) {
        /*
            r0 = this;
            java.lang.Object r1 = r0.lock
            monitor-enter(r1)
            com.google.android.gms.internal.ads.zzbbw r2 = r0.zzeem     // Catch:{ all -> 0x0029 }
            boolean r2 = r2.isDestroyed()     // Catch:{ all -> 0x0029 }
            if (r2 == 0) goto L_0x0017
            java.lang.String r2 = "Blank page loaded, 1..."
            com.google.android.gms.internal.ads.zzaug.zzdy(r2)     // Catch:{ all -> 0x0029 }
            com.google.android.gms.internal.ads.zzbbw r2 = r0.zzeem     // Catch:{ all -> 0x0029 }
            r2.zzzv()     // Catch:{ all -> 0x0029 }
            monitor-exit(r1)     // Catch:{ all -> 0x0029 }
            return
        L_0x0017:
            monitor-exit(r1)     // Catch:{ all -> 0x0029 }
            r1 = 1
            r0.zzeex = r1
            com.google.android.gms.internal.ads.zzbdi r1 = r0.zzeeq
            if (r1 == 0) goto L_0x0025
            r1.zzrf()
            r1 = 0
            r0.zzeeq = r1
        L_0x0025:
            r0.zzzf()
            return
        L_0x0029:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0029 }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbbv.onPageFinished(android.webkit.WebView, java.lang.String):void");
    }

    /* access modifiers changed from: private */
    public final void zza(View view, zzasi zzasi, int i) {
        if (zzasi.zztn() && i > 0) {
            zzasi.zzj(view);
            if (zzasi.zztn()) {
                zzaul.zzdsu.postDelayed(new zzbca(this, view, zzasi, i), 100);
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
            this.zzefa = new zzbbz(this, zzasi);
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
        zzsd zzsd = this.zzeen;
        if (zzsd != null) {
            zzsd.zza(C3512zza.DELAY_PAGE_LOAD_CANCELLED_AD);
        }
        this.zzeey = true;
        zzzf();
        if (((Boolean) zzuv.zzon().zzd(zzza.zzcrz)).booleanValue()) {
            this.zzeem.destroy();
        }
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
            zzo = new zzbcc(this.zzeem, this.zzdhy);
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
            zzo = new zzbcc(this.zzeem, this.zzdhy);
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

    public final void zza(String str, zzaer<? super zzbbw> zzaer) {
        synchronized (this.lock) {
            List list = (List) this.zzeeo.get(str);
            if (list == null) {
                list = new CopyOnWriteArrayList();
                this.zzeeo.put(str, list);
            }
            list.add(zzaer);
        }
    }

    public final void zzb(String str, zzaer<? super zzbbw> zzaer) {
        synchronized (this.lock) {
            List list = (List) this.zzeeo.get(str);
            if (list != null) {
                list.remove(zzaer);
            }
        }
    }

    public final void zza(String str, Predicate<zzaer<? super zzbbw>> predicate) {
        synchronized (this.lock) {
            List<zzaer> list = (List) this.zzeeo.get(str);
            if (list != null) {
                ArrayList arrayList = new ArrayList();
                for (zzaer zzaer : list) {
                    if (predicate.apply(zzaer)) {
                        arrayList.add(zzaer);
                    }
                }
                list.removeAll(arrayList);
            }
        }
    }

    public final void reset() {
        zzasi zzasi = this.zzeew;
        if (zzasi != null) {
            zzasi.zztp();
            this.zzeew = null;
        }
        zzza();
        synchronized (this.lock) {
            this.zzeeo.clear();
            this.zzcbs = null;
            this.zzdhy = null;
            this.zzeep = null;
            this.zzeeq = null;
            this.zzcxc = null;
            this.zzcxd = null;
            this.zzees = false;
            this.zzbma = false;
            this.zzeet = false;
            this.zzeeu = false;
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

    public final void onLoadResource(WebView webView, String str) {
        String valueOf = String.valueOf(str);
        String str2 = "Loading resource: ";
        zzaug.zzdy(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme())) {
            if ("mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
                zzh(parse);
            }
        }
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        String str3;
        if (i < 0) {
            int i2 = (-i) - 1;
            String[] strArr = zzeek;
            if (i2 < strArr.length) {
                str3 = strArr[i2];
                zze(this.zzeem.getContext(), "http_err", str3, str2);
                super.onReceivedError(webView, i, str, str2);
            }
        }
        str3 = String.valueOf(i);
        zze(this.zzeem.getContext(), "http_err", str3, str2);
        super.onReceivedError(webView, i, str, str2);
    }

    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        String str;
        if (sslError != null) {
            int primaryError = sslError.getPrimaryError();
            if (primaryError >= 0) {
                String[] strArr = zzeel;
                if (primaryError < strArr.length) {
                    str = strArr[primaryError];
                    Context context = this.zzeem.getContext();
                    zzq.zzkl();
                    zze(context, "ssl_err", str, sslError.getUrl());
                }
            }
            str = String.valueOf(primaryError);
            Context context2 = this.zzeem.getContext();
            zzq.zzkl();
            zze(context2, "ssl_err", str, sslError.getUrl());
        }
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    private final void zze(Context context, String str, String str2, String str3) {
        String str4;
        if (((Boolean) zzuv.zzon().zzd(zzza.zzcmd)).booleanValue()) {
            Bundle bundle = new Bundle();
            bundle.putString(NotificationCompat.CATEGORY_ERROR, str);
            bundle.putString("code", str2);
            if (!TextUtils.isEmpty(str3)) {
                Uri parse = Uri.parse(str3);
                if (parse.getHost() != null) {
                    str4 = parse.getHost();
                    bundle.putString("host", str4);
                    zzq.zzkj().zza(context, this.zzeem.zzxr().zzblz, "gmob-apps", bundle, true);
                }
            }
            str4 = "";
            bundle.putString("host", str4);
            zzq.zzkj().zza(context, this.zzeem.zzxr().zzblz, "gmob-apps", bundle, true);
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        String valueOf = String.valueOf(str);
        String str2 = "AdWebView shouldOverrideUrlLoading: ";
        zzaug.zzdy(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme())) {
            if ("mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
                zzh(parse);
                return true;
            }
        }
        if (this.zzees && webView == this.zzeem.getWebView()) {
            String scheme = parse.getScheme();
            if ("http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
                zztp zztp = this.zzcbs;
                if (zztp != null) {
                    zztp.onAdClicked();
                    zzasi zzasi = this.zzeew;
                    if (zzasi != null) {
                        zzasi.zzdq(str);
                    }
                    this.zzcbs = null;
                }
                return super.shouldOverrideUrlLoading(webView, str);
            }
        }
        if (!this.zzeem.getWebView().willNotDraw()) {
            try {
                zzdf zzzs = this.zzeem.zzzs();
                if (zzzs != null && zzzs.zzc(parse)) {
                    parse = zzzs.zza(parse, this.zzeem.getContext(), this.zzeem.getView(), this.zzeem.zzxn());
                }
            } catch (zzdi unused) {
                String str3 = "Unable to append parameter to URL: ";
                String valueOf2 = String.valueOf(str);
                zzaug.zzeu(valueOf2.length() != 0 ? str3.concat(valueOf2) : new String(str3));
            }
            zzc zzc = this.zzcxx;
            if (zzc == null || zzc.zzjk()) {
                zzd zzd = new zzd("android.intent.action.VIEW", parse.toString(), null, null, null, null, null);
                zza(zzd);
            } else {
                this.zzcxx.zzbl(str);
            }
        } else {
            String str4 = "AdWebView unable to handle URL: ";
            String valueOf3 = String.valueOf(str);
            zzaug.zzeu(valueOf3.length() != 0 ? str4.concat(valueOf3) : new String(str4));
        }
        return true;
    }

    @TargetApi(11)
    @Nullable
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return zzd(str, Collections.emptyMap());
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final WebResourceResponse zzd(String str, Map<String, String> map) {
        String str2 = "";
        try {
            String zzd = zzate.zzd(str, this.zzeem.getContext(), this.zzdlr);
            if (!zzd.equals(str)) {
                return zze(zzd, map);
            }
            zzrp zzbt = zzrp.zzbt(str);
            if (zzbt != null) {
                zzro zza = zzq.zzkp().zza(zzbt);
                if (zza != null && zza.zzmi()) {
                    return new WebResourceResponse(str2, str2, zza.zzmj());
                }
            }
            if (zzaxc.isEnabled()) {
                if (((Boolean) zzuv.zzon().zzd(zzza.zzcls)).booleanValue()) {
                    return zze(str, map);
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

    private final WebResourceResponse zze(String str, Map<String, String> map) throws IOException {
        HttpURLConnection httpURLConnection;
        URL url = new URL(str);
        int i = 0;
        while (true) {
            i++;
            if (i <= 20) {
                URLConnection openConnection = url.openConnection();
                openConnection.setConnectTimeout(10000);
                openConnection.setReadTimeout(10000);
                for (Entry entry : map.entrySet()) {
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
                                String str2 = "Redirecting to ";
                                String valueOf = String.valueOf(headerField);
                                zzaug.zzdv(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                                httpURLConnection.disconnect();
                                url = url2;
                            } else {
                                String str3 = "Unsupported scheme: ";
                                String valueOf2 = String.valueOf(protocol);
                                zzaug.zzeu(valueOf2.length() != 0 ? str3.concat(valueOf2) : new String(str3));
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
            zzaxn.zzdwm.execute(new zzbby(this));
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

    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (!(keyCode == 79 || keyCode == 222)) {
            switch (keyCode) {
                case 85:
                case 86:
                case 87:
                case 88:
                case 89:
                case 90:
                case 91:
                    break;
                default:
                    switch (keyCode) {
                        case 126:
                        case Notifications.NOTIFICATION_TYPES_ALL /*127*/:
                        case 128:
                        case 129:
                        case 130:
                            break;
                        default:
                            return false;
                    }
            }
        }
        return true;
    }

    public final void zzh(Uri uri) {
        String path = uri.getPath();
        List<zzaer> list = (List) this.zzeeo.get(path);
        if (list != null) {
            zzq.zzkj();
            Map zzi = zzaul.zzi(uri);
            if (zzaug.isLoggable(2)) {
                String str = "Received GMSG: ";
                String valueOf = String.valueOf(path);
                zzaug.zzdy(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                for (String str2 : zzi.keySet()) {
                    String str3 = (String) zzi.get(str2);
                    StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 4 + String.valueOf(str3).length());
                    sb.append("  ");
                    sb.append(str2);
                    sb.append(": ");
                    sb.append(str3);
                    zzaug.zzdy(sb.toString());
                }
            }
            for (zzaer zza : list) {
                zza.zza(this.zzeem, zzi);
            }
            return;
        }
        String valueOf2 = String.valueOf(uri);
        StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 32);
        sb2.append("No GMSG handler found for GMSG: ");
        sb2.append(valueOf2);
        zzaug.zzdy(sb2.toString());
        if (((Boolean) zzuv.zzon().zzd(zzza.zzctw)).booleanValue() && zzq.zzkn().zzub() != null) {
            zzaxn.zzdwi.execute(new zzbbx(path));
        }
    }

    public final void zzar(boolean z) {
        synchronized (this.lock) {
            this.zzeet = true;
        }
    }

    @TargetApi(26)
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return this.zzeem.zzc(renderProcessGoneDetail.didCrash(), renderProcessGoneDetail.rendererPriorityAtExit());
    }
}
