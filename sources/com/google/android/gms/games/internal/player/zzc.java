package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;

public final class zzc extends DataBufferRef implements zza {
    private final zzd zzcy;

    public zzc(DataHolder dataHolder, int i, zzd zzd) {
        super(dataHolder, i);
        this.zzcy = zzd;
    }

    public final int describeContents() {
        return 0;
    }

    public final String zzdb() {
        return getString(this.zzcy.zzmu);
    }

    public final String zzdc() {
        return getString(this.zzcy.zzmv);
    }

    public final long zzdd() {
        return getLong(this.zzcy.zzmw);
    }

    public final Uri zzde() {
        return parseUri(this.zzcy.zzmx);
    }

    public final Uri zzdf() {
        return parseUri(this.zzcy.zzmy);
    }

    public final Uri zzdg() {
        return parseUri(this.zzcy.zzmz);
    }

    public final int hashCode() {
        return MostRecentGameInfoEntity.zza(this);
    }

    public final boolean equals(Object obj) {
        return MostRecentGameInfoEntity.zza(this, obj);
    }

    public final String toString() {
        return MostRecentGameInfoEntity.zzb(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        ((MostRecentGameInfoEntity) ((zza) freeze())).writeToParcel(parcel, i);
    }

    public final /* synthetic */ Object freeze() {
        return new MostRecentGameInfoEntity(this);
    }
}
