package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzato implements Runnable {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzaxv zzdqa;

    zzato(zzatl zzatl, Context context, zzaxv zzaxv) {
        this.val$context = context;
        this.zzdqa = zzaxv;
    }

    public final void run() {
        try {
            this.zzdqa.set(AdvertisingIdClient.getAdvertisingIdInfo(this.val$context));
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException | IllegalStateException e) {
            this.zzdqa.setException(e);
            zzaxi.zzc("Exception while getting advertising Id info", e);
        }
    }
}
