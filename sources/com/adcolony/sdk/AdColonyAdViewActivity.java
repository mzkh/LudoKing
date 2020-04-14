package com.adcolony.sdk;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.ViewParent;

public class AdColonyAdViewActivity extends C0578b {

    /* renamed from: n */
    AdColonyAdView f93n;

    public AdColonyAdViewActivity() {
        AdColonyAdView adColonyAdView;
        if (!C0476a.m84b()) {
            adColonyAdView = null;
        } else {
            adColonyAdView = C0476a.m77a().mo8587u();
        }
        this.f93n = adColonyAdView;
    }

    public /* bridge */ /* synthetic */ void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public /* bridge */ /* synthetic */ void onDestroy() {
        super.onDestroy();
    }

    public /* bridge */ /* synthetic */ void onPause() {
        super.onPause();
    }

    public /* bridge */ /* synthetic */ void onResume() {
        super.onResume();
    }

    public /* bridge */ /* synthetic */ void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    public void onCreate(Bundle bundle) {
        if (C0476a.m84b()) {
            AdColonyAdView adColonyAdView = this.f93n;
            if (adColonyAdView != null) {
                this.f533d = adColonyAdView.getOrientation();
                super.onCreate(bundle);
                this.f93n.mo8036b();
                AdColonyAdViewListener listener = this.f93n.getListener();
                if (listener != null) {
                    listener.onOpened(this.f93n);
                }
                return;
            }
        }
        C0476a.m77a().mo8548a((AdColonyAdView) null);
        finish();
    }

    public void onBackPressed() {
        mo8060b();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo8060b() {
        ViewParent parent = this.f532c.getParent();
        if (parent != null) {
            ((ViewGroup) parent).removeView(this.f532c);
        }
        this.f93n.mo8037c();
        C0476a.m77a().mo8548a((AdColonyAdView) null);
        finish();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo8061c() {
        this.f93n.mo8036b();
    }
}
