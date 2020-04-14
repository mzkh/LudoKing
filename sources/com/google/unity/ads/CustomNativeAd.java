package com.google.unity.ads;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.BitmapDrawable;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import java.io.ByteArrayOutputStream;
import java.util.List;

public class CustomNativeAd {
    private Activity activity;
    /* access modifiers changed from: private */
    public NativeCustomTemplateAd nativeAd;

    public CustomNativeAd(Activity activity2, NativeCustomTemplateAd nativeCustomTemplateAd) {
        this.activity = activity2;
        this.nativeAd = nativeCustomTemplateAd;
    }

    public String[] getAvailableAssetNames() {
        List availableAssetNames = this.nativeAd.getAvailableAssetNames();
        return (String[]) availableAssetNames.toArray(new String[availableAssetNames.size()]);
    }

    public String getTemplateId() {
        return this.nativeAd.getCustomTemplateId();
    }

    public void performClick(final String str) {
        this.activity.runOnUiThread(new Runnable() {
            public void run() {
                CustomNativeAd.this.nativeAd.performClick(str);
            }
        });
    }

    public void recordImpression() {
        this.activity.runOnUiThread(new Runnable() {
            public void run() {
                CustomNativeAd.this.nativeAd.recordImpression();
            }
        });
    }

    public byte[] getImage(String str) {
        Image image = this.nativeAd.getImage(str);
        if (image == null) {
            return new byte[0];
        }
        Bitmap bitmap = ((BitmapDrawable) image.getDrawable()).getBitmap();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public String getText(String str) {
        if (this.nativeAd.getText(str) == null) {
            return "";
        }
        return this.nativeAd.getText(str).toString();
    }
}
