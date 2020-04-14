package com.google.ads.mediation.inmobi;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdConfiguration;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.inmobi.sdk.InMobiSdk;
import com.inmobi.sdk.InMobiSdk.AgeGroup;
import com.inmobi.sdk.InMobiSdk.Education;
import com.inmobi.sdk.InMobiSdk.Gender;
import com.inmobi.sdk.InMobiSdk.LogLevel;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;

class InMobiAdapterUtils {
    static final String KEY_ACCOUNT_ID = "accountid";
    static final String KEY_PLACEMENT_ID = "placementid";

    InMobiAdapterUtils() {
    }

    static void setGlobalTargeting(MediationAdRequest mediationAdRequest, Bundle bundle) {
        configureGlobalTargeting(bundle);
        if (mediationAdRequest.getLocation() != null) {
            InMobiSdk.setLocation(mediationAdRequest.getLocation());
        }
        if (mediationAdRequest.getBirthday() != null) {
            Calendar instance = Calendar.getInstance();
            instance.setTime(mediationAdRequest.getBirthday());
            InMobiSdk.setYearOfBirth(instance.get(1));
        }
        if (mediationAdRequest.getGender() != -1) {
            int gender = mediationAdRequest.getGender();
            if (gender == 1) {
                InMobiSdk.setGender(Gender.MALE);
            } else if (gender == 2) {
                InMobiSdk.setGender(Gender.FEMALE);
            }
        }
    }

    static void setGlobalTargeting(MediationRewardedAdConfiguration mediationRewardedAdConfiguration, Bundle bundle) {
        configureGlobalTargeting(bundle);
        if (mediationRewardedAdConfiguration.getLocation() != null) {
            InMobiSdk.setLocation(mediationRewardedAdConfiguration.getLocation());
        }
    }

    private static void configureGlobalTargeting(Bundle bundle) {
        if (bundle == null) {
            Log.d("InMobiAdapter", "Bundle extras are null");
            bundle = new Bundle();
        }
        String str = "";
        String str2 = str;
        String str3 = str2;
        String str4 = str3;
        for (String str5 : bundle.keySet()) {
            String string = bundle.getString(str5);
            if (str5.equals(InMobiNetworkKeys.AREA_CODE)) {
                if (!str.equals(string)) {
                    InMobiSdk.setAreaCode(string);
                }
            } else if (str5.equals(InMobiNetworkKeys.AGE)) {
                try {
                    if (!str.equals(string)) {
                        InMobiSdk.setAge(Integer.parseInt(string));
                    }
                } catch (NumberFormatException e) {
                    Log.d("Please Set age properly", e.getMessage());
                }
            } else if (str5.equals(InMobiNetworkKeys.POSTAL_CODE)) {
                if (!str.equals(string)) {
                    InMobiSdk.setPostalCode(string);
                }
            } else if (str5.equals(InMobiNetworkKeys.LANGUAGE)) {
                if (!str.equals(string)) {
                    InMobiSdk.setLanguage(string);
                }
            } else if (str5.equals(InMobiNetworkKeys.CITY)) {
                str2 = string;
            } else if (str5.equals(InMobiNetworkKeys.STATE)) {
                str3 = string;
            } else if (str5.equals(InMobiNetworkKeys.COUNTRY)) {
                str4 = string;
            } else if (str5.equals(InMobiNetworkKeys.AGE_GROUP)) {
                if (string != null) {
                    AgeGroup ageGroup = getAgeGroup(string);
                    if (ageGroup != null) {
                        InMobiSdk.setAgeGroup(ageGroup);
                    }
                }
            } else if (str5.equals(InMobiNetworkKeys.EDUCATION)) {
                if (string != null) {
                    Education education = getEducation(string);
                    if (education != null) {
                        InMobiSdk.setEducation(education);
                    }
                }
            } else if (str5.equals(InMobiNetworkKeys.LOGLEVEL)) {
                if (string != null) {
                    InMobiSdk.setLogLevel(getLogLevel(string));
                } else {
                    InMobiSdk.setLogLevel(LogLevel.NONE);
                }
            } else if (str5.equals(InMobiNetworkKeys.INTERESTS)) {
                InMobiSdk.setInterests(string);
            }
        }
        if (VERSION.SDK_INT >= 19 && !Objects.equals(str2, str) && !Objects.equals(str3, str) && !Objects.equals(str4, str)) {
            InMobiSdk.setLocationWithCityStateCountry(str2, str3, str4);
        }
    }

