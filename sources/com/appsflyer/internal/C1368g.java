package com.appsflyer.internal;

import com.inmobi.media.C2663v;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.appsflyer.internal.g */
public final class C1368g {

    /* renamed from: com.appsflyer.internal.g$a */
    enum C1369a {
        UNKNOWN(0),
        ACCELEROMETER(1),
        MAGNETOMETER(2),
        RESERVED(3),
        GYROSCOPE(4);
        

        /* renamed from: ʽ */
        private int f3561;

        private C1369a(int i) {
            this.f3561 = i;
        }
    }

    /* renamed from: com.appsflyer.internal.g$b */
    enum C1370b {
        UNKNOWN("uk"),
        ACCELEROMETER("am"),
        MAGNETOMETER("mm"),
        RESERVED("rs"),
        GYROSCOPE("gs");
        

        /* renamed from: ॱ */
        String f3568;

        private C1370b(String str) {
            this.f3568 = str;
        }
    }

    /* renamed from: com.appsflyer.internal.g$c */
    enum C1371c {
        ;
        

        /* renamed from: ˋ */
        public static final int f3569 = 1;

        /* renamed from: ˎ */
        public static final int f3570 = 2;

        /* renamed from: ॱ */
        public static final int f3572 = 3;

        static {
            f3571 = new int[]{1, 2, 3};
        }

        public static int[] values$3f33b5a2() {
            return (int[]) f3571.clone();
        }
    }

    /* renamed from: ˋ */
    private static List<BigDecimal> m3336(Object obj) {
        ArrayList arrayList = (ArrayList) obj;
        Float f = (Float) arrayList.get(0);
        Float f2 = (Float) arrayList.get(1);
        Float f3 = (Float) arrayList.get(2);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(BigDecimal.valueOf(Double.parseDouble(f.toString())));
        arrayList2.add(BigDecimal.valueOf(Double.parseDouble(f2.toString())));
        arrayList2.add(BigDecimal.valueOf(Double.parseDouble(f3.toString())));
        return arrayList2;
    }

