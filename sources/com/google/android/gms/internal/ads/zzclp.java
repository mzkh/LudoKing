package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzclp {
    private final zzchm zzfsy;
    private final ConcurrentHashMap<String, zzamd> zzgbf = new ConcurrentHashMap<>();

    public zzclp(zzchm zzchm) {
        this.zzfsy = zzchm;
    }

    public final void zzgb(String str) {
        try {
            this.zzgbf.put(str, this.zzfsy.zzdd(str));
        } catch (RemoteException e) {
            zzaug.zzc("Couldn't create RTB adapter : ", e);
        }
    }

    @CheckForNull
    public final zzamd zzgc(String str) {
        if (this.zzgbf.containsKey(str)) {
            return (zzamd) this.zzgbf.get(str);
        }
        return null;
    }
}
