package com.inmobi.media;

import android.annotation.SuppressLint;
import android.content.Context;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.firebase.messaging.cpp.SerializedEventUnion;
import com.tapjoy.TapjoyConstants;
import java.security.MessageDigest;

/* renamed from: com.inmobi.media.gx */
/* compiled from: UidHelper */
public class C2538gx {

    /* renamed from: a */
    private static final String f5569a = "gx";
    @Nullable

    /* renamed from: b */
    private static C2537gw f5570b;

    /* renamed from: com.inmobi.media.gx$a */
    /* compiled from: UidHelper */
    static class C2539a {

        /* renamed from: a */
        static final C2538gx f5571a = new C2538gx(0);
    }

    /* synthetic */ C2538gx(byte b) {
        this();
    }

    /* renamed from: a */
    public static C2538gx m5429a() {
        return C2539a.f5571a;
    }

    private C2538gx() {
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    @androidx.annotation.WorkerThread
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo28479b() {
        /*
            r7 = this;
            java.lang.String r0 = "limit_ad_tracking"
            java.lang.String r1 = "adv_id"
            r7.mo28480c()     // Catch:{ Exception -> 0x0064 }
            android.content.Context r2 = com.inmobi.media.C2505gd.m5298c()     // Catch:{  }
            if (r2 == 0) goto L_0x0064
            com.inmobi.media.gk r3 = new com.inmobi.media.gk     // Catch:{  }
            java.lang.String r4 = "uid_store"
            r3.<init>(r2, r4)     // Catch:{  }
            com.inmobi.media.gw r4 = new com.inmobi.media.gw     // Catch:{  }
            r4.<init>()     // Catch:{  }
            f5570b = r4     // Catch:{  }
            java.lang.String r5 = r3.mo28467a(r1)     // Catch:{  }
            r4.f5567a = r5     // Catch:{  }
            com.inmobi.media.gw r4 = f5570b     // Catch:{  }
            com.inmobi.media.fy r5 = r3.f5517a     // Catch:{  }
            android.content.SharedPreferences r5 = r5.f5473a     // Catch:{  }
            boolean r5 = r5.contains(r0)     // Catch:{  }
            if (r5 == 0) goto L_0x0039
            com.inmobi.media.fy r5 = r3.f5517a     // Catch:{  }
            r6 = 1
            boolean r5 = r5.mo28443b(r0, r6)     // Catch:{  }
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch:{  }
            goto L_0x003a
        L_0x0039:
            r5 = 0
        L_0x003a:
            r4.f5568b = r5     // Catch:{  }
            boolean r4 = m5432g()     // Catch:{  }
            if (r4 == 0) goto L_0x0064
            com.google.android.gms.ads.identifier.AdvertisingIdClient$Info r2 = com.google.android.gms.ads.identifier.AdvertisingIdClient.getAdvertisingIdInfo(r2)     // Catch:{  }
            java.lang.String r4 = r2.getId()     // Catch:{  }
            boolean r2 = r2.isLimitAdTrackingEnabled()     // Catch:{  }
            com.inmobi.media.gw r5 = f5570b     // Catch:{  }
            r5.f5567a = r4     // Catch:{  }
            com.inmobi.media.fy r5 = r3.f5517a     // Catch:{  }
            r5.mo28439a(r1, r4)     // Catch:{  }
            com.inmobi.media.gw r1 = f5570b     // Catch:{  }
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r2)     // Catch:{  }
            r1.f5568b = r4     // Catch:{  }
            com.inmobi.media.fy r1 = r3.f5517a     // Catch:{  }
            r1.mo28440a(r0, r2)     // Catch:{  }
        L_0x0064:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2538gx.mo28479b():void");
    }

    /* renamed from: c */
    public void mo28480c() {
        try {
            C2537gw e = mo28481e();
            String str = "Publisher device Id is ";
            if (e != null) {
                String b = e.mo28478b();
                if (b != null) {
                    C2514gh.m5342a(2, f5569a, str.concat(String.valueOf(b)));
                }
            } else {
                String d = m5431d();
                String str2 = f5569a;
                StringBuilder sb = new StringBuilder(str);
                sb.append(m5430a(d, "SHA-1"));
                C2514gh.m5342a(2, str2, sb.toString());
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    static String m5430a(String str, String str2) {
        if (str != null) {
            try {
                if (!"".equals(str.trim())) {
                    MessageDigest instance = MessageDigest.getInstance(str2);
                    instance.update(str.getBytes());
                    byte[] digest = instance.digest();
                    StringBuilder sb = new StringBuilder();
                    for (byte b : digest) {
                        sb.append(Integer.toString((b & 255) + SerializedEventUnion.NONE, 16).substring(1));
                    }
                    return sb.toString();
                }
            } catch (Exception unused) {
                return null;
            }
        }
        return "TEST_EMULATOR";
    }

    @SuppressLint({"HardwareIds"})
    /* renamed from: d */
    static String m5431d() {
        String str = TapjoyConstants.TJC_ANDROID_ID;
        Context c = C2505gd.m5298c();
        String str2 = "";
        if (c == null) {
            return str2;
        }
        try {
            String string = Secure.getString(c.getContentResolver(), str);
            return string == null ? System.getString(c.getContentResolver(), str) : string;
        } catch (Exception unused) {
            return str2;
        }
    }

    @Nullable
    /* renamed from: e */
    public C2537gw mo28481e() {
        return f5570b;
    }

    /* renamed from: g */
    private static boolean m5432g() {
        try {
            AdvertisingIdClient.class.getName();
            return true;
        } catch (NoClassDefFoundError unused) {
            return false;
        }
    }

    @Nullable
    /* renamed from: f */
    public Boolean mo28482f() {
        C2537gw e = m5429a().mo28481e();
        if (e == null) {
            return null;
        }
        return e.mo28477a();
    }
}
