package com.moat.analytics.mobile.inm;

import android.app.Activity;
import android.app.Application;
import android.media.MediaPlayer;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import com.moat.analytics.mobile.inm.NativeDisplayTracker.MoatUserInteractionType;
import java.util.Map;

/* renamed from: com.moat.analytics.mobile.inm.v */
abstract class C2744v {

    /* renamed from: com.moat.analytics.mobile.inm.v$a */
    public static class C2745a extends MoatAnalytics {
        public void prepareNativeDisplayTracking(String str) {
        }

        public void start(Application application) {
        }

        public void start(MoatOptions moatOptions, Application application) {
        }
    }

    /* renamed from: com.moat.analytics.mobile.inm.v$b */
    public static class C2746b extends MoatFactory {
        public <T> T createCustomTracker(MoatPlugin<T> moatPlugin) {
            return moatPlugin.mo28946b();
        }

        public NativeDisplayTracker createNativeDisplayTracker(@NonNull View view, @NonNull Map<String, String> map) {
            return new C2747c();
        }

        public NativeVideoTracker createNativeVideoTracker(@NonNull String str) {
            return new C2748d();
        }

        public WebAdTracker createWebAdTracker(@NonNull ViewGroup viewGroup) {
            return new C2749e();
        }

        public WebAdTracker createWebAdTracker(@NonNull WebView webView) {
            return new C2749e();
        }
    }

    /* renamed from: com.moat.analytics.mobile.inm.v$c */
    static class C2747c implements NativeDisplayTracker {
        C2747c() {
        }

        public void removeListener() {
        }

        public void reportUserInteractionEvent(MoatUserInteractionType moatUserInteractionType) {
        }

        public void setActivity(Activity activity) {
        }

        public void setListener(TrackerListener trackerListener) {
        }

        public void startTracking() {
        }

        public void stopTracking() {
        }
    }

    /* renamed from: com.moat.analytics.mobile.inm.v$d */
    static class C2748d implements NativeVideoTracker {
        C2748d() {
        }

        public void changeTargetView(View view) {
        }

        public void dispatchEvent(MoatAdEvent moatAdEvent) {
        }

        public void removeListener() {
        }

        public void removeVideoListener() {
        }

        public void setActivity(Activity activity) {
        }

        public void setListener(TrackerListener trackerListener) {
        }

        public void setPlayerVolume(Double d) {
        }

        public void setVideoListener(VideoTrackerListener videoTrackerListener) {
        }

        public void stopTracking() {
        }

        public boolean trackVideoAd(Map<String, String> map, MediaPlayer mediaPlayer, View view) {
            return false;
        }
    }

    /* renamed from: com.moat.analytics.mobile.inm.v$e */
    static class C2749e implements WebAdTracker {
        C2749e() {
        }

        public void removeListener() {
        }

        public void setActivity(Activity activity) {
        }

        public void setListener(TrackerListener trackerListener) {
        }

        public void startTracking() {
        }

        public void stopTracking() {
        }
    }

    C2744v() {
    }
}
