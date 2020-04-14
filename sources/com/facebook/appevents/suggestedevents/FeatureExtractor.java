package com.facebook.appevents.suggestedevents;

import android.util.Patterns;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.tapjoy.TJAdUnitConstants.String;
import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class FeatureExtractor {
    private static final int NUM_OF_FEATURES = 30;
    private static final String REGEX_ADD_TO_CART_BUTTON_TEXT = "(?i)add to(\\s|\\Z)|update(\\s|\\Z)|cart";
    private static final String REGEX_ADD_TO_CART_PAGE_TITLE = "(?i)add to(\\s|\\Z)|update(\\s|\\Z)|cart|shop|buy";
    private static final String REGEX_CR_HAS_CONFIRM_PASSWORD_FIELD = "(?i)(confirm.*password)|(password.*(confirmation|confirm)|confirmation)";
    private static final String REGEX_CR_HAS_LOG_IN_KEYWORDS = "(?i)(sign in)|login|signIn";
    private static final String REGEX_CR_HAS_SIGN_ON_KEYWORDS = "(?i)(sign.*(up|now)|registration|register|(create|apply).*(profile|account)|open.*account|account.*(open|creation|application)|enroll|join.*now)";
    private static final String REGEX_CR_PASSWORD_FIELD = "password";
    private static Map<String, String> eventInfo = null;
    private static boolean initialized = false;
    private static Map<String, String> languageInfo;
    private static JSONObject rules;
    private static Map<String, String> textTypeInfo;

    FeatureExtractor() {
    }

    static void initialize(File file) {
        try {
            rules = new JSONObject();
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            fileInputStream.close();
            rules = new JSONObject(new String(bArr, "UTF-8"));
            languageInfo = new HashMap();
            String str = "1";
            languageInfo.put(ViewHierarchyConstants.ENGLISH, str);
            String str2 = "2";
            languageInfo.put(ViewHierarchyConstants.GERMAN, str2);
            Map<String, String> map = languageInfo;
            String str3 = ExifInterface.GPS_MEASUREMENT_3D;
            map.put(ViewHierarchyConstants.SPANISH, str3);
            String str4 = "4";
            languageInfo.put(ViewHierarchyConstants.JAPANESE, str4);
            eventInfo = new HashMap();
            eventInfo.put(ViewHierarchyConstants.VIEW_CONTENT, AppEventsConstants.EVENT_PARAM_VALUE_NO);
            eventInfo.put(ViewHierarchyConstants.SEARCH, str);
            eventInfo.put(ViewHierarchyConstants.ADD_TO_CART, str2);
            eventInfo.put(ViewHierarchyConstants.ADD_TO_WISHLIST, str3);
            eventInfo.put(ViewHierarchyConstants.INITIATE_CHECKOUT, str4);
            eventInfo.put(ViewHierarchyConstants.ADD_PAYMENT_INFO, "5");
            eventInfo.put(ViewHierarchyConstants.PURCHASE, "6");
            eventInfo.put(ViewHierarchyConstants.LEAD, "7");
            eventInfo.put(ViewHierarchyConstants.COMPLETE_REGISTRATION, "8");
            textTypeInfo = new HashMap();
            textTypeInfo.put(ViewHierarchyConstants.BUTTON_TEXT, str);
            textTypeInfo.put(ViewHierarchyConstants.PAGE_TITLE, str2);
            textTypeInfo.put(ViewHierarchyConstants.RESOLVED_DOCUMENT_LINK, str3);
            textTypeInfo.put(ViewHierarchyConstants.BUTTON_ID, str4);
            initialized = true;
        } catch (Exception unused) {
        }
    }

    static boolean isInitialized() {
        return initialized;
    }

    static String getTextFeature(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append(str3);
        sb.append(" | ");
        sb.append(str2);
        sb.append(", ");
        sb.append(str);
        return sb.toString().toLowerCase();
    }

    @Nullable
    static float[] getDenseFeatures(JSONObject jSONObject, String str) {
        if (!initialized) {
            return null;
        }
        float[] fArr = new float[30];
        Arrays.fill(fArr, 0.0f);
        try {
            String lowerCase = str.toLowerCase();
            JSONObject jSONObject2 = new JSONObject(jSONObject.optJSONObject(ViewHierarchyConstants.VIEW_KEY).toString());
            String optString = jSONObject.optString(ViewHierarchyConstants.SCREEN_NAME_KEY);
            JSONArray jSONArray = new JSONArray();
            pruneTree(jSONObject2, jSONArray);
            sum(fArr, parseFeatures(jSONObject2));
            JSONObject interactedNode = getInteractedNode(jSONObject2);
            if (interactedNode == null) {
                return null;
            }
            sum(fArr, nonparseFeatures(interactedNode, jSONArray, optString, jSONObject2.toString(), lowerCase));
            return fArr;
        } catch (JSONException unused) {
        }
    }

    private static float[] parseFeatures(JSONObject jSONObject) {
        float[] fArr = new float[30];
        Arrays.fill(fArr, 0.0f);
        String lowerCase = jSONObject.optString(ViewHierarchyConstants.TEXT_KEY).toLowerCase();
        String lowerCase2 = jSONObject.optString(ViewHierarchyConstants.HINT_KEY).toLowerCase();
        String lowerCase3 = jSONObject.optString(ViewHierarchyConstants.CLASS_NAME_KEY).toLowerCase();
        int optInt = jSONObject.optInt(ViewHierarchyConstants.INPUT_TYPE_KEY, -1);
        String[] strArr = {lowerCase, lowerCase2};
        if (matchIndicators(new String[]{"$", "amount", "price", "total"}, strArr)) {
            double d = (double) fArr[0];
            Double.isNaN(d);
            fArr[0] = (float) (d + 1.0d);
        }
        if (matchIndicators(new String[]{REGEX_CR_PASSWORD_FIELD, "pwd"}, strArr)) {
            double d2 = (double) fArr[1];
            Double.isNaN(d2);
            fArr[1] = (float) (d2 + 1.0d);
        }
        if (matchIndicators(new String[]{"tel", "phone"}, strArr)) {
            double d3 = (double) fArr[2];
            Double.isNaN(d3);
            fArr[2] = (float) (d3 + 1.0d);
        }
        if (matchIndicators(new String[]{"search"}, strArr)) {
            double d4 = (double) fArr[4];
            Double.isNaN(d4);
            fArr[4] = (float) (d4 + 1.0d);
        }
        if (optInt >= 0) {
            double d5 = (double) fArr[5];
            Double.isNaN(d5);
            fArr[5] = (float) (d5 + 1.0d);
        }
        if (optInt == 3 || optInt == 2) {
            double d6 = (double) fArr[6];
            Double.isNaN(d6);
            fArr[6] = (float) (d6 + 1.0d);
        }
        if (optInt == 32 || Patterns.EMAIL_ADDRESS.matcher(lowerCase).matches()) {
            double d7 = (double) fArr[7];
            Double.isNaN(d7);
            fArr[7] = (float) (d7 + 1.0d);
        }
        if (lowerCase3.contains("checkbox")) {
            double d8 = (double) fArr[8];
            Double.isNaN(d8);
            fArr[8] = (float) (d8 + 1.0d);
        }
        if (matchIndicators(new String[]{String.VIDEO_COMPLETE, "confirm", "done", "submit"}, new String[]{lowerCase})) {
            double d9 = (double) fArr[10];
            Double.isNaN(d9);
            fArr[10] = (float) (d9 + 1.0d);
        }
        if (lowerCase3.contains("radio") && lowerCase3.contains("button")) {
            double d10 = (double) fArr[12];
            Double.isNaN(d10);
            fArr[12] = (float) (d10 + 1.0d);
        }
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray(ViewHierarchyConstants.CHILDREN_VIEW_KEY);
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                sum(fArr, parseFeatures(optJSONArray.getJSONObject(i)));
            }
        } catch (JSONException unused) {
        }
        return fArr;
    }

    private static float[] nonparseFeatures(JSONObject jSONObject, JSONArray jSONArray, String str, String str2, String str3) {
        float[] fArr = new float[30];
        float f = 0.0f;
        Arrays.fill(fArr, 0.0f);
        int length = jSONArray.length();
        int i = 0;
        fArr[3] = (float) (length > 1 ? length - 1 : 0);
        while (i < jSONArray.length()) {
            try {
                if (isButton(jSONArray.getJSONObject(i))) {
                    fArr[9] = fArr[9] + 1.0f;
                }
                i++;
            } catch (JSONException unused) {
            }
        }
        fArr[13] = -1.0f;
        fArr[14] = -1.0f;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append('|');
        sb.append(str3);
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = new StringBuilder();
        updateHintAndTextRecursively(jSONObject, sb3, sb4);
        String sb5 = sb3.toString();
        String sb6 = sb4.toString();
        String str4 = ViewHierarchyConstants.BUTTON_TEXT;
        String str5 = ViewHierarchyConstants.COMPLETE_REGISTRATION;
        String str6 = ViewHierarchyConstants.ENGLISH;
        fArr[15] = regexMatched(str6, str5, str4, sb6) ? 1.0f : 0.0f;
        String str7 = ViewHierarchyConstants.PAGE_TITLE;
        fArr[16] = regexMatched(str6, str5, str7, sb2) ? 1.0f : 0.0f;
        fArr[17] = regexMatched(str6, str5, ViewHierarchyConstants.BUTTON_ID, sb5) ? 1.0f : 0.0f;
        fArr[18] = str2.contains(REGEX_CR_PASSWORD_FIELD) ? 1.0f : 0.0f;
        fArr[19] = regexMatched(REGEX_CR_HAS_CONFIRM_PASSWORD_FIELD, str2) ? 1.0f : 0.0f;
        fArr[20] = regexMatched(REGEX_CR_HAS_LOG_IN_KEYWORDS, str2) ? 1.0f : 0.0f;
        fArr[21] = regexMatched(REGEX_CR_HAS_SIGN_ON_KEYWORDS, str2) ? 1.0f : 0.0f;
        String str8 = ViewHierarchyConstants.PURCHASE;
        fArr[22] = regexMatched(str6, str8, str4, sb6) ? 1.0f : 0.0f;
        fArr[24] = regexMatched(str6, str8, str7, sb2) ? 1.0f : 0.0f;
        fArr[25] = regexMatched(REGEX_ADD_TO_CART_BUTTON_TEXT, sb6) ? 1.0f : 0.0f;
        fArr[27] = regexMatched(REGEX_ADD_TO_CART_PAGE_TITLE, sb2) ? 1.0f : 0.0f;
        String str9 = ViewHierarchyConstants.LEAD;
        fArr[28] = regexMatched(str6, str9, str4, sb6) ? 1.0f : 0.0f;
        if (regexMatched(str6, str9, str7, sb2)) {
            f = 1.0f;
        }
        fArr[29] = f;
        return fArr;
    }

    private static boolean regexMatched(String str, String str2, String str3, String str4) {
        return regexMatched(rules.optJSONObject("rulesForLanguage").optJSONObject((String) languageInfo.get(str)).optJSONObject("rulesForEvent").optJSONObject((String) eventInfo.get(str2)).optJSONObject("positiveRules").optString((String) textTypeInfo.get(str3)), str4);
    }

    private static boolean regexMatched(String str, String str2) {
        return Pattern.compile(str).matcher(str2).find();
    }

    private static boolean matchIndicators(String[] strArr, String[] strArr2) {
        for (String str : strArr) {
            for (String contains : strArr2) {
                if (contains.contains(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean pruneTree(JSONObject jSONObject, JSONArray jSONArray) {
        boolean z;
        boolean z2;
        String str = ViewHierarchyConstants.CHILDREN_VIEW_KEY;
        String str2 = ViewHierarchyConstants.IS_INTERACTED_KEY;
        try {
            if (jSONObject.optBoolean(str2)) {
                return true;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray(str);
            int i = 0;
            while (true) {
                if (i >= optJSONArray.length()) {
                    z = false;
                    z2 = false;
                    break;
                } else if (optJSONArray.getJSONObject(i).optBoolean(str2)) {
                    z = true;
                    z2 = true;
                    break;
                } else {
                    i++;
                }
            }
            JSONArray jSONArray2 = new JSONArray();
            if (z) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    jSONArray.put(optJSONArray.getJSONObject(i2));
                }
            } else {
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                    if (pruneTree(jSONObject2, jSONArray)) {
                        jSONArray2.put(jSONObject2);
                        z2 = true;
                    }
                }
                jSONObject.put(str, jSONArray2);
            }
            return z2;
        } catch (JSONException unused) {
            return false;
        }
    }

    private static void sum(float[] fArr, float[] fArr2) {
        for (int i = 0; i < fArr.length; i++) {
            fArr[i] = fArr[i] + fArr2[i];
        }
    }

    private static boolean isButton(JSONObject jSONObject) {
        return (jSONObject.optInt(ViewHierarchyConstants.CLASS_TYPE_BITMASK_KEY) & 32) > 0;
    }

    private static void updateHintAndTextRecursively(JSONObject jSONObject, StringBuilder sb, StringBuilder sb2) {
        String str = "";
        String lowerCase = jSONObject.optString(ViewHierarchyConstants.TEXT_KEY, str).toLowerCase();
        String lowerCase2 = jSONObject.optString(ViewHierarchyConstants.HINT_KEY, str).toLowerCase();
        String str2 = " ";
        if (!lowerCase.isEmpty()) {
            sb.append(lowerCase);
            sb.append(str2);
        }
        if (!lowerCase2.isEmpty()) {
            sb2.append(lowerCase2);
            sb2.append(str2);
        }
        JSONArray optJSONArray = jSONObject.optJSONArray(ViewHierarchyConstants.CHILDREN_VIEW_KEY);
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                updateHintAndTextRecursively(jSONObject, sb, sb2);
            }
        }
    }

    @Nullable
    private static JSONObject getInteractedNode(JSONObject jSONObject) {
        try {
            if (jSONObject.optBoolean(ViewHierarchyConstants.IS_INTERACTED_KEY)) {
                return jSONObject;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray(ViewHierarchyConstants.CHILDREN_VIEW_KEY);
            if (optJSONArray == null) {
                return null;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject interactedNode = getInteractedNode(optJSONArray.getJSONObject(i));
                if (interactedNode != null) {
                    return interactedNode;
                }
            }
            return null;
        } catch (JSONException unused) {
        }
    }
}
