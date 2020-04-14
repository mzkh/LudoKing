package com.inmobi.media;

import android.content.ContentValues;
import android.content.Context;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* renamed from: com.inmobi.media.gb */
/* compiled from: TelemetryDao */
public class C2503gb extends C2472fi {

    /* renamed from: a */
    private static final String f5490a = "gb";

    public C2503gb() {
        C2493fx a = C2493fx.m5237a();
        a.mo28431a("telemetry", "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, eventType TEXT NOT NULL, payload TEXT NOT NULL, ts TEXT NOT NULL)");
        a.mo28434b();
    }

    /* renamed from: a */
    public static void m5273a(C2504gc gcVar) {
        C2493fx a = C2493fx.m5237a();
        ContentValues contentValues = new ContentValues();
        contentValues.put("eventType", gcVar.f5492b);
        contentValues.put(MessengerShareContentUtility.ATTACHMENT_PAYLOAD, gcVar.mo28454a());
        contentValues.put("ts", String.valueOf(gcVar.f5493c));
        a.mo28428a("telemetry", contentValues);
        a.mo28434b();
    }

    /* renamed from: a */
    public static List<C2504gc> m5272a(int i) {
        C2493fx a = C2493fx.m5237a();
        C2493fx fxVar = a;
        List<ContentValues> a2 = fxVar.mo28429a("telemetry", null, null, null, null, null, "ts ASC", String.valueOf(i));
        ArrayList arrayList = new ArrayList();
        a.mo28434b();
        for (ContentValues a3 : a2) {
            arrayList.add(C2504gc.m5282a(a3));
        }
        return arrayList;
    }

    /* renamed from: a */
    public final boolean mo28389a(long j) {
        List a = m5272a(1);
        if (a.size() <= 0 || TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - ((C2504gc) a.get(0)).f5493c) < j) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public final boolean mo28390a(long j, long j2) {
        long seconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()) + j;
        List a = m5272a(1);
        if (a.size() <= 0 || seconds - TimeUnit.MILLISECONDS.toSeconds(((C2504gc) a.get(0)).f5493c) <= j2) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public final int mo28387a() {
        C2493fx a = C2493fx.m5237a();
        int a2 = a.mo28426a("telemetry");
        a.mo28434b();
        return a2;
    }

    /* renamed from: b */
    public final void mo28391b(long j) {
        C2493fx a = C2493fx.m5237a();
        a.mo28427a("telemetry", "ts<?", new String[]{String.valueOf(System.currentTimeMillis() - (j * 1000))});
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
            a.mo28427a("telemetry", sb2.toString(), null);
            a.mo28434b();
        }
    }

    /* renamed from: b */
    public final void mo28453b(int i) {
        C2493fx a = C2493fx.m5237a();
        C2493fx fxVar = a;
        List<ContentValues> a2 = fxVar.mo28429a("telemetry", null, null, null, null, null, "ts ASC", String.valueOf(i));
        ArrayList arrayList = new ArrayList();
        for (ContentValues contentValues : a2) {
            String str = "id";
            contentValues.getAsString(str);
            arrayList.add(Integer.valueOf(Integer.parseInt(contentValues.getAsString(str))));
        }
        mo28388a((List<Integer>) arrayList);
        a.mo28434b();
    }

    /* renamed from: c */
    public final void mo28393c(long j) {
        Context c = C2505gd.m5298c();
        if (c != null) {
            C2494fy.m5249a(c, "batch_processing_info").mo28438a("telemetry_last_batch_process", j);
        }
    }

    /* renamed from: c */
    public final long mo28392c() {
        Context c = C2505gd.m5298c();
        if (c == null) {
            return -1;
        }
        return C2494fy.m5249a(c, "batch_processing_info").mo28441b("telemetry_last_batch_process", -1);
    }
}
