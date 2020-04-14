package com.inmobi.media;

import android.content.ContentValues;
import android.content.Context;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* renamed from: com.inmobi.media.fe */
/* compiled from: CrashDao */
public class C2468fe extends C2472fi {

    /* renamed from: a */
    private static final String f5370a = "fe";

    public C2468fe() {
        C2493fx a = C2493fx.m5237a();
        a.mo28431a("crash", "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, componentType TEXT NOT NULL, eventId TEXT NOT NULL, eventType TEXT NOT NULL, payload TEXT NOT NULL, ts TEXT NOT NULL)");
        a.mo28434b();
    }

    /* renamed from: a */
    public static void m5171a(C2469ff ffVar) {
        C2493fx a = C2493fx.m5237a();
        ContentValues contentValues = new ContentValues();
        contentValues.put("eventId", ffVar.f5373b);
        contentValues.put("componentType", ffVar.f5375d);
        contentValues.put("eventType", ffVar.f5374c);
        contentValues.put(MessengerShareContentUtility.ATTACHMENT_PAYLOAD, ffVar.mo28394a());
        contentValues.put("ts", String.valueOf(ffVar.f5376e));
        a.mo28428a("crash", contentValues);
        a.mo28434b();
    }

    /* renamed from: a */
    public static List<C2469ff> m5170a(int i) {
        C2493fx a = C2493fx.m5237a();
        C2493fx fxVar = a;
        List<ContentValues> a2 = fxVar.mo28429a("crash", null, null, null, null, null, "ts ASC", String.valueOf(i));
        ArrayList arrayList = new ArrayList();
        a.mo28434b();
        for (ContentValues a3 : a2) {
            arrayList.add(C2469ff.m5180a(a3));
        }
        return arrayList;
    }

    /* renamed from: a */
    public final boolean mo28389a(long j) {
        List a = m5170a(1);
        if (a.size() <= 0 || TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - ((C2469ff) a.get(0)).f5376e) <= j) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public final boolean mo28390a(long j, long j2) {
        long seconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()) + j;
        List a = m5170a(1);
        if (a.size() <= 0 || seconds - TimeUnit.MILLISECONDS.toSeconds(((C2469ff) a.get(0)).f5376e) < j2) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public final int mo28387a() {
        C2493fx a = C2493fx.m5237a();
        int a2 = a.mo28426a("crash");
        a.mo28434b();
        return a2;
    }

    /* renamed from: b */
    public final void mo28391b(long j) {
        C2493fx a = C2493fx.m5237a();
        a.mo28427a("crash", "ts<?", new String[]{String.valueOf(System.currentTimeMillis() - (j * 1000))});
        a.mo28434b();
    }

    /* renamed from: a */
    public final void mo28388a(List<Integer> list) {
        if (!list.isEmpty()) {
            C2493fx a = C2493fx.m5237a();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size() - 1; i++) {
                sb.append(list.get(i));
                sb.append(",");
            }
            sb.append(String.valueOf(list.get(list.size() - 1)));
            StringBuilder sb2 = new StringBuilder("id IN (");
            sb2.append(sb);
            sb2.append(")");
            a.mo28427a("crash", sb2.toString(), null);
            a.mo28434b();
        }
    }

    /* renamed from: b */
    public static void m5172b() {
        C2493fx a = C2493fx.m5237a();
        List a2 = a.mo28429a("crash", null, null, null, null, null, "ts ASC", "1");
        if (!a2.isEmpty()) {
            String asString = ((ContentValues) a2.get(0)).getAsString("id");
            StringBuilder sb = new StringBuilder("id IN (");
            sb.append(asString);
            sb.append(")");
            a.mo28427a("crash", sb.toString(), null);
        }
        a.mo28434b();
    }

    /* renamed from: c */
    public final void mo28393c(long j) {
        Context c = C2505gd.m5298c();
        if (c != null) {
            C2494fy.m5249a(c, "batch_processing_info").mo28438a("crash_last_batch_process", j);
        }
    }

    /* renamed from: c */
    public final long mo28392c() {
        Context c = C2505gd.m5298c();
        if (c != null) {
            return C2494fy.m5249a(c, "batch_processing_info").mo28441b("crash_last_batch_process", -1);
        }
        return -1;
    }
}
