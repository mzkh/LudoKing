package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.Strategy;

@Class(creator = "SubscribeRequestCreator")
public final class SubscribeRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Creator<SubscribeRequest> CREATOR = new zzcd();
    @VersionField(mo15157id = 1)
    private final int versionCode;
    @Field(mo15151id = 8)
    @Deprecated
    @Nullable
    private final String zzff;
    @Field(mo15151id = 13)
    @Deprecated
    private final boolean zzfg;
    @Field(mo15151id = 9)
    @Deprecated
    @Nullable
    private final String zzfj;
    @Field(mo15151id = 15)
    private final boolean zzgb;
    @Field(mo15151id = 16)
    private final int zzgc;
    @Field(mo15151id = 17)
    private final int zzhf;
    @Field(getter = "getCallbackAsBinder", mo15151id = 4, type = "android.os.IBinder")
    private final zzp zzhh;
    @Field(mo15151id = 14)
    @Deprecated
    private final ClientAppContext zzhi;
    @Field(mo15151id = 3)
    private final Strategy zzit;
    @Field(mo15151id = 11)
    @Deprecated
    private final boolean zziu;
    @Field(getter = "getMessageListenerAsBinder", mo15151id = 2, type = "android.os.IBinder")
    @Nullable
    private final zzm zziy;
    @Field(mo15151id = 5)
    private final MessageFilter zziz;
    @Field(mo15151id = 6)
    @Nullable
    private final PendingIntent zzja;
    @Field(mo15151id = 7)
    @Deprecated
    private final int zzjb;
    @Field(mo15151id = 10)
    @Nullable
    private final byte[] zzjc;
    @Field(getter = "getSubscribeCallbackAsBinder", mo15151id = 12, type = "android.os.IBinder")
    @Nullable
    private final zzaa zzjd;

    @Constructor
    @VisibleForTesting
    public SubscribeRequest(@Param(mo15154id = 1) int i, @Param(mo15154id = 2) @Nullable IBinder iBinder, @Param(mo15154id = 3) Strategy strategy, @Param(mo15154id = 4) IBinder iBinder2, @Param(mo15154id = 5) MessageFilter messageFilter, @Param(mo15154id = 6) @Nullable PendingIntent pendingIntent, @Param(mo15154id = 7) int i2, @Param(mo15154id = 8) @Nullable String str, @Param(mo15154id = 9) @Nullable String str2, @Param(mo15154id = 10) @Nullable byte[] bArr, @Param(mo15154id = 11) boolean z, @Param(mo15154id = 12) @Nullable IBinder iBinder3, @Param(mo15154id = 13) boolean z2, @Param(mo15154id = 14) @Nullable ClientAppContext clientAppContext, @Param(mo15154id = 15) boolean z3, @Param(mo15154id = 16) int i3, @Param(mo15154id = 17) int i4) {
        zzm zzm;
        zzp zzp;
        IBinder iBinder4 = iBinder;
        IBinder iBinder5 = iBinder2;
        String str3 = str;
        String str4 = str2;
        IBinder iBinder6 = iBinder3;
        boolean z4 = z2;
        this.versionCode = i;
        zzaa zzaa = null;
        if (iBinder4 == null) {
            zzm = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.IMessageListener");
            zzm = queryLocalInterface instanceof zzm ? (zzm) queryLocalInterface : new zzo(iBinder);
        }
        this.zziy = zzm;
        this.zzit = strategy;
        if (iBinder5 == null) {
            zzp = null;
        } else {
            IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesCallback");
            zzp = queryLocalInterface2 instanceof zzp ? (zzp) queryLocalInterface2 : new zzr(iBinder2);
        }
        this.zzhh = zzp;
        this.zziz = messageFilter;
        this.zzja = pendingIntent;
        this.zzjb = i2;
        this.zzff = str3;
        this.zzfj = str4;
        this.zzjc = bArr;
        this.zziu = z;
        if (!(iBinder6 == null || iBinder6 == null)) {
            IInterface queryLocalInterface3 = iBinder6.queryLocalInterface("com.google.android.gms.nearby.messages.internal.ISubscribeCallback");
            zzaa = queryLocalInterface3 instanceof zzaa ? (zzaa) queryLocalInterface3 : new zzac(iBinder6);
        }
        this.zzjd = zzaa;
        this.zzfg = z4;
        this.zzhi = ClientAppContext.zza(clientAppContext, str4, str3, z4);
        this.zzgb = z3;
        this.zzgc = i3;
        this.zzhf = i4;
    }

    public SubscribeRequest(IBinder iBinder, Strategy strategy, IBinder iBinder2, MessageFilter messageFilter, PendingIntent pendingIntent, @Nullable byte[] bArr, @Nullable IBinder iBinder3, boolean z, int i) {
        this(iBinder, strategy, iBinder2, messageFilter, null, bArr, iBinder3, z, 0, i);
    }

    public SubscribeRequest(IBinder iBinder, Strategy strategy, IBinder iBinder2, MessageFilter messageFilter, PendingIntent pendingIntent, @Nullable byte[] bArr, @Nullable IBinder iBinder3, boolean z, int i, int i2) {
        this(3, iBinder, strategy, iBinder2, messageFilter, pendingIntent, 0, null, null, bArr, false, iBinder3, false, null, z, i, i2);
    }

    public final String toString() {
        String str;
        String valueOf = String.valueOf(this.zziy);
        String valueOf2 = String.valueOf(this.zzit);
        String valueOf3 = String.valueOf(this.zzhh);
        String valueOf4 = String.valueOf(this.zziz);
        String valueOf5 = String.valueOf(this.zzja);
        byte[] bArr = this.zzjc;
        if (bArr == null) {
            str = null;
        } else {
            int length = bArr.length;
            StringBuilder sb = new StringBuilder(19);
            sb.append("<");
            sb.append(length);
            sb.append(" bytes>");
            str = sb.toString();
        }
        String valueOf6 = String.valueOf(this.zzjd);
        boolean z = this.zzfg;
        String valueOf7 = String.valueOf(this.zzhi);
        boolean z2 = this.zzgb;
        String str2 = this.zzff;
        String str3 = this.zzfj;
        boolean z3 = this.zziu;
        int i = this.zzhf;
        StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 291 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length() + String.valueOf(valueOf4).length() + String.valueOf(valueOf5).length() + String.valueOf(str).length() + String.valueOf(valueOf6).length() + String.valueOf(valueOf7).length() + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb2.append("SubscribeRequest{messageListener=");
        sb2.append(valueOf);
        sb2.append(", strategy=");
        sb2.append(valueOf2);
        sb2.append(", callback=");
        sb2.append(valueOf3);
        sb2.append(", filter=");
        sb2.append(valueOf4);
        sb2.append(", pendingIntent=");
        sb2.append(valueOf5);
        sb2.append(", hint=");
        sb2.append(str);
        sb2.append(", subscribeCallback=");
        sb2.append(valueOf6);
        sb2.append(", useRealClientApiKey=");
        sb2.append(z);
        sb2.append(", clientAppContext=");
        sb2.append(valueOf7);
        sb2.append(", isDiscardPendingIntent=");
        sb2.append(z2);
        sb2.append(", zeroPartyPackageName=");
        sb2.append(str2);
        sb2.append(", realClientPackageName=");
        sb2.append(str3);
        sb2.append(", isIgnoreNearbyPermission=");
        sb2.append(z3);
        sb2.append(", callingContext=");
        sb2.append(i);
        sb2.append("}");
        return sb2.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        zzm zzm = this.zziy;
        IBinder iBinder = null;
        SafeParcelWriter.writeIBinder(parcel, 2, zzm == null ? null : zzm.asBinder(), false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzit, i, false);
        zzp zzp = this.zzhh;
        SafeParcelWriter.writeIBinder(parcel, 4, zzp == null ? null : zzp.asBinder(), false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zziz, i, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzja, i, false);
        SafeParcelWriter.writeInt(parcel, 7, this.zzjb);
        SafeParcelWriter.writeString(parcel, 8, this.zzff, false);
        SafeParcelWriter.writeString(parcel, 9, this.zzfj, false);
        SafeParcelWriter.writeByteArray(parcel, 10, this.zzjc, false);
        SafeParcelWriter.writeBoolean(parcel, 11, this.zziu);
        zzaa zzaa = this.zzjd;
        if (zzaa != null) {
            iBinder = zzaa.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 12, iBinder, false);
        SafeParcelWriter.writeBoolean(parcel, 13, this.zzfg);
        SafeParcelWriter.writeParcelable(parcel, 14, this.zzhi, i, false);
        SafeParcelWriter.writeBoolean(parcel, 15, this.zzgb);
        SafeParcelWriter.writeInt(parcel, 16, this.zzgc);
        SafeParcelWriter.writeInt(parcel, 17, this.zzhf);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
