package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.zzb;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@Class(creator = "AdSizeParcelCreator")
@Reserved({1})
/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzua extends AbstractSafeParcelable {
    public static final Creator<zzua> CREATOR = new zzud();
    @Field(mo15151id = 3)
    public final int height;
    @Field(mo15151id = 4)
    public final int heightPixels;
    @Field(mo15151id = 6)
    public final int width;
    @Field(mo15151id = 7)
    public final int widthPixels;
    @Field(mo15151id = 2)
    public final String zzabd;
    @Field(mo15151id = 9)
    public final boolean zzbmb;
    @Field(mo15151id = 5)
    public final boolean zzccm;
    @Field(mo15151id = 8)
    public final zzua[] zzccn;
    @Field(mo15151id = 10)
    public final boolean zzcco;
    @Field(mo15151id = 11)
    public boolean zzccp;
    @Field(mo15151id = 12)
    public boolean zzccq;
    @Field(mo15151id = 13)
    private boolean zzccr;
    @Field(mo15151id = 14)
    public boolean zzccs;

    public static int zzb(DisplayMetrics displayMetrics) {
        return displayMetrics.widthPixels;
    }

    public static int zzc(DisplayMetrics displayMetrics) {
        return (int) (((float) zzd(displayMetrics)) * displayMetrics.density);
    }

    private static int zzd(DisplayMetrics displayMetrics) {
        int i = (int) (((float) displayMetrics.heightPixels) / displayMetrics.density);
        if (i <= 400) {
            return 32;
        }
        return i <= 720 ? 50 : 90;
    }

    public static zzua zzg(Context context) {
        zzua zzua = new zzua("320x50_mb", 0, 0, false, 0, 0, null, true, false, false, false, false, false);
        return zzua;
    }

    public static zzua zzoa() {
        zzua zzua = new zzua("reward_mb", 0, 0, true, 0, 0, null, false, false, false, false, false, false);
        return zzua;
    }

    public static zzua zzob() {
        zzua zzua = new zzua("interstitial_mb", 0, 0, false, 0, 0, null, false, false, false, false, true, false);
        return zzua;
    }

    public zzua() {
        this("interstitial_mb", 0, 0, true, 0, 0, null, false, false, false, false, false, false);
    }

    public static zzua zzoc() {
        zzua zzua = new zzua("invalid", 0, 0, false, 0, 0, null, false, false, false, true, false, false);
        return zzua;
    }

    public zzua(Context context, AdSize adSize) {
        this(context, new AdSize[]{adSize});
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x008c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzua(android.content.Context r13, com.google.android.gms.ads.AdSize[] r14) {
        /*
            r12 = this;
            r12.<init>()
            r0 = 0
            r1 = r14[r0]
            r12.zzccm = r0
            boolean r2 = r1.isFluid()
            r12.zzcco = r2
            boolean r2 = r1.zzdc()
            r12.zzccs = r2
            boolean r2 = r12.zzcco
            if (r2 == 0) goto L_0x0029
            com.google.android.gms.ads.AdSize r2 = com.google.android.gms.ads.AdSize.BANNER
            int r2 = r2.getWidth()
            r12.width = r2
            com.google.android.gms.ads.AdSize r2 = com.google.android.gms.ads.AdSize.BANNER
            int r2 = r2.getHeight()
            r12.height = r2
            goto L_0x0035
        L_0x0029:
            int r2 = r1.getWidth()
            r12.width = r2
            int r2 = r1.getHeight()
            r12.height = r2
        L_0x0035:
            int r2 = r12.width
            r3 = -1
            r4 = 1
            if (r2 != r3) goto L_0x003d
            r2 = 1
            goto L_0x003e
        L_0x003d:
            r2 = 0
        L_0x003e:
            int r3 = r12.height
            r5 = -2
            if (r3 != r5) goto L_0x0045
            r3 = 1
            goto L_0x0046
        L_0x0045:
            r3 = 0
        L_0x0046:
            android.content.res.Resources r5 = r13.getResources()
            android.util.DisplayMetrics r5 = r5.getDisplayMetrics()
            if (r2 == 0) goto L_0x008f
            com.google.android.gms.internal.ads.zzuv.zzoj()
            boolean r6 = com.google.android.gms.internal.ads.zzawy.zzbl(r13)
            if (r6 == 0) goto L_0x006f
            com.google.android.gms.internal.ads.zzuv.zzoj()
            boolean r6 = com.google.android.gms.internal.ads.zzawy.zzbm(r13)
            if (r6 == 0) goto L_0x006f
            int r6 = r5.widthPixels
            com.google.android.gms.internal.ads.zzuv.zzoj()
            int r7 = com.google.android.gms.internal.ads.zzawy.zzbn(r13)
            int r6 = r6 - r7
            r12.widthPixels = r6
            goto L_0x0073
        L_0x006f:
            int r6 = r5.widthPixels
            r12.widthPixels = r6
        L_0x0073:
            int r6 = r12.widthPixels
            float r6 = (float) r6
            float r7 = r5.density
            float r6 = r6 / r7
            double r6 = (double) r6
            int r8 = (int) r6
            double r9 = (double) r8
            java.lang.Double.isNaN(r6)
            java.lang.Double.isNaN(r9)
            double r6 = r6 - r9
            r9 = 4576918229304087675(0x3f847ae147ae147b, double:0.01)
            int r11 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r11 < 0) goto L_0x009c
            int r8 = r8 + 1
            goto L_0x009c
        L_0x008f:
            int r8 = r12.width
            com.google.android.gms.internal.ads.zzuv.zzoj()
            int r6 = r12.width
            int r6 = com.google.android.gms.internal.ads.zzawy.zza(r5, r6)
            r12.widthPixels = r6
        L_0x009c:
            if (r3 == 0) goto L_0x00a3
            int r6 = zzd(r5)
            goto L_0x00a5
        L_0x00a3:
            int r6 = r12.height
        L_0x00a5:
            com.google.android.gms.internal.ads.zzuv.zzoj()
            int r5 = com.google.android.gms.internal.ads.zzawy.zza(r5, r6)
            r12.heightPixels = r5
            if (r2 != 0) goto L_0x00c3
            if (r3 == 0) goto L_0x00b3
            goto L_0x00c3
        L_0x00b3:
            boolean r2 = r12.zzcco
            if (r2 == 0) goto L_0x00bc
            java.lang.String r1 = "320x50_mb"
            r12.zzabd = r1
            goto L_0x00e0
        L_0x00bc:
            java.lang.String r1 = r1.toString()
            r12.zzabd = r1
            goto L_0x00e0
        L_0x00c3:
            r1 = 26
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            r2.append(r8)
            java.lang.String r1 = "x"
            r2.append(r1)
            r2.append(r6)
            java.lang.String r1 = "_as"
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r12.zzabd = r1
        L_0x00e0:
            int r1 = r14.length
            if (r1 <= r4) goto L_0x00fa
            int r1 = r14.length
            com.google.android.gms.internal.ads.zzua[] r1 = new com.google.android.gms.internal.ads.zzua[r1]
            r12.zzccn = r1
            r1 = 0
        L_0x00e9:
            int r2 = r14.length
            if (r1 >= r2) goto L_0x00fd
            com.google.android.gms.internal.ads.zzua[] r2 = r12.zzccn
            com.google.android.gms.internal.ads.zzua r3 = new com.google.android.gms.internal.ads.zzua
            r4 = r14[r1]
            r3.<init>(r13, r4)
            r2[r1] = r3
            int r1 = r1 + 1
            goto L_0x00e9
        L_0x00fa:
            r13 = 0
            r12.zzccn = r13
        L_0x00fd:
            r12.zzbmb = r0
            r12.zzccp = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzua.<init>(android.content.Context, com.google.android.gms.ads.AdSize[]):void");
    }

    @Constructor
    zzua(@Param(mo15154id = 2) String str, @Param(mo15154id = 3) int i, @Param(mo15154id = 4) int i2, @Param(mo15154id = 5) boolean z, @Param(mo15154id = 6) int i3, @Param(mo15154id = 7) int i4, @Param(mo15154id = 8) zzua[] zzuaArr, @Param(mo15154id = 9) boolean z2, @Param(mo15154id = 10) boolean z3, @Param(mo15154id = 11) boolean z4, @Param(mo15154id = 12) boolean z5, @Param(mo15154id = 13) boolean z6, @Param(mo15154id = 14) boolean z7) {
        this.zzabd = str;
        this.height = i;
        this.heightPixels = i2;
        this.zzccm = z;
        this.width = i3;
        this.widthPixels = i4;
        this.zzccn = zzuaArr;
        this.zzbmb = z2;
        this.zzcco = z3;
        this.zzccp = z4;
        this.zzccq = z5;
        this.zzccr = z6;
        this.zzccs = z7;
    }

    public final AdSize zzod() {
        return zzb.zza(this.width, this.height, this.zzabd);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzabd, false);
        SafeParcelWriter.writeInt(parcel, 3, this.height);
        SafeParcelWriter.writeInt(parcel, 4, this.heightPixels);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzccm);
        SafeParcelWriter.writeInt(parcel, 6, this.width);
        SafeParcelWriter.writeInt(parcel, 7, this.widthPixels);
        SafeParcelWriter.writeTypedArray(parcel, 8, this.zzccn, i, false);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzbmb);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzcco);
        SafeParcelWriter.writeBoolean(parcel, 11, this.zzccp);
        SafeParcelWriter.writeBoolean(parcel, 12, this.zzccq);
        SafeParcelWriter.writeBoolean(parcel, 13, this.zzccr);
        SafeParcelWriter.writeBoolean(parcel, 14, this.zzccs);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
