package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
final class zzyq extends zzyp<Long> {
    zzyq(int i, String str, Long l) {
        super(i, str, l, null);
    }

    public final /* synthetic */ Object zza(Bundle bundle) {
        String valueOf = String.valueOf(getKey());
        String str = "com.google.android.gms.ads.flag.";
        if (!bundle.containsKey(valueOf.length() != 0 ? str.concat(valueOf) : new String(str))) {
            return (Long) zzpq();
        }
        String valueOf2 = String.valueOf(getKey());
        return Long.valueOf(bundle.getLong(valueOf2.length() != 0 ? str.concat(valueOf2) : new String(str)));
    }

    public final /* synthetic */ void zza(Editor editor, Object obj) {
        editor.putLong(getKey(), ((Long) obj).longValue());
    }

    public final /* synthetic */ Object zza(JSONObject jSONObject) {
        return Long.valueOf(jSONObject.optLong(getKey(), ((Long) zzpq()).longValue()));
    }

    public final /* synthetic */ Object zza(SharedPreferences sharedPreferences) {
        return Long.valueOf(sharedPreferences.getLong(getKey(), ((Long) zzpq()).longValue()));
    }
}
