package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.games.internal.zzd;

@UsedByReflection("GamesClientImpl.java")
@Class(creator = "AppContentConditionEntityCreator")
@Reserved({1000})
public final class AppContentConditionEntity extends zzd implements zzg {
    public static final Creator<AppContentConditionEntity> CREATOR = new zzh();
    @Field(getter = "getDefaultValue", mo15151id = 1)
    private final String zzgf;
    @Field(getter = "getExpectedValue", mo15151id = 2)
    private final String zzgg;
    @Field(getter = "getPredicate", mo15151id = 3)
    private final String zzgh;
    @Field(getter = "getPredicateParameters", mo15151id = 4)
    private final Bundle zzgi;

    @Constructor
    AppContentConditionEntity(@Param(mo15154id = 1) String str, @Param(mo15154id = 2) String str2, @Param(mo15154id = 3) String str3, @Param(mo15154id = 4) Bundle bundle) {
        this.zzgf = str;
        this.zzgg = str2;
        this.zzgh = str3;
        this.zzgi = bundle;
    }

    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    public final boolean isDataValid() {
        return true;
    }

    public final String zzam() {
        return this.zzgf;
    }

    public final String zzan() {
        return this.zzgg;
    }

    public final String zzao() {
        return this.zzgh;
    }

    public final Bundle zzap() {
        return this.zzgi;
    }

    public final int hashCode() {
        return Objects.hashCode(zzam(), zzan(), zzao(), zzap());
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzg) {
            if (this == obj) {
                return true;
            }
            zzg zzg = (zzg) obj;
            if (Objects.equal(zzg.zzam(), zzam()) && Objects.equal(zzg.zzan(), zzan()) && Objects.equal(zzg.zzao(), zzao()) && Objects.equal(zzg.zzap(), zzap())) {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("DefaultValue", zzam()).add("ExpectedValue", zzan()).add("Predicate", zzao()).add("PredicateParameters", zzap()).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzgf, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzgg, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzgh, false);
        SafeParcelWriter.writeBundle(parcel, 4, this.zzgi, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
