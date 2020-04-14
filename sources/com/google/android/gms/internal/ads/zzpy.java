package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzq;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

@TargetApi(14)
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzpy implements ActivityLifecycleCallbacks {
    /* access modifiers changed from: private */
    public boolean foreground = true;
    /* access modifiers changed from: private */
    public final Object lock = new Object();
    /* access modifiers changed from: private */
    public boolean zzbpd = false;
    /* access modifiers changed from: private */
    @GuardedBy("lock")
    public final List<zzqa> zzbpe = new ArrayList();
    @GuardedBy("lock")
    private final List<zzql> zzbpf = new ArrayList();
    private Runnable zzbpg;
    private long zzbph;
    private Context zzlk;
    private boolean zzye = false;
    @Nullable
    private Activity zzzr;

    zzpy() {
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void zza(Application application, Context context) {
        if (!this.zzye) {
            application.registerActivityLifecycleCallbacks(this);
            if (context instanceof Activity) {
                setActivity((Activity) context);
            }
            this.zzlk = application;
            this.zzbph = ((Long) zzuv.zzon().zzd(zzza.zzckn)).longValue();
            this.zzye = true;
        }
    }

    public final void zza(zzqa zzqa) {
        synchronized (this.lock) {
            this.zzbpe.add(zzqa);
        }
    }

    public final void zzb(zzqa zzqa) {
        synchronized (this.lock) {
            this.zzbpe.remove(zzqa);
        }
    }

    @Nullable
    public final Activity getActivity() {
        return this.zzzr;
    }

    @Nullable
    public final Context getContext() {
        return this.zzlk;
    }

    public final void onActivityStarted(Activity activity) {
        setActivity(activity);
    }

    public final void onActivityResumed(Activity activity) {
        setActivity(activity);
        this.zzbpd = false;
        boolean z = !this.foreground;
        this.foreground = true;
        if (this.zzbpg != null) {
            zzaul.zzdsu.removeCallbacks(this.zzbpg);
        }
        synchronized (this.lock) {
            for (zzql onActivityResumed : this.zzbpf) {
                try {
                    onActivityResumed.onActivityResumed(activity);
                } catch (Exception e) {
                    zzq.zzkn().zza(e, "AppActivityTracker.ActivityListener.onActivityResumed");
                    zzaxi.zzc("", e);
                }
            }
            if (z) {
                for (zzqa zzo : this.zzbpe) {
                    try {
                        zzo.zzo(true);
                    } catch (Exception e2) {
                        zzaxi.zzc("", e2);
                    }
                }
            } else {
                zzaug.zzdv("App is still foreground.");
            }
        }
    }

    public final void onActivityPaused(Activity activity) {
        setActivity(activity);
        synchronized (this.lock) {
            for (zzql onActivityPaused : this.zzbpf) {
                try {
                    onActivityPaused.onActivityPaused(activity);
                } catch (Exception e) {
                    zzq.zzkn().zza(e, "AppActivityTracker.ActivityListener.onActivityPaused");
                    zzaxi.zzc("", e);
                }
            }
        }
        this.zzbpd = true;
        if (this.zzbpg != null) {
            zzaul.zzdsu.removeCallbacks(this.zzbpg);
        }
        Handler handler = zzaul.zzdsu;
        zzpx zzpx = new zzpx(this);
        this.zzbpg = zzpx;
        handler.postDelayed(zzpx, this.zzbph);
    }

    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.lock) {
            if (this.zzzr != null) {
                if (this.zzzr.equals(activity)) {
                    this.zzzr = null;
                }
                Iterator it = this.zzbpf.iterator();
                while (it.hasNext()) {
                    try {
                        if (((zzql) it.next()).zza(activity)) {
                            it.remove();
                        }
                    } catch (Exception e) {
                        zzq.zzkn().zza(e, "AppActivityTracker.ActivityListener.onActivityDestroyed");
                        zzaxi.zzc("", e);
                    }
                }
            }
        }
    }

    private final void setActivity(Activity activity) {
        synchronized (this.lock) {
            if (!activity.getClass().getName().startsWith("com.google.android.gms.ads")) {
                this.zzzr = activity;
            }
        }
    }
}
