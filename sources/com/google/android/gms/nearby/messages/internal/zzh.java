package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.IInterface;
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

@Class(creator = "GetPermissionStatusRequestCreator")
@Deprecated
public final class zzh extends AbstractSafeParcelable {
    public static final Creator<zzh> CREATOR = new zzi();
    @VersionField(mo15157id = 1)
    private final int versionCode;
    @Field(mo15151id = 3)
    @Deprecated
    @Nullable
    private final String zzff;
    @Field(getter = "getCallbackAsBinder", mo15151id = 2, type = "android.os.IBinder")
    private final zzp zzhh;
    @Field(mo15151id = 4)
    @Deprecated
    @Nullable
    private final ClientAppContext zzhi;

    @Constructor
    zzh(@Param(mo15154id = 1) int i, @Param(mo15154id = 2) IBinder iBinder, @Param(mo15154id = 3) @Nullable String str, @Param(mo15154id = 4) @Nullable ClientAppContext clientAppContext) {
        zzp zzp;
        this.versionCode = i;
        if (iBinder == null) {
            zzp = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesCallback");
            zzp = queryLocalInterface instanceof zzp ? (zzp) queryLocalInterface : new zzr(iBinder);
        }
        this.zzhh = zzp;
        this.zzff = str;
        this.zzhi = ClientAppContext.zza(clientAppContext, null, str, false);
    }

    zzh(IBinder iBinder) {
        this(1, iBinder, null, null);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeIBinder(parcel, 2, this.zzhh.asBinder(), false);
        SafeParcelWriter.writeString(parcel, 3, this.zzff, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzhi, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
