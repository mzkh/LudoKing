package com.google.android.gms.games.snapshot;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.games.internal.zzd;

@UsedByReflection("GamesClientImpl.java")
@Class(creator = "SnapshotMetadataChangeCreator")
@Reserved({1000})
public final class SnapshotMetadataChangeEntity extends zzd implements SnapshotMetadataChange {
    public static final Creator<SnapshotMetadataChangeEntity> CREATOR = new zzc();
    @Field(getter = "getDescription", mo15151id = 1)
    private final String description;
    @Field(getter = "getProgressValue", mo15151id = 6)
    private final Long zzru;
    @Field(getter = "getCoverImageUri", mo15151id = 4)
    private final Uri zzrw;
    @Field(getter = "getPlayedTimeMillis", mo15151id = 2)
    private final Long zzrx;
    @Field(getter = "getCoverImageTeleporter", mo15151id = 5)
    private BitmapTeleporter zzry;

    SnapshotMetadataChangeEntity() {
        this(null, null, null, null, null);
    }

    @Constructor
    SnapshotMetadataChangeEntity(@Param(mo15154id = 1) String str, @Param(mo15154id = 2) Long l, @Param(mo15154id = 5) BitmapTeleporter bitmapTeleporter, @Param(mo15154id = 4) Uri uri, @Param(mo15154id = 6) Long l2) {
        this.description = str;
        this.zzrx = l;
        this.zzry = bitmapTeleporter;
        this.zzrw = uri;
        this.zzru = l2;
        BitmapTeleporter bitmapTeleporter2 = this.zzry;
        String str2 = "Cannot set both a URI and an image";
        boolean z = true;
        if (bitmapTeleporter2 != null) {
            if (this.zzrw != null) {
                z = false;
            }
            Preconditions.checkState(z, str2);
            return;
        }
        if (this.zzrw != null) {
            if (bitmapTeleporter2 != null) {
                z = false;
            }
            Preconditions.checkState(z, str2);
        }
    }

    public final String getDescription() {
        return this.description;
    }

    public final Long getPlayedTimeMillis() {
        return this.zzrx;
    }

    public final Long getProgressValue() {
        return this.zzru;
    }

    public final BitmapTeleporter zzdt() {
        return this.zzry;
    }

    public final Bitmap getCoverImage() {
        BitmapTeleporter bitmapTeleporter = this.zzry;
        if (bitmapTeleporter == null) {
            return null;
        }
        return bitmapTeleporter.get();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getDescription(), false);
        SafeParcelWriter.writeLongObject(parcel, 2, getPlayedTimeMillis(), false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzrw, i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzry, i, false);
        SafeParcelWriter.writeLongObject(parcel, 6, getProgressValue(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
