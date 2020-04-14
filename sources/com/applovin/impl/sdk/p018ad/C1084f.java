package com.applovin.impl.sdk.p018ad;

import android.graphics.Color;
import android.graphics.Point;
import android.graphics.PointF;
import android.net.Uri;
import androidx.core.view.ViewCompat;
import com.applovin.impl.adview.C0826h.C0827a;
import com.applovin.impl.adview.C0889s;
import com.applovin.impl.adview.C0894w;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.p017a.C1075c;
import com.applovin.impl.sdk.p019b.C1096c;
import com.applovin.impl.sdk.p020c.C1101a;
import com.applovin.impl.sdk.utils.C1243d;
import com.applovin.impl.sdk.utils.C1245f;
import com.applovin.impl.sdk.utils.C1247h;
import com.applovin.impl.sdk.utils.C1277l;
import com.applovin.impl.sdk.utils.C1281o;
import com.appsflyer.share.Constants;
import com.tapjoy.TapjoyConstants;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.ad.f */
public abstract class C1084f extends AppLovinAdBase {

    /* renamed from: a */
    private final AtomicBoolean f2210a = new AtomicBoolean();

    /* renamed from: b */
    private final AtomicBoolean f2211b = new AtomicBoolean();

    /* renamed from: c */
    private final AtomicReference<C1075c> f2212c = new AtomicReference<>();

    /* renamed from: d */
    private List<C1101a> f2213d;

    /* renamed from: e */
    private List<C1101a> f2214e;

    /* renamed from: f */
    private List<C1101a> f2215f;

    /* renamed from: com.applovin.impl.sdk.ad.f$a */
    public enum C1085a {
        UNSPECIFIED,
        DISMISS,
        DO_NOT_DISMISS
    }

    /* renamed from: com.applovin.impl.sdk.ad.f$b */
    public enum C1086b {
        DEFAULT,
        ACTIVITY_PORTRAIT,
        ACTIVITY_LANDSCAPE
    }

    public C1084f(JSONObject jSONObject, JSONObject jSONObject2, C1079b bVar, C1192i iVar) {
        super(jSONObject, jSONObject2, bVar, iVar);
    }

    /* renamed from: a */
    private String mo8878a() {
        String stringFromAdObject = getStringFromAdObject("video_end_url", null);
        if (stringFromAdObject == null) {
            return null;
        }
        return stringFromAdObject.replace("{CLCODE}", getClCode());
    }

    /* renamed from: a */
    private List<C1101a> m2030a(PointF pointF, boolean z) {
        List<C1101a> a;
        synchronized (this.adObjectLock) {
            a = C1281o.m3080a("click_tracking_urls", this.adObject, m2033c(pointF, z), m2032b(pointF, z), this.sdk);
        }
        return a;
    }

    /* renamed from: b */
    private C0827a m2031b(boolean z) {
        return z ? C0827a.WhiteXOnTransparentGrey : C0827a.WhiteXOnOpaqueBlack;
    }

    /* renamed from: b */
    private String m2032b(PointF pointF, boolean z) {
        String stringFromAdObject = getStringFromAdObject("click_tracking_url", null);
        Map c = m2033c(pointF, z);
        if (stringFromAdObject != null) {
            return C1277l.m3037a(stringFromAdObject, c);
        }
        return null;
    }

    /* renamed from: c */
    private Map<String, String> m2033c(PointF pointF, boolean z) {
        Point a = C1245f.m2928a(this.sdk.mo10179D());
        HashMap hashMap = new HashMap(5);
        hashMap.put("{CLCODE}", getClCode());
        hashMap.put("{CLICK_X}", String.valueOf(pointF.x));
        hashMap.put("{CLICK_Y}", String.valueOf(pointF.y));
        hashMap.put("{SCREEN_WIDTH}", String.valueOf(a.x));
        hashMap.put("{SCREEN_HEIGHT}", String.valueOf(a.y));
        hashMap.put("{IS_VIDEO_CLICK}", String.valueOf(z));
        return hashMap;
    }

    /* renamed from: A */
    public int mo9863A() {
        return getIntFromAdObject("countdown_length", 0);
    }

