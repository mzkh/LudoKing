package com.facebook.appevents;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.util.Patterns;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo.Scope;
import com.facebook.FacebookSdk;
import com.facebook.internal.Utility;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

@RestrictTo({Scope.LIBRARY_GROUP})
public class UserDataStore {
    public static final String CITY = "ct";
    public static final String COUNTRY = "country";
    private static final String DATA_SEPARATOR = ",";
    public static final String DATE_OF_BIRTH = "db";
    public static final String EMAIL = "em";
    public static final String FIRST_NAME = "fn";
    public static final String GENDER = "ge";
    private static final String INTERNAL_USER_DATA_KEY = "com.facebook.appevents.UserDataStore.internalUserData";
    public static final String LAST_NAME = "ln";
    private static final int MAX_NUM = 5;
    public static final String PHONE = "ph";
    public static final String STATE = "st";
    /* access modifiers changed from: private */
    public static final String TAG = "UserDataStore";
    private static final String USER_DATA_KEY = "com.facebook.appevents.UserDataStore.userData";
    public static final String ZIP = "zp";
    /* access modifiers changed from: private */
    public static final ConcurrentHashMap<String, String> externalHashedUserData = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */
    public static AtomicBoolean initialized = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public static final ConcurrentHashMap<String, String> internalHashedUserData = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */
    public static SharedPreferences sharedPreferences;

    static void initStore() {
        if (!initialized.get()) {
            initAndWait();
        }
    }

    /* access modifiers changed from: private */
    public static void writeDataIntoCache(final String str, final String str2) {
        FacebookSdk.getExecutor().execute(new Runnable() {
            public void run() {
                if (!UserDataStore.initialized.get()) {
                    UserDataStore.initAndWait();
                }
                UserDataStore.sharedPreferences.edit().putString(str, str2).apply();
            }
        });
    }

    static void setUserDataAndHash(final Bundle bundle) {
        InternalAppEventsLogger.getAnalyticsExecutor().execute(new Runnable() {
            public void run() {
                if (!UserDataStore.initialized.get()) {
                    Log.w(UserDataStore.TAG, "initStore should have been called before calling setUserData");
                    UserDataStore.initAndWait();
                }
                UserDataStore.updateHashUserData(bundle);
                UserDataStore.writeDataIntoCache(UserDataStore.USER_DATA_KEY, Utility.mapToJsonStr(UserDataStore.externalHashedUserData));
                UserDataStore.writeDataIntoCache(UserDataStore.INTERNAL_USER_DATA_KEY, Utility.mapToJsonStr(UserDataStore.internalHashedUserData));
            }
        });
    }

    static void setUserDataAndHash(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10) {
        Bundle bundle = new Bundle();
        if (str != null) {
            bundle.putString(EMAIL, str);
        }
        if (str2 != null) {
            bundle.putString(FIRST_NAME, str2);
        }
        if (str3 != null) {
            bundle.putString(LAST_NAME, str3);
        }
        if (str4 != null) {
            bundle.putString(PHONE, str4);
        }
        if (str5 != null) {
            bundle.putString(DATE_OF_BIRTH, str5);
        }
        if (str6 != null) {
            bundle.putString(GENDER, str6);
        }
        if (str7 != null) {
            bundle.putString(CITY, str7);
        }
        if (str8 != null) {
            bundle.putString(STATE, str8);
        }
        if (str9 != null) {
            bundle.putString(ZIP, str9);
        }
        if (str10 != null) {
            bundle.putString(COUNTRY, str10);
        }
        setUserDataAndHash(bundle);
    }

    static void clear() {
        InternalAppEventsLogger.getAnalyticsExecutor().execute(new Runnable() {
            public void run() {
                if (!UserDataStore.initialized.get()) {
                    Log.w(UserDataStore.TAG, "initStore should have been called before calling setUserData");
                    UserDataStore.initAndWait();
                }
                UserDataStore.externalHashedUserData.clear();
                UserDataStore.sharedPreferences.edit().putString(UserDataStore.USER_DATA_KEY, null).apply();
            }
        });
    }

    public static void removeRules(List<String> list) {
        if (!initialized.get()) {
            initAndWait();
        }
        for (String str : list) {
            if (internalHashedUserData.containsKey(str)) {
                internalHashedUserData.remove(str);
            }
        }
        writeDataIntoCache(INTERNAL_USER_DATA_KEY, Utility.mapToJsonStr(internalHashedUserData));
    }

