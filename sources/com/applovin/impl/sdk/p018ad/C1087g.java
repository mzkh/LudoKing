package com.applovin.impl.sdk.p018ad;

import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.C1227o;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.ad.g */
public final class C1087g extends AppLovinAdBase {

    /* renamed from: a */
    private AppLovinAd f2224a;

    /* renamed from: b */
    private final C1082d f2225b;

    public C1087g(C1082d dVar, C1192i iVar) {
        super(new JSONObject(), new JSONObject(), C1079b.UNKNOWN, iVar);
        this.f2225b = dVar;
    }

    /* renamed from: c */
    private AppLovinAd m2115c() {
        return (AppLovinAd) this.sdk.mo10194T().mo9981c(this.f2225b);
    }

    /* renamed from: d */
    private String m2116d() {
        C1082d adZone = getAdZone();
        if (adZone == null || adZone.mo9858j()) {
            return null;
        }
        return adZone.mo9846a();
    }

    /* renamed from: a */
    public AppLovinAd mo9938a() {
        return this.f2224a;
    }

    /* renamed from: a */
    public void mo9939a(AppLovinAd appLovinAd) {
        this.f2224a = appLovinAd;
    }

    /* renamed from: b */
    public AppLovinAd mo9940b() {
        AppLovinAd appLovinAd = this.f2224a;
        return appLovinAd != null ? appLovinAd : m2115c();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AppLovinAd b = mo9940b();
        return b != null ? b.equals(obj) : super.equals(obj);
    }

    public long getAdIdNumber() {
        try {
            AppLovinAd b = mo9940b();
            if (b != null) {
                return b.getAdIdNumber();
            }
            return 0;
        } catch (Throwable th) {
            C1227o.m2837c("AppLovinAd", "Failed to retrieve ad id number", th);
            return 0;
        }
    }

    public C1082d getAdZone() {
        AppLovinAdBase appLovinAdBase = (AppLovinAdBase) mo9940b();
        return appLovinAdBase != null ? appLovinAdBase.getAdZone() : this.f2225b;
    }

    public AppLovinAdSize getSize() {
        AppLovinAdSize appLovinAdSize = AppLovinAdSize.INTERSTITIAL;
        try {
            return getAdZone().mo9848b();
        } catch (Throwable th) {
            C1227o.m2837c("AppLovinAd", "Failed to retrieve ad size", th);
            return appLovinAdSize;
        }
    }

    public C1079b getSource() {
        AppLovinAdBase appLovinAdBase = (AppLovinAdBase) mo9940b();
        return appLovinAdBase != null ? appLovinAdBase.getSource() : C1079b.UNKNOWN;
    }

    public AppLovinAdType getType() {
        AppLovinAdType appLovinAdType = AppLovinAdType.REGULAR;
        try {
            return getAdZone().mo9849c();
        } catch (Throwable th) {
            C1227o.m2837c("AppLovinAd", "Failed to retrieve ad type", th);
            return appLovinAdType;
        }
    }

    public String getZoneId() {
        try {
            if (!this.f2225b.mo9858j()) {
                return this.f2225b.mo9846a();
            }
            return null;
        } catch (Throwable th) {
            C1227o.m2837c("AppLovinAd", "Failed to return zone id", th);
            return null;
        }
    }

    public int hashCode() {
        AppLovinAd b = mo9940b();
        return b != null ? b.hashCode() : super.hashCode();
    }

    public boolean isVideoAd() {
        try {
            AppLovinAd b = mo9940b();
            if (b != null) {
                return b.isVideoAd();
            }
            return false;
        } catch (Throwable th) {
            C1227o.m2837c("AppLovinAd", "Failed to return whether ad is video ad", th);
            return false;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AppLovinAd{ #");
        sb.append(getAdIdNumber());
        sb.append(", adType=");
        sb.append(getType());
        sb.append(", adSize=");
        sb.append(getSize());
        sb.append(", zoneId='");
        sb.append(m2116d());
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