    /* renamed from: ˋ */
    public static Map m3337(List<Map<String, Object>> list) {
        int i;
        int i2;
        ArrayList arrayList;
        HashMap hashMap = new HashMap();
        for (Map map : list) {
            HashMap hashMap2 = new HashMap();
            String str = "sVS";
            boolean z = map.get(str) != null;
            String str2 = "sVE";
            boolean z2 = map.get(str2) != null;
            if (z && z2) {
                i = C1371c.f3572;
            } else if (z) {
                i = C1371c.f3570;
            } else {
                i = C1371c.f3569;
            }
            String str3 = "er";
            if (i != C1371c.f3569) {
                Integer num = (Integer) map.get("sT");
                String str4 = (String) map.get("sN");
                String str5 = "n";
                if (str4 != null) {
                    hashMap2.put(str5, str4);
                } else {
                    hashMap2.put(str5, "uk");
                }
                C1369a aVar = C1369a.values()[num.intValue()];
                ArrayList arrayList2 = new ArrayList(m3336(map.get(str)));
                if (i == C1371c.f3572) {
                    arrayList2.addAll(m3336(map.get(str2)));
                }
                String str6 = "##.#";
                if (aVar == C1369a.MAGNETOMETER) {
                    ArrayList arrayList3 = new ArrayList();
                    i2 = i;
                    BigDecimal valueOf = BigDecimal.valueOf(Math.atan2(((BigDecimal) arrayList2.get(1)).doubleValue(), ((BigDecimal) arrayList2.get(0)).doubleValue()) * 57.29577951308232d);
                    DecimalFormat decimalFormat = new DecimalFormat(str6);
                    decimalFormat.setRoundingMode(RoundingMode.DOWN);
                    arrayList3.add(Double.valueOf(Double.parseDouble(decimalFormat.format(valueOf))));
                    BigDecimal bigDecimal = (BigDecimal) arrayList2.get(2);
                    DecimalFormat decimalFormat2 = new DecimalFormat(str6);
                    decimalFormat2.setRoundingMode(RoundingMode.DOWN);
                    arrayList3.add(Double.valueOf(Double.parseDouble(decimalFormat2.format(bigDecimal))));
                    ArrayList arrayList4 = new ArrayList();
                    if (arrayList2.size() > 5) {
                        BigDecimal subtract = BigDecimal.valueOf(Math.atan2(((BigDecimal) arrayList2.get(4)).doubleValue(), ((BigDecimal) arrayList2.get(3)).doubleValue()) * 57.29577951308232d).subtract(valueOf);
                        DecimalFormat decimalFormat3 = new DecimalFormat(str6);
                        decimalFormat3.setRoundingMode(RoundingMode.DOWN);
                        arrayList4.add(Double.valueOf(Double.parseDouble(decimalFormat3.format(subtract))));
                        BigDecimal subtract2 = ((BigDecimal) arrayList2.get(5)).subtract((BigDecimal) arrayList2.get(2));
                        DecimalFormat decimalFormat4 = new DecimalFormat(str6);
                        decimalFormat4.setRoundingMode(RoundingMode.DOWN);
                        arrayList4.add(Double.valueOf(Double.parseDouble(decimalFormat4.format(subtract2))));
                    }
                    arrayList = new ArrayList();
                    arrayList.add(arrayList3);
                    arrayList.add(arrayList4);
                } else {
                    i2 = i;
                    ArrayList arrayList5 = new ArrayList();
                    if (arrayList2.size() > 5) {
                        BigDecimal subtract3 = ((BigDecimal) arrayList2.get(3)).subtract((BigDecimal) arrayList2.get(0));
                        DecimalFormat decimalFormat5 = new DecimalFormat(str6);
                        decimalFormat5.setRoundingMode(RoundingMode.DOWN);
                        arrayList5.add(Double.valueOf(Double.parseDouble(decimalFormat5.format(subtract3))));
                        BigDecimal subtract4 = ((BigDecimal) arrayList2.get(4)).subtract((BigDecimal) arrayList2.get(1));
                        DecimalFormat decimalFormat6 = new DecimalFormat(str6);
                        decimalFormat6.setRoundingMode(RoundingMode.DOWN);
                        arrayList5.add(Double.valueOf(Double.parseDouble(decimalFormat6.format(subtract4))));
                        BigDecimal subtract5 = ((BigDecimal) arrayList2.get(5)).subtract((BigDecimal) arrayList2.get(2));
                        DecimalFormat decimalFormat7 = new DecimalFormat(str6);
                        decimalFormat7.setRoundingMode(RoundingMode.DOWN);
                        arrayList5.add(Double.valueOf(Double.parseDouble(decimalFormat7.format(subtract5))));
                    }
                    ArrayList arrayList6 = new ArrayList();
                    BigDecimal bigDecimal2 = (BigDecimal) arrayList2.get(0);
                    DecimalFormat decimalFormat8 = new DecimalFormat(str6);
                    decimalFormat8.setRoundingMode(RoundingMode.DOWN);
                    arrayList6.add(Double.valueOf(Double.parseDouble(decimalFormat8.format(bigDecimal2))));
                    BigDecimal bigDecimal3 = (BigDecimal) arrayList2.get(1);
                    DecimalFormat decimalFormat9 = new DecimalFormat(str6);
                    decimalFormat9.setRoundingMode(RoundingMode.DOWN);
                    arrayList6.add(Double.valueOf(Double.parseDouble(decimalFormat9.format(bigDecimal3))));
                    BigDecimal bigDecimal4 = (BigDecimal) arrayList2.get(2);
                    DecimalFormat decimalFormat10 = new DecimalFormat(str6);
                    decimalFormat10.setRoundingMode(RoundingMode.DOWN);
                    arrayList6.add(Double.valueOf(Double.parseDouble(decimalFormat10.format(bigDecimal4))));
                    ArrayList arrayList7 = new ArrayList();
                    arrayList7.add(arrayList6);
                    arrayList7.add(arrayList5);
                    arrayList = arrayList7;
                }
                hashMap2.put(C2663v.f5947r, arrayList);
                hashMap.put(C1370b.values()[num.intValue()].f3568, hashMap2);
                if (i2 == C1371c.f3570) {
                    hashMap.put(str3, "no_svs");
                }
            } else {
                HashMap hashMap3 = new HashMap();
                hashMap3.put(str3, "na");
                return hashMap3;
            }
        }
        return hashMap;
    }
}
