package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.UUID;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzin implements Parcelable, Comparator<zza> {
    public static final Creator<zzin> CREATOR = new zzim();
    private int zzafv;
    private final zza[] zzamk;
    public final int zzaml;

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    public static final class zza implements Parcelable {
        public static final Creator<zza> CREATOR = new zzio();
        private final byte[] data;
        private final String mimeType;
        /* access modifiers changed from: private */
        public final UUID uuid;
        private int zzafv;
        public final boolean zzamm;

        public zza(UUID uuid2, String str, byte[] bArr) {
            this(uuid2, str, bArr, false);
        }

        public final int describeContents() {
            return 0;
        }

        private zza(UUID uuid2, String str, byte[] bArr, boolean z) {
            this.uuid = (UUID) zznr.checkNotNull(uuid2);
            this.mimeType = (String) zznr.checkNotNull(str);
            this.data = (byte[]) zznr.checkNotNull(bArr);
            this.zzamm = false;
        }

        zza(Parcel parcel) {
            this.uuid = new UUID(parcel.readLong(), parcel.readLong());
            this.mimeType = parcel.readString();
            this.data = parcel.createByteArray();
            this.zzamm = parcel.readByte() != 0;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            zza zza = (zza) obj;
            return this.mimeType.equals(zza.mimeType) && zzof.zza(this.uuid, zza.uuid) && Arrays.equals(this.data, zza.data);
        }

        public final int hashCode() {
            if (this.zzafv == 0) {
                this.zzafv = (((this.uuid.hashCode() * 31) + this.mimeType.hashCode()) * 31) + Arrays.hashCode(this.data);
            }
            return this.zzafv;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.uuid.getMostSignificantBits());
            parcel.writeLong(this.uuid.getLeastSignificantBits());
            parcel.writeString(this.mimeType);
            parcel.writeByteArray(this.data);
            parcel.writeByte(this.zzamm ? (byte) 1 : 0);
        }
    }

    public zzin(zza... zzaArr) {
        this(true, zzaArr);
    }

    public final int describeContents() {
        return 0;
    }

    private zzin(boolean z, zza... zzaArr) {
        zza[] zzaArr2 = (zza[]) zzaArr.clone();
        Arrays.sort(zzaArr2, this);
        int i = 1;
        while (i < zzaArr2.length) {
            if (!zzaArr2[i - 1].uuid.equals(zzaArr2[i].uuid)) {
                i++;
            } else {
                String valueOf = String.valueOf(zzaArr2[i].uuid);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 25);
                sb.append("Duplicate data for uuid: ");
                sb.append(valueOf);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        this.zzamk = zzaArr2;
        this.zzaml = zzaArr2.length;
    }

    zzin(Parcel parcel) {
        this.zzamk = (zza[]) parcel.createTypedArray(zza.CREATOR);
        this.zzaml = this.zzamk.length;
    }

    public final zza zzz(int i) {
        return this.zzamk[i];
    }

    public final int hashCode() {
        if (this.zzafv == 0) {
            this.zzafv = Arrays.hashCode(this.zzamk);
        }
        return this.zzafv;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.zzamk, ((zzin) obj).zzamk);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.zzamk, 0);
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zza zza2 = (zza) obj;
        zza zza3 = (zza) obj2;
        if (zzga.zzaca.equals(zza2.uuid)) {
            return zzga.zzaca.equals(zza3.uuid) ? 0 : 1;
        }
        return zza2.uuid.compareTo(zza3.uuid);
    }
}
