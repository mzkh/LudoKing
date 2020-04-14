package com.tapjoy;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import com.unity3d.player.UnityPlayer;
import java.util.HashMap;
import java.util.Hashtable;

public final class TapjoyConnectUnity {
    private static final TJAwardCurrencyListener AWARD_CURRENCY_LISTENER = new TJAwardCurrencyListener() {
        public void onAwardCurrencyResponse(String str, int i) {
            StringBuilder sb = new StringBuilder();
            sb.append("OnAwardCurrencyResponse,");
            sb.append(str);
            sb.append(",");
            sb.append(i);
            UnityPlayer.UnitySendMessage(TapjoyConnectUnity.UNITY_GAME_OBJECT_NAME, "OnNativeCurrencyCallback", sb.toString());
        }

        public void onAwardCurrencyResponseFailure(String str) {
            StringBuilder sb = new StringBuilder();
            sb.append("OnAwardCurrencyResponseFailure,");
            sb.append(str);
            UnityPlayer.UnitySendMessage(TapjoyConnectUnity.UNITY_GAME_OBJECT_NAME, "OnNativeCurrencyCallback", sb.toString());
        }
    };
    private static final String CONNECT_FLAG_DICTIONARY_NAME = "connectFlags";
    /* access modifiers changed from: private */
    public static final TJConnectListener CONNECT_LISTENER = new TJConnectListener() {
        public void onConnectSuccess() {
            Tapjoy.setEarnedCurrencyListener(TapjoyConnectUnity.EARNED_CURRENCY_LISTENER);
            Tapjoy.setVideoListener(TapjoyConnectUnity.VIDEO_LISTENER);
            UnityPlayer.UnitySendMessage(TapjoyConnectUnity.UNITY_GAME_OBJECT_NAME, "OnNativeConnectCallback", "OnConnectSuccess");
        }

        public void onConnectFailure() {
            UnityPlayer.UnitySendMessage(TapjoyConnectUnity.UNITY_GAME_OBJECT_NAME, "OnNativeConnectCallback", "OnConnectFailure");
        }
    };
    private static final int CURRENCY_ALERT_CODE = 1;
    /* access modifiers changed from: private */
    public static final TJEarnedCurrencyListener EARNED_CURRENCY_LISTENER = new TJEarnedCurrencyListener() {
        public void onEarnedCurrency(String str, int i) {
            TapjoyConnectUnity.earnedAmount = i;
            StringBuilder sb = new StringBuilder();
            sb.append("OnEarnedCurrency,");
            sb.append(str);
            sb.append(",");
            sb.append(i);
            UnityPlayer.UnitySendMessage(TapjoyConnectUnity.UNITY_GAME_OBJECT_NAME, "OnNativeCurrencyCallback", sb.toString());
        }
    };
    private static final TJGetCurrencyBalanceListener GET_CURRENCY_BALANCE_LISTENER = new TJGetCurrencyBalanceListener() {
        public void onGetCurrencyBalanceResponse(String str, int i) {
            StringBuilder sb = new StringBuilder();
            sb.append("OnGetCurrencyBalanceResponse,");
            sb.append(str);
            sb.append(",");
            sb.append(i);
            UnityPlayer.UnitySendMessage(TapjoyConnectUnity.UNITY_GAME_OBJECT_NAME, "OnNativeCurrencyCallback", sb.toString());
        }

        public void onGetCurrencyBalanceResponseFailure(String str) {
            StringBuilder sb = new StringBuilder();
            sb.append("OnGetCurrencyBalanceResponseFailure,");
            sb.append(str);
            UnityPlayer.UnitySendMessage(TapjoyConnectUnity.UNITY_GAME_OBJECT_NAME, "OnNativeCurrencyCallback", sb.toString());
        }
    };
    private static final TJPlacementListener PLACEMENT_LISTENER = new TJPlacementListener() {
        public void onRequestSuccess(TJPlacement tJPlacement) {
            String str;
            String str2 = (String) TapjoyConnectUnity.javaToCSharpMap.get(tJPlacement.getGUID());
            try {
                str = Uri.encode(tJPlacement.getName(), "UTF-8");
            } catch (Exception unused) {
                str = tJPlacement.getName();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("OnPlacementRequestSuccess,");
            sb.append(str2);
            String str3 = ",";
            sb.append(str3);
            sb.append(str);
            sb.append(str3);
            sb.append(tJPlacement.isContentAvailable());
            UnityPlayer.UnitySendMessage(TapjoyConnectUnity.UNITY_GAME_OBJECT_NAME, "OnNativePlacementCallback", sb.toString());
        }

        public void onRequestFailure(TJPlacement tJPlacement, TJError tJError) {
            String str;
            String str2 = (String) TapjoyConnectUnity.javaToCSharpMap.get(tJPlacement.getGUID());
            try {
                str = Uri.encode(tJPlacement.getName(), "UTF-8");
            } catch (Exception unused) {
                str = tJPlacement.getName();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("OnPlacementRequestFailure,");
            sb.append(str2);
            String str3 = ",";
            sb.append(str3);
            sb.append(str);
            sb.append(str3);
            sb.append(tJError.message);
            UnityPlayer.UnitySendMessage(TapjoyConnectUnity.UNITY_GAME_OBJECT_NAME, "OnNativePlacementCallback", sb.toString());
        }

        public void onContentReady(TJPlacement tJPlacement) {
            String str;
            String str2 = (String) TapjoyConnectUnity.javaToCSharpMap.get(tJPlacement.getGUID());
            try {
                str = Uri.encode(tJPlacement.getName(), "UTF-8");
            } catch (Exception unused) {
                str = tJPlacement.getName();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("OnPlacementContentReady,");
            sb.append(str2);
            sb.append(",");
            sb.append(str);
            UnityPlayer.UnitySendMessage(TapjoyConnectUnity.UNITY_GAME_OBJECT_NAME, "OnNativePlacementCallback", sb.toString());
        }

        public void onContentShow(TJPlacement tJPlacement) {
            String str;
            String str2 = (String) TapjoyConnectUnity.javaToCSharpMap.get(tJPlacement.getGUID());
            try {
                str = Uri.encode(tJPlacement.getName(), "UTF-8");
            } catch (Exception unused) {
                str = tJPlacement.getName();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("OnPlacementContentShow,");
            sb.append(str2);
            sb.append(",");
            sb.append(str);
            UnityPlayer.UnitySendMessage(TapjoyConnectUnity.UNITY_GAME_OBJECT_NAME, "OnNativePlacementCallback", sb.toString());
        }

        public void onContentDismiss(TJPlacement tJPlacement) {
            String str;
            String str2 = (String) TapjoyConnectUnity.javaToCSharpMap.get(tJPlacement.getGUID());
            try {
                str = Uri.encode(tJPlacement.getName(), "UTF-8");
            } catch (Exception unused) {
                str = tJPlacement.getName();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("OnPlacementContentDismiss,");
            sb.append(str2);
            sb.append(",");
            sb.append(str);
            UnityPlayer.UnitySendMessage(TapjoyConnectUnity.UNITY_GAME_OBJECT_NAME, "OnNativePlacementCallback", sb.toString());
        }

        public void onClick(TJPlacement tJPlacement) {
            String str;
            String str2 = (String) TapjoyConnectUnity.javaToCSharpMap.get(tJPlacement.getGUID());
            try {
                str = Uri.encode(tJPlacement.getName(), "UTF-8");
            } catch (Exception unused) {
                str = tJPlacement.getName();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("OnPlacementClick,");
            sb.append(str2);
            sb.append(",");
            sb.append(str);
            UnityPlayer.UnitySendMessage(TapjoyConnectUnity.UNITY_GAME_OBJECT_NAME, "OnNativePlacementCallback", sb.toString());
        }

        public void onPurchaseRequest(TJPlacement tJPlacement, TJActionRequest tJActionRequest, String str) {
            String str2;
            String str3 = (String) TapjoyConnectUnity.javaToCSharpMap.get(tJPlacement.getGUID());
            TapjoyConnectUnity.actionRequestMap.put(str3, tJActionRequest);
            try {
                str2 = Uri.encode(tJPlacement.getName(), "UTF-8");
            } catch (Exception unused) {
                str2 = tJPlacement.getName();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("OnPurchaseRequest,");
            sb.append(str3);
            String str4 = ",";
            sb.append(str4);
            sb.append(str2);
            sb.append(str4);
            sb.append(tJActionRequest.getRequestId());
            sb.append(str4);
            sb.append(tJActionRequest.getToken());
            sb.append(str4);
            sb.append(str);
            UnityPlayer.UnitySendMessage(TapjoyConnectUnity.UNITY_GAME_OBJECT_NAME, "OnNativePlacementCallback", sb.toString());
        }

        public void onRewardRequest(TJPlacement tJPlacement, TJActionRequest tJActionRequest, String str, int i) {
            String str2;
            String str3 = (String) TapjoyConnectUnity.javaToCSharpMap.get(tJPlacement.getGUID());
            TapjoyConnectUnity.actionRequestMap.put(str3, tJActionRequest);
            try {
                str2 = Uri.encode(tJPlacement.getName(), "UTF-8");
            } catch (Exception unused) {
                str2 = tJPlacement.getName();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("OnRewardRequest,");
            sb.append(str3);
            String str4 = ",";
            sb.append(str4);
            sb.append(str2);
            sb.append(str4);
            sb.append(tJActionRequest.getRequestId());
            sb.append(str4);
            sb.append(tJActionRequest.getToken());
            sb.append(str4);
            sb.append(str);
            sb.append(str4);
            sb.append(i);
            UnityPlayer.UnitySendMessage(TapjoyConnectUnity.UNITY_GAME_OBJECT_NAME, "OnNativePlacementCallback", sb.toString());
        }
    };
    private static final TJPlacementVideoListener PLACEMENT_VIDEO_LISTENER = new TJPlacementVideoListener() {
        public void onVideoStart(TJPlacement tJPlacement) {
            String str;
            String str2 = (String) TapjoyConnectUnity.javaToCSharpMap.get(tJPlacement.getGUID());
            try {
                str = Uri.encode(tJPlacement.getName(), "UTF-8");
            } catch (Exception unused) {
                str = tJPlacement.getName();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("OnVideoStart,");
            sb.append(str2);
            sb.append(",");
            sb.append(str);
            UnityPlayer.UnitySendMessage(TapjoyConnectUnity.UNITY_GAME_OBJECT_NAME, "OnNativePlacementVideoCallback", sb.toString());
        }

        public void onVideoError(TJPlacement tJPlacement, String str) {
            String str2;
            String str3 = (String) TapjoyConnectUnity.javaToCSharpMap.get(tJPlacement.getGUID());
            try {
                str2 = Uri.encode(tJPlacement.getName(), "UTF-8");
            } catch (Exception unused) {
                str2 = tJPlacement.getName();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("OnVideoError,");
            sb.append(str3);
            String str4 = ",";
            sb.append(str4);
            sb.append(str2);
            sb.append(str4);
            sb.append(str);
            UnityPlayer.UnitySendMessage(TapjoyConnectUnity.UNITY_GAME_OBJECT_NAME, "OnNativePlacementVideoCallback", sb.toString());
        }

        public void onVideoComplete(TJPlacement tJPlacement) {
            String str;
            String str2 = (String) TapjoyConnectUnity.javaToCSharpMap.get(tJPlacement.getGUID());
            try {
                str = Uri.encode(tJPlacement.getName(), "UTF-8");
            } catch (Exception unused) {
                str = tJPlacement.getName();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("OnVideoComplete,");
            sb.append(str2);
            sb.append(",");
            sb.append(str);
            UnityPlayer.UnitySendMessage(TapjoyConnectUnity.UNITY_GAME_OBJECT_NAME, "OnNativePlacementVideoCallback", sb.toString());
        }
    };
    private static final String SEGMENTATION_DICTIONARY_NAME = "segmentationParams";
    private static final TJSetUserIDListener SET_USER_ID_LISTENER = new TJSetUserIDListener() {
        public void onSetUserIDSuccess() {
            UnityPlayer.UnitySendMessage(TapjoyConnectUnity.UNITY_GAME_OBJECT_NAME, "OnNativeSetUserIDCallback", "OnSetUserIDSuccess");
        }

        public void onSetUserIDFailure(String str) {
            StringBuilder sb = new StringBuilder();
            sb.append("OnSetUserIDFailure,");
            sb.append(str);
            UnityPlayer.UnitySendMessage(TapjoyConnectUnity.UNITY_GAME_OBJECT_NAME, "OnNativeSetUserIDCallback", sb.toString());
        }
    };
    private static final TJSpendCurrencyListener SPEND_CURRENCY_LISTENER = new TJSpendCurrencyListener() {
        public void onSpendCurrencyResponse(String str, int i) {
            StringBuilder sb = new StringBuilder();
            sb.append("OnSpendCurrencyResponse,");
            sb.append(str);
            sb.append(",");
            sb.append(i);
            UnityPlayer.UnitySendMessage(TapjoyConnectUnity.UNITY_GAME_OBJECT_NAME, "OnNativeCurrencyCallback", sb.toString());
        }

        public void onSpendCurrencyResponseFailure(String str) {
            StringBuilder sb = new StringBuilder();
            sb.append("OnSpendCurrencyResponseFailure,");
            sb.append(str);
            UnityPlayer.UnitySendMessage(TapjoyConnectUnity.UNITY_GAME_OBJECT_NAME, "OnNativeCurrencyCallback", sb.toString());
        }
    };
    private static final String TAG = "TapjoyConnectUnity";
    private static final String UNITY_GAME_OBJECT_NAME = "TapjoyUnity";
    /* access modifiers changed from: private */
    public static final TJVideoListener VIDEO_LISTENER = new TJVideoListener() {
        public void onVideoStart() {
            UnityPlayer.UnitySendMessage(TapjoyConnectUnity.UNITY_GAME_OBJECT_NAME, "OnNativeVideoCallback", "OnVideoStart");
        }

        public void onVideoError(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append("OnVideoError,");
            sb.append(i);
            UnityPlayer.UnitySendMessage(TapjoyConnectUnity.UNITY_GAME_OBJECT_NAME, "OnNativeVideoCallback", sb.toString());
        }

        public void onVideoComplete() {
            UnityPlayer.UnitySendMessage(TapjoyConnectUnity.UNITY_GAME_OBJECT_NAME, "OnNativeVideoCallback", "OnVideoComplete");
        }
    };
    /* access modifiers changed from: private */
    public static Hashtable<String, TJActionRequest> actionRequestMap = new Hashtable<>();
    /* access modifiers changed from: private */
    public static Activity activity;
    /* access modifiers changed from: private */
    public static Context applicationContext;
    private static Hashtable<String, Object> cSharpDictionaryRefs = new Hashtable<>();
    private static Hashtable<String, TJPlacement> cSharpGuidMap = new Hashtable<>();
    /* access modifiers changed from: private */
    public static int earnedAmount = 0;
    /* access modifiers changed from: private */
    public static String earnedCurrencyName = "Points";
    /* access modifiers changed from: private */
    public static Handler handler;
    /* access modifiers changed from: private */
    public static Hashtable<String, String> javaToCSharpMap = new Hashtable<>();
    static final Runnable showDefaultEarnedCurrencyAlert = new Runnable() {
        public void run() {
            try {
                Builder title = new Builder(TapjoyConnectUnity.activity).setTitle("Congratulations!");
                StringBuilder sb = new StringBuilder();
                sb.append("You've just earned ");
                sb.append(TapjoyConnectUnity.earnedAmount);
                sb.append(" ");
                sb.append(TapjoyConnectUnity.earnedCurrencyName);
                title.setMessage(sb.toString()).setPositiveButton("OK", new OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).create().show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private static TapjoyConnectUnity tapjoyUnity;
    private int tapjoycurrencyTotal = 0;

    private TapjoyConnectUnity() {
    }

    public static void activate(String str) {
        activity = UnityPlayer.currentActivity;
        applicationContext = activity.getApplicationContext();
        if (activity != null) {
            TapjoyConnectCore.setPlugin(TapjoyConstants.TJC_PLUGIN_UNITY);
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    Tapjoy.setActivity(TapjoyConnectUnity.activity);
                    TapjoyConnectUnity.handler = new Handler() {
                        public void handleMessage(Message message) {
                            super.handleMessage(message);
                            if (message != null && message.arg1 == 1) {
                                post(TapjoyConnectUnity.showDefaultEarnedCurrencyAlert);
                            }
                        }
                    };
                }
            });
        }
    }

    public static void connect(String str) {
        connect(str, getReferenceDictionary(CONNECT_FLAG_DICTIONARY_NAME, false));
    }

    public static void connect(final String str, final Hashtable<String, Object> hashtable) {
        tapjoyUnity = new TapjoyConnectUnity();
        Activity activity2 = activity;
        if (activity2 != null) {
            activity2.runOnUiThread(new Runnable() {
                public void run() {
                    Tapjoy.connect(TapjoyConnectUnity.applicationContext, str, hashtable, TapjoyConnectUnity.CONNECT_LISTENER);
                }
            });
        }
    }

    public static void setReceiveRemoteNotification(String str) {
        Tapjoy.setReceiveRemoteNotification(applicationContext, new HashMap(getReferenceDictionary(str)));
        removeRefDictionary(str);
    }

    public static void onActivityStart() {
        if (VERSION.SDK_INT < 14) {
            Activity activity2 = activity;
            if (activity2 != null) {
                activity2.runOnUiThread(new Runnable() {
                    public void run() {
                        Tapjoy.onActivityStart(TapjoyConnectUnity.activity);
                    }
                });
            }
        }
    }

    public static void onActivityStop() {
        if (VERSION.SDK_INT < 14) {
            Activity activity2 = activity;
            if (activity2 != null) {
                activity2.runOnUiThread(new Runnable() {
                    public void run() {
                        Tapjoy.onActivityStop(TapjoyConnectUnity.activity);
                    }
                });
            }
        }
    }

    public static void actionComplete(String str) {
        Tapjoy.actionComplete(str);
    }

    public static void setUserID(String str) {
        Tapjoy.setUserID(str, SET_USER_ID_LISTENER);
    }

    public static void awardCurrency(int i) {
        Tapjoy.awardCurrency(i, AWARD_CURRENCY_LISTENER);
    }

    public static void getCurrencyBalance() {
        Tapjoy.getCurrencyBalance(GET_CURRENCY_BALANCE_LISTENER);
    }

    public static void spendCurrency(int i) {
        Tapjoy.spendCurrency(i, SPEND_CURRENCY_LISTENER);
    }

    public static float getCurrencyMultiplier() {
        return Tapjoy.getCurrencyMultiplier();
    }

    public static String getSupportURL() {
        return Tapjoy.getSupportURL();
    }

    public static String getSupportURL(String str) {
        return Tapjoy.getSupportURL(str);
    }

    public static void showDefaultEarnedCurrencyAlert() {
        Message message = new Message();
        message.arg1 = 1;
        Handler handler2 = handler;
        if (handler2 != null) {
            handler2.sendMessage(message);
        }
    }

    public static void createPlacement(String str, String str2) {
        TJPlacement tJPlacement = new TJPlacement(activity, str2, PLACEMENT_LISTENER);
        tJPlacement.setVideoListener(PLACEMENT_VIDEO_LISTENER);
        cSharpGuidMap.put(str, tJPlacement);
        javaToCSharpMap.put(tJPlacement.getGUID(), str);
    }

    public static void dismissPlacementContent() {
        TJPlacement.dismissContent();
    }

    public static void requestPlacementContent(String str) {
        TJPlacement tJPlacement = (TJPlacement) cSharpGuidMap.get(str);
        if (tJPlacement != null) {
            tJPlacement.requestContent();
        }
    }

    public static void showPlacementContent(String str) {
        TJPlacement tJPlacement = (TJPlacement) cSharpGuidMap.get(str);
        if (tJPlacement != null) {
            tJPlacement.showContent();
        }
    }

    public static boolean isPlacementContentAvailable(String str) {
        TJPlacement tJPlacement = (TJPlacement) cSharpGuidMap.get(str);
        if (tJPlacement != null) {
            return tJPlacement.isContentAvailable();
        }
        return false;
    }

    public static boolean isPlacementContentReady(String str) {
        TJPlacement tJPlacement = (TJPlacement) cSharpGuidMap.get(str);
        if (tJPlacement != null) {
            return tJPlacement.isContentReady();
        }
        return false;
    }

    public static void removePlacement(String str) {
        cSharpGuidMap.remove(str);
    }

    public static void removeRefDictionary(String str) {
        cSharpDictionaryRefs.remove(str);
    }

    public static void actionRequestCompleted(String str) {
        TJActionRequest tJActionRequest = (TJActionRequest) actionRequestMap.get(str);
        if (tJActionRequest != null) {
            tJActionRequest.completed();
            actionRequestMap.remove(str);
        }
    }

    public static void actionRequestCancelled(String str) {
        TJActionRequest tJActionRequest = (TJActionRequest) actionRequestMap.get(str);
        if (tJActionRequest != null) {
            tJActionRequest.cancelled();
            actionRequestMap.remove(str);
        }
    }

    public static void removeActionRequest(String str) {
        actionRequestMap.remove(str);
    }

    public static void trackEvent_CNPPV(String str, String str2, String str3, String str4, long j) {
        Tapjoy.trackEvent(str, str2, str3, str4, j);
    }

    public static void trackEvent_CNPPV1V2V3(String str, String str2, String str3, String str4, String str5, long j, String str6, long j2, String str7, long j3) {
        Tapjoy.trackEvent(str, str2, str3, str4, str5, j, str6, j2, str7, j3);
    }

    public static Hashtable<String, Object> getReferenceDictionary(String str, boolean z) {
        Hashtable<String, Object> hashtable = (Hashtable) cSharpDictionaryRefs.get(str);
        if (hashtable != null || !z) {
            return hashtable;
        }
        Hashtable<String, Object> hashtable2 = new Hashtable<>();
        cSharpDictionaryRefs.put(str, hashtable2);
        return hashtable2;
    }

    public static Hashtable<String, Object> getReferenceDictionary(String str) {
        return getReferenceDictionary(str, true);
    }

    public static void setKeyValueInDictionary(String str, String str2, String str3) {
        getReferenceDictionary(str3).put(str, str2);
    }

    public static void setKeyValueInDictionary(String str, int i, String str2) {
        getReferenceDictionary(str2).put(str, Integer.valueOf(i));
    }

    public static void setKeyValueInDictionary(String str, float f, String str2) {
        getReferenceDictionary(str2).put(str, Float.valueOf(f));
    }

    public static void setKeyValueInDictionary(String str, boolean z, String str2) {
        getReferenceDictionary(str2).put(str, Boolean.valueOf(z));
    }

    public static void setDictionaryInDictionary(String str, String str2, String str3) {
        Hashtable hashtable = (Hashtable) cSharpDictionaryRefs.get(str3);
        if (hashtable == null) {
            hashtable = new Hashtable();
            cSharpDictionaryRefs.put(str3, hashtable);
        }
        Hashtable hashtable2 = (Hashtable) cSharpDictionaryRefs.get(str2);
        if (hashtable2 == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("no dictionary reference by the name of ");
            sb.append(str2);
            TapjoyLog.m6553i(UNITY_GAME_OBJECT_NAME, sb.toString());
            return;
        }
        hashtable.put(str, hashtable2);
    }
}
