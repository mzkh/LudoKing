package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.os.Message;
import android.support.p000v4.media.session.PlaybackStateCompat;
import android.view.View;
import android.view.WindowManager.BadTokenException;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebStorage.QuotaUpdater;
import android.webkit.WebView;
import android.webkit.WebView.WebViewTransport;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.ads.internal.zzc;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.util.PlatformVersion;

@TargetApi(11)
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbbo extends WebChromeClient {
    private final zzbbw zzczi;

    public zzbbo(zzbbw zzbbw) {
        this.zzczi = zzbbw;
    }

    private final boolean zza(Context context, String str, String str2, String str3, String str4, JsResult jsResult, JsPromptResult jsPromptResult, boolean z) {
        try {
            if (!(this.zzczi == null || this.zzczi.zzzp() == null || this.zzczi.zzzp().zzyv() == null)) {
                zzc zzyv = this.zzczi.zzzp().zzyv();
                if (zzyv != null && !zzyv.zzjk()) {
                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 11 + String.valueOf(str3).length());
                    sb.append("window.");
                    sb.append(str);
                    sb.append("('");
                    sb.append(str3);
                    sb.append("')");
                    zzyv.zzbl(sb.toString());
                    return false;
                }
            }
            Builder builder = new Builder(context);
            builder.setTitle(str2);
            if (z) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                TextView textView = new TextView(context);
                textView.setText(str3);
                EditText editText = new EditText(context);
                editText.setText(str4);
                linearLayout.addView(textView);
                linearLayout.addView(editText);
                builder.setView(linearLayout).setPositiveButton(17039370, new zzbbu(jsPromptResult, editText)).setNegativeButton(17039360, new zzbbr(jsPromptResult)).setOnCancelListener(new zzbbs(jsPromptResult)).create().show();
            } else {
                builder.setMessage(str3).setPositiveButton(17039370, new zzbbp(jsResult)).setNegativeButton(17039360, new zzbbq(jsResult)).setOnCancelListener(new zzbbn(jsResult)).create().show();
            }
        } catch (BadTokenException e) {
            zzaug.zzd("Fail to display Dialog.", e);
        }
        return true;
    }

    public final boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        WebViewTransport webViewTransport = (WebViewTransport) message.obj;
        WebView webView2 = new WebView(webView.getContext());
        if (this.zzczi.zzzq() != null) {
            webView2.setWebViewClient(this.zzczi.zzzq());
        }
        webViewTransport.setWebView(webView2);
        message.sendToTarget();
        return true;
    }

    public final void onCloseWindow(WebView webView) {
        if (!(webView instanceof zzbbw)) {
            zzaug.zzeu("Tried to close a WebView that wasn't an AdWebView.");
            return;
        }
        com.google.android.gms.ads.internal.overlay.zzc zzzl = ((zzbbw) webView).zzzl();
        if (zzzl == null) {
            zzaug.zzeu("Tried to close an AdWebView not associated with an overlay.");
        } else {
            zzzl.close();
        }
    }

    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String message = consoleMessage.message();
        String sourceId = consoleMessage.sourceId();
        int lineNumber = consoleMessage.lineNumber();
        StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 19 + String.valueOf(sourceId).length());
        sb.append("JS: ");
        sb.append(message);
        sb.append(" (");
        sb.append(sourceId);
        sb.append(":");
        sb.append(lineNumber);
        sb.append(")");
        String sb2 = sb.toString();
        if (sb2.contains("Application Cache")) {
            return super.onConsoleMessage(consoleMessage);
        }
        int i = zzbbt.zzeei[consoleMessage.messageLevel().ordinal()];
        if (i == 1) {
            zzaug.zzes(sb2);
        } else if (i == 2) {
            zzaug.zzeu(sb2);
        } else if (i == 3 || i == 4) {
            zzaug.zzet(sb2);
        } else if (i != 5) {
            zzaug.zzet(sb2);
        } else {
            zzaug.zzdv(sb2);
        }
        return super.onConsoleMessage(consoleMessage);
    }

    public final void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, QuotaUpdater quotaUpdater) {
        long j4 = 5242880 - j3;
        if (j4 <= 0) {
            quotaUpdater.updateQuota(j);
            return;
        }
        if (j != 0) {
            if (j2 == 0) {
                j = Math.min(j + Math.min(PlaybackStateCompat.ACTION_PREPARE_FROM_URI, j4), PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
            } else if (j2 <= Math.min(PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED - j, j4)) {
                j += j2;
            }
            j2 = j;
        } else if (j2 > j4 || j2 > PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
            j2 = 0;
        }
        quotaUpdater.updateQuota(j2);
    }

    public final void onHideCustomView() {
        com.google.android.gms.ads.internal.overlay.zzc zzzl = this.zzczi.zzzl();
        if (zzzl == null) {
            zzaug.zzeu("Could not get ad overlay when hiding custom view.");
        } else {
            zzzl.zzsn();
        }
    }

    private static Context zza(WebView webView) {
        if (!(webView instanceof zzbbw)) {
            return webView.getContext();
        }
        zzbbw zzbbw = (zzbbw) webView;
        Activity zzxn = zzbbw.zzxn();
        if (zzxn != null) {
            return zzxn;
        }
        return zzbbw.getContext();
    }

    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zza(webView), "alert", str, str2, null, jsResult, null, false);
    }

    public final boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zza(webView), "onBeforeUnload", str, str2, null, jsResult, null, false);
    }

    public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zza(webView), "confirm", str, str2, null, jsResult, null, false);
    }

    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return zza(zza(webView), "prompt", str, str2, str3, null, jsPromptResult, true);
    }

    public final void onReachedMaxAppCacheSize(long j, long j2, QuotaUpdater quotaUpdater) {
        long j3 = j + PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
        if (5242880 - j2 < j3) {
            quotaUpdater.updateQuota(0);
        } else {
            quotaUpdater.updateQuota(j3);
        }
    }

    public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        onShowCustomView(view, -1, customViewCallback);
    }

    @Deprecated
    public final void onShowCustomView(View view, int i, CustomViewCallback customViewCallback) {
        com.google.android.gms.ads.internal.overlay.zzc zzzl = this.zzczi.zzzl();
        if (zzzl == null) {
            zzaug.zzeu("Could not get ad overlay when showing custom view.");
            customViewCallback.onCustomViewHidden();
            return;
        }
        zzzl.zza(view, customViewCallback);
        zzzl.setRequestedOrientation(i);
    }

    public final void onGeolocationPermissionsShowPrompt(String str, Callback callback) {
        boolean z;
        if (callback != null) {
            zzq.zzkj();
            if (!zzaul.zzq(this.zzczi.getContext(), "android.permission.ACCESS_FINE_LOCATION")) {
                zzq.zzkj();
                if (!zzaul.zzq(this.zzczi.getContext(), "android.permission.ACCESS_COARSE_LOCATION")) {
                    z = false;
                    callback.invoke(str, z, true);
                }
            }
            z = true;
            callback.invoke(str, z, true);
        }
    }

    @TargetApi(21)
    public final void onPermissionRequest(PermissionRequest permissionRequest) {
        if (PlatformVersion.isAtLeastLollipop()) {
            if (!((Boolean) zzuv.zzon().zzd(zzza.zzcjz)).booleanValue()) {
                zzbbw zzbbw = this.zzczi;
                if (zzbbw == null || zzbbw.zzzp() == null || this.zzczi.zzzp().zzzh() == null) {
                    super.onPermissionRequest(permissionRequest);
                    return;
                }
                String[] zza = this.zzczi.zzzp().zzzh().zza(permissionRequest.getResources());
                if (zza.length > 0) {
                    permissionRequest.grant(zza);
                    return;
                } else {
                    permissionRequest.deny();
                    return;
                }
            }
        }
        super.onPermissionRequest(permissionRequest);
    }
}