    /* renamed from: B */
    public int mo9864B() {
        int parseColor = Color.parseColor("#C8FFFFFF");
        String stringFromAdObject = getStringFromAdObject("countdown_color", null);
        if (!C1277l.m3042b(stringFromAdObject)) {
            return parseColor;
        }
        try {
            return Color.parseColor(stringFromAdObject);
        } catch (Throwable th) {
            this.sdk.mo10249v().mo10379b("DirectAd", "Unable to parse countdown color", th);
            return parseColor;
        }
    }

    /* renamed from: C */
    public int mo9865C() {
        String stringFromAdObject = getStringFromAdObject("video_background_color", null);
        if (C1277l.m3042b(stringFromAdObject)) {
            try {
                return Color.parseColor(stringFromAdObject);
            } catch (Throwable unused) {
            }
        }
        return ViewCompat.MEASURED_STATE_MASK;
    }

    /* renamed from: D */
    public int mo9866D() {
        int i = hasVideoUrl() ? ViewCompat.MEASURED_STATE_MASK : -1157627904;
        String stringFromAdObject = getStringFromAdObject("graphic_background_color", null);
        if (!C1277l.m3042b(stringFromAdObject)) {
            return i;
        }
        try {
            return Color.parseColor(stringFromAdObject);
        } catch (Throwable unused) {
            return i;
        }
    }

    /* renamed from: E */
    public C1085a mo9867E() {
        String stringFromAdObject = getStringFromAdObject("poststitial_dismiss_type", null);
        if (C1277l.m3042b(stringFromAdObject)) {
            if (TapjoyConstants.TJC_FULLSCREEN_AD_DISMISS_URL.equalsIgnoreCase(stringFromAdObject)) {
                return C1085a.DISMISS;
            }
            if ("no_dismiss".equalsIgnoreCase(stringFromAdObject)) {
                return C1085a.DO_NOT_DISMISS;
            }
        }
        return C1085a.UNSPECIFIED;
    }

    /* renamed from: F */
    public List<String> mo9868F() {
        String stringFromAdObject = getStringFromAdObject("resource_cache_prefix", null);
        return stringFromAdObject != null ? C1243d.m2924a(stringFromAdObject) : this.sdk.mo10224b((C1096c) C1096c.f2350bL);
    }

    /* renamed from: G */
    public String mo9869G() {
        return getStringFromAdObject("cache_prefix", null);
    }

    /* renamed from: H */
    public boolean mo9870H() {
        return getBooleanFromAdObject("daome", Boolean.valueOf(true));
    }

    /* renamed from: I */
    public boolean mo9871I() {
        return getBooleanFromAdObject("utpfc", Boolean.valueOf(false));
    }

    /* renamed from: J */
    public boolean mo9872J() {
        return getBooleanFromAdObject("sscomt", Boolean.valueOf(false));
    }

    /* renamed from: K */
    public String mo9873K() {
        return getStringFromFullResponse("event_id", null);
    }

    /* renamed from: L */
    public boolean mo9874L() {
        return getBooleanFromAdObject("progress_bar_enabled", Boolean.valueOf(false));
    }

