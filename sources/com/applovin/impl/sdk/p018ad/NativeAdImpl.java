package com.applovin.impl.sdk.p018ad;

import android.content.Context;
import android.net.Uri;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.C1227o;
import com.applovin.impl.sdk.network.C1222f;
import com.applovin.impl.sdk.network.C1225g;
import com.applovin.impl.sdk.p019b.C1096c;
import com.applovin.impl.sdk.p020c.C1101a;
import com.applovin.impl.sdk.utils.C1281o;
import com.applovin.nativeAds.AppLovinNativeAd;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinPostbackListener;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.applovin.impl.sdk.ad.NativeAdImpl */
public class NativeAdImpl implements C1090j, AppLovinNativeAd {
    public static final String QUERY_PARAM_IS_FIRST_PLAY = "fp";
    public static final String QUERY_PARAM_VIDEO_PERCENT_VIEWED = "pv";

    /* renamed from: a */
    private final C1192i f2133a;

    /* renamed from: b */
    private final C1082d f2134b;

    /* renamed from: c */
    private final String f2135c;

    /* renamed from: d */
    private final String f2136d;

    /* renamed from: e */
    private final String f2137e;

    /* renamed from: f */
    private final String f2138f;

    /* renamed from: g */
    private final String f2139g;

    /* renamed from: h */
    private final String f2140h;

    /* renamed from: i */
    private final String f2141i;

    /* renamed from: j */
    private final String f2142j;

    /* renamed from: k */
    private final String f2143k;

    /* renamed from: l */
    private final String f2144l;

    /* renamed from: m */
    private final String f2145m;

    /* renamed from: n */
    private final String f2146n;

    /* renamed from: o */
    private final String f2147o;

    /* renamed from: p */
    private final List<C1101a> f2148p;

    /* renamed from: q */
    private final List<C1101a> f2149q;

    /* renamed from: r */
    private final String f2150r;

    /* renamed from: s */
    private final long f2151s;

    /* renamed from: t */
    private final List<String> f2152t;

    /* renamed from: u */
    private String f2153u;

    /* renamed from: v */
    private String f2154v;

    /* renamed from: w */
    private float f2155w;

    /* renamed from: x */
    private String f2156x;

    /* renamed from: y */
    private AtomicBoolean f2157y;

    /* renamed from: com.applovin.impl.sdk.ad.NativeAdImpl$a */
    public static class C1077a {

        /* renamed from: a */
        private C1082d f2158a;

        /* renamed from: b */
        private String f2159b;

        /* renamed from: c */
        private String f2160c;

        /* renamed from: d */
        private String f2161d;

        /* renamed from: e */
        private String f2162e;

        /* renamed from: f */
        private String f2163f;

        /* renamed from: g */
        private String f2164g;

        /* renamed from: h */
        private String f2165h;

        /* renamed from: i */
        private String f2166i;

        /* renamed from: j */
        private String f2167j;

        /* renamed from: k */
        private String f2168k;

        /* renamed from: l */
        private float f2169l;

        /* renamed from: m */
        private String f2170m;

        /* renamed from: n */
        private String f2171n;

        /* renamed from: o */
        private String f2172o;

        /* renamed from: p */
        private String f2173p;

        /* renamed from: q */
        private String f2174q;

        /* renamed from: r */
        private List<C1101a> f2175r;

        /* renamed from: s */
        private List<C1101a> f2176s;

        /* renamed from: t */
        private String f2177t;

        /* renamed from: u */
        private String f2178u;

        /* renamed from: v */
        private long f2179v;

        /* renamed from: w */
        private List<String> f2180w;

        /* renamed from: x */
        private C1192i f2181x;

        /* renamed from: a */
        public C1077a mo9805a(float f) {
            this.f2169l = f;
            return this;
        }

        /* renamed from: a */
        public C1077a mo9806a(long j) {
            this.f2179v = j;
            return this;
        }

        /* renamed from: a */
        public C1077a mo9807a(C1082d dVar) {
            this.f2158a = dVar;
            return this;
        }

        /* renamed from: a */
        public C1077a mo9808a(C1192i iVar) {
            this.f2181x = iVar;
            return this;
        }

        /* renamed from: a */
        public C1077a mo9809a(String str) {
            this.f2160c = str;
            return this;
        }

        /* renamed from: a */
        public C1077a mo9810a(List<C1101a> list) {
            this.f2175r = list;
            return this;
        }

        /* renamed from: a */
        public NativeAdImpl mo9811a() {
            NativeAdImpl nativeAdImpl = new NativeAdImpl(this.f2158a, this.f2159b, this.f2160c, this.f2161d, this.f2162e, this.f2163f, this.f2164g, this.f2165h, this.f2166i, this.f2167j, this.f2168k, this.f2169l, this.f2170m, this.f2171n, this.f2172o, this.f2173p, this.f2174q, this.f2175r, this.f2176s, this.f2177t, this.f2178u, this.f2179v, this.f2180w, this.f2181x);
            return nativeAdImpl;
        }

