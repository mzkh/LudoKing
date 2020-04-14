package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzxk extends zzwl {
    private final String description;
    private final String zzcfe;

    public zzxk(String str, String str2) {
        this.description = str;
        this.zzcfe = str2;
    }

    public final String getDescription() throws RemoteException {
        return this.description;
    }

    public final String zzov() throws RemoteException {
        return this.zzcfe;
    }
}
