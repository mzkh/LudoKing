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
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.nearby.messages.Strategy;

@Class(creator = "PublishRequestCreator")
public final class zzbz extends AbstractSafeParcelable {
    public static final Creator<zzbz> CREATOR = new zzca();
    @VersionField(mo15157id = 1)
    private final int versionCode;
    @Field(mo15151id = 5)
    @Deprecated
    @Nullable
    private final String zzff;
    @Field(mo15151id = 9)
    @Deprecated
    private final boolean zzfg;
    @Field(mo15151id = 6)
    @Deprecated
    @Nullable
    private final String zzfj;
    @Field(mo15151id = 11)
    private final int zzhf;
    @Field(getter = "getCallbackAsBinder", mo15151id = 4, type = "android.os.IBinder")
    private final zzp zzhh;
    @Field(mo15151id = 10)
    @Deprecated
    private final ClientAppContext zzhi;
    @Field(mo15151id = 2)
    private final zzaf zzis;
    @Field(mo15151id = 3)
    private final Strategy zzit;
    @Field(mo15151id = 7)
    @Deprecated
    private final boolean zziu;
    @Field(getter = "getPublishCallbackAsBinder", mo15151id = 8, type = "android.os.IBinder")
    @Nullable
    private final zzu zziv;

    @Constructor
    zzbz(@Param(mo15154id = 1) int i, @Param(mo15154id = 2) zzaf zzaf, @Param(mo15154id = 3) Strategy strategy, @Param(mo15154id = 4) IBinder iBinder, @Param(mo15154id = 5) @Nullable String str, @Param(mo15154id = 6) @Nullable String str2, @Param(mo15154id = 7) boolean z, @Param(mo15154id = 8) @Nullable IBinder iBinder2, @Param(mo15154id = 9) boolean z2, @Param(mo15154id = 10) @Nullable ClientAppContext clientAppContext, @Param(mo15154id = 11) int i2) {
        zzp zzp;
        this.versionCode = i;
        this.zzis = zzaf;
        this.zzit = strategy;
        zzu zzu = null;
        if (iBinder == null) {
            zzp = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesCallback");
            zzp = queryLocalInterface instanceof zzp ? (zzp) queryLocalInterface : new zzr(iBinder);
        }
        this.zzhh = zzp;
        this.zzff = str;
        this.zzfj = str2;
        this.zziu = z;
        if (!(iBinder2 == null || iBinder2 == null)) {
            IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.messages.internal.IPublishCallback");
            zzu = queryLocalInterface2 instanceof zzu ? (zzu) queryLocalInterface2 : new zzw(iBinder2);
        }
        this.zziv = zzu;
        this.zzfg = z2;
        this.zzhi = ClientAppContext.zza(clientAppContext, str2, str, z2);
        this.zzhf = i2;
    }

    @VisibleForTesting
    public zzbz(zzaf zzaf, Strategy strategy, IBinder iBinder, @Nullable IBinder iBinder2, int i) {
        this(2, zzaf, strategy, iBinder, null, null, false, iBinder2, false, null, i);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzis, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzit, i, false);
        SafeParcelWriter.writeIBinder(parcel, 4, this.zzhh.asBinder(), false);
        SafeParcelWriter.writeString(parcel, 5, this.zzff, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzfj, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zziu);
        zzu zzu = this.zziv;
        SafeParcelWriter.writeIBinder(parcel, 8, zzu == null ? null : zzu.asBinder(), false);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzfg);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzhi, i, false);
        SafeParcelWriter.writeInt(parcel, 11, this.zzhf);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