    static HashMap<String, String> createInMobiParameterMap(MediationAdRequest mediationAdRequest) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("tp", "c_admob");
        String str = "coppa";
        if (mediationAdRequest.taggedForChildDirectedTreatment() == 1) {
            hashMap.put(str, "1");
        } else {
            hashMap.put(str, AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        return hashMap;
    }

    static HashMap<String, String> createInMobiParameterMap(MediationAdConfiguration mediationAdConfiguration) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("tp", "c_admob");
        String str = "coppa";
        if (mediationAdConfiguration.taggedForChildDirectedTreatment() == 1) {
            hashMap.put(str, "1");
        } else {
            hashMap.put(str, AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        return hashMap;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.inmobi.sdk.InMobiSdk.AgeGroup getAgeGroup(java.lang.String r1) {
        /*
            int r0 = r1.hashCode()
            switch(r0) {
                case -2144603857: goto L_0x004e;
                case -1892470079: goto L_0x0044;
                case -1873932011: goto L_0x003a;
                case -1017207884: goto L_0x0030;
                case -337149426: goto L_0x0026;
                case 1346187892: goto L_0x001c;
                case 1470305006: goto L_0x0012;
                case 1723710283: goto L_0x0008;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x0058
        L_0x0008:
            java.lang.String r0 = "BETWEEN_18_AND_24"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0058
            r1 = 2
            goto L_0x0059
        L_0x0012:
            java.lang.String r0 = "BETWEEN_35_AND_44"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0058
            r1 = 5
            goto L_0x0059
        L_0x001c:
            java.lang.String r0 = "BETWEEN_30_AND_34"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0058
            r1 = 4
            goto L_0x0059
        L_0x0026:
            java.lang.String r0 = "BETWEEN_45_AND_54"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0058
            r1 = 6
            goto L_0x0059
        L_0x0030:
            java.lang.String r0 = "BETWEEN_25_AND_29"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0058
            r1 = 3
            goto L_0x0059
        L_0x003a:
            java.lang.String r0 = "BELOW_18"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0058
            r1 = 1
            goto L_0x0059
        L_0x0044:
            java.lang.String r0 = "ABOVE_65"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0058
            r1 = 0
            goto L_0x0059
        L_0x004e:
            java.lang.String r0 = "BETWEEN_55_AND_65"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0058
            r1 = 7
            goto L_0x0059
        L_0x0058:
            r1 = -1
        L_0x0059:
            switch(r1) {
                case 0: goto L_0x0073;
                case 1: goto L_0x0070;
                case 2: goto L_0x006d;
                case 3: goto L_0x006a;
                case 4: goto L_0x0067;
                case 5: goto L_0x0064;
                case 6: goto L_0x0061;
                case 7: goto L_0x005e;
                default: goto L_0x005c;
            }
        L_0x005c:
            r1 = 0
            return r1
        L_0x005e:
            com.inmobi.sdk.InMobiSdk$AgeGroup r1 = com.inmobi.sdk.InMobiSdk.AgeGroup.BETWEEN_55_AND_65
            return r1
        L_0x0061:
            com.inmobi.sdk.InMobiSdk$AgeGroup r1 = com.inmobi.sdk.InMobiSdk.AgeGroup.BETWEEN_45_AND_54
            return r1
        L_0x0064:
            com.inmobi.sdk.InMobiSdk$AgeGroup r1 = com.inmobi.sdk.InMobiSdk.AgeGroup.BETWEEN_35_AND_44
            return r1
        L_0x0067:
            com.inmobi.sdk.InMobiSdk$AgeGroup r1 = com.inmobi.sdk.InMobiSdk.AgeGroup.BETWEEN_30_AND_34
            return r1
        L_0x006a:
            com.inmobi.sdk.InMobiSdk$AgeGroup r1 = com.inmobi.sdk.InMobiSdk.AgeGroup.BETWEEN_25_AND_29
            return r1
        L_0x006d:
            com.inmobi.sdk.InMobiSdk$AgeGroup r1 = com.inmobi.sdk.InMobiSdk.AgeGroup.BETWEEN_18_AND_24
            return r1
        L_0x0070:
            com.inmobi.sdk.InMobiSdk$AgeGroup r1 = com.inmobi.sdk.InMobiSdk.AgeGroup.BELOW_18
            return r1
        L_0x0073:
            com.inmobi.sdk.InMobiSdk$AgeGroup r1 = com.inmobi.sdk.InMobiSdk.AgeGroup.ABOVE_65
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.mediation.inmobi.InMobiAdapterUtils.getAgeGroup(java.lang.String):com.inmobi.sdk.InMobiSdk$AgeGroup");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0043  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.inmobi.sdk.InMobiSdk.Education getEducation(java.lang.String r4) {
        /*
            int r0 = r4.hashCode()
            r1 = -2023680018(0xffffffff876117ee, float:-1.6934151E-34)
            r2 = 2
            r3 = 1
            if (r0 == r1) goto L_0x002a
            r1 = 1302797304(0x4da71bf8, float:3.50453504E8)
            if (r0 == r1) goto L_0x0020
            r1 = 1522352361(0x5abd40e9, float:2.663507E16)
            if (r0 == r1) goto L_0x0016
            goto L_0x0034
        L_0x0016:
            java.lang.String r0 = "EDUCATION_HIGHSCHOOLORLESS"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0034
            r4 = 1
            goto L_0x0035
        L_0x0020:
            java.lang.String r0 = "EDUCATION_POSTGRADUATEORABOVE"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0034
            r4 = 2
            goto L_0x0035
        L_0x002a:
            java.lang.String r0 = "EDUCATION_COLLEGEORGRADUATE"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0034
            r4 = 0
            goto L_0x0035
        L_0x0034:
            r4 = -1
        L_0x0035:
            if (r4 == 0) goto L_0x0043
            if (r4 == r3) goto L_0x0040
            if (r4 == r2) goto L_0x003d
            r4 = 0
            return r4
        L_0x003d:
            com.inmobi.sdk.InMobiSdk$Education r4 = com.inmobi.sdk.InMobiSdk.Education.POST_GRADUATE_OR_ABOVE
            return r4
        L_0x0040:
            com.inmobi.sdk.InMobiSdk$Education r4 = com.inmobi.sdk.InMobiSdk.Education.HIGH_SCHOOL_OR_LESS
            return r4
        L_0x0043:
            com.inmobi.sdk.InMobiSdk$Education r4 = com.inmobi.sdk.InMobiSdk.Education.COLLEGE_OR_GRADUATE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.mediation.inmobi.InMobiAdapterUtils.getEducation(java.lang.String):com.inmobi.sdk.InMobiSdk$Education");
    }

    private static LogLevel getLogLevel(String str) {
        if (str.equals(InMobiNetworkValues.LOGLEVEL_DEBUG)) {
            return LogLevel.DEBUG;
        }
        if (str.equals(InMobiNetworkValues.LOGLEVEL_ERROR)) {
            return LogLevel.ERROR;
        }
        if (str.equals(InMobiNetworkValues.LOGLEVEL_NONE)) {
            return LogLevel.NONE;
        }
        return LogLevel.NONE;
    }

    static <T> T mandatoryChecking(@Nullable T t, String str) throws MandatoryParamException {
        if (t != null && !t.toString().isEmpty()) {
            return t;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Mandatory param ");
        sb.append(str);
        sb.append(" not present");
        throw new MandatoryParamException(sb.toString());
    }

    public static AdSize findClosestSize(Context context, AdSize adSize, ArrayList<AdSize> arrayList) {
        AdSize adSize2 = null;
        if (!(arrayList == null || adSize == null)) {
            float f = context.getResources().getDisplayMetrics().density;
            AdSize adSize3 = new AdSize(Math.round(((float) adSize.getWidthInPixels(context)) / f), Math.round(((float) adSize.getHeightInPixels(context)) / f));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                AdSize adSize4 = (AdSize) it.next();
                if (isSizeInRange(adSize3, adSize4)) {
                    if (adSize2 != null) {
                        adSize4 = getLargerByArea(adSize2, adSize4);
                    }
                    adSize2 = adSize4;
                }
            }
        }
        return adSize2;
    }

    private static boolean isSizeInRange(AdSize adSize, AdSize adSize2) {
        if (adSize2 == null) {
            return false;
        }
        int width = adSize.getWidth();
        int width2 = adSize2.getWidth();
        int height = adSize.getHeight();
        int height2 = adSize2.getHeight();
        double d = (double) width;
        Double.isNaN(d);
        if (d * 0.5d <= ((double) width2) && width >= width2) {
            double d2 = (double) height;
            Double.isNaN(d2);
            if (d2 * 0.7d <= ((double) height2) && height >= height2) {
                return true;
            }
        }
        return false;
    }

    private static AdSize getLargerByArea(AdSize adSize, AdSize adSize2) {
        return adSize.getWidth() * adSize.getHeight() > adSize2.getWidth() * adSize2.getHeight() ? adSize : adSize2;
    }
}
