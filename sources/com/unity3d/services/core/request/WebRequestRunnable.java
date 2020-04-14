package com.unity3d.services.core.request;

import android.os.Bundle;
import com.unity3d.services.core.log.DeviceLog;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebRequestRunnable implements Runnable {
    private final String _body;
    private boolean _canceled = false;
    private final int _connectTimeout;
    private WebRequest _currentRequest;
    private final Map<String, List<String>> _headers;
    private final IWebRequestListener _listener;
    private final int _readTimeout;
    private final String _type;
    private final String _url;

    public WebRequestRunnable(String str, String str2, String str3, int i, int i2, Map<String, List<String>> map, IWebRequestListener iWebRequestListener) {
        this._url = str;
        this._type = str2;
        this._body = str3;
        this._connectTimeout = i;
        this._readTimeout = i2;
        this._headers = map;
        this._listener = iWebRequestListener;
    }

    public void run() {
        StringBuilder sb = new StringBuilder();
        sb.append("Handling request message: ");
        sb.append(this._url);
        sb.append(" type=");
        sb.append(this._type);
        DeviceLog.debug(sb.toString());
        try {
            makeRequest(this._url, this._type, this._headers, this._body, this._connectTimeout, this._readTimeout);
        } catch (MalformedURLException e) {
            String str = "Malformed URL";
            DeviceLog.exception(str, e);
            onFailed(str);
        }
    }

    public void setCancelStatus(boolean z) {
        this._canceled = z;
        if (this._canceled) {
            WebRequest webRequest = this._currentRequest;
            if (webRequest != null) {
                webRequest.cancel();
            }
        }
    }

    private void makeRequest(String str, String str2, Map<String, List<String>> map, String str3, int i, int i2) throws MalformedURLException {
        if (!this._canceled) {
            WebRequest webRequest = new WebRequest(str, str2, map, i, i2);
            this._currentRequest = webRequest;
            if (str3 != null) {
                this._currentRequest.setBody(str3);
            }
            try {
                String makeRequest = this._currentRequest.makeRequest();
                if (!this._currentRequest.isCanceled()) {
                    Bundle bundle = new Bundle();
                    for (String str4 : this._currentRequest.getResponseHeaders().keySet()) {
                        if (str4 != null && !str4.contentEquals("null")) {
                            String[] strArr = new String[((List) this._currentRequest.getResponseHeaders().get(str4)).size()];
                            for (int i3 = 0; i3 < ((List) this._currentRequest.getResponseHeaders().get(str4)).size(); i3++) {
                                strArr[i3] = (String) ((List) this._currentRequest.getResponseHeaders().get(str4)).get(i3);
                            }
                            bundle.putStringArray(str4, strArr);
                        }
                    }
                    if (!this._currentRequest.isCanceled()) {
                        onSucceed(makeRequest, this._currentRequest.getResponseCode(), getResponseHeaders(bundle));
                    }
                }
            } catch (NetworkIOException | IOException | IllegalArgumentException | IllegalStateException e) {
                DeviceLog.exception("Error completing request", e);
                StringBuilder sb = new StringBuilder();
                sb.append(e.getClass().getName());
                sb.append(": ");
                sb.append(e.getMessage());
                onFailed(sb.toString());
            }
        }
    }

    private void onSucceed(String str, int i, Map<String, List<String>> map) {
        this._listener.onComplete(this._url, str, i, map);
    }

    private void onFailed(String str) {
        this._listener.onFailed(this._url, str);
    }

    private Map<String, List<String>> getResponseHeaders(Bundle bundle) {
        if (bundle.size() <= 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String str : bundle.keySet()) {
            String[] stringArray = bundle.getStringArray(str);
            if (stringArray != null) {
                hashMap.put(str, new ArrayList(Arrays.asList(stringArray)));
            }
        }
        return hashMap;
    }
}
