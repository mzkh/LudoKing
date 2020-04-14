package com.google.android.gms.games.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.GamesActivityResultCodes;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataChangeEntity;
import com.google.android.gms.internal.games.zza;
import com.google.android.gms.internal.games.zzc;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;

public final class zzbv extends zza implements zzbu {
    zzbv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.games.internal.IGamesService");
    }

    public final void zza(long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeLong(j);
        zzb(5001, zza);
    }

    public final void zza(zzbq zzbq) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) zzbq);
        zzb(5002, zza);
    }

    public final String zzbr() throws RemoteException {
        Parcel zza = zza(5003, zza());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final Bundle getConnectionHint() throws RemoteException {
        Parcel zza = zza(5004, zza());
        Bundle bundle = (Bundle) zzc.zza(zza, Bundle.CREATOR);
        zza.recycle();
        return bundle;
    }

    public final void zza(IBinder iBinder, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zza.writeStrongBinder(iBinder);
        zzc.zza(zza, (Parcelable) bundle);
        zzb(5005, zza);
    }

    public final void zzci() throws RemoteException {
        zzb(5006, zza());
    }

    public final String zzau() throws RemoteException {
        Parcel zza = zza(5007, zza());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final String zzck() throws RemoteException {
        Parcel zza = zza(5012, zza());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final DataHolder zzcl() throws RemoteException {
        Parcel zza = zza(5013, zza());
        DataHolder dataHolder = (DataHolder) zzc.zza(zza, DataHolder.CREATOR);
        zza.recycle();
        return dataHolder;
    }

    public final void zza(zzbq zzbq, int i, boolean z, boolean z2) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) zzbq);
        zza.writeInt(i);
        zzc.writeBoolean(zza, z);
        zzc.writeBoolean(zza, z2);
        zzb(5015, zza);
    }

    public final void zza(zzbq zzbq, String str, int i, int i2, int i3, boolean z) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) zzbq);
        zza.writeString(str);
        zza.writeInt(i);
        zza.writeInt(i2);
        zza.writeInt(i3);
        zzc.writeBoolean(zza, z);
        zzb(5019, zza);
    }

    public final void zzb(zzbq zzbq, String str, int i, int i2, int i3, boolean z) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) zzbq);
        zza.writeString(str);
        zza.writeInt(i);
        zza.writeInt(i2);
        zza.writeInt(i3);
        zzc.writeBoolean(zza, z);
        zzb(5020, zza);
    }

    public final void zza(zzbq zzbq, Bundle bundle, int i, int i2) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) zzbq);
        zzc.zza(zza, (Parcelable) bundle);
        zza.writeInt(i);
        zza.writeInt(i2);
        zzb(5021, zza);
    }

    public final void zza(zzbq zzbq, String str, IBinder iBinder, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) zzbq);
        zza.writeString(str);
        zza.writeStrongBinder(iBinder);
        zzc.zza(zza, (Parcelable) bundle);
        zzb(5023, zza);
    }

    public final void zzb(zzbq zzbq, String str, IBinder iBinder, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) zzbq);
        zza.writeString(str);
        zza.writeStrongBinder(iBinder);
        zzc.zza(zza, (Parcelable) bundle);
        zzb(5024, zza);
    }

    public final void zza(zzbq zzbq, String str, int i, IBinder iBinder, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) zzbq);
        zza.writeString(str);
        zza.writeInt(i);
        zza.writeStrongBinder(iBinder);
        zzc.zza(zza, (Parcelable) bundle);
        zzb(5025, zza);
    }

    public final void zzb(zzbq zzbq) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) zzbq);
        zzb(5026, zza);
    }

    public final void zzd(String str, int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeInt(i);
        zzb(5028, zza);
    }

    public final void zzb(String str, int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeInt(i);
        zzb(5029, zza);
    }

    public final void zza(zzbq zzbq, long j) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) zzbq);
        zza.writeLong(j);
        zzb(5058, zza);
    }

    public final void zzb(long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeLong(j);
        zzb(5059, zza);
    }

    public final void zza(zzbq zzbq, IBinder iBinder, int i, String[] strArr, Bundle bundle, boolean z, long j) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) zzbq);
        zza.writeStrongBinder(iBinder);
        zza.writeInt(i);
        zza.writeStringArray(strArr);
        zzc.zza(zza, (Parcelable) bundle);
        zzc.writeBoolean(zza, false);
        zza.writeLong(j);
        zzb(5030, zza);
    }

    public final void zza(zzbq zzbq, IBinder iBinder, String str, boolean z, long j) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) zzbq);
        zza.writeStrongBinder(iBinder);
        zza.writeString(str);
        zzc.writeBoolean(zza, false);
        zza.writeLong(j);
        zzb(5031, zza);
    }

    public final void zza(zzbq zzbq, String str) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) zzbq);
        zza.writeString(str);
        zzb(5032, zza);
    }

    public final int zza(zzbq zzbq, byte[] bArr, String str, String str2) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) zzbq);
        zza.writeByteArray(bArr);
        zza.writeString(str);
        zza.writeString(str2);
        Parcel zza2 = zza(5033, zza);
        int readInt = zza2.readInt();
        zza2.recycle();
        return readInt;
    }

    public final int zzb(byte[] bArr, String str, String[] strArr) throws RemoteException {
        Parcel zza = zza();
        zza.writeByteArray(bArr);
        zza.writeString(str);
        zza.writeStringArray(strArr);
        Parcel zza2 = zza(5034, zza);
        int readInt = zza2.readInt();
        zza2.recycle();
        return readInt;
    }

    public final void zzl(int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zzb(5036, zza);
    }

    public final DataHolder zzcm() throws RemoteException {
        Parcel zza = zza(5502, zza());
        DataHolder dataHolder = (DataHolder) zzc.zza(zza, DataHolder.CREATOR);
        zza.recycle();
        return dataHolder;
    }

    public final void zza(zzbq zzbq, boolean z) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) zzbq);
        zzc.writeBoolean(zza, z);
        zzb(6001, zza);
    }

    public final void zzb(zzbq zzbq, boolean z) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) zzbq);
        zzc.writeBoolean(zza, z);
        zzb(GamesStatusCodes.STATUS_MATCH_ERROR_OUT_OF_DATE_VERSION, zza);
    }

    public final void zza(zzbq zzbq, String str, boolean z) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) zzbq);
        zza.writeString(str);
        zzc.writeBoolean(zza, z);
        zzb(GamesStatusCodes.STATUS_MATCH_ERROR_INVALID_MATCH_RESULTS, zza);
    }

    public final void zza(zzbq zzbq, String str, long j, String str2) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) zzbq);
        zza.writeString(str);
        zza.writeLong(j);
        zza.writeString(str2);
        zzb(7002, zza);
    }

    public final void zzb(zzbq zzbq, String str, int i, IBinder iBinder, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) zzbq);
        zza.writeString(str);
        zza.writeInt(i);
        zza.writeStrongBinder(iBinder);
        zzc.zza(zza, (Parcelable) bundle);
        zzb(7003, zza);
    }

    public final void zza(zzbq zzbq, String str, String str2, int i, int i2) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) zzbq);
        zza.writeString(null);
        zza.writeString(str2);
        zza.writeInt(i);
        zza.writeInt(i2);
        zzb(8001, zza);
    }

    public final void zzf(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzb(8002, zza);
    }

    public final void zza(zzbq zzbq, int i, int i2, String[] strArr, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) zzbq);
        zza.writeInt(i);
        zza.writeInt(i2);
        zza.writeStringArray(strArr);
        zzc.zza(zza, (Parcelable) bundle);
        zzb(ConnectionsStatusCodes.STATUS_CONNECTION_REJECTED, zza);
    }

    public final void zzb(zzbq zzbq, String str) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) zzbq);
        zza.writeString(str);
        zzb(ConnectionsStatusCodes.STATUS_NOT_CONNECTED_TO_ENDPOINT, zza);
    }

    public final void zzc(zzbq zzbq, String str) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) zzbq);
        zza.writeString(str);
        zzb(8006, zza);
    }

    public final void zza(zzbq zzbq, String str, byte[] bArr, String str2, ParticipantResult[] participantResultArr) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) zzbq);
        zza.writeString(str);
        zza.writeByteArray(bArr);
        zza.writeString(str2);
        zza.writeTypedArray(participantResultArr, 0);
        zzb(ConnectionsStatusCodes.STATUS_BLUETOOTH_ERROR, zza);
    }

    public final void zza(zzbq zzbq, String str, byte[] bArr, ParticipantResult[] participantResultArr) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) zzbq);
        zza.writeString(str);
        zza.writeByteArray(bArr);
        zza.writeTypedArray(participantResultArr, 0);
        zzb(ConnectionsStatusCodes.STATUS_ALREADY_HAVE_ACTIVE_STRATEGY, zza);
    }

    public final void zzd(zzbq zzbq, String str) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) zzbq);
        zza.writeString(str);
        zzb(ConnectionsStatusCodes.STATUS_OUT_OF_ORDER_API_CALL, zza);
    }

    public final void zze(zzbq zzbq, String str) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) zzbq);
        zza.writeString(str);
        zzb(8010, zza);
    }

    public final void zza(zzbq zzbq, String str, String str2) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) zzbq);
        zza.writeString(str);
        zza.writeString(str2);
        zzb(ConnectionsStatusCodes.STATUS_ENDPOINT_UNKNOWN, zza);
    }

    public final void zzb(zzbq zzbq, long j) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) zzbq);
        zza.writeLong(j);
        zzb(ConnectionsStatusCodes.STATUS_ENDPOINT_IO_ERROR, zza);
    }

    public final void zzc(long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeLong(j);
        zzb(ConnectionsStatusCodes.STATUS_PAYLOAD_IO_ERROR, zza);
    }

    public final void zzf(zzbq zzbq, String str) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) zzbq);
        zza.writeString(str);
        zzb(8014, zza);
    }

    public final int zzbt() throws RemoteException {
        Parcel zza = zza(8024, zza());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    public final void zzc(zzbq zzbq, boolean z) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) zzbq);
        zzc.writeBoolean(zza, z);
        zzb(8027, zza);
    }

    public final Intent zzba() throws RemoteException {
        Parcel zza = zza(GamesStatusCodes.STATUS_VIDEO_STORAGE_ERROR, zza());
        Intent intent = (Intent) zzc.zza(zza, Intent.CREATOR);
        zza.recycle();
        return intent;
    }

    public final Intent zzbc() throws RemoteException {
        Parcel zza = zza(9005, zza());
        Intent intent = (Intent) zzc.zza(zza, Intent.CREATOR);
        zza.recycle();
        return intent;
    }

    public final Intent zzbd() throws RemoteException {
        Parcel zza = zza(GamesStatusCodes.STATUS_VIDEO_ALREADY_CAPTURING, zza());
        Intent intent = (Intent) zzc.zza(zza, Intent.CREATOR);
        zza.recycle();
        return intent;
    }

    public final Intent zzbe() throws RemoteException {
        Parcel zza = zza(9007, zza());
        Intent intent = (Intent) zzc.zza(zza, Intent.CREATOR);
        zza.recycle();
        return intent;
    }

    public final Intent zza(int i, int i2, boolean z) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zza.writeInt(i2);
        zzc.writeBoolean(zza, z);
        Parcel zza2 = zza(9008, zza);
        Intent intent = (Intent) zzc.zza(zza2, Intent.CREATOR);
        zza2.recycle();
        return intent;
    }

    public final Intent zzc(int i, int i2, boolean z) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zza.writeInt(i2);
        zzc.writeBoolean(zza, z);
        Parcel zza2 = zza(GamesStatusCodes.STATUS_VIDEO_OUT_OF_DISK_SPACE, zza);
        Intent intent = (Intent) zzc.zza(zza2, Intent.CREATOR);
        zza2.recycle();
        return intent;
    }

    public final Intent zzbl() throws RemoteException {
        Parcel zza = zza(9010, zza());
        Intent intent = (Intent) zzc.zza(zza, Intent.CREATOR);
        zza.recycle();
        return intent;
    }

    public final Intent zza(RoomEntity roomEntity, int i) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) roomEntity);
        zza.writeInt(i);
        Parcel zza2 = zza(9011, zza);
        Intent intent = (Intent) zzc.zza(zza2, Intent.CREATOR);
        zza2.recycle();
        return intent;
    }

    public final Intent zzbn() throws RemoteException {
        Parcel zza = zza(9012, zza());
        Intent intent = (Intent) zzc.zza(zza, Intent.CREATOR);
        zza.recycle();
        return intent;
    }

    public final int zzbp() throws RemoteException {
        Parcel zza = zza(9019, zza());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    public final void zza(zzbq zzbq, String str, int i, boolean z, boolean z2) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) zzbq);
        zza.writeString(str);
        zza.writeInt(i);
        zzc.writeBoolean(zza, z);
        zzc.writeBoolean(zza, z2);
        zzb(9020, zza);
    }

    public final void zzc(zzbq zzbq, long j) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) zzbq);
        zza.writeLong(j);
        zzb(GamesActivityResultCodes.RESULT_RECONNECT_REQUIRED, zza);
    }

    public final void zzd(long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeLong(j);
        zzb(GamesActivityResultCodes.RESULT_SIGN_IN_FAILED, zza);
    }

    public final void zza(zzbq zzbq, String[] strArr) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) zzbq);
        zza.writeStringArray(strArr);
        zzb(GamesActivityResultCodes.RESULT_NETWORK_FAILURE, zza);
    }

    public final void zzb(zzbq zzbq, String[] strArr) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) zzbq);
        zza.writeStringArray(strArr);
        zzb(GamesActivityResultCodes.RESULT_SEND_REQUEST_FAILED, zza);
    }

    public final void zza(zzbq zzbq, int i, int i2, int i3) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) zzbq);
        zza.writeInt(i);
        zza.writeInt(i2);
        zza.writeInt(i3);
        zzb(10009, zza);
    }

    public final Intent zza(int i, byte[] bArr, int i2, String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zza.writeByteArray(bArr);
        zza.writeInt(i2);
        zza.writeString(str);
        Parcel zza2 = zza(10012, zza);
        Intent intent = (Intent) zzc.zza(zza2, Intent.CREATOR);
        zza2.recycle();
        return intent;
    }

    public final int zzbw() throws RemoteException {
        Parcel zza = zza(10013, zza());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    public final int zzbx() throws RemoteException {
        Parcel zza = zza(10023, zza());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    public final Intent zzbv() throws RemoteException {
        Parcel zza = zza(10015, zza());
        Intent intent = (Intent) zzc.zza(zza, Intent.CREATOR);
        zza.recycle();
        return intent;
    }

    public final void zza(zzbq zzbq, int i) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) zzbq);
        zza.writeInt(i);
        zzb(10016, zza);
    }

    public final void zza(zzbq zzbq, int i, int[] iArr) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) zzbq);
        zza.writeInt(i);
        zza.writeIntArray(iArr);
        zzb(10018, zza);
    }

    public final Intent zza(String str, boolean z, boolean z2, int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzc.writeBoolean(zza, z);
        zzc.writeBoolean(zza, z2);
        zza.writeInt(i);
        Parcel zza2 = zza(12001, zza);
        Intent intent = (Intent) zzc.zza(zza2, Intent.CREATOR);
        zza2.recycle();
        return intent;
    }

    public final void zzd(zzbq zzbq, boolean z) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) zzbq);
        zzc.writeBoolean(zza, z);
        zzb(12002, zza);
    }

    public final void zza(zzbq zzbq, String str, SnapshotMetadataChangeEntity snapshotMetadataChangeEntity, Contents contents) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) zzbq);
        zza.writeString(str);
        zzc.zza(zza, (Parcelable) snapshotMetadataChangeEntity);
        zzc.zza(zza, (Parcelable) contents);
        zzb(12007, zza);
    }

    public final void zza(Contents contents) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) contents);
        zzb(12019, zza);
    }

    public final void zzg(zzbq zzbq, String str) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) zzbq);
        zza.writeString(str);
        zzb(12020, zza);
    }

    public final void zza(zzbq zzbq, String str, String str2, SnapshotMetadataChangeEntity snapshotMetadataChangeEntity, Contents contents) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) zzbq);
        zza.writeString(str);
        zza.writeString(str2);
        zzc.zza(zza, (Parcelable) snapshotMetadataChangeEntity);
        zzc.zza(zza, (Parcelable) contents);
        zzb(12033, zza);
    }

    public final int zzby() throws RemoteException {
        Parcel zza = zza(12035, zza());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    public final int zzca() throws RemoteException {
        Parcel zza = zza(12036, zza());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    public final void zze(zzbq zzbq, boolean z) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) zzbq);
        zzc.writeBoolean(zza, z);
        zzb(12016, zza);
    }

    public final void zza(zzbq zzbq, boolean z, String[] strArr) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) zzbq);
        zzc.writeBoolean(zza, z);
        zza.writeStringArray(strArr);
        zzb(12031, zza);
    }

    public final void zza(String str, int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeInt(i);
        zzb(12017, zza);
    }

    public final void zzh(zzbq zzbq, String str) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) zzbq);
        zza.writeString(str);
        zzb(12008, zza);
    }

    public final void zzb(zzbq zzbq, String str, String str2) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) zzbq);
        zza.writeString(str);
        zza.writeString(str2);
        zzb(12009, zza);
    }

    public final void zza(zzbq zzbq, int[] iArr, int i, boolean z) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) zzbq);
        zza.writeIntArray(iArr);
        zza.writeInt(i);
        zzc.writeBoolean(zza, z);
        zzb(12010, zza);
    }

    public final void zza(zzbq zzbq, String[] strArr, boolean z) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) zzbq);
        zza.writeStringArray(strArr);
        zzc.writeBoolean(zza, z);
        zzb(12029, zza);
    }

    public final void zzd(zzbq zzbq, long j) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) zzbq);
        zza.writeLong(j);
        zzb(12011, zza);
    }

    public final void zze(long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeLong(j);
        zzb(12012, zza);
    }

    public final Intent zza(int[] iArr) throws RemoteException {
        Parcel zza = zza();
        zza.writeIntArray(iArr);
        Parcel zza2 = zza(12030, zza);
        Intent intent = (Intent) zzc.zza(zza2, Intent.CREATOR);
        zza2.recycle();
        return intent;
    }

    public final Intent zzd(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        Parcel zza2 = zza(12034, zza);
        Intent intent = (Intent) zzc.zza(zza2, Intent.CREATOR);
        zza2.recycle();
        return intent;
    }

    public final void zza(String str, IBinder iBinder, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeStrongBinder(iBinder);
        zzc.zza(zza, (Parcelable) bundle);
        zzb(13002, zza);
    }

    public final void zzb(zzbq zzbq, String str, boolean z) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) zzbq);
        zza.writeString(str);
        zzc.writeBoolean(zza, z);
        zzb(13006, zza);
    }

    public final void zza(zzbq zzbq, String str, boolean z, int i) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) zzbq);
        zza.writeString(str);
        zzc.writeBoolean(zza, z);
        zza.writeInt(i);
        zzb(15001, zza);
    }

    public final void zza(zzbs zzbs, long j) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) zzbs);
        zza.writeLong(j);
        zzb(15501, zza);
    }

    public final Intent zza(PlayerEntity playerEntity) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) playerEntity);
        Parcel zza2 = zza(15503, zza);
        Intent intent = (Intent) zzc.zza(zza2, Intent.CREATOR);
        zza2.recycle();
        return intent;
    }

    public final void zzf(zzbq zzbq, boolean z) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) zzbq);
        zzc.writeBoolean(zza, z);
        zzb(17001, zza);
    }

    public final Intent zzb(String str, int i, int i2) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeInt(i);
        zza.writeInt(i2);
        Parcel zza2 = zza(18001, zza);
        Intent intent = (Intent) zzc.zza(zza2, Intent.CREATOR);
        zza2.recycle();
        return intent;
    }

    public final Intent zzcn() throws RemoteException {
        Parcel zza = zza(19002, zza());
        Intent intent = (Intent) zzc.zza(zza, Intent.CREATOR);
        zza.recycle();
        return intent;
    }

    public final void zza(String str, zzbq zzbq) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzc.zza(zza, (IInterface) zzbq);
        zzb(20001, zza);
    }

    public final void zzc(zzbq zzbq) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) zzbq);
        zzb(21007, zza);
    }

    public final void zzb(zzbq zzbq, int i) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) zzbq);
        zza.writeInt(i);
        zzb(22016, zza);
    }

    public final void zze(zzbq zzbq, long j) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) zzbq);
        zza.writeLong(j);
        zzb(22026, zza);
    }

    public final void zzf(long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeLong(j);
        zzb(22027, zza);
    }

    public final void zzd(zzbq zzbq) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) zzbq);
        zzb(22028, zza);
    }

    public final boolean zzce() throws RemoteException {
        Parcel zza = zza(22030, zza());
        boolean zza2 = zzc.zza(zza);
        zza.recycle();
        return zza2;
    }
}
