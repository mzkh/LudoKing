package com.google.android.gms.internal.ads;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.wrappers.Wrappers;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzxi extends ContentProvider {
    public final int delete(@NonNull Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Nullable
    public final String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    public final Uri insert(@NonNull Uri uri, ContentValues contentValues) {
        return null;
    }

    public final boolean onCreate() {
        return false;
    }

    @Nullable
    public final Cursor query(@NonNull Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public final int update(@NonNull Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    public final void attachInfo(Context context, ProviderInfo providerInfo) {
        Bundle zzh = zzh(context);
        zzajp zzrn = zzajp.zzrn();
        if (zzh == null) {
            zzaxi.zzes("Metadata was null.");
        } else {
            try {
                String str = (String) zzh.get("com.google.android.gms.ads.APPLICATION_ID");
                try {
                    Boolean bool = (Boolean) zzh.get("com.google.android.gms.ads.AD_MANAGER_APP");
                    try {
                        Boolean bool2 = (Boolean) zzh.get("com.google.android.gms.ads.DELAY_APP_MEASUREMENT_INIT");
                        if (str == null || str.matches("^/\\d+~.+$")) {
                            if (bool == null || !bool.booleanValue()) {
                                throw new IllegalStateException("\n\n******************************************************************************\n* The Google Mobile Ads SDK was initialized incorrectly. AdMob publishers    *\n* should follow the instructions here:                                       *\n* https://googlemobileadssdk.page.link/admob-android-update-manifest         *\n* to add a valid App ID inside the AndroidManifest.                          *\n* Google Ad Manager publishers should follow instructions here:              *\n* https://googlemobileadssdk.page.link/ad-manager-android-update-manifest.   *\n******************************************************************************\n\n");
                            } else if (bool2 == null || !bool2.booleanValue()) {
                                zzrn.zzm(context);
                            }
                        } else if (str.matches("^ca-app-pub-[0-9]{16}~[0-9]{10}$")) {
                            String str2 = "Publisher provided Google AdMob App ID in manifest: ";
                            String valueOf = String.valueOf(str);
                            zzaxi.zzdv(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                            if (bool2 == null || !bool2.booleanValue()) {
                                zzrn.zzc(context, str);
                            }
                        } else {
                            throw new IllegalStateException("\n\n******************************************************************************\n* Invalid application ID. Follow instructions here:                          *\n* https://googlemobileadssdk.page.link/admob-android-update-manifest         *\n* to find your app ID.                                                       *\n******************************************************************************\n\n");
                        }
                    } catch (ClassCastException e) {
                        throw new IllegalStateException("The com.google.android.gms.ads.DELAY_APP_MEASUREMENT_INIT metadata must have a boolean value.", e);
                    }
                } catch (ClassCastException e2) {
                    throw new IllegalStateException("The com.google.android.gms.ads.AD_MANAGER_APP metadata must have a boolean value.", e2);
                }
            } catch (ClassCastException e3) {
                throw new IllegalStateException("The com.google.android.gms.ads.APPLICATION_ID metadata must have a String value.", e3);
            }
        }
        super.attachInfo(context, providerInfo);
    }

    @Nullable
    private static Bundle zzh(Context context) {
        try {
            return Wrappers.packageManager(context).getApplicationInfo(context.getPackageName(), 128).metaData;
        } catch (NullPointerException e) {
            zzaxi.zzc("Failed to load metadata: Null pointer exception.", e);
            return null;
        } catch (NameNotFoundException e2) {
            zzaxi.zzc("Failed to load metadata: Package name not found.", e2);
            return null;
        }
    }
}
