package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzasu implements zzatc {
    static final zzatc zzdpu = new zzasu();

    private zzasu() {
    }

    public final Object zza(zzbeb zzbeb) {
        String currentScreenName = zzbeb.getCurrentScreenName();
        if (currentScreenName != null) {
            return currentScreenName;
        }
        String currentScreenClass = zzbeb.getCurrentScreenClass();
        return currentScreenClass != null ? currentScreenClass : "";
    }
}
