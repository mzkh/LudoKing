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
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@Class(creator = "SafeBrowsingConfigParcelCreator")
@Reserved({1})
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzasd extends AbstractSafeParcelable {
    public static final Creator<zzasd> CREATOR = new zzasg();
    @Field(mo15151id = 2)
    public final String zzdow;
    @Field(mo15151id = 3)
    public final String zzdox;
    @Field(mo15151id = 4)
    public final boolean zzdoy;
    @Field(mo15151id = 5)
    public final boolean zzdoz;
    @Field(mo15151id = 6)
    public final List<String> zzdpa;
    @Field(mo15151id = 7)
    public final boolean zzdpb;
    @Field(mo15151id = 8)
    public final boolean zzdpc;
    @Field(mo15151id = 9)
    public final List<String> zzdpd;

    @Constructor
    public zzasd(@Param(mo15154id = 2) String str, @Param(mo15154id = 3) String str2, @Param(mo15154id = 4) boolean z, @Param(mo15154id = 5) boolean z2, @Param(mo15154id = 6) List<String> list, @Param(mo15154id = 7) boolean z3, @Param(mo15154id = 8) boolean z4, @Param(mo15154id = 9) List<String> list2) {
        this.zzdow = str;
        this.zzdox = str2;
        this.zzdoy = z;
        this.zzdoz = z2;
        this.zzdpa = list;
        this.zzdpb = z3;
        this.zzdpc = z4;
        if (list2 == null) {
            list2 = new ArrayList<>();
        }
        this.zzdpd = list2;
    }

    @Nullable
    public static zzasd zzg(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        String str = "";
        zzasd zzasd = new zzasd(jSONObject.optString("click_string", str), jSONObject.optString("report_url", str), jSONObject.optBoolean("rendered_ad_enabled", false), jSONObject.optBoolean("non_malicious_reporting_enabled", false), zzawg.zza(jSONObject.optJSONArray("allowed_headers"), null), jSONObject.optBoolean("protection_enabled", false), jSONObject.optBoolean("malicious_reporting_enabled", false), zzawg.zza(jSONObject.optJSONArray("webview_permissions"), null));
        return zzasd;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzdow, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzdox, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzdoy);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzdoz);
        SafeParcelWriter.writeStringList(parcel, 6, this.zzdpa, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzdpb);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzdpc);
        SafeParcelWriter.writeStringList(parcel, 9, this.zzdpd, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
