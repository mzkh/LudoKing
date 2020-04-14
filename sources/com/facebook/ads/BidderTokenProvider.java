package com.facebook.ads;

import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.WorkerThread;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import com.facebook.ads.internal.util.common.Preconditions;

@Keep
public final class BidderTokenProvider {
    @WorkerThread
    public static String getBidderToken(Context context) {
        Preconditions.checkNotNull(context, "Context can not be null.");
        return DynamicLoaderFactory.makeLoader(context).createBidderTokenProviderApi().getBidderToken(context);
    }
}
