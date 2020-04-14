package com.applovin.impl.adview;

import android.annotation.TargetApi;
import android.webkit.WebSettings.PluginState;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.utils.C1247h;
import com.applovin.impl.sdk.utils.C1277l;
import com.tapjoy.TJAdUnitConstants.String;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.adview.w */
public final class C0894w {

    /* renamed from: a */
    private C1192i f1623a;

    /* renamed from: b */
    private JSONObject f1624b;

    public C0894w(JSONObject jSONObject, C1192i iVar) {
        this.f1623a = iVar;
        this.f1624b = jSONObject;
    }

    /* access modifiers changed from: 0000 */
    @TargetApi(21)
    /* renamed from: a */
    public Integer mo9225a() {
        int i;
        String b = C1247h.m2985b(this.f1624b, "mixed_content_mode", (String) null, this.f1623a);
        if (C1277l.m3042b(b)) {
            if ("always_allow".equalsIgnoreCase(b)) {
                i = 0;
            } else if ("never_allow".equalsIgnoreCase(b)) {
                i = 1;
            } else if ("compatibility_mode".equalsIgnoreCase(b)) {
                i = 2;
            }
            return Integer.valueOf(i);
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public PluginState mo9226b() {
        String b = C1247h.m2985b(this.f1624b, "plugin_state", (String) null, this.f1623a);
        if (C1277l.m3042b(b)) {
            if (String.SPLIT_VIEW_TRIGGER_ON.equalsIgnoreCase(b)) {
                return PluginState.ON;
            }
            if ("on_demand".equalsIgnoreCase(b)) {
                return PluginState.ON_DEMAND;
            }
            if ("off".equalsIgnoreCase(b)) {
                return PluginState.OFF;
            }
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public Boolean mo9227c() {
        return C1247h.m2963a(this.f1624b, "allow_file_access", (Boolean) null, this.f1623a);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public Boolean mo9228d() {
        return C1247h.m2963a(this.f1624b, "load_with_overview_mode", (Boolean) null, this.f1623a);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public Boolean mo9229e() {
        return C1247h.m2963a(this.f1624b, "use_wide_view_port", (Boolean) null, this.f1623a);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public Boolean mo9230f() {
        return C1247h.m2963a(this.f1624b, "allow_content_access", (Boolean) null, this.f1623a);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public Boolean mo9231g() {
        return C1247h.m2963a(this.f1624b, "use_built_in_zoom_controls", (Boolean) null, this.f1623a);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public Boolean mo9232h() {
        return C1247h.m2963a(this.f1624b, "display_zoom_controls", (Boolean) null, this.f1623a);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public Boolean mo9233i() {
        return C1247h.m2963a(this.f1624b, "save_form_data", (Boolean) null, this.f1623a);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: j */
    public Boolean mo9234j() {
        return C1247h.m2963a(this.f1624b, "geolocation_enabled", (Boolean) null, this.f1623a);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: k */
    public Boolean mo9235k() {
        return C1247h.m2963a(this.f1624b, "need_initial_focus", (Boolean) null, this.f1623a);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: l */
    public Boolean mo9236l() {
        return C1247h.m2963a(this.f1624b, "allow_file_access_from_file_urls", (Boolean) null, this.f1623a);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: m */
    public Boolean mo9237m() {
        return C1247h.m2963a(this.f1624b, "allow_universal_access_from_file_urls", (Boolean) null, this.f1623a);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: n */
    public Boolean mo9238n() {
        return C1247h.m2963a(this.f1624b, "offscreen_pre_raster", (Boolean) null, this.f1623a);
    }
}
