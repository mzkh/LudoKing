package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Class(creator = "ActivityTransitionCreator")
@Reserved({1000})
public class ActivityTransition extends AbstractSafeParcelable {
    public static final int ACTIVITY_TRANSITION_ENTER = 0;
    public static final int ACTIVITY_TRANSITION_EXIT = 1;
    public static final Creator<ActivityTransition> CREATOR = new zzc();
    @Field(getter = "getActivityType", mo15151id = 1)
    private final int zzi;
    @Field(getter = "getTransitionType", mo15151id = 2)
    private final int zzj;

    @Retention(RetentionPolicy.SOURCE)
    public @interface SupportedActivityTransition {
    }

    public static class Builder {
        private int zzi = -1;
        private int zzj = -1;

        public ActivityTransition build() {
            boolean z = true;
            Preconditions.checkState(this.zzi != -1, "Activity type not set.");
            if (this.zzj == -1) {
                z = false;
            }
            Preconditions.checkState(z, "Activity transition type not set.");
            return new ActivityTransition(this.zzi, this.zzj);
        }

        public Builder setActivityTransition(int i) {
            ActivityTransition.zza(i);
            this.zzj = i;
            return this;
        }

        public Builder setActivityType(int i) {
            DetectedActivity.zzb(i);
            this.zzi = i;
            return this;
        }
    }

    @Constructor
    ActivityTransition(@Param(mo15154id = 1) int i, @Param(mo15154id = 2) int i2) {
        this.zzi = i;
        this.zzj = i2;
    }

    public static void zza(int i) {
        boolean z = true;
        if (i < 0 || i > 1) {
            z = false;
        }
        StringBuilder sb = new StringBuilder(41);
        sb.append("Transition type ");
        sb.append(i);
        sb.append(" is not valid.");
        Preconditions.checkArgument(z, sb.toString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityTransition)) {
            return false;
        }
        ActivityTransition activityTransition = (ActivityTransition) obj;
        return this.zzi == activityTransition.zzi && this.zzj == activityTransition.zzj;
    }

    public int getActivityType() {
        return this.zzi;
    }

    public int getTransitionType() {
        return this.zzj;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zzi), Integer.valueOf(this.zzj));
    }

    public String toString() {
        int i = this.zzi;
        int i2 = this.zzj;
        StringBuilder sb = new StringBuilder(75);
        sb.append("ActivityTransition [mActivityType=");
        sb.append(i);
        sb.append(", mTransitionType=");
        sb.append(i2);
        sb.append(']');
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getActivityType());
        SafeParcelWriter.writeInt(parcel, 2, getTransitionType());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
