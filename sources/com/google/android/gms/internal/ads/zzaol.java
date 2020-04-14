package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@Class(creator = "AdRequestInfoParcelCreator")
@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzaol extends AbstractSafeParcelable {
    public static final Creator<zzaol> CREATOR = new zzaoo();
    @Field(mo15151id = 6)
    private final ApplicationInfo applicationInfo;
    @Field(mo15151id = 1)
    private final int versionCode;
    @Field(mo15151id = 11)
    private final zzaxl zzblk;
    @Field(mo15151id = 4)
    private final zzua zzbll;
    @Field(mo15151id = 20)
    private final float zzbog;
    @Field(mo15151id = 5)
    private final String zzbqy;
    @Field(mo15151id = 10)
    private final String zzcdr;
    @Field(mo15151id = 42)
    private final boolean zzdcd;
    @Field(mo15151id = 29)
    private final zzaay zzdeh;
    @Field(mo15151id = 14)
    private final List<String> zzdei;
    @Field(mo15151id = 18)
    private final int zzdgn;
    @Field(mo15151id = 19)
    private final int zzdgo;
    @Field(mo15151id = 2)
    @Nullable
    private final Bundle zzdit;
    @Field(mo15151id = 3)
    private final zztx zzdiu;
    @Field(mo15151id = 7)
    @Nullable
    private final PackageInfo zzdiv;
    @Field(mo15151id = 8)
    private final String zzdiw;
    @Field(mo15151id = 9)
    private final String zzdix;
    @Field(mo15151id = 12)
    private final Bundle zzdiy;
    @Field(mo15151id = 13)
    private final int zzdiz;
    @Field(mo15151id = 15)
    private final Bundle zzdja;
    @Field(mo15151id = 16)
    private final boolean zzdjb;
    @Field(mo15151id = 21)
    private final String zzdjc;
    @Field(mo15151id = 25)
    private final long zzdjd;
    @Field(mo15151id = 26)
    private final String zzdje;
    @Field(mo15151id = 27)
    @Nullable
    private final List<String> zzdjf;
    @Field(mo15151id = 28)
    private final String zzdjg;
    @Field(mo15151id = 30)
    private final List<String> zzdjh;
    @Field(mo15151id = 31)
    private final long zzdji;
    @Field(mo15151id = 33)
    private final String zzdjj;
    @Field(mo15151id = 34)
    private final float zzdjk;
    @Field(mo15151id = 35)
    private final int zzdjl;
    @Field(mo15151id = 36)
    private final int zzdjm;
    @Field(mo15151id = 37)
    private final boolean zzdjn;
    @Field(mo15151id = 38)
    private final boolean zzdjo;
    @Field(mo15151id = 39)
    private final String zzdjp;
    @Field(mo15151id = 40)
    private final boolean zzdjq;
    @Field(mo15151id = 41)
    private final String zzdjr;
    @Field(mo15151id = 43)
    private final int zzdjs;
    @Field(mo15151id = 44)
    private final Bundle zzdjt;
    @Field(mo15151id = 45)
    private final String zzdju;
    @Field(mo15151id = 46)
    @Nullable
    private final zzwx zzdjv;
    @Field(mo15151id = 47)
    private final boolean zzdjw;
    @Field(mo15151id = 48)
    private final Bundle zzdjx;
    @Field(mo15151id = 49)
    @Nullable
    private final String zzdjy;
    @Field(mo15151id = 50)
    @Nullable
    private final String zzdjz;
    @Field(mo15151id = 51)
    @Nullable
    private final String zzdka;
    @Field(mo15151id = 52)
    private final boolean zzdkb;
    @Field(mo15151id = 53)
    private final List<Integer> zzdkc;
    @Field(mo15151id = 54)
    private final String zzdkd;
    @Field(mo15151id = 55)
    private final List<String> zzdke;
    @Field(mo15151id = 56)
    private final int zzdkf;
    @Field(mo15151id = 57)
    private final boolean zzdkg;
    @Field(mo15151id = 58)
    private final boolean zzdkh;
    @Field(mo15151id = 59)
    private final boolean zzdki;
    @Field(mo15151id = 60)
    private final ArrayList<String> zzdkj;
    @Field(mo15151id = 61)
    private final String zzdkk;
    @Field(mo15151id = 63)
    private final zzagd zzdkl;
    @Field(mo15151id = 64)
    @Nullable
    private final String zzdkm;
    @Field(mo15151id = 65)
    private final Bundle zzdkn;

    @Constructor
    zzaol(@Param(mo15154id = 1) int i, @Param(mo15154id = 2) Bundle bundle, @Param(mo15154id = 3) zztx zztx, @Param(mo15154id = 4) zzua zzua, @Param(mo15154id = 5) String str, @Param(mo15154id = 6) ApplicationInfo applicationInfo2, @Param(mo15154id = 7) PackageInfo packageInfo, @Param(mo15154id = 8) String str2, @Param(mo15154id = 9) String str3, @Param(mo15154id = 10) String str4, @Param(mo15154id = 11) zzaxl zzaxl, @Param(mo15154id = 12) Bundle bundle2, @Param(mo15154id = 13) int i2, @Param(mo15154id = 14) List<String> list, @Param(mo15154id = 15) Bundle bundle3, @Param(mo15154id = 16) boolean z, @Param(mo15154id = 18) int i3, @Param(mo15154id = 19) int i4, @Param(mo15154id = 20) float f, @Param(mo15154id = 21) String str5, @Param(mo15154id = 25) long j, @Param(mo15154id = 26) String str6, @Param(mo15154id = 27) List<String> list2, @Param(mo15154id = 28) String str7, @Param(mo15154id = 29) zzaay zzaay, @Param(mo15154id = 30) List<String> list3, @Param(mo15154id = 31) long j2, @Param(mo15154id = 33) String str8, @Param(mo15154id = 34) float f2, @Param(mo15154id = 40) boolean z2, @Param(mo15154id = 35) int i5, @Param(mo15154id = 36) int i6, @Param(mo15154id = 37) boolean z3, @Param(mo15154id = 38) boolean z4, @Param(mo15154id = 39) String str9, @Param(mo15154id = 41) String str10, @Param(mo15154id = 42) boolean z5, @Param(mo15154id = 43) int i7, @Param(mo15154id = 44) Bundle bundle4, @Param(mo15154id = 45) String str11, @Param(mo15154id = 46) zzwx zzwx, @Param(mo15154id = 47) boolean z6, @Param(mo15154id = 48) Bundle bundle5, @Param(mo15154id = 49) @Nullable String str12, @Param(mo15154id = 50) @Nullable String str13, @Param(mo15154id = 51) @Nullable String str14, @Param(mo15154id = 52) boolean z7, @Param(mo15154id = 53) List<Integer> list4, @Param(mo15154id = 54) String str15, @Param(mo15154id = 55) List<String> list5, @Param(mo15154id = 56) int i8, @Param(mo15154id = 57) boolean z8, @Param(mo15154id = 58) boolean z9, @Param(mo15154id = 59) boolean z10, @Param(mo15154id = 60) ArrayList<String> arrayList, @Param(mo15154id = 61) String str16, @Param(mo15154id = 63) zzagd zzagd, @Param(mo15154id = 64) @Nullable String str17, @Param(mo15154id = 65) Bundle bundle6) {
        List<String> list6;
        List<String> list7;
        this.versionCode = i;
        this.zzdit = bundle;
        this.zzdiu = zztx;
        this.zzbll = zzua;
        this.zzbqy = str;
        this.applicationInfo = applicationInfo2;
        this.zzdiv = packageInfo;
        this.zzdiw = str2;
        this.zzdix = str3;
        this.zzcdr = str4;
        this.zzblk = zzaxl;
        this.zzdiy = bundle2;
        this.zzdiz = i2;
        this.zzdei = list;
        if (list3 == null) {
            list6 = Collections.emptyList();
        } else {
            list6 = Collections.unmodifiableList(list3);
        }
        this.zzdjh = list6;
        this.zzdja = bundle3;
        this.zzdjb = z;
        this.zzdgn = i3;
        this.zzdgo = i4;
        this.zzbog = f;
        this.zzdjc = str5;
        this.zzdjd = j;
        this.zzdje = str6;
        if (list2 == null) {
            list7 = Collections.emptyList();
        } else {
            list7 = Collections.unmodifiableList(list2);
        }
        this.zzdjf = list7;
        this.zzdjg = str7;
        this.zzdeh = zzaay;
        this.zzdji = j2;
        this.zzdjj = str8;
        this.zzdjk = f2;
        this.zzdjq = z2;
        this.zzdjl = i5;
        this.zzdjm = i6;
        this.zzdjn = z3;
        this.zzdjo = z4;
        this.zzdjp = str9;
        this.zzdjr = str10;
        this.zzdcd = z5;
        this.zzdjs = i7;
        this.zzdjt = bundle4;
        this.zzdju = str11;
        this.zzdjv = zzwx;
        this.zzdjw = z6;
        this.zzdjx = bundle5;
        this.zzdjy = str12;
        this.zzdjz = str13;
        this.zzdka = str14;
        this.zzdkb = z7;
        this.zzdkc = list4;
        this.zzdkd = str15;
        this.zzdke = list5;
        this.zzdkf = i8;
        this.zzdkg = z8;
        this.zzdkh = z9;
        this.zzdki = z10;
        this.zzdkj = arrayList;
        this.zzdkk = str16;
        this.zzdkl = zzagd;
        this.zzdkm = str17;
        this.zzdkn = bundle6;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeBundle(parcel, 2, this.zzdit, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzdiu, i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzbll, i, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzbqy, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.applicationInfo, i, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzdiv, i, false);
        SafeParcelWriter.writeString(parcel, 8, this.zzdiw, false);
        SafeParcelWriter.writeString(parcel, 9, this.zzdix, false);
        SafeParcelWriter.writeString(parcel, 10, this.zzcdr, false);
        SafeParcelWriter.writeParcelable(parcel, 11, this.zzblk, i, false);
        SafeParcelWriter.writeBundle(parcel, 12, this.zzdiy, false);
        SafeParcelWriter.writeInt(parcel, 13, this.zzdiz);
        SafeParcelWriter.writeStringList(parcel, 14, this.zzdei, false);
        SafeParcelWriter.writeBundle(parcel, 15, this.zzdja, false);
        SafeParcelWriter.writeBoolean(parcel, 16, this.zzdjb);
        SafeParcelWriter.writeInt(parcel, 18, this.zzdgn);
        SafeParcelWriter.writeInt(parcel, 19, this.zzdgo);
        SafeParcelWriter.writeFloat(parcel, 20, this.zzbog);
        SafeParcelWriter.writeString(parcel, 21, this.zzdjc, false);
        SafeParcelWriter.writeLong(parcel, 25, this.zzdjd);
        SafeParcelWriter.writeString(parcel, 26, this.zzdje, false);
        SafeParcelWriter.writeStringList(parcel, 27, this.zzdjf, false);
        SafeParcelWriter.writeString(parcel, 28, this.zzdjg, false);
        SafeParcelWriter.writeParcelable(parcel, 29, this.zzdeh, i, false);
        SafeParcelWriter.writeStringList(parcel, 30, this.zzdjh, false);
        SafeParcelWriter.writeLong(parcel, 31, this.zzdji);
        SafeParcelWriter.writeString(parcel, 33, this.zzdjj, false);
        SafeParcelWriter.writeFloat(parcel, 34, this.zzdjk);
        SafeParcelWriter.writeInt(parcel, 35, this.zzdjl);
        SafeParcelWriter.writeInt(parcel, 36, this.zzdjm);
        SafeParcelWriter.writeBoolean(parcel, 37, this.zzdjn);
        SafeParcelWriter.writeBoolean(parcel, 38, this.zzdjo);
        SafeParcelWriter.writeString(parcel, 39, this.zzdjp, false);
        SafeParcelWriter.writeBoolean(parcel, 40, this.zzdjq);
        SafeParcelWriter.writeString(parcel, 41, this.zzdjr, false);
        SafeParcelWriter.writeBoolean(parcel, 42, this.zzdcd);
        SafeParcelWriter.writeInt(parcel, 43, this.zzdjs);
        SafeParcelWriter.writeBundle(parcel, 44, this.zzdjt, false);
        SafeParcelWriter.writeString(parcel, 45, this.zzdju, false);
        SafeParcelWriter.writeParcelable(parcel, 46, this.zzdjv, i, false);
        SafeParcelWriter.writeBoolean(parcel, 47, this.zzdjw);
        SafeParcelWriter.writeBundle(parcel, 48, this.zzdjx, false);
        SafeParcelWriter.writeString(parcel, 49, this.zzdjy, false);
        SafeParcelWriter.writeString(parcel, 50, this.zzdjz, false);
        SafeParcelWriter.writeString(parcel, 51, this.zzdka, false);
        SafeParcelWriter.writeBoolean(parcel, 52, this.zzdkb);
        SafeParcelWriter.writeIntegerList(parcel, 53, this.zzdkc, false);
        SafeParcelWriter.writeString(parcel, 54, this.zzdkd, false);
        SafeParcelWriter.writeStringList(parcel, 55, this.zzdke, false);
        SafeParcelWriter.writeInt(parcel, 56, this.zzdkf);
        SafeParcelWriter.writeBoolean(parcel, 57, this.zzdkg);
        SafeParcelWriter.writeBoolean(parcel, 58, this.zzdkh);
        SafeParcelWriter.writeBoolean(parcel, 59, this.zzdki);
        SafeParcelWriter.writeStringList(parcel, 60, this.zzdkj, false);
        SafeParcelWriter.writeString(parcel, 61, this.zzdkk, false);
        SafeParcelWriter.writeParcelable(parcel, 63, this.zzdkl, i, false);
        SafeParcelWriter.writeString(parcel, 64, this.zzdkm, false);
        SafeParcelWriter.writeBundle(parcel, 65, this.zzdkn, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
