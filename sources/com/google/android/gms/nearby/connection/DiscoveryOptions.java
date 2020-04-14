package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@Class(creator = "DiscoveryOptionsCreator")
@Reserved({1000})
public final class DiscoveryOptions extends AbstractSafeParcelable {
    public static final Creator<DiscoveryOptions> CREATOR = new zzg();
    /* access modifiers changed from: private */
    @Field(getter = "getStrategy", mo15151id = 1)
    public Strategy zzh;
    /* access modifiers changed from: private */
    @Field(defaultValue = "true", getter = "getEnableBluetooth", mo15151id = 3)
    public boolean zzk;
    /* access modifiers changed from: private */
    @Field(defaultValue = "true", getter = "getEnableBle", mo15151id = 4)
    public boolean zzl;
    /* access modifiers changed from: private */
    @Field(defaultValue = "false", getter = "getForwardUnrecognizedBluetoothDevices", mo15151id = 2)
    public boolean zzw;

    public static final class Builder {
        private final DiscoveryOptions zzx = new DiscoveryOptions();

        public Builder() {
        }

        public Builder(DiscoveryOptions discoveryOptions) {
            this.zzx.zzh = discoveryOptions.zzh;
            this.zzx.zzw = discoveryOptions.zzw;
            this.zzx.zzk = discoveryOptions.zzk;
            this.zzx.zzl = discoveryOptions.zzl;
        }

        public final DiscoveryOptions build() {
            return this.zzx;
        }

        public final Builder setStrategy(Strategy strategy) {
            this.zzx.zzh = strategy;
            return this;
        }
    }

    private DiscoveryOptions() {
        this.zzw = false;
        this.zzk = true;
        this.zzl = true;
    }

    @Deprecated
    public DiscoveryOptions(Strategy strategy) {
        this.zzw = false;
        this.zzk = true;
        this.zzl = true;
        this.zzh = strategy;
    }

    @Constructor
    DiscoveryOptions(@Param(mo15154id = 1) Strategy strategy, @Param(mo15154id = 2) boolean z, @Param(mo15154id = 3) boolean z2, @Param(mo15154id = 4) boolean z3) {
        this.zzw = false;
        this.zzk = true;
        this.zzl = true;
        this.zzh = strategy;
        this.zzw = z;
        this.zzk = z2;
        this.zzl = z3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DiscoveryOptions) {
            DiscoveryOptions discoveryOptions = (DiscoveryOptions) obj;
            return Objects.equal(this.zzh, discoveryOptions.zzh) && Objects.equal(Boolean.valueOf(this.zzw), Boolean.valueOf(discoveryOptions.zzw)) && Objects.equal(Boolean.valueOf(this.zzk), Boolean.valueOf(discoveryOptions.zzk)) && Objects.equal(Boolean.valueOf(this.zzl), Boolean.valueOf(discoveryOptions.zzl));
        }
    }

    public final Strategy getStrategy() {
        return this.zzh;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzh, Boolean.valueOf(this.zzw), Boolean.valueOf(this.zzk), Boolean.valueOf(this.zzl));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getStrategy(), i, false);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzw);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzk);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzl);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
