package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.impl.C1774R;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbci extends FrameLayout implements zzbbw {
    /* access modifiers changed from: private */
    public final zzbbw zzefw;
    private final zzazc zzefx;
    private final AtomicBoolean zzefy = new AtomicBoolean();

    public zzbci(zzbbw zzbbw) {
        super(zzbbw.getContext());
        this.zzefw = zzbbw;
        this.zzefx = new zzazc(zzbbw.zzzk(), this, this);
        if (!zzaag()) {
            addView(this.zzefw.getView());
        }
    }

    public final View getView() {
        return this;
    }

    public final zzazc zzxk() {
        return this.zzefx;
    }

    public final void onPause() {
        this.zzefx.onPause();
        this.zzefw.onPause();
    }

    public final void zzzv() {
        this.zzefx.onDestroy();
        this.zzefw.zzzv();
    }

    public final void zzaab() {
        setBackgroundColor(0);
        this.zzefw.setBackgroundColor(0);
    }

    public final int zzxs() {
        return getMeasuredHeight();
    }

    public final int zzxt() {
        return getMeasuredWidth();
    }

    public final void zzxu() {
        this.zzefw.zzxu();
    }

    public final WebView getWebView() {
        return this.zzefw.getWebView();
    }

    public final void zza(String str, Map<String, ?> map) {
        this.zzefw.zza(str, map);
    }

    public final void zzb(String str, JSONObject jSONObject) {
        this.zzefw.zzb(str, jSONObject);
    }

    public final void zza(String str, zzaer<? super zzbbw> zzaer) {
        this.zzefw.zza(str, zzaer);
    }

    public final void zzb(String str, zzaer<? super zzbbw> zzaer) {
        this.zzefw.zzb(str, zzaer);
    }

    public final void zza(String str, Predicate<zzaer<? super zzbbw>> predicate) {
        this.zzefw.zza(str, predicate);
    }

    public final void zzzi() {
        this.zzefw.zzzi();
    }

    public final void zzdb(int i) {
        this.zzefw.zzdb(i);
    }

    public final void zzsu() {
        this.zzefw.zzsu();
    }

    public final void zzzj() {
        this.zzefw.zzzj();
    }

    public final void zza(boolean z, long j) {
        this.zzefw.zza(z, j);
    }

    public final void zzct(String str) {
        this.zzefw.zzct(str);
    }

    public final void zza(String str, JSONObject jSONObject) {
        this.zzefw.zza(str, jSONObject);
    }

    public final Activity zzxn() {
        return this.zzefw.zzxn();
    }

    public final Context zzzk() {
        return this.zzefw.zzzk();
    }

    public final zza zzxo() {
        return this.zzefw.zzxo();
    }

    public final zzc zzzl() {
        return this.zzefw.zzzl();
    }

    public final IObjectWrapper zzzt() {
        return this.zzefw.zzzt();
    }

    public final zzc zzzm() {
        return this.zzefw.zzzm();
    }

    public final zzbdj zzzn() {
        return this.zzefw.zzzn();
    }

    public final String zzzo() {
        return this.zzefw.zzzo();
    }

    public final zzbdg zzzp() {
        return this.zzefw.zzzp();
    }

    public final WebViewClient zzzq() {
        return this.zzefw.zzzq();
    }

    public final boolean zzzr() {
        return this.zzefw.zzzr();
    }

    public final zzdf zzzs() {
        return this.zzefw.zzzs();
    }

    public final zzaxl zzxr() {
        return this.zzefw.zzxr();
    }

    public final boolean zzzu() {
        return this.zzefw.zzzu();
    }

    public final boolean isDestroyed() {
        return this.zzefw.isDestroyed();
    }

    public final boolean zzzw() {
        return this.zzefw.zzzw();
    }

    public final void zzjq() {
        this.zzefw.zzjq();
    }

    public final void zzjp() {
        this.zzefw.zzjp();
    }

    public final String zzxp() {
        return this.zzefw.zzxp();
    }

    public final zzzz zzxm() {
        return this.zzefw.zzxm();
    }

    public final zzzy zzxq() {
        return this.zzefw.zzxq();
    }

    public final zzbco zzxl() {
        return this.zzefw.zzxl();
    }

    public final void zza(zzc zzc) {
        this.zzefw.zza(zzc);
    }

    public final void zzaq(IObjectWrapper iObjectWrapper) {
        this.zzefw.zzaq(iObjectWrapper);
    }

    public final void zza(zzbdj zzbdj) {
        this.zzefw.zza(zzbdj);
    }

    public final void zzas(boolean z) {
        this.zzefw.zzas(z);
    }

    public final void zzzy() {
        this.zzefw.zzzy();
    }

    public final void zzbr(Context context) {
        this.zzefw.zzbr(context);
    }

    public final void zzae(boolean z) {
        this.zzefw.zzae(z);
    }

    public final void setRequestedOrientation(int i) {
        this.zzefw.setRequestedOrientation(i);
    }

    public final void zzb(zzc zzc) {
        this.zzefw.zzb(zzc);
    }

    public final void zzat(boolean z) {
        this.zzefw.zzat(z);
    }

    public final void zza(String str, zzbax zzbax) {
        this.zzefw.zza(str, zzbax);
    }

    public final zzbax zzez(String str) {
        return this.zzefw.zzez(str);
    }

    public final void zzzz() {
        this.zzefw.zzzz();
    }

    public final void destroy() {
        IObjectWrapper zzzt = zzzt();
        if (zzzt != null) {
            zzq.zzky().zzaf(zzzt);
            zzaul.zzdsu.postDelayed(new zzbch(this), (long) ((Integer) zzuv.zzon().zzd(zzza.zzcqv)).intValue());
            return;
        }
        this.zzefw.destroy();
    }

    public final void loadData(String str, String str2, String str3) {
        this.zzefw.loadData(str, str2, str3);
    }

    public final void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.zzefw.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    public final void loadUrl(String str) {
        this.zzefw.loadUrl(str);
    }

    public final void zzb(String str, String str2, @Nullable String str3) {
        this.zzefw.zzb(str, str2, str3);
    }

    public final void setOnClickListener(OnClickListener onClickListener) {
        this.zzefw.setOnClickListener(onClickListener);
    }

    public final void setOnTouchListener(OnTouchListener onTouchListener) {
        this.zzefw.setOnTouchListener(onTouchListener);
    }

    public final void setWebChromeClient(WebChromeClient webChromeClient) {
        this.zzefw.setWebChromeClient(webChromeClient);
    }

    public final void setWebViewClient(WebViewClient webViewClient) {
        this.zzefw.setWebViewClient(webViewClient);
    }

    public final void onResume() {
        this.zzefw.onResume();
    }

    public final void zzaac() {
        TextView textView = new TextView(getContext());
        Resources resources = zzq.zzkn().getResources();
        textView.setText(resources != null ? resources.getString(C1774R.string.f3705s7) : "Test Ad");
        textView.setTextSize(15.0f);
        textView.setTextColor(-1);
        textView.setPadding(5, 0, 5, 0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(-12303292);
        gradientDrawable.setCornerRadius(8.0f);
        if (VERSION.SDK_INT >= 16) {
            textView.setBackground(gradientDrawable);
        } else {
            textView.setBackgroundDrawable(gradientDrawable);
        }
        addView(textView, new LayoutParams(-2, -2, 49));
        bringChildToFront(textView);
    }

    public final void zzaq(boolean z) {
        this.zzefw.zzaq(z);
    }

    public final void zza(zzaav zzaav) {
        this.zzefw.zza(zzaav);
    }

    public final void zza(zzqr zzqr) {
        this.zzefw.zza(zzqr);
    }

    public final zzqr zzaad() {
        return this.zzefw.zzaad();
    }

    public final void zza(zzpk zzpk) {
        this.zzefw.zza(zzpk);
    }

    public final void zza(@Nullable zzaaw zzaaw) {
        this.zzefw.zza(zzaaw);
    }

    @Nullable
    public final zzaaw zzaaa() {
        return this.zzefw.zzaaa();
    }

    public final void zza(zzbco zzbco) {
        this.zzefw.zza(zzbco);
    }

    public final boolean zzzx() {
        return this.zzefw.zzzx();
    }

    public final void zzau(boolean z) {
        this.zzefw.zzau(z);
    }

    public final void zzao(boolean z) {
        this.zzefw.zzao(z);
    }

    public final void zzsv() {
        this.zzefw.zzsv();
    }

    public final void zza(zzd zzd) {
        this.zzefw.zza(zzd);
    }

    public final void zzb(boolean z, int i) {
        this.zzefw.zzb(z, i);
    }

    public final void zza(boolean z, int i, String str) {
        this.zzefw.zza(z, i, str);
    }

    public final void zza(boolean z, int i, String str, String str2) {
        this.zzefw.zza(z, i, str, str2);
    }

    public final boolean zzc(boolean z, int i) {
        if (!this.zzefy.compareAndSet(false, true)) {
            return true;
        }
        if (((Boolean) zzuv.zzon().zzd(zzza.zzckd)).booleanValue()) {
            return false;
        }
        if (this.zzefw.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.zzefw.getParent()).removeView(this.zzefw.getView());
        }
        return this.zzefw.zzc(z, i);
    }

    public final boolean zzaae() {
        return this.zzefy.get();
    }

    public final void zza(ViewGroup viewGroup, Activity activity, String str, String str2) {
        this.zzefw.zza(this, activity, str, str2);
    }

    public final zzrf zzaaf() {
        return this.zzefw.zzaaf();
    }

    public final boolean zzaag() {
        return this.zzefw.zzaag();
    }
}
