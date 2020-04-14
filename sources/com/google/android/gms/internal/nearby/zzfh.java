package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import java.util.Arrays;

@Class(creator = "ParcelablePayloadCreator")
@Reserved({1000})
public final class zzfh extends AbstractSafeParcelable {
    public static final Creator<zzfh> CREATOR = new zzfk();
    /* access modifiers changed from: private */
    @Field(getter = "getId", mo15151id = 1)

    /* renamed from: id */
    public long f3923id;
    /* access modifiers changed from: private */
    @Field(getter = "getType", mo15151id = 2)
    public int type;
    /* access modifiers changed from: private */
    @Field(getter = "getDataPfd", mo15151id = 4)
    @Nullable
    public ParcelFileDescriptor zzdv;
    /* access modifiers changed from: private */
    @Field(getter = "getJavaFilePath", mo15151id = 5)
    @Nullable
    public String zzdw;
    /* access modifiers changed from: private */
    @Field(defaultValue = "-1", getter = "getJavaFileSize", mo15151id = 6)
    public long zzdx;
    /* access modifiers changed from: private */
    @Field(getter = "getStatusPfd", mo15151id = 7)
    @Nullable
    public ParcelFileDescriptor zzdy;
    /* access modifiers changed from: private */
    @Field(getter = "getBytes", mo15151id = 3)
    @Nullable
    public byte[] zzy;

    private zzfh() {
        this.zzdx = -1;
    }

    @Constructor
    zzfh(@Param(mo15154id = 1) long j, @Param(mo15154id = 2) int i, @Param(mo15154id = 3) @Nullable byte[] bArr, @Param(mo15154id = 4) @Nullable ParcelFileDescriptor parcelFileDescriptor, @Param(mo15154id = 5) @Nullable String str, @Param(mo15154id = 6) long j2, @Param(mo15154id = 7) @Nullable ParcelFileDescriptor parcelFileDescriptor2) {
        this.zzdx = -1;
        this.f3923id = j;
        this.type = i;
        this.zzy = bArr;
        this.zzdv = parcelFileDescriptor;
        this.zzdw = str;
        this.zzdx = j2;
        this.zzdy = parcelFileDescriptor2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzfh) {
            zzfh zzfh = (zzfh) obj;
            return Objects.equal(Long.valueOf(this.f3923id), Long.valueOf(zzfh.f3923id)) && Objects.equal(Integer.valueOf(this.type), Integer.valueOf(zzfh.type)) && Arrays.equals(this.zzy, zzfh.zzy) && Objects.equal(this.zzdv, zzfh.zzdv) && Objects.equal(this.zzdw, zzfh.zzdw) && Objects.equal(Long.valueOf(this.zzdx), Long.valueOf(zzfh.zzdx)) && Objects.equal(this.zzdy, zzfh.zzdy);
        }
    }

    @Nullable
    public final byte[] getBytes() {
        return this.zzy;
    }

    public final long getId() {
        return this.f3923id;
    }

    public final int getType() {
        return this.type;
    }

    public final int hashCode() {
        return Objects.hashCode(Long.valueOf(this.f3923id), Integer.valueOf(this.type), Integer.valueOf(Arrays.hashCode(this.zzy)), this.zzdv, this.zzdw, Long.valueOf(this.zzdx), this.zzdy);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, this.f3923id);
        SafeParcelWriter.writeInt(parcel, 2, this.type);
        SafeParcelWriter.writeByteArray(parcel, 3, this.zzy, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzdv, i, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzdw, false);
        SafeParcelWriter.writeLong(parcel, 6, this.zzdx);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzdy, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Nullable
    public final ParcelFileDescriptor zzo() {
        return this.zzdv;
    }

    @Nullable
    public final String zzp() {
        return this.zzdw;
    }

    public final long zzq() {
        return this.zzdx;
    }
}