        /* renamed from: b */
        public C1077a mo9812b(String str) {
            this.f2161d = str;
            return this;
        }

        /* renamed from: b */
        public C1077a mo9813b(List<C1101a> list) {
            this.f2176s = list;
            return this;
        }

        /* renamed from: c */
        public C1077a mo9814c(String str) {
            this.f2162e = str;
            return this;
        }

        /* renamed from: c */
        public C1077a mo9815c(List<String> list) {
            this.f2180w = list;
            return this;
        }

        /* renamed from: d */
        public C1077a mo9816d(String str) {
            this.f2163f = str;
            return this;
        }

        /* renamed from: e */
        public C1077a mo9817e(String str) {
            this.f2159b = str;
            return this;
        }

        /* renamed from: f */
        public C1077a mo9818f(String str) {
            this.f2164g = str;
            return this;
        }

        /* renamed from: g */
        public C1077a mo9819g(String str) {
            this.f2165h = str;
            return this;
        }

        /* renamed from: h */
        public C1077a mo9820h(String str) {
            this.f2166i = str;
            return this;
        }

        /* renamed from: i */
        public C1077a mo9821i(String str) {
            this.f2167j = str;
            return this;
        }

        /* renamed from: j */
        public C1077a mo9822j(String str) {
            this.f2168k = str;
            return this;
        }

        /* renamed from: k */
        public C1077a mo9823k(String str) {
            this.f2170m = str;
            return this;
        }

        /* renamed from: l */
        public C1077a mo9824l(String str) {
            this.f2171n = str;
            return this;
        }

        /* renamed from: m */
        public C1077a mo9825m(String str) {
            this.f2172o = str;
            return this;
        }

        /* renamed from: n */
        public C1077a mo9826n(String str) {
            this.f2173p = str;
            return this;
        }

        /* renamed from: o */
        public C1077a mo9827o(String str) {
            this.f2174q = str;
            return this;
        }

        /* renamed from: p */
        public C1077a mo9828p(String str) {
            this.f2177t = str;
            return this;
        }

        /* renamed from: q */
        public C1077a mo9829q(String str) {
            this.f2178u = str;
            return this;
        }
    }

    private NativeAdImpl(C1082d dVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, float f, String str11, String str12, String str13, String str14, String str15, List<C1101a> list, List<C1101a> list2, String str16, String str17, long j, List<String> list3, C1192i iVar) {
        this.f2157y = new AtomicBoolean();
        this.f2134b = dVar;
        this.f2135c = str;
        this.f2136d = str2;
        this.f2137e = str3;
        this.f2138f = str4;
        this.f2139g = str5;
        this.f2140h = str6;
        this.f2141i = str7;
        this.f2142j = str8;
        this.f2153u = str9;
        this.f2154v = str10;
        this.f2155w = f;
        this.f2156x = str11;
        this.f2144l = str12;
        this.f2145m = str13;
        this.f2146n = str14;
        this.f2147o = str15;
        this.f2148p = list;
        this.f2149q = list2;
        this.f2150r = str16;
        this.f2143k = str17;
        this.f2151s = j;
        this.f2152t = list3;
        this.f2133a = iVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        NativeAdImpl nativeAdImpl = (NativeAdImpl) obj;
        C1082d dVar = this.f2134b;
        if (dVar == null ? nativeAdImpl.f2134b != null : !dVar.equals(nativeAdImpl.f2134b)) {
            return false;
        }
        String str = this.f2142j;
        if (str == null ? nativeAdImpl.f2142j != null : !str.equals(nativeAdImpl.f2142j)) {
            return false;
        }
        String str2 = this.f2150r;
        if (str2 == null ? nativeAdImpl.f2150r != null : !str2.equals(nativeAdImpl.f2150r)) {
            return false;
        }
        String str3 = this.f2144l;
        if (str3 == null ? nativeAdImpl.f2144l != null : !str3.equals(nativeAdImpl.f2144l)) {
            return false;
        }
        String str4 = this.f2143k;
        if (str4 == null ? nativeAdImpl.f2143k != null : !str4.equals(nativeAdImpl.f2143k)) {
            return false;
        }
        String str5 = this.f2141i;
        if (str5 == null ? nativeAdImpl.f2141i != null : !str5.equals(nativeAdImpl.f2141i)) {
            return false;
        }
        String str6 = this.f2145m;
        if (str6 == null ? nativeAdImpl.f2145m != null : !str6.equals(nativeAdImpl.f2145m)) {
            return false;
        }
        String str7 = this.f2136d;
        if (str7 == null ? nativeAdImpl.f2136d != null : !str7.equals(nativeAdImpl.f2136d)) {
            return false;
        }
        String str8 = this.f2137e;
        if (str8 == null ? nativeAdImpl.f2137e != null : !str8.equals(nativeAdImpl.f2137e)) {
            return false;
        }
        String str9 = this.f2138f;
        if (str9 == null ? nativeAdImpl.f2138f != null : !str9.equals(nativeAdImpl.f2138f)) {
            return false;
        }
        String str10 = this.f2139g;
        if (str10 == null ? nativeAdImpl.f2139g != null : !str10.equals(nativeAdImpl.f2139g)) {
            return false;
        }
        String str11 = this.f2140h;
        if (str11 == null ? nativeAdImpl.f2140h != null : !str11.equals(nativeAdImpl.f2140h)) {
            return false;
        }
        String str12 = this.f2147o;
        if (str12 == null ? nativeAdImpl.f2147o != null : !str12.equals(nativeAdImpl.f2147o)) {
            return false;
        }
        String str13 = this.f2146n;
        if (str13 == null ? nativeAdImpl.f2146n != null : !str13.equals(nativeAdImpl.f2146n)) {
            return false;
        }
        List<C1101a> list = this.f2148p;
        if (list == null ? nativeAdImpl.f2148p != null : !list.equals(nativeAdImpl.f2148p)) {
            return false;
        }
        List<C1101a> list2 = this.f2149q;
        if (list2 == null ? nativeAdImpl.f2149q != null : !list2.equals(nativeAdImpl.f2149q)) {
            return false;
        }
        List<String> list3 = this.f2152t;
        return list3 == null ? nativeAdImpl.f2152t == null : list3.equals(nativeAdImpl.f2152t);
    }

