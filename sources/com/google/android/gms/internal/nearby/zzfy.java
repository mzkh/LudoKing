package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
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
import com.google.android.gms.nearby.connection.AdvertisingOptions;

@Class(creator = "StartAdvertisingParamsCreator")
@Reserved({1000})
public final class zzfy extends AbstractSafeParcelable {
    public static final Creator<zzfy> CREATOR = new zzgb();
    /* access modifiers changed from: private */
    @Field(getter = "getDurationMillis", mo15151id = 5)
    public long durationMillis;
    /* access modifiers changed from: private */
    @Field(getter = "getName", mo15151id = 3)
    public String name;
    /* access modifiers changed from: private */
    @Field(getter = "getConnectionLifecycleListenerAsBinder", mo15151id = 7, type = "android.os.IBinder")
    @Nullable
    public zzdj zzec;
    /* access modifiers changed from: private */
    @Field(getter = "getResultListenerAsBinder", mo15151id = 1, type = "android.os.IBinder")
    @Nullable
    public zzec zzeh;
    /* access modifiers changed from: private */
    @Field(getter = "getCallbackAsBinder", mo15151id = 2, type = "android.os.IBinder")
    @Nullable
    public zzdd zzei;
    /* access modifiers changed from: private */
    @Field(getter = "getOptions", mo15151id = 6)
    public AdvertisingOptions zzej;
    /* access modifiers changed from: private */
    @Field(getter = "getServiceId", mo15151id = 4)
    public String zzu;

    private zzfy() {
    }

    @Constructor
    zzfy(@Param(mo15154id = 1) @Nullable IBinder iBinder, @Param(mo15154id = 2) @Nullable IBinder iBinder2, @Param(mo15154id = 3) String str, @Param(mo15154id = 4) String str2, @Param(mo15154id = 5) long j, @Param(mo15154id = 6) AdvertisingOptions advertisingOptions, @Param(mo15154id = 7) @Nullable IBinder iBinder3) {
        zzec zzec2;
        zzdd zzdd;
        IBinder iBinder4 = iBinder2;
        IBinder iBinder5 = iBinder3;
        zzdj zzdj = null;
        if (iBinder == null) {
            zzec2 = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IStartAdvertisingResultListener");
            zzec2 = queryLocalInterface instanceof zzec ? (zzec) queryLocalInterface : new zzee(iBinder);
        }
        if (iBinder4 == null) {
            zzdd = null;
        } else {
            IInterface queryLocalInterface2 = iBinder4.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IAdvertisingCallback");
            zzdd = queryLocalInterface2 instanceof zzdd ? (zzdd) queryLocalInterface2 : new zzdf(iBinder4);
        }
        if (iBinder5 != null) {
            IInterface queryLocalInterface3 = iBinder5.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IConnectionLifecycleListener");
            zzdj = queryLocalInterface3 instanceof zzdj ? (zzdj) queryLocalInterface3 : new zzdl(iBinder5);
        }
        this(zzec2, zzdd, str, str2, j, advertisingOptions, zzdj);
    }

    private zzfy(@Nullable zzec zzec2, @Nullable zzdd zzdd, String str, String str2, long j, AdvertisingOptions advertisingOptions, @Nullable zzdj zzdj) {
        this.zzeh = zzec2;
        this.zzei = zzdd;
        this.name = str;
        this.zzu = str2;
        this.durationMillis = j;
        this.zzej = advertisingOptions;
        this.zzec = zzdj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzfy) {
            zzfy zzfy = (zzfy) obj;
            return Objects.equal(this.zzeh, zzfy.zzeh) && Objects.equal(this.zzei, zzfy.zzei) && Objects.equal(this.name, zzfy.name) && Objects.equal(this.zzu, zzfy.zzu) && Objects.equal(Long.valueOf(this.durationMillis), Long.valueOf(zzfy.durationMillis)) && Objects.equal(this.zzej, zzfy.zzej) && Objects.equal(this.zzec, zzfy.zzec);
        }
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzeh, this.zzei, this.name, this.zzu, Long.valueOf(this.durationMillis), this.zzej, this.zzec);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        zzec zzec2 = this.zzeh;
        IBinder iBinder = null;
        SafeParcelWriter.writeIBinder(parcel, 1, zzec2 == null ? null : zzec2.asBinder(), false);
        zzdd zzdd = this.zzei;
        SafeParcelWriter.writeIBinder(parcel, 2, zzdd == null ? null : zzdd.asBinder(), false);
        SafeParcelWriter.writeString(parcel, 3, this.name, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzu, false);
        SafeParcelWriter.writeLong(parcel, 5, this.durationMillis);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzej, i, false);
        zzdj zzdj = this.zzec;
        if (zzdj != null) {
            iBinder = zzdj.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 7, iBinder, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
