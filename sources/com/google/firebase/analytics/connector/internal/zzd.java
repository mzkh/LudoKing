package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.AppMeasurement.UserProperty;
import com.google.android.gms.measurement.internal.zzho;
import com.google.firebase.analytics.FirebaseAnalytics.Event;
import com.google.firebase.analytics.connector.AnalyticsConnector.ConditionalUserProperty;
import com.tapjoy.TapjoyConstants;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class zzd {
    private static final Set<String> zzacl = new HashSet(Arrays.asList(new String[]{"_in", "_xa", "_xu", "_aq", "_aa", "_ai", "_ac", Event.CAMPAIGN_DETAILS, "_ug", "_iapx", "_exp_set", "_exp_clear", "_exp_activate", "_exp_timeout", "_exp_expire"}));
    private static final List<String> zzacm = Arrays.asList(new String[]{"_e", "_f", "_iap", "_s", "_au", "_ui", "_cd", Event.APP_OPEN});
    private static final List<String> zzacn = Arrays.asList(new String[]{"auto", TapjoyConstants.TJC_APP_PLACEMENT, "am"});
    private static final List<String> zzaco = Arrays.asList(new String[]{"_r", "_dbg"});
    private static final List<String> zzacp = Arrays.asList((String[]) ArrayUtils.concat(UserProperty.zzpp, UserProperty.zzpq));
    private static final List<String> zzacq = Arrays.asList(new String[]{"^_ltv_[A-Z]{3}$", "^_cc[1-5]{1}$"});

    public static boolean zzdj(@NonNull String str) {
        return !zzacn.contains(str);
    }

    public static boolean zza(@NonNull String str, @Nullable Bundle bundle) {
        if (zzacm.contains(str)) {
            return false;
        }
        if (bundle != null) {
            for (String containsKey : zzaco) {
                if (bundle.containsKey(containsKey)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean zzdk(@NonNull String str) {
        return !zzacl.contains(str);
    }

    public static boolean zzu(@NonNull String str, @NonNull String str2) {
        String str3 = "fcm";
        if ("_ce1".equals(str2) || "_ce2".equals(str2)) {
            return str.equals(str3) || str.equals("frc");
        }
        if (UserProperty.FIREBASE_LAST_NOTIFICATION.equals(str2)) {
            return str.equals(str3) || str.equals("fiam");
        }
        if (zzacp.contains(str2)) {
            return false;
        }
        for (String matches : zzacq) {
            if (str2.matches(matches)) {
                return false;
            }
        }
        return true;
    }

    public static boolean zza(ConditionalUserProperty conditionalUserProperty) {
        if (conditionalUserProperty == null) {
            return false;
        }
        String str = conditionalUserProperty.origin;
        if (str == null || str.isEmpty()) {
            return false;
        }
        if ((conditionalUserProperty.value != null && zzho.zza(conditionalUserProperty.value) == null) || !zzdj(str) || !zzu(str, conditionalUserProperty.name)) {
            return false;
        }
        if (conditionalUserProperty.expiredEventName != null && (!zza(conditionalUserProperty.expiredEventName, conditionalUserProperty.expiredEventParams) || !zzb(str, conditionalUserProperty.expiredEventName, conditionalUserProperty.expiredEventParams))) {
            return false;
        }
        if (conditionalUserProperty.triggeredEventName != null && (!zza(conditionalUserProperty.triggeredEventName, conditionalUserProperty.triggeredEventParams) || !zzb(str, conditionalUserProperty.triggeredEventName, conditionalUserProperty.triggeredEventParams))) {
            return false;
        }
        if (conditionalUserProperty.timedOutEventName == null || (zza(conditionalUserProperty.timedOutEventName, conditionalUserProperty.timedOutEventParams) && zzb(str, conditionalUserProperty.timedOutEventName, conditionalUserProperty.timedOutEventParams))) {
            return true;
        }
        return false;
    }

    public static boolean zzb(@NonNull String str, @NonNull String str2, @Nullable Bundle bundle) {
        if (!"_cmp".equals(str2)) {
            return true;
        }
        if (!zzdj(str) || bundle == null) {
            return false;
        }
        for (String containsKey : zzaco) {
            if (bundle.containsKey(containsKey)) {
                return false;
            }
        }
        char c = 65535;
        int hashCode = str.hashCode();
        if (hashCode != 101200) {
            if (hashCode != 101230) {
                if (hashCode == 3142703 && str.equals("fiam")) {
                    c = 2;
                }
            } else if (str.equals("fdl")) {
                c = 1;
            }
        } else if (str.equals("fcm")) {
            c = 0;
        }
        String str3 = "_cis";
        if (c == 0) {
            bundle.putString(str3, "fcm_integration");
            return true;
        } else if (c == 1) {
            bundle.putString(str3, "fdl_integration");
            return true;
        } else if (c != 2) {
            return false;
        } else {
            bundle.putString(str3, "fiam_integration");
            return true;
        }
    }

    public static AppMeasurement.ConditionalUserProperty zzb(ConditionalUserProperty conditionalUserProperty) {
        AppMeasurement.ConditionalUserProperty conditionalUserProperty2 = new AppMeasurement.ConditionalUserProperty();
        conditionalUserProperty2.mOrigin = conditionalUserProperty.origin;
        conditionalUserProperty2.mActive = conditionalUserProperty.active;
        conditionalUserProperty2.mCreationTimestamp = conditionalUserProperty.creationTimestamp;
        conditionalUserProperty2.mExpiredEventName = conditionalUserProperty.expiredEventName;
        if (conditionalUserProperty.expiredEventParams != null) {
            conditionalUserProperty2.mExpiredEventParams = new Bundle(conditionalUserProperty.expiredEventParams);
        }
        conditionalUserProperty2.mName = conditionalUserProperty.name;
        conditionalUserProperty2.mTimedOutEventName = conditionalUserProperty.timedOutEventName;
        if (conditionalUserProperty.timedOutEventParams != null) {
            conditionalUserProperty2.mTimedOutEventParams = new Bundle(conditionalUserProperty.timedOutEventParams);
        }
        conditionalUserProperty2.mTimeToLive = conditionalUserProperty.timeToLive;
        conditionalUserProperty2.mTriggeredEventName = conditionalUserProperty.triggeredEventName;
        if (conditionalUserProperty.triggeredEventParams != null) {
            conditionalUserProperty2.mTriggeredEventParams = new Bundle(conditionalUserProperty.triggeredEventParams);
        }
        conditionalUserProperty2.mTriggeredTimestamp = conditionalUserProperty.triggeredTimestamp;
        conditionalUserProperty2.mTriggerEventName = conditionalUserProperty.triggerEventName;
        conditionalUserProperty2.mTriggerTimeout = conditionalUserProperty.triggerTimeout;
        if (conditionalUserProperty.value != null) {
            conditionalUserProperty2.mValue = zzho.zza(conditionalUserProperty.value);
        }
        return conditionalUserProperty2;
    }

    public static ConditionalUserProperty zzb(AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        ConditionalUserProperty conditionalUserProperty2 = new ConditionalUserProperty();
        conditionalUserProperty2.origin = conditionalUserProperty.mOrigin;
        conditionalUserProperty2.active = conditionalUserProperty.mActive;
        conditionalUserProperty2.creationTimestamp = conditionalUserProperty.mCreationTimestamp;
        conditionalUserProperty2.expiredEventName = conditionalUserProperty.mExpiredEventName;
        if (conditionalUserProperty.mExpiredEventParams != null) {
            conditionalUserProperty2.expiredEventParams = new Bundle(conditionalUserProperty.mExpiredEventParams);
        }
        conditionalUserProperty2.name = conditionalUserProperty.mName;
        conditionalUserProperty2.timedOutEventName = conditionalUserProperty.mTimedOutEventName;
        if (conditionalUserProperty.mTimedOutEventParams != null) {
            conditionalUserProperty2.timedOutEventParams = new Bundle(conditionalUserProperty.mTimedOutEventParams);
        }
        conditionalUserProperty2.timeToLive = conditionalUserProperty.mTimeToLive;
        conditionalUserProperty2.triggeredEventName = conditionalUserProperty.mTriggeredEventName;
        if (conditionalUserProperty.mTriggeredEventParams != null) {
            conditionalUserProperty2.triggeredEventParams = new Bundle(conditionalUserProperty.mTriggeredEventParams);
        }
        conditionalUserProperty2.triggeredTimestamp = conditionalUserProperty.mTriggeredTimestamp;
        conditionalUserProperty2.triggerEventName = conditionalUserProperty.mTriggerEventName;
        conditionalUserProperty2.triggerTimeout = conditionalUserProperty.mTriggerTimeout;
        if (conditionalUserProperty.mValue != null) {
            conditionalUserProperty2.value = zzho.zza(conditionalUserProperty.mValue);
        }
        return conditionalUserProperty2;
    }

    public static boolean zzdl(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        int codePointAt = str.codePointAt(0);
        if (!Character.isLetter(codePointAt)) {
            return false;
        }
        int length = str.length();
        int charCount = Character.charCount(codePointAt);
        while (charCount < length) {
            int codePointAt2 = str.codePointAt(charCount);
            if (codePointAt2 != 95 && !Character.isLetterOrDigit(codePointAt2)) {
                return false;
            }
            charCount += Character.charCount(codePointAt2);
        }
        return true;
    }

    public static boolean zzdm(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        int codePointAt = str.codePointAt(0);
        if (!Character.isLetter(codePointAt) && codePointAt != 95) {
            return false;
        }
        int length = str.length();
        int charCount = Character.charCount(codePointAt);
        while (charCount < length) {
            int codePointAt2 = str.codePointAt(charCount);
            if (codePointAt2 != 95 && !Character.isLetterOrDigit(codePointAt2)) {
                return false;
            }
            charCount += Character.charCount(codePointAt2);
        }
        return true;
    }

    public static String zzdn(String str) {
        String zzbf = AppMeasurement.Event.zzbf(str);
        return zzbf != null ? zzbf : str;
    }

    public static String zzdo(String str) {
        String zzbe = AppMeasurement.Event.zzbe(str);
        return zzbe != null ? zzbe : str;
    }
}
