package com.google.android.gms.drive.metadata.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.drive.zzhp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Class(creator = "MetadataBundleCreator")
@Reserved({1})
public final class MetadataBundle extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Creator<MetadataBundle> CREATOR = new zzj();
    private static final GmsLogger zzbx = new GmsLogger("MetadataBundle", "");
    @Field(mo15151id = 2)
    private final Bundle zzir;

    @Constructor
    MetadataBundle(@Param(mo15154id = 2) Bundle bundle) {
        int i;
        this.zzir = (Bundle) Preconditions.checkNotNull(bundle);
        this.zzir.setClassLoader(getClass().getClassLoader());
        ArrayList arrayList = new ArrayList();
        Iterator it = this.zzir.keySet().iterator();
        while (true) {
            i = 0;
            if (!it.hasNext()) {
                break;
            }
            String str = (String) it.next();
            if (zzf.zzd(str) == null) {
                arrayList.add(str);
                zzbx.wfmt("MetadataBundle", "Ignored unknown metadata field in bundle: %s", str);
            }
        }
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            this.zzir.remove((String) obj);
        }
    }

    public static <T> MetadataBundle zza(MetadataField<T> metadataField, T t) {
        MetadataBundle zzaw = zzaw();
        zzaw.zzb(metadataField, t);
        return zzaw;
    }

    public static MetadataBundle zzaw() {
        return new MetadataBundle(new Bundle());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        MetadataBundle metadataBundle = (MetadataBundle) obj;
        Set<String> keySet = this.zzir.keySet();
        if (!keySet.equals(metadataBundle.zzir.keySet())) {
            return false;
        }
        for (String str : keySet) {
            if (!Objects.equal(this.zzir.get(str), metadataBundle.zzir.get(str))) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (String str : this.zzir.keySet()) {
            i = (i * 31) + this.zzir.get(str).hashCode();
        }
        return i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 2, this.zzir, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Nullable
    public final <T> T zza(MetadataField<T> metadataField) {
        return metadataField.zza(this.zzir);
    }

    public final void zza(Context context) {
        BitmapTeleporter bitmapTeleporter = (BitmapTeleporter) zza(zzhp.zzka);
        if (bitmapTeleporter != null) {
            bitmapTeleporter.setTempDir(context.getCacheDir());
        }
    }

    public final MetadataBundle zzax() {
        return new MetadataBundle(new Bundle(this.zzir));
    }

    public final Set<MetadataField<?>> zzay() {
        HashSet hashSet = new HashSet();
        for (String zzd : this.zzir.keySet()) {
            hashSet.add(zzf.zzd(zzd));
        }
        return hashSet;
    }

    public final <T> void zzb(MetadataField<T> metadataField, T t) {
        if (zzf.zzd(metadataField.getName()) == null) {
            String str = "Unregistered field: ";
            String valueOf = String.valueOf(metadataField.getName());
            throw new IllegalArgumentException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
        metadataField.zza(t, this.zzir);
    }

    @Nullable
    public final <T> T zzc(MetadataField<T> metadataField) {
        T zza = zza(metadataField);
        this.zzir.remove(metadataField.getName());
        return zza;
    }

    public final boolean zzd(MetadataField<?> metadataField) {
        return this.zzir.containsKey(metadataField.getName());
    }
}
