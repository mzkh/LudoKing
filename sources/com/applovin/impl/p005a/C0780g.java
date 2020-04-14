package com.applovin.impl.p005a;

import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.C1227o;
import com.applovin.impl.sdk.utils.C1243d;
import com.applovin.impl.sdk.utils.C1277l;
import com.applovin.impl.sdk.utils.C1283q;
import com.tapjoy.TJAdUnitConstants.String;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.a.g */
public class C0780g {

    /* renamed from: a */
    private String f1287a;

    /* renamed from: b */
    private String f1288b;

    /* renamed from: c */
    private String f1289c;

    /* renamed from: d */
    private long f1290d = -1;

    /* renamed from: e */
    private int f1291e = -1;

    private C0780g() {
    }

    /* renamed from: a */
    private static int m1067a(String str, C0775c cVar) {
        if (String.VIDEO_START.equalsIgnoreCase(str)) {
            return 0;
        }
        if (String.VIDEO_FIRST_QUARTILE.equalsIgnoreCase(str)) {
            return 25;
        }
        if (String.VIDEO_MIDPOINT.equalsIgnoreCase(str)) {
            return 50;
        }
        if (String.VIDEO_THIRD_QUARTILE.equalsIgnoreCase(str)) {
            return 75;
        }
        if (!String.VIDEO_COMPLETE.equalsIgnoreCase(str)) {
            return -1;
        }
        return cVar != null ? cVar.mo8928i() : 95;
    }

    /* renamed from: a */
    public static C0780g m1068a(C1283q qVar, C0775c cVar, C1192i iVar) {
        TimeUnit timeUnit;
        long seconds;
        String str = ":";
        String str2 = "VastTracker";
        if (qVar == null) {
            throw new IllegalArgumentException("No node specified.");
        } else if (iVar != null) {
            try {
                String c = qVar.mo10452c();
                if (C1277l.m3042b(c)) {
                    C0780g gVar = new C0780g();
                    gVar.f1289c = c;
                    gVar.f1287a = (String) qVar.mo10450b().get("id");
                    gVar.f1288b = (String) qVar.mo10450b().get("event");
                    gVar.f1291e = m1067a(gVar.mo8941a(), cVar);
                    String str3 = (String) qVar.mo10450b().get("offset");
                    if (C1277l.m3042b(str3)) {
                        String trim = str3.trim();
                        if (trim.contains("%")) {
                            gVar.f1291e = C1277l.m3031a(trim.substring(0, trim.length() - 1));
                        } else if (trim.contains(str)) {
                            List a = C1243d.m2925a(trim, str);
                            int size = a.size();
                            if (size > 0) {
                                long j = 0;
                                int i = size - 1;
                                for (int i2 = i; i2 >= 0; i2--) {
                                    String str4 = (String) a.get(i2);
                                    if (C1277l.m3043c(str4)) {
                                        int parseInt = Integer.parseInt(str4);
                                        if (i2 == i) {
                                            seconds = (long) parseInt;
                                        } else {
                                            if (i2 == size - 2) {
                                                timeUnit = TimeUnit.MINUTES;
                                            } else if (i2 == size - 3) {
                                                timeUnit = TimeUnit.HOURS;
                                            }
                                            seconds = timeUnit.toSeconds((long) parseInt);
                                        }
                                        j += seconds;
                                    }
                                }
                                gVar.f1290d = j;
                                gVar.f1291e = -1;
                            }
                        } else {
                            C1227o v = iVar.mo10249v();
                            StringBuilder sb = new StringBuilder();
                            sb.append("Unable to parse time offset from rawOffsetString = ");
                            sb.append(trim);
                            v.mo10382e(str2, sb.toString());
                        }
                    }
                    return gVar;
                }
                iVar.mo10249v().mo10382e(str2, "Unable to create tracker. Could not find URL.");
                return null;
            } catch (Throwable th) {
                iVar.mo10249v().mo10379b(str2, "Error occurred while initializing", th);
            }
        } else {
            throw new IllegalArgumentException("No sdk specified.");
        }
    }

    /* renamed from: a */
    public String mo8941a() {
        return this.f1288b;
    }

    /* renamed from: a */
    public boolean mo8942a(long j, int i) {
        boolean z = this.f1290d >= 0;
        boolean z2 = j >= this.f1290d;
        boolean z3 = this.f1291e >= 0;
        boolean z4 = i >= this.f1291e;
        if (!z || !z2) {
            return z3 && z4;
        }
        return true;
    }

    /* renamed from: b */
    public String mo8943b() {
        return this.f1289c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0780g)) {
            return false;
        }
        C0780g gVar = (C0780g) obj;
        if (this.f1290d != gVar.f1290d || this.f1291e != gVar.f1291e) {
            return false;
        }
        String str = this.f1287a;
        if (str == null ? gVar.f1287a != null : !str.equals(gVar.f1287a)) {
            return false;
        }
        String str2 = this.f1288b;
        if (str2 == null ? gVar.f1288b == null : str2.equals(gVar.f1288b)) {
            return this.f1289c.equals(gVar.f1289c);
        }
        return false;
    }

    public int hashCode() {
        String str = this.f1287a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f1288b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        int hashCode2 = (((hashCode + i) * 31) + this.f1289c.hashCode()) * 31;
        long j = this.f1290d;
        return ((hashCode2 + ((int) (j ^ (j >>> 32)))) * 31) + this.f1291e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VastTracker{identifier='");
        sb.append(this.f1287a);
        sb.append('\'');
        sb.append(", event='");
        sb.append(this.f1288b);
        sb.append('\'');
        sb.append(", uriString='");
        sb.append(this.f1289c);
        sb.append('\'');
        sb.append(", offsetSeconds=");
        sb.append(this.f1290d);
        sb.append(", offsetPercent=");
        sb.append(this.f1291e);
        sb.append('}');
        return sb.toString();
    }
}
