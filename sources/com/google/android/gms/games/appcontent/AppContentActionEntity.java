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
import com.google.android.gms.games.internal.zzc;
import com.google.android.gms.games.internal.zzd;
import java.util.ArrayList;
import java.util.List;

@UsedByReflection("GamesClientImpl.java")
@Class(creator = "AppContentActionEntityCreator")
@Reserved({1000})
public final class AppContentActionEntity extends zzd implements zza {
    public static final Creator<AppContentActionEntity> CREATOR = new zzb();
    @Field(getter = "getExtras", mo15151id = 3)
    private final Bundle extras;
    @Field(getter = "getType", mo15151id = 6)
    private final String type;
    @Field(getter = "getConditions", mo15151id = 1)
    private final ArrayList<AppContentConditionEntity> zzfp;
    @Field(getter = "getContentDescription", mo15151id = 2)
    private final String zzfq;
    @Field(getter = "getId", mo15151id = 7)
    private final String zzfr;
    @Field(getter = "getAnnotation", mo15151id = 8)
    private final AppContentAnnotationEntity zzfs;
    @Field(getter = "getOverflowText", mo15151id = 9)
    private final String zzft;

    @Constructor
    AppContentActionEntity(@Param(mo15154id = 1) ArrayList<AppContentConditionEntity> arrayList, @Param(mo15154id = 2) String str, @Param(mo15154id = 3) Bundle bundle, @Param(mo15154id = 6) String str2, @Param(mo15154id = 7) String str3, @Param(mo15154id = 8) AppContentAnnotationEntity appContentAnnotationEntity, @Param(mo15154id = 9) String str4) {
        this.zzfs = appContentAnnotationEntity;
        this.zzfp = arrayList;
        this.zzfq = str;
        this.extras = bundle;
        this.zzfr = str3;
        this.zzft = str4;
        this.type = str2;
    }

    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    public final boolean isDataValid() {
        return true;
    }

    public final zzc zzy() {
        return this.zzfs;
    }

    public final List<zzg> zzz() {
        return new ArrayList(this.zzfp);
    }

    public final String zzaa() {
        return this.zzfq;
    }

    public final Bundle getExtras() {
        return this.extras;
    }

    public final String getId() {
        return this.zzfr;
    }

    public final String zzab() {
        return this.zzft;
    }

    public final String getType() {
        return this.type;
    }

    public final int hashCode() {
        return Objects.hashCode(zzy(), zzz(), zzaa(), Integer.valueOf(zzc.zza(getExtras())), getId(), zzab(), getType());
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zza) {
            if (this == obj) {
                return true;
            }
            zza zza = (zza) obj;
            if (Objects.equal(zza.zzy(), zzy()) && Objects.equal(zza.zzz(), zzz()) && Objects.equal(zza.zzaa(), zzaa()) && zzc.zza(zza.getExtras(), getExtras()) && Objects.equal(zza.getId(), getId()) && Objects.equal(zza.zzab(), zzab()) && Objects.equal(zza.getType(), getType())) {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("Annotation", zzy()).add("Conditions", zzz()).add("ContentDescription", zzaa()).add("Extras", getExtras()).add("Id", getId()).add("OverflowText", zzab()).add("Type", getType()).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, zzz(), false);
        SafeParcelWriter.writeString(parcel, 2, this.zzfq, false);
        SafeParcelWriter.writeBundle(parcel, 3, this.extras, false);
        SafeParcelWriter.writeString(parcel, 6, this.type, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzfr, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzfs, i, false);
        SafeParcelWriter.writeString(parcel, 9, this.zzft, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
