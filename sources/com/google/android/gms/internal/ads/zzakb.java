package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public abstract class zzakb extends zzfm implements zzajy {
    public zzakb() {
        super("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    /* access modifiers changed from: protected */
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzakd zzakd = null;
        String str = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener";
        switch (i) {
            case 1:
                IObjectWrapper asInterface = Stub.asInterface(parcel.readStrongBinder());
                zzua zzua = (zzua) zzfp.zza(parcel, zzua.CREATOR);
                zztx zztx = (zztx) zzfp.zza(parcel, zztx.CREATOR);
                String readString = parcel.readString();
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface(str);
                    if (queryLocalInterface instanceof zzakd) {
                        zzakd = (zzakd) queryLocalInterface;
                    } else {
                        zzakd = new zzakf(readStrongBinder);
                    }
                }
                zza(asInterface, zzua, zztx, readString, zzakd);
                parcel2.writeNoException();
                break;
            case 2:
                IObjectWrapper zzro = zzro();
                parcel2.writeNoException();
                zzfp.zza(parcel2, (IInterface) zzro);
                break;
            case 3:
                IObjectWrapper asInterface2 = Stub.asInterface(parcel.readStrongBinder());
                zztx zztx2 = (zztx) zzfp.zza(parcel, zztx.CREATOR);
                String readString2 = parcel.readString();
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface(str);
                    if (queryLocalInterface2 instanceof zzakd) {
                        zzakd = (zzakd) queryLocalInterface2;
                    } else {
                        zzakd = new zzakf(readStrongBinder2);
                    }
                }
                zza(asInterface2, zztx2, readString2, zzakd);
                parcel2.writeNoException();
                break;
            case 4:
                showInterstitial();
                parcel2.writeNoException();
                break;
            case 5:
                destroy();
                parcel2.writeNoException();
                break;
            case 6:
                IObjectWrapper asInterface3 = Stub.asInterface(parcel.readStrongBinder());
                zzua zzua2 = (zzua) zzfp.zza(parcel, zzua.CREATOR);
                zztx zztx3 = (zztx) zzfp.zza(parcel, zztx.CREATOR);
                String readString3 = parcel.readString();
                String readString4 = parcel.readString();
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface(str);
                    if (queryLocalInterface3 instanceof zzakd) {
                        zzakd = (zzakd) queryLocalInterface3;
                    } else {
                        zzakd = new zzakf(readStrongBinder3);
                    }
                }
                zza(asInterface3, zzua2, zztx3, readString3, readString4, zzakd);
                parcel2.writeNoException();
                break;
            case 7:
                IObjectWrapper asInterface4 = Stub.asInterface(parcel.readStrongBinder());
                zztx zztx4 = (zztx) zzfp.zza(parcel, zztx.CREATOR);
                String readString5 = parcel.readString();
                String readString6 = parcel.readString();
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 != null) {
                    IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface(str);
                    if (queryLocalInterface4 instanceof zzakd) {
                        zzakd = (zzakd) queryLocalInterface4;
                    } else {
                        zzakd = new zzakf(readStrongBinder4);
                    }
                }
                zza(asInterface4, zztx4, readString5, readString6, zzakd);
                parcel2.writeNoException();
                break;
            case 8:
                pause();
                parcel2.writeNoException();
                break;
            case 9:
                resume();
                parcel2.writeNoException();
                break;
            case 10:
                zza(Stub.asInterface(parcel.readStrongBinder()), (zztx) zzfp.zza(parcel, zztx.CREATOR), parcel.readString(), zzaqs.zzak(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                break;
            case 11:
                zza((zztx) zzfp.zza(parcel, zztx.CREATOR), parcel.readString());
                parcel2.writeNoException();
                break;
            case 12:
                showVideo();
                parcel2.writeNoException();
                break;
            case 13:
                boolean isInitialized = isInitialized();
                parcel2.writeNoException();
                zzfp.writeBoolean(parcel2, isInitialized);
                break;
            case 14:
                IObjectWrapper asInterface5 = Stub.asInterface(parcel.readStrongBinder());
                zztx zztx5 = (zztx) zzfp.zza(parcel, zztx.CREATOR);
                String readString7 = parcel.readString();
                String readString8 = parcel.readString();
                IBinder readStrongBinder5 = parcel.readStrongBinder();
                if (readStrongBinder5 != null) {
                    IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface(str);
                    if (queryLocalInterface5 instanceof zzakd) {
                        zzakd = (zzakd) queryLocalInterface5;
                    } else {
                        zzakd = new zzakf(readStrongBinder5);
                    }
                }
                zza(asInterface5, zztx5, readString7, readString8, zzakd, (zzaay) zzfp.zza(parcel, zzaay.CREATOR), parcel.createStringArrayList());
                parcel2.writeNoException();
                break;
            case 15:
                zzakg zzrp = zzrp();
                parcel2.writeNoException();
                zzfp.zza(parcel2, (IInterface) zzrp);
                break;
            case 16:
                zzakl zzrq = zzrq();
                parcel2.writeNoException();
                zzfp.zza(parcel2, (IInterface) zzrq);
                break;
            case 17:
                Bundle zzrr = zzrr();
                parcel2.writeNoException();
                zzfp.zzb(parcel2, zzrr);
                break;
            case 18:
                Bundle interstitialAdapterInfo = getInterstitialAdapterInfo();
                parcel2.writeNoException();
                zzfp.zzb(parcel2, interstitialAdapterInfo);
                break;
            case 19:
                Bundle zzrs = zzrs();
                parcel2.writeNoException();
                zzfp.zzb(parcel2, zzrs);
                break;
            case 20:
                zza((zztx) zzfp.zza(parcel, zztx.CREATOR), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                break;
            case 21:
                zzw(Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 22:
                boolean zzrt = zzrt();
                parcel2.writeNoException();
                zzfp.writeBoolean(parcel2, zzrt);
                break;
            case 23:
                zza(Stub.asInterface(parcel.readStrongBinder()), zzaqs.zzak(parcel.readStrongBinder()), (List<String>) parcel.createStringArrayList());
                parcel2.writeNoException();
                break;
            case 24:
                zzace zzru = zzru();
                parcel2.writeNoException();
                zzfp.zza(parcel2, (IInterface) zzru);
                break;
            case 25:
                setImmersiveMode(zzfp.zza(parcel));
                parcel2.writeNoException();
                break;
            case 26:
                zzwr videoController = getVideoController();
                parcel2.writeNoException();
                zzfp.zza(parcel2, (IInterface) videoController);
                break;
            case 27:
                zzakm zzrv = zzrv();
                parcel2.writeNoException();
                zzfp.zza(parcel2, (IInterface) zzrv);
                break;
            case 28:
                IObjectWrapper asInterface6 = Stub.asInterface(parcel.readStrongBinder());
                zztx zztx6 = (zztx) zzfp.zza(parcel, zztx.CREATOR);
                String readString9 = parcel.readString();
                IBinder readStrongBinder6 = parcel.readStrongBinder();
                if (readStrongBinder6 != null) {
                    IInterface queryLocalInterface6 = readStrongBinder6.queryLocalInterface(str);
                    if (queryLocalInterface6 instanceof zzakd) {
                        zzakd = (zzakd) queryLocalInterface6;
                    } else {
                        zzakd = new zzakf(readStrongBinder6);
                    }
                }
                zzb(asInterface6, zztx6, readString9, zzakd);
                parcel2.writeNoException();
                break;
            case 30:
                zzx(Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 31:
                zza(Stub.asInterface(parcel.readStrongBinder()), zzafs.zzx(parcel.readStrongBinder()), (List<zzagb>) parcel.createTypedArrayList(zzagb.CREATOR));
                parcel2.writeNoException();
                break;
            default:
                return false;
        }
        return true;
    }
}
