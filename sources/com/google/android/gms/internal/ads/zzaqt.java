package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import org.json.JSONArray;
import org.json.JSONException;

@Class(creator = "RewardItemParcelCreator")
@Reserved({1})
/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzaqt extends AbstractSafeParcelable {
    public static final Creator<zzaqt> CREATOR = new zzaqw();
    @Field(mo15151id = 2)
    public final String type;
    @Field(mo15151id = 3)
    public final int zzdnv;

    public zzaqt(RewardItem rewardItem) {
        this(rewardItem.getType(), rewardItem.getAmount());
    }

    @Constructor
    public zzaqt(@Param(mo15154id = 2) String str, @Param(mo15154id = 3) int i) {
        this.type = str;
        this.zzdnv = i;
    }

    @Nullable
    public static zzaqt zza(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        return new zzaqt(jSONArray.getJSONObject(0).optString("rb_type"), jSONArray.getJSONObject(0).optInt("rb_amount"));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.type, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzdnv);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zzaqt)) {
            zzaqt zzaqt = (zzaqt) obj;
            if (Objects.equal(this.type, zzaqt.type) && Objects.equal(Integer.valueOf(this.zzdnv), Integer.valueOf(zzaqt.zzdnv))) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.type, Integer.valueOf(this.zzdnv));
    }
}
