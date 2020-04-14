package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.util.JsonWriter;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.games.GamesStatusCodes;
import java.io.IOException;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzaxc {
    @GuardedBy("lock")
    private static boolean enabled = false;
    private static Object lock = new Object();
    private static Clock zzbmp = DefaultClock.getInstance();
    @GuardedBy("lock")
    private static boolean zzdvy = false;
    private static final Set<String> zzdvz = new HashSet(Arrays.asList(new String[0]));
    private final List<String> zzdwa;

    public zzaxc() {
        this(null);
    }

    public zzaxc(@Nullable String str) {
        List<String> list;
        if (!isEnabled()) {
            list = new ArrayList<>();
        } else {
            String[] strArr = new String[1];
            String str2 = "network_request_";
            String valueOf = String.valueOf(UUID.randomUUID().toString());
            strArr[0] = valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2);
            list = Arrays.asList(strArr);
        }
        this.zzdwa = list;
    }

    public final void zza(HttpURLConnection httpURLConnection, @Nullable byte[] bArr) {
        HashMap hashMap;
        if (isEnabled()) {
            if (httpURLConnection.getRequestProperties() == null) {
                hashMap = null;
            } else {
                hashMap = new HashMap(httpURLConnection.getRequestProperties());
            }
            zzb(new String(httpURLConnection.getURL().toString()), new String(httpURLConnection.getRequestMethod()), hashMap, bArr);
        }
    }

    public final void zza(String str, String str2, @Nullable Map<String, ?> map, @Nullable byte[] bArr) {
        if (isEnabled()) {
            zzb(str, str2, map, bArr);
        }
    }

    private final void zzb(String str, String str2, @Nullable Map<String, ?> map, @Nullable byte[] bArr) {
        zza("onNetworkRequest", (zzaxf) new zzaxb(str, str2, map, bArr));
    }

    public final void zza(HttpURLConnection httpURLConnection, int i) {
        if (isEnabled()) {
            String str = null;
            zzb(httpURLConnection.getHeaderFields() == null ? null : new HashMap(httpURLConnection.getHeaderFields()), i);
            if (i < 200 || i >= 300) {
                try {
                    str = httpURLConnection.getResponseMessage();
                } catch (IOException e) {
                    String str2 = "Can not get error message from error HttpURLConnection\n";
                    String valueOf = String.valueOf(e.getMessage());
                    zzaxi.zzeu(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                }
                zzeq(str);
            }
        }
    }

    public final void zza(@Nullable Map<String, ?> map, int i) {
        if (isEnabled()) {
            zzb(map, i);
            if (i < 200 || i >= 300) {
                zzeq(null);
            }
        }
    }

    private final void zzb(@Nullable Map<String, ?> map, int i) {
        zza("onNetworkResponse", (zzaxf) new zzaxe(i, map));
    }

    public final void zzep(@Nullable String str) {
        if (isEnabled() && str != null) {
            zzi(str.getBytes());
        }
    }

    public final void zzi(byte[] bArr) {
        zza("onNetworkResponseBody", (zzaxf) new zzaxd(bArr));
    }

    private final void zzeq(@Nullable String str) {
        zza("onNetworkRequestError", (zzaxf) new zzaxg(str));
    }

    private static void zza(JsonWriter jsonWriter, @Nullable Map<String, ?> map) throws IOException {
        if (map != null) {
            jsonWriter.name("headers").beginArray();
            Iterator it = map.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Entry entry = (Entry) it.next();
                String str = (String) entry.getKey();
                if (!zzdvz.contains(str)) {
                    String str2 = "value";
                    String str3 = "name";
                    if (!(entry.getValue() instanceof List)) {
                        if (!(entry.getValue() instanceof String)) {
                            zzaxi.zzes("Connection headers should be either Map<String, String> or Map<String, List<String>>");
                            break;
                        }
                        jsonWriter.beginObject();
                        jsonWriter.name(str3).value(str);
                        jsonWriter.name(str2).value((String) entry.getValue());
                        jsonWriter.endObject();
                    } else {
                        for (String str4 : (List) entry.getValue()) {
                            jsonWriter.beginObject();
                            jsonWriter.name(str3).value(str);
                            jsonWriter.name(str2).value(str4);
                            jsonWriter.endObject();
                        }
                    }
                }
            }
            jsonWriter.endArray();
        }
    }

    private final void zza(String str, zzaxf zzaxf) {
        StringWriter stringWriter = new StringWriter();
        JsonWriter jsonWriter = new JsonWriter(stringWriter);
        try {
            jsonWriter.beginObject();
            jsonWriter.name("timestamp").value(zzbmp.currentTimeMillis());
            jsonWriter.name("event").value(str);
            jsonWriter.name("components").beginArray();
            for (String value : this.zzdwa) {
                jsonWriter.value(value);
            }
            jsonWriter.endArray();
            zzaxf.zzb(jsonWriter);
            jsonWriter.endObject();
            jsonWriter.flush();
            jsonWriter.close();
        } catch (IOException e) {
            zzaxi.zzc("unable to log", e);
        }
        zzer(stringWriter.toString());
    }

    private static synchronized void zzer(String str) {
        synchronized (zzaxc.class) {
            zzaxi.zzet("GMA Debug BEGIN");
            int i = 0;
            while (i < str.length()) {
                int i2 = i + GamesStatusCodes.STATUS_SNAPSHOT_NOT_FOUND;
                String str2 = "GMA Debug CONTENT ";
                String valueOf = String.valueOf(str.substring(i, Math.min(i2, str.length())));
                zzaxi.zzet(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                i = i2;
            }
            zzaxi.zzet("GMA Debug FINISH");
        }
    }

    public static void zzwm() {
        synchronized (lock) {
            zzdvy = false;
            enabled = false;
            zzaxi.zzeu("Ad debug logging enablement is out of date.");
        }
    }

    public static void zzak(boolean z) {
        synchronized (lock) {
            zzdvy = true;
            enabled = z;
        }
    }

    public static boolean zzwn() {
        boolean z;
        synchronized (lock) {
            z = zzdvy;
        }
        return z;
    }

    public static boolean isEnabled() {
        boolean z;
        synchronized (lock) {
            z = zzdvy && enabled;
        }
        return z;
    }

    public static boolean zzbo(Context context) {
        if (VERSION.SDK_INT < 17) {
            return false;
        }
        if (!((Boolean) zzuv.zzon().zzd(zzza.zzclr)).booleanValue()) {
            return false;
        }
        try {
            if (Global.getInt(context.getContentResolver(), "development_settings_enabled", 0) != 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            zzaxi.zzd("Fail to determine debug setting.", e);
            return false;
        }
    }

    static final /* synthetic */ void zza(String str, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name(NativeProtocol.WEB_DIALOG_PARAMS).beginObject();
        if (str != null) {
            jsonWriter.name(NativeProtocol.BRIDGE_ARG_ERROR_DESCRIPTION).value(str);
        }
        jsonWriter.endObject();
    }

    static final /* synthetic */ void zza(byte[] bArr, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name(NativeProtocol.WEB_DIALOG_PARAMS).beginObject();
        int length = bArr.length;
        String encode = Base64Utils.encode(bArr);
        if (length < 10000) {
            jsonWriter.name("body").value(encode);
        } else {
            String zzen = zzawy.zzen(encode);
            if (zzen != null) {
                jsonWriter.name("bodydigest").value(zzen);
            }
        }
        jsonWriter.name("bodylength").value((long) length);
        jsonWriter.endObject();
    }

    static final /* synthetic */ void zza(int i, Map map, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name(NativeProtocol.WEB_DIALOG_PARAMS).beginObject();
        jsonWriter.name("firstline").beginObject();
        jsonWriter.name("code").value((long) i);
        jsonWriter.endObject();
        zza(jsonWriter, map);
        jsonWriter.endObject();
    }

    static final /* synthetic */ void zza(String str, String str2, Map map, byte[] bArr, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name(NativeProtocol.WEB_DIALOG_PARAMS).beginObject();
        jsonWriter.name("firstline").beginObject();
        jsonWriter.name(ShareConstants.MEDIA_URI).value(str);
        jsonWriter.name("verb").value(str2);
        jsonWriter.endObject();
        zza(jsonWriter, map);
        if (bArr != null) {
            jsonWriter.name("body").value(Base64Utils.encode(bArr));
        }
        jsonWriter.endObject();
    }
}
