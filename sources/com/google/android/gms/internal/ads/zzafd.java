package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import java.util.Map;
import java.util.Map.Entry;

@Class(creator = "HttpRequestParcelCreator")
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzafd extends AbstractSafeParcelable {
    public static final Creator<zzafd> CREATOR = new zzafc();
    @Field(mo15151id = 1)
    private final String url;
    @Field(mo15151id = 2)
    private final String[] zzcyg;
    @Field(mo15151id = 3)
    private final String[] zzcyh;

    @Constructor
    zzafd(@Param(mo15154id = 1) String str, @Param(mo15154id = 2) String[] strArr, @Param(mo15154id = 3) String[] strArr2) {
        this.url = str;
        this.zzcyg = strArr;
        this.zzcyh = strArr2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.url, false);
        SafeParcelWriter.writeStringArray(parcel, 2, this.zzcyg, false);
        SafeParcelWriter.writeStringArray(parcel, 3, this.zzcyh, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public static zzafd zzh(zzq<?> zzq) throws zzb {
        Map headers = zzq.getHeaders();
        int size = headers.size();
        String[] strArr = new String[size];
        String[] strArr2 = new String[size];
        int i = 0;
        for (Entry entry : headers.entrySet()) {
            strArr[i] = (String) entry.getKey();
            strArr2[i] = (String) entry.getValue();
            i++;
        }
        return new zzafd(zzq.getUrl(), strArr, strArr2);
    }
}
