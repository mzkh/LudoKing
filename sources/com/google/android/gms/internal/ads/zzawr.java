package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.webkit.WebSettings;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzawr implements Callable<String> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ Context zzdve;

    zzawr(zzawp zzawp, Context context, Context context2) {
        this.zzdve = context;
        this.val$context = context2;
    }

    public final /* synthetic */ Object call() throws Exception {
        SharedPreferences sharedPreferences;
        String str = "admob_user_agent";
        boolean z = false;
        if (this.zzdve != null) {
            zzaug.zzdy("Attempting to read user agent from Google Play Services.");
            sharedPreferences = this.zzdve.getSharedPreferences(str, 0);
        } else {
            zzaug.zzdy("Attempting to read user agent from local cache.");
            sharedPreferences = this.val$context.getSharedPreferences(str, 0);
            z = true;
        }
        String str2 = "user_agent";
        String string = sharedPreferences.getString(str2, "");
        if (TextUtils.isEmpty(string)) {
            zzaug.zzdy("Reading user agent from WebSettings");
            string = WebSettings.getDefaultUserAgent(this.val$context);
            if (z) {
                sharedPreferences.edit().putString(str2, string).apply();
                zzaug.zzdy("Persisting user agent.");
            }
        }
        return string;
    }
}
