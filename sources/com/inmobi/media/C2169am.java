package com.inmobi.media;

import android.content.ContentValues;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* renamed from: com.inmobi.media.am */
/* compiled from: AssetDao */
public class C2169am {

    /* renamed from: a */
    public static final String[] f4410a = {"id", "pending_attempts", "url", "disk_uri", "ts", "created_ts", "ttl", "soft_ttl"};

    /* renamed from: b */
    private static final String f4411b = "am";

    /* renamed from: com.inmobi.media.am$a */
    /* compiled from: AssetDao */
    static class C2170a {

        /* renamed from: a */
        static final C2169am f4412a = new C2169am(0);
    }

    /* synthetic */ C2169am(byte b) {
        this();
    }

    /* renamed from: a */
    public static C2169am m4358a() {
        return C2170a.f4412a;
    }

    private C2169am() {
        C2493fx a = C2493fx.m5237a();
        a.mo28431a("asset", "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, pending_attempts INTEGER NOT NULL, url TEXT NOT NULL, disk_uri TEXT, ts TEXT NOT NULL, created_ts TEXT NOT NULL, ttl TEXT NOT NULL, soft_ttl TEXT NOT NULL)");
        a.mo28434b();
    }

    /* renamed from: a */
    public final synchronized void mo27893a(C2154ad adVar) {
        if (m4359b(adVar) <= 0) {
            ContentValues d = m4364d(adVar);
            C2493fx a = C2493fx.m5237a();
            a.mo28428a("asset", d);
            a.mo28434b();
        }
    }

    @Nullable
    /* renamed from: b */
    static C2154ad m4360b() {
        List a = C2493fx.m5237a().mo28429a("asset", f4410a, null, null, null, null, "ts ASC ", null);
        if (a.size() == 0) {
            return null;
        }
        return m4356a((ContentValues) a.get(0));
    }

    @NonNull
    /* renamed from: c */
    static List<C2154ad> m4362c() {
        ArrayList<C2154ad> arrayList = new ArrayList<>();
        C2493fx a = C2493fx.m5237a();
        C2493fx fxVar = a;
        for (ContentValues a2 : fxVar.mo28429a("asset", f4410a, null, null, null, null, "ts ASC ", null)) {
            arrayList.add(m4356a(a2));
        }
        a.mo28434b();
        ArrayList arrayList2 = new ArrayList();
        for (C2154ad adVar : arrayList) {
            if (!adVar.mo27832a()) {
                arrayList2.add(adVar);
            }
        }
        return arrayList2;
    }

    /* renamed from: d */
    static List<C2154ad> m4365d() {
        ArrayList arrayList = new ArrayList();
        C2493fx a = C2493fx.m5237a();
        if (a.mo28426a("asset") == 0) {
            return arrayList;
        }
        C2493fx fxVar = a;
        List<ContentValues> a2 = fxVar.mo28429a("asset", f4410a, "disk_uri IS NOT NULL", null, null, null, "created_ts DESC ", null);
        a.mo28434b();
        for (ContentValues a3 : a2) {
            arrayList.add(m4356a(a3));
        }
        return arrayList;
    }

    /* renamed from: e */
    public static String m4366e() {
        List<C2154ad> d = m4365d();
        if (d.size() == 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (C2154ad adVar : d) {
            try {
                jSONArray.put(URLEncoder.encode(adVar.f4336d, "UTF-8"));
            } catch (UnsupportedEncodingException unused) {
            }
        }
        return jSONArray.toString();
    }

    @Nullable
    /* renamed from: a */
    static C2154ad m4357a(String str) {
        C2493fx a = C2493fx.m5237a();
        C2493fx fxVar = a;
        List a2 = fxVar.mo28429a("asset", f4410a, "url=? ", new String[]{str}, null, null, "created_ts DESC ", "1");
        a.mo28434b();
        if (a2.isEmpty()) {
            return null;
        }
        return m4356a((ContentValues) a2.get(0));
    }

    /* renamed from: f */
    public static List<String> m4367f() {
        ArrayList arrayList = new ArrayList();
        C2493fx a = C2493fx.m5237a();
        if (a.mo28426a("asset") == 0) {
            return arrayList;
        }
        String str = "url";
        C2493fx fxVar = a;
        List<ContentValues> a2 = fxVar.mo28429a("asset", new String[]{str}, null, null, null, null, "created_ts DESC ", null);
        a.mo28434b();
        for (ContentValues asString : a2) {
            arrayList.add(asString.getAsString(str));
        }
        return arrayList;
    }

    /* renamed from: b */
    public static C2154ad m4361b(String str) {
        C2493fx a = C2493fx.m5237a();
        C2493fx fxVar = a;
        List a2 = fxVar.mo28429a("asset", f4410a, "url=? ", new String[]{str}, null, null, "created_ts DESC ", "1");
        a.mo28434b();
        if (a2.isEmpty()) {
            return null;
        }
        return m4356a((ContentValues) a2.get(0));
    }

    /* renamed from: b */
    public static int m4359b(C2154ad adVar) {
        C2493fx a = C2493fx.m5237a();
        String str = "asset";
        int b = a.mo28432b(str, m4364d(adVar), "url = ?", new String[]{String.valueOf(adVar.f4336d)});
        a.mo28434b();
        return b;
    }

    /* renamed from: c */
    public static void m4363c(C2154ad adVar) {
        C2493fx a = C2493fx.m5237a();
        a.mo28427a("asset", "id = ?", new String[]{String.valueOf(adVar.f4334b)});
        a.mo28434b();
    }

    /* renamed from: a */
    public static C2154ad m4356a(ContentValues contentValues) {
        C2154ad adVar = new C2154ad(contentValues.getAsInteger("id").intValue(), contentValues.getAsString("url"), contentValues.getAsString("disk_uri"), contentValues.getAsInteger("pending_attempts").intValue(), Long.valueOf(contentValues.getAsString("ts")).longValue(), Long.valueOf(contentValues.getAsString("created_ts")).longValue(), Long.valueOf(contentValues.getAsString("ttl")).longValue(), Long.valueOf(contentValues.getAsString("soft_ttl")).longValue());
        return adVar;
    }

    /* renamed from: d */
    private static ContentValues m4364d(C2154ad adVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(adVar.f4334b));
        contentValues.put("url", adVar.f4336d);
        contentValues.put("disk_uri", adVar.f4337e);
        contentValues.put("pending_attempts", Integer.valueOf(adVar.f4335c));
        contentValues.put("ts", Long.toString(adVar.f4338f));
        contentValues.put("created_ts", Long.toString(adVar.f4339g));
        contentValues.put("ttl", Long.toString(adVar.f4340h));
        contentValues.put("soft_ttl", Long.toString(adVar.f4341i));
        return contentValues;
    }
}
