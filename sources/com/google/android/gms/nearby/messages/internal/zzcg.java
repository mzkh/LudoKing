package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@Class(creator = "UnsubscribeRequestCreator")
public final class zzcg extends AbstractSafeParcelable {
    public static final Creator<zzcg> CREATOR = new zzch();
    @VersionField(mo15157id = 1)
    private final int versionCode;
    @Field(mo15151id = 6)
    @Deprecated
    @Nullable
    private final String zzff;
    @Field(mo15151id = 8)
    @Deprecated
    private final boolean zzfg;
    @Field(mo15151id = 7)
    @Deprecated
    @Nullable
    private final String zzfj;
    @Field(getter = "getCallbackAsBinder", mo15151id = 3, type = "android.os.IBinder")
    private final zzp zzhh;
    @Field(mo15151id = 9)
    @Deprecated
    @Nullable
    private final ClientAppContext zzhi;
    @Field(getter = "getMessageListenerAsBinder", mo15151id = 2, type = "android.os.IBinder")
    @Nullable
    private final zzm zziy;
    @Field(mo15151id = 4)
    @Nullable
    private final PendingIntent zzja;
    @Field(mo15151id = 5)
    @Deprecated
    private final int zzjb;

    @VisibleForTesting
    @Constructor
    public zzcg(@Param(mo15154id = 1) int i, @Param(mo15154id = 2) @Nullable IBinder iBinder, @Param(mo15154id = 3) IBinder iBinder2, @Param(mo15154id = 4) @Nullable PendingIntent pendingIntent, @Param(mo15154id = 5) int i2, @Param(mo15154id = 6) @Nullable String str, @Param(mo15154id = 7) @Nullable String str2, @Param(mo15154id = 8) boolean z, @Param(mo15154id = 9) @Nullable ClientAppContext clientAppContext) {
        zzm zzm;
        this.versionCode = i;
        zzp zzp = null;
        if (iBinder == null) {
            zzm = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.IMessageListener");
            zzm = queryLocalInterface instanceof zzm ? (zzm) queryLocalInterface : new zzo(iBinder);
        }
        this.zziy = zzm;
        if (iBinder2 != null) {
            IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesCallback");
            zzp = queryLocalInterface2 instanceof zzp ? (zzp) queryLocalInterface2 : new zzr(iBinder2);
        }
        this.zzhh = zzp;
        this.zzja = pendingIntent;
        this.zzjb = i2;
        this.zzff = str;
        this.zzfj = str2;
        this.zzfg = z;
        this.zzhi = ClientAppContext.zza(clientAppContext, str2, str, z);
    }

    @VisibleForTesting
    public zzcg(IBinder iBinder, IBinder iBinder2, @Nullable PendingIntent pendingIntent) {
        this(1, iBinder, iBinder2, pendingIntent, 0, null, null, false, null);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        zzm zzm = this.zziy;
        SafeParcelWriter.writeIBinder(parcel, 2, zzm == null ? null : zzm.asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 3, this.zzhh.asBinder(), false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzja, i, false);
        SafeParcelWriter.writeInt(parcel, 5, this.zzjb);
        SafeParcelWriter.writeString(parcel, 6, this.zzff, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzfj, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzfg);
        SafeParcelWriter.writeParcelable(parcel, 9, this.zzhi, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
