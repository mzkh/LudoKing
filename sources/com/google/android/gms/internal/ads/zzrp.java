package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import java.util.List;

@Class(creator = "CacheOfferingCreator")
@Reserved({1})
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzrp extends AbstractSafeParcelable {
    public static final Creator<zzrp> CREATOR = new zzrs();
    @Field(mo15151id = 2)
    @Nullable
    public final String url;
    @Field(mo15151id = 3)
    private final long zzbri;
    @Field(mo15151id = 4)
    private final String zzbrj;
    @Field(mo15151id = 5)
    private final String zzbrk;
    @Field(mo15151id = 6)
    private final String zzbrl;
    @Field(mo15151id = 7)
    private final Bundle zzbrm;
    @Field(mo15151id = 8)
    public final boolean zzbrn;
    @Field(mo15151id = 9)
    public long zzbro;

    @Nullable
    public static zzrp zzbt(String str) {
        return zze(Uri.parse(str));
    }

    @Nullable
    public static zzrp zze(Uri uri) {
        long j;
        try {
            if (!"gcache".equals(uri.getScheme())) {
                return null;
            }
            List pathSegments = uri.getPathSegments();
            if (pathSegments.size() != 2) {
                int size = pathSegments.size();
                StringBuilder sb = new StringBuilder(62);
                sb.append("Expected 2 path parts for namespace and id, found :");
                sb.append(size);
                zzaug.zzeu(sb.toString());
                return null;
            }
            String str = (String) pathSegments.get(0);
            String str2 = (String) pathSegments.get(1);
            String host = uri.getHost();
            String queryParameter = uri.getQueryParameter("url");
            boolean equals = "1".equals(uri.getQueryParameter("read_only"));
            String queryParameter2 = uri.getQueryParameter("expiration");
            if (queryParameter2 == null) {
                j = 0;
            } else {
                j = Long.parseLong(queryParameter2);
            }
            long j2 = j;
            Bundle bundle = new Bundle();
            zzq.zzkl();
            for (String str3 : uri.getQueryParameterNames()) {
                if (str3.startsWith("tag.")) {
                    bundle.putString(str3.substring(4), uri.getQueryParameter(str3));
                }
            }
            zzrp zzrp = new zzrp(queryParameter, j2, host, str, str2, bundle, equals, 0);
            return zzrp;
        } catch (NullPointerException | NumberFormatException e) {
            zzaug.zzd("Unable to parse Uri into cache offering.", e);
            return null;
        }
    }

    @Constructor
    zzrp(@Param(mo15154id = 2) @Nullable String str, @Param(mo15154id = 3) long j, @Param(mo15154id = 4) String str2, @Param(mo15154id = 5) String str3, @Param(mo15154id = 6) String str4, @Param(mo15154id = 7) Bundle bundle, @Param(mo15154id = 8) boolean z, @Param(mo15154id = 9) long j2) {
        this.url = str;
        this.zzbri = j;
        String str5 = "";
        if (str2 == null) {
            str2 = str5;
        }
        this.zzbrj = str2;
        if (str3 == null) {
            str3 = str5;
        }
        this.zzbrk = str3;
        if (str4 != null) {
            str5 = str4;
        }
        this.zzbrl = str5;
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.zzbrm = bundle;
        this.zzbrn = z;
        this.zzbro = j2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.url, false);
        SafeParcelWriter.writeLong(parcel, 3, this.zzbri);
        SafeParcelWriter.writeString(parcel, 4, this.zzbrj, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzbrk, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzbrl, false);
        SafeParcelWriter.writeBundle(parcel, 7, this.zzbrm, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzbrn);
        SafeParcelWriter.writeLong(parcel, 9, this.zzbro);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