    static String getHashedUserData() {
        if (!initialized.get()) {
            Log.w(TAG, "initStore should have been called before calling setUserID");
            initAndWait();
        }
        return Utility.mapToJsonStr(externalHashedUserData);
    }

    public static String getAllHashedUserData() {
        if (!initialized.get()) {
            initAndWait();
        }
        HashMap hashMap = new HashMap();
        hashMap.putAll(externalHashedUserData);
        hashMap.putAll(internalHashedUserData);
        return Utility.mapToJsonStr(hashMap);
    }

    /* access modifiers changed from: private */
    public static synchronized void initAndWait() {
        synchronized (UserDataStore.class) {
            if (!initialized.get()) {
                sharedPreferences = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext());
                String string = sharedPreferences.getString(USER_DATA_KEY, "");
                String string2 = sharedPreferences.getString(INTERNAL_USER_DATA_KEY, "");
                externalHashedUserData.putAll(Utility.JsonStrToMap(string));
                internalHashedUserData.putAll(Utility.JsonStrToMap(string2));
                initialized.set(true);
            }
        }
    }

    public static Map<String, String> getInternalHashedUserData() {
        if (!initialized.get()) {
            initAndWait();
        }
        return new HashMap(internalHashedUserData);
    }

    /* access modifiers changed from: private */
    public static void updateHashUserData(Bundle bundle) {
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (obj != null) {
                    String obj2 = obj.toString();
                    if (maybeSHA256Hashed(obj2)) {
                        externalHashedUserData.put(str, obj2.toLowerCase());
                    } else {
                        String sha256hash = Utility.sha256hash(normalizeData(str, obj2));
                        if (sha256hash != null) {
                            externalHashedUserData.put(str, sha256hash);
                        }
                    }
                }
            }
        }
    }

    static void setInternalUd(Map<String, String> map) {
        String[] strArr;
        if (!initialized.get()) {
            initAndWait();
        }
        for (Entry key : map.entrySet()) {
            String str = (String) key.getKey();
            String sha256hash = Utility.sha256hash(normalizeData(str, ((String) map.get(str)).trim()));
            if (internalHashedUserData.containsKey(str)) {
                String str2 = (String) internalHashedUserData.get(str);
                String str3 = DATA_SEPARATOR;
                if (str2 != null) {
                    strArr = str2.split(str3);
                } else {
                    strArr = new String[0];
                }
                HashSet hashSet = new HashSet(Arrays.asList(strArr));
                if (!hashSet.contains(sha256hash)) {
                    StringBuilder sb = new StringBuilder();
                    if (strArr.length == 0) {
                        sb.append(sha256hash);
                    } else if (strArr.length < 5) {
                        sb.append(str2);
                        sb.append(str3);
                        sb.append(sha256hash);
                    } else {
                        for (int i = 1; i < 5; i++) {
                            sb.append(strArr[i]);
                            sb.append(str3);
                        }
                        sb.append(sha256hash);
                        hashSet.remove(strArr[0]);
                    }
                    internalHashedUserData.put(str, sb.toString());
                } else {
                    return;
                }
            } else {
                internalHashedUserData.put(str, sha256hash);
            }
        }
        writeDataIntoCache(INTERNAL_USER_DATA_KEY, Utility.mapToJsonStr(internalHashedUserData));
    }

    private static String normalizeData(String str, String str2) {
        String lowerCase = str2.trim().toLowerCase();
        String str3 = "";
        if (EMAIL.equals(str)) {
            if (Patterns.EMAIL_ADDRESS.matcher(lowerCase).matches()) {
                return lowerCase;
            }
            Log.e(TAG, "Setting email failure: this is not a valid email address");
            return str3;
        } else if (PHONE.equals(str)) {
            return lowerCase.replaceAll("[^0-9]", str3);
        } else {
            if (!GENDER.equals(str)) {
                return lowerCase;
            }
            String substring = lowerCase.length() > 0 ? lowerCase.substring(0, 1) : str3;
            if ("f".equals(substring) || "m".equals(substring)) {
                return substring;
            }
            Log.e(TAG, "Setting gender failure: the supported value for gender is f or m");
            return str3;
        }
    }

    private static boolean maybeSHA256Hashed(String str) {
        return str.matches("[A-Fa-f0-9]{64}");
    }
}