    /* renamed from: M */
    public int mo9875M() {
        String stringFromAdObject = getStringFromAdObject("progress_bar_color", "#C8FFFFFF");
        if (C1277l.m3042b(stringFromAdObject)) {
            try {
                return Color.parseColor(stringFromAdObject);
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    /* renamed from: N */
    public boolean mo9876N() {
        return getBooleanFromAdObject("vs_buffer_indicator_enabled", Boolean.valueOf(false));
    }

    /* renamed from: O */
    public boolean mo9877O() {
        return getBooleanFromAdObject("vs_buffer_indicator_initial_load_enabled", Boolean.valueOf(false));
    }

    /* renamed from: P */
    public int mo9878P() {
        return getIntFromAdObject("vs_buffer_indicator_style", 16842874);
    }

    /* renamed from: Q */
    public int mo9879Q() {
        String stringFromAdObject = getStringFromAdObject("vs_buffer_indicator_color", null);
        if (C1277l.m3042b(stringFromAdObject)) {
            try {
                return Color.parseColor(stringFromAdObject);
            } catch (Throwable unused) {
            }
        }
        return -1;
    }

    /* renamed from: R */
    public int mo9880R() {
        int parseColor = Color.parseColor("#66000000");
        String stringFromAdObject = getStringFromAdObject("vs_buffer_indicator_bg_color", null);
        if (!C1277l.m3042b(stringFromAdObject)) {
            return parseColor;
        }
        try {
            return Color.parseColor(stringFromAdObject);
        } catch (Throwable unused) {
            return parseColor;
        }
    }

    /* renamed from: S */
    public boolean mo9881S() {
        return getBooleanFromAdObject("clear_dismissible", Boolean.valueOf(false));
    }

    /* renamed from: T */
    public int mo9882T() {
        int a;
        synchronized (this.adObjectLock) {
            a = C1281o.m3063a(this.adObject);
        }
        return a;
    }

    /* renamed from: U */
    public int mo9883U() {
        return getIntFromAdObject("poststitial_shown_forward_delay_millis", -1);
    }

    /* renamed from: V */
    public boolean mo9884V() {
        return getBooleanFromAdObject("should_apply_mute_setting_to_poststitial", Boolean.valueOf(false));
    }

    /* renamed from: W */
    public boolean mo9885W() {
        return getBooleanFromAdObject("should_forward_close_button_tapped_to_poststitial", Boolean.valueOf(false));
    }

    /* renamed from: X */
    public boolean mo9886X() {
        return getBooleanFromAdObject("vkuv", Boolean.valueOf(false));
    }

    /* renamed from: Y */
    public boolean mo9887Y() {
        return getBooleanFromAdObject("forward_lifecycle_events_to_webview", Boolean.valueOf(false));
    }

    /* renamed from: Z */
    public int mo9888Z() {
        return getIntFromAdObject("close_button_size", ((Integer) this.sdk.mo10202a(C1096c.f2396cF)).intValue());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0827a mo9889a(int i) {
        return i == 1 ? C0827a.WhiteXOnTransparentGrey : i == 2 ? C0827a.Invisible : C0827a.WhiteXOnOpaqueBlack;
    }

    /* renamed from: a */
    public List<C1101a> mo9890a(PointF pointF) {
        return m2030a(pointF, false);
    }

    /* renamed from: a */
    public void mo9891a(C1075c cVar) {
        this.f2212c.set(cVar);
    }

    /* renamed from: a */
    public void mo9892a(boolean z) {
        try {
            synchronized (this.adObjectLock) {
                this.adObject.put("html_resources_cached", z);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: aA */
    public boolean mo9893aA() {
        return this.f2211b.get();
    }

    /* renamed from: aB */
    public void mo9894aB() {
        this.f2211b.set(true);
    }

    /* renamed from: aC */
    public C1075c mo9895aC() {
        return (C1075c) this.f2212c.getAndSet(null);
    }

    /* renamed from: aa */
    public int mo9896aa() {
        return getIntFromAdObject("close_button_top_margin", ((Integer) this.sdk.mo10202a(C1096c.f2397cG)).intValue());
    }

    /* renamed from: ab */
    public int mo9897ab() {
        return getIntFromAdObject("close_button_horizontal_margin", ((Integer) this.sdk.mo10202a(C1096c.f2395cE)).intValue());
    }

    /* renamed from: ac */
    public boolean mo9898ac() {
        return getBooleanFromAdObject("lhs_close_button", (Boolean) this.sdk.mo10202a(C1096c.f2394cD));
    }

    /* renamed from: ad */
    public boolean mo9899ad() {
        return getBooleanFromAdObject("lhs_skip_button", (Boolean) this.sdk.mo10202a(C1096c.f2413cW));
    }

    /* renamed from: ae */
    public boolean mo9900ae() {
        return getBooleanFromAdObject("stop_video_player_after_poststitial_render", Boolean.valueOf(false));
    }

    /* renamed from: af */
    public boolean mo9901af() {
        return getBooleanFromAdObject("unhide_adview_on_render", Boolean.valueOf(false));
    }

    /* renamed from: ag */
    public long mo9902ag() {
        long longFromAdObject = getLongFromAdObject("report_reward_duration", -1);
        if (longFromAdObject >= 0) {
            return TimeUnit.SECONDS.toMillis(longFromAdObject);
        }
        return -1;
    }

    /* renamed from: ah */
    public int mo9903ah() {
        return getIntFromAdObject("report_reward_percent", -1);
    }

    /* renamed from: ai */
    public boolean mo9904ai() {
        return getBooleanFromAdObject("report_reward_percent_include_close_delay", Boolean.valueOf(true));
    }

    /* renamed from: aj */
    public AtomicBoolean mo9905aj() {
        return this.f2210a;
    }

    /* renamed from: ak */
    public boolean mo9906ak() {
        return getBooleanFromAdObject("show_skip_button_on_click", Boolean.valueOf(false));
    }

    /* renamed from: al */
    public List<C1101a> mo9907al() {
        List<C1101a> list = this.f2213d;
        if (list != null) {
            return list;
        }
        synchronized (this.adObjectLock) {
            this.f2213d = C1281o.m3078a("video_end_urls", this.adObject, getClCode(), mo8878a(), this.sdk);
        }
        return this.f2213d;
    }

    /* renamed from: am */
    public List<C1101a> mo9908am() {
        List<C1101a> list = this.f2214e;
        if (list != null) {
            return list;
        }
        synchronized (this.adObjectLock) {
            this.f2214e = C1281o.m3078a("ad_closed_urls", this.adObject, getClCode(), (String) null, this.sdk);
        }
        return this.f2214e;
    }

    /* renamed from: an */
    public List<C1101a> mo8883an() {
        List<C1101a> list = this.f2215f;
        if (list != null) {
            return list;
        }
        synchronized (this.adObjectLock) {
            this.f2215f = C1281o.m3078a("imp_urls", this.adObject, getClCode(), (String) null, this.sdk);
        }
        return this.f2215f;
    }

    /* renamed from: ao */
    public boolean mo9909ao() {
        return getBooleanFromAdObject("playback_requires_user_action", Boolean.valueOf(true));
    }

    /* renamed from: ap */
    public boolean mo9910ap() {
        return getBooleanFromAdObject("sanitize_webview", Boolean.valueOf(false));
    }

    /* renamed from: aq */
    public String mo9911aq() {
        String stringFromAdObject = getStringFromAdObject("base_url", Constants.URL_PATH_DELIMITER);
        if ("null".equalsIgnoreCase(stringFromAdObject)) {
            return null;
        }
        return stringFromAdObject;
    }

    /* renamed from: ar */
    public boolean mo9912ar() {
        return getBooleanFromAdObject("web_contents_debugging_enabled", Boolean.valueOf(false));
    }

    /* renamed from: as */
    public C0894w mo9913as() {
        JSONObject jsonObjectFromAdObject = getJsonObjectFromAdObject("web_view_settings", null);
        if (jsonObjectFromAdObject != null) {
            return new C0894w(jsonObjectFromAdObject, this.sdk);
        }
        return null;
    }

    /* renamed from: at */
    public List<String> mo9914at() {
        return C1243d.m2924a(getStringFromAdObject("wls", ""));
    }

    /* renamed from: au */
    public List<String> mo9915au() {
        return C1243d.m2924a(getStringFromAdObject("wlh", null));
    }

    /* renamed from: av */
    public boolean mo9916av() {
        return getBooleanFromAdObject("tvv", Boolean.valueOf(false));
    }

    /* renamed from: aw */
    public boolean mo9917aw() {
        return getBooleanFromAdObject("ibbdfs", Boolean.valueOf(false));
    }

    /* renamed from: ax */
    public boolean mo9918ax() {
        return getBooleanFromAdObject("ibbdfc", Boolean.valueOf(false));
    }

    /* renamed from: ay */
    public Uri mo9919ay() {
        String stringFromAdObject = getStringFromAdObject("mute_image", null);
        if (!C1277l.m3042b(stringFromAdObject)) {
            return null;
        }
        try {
            return Uri.parse(stringFromAdObject);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: az */
    public Uri mo9920az() {
        String stringFromAdObject = getStringFromAdObject("unmute_image", "");
        if (C1277l.m3042b(stringFromAdObject)) {
            try {
                return Uri.parse(stringFromAdObject);
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    /* renamed from: b */
    public List<C1101a> mo9921b(PointF pointF) {
        List<C1101a> a;
        synchronized (this.adObjectLock) {
            a = C1281o.m3080a("video_click_tracking_urls", this.adObject, m2033c(pointF, true), (String) null, this.sdk);
        }
        return a.isEmpty() ? m2030a(pointF, true) : a;
    }

    /* renamed from: b */
    public void mo9922b(Uri uri) {
        try {
            synchronized (this.adObjectLock) {
                this.adObject.put("mute_image", uri);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: b */
    public boolean mo8884b() {
        this.sdk.mo10249v().mo10382e("DirectAd", "Attempting to invoke isVideoStream() from base ad class");
        return false;
    }

    /* renamed from: c */
    public void mo9923c(Uri uri) {
        try {
            synchronized (this.adObjectLock) {
                this.adObject.put("unmute_image", uri);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: d */
    public Uri mo8886d() {
        this.sdk.mo10249v().mo10382e("DirectAd", "Attempting to invoke getVideoUri() from base ad class");
        return null;
    }

    /* renamed from: f */
    public Uri mo8889f() {
        this.sdk.mo10249v().mo10382e("DirectAd", "Attempting to invoke getClickDestinationUri() from base ad class");
        return null;
    }

    /* renamed from: g */
    public Uri mo8890g() {
        this.sdk.mo10249v().mo10382e("DirectAd", "Attempting to invoke getVideoClickDestinationUri() from base ad class");
        return null;
    }

    /* renamed from: l */
    public C1086b mo9924l() {
        String upperCase = getStringFromAdObject("ad_target", C1086b.DEFAULT.toString()).toUpperCase(Locale.ENGLISH);
        return "ACTIVITY_PORTRAIT".equalsIgnoreCase(upperCase) ? C1086b.ACTIVITY_PORTRAIT : "ACTIVITY_LANDSCAPE".equalsIgnoreCase(upperCase) ? C1086b.ACTIVITY_LANDSCAPE : C1086b.DEFAULT;
    }

    /* renamed from: m */
    public float mo9925m() {
        return getFloatFromAdObject("close_delay", 0.0f);
    }

    /* renamed from: n */
    public float mo9926n() {
        return getFloatFromAdObject("close_delay_graphic", 0.0f);
    }

    /* renamed from: o */
    public C0827a mo9927o() {
        int intFromAdObject = getIntFromAdObject("close_style", -1);
        return intFromAdObject == -1 ? m2031b(hasVideoUrl()) : mo9889a(intFromAdObject);
    }

    /* renamed from: p */
    public C0827a mo9928p() {
        int intFromAdObject = getIntFromAdObject("skip_style", -1);
        return intFromAdObject == -1 ? mo9927o() : mo9889a(intFromAdObject);
    }

    /* renamed from: q */
    public boolean mo9929q() {
        return getBooleanFromAdObject("dismiss_on_skip", Boolean.valueOf(false));
    }

    /* renamed from: r */
    public boolean mo9930r() {
        return getBooleanFromAdObject("html_resources_cached", Boolean.valueOf(false));
    }

    /* renamed from: s */
    public String mo9931s() {
        JSONObject jsonObjectFromAdObject = getJsonObjectFromAdObject("video_button_properties", null);
        String str = "";
        if (jsonObjectFromAdObject == null) {
            return str;
        }
        return C1247h.m2985b(jsonObjectFromAdObject, "video_button_html", str, this.sdk);
    }

    /* renamed from: t */
    public C0889s mo9932t() {
        return new C0889s(getJsonObjectFromAdObject("video_button_properties", null), this.sdk);
    }

    /* renamed from: u */
    public boolean mo8899u() {
        return getBooleanFromAdObject("video_clickable", Boolean.valueOf(false));
    }

    /* renamed from: v */
    public boolean mo9933v() {
        return getBooleanFromAdObject("accelerate_hardware", Boolean.valueOf(false));
    }

    /* renamed from: w */
    public boolean mo9934w() {
        return getBooleanFromAdObject("keep_screen_on", Boolean.valueOf(false));
    }

    /* renamed from: x */
    public boolean mo9935x() {
        return getBooleanFromAdObject("hide_close_on_exit_graphic", Boolean.valueOf(false));
    }

    /* renamed from: y */
    public boolean mo9936y() {
        return getBooleanFromAdObject("hide_close_on_exit", Boolean.valueOf(false));
    }

    /* renamed from: z */
    public boolean mo9937z() {
        return getBooleanFromAdObject("lock_current_orientation", Boolean.valueOf(false));
    }
}
