package com.inmobi.media;

import android.content.Context;
import android.location.Location;
import java.util.HashMap;
import java.util.Locale;

/* renamed from: com.inmobi.media.gu */
/* compiled from: PublisherProvidedUserInfoDao */
public final class C2534gu {

    /* renamed from: a */
    private static int f5548a = Integer.MIN_VALUE;

    /* renamed from: b */
    private static String f5549b = null;

    /* renamed from: c */
    private static String f5550c = null;

    /* renamed from: d */
    private static String f5551d = null;

    /* renamed from: e */
    private static String f5552e = null;

    /* renamed from: f */
    private static String f5553f = null;

    /* renamed from: g */
    private static String f5554g = null;

    /* renamed from: h */
    private static int f5555h = Integer.MIN_VALUE;

    /* renamed from: i */
    private static String f5556i;

    /* renamed from: j */
    private static String f5557j;

    /* renamed from: k */
    private static String f5558k;

    /* renamed from: l */
    private static String f5559l;

    /* renamed from: m */
    private static Location f5560m;

    /* renamed from: a */
    public static void m5409a() {
        m5410a(f5548a);
        m5412a(f5549b);
        m5416b(f5550c);
        m5418c(f5551d);
        m5419d(f5552e);
        m5420e(f5553f);
        m5421f(f5554g);
        m5415b(f5555h);
        m5422g(f5556i);
        m5423h(f5557j);
        m5424i(f5558k);
        m5425j(f5559l);
        m5411a(f5560m);
    }

    /* renamed from: a */
    public static void m5410a(int i) {
        Context c = C2505gd.m5298c();
        if (c == null || i == Integer.MIN_VALUE) {
            f5548a = i;
        } else {
            C2494fy.m5249a(c, "user_info_store").mo28437a("user_age", i);
        }
    }

    /* renamed from: a */
    public static void m5412a(String str) {
        Context c = C2505gd.m5298c();
        if (c == null || str == null) {
            f5549b = str;
        } else {
            C2494fy.m5249a(c, "user_info_store").mo28439a("user_age_group", str);
        }
    }

    /* renamed from: b */
    public static void m5416b(String str) {
        Context c = C2505gd.m5298c();
        if (c == null || str == null) {
            f5550c = str;
        } else {
            C2494fy.m5249a(c, "user_info_store").mo28439a("user_area_code", str);
        }
    }

    /* renamed from: c */
    public static void m5418c(String str) {
        Context c = C2505gd.m5298c();
        if (c == null || str == null) {
            f5551d = str;
        } else {
            C2494fy.m5249a(c, "user_info_store").mo28439a("user_post_code", str);
        }
    }

    /* renamed from: d */
    public static void m5419d(String str) {
        Context c = C2505gd.m5298c();
        if (c == null || str == null) {
            f5552e = str;
        } else {
            C2494fy.m5249a(c, "user_info_store").mo28439a("user_city_code", str);
        }
    }

    /* renamed from: e */
    public static void m5420e(String str) {
        Context c = C2505gd.m5298c();
        if (c == null || str == null) {
            f5553f = str;
        } else {
            C2494fy.m5249a(c, "user_info_store").mo28439a("user_state_code", str);
        }
    }

    /* renamed from: f */
    public static void m5421f(String str) {
        Context c = C2505gd.m5298c();
        if (c == null || str == null) {
            f5554g = str;
        } else {
            C2494fy.m5249a(c, "user_info_store").mo28439a("user_country_code", str);
        }
    }

    /* renamed from: b */
    public static void m5415b(int i) {
        Context c = C2505gd.m5298c();
        if (c == null || i == Integer.MIN_VALUE) {
            f5555h = i;
        } else {
            C2494fy.m5249a(c, "user_info_store").mo28437a("user_yob", i);
        }
    }

    /* renamed from: g */
    public static void m5422g(String str) {
        Context c = C2505gd.m5298c();
        if (c == null || str == null) {
            f5556i = str;
        } else {
            C2494fy.m5249a(c, "user_info_store").mo28439a("user_gender", str);
        }
    }

    /* renamed from: h */
    public static void m5423h(String str) {
        Context c = C2505gd.m5298c();
        if (c == null || str == null) {
            f5557j = str;
        } else {
            C2494fy.m5249a(c, "user_info_store").mo28439a("user_education", str);
        }
    }

    /* renamed from: i */
    public static void m5424i(String str) {
        Context c = C2505gd.m5298c();
        if (c == null || str == null) {
            f5558k = str;
        } else {
            C2494fy.m5249a(c, "user_info_store").mo28439a("user_language", str);
        }
    }

    /* renamed from: j */
    public static void m5425j(String str) {
        Context c = C2505gd.m5298c();
        if (c == null || str == null) {
            f5559l = str;
        } else {
            C2494fy.m5249a(c, "user_info_store").mo28439a("user_interest", str);
        }
    }

    /* renamed from: b */
    public static Location m5413b() {
        Location location = f5560m;
        if (location != null) {
            return location;
        }
        Context c = C2505gd.m5298c();
        Location location2 = null;
        if (c == null) {
            return null;
        }
        String b = C2494fy.m5249a(c, "user_info_store").mo28442b("user_location");
        if (b == null) {
            return null;
        }
        Location location3 = new Location("");
        try {
            String[] split = b.split(",");
            location3.setLatitude(Double.parseDouble(split[0]));
            location3.setLongitude(Double.parseDouble(split[1]));
            location3.setAccuracy(Float.parseFloat(split[2]));
            location3.setTime(Long.parseLong(split[3]));
            location2 = location3;
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException unused) {
        }
        return location2;
    }

