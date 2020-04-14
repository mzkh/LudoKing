package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import java.io.InputStream;
import javax.annotation.concurrent.GuardedBy;

@Class(creator = "CacheEntryParcelCreator")
@Reserved({1})
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzro extends AbstractSafeParcelable {
    public static final Creator<zzro> CREATOR = new zzrn();
    @GuardedBy("this")
    @Field(getter = "getContentFileDescriptor", mo15151id = 2)
    @Nullable
    private ParcelFileDescriptor zzbrh;

    public zzro() {
        this(null);
    }

    @Constructor
    public zzro(@Param(mo15154id = 2) @Nullable ParcelFileDescriptor parcelFileDescriptor) {
        this.zzbrh = parcelFileDescriptor;
    }

    public final synchronized boolean zzmi() {
        return this.zzbrh != null;
    }

    @Nullable
    public final synchronized InputStream zzmj() {
        if (this.zzbrh == null) {
            return null;
        }
        AutoCloseInputStream autoCloseInputStream = new AutoCloseInputStream(this.zzbrh);
        this.zzbrh = null;
        return autoCloseInputStream;
    }

    private final synchronized ParcelFileDescriptor zzmk() {
        return this.zzbrh;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, zzmk(), i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
