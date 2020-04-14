package com.google.android.gms.internal.ads;

import android.util.JsonWriter;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.util.Clock;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcbv {
    private final Clock zzbmp;

    public zzcbv(Clock clock) {
        this.zzbmp = clock;
    }

    public final void zza(List<Object> list, String str, String str2, Object... objArr) {
        if (((Boolean) zzuv.zzon().zzd(zzza.zzclv)).booleanValue()) {
            long currentTimeMillis = this.zzbmp.currentTimeMillis();
            StringWriter stringWriter = new StringWriter();
            JsonWriter jsonWriter = new JsonWriter(stringWriter);
            try {
                jsonWriter.beginObject();
                jsonWriter.name("timestamp").value(currentTimeMillis);
                jsonWriter.name("source").value(str);
                jsonWriter.name("event").value(str2);
                jsonWriter.name("components").beginArray();
                for (Object obj : list) {
                    jsonWriter.value(obj.toString());
                }
                jsonWriter.endArray();
                jsonWriter.name(NativeProtocol.WEB_DIALOG_PARAMS).beginArray();
                int length = objArr.length;
                for (int i = 0; i < length; i++) {
                    Object obj2 = objArr[i];
                    jsonWriter.value(obj2 != null ? obj2.toString() : null);
                }
                jsonWriter.endArray();
                jsonWriter.endObject();
                jsonWriter.flush();
                jsonWriter.close();
            } catch (IOException e) {
                zzaug.zzc("unable to log", e);
            }
            String str3 = "AD-DBG ";
            String valueOf = String.valueOf(stringWriter.toString());
            zzaug.zzet(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
        }
    }
}
