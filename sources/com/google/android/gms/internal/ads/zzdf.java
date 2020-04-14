package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdf {
    private static final String[] zzwy = {"/aclk", "/pcs/click", "/dbm/clk"};
    private String zzwu = "googleads.g.doubleclick.net";
    private String zzwv = "/pagead/ads";
    private String zzww = "ad.doubleclick.net";
    private String[] zzwx = {".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};
    private zzdc zzwz;

    public zzdf(zzdc zzdc) {
        this.zzwz = zzdc;
    }

    public final void zzb(String str, String str2) {
        this.zzwu = str;
        this.zzwv = str2;
    }

    public final boolean zza(Uri uri) {
        if (uri != null) {
            try {
                if (uri.getHost().equals(this.zzwu) && uri.getPath().equals(this.zzwv)) {
                    return true;
                }
            } catch (NullPointerException unused) {
            }
            return false;
        }
        throw new NullPointerException();
    }

    private final boolean zzb(Uri uri) {
        if (uri != null) {
            try {
                return uri.getHost().equals(this.zzww);
            } catch (NullPointerException unused) {
                return false;
            }
        } else {
            throw new NullPointerException();
        }
    }

    public final boolean zzc(Uri uri) {
        if (uri != null) {
            try {
                String host = uri.getHost();
                for (String endsWith : this.zzwx) {
                    if (host.endsWith(endsWith)) {
                        return true;
                    }
                }
            } catch (NullPointerException unused) {
            }
            return false;
        }
        throw new NullPointerException();
    }

    public final void zzap(String str) {
        this.zzwx = str.split(",");
    }

    public final zzdc zzcd() {
        return this.zzwz;
    }

    public final Uri zza(Uri uri, Context context) throws zzdi {
        return zza(uri, this.zzwz.zza(context));
    }

    public final void zzb(MotionEvent motionEvent) {
        this.zzwz.zzb(motionEvent);
    }

    @Deprecated
    public final Uri zzb(Uri uri, Context context) throws zzdi {
        return zza(uri, context, null, null);
    }

    public final Uri zza(Uri uri, Context context, View view, Activity activity) throws zzdi {
        try {
            return zza(uri, this.zzwz.zza(context, uri.getQueryParameter("ai"), view, activity));
        } catch (UnsupportedOperationException unused) {
            throw new zzdi("Provided Uri is not in a valid state");
        }
    }

    public final boolean zzd(Uri uri) {
        if (zzc(uri)) {
            for (String endsWith : zzwy) {
                if (uri.getPath().endsWith(endsWith)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final Uri zza(Uri uri, String str) throws zzdi {
        try {
            boolean zzb = zzb(uri);
            String str2 = "ms";
            if (zzb) {
                if (uri.toString().contains("dc_ms=")) {
                    throw new zzdi("Parameter already exists: dc_ms");
                }
            } else if (uri.getQueryParameter(str2) != null) {
                throw new zzdi("Query parameter already exists: ms");
            }
            String str3 = "=";
            if (zzb) {
                String str4 = "dc_ms";
                String uri2 = uri.toString();
                int indexOf = uri2.indexOf(";adurl");
                String str5 = ";";
                if (indexOf != -1) {
                    int i = indexOf + 1;
                    StringBuilder sb = new StringBuilder(uri2.substring(0, i));
                    sb.append(str4);
                    sb.append(str3);
                    sb.append(str);
                    sb.append(str5);
                    sb.append(uri2.substring(i));
                    return Uri.parse(sb.toString());
                }
                String encodedPath = uri.getEncodedPath();
                int indexOf2 = uri2.indexOf(encodedPath);
                StringBuilder sb2 = new StringBuilder(uri2.substring(0, encodedPath.length() + indexOf2));
                sb2.append(str5);
                sb2.append(str4);
                sb2.append(str3);
                sb2.append(str);
                sb2.append(str5);
                sb2.append(uri2.substring(indexOf2 + encodedPath.length()));
                return Uri.parse(sb2.toString());
            }
            String uri3 = uri.toString();
            int indexOf3 = uri3.indexOf("&adurl");
            if (indexOf3 == -1) {
                indexOf3 = uri3.indexOf("?adurl");
            }
            if (indexOf3 == -1) {
                return uri.buildUpon().appendQueryParameter(str2, str).build();
            }
            int i2 = indexOf3 + 1;
            StringBuilder sb3 = new StringBuilder(uri3.substring(0, i2));
            sb3.append(str2);
            sb3.append(str3);
            sb3.append(str);
            sb3.append("&");
            sb3.append(uri3.substring(i2));
            return Uri.parse(sb3.toString());
        } catch (UnsupportedOperationException unused) {
            throw new zzdi("Provided Uri is not in a valid state");
        }
    }
}
