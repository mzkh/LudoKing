package com.google.android.gms.ads.consent;

import android.content.Context;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.ads.zzzl;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public class ConsentSdkUtil {

    /* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
    public interface ConsentInformationCallback {
        void onFailure(int i);

        void onSuccess(String str);
    }

    private ConsentSdkUtil() {
    }

    @KeepForSdk
    public static void requestConsentInformation(Context context, Map<String, String> map, ConsentInformationCallback consentInformationCallback) {
        zzzl.zzj(context.getApplicationContext()).zza(map, consentInformationCallback);
    }
}
