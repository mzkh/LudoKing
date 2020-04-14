package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzwy;
import com.google.android.gms.internal.ads.zzwz;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Date;
import java.util.List;
import java.util.Set;

@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class PublisherAdRequest {
    public static final String DEVICE_ID_EMULATOR = "B3EEABB8EE11C2BE770B684D95219ECB";
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;
    public static final int GENDER_FEMALE = 2;
    public static final int GENDER_MALE = 1;
    public static final int GENDER_UNKNOWN = 0;
    @Deprecated
    public static final String MAX_AD_CONTENT_RATING_G = "G";
    @Deprecated
    public static final String MAX_AD_CONTENT_RATING_MA = "MA";
    @Deprecated
    public static final String MAX_AD_CONTENT_RATING_PG = "PG";
    @Deprecated
    public static final String MAX_AD_CONTENT_RATING_T = "T";
    @Deprecated
    public static final int TAG_FOR_UNDER_AGE_OF_CONSENT_FALSE = 0;
    @Deprecated
    public static final int TAG_FOR_UNDER_AGE_OF_CONSENT_TRUE = 1;
    @Deprecated
    public static final int TAG_FOR_UNDER_AGE_OF_CONSENT_UNSPECIFIED = -1;
    private final zzwz zzaaz;

    @VisibleForTesting
    /* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
    public static final class Builder {
        /* access modifiers changed from: private */
        public final zzwy zzabb = new zzwy();

        public final Builder addKeyword(String str) {
            this.zzabb.zzca(str);
            return this;
        }

        public final Builder addNetworkExtras(NetworkExtras networkExtras) {
            this.zzabb.zza(networkExtras);
            return this;
        }

        public final Builder addNetworkExtrasBundle(Class<? extends MediationExtrasReceiver> cls, Bundle bundle) {
            this.zzabb.zza(cls, bundle);
            return this;
        }

        public final Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> cls, Bundle bundle) {
            this.zzabb.zzb(cls, bundle);
            return this;
        }

        public final Builder addTestDevice(String str) {
            this.zzabb.zzcb(str);
            return this;
        }

        public final PublisherAdRequest build() {
            return new PublisherAdRequest(this);
        }

        @Deprecated
        public final Builder setBirthday(Date date) {
            this.zzabb.zza(date);
            return this;
        }

        public final Builder setContentUrl(String str) {
            Preconditions.checkNotNull(str, "Content URL must be non-null.");
            Preconditions.checkNotEmpty(str, "Content URL must be non-empty.");
            Preconditions.checkArgument(str.length() <= 512, "Content URL must not exceed %d in length.  Provided length was %d.", Integer.valueOf(512), Integer.valueOf(str.length()));
            this.zzabb.zzcd(str);
            return this;
        }

        @Deprecated
        public final Builder setGender(int i) {
            this.zzabb.zzcg(i);
            return this;
        }

        public final Builder setLocation(Location location) {
            this.zzabb.zza(location);
            return this;
        }

        @Deprecated
        public final Builder setManualImpressionsEnabled(boolean z) {
            this.zzabb.setManualImpressionsEnabled(z);
            return this;
        }

        public final Builder setPublisherProvidedId(String str) {
            this.zzabb.zzce(str);
            return this;
        }

        public final Builder setRequestAgent(String str) {
            this.zzabb.zzcf(str);
            return this;
        }

        @Deprecated
        public final Builder tagForChildDirectedTreatment(boolean z) {
            this.zzabb.zzs(z);
            return this;
        }

        public final Builder addCustomTargeting(String str, String str2) {
            this.zzabb.zzg(str, str2);
            return this;
        }

        public final Builder addCustomTargeting(String str, List<String> list) {
            if (list != null) {
                this.zzabb.zzg(str, TextUtils.join(",", list));
            }
            return this;
        }

        public final Builder addCategoryExclusion(String str) {
            this.zzabb.zzcg(str);
            return this;
        }

        @Deprecated
        public final Builder setIsDesignedForFamilies(boolean z) {
            this.zzabb.zzt(z);
            return this;
        }

        @Deprecated
        public final Builder setTagForUnderAgeOfConsent(int i) {
            this.zzabb.zzch(i);
            return this;
        }

        @Deprecated
        public final Builder setMaxAdContentRating(String str) {
            this.zzabb.zzch(str);
            return this;
        }
    }

    @Deprecated
    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
    public @interface MaxAdContentRating {
    }

    @Deprecated
    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
    public @interface TagForUnderAgeOfConsent {
    }

    private PublisherAdRequest(Builder builder) {
        this.zzaaz = new zzwz(builder.zzabb);
    }

    @KeepForSdk
    @Deprecated
    public static void updateCorrelator() {
    }

    @Deprecated
    public final Date getBirthday() {
        return this.zzaaz.getBirthday();
    }

    public final String getContentUrl() {
        return this.zzaaz.getContentUrl();
    }

    @Deprecated
    public final int getGender() {
        return this.zzaaz.getGender();
    }

    public final Set<String> getKeywords() {
        return this.zzaaz.getKeywords();
    }

    public final Location getLocation() {
        return this.zzaaz.getLocation();
    }

    public final boolean getManualImpressionsEnabled() {
        return this.zzaaz.getManualImpressionsEnabled();
    }

    @Deprecated
    public final <T extends NetworkExtras> T getNetworkExtras(Class<T> cls) {
        return this.zzaaz.getNetworkExtras(cls);
    }

    public final <T extends MediationExtrasReceiver> Bundle getNetworkExtrasBundle(Class<T> cls) {
        return this.zzaaz.getNetworkExtrasBundle(cls);
    }

    public final <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> cls) {
        return this.zzaaz.getCustomEventExtrasBundle(cls);
    }

    public final String getPublisherProvidedId() {
        return this.zzaaz.getPublisherProvidedId();
    }

    public final boolean isTestDevice(Context context) {
        return this.zzaaz.isTestDevice(context);
    }

    public final Bundle getCustomTargeting() {
        return this.zzaaz.getCustomTargeting();
    }

    public final zzwz zzdb() {
        return this.zzaaz;
    }
}
