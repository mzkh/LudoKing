package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.tapjoy.TJAdUnitConstants.String;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class LegacyTokenHelper {
    public static final String APPLICATION_ID_KEY = "com.facebook.TokenCachingStrategy.ApplicationId";
    public static final String DECLINED_PERMISSIONS_KEY = "com.facebook.TokenCachingStrategy.DeclinedPermissions";
    public static final String DEFAULT_CACHE_KEY = "com.facebook.SharedPreferencesTokenCachingStrategy.DEFAULT_KEY";
    public static final String EXPIRATION_DATE_KEY = "com.facebook.TokenCachingStrategy.ExpirationDate";
    public static final String EXPIRED_PERMISSIONS_KEY = "com.facebook.TokenCachingStrategy.ExpiredPermissions";
    private static final long INVALID_BUNDLE_MILLISECONDS = Long.MIN_VALUE;
    private static final String IS_SSO_KEY = "com.facebook.TokenCachingStrategy.IsSSO";
    private static final String JSON_VALUE = "value";
    private static final String JSON_VALUE_ENUM_TYPE = "enumType";
    private static final String JSON_VALUE_TYPE = "valueType";
    public static final String LAST_REFRESH_DATE_KEY = "com.facebook.TokenCachingStrategy.LastRefreshDate";
    public static final String PERMISSIONS_KEY = "com.facebook.TokenCachingStrategy.Permissions";
    private static final String TAG = "LegacyTokenHelper";
    public static final String TOKEN_KEY = "com.facebook.TokenCachingStrategy.Token";
    public static final String TOKEN_SOURCE_KEY = "com.facebook.TokenCachingStrategy.AccessTokenSource";
    private static final String TYPE_BOOLEAN = "bool";
    private static final String TYPE_BOOLEAN_ARRAY = "bool[]";
    private static final String TYPE_BYTE = "byte";
    private static final String TYPE_BYTE_ARRAY = "byte[]";
    private static final String TYPE_CHAR = "char";
    private static final String TYPE_CHAR_ARRAY = "char[]";
    private static final String TYPE_DOUBLE = "double";
    private static final String TYPE_DOUBLE_ARRAY = "double[]";
    private static final String TYPE_ENUM = "enum";
    private static final String TYPE_FLOAT = "float";
    private static final String TYPE_FLOAT_ARRAY = "float[]";
    private static final String TYPE_INTEGER = "int";
    private static final String TYPE_INTEGER_ARRAY = "int[]";
    private static final String TYPE_LONG = "long";
    private static final String TYPE_LONG_ARRAY = "long[]";
    private static final String TYPE_SHORT = "short";
    private static final String TYPE_SHORT_ARRAY = "short[]";
    private static final String TYPE_STRING = "string";
    private static final String TYPE_STRING_LIST = "stringList";
    private SharedPreferences cache;
    private String cacheKey;

    public LegacyTokenHelper(Context context) {
        this(context, null);
    }

    public LegacyTokenHelper(Context context, String str) {
        Validate.notNull(context, "context");
        if (Utility.isNullOrEmpty(str)) {
            str = DEFAULT_CACHE_KEY;
        }
        this.cacheKey = str;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        this.cache = context.getSharedPreferences(this.cacheKey, 0);
    }

    public Bundle load() {
        Bundle bundle = new Bundle();
        for (String str : this.cache.getAll().keySet()) {
            try {
                deserializeKey(str, bundle);
            } catch (JSONException e) {
                LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
                String str2 = TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("Error reading cached value for key: '");
                sb.append(str);
                sb.append("' -- ");
                sb.append(e);
                Logger.log(loggingBehavior, 5, str2, sb.toString());
                return null;
            }
        }
        return bundle;
    }

    public void save(Bundle bundle) {
        Validate.notNull(bundle, String.BUNDLE);
        Editor edit = this.cache.edit();
        for (String str : bundle.keySet()) {
            try {
                serializeKey(str, bundle, edit);
            } catch (JSONException e) {
                LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
                String str2 = TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("Error processing value for key: '");
                sb.append(str);
                sb.append("' -- ");
                sb.append(e);
                Logger.log(loggingBehavior, 5, str2, sb.toString());
                return;
            }
        }
        edit.apply();
    }

    public void clear() {
        this.cache.edit().clear().apply();
    }

    public static boolean hasTokenInformation(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        String string = bundle.getString(TOKEN_KEY);
        if (string == null || string.length() == 0 || bundle.getLong(EXPIRATION_DATE_KEY, 0) == 0) {
            return false;
        }
        return true;
    }

    public static String getToken(Bundle bundle) {
        Validate.notNull(bundle, String.BUNDLE);
        return bundle.getString(TOKEN_KEY);
    }

    public static void putToken(Bundle bundle, String str) {
        Validate.notNull(bundle, String.BUNDLE);
        Validate.notNull(str, "value");
        bundle.putString(TOKEN_KEY, str);
    }

    public static Date getExpirationDate(Bundle bundle) {
        Validate.notNull(bundle, String.BUNDLE);
        return getDate(bundle, EXPIRATION_DATE_KEY);
    }

    public static void putExpirationDate(Bundle bundle, Date date) {
        Validate.notNull(bundle, String.BUNDLE);
        Validate.notNull(date, "value");
        putDate(bundle, EXPIRATION_DATE_KEY, date);
    }

    public static long getExpirationMilliseconds(Bundle bundle) {
        Validate.notNull(bundle, String.BUNDLE);
        return bundle.getLong(EXPIRATION_DATE_KEY);
    }

    public static void putExpirationMilliseconds(Bundle bundle, long j) {
        Validate.notNull(bundle, String.BUNDLE);
        bundle.putLong(EXPIRATION_DATE_KEY, j);
    }

    public static Set<String> getPermissions(Bundle bundle) {
        Validate.notNull(bundle, String.BUNDLE);
        ArrayList stringArrayList = bundle.getStringArrayList(PERMISSIONS_KEY);
        if (stringArrayList == null) {
            return null;
        }
        return new HashSet(stringArrayList);
    }

    public static void putPermissions(Bundle bundle, Collection<String> collection) {
        Validate.notNull(bundle, String.BUNDLE);
        Validate.notNull(collection, "value");
        bundle.putStringArrayList(PERMISSIONS_KEY, new ArrayList(collection));
    }

    public static void putDeclinedPermissions(Bundle bundle, Collection<String> collection) {
        Validate.notNull(bundle, String.BUNDLE);
        Validate.notNull(collection, "value");
        bundle.putStringArrayList(DECLINED_PERMISSIONS_KEY, new ArrayList(collection));
    }

    public static void putExpiredPermissions(Bundle bundle, Collection<String> collection) {
        Validate.notNull(bundle, String.BUNDLE);
        Validate.notNull(collection, "value");
        bundle.putStringArrayList(EXPIRED_PERMISSIONS_KEY, new ArrayList(collection));
    }

    public static AccessTokenSource getSource(Bundle bundle) {
        Validate.notNull(bundle, String.BUNDLE);
        String str = TOKEN_SOURCE_KEY;
        if (bundle.containsKey(str)) {
            return (AccessTokenSource) bundle.getSerializable(str);
        }
        return bundle.getBoolean(IS_SSO_KEY) ? AccessTokenSource.FACEBOOK_APPLICATION_WEB : AccessTokenSource.WEB_VIEW;
    }

    public static void putSource(Bundle bundle, AccessTokenSource accessTokenSource) {
        Validate.notNull(bundle, String.BUNDLE);
        bundle.putSerializable(TOKEN_SOURCE_KEY, accessTokenSource);
    }

    public static Date getLastRefreshDate(Bundle bundle) {
        Validate.notNull(bundle, String.BUNDLE);
        return getDate(bundle, LAST_REFRESH_DATE_KEY);
    }

    public static void putLastRefreshDate(Bundle bundle, Date date) {
        Validate.notNull(bundle, String.BUNDLE);
        Validate.notNull(date, "value");
        putDate(bundle, LAST_REFRESH_DATE_KEY, date);
    }

    public static long getLastRefreshMilliseconds(Bundle bundle) {
        Validate.notNull(bundle, String.BUNDLE);
        return bundle.getLong(LAST_REFRESH_DATE_KEY);
    }

    public static void putLastRefreshMilliseconds(Bundle bundle, long j) {
        Validate.notNull(bundle, String.BUNDLE);
        bundle.putLong(LAST_REFRESH_DATE_KEY, j);
    }

    public static String getApplicationId(Bundle bundle) {
        Validate.notNull(bundle, String.BUNDLE);
        return bundle.getString(APPLICATION_ID_KEY);
    }

    public static void putApplicationId(Bundle bundle, String str) {
        Validate.notNull(bundle, String.BUNDLE);
        bundle.putString(APPLICATION_ID_KEY, str);
    }

    static Date getDate(Bundle bundle, String str) {
        if (bundle == null) {
            return null;
        }
        long j = bundle.getLong(str, INVALID_BUNDLE_MILLISECONDS);
        if (j == INVALID_BUNDLE_MILLISECONDS) {
            return null;
        }
        return new Date(j);
    }

    static void putDate(Bundle bundle, String str, Date date) {
        bundle.putLong(str, date.getTime());
    }

    private void serializeKey(String str, Bundle bundle, Editor editor) throws JSONException {
        Object obj;
        String str2;
        Object obj2 = bundle.get(str);
        if (obj2 != null) {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = null;
            String str3 = "value";
            if (obj2 instanceof Byte) {
                jSONObject.put(str3, ((Byte) obj2).intValue());
                obj = TYPE_BYTE;
            } else if (obj2 instanceof Short) {
                jSONObject.put(str3, ((Short) obj2).intValue());
                obj = TYPE_SHORT;
            } else if (obj2 instanceof Integer) {
                jSONObject.put(str3, ((Integer) obj2).intValue());
                obj = TYPE_INTEGER;
            } else if (obj2 instanceof Long) {
                jSONObject.put(str3, ((Long) obj2).longValue());
                obj = TYPE_LONG;
            } else if (obj2 instanceof Float) {
                jSONObject.put(str3, ((Float) obj2).doubleValue());
                obj = TYPE_FLOAT;
            } else if (obj2 instanceof Double) {
                jSONObject.put(str3, ((Double) obj2).doubleValue());
                obj = TYPE_DOUBLE;
            } else if (obj2 instanceof Boolean) {
                jSONObject.put(str3, ((Boolean) obj2).booleanValue());
                obj = TYPE_BOOLEAN;
            } else if (obj2 instanceof Character) {
                jSONObject.put(str3, obj2.toString());
                obj = TYPE_CHAR;
            } else if (obj2 instanceof String) {
                jSONObject.put(str3, (String) obj2);
                obj = TYPE_STRING;
            } else if (obj2 instanceof Enum) {
                jSONObject.put(str3, obj2.toString());
                jSONObject.put(JSON_VALUE_ENUM_TYPE, obj2.getClass().getName());
                obj = TYPE_ENUM;
            } else {
                JSONArray jSONArray2 = new JSONArray();
                int i = 0;
                if (obj2 instanceof byte[]) {
                    byte[] bArr = (byte[]) obj2;
                    int length = bArr.length;
                    while (i < length) {
                        jSONArray2.put(bArr[i]);
                        i++;
                    }
                    str2 = TYPE_BYTE_ARRAY;
                } else if (obj2 instanceof short[]) {
                    short[] sArr = (short[]) obj2;
                    int length2 = sArr.length;
                    while (i < length2) {
                        jSONArray2.put(sArr[i]);
                        i++;
                    }
                    str2 = TYPE_SHORT_ARRAY;
                } else if (obj2 instanceof int[]) {
                    int[] iArr = (int[]) obj2;
                    int length3 = iArr.length;
                    while (i < length3) {
                        jSONArray2.put(iArr[i]);
                        i++;
                    }
                    str2 = TYPE_INTEGER_ARRAY;
                } else if (obj2 instanceof long[]) {
                    long[] jArr = (long[]) obj2;
                    int length4 = jArr.length;
                    while (i < length4) {
                        jSONArray2.put(jArr[i]);
                        i++;
                    }
                    str2 = TYPE_LONG_ARRAY;
                } else if (obj2 instanceof float[]) {
                    float[] fArr = (float[]) obj2;
                    int length5 = fArr.length;
                    while (i < length5) {
                        jSONArray2.put((double) fArr[i]);
                        i++;
                    }
                    str2 = TYPE_FLOAT_ARRAY;
                } else if (obj2 instanceof double[]) {
                    double[] dArr = (double[]) obj2;
                    int length6 = dArr.length;
                    while (i < length6) {
                        jSONArray2.put(dArr[i]);
                        i++;
                    }
                    str2 = TYPE_DOUBLE_ARRAY;
                } else if (obj2 instanceof boolean[]) {
                    boolean[] zArr = (boolean[]) obj2;
                    int length7 = zArr.length;
                    while (i < length7) {
                        jSONArray2.put(zArr[i]);
                        i++;
                    }
                    str2 = TYPE_BOOLEAN_ARRAY;
                } else if (obj2 instanceof char[]) {
                    char[] cArr = (char[]) obj2;
                    int length8 = cArr.length;
                    while (i < length8) {
                        jSONArray2.put(String.valueOf(cArr[i]));
                        i++;
                    }
                    str2 = TYPE_CHAR_ARRAY;
                } else if (obj2 instanceof List) {
                    for (Object obj3 : (List) obj2) {
                        if (obj3 == null) {
                            obj3 = JSONObject.NULL;
                        }
                        jSONArray2.put(obj3);
                    }
                    str2 = TYPE_STRING_LIST;
                } else {
                    obj = null;
                }
                obj = str2;
                jSONArray = jSONArray2;
            }
            if (obj != null) {
                jSONObject.put(JSON_VALUE_TYPE, obj);
                if (jSONArray != null) {
                    jSONObject.putOpt(str3, jSONArray);
                }
                editor.putString(str, jSONObject.toString());
            }
        }
    }

    private void deserializeKey(String str, Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject(this.cache.getString(str, "{}"));
        String string = jSONObject.getString(JSON_VALUE_TYPE);
        String str2 = "value";
        if (string.equals(TYPE_BOOLEAN)) {
            bundle.putBoolean(str, jSONObject.getBoolean(str2));
            return;
        }
        int i = 0;
        if (string.equals(TYPE_BOOLEAN_ARRAY)) {
            JSONArray jSONArray = jSONObject.getJSONArray(str2);
            boolean[] zArr = new boolean[jSONArray.length()];
            while (i < zArr.length) {
                zArr[i] = jSONArray.getBoolean(i);
                i++;
            }
            bundle.putBooleanArray(str, zArr);
        } else if (string.equals(TYPE_BYTE)) {
            bundle.putByte(str, (byte) jSONObject.getInt(str2));
        } else if (string.equals(TYPE_BYTE_ARRAY)) {
            JSONArray jSONArray2 = jSONObject.getJSONArray(str2);
            byte[] bArr = new byte[jSONArray2.length()];
            while (i < bArr.length) {
                bArr[i] = (byte) jSONArray2.getInt(i);
                i++;
            }
            bundle.putByteArray(str, bArr);
        } else if (string.equals(TYPE_SHORT)) {
            bundle.putShort(str, (short) jSONObject.getInt(str2));
        } else if (string.equals(TYPE_SHORT_ARRAY)) {
            JSONArray jSONArray3 = jSONObject.getJSONArray(str2);
            short[] sArr = new short[jSONArray3.length()];
            while (i < sArr.length) {
                sArr[i] = (short) jSONArray3.getInt(i);
                i++;
            }
            bundle.putShortArray(str, sArr);
        } else if (string.equals(TYPE_INTEGER)) {
            bundle.putInt(str, jSONObject.getInt(str2));
        } else if (string.equals(TYPE_INTEGER_ARRAY)) {
            JSONArray jSONArray4 = jSONObject.getJSONArray(str2);
            int[] iArr = new int[jSONArray4.length()];
            while (i < iArr.length) {
                iArr[i] = jSONArray4.getInt(i);
                i++;
            }
            bundle.putIntArray(str, iArr);
        } else if (string.equals(TYPE_LONG)) {
            bundle.putLong(str, jSONObject.getLong(str2));
        } else if (string.equals(TYPE_LONG_ARRAY)) {
            JSONArray jSONArray5 = jSONObject.getJSONArray(str2);
            long[] jArr = new long[jSONArray5.length()];
            while (i < jArr.length) {
                jArr[i] = jSONArray5.getLong(i);
                i++;
            }
            bundle.putLongArray(str, jArr);
        } else if (string.equals(TYPE_FLOAT)) {
            bundle.putFloat(str, (float) jSONObject.getDouble(str2));
        } else if (string.equals(TYPE_FLOAT_ARRAY)) {
            JSONArray jSONArray6 = jSONObject.getJSONArray(str2);
            float[] fArr = new float[jSONArray6.length()];
            while (i < fArr.length) {
                fArr[i] = (float) jSONArray6.getDouble(i);
                i++;
            }
            bundle.putFloatArray(str, fArr);
        } else if (string.equals(TYPE_DOUBLE)) {
            bundle.putDouble(str, jSONObject.getDouble(str2));
        } else if (string.equals(TYPE_DOUBLE_ARRAY)) {
            JSONArray jSONArray7 = jSONObject.getJSONArray(str2);
            double[] dArr = new double[jSONArray7.length()];
            while (i < dArr.length) {
                dArr[i] = jSONArray7.getDouble(i);
                i++;
            }
            bundle.putDoubleArray(str, dArr);
        } else if (string.equals(TYPE_CHAR)) {
            String string2 = jSONObject.getString(str2);
            if (string2 != null && string2.length() == 1) {
                bundle.putChar(str, string2.charAt(0));
            }
        } else if (string.equals(TYPE_CHAR_ARRAY)) {
            JSONArray jSONArray8 = jSONObject.getJSONArray(str2);
            char[] cArr = new char[jSONArray8.length()];
            for (int i2 = 0; i2 < cArr.length; i2++) {
                String string3 = jSONArray8.getString(i2);
                if (string3 != null && string3.length() == 1) {
                    cArr[i2] = string3.charAt(0);
                }
            }
            bundle.putCharArray(str, cArr);
        } else if (string.equals(TYPE_STRING)) {
            bundle.putString(str, jSONObject.getString(str2));
        } else if (string.equals(TYPE_STRING_LIST)) {
            JSONArray jSONArray9 = jSONObject.getJSONArray(str2);
            int length = jSONArray9.length();
            ArrayList arrayList = new ArrayList(length);
            while (i < length) {
                Object obj = jSONArray9.get(i);
                arrayList.add(i, obj == JSONObject.NULL ? null : (String) obj);
                i++;
            }
            bundle.putStringArrayList(str, arrayList);
        } else if (string.equals(TYPE_ENUM)) {
            try {
                bundle.putSerializable(str, Enum.valueOf(Class.forName(jSONObject.getString(JSON_VALUE_ENUM_TYPE)), jSONObject.getString(str2)));
            } catch (ClassNotFoundException | IllegalArgumentException unused) {
            }
        }
    }
}
