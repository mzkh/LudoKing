package com.applovin.impl.sdk.p018ad;

import android.net.Uri;
import com.applovin.impl.adview.C0826h.C0827a;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.utils.C1247h;
import com.applovin.impl.sdk.utils.C1277l;
import com.tapjoy.TJAdUnitConstants.String;
import com.tapjoy.TapjoyConstants;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.ad.a */
public final class C1078a extends C1084f {
    public C1078a(JSONObject jSONObject, JSONObject jSONObject2, C1079b bVar, C1192i iVar) {
        super(jSONObject, jSONObject2, bVar, iVar);
    }

    /* renamed from: aD */
    private String m1977aD() {
        return getStringFromAdObject("stream_url", "");
    }

    /* renamed from: a */
    public String mo8878a() {
        String b;
        synchronized (this.adObjectLock) {
            b = C1247h.m2985b(this.adObject, String.HTML, (String) null, this.sdk);
        }
        return b;
    }

    /* renamed from: a */
    public void mo9830a(Uri uri) {
        try {
            synchronized (this.adObjectLock) {
                this.adObject.put("video", uri.toString());
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public void mo9831a(String str) {
        try {
            synchronized (this.adObjectLock) {
                this.adObject.put(String.HTML, str);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: b */
    public boolean mo8884b() {
        return this.adObject.has("stream_url");
    }

    /* renamed from: c */
    public void mo9832c() {
        synchronized (this.adObjectLock) {
            this.adObject.remove("stream_url");
        }
    }

    /* renamed from: d */
    public Uri mo8886d() {
        String aD = m1977aD();
        if (C1277l.m3042b(aD)) {
            return Uri.parse(aD);
        }
        String e = mo9833e();
        if (C1277l.m3042b(e)) {
            return Uri.parse(e);
        }
        return null;
    }

    /* renamed from: e */
    public String mo9833e() {
        return getStringFromAdObject("video", "");
    }

    /* renamed from: f */
    public Uri mo8889f() {
        String stringFromAdObject = getStringFromAdObject(TapjoyConstants.TJC_CLICK_URL, "");
        if (C1277l.m3042b(stringFromAdObject)) {
            return Uri.parse(stringFromAdObject);
        }
        return null;
    }

    /* renamed from: g */
    public Uri mo8890g() {
        String stringFromAdObject = getStringFromAdObject("video_click_url", "");
        return C1277l.m3042b(stringFromAdObject) ? Uri.parse(stringFromAdObject) : mo8889f();
    }

    /* renamed from: h */
    public float mo9834h() {
        return getFloatFromAdObject("mraid_close_delay_graphic", 0.0f);
    }

    public boolean hasVideoUrl() {
        return mo8886d() != null;
    }

    /* renamed from: i */
    public boolean mo9835i() {
        return getBooleanFromAdObject("close_button_graphic_hidden", Boolean.valueOf(false));
    }

    /* renamed from: j */
    public boolean mo9836j() {
        String str = "close_button_expandable_hidden";
        if (this.adObject.has(str)) {
            return getBooleanFromAdObject(str, Boolean.valueOf(false));
        }
        return true;
    }

    /* renamed from: k */
    public C0827a mo9837k() {
        return mo9889a(getIntFromAdObject("expandable_style", C0827a.Invisible.mo9082a()));
    }
}