    /* renamed from: a */
    public static void m5411a(Location location) {
        Context c = C2505gd.m5298c();
        if (c == null || location == null) {
            f5560m = location;
            return;
        }
        C2494fy.m5249a(c, "user_info_store").mo28439a("user_location", m5414b(location));
    }

    /* renamed from: c */
    public static HashMap<String, String> m5417c() {
        HashMap<String, String> hashMap = new HashMap<>();
        int i = f5548a;
        int i2 = Integer.MIN_VALUE;
        String str = "user_info_store";
        if (i == Integer.MIN_VALUE) {
            Context c = C2505gd.m5298c();
            if (c == null) {
                i = Integer.MIN_VALUE;
            } else {
                i = C2494fy.m5249a(c, str).mo28444c("user_age");
            }
        }
        if (i > 0) {
            hashMap.put("u-age", String.valueOf(i));
        }
        int i3 = f5555h;
        if (i3 != Integer.MIN_VALUE) {
            i2 = i3;
        } else {
            Context c2 = C2505gd.m5298c();
            if (c2 != null) {
                i2 = C2494fy.m5249a(c2, str).mo28444c("user_yob");
            }
        }
        if (i2 > 0) {
            hashMap.put("u-yearofbirth", String.valueOf(i2));
        }
        String str2 = f5552e;
        String str3 = null;
        if (str2 == null) {
            Context c3 = C2505gd.m5298c();
            if (c3 == null) {
                str2 = null;
            } else {
                str2 = C2494fy.m5249a(c3, str).mo28442b("user_city_code");
            }
        }
        String str4 = f5553f;
        if (str4 == null) {
            Context c4 = C2505gd.m5298c();
            if (c4 == null) {
                str4 = null;
            } else {
                str4 = C2494fy.m5249a(c4, str).mo28442b("user_state_code");
            }
        }
        String str5 = f5554g;
        if (str5 == null) {
            Context c5 = C2505gd.m5298c();
            if (c5 == null) {
                str5 = null;
            } else {
                str5 = C2494fy.m5249a(c5, str).mo28442b("user_country_code");
            }
        }
        String trim = (str2 == null || str2.trim().length() == 0) ? "" : str2.trim();
        String str6 = "-";
        if (!(str4 == null || str4.trim().length() == 0)) {
            StringBuilder sb = new StringBuilder();
            sb.append(trim);
            sb.append(str6);
            sb.append(str4.trim());
            trim = sb.toString();
        }
        if (!(str5 == null || str5.trim().length() == 0)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(trim);
            sb2.append(str6);
            sb2.append(str5.trim());
            trim = sb2.toString();
        }
        if (!(trim == null || trim.trim().length() == 0)) {
            hashMap.put("u-location", trim);
        }
        String str7 = f5549b;
        if (str7 == null) {
            Context c6 = C2505gd.m5298c();
            if (c6 == null) {
                str7 = null;
            } else {
                str7 = C2494fy.m5249a(c6, str).mo28442b("user_age_group");
            }
        }
        if (str7 != null) {
            hashMap.put("u-agegroup", str7.toLowerCase(Locale.ENGLISH));
        }
        String str8 = f5550c;
        if (str8 == null) {
            Context c7 = C2505gd.m5298c();
            if (c7 == null) {
                str8 = null;
            } else {
                str8 = C2494fy.m5249a(c7, str).mo28442b("user_area_code");
            }
        }
        if (str8 != null) {
            hashMap.put("u-areacode", str8);
        }
        String str9 = f5551d;
        if (str9 == null) {
            Context c8 = C2505gd.m5298c();
            if (c8 == null) {
                str9 = null;
            } else {
                str9 = C2494fy.m5249a(c8, str).mo28442b("user_post_code");
            }
        }
        if (str9 != null) {
            hashMap.put("u-postalcode", str9);
        }
        String str10 = f5556i;
        if (str10 == null) {
            Context c9 = C2505gd.m5298c();
            if (c9 == null) {
                str10 = null;
            } else {
                str10 = C2494fy.m5249a(c9, str).mo28442b("user_gender");
            }
        }
        if (str10 != null) {
            hashMap.put("u-gender", str10);
        }
        String str11 = f5557j;
        if (str11 == null) {
            Context c10 = C2505gd.m5298c();
            if (c10 == null) {
                str11 = null;
            } else {
                str11 = C2494fy.m5249a(c10, str).mo28442b("user_education");
            }
        }
        if (str11 != null) {
            hashMap.put("u-education", str11);
        }
        String str12 = f5558k;
        if (str12 == null) {
            Context c11 = C2505gd.m5298c();
            if (c11 == null) {
                str12 = null;
            } else {
                str12 = C2494fy.m5249a(c11, str).mo28442b("user_language");
            }
        }
        if (str12 != null) {
            hashMap.put("u-language", str12);
        }
        String str13 = f5559l;
        if (str13 != null) {
            str3 = str13;
        } else {
            Context c12 = C2505gd.m5298c();
            if (c12 != null) {
                str3 = C2494fy.m5249a(c12, str).mo28442b("user_interest");
            }
        }
        if (str3 != null) {
            hashMap.put("u-interests", str3);
        }
        return hashMap;
    }

    /* renamed from: b */
    private static String m5414b(Location location) {
        StringBuilder sb = new StringBuilder();
        sb.append(location.getLatitude());
        String str = ",";
        sb.append(str);
        sb.append(location.getLongitude());
        sb.append(str);
        sb.append((int) location.getAccuracy());
        sb.append(str);
        sb.append(location.getTime());
        return sb.toString();
    }
}
