package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzi;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public interface zzbbw extends zzi, zzagn, zzahk, zzazj, zzbct, zzbcw, zzbda, zzbdb, zzbdd, zzbde, zzpj {
    void destroy();

    Context getContext();

    int getHeight();

    LayoutParams getLayoutParams();

    void getLocationOnScreen(int[] iArr);

    ViewParent getParent();

    View getView();

    WebView getWebView();

    int getWidth();

    boolean isDestroyed();

    void loadData(String str, String str2, String str3);

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, @Nullable String str5);

    void loadUrl(String str);

    void measure(int i, int i2);

    void onPause();

    void onResume();

    void setBackgroundColor(int i);

    void setOnClickListener(OnClickListener onClickListener);

    void setOnTouchListener(OnTouchListener onTouchListener);

    void setRequestedOrientation(int i);

    void setWebChromeClient(WebChromeClient webChromeClient);

    void setWebViewClient(WebViewClient webViewClient);

    void zza(ViewGroup viewGroup, Activity activity, String str, String str2);

    void zza(zzc zzc);

    void zza(zzaav zzaav);

    void zza(zzaaw zzaaw);

    void zza(zzbco zzbco);

    void zza(zzbdj zzbdj);

    void zza(zzqr zzqr);

    void zza(String str, Predicate<zzaer<? super zzbbw>> predicate);

    void zza(String str, zzaer<? super zzbbw> zzaer);

    void zza(String str, zzbax zzbax);

    zzaaw zzaaa();

    void zzaab();

    void zzaac();

    zzqr zzaad();

    boolean zzaae();

    zzrf zzaaf();

    boolean zzaag();

    void zzae(boolean z);

    void zzaq(IObjectWrapper iObjectWrapper);

    void zzaq(boolean z);

    void zzas(boolean z);

    void zzat(boolean z);

    void zzau(boolean z);

    void zzb(zzc zzc);

    void zzb(String str, zzaer<? super zzbbw> zzaer);

    void zzb(String str, String str2, @Nullable String str3);

    void zzbr(Context context);

    boolean zzc(boolean z, int i);

    void zzdb(int i);

    void zzsu();

    @Nullable
    zzbco zzxl();

    Activity zzxn();

    zza zzxo();

    zzzy zzxq();

    zzaxl zzxr();

    void zzzi();

    void zzzj();

    Context zzzk();

    zzc zzzl();

    zzc zzzm();

    zzbdj zzzn();

    String zzzo();

    @Nullable
    zzbdg zzzp();

    WebViewClient zzzq();

    boolean zzzr();

    zzdf zzzs();

    @Nullable
    IObjectWrapper zzzt();

    boolean zzzu();

    void zzzv();

    boolean zzzw();

    boolean zzzx();

    void zzzy();

    void zzzz();
}
