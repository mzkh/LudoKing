package com.inmobi.media;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.bo */
/* compiled from: NativeTracker */
public class C2234bo {

    /* renamed from: g */
    private static final String f4627g = "bo";

    /* renamed from: a */
    protected String f4628a;

    /* renamed from: b */
    public String f4629b;

    /* renamed from: c */
    protected int f4630c;

    /* renamed from: d */
    public String f4631d;

    /* renamed from: e */
    public Map<String, String> f4632e;

    /* renamed from: f */
    public Map<String, Object> f4633f;

    public C2234bo(String str, int i, String str2, Map<String, String> map) {
        this("url_ping", str, i, str2, map);
    }

    public C2234bo(String str, String str2, int i, String str3, Map<String, String> map) {
        this.f4632e = new HashMap();
        this.f4628a = str;
        this.f4629b = str2.trim();
        this.f4630c = i;
        this.f4631d = str3;
        this.f4632e = map;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x013d, code lost:
        return r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x013e, code lost:
        return r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0141, code lost:
        return "page_view";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0144, code lost:
        return "VideoImpression";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0147, code lost:
        return "Impression";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0148, code lost:
        return r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0149, code lost:
        return r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0033, code lost:
        r3 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0106, code lost:
        r3 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x011f, code lost:
        r0 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0120, code lost:
        switch(r0) {
            case 2: goto L_0x0149;
            case 3: goto L_0x0148;
            case 4: goto L_0x0145;
            case 5: goto L_0x0142;
            case 6: goto L_0x013f;
            case 7: goto L_0x013e;
            case 8: goto L_0x013d;
            case 9: goto L_0x013a;
            case 10: goto L_0x0139;
            case 11: goto L_0x0138;
            case 12: goto L_0x0137;
            case 13: goto L_0x0134;
            case 14: goto L_0x0133;
            case 15: goto L_0x0130;
            case 16: goto L_0x012f;
            case 17: goto L_0x012e;
            case 18: goto L_0x012d;
            case 19: goto L_0x012c;
            case 20: goto L_0x012b;
            case 21: goto L_0x0128;
            case 22: goto L_0x0127;
            case 23: goto L_0x0124;
            default: goto L_0x0123;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0123, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0126, code lost:
        return "closeEndCard";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0127, code lost:
        return r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x012a, code lost:
        return "OMID_VIEWABILITY";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x012b, code lost:
        return r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x012c, code lost:
        return r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x012d, code lost:
        return r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x012e, code lost:
        return r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x012f, code lost:
        return r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0132, code lost:
        return "exitFullscreen";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0133, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0136, code lost:
        return "creativeView";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0137, code lost:
        return r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0138, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0139, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x013c, code lost:
        return com.tapjoy.TJAdUnitConstants.String.VIDEO_FIRST_QUARTILE;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m4553a(java.lang.String r17) {
        /*
            r0 = r17
            java.lang.String r1 = "unknown"
            if (r0 == 0) goto L_0x014a
            int r2 = r17.length()
            if (r2 != 0) goto L_0x000e
            goto L_0x014a
        L_0x000e:
            int r3 = r17.hashCode()
            java.lang.String r4 = "fullscreen"
            java.lang.String r5 = "start"
            java.lang.String r6 = "pause"
            java.lang.String r7 = "error"
            java.lang.String r8 = "click"
            java.lang.String r9 = "mute"
            java.lang.String r10 = "load"
            java.lang.String r11 = "client_fill"
            java.lang.String r12 = "complete"
            java.lang.String r13 = "zMoatVASTIDs"
            java.lang.String r14 = "unmute"
            java.lang.String r15 = "resume"
            java.lang.String r2 = "thirdQuartile"
            r16 = r2
            java.lang.String r2 = "midpoint"
            switch(r3) {
                case -1638835128: goto L_0x0114;
                case -1337830390: goto L_0x0109;
                case -934426579: goto L_0x00fe;
                case -840405966: goto L_0x00f5;
                case -667101923: goto L_0x00ec;
                case -599445191: goto L_0x00e3;
                case -284840886: goto L_0x00db;
                case -174104201: goto L_0x00d3;
                case 3327206: goto L_0x00cb;
                case 3363353: goto L_0x00c2;
                case 94750088: goto L_0x00ba;
                case 96784904: goto L_0x00b1;
                case 106440182: goto L_0x00a8;
                case 109757538: goto L_0x009e;
                case 110066619: goto L_0x0094;
                case 113951609: goto L_0x0088;
                case 354294980: goto L_0x007d;
                case 368426751: goto L_0x0071;
                case 560220243: goto L_0x0065;
                case 883937877: goto L_0x005a;
                case 1342121331: goto L_0x004e;
                case 1778167540: goto L_0x0042;
                case 2114088489: goto L_0x0037;
                default: goto L_0x0033;
            }
        L_0x0033:
            r3 = r16
            goto L_0x011f
        L_0x0037:
            java.lang.String r3 = "Impression"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0033
            r0 = 4
            goto L_0x0106
        L_0x0042:
            java.lang.String r3 = "creativeView"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0033
            r0 = 13
            goto L_0x0106
        L_0x004e:
            java.lang.String r3 = "closeEndCard"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0033
            r0 = 23
            goto L_0x0106
        L_0x005a:
            java.lang.String r3 = "page_view"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0033
            r0 = 6
            goto L_0x0106
        L_0x0065:
            java.lang.String r3 = "firstQuartile"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0033
            r0 = 9
            goto L_0x0106
        L_0x0071:
            java.lang.String r3 = "OMID_VIEWABILITY"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0033
            r0 = 21
            goto L_0x0106
        L_0x007d:
            java.lang.String r3 = "VideoImpression"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0033
            r0 = 5
            goto L_0x0106
        L_0x0088:
            java.lang.String r3 = "exitFullscreen"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0033
            r0 = 15
            goto L_0x0106
        L_0x0094:
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x0033
            r0 = 14
            goto L_0x0106
        L_0x009e:
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L_0x0033
            r0 = 8
            goto L_0x0106
        L_0x00a8:
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x0033
            r0 = 18
            goto L_0x0106
        L_0x00b1:
            boolean r0 = r0.equals(r7)
            if (r0 == 0) goto L_0x0033
            r0 = 20
            goto L_0x0106
        L_0x00ba:
            boolean r0 = r0.equals(r8)
            if (r0 == 0) goto L_0x0033
            r0 = 7
            goto L_0x0106
        L_0x00c2:
            boolean r0 = r0.equals(r9)
            if (r0 == 0) goto L_0x0033
            r0 = 16
            goto L_0x0106
        L_0x00cb:
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L_0x0033
            r0 = 2
            goto L_0x0106
        L_0x00d3:
            boolean r0 = r0.equals(r11)
            if (r0 == 0) goto L_0x0033
            r0 = 3
            goto L_0x0106
        L_0x00db:
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0033
            r0 = 1
            goto L_0x0106
        L_0x00e3:
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x0033
            r0 = 12
            goto L_0x0106
        L_0x00ec:
            boolean r0 = r0.equals(r13)
            if (r0 == 0) goto L_0x0033
            r0 = 22
            goto L_0x0106
        L_0x00f5:
            boolean r0 = r0.equals(r14)
            if (r0 == 0) goto L_0x0033
            r0 = 17
            goto L_0x0106
        L_0x00fe:
            boolean r0 = r0.equals(r15)
            if (r0 == 0) goto L_0x0033
            r0 = 19
        L_0x0106:
            r3 = r16
            goto L_0x0120
        L_0x0109:
            r3 = r16
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x011f
            r0 = 11
            goto L_0x0120
        L_0x0114:
            r3 = r16
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x011f
            r0 = 10
            goto L_0x0120
        L_0x011f:
            r0 = -1
        L_0x0120:
            switch(r0) {
                case 2: goto L_0x0149;
                case 3: goto L_0x0148;
                case 4: goto L_0x0145;
                case 5: goto L_0x0142;
                case 6: goto L_0x013f;
                case 7: goto L_0x013e;
                case 8: goto L_0x013d;
                case 9: goto L_0x013a;
                case 10: goto L_0x0139;
                case 11: goto L_0x0138;
                case 12: goto L_0x0137;
                case 13: goto L_0x0134;
                case 14: goto L_0x0133;
                case 15: goto L_0x0130;
                case 16: goto L_0x012f;
                case 17: goto L_0x012e;
                case 18: goto L_0x012d;
                case 19: goto L_0x012c;
                case 20: goto L_0x012b;
                case 21: goto L_0x0128;
                case 22: goto L_0x0127;
                case 23: goto L_0x0124;
                default: goto L_0x0123;
            }
        L_0x0123:
            return r1
        L_0x0124:
            java.lang.String r0 = "closeEndCard"
            return r0
        L_0x0127:
            return r13
        L_0x0128:
            java.lang.String r0 = "OMID_VIEWABILITY"
            return r0
        L_0x012b:
            return r7
        L_0x012c:
            return r15
        L_0x012d:
            return r6
        L_0x012e:
            return r14
        L_0x012f:
            return r9
        L_0x0130:
            java.lang.String r0 = "exitFullscreen"
            return r0
        L_0x0133:
            return r4
        L_0x0134:
            java.lang.String r0 = "creativeView"
            return r0
        L_0x0137:
            return r12
        L_0x0138:
            return r3
        L_0x0139:
            return r2
        L_0x013a:
            java.lang.String r0 = "firstQuartile"
            return r0
        L_0x013d:
            return r5
        L_0x013e:
            return r8
        L_0x013f:
            java.lang.String r0 = "page_view"
            return r0
        L_0x0142:
            java.lang.String r0 = "VideoImpression"
            return r0
        L_0x0145:
            java.lang.String r0 = "Impression"
            return r0
        L_0x0148:
            return r11
        L_0x0149:
            return r10
        L_0x014a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2234bo.m4553a(java.lang.String):java.lang.String");
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.f4628a);
            jSONObject.put("url", this.f4629b);
            jSONObject.put("eventType", this.f4631d);
            jSONObject.put("eventId", this.f4630c);
            jSONObject.put("extras", C2515gi.m5348a(this.f4632e == null ? new HashMap<>() : this.f4632e, ","));
            return jSONObject.toString();
        } catch (JSONException e) {
            C2463fd.m5161a().mo28382a(new C2495fz(e));
            return "";
        }
    }
}
