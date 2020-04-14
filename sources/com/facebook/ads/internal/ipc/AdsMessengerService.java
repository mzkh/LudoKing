package com.facebook.ads.internal.ipc;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.facebook.ads.internal.api.AdsMessengerServiceApi;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;

@UiThread
@Keep
public class AdsMessengerService extends Service {
    private AdsMessengerServiceApi mAdsMessengerServiceApi;

    public void onCreate() {
        this.mAdsMessengerServiceApi = DynamicLoaderFactory.makeLoader(this, false).createAdsMessengerServiceApi(this);
        this.mAdsMessengerServiceApi.onCreate();
    }

    public void onDestroy() {
        this.mAdsMessengerServiceApi.onDestroy();
    }

    @Nullable
    public IBinder onBind(Intent intent) {
        return this.mAdsMessengerServiceApi.onBind(intent);
    }
}
