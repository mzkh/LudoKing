package com.moat.analytics.mobile.inm;

import android.os.Build.VERSION;
import androidx.recyclerview.widget.ItemTouchHelper.Callback;
import com.tapjoy.TJAdUnitConstants.String;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.moat.analytics.mobile.inm.l */
class C2725l {

    /* renamed from: a */
    private boolean f6108a = false;

    /* renamed from: b */
    private boolean f6109b = false;

    /* renamed from: c */
    private boolean f6110c = false;

    /* renamed from: d */
    private int f6111d = Callback.DEFAULT_DRAG_ANIMATION_DURATION;

    /* renamed from: e */
    private int f6112e = 10;

    C2725l(String str) {
        m6263a(str);
    }

    /* renamed from: a */
    private void m6263a(String str) {
        String str2 = "es";
        String str3 = "in";
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("sa");
                boolean equals = string.equals("c334ae83accfebb8da23104450c896463c9cfab7");
                boolean equals2 = string.equals("8f1d08a2d6496191a5ebae8f0590f513e2619489");
                if ((string.equals(String.SPLIT_VIEW_TRIGGER_ON) || equals || equals2) && !m6264a(jSONObject) && !m6265b(jSONObject)) {
                    this.f6108a = true;
                    this.f6109b = equals;
                    this.f6110c = equals2;
                    if (this.f6110c) {
                        this.f6109b = true;
                    }
                }
                if (jSONObject.has(str3)) {
                    int i = jSONObject.getInt(str3);
                    if (i >= 100 && i <= 1000) {
                        this.f6111d = i;
                    }
                }
                if (jSONObject.has(str2)) {
                    this.f6112e = jSONObject.getInt(str2);
                }
                if (m6266c(jSONObject)) {
                    ((C2724k) MoatAnalytics.getInstance()).f6102c = true;
                }
            } catch (Exception e) {
                this.f6108a = false;
                this.f6109b = false;
                this.f6111d = Callback.DEFAULT_DRAG_ANIMATION_DURATION;
                C2726m.m6274a(e);
            }
        }
    }

    /* renamed from: a */
    private boolean m6264a(JSONObject jSONObject) {
        String str = "ob";
        try {
            if (16 > VERSION.SDK_INT) {
                return true;
            }
            if (jSONObject.has(str)) {
                JSONArray jSONArray = jSONObject.getJSONArray(str);
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    if (jSONArray.getInt(i) == VERSION.SDK_INT) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    /* renamed from: b */
    private boolean m6265b(JSONObject jSONObject) {
        String str = "ap";
        try {
            if (jSONObject.has(str)) {
                String b = C2738s.m6324d().mo29085b();
                JSONArray jSONArray = jSONObject.getJSONArray(str);
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    if (jSONArray.getString(i).contentEquals(b)) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            C2726m.m6274a(e);
        }
        return false;
    }

    /* renamed from: c */
    private boolean m6266c(JSONObject jSONObject) {
        String str = "al";
        try {
            if (jSONObject.has(str)) {
                String b = C2738s.m6324d().mo29085b();
                JSONArray jSONArray = jSONObject.getJSONArray(str);
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    if (jSONArray.getString(i).contentEquals(b)) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            C2726m.m6274a(e);
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo29068a() {
        return this.f6109b;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo29069b() {
        return this.f6110c;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public int mo29070c() {
        return this.f6111d;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public int mo29071d() {
        return this.f6112e;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public C2758d mo29072e() {
        return this.f6108a ? C2758d.ON : C2758d.OFF;
    }
}
