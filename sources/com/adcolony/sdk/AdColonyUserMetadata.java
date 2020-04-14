package com.adcolony.sdk;

import android.location.Location;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import org.json.JSONArray;
import org.json.JSONObject;

public class AdColonyUserMetadata {
    public static final String USER_EDUCATION_ASSOCIATES_DEGREE = "associates_degree";
    public static final String USER_EDUCATION_BACHELORS_DEGREE = "bachelors_degree";
    public static final String USER_EDUCATION_GRADE_SCHOOL = "grade_school";
    public static final String USER_EDUCATION_GRADUATE_DEGREE = "graduate_degree";
    public static final String USER_EDUCATION_HIGH_SCHOOL_DIPLOMA = "high_school_diploma";
    public static final String USER_EDUCATION_SOME_COLLEGE = "some_college";
    public static final String USER_EDUCATION_SOME_HIGH_SCHOOL = "some_high_school";
    public static final String USER_FEMALE = "female";
    public static final String USER_MALE = "male";
    public static final String USER_MARRIED = "married";
    public static final String USER_SINGLE = "single";

    /* renamed from: a */
    static final int f126a = 128;

    /* renamed from: b */
    JSONArray f127b = C0746u.m909b();

    /* renamed from: c */
    JSONObject f128c = C0746u.m892a();

    /* renamed from: d */
    Location f129d;

    public AdColonyUserMetadata setUserGender(@NonNull String str) {
        if (C0543at.m325d(str)) {
            setMetadata("adc_gender", str);
        }
        return this;
    }

    public String getUserGender() {
        return C0746u.m908b(this.f128c, "adc_gender");
    }

    public AdColonyUserMetadata setUserAge(@IntRange(from = 0, mo668to = 130) int i) {
        setMetadata("adc_age", (double) i);
        return this;
    }

    public int getUserAge() {
        return C0746u.m914c(this.f128c, "adc_age");
    }

    public AdColonyUserMetadata setUserMaritalStatus(@NonNull String str) {
        if (C0543at.m325d(str)) {
            setMetadata("adc_marital_status", str);
        }
        return this;
    }

    public String getUserMaritalStatus() {
        return C0746u.m908b(this.f128c, "adc_marital_status");
    }

    public AdColonyUserMetadata setUserAnnualHouseholdIncome(@IntRange(from = 0) int i) {
        setMetadata("adc_household_income", (double) i);
        return this;
    }

    public int getUserAnnualHouseholdIncome() {
        return C0746u.m914c(this.f128c, "adc_household_income");
    }

    public AdColonyUserMetadata setUserEducation(@NonNull String str) {
        if (C0543at.m325d(str)) {
            setMetadata("adc_education", str);
        }
        return this;
    }

    public String getUserEducation() {
        return C0746u.m908b(this.f128c, "adc_education");
    }

    public AdColonyUserMetadata setUserZipCode(@NonNull String str) {
        if (C0543at.m325d(str)) {
            setMetadata("adc_zip", str);
        }
        return this;
    }

    public String getUserZipCode() {
        return C0746u.m908b(this.f128c, "adc_zip");
    }

    public AdColonyUserMetadata setUserLocation(@NonNull Location location) {
        this.f129d = location;
        setMetadata("adc_longitude", location.getLongitude());
        setMetadata("adc_latitude", location.getLatitude());
        setMetadata("adc_speed", (double) location.getSpeed());
        setMetadata("adc_altitude", location.getAltitude());
        setMetadata("adc_time", (double) location.getTime());
        setMetadata("adc_accuracy", (double) location.getAccuracy());
        return this;
    }

    public Location getUserLocation() {
        return this.f129d;
    }

    public AdColonyUserMetadata addUserInterest(@NonNull String str) {
        if (C0543at.m325d(str)) {
            C0746u.m898a(this.f127b, str);
            C0746u.m903a(this.f128c, "adc_interests", this.f127b);
        }
        return this;
    }

    public AdColonyUserMetadata clearUserInterests() {
        this.f127b = C0746u.m909b();
        C0746u.m903a(this.f128c, "adc_interests", this.f127b);
        return this;
    }

    public String[] getUserInterests() {
        String[] strArr = new String[this.f127b.length()];
        for (int i = 0; i < this.f127b.length(); i++) {
            strArr[i] = C0746u.m915c(this.f127b, i);
        }
        return strArr;
    }

    public AdColonyUserMetadata setMetadata(@NonNull String str, boolean z) {
        if (C0543at.m325d(str)) {
            C0746u.m913b(this.f128c, str, z);
        }
        return this;
    }

    public Object getMetadata(@NonNull String str) {
        return C0746u.m889a(this.f128c, str);
    }

    public AdColonyUserMetadata setMetadata(@NonNull String str, double d) {
        if (C0543at.m325d(str)) {
            C0746u.m900a(this.f128c, str, d);
        }
        return this;
    }

    public AdColonyUserMetadata setMetadata(@NonNull String str, @NonNull String str2) {
        if (C0543at.m325d(str2) && C0543at.m325d(str)) {
            C0746u.m902a(this.f128c, str, str2);
        }
        return this;
    }
}
