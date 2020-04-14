package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.data.DataBufferRef;

public class StockProfileImageRef extends DataBufferRef implements StockProfileImage {
    public String getImageUrl() {
        return getString(MessengerShareContentUtility.IMAGE_URL);
    }

    public final Uri zzae() {
        throw new NoSuchMethodError();
    }

    public int describeContents() {
        throw new NoSuchMethodError();
    }

    public void writeToParcel(Parcel parcel, int i) {
        throw new NoSuchMethodError();
    }

    public /* synthetic */ Object freeze() {
        throw new NoSuchMethodError();
    }
}
