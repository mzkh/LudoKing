package com.appsflyer.internal;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import androidx.annotation.RequiresApi;
import com.appsflyer.AFExecutor;
import com.appsflyer.AFLogger;
import java.lang.ref.WeakReference;
import java.util.concurrent.RejectedExecutionException;

@RequiresApi(api = 14)
/* renamed from: com.appsflyer.internal.ah */
public final class C1348ah implements ActivityLifecycleCallbacks {

    /* renamed from: ˎ */
    public static C1348ah f3444;

    /* renamed from: ˊ */
    boolean f3445 = true;

    /* renamed from: ˋ */
    boolean f3446 = false;

    /* renamed from: ॱ */
    public C1350d f3447 = null;

    /* renamed from: com.appsflyer.internal.ah$b */
    class C1349b extends AsyncTask<Void, Void, Void> {

        /* renamed from: ॱ */
        private WeakReference<Context> f3449;

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            return m3285();
        }

        public C1349b(WeakReference<Context> weakReference) {
            this.f3449 = weakReference;
        }

        /* renamed from: ˏ */
        private Void m3285() {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                AFLogger.afErrorLog("Sleeping attempt failed (essential for background state verification)\n", e);
            }
            if (C1348ah.this.f3446 && C1348ah.this.f3445) {
                C1348ah ahVar = C1348ah.this;
                ahVar.f3446 = false;
                try {
                    ahVar.f3447.mo10738(this.f3449);
                } catch (Exception e2) {
                    AFLogger.afErrorLog("Listener threw exception! ", e2);
                    cancel(true);
                }
            }
            this.f3449.clear();
            return null;
        }
    }

    /* renamed from: com.appsflyer.internal.ah$d */
    public interface C1350d {
        /* renamed from: ˋ */
        void mo10738(WeakReference<Context> weakReference);

        /* renamed from: ˏ */
        void mo10739(Activity activity);
    }

    public final void onActivityDestroyed(Activity activity) {
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void onActivityResumed(Activity activity) {
        this.f3445 = false;
        boolean z = !this.f3446;
        this.f3446 = true;
        if (z) {
            try {
                this.f3447.mo10739(activity);
            } catch (Exception e) {
                AFLogger.afErrorLog("Listener threw exception! ", e);
            }
        }
    }

    public final void onActivityPaused(Activity activity) {
        this.f3445 = true;
        try {
            new C1349b(new WeakReference(activity.getApplicationContext())).executeOnExecutor(AFExecutor.getInstance().getThreadPoolExecutor(), new Void[0]);
        } catch (RejectedExecutionException e) {
            AFLogger.afErrorLog("backgroundTask.executeOnExecutor failed with RejectedExecutionException Exception", e);
        } catch (Throwable th) {
            AFLogger.afErrorLog("backgroundTask.executeOnExecutor failed with Exception", th);
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        C1366f.m3331();
        Intent intent = activity.getIntent();
        if (C1366f.m3333(intent) != null && intent.getData() != C1366f.f3548) {
            C1366f.f3548 = intent.getData();
        }
    }
}
