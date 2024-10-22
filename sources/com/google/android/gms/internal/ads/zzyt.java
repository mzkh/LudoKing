package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
final class zzyt extends zzyp<Float> {
    zzyt(int i, String str, Float f) {
        super(i, str, f, null);
    }

    public final /* synthetic */ Object zza(Bundle bundle) {
        String valueOf = String.valueOf(getKey());
        String str = "com.google.android.gms.ads.flag.";
        if (!bundle.containsKey(valueOf.length() != 0 ? str.concat(valueOf) : new String(str))) {
            return (Float) zzpq();
        }
        String valueOf2 = String.valueOf(getKey());
        return Float.valueOf(bundle.getFloat(valueOf2.length() != 0 ? str.concat(valueOf2) : new String(str)));
    }

    public final /* synthetic */ void zza(Editor editor, Object obj) {
        editor.putFloat(getKey(), ((Float) obj).floatValue());
    }

    public final /* synthetic */ Object zza(JSONObject jSONObject) {
        return Float.valueOf((float) jSONObject.optDouble(getKey(), (double) ((Float) zzpq()).floatValue()));
    }

    public final /* synthetic */ Object zza(SharedPreferences sharedPreferences) {
        return Float.valueOf(sharedPreferences.getFloat(getKey(), ((Float) zzpq()).floatValue()));
    }
}
