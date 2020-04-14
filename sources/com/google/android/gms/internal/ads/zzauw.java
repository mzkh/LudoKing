package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.provider.Settings.Global;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.common.util.SharedPreferencesUtils;

@TargetApi(17)
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public class zzauw extends zzaur {
    public zzauw() {
        super();
    }

    public final boolean zza(Context context, WebSettings webSettings) {
        super.zza(context, webSettings);
        webSettings.setMediaPlaybackRequiresUserGesture(false);
        return true;
    }

    public final String getDefaultUserAgent(Context context) {
        String str;
        zzawp zzwe = zzawp.zzwe();
        if (TextUtils.isEmpty(zzwe.zzdvd)) {
            if (ClientLibraryUtils.isPackageSide()) {
                str = (String) zzawq.zza(context, new zzaws(zzwe, context));
            } else {
                str = (String) zzawq.zza(context, new zzawr(zzwe, GooglePlayServicesUtilLight.getRemoteContext(context), context));
            }
            zzwe.zzdvd = str;
        }
        return zzwe.zzdvd;
    }

    public final void zzbc(Context context) {
        zzawp zzwe = zzawp.zzwe();
        zzaug.zzdy("Updating user agent.");
        String defaultUserAgent = WebSettings.getDefaultUserAgent(context);
        if (!defaultUserAgent.equals(zzwe.zzdvd)) {
            Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(context);
            if (ClientLibraryUtils.isPackageSide() || remoteContext == null) {
                String str = "admob_user_agent";
                Editor putString = context.getSharedPreferences(str, 0).edit().putString("user_agent", WebSettings.getDefaultUserAgent(context));
                if (remoteContext == null) {
                    putString.apply();
                } else {
                    SharedPreferencesUtils.publishWorldReadableSharedPreferences(context, putString, str);
                }
            }
            zzwe.zzdvd = defaultUserAgent;
        }
        zzaug.zzdy("User agent is updated.");
    }

    public final Drawable zza(Context context, Bitmap bitmap, boolean z, float f) {
        if (!z || f <= 0.0f || f > 25.0f) {
            return new BitmapDrawable(context.getResources(), bitmap);
        }
        try {
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight(), false);
            Bitmap createBitmap = Bitmap.createBitmap(createScaledBitmap);
            RenderScript create = RenderScript.create(context);
            ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
            Allocation createFromBitmap = Allocation.createFromBitmap(create, createScaledBitmap);
            Allocation createFromBitmap2 = Allocation.createFromBitmap(create, createBitmap);
            create2.setRadius(f);
            create2.setInput(createFromBitmap);
            create2.forEach(createFromBitmap2);
            createFromBitmap2.copyTo(createBitmap);
            return new BitmapDrawable(context.getResources(), createBitmap);
        } catch (RuntimeException unused) {
            return new BitmapDrawable(context.getResources(), bitmap);
        }
    }

    public final int zza(ContentResolver contentResolver) {
        return Global.getInt(contentResolver, "wifi_on", 0);
    }

    public final int zzb(ContentResolver contentResolver) {
        return Global.getInt(contentResolver, "airplane_mode_on", 0);
    }
}
