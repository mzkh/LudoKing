package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
final class zzyo extends zzyp<Boolean> {
    zzyo(int i, String str, Boolean bool) {
        super(i, str, bool, null);
    }

    public final /* synthetic */ Object zza(Bundle bundle) {
        String valueOf = String.valueOf(getKey());
        String str = "com.google.android.gms.ads.flag.";
        if (!bundle.containsKey(valueOf.length() != 0 ? str.concat(valueOf) : new String(str))) {
            return (Boolean) zzpq();
        }
        String valueOf2 = String.valueOf(getKey());
        return Boolean.valueOf(bundle.getBoolean(valueOf2.length() != 0 ? str.concat(valueOf2) : new String(str)));
    }

    public final /* synthetic */ void zza(Editor editor, Object obj) {
        editor.putBoolean(getKey(), ((Boolean) obj).booleanValue());
    }

    public final /* synthetic */ Object zza(JSONObject jSONObject) {
        return Boolean.valueOf(jSONObject.optBoolean(getKey(), ((Boolean) zzpq()).booleanValue()));
    }

    public final /* synthetic */ Object zza(SharedPreferences sharedPreferences) {
        return Boolean.valueOf(sharedPreferences.getBoolean(getKey(), ((Boolean) zzpq()).booleanValue()));
    }
}
