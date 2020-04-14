package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import java.util.Locale;

@Class(creator = "ClientAppContextCreator")
public final class ClientAppContext extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Creator<ClientAppContext> CREATOR = new zzd();
    @VersionField(mo15157id = 1)
    private final int versionCode;
    @Field(mo15151id = 4)
    private final boolean zzfg;
    @Field(mo15151id = 6)
    private final String zzfi;
    @Field(mo15151id = 2)
    private final String zzfj;
    @Field(mo15151id = 3)
    @Nullable
    private final String zzhe;
    @Field(mo15151id = 5)
    @Deprecated
    public final int zzhf;

    @Constructor
    ClientAppContext(@Param(mo15154id = 1) int i, @Param(mo15154id = 2) String str, @Param(mo15154id = 3) @Nullable String str2, @Param(mo15154id = 4) boolean z, @Param(mo15154id = 5) int i2, @Param(mo15154id = 6) @Nullable String str3) {
        this.versionCode = i;
        this.zzfj = (String) Preconditions.checkNotNull(str);
        if (str2 != null && !str2.isEmpty()) {
            String str4 = "0p:";
            if (!str2.startsWith(str4)) {
                Log.w("NearbyMessages", String.format(Locale.US, "ClientAppContext: 0P identifier(%s) without 0P prefix(%s)", new Object[]{str2, str4}));
                String valueOf = String.valueOf(str2);
                str2 = valueOf.length() != 0 ? str4.concat(valueOf) : new String(str4);
            }
        }
        this.zzhe = str2;
        this.zzfg = z;
        this.zzhf = i2;
        this.zzfi = str3;
    }

    public ClientAppContext(String str, @Nullable String str2, boolean z, @Nullable String str3, int i) {
        this(1, str, str2, z, i, str3);
    }

    @Nullable
    static final ClientAppContext zza(@Nullable ClientAppContext clientAppContext, @Nullable String str, @Nullable String str2, boolean z) {
        if (clientAppContext != null) {
            return clientAppContext;
        }
        if (str == null && str2 == null) {
            return null;
        }
        ClientAppContext clientAppContext2 = new ClientAppContext(str, str2, z, null, 0);
        return clientAppContext2;
    }

    private static boolean zzc(String str, String str2) {
        return TextUtils.isEmpty(str) ? TextUtils.isEmpty(str2) : str.equals(str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClientAppContext)) {
            return false;
        }
        ClientAppContext clientAppContext = (ClientAppContext) obj;
        return zzc(this.zzfj, clientAppContext.zzfj) && zzc(this.zzhe, clientAppContext.zzhe) && this.zzfg == clientAppContext.zzfg && zzc(this.zzfi, clientAppContext.zzfi) && this.zzhf == clientAppContext.zzhf;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzfj, this.zzhe, Boolean.valueOf(this.zzfg), this.zzfi, Integer.valueOf(this.zzhf));
    }

    public final String toString() {
        return String.format(Locale.US, "{realClientPackageName: %s, zeroPartyIdentifier: %s, useRealClientApiKey: %b, apiKey: %s, callingContext: %d}", new Object[]{this.zzfj, this.zzhe, Boolean.valueOf(this.zzfg), this.zzfi, Integer.valueOf(this.zzhf)});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeString(parcel, 2, this.zzfj, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzhe, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzfg);
        SafeParcelWriter.writeInt(parcel, 5, this.zzhf);
        SafeParcelWriter.writeString(parcel, 6, this.zzfi, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
