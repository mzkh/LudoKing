package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.google.android.gms.internal.auth.zzaz;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Class(creator = "AccountTransferProgressCreator")
public class zzo extends zzaz {
    public static final Creator<zzo> CREATOR = new zzp();
    private static final ArrayMap<String, Field<?, ?>> zzbe;
    @SafeParcelable.Field(getter = "getRegisteredAccountTypes", mo15151id = 2)
    private List<String> zzbf;
    @SafeParcelable.Field(getter = "getInProgressAccountTypes", mo15151id = 3)
    private List<String> zzbg;
    @SafeParcelable.Field(getter = "getSuccessAccountTypes", mo15151id = 4)
    private List<String> zzbh;
    @SafeParcelable.Field(getter = "getFailedAccountTypes", mo15151id = 5)
    private List<String> zzbi;
    @SafeParcelable.Field(getter = "getEscrowedAccountTypes", mo15151id = 6)
    private List<String> zzbj;
    @VersionField(mo15157id = 1)
    private final int zzv;

    public zzo() {
        this.zzv = 1;
    }

    /* access modifiers changed from: protected */
    public boolean isFieldSet(Field field) {
        return true;
    }

    @Constructor
    zzo(@Param(mo15154id = 1) int i, @Param(mo15154id = 2) @Nullable List<String> list, @Param(mo15154id = 3) @Nullable List<String> list2, @Param(mo15154id = 4) @Nullable List<String> list3, @Param(mo15154id = 5) @Nullable List<String> list4, @Param(mo15154id = 6) @Nullable List<String> list5) {
        this.zzv = i;
        this.zzbf = list;
        this.zzbg = list2;
        this.zzbh = list3;
        this.zzbi = list4;
        this.zzbj = list5;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzv);
        SafeParcelWriter.writeStringList(parcel, 2, this.zzbf, false);
        SafeParcelWriter.writeStringList(parcel, 3, this.zzbg, false);
        SafeParcelWriter.writeStringList(parcel, 4, this.zzbh, false);
        SafeParcelWriter.writeStringList(parcel, 5, this.zzbi, false);
        SafeParcelWriter.writeStringList(parcel, 6, this.zzbj, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public Map<String, Field<?, ?>> getFieldMappings() {
        return zzbe;
    }

    /* access modifiers changed from: protected */
    public Object getFieldValue(Field field) {
        switch (field.getSafeParcelableFieldId()) {
            case 1:
                return Integer.valueOf(this.zzv);
            case 2:
                return this.zzbf;
            case 3:
                return this.zzbg;
            case 4:
                return this.zzbh;
            case 5:
                return this.zzbi;
            case 6:
                return this.zzbj;
            default:
                int safeParcelableFieldId = field.getSafeParcelableFieldId();
                StringBuilder sb = new StringBuilder(37);
                sb.append("Unknown SafeParcelable id=");
                sb.append(safeParcelableFieldId);
                throw new IllegalStateException(sb.toString());
        }
    }

    /* access modifiers changed from: protected */
    public void setStringsInternal(Field<?, ?> field, String str, ArrayList<String> arrayList) {
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        if (safeParcelableFieldId == 2) {
            this.zzbf = arrayList;
        } else if (safeParcelableFieldId == 3) {
            this.zzbg = arrayList;
        } else if (safeParcelableFieldId == 4) {
            this.zzbh = arrayList;
        } else if (safeParcelableFieldId == 5) {
            this.zzbi = arrayList;
        } else if (safeParcelableFieldId == 6) {
            this.zzbj = arrayList;
        } else {
            throw new IllegalArgumentException(String.format("Field with id=%d is not known to be a string list.", new Object[]{Integer.valueOf(safeParcelableFieldId)}));
        }
    }

    static {
        ArrayMap<String, Field<?, ?>> arrayMap = new ArrayMap<>();
        zzbe = arrayMap;
        String str = "registered";
        arrayMap.put(str, Field.forStrings(str, 2));
        String str2 = "in_progress";
        zzbe.put(str2, Field.forStrings(str2, 3));
        String str3 = "success";
        zzbe.put(str3, Field.forStrings(str3, 4));
        String str4 = "failed";
        zzbe.put(str4, Field.forStrings(str4, 5));
        String str5 = "escrowed";
        zzbe.put(str5, Field.forStrings(str5, 6));
    }
}