    public long getAdId() {
        return this.f2151s;
    }

    public C1082d getAdZone() {
        return this.f2134b;
    }

    public String getCaptionText() {
        return this.f2142j;
    }

    public String getClCode() {
        return this.f2150r;
    }

    public String getClickUrl() {
        return this.f2144l;
    }

    public String getCtaText() {
        return this.f2143k;
    }

    public String getDescriptionText() {
        return this.f2141i;
    }

    public String getIconUrl() {
        return this.f2153u;
    }

    public String getImageUrl() {
        return this.f2154v;
    }

    public String getImpressionTrackingUrl() {
        return this.f2145m;
    }

    public List<String> getResourcePrefixes() {
        return this.f2152t;
    }

    public String getSourceIconUrl() {
        return this.f2136d;
    }

    public String getSourceImageUrl() {
        return this.f2137e;
    }

    public String getSourceStarRatingImageUrl() {
        return this.f2138f;
    }

    public String getSourceVideoUrl() {
        return this.f2139g;
    }

    public float getStarRating() {
        return this.f2155w;
    }

    public String getTitle() {
        return this.f2140h;
    }

    public String getVideoEndTrackingUrl(int i, boolean z) {
        Uri build;
        if (this.f2147o == null) {
            build = Uri.EMPTY;
        } else {
            if (i < 0 || i > 100) {
                C1227o.m2837c("AppLovinNativeAd", "Invalid percent viewed supplied.", new IllegalArgumentException("Percent viewed must be an integer between 0 and 100."));
            }
            build = Uri.parse(this.f2147o).buildUpon().appendQueryParameter(QUERY_PARAM_VIDEO_PERCENT_VIEWED, Integer.toString(i)).appendQueryParameter(QUERY_PARAM_IS_FIRST_PLAY, Boolean.toString(z)).build();
        }
        return build.toString();
    }

    public String getVideoStartTrackingUrl() {
        return this.f2146n;
    }

    public String getVideoUrl() {
        return this.f2156x;
    }

    public String getZoneId() {
        return this.f2135c;
    }

