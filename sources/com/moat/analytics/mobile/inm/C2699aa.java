package com.moat.analytics.mobile.inm;

import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.Nullable;

/* renamed from: com.moat.analytics.mobile.inm.aa */
class C2699aa extends C2701b implements WebAdTracker {
    C2699aa(@Nullable ViewGroup viewGroup) {
        this((WebView) C2700ab.m6157a(viewGroup, false).mo28993c(null));
        String str = "WebAdTracker";
        String str2 = "[ERROR] ";
        String str3 = "WebAdTracker initialization not successful, ";
        if (viewGroup == null) {
            String str4 = "Target ViewGroup is null";
            C2735p.m6311a(str2, 3, str, this, str3.concat(str4));
            this.f6015a = new C2726m(str4);
        }
        if (this.f6016b == null) {
            String str5 = "No WebView to track inside of ad container";
            C2735p.m6311a(str2, 3, str, this, str3.concat(str5));
            this.f6015a = new C2726m(str5);
        }
    }

    C2699aa(@Nullable WebView webView) {
        super(webView, false, false);
        String str = "WebAdTracker";
        C2735p.m6310a(3, str, (Object) this, "Initializing.");
        if (webView == null) {
            String str2 = "WebView is null";
            C2735p.m6311a("[ERROR] ", 3, str, this, "WebAdTracker initialization not successful, ".concat(str2));
            this.f6015a = new C2726m(str2);
            return;
        }
        try {
            super.mo28999a(webView);
            StringBuilder sb = new StringBuilder();
            sb.append(mo28998a());
            sb.append(" created for ");
            sb.append(mo29009g());
            C2735p.m6313a("[SUCCESS] ", sb.toString());
        } catch (C2726m e) {
            this.f6015a = e;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo28998a() {
        return "WebAdTracker";
    }
}
