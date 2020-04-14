package com.inmobi.media;

import android.content.ContentValues;
import com.tapjoy.TJAdUnitConstants.String;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.ar */
/* compiled from: ClickDao */
public class C2184ar {

    /* renamed from: a */
    static final String[] f4455a = {"id", "pending_attempts", "url", "ping_in_webview", "follow_redirect", "ts", "created_ts", "track_extras"};

    /* renamed from: b */
    private static final String f4456b = "ar";

    C2184ar() {
        C2493fx a = C2493fx.m5237a();
        a.mo28431a(String.CLICK, "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, pending_attempts INTEGER NOT NULL, url TEXT NOT NULL, ping_in_webview TEXT NOT NULL, follow_redirect TEXT NOT NULL, ts TEXT NOT NULL, track_extras TEXT, created_ts TEXT NOT NULL )");
        a.mo28434b();
    }

    /* renamed from: a */
    public static boolean m4429a() {
        return C2493fx.m5237a().mo28426a(String.CLICK) == 0;
    }

    /* renamed from: a */
    public final synchronized void mo27907a(C2183aq aqVar, int i) {
        ContentValues b = m4430b(aqVar);
        C2493fx a = C2493fx.m5237a();
        if (a.mo28426a(String.CLICK) >= i) {
            m4428a(m4426a((ContentValues) a.mo28429a(String.CLICK, f4455a, "ts= (SELECT MIN(ts) FROM click LIMIT 1)", null, null, null, null, null).get(0)));
        }
        a.mo28428a(String.CLICK, b);
        a.mo28434b();
    }

    /* renamed from: a */
    public static void m4428a(C2183aq aqVar) {
        C2493fx a = C2493fx.m5237a();
        a.mo28427a(String.CLICK, "id = ?", new String[]{String.valueOf(aqVar.f4446a)});
        a.mo28434b();
    }

    /* renamed from: a */
    static C2183aq m4426a(ContentValues contentValues) {
        int intValue = contentValues.getAsInteger("id").intValue();
        int intValue2 = contentValues.getAsInteger("pending_attempts").intValue();
        String asString = contentValues.getAsString("url");
        long longValue = Long.valueOf(contentValues.getAsString("ts")).longValue();
        long longValue2 = Long.valueOf(contentValues.getAsString("created_ts")).longValue();
        boolean booleanValue = Boolean.valueOf(contentValues.getAsString("follow_redirect")).booleanValue();
        boolean booleanValue2 = Boolean.valueOf(contentValues.getAsString("ping_in_webview")).booleanValue();
        String asString2 = contentValues.getAsString("track_extras");
        HashMap hashMap = new HashMap();
        if (asString2 != null) {
            try {
                hashMap.putAll(m4427a(new JSONObject(asString2)));
            } catch (Exception | JSONException unused) {
            }
        }
        C2183aq aqVar = new C2183aq(intValue, asString, hashMap, booleanValue, booleanValue2, intValue2, longValue, longValue2);
        return aqVar;
    }

    /* renamed from: b */
    static ContentValues m4430b(C2183aq aqVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(aqVar.f4446a));
        contentValues.put("url", aqVar.f4447b);
        contentValues.put("pending_attempts", Integer.valueOf(aqVar.f4451f));
        contentValues.put("ts", Long.toString(aqVar.f4449d));
        contentValues.put("created_ts", Long.toString(aqVar.f4450e));
        contentValues.put("follow_redirect", Boolean.toString(aqVar.f4454i));
        contentValues.put("ping_in_webview", Boolean.toString(aqVar.f4453h));
        if (aqVar.f4448c != null && aqVar.f4448c.size() > 0) {
            contentValues.put("track_extras", new JSONObject(aqVar.f4448c).toString());
        }
        return contentValues;
    }

    /* renamed from: a */
    private static Map<String, String> m4427a(JSONObject jSONObject) throws JSONException {
        HashMap hashMap = new HashMap();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            hashMap.put(str, (String) jSONObject.get(str));
        }
        return hashMap;
    }
}
