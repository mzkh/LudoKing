package com.applovin.impl.sdk;

import android.text.TextUtils;
import com.applovin.impl.sdk.p018ad.C1079b;
import com.applovin.impl.sdk.p018ad.C1082d;
import com.applovin.impl.sdk.p018ad.C1087g;
import com.applovin.impl.sdk.p018ad.C1090j;
import com.applovin.impl.sdk.utils.C1247h;
import com.applovin.impl.sdk.utils.C1277l;
import com.applovin.mediation.AppLovinNativeAdapter;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.facebook.appevents.AppEventsConstants;
import com.google.ads.mediation.adcolony.AdColonyAdapterUtils;
import java.util.Arrays;
import org.json.JSONObject;

public abstract class AppLovinAdBase implements C1090j, AppLovinAd {

    /* renamed from: a */
    private final int f2029a;
    protected final JSONObject adObject;
    protected final Object adObjectLock;

    /* renamed from: b */
    private C1082d f2030b;

    /* renamed from: c */
    private final long f2031c;

    /* renamed from: d */
    private C1087g f2032d;
    protected final JSONObject fullResponse;
    protected final Object fullResponseLock;
    protected final C1192i sdk;
    protected final C1079b source;

    protected AppLovinAdBase(JSONObject jSONObject, JSONObject jSONObject2, C1079b bVar, C1192i iVar) {
        if (jSONObject == null) {
            throw new IllegalArgumentException("No ad object specified");
        } else if (jSONObject2 == null) {
            throw new IllegalArgumentException("No response specified");
        } else if (iVar != null) {
            this.adObject = jSONObject;
            this.fullResponse = jSONObject2;
            this.source = bVar;
            this.sdk = iVar;
            this.adObjectLock = new Object();
            this.fullResponseLock = new Object();
            this.f2031c = System.currentTimeMillis();
            char[] charArray = jSONObject.toString().toCharArray();
            Arrays.sort(charArray);
            this.f2029a = new String(charArray).hashCode();
        } else {
            throw new IllegalArgumentException("No sdk specified");
        }
    }

