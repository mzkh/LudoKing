package com.inmobi.media;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsIntent.Builder;
import com.inmobi.media.C2308d.C2311a;

/* renamed from: com.inmobi.media.bu */
/* compiled from: ChromeTabManager */
public final class C2241bu implements ActivityLifecycleCallbacks, C2311a {

    /* renamed from: a */
    private final C2308d f4663a = new C2308d();

    /* renamed from: b */
    private String f4664b;

    /* renamed from: c */
    private Context f4665c;

    /* renamed from: d */
    private C2452f f4666d;

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivityResumed(Activity activity) {
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    public C2241bu(@NonNull String str, @NonNull Context context, @NonNull C2452f fVar) {
        this.f4664b = str;
        this.f4665c = context;
        this.f4666d = fVar;
        C2505gd.m5286a(context, (ActivityLifecycleCallbacks) this);
    }

    /* renamed from: b */
    public final void mo27988b() {
        this.f4663a.mo28162a(this.f4665c);
    }

    /* renamed from: a */
    public final void mo27986a() {
        Uri parse = Uri.parse(this.f4664b);
        C2308d dVar = this.f4663a;
        Builder builder = new Builder(dVar.f4869a == null ? null : dVar.f4869a.newSession(new CustomTabsCallback() {
            public final void onNavigationEvent(int i, Bundle bundle) {
                super.onNavigationEvent(i, bundle);
                C2308d.f4868d;
                if (C2308d.this.f4871c != null) {
                    C2308d.this.f4871c.mo27987a(i);
                }
            }
        }));
        builder.enableUrlBarHiding();
        C2308d.m4726a(this.f4665c, builder.build(), parse, this.f4666d);
    }

    /* renamed from: a */
    public final void mo27987a(int i) {
        switch (i) {
            case 5:
                this.f4666d.mo28364e();
                return;
            case 6:
                this.f4666d.mo28365f();
                return;
            default:
                return;
        }
    }

    public final void onActivityDestroyed(Activity activity) {
        if (activity != null) {
            C2308d dVar = this.f4663a;
            Context context = this.f4665c;
            if (dVar.f4870b != null) {
                context.unbindService(dVar.f4870b);
                dVar.f4869a = null;
                dVar.f4870b = null;
            }
            activity.getApplication().unregisterActivityLifecycleCallbacks(this);
        }
    }
}
