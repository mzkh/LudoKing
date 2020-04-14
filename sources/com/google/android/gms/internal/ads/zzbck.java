package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzi;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzsf.zza.C3512zza;
import com.google.android.gms.internal.ads.zzsp.zzw;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzbck extends WebView implements OnGlobalLayoutListener, DownloadListener, zzbbw {
    private int maxHeight = -1;
    private int maxWidth = -1;
    @GuardedBy("this")
    private String zzabd;
    private final zzaxl zzblk;
    private final WindowManager zzbnk;
    private int zzdgn = -1;
    private int zzdgo = -1;
    @GuardedBy("this")
    private boolean zzdia;
    @GuardedBy("this")
    private String zzdje = "";
    @GuardedBy("this")
    private Boolean zzdqp;
    private zzzz zzeat;
    private final zzsd zzeen;
    private final zzbdk zzega;
    @Nullable
    private final zzdf zzegb;
    private final zzi zzegc;
    private final zza zzegd;
    private final float zzege;
    @Nullable
    private final zzrf zzegf;
    private final boolean zzegg;
    private boolean zzegh = false;
    private boolean zzegi = false;
    private zzbbv zzegj;
    @GuardedBy("this")
    private zzc zzegk;
    @GuardedBy("this")
    private IObjectWrapper zzegl;
    @GuardedBy("this")
    private zzbdj zzegm;
    @GuardedBy("this")
    private boolean zzegn;
    @GuardedBy("this")
    private boolean zzego;
    @GuardedBy("this")
    private boolean zzegp;
    @GuardedBy("this")
    private int zzegq;
    @GuardedBy("this")
    private boolean zzegr = true;
    @GuardedBy("this")
    private boolean zzegs = false;
    @GuardedBy("this")
    private zzbco zzegt;
    @GuardedBy("this")
    private boolean zzegu;
    @GuardedBy("this")
    private boolean zzegv;
    @GuardedBy("this")
    private zzaaw zzegw;
    @GuardedBy("this")
    private zzaav zzegx;
    @GuardedBy("this")
    private zzqr zzegy;
    @GuardedBy("this")
    private int zzegz;
    /* access modifiers changed from: private */
    @GuardedBy("this")
    public int zzeha;
    private zzzz zzehb;
    private zzzz zzehc;
    private zzzy zzehd;
    private WeakReference<OnClickListener> zzehe;
    @GuardedBy("this")
    private zzc zzehf;
    @GuardedBy("this")
    private boolean zzehg;
    private zzawv zzehh;
    private Map<String, zzbax> zzehi;
    private final DisplayMetrics zzwl;

    static zzbck zzb(Context context, zzbdj zzbdj, String str, boolean z, boolean z2, @Nullable zzdf zzdf, zzaxl zzaxl, zzaab zzaab, zzi zzi, zza zza, zzsd zzsd, zzrf zzrf, boolean z3) {
        Context context2 = context;
        zzbck zzbck = new zzbck(new zzbdk(context), zzbdj, str, z, z2, zzdf, zzaxl, zzaab, zzi, zza, zzsd, zzrf, z3);
        return zzbck;
    }

    public final View getView() {
        return this;
    }

    public final WebView getWebView() {
        return this;
    }

    public final boolean zzaae() {
        return false;
    }

    public final zzazc zzxk() {
        return null;
    }

    @VisibleForTesting
    private zzbck(zzbdk zzbdk, zzbdj zzbdj, String str, boolean z, boolean z2, @Nullable zzdf zzdf, zzaxl zzaxl, zzaab zzaab, zzi zzi, zza zza, zzsd zzsd, zzrf zzrf, boolean z3) {
        super(zzbdk);
        this.zzega = zzbdk;
        this.zzegm = zzbdj;
        this.zzabd = str;
        this.zzego = z;
        this.zzegq = -1;
        this.zzegb = zzdf;
        this.zzblk = zzaxl;
        this.zzegc = zzi;
        this.zzegd = zza;
        this.zzbnk = (WindowManager) getContext().getSystemService("window");
        zzq.zzkj();
        this.zzwl = zzaul.zza(this.zzbnk);
        this.zzege = this.zzwl.density;
        this.zzeen = zzsd;
        this.zzegf = zzrf;
        this.zzegg = z3;
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setAllowFileAccess(false);
        try {
            settings.setJavaScriptEnabled(true);
        } catch (NullPointerException e) {
            zzaug.zzc("Unable to enable Javascript.", e);
        }
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(2);
        }
        zzq.zzkj().zza((Context) zzbdk, zzaxl.zzblz, settings);
        zzq.zzkl().zza(getContext(), settings);
        setDownloadListener(this);
        zzaak();
        if (PlatformVersion.isAtLeastJellyBeanMR1()) {
            addJavascriptInterface(zzbcp.zzc(this), "googleAdsJsInterface");
        }
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        this.zzehh = new zzawv(this.zzega.zzxn(), this, this, null);
        zzaao();
        this.zzehd = new zzzy(new zzaab(true, "make_wv", this.zzabd));
        this.zzehd.zzpy().zzc(zzaab);
        this.zzeat = zzzs.zzb(this.zzehd.zzpy());
        this.zzehd.zza("native:view_create", this.zzeat);
        this.zzehc = null;
        this.zzehb = null;
        zzq.zzkl().zzbc(zzbdk);
        zzq.zzkn().zzue();
    }

    public final void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        if (webViewClient instanceof zzbbv) {
            this.zzegj = (zzbbv) webViewClient;
        }
    }

    public final zza zzxo() {
        return this.zzegd;
    }

    private final boolean zzaah() {
        int i;
        int i2;
        boolean z = false;
        if (!this.zzegj.zzyw() && !this.zzegj.zzyx()) {
            return false;
        }
        zzuv.zzoj();
        DisplayMetrics displayMetrics = this.zzwl;
        int zzb = zzawy.zzb(displayMetrics, displayMetrics.widthPixels);
        zzuv.zzoj();
        DisplayMetrics displayMetrics2 = this.zzwl;
        int zzb2 = zzawy.zzb(displayMetrics2, displayMetrics2.heightPixels);
        Activity zzxn = this.zzega.zzxn();
        if (zzxn == null || zzxn.getWindow() == null) {
            i2 = zzb;
            i = zzb2;
        } else {
            zzq.zzkj();
            int[] zzd = zzaul.zzd(zzxn);
            zzuv.zzoj();
            int zzb3 = zzawy.zzb(this.zzwl, zzd[0]);
            zzuv.zzoj();
            i = zzawy.zzb(this.zzwl, zzd[1]);
            i2 = zzb3;
        }
        if (this.zzdgn == zzb && this.zzdgo == zzb2 && this.maxWidth == i2 && this.maxHeight == i) {
            return false;
        }
        if (!(this.zzdgn == zzb && this.zzdgo == zzb2)) {
            z = true;
        }
        this.zzdgn = zzb;
        this.zzdgo = zzb2;
        this.maxWidth = i2;
        this.maxHeight = i;
        new zzanj(this).zza(zzb, zzb2, i2, i, this.zzwl.density, this.zzbnk.getDefaultDisplay().getRotation());
        return z;
    }

    public final void zza(String str, Map<String, ?> map) {
        try {
            zzb(str, zzq.zzkj().zzi(map));
        } catch (JSONException unused) {
            zzaug.zzeu("Could not convert parameters to JSON.");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        return;
     */
    @android.annotation.TargetApi(19)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void evaluateJavascript(java.lang.String r2, android.webkit.ValueCallback<java.lang.String> r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.isDestroyed()     // Catch:{ all -> 0x0019 }
            if (r0 == 0) goto L_0x0014
            java.lang.String r2 = "#004 The webview is destroyed. Ignoring action."
            com.google.android.gms.internal.ads.zzaug.zzew(r2)     // Catch:{ all -> 0x0019 }
            if (r3 == 0) goto L_0x0012
            r2 = 0
            r3.onReceiveValue(r2)     // Catch:{ all -> 0x0019 }
        L_0x0012:
            monitor-exit(r1)
            return
        L_0x0014:
            super.evaluateJavascript(r2, r3)     // Catch:{ all -> 0x0019 }
            monitor-exit(r1)
            return
        L_0x0019:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbck.evaluateJavascript(java.lang.String, android.webkit.ValueCallback):void");
    }

    private final synchronized void zzfi(String str) {
        if (!isDestroyed()) {
            loadUrl(str);
        } else {
            zzaug.zzeu("#004 The webview is destroyed. Ignoring action.");
        }
    }

    public final synchronized void loadUrl(String str) {
        if (!isDestroyed()) {
            try {
                super.loadUrl(str);
            } catch (Exception | IncompatibleClassChangeError | NoClassDefFoundError e) {
                zzq.zzkn().zza(e, "AdWebViewImpl.loadUrl");
                zzaug.zzd("Could not call loadUrl. ", e);
            }
        } else {
            zzaug.zzeu("#004 The webview is destroyed. Ignoring action.");
        }
    }

    private final synchronized void zzfj(String str) {
        try {
            super.loadUrl(str);
        } catch (Exception | IncompatibleClassChangeError | NoClassDefFoundError | UnsatisfiedLinkError e) {
            zzq.zzkn().zza(e, "AdWebViewImpl.loadUrlUnsafe");
            zzaug.zzd("Could not call loadUrl. ", e);
        }
    }

    public final synchronized void loadData(String str, String str2, String str3) {
        if (!isDestroyed()) {
            super.loadData(str, str2, str3);
        } else {
            zzaug.zzeu("#004 The webview is destroyed. Ignoring action.");
        }
    }

    public final synchronized void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (!isDestroyed()) {
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        } else {
            zzaug.zzeu("#004 The webview is destroyed. Ignoring action.");
        }
    }

    public final synchronized void zzb(String str, String str2, @Nullable String str3) {
        if (!isDestroyed()) {
            String str4 = str;
            super.loadDataWithBaseURL(str4, zzbcz.zzf(str2, zzbcz.zzaaq()), "text/html", "UTF-8", str3);
            return;
        }
        zzaug.zzeu("#004 The webview is destroyed. Ignoring action.");
    }

    @TargetApi(19)
    private final synchronized void zza(String str, ValueCallback<String> valueCallback) {
        if (!isDestroyed()) {
            evaluateJavascript(str, null);
        } else {
            zzaug.zzeu("#004 The webview is destroyed. Ignoring action.");
        }
    }

    private final void zzfk(String str) {
        String str2 = "javascript:";
        if (PlatformVersion.isAtLeastKitKat()) {
            if (zzuc() == null) {
                zzaai();
            }
            if (zzuc().booleanValue()) {
                zza(str, null);
                return;
            }
            String valueOf = String.valueOf(str);
            zzfi(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            return;
        }
        String valueOf2 = String.valueOf(str);
        zzfi(valueOf2.length() != 0 ? str2.concat(valueOf2) : new String(str2));
    }

    public final void zzct(String str) {
        zzfk(str);
    }

    private final synchronized void zzaai() {
        this.zzdqp = zzq.zzkn().zzuc();
        if (this.zzdqp == null) {
            try {
                evaluateJavascript("(function(){})()", null);
                zza(Boolean.valueOf(true));
            } catch (IllegalStateException unused) {
                zza(Boolean.valueOf(false));
            }
        }
    }

    @VisibleForTesting
    private final void zza(Boolean bool) {
        synchronized (this) {
            this.zzdqp = bool;
        }
        zzq.zzkn().zza(bool);
    }

    @VisibleForTesting
    private final synchronized Boolean zzuc() {
        return this.zzdqp;
    }

    public final void zza(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(jSONObject2).length());
        sb.append(str);
        sb.append("(");
        sb.append(jSONObject2);
        sb.append(");");
        zzfk(sb.toString());
    }

    public final void zzb(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("(window.AFMA_ReceiveMessage || function() {})('");
        sb.append(str);
        sb.append("'");
        sb.append(",");
        sb.append(jSONObject2);
        sb.append(");");
        String str2 = "Dispatching AFMA event: ";
        String valueOf = String.valueOf(sb.toString());
        zzaug.zzdv(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        zzfk(sb.toString());
    }

    public final void zzzi() {
        zzaaj();
        HashMap hashMap = new HashMap(1);
        hashMap.put("version", this.zzblk.zzblz);
        zza("onhide", (Map<String, ?>) hashMap);
    }

    public final void zzdb(int i) {
        if (i == 0) {
            zzzs.zza(this.zzehd.zzpy(), this.zzeat, "aebb2");
        }
        zzaaj();
        if (this.zzehd.zzpy() != null) {
            this.zzehd.zzpy().zzj("close_type", String.valueOf(i));
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("closetype", String.valueOf(i));
        hashMap.put("version", this.zzblk.zzblz);
        zza("onhide", (Map<String, ?>) hashMap);
    }

    private final void zzaaj() {
        zzzs.zza(this.zzehd.zzpy(), this.zzeat, "aeh2");
    }

    public final void zzsu() {
        if (this.zzehb == null) {
            zzzs.zza(this.zzehd.zzpy(), this.zzeat, "aes2");
            this.zzehb = zzzs.zzb(this.zzehd.zzpy());
            this.zzehd.zza("native:view_show", this.zzehb);
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put("version", this.zzblk.zzblz);
        zza("onshow", (Map<String, ?>) hashMap);
    }

    public final void zzzj() {
        HashMap hashMap = new HashMap(3);
        hashMap.put("app_muted", String.valueOf(zzq.zzko().zzot()));
        hashMap.put("app_volume", String.valueOf(zzq.zzko().zzos()));
        hashMap.put("device_volume", String.valueOf(zzave.zzbe(getContext())));
        zza("volume", (Map<String, ?>) hashMap);
    }

    public final void zza(boolean z, long j) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("success", z ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        hashMap.put("duration", Long.toString(j));
        zza("onCacheAccessComplete", (Map<String, ?>) hashMap);
    }

    public final synchronized zzc zzzl() {
        return this.zzegk;
    }

    public final synchronized IObjectWrapper zzzt() {
        return this.zzegl;
    }

    public final synchronized zzc zzzm() {
        return this.zzehf;
    }

    public final synchronized zzbdj zzzn() {
        return this.zzegm;
    }

    public final synchronized String zzzo() {
        return this.zzabd;
    }

    public final WebViewClient zzzq() {
        return this.zzegj;
    }

    public final synchronized boolean zzzr() {
        return this.zzdia;
    }

    public final zzdf zzzs() {
        return this.zzegb;
    }

    public final zzaxl zzxr() {
        return this.zzblk;
    }

    public final synchronized boolean zzzu() {
        return this.zzego;
    }

    public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(str), str4);
            zzq.zzkj();
            zzaul.zza(getContext(), intent);
        } catch (ActivityNotFoundException unused) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51 + String.valueOf(str4).length());
            sb.append("Couldn't find an Activity to view url/mimetype: ");
            sb.append(str);
            sb.append(" / ");
            sb.append(str4);
            zzaug.zzdv(sb.toString());
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.zzegj.zzyx()) {
            synchronized (this) {
                if (this.zzegw != null) {
                    this.zzegw.zzc(motionEvent);
                }
            }
        } else {
            zzdf zzdf = this.zzegb;
            if (zzdf != null) {
                zzdf.zzb(motionEvent);
            }
        }
        if (isDestroyed()) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float axisValue = motionEvent.getAxisValue(9);
        float axisValue2 = motionEvent.getAxisValue(10);
        if (motionEvent.getActionMasked() != 8 || ((axisValue <= 0.0f || canScrollVertically(-1)) && ((axisValue >= 0.0f || canScrollVertically(1)) && ((axisValue2 <= 0.0f || canScrollHorizontally(-1)) && (axisValue2 >= 0.0f || canScrollHorizontally(1)))))) {
            return super.onGenericMotionEvent(motionEvent);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x01f9, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x016c  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x01d7 A[SYNTHETIC, Splitter:B:112:0x01d7] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0141  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:122:0x01fa=Splitter:B:122:0x01fa, B:64:0x00de=Splitter:B:64:0x00de} */
    @android.annotation.SuppressLint({"DrawAllocation"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void onMeasure(int r8, int r9) {
        /*
            r7 = this;
            monitor-enter(r7)
            boolean r0 = r7.isDestroyed()     // Catch:{ all -> 0x01ff }
            r1 = 0
            if (r0 == 0) goto L_0x000d
            r7.setMeasuredDimension(r1, r1)     // Catch:{ all -> 0x01ff }
            monitor-exit(r7)
            return
        L_0x000d:
            boolean r0 = r7.isInEditMode()     // Catch:{ all -> 0x01ff }
            if (r0 != 0) goto L_0x01fa
            boolean r0 = r7.zzego     // Catch:{ all -> 0x01ff }
            if (r0 != 0) goto L_0x01fa
            com.google.android.gms.internal.ads.zzbdj r0 = r7.zzegm     // Catch:{ all -> 0x01ff }
            boolean r0 = r0.zzaav()     // Catch:{ all -> 0x01ff }
            if (r0 == 0) goto L_0x0021
            goto L_0x01fa
        L_0x0021:
            com.google.android.gms.internal.ads.zzbdj r0 = r7.zzegm     // Catch:{ all -> 0x01ff }
            boolean r0 = r0.zzaax()     // Catch:{ all -> 0x01ff }
            if (r0 == 0) goto L_0x002e
            super.onMeasure(r8, r9)     // Catch:{ all -> 0x01ff }
            monitor-exit(r7)
            return
        L_0x002e:
            com.google.android.gms.internal.ads.zzbdj r0 = r7.zzegm     // Catch:{ all -> 0x01ff }
            boolean r0 = r0.zzaaw()     // Catch:{ all -> 0x01ff }
            if (r0 == 0) goto L_0x0091
            com.google.android.gms.internal.ads.zzyp<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzza.zzcol     // Catch:{ all -> 0x01ff }
            com.google.android.gms.internal.ads.zzyw r1 = com.google.android.gms.internal.ads.zzuv.zzon()     // Catch:{ all -> 0x01ff }
            java.lang.Object r0 = r1.zzd(r0)     // Catch:{ all -> 0x01ff }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x01ff }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x01ff }
            if (r0 == 0) goto L_0x004d
            super.onMeasure(r8, r9)     // Catch:{ all -> 0x01ff }
            monitor-exit(r7)
            return
        L_0x004d:
            com.google.android.gms.internal.ads.zzbco r0 = r7.zzxl()     // Catch:{ all -> 0x01ff }
            r1 = 0
            if (r0 == 0) goto L_0x0059
            float r0 = r0.getAspectRatio()     // Catch:{ all -> 0x01ff }
            goto L_0x005a
        L_0x0059:
            r0 = 0
        L_0x005a:
            int r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x0063
            super.onMeasure(r8, r9)     // Catch:{ all -> 0x01ff }
            monitor-exit(r7)
            return
        L_0x0063:
            int r8 = android.view.View.MeasureSpec.getSize(r8)     // Catch:{ all -> 0x01ff }
            int r9 = android.view.View.MeasureSpec.getSize(r9)     // Catch:{ all -> 0x01ff }
            float r1 = (float) r9     // Catch:{ all -> 0x01ff }
            float r1 = r1 * r0
            int r1 = (int) r1     // Catch:{ all -> 0x01ff }
            float r2 = (float) r8     // Catch:{ all -> 0x01ff }
            float r2 = r2 / r0
            int r2 = (int) r2     // Catch:{ all -> 0x01ff }
            if (r9 != 0) goto L_0x007c
            if (r2 == 0) goto L_0x007c
            float r9 = (float) r2     // Catch:{ all -> 0x01ff }
            float r9 = r9 * r0
            int r1 = (int) r9     // Catch:{ all -> 0x01ff }
            r9 = r2
            goto L_0x0084
        L_0x007c:
            if (r8 != 0) goto L_0x0084
            if (r1 == 0) goto L_0x0084
            float r8 = (float) r1     // Catch:{ all -> 0x01ff }
            float r8 = r8 / r0
            int r2 = (int) r8     // Catch:{ all -> 0x01ff }
            r8 = r1
        L_0x0084:
            int r8 = java.lang.Math.min(r1, r8)     // Catch:{ all -> 0x01ff }
            int r9 = java.lang.Math.min(r2, r9)     // Catch:{ all -> 0x01ff }
            r7.setMeasuredDimension(r8, r9)     // Catch:{ all -> 0x01ff }
            monitor-exit(r7)
            return
        L_0x0091:
            com.google.android.gms.internal.ads.zzbdj r0 = r7.zzegm     // Catch:{ all -> 0x01ff }
            boolean r0 = r0.isFluid()     // Catch:{ all -> 0x01ff }
            if (r0 == 0) goto L_0x00e3
            com.google.android.gms.internal.ads.zzyp<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzza.zzcoo     // Catch:{ all -> 0x01ff }
            com.google.android.gms.internal.ads.zzyw r1 = com.google.android.gms.internal.ads.zzuv.zzon()     // Catch:{ all -> 0x01ff }
            java.lang.Object r0 = r1.zzd(r0)     // Catch:{ all -> 0x01ff }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x01ff }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x01ff }
            if (r0 != 0) goto L_0x00de
            boolean r0 = com.google.android.gms.common.util.PlatformVersion.isAtLeastJellyBeanMR1()     // Catch:{ all -> 0x01ff }
            if (r0 != 0) goto L_0x00b2
            goto L_0x00de
        L_0x00b2:
            java.lang.String r0 = "/contentHeight"
            com.google.android.gms.internal.ads.zzbcm r1 = new com.google.android.gms.internal.ads.zzbcm     // Catch:{ all -> 0x01ff }
            r1.<init>(r7)     // Catch:{ all -> 0x01ff }
            r7.zza(r0, r1)     // Catch:{ all -> 0x01ff }
            java.lang.String r0 = "(function() {  var height = -1;  if (document.body) {    height = document.body.offsetHeight;  } else if (document.documentElement) {    height = document.documentElement.offsetHeight;  }  var url = 'gmsg://mobileads.google.com/contentHeight?';  url += 'height=' + height;  try {    window.googleAdsJsInterface.notify(url);  } catch (e) {    var frame = document.getElementById('afma-notify-fluid');    if (!frame) {      frame = document.createElement('IFRAME');      frame.id = 'afma-notify-fluid';      frame.style.display = 'none';      var body = document.body || document.documentElement;      body.appendChild(frame);    }    frame.src = url;  }})();"
            r7.zzfk(r0)     // Catch:{ all -> 0x01ff }
            android.util.DisplayMetrics r0 = r7.zzwl     // Catch:{ all -> 0x01ff }
            float r0 = r0.density     // Catch:{ all -> 0x01ff }
            int r8 = android.view.View.MeasureSpec.getSize(r8)     // Catch:{ all -> 0x01ff }
            int r1 = r7.zzeha     // Catch:{ all -> 0x01ff }
            r2 = -1
            if (r1 == r2) goto L_0x00d5
            int r9 = r7.zzeha     // Catch:{ all -> 0x01ff }
            float r9 = (float) r9     // Catch:{ all -> 0x01ff }
            float r9 = r9 * r0
            int r9 = (int) r9     // Catch:{ all -> 0x01ff }
            goto L_0x00d9
        L_0x00d5:
            int r9 = android.view.View.MeasureSpec.getSize(r9)     // Catch:{ all -> 0x01ff }
        L_0x00d9:
            r7.setMeasuredDimension(r8, r9)     // Catch:{ all -> 0x01ff }
            monitor-exit(r7)
            return
        L_0x00de:
            super.onMeasure(r8, r9)     // Catch:{ all -> 0x01ff }
            monitor-exit(r7)
            return
        L_0x00e3:
            com.google.android.gms.internal.ads.zzbdj r0 = r7.zzegm     // Catch:{ all -> 0x01ff }
            boolean r0 = r0.zzaau()     // Catch:{ all -> 0x01ff }
            if (r0 == 0) goto L_0x00f8
            android.util.DisplayMetrics r8 = r7.zzwl     // Catch:{ all -> 0x01ff }
            int r8 = r8.widthPixels     // Catch:{ all -> 0x01ff }
            android.util.DisplayMetrics r9 = r7.zzwl     // Catch:{ all -> 0x01ff }
            int r9 = r9.heightPixels     // Catch:{ all -> 0x01ff }
            r7.setMeasuredDimension(r8, r9)     // Catch:{ all -> 0x01ff }
            monitor-exit(r7)
            return
        L_0x00f8:
            int r0 = android.view.View.MeasureSpec.getMode(r8)     // Catch:{ all -> 0x01ff }
            int r8 = android.view.View.MeasureSpec.getSize(r8)     // Catch:{ all -> 0x01ff }
            int r2 = android.view.View.MeasureSpec.getMode(r9)     // Catch:{ all -> 0x01ff }
            int r9 = android.view.View.MeasureSpec.getSize(r9)     // Catch:{ all -> 0x01ff }
            r3 = 1073741824(0x40000000, float:2.0)
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r0 == r4) goto L_0x0118
            if (r0 != r3) goto L_0x0114
            goto L_0x0118
        L_0x0114:
            r0 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x0119
        L_0x0118:
            r0 = r8
        L_0x0119:
            if (r2 == r4) goto L_0x011d
            if (r2 != r3) goto L_0x011e
        L_0x011d:
            r5 = r9
        L_0x011e:
            com.google.android.gms.internal.ads.zzbdj r2 = r7.zzegm     // Catch:{ all -> 0x01ff }
            int r2 = r2.widthPixels     // Catch:{ all -> 0x01ff }
            r3 = 1
            if (r2 > r0) goto L_0x012e
            com.google.android.gms.internal.ads.zzbdj r2 = r7.zzegm     // Catch:{ all -> 0x01ff }
            int r2 = r2.heightPixels     // Catch:{ all -> 0x01ff }
            if (r2 <= r5) goto L_0x012c
            goto L_0x012e
        L_0x012c:
            r2 = 0
            goto L_0x012f
        L_0x012e:
            r2 = 1
        L_0x012f:
            com.google.android.gms.internal.ads.zzyp<java.lang.Boolean> r4 = com.google.android.gms.internal.ads.zzza.zzcrj     // Catch:{ all -> 0x01ff }
            com.google.android.gms.internal.ads.zzyw r6 = com.google.android.gms.internal.ads.zzuv.zzon()     // Catch:{ all -> 0x01ff }
            java.lang.Object r4 = r6.zzd(r4)     // Catch:{ all -> 0x01ff }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ all -> 0x01ff }
            boolean r4 = r4.booleanValue()     // Catch:{ all -> 0x01ff }
            if (r4 == 0) goto L_0x0167
            com.google.android.gms.internal.ads.zzbdj r4 = r7.zzegm     // Catch:{ all -> 0x01ff }
            int r4 = r4.widthPixels     // Catch:{ all -> 0x01ff }
            float r4 = (float) r4     // Catch:{ all -> 0x01ff }
            float r6 = r7.zzege     // Catch:{ all -> 0x01ff }
            float r4 = r4 / r6
            float r0 = (float) r0     // Catch:{ all -> 0x01ff }
            float r6 = r7.zzege     // Catch:{ all -> 0x01ff }
            float r0 = r0 / r6
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 > 0) goto L_0x0163
            com.google.android.gms.internal.ads.zzbdj r0 = r7.zzegm     // Catch:{ all -> 0x01ff }
            int r0 = r0.heightPixels     // Catch:{ all -> 0x01ff }
            float r0 = (float) r0     // Catch:{ all -> 0x01ff }
            float r4 = r7.zzege     // Catch:{ all -> 0x01ff }
            float r0 = r0 / r4
            float r4 = (float) r5     // Catch:{ all -> 0x01ff }
            float r5 = r7.zzege     // Catch:{ all -> 0x01ff }
            float r4 = r4 / r5
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 > 0) goto L_0x0163
            r0 = 1
            goto L_0x0164
        L_0x0163:
            r0 = 0
        L_0x0164:
            if (r2 == 0) goto L_0x0167
            goto L_0x0168
        L_0x0167:
            r0 = r2
        L_0x0168:
            r2 = 8
            if (r0 == 0) goto L_0x01d7
            com.google.android.gms.internal.ads.zzbdj r0 = r7.zzegm     // Catch:{ all -> 0x01ff }
            int r0 = r0.widthPixels     // Catch:{ all -> 0x01ff }
            float r0 = (float) r0     // Catch:{ all -> 0x01ff }
            float r4 = r7.zzege     // Catch:{ all -> 0x01ff }
            float r0 = r0 / r4
            int r0 = (int) r0     // Catch:{ all -> 0x01ff }
            com.google.android.gms.internal.ads.zzbdj r4 = r7.zzegm     // Catch:{ all -> 0x01ff }
            int r4 = r4.heightPixels     // Catch:{ all -> 0x01ff }
            float r4 = (float) r4     // Catch:{ all -> 0x01ff }
            float r5 = r7.zzege     // Catch:{ all -> 0x01ff }
            float r4 = r4 / r5
            int r4 = (int) r4     // Catch:{ all -> 0x01ff }
            float r8 = (float) r8     // Catch:{ all -> 0x01ff }
            float r5 = r7.zzege     // Catch:{ all -> 0x01ff }
            float r8 = r8 / r5
            int r8 = (int) r8     // Catch:{ all -> 0x01ff }
            float r9 = (float) r9     // Catch:{ all -> 0x01ff }
            float r5 = r7.zzege     // Catch:{ all -> 0x01ff }
            float r9 = r9 / r5
            int r9 = (int) r9     // Catch:{ all -> 0x01ff }
            r5 = 103(0x67, float:1.44E-43)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x01ff }
            r6.<init>(r5)     // Catch:{ all -> 0x01ff }
            java.lang.String r5 = "Not enough space to show ad. Needs "
            r6.append(r5)     // Catch:{ all -> 0x01ff }
            r6.append(r0)     // Catch:{ all -> 0x01ff }
            java.lang.String r0 = "x"
            r6.append(r0)     // Catch:{ all -> 0x01ff }
            r6.append(r4)     // Catch:{ all -> 0x01ff }
            java.lang.String r0 = " dp, but only has "
            r6.append(r0)     // Catch:{ all -> 0x01ff }
            r6.append(r8)     // Catch:{ all -> 0x01ff }
            java.lang.String r8 = "x"
            r6.append(r8)     // Catch:{ all -> 0x01ff }
            r6.append(r9)     // Catch:{ all -> 0x01ff }
            java.lang.String r8 = " dp."
            r6.append(r8)     // Catch:{ all -> 0x01ff }
            java.lang.String r8 = r6.toString()     // Catch:{ all -> 0x01ff }
            com.google.android.gms.internal.ads.zzaug.zzeu(r8)     // Catch:{ all -> 0x01ff }
            int r8 = r7.getVisibility()     // Catch:{ all -> 0x01ff }
            if (r8 == r2) goto L_0x01c5
            r8 = 4
            r7.setVisibility(r8)     // Catch:{ all -> 0x01ff }
        L_0x01c5:
            r7.setMeasuredDimension(r1, r1)     // Catch:{ all -> 0x01ff }
            boolean r8 = r7.zzegh     // Catch:{ all -> 0x01ff }
            if (r8 != 0) goto L_0x01f8
            com.google.android.gms.internal.ads.zzsd r8 = r7.zzeen     // Catch:{ all -> 0x01ff }
            com.google.android.gms.internal.ads.zzsf$zza$zza r9 = com.google.android.gms.internal.ads.zzsf.zza.C3512zza.BANNER_SIZE_INVALID     // Catch:{ all -> 0x01ff }
            r8.zza(r9)     // Catch:{ all -> 0x01ff }
            r7.zzegh = r3     // Catch:{ all -> 0x01ff }
            monitor-exit(r7)
            return
        L_0x01d7:
            int r8 = r7.getVisibility()     // Catch:{ all -> 0x01ff }
            if (r8 == r2) goto L_0x01e0
            r7.setVisibility(r1)     // Catch:{ all -> 0x01ff }
        L_0x01e0:
            boolean r8 = r7.zzegi     // Catch:{ all -> 0x01ff }
            if (r8 != 0) goto L_0x01ed
            com.google.android.gms.internal.ads.zzsd r8 = r7.zzeen     // Catch:{ all -> 0x01ff }
            com.google.android.gms.internal.ads.zzsf$zza$zza r9 = com.google.android.gms.internal.ads.zzsf.zza.C3512zza.BANNER_SIZE_VALID     // Catch:{ all -> 0x01ff }
            r8.zza(r9)     // Catch:{ all -> 0x01ff }
            r7.zzegi = r3     // Catch:{ all -> 0x01ff }
        L_0x01ed:
            com.google.android.gms.internal.ads.zzbdj r8 = r7.zzegm     // Catch:{ all -> 0x01ff }
            int r8 = r8.widthPixels     // Catch:{ all -> 0x01ff }
            com.google.android.gms.internal.ads.zzbdj r9 = r7.zzegm     // Catch:{ all -> 0x01ff }
            int r9 = r9.heightPixels     // Catch:{ all -> 0x01ff }
            r7.setMeasuredDimension(r8, r9)     // Catch:{ all -> 0x01ff }
        L_0x01f8:
            monitor-exit(r7)
            return
        L_0x01fa:
            super.onMeasure(r8, r9)     // Catch:{ all -> 0x01ff }
            monitor-exit(r7)
            return
        L_0x01ff:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbck.onMeasure(int, int):void");
    }

    public final void onGlobalLayout() {
        boolean zzaah = zzaah();
        zzc zzzl = zzzl();
        if (zzzl != null && zzaah) {
            zzzl.zzst();
        }
    }

    public final synchronized void zza(zzc zzc) {
        this.zzegk = zzc;
    }

    public final synchronized void zzaq(IObjectWrapper iObjectWrapper) {
        this.zzegl = iObjectWrapper;
    }

    public final synchronized void zzb(zzc zzc) {
        this.zzehf = zzc;
    }

    public final synchronized void zza(zzbdj zzbdj) {
        this.zzegm = zzbdj;
        requestLayout();
    }

    public final synchronized void zzas(boolean z) {
        boolean z2 = z != this.zzego;
        this.zzego = z;
        zzaak();
        if (z2) {
            if (!((Boolean) zzuv.zzon().zzd(zzza.zzcii)).booleanValue() || !this.zzegm.zzaau()) {
                new zzanj(this).zzdp(z ? "expanded" : "default");
            }
        }
    }

    public final void zzzy() {
        this.zzehh.zzwf();
    }

    /* access modifiers changed from: protected */
    public final synchronized void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isDestroyed()) {
            this.zzehh.onAttachedToWindow();
        }
        boolean z = this.zzegu;
        if (this.zzegj != null && this.zzegj.zzyx()) {
            if (!this.zzegv) {
                this.zzegj.zzyy();
                this.zzegj.zzyz();
                this.zzegv = true;
            }
            zzaah();
            z = true;
        }
        zzav(z);
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        synchronized (this) {
            if (!isDestroyed()) {
                this.zzehh.onDetachedFromWindow();
            }
            super.onDetachedFromWindow();
            if (this.zzegv && this.zzegj != null && this.zzegj.zzyx() && getViewTreeObserver() != null && getViewTreeObserver().isAlive()) {
                this.zzegj.zzyy();
                this.zzegj.zzyz();
                this.zzegv = false;
            }
        }
        zzav(false);
    }

    public final void zzbr(Context context) {
        this.zzega.setBaseContext(context);
        this.zzehh.zzh(this.zzega.zzxn());
    }

    public final synchronized void zzae(boolean z) {
        if (this.zzegk != null) {
            this.zzegk.zza(this.zzegj.zzyw(), z);
        } else {
            this.zzdia = z;
        }
    }

    public final synchronized void setRequestedOrientation(int i) {
        this.zzegq = i;
        if (this.zzegk != null) {
            this.zzegk.setRequestedOrientation(this.zzegq);
        }
    }

    public final Activity zzxn() {
        return this.zzega.zzxn();
    }

    public final Context zzzk() {
        return this.zzega.zzzk();
    }

    private final synchronized void zzaak() {
        if (!this.zzego) {
            if (!this.zzegm.zzaau()) {
                if (VERSION.SDK_INT < 18) {
                    zzaug.zzdv("Disabling hardware acceleration on an AdView.");
                    zzaal();
                    return;
                }
                zzaug.zzdv("Enabling hardware acceleration on an AdView.");
                zzaam();
                return;
            }
        }
        zzaug.zzdv("Enabling hardware acceleration on an overlay.");
        zzaam();
    }

    private final synchronized void zzaal() {
        if (!this.zzegp) {
            zzq.zzkl();
            setLayerType(1, null);
        }
        this.zzegp = true;
    }

    private final synchronized void zzaam() {
        if (this.zzegp) {
            zzq.zzkl();
            setLayerType(0, null);
        }
        this.zzegp = false;
    }

    public final synchronized void destroy() {
        zzaao();
        this.zzehh.zzwg();
        if (this.zzegk != null) {
            this.zzegk.close();
            this.zzegk.onDestroy();
            this.zzegk = null;
        }
        this.zzegl = null;
        this.zzegj.reset();
        if (!this.zzegn) {
            zzq.zzlf();
            zzbay.zzc(this);
            zzaan();
            this.zzegn = true;
            zzaug.zzdy("Initiating WebView self destruct sequence in 3...");
            zzaug.zzdy("Loading blank page in WebView, 2...");
            zzfj("about:blank");
        }
    }

    /* access modifiers changed from: protected */
    public final void finalize() throws Throwable {
        try {
            synchronized (this) {
                if (!this.zzegn) {
                    this.zzegj.reset();
                    zzq.zzlf();
                    zzbay.zzc(this);
                    zzaan();
                    zzuf();
                }
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
            throw th;
        }
    }

    public final synchronized void zzzv() {
        zzaug.zzdy("Destroying WebView!");
        zzuf();
        zzaul.zzdsu.post(new zzbcl(this));
    }

    private final synchronized void zzuf() {
        if (!this.zzehg) {
            this.zzehg = true;
            zzq.zzkn().zzuf();
        }
    }

    public final synchronized boolean isDestroyed() {
        return this.zzegn;
    }

    /* access modifiers changed from: protected */
    @TargetApi(21)
    public final void onDraw(Canvas canvas) {
        if (!isDestroyed()) {
            if (VERSION.SDK_INT != 21 || !canvas.isHardwareAccelerated() || isAttachedToWindow()) {
                super.onDraw(canvas);
                zzbbv zzbbv = this.zzegj;
            }
        }
    }

    public final void zzzz() {
        if (this.zzehc == null) {
            this.zzehc = zzzs.zzb(this.zzehd.zzpy());
            this.zzehd.zza("native:view_load", this.zzehc);
        }
    }

    public final void onPause() {
        if (!isDestroyed()) {
            try {
                super.onPause();
            } catch (Exception e) {
                zzaug.zzc("Could not pause webview.", e);
            }
        }
    }

    public final void onResume() {
        if (!isDestroyed()) {
            try {
                super.onResume();
            } catch (Exception e) {
                zzaug.zzc("Could not resume webview.", e);
            }
        }
    }

    public final void zzaac() {
        zzaug.zzdy("Cannot add text view to inner AdWebView");
    }

    public final void zzaq(boolean z) {
        this.zzegj.zzaq(z);
    }

    public final void stopLoading() {
        if (!isDestroyed()) {
            try {
                super.stopLoading();
            } catch (Exception e) {
                zzaug.zzc("Could not stop loading webview.", e);
            }
        }
    }

    public final synchronized void zzat(boolean z) {
        this.zzegr = z;
    }

    public final synchronized boolean zzzw() {
        return this.zzegr;
    }

    public final synchronized void zzjp() {
        this.zzegs = true;
        if (this.zzegc != null) {
            this.zzegc.zzjp();
        }
    }

    public final synchronized void zzjq() {
        this.zzegs = false;
        if (this.zzegc != null) {
            this.zzegc.zzjq();
        }
    }

    private final synchronized void zzaan() {
        if (this.zzehi != null) {
            for (zzbax release : this.zzehi.values()) {
                release.release();
            }
        }
        this.zzehi = null;
    }

    public final synchronized void zza(String str, zzbax zzbax) {
        if (this.zzehi == null) {
            this.zzehi = new HashMap();
        }
        this.zzehi.put(str, zzbax);
    }

    public final synchronized zzbax zzez(String str) {
        if (this.zzehi == null) {
            return null;
        }
        return (zzbax) this.zzehi.get(str);
    }

    public final synchronized String zzxp() {
        return this.zzdje;
    }

    public final synchronized void zzxu() {
        if (this.zzegx != null) {
            this.zzegx.zzqj();
        }
    }

    public final synchronized void zza(zzaav zzaav) {
        this.zzegx = zzaav;
    }

    public final synchronized void zza(zzqr zzqr) {
        this.zzegy = zzqr;
    }

    public final synchronized zzqr zzaad() {
        return this.zzegy;
    }

    public final zzzz zzxm() {
        return this.zzeat;
    }

    public final zzzy zzxq() {
        return this.zzehd;
    }

    public final void setOnClickListener(OnClickListener onClickListener) {
        this.zzehe = new WeakReference<>(onClickListener);
        super.setOnClickListener(onClickListener);
    }

    public final synchronized void zza(zzaaw zzaaw) {
        this.zzegw = zzaaw;
    }

    public final synchronized zzaaw zzaaa() {
        return this.zzegw;
    }

    public final synchronized zzbco zzxl() {
        return this.zzegt;
    }

    public final synchronized void zza(zzbco zzbco) {
        if (this.zzegt != null) {
            zzaug.zzes("Attempt to create multiple AdWebViewVideoControllers.");
        } else {
            this.zzegt = zzbco;
        }
    }

    public final synchronized boolean zzzx() {
        return this.zzegz > 0;
    }

    public final synchronized void zzau(boolean z) {
        this.zzegz += z ? 1 : -1;
        if (this.zzegz <= 0 && this.zzegk != null) {
            this.zzegk.zzsw();
        }
    }

    private final void zzaao() {
        zzzy zzzy = this.zzehd;
        if (zzzy != null) {
            zzaab zzpy = zzzy.zzpy();
            if (!(zzpy == null || zzq.zzkn().zzub() == null)) {
                zzq.zzkn().zzub().zza(zzpy);
            }
        }
    }

    public final void zzaab() {
        setBackgroundColor(0);
    }

    public final void zzao(boolean z) {
        this.zzegj.zzao(z);
    }

    public final void zzsv() {
        zzc zzzl = zzzl();
        if (zzzl != null) {
            zzzl.zzsv();
        }
    }

    public final int zzxs() {
        return getMeasuredHeight();
    }

    public final int zzxt() {
        return getMeasuredWidth();
    }

    public final void zza(zzd zzd) {
        this.zzegj.zza(zzd);
    }

    public final void zzb(boolean z, int i) {
        this.zzegj.zzb(z, i);
    }

    public final void zza(boolean z, int i, String str) {
        this.zzegj.zza(z, i, str);
    }

    public final void zza(boolean z, int i, String str, String str2) {
        this.zzegj.zza(z, i, str, str2);
    }

    public final void zza(zzpk zzpk) {
        synchronized (this) {
            this.zzegu = zzpk.zzbnp;
        }
        zzav(zzpk.zzbnp);
    }

    private final void zzav(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("isVisible", z ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        zza("onAdVisibilityChanged", (Map<String, ?>) hashMap);
    }

    public final void zza(String str, zzaer<? super zzbbw> zzaer) {
        zzbbv zzbbv = this.zzegj;
        if (zzbbv != null) {
            zzbbv.zza(str, zzaer);
        }
    }

    public final void zzb(String str, zzaer<? super zzbbw> zzaer) {
        zzbbv zzbbv = this.zzegj;
        if (zzbbv != null) {
            zzbbv.zzb(str, zzaer);
        }
    }

    public final void zza(String str, Predicate<zzaer<? super zzbbw>> predicate) {
        zzbbv zzbbv = this.zzegj;
        if (zzbbv != null) {
            zzbbv.zza(str, predicate);
        }
    }

    public final boolean zzc(boolean z, int i) {
        destroy();
        this.zzeen.zza((zzsg) new zzbcj(z, i));
        this.zzeen.zza(C3512zza.ANDROID_WEBVIEW_CRASH);
        return true;
    }

    public final void zza(ViewGroup viewGroup, Activity activity, String str, String str2) {
        if (!zzaag()) {
            zzaug.zzdy("AR ad is not enabled or the ad from the server is not an AR ad.");
            return;
        }
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).removeView(this);
        }
        zzaug.zzdy("Initializing ArWebView object.");
        this.zzegf.zza(activity, this);
        this.zzegf.zze(str, str2);
        if (viewGroup != null) {
            viewGroup.addView(this.zzegf.getView());
        } else {
            zzaug.zzes("The FrameLayout object cannot be null.");
        }
    }

    public final zzrf zzaaf() {
        return this.zzegf;
    }

    public final boolean zzaag() {
        return ((Boolean) zzuv.zzon().zzd(zzza.zzcth)).booleanValue() && this.zzegf != null && this.zzegg;
    }

    public final /* synthetic */ zzbdg zzzp() {
        return this.zzegj;
    }

    static final /* synthetic */ void zza(boolean z, int i, zztl zztl) {
        zzw.zza zznv = zzw.zznv();
        if (zznv.zznu() != z) {
            zznv.zzp(z);
        }
        zztl.zzcaz = (zzw) ((zzdqw) zznv.zzce(i).zzazr());
    }
}
