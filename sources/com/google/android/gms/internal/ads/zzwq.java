package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public abstract class zzwq extends zzfm implements zzwr {
    public zzwq() {
        super("com.google.android.gms.ads.internal.client.IVideoController");
    }

    public static zzwr zzi(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoController");
        if (queryLocalInterface instanceof zzwr) {
            return (zzwr) queryLocalInterface;
        }
        return new zzwt(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzws zzws;
        switch (i) {
            case 1:
                play();
                parcel2.writeNoException();
                break;
            case 2:
                pause();
                parcel2.writeNoException();
                break;
            case 3:
                mute(zzfp.zza(parcel));
                parcel2.writeNoException();
                break;
            case 4:
                boolean isMuted = isMuted();
                parcel2.writeNoException();
                zzfp.writeBoolean(parcel2, isMuted);
                break;
            case 5:
                int playbackState = getPlaybackState();
                parcel2.writeNoException();
                parcel2.writeInt(playbackState);
                break;
            case 6:
                float zzox = zzox();
                parcel2.writeNoException();
                parcel2.writeFloat(zzox);
                break;
            case 7:
                float zzoy = zzoy();
                parcel2.writeNoException();
                parcel2.writeFloat(zzoy);
                break;
            case 8:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zzws = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
                    if (queryLocalInterface instanceof zzws) {
                        zzws = (zzws) queryLocalInterface;
                    } else {
                        zzws = new zzwu(readStrongBinder);
                    }
                }
                zza(zzws);
                parcel2.writeNoException();
                break;
            case 9:
                float aspectRatio = getAspectRatio();
                parcel2.writeNoException();
                parcel2.writeFloat(aspectRatio);
                break;
            case 10:
                boolean isCustomControlsEnabled = isCustomControlsEnabled();
                parcel2.writeNoException();
                zzfp.writeBoolean(parcel2, isCustomControlsEnabled);
                break;
            case 11:
                zzws zzoz = zzoz();
                parcel2.writeNoException();
                zzfp.zza(parcel2, (IInterface) zzoz);
                break;
            case 12:
                boolean isClickToExpandEnabled = isClickToExpandEnabled();
                parcel2.writeNoException();
                zzfp.writeBoolean(parcel2, isClickToExpandEnabled);
                break;
            case 13:
                stop();
                parcel2.writeNoException();
                break;
            default:
                return false;
        }
        return true;
    }
}
