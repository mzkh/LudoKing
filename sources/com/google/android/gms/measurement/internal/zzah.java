package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import java.util.Iterator;

@Class(creator = "EventParamsCreator")
@Reserved({1})
public final class zzah extends AbstractSafeParcelable implements Iterable<String> {
    public static final Creator<zzah> CREATOR = new zzaj();
    /* access modifiers changed from: private */
    @Field(getter = "z", mo15151id = 2)
    public final Bundle zzft;

    @Constructor
    zzah(@Param(mo15154id = 2) Bundle bundle) {
        this.zzft = bundle;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 2, zzcv(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* access modifiers changed from: 0000 */
    public final Object get(String str) {
        return this.zzft.get(str);
    }

    /* access modifiers changed from: 0000 */
    public final Long getLong(String str) {
        return Long.valueOf(this.zzft.getLong(str));
    }

    /* access modifiers changed from: 0000 */
    public final Double zzah(String str) {
        return Double.valueOf(this.zzft.getDouble(str));
    }

    /* access modifiers changed from: 0000 */
    public final String getString(String str) {
        return this.zzft.getString(str);
    }

    public final int size() {
        return this.zzft.size();
    }

    public final String toString() {
        return this.zzft.toString();
    }

    public final Bundle zzcv() {
        return new Bundle(this.zzft);
    }

    public final Iterator<String> iterator() {
        return new zzag(this);
    }
}
