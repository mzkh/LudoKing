package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@Class(creator = "AdLauncherIntentInfoCreator")
@Reserved({1})
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzd extends AbstractSafeParcelable {
    public static final Creator<zzd> CREATOR = new zza();
    @Field(mo15151id = 9)
    public final Intent intent;
    @Field(mo15151id = 4)
    public final String mimeType;
    @Field(mo15151id = 5)
    public final String packageName;
    @Field(mo15151id = 3)
    public final String url;
    @Field(mo15151id = 2)
    private final String zzdhm;
    @Field(mo15151id = 6)
    public final String zzdhn;
    @Field(mo15151id = 7)
    public final String zzdho;
    @Field(mo15151id = 8)
    private final String zzdhp;

    public zzd(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this(str, str2, str3, str4, str5, str6, str7, null);
    }

    public zzd(Intent intent2) {
        this(null, null, null, null, null, null, null, intent2);
    }

    @Constructor
    public zzd(@Param(mo15154id = 2) String str, @Param(mo15154id = 3) String str2, @Param(mo15154id = 4) String str3, @Param(mo15154id = 5) String str4, @Param(mo15154id = 6) String str5, @Param(mo15154id = 7) String str6, @Param(mo15154id = 8) String str7, @Param(mo15154id = 9) Intent intent2) {
        this.zzdhm = str;
        this.url = str2;
        this.mimeType = str3;
        this.packageName = str4;
        this.zzdhn = str5;
        this.zzdho = str6;
        this.zzdhp = str7;
        this.intent = intent2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzdhm, false);
        SafeParcelWriter.writeString(parcel, 3, this.url, false);
        SafeParcelWriter.writeString(parcel, 4, this.mimeType, false);
        SafeParcelWriter.writeString(parcel, 5, this.packageName, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzdhn, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzdho, false);
        SafeParcelWriter.writeString(parcel, 8, this.zzdhp, false);
        SafeParcelWriter.writeParcelable(parcel, 9, this.intent, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
