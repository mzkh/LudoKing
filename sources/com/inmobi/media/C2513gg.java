package com.inmobi.media;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.drive.DriveFile;
import java.net.URISyntaxException;
import java.net.URLDecoder;

/* renamed from: com.inmobi.media.gg */
/* compiled from: ClickUrlHandler */
public class C2513gg {

    /* renamed from: a */
    private static final String f5513a = "gg";

    /* renamed from: a */
    public static boolean m5336a(Context context, String str) {
        if (str == null) {
            return false;
        }
        if (context == null) {
            return m5337a(Uri.parse(str));
        }
        try {
            if (new Intent("android.intent.action.VIEW", Uri.parse(str)).resolveActivity(context.getPackageManager()) != null) {
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    /* renamed from: b */
    public static void m5340b(Context context, @NonNull String str) throws URISyntaxException, ActivityNotFoundException {
        while (context != null) {
            try {
                Intent parseUri = Intent.parseUri(str, 0);
                parseUri.setFlags(DriveFile.MODE_READ_ONLY);
                context.startActivity(parseUri);
                return;
            } catch (ActivityNotFoundException e) {
                if ("intent".equals(Uri.parse(str).getScheme())) {
                    str = m5339b(str);
                    if (TextUtils.isEmpty(str)) {
                    }
                }
                throw e;
            }
        }
    }

    @Nullable
    /* renamed from: a */
    public static String m5335a(Context context, @NonNull String str, @Nullable String str2) {
        if (context == null) {
            return null;
        }
        try {
            Intent parseUri = Intent.parseUri(str, 0);
            if (parseUri.resolveActivity(context.getPackageManager()) != null) {
                parseUri.setFlags(DriveFile.MODE_READ_ONLY);
                context.startActivity(parseUri);
                return str;
            } else if (!TextUtils.isEmpty(str2)) {
                return m5335a(context, str2, null);
            } else {
                if ("intent".equals(Uri.parse(str).getScheme())) {
                    String b = m5339b(str);
                    if (!TextUtils.isEmpty(b)) {
                        return m5335a(context, URLDecoder.decode(b, "UTF-8"), null);
                    }
                }
                return null;
            }
        } catch (Exception unused) {
        }
    }

    @Nullable
    /* renamed from: b */
    private static String m5339b(String str) {
        try {
            return Intent.parseUri(str, 1).getStringExtra("browser_fallback_url");
        } catch (URISyntaxException unused) {
            return null;
        }
    }

    /* renamed from: a */
    private static boolean m5337a(Uri uri) {
        if (!"http".equals(uri.getScheme())) {
            if (!"https".equals(uri.getScheme())) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m5338a(@NonNull String str) {
        Uri parse = Uri.parse(str);
        if (m5337a(parse)) {
            if (!"play.google.com".equals(parse.getHost())) {
                if (!"market.android.com".equals(parse.getHost())) {
                    if (!"market".equals(parse.getScheme())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
