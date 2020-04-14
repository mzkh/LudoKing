package com.unity3d.services.ads.load;

import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.webview.WebViewApp;
import com.unity3d.services.core.webview.WebViewEventCategory;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONObject;

public class LoadBridge implements ILoadBridge {

    public enum LoadEvent {
        LOAD_PLACEMENTS
    }

    public void loadPlacements(Map<String, Integer> map) {
        try {
            JSONObject jSONObject = new JSONObject();
            for (Entry entry : map.entrySet()) {
                jSONObject.put((String) entry.getKey(), ((Integer) entry.getValue()).intValue());
            }
            if (WebViewApp.getCurrentApp() != null) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.LOAD_API, LoadEvent.LOAD_PLACEMENTS, jSONObject);
            }
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("An exception was thrown while loading placements ");
            sb.append(e.getLocalizedMessage());
            DeviceLog.error(sb.toString());
        }
    }
}
