package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@Class(creator = "HandleClientLifecycleEventRequestCreator")
public final class zzj extends AbstractSafeParcelable {
    public static final Creator<zzj> CREATOR = new zzk();
    @VersionField(mo15157id = 1)
    private final int versionCode;
    @Field(mo15151id = 2)
    @Deprecated
    @Nullable
    private final ClientAppContext zzhi;
    @Field(mo15151id = 3)
    private final int zzhj;

    public zzj(int i) {
        this(1, null, i);
    }

    @Constructor
    zzj(@Param(mo15154id = 1) int i, @Param(mo15154id = 2) ClientAppContext clientAppContext, @Param(mo15154id = 3) int i2) {
        this.versionCode = i;
        this.zzhi = clientAppContext;
        this.zzhj = i2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzhi, i, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzhj);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
