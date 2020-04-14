package com.facebook.unity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.AccessToken.AccessTokenRefreshCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.FacebookSdk.InitializeCallback;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.appevents.internal.AutomaticAnalyticsLogger;
import com.facebook.applinks.AppLinkData;
import com.facebook.applinks.AppLinkData.CompletionHandler;
import com.facebook.internal.BundleJSONConverter;
import com.facebook.internal.InternalSettings;
import com.facebook.internal.Utility;
import com.facebook.login.LoginManager;
import com.facebook.share.widget.ShareDialog.Mode;
import com.facebook.unity.FBUnityLoginActivity.LoginType;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Currency;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;

/* renamed from: com.facebook.unity.FB */
public class C1713FB {
    static final String FB_UNITY_OBJECT = "UnityFacebookSDKPlugin";
    static Mode ShareDialogMode = Mode.AUTOMATIC;
    static final String TAG = "com.facebook.unity.FB";
    private static AtomicBoolean activateAppCalled = new AtomicBoolean();
    private static AppEventsLogger appEventsLogger;
    private static Intent clearedIntent;
    private static Intent intent;

    private static AppEventsLogger getAppEventsLogger() {
        if (appEventsLogger == null) {
            appEventsLogger = AppEventsLogger.newLogger(getUnityActivity().getApplicationContext());
        }
        return appEventsLogger;
    }

    public static Activity getUnityActivity() {
        return UnityReflection.GetUnityActivity();
    }

