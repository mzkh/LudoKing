package com.unity3d.services.monetization.placementcontent.ads;

import android.app.Activity;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.UnityAds.FinishState;
import com.unity3d.services.monetization.placementcontent.core.RewardablePlacementContent;
import java.util.HashMap;
import java.util.Map;

public class ShowAdPlacementContent extends RewardablePlacementContent {
    private static Map<String, IShowAdListener> listenerMap = new HashMap();

    public ShowAdPlacementContent(String str, Map<String, Object> map) {
        super(str, map);
    }

    public void show(Activity activity, IShowAdListener iShowAdListener) {
        listenerMap.put(this.placementId, iShowAdListener);
        if (UnityAds.isReady(this.placementId)) {
            UnityAds.show(activity, this.placementId);
        } else {
            sendAdFinished(this.placementId, FinishState.ERROR);
        }
    }

    public static void sendAdFinished(String str, FinishState finishState) {
        IShowAdListener iShowAdListener = (IShowAdListener) listenerMap.remove(str);
        if (iShowAdListener != null) {
            iShowAdListener.onAdFinished(str, finishState);
        }
    }

    public static void sendAdStarted(String str) {
        IShowAdListener iShowAdListener = (IShowAdListener) listenerMap.get(str);
        if (iShowAdListener != null) {
            iShowAdListener.onAdStarted(str);
        }
    }
}
