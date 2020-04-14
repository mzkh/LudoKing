package com.inmobi.media;

import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.annotation.NonNull;
import com.appsflyer.share.Constants;
import com.inmobi.media.C2426eq.C2428b;
import com.inmobi.media.C2426eq.C2434h;
import com.tapjoy.TJAdUnitConstants.String;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* renamed from: com.inmobi.media.cn */
/* compiled from: VastParser */
public class C2290cn {

    /* renamed from: a */
    private static final String f4823a = "cn";

    /* renamed from: f */
    private static final Map<String, String> f4824f;

    /* renamed from: b */
    private C2296cq f4825b = new C2296cq(this.f4826c);

    /* renamed from: c */
    private C2434h f4826c;

    /* renamed from: d */
    private boolean f4827d;

    /* renamed from: e */
    private int f4828e;

    /* renamed from: b */
    private static boolean m4650b(int i) {
        return i == 3;
    }

    static {
        HashMap hashMap = new HashMap();
        f4824f = hashMap;
        hashMap.put("Error", "error");
        String str = "Impression";
        f4824f.put(str, str);
        f4824f.put("ClickTracking", String.CLICK);
        String str2 = "creativeView";
        f4824f.put(str2, str2);
        Map<String, String> map = f4824f;
        String str3 = String.VIDEO_START;
        map.put(str3, str3);
        Map<String, String> map2 = f4824f;
        String str4 = String.VIDEO_FIRST_QUARTILE;
        map2.put(str4, str4);
        Map<String, String> map3 = f4824f;
        String str5 = String.VIDEO_MIDPOINT;
        map3.put(str5, str5);
        Map<String, String> map4 = f4824f;
        String str6 = String.VIDEO_THIRD_QUARTILE;
        map4.put(str6, str6);
        Map<String, String> map5 = f4824f;
        String str7 = String.VIDEO_COMPLETE;
        map5.put(str7, str7);
        String str8 = "mute";
        f4824f.put(str8, str8);
        String str9 = "unmute";
        f4824f.put(str9, str9);
        String str10 = "pause";
        f4824f.put(str10, str10);
        String str11 = "resume";
        f4824f.put(str11, str11);
        String str12 = "fullscreen";
        f4824f.put(str12, str12);
        String str13 = "exitFullscreen";
        f4824f.put(str13, str13);
        String str14 = "closeEndCard";
        f4824f.put(str14, str14);
    }

    public C2290cn(C2434h hVar) {
        this.f4826c = hVar;
    }

