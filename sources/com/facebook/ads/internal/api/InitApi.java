package com.facebook.ads.internal.api;

import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.facebook.ads.AudienceNetworkAds.InitListener;
import com.facebook.ads.internal.settings.MultithreadedBundleWrapper;

@Keep
public interface InitApi {
    public static final int INIT_TYPE_CONTENT_PROVIDER = 0;
    public static final int INIT_TYPE_INTERNAL_API = 3;
    public static final int INIT_TYPE_PUBLIC_API = 1;
    public static final int INIT_TYPE_REMOTE_PROCESS = 2;

    void initialize(Context context, @Nullable MultithreadedBundleWrapper multithreadedBundleWrapper, @Nullable InitListener initListener, int i);

    boolean isInitialized();

    void maybeAttachCrashListener(Context context);

    void onAdEventManagerCreated(Context context);

    void onAdLoadInvoked(Context context);

    void onContentProviderCreated(Context context);
}
