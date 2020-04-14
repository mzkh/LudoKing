package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@Class(creator = "SignInConfigurationCreator")
@Reserved({1})
public final class SignInConfiguration extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Creator<SignInConfiguration> CREATOR = new zzx();
    @Field(getter = "getConsumerPkgName", mo15151id = 2)
    private final String zzbr;
    @Field(getter = "getGoogleConfig", mo15151id = 5)
    private GoogleSignInOptions zzbs;

    @Constructor
    public SignInConfiguration(@Param(mo15154id = 2) String str, @Param(mo15154id = 5) GoogleSignInOptions googleSignInOptions) {
        this.zzbr = Preconditions.checkNotEmpty(str);
        this.zzbs = googleSignInOptions;
    }

    public final GoogleSignInOptions zzm() {
        return this.zzbs;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzbr, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzbs, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof SignInConfiguration)) {
            return false;
        }
        SignInConfiguration signInConfiguration = (SignInConfiguration) obj;
        if (this.zzbr.equals(signInConfiguration.zzbr)) {
            GoogleSignInOptions googleSignInOptions = this.zzbs;
            if (googleSignInOptions != null ? googleSignInOptions.equals(signInConfiguration.zzbs) : signInConfiguration.zzbs == null) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return new HashAccumulator().addObject(this.zzbr).addObject(this.zzbs).hash();
    }
}
