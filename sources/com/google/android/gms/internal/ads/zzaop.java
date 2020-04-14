package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@Class(creator = "AutoClickProtectionConfigurationParcelCreator")
@Reserved({1})
@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzaop extends AbstractSafeParcelable {
    public static final Creator<zzaop> CREATOR = new zzaos();
    @Field(mo15151id = 2)
    public final boolean zzdlt;
    @Field(mo15151id = 3)
    @Nullable
    public final List<String> zzdlu;

    public zzaop() {
        this(false, Collections.emptyList());
    }

    @Constructor
    public zzaop(@Param(mo15154id = 2) boolean z, @Param(mo15154id = 3) List<String> list) {
        this.zzdlt = z;
        this.zzdlu = list;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzdlt);
        SafeParcelWriter.writeStringList(parcel, 3, this.zzdlu, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
