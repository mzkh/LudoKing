package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public abstract class zzvx extends zzfm implements zzvu {
    public zzvx() {
        super("com.google.android.gms.ads.internal.client.IClientApi");
    }

    /* access modifiers changed from: protected */
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zzvl zza = zza(Stub.asInterface(parcel.readStrongBinder()), (zzua) zzfp.zza(parcel, zzua.CREATOR), parcel.readString(), zzajw.zzaa(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzfp.zza(parcel2, (IInterface) zza);
                break;
            case 2:
                zzvl zzb = zzb(Stub.asInterface(parcel.readStrongBinder()), (zzua) zzfp.zza(parcel, zzua.CREATOR), parcel.readString(), zzajw.zzaa(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzfp.zza(parcel2, (IInterface) zzb);
                break;
            case 3:
                zzve zza2 = zza(Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), zzajw.zzaa(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzfp.zza(parcel2, (IInterface) zza2);
                break;
            case 4:
                zzwb zzg = zzg(Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzfp.zza(parcel2, (IInterface) zzg);
                break;
            case 5:
                zzabm zzc = zzc(Stub.asInterface(parcel.readStrongBinder()), Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzfp.zza(parcel2, (IInterface) zzc);
                break;
            case 6:
                zzaqb zza3 = zza(Stub.asInterface(parcel.readStrongBinder()), zzajw.zzaa(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzfp.zza(parcel2, (IInterface) zza3);
                break;
            case 7:
                zzany zzh = zzh(Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzfp.zza(parcel2, (IInterface) zzh);
                break;
            case 8:
                zzano zzf = zzf(Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzfp.zza(parcel2, (IInterface) zzf);
                break;
            case 9:
                zzwb zza4 = zza(Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzfp.zza(parcel2, (IInterface) zza4);
                break;
            case 10:
                zzvl zza5 = zza(Stub.asInterface(parcel.readStrongBinder()), (zzua) zzfp.zza(parcel, zzua.CREATOR), parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                zzfp.zza(parcel2, (IInterface) zza5);
                break;
            case 11:
                zzabt zza6 = zza(Stub.asInterface(parcel.readStrongBinder()), Stub.asInterface(parcel.readStrongBinder()), Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzfp.zza(parcel2, (IInterface) zza6);
                break;
            case 12:
                zzara zzb2 = zzb(Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), zzajw.zzaa(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzfp.zza(parcel2, (IInterface) zzb2);
                break;
            case 13:
                zzvl zzc2 = zzc(Stub.asInterface(parcel.readStrongBinder()), (zzua) zzfp.zza(parcel, zzua.CREATOR), parcel.readString(), zzajw.zzaa(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzfp.zza(parcel2, (IInterface) zzc2);
                break;
            default:
                return false;
        }
        return true;
    }
}
