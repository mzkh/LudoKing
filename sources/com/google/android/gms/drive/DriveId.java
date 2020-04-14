package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Base64;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.drive.zzbn;
import com.google.android.gms.internal.drive.zzbs;
import com.google.android.gms.internal.drive.zzdp;
import com.google.android.gms.internal.drive.zzhn;
import com.google.android.gms.internal.drive.zzho;
import com.google.android.gms.internal.drive.zziw;
import com.google.android.gms.internal.drive.zzix;

@Class(creator = "DriveIdCreator")
@Reserved({1})
public class DriveId extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Creator<DriveId> CREATOR = new zzk();
    public static final int RESOURCE_TYPE_FILE = 0;
    public static final int RESOURCE_TYPE_FOLDER = 1;
    public static final int RESOURCE_TYPE_UNKNOWN = -1;
    @Field(mo15151id = 2)
    private final String zzab;
    @Field(mo15151id = 3)
    private final long zzac;
    @Field(defaultValueUnchecked = "com.google.android.gms.drive.DriveId.RESOURCE_TYPE_UNKNOWN", mo15151id = 5)
    private final int zzad;
    private volatile String zzae = null;
    @Field(mo15151id = 4)
    private final long zzf;
    private volatile String zzh = null;

    @Constructor
    public DriveId(@Param(mo15154id = 2) String str, @Param(mo15154id = 3) long j, @Param(mo15154id = 4) long j2, @Param(mo15154id = 5) int i) {
        this.zzab = str;
        boolean z = true;
        Preconditions.checkArgument(!"".equals(str));
        if (str == null && j == -1) {
            z = false;
        }
        Preconditions.checkArgument(z);
        this.zzac = j;
        this.zzf = j2;
        this.zzad = i;
    }

    public static DriveId decodeFromString(String str) {
        boolean startsWith = str.startsWith("DriveId:");
        String valueOf = String.valueOf(str);
        String str2 = "Invalid DriveId: ";
        Preconditions.checkArgument(startsWith, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        return zza(Base64.decode(str.substring(8), 10));
    }

    @VisibleForTesting
    public static DriveId zza(String str) {
        Preconditions.checkNotNull(str);
        DriveId driveId = new DriveId(str, -1, -1, -1);
        return driveId;
    }

    @VisibleForTesting
    private static DriveId zza(byte[] bArr) {
        try {
            zzhn zzhn = (zzhn) zzix.zza(new zzhn(), bArr, 0, bArr.length);
            DriveId driveId = new DriveId("".equals(zzhn.zzab) ? null : zzhn.zzab, zzhn.zzac, zzhn.zzf, zzhn.zzad);
            return driveId;
        } catch (zziw unused) {
            throw new IllegalArgumentException();
        }
    }

    public DriveFile asDriveFile() {
        if (this.zzad != 1) {
            return new zzbn(this);
        }
        throw new IllegalStateException("This DriveId corresponds to a folder. Call asDriveFolder instead.");
    }

    public DriveFolder asDriveFolder() {
        if (this.zzad != 0) {
            return new zzbs(this);
        }
        throw new IllegalStateException("This DriveId corresponds to a file. Call asDriveFile instead.");
    }

    public DriveResource asDriveResource() {
        int i = this.zzad;
        return i == 1 ? asDriveFolder() : i == 0 ? asDriveFile() : new zzdp(this);
    }

    public final String encodeToString() {
        if (this.zzh == null) {
            zzhn zzhn = new zzhn();
            zzhn.versionCode = 1;
            String str = this.zzab;
            if (str == null) {
                str = "";
            }
            zzhn.zzab = str;
            zzhn.zzac = this.zzac;
            zzhn.zzf = this.zzf;
            zzhn.zzad = this.zzad;
            String str2 = "DriveId:";
            String valueOf = String.valueOf(Base64.encodeToString(zzix.zza((zzix) zzhn), 10));
            this.zzh = valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2);
        }
        return this.zzh;
    }

    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == DriveId.class) {
            DriveId driveId = (DriveId) obj;
            if (driveId.zzf != this.zzf) {
                return false;
            }
            if (driveId.zzac == -1 && this.zzac == -1) {
                return driveId.zzab.equals(this.zzab);
            }
            String str = this.zzab;
            if (str != null) {
                String str2 = driveId.zzab;
                if (str2 != null) {
                    return driveId.zzac == this.zzac && str2.equals(str);
                }
            }
            if (driveId.zzac == this.zzac) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public String getResourceId() {
        return this.zzab;
    }

    public int getResourceType() {
        return this.zzad;
    }

    public int hashCode() {
        if (this.zzac == -1) {
            return this.zzab.hashCode();
        }
        String valueOf = String.valueOf(String.valueOf(this.zzf));
        String valueOf2 = String.valueOf(String.valueOf(this.zzac));
        return (valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)).hashCode();
    }

    public final String toInvariantString() {
        if (this.zzae == null) {
            zzho zzho = new zzho();
            zzho.zzac = this.zzac;
            zzho.zzf = this.zzf;
            this.zzae = Base64.encodeToString(zzix.zza((zzix) zzho), 10);
        }
        return this.zzae;
    }

    public String toString() {
        return encodeToString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzab, false);
        SafeParcelWriter.writeLong(parcel, 3, this.zzac);
        SafeParcelWriter.writeLong(parcel, 4, this.zzf);
        SafeParcelWriter.writeInt(parcel, 5, this.zzad);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
