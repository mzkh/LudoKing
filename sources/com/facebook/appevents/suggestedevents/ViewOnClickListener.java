package com.facebook.appevents.suggestedevents;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo.Scope;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.appevents.p022ml.ModelManager;
import com.facebook.internal.Utility;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@RestrictTo({Scope.LIBRARY})
public final class ViewOnClickListener implements OnClickListener {
    private static final String API_ENDPOINT = "%s/suggested_events";
    public static final String OTHER_EVENT = "other";
    private static final String TAG = "com.facebook.appevents.suggestedevents.ViewOnClickListener";
    private static final Set<Integer> viewsAttachedListener = new HashSet();
    /* access modifiers changed from: private */
    public String activityName;
    @Nullable
    private OnClickListener baseListener;
    private WeakReference<View> hostViewWeakReference;
    private WeakReference<View> rootViewWeakReference;

    static void attachListener(View view, View view2, String str) {
        int hashCode = view.hashCode();
        if (!viewsAttachedListener.contains(Integer.valueOf(hashCode))) {
            ViewHierarchy.setOnClickListener(view, new ViewOnClickListener(view, view2, str));
            viewsAttachedListener.add(Integer.valueOf(hashCode));
        }
    }

    private ViewOnClickListener(View view, View view2, String str) {
        this.baseListener = ViewHierarchy.getExistingOnClickListener(view);
        this.hostViewWeakReference = new WeakReference<>(view);
        this.rootViewWeakReference = new WeakReference<>(view2);
        this.activityName = str.toLowerCase().replace("activity", "");
    }

    public void onClick(View view) {
        OnClickListener onClickListener = this.baseListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        process();
    }

    private void process() {
        View view = (View) this.rootViewWeakReference.get();
        View view2 = (View) this.hostViewWeakReference.get();
        if (!(view == null || view2 == null)) {
            try {
                String pathID = PredictionHistoryManager.getPathID(view2);
                if (pathID != null) {
                    String textOfView = ViewHierarchy.getTextOfView(view2);
                    if (!queryHistoryAndProcess(pathID, textOfView)) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(ViewHierarchyConstants.VIEW_KEY, SuggestedEventViewHierarchy.getDictionaryOfView(view, view2));
                        jSONObject.put(ViewHierarchyConstants.SCREEN_NAME_KEY, this.activityName);
                        predictAndProcess(pathID, textOfView, jSONObject);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    private static boolean queryHistoryAndProcess(String str, final String str2) {
        final String queryEvent = PredictionHistoryManager.queryEvent(str);
        if (queryEvent == null) {
            return false;
        }
        if (!queryEvent.equals("other")) {
            Utility.runOnNonUiThread(new Runnable() {
                public void run() {
                    ViewOnClickListener.processPredictedResult(queryEvent, str2, new float[0]);
                }
            });
        }
        return true;
    }

    private void predictAndProcess(final String str, final String str2, final JSONObject jSONObject) {
        Utility.runOnNonUiThread(new Runnable() {
            public void run() {
                try {
                    String lowerCase = Utility.getAppName(FacebookSdk.getApplicationContext()).toLowerCase();
                    float[] denseFeatures = FeatureExtractor.getDenseFeatures(jSONObject, lowerCase);
                    String textFeature = FeatureExtractor.getTextFeature(str2, ViewOnClickListener.this.activityName, lowerCase);
                    if (denseFeatures != null) {
                        String predict = ModelManager.predict(ModelManager.MODEL_SUGGESTED_EVENTS, denseFeatures, textFeature);
                        if (predict != null) {
                            PredictionHistoryManager.addPrediction(str, predict);
                            if (!predict.equals("other")) {
                                ViewOnClickListener.processPredictedResult(predict, str2, denseFeatures);
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public static void processPredictedResult(String str, String str2, float[] fArr) {
        if (SuggestedEventsManager.isProductionEvents(str)) {
            new InternalAppEventsLogger(FacebookSdk.getApplicationContext()).logEventFromSE(str, str2);
        } else if (SuggestedEventsManager.isEligibleEvents(str)) {
            sendPredictedResult(str, str2, fArr);
        }
    }

    private static void sendPredictedResult(String str, String str2, float[] fArr) {
        Bundle bundle = new Bundle();
        try {
            bundle.putString("event_name", str);
            JSONObject jSONObject = new JSONObject();
            StringBuilder sb = new StringBuilder();
            for (float append : fArr) {
                sb.append(append);
                sb.append(",");
            }
            jSONObject.put("dense", sb.toString());
            jSONObject.put("button_text", str2);
            bundle.putString("metadata", jSONObject.toString());
            GraphRequest newPostRequest = GraphRequest.newPostRequest(null, String.format(Locale.US, API_ENDPOINT, new Object[]{FacebookSdk.getApplicationId()}), null, null);
            newPostRequest.setParameters(bundle);
            newPostRequest.executeAndWait();
        } catch (JSONException unused) {
        }
    }
}
