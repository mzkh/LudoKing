package com.google.android.gms.location;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

@Class(creator = "ActivityTransitionRequestCreator")
@Reserved({1000})
public class ActivityTransitionRequest extends AbstractSafeParcelable {
    public static final Creator<ActivityTransitionRequest> CREATOR = new zzf();
    public static final Comparator<ActivityTransition> IS_SAME_TRANSITION = new zze();
    @Field(getter = "getTag", mo15151id = 2)
    @Nullable
    private final String tag;
    @Field(getter = "getActivityTransitions", mo15151id = 1)
    private final List<ActivityTransition> zzl;
    @Field(getter = "getClients", mo15151id = 3)
    private final List<ClientIdentity> zzm;

    public ActivityTransitionRequest(List<ActivityTransition> list) {
        this(list, null, null);
    }

    @Constructor
    public ActivityTransitionRequest(@Param(mo15154id = 1) List<ActivityTransition> list, @Param(mo15154id = 2) @Nullable String str, @Param(mo15154id = 3) @Nullable List<ClientIdentity> list2) {
        Preconditions.checkNotNull(list, "transitions can't be null");
        Preconditions.checkArgument(list.size() > 0, "transitions can't be empty.");
        TreeSet treeSet = new TreeSet(IS_SAME_TRANSITION);
        for (ActivityTransition activityTransition : list) {
            Preconditions.checkArgument(treeSet.add(activityTransition), String.format("Found duplicated transition: %s.", new Object[]{activityTransition}));
        }
        this.zzl = Collections.unmodifiableList(list);
        this.tag = str;
        this.zzm = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ActivityTransitionRequest activityTransitionRequest = (ActivityTransitionRequest) obj;
            return Objects.equal(this.zzl, activityTransitionRequest.zzl) && Objects.equal(this.tag, activityTransitionRequest.tag) && Objects.equal(this.zzm, activityTransitionRequest.zzm);
        }
    }

    public int hashCode() {
        int hashCode = this.zzl.hashCode() * 31;
        String str = this.tag;
        int i = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        List<ClientIdentity> list = this.zzm;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode2 + i;
    }

    public void serializeToIntentExtra(Intent intent) {
        SafeParcelableSerializer.serializeToIntentExtra(this, intent, "com.google.android.location.internal.EXTRA_ACTIVITY_TRANSITION_REQUEST");
    }

    public String toString() {
        String valueOf = String.valueOf(this.zzl);
        String str = this.tag;
        String valueOf2 = String.valueOf(this.zzm);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 61 + String.valueOf(str).length() + String.valueOf(valueOf2).length());
        sb.append("ActivityTransitionRequest [mTransitions=");
        sb.append(valueOf);
        sb.append(", mTag='");
        sb.append(str);
        sb.append('\'');
        sb.append(", mClients=");
        sb.append(valueOf2);
        sb.append(']');
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, this.zzl, false);
        SafeParcelWriter.writeString(parcel, 2, this.tag, false);
        SafeParcelWriter.writeTypedList(parcel, 3, this.zzm, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
