package com.google.android.gms.internal.drive;

import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public final class zzaa extends Metadata {
    private final MetadataBundle zzdr;

    public zzaa(MetadataBundle metadataBundle) {
        this.zzdr = metadataBundle;
    }

    public final /* synthetic */ Object freeze() {
        return new zzaa(this.zzdr.zzax());
    }

    public final boolean isDataValid() {
        return this.zzdr != null;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzdr);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 17);
        sb.append("Metadata [mImpl=");
        sb.append(valueOf);
        sb.append("]");
        return sb.toString();
    }

    public final <T> T zza(MetadataField<T> metadataField) {
        return this.zzdr.zza(metadataField);
    }
}