    @UnityCallable
    public static void Init(String str) {
        final String str2;
        String str3 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("Init(");
        sb.append(str);
        sb.append(")");
        Log.v(str3, sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("couldn't parse init params: ");
        sb2.append(str);
        UnityParams parse = UnityParams.parse(str, sb2.toString());
        String str4 = "appId";
        if (parse.hasString(str4).booleanValue()) {
            str2 = parse.getString(str4);
        } else {
            str2 = Utility.getMetadataApplicationId(getUnityActivity());
        }
        FacebookSdk.setApplicationId(str2);
        FacebookSdk.sdkInitialize((Context) getUnityActivity(), (InitializeCallback) new InitializeCallback() {
            public void onInitialized() {
                UnityMessage unityMessage = new UnityMessage("OnInitComplete");
                AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
                if (currentAccessToken != null) {
                    FBLogin.addLoginParametersToMessage(unityMessage, currentAccessToken, null);
                } else {
                    unityMessage.put("key_hash", C1713FB.getKeyHash());
                }
                if (FacebookSdk.getAutoLogAppEventsEnabled()) {
                    C1713FB.ActivateApp(str2);
                }
                unityMessage.send();
            }
        });
    }

    @UnityCallable
    public static void LoginWithReadPermissions(String str) {
        String str2 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("LoginWithReadPermissions(");
        sb.append(str);
        sb.append(")");
        Log.v(str2, sb.toString());
        Intent intent2 = new Intent(getUnityActivity(), FBUnityLoginActivity.class);
        intent2.putExtra(FBUnityLoginActivity.LOGIN_PARAMS, str);
        intent2.putExtra(FBUnityLoginActivity.LOGIN_TYPE, LoginType.READ);
        getUnityActivity().startActivity(intent2);
    }

    @UnityCallable
    public static void LoginWithPublishPermissions(String str) {
        String str2 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("LoginWithPublishPermissions(");
        sb.append(str);
        sb.append(")");
        Log.v(str2, sb.toString());
        Intent intent2 = new Intent(getUnityActivity(), FBUnityLoginActivity.class);
        intent2.putExtra(FBUnityLoginActivity.LOGIN_PARAMS, str);
        intent2.putExtra(FBUnityLoginActivity.LOGIN_TYPE, LoginType.PUBLISH);
        getUnityActivity().startActivity(intent2);
    }

    @UnityCallable
    public static void Logout(String str) {
        String str2 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("Logout(");
        sb.append(str);
        sb.append(")");
        Log.v(str2, sb.toString());
        LoginManager.getInstance().logOut();
        UnityMessage unityMessage = new UnityMessage("OnLogoutComplete");
        unityMessage.put("did_complete", Boolean.valueOf(true));
        unityMessage.send();
    }

    @UnityCallable
    public static void loginForTVWithReadPermissions(String str) {
        String str2 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("loginForTVWithReadPermissions(");
        sb.append(str);
        sb.append(")");
        Log.v(str2, sb.toString());
        Intent intent2 = new Intent(getUnityActivity(), FBUnityLoginActivity.class);
        intent2.putExtra(FBUnityLoginActivity.LOGIN_PARAMS, str);
        intent2.putExtra(FBUnityLoginActivity.LOGIN_TYPE, LoginType.TV_READ);
        getUnityActivity().startActivity(intent2);
    }

    @UnityCallable
    public static void LoginForTVWithPublishPermissions(String str) {
        String str2 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("LoginForTVWithPublishPermissions(");
        sb.append(str);
        sb.append(")");
        Log.v(str2, sb.toString());
        Intent intent2 = new Intent(getUnityActivity(), FBUnityLoginActivity.class);
        intent2.putExtra(FBUnityLoginActivity.LOGIN_PARAMS, str);
        intent2.putExtra(FBUnityLoginActivity.LOGIN_TYPE, LoginType.TV_PUBLISH);
        getUnityActivity().startActivity(intent2);
    }

    @UnityCallable
    public static void AppRequest(String str) {
        String str2 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("AppRequest(");
        sb.append(str);
        sb.append(")");
        Log.v(str2, sb.toString());
        Intent intent2 = new Intent(getUnityActivity(), FBUnityGameRequestActivity.class);
        intent2.putExtra(FBUnityGameRequestActivity.GAME_REQUEST_PARAMS, UnityParams.parse(str).getStringParams());
        getUnityActivity().startActivity(intent2);
    }

    @UnityCallable
    public static void GameGroupCreate(String str) {
        String str2 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("GameGroupCreate(");
        sb.append(str);
        sb.append(")");
        Log.v(str2, sb.toString());
        Bundle stringParams = UnityParams.parse(str).getStringParams();
        Intent intent2 = new Intent(getUnityActivity(), FBUnityCreateGameGroupActivity.class);
        intent2.putExtra(FBUnityCreateGameGroupActivity.CREATE_GAME_GROUP_PARAMS, stringParams);
        getUnityActivity().startActivity(intent2);
    }

    @UnityCallable
    public static void GameGroupJoin(String str) {
        String str2 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("GameGroupJoin(");
        sb.append(str);
        sb.append(")");
        Log.v(str2, sb.toString());
        Bundle stringParams = UnityParams.parse(str).getStringParams();
        Intent intent2 = new Intent(getUnityActivity(), FBUnityJoinGameGroupActivity.class);
        intent2.putExtra(FBUnityJoinGameGroupActivity.JOIN_GAME_GROUP_PARAMS, stringParams);
        getUnityActivity().startActivity(intent2);
    }

    @UnityCallable
    public static void ShareLink(String str) {
        String str2 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("ShareLink(");
        sb.append(str);
        sb.append(")");
        Log.v(str2, sb.toString());
        Bundle stringParams = UnityParams.parse(str).getStringParams();
        Intent intent2 = new Intent(getUnityActivity(), FBUnityDialogsActivity.class);
        intent2.putExtra(FBUnityDialogsActivity.DIALOG_TYPE, ShareDialogMode);
        intent2.putExtra(FBUnityDialogsActivity.SHARE_DIALOG_PARAMS, stringParams);
        getUnityActivity().startActivity(intent2);
    }

    @UnityCallable
    public static void FeedShare(String str) {
        String str2 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("FeedShare(");
        sb.append(str);
        sb.append(")");
        Log.v(str2, sb.toString());
        Bundle stringParams = UnityParams.parse(str).getStringParams();
        Intent intent2 = new Intent(getUnityActivity(), FBUnityDialogsActivity.class);
        intent2.putExtra(FBUnityDialogsActivity.DIALOG_TYPE, Mode.FEED);
        intent2.putExtra(FBUnityDialogsActivity.FEED_DIALOG_PARAMS, stringParams);
        getUnityActivity().startActivity(intent2);
    }

    @UnityCallable
    public static void SetUserID(String str) {
        String str2 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("SetUserID(");
        sb.append(str);
        sb.append(")");
        Log.v(str2, sb.toString());
        AppEventsLogger.setUserID(str);
    }

    @UnityCallable
    public static String GetUserID() {
        return AppEventsLogger.getUserID();
    }

    @UnityCallable
    public static void UpdateUserProperties(String str) {
        String str2 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("UpdateUserProperties(");
        sb.append(str);
        sb.append(")");
        Log.v(str2, sb.toString());
        AppEventsLogger.updateUserProperties(UnityParams.parse(str).getStringParams(), null);
    }

    public static void SetIntent(Intent intent2) {
        intent = intent2;
    }

    public static void SetLimitEventUsage(String str) {
        String str2 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("SetLimitEventUsage(");
        sb.append(str);
        sb.append(")");
        Log.v(str2, sb.toString());
        FacebookSdk.setLimitEventAndDataUsage(getUnityActivity().getApplicationContext(), Boolean.valueOf(str).booleanValue());
    }

    @UnityCallable
    public static void LogAppEvent(String str) {
        String str2 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("LogAppEvent(");
        sb.append(str);
        sb.append(")");
        Log.v(str2, sb.toString());
        UnityParams parse = UnityParams.parse(str);
        Bundle bundle = new Bundle();
        String str3 = "parameters";
        if (parse.has(str3)) {
            bundle = parse.getParamsObject(str3).getStringParams();
        }
        String str4 = "logPurchase";
        if (parse.has(str4)) {
            getAppEventsLogger().logPurchase(new BigDecimal(parse.getDouble(str4)), Currency.getInstance(parse.getString("currency")), bundle);
            return;
        }
        String str5 = "logEvent";
        if (parse.hasString(str5).booleanValue()) {
            String str6 = "valueToSum";
            if (parse.has(str6)) {
                getAppEventsLogger().logEvent(parse.getString(str5), parse.getDouble(str6), bundle);
            } else {
                getAppEventsLogger().logEvent(parse.getString(str5), bundle);
            }
        } else {
            String str7 = TAG;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("couldn't logPurchase or logEvent params: ");
            sb2.append(str);
            Log.e(str7, sb2.toString());
        }
    }

    @UnityCallable
    public static boolean IsImplicitPurchaseLoggingEnabled() {
        return AutomaticAnalyticsLogger.isImplicitPurchaseLoggingEnabled();
    }

    @UnityCallable
    public static void SetShareDialogMode(String str) {
        String str2 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("SetShareDialogMode(");
        sb.append(str);
        sb.append(")");
        Log.v(str2, sb.toString());
        if (str.equalsIgnoreCase("NATIVE")) {
            ShareDialogMode = Mode.NATIVE;
        } else if (str.equalsIgnoreCase("WEB")) {
            ShareDialogMode = Mode.WEB;
        } else if (str.equalsIgnoreCase("FEED")) {
            ShareDialogMode = Mode.FEED;
        } else {
            ShareDialogMode = Mode.AUTOMATIC;
        }
    }

    @UnityCallable
    public static void SetAutoLogAppEventsEnabled(String str) {
        String str2 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("SetAutoLogAppEventsEnabled(");
        sb.append(str);
        sb.append(")");
        Log.v(str2, sb.toString());
        FacebookSdk.setAutoLogAppEventsEnabled(Boolean.valueOf(str).booleanValue());
    }

    @UnityCallable
    public static void SetAdvertiserIDCollectionEnabled(String str) {
        String str2 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("SetAdvertiserIDCollectionEnabled(");
        sb.append(str);
        sb.append(")");
        Log.v(str2, sb.toString());
        FacebookSdk.setAdvertiserIDCollectionEnabled(Boolean.valueOf(str).booleanValue());
    }

    @UnityCallable
    public static String GetSdkVersion() {
        return FacebookSdk.getSdkVersion();
    }

    @UnityCallable
    public static void SetUserAgentSuffix(String str) {
        String str2 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("SetUserAgentSuffix(");
        sb.append(str);
        sb.append(")");
        Log.v(str2, sb.toString());
        InternalSettings.setCustomUserAgent(str);
    }

    @UnityCallable
    public static void FetchDeferredAppLinkData(String str) {
        LogMethodCall("FetchDeferredAppLinkData", str);
        UnityParams parse = UnityParams.parse(str);
        final UnityMessage unityMessage = new UnityMessage("OnFetchDeferredAppLinkComplete");
        String str2 = Constants.CALLBACK_ID_KEY;
        if (parse.hasString(str2).booleanValue()) {
            unityMessage.put(str2, parse.getString(str2));
        }
        AppLinkData.fetchDeferredAppLinkData(getUnityActivity(), new CompletionHandler() {
            public void onDeferredAppLinkDataFetched(AppLinkData appLinkData) {
                C1713FB.addAppLinkToMessage(unityMessage, appLinkData);
                unityMessage.send();
            }
        });
    }

    @UnityCallable
    public static void GetAppLink(String str) {
        String str2 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("GetAppLink(");
        sb.append(str);
        sb.append(")");
        Log.v(str2, sb.toString());
        UnityMessage createWithCallbackFromParams = UnityMessage.createWithCallbackFromParams("OnGetAppLinkComplete", UnityParams.parse(str));
        Intent intent2 = intent;
        Boolean valueOf = Boolean.valueOf(true);
        String str3 = "did_complete";
        if (intent2 == null) {
            createWithCallbackFromParams.put(str3, valueOf);
            createWithCallbackFromParams.send();
        } else if (intent2 == clearedIntent) {
            createWithCallbackFromParams.put(str3, valueOf);
            createWithCallbackFromParams.send();
        } else {
            AppLinkData createFromAlApplinkData = AppLinkData.createFromAlApplinkData(intent2);
            String str4 = "url";
            if (createFromAlApplinkData != null) {
                addAppLinkToMessage(createWithCallbackFromParams, createFromAlApplinkData);
                createWithCallbackFromParams.put(str4, intent.getDataString());
            } else if (intent.getData() != null) {
                createWithCallbackFromParams.put(str4, intent.getDataString());
            } else {
                createWithCallbackFromParams.put(str3, valueOf);
            }
            createWithCallbackFromParams.send();
        }
    }

    @UnityCallable
    public static void ClearAppLink() {
        Log.v(TAG, "ClearAppLink");
        clearedIntent = intent;
    }

    @UnityCallable
    public static void RefreshCurrentAccessToken(String str) {
        LogMethodCall("RefreshCurrentAccessToken", str);
        UnityParams parse = UnityParams.parse(str);
        final UnityMessage unityMessage = new UnityMessage("OnRefreshCurrentAccessTokenComplete");
        String str2 = Constants.CALLBACK_ID_KEY;
        if (parse.hasString(str2).booleanValue()) {
            unityMessage.put(str2, parse.getString(str2));
        }
        AccessToken.refreshCurrentAccessTokenAsync(new AccessTokenRefreshCallback() {
            public void OnTokenRefreshed(AccessToken accessToken) {
                FBLogin.addLoginParametersToMessage(unityMessage, accessToken, null);
                unityMessage.send();
            }

            public void OnTokenRefreshFailed(FacebookException facebookException) {
                unityMessage.sendError(facebookException.getMessage());
            }
        });
    }

    @TargetApi(8)
    public static String getKeyHash() {
        String str = "";
        try {
            Activity unityActivity = getUnityActivity();
            if (unityActivity == null) {
                return str;
            }
            Signature[] signatureArr = unityActivity.getPackageManager().getPackageInfo(unityActivity.getPackageName(), 64).signatures;
            if (signatureArr.length > 0) {
                Signature signature = signatureArr[0];
                MessageDigest instance = MessageDigest.getInstance("SHA");
                instance.update(signature.toByteArray());
                String encodeToString = Base64.encodeToString(instance.digest(), 0);
                String str2 = TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("KeyHash: ");
                sb.append(encodeToString);
                Log.d(str2, sb.toString());
                return encodeToString;
            }
            return str;
        } catch (NameNotFoundException | NoSuchAlgorithmException unused) {
        }
    }

    @UnityCallable
    public static void ActivateApp() {
        AppEventsLogger.activateApp((Context) getUnityActivity());
    }

    /* access modifiers changed from: private */
    public static void ActivateApp(String str) {
        if (!activateAppCalled.compareAndSet(false, true)) {
            Log.w(TAG, "Activite app only needs to be called once");
            return;
        }
        final Activity unityActivity = getUnityActivity();
        if (str != null) {
            AppEventsLogger.activateApp(unityActivity.getApplication(), str);
        } else {
            AppEventsLogger.activateApp(unityActivity.getApplication());
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                ActivityLifecycleTracker.onActivityCreated(unityActivity);
                ActivityLifecycleTracker.onActivityResumed(unityActivity);
            }
        });
    }

    private static void startActivity(Class<?> cls, String str) {
        Intent intent2 = new Intent(getUnityActivity(), cls);
        intent2.putExtra(BaseActivity.ACTIVITY_PARAMS, UnityParams.parse(str).getStringParams());
        getUnityActivity().startActivity(intent2);
    }

    private static void LogMethodCall(String str, String str2) {
        Log.v(TAG, String.format(Locale.ROOT, "%s(%s)", new Object[]{str, str2}));
    }

    /* access modifiers changed from: private */
    public static void addAppLinkToMessage(UnityMessage unityMessage, AppLinkData appLinkData) {
        if (appLinkData == null) {
            unityMessage.put("did_complete", Boolean.valueOf(true));
            return;
        }
        unityMessage.put("ref", appLinkData.getRef());
        unityMessage.put("target_url", appLinkData.getTargetUri().toString());
        try {
            if (appLinkData.getArgumentBundle() != null) {
                unityMessage.put("extras", BundleJSONConverter.convertToJSON(appLinkData.getArgumentBundle()).toString());
            }
        } catch (JSONException e) {
            Log.e(TAG, e.getLocalizedMessage());
        }
    }
}
