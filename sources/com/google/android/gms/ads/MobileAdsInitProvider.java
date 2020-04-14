package com.google.android.gms.ads;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.internal.ads.zzxi;

@KeepForSdkWithMembers
/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public class MobileAdsInitProvider extends ContentProvider {
    private final zzxi zzabi = new zzxi();

    public void attachInfo(Context context, ProviderInfo providerInfo) {
        this.zzabi.attachInfo(context, providerInfo);
    }

    public boolean onCreate() {
        return this.zzabi.onCreate();
    }

    @Nullable
    public Cursor query(@NonNull Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return this.zzabi.query(uri, strArr, str, strArr2, str2);
    }

    @Nullable
    public String getType(@NonNull Uri uri) {
        return this.zzabi.getType(uri);
    }

    @Nullable
    public Uri insert(@NonNull Uri uri, ContentValues contentValues) {
        return this.zzabi.insert(uri, contentValues);
    }

    public int delete(@NonNull Uri uri, String str, String[] strArr) {
        return this.zzabi.delete(uri, str, strArr);
    }

    public int update(@NonNull Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return this.zzabi.update(uri, contentValues, str, strArr);
    }
}
