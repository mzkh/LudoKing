package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
abstract class zzus<T> {
    @Nullable
    private static final zzvu zzcdm = zzog();

    zzus() {
    }

    /* access modifiers changed from: protected */
    @Nullable
    public abstract T zza(zzvu zzvu) throws RemoteException;

    /* access modifiers changed from: protected */
    @NonNull
    public abstract T zzoe();

    /* access modifiers changed from: protected */
    @Nullable
    public abstract T zzof() throws RemoteException;

    private static zzvu zzog() {
        try {
            Object newInstance = zzug.class.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            if (!(newInstance instanceof IBinder)) {
                zzaxi.zzeu("ClientApi class is not an instance of IBinder.");
                return null;
            }
            IBinder iBinder = (IBinder) newInstance;
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IClientApi");
            if (queryLocalInterface instanceof zzvu) {
                return (zzvu) queryLocalInterface;
            }
            return new zzvw(iBinder);
        } catch (Exception unused) {
            zzaxi.zzeu("Failed to instantiate ClientApi class.");
            return null;
        }
    }

    @Nullable
    private final T zzoh() {
        zzvu zzvu = zzcdm;
        if (zzvu == null) {
            zzaxi.zzeu("ClientApi class cannot be loaded.");
            return null;
        }
        try {
            return zza(zzvu);
        } catch (RemoteException e) {
            zzaxi.zzd("Cannot invoke local loader using ClientApi class.", e);
            return null;
        }
    }

    @Nullable
    private final T zzoi() {
        try {
            return zzof();
        } catch (RemoteException e) {
            zzaxi.zzd("Cannot invoke remote loader.", e);
            return null;
        }
    }

    public final T zzd(Context context, boolean z) {
        T t;
        boolean z2 = false;
        boolean z3 = z;
        if (!z3) {
            zzuv.zzoj();
            if (!zzawy.zzc(context, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE)) {
                zzaxi.zzdv("Google Play Services is not available.");
                z3 = true;
            }
        }
        String str = ModuleDescriptor.MODULE_ID;
        if (DynamiteModule.getLocalVersion(context, str) > DynamiteModule.getRemoteVersion(context, str)) {
            z3 = true;
        }
        zzza.initialize(context);
        if (((Boolean) zzuv.zzon().zzd(zzza.zzcqr)).booleanValue()) {
            z3 = false;
        }
        if (z3) {
            t = zzoh();
            if (t == null) {
                t = zzoi();
            }
        } else {
            T zzoi = zzoi();
            int i = zzoi == null ? 1 : 0;
            if (i != 0) {
                if (zzuv.zzoq().nextInt(((Integer) zzuv.zzon().zzd(zzza.zzcta)).intValue()) == 0) {
                    z2 = true;
                }
                if (z2) {
                    Bundle bundle = new Bundle();
                    bundle.putString(NativeProtocol.WEB_DIALOG_ACTION, "dynamite_load");
                    bundle.putInt("is_missing", i);
                    zzuv.zzoj().zza(context, zzuv.zzop().zzblz, "gmob-apps", bundle, true);
                }
            }
            t = zzoi == null ? zzoh() : zzoi;
        }
        return t == null ? zzoe() : t;
    }
}
