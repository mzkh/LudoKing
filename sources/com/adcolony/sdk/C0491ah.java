package com.adcolony.sdk;

import android.os.Bundle;
import com.google.ads.mediation.adcolony.AdColonyAdapterUtils;
import java.util.HashMap;

/* renamed from: com.adcolony.sdk.ah */
class C0491ah {

    /* renamed from: a */
    static final int f204a = 5;

    /* renamed from: b */
    static final int f205b = 1;

    /* renamed from: c */
    static final int f206c = 3;

    /* renamed from: d */
    static final int f207d = 0;

    /* renamed from: e */
    static final int f208e = 1;

    /* renamed from: f */
    private static int f209f;

    /* renamed from: g */
    private static HashMap<String, Integer> f210g = new HashMap<>();

    /* renamed from: h */
    private static HashMap<String, Integer> f211h = new HashMap<>();

    C0491ah() {
    }

    /* renamed from: a */
    static boolean m146a(int i, Bundle bundle) {
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        if (i != 0) {
            if (i != 1 || bundle == null) {
                return false;
            }
            String string = bundle.getString(AdColonyAdapterUtils.KEY_ZONE_ID);
            if (f210g.get(string) == null) {
                f210g.put(string, Integer.valueOf(currentTimeMillis));
            }
            if (f211h.get(string) == null) {
                f211h.put(string, Integer.valueOf(0));
            }
            if (currentTimeMillis - ((Integer) f210g.get(string)).intValue() > 1) {
                f211h.put(string, Integer.valueOf(1));
                f210g.put(string, Integer.valueOf(currentTimeMillis));
                return false;
            }
            int intValue = ((Integer) f211h.get(string)).intValue() + 1;
            f211h.put(string, Integer.valueOf(intValue));
            return intValue > 3;
        } else if (currentTimeMillis - f209f < 5) {
            return true;
        } else {
            f209f = currentTimeMillis;
            return false;
        }
    }
}
