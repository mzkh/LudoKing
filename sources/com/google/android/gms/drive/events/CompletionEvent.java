package com.google.android.gms.drive.events;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.util.IOUtils;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.drive.zzev;
import com.google.android.gms.internal.drive.zzhp;
import com.tapjoy.TapjoyConstants;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Class(creator = "CompletionEventCreator")
@Reserved({1})
public final class CompletionEvent extends AbstractSafeParcelable implements ResourceEvent {
    public static final Creator<CompletionEvent> CREATOR = new zzg();
    public static final int STATUS_CANCELED = 3;
    public static final int STATUS_CONFLICT = 2;
    public static final int STATUS_FAILURE = 1;
    public static final int STATUS_SUCCESS = 0;
    private static final GmsLogger zzbx = new GmsLogger("CompletionEvent", "");
    @Field(mo15151id = 8)
    private final int status;
    @Field(mo15151id = 3)
    @Nullable
    private final String zzby;
    @Field(mo15151id = 4)
    @Nullable
    private final ParcelFileDescriptor zzbz;
    @Field(mo15151id = 5)
    @Nullable
    private final ParcelFileDescriptor zzca;
    @Field(mo15151id = 6)
    @Nullable
    private final MetadataBundle zzcb;
    @Field(mo15151id = 7)
    private final List<String> zzcc;
    @Field(mo15151id = 9)
    private final IBinder zzcd;
    private boolean zzce = false;
    private boolean zzcf = false;
    private boolean zzcg = false;
    @Field(mo15151id = 2)
    private final DriveId zzk;

    @Constructor
    CompletionEvent(@Param(mo15154id = 2) DriveId driveId, @Param(mo15154id = 3) String str, @Param(mo15154id = 4) ParcelFileDescriptor parcelFileDescriptor, @Param(mo15154id = 5) ParcelFileDescriptor parcelFileDescriptor2, @Param(mo15154id = 6) MetadataBundle metadataBundle, @Param(mo15154id = 7) List<String> list, @Param(mo15154id = 8) int i, @Param(mo15154id = 9) IBinder iBinder) {
        this.zzk = driveId;
        this.zzby = str;
        this.zzbz = parcelFileDescriptor;
        this.zzca = parcelFileDescriptor2;
        this.zzcb = metadataBundle;
        this.zzcc = list;
        this.status = i;
        this.zzcd = iBinder;
    }

    private final void zza(boolean z) {
        zzu();
        this.zzcg = true;
        IOUtils.closeQuietly(this.zzbz);
        IOUtils.closeQuietly(this.zzca);
        MetadataBundle metadataBundle = this.zzcb;
        if (metadataBundle != null && metadataBundle.zzd(zzhp.zzka)) {
            ((BitmapTeleporter) this.zzcb.zza(zzhp.zzka)).release();
        }
        IBinder iBinder = this.zzcd;
        String str = "CompletionEvent";
        String str2 = "snooze";
        String str3 = TapjoyConstants.TJC_FULLSCREEN_AD_DISMISS_URL;
        if (iBinder == null) {
            if (!z) {
                str2 = str3;
            }
            zzbx.efmt(str, "No callback on %s", str2);
            return;
        }
        try {
            zzev.zza(iBinder).zza(z);
        } catch (RemoteException e) {
            if (!z) {
                str2 = str3;
            }
            zzbx.mo15090e(str, String.format("RemoteException on %s", new Object[]{str2}), e);
        }
    }

    private final void zzu() {
        if (this.zzcg) {
            throw new IllegalStateException("Event has already been dismissed or snoozed.");
        }
    }

    public final void dismiss() {
        zza(false);
    }

    @Nullable
    public final String getAccountName() {
        zzu();
        return this.zzby;
    }

    @Nullable
    public final InputStream getBaseContentsInputStream() {
        zzu();
        ParcelFileDescriptor parcelFileDescriptor = this.zzbz;
        if (parcelFileDescriptor == null) {
            return null;
        }
        if (!this.zzce) {
            this.zzce = true;
            return new FileInputStream(parcelFileDescriptor.getFileDescriptor());
        }
        throw new IllegalStateException("getBaseInputStream() can only be called once per CompletionEvent instance.");
    }

    public final DriveId getDriveId() {
        zzu();
        return this.zzk;
    }

    @Nullable
    public final InputStream getModifiedContentsInputStream() {
        zzu();
        ParcelFileDescriptor parcelFileDescriptor = this.zzca;
        if (parcelFileDescriptor == null) {
            return null;
        }
        if (!this.zzcf) {
            this.zzcf = true;
            return new FileInputStream(parcelFileDescriptor.getFileDescriptor());
        }
        throw new IllegalStateException("getModifiedInputStream() can only be called once per CompletionEvent instance.");
    }

    @Nullable
    public final MetadataChangeSet getModifiedMetadataChangeSet() {
        zzu();
        MetadataBundle metadataBundle = this.zzcb;
        if (metadataBundle != null) {
            return new MetadataChangeSet(metadataBundle);
        }
        return null;
    }

    public final int getStatus() {
        zzu();
        return this.status;
    }

    public final List<String> getTrackingTags() {
        zzu();
        return new ArrayList(this.zzcc);
    }

    public final int getType() {
        return 2;
    }

    public final void snooze() {
        zza(true);
    }

    public final String toString() {
        String str;
        List<String> list = this.zzcc;
        if (list == null) {
            str = "<null>";
        } else {
            String join = TextUtils.join("','", list);
            StringBuilder sb = new StringBuilder(String.valueOf(join).length() + 2);
            String str2 = "'";
            sb.append(str2);
            sb.append(join);
            sb.append(str2);
            str = sb.toString();
        }
        return String.format(Locale.US, "CompletionEvent [id=%s, status=%s, trackingTag=%s]", new Object[]{this.zzk, Integer.valueOf(this.status), str});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = i | 1;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzk, i2, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzby, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzbz, i2, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzca, i2, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzcb, i2, false);
        SafeParcelWriter.writeStringList(parcel, 7, this.zzcc, false);
        SafeParcelWriter.writeInt(parcel, 8, this.status);
        SafeParcelWriter.writeIBinder(parcel, 9, this.zzcd, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