    public int hashCode() {
        String str = this.f2136d;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f2137e;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f2138f;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f2139g;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f2140h;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.f2141i;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.f2142j;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.f2143k;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.f2144l;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.f2145m;
        int hashCode10 = (hashCode9 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.f2146n;
        int hashCode11 = (hashCode10 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.f2147o;
        int hashCode12 = (hashCode11 + (str12 != null ? str12.hashCode() : 0)) * 31;
        List<C1101a> list = this.f2148p;
        int hashCode13 = (hashCode12 + (list != null ? list.hashCode() : 0)) * 31;
        List<C1101a> list2 = this.f2149q;
        int hashCode14 = (hashCode13 + (list2 != null ? list2.hashCode() : 0)) * 31;
        String str13 = this.f2150r;
        int hashCode15 = (hashCode14 + (str13 != null ? str13.hashCode() : 0)) * 31;
        C1082d dVar = this.f2134b;
        int hashCode16 = (hashCode15 + (dVar != null ? dVar.hashCode() : 0)) * 31;
        List<String> list3 = this.f2152t;
        if (list3 != null) {
            i = list3.hashCode();
        }
        return hashCode16 + i;
    }

    public boolean isImagePrecached() {
        String str = this.f2153u;
        boolean z = str != null && !str.equals(this.f2136d);
        String str2 = this.f2154v;
        return z && (str2 != null && !str2.equals(this.f2137e));
    }

    public boolean isVideoPrecached() {
        String str = this.f2156x;
        return str != null && !str.equals(this.f2139g);
    }

    public void launchClickTarget(Context context) {
        for (C1101a aVar : this.f2149q) {
            this.f2133a.mo10188N().mo10338a(C1222f.m2788k().mo10355a(aVar.mo9988a()).mo10359b(aVar.mo9989b()).mo10357a(false).mo10358a());
        }
        C1281o.m3090a(context, Uri.parse(this.f2144l), this.f2133a);
    }

    public void setIconUrl(String str) {
        this.f2153u = str;
    }

    public void setImageUrl(String str) {
        this.f2154v = str;
    }

    public void setStarRating(float f) {
        this.f2155w = f;
    }

    public void setVideoUrl(String str) {
        this.f2156x = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AppLovinNativeAd{clCode='");
        sb.append(this.f2150r);
        sb.append('\'');
        sb.append(", adZone='");
        sb.append(this.f2134b);
        sb.append('\'');
        sb.append(", sourceIconUrl='");
        sb.append(this.f2136d);
        sb.append('\'');
        sb.append(", sourceImageUrl='");
        sb.append(this.f2137e);
        sb.append('\'');
        sb.append(", sourceStarRatingImageUrl='");
        sb.append(this.f2138f);
        sb.append('\'');
        sb.append(", sourceVideoUrl='");
        sb.append(this.f2139g);
        sb.append('\'');
        sb.append(", title='");
        sb.append(this.f2140h);
        sb.append('\'');
        sb.append(", descriptionText='");
        sb.append(this.f2141i);
        sb.append('\'');
        sb.append(", captionText='");
        sb.append(this.f2142j);
        sb.append('\'');
        sb.append(", ctaText='");
        sb.append(this.f2143k);
        sb.append('\'');
        sb.append(", iconUrl='");
        sb.append(this.f2153u);
        sb.append('\'');
        sb.append(", imageUrl='");
        sb.append(this.f2154v);
        sb.append('\'');
        sb.append(", starRating='");
        sb.append(this.f2155w);
        sb.append('\'');
        sb.append(", videoUrl='");
        sb.append(this.f2156x);
        sb.append('\'');
        sb.append(", clickUrl='");
        sb.append(this.f2144l);
        sb.append('\'');
        sb.append(", impressionTrackingUrl='");
        sb.append(this.f2145m);
        sb.append('\'');
        sb.append(", videoStartTrackingUrl='");
        sb.append(this.f2146n);
        sb.append('\'');
        sb.append(", videoEndTrackingUrl='");
        sb.append(this.f2147o);
        sb.append('\'');
        sb.append(", impressionPostbacks=");
        sb.append(this.f2148p);
        sb.append('\'');
        sb.append(", clickTrackingPostbacks=");
        sb.append(this.f2149q);
        sb.append('\'');
        sb.append(", resourcePrefixes=");
        sb.append(this.f2152t);
        sb.append('}');
        return sb.toString();
    }

    public void trackImpression() {
        trackImpression(null);
    }

    public void trackImpression(AppLovinPostbackListener appLovinPostbackListener) {
        if (!this.f2157y.getAndSet(true)) {
            this.f2133a.mo10249v().mo10378b("AppLovinNativeAd", "Tracking impression...");
            boolean booleanValue = ((Boolean) this.f2133a.mo10202a(C1096c.f2517eW)).booleanValue();
            for (C1101a aVar : this.f2148p) {
                if (booleanValue) {
                    this.f2133a.mo10188N().mo10340a(C1222f.m2788k().mo10355a(aVar.mo9988a()).mo10359b(aVar.mo9989b()).mo10357a(false).mo10358a(), true, appLovinPostbackListener);
                } else {
                    this.f2133a.mo10192R().dispatchPostbackRequest(C1225g.m2812b(this.f2133a).mo10324a(aVar.mo9988a()).mo10333c(aVar.mo9989b()).mo10327a(false).mo10328a(), appLovinPostbackListener);
                }
            }
        } else if (appLovinPostbackListener != null) {
            appLovinPostbackListener.onPostbackFailure(this.f2145m, AppLovinErrorCodes.NATIVE_AD_IMPRESSION_ALREADY_TRACKED);
        }
    }
}
