package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.net.Uri;
import android.webkit.WebResourceRequest;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbdy {
    private final String method;
    public final Uri uri;
    public final String url;
    public final Map<String, String> zzab;

    @TargetApi(21)
    public zzbdy(WebResourceRequest webResourceRequest) {
        this(webResourceRequest.getUrl().toString(), webResourceRequest.getUrl(), webResourceRequest.getMethod(), webResourceRequest.getRequestHeaders());
    }

    public zzbdy(String str) {
        this(str, Uri.parse(str), null, null);
    }

    private zzbdy(String str, Uri uri2, @Nullable String str2, @Nullable Map<String, String> map) {
        this.url = str;
        this.uri = uri2;
        if (str2 == null) {
            str2 = "GET";
        }
        this.method = str2;
        if (map == null) {
            map = Collections.emptyMap();
        }
        this.zzab = map;
    }
}
