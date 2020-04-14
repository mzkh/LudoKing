package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzvw extends zzfn implements zzvu {
    zzvw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IClientApi");
    }

    public final zzvl zza(IObjectWrapper iObjectWrapper, zzua zzua, String str, zzajx zzajx, int i) throws RemoteException {
        zzvl zzvl;
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzfp.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        zzfp.zza(obtainAndWriteInterfaceToken, (Parcelable) zzua);
        obtainAndWriteInterfaceToken.writeString(str);
        zzfp.zza(obtainAndWriteInterfaceToken, (IInterface) zzajx);
        obtainAndWriteInterfaceToken.writeInt(i);
        Parcel transactAndReadException = transactAndReadException(1, obtainAndWriteInterfaceToken);
        IBinder readStrongBinder = transactAndReadException.readStrongBinder();
        if (readStrongBinder == null) {
            zzvl = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            if (queryLocalInterface instanceof zzvl) {
                zzvl = (zzvl) queryLocalInterface;
            } else {
                zzvl = new zzvn(readStrongBinder);
            }
        }
        transactAndReadException.recycle();
        return zzvl;
    }

    public final zzvl zzb(IObjectWrapper iObjectWrapper, zzua zzua, String str, zzajx zzajx, int i) throws RemoteException {
        zzvl zzvl;
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzfp.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        zzfp.zza(obtainAndWriteInterfaceToken, (Parcelable) zzua);
        obtainAndWriteInterfaceToken.writeString(str);
        zzfp.zza(obtainAndWriteInterfaceToken, (IInterface) zzajx);
        obtainAndWriteInterfaceToken.writeInt(i);
        Parcel transactAndReadException = transactAndReadException(2, obtainAndWriteInterfaceToken);
        IBinder readStrongBinder = transactAndReadException.readStrongBinder();
        if (readStrongBinder == null) {
            zzvl = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            if (queryLocalInterface instanceof zzvl) {
                zzvl = (zzvl) queryLocalInterface;
            } else {
                zzvl = new zzvn(readStrongBinder);
            }
        }
        transactAndReadException.recycle();
        return zzvl;
    }

    public final zzve zza(IObjectWrapper iObjectWrapper, String str, zzajx zzajx, int i) throws RemoteException {
        zzve zzve;
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzfp.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        obtainAndWriteInterfaceToken.writeString(str);
        zzfp.zza(obtainAndWriteInterfaceToken, (IInterface) zzajx);
        obtainAndWriteInterfaceToken.writeInt(i);
        Parcel transactAndReadException = transactAndReadException(3, obtainAndWriteInterfaceToken);
        IBinder readStrongBinder = transactAndReadException.readStrongBinder();
        if (readStrongBinder == null) {
            zzve = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            if (queryLocalInterface instanceof zzve) {
                zzve = (zzve) queryLocalInterface;
            } else {
                zzve = new zzvg(readStrongBinder);
            }
        }
        transactAndReadException.recycle();
        return zzve;
    }

    public final zzwb zzg(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzwb zzwb;
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzfp.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        Parcel transactAndReadException = transactAndReadException(4, obtainAndWriteInterfaceToken);
        IBinder readStrongBinder = transactAndReadException.readStrongBinder();
        if (readStrongBinder == null) {
            zzwb = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            if (queryLocalInterface instanceof zzwb) {
                zzwb = (zzwb) queryLocalInterface;
            } else {
                zzwb = new zzwd(readStrongBinder);
            }
        }
        transactAndReadException.recycle();
        return zzwb;
    }

    public final zzabm zzc(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzfp.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        zzfp.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper2);
        Parcel transactAndReadException = transactAndReadException(5, obtainAndWriteInterfaceToken);
        zzabm zzn = zzabp.zzn(transactAndReadException.readStrongBinder());
        transactAndReadException.recycle();
        return zzn;
    }

    public final zzaqb zza(IObjectWrapper iObjectWrapper, zzajx zzajx, int i) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzfp.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        zzfp.zza(obtainAndWriteInterfaceToken, (IInterface) zzajx);
        obtainAndWriteInterfaceToken.writeInt(i);
        Parcel transactAndReadException = transactAndReadException(6, obtainAndWriteInterfaceToken);
        zzaqb zzai = zzaqe.zzai(transactAndReadException.readStrongBinder());
        transactAndReadException.recycle();
        return zzai;
    }

    public final zzany zzh(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzfp.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        Parcel transactAndReadException = transactAndReadException(7, obtainAndWriteInterfaceToken);
        zzany zzag = zzanx.zzag(transactAndReadException.readStrongBinder());
        transactAndReadException.recycle();
        return zzag;
    }

    public final zzano zzf(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzfp.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        Parcel transactAndReadException = transactAndReadException(8, obtainAndWriteInterfaceToken);
        zzano zzae = zzann.zzae(transactAndReadException.readStrongBinder());
        transactAndReadException.recycle();
        return zzae;
    }

    public final zzwb zza(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        zzwb zzwb;
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzfp.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        obtainAndWriteInterfaceToken.writeInt(i);
        Parcel transactAndReadException = transactAndReadException(9, obtainAndWriteInterfaceToken);
        IBinder readStrongBinder = transactAndReadException.readStrongBinder();
        if (readStrongBinder == null) {
            zzwb = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            if (queryLocalInterface instanceof zzwb) {
                zzwb = (zzwb) queryLocalInterface;
            } else {
                zzwb = new zzwd(readStrongBinder);
            }
        }
        transactAndReadException.recycle();
        return zzwb;
    }

    public final zzvl zza(IObjectWrapper iObjectWrapper, zzua zzua, String str, int i) throws RemoteException {
        zzvl zzvl;
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzfp.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        zzfp.zza(obtainAndWriteInterfaceToken, (Parcelable) zzua);
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeInt(i);
        Parcel transactAndReadException = transactAndReadException(10, obtainAndWriteInterfaceToken);
        IBinder readStrongBinder = transactAndReadException.readStrongBinder();
        if (readStrongBinder == null) {
            zzvl = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            if (queryLocalInterface instanceof zzvl) {
                zzvl = (zzvl) queryLocalInterface;
            } else {
                zzvl = new zzvn(readStrongBinder);
            }
        }
        transactAndReadException.recycle();
        return zzvl;
    }

    public final zzabt zza(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzfp.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        zzfp.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper2);
        zzfp.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper3);
        Parcel transactAndReadException = transactAndReadException(11, obtainAndWriteInterfaceToken);
        zzabt zzo = zzabs.zzo(transactAndReadException.readStrongBinder());
        transactAndReadException.recycle();
        return zzo;
    }

    public final zzara zzb(IObjectWrapper iObjectWrapper, String str, zzajx zzajx, int i) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzfp.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        obtainAndWriteInterfaceToken.writeString(str);
        zzfp.zza(obtainAndWriteInterfaceToken, (IInterface) zzajx);
        obtainAndWriteInterfaceToken.writeInt(i);
        Parcel transactAndReadException = transactAndReadException(12, obtainAndWriteInterfaceToken);
        zzara zzam = zzaqz.zzam(transactAndReadException.readStrongBinder());
        transactAndReadException.recycle();
        return zzam;
    }

    public final zzvl zzc(IObjectWrapper iObjectWrapper, zzua zzua, String str, zzajx zzajx, int i) throws RemoteException {
        zzvl zzvl;
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzfp.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        zzfp.zza(obtainAndWriteInterfaceToken, (Parcelable) zzua);
        obtainAndWriteInterfaceToken.writeString(str);
        zzfp.zza(obtainAndWriteInterfaceToken, (IInterface) zzajx);
        obtainAndWriteInterfaceToken.writeInt(i);
        Parcel transactAndReadException = transactAndReadException(13, obtainAndWriteInterfaceToken);
        IBinder readStrongBinder = transactAndReadException.readStrongBinder();
        if (readStrongBinder == null) {
            zzvl = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            if (queryLocalInterface instanceof zzvl) {
                zzvl = (zzvl) queryLocalInterface;
            } else {
                zzvl = new zzvn(readStrongBinder);
            }
        }
        transactAndReadException.recycle();
        return zzvl;
    }
}
