package com.appsflyer.internal;

import com.appsflyer.AFLogger;

/* renamed from: com.appsflyer.internal.ae */
public final class C1343ae implements C1345d {

    /* renamed from: ˎ */
    private C1345d f3431 = this;

    /* renamed from: com.appsflyer.internal.ae$a */
    enum C1344a {
        UNITY("android_unity", "com.unity3d.player.UnityPlayer"),
        REACT_NATIVE("android_reactNative", "com.facebook.react.ReactApplication"),
        CORDOVA("android_cordova", "org.apache.cordova.CordovaActivity"),
        SEGMENT("android_segment", "com.segment.analytics.integrations.Integration"),
        COCOS2DX("android_cocos2dx", "org.cocos2dx.lib.Cocos2dxActivity"),
        DEFAULT(r6, r6),
        ADOBE_EX("android_adobe_ex", "com.appsflyer.adobeextension"),
        FLUTTER("android_flutter", "io.flutter.plugin.common.MethodChannel.MethodCallHandler");
        
        /* access modifiers changed from: private */

        /* renamed from: ʻ */
        public String f3441;
        /* access modifiers changed from: private */

        /* renamed from: ᐝ */
        public String f3442;

        private C1344a(String str, String str2) {
            this.f3442 = str;
            this.f3441 = str2;
        }
    }

    /* renamed from: com.appsflyer.internal.ae$d */
    interface C1345d {
        /* renamed from: ˋ */
        Class<?> mo10796(String str) throws ClassNotFoundException;
    }

    /* renamed from: ॱ */
    public final String mo10797() {
        C1344a[] values;
        for (C1344a aVar : C1344a.values()) {
            if (m3273(aVar.f3441)) {
                return aVar.f3442;
            }
        }
        return C1344a.DEFAULT.f3442;
    }

    /* renamed from: ˏ */
    private boolean m3273(String str) {
        try {
            this.f3431.mo10796(str);
            StringBuilder sb = new StringBuilder("Class: ");
            sb.append(str);
            sb.append(" is found.");
            AFLogger.afRDLog(sb.toString());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        } catch (Throwable th) {
            AFLogger.afErrorLog(th.getMessage(), th);
            return false;
        }
    }

    /* renamed from: ˋ */
    public final Class<?> mo10796(String str) throws ClassNotFoundException {
        return Class.forName(str);
    }
}
