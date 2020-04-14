package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@Class(creator = "AdResponseParcelCreator")
@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzaon extends AbstractSafeParcelable {
    public static final Creator<zzaon> CREATOR = new zzaoq();
    @Field(mo15151id = 5)
    private final int errorCode;
    @Field(mo15151id = 12)
    private final int orientation;
    @Field(mo15151id = 1)
    private final int versionCode;
    @Field(mo15151id = 37)
    @Nullable
    private final zzaop zzbkt;
    @Field(mo15151id = 49)
    private final boolean zzbld;
    @Field(mo15151id = 53)
    private final boolean zzble;
    @Field(mo15151id = 23)
    private final boolean zzbmb;
    @Field(mo15151id = 30)
    private final String zzbzn;
    @Field(mo15151id = 31)
    private final boolean zzcco;
    @Field(mo15151id = 32)
    private final boolean zzccp;
    @Field(mo15151id = 4)
    private final List<String> zzdby;
    @Field(mo15151id = 6)
    private final List<String> zzdbz;
    @Field(mo15151id = 52)
    private final List<String> zzdca;
    @Field(mo15151id = 40)
    private final List<String> zzdcc;
    @Field(mo15151id = 42)
    private final boolean zzdcd;
    @Field(mo15151id = 11)
    private final long zzdcf;
    @Field(mo15151id = 2)
    private final String zzdhz;
    @Field(mo15151id = 24)
    private final boolean zzdjb;
    @Field(mo15151id = 38)
    private final boolean zzdjo;
    @Field(mo15151id = 39)
    @Nullable
    private String zzdjp;
    @Field(mo15151id = 47)
    private final boolean zzdkb;
    @Field(mo15151id = 3)
    private String zzdko;
    @Field(mo15151id = 7)
    private final long zzdkp;
    @Field(mo15151id = 8)
    private final boolean zzdkq;
    @Field(mo15151id = 9)
    private final long zzdkr;
    @Field(mo15151id = 10)
    private final List<String> zzdks;
    @Field(mo15151id = 13)
    private final String zzdkt;
    @Field(mo15151id = 14)
    private final long zzdku;
    @Field(mo15151id = 15)
    private final String zzdkv;
    @Field(mo15151id = 18)
    private final boolean zzdkw;
    @Field(mo15151id = 19)
    private final String zzdkx;
    @Field(mo15151id = 21)
    private final String zzdky;
    @Field(mo15151id = 22)
    private final boolean zzdkz;
    @Field(mo15151id = 25)
    private final boolean zzdla;
    @Field(mo15151id = 26)
    private final boolean zzdlb;
    @Field(mo15151id = 28)
    private zzaoz zzdlc;
    @Field(mo15151id = 29)
    private String zzdld;
    @Field(mo15151id = 33)
    @Nullable
    private final zzaqt zzdle;
    @Field(mo15151id = 34)
    @Nullable
    private final List<String> zzdlf;
    @Field(mo15151id = 35)
    @Nullable
    private final List<String> zzdlg;
    @Field(mo15151id = 36)
    private final boolean zzdlh;
    @Field(mo15151id = 43)
    @Nullable
    private final String zzdli;
    @Field(mo15151id = 44)
    @Nullable
    private final zzasd zzdlj;
    @Field(mo15151id = 45)
    @Nullable
    private final String zzdlk;
    @Field(mo15151id = 46)
    private final boolean zzdll;
    @Field(mo15151id = 48)
    private Bundle zzdlm;
    @Field(mo15151id = 50)
    private final int zzdln;
    @Field(mo15151id = 51)
    private final boolean zzdlo;
    @Field(mo15151id = 54)
    @Nullable
    private final String zzdlp;
    @Field(mo15151id = 55)
    @Nullable
    private String zzdlq;
    @Field(mo15151id = 56)
    private boolean zzdlr;
    @Field(mo15151id = 57)
    private boolean zzdls;

    @Constructor
    zzaon(@Param(mo15154id = 1) int i, @Param(mo15154id = 2) String str, @Param(mo15154id = 3) String str2, @Param(mo15154id = 4) List<String> list, @Param(mo15154id = 5) int i2, @Param(mo15154id = 6) List<String> list2, @Param(mo15154id = 7) long j, @Param(mo15154id = 8) boolean z, @Param(mo15154id = 9) long j2, @Param(mo15154id = 10) List<String> list3, @Param(mo15154id = 11) long j3, @Param(mo15154id = 12) int i3, @Param(mo15154id = 13) String str3, @Param(mo15154id = 14) long j4, @Param(mo15154id = 15) String str4, @Param(mo15154id = 18) boolean z2, @Param(mo15154id = 19) String str5, @Param(mo15154id = 21) String str6, @Param(mo15154id = 22) boolean z3, @Param(mo15154id = 23) boolean z4, @Param(mo15154id = 24) boolean z5, @Param(mo15154id = 25) boolean z6, @Param(mo15154id = 26) boolean z7, @Param(mo15154id = 28) zzaoz zzaoz, @Param(mo15154id = 29) String str7, @Param(mo15154id = 30) String str8, @Param(mo15154id = 31) boolean z8, @Param(mo15154id = 32) boolean z9, @Param(mo15154id = 33) zzaqt zzaqt, @Param(mo15154id = 34) List<String> list4, @Param(mo15154id = 35) List<String> list5, @Param(mo15154id = 36) boolean z10, @Param(mo15154id = 37) zzaop zzaop, @Param(mo15154id = 38) boolean z11, @Param(mo15154id = 39) String str9, @Param(mo15154id = 40) List<String> list6, @Param(mo15154id = 42) boolean z12, @Param(mo15154id = 43) String str10, @Param(mo15154id = 44) zzasd zzasd, @Param(mo15154id = 45) String str11, @Param(mo15154id = 46) boolean z13, @Param(mo15154id = 47) boolean z14, @Param(mo15154id = 48) Bundle bundle, @Param(mo15154id = 49) boolean z15, @Param(mo15154id = 50) int i4, @Param(mo15154id = 51) boolean z16, @Param(mo15154id = 52) List<String> list7, @Param(mo15154id = 53) boolean z17, @Param(mo15154id = 54) String str12, @Param(mo15154id = 55) @Nullable String str13, @Param(mo15154id = 56) boolean z18, @Param(mo15154id = 57) boolean z19) {
        this.versionCode = i;
        this.zzdhz = str;
        this.zzdko = str2;
        List<String> list8 = null;
        this.zzdby = list != null ? Collections.unmodifiableList(list) : null;
        this.errorCode = i2;
        this.zzdbz = list2 != null ? Collections.unmodifiableList(list2) : null;
        this.zzdkp = j;
        this.zzdkq = z;
        this.zzdkr = j2;
        this.zzdks = list3 != null ? Collections.unmodifiableList(list3) : null;
        this.zzdcf = j3;
        this.orientation = i3;
        this.zzdkt = str3;
        this.zzdku = j4;
        this.zzdkv = str4;
        this.zzdkw = z2;
        this.zzdkx = str5;
        this.zzdky = str6;
        this.zzdkz = z3;
        this.zzbmb = z4;
        this.zzdjb = z5;
        this.zzdla = z6;
        this.zzdll = z13;
        this.zzdlb = z7;
        this.zzdlc = zzaoz;
        this.zzdld = str7;
        this.zzbzn = str8;
        if (this.zzdko == null) {
            zzaoz zzaoz2 = this.zzdlc;
            if (zzaoz2 != null) {
                zzapg zzapg = (zzapg) zzaoz2.zza(zzapg.CREATOR);
                if (zzapg != null && !TextUtils.isEmpty(zzapg.zzdmd)) {
                    this.zzdko = zzapg.zzdmd;
                }
            }
        }
        this.zzcco = z8;
        this.zzccp = z9;
        this.zzdle = zzaqt;
        this.zzdlf = list4;
        this.zzdlg = list5;
        this.zzdlh = z10;
        this.zzbkt = zzaop;
        this.zzdjo = z11;
        this.zzdjp = str9;
        this.zzdcc = list6;
        this.zzdcd = z12;
        this.zzdli = str10;
        this.zzdlj = zzasd;
        this.zzdlk = str11;
        this.zzdkb = z14;
        this.zzdlm = bundle;
        this.zzbld = z15;
        this.zzdln = i4;
        this.zzdlo = z16;
        if (list7 != null) {
            list8 = Collections.unmodifiableList(list7);
        }
        this.zzdca = list8;
        this.zzble = z17;
        this.zzdlp = str12;
        this.zzdlq = str13;
        this.zzdlr = z18;
        this.zzdls = z19;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeString(parcel, 2, this.zzdhz, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzdko, false);
        SafeParcelWriter.writeStringList(parcel, 4, this.zzdby, false);
        SafeParcelWriter.writeInt(parcel, 5, this.errorCode);
        SafeParcelWriter.writeStringList(parcel, 6, this.zzdbz, false);
        SafeParcelWriter.writeLong(parcel, 7, this.zzdkp);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzdkq);
        SafeParcelWriter.writeLong(parcel, 9, this.zzdkr);
        SafeParcelWriter.writeStringList(parcel, 10, this.zzdks, false);
        SafeParcelWriter.writeLong(parcel, 11, this.zzdcf);
        SafeParcelWriter.writeInt(parcel, 12, this.orientation);
        SafeParcelWriter.writeString(parcel, 13, this.zzdkt, false);
        SafeParcelWriter.writeLong(parcel, 14, this.zzdku);
        SafeParcelWriter.writeString(parcel, 15, this.zzdkv, false);
        SafeParcelWriter.writeBoolean(parcel, 18, this.zzdkw);
        SafeParcelWriter.writeString(parcel, 19, this.zzdkx, false);
        SafeParcelWriter.writeString(parcel, 21, this.zzdky, false);
        SafeParcelWriter.writeBoolean(parcel, 22, this.zzdkz);
        SafeParcelWriter.writeBoolean(parcel, 23, this.zzbmb);
        SafeParcelWriter.writeBoolean(parcel, 24, this.zzdjb);
        SafeParcelWriter.writeBoolean(parcel, 25, this.zzdla);
        SafeParcelWriter.writeBoolean(parcel, 26, this.zzdlb);
        SafeParcelWriter.writeParcelable(parcel, 28, this.zzdlc, i, false);
        SafeParcelWriter.writeString(parcel, 29, this.zzdld, false);
        SafeParcelWriter.writeString(parcel, 30, this.zzbzn, false);
        SafeParcelWriter.writeBoolean(parcel, 31, this.zzcco);
        SafeParcelWriter.writeBoolean(parcel, 32, this.zzccp);
        SafeParcelWriter.writeParcelable(parcel, 33, this.zzdle, i, false);
        SafeParcelWriter.writeStringList(parcel, 34, this.zzdlf, false);
        SafeParcelWriter.writeStringList(parcel, 35, this.zzdlg, false);
        SafeParcelWriter.writeBoolean(parcel, 36, this.zzdlh);
        SafeParcelWriter.writeParcelable(parcel, 37, this.zzbkt, i, false);
        SafeParcelWriter.writeBoolean(parcel, 38, this.zzdjo);
        SafeParcelWriter.writeString(parcel, 39, this.zzdjp, false);
        SafeParcelWriter.writeStringList(parcel, 40, this.zzdcc, false);
        SafeParcelWriter.writeBoolean(parcel, 42, this.zzdcd);
        SafeParcelWriter.writeString(parcel, 43, this.zzdli, false);
        SafeParcelWriter.writeParcelable(parcel, 44, this.zzdlj, i, false);
        SafeParcelWriter.writeString(parcel, 45, this.zzdlk, false);
        SafeParcelWriter.writeBoolean(parcel, 46, this.zzdll);
        SafeParcelWriter.writeBoolean(parcel, 47, this.zzdkb);
        SafeParcelWriter.writeBundle(parcel, 48, this.zzdlm, false);
        SafeParcelWriter.writeBoolean(parcel, 49, this.zzbld);
        SafeParcelWriter.writeInt(parcel, 50, this.zzdln);
        SafeParcelWriter.writeBoolean(parcel, 51, this.zzdlo);
        SafeParcelWriter.writeStringList(parcel, 52, this.zzdca, false);
        SafeParcelWriter.writeBoolean(parcel, 53, this.zzble);
        SafeParcelWriter.writeString(parcel, 54, this.zzdlp, false);
        SafeParcelWriter.writeString(parcel, 55, this.zzdlq, false);
        SafeParcelWriter.writeBoolean(parcel, 56, this.zzdlr);
        SafeParcelWriter.writeBoolean(parcel, 57, this.zzdls);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
