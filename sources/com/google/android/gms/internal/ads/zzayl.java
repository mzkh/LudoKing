package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzayl implements Runnable {
    private final /* synthetic */ zzayh zzdxr;
    private final /* synthetic */ String zzdxt;
    private final /* synthetic */ String zzdxu;

    zzayl(zzayh zzayh, String str, String str2) {
        this.zzdxr = zzayh;
        this.zzdxt = str;
        this.zzdxu = str2;
    }

    public final void run() {
        if (this.zzdxr.zzdxp != null) {
            this.zzdxr.zzdxp.zzn(this.zzdxt, this.zzdxu);
        }
    }
}
