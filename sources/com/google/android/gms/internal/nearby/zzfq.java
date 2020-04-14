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

@Class(creator = "SendConnectionRequestParamsCreator")
@Reserved({1000})
public final class zzfq extends AbstractSafeParcelable {
    public static final Creator<zzfq> CREATOR = new zzft();
    /* access modifiers changed from: private */
    @Field(getter = "getName", mo15151id = 4)
    @Nullable
    public String name;
    /* access modifiers changed from: private */
    @Field(getter = "getResultListenerAsBinder", mo15151id = 1, type = "android.os.IBinder")
    @Nullable
    public zzdz zzar;
    /* access modifiers changed from: private */
    @Field(getter = "getConnectionEventListenerAsBinder", mo15151id = 2, type = "android.os.IBinder")
    @Nullable
    public zzdg zzas;
    /* access modifiers changed from: private */
    @Field(getter = "getRemoteEndpointId", mo15151id = 5)
    public String zzat;
    /* access modifiers changed from: private */
    @Field(getter = "getHandshakeData", mo15151id = 6)
    @Nullable
    public byte[] zzau;
    /* access modifiers changed from: private */
    @Field(getter = "getConnectionResponseListenerAsBinder", mo15151id = 3, type = "android.os.IBinder")
    @Nullable
    public zzdm zzeb;
    /* access modifiers changed from: private */
    @Field(getter = "getConnectionLifecycleListenerAsBinder", mo15151id = 7, type = "android.os.IBinder")
    @Nullable
    public zzdj zzec;

    private zzfq() {
    }

    @Constructor
    zzfq(@Param(mo15154id = 1) @Nullable IBinder iBinder, @Param(mo15154id = 2) @Nullable IBinder iBinder2, @Param(mo15154id = 3) @Nullable IBinder iBinder3, @Param(mo15154id = 4) @Nullable String str, @Param(mo15154id = 5) String str2, @Param(mo15154id = 6) @Nullable byte[] bArr, @Param(mo15154id = 7) @Nullable IBinder iBinder4) {
        zzdz zzdz;
        zzdg zzdg;
        zzdm zzdm;
        IBinder iBinder5 = iBinder2;
        IBinder iBinder6 = iBinder3;
        IBinder iBinder7 = iBinder4;
        zzdj zzdj = null;
        if (iBinder == null) {
            zzdz = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IResultListener");
            zzdz = queryLocalInterface instanceof zzdz ? (zzdz) queryLocalInterface : new zzeb(iBinder);
        }
        if (iBinder5 == null) {
            zzdg = null;
        } else {
            IInterface queryLocalInterface2 = iBinder5.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IConnectionEventListener");
            zzdg = queryLocalInterface2 instanceof zzdg ? (zzdg) queryLocalInterface2 : new zzdi(iBinder5);
        }
        if (iBinder6 == null) {
            zzdm = null;
        } else {
            IInterface queryLocalInterface3 = iBinder6.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IConnectionResponseListener");
            zzdm = queryLocalInterface3 instanceof zzdm ? (zzdm) queryLocalInterface3 : new zzdo(iBinder6);
        }
        if (iBinder7 != null) {
            IInterface queryLocalInterface4 = iBinder7.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IConnectionLifecycleListener");
            zzdj = queryLocalInterface4 instanceof zzdj ? (zzdj) queryLocalInterface4 : new zzdl(iBinder7);
        }
        this(zzdz, zzdg, zzdm, str, str2, bArr, zzdj);
    }

    private zzfq(@Nullable zzdz zzdz, @Nullable zzdg zzdg, @Nullable zzdm zzdm, @Nullable String str, String str2, @Nullable byte[] bArr, @Nullable zzdj zzdj) {
        this.zzar = zzdz;
        this.zzas = zzdg;
        this.zzeb = zzdm;
        this.name = str;
        this.zzat = str2;
        this.zzau = bArr;
        this.zzec = zzdj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzfq) {
            zzfq zzfq = (zzfq) obj;
            return Objects.equal(this.zzar, zzfq.zzar) && Objects.equal(this.zzas, zzfq.zzas) && Objects.equal(this.zzeb, zzfq.zzeb) && Objects.equal(this.name, zzfq.name) && Objects.equal(this.zzat, zzfq.zzat) && Arrays.equals(this.zzau, zzfq.zzau) && Objects.equal(this.zzec, zzfq.zzec);
        }
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzar, this.zzas, this.zzeb, this.name, this.zzat, Integer.valueOf(Arrays.hashCode(this.zzau)), this.zzec);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        zzdz zzdz = this.zzar;
        IBinder iBinder = null;
        SafeParcelWriter.writeIBinder(parcel, 1, zzdz == null ? null : zzdz.asBinder(), false);
        zzdg zzdg = this.zzas;
        SafeParcelWriter.writeIBinder(parcel, 2, zzdg == null ? null : zzdg.asBinder(), false);
        zzdm zzdm = this.zzeb;
        SafeParcelWriter.writeIBinder(parcel, 3, zzdm == null ? null : zzdm.asBinder(), false);
        SafeParcelWriter.writeString(parcel, 4, this.name, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzat, false);
        SafeParcelWriter.writeByteArray(parcel, 6, this.zzau, false);
        zzdj zzdj = this.zzec;
        if (zzdj != null) {
            iBinder = zzdj.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 7, iBinder, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
