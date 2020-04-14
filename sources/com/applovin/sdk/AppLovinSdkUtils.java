package com.applovin.sdk;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.TypedValue;
import android.widget.ImageView;
import com.applovin.impl.sdk.utils.C1247h;
import com.applovin.impl.sdk.utils.C1281o;
import java.io.File;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class AppLovinSdkUtils {

    /* renamed from: a */
    private static final Handler f3282a = new Handler(Looper.getMainLooper());

    /* renamed from: a */
    private static void m3158a(ImageView imageView) {
        if (imageView != null) {
            Drawable drawable = imageView.getDrawable();
            if (drawable instanceof BitmapDrawable) {
                ((BitmapDrawable) drawable).getBitmap().recycle();
            }
        }
    }

    public static int dpToPx(Context context, int i) {
        return (int) TypedValue.applyDimension(1, (float) i, context.getResources().getDisplayMetrics());
    }

    public static boolean isTablet(Context context) {
        Configuration configuration = context.getResources().getConfiguration();
        return configuration != null && configuration.smallestScreenWidthDp >= 600;
    }

    public static boolean isValidString(String str) {
        return !TextUtils.isEmpty(str);
    }

    public static int pxToDp(Context context, int i) {
        return (int) Math.ceil((double) (((float) i) / context.getResources().getDisplayMetrics().density));
    }

    public static void runOnUiThread(Runnable runnable) {
        runOnUiThread(false, runnable);
    }

    public static void runOnUiThread(boolean z, Runnable runnable) {
        if (z || !C1281o.m3101b()) {
            f3282a.post(runnable);
        } else {
            runnable.run();
        }
    }

    public static void runOnUiThreadDelayed(Runnable runnable, long j) {
        if (j > 0) {
            f3282a.postDelayed(runnable, j);
        } else if (C1281o.m3101b()) {
            runnable.run();
        } else {
            f3282a.post(runnable);
        }
    }

    public static void safePopulateImageView(Context context, ImageView imageView, int i, int i2) {
        m3158a(imageView);
        Bitmap a = C1281o.m3066a(context, i, i2);
        if (a != null) {
            imageView.setImageBitmap(a);
        }
    }

    public static void safePopulateImageView(ImageView imageView, Bitmap bitmap) {
        m3158a(imageView);
        if (imageView != null && bitmap != null) {
            imageView.setImageBitmap(bitmap);
        }
    }

    public static void safePopulateImageView(ImageView imageView, Uri uri, int i) {
        m3158a(imageView);
        Bitmap a = C1281o.m3067a(new File(uri.getPath()), i);
        if (a != null) {
            imageView.setImageBitmap(a);
        }
    }

    public static Map<String, String> toMap(JSONObject jSONObject) throws JSONException {
        return C1247h.m2973a(jSONObject);
    }
}
