package com.inmobi.media;

import android.net.Uri;
import androidx.annotation.NonNull;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.af */
/* compiled from: AdAssetFetcher */
public final class C2157af {

    /* renamed from: b */
    private static final String f4363b = "af";

    /* renamed from: a */
    C2171an f4364a;

    C2157af(C2171an anVar) {
        this.f4364a = anVar;
    }

    /* renamed from: a */
    static String m4277a(@NonNull C2154ad adVar, File file, long j, long j2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", adVar.f4336d);
            jSONObject.put("saved_url", Uri.fromFile(file));
            jSONObject.put("size_in_bytes", file.length());
            jSONObject.put("download_started_at", j);
            jSONObject.put("download_ended_at", j2);
        } catch (JSONException e) {
            C2463fd.m5161a().mo28382a(new C2495fz(e));
        }
        return jSONObject.toString().replace("\"", "\\\"");
    }

    /* renamed from: a */
    static void m4278a(long j, long j2, long j3) {
        try {
            C2566hi.m5571a().mo28564a(0);
            C2566hi.m5571a().mo28565b(j2);
            C2566hi.m5571a().mo28566c(j3 - j);
        } catch (Exception e) {
            C2463fd.m5161a().mo28382a(new C2495fz(e));
        }
    }
}