    /* renamed from: a */
    public final C2296cq mo28131a(String str) {
        String str2 = "Ad";
        String str3 = "VAST";
        String str4 = "InLine";
        String str5 = "Wrapper";
        try {
            if (TextUtils.isEmpty(str)) {
                m4641a(303);
                return this.f4825b;
            }
            XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
            newPullParser.setInput(new StringReader(str));
            String[] strArr = {str5, str4};
            m4643a(newPullParser, str3);
            if (m4647a(str3, newPullParser)) {
                m4643a(newPullParser, str2);
                if (m4647a(str2, newPullParser)) {
                    m4645a(newPullParser, strArr);
                    if (m4647a(str4, newPullParser)) {
                        m4648b(newPullParser);
                    } else if (m4647a(str5, newPullParser)) {
                        m4642a(newPullParser);
                    } else {
                        m4641a(101);
                    }
                } else {
                    m4641a(303);
                }
            } else {
                m4641a(101);
            }
            return this.f4825b;
        } catch (XmlPullParserException e) {
            m4641a(100);
            C2463fd.m5161a().mo28382a(new C2495fz(e));
        } catch (Exception e2) {
            m4641a(900);
            C2463fd.m5161a().mo28382a(new C2495fz(e2));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0142, code lost:
        continue;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m4642a(org.xmlpull.v1.XmlPullParser r11) {
        /*
            r10 = this;
            int r0 = r10.f4828e
            r1 = 1
            int r0 = r0 + r1
            r10.f4828e = r0
            int r0 = r10.f4828e
            com.inmobi.media.eq$h r2 = r10.f4826c
            int r2 = r2.f5226a
            if (r0 <= r2) goto L_0x0014
            r11 = 302(0x12e, float:4.23E-43)
            r10.m4641a(r11)
            return
        L_0x0014:
            int r0 = m4658i(r11)
            r2 = 0
            r3 = 0
            r4 = 0
        L_0x001b:
            java.lang.String r5 = r11.getName()
            r6 = 101(0x65, float:1.42E-43)
            if (r5 == 0) goto L_0x003e
            java.lang.String r5 = r11.getName()
            java.lang.String r7 = "Wrapper"
            boolean r5 = r5.equals(r7)
            if (r5 == 0) goto L_0x003e
            boolean r5 = m4650b(r0)
            if (r5 != 0) goto L_0x0036
            goto L_0x003e
        L_0x0036:
            if (r3 == 0) goto L_0x003a
            if (r4 != 0) goto L_0x003d
        L_0x003a:
            r10.m4641a(r6)
        L_0x003d:
            return
        L_0x003e:
            java.lang.String r5 = r11.getName()
            if (r5 == 0) goto L_0x0142
            boolean r0 = m4650b(r0)
            if (r0 != 0) goto L_0x0142
            java.lang.String r0 = r11.getName()
            r5 = -1
            int r7 = r0.hashCode()
            java.lang.String r8 = "Impression"
            r9 = 4
            switch(r7) {
                case -2077435339: goto L_0x0094;
                case -2049897434: goto L_0x008a;
                case -587420703: goto L_0x0080;
                case 67232232: goto L_0x0076;
                case 184043572: goto L_0x006c;
                case 611554000: goto L_0x0062;
                case 2114088489: goto L_0x005a;
                default: goto L_0x0059;
            }
        L_0x0059:
            goto L_0x009e
        L_0x005a:
            boolean r0 = r0.equals(r8)
            if (r0 == 0) goto L_0x009e
            r0 = 0
            goto L_0x009f
        L_0x0062:
            java.lang.String r7 = "TrackingEvents"
            boolean r0 = r0.equals(r7)
            if (r0 == 0) goto L_0x009e
            r0 = 3
            goto L_0x009f
        L_0x006c:
            java.lang.String r7 = "Extensions"
            boolean r0 = r0.equals(r7)
            if (r0 == 0) goto L_0x009e
            r0 = 6
            goto L_0x009f
        L_0x0076:
            java.lang.String r7 = "Error"
            boolean r0 = r0.equals(r7)
            if (r0 == 0) goto L_0x009e
            r0 = 1
            goto L_0x009f
        L_0x0080:
            java.lang.String r7 = "VASTAdTagURI"
            boolean r0 = r0.equals(r7)
            if (r0 == 0) goto L_0x009e
            r0 = 2
            goto L_0x009f
        L_0x008a:
            java.lang.String r7 = "VideoClicks"
            boolean r0 = r0.equals(r7)
            if (r0 == 0) goto L_0x009e
            r0 = 4
            goto L_0x009f
        L_0x0094:
            java.lang.String r7 = "AdVerifications"
            boolean r0 = r0.equals(r7)
            if (r0 == 0) goto L_0x009e
            r0 = 5
            goto L_0x009f
        L_0x009e:
            r0 = -1
        L_0x009f:
            switch(r0) {
                case 0: goto L_0x012b;
                case 1: goto L_0x011b;
                case 2: goto L_0x00b8;
                case 3: goto L_0x00b3;
                case 4: goto L_0x00ae;
                case 5: goto L_0x00a9;
                case 6: goto L_0x00a4;
                default: goto L_0x00a2;
            }
        L_0x00a2:
            goto L_0x0142
        L_0x00a4:
            r10.m4654e(r11)
            goto L_0x0142
        L_0x00a9:
            r10.m4656g(r11)
            goto L_0x0142
        L_0x00ae:
            r10.m4644a(r11, r2)
            goto L_0x0142
        L_0x00b3:
            r10.m4653d(r11)
            goto L_0x0142
        L_0x00b8:
            int r0 = m4658i(r11)
            if (r0 != r9) goto L_0x0117
            java.lang.String r0 = r11.getText()
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 == 0) goto L_0x00ca
            r0 = 0
            goto L_0x00ce
        L_0x00ca:
            java.lang.String r0 = r0.trim()
        L_0x00ce:
            r3 = 300(0x12c, float:4.2E-43)
            if (r0 != 0) goto L_0x00d6
            r10.m4641a(r3)
            return
        L_0x00d6:
            boolean r5 = android.webkit.URLUtil.isValidUrl(r0)
            if (r5 == 0) goto L_0x0106
            com.inmobi.media.fr r3 = new com.inmobi.media.fr
            java.lang.String r5 = "GET"
            r3.<init>(r5, r0)
            r3.f5444p = r2
            r3.f5450v = r2
            r3.f5443o = r1
            com.inmobi.media.ft r0 = new com.inmobi.media.ft
            r0.<init>(r3)
            com.inmobi.media.fs r0 = r0.mo28422a()
            boolean r3 = r0.mo28417a()
            if (r3 == 0) goto L_0x00fe
            r0 = 301(0x12d, float:4.22E-43)
            r10.m4641a(r0)
            goto L_0x0109
        L_0x00fe:
            java.lang.String r0 = r0.mo28418b()
            r10.mo28131a(r0)
            goto L_0x0109
        L_0x0106:
            r10.m4641a(r3)
        L_0x0109:
            com.inmobi.media.cq r0 = r10.f4825b
            int r0 = r0.f4846f
            if (r0 == 0) goto L_0x0111
            r0 = 1
            goto L_0x0112
        L_0x0111:
            r0 = 0
        L_0x0112:
            if (r0 == 0) goto L_0x0115
            return
        L_0x0115:
            r3 = 1
            goto L_0x0142
        L_0x0117:
            r10.m4641a(r6)
            return
        L_0x011b:
            int r0 = m4658i(r11)
            if (r0 != r9) goto L_0x0142
            java.lang.String r0 = r11.getText()
            java.lang.String r5 = "error"
            r10.m4646a(r5, r0)
            goto L_0x0142
        L_0x012b:
            int r0 = m4658i(r11)
            if (r0 != r9) goto L_0x013e
            java.lang.String r0 = r11.getText()
            boolean r0 = r10.m4646a(r8, r0)
            if (r0 != 0) goto L_0x013c
            goto L_0x013e
        L_0x013c:
            r4 = 1
            goto L_0x0142
        L_0x013e:
            r10.m4641a(r6)
            return
        L_0x0142:
            int r0 = m4658i(r11)
            goto L_0x001b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2290cn.m4642a(org.xmlpull.v1.XmlPullParser):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:302:0x049e, code lost:
        r16 = false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0186 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:306:0x04af  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x010e  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m4648b(org.xmlpull.v1.XmlPullParser r21) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            int r2 = m4658i(r21)
            r4 = 0
            r5 = 0
        L_0x000a:
            java.lang.String r6 = r21.getName()
            r7 = 101(0x65, float:1.42E-43)
            if (r6 == 0) goto L_0x002d
            java.lang.String r6 = r21.getName()
            java.lang.String r8 = "InLine"
            boolean r6 = r6.equals(r8)
            if (r6 == 0) goto L_0x002d
            boolean r6 = m4650b(r2)
            if (r6 != 0) goto L_0x0025
            goto L_0x002d
        L_0x0025:
            if (r4 == 0) goto L_0x0029
            if (r5 != 0) goto L_0x002c
        L_0x0029:
            r0.m4641a(r7)
        L_0x002c:
            return
        L_0x002d:
            java.lang.String r6 = r21.getName()
            r8 = 1
            if (r6 == 0) goto L_0x00c6
            boolean r2 = m4650b(r2)
            if (r2 != 0) goto L_0x00c6
            java.lang.String r2 = r21.getName()
            int r6 = r2.hashCode()
            java.lang.String r9 = "Impression"
            java.lang.String r10 = "Creatives"
            r12 = 3
            r13 = 2
            r14 = 4
            switch(r6) {
                case -2077435339: goto L_0x0071;
                case -1692490108: goto L_0x0069;
                case 67232232: goto L_0x005f;
                case 184043572: goto L_0x0055;
                case 2114088489: goto L_0x004d;
                default: goto L_0x004c;
            }
        L_0x004c:
            goto L_0x007b
        L_0x004d:
            boolean r2 = r2.equals(r9)
            if (r2 == 0) goto L_0x007b
            r2 = 0
            goto L_0x007c
        L_0x0055:
            java.lang.String r6 = "Extensions"
            boolean r2 = r2.equals(r6)
            if (r2 == 0) goto L_0x007b
            r2 = 4
            goto L_0x007c
        L_0x005f:
            java.lang.String r6 = "Error"
            boolean r2 = r2.equals(r6)
            if (r2 == 0) goto L_0x007b
            r2 = 1
            goto L_0x007c
        L_0x0069:
            boolean r2 = r2.equals(r10)
            if (r2 == 0) goto L_0x007b
            r2 = 2
            goto L_0x007c
        L_0x0071:
            java.lang.String r6 = "AdVerifications"
            boolean r2 = r2.equals(r6)
            if (r2 == 0) goto L_0x007b
            r2 = 3
            goto L_0x007c
        L_0x007b:
            r2 = -1
        L_0x007c:
            if (r2 == 0) goto L_0x04d4
            if (r2 == r8) goto L_0x04c6
            if (r2 == r13) goto L_0x008f
            if (r2 == r12) goto L_0x008b
            if (r2 == r14) goto L_0x0087
            goto L_0x00c6
        L_0x0087:
            r20.m4654e(r21)
            goto L_0x00c6
        L_0x008b:
            r20.m4656g(r21)
            goto L_0x00c6
        L_0x008f:
            int r2 = m4658i(r21)
            r4 = 0
            r6 = 0
            r9 = 0
        L_0x0096:
            java.lang.String r15 = r21.getName()
            if (r15 == 0) goto L_0x00c9
            java.lang.String r15 = r21.getName()
            boolean r15 = r15.equals(r10)
            if (r15 == 0) goto L_0x00c9
            boolean r15 = m4650b(r2)
            if (r15 != 0) goto L_0x00ad
            goto L_0x00c9
        L_0x00ad:
            if (r4 != 0) goto L_0x00b2
            r0.m4641a(r7)
        L_0x00b2:
            if (r6 != 0) goto L_0x00b9
            r2 = 201(0xc9, float:2.82E-43)
            r0.m4641a(r2)
        L_0x00b9:
            if (r4 == 0) goto L_0x00c1
            if (r6 == 0) goto L_0x00c1
            if (r9 == 0) goto L_0x00c1
            r2 = 1
            goto L_0x00c2
        L_0x00c1:
            r2 = 0
        L_0x00c2:
            if (r2 != 0) goto L_0x00c5
            return
        L_0x00c5:
            r4 = 1
        L_0x00c6:
            r13 = 0
            goto L_0x04ef
        L_0x00c9:
            java.lang.String r15 = r21.getName()
            if (r15 == 0) goto L_0x04b4
            boolean r2 = m4650b(r2)
            if (r2 != 0) goto L_0x04b4
            java.lang.String r2 = r21.getName()
            int r15 = r2.hashCode()
            r11 = -2018804923(0xffffffff87ab7b45, float:-2.5801672E-34)
            java.lang.String r7 = "CompanionAds"
            java.lang.String r3 = "Linear"
            if (r15 == r11) goto L_0x0103
            r11 = 1150879268(0x44990624, float:1224.1919)
            if (r15 == r11) goto L_0x00fb
            r11 = 1885066191(0x705bd3cf, float:2.7213311E29)
            if (r15 == r11) goto L_0x00f1
            goto L_0x010b
        L_0x00f1:
            java.lang.String r11 = "Creative"
            boolean r2 = r2.equals(r11)
            if (r2 == 0) goto L_0x010b
            r2 = 0
            goto L_0x010c
        L_0x00fb:
            boolean r2 = r2.equals(r7)
            if (r2 == 0) goto L_0x010b
            r2 = 2
            goto L_0x010c
        L_0x0103:
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x010b
            r2 = 1
            goto L_0x010c
        L_0x010b:
            r2 = -1
        L_0x010c:
            if (r2 == 0) goto L_0x04af
            java.lang.String r11 = "TrackingEvents"
            if (r2 == r8) goto L_0x03dd
            if (r2 == r13) goto L_0x0116
            goto L_0x04b4
        L_0x0116:
            int r2 = m4658i(r21)
            r3 = 0
        L_0x011b:
            java.lang.String r15 = r21.getName()
            if (r15 == 0) goto L_0x0152
            java.lang.String r15 = r21.getName()
            boolean r15 = r15.equals(r7)
            if (r15 == 0) goto L_0x0152
            boolean r15 = m4650b(r2)
            if (r15 != 0) goto L_0x0132
            goto L_0x0152
        L_0x0132:
            com.inmobi.media.cq r2 = r0.f4825b
            java.util.List<com.inmobi.media.ck> r2 = r2.f4845e
            int r2 = r2.size()
            if (r2 != 0) goto L_0x0147
            boolean r7 = r0.f4827d
            if (r7 == 0) goto L_0x0147
            r2 = 604(0x25c, float:8.46E-43)
            r0.m4651c(r2)
            goto L_0x04b4
        L_0x0147:
            if (r3 <= 0) goto L_0x04b4
            if (r2 != 0) goto L_0x04b4
            r2 = 600(0x258, float:8.41E-43)
            r0.m4651c(r2)
            goto L_0x04b4
        L_0x0152:
            java.lang.String r15 = r21.getName()
            if (r15 == 0) goto L_0x01c4
            java.lang.String r15 = r21.getName()
            java.lang.String r14 = "Companion"
            boolean r15 = r14.equals(r15)
            if (r15 == 0) goto L_0x01c4
            boolean r15 = m4650b(r2)
            if (r15 != 0) goto L_0x01c4
            int r3 = r3 + 1
            r15 = 0
            java.lang.String r12 = "width"
            java.lang.String r12 = r1.getAttributeValue(r15, r12)     // Catch:{ Exception -> 0x0182 }
            int r12 = java.lang.Integer.parseInt(r12)     // Catch:{ Exception -> 0x0182 }
            java.lang.String r13 = "height"
            java.lang.String r13 = r1.getAttributeValue(r15, r13)     // Catch:{ Exception -> 0x0183 }
            int r13 = java.lang.Integer.parseInt(r13)     // Catch:{ Exception -> 0x0183 }
            goto L_0x0184
        L_0x0182:
            r12 = 0
        L_0x0183:
            r13 = 0
        L_0x0184:
            if (r12 <= 0) goto L_0x03c5
            if (r13 > 0) goto L_0x018a
            goto L_0x03c5
        L_0x018a:
            java.lang.String r8 = "ID"
            java.lang.String r8 = r1.getAttributeValue(r15, r8)
            r17 = r2
            com.inmobi.media.ck r2 = new com.inmobi.media.ck
            r2.<init>(r12, r13, r15, r8)
            int r8 = m4658i(r21)
            r12 = r15
        L_0x019c:
            java.lang.String r13 = r21.getName()
            if (r13 == 0) goto L_0x01cd
            java.lang.String r13 = r21.getName()
            boolean r13 = r13.equals(r14)
            if (r13 == 0) goto L_0x01cd
            boolean r13 = m4650b(r8)
            if (r13 != 0) goto L_0x01b3
            goto L_0x01cd
        L_0x01b3:
            java.util.List<com.inmobi.media.ck$a> r8 = r2.f4798c
            if (r8 == 0) goto L_0x01c9
            int r8 = r8.size()
            if (r8 == 0) goto L_0x01c9
            com.inmobi.media.cq r8 = r0.f4825b
            java.util.List<com.inmobi.media.ck> r8 = r8.f4845e
            r8.add(r2)
        L_0x01c4:
            r19 = r4
            r13 = 0
            goto L_0x03d1
        L_0x01c9:
            r2 = r17
            goto L_0x03d7
        L_0x01cd:
            java.lang.String r13 = r21.getName()
            if (r13 == 0) goto L_0x03b5
            boolean r8 = m4650b(r8)
            if (r8 != 0) goto L_0x03b5
            java.lang.String r8 = r21.getName()
            int r13 = r8.hashCode()
            r15 = 5
            switch(r13) {
                case -375340334: goto L_0x0216;
                case -348198615: goto L_0x020c;
                case 611554000: goto L_0x0204;
                case 676623548: goto L_0x01fa;
                case 1877773523: goto L_0x01f0;
                case 1928285401: goto L_0x01e6;
                default: goto L_0x01e5;
            }
        L_0x01e5:
            goto L_0x0220
        L_0x01e6:
            java.lang.String r13 = "HTMLResource"
            boolean r8 = r8.equals(r13)
            if (r8 == 0) goto L_0x0220
            r8 = 1
            goto L_0x0221
        L_0x01f0:
            java.lang.String r13 = "CompanionClickTracking"
            boolean r8 = r8.equals(r13)
            if (r8 == 0) goto L_0x0220
            r8 = 3
            goto L_0x0221
        L_0x01fa:
            java.lang.String r13 = "StaticResource"
            boolean r8 = r8.equals(r13)
            if (r8 == 0) goto L_0x0220
            r8 = 0
            goto L_0x0221
        L_0x0204:
            boolean r8 = r8.equals(r11)
            if (r8 == 0) goto L_0x0220
            r8 = 5
            goto L_0x0221
        L_0x020c:
            java.lang.String r13 = "CompanionClickThrough"
            boolean r8 = r8.equals(r13)
            if (r8 == 0) goto L_0x0220
            r8 = 4
            goto L_0x0221
        L_0x0216:
            java.lang.String r13 = "IFrameResource"
            boolean r8 = r8.equals(r13)
            if (r8 == 0) goto L_0x0220
            r8 = 2
            goto L_0x0221
        L_0x0220:
            r8 = -1
        L_0x0221:
            if (r8 == 0) goto L_0x0357
            r13 = 1
            if (r8 == r13) goto L_0x0337
            r13 = 2
            if (r8 == r13) goto L_0x0316
            r13 = 3
            if (r8 == r13) goto L_0x02e4
            r13 = 4
            if (r8 == r13) goto L_0x02bf
            if (r8 == r15) goto L_0x0233
            goto L_0x03b5
        L_0x0233:
            int r8 = m4658i(r21)
        L_0x0237:
            java.lang.String r13 = r21.getName()
            if (r13 == 0) goto L_0x024d
            java.lang.String r13 = r21.getName()
            boolean r13 = r13.equals(r11)
            if (r13 == 0) goto L_0x024d
            boolean r13 = m4650b(r8)
            if (r13 != 0) goto L_0x03b5
        L_0x024d:
            java.lang.String r13 = r21.getName()
            java.lang.String r15 = "Tracking"
            boolean r13 = r15.equals(r13)
            if (r13 == 0) goto L_0x02b1
            boolean r8 = m4650b(r8)
            if (r8 != 0) goto L_0x02b1
            int r8 = r21.getAttributeCount()
            r13 = 0
        L_0x0264:
            if (r13 >= r8) goto L_0x02b1
            java.lang.String r15 = r1.getAttributeName(r13)
            r18 = r3
            java.lang.String r3 = "event"
            boolean r3 = r15.equals(r3)
            if (r3 == 0) goto L_0x02aa
            java.lang.String r3 = r1.getAttributeValue(r13)
            int r8 = m4658i(r21)
            r13 = 4
            if (r8 != r13) goto L_0x02b3
            java.lang.String r8 = r21.getText()
            if (r8 != 0) goto L_0x0287
            r15 = 0
            goto L_0x028b
        L_0x0287:
            java.lang.String r15 = r8.trim()
        L_0x028b:
            boolean r8 = android.webkit.URLUtil.isValidUrl(r15)
            if (r8 == 0) goto L_0x02b3
            com.inmobi.media.bo r8 = new com.inmobi.media.bo
            java.lang.String r13 = r21.getText()
            java.util.Map<java.lang.String, java.lang.String> r15 = f4824f
            java.lang.Object r3 = r15.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            r19 = r4
            r4 = 0
            r15 = 0
            r8.<init>(r13, r4, r3, r15)
            r2.mo28123a(r8)
            goto L_0x02b5
        L_0x02aa:
            r19 = r4
            int r13 = r13 + 1
            r3 = r18
            goto L_0x0264
        L_0x02b1:
            r18 = r3
        L_0x02b3:
            r19 = r4
        L_0x02b5:
            int r8 = m4658i(r21)
            r3 = r18
            r4 = r19
            goto L_0x0237
        L_0x02bf:
            r18 = r3
            r19 = r4
            int r3 = m4658i(r21)
            r4 = 4
            if (r3 != r4) goto L_0x03b9
            java.lang.String r3 = r21.getText()
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 == 0) goto L_0x02d6
            r15 = 0
            goto L_0x02da
        L_0x02d6:
            java.lang.String r15 = r3.trim()
        L_0x02da:
            boolean r3 = android.webkit.URLUtil.isValidUrl(r15)
            if (r3 == 0) goto L_0x03b9
            r2.f4800e = r15
            goto L_0x03b9
        L_0x02e4:
            r18 = r3
            r19 = r4
            int r3 = m4658i(r21)
            r4 = 4
            if (r3 != r4) goto L_0x03b9
            java.lang.String r3 = r21.getText()
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 == 0) goto L_0x02fb
            r15 = 0
            goto L_0x02ff
        L_0x02fb:
            java.lang.String r15 = r3.trim()
        L_0x02ff:
            boolean r3 = android.webkit.URLUtil.isValidUrl(r15)
            if (r3 == 0) goto L_0x0312
            com.inmobi.media.bo r3 = new com.inmobi.media.bo
            java.lang.String r4 = "click"
            r8 = 0
            r13 = 0
            r3.<init>(r15, r13, r4, r8)
            r2.mo28123a(r3)
            goto L_0x0313
        L_0x0312:
            r13 = 0
        L_0x0313:
            r12 = r15
            goto L_0x03ba
        L_0x0316:
            r18 = r3
            r19 = r4
            r13 = 0
            int r3 = m4658i(r21)
            r4 = 4
            if (r3 != r4) goto L_0x03ba
            java.lang.String r3 = r21.getText()
            boolean r8 = android.text.TextUtils.isEmpty(r3)
            if (r8 != 0) goto L_0x03ba
            com.inmobi.media.ck$a r8 = new com.inmobi.media.ck$a
            r15 = 3
            r8.<init>(r15, r3)
            r2.mo28124a(r8)
            goto L_0x03ba
        L_0x0337:
            r18 = r3
            r19 = r4
            r4 = 4
            r13 = 0
            int r3 = m4658i(r21)
            if (r3 != r4) goto L_0x03ba
            java.lang.String r3 = r21.getText()
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L_0x03ba
            com.inmobi.media.ck$a r4 = new com.inmobi.media.ck$a
            r8 = 2
            r4.<init>(r8, r3)
            r2.mo28124a(r4)
            goto L_0x03ba
        L_0x0357:
            r18 = r3
            r19 = r4
            r13 = 0
            java.lang.String r3 = "creativeType"
            r4 = 0
            java.lang.String r3 = r1.getAttributeValue(r4, r3)
            int r8 = m4658i(r21)
            r15 = 4
            if (r8 != r15) goto L_0x037b
            java.lang.String r8 = r21.getText()
            boolean r12 = android.text.TextUtils.isEmpty(r8)
            if (r12 == 0) goto L_0x0376
            r12 = r4
            goto L_0x037b
        L_0x0376:
            java.lang.String r15 = r8.trim()
            r12 = r15
        L_0x037b:
            if (r3 == 0) goto L_0x03ba
            java.lang.String r8 = r3.trim()
            boolean r8 = r8.isEmpty()
            if (r8 != 0) goto L_0x03ba
            java.util.ArrayList<java.lang.String> r8 = com.inmobi.media.C2284ck.f4794f
            int r8 = r8.size()
            r15 = 0
        L_0x038e:
            if (r15 >= r8) goto L_0x03a4
            java.util.ArrayList<java.lang.String> r4 = com.inmobi.media.C2284ck.f4794f
            java.lang.Object r4 = r4.get(r15)
            java.lang.String r4 = (java.lang.String) r4
            boolean r4 = r3.equalsIgnoreCase(r4)
            if (r4 == 0) goto L_0x03a0
            r3 = 1
            goto L_0x03a5
        L_0x03a0:
            int r15 = r15 + 1
            r4 = 0
            goto L_0x038e
        L_0x03a4:
            r3 = 0
        L_0x03a5:
            if (r3 == 0) goto L_0x03b1
            com.inmobi.media.ck$a r3 = new com.inmobi.media.ck$a
            r4 = 1
            r3.<init>(r4, r12)
            r2.mo28124a(r3)
            goto L_0x03ba
        L_0x03b1:
            r4 = 1
            r0.f4827d = r4
            goto L_0x03ba
        L_0x03b5:
            r18 = r3
            r19 = r4
        L_0x03b9:
            r13 = 0
        L_0x03ba:
            int r8 = m4658i(r21)
            r3 = r18
            r4 = r19
            r15 = 0
            goto L_0x019c
        L_0x03c5:
            r18 = r3
            r19 = r4
            r13 = 0
            int r2 = m4658i(r21)
            r3 = r18
            goto L_0x03d5
        L_0x03d1:
            int r2 = m4658i(r21)
        L_0x03d5:
            r4 = r19
        L_0x03d7:
            r8 = 1
            r12 = 3
            r13 = 2
            r14 = 4
            goto L_0x011b
        L_0x03dd:
            r19 = r4
            r13 = 0
            int r2 = m4658i(r21)
            r4 = 0
            r6 = 0
            r7 = 0
        L_0x03e7:
            java.lang.String r8 = r21.getName()
            if (r8 == 0) goto L_0x0419
            java.lang.String r8 = r21.getName()
            boolean r8 = r8.equals(r3)
            if (r8 == 0) goto L_0x0419
            boolean r8 = m4650b(r2)
            if (r8 != 0) goto L_0x03fe
            goto L_0x0419
        L_0x03fe:
            if (r4 == 0) goto L_0x0402
            if (r6 != 0) goto L_0x0407
        L_0x0402:
            r2 = 101(0x65, float:1.42E-43)
            r0.m4641a(r2)
        L_0x0407:
            if (r4 == 0) goto L_0x0414
            if (r6 == 0) goto L_0x0414
            if (r7 == 0) goto L_0x0414
            r8 = 1
            r12 = 2
            r14 = 3
            r16 = 1
            goto L_0x04a0
        L_0x0414:
            r8 = 1
            r12 = 2
            r14 = 3
            goto L_0x049e
        L_0x0419:
            java.lang.String r8 = r21.getName()
            if (r8 == 0) goto L_0x04a6
            boolean r2 = m4650b(r2)
            if (r2 != 0) goto L_0x04a6
            java.lang.String r2 = r21.getName()
            int r8 = r2.hashCode()
            switch(r8) {
                case -2049897434: goto L_0x044d;
                case -1927368268: goto L_0x0443;
                case -385055469: goto L_0x0439;
                case 611554000: goto L_0x0431;
                default: goto L_0x0430;
            }
        L_0x0430:
            goto L_0x0457
        L_0x0431:
            boolean r2 = r2.equals(r11)
            if (r2 == 0) goto L_0x0457
            r2 = 1
            goto L_0x0458
        L_0x0439:
            java.lang.String r8 = "MediaFiles"
            boolean r2 = r2.equals(r8)
            if (r2 == 0) goto L_0x0457
            r2 = 3
            goto L_0x0458
        L_0x0443:
            java.lang.String r8 = "Duration"
            boolean r2 = r2.equals(r8)
            if (r2 == 0) goto L_0x0457
            r2 = 0
            goto L_0x0458
        L_0x044d:
            java.lang.String r8 = "VideoClicks"
            boolean r2 = r2.equals(r8)
            if (r2 == 0) goto L_0x0457
            r2 = 2
            goto L_0x0458
        L_0x0457:
            r2 = -1
        L_0x0458:
            if (r2 == 0) goto L_0x0476
            r8 = 1
            if (r2 == r8) goto L_0x0470
            r12 = 2
            if (r2 == r12) goto L_0x046b
            r14 = 3
            if (r2 == r14) goto L_0x0464
            goto L_0x04a9
        L_0x0464:
            boolean r2 = r20.m4652c(r21)
            r7 = r2
            r6 = 1
            goto L_0x04a9
        L_0x046b:
            r14 = 3
            r0.m4644a(r1, r8)
            goto L_0x04a9
        L_0x0470:
            r12 = 2
            r14 = 3
            r20.m4653d(r21)
            goto L_0x04a9
        L_0x0476:
            r8 = 1
            r12 = 2
            r14 = 3
            int r2 = m4658i(r21)
            r9 = 4
            if (r2 != r9) goto L_0x04a9
            java.lang.String r2 = r21.getText()
            boolean r4 = android.text.TextUtils.isEmpty(r2)
            if (r4 != 0) goto L_0x0499
            java.lang.String r4 = "\\d*:[0-5][0-9]:[0-5][0-9](:[0-9][0-9][0-9])?"
            boolean r4 = r2.matches(r4)
            if (r4 != 0) goto L_0x0493
            goto L_0x0499
        L_0x0493:
            com.inmobi.media.cq r4 = r0.f4825b
            r4.f4842b = r2
            r4 = 1
            goto L_0x04a9
        L_0x0499:
            r2 = 101(0x65, float:1.42E-43)
            r0.m4641a(r2)
        L_0x049e:
            r16 = 0
        L_0x04a0:
            r9 = r16
            r4 = r19
            r6 = 1
            goto L_0x04bb
        L_0x04a6:
            r8 = 1
            r12 = 2
            r14 = 3
        L_0x04a9:
            int r2 = m4658i(r21)
            goto L_0x03e7
        L_0x04af:
            r12 = 2
            r13 = 0
            r14 = 3
            r4 = 1
            goto L_0x04bb
        L_0x04b4:
            r19 = r4
            r12 = 2
            r13 = 0
            r14 = 3
            r4 = r19
        L_0x04bb:
            int r2 = m4658i(r21)
            r7 = 101(0x65, float:1.42E-43)
            r12 = 3
            r13 = 2
            r14 = 4
            goto L_0x0096
        L_0x04c6:
            r13 = 0
            m4658i(r21)
            java.lang.String r2 = r21.getText()
            java.lang.String r3 = "error"
            r0.m4646a(r3, r2)
            goto L_0x04ef
        L_0x04d4:
            r13 = 0
            int r2 = m4658i(r21)
            r3 = 4
            if (r2 != r3) goto L_0x04e9
            java.lang.String r2 = r21.getText()
            boolean r2 = r0.m4646a(r9, r2)
            if (r2 != 0) goto L_0x04e7
            goto L_0x04e9
        L_0x04e7:
            r5 = 1
            goto L_0x04ef
        L_0x04e9:
            r1 = 101(0x65, float:1.42E-43)
            r0.m4641a(r1)
            return
        L_0x04ef:
            int r2 = m4658i(r21)
            goto L_0x000a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2290cn.m4648b(org.xmlpull.v1.XmlPullParser):void");
    }

    /* renamed from: a */
    private static void m4643a(XmlPullParser xmlPullParser, String str) {
        int i = 0;
        while (true) {
            try {
                i = xmlPullParser.next();
            } catch (IOException | XmlPullParserException unused) {
            }
            if (i == 1) {
                return;
            }
            if (xmlPullParser.getName() != null && xmlPullParser.getName().equals(str)) {
                return;
            }
        }
    }

    /* renamed from: a */
    private static void m4645a(XmlPullParser xmlPullParser, String[] strArr) {
        int i = 0;
        boolean z = false;
        do {
            try {
                i = xmlPullParser.next();
            } catch (IOException | XmlPullParserException unused) {
            }
            if (i == 1) {
                return;
            }
            if (xmlPullParser.getName() != null) {
                int i2 = 0;
                while (true) {
                    if (i2 >= 2) {
                        continue;
                        break;
                    }
                    if (xmlPullParser.getName().equals(strArr[i2])) {
                        z = true;
                        continue;
                        break;
                    }
                    i2++;
                }
            }
        } while (!z);
    }

    /* renamed from: c */
    private boolean m4652c(XmlPullParser xmlPullParser) {
        int i = m4658i(xmlPullParser);
        boolean z = false;
        while (true) {
            if (xmlPullParser.getName() != null && xmlPullParser.getName().equals("MediaFiles") && m4650b(i)) {
                break;
            }
            if (xmlPullParser.getName() != null) {
                if ("MediaFile".equals(xmlPullParser.getName()) && !m4650b(i)) {
                    C2428b bVar = this.f4826c.f5229d;
                    int attributeCount = xmlPullParser.getAttributeCount();
                    String str = null;
                    String str2 = null;
                    String str3 = null;
                    int i2 = 0;
                    for (int i3 = 0; i3 < attributeCount; i3++) {
                        String attributeName = xmlPullParser.getAttributeName(i3);
                        char c = 65535;
                        int hashCode = attributeName.hashCode();
                        if (hashCode != -102270099) {
                            if (hashCode != 3575610) {
                                if (hashCode == 823466996 && attributeName.equals("delivery")) {
                                    c = 0;
                                }
                            } else if (attributeName.equals("type")) {
                                c = 1;
                            }
                        } else if (attributeName.equals("bitrate")) {
                            c = 2;
                        }
                        if (c == 0) {
                            str2 = xmlPullParser.getAttributeValue(i3);
                        } else if (c == 1) {
                            str3 = xmlPullParser.getAttributeValue(i3);
                        } else if (c == 2) {
                            try {
                                i2 = Integer.valueOf(xmlPullParser.getAttributeValue(i3)).intValue();
                            } catch (Exception unused) {
                            }
                        }
                    }
                    int i4 = m4658i(xmlPullParser);
                    if (i4 == 4) {
                        String text = xmlPullParser.getText();
                        if (!TextUtils.isEmpty(text)) {
                            str = text.trim();
                        }
                        if (!URLUtil.isValidUrl(str) || ((bVar.f5193a && i2 <= 0) || str2 == null || !str2.trim().equalsIgnoreCase("Progressive"))) {
                            i = i4;
                            z = true;
                        } else {
                            ArrayList<String> arrayList = this.f4826c.f5230e;
                            if (str3 != null) {
                                for (int i5 = 0; i5 < arrayList.size(); i5++) {
                                    if (str3.equalsIgnoreCase((String) arrayList.get(i5))) {
                                        C2296cq cqVar = this.f4825b;
                                        cqVar.f4841a.add(new C2286cl(str, str2, str3, i2));
                                    }
                                }
                            }
                        }
                    }
                    z = true;
                }
            }
            i = m4658i(xmlPullParser);
        }
        if (!z) {
            m4641a(401);
            return false;
        } else if (!this.f4825b.f4841a.isEmpty()) {
            return true;
        } else {
            m4641a(403);
            return false;
        }
    }

    /* renamed from: a */
    private void m4644a(XmlPullParser xmlPullParser, boolean z) {
        int i = m4658i(xmlPullParser);
        while (true) {
            if (xmlPullParser.getName() == null || !xmlPullParser.getName().equals("VideoClicks") || !m4650b(i)) {
                if (xmlPullParser.getName() != null && !m4650b(i)) {
                    String name = xmlPullParser.getName();
                    char c = 65535;
                    int hashCode = name.hashCode();
                    if (hashCode != -617879491) {
                        if (hashCode == 2107600959 && name.equals("ClickTracking")) {
                            c = 1;
                        }
                    } else if (name.equals("ClickThrough")) {
                        c = 0;
                    }
                    if (c != 0) {
                        if (c == 1 && m4658i(xmlPullParser) == 4) {
                            m4646a(String.CLICK, xmlPullParser.getText());
                        }
                    } else if (z && m4658i(xmlPullParser) == 4) {
                        String text = xmlPullParser.getText();
                        this.f4825b.f4843c = TextUtils.isEmpty(text) ? null : text.trim();
                    }
                }
                i = m4658i(xmlPullParser);
            } else {
                return;
            }
        }
    }

    /* renamed from: d */
    private void m4653d(XmlPullParser xmlPullParser) {
        int i = m4658i(xmlPullParser);
        while (true) {
            if (xmlPullParser.getName() == null || !xmlPullParser.getName().equals("TrackingEvents") || !m4650b(i)) {
                if (xmlPullParser.getName() != null) {
                    if ("Tracking".equals(xmlPullParser.getName()) && !m4650b(i)) {
                        int attributeCount = xmlPullParser.getAttributeCount();
                        int i2 = 0;
                        while (true) {
                            if (i2 >= attributeCount) {
                                break;
                            } else if (xmlPullParser.getAttributeName(i2).equals("event")) {
                                String attributeValue = xmlPullParser.getAttributeValue(i2);
                                if (m4658i(xmlPullParser) == 4 && f4824f.containsKey(attributeValue)) {
                                    m4646a((String) f4824f.get(attributeValue), xmlPullParser.getText());
                                }
                            } else {
                                i2++;
                            }
                        }
                    }
                }
                i = m4658i(xmlPullParser);
            } else {
                return;
            }
        }
    }

    /* renamed from: e */
    private void m4654e(XmlPullParser xmlPullParser) {
        int i = m4658i(xmlPullParser);
        while (true) {
            if (xmlPullParser.getName() == null || !xmlPullParser.getName().equals("Extensions") || !m4650b(i)) {
                if (xmlPullParser.getName() != null && !m4650b(i)) {
                    String name = xmlPullParser.getName();
                    char c = 65535;
                    int hashCode = name.hashCode();
                    if (hashCode != -1788091386) {
                        if (hashCode == 1391410207 && name.equals("Extension")) {
                            c = 1;
                        }
                    } else if (name.equals("CompanionAdTracking")) {
                        c = 0;
                    }
                    if (c == 0) {
                        m4655f(xmlPullParser);
                    } else if (c == 1) {
                        String attributeValue = xmlPullParser.getAttributeValue(null, "type");
                        if (attributeValue != null && attributeValue.equals("AdVerifications")) {
                            m4656g(xmlPullParser);
                        }
                    }
                }
                i = m4658i(xmlPullParser);
            } else {
                return;
            }
        }
    }

    /* renamed from: f */
    private void m4655f(XmlPullParser xmlPullParser) {
        int i = m4658i(xmlPullParser);
        while (true) {
            if (xmlPullParser.getName() == null || !xmlPullParser.getName().equals("CompanionAdTracking") || !m4650b(i)) {
                if (xmlPullParser.getName() != null && !m4650b(i)) {
                    if ("TrackingEvents".equals(xmlPullParser.getName())) {
                        m4653d(xmlPullParser);
                    }
                }
                i = m4658i(xmlPullParser);
            } else {
                return;
            }
        }
    }

    /* renamed from: g */
    private void m4656g(XmlPullParser xmlPullParser) {
        int i = m4658i(xmlPullParser);
        while (true) {
            if (xmlPullParser.getName() == null || !xmlPullParser.getName().equals("AdVerifications") || !m4650b(i)) {
                if (xmlPullParser.getName() != null && !m4650b(i)) {
                    String name = xmlPullParser.getName();
                    char c = 65535;
                    if (name.hashCode() == -1320080837 && name.equals("Verification")) {
                        c = 0;
                    }
                    if (c == 0) {
                        String attributeValue = xmlPullParser.getAttributeValue(null, "vendor");
                        if (attributeValue != null) {
                            if (attributeValue.equals("Moat")) {
                                m4657h(xmlPullParser);
                            } else {
                                m4649b(xmlPullParser, attributeValue);
                            }
                        }
                    }
                }
                i = m4658i(xmlPullParser);
            } else {
                return;
            }
        }
    }

    /* renamed from: h */
    private void m4657h(XmlPullParser xmlPullParser) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        int i = m4658i(xmlPullParser);
        while (true) {
            if (xmlPullParser.getName() != null && xmlPullParser.getName().equals("Verification") && m4650b(i)) {
                break;
            }
            if (xmlPullParser.getName() != null && !m4650b(i)) {
                String name = xmlPullParser.getName();
                char c = 65535;
                if (name.hashCode() == 1083804936 && name.equals("ViewableImpression")) {
                    c = 0;
                }
                if (c == 0) {
                    String name2 = xmlPullParser.getName();
                    String name3 = xmlPullParser.getName();
                    int attributeCount = xmlPullParser.getAttributeCount();
                    for (int i2 = 0; i2 < attributeCount; i2++) {
                        sb2.append(' ');
                        sb2.append(xmlPullParser.getAttributeName(i2));
                        sb2.append("=\"");
                        sb2.append(xmlPullParser.getAttributeValue(i2));
                        sb2.append("\"");
                    }
                    do {
                        try {
                            i = xmlPullParser.nextToken();
                        } catch (IOException | XmlPullParserException unused) {
                        }
                        if (i == 4) {
                            sb3.append(xmlPullParser.getText());
                        } else if (i == 5) {
                            sb3.append("<![CDATA[");
                            sb3.append(xmlPullParser.getText());
                            sb3.append("]]>");
                        }
                    } while (!m4650b(i));
                    String str = "<";
                    sb.append(str);
                    sb.append(name2);
                    sb.append(sb2);
                    String str2 = ">";
                    sb.append(str2);
                    sb.append(sb3);
                    sb.append(str);
                    sb.append(Constants.URL_PATH_DELIMITER);
                    sb.append(name3);
                    sb.append(str2);
                }
            }
            i = m4658i(xmlPullParser);
        }
        if (sb.length() != 0) {
            this.f4825b.mo28136a(new C2234bo(sb.toString(), 0, "zMoatVASTIDs", null));
        }
    }

    /* renamed from: b */
    private void m4649b(XmlPullParser xmlPullParser, String str) {
        int i = m4658i(xmlPullParser);
        String str2 = null;
        String str3 = null;
        while (true) {
            if (xmlPullParser.getName() != null && xmlPullParser.getName().equals("Verification") && m4650b(i)) {
                break;
            }
            if (xmlPullParser.getName() != null && !m4650b(i)) {
                String name = xmlPullParser.getName();
                char c = 65535;
                int hashCode = name.hashCode();
                if (hashCode != 1561251035) {
                    if (hashCode == 1749252741 && name.equals("VerificationParameters")) {
                        c = 1;
                    }
                } else if (name.equals("JavaScriptResource")) {
                    c = 0;
                }
                if (c == 0) {
                    String attributeValue = xmlPullParser.getAttributeValue(null, "apiFramework");
                    if (attributeValue != null && attributeValue.startsWith("omid") && m4658i(xmlPullParser) == 4) {
                        String text = xmlPullParser.getText();
                        str3 = TextUtils.isEmpty(text) ? null : text.trim();
                    }
                } else if (c == 1 && m4658i(xmlPullParser) == 5) {
                    str2 = TextUtils.isEmpty(xmlPullParser.getText()) ? null : xmlPullParser.getText();
                }
            }
            i = m4658i(xmlPullParser);
        }
        if (URLUtil.isValidUrl(str3)) {
            C2338dn dnVar = new C2338dn(str, str2, str3, "OMID_VIEWABILITY", null);
            this.f4825b.mo28136a((C2234bo) dnVar);
        }
    }

    /* renamed from: i */
    private static int m4658i(XmlPullParser xmlPullParser) {
        try {
            return xmlPullParser.next();
        } catch (IOException | XmlPullParserException unused) {
            return -1;
        }
    }

    /* renamed from: a */
    private static boolean m4647a(@NonNull String str, XmlPullParser xmlPullParser) {
        return str.equals(xmlPullParser.getName());
    }

    /* renamed from: a */
    private void m4641a(int i) {
        this.f4825b.f4846f = i;
        m4651c(i);
    }

    /* renamed from: c */
    private void m4651c(int i) {
        C2185as a = C2185as.m4434a();
        HashMap hashMap = new HashMap();
        hashMap.put("[ERRORCODE]", String.valueOf(i));
        for (C2234bo boVar : this.f4825b.f4844d) {
            if ("error".equals(boVar.f4631d)) {
                a.mo27908a(C2515gi.m5347a(boVar.f4629b, (Map<String, String>) hashMap), boVar.f4632e, true);
            }
        }
    }

    /* renamed from: a */
    private boolean m4646a(String str, String str2) {
        String trim = TextUtils.isEmpty(str2) ? null : str2.trim();
        if (!URLUtil.isValidUrl(trim)) {
            return !str.equals("Impression");
        }
        this.f4825b.mo28136a(new C2234bo(trim, 0, str, null));
        return true;
    }
}
