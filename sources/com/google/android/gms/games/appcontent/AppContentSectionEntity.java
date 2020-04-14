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
@Class(creator = "AppContentSectionEntityCreator")
@Reserved({1000})
public final class AppContentSectionEntity extends zzd implements zzi {
    public static final Creator<AppContentSectionEntity> CREATOR = new zzj();
    @Field(getter = "getExtras", mo15151id = 5)
    private final Bundle extras;
    @Field(getter = "getType", mo15151id = 8)
    private final String type;
    @Field(getter = "getTitle", mo15151id = 7)
    private final String zzcd;
    @Field(getter = "getContentDescription", mo15151id = 4)
    private final String zzfq;
    @Field(getter = "getId", mo15151id = 9)
    private final String zzfr;
    @Field(getter = "getActions", mo15151id = 1)
    private final ArrayList<AppContentActionEntity> zzga;
    @Field(getter = "getAnnotations", mo15151id = 14)
    private final ArrayList<AppContentAnnotationEntity> zzgb;
    @Field(getter = "getSubtitle", mo15151id = 6)
    private final String zzgd;
    @Field(getter = "getCards", mo15151id = 3)
    private final ArrayList<AppContentCardEntity> zzgj;
    @Field(getter = "getCardType", mo15151id = 10)
    private final String zzgk;

    @Constructor
    AppContentSectionEntity(@Param(mo15154id = 1) ArrayList<AppContentActionEntity> arrayList, @Param(mo15154id = 3) ArrayList<AppContentCardEntity> arrayList2, @Param(mo15154id = 4) String str, @Param(mo15154id = 5) Bundle bundle, @Param(mo15154id = 6) String str2, @Param(mo15154id = 7) String str3, @Param(mo15154id = 8) String str4, @Param(mo15154id = 9) String str5, @Param(mo15154id = 10) String str6, @Param(mo15154id = 14) ArrayList<AppContentAnnotationEntity> arrayList3) {
        this.zzga = arrayList;
        this.zzgb = arrayList3;
        this.zzgj = arrayList2;
        this.zzgk = str6;
        this.zzfq = str;
        this.extras = bundle;
        this.zzfr = str5;
        this.zzgd = str2;
        this.zzcd = str3;
        this.type = str4;
    }

    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    public final boolean isDataValid() {
        return true;
    }

    public final List<zza> getActions() {
        return new ArrayList(this.zzga);
    }

    public final List<zzc> zzai() {
        return new ArrayList(this.zzgb);
    }

    public final List<zze> zzaq() {
        return new ArrayList(this.zzgj);
    }

    public final String zzar() {
        return this.zzgk;
    }

    public final String zzaa() {
        return this.zzfq;
    }

    public final Bundle getExtras() {
        return this.extras;
    }

    public final String zzak() {
        return this.zzgd;
    }

    public final String getId() {
        return this.zzfr;
    }

    public final String getTitle() {
        return this.zzcd;
    }

    public final String getType() {
        return this.type;
    }

    public final int hashCode() {
        return Objects.hashCode(getActions(), zzai(), zzaq(), zzar(), zzaa(), Integer.valueOf(zzc.zza(getExtras())), getId(), zzak(), getTitle(), getType());
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzi) {
            if (this == obj) {
                return true;
            }
            zzi zzi = (zzi) obj;
            if (Objects.equal(zzi.getActions(), getActions()) && Objects.equal(zzi.zzai(), zzai()) && Objects.equal(zzi.zzaq(), zzaq()) && Objects.equal(zzi.zzar(), zzar()) && Objects.equal(zzi.zzaa(), zzaa()) && zzc.zza(zzi.getExtras(), getExtras()) && Objects.equal(zzi.getId(), getId()) && Objects.equal(zzi.zzak(), zzak()) && Objects.equal(zzi.getTitle(), getTitle()) && Objects.equal(zzi.getType(), getType())) {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("Actions", getActions()).add("Annotations", zzai()).add("Cards", zzaq()).add("CardType", zzar()).add("ContentDescription", zzaa()).add("Extras", getExtras()).add("Id", getId()).add("Subtitle", zzak()).add("Title", getTitle()).add("Type", getType()).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, getActions(), false);
        SafeParcelWriter.writeTypedList(parcel, 3, zzaq(), false);
        SafeParcelWriter.writeString(parcel, 4, this.zzfq, false);
        SafeParcelWriter.writeBundle(parcel, 5, this.extras, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzgd, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzcd, false);
        SafeParcelWriter.writeString(parcel, 8, this.type, false);
        SafeParcelWriter.writeString(parcel, 9, this.zzfr, false);
        SafeParcelWriter.writeString(parcel, 10, this.zzgk, false);
        SafeParcelWriter.writeTypedList(parcel, 14, zzai(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
