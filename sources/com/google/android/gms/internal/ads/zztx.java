package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
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
import java.util.List;

@Class(creator = "AdRequestParcelCreator")
/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zztx extends AbstractSafeParcelable {
    public static final Creator<zztx> CREATOR = new zztz();
    @Field(mo15151id = 3)
    public final Bundle extras;
    @Field(mo15151id = 1)
    public final int versionCode;
    @Field(mo15151id = 7)
    public final int zzabj;
    @Field(mo15151id = 20)
    public final int zzabk;
    @Field(mo15151id = 21)
    @Nullable
    public final String zzabl;
    @Field(mo15151id = 8)
    public final boolean zzbkg;
    @Field(mo15151id = 2)
    @Deprecated
    public final long zzcbx;
    @Field(mo15151id = 4)
    @Deprecated
    public final int zzcby;
    @Field(mo15151id = 5)
    public final List<String> zzcbz;
    @Field(mo15151id = 6)
    public final boolean zzcca;
    @Field(mo15151id = 9)
    public final String zzccb;
    @Field(mo15151id = 10)
    public final zzyf zzccc;
    @Field(mo15151id = 12)
    public final String zzccd;
    @Field(mo15151id = 13)
    public final Bundle zzcce;
    @Field(mo15151id = 14)
    public final Bundle zzccf;
    @Field(mo15151id = 15)
    public final List<String> zzccg;
    @Field(mo15151id = 16)
    public final String zzcch;
    @Field(mo15151id = 17)
    public final String zzcci;
    @Field(mo15151id = 18)
    @Deprecated
    public final boolean zzccj;
    @Field(mo15151id = 19)
    @Nullable
    public final zztr zzcck;
    @Field(mo15151id = 11)
    public final Location zzng;

    @Constructor
    public zztx(@Param(mo15154id = 1) int i, @Param(mo15154id = 2) long j, @Param(mo15154id = 3) Bundle bundle, @Param(mo15154id = 4) int i2, @Param(mo15154id = 5) List<String> list, @Param(mo15154id = 6) boolean z, @Param(mo15154id = 7) int i3, @Param(mo15154id = 8) boolean z2, @Param(mo15154id = 9) String str, @Param(mo15154id = 10) zzyf zzyf, @Param(mo15154id = 11) Location location, @Param(mo15154id = 12) String str2, @Param(mo15154id = 13) Bundle bundle2, @Param(mo15154id = 14) Bundle bundle3, @Param(mo15154id = 15) List<String> list2, @Param(mo15154id = 16) String str3, @Param(mo15154id = 17) String str4, @Param(mo15154id = 18) boolean z3, @Param(mo15154id = 19) zztr zztr, @Param(mo15154id = 20) int i4, @Param(mo15154id = 21) @Nullable String str5) {
        this.versionCode = i;
        this.zzcbx = j;
        this.extras = bundle == null ? new Bundle() : bundle;
        this.zzcby = i2;
        this.zzcbz = list;
        this.zzcca = z;
        this.zzabj = i3;
        this.zzbkg = z2;
        this.zzccb = str;
        this.zzccc = zzyf;
        this.zzng = location;
        this.zzccd = str2;
        this.zzcce = bundle2 == null ? new Bundle() : bundle2;
        this.zzccf = bundle3;
        this.zzccg = list2;
        this.zzcch = str3;
        this.zzcci = str4;
        this.zzccj = z3;
        this.zzcck = zztr;
        this.zzabk = i4;
        this.zzabl = str5;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeLong(parcel, 2, this.zzcbx);
        SafeParcelWriter.writeBundle(parcel, 3, this.extras, false);
        SafeParcelWriter.writeInt(parcel, 4, this.zzcby);
        SafeParcelWriter.writeStringList(parcel, 5, this.zzcbz, false);
        SafeParcelWriter.writeBoolean(parcel, 6, this.zzcca);
        SafeParcelWriter.writeInt(parcel, 7, this.zzabj);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzbkg);
        SafeParcelWriter.writeString(parcel, 9, this.zzccb, false);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzccc, i, false);
        SafeParcelWriter.writeParcelable(parcel, 11, this.zzng, i, false);
        SafeParcelWriter.writeString(parcel, 12, this.zzccd, false);
        SafeParcelWriter.writeBundle(parcel, 13, this.zzcce, false);
        SafeParcelWriter.writeBundle(parcel, 14, this.zzccf, false);
        SafeParcelWriter.writeStringList(parcel, 15, this.zzccg, false);
        SafeParcelWriter.writeString(parcel, 16, this.zzcch, false);
        SafeParcelWriter.writeString(parcel, 17, this.zzcci, false);
        SafeParcelWriter.writeBoolean(parcel, 18, this.zzccj);
        SafeParcelWriter.writeParcelable(parcel, 19, this.zzcck, i, false);
        SafeParcelWriter.writeInt(parcel, 20, this.zzabk);
        SafeParcelWriter.writeString(parcel, 21, this.zzabl, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zztx)) {
            return false;
        }
        zztx zztx = (zztx) obj;
        if (this.versionCode != zztx.versionCode || this.zzcbx != zztx.zzcbx || !Objects.equal(this.extras, zztx.extras) || this.zzcby != zztx.zzcby || !Objects.equal(this.zzcbz, zztx.zzcbz) || this.zzcca != zztx.zzcca || this.zzabj != zztx.zzabj || this.zzbkg != zztx.zzbkg || !Objects.equal(this.zzccb, zztx.zzccb) || !Objects.equal(this.zzccc, zztx.zzccc) || !Objects.equal(this.zzng, zztx.zzng) || !Objects.equal(this.zzccd, zztx.zzccd) || !Objects.equal(this.zzcce, zztx.zzcce) || !Objects.equal(this.zzccf, zztx.zzccf) || !Objects.equal(this.zzccg, zztx.zzccg) || !Objects.equal(this.zzcch, zztx.zzcch) || !Objects.equal(this.zzcci, zztx.zzcci) || this.zzccj != zztx.zzccj || this.zzabk != zztx.zzabk || !Objects.equal(this.zzabl, zztx.zzabl)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.versionCode), Long.valueOf(this.zzcbx), this.extras, Integer.valueOf(this.zzcby), this.zzcbz, Boolean.valueOf(this.zzcca), Integer.valueOf(this.zzabj), Boolean.valueOf(this.zzbkg), this.zzccb, this.zzccc, this.zzng, this.zzccd, this.zzcce, this.zzccf, this.zzccg, this.zzcch, this.zzcci, Boolean.valueOf(this.zzccj), Integer.valueOf(this.zzabk), this.zzabl);
    }
}
