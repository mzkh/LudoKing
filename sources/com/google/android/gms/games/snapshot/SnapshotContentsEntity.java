package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.util.IOUtils;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.internal.zzbd;
import com.google.android.gms.games.internal.zzd;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

@UsedByReflection("GamesClientImpl.java")
@Class(creator = "SnapshotContentsEntityCreator")
@Reserved({1000})
public final class SnapshotContentsEntity extends zzd implements SnapshotContents {
    public static final Creator<SnapshotContentsEntity> CREATOR = new zza();
    private static final Object zzrp = new Object();
    @Field(getter = "getContents", mo15151id = 1)
    private Contents zzrq;

    @Constructor
    public SnapshotContentsEntity(@Param(mo15154id = 1) Contents contents) {
        this.zzrq = contents;
    }

    public final ParcelFileDescriptor getParcelFileDescriptor() {
        Preconditions.checkState(!isClosed(), "Cannot mutate closed contents!");
        return this.zzrq.getParcelFileDescriptor();
    }

    public final Contents zzds() {
        return this.zzrq;
    }

    public final void close() {
        this.zzrq = null;
    }

    public final boolean isClosed() {
        return this.zzrq == null;
    }

    public final byte[] readFully() throws IOException {
        byte[] readInputStreamFully;
        Preconditions.checkState(!isClosed(), "Must provide a previously opened Snapshot");
        synchronized (zzrp) {
            FileInputStream fileInputStream = new FileInputStream(this.zzrq.getParcelFileDescriptor().getFileDescriptor());
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            try {
                fileInputStream.getChannel().position(0);
                readInputStreamFully = IOUtils.readInputStreamFully(bufferedInputStream, false);
                fileInputStream.getChannel().position(0);
            } catch (IOException e) {
                zzbd.m3405w("SnapshotContentsEntity", "Failed to read snapshot data", e);
                throw e;
            }
        }
        return readInputStreamFully;
    }

    public final boolean writeBytes(byte[] bArr) {
        return zza(0, bArr, 0, bArr.length, true);
    }

    public final boolean modifyBytes(int i, byte[] bArr, int i2, int i3) {
        return zza(i, bArr, i2, bArr.length, false);
    }

    private final boolean zza(int i, byte[] bArr, int i2, int i3, boolean z) {
        Preconditions.checkState(!isClosed(), "Must provide a previously opened SnapshotContents");
        synchronized (zzrp) {
            FileOutputStream fileOutputStream = new FileOutputStream(this.zzrq.getParcelFileDescriptor().getFileDescriptor());
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            try {
                FileChannel channel = fileOutputStream.getChannel();
                channel.position((long) i);
                bufferedOutputStream.write(bArr, i2, i3);
                if (z) {
                    channel.truncate((long) bArr.length);
                }
                bufferedOutputStream.flush();
            } catch (IOException e) {
                zzbd.m3403i("SnapshotContentsEntity", "Failed to write snapshot data", e);
                return false;
            }
        }
        return true;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzrq, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
