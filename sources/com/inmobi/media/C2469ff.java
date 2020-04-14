package com.inmobi.media;

import android.content.ContentValues;
import android.util.Log;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.ff */
/* compiled from: CrashEvent */
public class C2469ff {

    /* renamed from: g */
    private static final String f5371g = "ff";

    /* renamed from: a */
    int f5372a;

    /* renamed from: b */
    String f5373b;

    /* renamed from: c */
    String f5374c;

    /* renamed from: d */
    String f5375d;

    /* renamed from: e */
    long f5376e;

    /* renamed from: f */
    protected String f5377f;

    public C2469ff(Thread thread, Throwable th) {
        this("crashReporting", "CrashEvent");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", th.getClass().getSimpleName());
            jSONObject.put("message", th.getMessage());
            jSONObject.put("stack", Log.getStackTraceString(th));
            jSONObject.put("thread", thread.getName());
            this.f5377f = jSONObject.toString();
        } catch (JSONException unused) {
        }
    }

    public C2469ff(String str, String str2) {
        this.f5373b = UUID.randomUUID().toString();
        this.f5375d = str;
        this.f5374c = str2;
        this.f5377f = null;
        this.f5376e = System.currentTimeMillis();
    }

    private C2469ff(String str, String str2, String str3, String str4) {
        this.f5373b = str;
        this.f5375d = str2;
        this.f5374c = str3;
        this.f5377f = str4;
        this.f5376e = System.currentTimeMillis();
    }

    /* renamed from: a */
    public final String mo28394a() {
        String str = this.f5377f;
        return str == null ? "" : str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f5374c);
        sb.append("@");
        sb.append(this.f5375d);
        sb.append(" ");
        return sb.toString();
    }

    /* renamed from: a */
    public static C2469ff m5180a(ContentValues contentValues) {
        String asString = contentValues.getAsString("eventId");
        String asString2 = contentValues.getAsString("eventType");
        String asString3 = contentValues.getAsString("componentType");
        String asString4 = contentValues.getAsString(MessengerShareContentUtility.ATTACHMENT_PAYLOAD);
        long longValue = Long.valueOf(contentValues.getAsString("ts")).longValue();
        C2469ff ffVar = new C2469ff(asString, asString3, asString2, asString4);
        ffVar.f5376e = longValue;
        ffVar.f5372a = contentValues.getAsInteger("id").intValue();
        return ffVar;
    }
}
