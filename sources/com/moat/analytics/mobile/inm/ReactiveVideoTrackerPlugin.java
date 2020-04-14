package com.moat.analytics.mobile.inm;

import android.app.Activity;
import android.view.View;
import com.moat.analytics.mobile.inm.p037a.p039b.C2698a;
import java.util.Map;

public class ReactiveVideoTrackerPlugin implements MoatPlugin<ReactiveVideoTracker> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final String f6005a;

    /* renamed from: com.moat.analytics.mobile.inm.ReactiveVideoTrackerPlugin$a */
    static class C2694a implements ReactiveVideoTracker {
        C2694a() {
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

        public boolean trackVideoAd(Map<String, String> map, Integer num, View view) {
            return false;
        }
    }

    public ReactiveVideoTrackerPlugin(String str) {
        this.f6005a = str;
    }

    /* renamed from: c */
    public ReactiveVideoTracker mo28945a() {
        return (ReactiveVideoTracker) C2760x.m6369a((C2762a<T>) new C2762a<ReactiveVideoTracker>() {
            /* renamed from: a */
            public C2698a<ReactiveVideoTracker> mo28975a() {
                C2735p.m6313a("[INFO] ", "Attempting to create ReactiveVideoTracker");
                return C2698a.m6151a(new C2764y(ReactiveVideoTrackerPlugin.this.f6005a));
            }
        }, ReactiveVideoTracker.class);
    }

    /* renamed from: d */
    public ReactiveVideoTracker mo28946b() {
        return new C2694a();
    }
}
