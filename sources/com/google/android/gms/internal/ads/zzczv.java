package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.internal.ads.zzbo.zza;

@Class(creator = "GassResponseParcelCreator")
/* compiled from: com.google.android.gms:play-services-gass@@18.2.0 */
public final class zzczv extends AbstractSafeParcelable {
    public static final Creator<zzczv> CREATOR = new zzczu();
    @VersionField(mo15157id = 1)
    private final int versionCode;
    @Field(getter = "getAfmaSignalsAsBytes", mo15151id = 2, type = "byte[]")
    private zza zzgog = null;
    private byte[] zzgoh;

    @Constructor
    zzczv(@Param(mo15154id = 1) int i, @Param(mo15154id = 2) byte[] bArr) {
        this.versionCode = i;
        this.zzgoh = bArr;
        zzaod();
    }

    public final zza zzaoc() {
        if (!(this.zzgog != null)) {
            try {
                this.zzgog = zza.zzb(this.zzgoh, zzdqj.zzazb());
                this.zzgoh = null;
            } catch (zzdrg e) {
                throw new IllegalStateException(e);
            }
        }
        zzaod();
        return this.zzgog;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        byte[] bArr = this.zzgoh;
        if (bArr == null) {
            bArr = this.zzgog.toByteArray();
        }
        SafeParcelWriter.writeByteArray(parcel, 2, bArr, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    private final void zzaod() {
        if (this.zzgog == null && this.zzgoh != null) {
            return;
        }
        if (this.zzgog != null && this.zzgoh == null) {
            return;
        }
        if (this.zzgog != null && this.zzgoh != null) {
            throw new IllegalStateException("Invalid internal representation - full");
        } else if (this.zzgog == null && this.zzgoh == null) {
            throw new IllegalStateException("Invalid internal representation - empty");
        } else {
            throw new IllegalStateException("Impossible");
        }
    }
}
