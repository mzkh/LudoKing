package com.inmobi.media;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.PowerManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.GZIPInputStream;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.gi */
/* compiled from: NetworkUtils */
public class C2515gi {

    /* renamed from: a */
    private static final String f5515a = "gi";

    @SuppressLint({"MissingPermission"})
    /* renamed from: a */
    public static boolean m5353a() {
        Context c = C2505gd.m5298c();
        if (c == null) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) c.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected() && !m5356b()) {
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    /* renamed from: b */
    private static boolean m5356b() {
        Context c = C2505gd.m5298c();
        boolean z = false;
        if (c == null) {
            return false;
        }
        try {
            PowerManager powerManager = (PowerManager) c.getSystemService("power");
            if (VERSION.SDK_INT > 22 && powerManager != null) {
                z = powerManager.isDeviceIdleMode();
            }
        } catch (Exception unused) {
        }
        return z;
    }

    /* renamed from: a */
    public static String m5348a(Map<String, String> map, String str) {
        StringBuilder sb = new StringBuilder();
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                if (sb.length() > 0) {
                    sb.append(str);
                }
                sb.append(String.format(Locale.US, "%s=%s", new Object[]{m5346a((String) entry.getKey()), m5346a((String) entry.getValue())}));
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static String m5346a(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    /* renamed from: a */
    public static void m5352a(Map<String, String> map) {
        if (map != null) {
            HashMap hashMap = new HashMap();
            for (Entry entry : map.entrySet()) {
                if (!(entry.getValue() == null || ((String) entry.getValue()).trim().length() == 0 || entry.getKey() == null || ((String) entry.getKey()).trim().length() == 0)) {
                    hashMap.put(((String) entry.getKey()).trim(), ((String) entry.getValue()).trim());
                }
            }
            map.clear();
            map.putAll(hashMap);
        }
    }

    @NonNull
    /* renamed from: a */
    public static HashMap<String, String> m5349a(@Nullable JSONObject jSONObject) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (jSONObject != null) {
            try {
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    hashMap.put(str, jSONObject.getString(str));
                }
            } catch (Exception unused) {
            }
        }
        return hashMap;
    }

    /* renamed from: a */
    public static String m5347a(String str, Map<String, String> map) {
        if (map != null && map.size() > 0) {
            for (Entry entry : map.entrySet()) {
                str = str.replace((CharSequence) entry.getKey(), (CharSequence) entry.getValue());
            }
        }
        return str;
    }

    /* renamed from: a */
    public static byte[] m5355a(@NonNull byte[] bArr) {
        GZIPInputStream gZIPInputStream;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        byte[] bArr2 = null;
        try {
            gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            try {
                bArr2 = m5354a((InputStream) gZIPInputStream);
            } catch (IOException e) {
                e = e;
                try {
                    C2514gh.m5343a(2, f5515a, "Failed to decompress response", e);
                    m5350a((Closeable) byteArrayInputStream);
                    m5350a((Closeable) gZIPInputStream);
                    return bArr2;
                } catch (Throwable th) {
                    th = th;
                }
            }
        } catch (IOException e2) {
            e = e2;
            gZIPInputStream = null;
            C2514gh.m5343a(2, f5515a, "Failed to decompress response", e);
            m5350a((Closeable) byteArrayInputStream);
            m5350a((Closeable) gZIPInputStream);
            return bArr2;
        } catch (Throwable th2) {
            Throwable th3 = th2;
            gZIPInputStream = null;
            th = th3;
            m5350a((Closeable) byteArrayInputStream);
            m5350a((Closeable) gZIPInputStream);
            throw th;
        }
        m5350a((Closeable) byteArrayInputStream);
        m5350a((Closeable) gZIPInputStream);
        return bArr2;
    }

    /* renamed from: a */
    public static byte[] m5354a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (-1 == read) {
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } finally {
                byteArrayOutputStream.close();
            }
        }
    }

    /* renamed from: a */
    public static void m5351a(HttpURLConnection httpURLConnection) {
        try {
            m5350a((Closeable) httpURLConnection.getInputStream());
        } catch (IOException unused) {
        }
    }

    /* renamed from: a */
    public static void m5350a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
