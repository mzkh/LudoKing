package com.moat.analytics.mobile.inm;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import com.moat.analytics.mobile.inm.C2744v.C2746b;
import java.util.Map;

public abstract class MoatFactory {
    public static MoatFactory create() {
        try {
            return new C2727n();
        } catch (Exception e) {
            C2726m.m6274a(e);
            return new C2746b();
        }
    }

    @UiThread
    public abstract <T> T createCustomTracker(MoatPlugin<T> moatPlugin);

    @UiThread
    public abstract NativeDisplayTracker createNativeDisplayTracker(@NonNull View view, @NonNull Map<String, String> map);

    @UiThread
    public abstract NativeVideoTracker createNativeVideoTracker(String str);

    @UiThread
    public abstract WebAdTracker createWebAdTracker(@NonNull ViewGroup viewGroup);

    @UiThread
    public abstract WebAdTracker createWebAdTracker(@NonNull WebView webView);
}
