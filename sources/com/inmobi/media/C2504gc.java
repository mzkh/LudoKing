package com.inmobi.media;

import android.content.ContentValues;
import com.facebook.share.internal.MessengerShareContentUtility;

/* renamed from: com.inmobi.media.gc */
/* compiled from: TelemetryEvent */
public class C2504gc {

    /* renamed from: a */
    int f5491a;

    /* renamed from: b */
    String f5492b;

    /* renamed from: c */
    long f5493c;

    /* renamed from: d */
    String f5494d;

    public C2504gc(String str) {
        this.f5492b = str;
        this.f5494d = null;
        this.f5493c = System.currentTimeMillis();
    }

    private C2504gc(String str, String str2) {
        this.f5492b = str;
        this.f5494d = str2;
        this.f5493c = System.currentTimeMillis();
    }

    /* renamed from: a */
    public final String mo28454a() {
        String str = this.f5494d;
        return str == null ? "" : str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f5492b);
        sb.append(" ");
        return sb.toString();
    }

    /* renamed from: a */
    public static C2504gc m5282a(ContentValues contentValues) {
        String asString = contentValues.getAsString("eventType");
        String asString2 = contentValues.getAsString(MessengerShareContentUtility.ATTACHMENT_PAYLOAD);
        long longValue = Long.valueOf(contentValues.getAsString("ts")).longValue();
        C2504gc gcVar = new C2504gc(asString, asString2);
        gcVar.f5493c = longValue;
        gcVar.f5491a = contentValues.getAsInteger("id").intValue();
        return gcVar;
    }
}