    /* access modifiers changed from: protected */
    public boolean containsKeyForAdObject(String str) {
        boolean has;
        synchronized (this.adObjectLock) {
            has = this.adObject.has(str);
        }
        return has;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C1087g) {
            Object b = ((C1087g) obj).mo9940b();
            if (b != null) {
                obj = b;
            }
        }
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AppLovinAdBase appLovinAdBase = (AppLovinAdBase) obj;
        C1082d dVar = this.f2030b;
        if (dVar == null ? appLovinAdBase.f2030b != null : !dVar.equals(appLovinAdBase.f2030b)) {
            return false;
        }
        if (this.source != appLovinAdBase.source) {
            return false;
        }
        if (this.f2029a != appLovinAdBase.f2029a) {
            z = false;
        }
        return z;
    }

    public long getAdIdNumber() {
        return getLongFromAdObject(AppLovinNativeAdapter.KEY_EXTRA_AD_ID, -1);
    }

    public String getAdValue(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jsonObjectFromAdObject = getJsonObjectFromAdObject("ad_values", null);
        if (jsonObjectFromAdObject == null || jsonObjectFromAdObject.length() <= 0) {
            return null;
        }
        return C1247h.m2985b(jsonObjectFromAdObject, str, (String) null, this.sdk);
    }

    public C1082d getAdZone() {
        C1082d dVar = this.f2030b;
        if (dVar != null) {
            return dVar;
        }
        this.f2030b = C1082d.m1997a(getSize(), getType(), getStringFromFullResponse(AdColonyAdapterUtils.KEY_ZONE_ID, null), this.sdk);
        return this.f2030b;
    }

    /* access modifiers changed from: protected */
    public boolean getBooleanFromAdObject(String str, Boolean bool) {
        boolean booleanValue;
        synchronized (this.adObjectLock) {
            booleanValue = C1247h.m2963a(this.adObject, str, bool, this.sdk).booleanValue();
        }
        return booleanValue;
    }

    /* access modifiers changed from: protected */
    public boolean getBooleanFromFullResponse(String str, boolean z) {
        boolean booleanValue;
        synchronized (this.fullResponseLock) {
            booleanValue = C1247h.m2963a(this.fullResponse, str, Boolean.valueOf(z), this.sdk).booleanValue();
        }
        return booleanValue;
    }

    public String getClCode() {
        String str = "";
        String str2 = "clcode";
        String stringFromAdObject = getStringFromAdObject(str2, str);
        return C1277l.m3042b(stringFromAdObject) ? stringFromAdObject : getStringFromFullResponse(str2, str);
    }

    public long getCreatedAtMillis() {
        return this.f2031c;
    }

    public C1087g getDummyAd() {
        return this.f2032d;
    }

    public long getFetchLatencyMillis() {
        return getLongFromFullResponse("ad_fetch_latency_millis", -1);
    }

    public long getFetchResponseSize() {
        return getLongFromFullResponse("ad_fetch_response_size", -1);
    }

    /* access modifiers changed from: protected */
    public float getFloatFromAdObject(String str, float f) {
        float a;
        synchronized (this.adObjectLock) {
            a = C1247h.m2961a(this.adObject, str, f, this.sdk);
        }
        return a;
    }

    /* access modifiers changed from: protected */
    public float getFloatFromFullResponse(String str, float f) {
        float a;
        synchronized (this.fullResponseLock) {
            a = C1247h.m2961a(this.fullResponse, str, f, this.sdk);
        }
        return a;
    }

    /* access modifiers changed from: protected */
    public int getIntFromAdObject(String str, int i) {
        int b;
        synchronized (this.adObjectLock) {
            b = C1247h.m2984b(this.adObject, str, i, this.sdk);
        }
        return b;
    }

    /* access modifiers changed from: protected */
    public int getIntFromFullResponse(String str, int i) {
        int b;
        synchronized (this.fullResponseLock) {
            b = C1247h.m2984b(this.fullResponse, str, i, this.sdk);
        }
        return b;
    }

    /* access modifiers changed from: protected */
    public JSONObject getJsonObjectFromAdObject(String str, JSONObject jSONObject) {
        JSONObject b;
        synchronized (this.adObjectLock) {
            b = C1247h.m2989b(this.adObject, str, jSONObject, this.sdk);
        }
        return b;
    }

    /* access modifiers changed from: protected */
    public JSONObject getJsonObjectFromFullResponse(String str, JSONObject jSONObject) {
        JSONObject b;
        synchronized (this.fullResponseLock) {
            b = C1247h.m2989b(this.fullResponse, str, jSONObject, this.sdk);
        }
        return b;
    }

    /* access modifiers changed from: protected */
    public long getLongFromAdObject(String str, long j) {
        long a;
        synchronized (this.adObjectLock) {
            a = C1247h.m2962a(this.adObject, str, j, this.sdk);
        }
        return a;
    }

    /* access modifiers changed from: protected */
    public long getLongFromFullResponse(String str, long j) {
        long a;
        synchronized (this.fullResponseLock) {
            a = C1247h.m2962a(this.fullResponse, str, j, this.sdk);
        }
        return a;
    }

    public String getPrimaryKey() {
        return getStringFromAdObject("pk", "NA");
    }

    public C1192i getSdk() {
        return this.sdk;
    }

    public String getSecondaryKey1() {
        return getStringFromAdObject("sk1", null);
    }

    public String getSecondaryKey2() {
        return getStringFromAdObject("sk2", null);
    }

    public AppLovinAdSize getSize() {
        return AppLovinAdSize.fromString(getStringFromFullResponse("ad_size", null));
    }

    public C1079b getSource() {
        return this.source;
    }

    /* access modifiers changed from: protected */
    public String getStringFromAdObject(String str, String str2) {
        String b;
        synchronized (this.adObjectLock) {
            b = C1247h.m2985b(this.adObject, str, str2, this.sdk);
        }
        return b;
    }

    /* access modifiers changed from: protected */
    public String getStringFromFullResponse(String str, String str2) {
        String b;
        synchronized (this.fullResponseLock) {
            b = C1247h.m2985b(this.fullResponse, str, str2, this.sdk);
        }
        return b;
    }

    public AppLovinAdType getType() {
        return AppLovinAdType.fromString(getStringFromFullResponse(AppEventsConstants.EVENT_PARAM_AD_TYPE, null));
    }

    public String getZoneId() {
        if (getAdZone().mo9858j()) {
            return null;
        }
        return getStringFromFullResponse(AdColonyAdapterUtils.KEY_ZONE_ID, null);
    }

    public boolean hasShown() {
        return getBooleanFromAdObject("shown", Boolean.valueOf(false));
    }

    public boolean hasVideoUrl() {
        this.sdk.mo10249v().mo10382e("AppLovinAdBase", "Attempting to invoke hasVideoUrl() from base ad class");
        return false;
    }

    public int hashCode() {
        return this.f2029a;
    }

    public boolean isVideoAd() {
        String str = "is_video_ad";
        return this.adObject.has(str) ? getBooleanFromAdObject(str, Boolean.valueOf(false)) : hasVideoUrl();
    }

    public void setDummyAd(C1087g gVar) {
        this.f2032d = gVar;
    }

    public void setHasShown(boolean z) {
        try {
            synchronized (this.adObjectLock) {
                this.adObject.put("shown", z);
            }
        } catch (Throwable unused) {
        }
    }

    public boolean shouldCancelHtmlCachingIfShown() {
        return getBooleanFromAdObject("chcis", Boolean.valueOf(false));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AppLovinAd{adIdNumber");
        sb.append(getAdIdNumber());
        sb.append(", source=");
        sb.append(getSource());
        sb.append(", zoneId='");
        sb.append(getZoneId());
        sb.append("'");
        sb.append('}');
        return sb.toString();
    }
}
