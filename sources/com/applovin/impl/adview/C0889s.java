package com.applovin.impl.adview;

import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.C1227o;
import com.applovin.impl.sdk.utils.C1247h;
import com.tapjoy.TJAdUnitConstants;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.adview.s */
public class C0889s {

    /* renamed from: a */
    private final int f1611a;

    /* renamed from: b */
    private final int f1612b;

    /* renamed from: c */
    private final int f1613c;

    /* renamed from: d */
    private final int f1614d;

    /* renamed from: e */
    private final boolean f1615e;

    /* renamed from: f */
    private final int f1616f;

    /* renamed from: g */
    private final int f1617g;

    /* renamed from: h */
    private final int f1618h;

    /* renamed from: i */
    private final float f1619i;

    /* renamed from: j */
    private final float f1620j;

    public C0889s(JSONObject jSONObject, C1192i iVar) {
        C1227o v = iVar.mo10249v();
        StringBuilder sb = new StringBuilder();
        sb.append("Updating video button properties with JSON = ");
        sb.append(C1247h.m2968a(jSONObject, iVar));
        v.mo10380c("VideoButtonProperties", sb.toString());
        this.f1611a = C1247h.m2984b(jSONObject, "width", 64, iVar);
        this.f1612b = C1247h.m2984b(jSONObject, "height", 7, iVar);
        this.f1613c = C1247h.m2984b(jSONObject, "margin", 20, iVar);
        this.f1614d = C1247h.m2984b(jSONObject, "gravity", 85, iVar);
        this.f1615e = C1247h.m2963a(jSONObject, "tap_to_fade", Boolean.valueOf(false), iVar).booleanValue();
        this.f1616f = C1247h.m2984b(jSONObject, "tap_to_fade_duration_milliseconds", (int) TJAdUnitConstants.DEFAULT_VOLUME_CHECK_INTERVAL, iVar);
        this.f1617g = C1247h.m2984b(jSONObject, "fade_in_duration_milliseconds", (int) TJAdUnitConstants.DEFAULT_VOLUME_CHECK_INTERVAL, iVar);
        this.f1618h = C1247h.m2984b(jSONObject, "fade_out_duration_milliseconds", (int) TJAdUnitConstants.DEFAULT_VOLUME_CHECK_INTERVAL, iVar);
        this.f1619i = C1247h.m2961a(jSONObject, "fade_in_delay_seconds", 1.0f, iVar);
        this.f1620j = C1247h.m2961a(jSONObject, "fade_out_delay_seconds", 6.0f, iVar);
    }

    /* renamed from: a */
    public int mo9205a() {
        return this.f1611a;
    }

    /* renamed from: b */
    public int mo9206b() {
        return this.f1612b;
    }

    /* renamed from: c */
    public int mo9207c() {
        return this.f1613c;
    }

    /* renamed from: d */
    public int mo9208d() {
        return this.f1614d;
    }

    /* renamed from: e */
    public boolean mo9209e() {
        return this.f1615e;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0889s sVar = (C0889s) obj;
        if (this.f1611a != sVar.f1611a || this.f1612b != sVar.f1612b || this.f1613c != sVar.f1613c || this.f1614d != sVar.f1614d || this.f1615e != sVar.f1615e || this.f1616f != sVar.f1616f || this.f1617g != sVar.f1617g || this.f1618h != sVar.f1618h || Float.compare(sVar.f1619i, this.f1619i) != 0) {
            return false;
        }
        if (Float.compare(sVar.f1620j, this.f1620j) != 0) {
            z = false;
        }
        return z;
    }

    /* renamed from: f */
    public long mo9211f() {
        return (long) this.f1616f;
    }

    /* renamed from: g */
    public long mo9212g() {
        return (long) this.f1617g;
    }

    /* renamed from: h */
    public long mo9213h() {
        return (long) this.f1618h;
    }

    public int hashCode() {
        int i = ((((((((((((((this.f1611a * 31) + this.f1612b) * 31) + this.f1613c) * 31) + this.f1614d) * 31) + (this.f1615e ? 1 : 0)) * 31) + this.f1616f) * 31) + this.f1617g) * 31) + this.f1618h) * 31;
        float f = this.f1619i;
        int i2 = 0;
        int floatToIntBits = (i + (f != 0.0f ? Float.floatToIntBits(f) : 0)) * 31;
        float f2 = this.f1620j;
        if (f2 != 0.0f) {
            i2 = Float.floatToIntBits(f2);
        }
        return floatToIntBits + i2;
    }

    /* renamed from: i */
    public float mo9215i() {
        return this.f1619i;
    }

    /* renamed from: j */
    public float mo9216j() {
        return this.f1620j;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VideoButtonProperties{widthPercentOfScreen=");
        sb.append(this.f1611a);
        sb.append(", heightPercentOfScreen=");
        sb.append(this.f1612b);
        sb.append(", margin=");
        sb.append(this.f1613c);
        sb.append(", gravity=");
        sb.append(this.f1614d);
        sb.append(", tapToFade=");
        sb.append(this.f1615e);
        sb.append(", tapToFadeDurationMillis=");
        sb.append(this.f1616f);
        sb.append(", fadeInDurationMillis=");
        sb.append(this.f1617g);
        sb.append(", fadeOutDurationMillis=");
        sb.append(this.f1618h);
        sb.append(", fadeInDelay=");
        sb.append(this.f1619i);
        sb.append(", fadeOutDelay=");
        sb.append(this.f1620j);
        sb.append('}');
        return sb.toString();
    }
}
