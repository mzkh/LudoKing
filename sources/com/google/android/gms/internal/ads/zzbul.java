package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzbul implements Runnable {
    private final zzbuz zzfla;

    private zzbul(zzbuz zzbuz) {
        this.zzfla = zzbuz;
    }

    static Runnable zza(zzbuz zzbuz) {
        return new zzbul(zzbuz);
    }

    public final void run() {
        this.zzfla.zzahf();
    }
}
