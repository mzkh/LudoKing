package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public class zzamj {
    public static zzamd zzdk(String str) throws RemoteException {
        try {
            return new zzami((RtbAdapter) Class.forName(str, false, zzamj.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        } catch (Throwable unused) {
            throw new RemoteException();
        }
    }
}
