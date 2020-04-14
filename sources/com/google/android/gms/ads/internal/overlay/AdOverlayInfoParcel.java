package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.zzg;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzadw;
import com.google.android.gms.internal.ads.zzady;
import com.google.android.gms.internal.ads.zzaxl;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zztp;

@Class(creator = "AdOverlayInfoCreator")
@Reserved({1})
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class AdOverlayInfoParcel extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Creator<AdOverlayInfoParcel> CREATOR = new zzm();
    @Field(mo15151id = 11)
    public final int orientation;
    @Field(mo15151id = 13)
    public final String url;
    @Field(mo15151id = 14)
    public final zzaxl zzblk;
    @Field(getter = "getAdClickListenerAsBinder", mo15151id = 3, type = "android.os.IBinder")
    public final zztp zzcbs;
    @Field(getter = "getAdMetadataGmsgListenerAsBinder", mo15151id = 18, type = "android.os.IBinder")
    public final zzadw zzcxc;
    @Field(getter = "getAppEventGmsgListenerAsBinder", mo15151id = 6, type = "android.os.IBinder")
    public final zzady zzcxd;
    @Field(getter = "getAdWebViewAsBinder", mo15151id = 5, type = "android.os.IBinder")
    public final zzbbw zzczi;
    @Field(mo15151id = 2)
    public final zzd zzdhx;
    @Field(getter = "getAdOverlayListenerAsBinder", mo15151id = 4, type = "android.os.IBinder")
    public final zzo zzdhy;
    @Field(mo15151id = 7)
    public final String zzdhz;
    @Field(mo15151id = 8)
    public final boolean zzdia;
    @Field(mo15151id = 9)
    public final String zzdib;
    @Field(getter = "getLeaveApplicationListenerAsBinder", mo15151id = 10, type = "android.os.IBinder")
    public final zzt zzdic;
    @Field(mo15151id = 12)
    public final int zzdid;
    @Field(mo15151id = 16)
    public final String zzdie;
    @Field(mo15151id = 17)
    public final zzg zzdif;

    public static void zza(Intent intent, AdOverlayInfoParcel adOverlayInfoParcel) {
        Bundle bundle = new Bundle(1);
        String str = "com.google.android.gms.ads.inernal.overlay.AdOverlayInfo";
        bundle.putParcelable(str, adOverlayInfoParcel);
        intent.putExtra(str, bundle);
    }

    public static AdOverlayInfoParcel zzc(Intent intent) {
        String str = "com.google.android.gms.ads.inernal.overlay.AdOverlayInfo";
        try {
            Bundle bundleExtra = intent.getBundleExtra(str);
            bundleExtra.setClassLoader(AdOverlayInfoParcel.class.getClassLoader());
            return (AdOverlayInfoParcel) bundleExtra.getParcelable(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public AdOverlayInfoParcel(zztp zztp, zzo zzo, zzt zzt, zzbbw zzbbw, int i, zzaxl zzaxl, String str, zzg zzg, String str2, String str3) {
        this.zzdhx = null;
        this.zzcbs = null;
        this.zzdhy = zzo;
        this.zzczi = zzbbw;
        this.zzcxc = null;
        this.zzcxd = null;
        this.zzdhz = str2;
        this.zzdia = false;
        this.zzdib = str3;
        this.zzdic = null;
        this.orientation = i;
        this.zzdid = 1;
        this.url = null;
        this.zzblk = zzaxl;
        this.zzdie = str;
        this.zzdif = zzg;
    }

    public AdOverlayInfoParcel(zztp zztp, zzo zzo, zzt zzt, zzbbw zzbbw, boolean z, int i, zzaxl zzaxl) {
        this.zzdhx = null;
        this.zzcbs = zztp;
        this.zzdhy = zzo;
        this.zzczi = zzbbw;
        this.zzcxc = null;
        this.zzcxd = null;
        this.zzdhz = null;
        this.zzdia = z;
        this.zzdib = null;
        this.zzdic = zzt;
        this.orientation = i;
        this.zzdid = 2;
        this.url = null;
        this.zzblk = zzaxl;
        this.zzdie = null;
        this.zzdif = null;
    }

    public AdOverlayInfoParcel(zztp zztp, zzo zzo, zzadw zzadw, zzady zzady, zzt zzt, zzbbw zzbbw, boolean z, int i, String str, zzaxl zzaxl) {
        this.zzdhx = null;
        this.zzcbs = zztp;
        this.zzdhy = zzo;
        this.zzczi = zzbbw;
        this.zzcxc = zzadw;
        this.zzcxd = zzady;
        this.zzdhz = null;
        this.zzdia = z;
        this.zzdib = null;
        this.zzdic = zzt;
        this.orientation = i;
        this.zzdid = 3;
        this.url = str;
        this.zzblk = zzaxl;
        this.zzdie = null;
        this.zzdif = null;
    }

    public AdOverlayInfoParcel(zztp zztp, zzo zzo, zzadw zzadw, zzady zzady, zzt zzt, zzbbw zzbbw, boolean z, int i, String str, String str2, zzaxl zzaxl) {
        this.zzdhx = null;
        this.zzcbs = zztp;
        this.zzdhy = zzo;
        this.zzczi = zzbbw;
        this.zzcxc = zzadw;
        this.zzcxd = zzady;
        this.zzdhz = str2;
        this.zzdia = z;
        this.zzdib = str;
        this.zzdic = zzt;
        this.orientation = i;
        this.zzdid = 3;
        this.url = null;
        this.zzblk = zzaxl;
        this.zzdie = null;
        this.zzdif = null;
    }

    public AdOverlayInfoParcel(zzd zzd, zztp zztp, zzo zzo, zzt zzt, zzaxl zzaxl) {
        this.zzdhx = zzd;
        this.zzcbs = zztp;
        this.zzdhy = zzo;
        this.zzczi = null;
        this.zzcxc = null;
        this.zzcxd = null;
        this.zzdhz = null;
        this.zzdia = false;
        this.zzdib = null;
        this.zzdic = zzt;
        this.orientation = -1;
        this.zzdid = 4;
        this.url = null;
        this.zzblk = zzaxl;
        this.zzdie = null;
        this.zzdif = null;
    }

    @Constructor
    AdOverlayInfoParcel(@Param(mo15154id = 2) zzd zzd, @Param(mo15154id = 3) IBinder iBinder, @Param(mo15154id = 4) IBinder iBinder2, @Param(mo15154id = 5) IBinder iBinder3, @Param(mo15154id = 6) IBinder iBinder4, @Param(mo15154id = 7) String str, @Param(mo15154id = 8) boolean z, @Param(mo15154id = 9) String str2, @Param(mo15154id = 10) IBinder iBinder5, @Param(mo15154id = 11) int i, @Param(mo15154id = 12) int i2, @Param(mo15154id = 13) String str3, @Param(mo15154id = 14) zzaxl zzaxl, @Param(mo15154id = 16) String str4, @Param(mo15154id = 17) zzg zzg, @Param(mo15154id = 18) IBinder iBinder6) {
        this.zzdhx = zzd;
        this.zzcbs = (zztp) ObjectWrapper.unwrap(Stub.asInterface(iBinder));
        this.zzdhy = (zzo) ObjectWrapper.unwrap(Stub.asInterface(iBinder2));
        this.zzczi = (zzbbw) ObjectWrapper.unwrap(Stub.asInterface(iBinder3));
        this.zzcxc = (zzadw) ObjectWrapper.unwrap(Stub.asInterface(iBinder6));
        this.zzcxd = (zzady) ObjectWrapper.unwrap(Stub.asInterface(iBinder4));
        this.zzdhz = str;
        this.zzdia = z;
        this.zzdib = str2;
        this.zzdic = (zzt) ObjectWrapper.unwrap(Stub.asInterface(iBinder5));
        this.orientation = i;
        this.zzdid = i2;
        this.url = str3;
        this.zzblk = zzaxl;
        this.zzdie = str4;
        this.zzdif = zzg;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzdhx, i, false);
        SafeParcelWriter.writeIBinder(parcel, 3, ObjectWrapper.wrap(this.zzcbs).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 4, ObjectWrapper.wrap(this.zzdhy).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 5, ObjectWrapper.wrap(this.zzczi).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 6, ObjectWrapper.wrap(this.zzcxd).asBinder(), false);
        SafeParcelWriter.writeString(parcel, 7, this.zzdhz, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzdia);
        SafeParcelWriter.writeString(parcel, 9, this.zzdib, false);
        SafeParcelWriter.writeIBinder(parcel, 10, ObjectWrapper.wrap(this.zzdic).asBinder(), false);
        SafeParcelWriter.writeInt(parcel, 11, this.orientation);
        SafeParcelWriter.writeInt(parcel, 12, this.zzdid);
        SafeParcelWriter.writeString(parcel, 13, this.url, false);
        SafeParcelWriter.writeParcelable(parcel, 14, this.zzblk, i, false);
        SafeParcelWriter.writeString(parcel, 16, this.zzdie, false);
        SafeParcelWriter.writeParcelable(parcel, 17, this.zzdif, i, false);
        SafeParcelWriter.writeIBinder(parcel, 18, ObjectWrapper.wrap(this.zzcxc).asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
