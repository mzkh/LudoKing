package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
final class zzyr extends zzyp<Integer> {
    zzyr(int i, String str, Integer num) {
        super(i, str, num, null);
    }

    public final /* synthetic */ Object zza(Bundle bundle) {
        String valueOf = String.valueOf(getKey());
        String str = "com.google.android.gms.ads.flag.";
        if (!bundle.containsKey(valueOf.length() != 0 ? str.concat(valueOf) : new String(str))) {
            return (Integer) zzpq();
        }
        String valueOf2 = String.valueOf(getKey());
        return Integer.valueOf(bundle.getInt(valueOf2.length() != 0 ? str.concat(valueOf2) : new String(str)));
    }

    public final /* synthetic */ void zza(Editor editor, Object obj) {
        editor.putInt(getKey(), ((Integer) obj).intValue());
    }

    public final /* synthetic */ Object zza(JSONObject jSONObject) {
        return Integer.valueOf(jSONObject.optInt(getKey(), ((Integer) zzpq()).intValue()));
    }

    public final /* synthetic */ Object zza(SharedPreferences sharedPreferences) {
        return Integer.valueOf(sharedPreferences.getInt(getKey(), ((Integer) zzpq()).intValue()));
    }
}
