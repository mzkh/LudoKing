package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.internal.drive.zzhm;
import com.google.android.gms.internal.drive.zzix;

@Class(creator = "ChangeSequenceNumberCreator")
@Reserved({1})
public class zza extends AbstractSafeParcelable {
    public static final Creator<zza> CREATOR = new zzb();
    @Field(mo15151id = 2)
    private final long zze;
    @Field(mo15151id = 3)
    private final long zzf;
    @Field(mo15151id = 4)
    private final long zzg;
    private volatile String zzh = null;

    @Constructor
    public zza(@Param(mo15154id = 2) long j, @Param(mo15154id = 3) long j2, @Param(mo15154id = 4) long j3) {
        boolean z = true;
        Preconditions.checkArgument(j != -1);
        Preconditions.checkArgument(j2 != -1);
        if (j3 == -1) {
            z = false;
        }
        Preconditions.checkArgument(z);
        this.zze = j;
        this.zzf = j2;
        this.zzg = j3;
    }

    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == zza.class) {
            zza zza = (zza) obj;
            if (zza.zzf == this.zzf && zza.zzg == this.zzg && zza.zze == this.zze) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String valueOf = String.valueOf(this.zze);
        String valueOf2 = String.valueOf(this.zzf);
        String valueOf3 = String.valueOf(this.zzg);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length());
        sb.append(valueOf);
        sb.append(valueOf2);
        sb.append(valueOf3);
        return sb.toString().hashCode();
    }

    public String toString() {
        if (this.zzh == null) {
            zzhm zzhm = new zzhm();
            zzhm.versionCode = 1;
            zzhm.zze = this.zze;
            zzhm.zzf = this.zzf;
            zzhm.zzg = this.zzg;
            String str = "ChangeSequenceNumber:";
            String valueOf = String.valueOf(Base64.encodeToString(zzix.zza((zzix) zzhm), 10));
            this.zzh = valueOf.length() != 0 ? str.concat(valueOf) : new String(str);
        }
        return this.zzh;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 2, this.zze);
        SafeParcelWriter.writeLong(parcel, 3, this.zzf);
        SafeParcelWriter.writeLong(parcel, 4, this.zzg);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
