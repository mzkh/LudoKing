package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@Class(creator = "ConditionalUserPropertyParcelCreator")
public final class zzq extends AbstractSafeParcelable {
    public static final Creator<zzq> CREATOR = new zzt();
    @Field(mo15151id = 6)
    public boolean active;
    @Field(mo15151id = 5)
    public long creationTimestamp;
    @Field(mo15151id = 3)
    public String origin;
    @Field(mo15151id = 2)
    public String packageName;
    @Field(mo15151id = 11)
    public long timeToLive;
    @Field(mo15151id = 7)
    public String triggerEventName;
    @Field(mo15151id = 9)
    public long triggerTimeout;
    @Field(mo15151id = 4)
    public zzjn zzdw;
    @Field(mo15151id = 8)
    public zzai zzdx;
    @Field(mo15151id = 10)
    public zzai zzdy;
    @Field(mo15151id = 12)
    public zzai zzdz;

    zzq(zzq zzq) {
        Preconditions.checkNotNull(zzq);
        this.packageName = zzq.packageName;
        this.origin = zzq.origin;
        this.zzdw = zzq.zzdw;
        this.creationTimestamp = zzq.creationTimestamp;
        this.active = zzq.active;
        this.triggerEventName = zzq.triggerEventName;
        this.zzdx = zzq.zzdx;
        this.triggerTimeout = zzq.triggerTimeout;
        this.zzdy = zzq.zzdy;
        this.timeToLive = zzq.timeToLive;
        this.zzdz = zzq.zzdz;
    }

    @Constructor
    zzq(@Param(mo15154id = 2) String str, @Param(mo15154id = 3) String str2, @Param(mo15154id = 4) zzjn zzjn, @Param(mo15154id = 5) long j, @Param(mo15154id = 6) boolean z, @Param(mo15154id = 7) String str3, @Param(mo15154id = 8) zzai zzai, @Param(mo15154id = 9) long j2, @Param(mo15154id = 10) zzai zzai2, @Param(mo15154id = 11) long j3, @Param(mo15154id = 12) zzai zzai3) {
        this.packageName = str;
        this.origin = str2;
        this.zzdw = zzjn;
        this.creationTimestamp = j;
        this.active = z;
        this.triggerEventName = str3;
        this.zzdx = zzai;
        this.triggerTimeout = j2;
        this.zzdy = zzai2;
        this.timeToLive = j3;
        this.zzdz = zzai3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.packageName, false);
        SafeParcelWriter.writeString(parcel, 3, this.origin, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzdw, i, false);
        SafeParcelWriter.writeLong(parcel, 5, this.creationTimestamp);
        SafeParcelWriter.writeBoolean(parcel, 6, this.active);
        SafeParcelWriter.writeString(parcel, 7, this.triggerEventName, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzdx, i, false);
        SafeParcelWriter.writeLong(parcel, 9, this.triggerTimeout);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzdy, i, false);
        SafeParcelWriter.writeLong(parcel, 11, this.timeToLive);
        SafeParcelWriter.writeParcelable(parcel, 12, this.zzdz, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
