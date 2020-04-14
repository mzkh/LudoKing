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
import java.util.Arrays;

@Class(creator = "AcceptConnectionRequestParamsCreator")
@Reserved({1000})
public final class zzm extends AbstractSafeParcelable {
    public static final Creator<zzm> CREATOR = new zzp();
    /* access modifiers changed from: private */
    @Field(getter = "getResultListenerAsBinder", mo15151id = 1, type = "android.os.IBinder")
    @Nullable
    public zzdz zzar;
    /* access modifiers changed from: private */
    @Field(getter = "getConnectionEventListenerAsBinder", mo15151id = 2, type = "android.os.IBinder")
    @Nullable
    public zzdg zzas;
    /* access modifiers changed from: private */
    @Field(getter = "getRemoteEndpointId", mo15151id = 3)
    public String zzat;
    /* access modifiers changed from: private */
    @Field(getter = "getHandshakeData", mo15151id = 4)
    @Nullable
    public byte[] zzau;
    /* access modifiers changed from: private */
    @Field(getter = "getPayloadListenerAsBinder", mo15151id = 5, type = "android.os.IBinder")
    @Nullable
    public zzdw zzav;

    private zzm() {
    }

    @Constructor
    zzm(@Param(mo15154id = 1) @Nullable IBinder iBinder, @Param(mo15154id = 2) @Nullable IBinder iBinder2, @Param(mo15154id = 3) String str, @Param(mo15154id = 4) @Nullable byte[] bArr, @Param(mo15154id = 5) @Nullable IBinder iBinder3) {
        zzdz zzdz;
        zzdg zzdg;
        zzdw zzdw = null;
        if (iBinder == null) {
            zzdz = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IResultListener");
            zzdz = queryLocalInterface instanceof zzdz ? (zzdz) queryLocalInterface : new zzeb(iBinder);
        }
        if (iBinder2 == null) {
            zzdg = null;
        } else {
            IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IConnectionEventListener");
            zzdg = queryLocalInterface2 instanceof zzdg ? (zzdg) queryLocalInterface2 : new zzdi(iBinder2);
        }
        if (iBinder3 != null) {
            IInterface queryLocalInterface3 = iBinder3.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IPayloadListener");
            zzdw = queryLocalInterface3 instanceof zzdw ? (zzdw) queryLocalInterface3 : new zzdy(iBinder3);
        }
        this(zzdz, zzdg, str, bArr, zzdw);
    }

    private zzm(@Nullable zzdz zzdz, @Nullable zzdg zzdg, String str, @Nullable byte[] bArr, @Nullable zzdw zzdw) {
        this.zzar = zzdz;
        this.zzas = zzdg;
        this.zzat = str;
        this.zzau = bArr;
        this.zzav = zzdw;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzm) {
            zzm zzm = (zzm) obj;
            return Objects.equal(this.zzar, zzm.zzar) && Objects.equal(this.zzas, zzm.zzas) && Objects.equal(this.zzat, zzm.zzat) && Arrays.equals(this.zzau, zzm.zzau) && Objects.equal(this.zzav, zzm.zzav);
        }
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzar, this.zzas, this.zzat, Integer.valueOf(Arrays.hashCode(this.zzau)), this.zzav);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        zzdz zzdz = this.zzar;
        IBinder iBinder = null;
        SafeParcelWriter.writeIBinder(parcel, 1, zzdz == null ? null : zzdz.asBinder(), false);
        zzdg zzdg = this.zzas;
        SafeParcelWriter.writeIBinder(parcel, 2, zzdg == null ? null : zzdg.asBinder(), false);
        SafeParcelWriter.writeString(parcel, 3, this.zzat, false);
        SafeParcelWriter.writeByteArray(parcel, 4, this.zzau, false);
        zzdw zzdw = this.zzav;
        if (zzdw != null) {
            iBinder = zzdw.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 5, iBinder, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
