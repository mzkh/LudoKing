package com.applovin.impl.p005a;

import android.net.Uri;
import android.webkit.URLUtil;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.C1227o;
import com.applovin.impl.sdk.network.C1222f;
import com.applovin.impl.sdk.utils.C1277l;
import com.applovin.impl.sdk.utils.C1281o;
import com.applovin.impl.sdk.utils.C1283q;
import com.applovin.sdk.AppLovinAdLoadListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.a.i */
public class C0782i {

    /* renamed from: a */
    private static DateFormat f1293a = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.US);

    /* renamed from: b */
    private static Random f1294b = new Random(System.currentTimeMillis());

    /* renamed from: a */
    public static Uri m1072a(String str, long j, Uri uri, C0776d dVar, C1192i iVar) {
        String str2 = "VastUtils";
        if (URLUtil.isValidUrl(str)) {
            try {
                String replace = str.replace("[ERRORCODE]", Integer.toString(dVar.mo8929a()));
                if (j >= 0) {
                    replace = replace.replace("[CONTENTPLAYHEAD]", m1075a(j));
                }
                if (uri != null) {
                    replace = replace.replace("[ASSETURI]", uri.toString());
                }
                return Uri.parse(replace.replace("[CACHEBUSTING]", m1074a()).replace("[TIMESTAMP]", m1087b()));
            } catch (Throwable th) {
                C1227o v = iVar.mo10249v();
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to replace macros in URL string ");
                sb.append(str);
                v.mo10379b(str2, sb.toString(), th);
                return null;
            }
        } else {
            iVar.mo10249v().mo10382e(str2, "Unable to replace macros in invalid URL string.");
            return null;
        }
    }

    /* renamed from: a */
    public static C0776d m1073a(C0769a aVar) {
        if (m1088b(aVar) || m1090c(aVar)) {
            return null;
        }
        return C0776d.GENERAL_WRAPPER_ERROR;
    }

    /* renamed from: a */
    private static String m1074a() {
        return Integer.toString(f1294b.nextInt(89999999) + 10000000);
    }

    /* renamed from: a */
    private static String m1075a(long j) {
        if (j <= 0) {
            return "00:00:00.000";
        }
        long hours = TimeUnit.SECONDS.toHours(j);
        long minutes = TimeUnit.SECONDS.toMinutes(j) % TimeUnit.MINUTES.toSeconds(1);
        long seconds = j % TimeUnit.MINUTES.toSeconds(1);
        return String.format(Locale.US, "%02d:%02d:%02d.000", new Object[]{Long.valueOf(hours), Long.valueOf(minutes), Long.valueOf(seconds)});
    }

    /* renamed from: a */
    public static String m1076a(C0775c cVar) {
        if (cVar != null) {
            List b = cVar.mo8921b();
            int size = cVar.mo8921b().size();
            if (size > 0) {
                C1283q c = ((C1283q) b.get(size - 1)).mo10451c("VASTAdTagURI");
                if (c != null) {
                    return c.mo10452c();
                }
            }
            return null;
        }
        throw new IllegalArgumentException("Unable to get resolution uri string for fetching the next wrapper or inline response in the chain");
    }

    /* renamed from: a */
    public static String m1077a(C1283q qVar, String str, String str2) {
        C1283q b = qVar.mo10449b(str);
        if (b != null) {
            String c = b.mo10452c();
            if (C1277l.m3042b(c)) {
                return c;
            }
        }
        return str2;
    }

    /* renamed from: a */
    private static Set<C0780g> m1078a(C0775c cVar, C1192i iVar) {
        if (cVar == null) {
            return null;
        }
        List<C1283q> b = cVar.mo8921b();
        Set<C0780g> hashSet = new HashSet<>(b.size());
        for (C1283q qVar : b) {
            C1283q c = qVar.mo10451c("Wrapper");
            if (c == null) {
                c = qVar.mo10451c("InLine");
            }
            String str = "Error";
            hashSet = m1079a(hashSet, c != null ? c.mo10448a(str) : qVar.mo10448a(str), cVar, iVar);
        }
        C1227o v = iVar.mo10249v();
        StringBuilder sb = new StringBuilder();
        sb.append("Retrieved ");
        sb.append(hashSet.size());
        sb.append(" top level error trackers: ");
        sb.append(hashSet);
        v.mo10378b("VastUtils", sb.toString());
        return hashSet;
    }

    /* renamed from: a */
    private static Set<C0780g> m1079a(Set<C0780g> set, List<C1283q> list, C0775c cVar, C1192i iVar) {
        if (list != null) {
            for (C1283q a : list) {
                C0780g a2 = C0780g.m1068a(a, cVar, iVar);
                if (a2 != null) {
                    set.add(a2);
                }
            }
        }
        return set;
    }

    /* renamed from: a */
    public static void m1080a(C0775c cVar, AppLovinAdLoadListener appLovinAdLoadListener, C0776d dVar, int i, C1192i iVar) {
        if (iVar != null) {
            C1281o.m3082a(appLovinAdLoadListener, cVar.mo8926g(), i, iVar);
            m1084a(m1078a(cVar, iVar), dVar, iVar);
            return;
        }
        throw new IllegalArgumentException("Unable to handle failure. No sdk specified.");
    }

    /* renamed from: a */
    public static void m1081a(C1283q qVar, Map<String, Set<C0780g>> map, C0775c cVar, C1192i iVar) {
        C1227o v;
        String str;
        if (iVar != null) {
            String str2 = "VastUtils";
            if (qVar == null) {
                v = iVar.mo10249v();
                str = "Unable to render event trackers; null node provided";
            } else if (map == null) {
                v = iVar.mo10249v();
                str = "Unable to render event trackers; null event trackers provided";
            } else {
                C1283q b = qVar.mo10449b("TrackingEvents");
                if (b != null) {
                    List<C1283q> a = b.mo10448a("Tracking");
                    if (a != null) {
                        for (C1283q qVar2 : a) {
                            String str3 = (String) qVar2.mo10450b().get("event");
                            if (C1277l.m3042b(str3)) {
                                C0780g a2 = C0780g.m1068a(qVar2, cVar, iVar);
                                if (a2 != null) {
                                    Set set = (Set) map.get(str3);
                                    if (set != null) {
                                        set.add(a2);
                                    } else {
                                        HashSet hashSet = new HashSet();
                                        hashSet.add(a2);
                                        map.put(str3, hashSet);
                                    }
                                }
                            } else {
                                C1227o v2 = iVar.mo10249v();
                                StringBuilder sb = new StringBuilder();
                                sb.append("Could not find event for tracking node = ");
                                sb.append(qVar2);
                                v2.mo10382e(str2, sb.toString());
                            }
                        }
                    }
                }
                return;
            }
            v.mo10382e(str2, str);
            return;
        }
        throw new IllegalArgumentException("Unable to render event trackers. No sdk specified.");
    }

    /* renamed from: a */
    public static void m1082a(List<C1283q> list, Set<C0780g> set, C0775c cVar, C1192i iVar) {
        C1227o v;
        String str;
        if (iVar != null) {
            String str2 = "VastUtils";
            if (list == null) {
                v = iVar.mo10249v();
                str = "Unable to render trackers; null nodes provided";
            } else if (set == null) {
                v = iVar.mo10249v();
                str = "Unable to render trackers; null trackers provided";
            } else {
                for (C1283q a : list) {
                    C0780g a2 = C0780g.m1068a(a, cVar, iVar);
                    if (a2 != null) {
                        set.add(a2);
                    }
                }
                return;
            }
            v.mo10382e(str2, str);
            return;
        }
        throw new IllegalArgumentException("Unable to render trackers. No sdk specified.");
    }

    /* renamed from: a */
    public static void m1083a(Set<C0780g> set, long j, Uri uri, C0776d dVar, C1192i iVar) {
        if (iVar == null) {
            throw new IllegalArgumentException("Unable to fire trackers. No sdk specified.");
        } else if (set != null && !set.isEmpty()) {
            for (C0780g b : set) {
                Uri a = m1072a(b.mo8943b(), j, uri, dVar, iVar);
                if (a != null) {
                    iVar.mo10188N().mo10339a(C1222f.m2788k().mo10355a(a.toString()).mo10357a(false).mo10358a(), false);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m1084a(Set<C0780g> set, C0776d dVar, C1192i iVar) {
        m1083a(set, -1, (Uri) null, dVar, iVar);
    }

    /* renamed from: a */
    public static void m1085a(Set<C0780g> set, C1192i iVar) {
        m1083a(set, -1, (Uri) null, C0776d.UNSPECIFIED, iVar);
    }

    /* renamed from: a */
    public static boolean m1086a(C1283q qVar) {
        if (qVar != null) {
            return qVar.mo10451c("Wrapper") != null;
        }
        throw new IllegalArgumentException("Unable to check if a given XmlNode contains a wrapper response");
    }

    /* renamed from: b */
    private static String m1087b() {
        f1293a.setTimeZone(TimeZone.getDefault());
        return f1293a.format(new Date());
    }

    /* renamed from: b */
    public static boolean m1088b(C0769a aVar) {
        boolean z = false;
        if (aVar == null) {
            return false;
        }
        C0783j h = aVar.mo8892h();
        if (h != null) {
            List a = h.mo8948a();
            if (a != null && !a.isEmpty()) {
                z = true;
            }
        }
        return z;
    }

    /* renamed from: b */
    public static boolean m1089b(C1283q qVar) {
        if (qVar != null) {
            return qVar.mo10451c("InLine") != null;
        }
        throw new IllegalArgumentException("Unable to check if a given XmlNode contains an inline response");
    }

    /* renamed from: c */
    public static boolean m1090c(C0769a aVar) {
        boolean z = false;
        if (aVar == null) {
            return false;
        }
        C0774b j = aVar.mo8896j();
        if (j != null) {
            C0777e b = j.mo8914b();
            if (b != null && (b.mo8933b() != null || C1277l.m3042b(b.mo8934c()))) {
                z = true;
            }
        }
        return z;
    }
}
