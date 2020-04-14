package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@Class(creator = "NonagonRequestParcelCreator")
@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzape extends AbstractSafeParcelable {
    public static final Creator<zzape> CREATOR = new zzapd();
    @Field(mo15151id = 3)
    public final ApplicationInfo applicationInfo;
    @Field(mo15151id = 4)
    public final String packageName;
    @Field(mo15151id = 2)
    public final zzaxl zzdio;
    @Field(mo15151id = 6)
    @Nullable
    public final PackageInfo zzdiv;
    @Field(mo15151id = 5)
    public final List<String> zzdjf;
    @Field(mo15151id = 7)
    public final String zzdjp;
    @Field(mo15151id = 1)
    public final Bundle zzdma;
    @Field(mo15151id = 8)
    public final boolean zzdmb;
    @Field(mo15151id = 9)
    public final String zzdmc;

    @Constructor
    public zzape(@Param(mo15154id = 1) Bundle bundle, @Param(mo15154id = 2) zzaxl zzaxl, @Param(mo15154id = 3) ApplicationInfo applicationInfo2, @Param(mo15154id = 4) String str, @Param(mo15154id = 5) List<String> list, @Param(mo15154id = 6) @Nullable PackageInfo packageInfo, @Param(mo15154id = 7) String str2, @Param(mo15154id = 8) boolean z, @Param(mo15154id = 9) String str3) {
        this.zzdma = bundle;
        this.zzdio = zzaxl;
        this.packageName = str;
        this.applicationInfo = applicationInfo2;
        this.zzdjf = list;
        this.zzdiv = packageInfo;
        this.zzdjp = str2;
        this.zzdmb = z;
        this.zzdmc = str3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 1, this.zzdma, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzdio, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.applicationInfo, i, false);
        SafeParcelWriter.writeString(parcel, 4, this.packageName, false);
        SafeParcelWriter.writeStringList(parcel, 5, this.zzdjf, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzdiv, i, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzdjp, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzdmb);
        SafeParcelWriter.writeString(parcel, 9, this.zzdmc, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
