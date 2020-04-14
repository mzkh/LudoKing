package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzty {
    public static final zzty zzccl = new zzty();

    @VisibleForTesting
    protected zzty() {
    }

    public static zztx zza(Context context, zzwz zzwz) {
        List list;
        Context context2;
        String str;
        zzwz zzwz2 = zzwz;
        Date birthday = zzwz.getBirthday();
        long time = birthday != null ? birthday.getTime() : -1;
        String contentUrl = zzwz.getContentUrl();
        int gender = zzwz.getGender();
        Set keywords = zzwz.getKeywords();
        if (!keywords.isEmpty()) {
            list = Collections.unmodifiableList(new ArrayList(keywords));
            context2 = context;
        } else {
            context2 = context;
            list = null;
        }
        boolean isTestDevice = zzwz2.isTestDevice(context2);
        Location location = zzwz.getLocation();
        Bundle networkExtrasBundle = zzwz2.getNetworkExtrasBundle(AdMobAdapter.class);
        boolean manualImpressionsEnabled = zzwz.getManualImpressionsEnabled();
        String publisherProvidedId = zzwz.getPublisherProvidedId();
        SearchAdRequest zzpb = zzwz.zzpb();
        zzyf zzyf = zzpb != null ? new zzyf(zzpb) : null;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            String packageName = applicationContext.getPackageName();
            zzuv.zzoj();
            str = zzawy.zza(Thread.currentThread().getStackTrace(), packageName);
        } else {
            str = null;
        }
        boolean isDesignedForFamilies = zzwz.isDesignedForFamilies();
        RequestConfiguration requestConfiguration = zzxc.zzph().getRequestConfiguration();
        zztx zztx = new zztx(8, time, networkExtrasBundle, gender, list, isTestDevice, Math.max(zzwz.zzpe(), requestConfiguration.getTagForChildDirectedTreatment()), manualImpressionsEnabled, publisherProvidedId, zzyf, location, contentUrl, zzwz.zzpd(), zzwz.getCustomTargeting(), Collections.unmodifiableList(new ArrayList(zzwz.zzpf())), zzwz.zzpa(), str, isDesignedForFamilies, null, Math.max(zzwz.zzpg(), requestConfiguration.getTagForUnderAgeOfConsent()), (String) Collections.max(Arrays.asList(new String[]{zzwz.getMaxAdContentRating(), requestConfiguration.getMaxAdContentRating()}), zzub.zzcct));
        return zztx;
    }

    public static zzaqo zza(Context context, zzwz zzwz, String str) {
        return new zzaqo(zza(context, zzwz), str);
    }

    static final /* synthetic */ int zzf(String str, String str2) {
        return RequestConfiguration.zzabm.indexOf(str) - RequestConfiguration.zzabm.indexOf(str2);
    }
}
