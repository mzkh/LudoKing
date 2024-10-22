package com.google.android.gms.auth.api.accounttransfer;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.collection.ArraySet;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Indicator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.google.android.gms.internal.auth.zzaz;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Class(creator = "AuthenticatorTransferInfoCreator")
public class zzt extends zzaz {
    public static final Creator<zzt> CREATOR = new zzu();
    private static final HashMap<String, Field<?, ?>> zzaz;
    @Indicator
    private final Set<Integer> zzba;
    @SafeParcelable.Field(getter = "getAccountType", mo15151id = 2)
    private String zzbn;
    @SafeParcelable.Field(getter = "getStatus", mo15151id = 3)
    private int zzbo;
    @SafeParcelable.Field(getter = "getTransferBytes", mo15151id = 4)
    private byte[] zzbp;
    @SafeParcelable.Field(getter = "getPendingIntent", mo15151id = 5)
    private PendingIntent zzbq;
    @SafeParcelable.Field(getter = "getDeviceMetaData", mo15151id = 6)
    private DeviceMetaData zzbr;
    @VersionField(mo15157id = 1)
    private final int zzv;

    @Constructor
    zzt(@Indicator Set<Integer> set, @Param(mo15154id = 1) int i, @Param(mo15154id = 2) String str, @Param(mo15154id = 3) int i2, @Param(mo15154id = 4) byte[] bArr, @Param(mo15154id = 5) PendingIntent pendingIntent, @Param(mo15154id = 6) DeviceMetaData deviceMetaData) {
        this.zzba = set;
        this.zzv = i;
        this.zzbn = str;
        this.zzbo = i2;
        this.zzbp = bArr;
        this.zzbq = pendingIntent;
        this.zzbr = deviceMetaData;
    }

    public zzt() {
        this.zzba = new ArraySet(3);
        this.zzv = 1;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        Set<Integer> set = this.zzba;
        if (set.contains(Integer.valueOf(1))) {
            SafeParcelWriter.writeInt(parcel, 1, this.zzv);
        }
        if (set.contains(Integer.valueOf(2))) {
            SafeParcelWriter.writeString(parcel, 2, this.zzbn, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            SafeParcelWriter.writeInt(parcel, 3, this.zzbo);
        }
        if (set.contains(Integer.valueOf(4))) {
            SafeParcelWriter.writeByteArray(parcel, 4, this.zzbp, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            SafeParcelWriter.writeParcelable(parcel, 5, this.zzbq, i, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            SafeParcelWriter.writeParcelable(parcel, 6, this.zzbr, i, true);
        }
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* access modifiers changed from: protected */
    public boolean isFieldSet(Field field) {
        return this.zzba.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
    }

    /* access modifiers changed from: protected */
    public Object getFieldValue(Field field) {
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        if (safeParcelableFieldId == 1) {
            return Integer.valueOf(this.zzv);
        }
        if (safeParcelableFieldId == 2) {
            return this.zzbn;
        }
        if (safeParcelableFieldId == 3) {
            return Integer.valueOf(this.zzbo);
        }
        if (safeParcelableFieldId == 4) {
            return this.zzbp;
        }
        int safeParcelableFieldId2 = field.getSafeParcelableFieldId();
        StringBuilder sb = new StringBuilder(37);
        sb.append("Unknown SafeParcelable id=");
        sb.append(safeParcelableFieldId2);
        throw new IllegalStateException(sb.toString());
    }

    /* access modifiers changed from: protected */
    public void setStringInternal(Field<?, ?> field, String str, String str2) {
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        if (safeParcelableFieldId == 2) {
            this.zzbn = str2;
            this.zzba.add(Integer.valueOf(safeParcelableFieldId));
            return;
        }
        throw new IllegalArgumentException(String.format("Field with id=%d is not known to be a string.", new Object[]{Integer.valueOf(safeParcelableFieldId)}));
    }

    /* access modifiers changed from: protected */
    public void setIntegerInternal(Field<?, ?> field, String str, int i) {
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        if (safeParcelableFieldId == 3) {
            this.zzbo = i;
            this.zzba.add(Integer.valueOf(safeParcelableFieldId));
            return;
        }
        StringBuilder sb = new StringBuilder(52);
        sb.append("Field with id=");
        sb.append(safeParcelableFieldId);
        sb.append(" is not known to be an int.");
        throw new IllegalArgumentException(sb.toString());
    }

    /* access modifiers changed from: protected */
    public void setDecodedBytesInternal(Field<?, ?> field, String str, byte[] bArr) {
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        if (safeParcelableFieldId == 4) {
            this.zzbp = bArr;
            this.zzba.add(Integer.valueOf(safeParcelableFieldId));
            return;
        }
        StringBuilder sb = new StringBuilder(59);
        sb.append("Field with id=");
        sb.append(safeParcelableFieldId);
        sb.append(" is not known to be an byte array.");
        throw new IllegalArgumentException(sb.toString());
    }

    public /* synthetic */ Map getFieldMappings() {
        return zzaz;
    }

    static {
        HashMap<String, Field<?, ?>> hashMap = new HashMap<>();
        zzaz = hashMap;
        String str = "accountType";
        hashMap.put(str, Field.forString(str, 2));
        String str2 = "status";
        zzaz.put(str2, Field.forInteger(str2, 3));
        String str3 = "transferBytes";
        zzaz.put(str3, Field.forBase64(str3, 4));
    }
}
