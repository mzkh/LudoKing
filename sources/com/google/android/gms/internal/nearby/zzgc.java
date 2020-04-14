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
import com.google.android.gms.nearby.connection.DiscoveryOptions;

@Class(creator = "StartDiscoveryParamsCreator")
@Reserved({1000})
public final class zzgc extends AbstractSafeParcelable {
    public static final Creator<zzgc> CREATOR = new zzgf();
    /* access modifiers changed from: private */
    @Field(getter = "getDurationMillis", mo15151id = 4)
    public long durationMillis;
    /* access modifiers changed from: private */
    @Field(getter = "getResultListenerAsBinder", mo15151id = 1, type = "android.os.IBinder")
    @Nullable
    public zzdz zzar;
    @Field(getter = "getCallbackAsBinder", mo15151id = 2, type = "android.os.IBinder")
    @Nullable
    private zzdp zzel;
    /* access modifiers changed from: private */
    @Field(getter = "getOptions", mo15151id = 5)
    public DiscoveryOptions zzem;
    /* access modifiers changed from: private */
    @Field(getter = "getDiscoveryListenerAsBinder", mo15151id = 6, type = "android.os.IBinder")
    @Nullable
    public zzdr zzen;
    /* access modifiers changed from: private */
    @Field(getter = "getServiceId", mo15151id = 3)
    public String zzu;

    private zzgc() {
    }

    @Constructor
    zzgc(@Param(mo15154id = 1) @Nullable IBinder iBinder, @Param(mo15154id = 2) @Nullable IBinder iBinder2, @Param(mo15154id = 3) String str, @Param(mo15154id = 4) long j, @Param(mo15154id = 5) DiscoveryOptions discoveryOptions, @Param(mo15154id = 6) @Nullable IBinder iBinder3) {
        zzdz zzdz;
        zzdp zzdp;
        IBinder iBinder4 = iBinder2;
        IBinder iBinder5 = iBinder3;
        zzdr zzdr = null;
        if (iBinder == null) {
            zzdz = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IResultListener");
            zzdz = queryLocalInterface instanceof zzdz ? (zzdz) queryLocalInterface : new zzeb(iBinder);
        }
        if (iBinder4 == null) {
            zzdp = null;
        } else {
            IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IDiscoveryCallback");
            zzdp = queryLocalInterface2 instanceof zzdp ? (zzdp) queryLocalInterface2 : new zzdq(iBinder2);
        }
        if (iBinder5 != null) {
            IInterface queryLocalInterface3 = iBinder5.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IDiscoveryListener");
            zzdr = queryLocalInterface3 instanceof zzdr ? (zzdr) queryLocalInterface3 : new zzdt(iBinder5);
        }
        this(zzdz, zzdp, str, j, discoveryOptions, zzdr);
    }

    private zzgc(@Nullable zzdz zzdz, @Nullable zzdp zzdp, String str, long j, DiscoveryOptions discoveryOptions, @Nullable zzdr zzdr) {
        this.zzar = zzdz;
        this.zzel = zzdp;
        this.zzu = str;
        this.durationMillis = j;
        this.zzem = discoveryOptions;
        this.zzen = zzdr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzgc) {
            zzgc zzgc = (zzgc) obj;
            return Objects.equal(this.zzar, zzgc.zzar) && Objects.equal(this.zzel, zzgc.zzel) && Objects.equal(this.zzu, zzgc.zzu) && Objects.equal(Long.valueOf(this.durationMillis), Long.valueOf(zzgc.durationMillis)) && Objects.equal(this.zzem, zzgc.zzem) && Objects.equal(this.zzen, zzgc.zzen);
        }
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzar, this.zzel, this.zzu, Long.valueOf(this.durationMillis), this.zzem, this.zzen);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        zzdz zzdz = this.zzar;
        IBinder iBinder = null;
        SafeParcelWriter.writeIBinder(parcel, 1, zzdz == null ? null : zzdz.asBinder(), false);
        zzdp zzdp = this.zzel;
        SafeParcelWriter.writeIBinder(parcel, 2, zzdp == null ? null : zzdp.asBinder(), false);
        SafeParcelWriter.writeString(parcel, 3, this.zzu, false);
        SafeParcelWriter.writeLong(parcel, 4, this.durationMillis);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzem, i, false);
        zzdr zzdr = this.zzen;
        if (zzdr != null) {
            iBinder = zzdr.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 6, iBinder, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
