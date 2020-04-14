package com.google.android.gms.ads.mediation;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public interface MediationAdapter extends MediationExtrasReceiver {

    /* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
    public static class zza {
        private int zzein;

        public final zza zzdc(int i) {
            this.zzein = 1;
            return this;
        }

        public final Bundle zzaaz() {
            Bundle bundle = new Bundle();
            bundle.putInt("capabilities", this.zzein);
            return bundle;
        }
    }

    void onDestroy();

    void onPause();

    void onResume();
}
