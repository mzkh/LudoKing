package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.ParcelFileDescriptor.AutoCloseOutputStream;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.util.IOUtils;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.IOException;

@Class(creator = "LargeParcelTeleporterCreator")
@Reserved({1})
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzaoz extends AbstractSafeParcelable {
    public static final Creator<zzaoz> CREATOR = new zzapb();
    @Field(mo15151id = 2)
    private ParcelFileDescriptor zzdlv;
    private Parcelable zzdlw = null;
    private boolean zzdlx = true;

    @Constructor
    public zzaoz(@Param(mo15154id = 2) ParcelFileDescriptor parcelFileDescriptor) {
        this.zzdlv = parcelFileDescriptor;
    }

    /* JADX INFO: finally extract failed */
    public final <T extends SafeParcelable> T zza(Creator<T> creator) {
        if (this.zzdlx) {
            ParcelFileDescriptor parcelFileDescriptor = this.zzdlv;
            if (parcelFileDescriptor == null) {
                zzaug.zzes("File descriptor is empty, returning null.");
                return null;
            }
            DataInputStream dataInputStream = new DataInputStream(new AutoCloseInputStream(parcelFileDescriptor));
            try {
                byte[] bArr = new byte[dataInputStream.readInt()];
                dataInputStream.readFully(bArr, 0, bArr.length);
                IOUtils.closeQuietly((Closeable) dataInputStream);
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.unmarshall(bArr, 0, bArr.length);
                    obtain.setDataPosition(0);
                    this.zzdlw = (Parcelable) creator.createFromParcel(obtain);
                    obtain.recycle();
                    this.zzdlx = false;
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            } catch (IOException e) {
                zzaug.zzc("Could not read from parcel file descriptor", e);
                IOUtils.closeQuietly((Closeable) dataInputStream);
                return null;
            } catch (Throwable th2) {
                IOUtils.closeQuietly((Closeable) dataInputStream);
                throw th2;
            }
        }
        return (SafeParcelable) this.zzdlw;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        zztb();
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzdlv, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX INFO: finally extract failed */
    private final ParcelFileDescriptor zztb() {
        if (this.zzdlv == null) {
            Parcel obtain = Parcel.obtain();
            try {
                this.zzdlw.writeToParcel(obtain, 0);
                byte[] marshall = obtain.marshall();
                obtain.recycle();
                this.zzdlv = zzh(marshall);
            } catch (Throwable th) {
                obtain.recycle();
                throw th;
            }
        }
        return this.zzdlv;
    }

    private static <T> ParcelFileDescriptor zzh(byte[] bArr) {
        AutoCloseOutputStream autoCloseOutputStream;
        try {
            ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
            autoCloseOutputStream = new AutoCloseOutputStream(createPipe[1]);
            try {
                zzaxn.zzdwi.execute(new zzapc(autoCloseOutputStream, bArr));
                return createPipe[0];
            } catch (IOException e) {
                e = e;
                zzaug.zzc("Error transporting the ad response", e);
                zzq.zzkn().zza(e, "LargeParcelTeleporter.pipeData.2");
                IOUtils.closeQuietly((Closeable) autoCloseOutputStream);
                return null;
            }
        } catch (IOException e2) {
            e = e2;
            autoCloseOutputStream = null;
            zzaug.zzc("Error transporting the ad response", e);
            zzq.zzkn().zza(e, "LargeParcelTeleporter.pipeData.2");
            IOUtils.closeQuietly((Closeable) autoCloseOutputStream);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0038  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static final /* synthetic */ void zza(java.io.OutputStream r3, byte[] r4) {
        /*
            r0 = 0
            java.io.DataOutputStream r1 = new java.io.DataOutputStream     // Catch:{ IOException -> 0x0019 }
            r1.<init>(r3)     // Catch:{ IOException -> 0x0019 }
            int r0 = r4.length     // Catch:{ IOException -> 0x0014, all -> 0x0011 }
            r1.writeInt(r0)     // Catch:{ IOException -> 0x0014, all -> 0x0011 }
            r1.write(r4)     // Catch:{ IOException -> 0x0014, all -> 0x0011 }
            com.google.android.gms.common.util.IOUtils.closeQuietly(r1)
            return
        L_0x0011:
            r4 = move-exception
            r0 = r1
            goto L_0x0032
        L_0x0014:
            r4 = move-exception
            r0 = r1
            goto L_0x001a
        L_0x0017:
            r4 = move-exception
            goto L_0x0032
        L_0x0019:
            r4 = move-exception
        L_0x001a:
            java.lang.String r1 = "Error transporting the ad response"
            com.google.android.gms.internal.ads.zzaug.zzc(r1, r4)     // Catch:{ all -> 0x0017 }
            com.google.android.gms.internal.ads.zzatr r1 = com.google.android.gms.ads.internal.zzq.zzkn()     // Catch:{ all -> 0x0017 }
            java.lang.String r2 = "LargeParcelTeleporter.pipeData.1"
            r1.zza(r4, r2)     // Catch:{ all -> 0x0017 }
            if (r0 != 0) goto L_0x002e
            com.google.android.gms.common.util.IOUtils.closeQuietly(r3)
            return
        L_0x002e:
            com.google.android.gms.common.util.IOUtils.closeQuietly(r0)
            return
        L_0x0032:
            if (r0 != 0) goto L_0x0038
            com.google.android.gms.common.util.IOUtils.closeQuietly(r3)
            goto L_0x003b
        L_0x0038:
            com.google.android.gms.common.util.IOUtils.closeQuietly(r0)
        L_0x003b:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaoz.zza(java.io.OutputStream, byte[]):void");
    }
}
