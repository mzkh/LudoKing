package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@Class(creator = "NativeAdOptionsParcelCreator")
/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzaay extends AbstractSafeParcelable {
    public static final Creator<zzaay> CREATOR = new zzabb();
    @Field(mo15151id = 1)
    public final int versionCode;
    @Field(mo15151id = 3)
    public final int zzbjv;
    @Field(mo15151id = 8)
    public final int zzbjw;
    @Field(mo15151id = 4)
    public final boolean zzbjx;
    @Field(mo15151id = 5)
    public final int zzbjy;
    @Field(mo15151id = 7)
    public final boolean zzbka;
    @Field(mo15151id = 2)
    public final boolean zzcvz;
    @Field(mo15151id = 6)
    @Nullable
    public final zzyj zzcwa;

    public zzaay(NativeAdOptions nativeAdOptions) {
        boolean shouldReturnUrlsForImageAssets = nativeAdOptions.shouldReturnUrlsForImageAssets();
        int imageOrientation = nativeAdOptions.getImageOrientation();
        boolean shouldRequestMultipleImages = nativeAdOptions.shouldRequestMultipleImages();
        int adChoicesPlacement = nativeAdOptions.getAdChoicesPlacement();
        zzyj zzyj = nativeAdOptions.getVideoOptions() != null ? new zzyj(nativeAdOptions.getVideoOptions()) : null;
        this(4, shouldReturnUrlsForImageAssets, imageOrientation, shouldRequestMultipleImages, adChoicesPlacement, zzyj, nativeAdOptions.zzje(), nativeAdOptions.getMediaAspectRatio());
    }

    @Constructor
    public zzaay(@Param(mo15154id = 1) int i, @Param(mo15154id = 2) boolean z, @Param(mo15154id = 3) int i2, @Param(mo15154id = 4) boolean z2, @Param(mo15154id = 5) int i3, @Param(mo15154id = 6) zzyj zzyj, @Param(mo15154id = 7) boolean z3, @Param(mo15154id = 8) int i4) {
        this.versionCode = i;
        this.zzcvz = z;
        this.zzbjv = i2;
        this.zzbjx = z2;
        this.zzbjy = i3;
        this.zzcwa = zzyj;
        this.zzbka = z3;
        this.zzbjw = i4;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzcvz);
        SafeParcelWriter.writeInt(parcel, 3, this.zzbjv);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzbjx);
        SafeParcelWriter.writeInt(parcel, 5, this.zzbjy);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzcwa, i, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzbka);
        SafeParcelWriter.writeInt(parcel, 8, this.zzbjw);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
