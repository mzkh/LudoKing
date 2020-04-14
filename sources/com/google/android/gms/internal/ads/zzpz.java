package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.KeyguardManager;
import android.content.Context;
import android.graphics.Rect;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Iterator;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(14)
@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzpz extends Thread {
    private final Object lock;
    private boolean started;
    private final int zzboi;
    private final int zzbok;
    private final boolean zzbol;
    private boolean zzbpi;
    private boolean zzbpj;
    private final zzpw zzbpk;
    private final int zzbpl;
    private final int zzbpm;
    private final int zzbpn;
    private final int zzbpo;
    private final int zzbpp;
    private final int zzbpq;
    private final String zzbpr;
    private final boolean zzbps;
    private final boolean zzbpt;

    public zzpz() {
        this(new zzpw());
    }

    @VisibleForTesting
    private zzpz(zzpw zzpw) {
        this.started = false;
        this.zzbpi = false;
        this.zzbpj = false;
        this.zzbpk = zzpw;
        this.lock = new Object();
        this.zzboi = ((Integer) zzuv.zzon().zzd(zzza.zzcio)).intValue();
        this.zzbpm = ((Integer) zzuv.zzon().zzd(zzza.zzcip)).intValue();
        this.zzbok = ((Integer) zzuv.zzon().zzd(zzza.zzciq)).intValue();
        this.zzbpn = ((Integer) zzuv.zzon().zzd(zzza.zzcir)).intValue();
        this.zzbpo = ((Integer) zzuv.zzon().zzd(zzza.zzcit)).intValue();
        this.zzbpp = ((Integer) zzuv.zzon().zzd(zzza.zzciu)).intValue();
        this.zzbpq = ((Integer) zzuv.zzon().zzd(zzza.zzciv)).intValue();
        this.zzbpl = ((Integer) zzuv.zzon().zzd(zzza.zzcis)).intValue();
        this.zzbpr = (String) zzuv.zzon().zzd(zzza.zzcix);
        this.zzbps = ((Boolean) zzuv.zzon().zzd(zzza.zzciy)).booleanValue();
        this.zzbol = ((Boolean) zzuv.zzon().zzd(zzza.zzcjc)).booleanValue();
        this.zzbpt = ((Boolean) zzuv.zzon().zzd(zzza.zzcjd)).booleanValue();
        setName("ContentFetchTask");
    }

    public final void zzlu() {
        synchronized (this.lock) {
            if (this.started) {
                zzaug.zzdv("Content hash thread already started, quiting...");
                return;
            }
            this.started = true;
            start();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        com.google.android.gms.ads.internal.zzq.zzkn().zza(r0, "ContentFetchTask.extractContent");
        com.google.android.gms.internal.ads.zzaug.zzdv("Failed getting root view of activity. Content not extracted.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x007c, code lost:
        com.google.android.gms.internal.ads.zzaug.zzc("Error in ContentFetchTask", r0);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x0084 */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007b A[ExcHandler: InterruptedException (r0v1 'e' java.lang.InterruptedException A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0084 A[LOOP:1: B:30:0x0084->B:42:0x0084, LOOP_START, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r4 = this;
        L_0x0000:
            boolean r0 = zzlv()     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
            if (r0 == 0) goto L_0x005a
            com.google.android.gms.internal.ads.zzpv r0 = com.google.android.gms.ads.internal.zzq.zzkm()     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
            android.app.Activity r0 = r0.getActivity()     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
            if (r0 != 0) goto L_0x0019
            java.lang.String r0 = "ContentFetchThread: no activity. Sleeping."
            com.google.android.gms.internal.ads.zzaug.zzdv(r0)     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
            r4.zzlx()     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
            goto L_0x0062
        L_0x0019:
            if (r0 == 0) goto L_0x0062
            r1 = 0
            android.view.Window r2 = r0.getWindow()     // Catch:{ Exception -> 0x003d, InterruptedException -> 0x007b }
            if (r2 == 0) goto L_0x004c
            android.view.Window r2 = r0.getWindow()     // Catch:{ Exception -> 0x003d, InterruptedException -> 0x007b }
            android.view.View r2 = r2.getDecorView()     // Catch:{ Exception -> 0x003d, InterruptedException -> 0x007b }
            if (r2 == 0) goto L_0x004c
            android.view.Window r0 = r0.getWindow()     // Catch:{ Exception -> 0x003d, InterruptedException -> 0x007b }
            android.view.View r0 = r0.getDecorView()     // Catch:{ Exception -> 0x003d, InterruptedException -> 0x007b }
            r2 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r0 = r0.findViewById(r2)     // Catch:{ Exception -> 0x003d, InterruptedException -> 0x007b }
            r1 = r0
            goto L_0x004c
        L_0x003d:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzatr r2 = com.google.android.gms.ads.internal.zzq.zzkn()     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
            java.lang.String r3 = "ContentFetchTask.extractContent"
            r2.zza(r0, r3)     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
            java.lang.String r0 = "Failed getting root view of activity. Content not extracted."
            com.google.android.gms.internal.ads.zzaug.zzdv(r0)     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
        L_0x004c:
            if (r1 == 0) goto L_0x0062
            if (r1 != 0) goto L_0x0051
            goto L_0x0062
        L_0x0051:
            com.google.android.gms.internal.ads.zzqc r0 = new com.google.android.gms.internal.ads.zzqc     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
            r0.<init>(r4, r1)     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
            r1.post(r0)     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
            goto L_0x0062
        L_0x005a:
            java.lang.String r0 = "ContentFetchTask: sleeping"
            com.google.android.gms.internal.ads.zzaug.zzdv(r0)     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
            r4.zzlx()     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
        L_0x0062:
            int r0 = r4.zzbpl     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
            int r0 = r0 * 1000
            long r0 = (long) r0     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
            java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
            goto L_0x0081
        L_0x006b:
            r0 = move-exception
            java.lang.String r1 = "Error in ContentFetchTask"
            com.google.android.gms.internal.ads.zzaug.zzc(r1, r0)
            com.google.android.gms.internal.ads.zzatr r1 = com.google.android.gms.ads.internal.zzq.zzkn()
            java.lang.String r2 = "ContentFetchTask.run"
            r1.zza(r0, r2)
            goto L_0x0081
        L_0x007b:
            r0 = move-exception
            java.lang.String r1 = "Error in ContentFetchTask"
            com.google.android.gms.internal.ads.zzaug.zzc(r1, r0)
        L_0x0081:
            java.lang.Object r0 = r4.lock
            monitor-enter(r0)
        L_0x0084:
            boolean r1 = r4.zzbpi     // Catch:{ all -> 0x0096 }
            if (r1 == 0) goto L_0x0093
            java.lang.String r1 = "ContentFetchTask: waiting"
            com.google.android.gms.internal.ads.zzaug.zzdv(r1)     // Catch:{ InterruptedException -> 0x0084 }
            java.lang.Object r1 = r4.lock     // Catch:{ InterruptedException -> 0x0084 }
            r1.wait()     // Catch:{ InterruptedException -> 0x0084 }
            goto L_0x0084
        L_0x0093:
            monitor-exit(r0)     // Catch:{ all -> 0x0096 }
            goto L_0x0000
        L_0x0096:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0096 }
            throw r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpz.run():void");
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    public final void zzi(View view) {
        try {
            zzpt zzpt = new zzpt(this.zzboi, this.zzbpm, this.zzbok, this.zzbpn, this.zzbpo, this.zzbpp, this.zzbpq, this.zzbol);
            Context context = zzq.zzkm().getContext();
            if (context != null && !TextUtils.isEmpty(this.zzbpr)) {
                String str = (String) view.getTag(context.getResources().getIdentifier((String) zzuv.zzon().zzd(zzza.zzciw), "id", context.getPackageName()));
                if (str != null && str.equals(this.zzbpr)) {
                    return;
                }
            }
            zzqd zza = zza(view, zzpt);
            zzpt.zzls();
            if (zza.zzbqa != 0 || zza.zzbqb != 0) {
                if (zza.zzbqb != 0 || zzpt.zzlt() != 0) {
                    if (zza.zzbqb != 0 || !this.zzbpk.zza(zzpt)) {
                        this.zzbpk.zzc(zzpt);
                    }
                }
            }
        } catch (Exception e) {
            zzaug.zzc("Exception in fetchContentOnUIThread", e);
            zzq.zzkn().zza(e, "ContentFetchTask.fetchContent");
        }
    }

    @VisibleForTesting
    private static boolean zzlv() {
        boolean z;
        boolean z2 = false;
        try {
            Context context = zzq.zzkm().getContext();
            if (context == null) {
                return false;
            }
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (activityManager != null) {
                if (keyguardManager != null) {
                    List runningAppProcesses = activityManager.getRunningAppProcesses();
                    if (runningAppProcesses != null) {
                        Iterator it = runningAppProcesses.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            RunningAppProcessInfo runningAppProcessInfo = (RunningAppProcessInfo) it.next();
                            if (Process.myPid() == runningAppProcessInfo.pid) {
                                if (runningAppProcessInfo.importance == 100 && !keyguardManager.inKeyguardRestrictedInputMode()) {
                                    PowerManager powerManager = (PowerManager) context.getSystemService("power");
                                    if (powerManager == null) {
                                        z = false;
                                    } else {
                                        z = powerManager.isScreenOn();
                                    }
                                    if (z) {
                                        z2 = true;
                                    }
                                }
                            }
                        }
                    } else {
                        return false;
                    }
                }
            }
            return z2;
        } catch (Throwable th) {
            zzq.zzkn().zza(th, "ContentFetchTask.isInForeground");
            return false;
        }
    }

    @VisibleForTesting
    private final zzqd zza(@Nullable View view, zzpt zzpt) {
        boolean z;
        if (view == null) {
            return new zzqd(this, 0, 0);
        }
        boolean globalVisibleRect = view.getGlobalVisibleRect(new Rect());
        if ((view instanceof TextView) && !(view instanceof EditText)) {
            CharSequence text = ((TextView) view).getText();
            if (TextUtils.isEmpty(text)) {
                return new zzqd(this, 0, 0);
            }
            zzpt.zzb(text.toString(), globalVisibleRect, view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight());
            return new zzqd(this, 1, 0);
        } else if ((view instanceof WebView) && !(view instanceof zzbbw)) {
            WebView webView = (WebView) view;
            if (!PlatformVersion.isAtLeastKitKat()) {
                z = false;
            } else {
                zzpt.zzlq();
                webView.post(new zzqb(this, zzpt, webView, globalVisibleRect));
                z = true;
            }
            if (z) {
                return new zzqd(this, 0, 1);
            }
            return new zzqd(this, 0, 0);
        } else if (!(view instanceof ViewGroup)) {
            return new zzqd(this, 0, 0);
        } else {
            ViewGroup viewGroup = (ViewGroup) view;
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                zzqd zza = zza(viewGroup.getChildAt(i3), zzpt);
                i += zza.zzbqa;
                i2 += zza.zzbqb;
            }
            return new zzqd(this, i, i2);
        }
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    public final void zza(zzpt zzpt, WebView webView, String str, boolean z) {
        zzpt.zzlp();
        try {
            if (!TextUtils.isEmpty(str)) {
                String optString = new JSONObject(str).optString(ViewHierarchyConstants.TEXT_KEY);
                if (this.zzbps || TextUtils.isEmpty(webView.getTitle())) {
                    zzpt.zza(optString, z, webView.getX(), webView.getY(), (float) webView.getWidth(), (float) webView.getHeight());
                } else {
                    String title = webView.getTitle();
                    StringBuilder sb = new StringBuilder(String.valueOf(title).length() + 1 + String.valueOf(optString).length());
                    sb.append(title);
                    sb.append("\n");
                    sb.append(optString);
                    zzpt.zza(sb.toString(), z, webView.getX(), webView.getY(), (float) webView.getWidth(), (float) webView.getHeight());
                }
            }
            if (zzpt.zzlk()) {
                this.zzbpk.zzb(zzpt);
            }
        } catch (JSONException unused) {
            zzaug.zzdv("Json string may be malformed.");
        } catch (Throwable th) {
            zzaug.zzb("Failed to get webview content.", th);
            zzq.zzkn().zza(th, "ContentFetchTask.processWebViewContent");
        }
    }

    public final zzpt zzlw() {
        return this.zzbpk.zzn(this.zzbpt);
    }

    public final void wakeup() {
        synchronized (this.lock) {
            this.zzbpi = false;
            this.lock.notifyAll();
            zzaug.zzdv("ContentFetchThread: wakeup");
        }
    }

    private final void zzlx() {
        synchronized (this.lock) {
            this.zzbpi = true;
            boolean z = this.zzbpi;
            StringBuilder sb = new StringBuilder(42);
            sb.append("ContentFetchThread: paused, mPause = ");
            sb.append(z);
            zzaug.zzdv(sb.toString());
        }
    }

    public final boolean zzly() {
        return this.zzbpi;
    }
}
