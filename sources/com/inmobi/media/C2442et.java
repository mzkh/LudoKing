package com.inmobi.media;

import android.content.ContentValues;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.util.List;

/* renamed from: com.inmobi.media.et */
/* compiled from: ConfigDao */
public class C2442et {

    /* renamed from: a */
    private static final String f5256a = "et";

    /* renamed from: b */
    private static final String[] f5257b = {"account_id", "config_value", "config_type", "update_ts"};

    /* renamed from: d */
    private static String[] m5106d(String str, @NonNull String str2) {
        return new String[]{str2, str};
    }

    @VisibleForTesting(otherwise = 3)
    public C2442et() {
        C2493fx a = C2493fx.m5237a();
        a.mo28431a("config_db", "(account_id TEXT NOT NULL,config_value TEXT NOT NULL,config_type TEXT NOT NULL,update_ts INTEGER DEFAULT 0,UNIQUE(account_id,config_type))");
        a.mo28434b();
    }

    /* renamed from: a */
    public static void m5102a(C2436er erVar) {
        try {
            if (erVar.f5244n != null) {
                C2493fx a = C2493fx.m5237a();
                ContentValues contentValues = new ContentValues();
                contentValues.put("account_id", erVar.f5244n);
                contentValues.put("config_value", erVar.mo28342b().toString());
                contentValues.put("config_type", erVar.mo28340a());
                contentValues.put("update_ts", Long.valueOf(System.currentTimeMillis()));
                a.mo28430a("config_db", contentValues, "account_id=? AND config_type=?", m5106d(erVar.mo28340a(), erVar.f5244n));
                a.mo28434b();
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    @androidx.annotation.NonNull
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.inmobi.media.C2436er m5101a(@androidx.annotation.NonNull java.lang.String r11, @androidx.annotation.NonNull java.lang.String r12) {
        /*
            r0 = 0
            com.inmobi.media.fx r10 = com.inmobi.media.C2493fx.m5237a()     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r2 = "config_db"
            java.lang.String[] r3 = f5257b     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r4 = "account_id=? AND config_type=?"
            java.lang.String[] r5 = m5106d(r11, r12)     // Catch:{ Exception -> 0x00b7 }
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r1 = r10
            java.util.List r12 = r1.mo28429a(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x00b7 }
            boolean r1 = r12.isEmpty()     // Catch:{ Exception -> 0x00b7 }
            if (r1 != 0) goto L_0x00b2
            r1 = 0
            java.lang.Object r12 = r12.get(r1)     // Catch:{ Exception -> 0x00b7 }
            android.content.ContentValues r12 = (android.content.ContentValues) r12     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r1 = "config_value"
            java.lang.String r1 = r12.getAsString(r1)     // Catch:{ Exception -> 0x00b7 }
            if (r1 != 0) goto L_0x002f
            goto L_0x00b2
        L_0x002f:
            java.lang.String r2 = "account_id"
            java.lang.String r2 = r12.getAsString(r2)     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r3 = "config_type"
            java.lang.String r12 = r12.getAsString(r3)     // Catch:{ Exception -> 0x00b7 }
            r3 = -1
            int r4 = r12.hashCode()     // Catch:{ Exception -> 0x00b7 }
            switch(r4) {
                case -60641721: goto L_0x0076;
                case 3579: goto L_0x006c;
                case 96432: goto L_0x0062;
                case 3506402: goto L_0x0058;
                case 780346297: goto L_0x004e;
                case 2088265419: goto L_0x0044;
                default: goto L_0x0043;
            }     // Catch:{ Exception -> 0x00b7 }
        L_0x0043:
            goto L_0x007f
        L_0x0044:
            java.lang.String r4 = "signals"
            boolean r12 = r12.equals(r4)     // Catch:{ Exception -> 0x00b7 }
            if (r12 == 0) goto L_0x007f
            r3 = 5
            goto L_0x007f
        L_0x004e:
            java.lang.String r4 = "telemetry"
            boolean r12 = r12.equals(r4)     // Catch:{ Exception -> 0x00b7 }
            if (r12 == 0) goto L_0x007f
            r3 = 6
            goto L_0x007f
        L_0x0058:
            java.lang.String r4 = "root"
            boolean r12 = r12.equals(r4)     // Catch:{ Exception -> 0x00b7 }
            if (r12 == 0) goto L_0x007f
            r3 = 4
            goto L_0x007f
        L_0x0062:
            java.lang.String r4 = "ads"
            boolean r12 = r12.equals(r4)     // Catch:{ Exception -> 0x00b7 }
            if (r12 == 0) goto L_0x007f
            r3 = 1
            goto L_0x007f
        L_0x006c:
            java.lang.String r4 = "pk"
            boolean r12 = r12.equals(r4)     // Catch:{ Exception -> 0x00b7 }
            if (r12 == 0) goto L_0x007f
            r3 = 3
            goto L_0x007f
        L_0x0076:
            java.lang.String r4 = "crashReporting"
            boolean r12 = r12.equals(r4)     // Catch:{ Exception -> 0x00b7 }
            if (r12 == 0) goto L_0x007f
            r3 = 2
        L_0x007f:
            switch(r3) {
                case 1: goto L_0x00a2;
                case 2: goto L_0x009c;
                case 3: goto L_0x0096;
                case 4: goto L_0x0090;
                case 5: goto L_0x008a;
                case 6: goto L_0x0084;
                default: goto L_0x0082;
            }     // Catch:{ Exception -> 0x00b7 }
        L_0x0082:
            r12 = r0
            goto L_0x00a7
        L_0x0084:
            com.inmobi.media.fc r12 = new com.inmobi.media.fc     // Catch:{ Exception -> 0x00b7 }
            r12.<init>(r2)     // Catch:{ Exception -> 0x00b7 }
            goto L_0x00a7
        L_0x008a:
            com.inmobi.media.fb r12 = new com.inmobi.media.fb     // Catch:{ Exception -> 0x00b7 }
            r12.<init>(r2)     // Catch:{ Exception -> 0x00b7 }
            goto L_0x00a7
        L_0x0090:
            com.inmobi.media.fa r12 = new com.inmobi.media.fa     // Catch:{ Exception -> 0x00b7 }
            r12.<init>(r2)     // Catch:{ Exception -> 0x00b7 }
            goto L_0x00a7
        L_0x0096:
            com.inmobi.media.ez r12 = new com.inmobi.media.ez     // Catch:{ Exception -> 0x00b7 }
            r12.<init>(r2)     // Catch:{ Exception -> 0x00b7 }
            goto L_0x00a7
        L_0x009c:
            com.inmobi.media.ey r12 = new com.inmobi.media.ey     // Catch:{ Exception -> 0x00b7 }
            r12.<init>(r2)     // Catch:{ Exception -> 0x00b7 }
            goto L_0x00a7
        L_0x00a2:
            com.inmobi.media.eq r12 = new com.inmobi.media.eq     // Catch:{ Exception -> 0x00b7 }
            r12.<init>(r2)     // Catch:{ Exception -> 0x00b7 }
        L_0x00a7:
            if (r12 == 0) goto L_0x00b3
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x00b7 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x00b7 }
            r12.mo28341a(r2)     // Catch:{ Exception -> 0x00b7 }
            goto L_0x00b3
        L_0x00b2:
            r12 = r0
        L_0x00b3:
            r10.mo28434b()     // Catch:{ Exception -> 0x00b8 }
            goto L_0x00b8
        L_0x00b7:
            r12 = r0
        L_0x00b8:
            if (r12 != 0) goto L_0x00be
            com.inmobi.media.er r12 = com.inmobi.media.C2436er.m5081a(r11, r0)
        L_0x00be:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2442et.m5101a(java.lang.String, java.lang.String):com.inmobi.media.er");
    }

    /* renamed from: b */
    public static boolean m5104b(@NonNull String str, @NonNull String str2) {
        try {
            C2493fx a = C2493fx.m5237a();
            int b = a.mo28433b("config_db", "account_id=? AND config_type=?", m5106d(str, str2));
            a.mo28434b();
            if (b <= 0) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    /* renamed from: c */
    public static long m5105c(@NonNull String str, @NonNull String str2) {
        long j = 0;
        try {
            C2493fx a = C2493fx.m5237a();
            List a2 = a.mo28429a("config_db", f5257b, "account_id=? AND config_type=?", m5106d(str, str2), null, null, null, null);
            if (!a2.isEmpty()) {
                j = ((ContentValues) a2.get(0)).getAsLong("update_ts").longValue();
            }
            a.mo28434b();
        } catch (Exception unused) {
        }
        return j;
    }

    /* renamed from: a */
    public static void m5103a(@NonNull String str, @NonNull String str2, long j) {
        try {
            C2493fx a = C2493fx.m5237a();
            ContentValues contentValues = new ContentValues();
            contentValues.put("update_ts", Long.valueOf(j));
            a.mo28432b("config_db", contentValues, "account_id=? AND config_type=?", m5106d(str, str2));
            a.mo28434b();
        } catch (Exception unused) {
        }
    }
}
