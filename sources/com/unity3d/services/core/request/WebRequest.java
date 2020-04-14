package com.unity3d.services.core.request;

import com.tapjoy.TapjoyConstants;
import com.unity3d.services.core.log.DeviceLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

public class WebRequest {
    private String _body;
    private boolean _canceled;
    private int _connectTimeout;
    private long _contentLength;
    private Map<String, List<String>> _headers;
    private IWebRequestProgressListener _progressListener;
    private int _readTimeout;
    private String _requestType;
    private int _responseCode;
    private Map<String, List<String>> _responseHeaders;
    private URL _url;

    public enum RequestType {
        POST,
        GET,
        HEAD
    }

    public WebRequest(String str, String str2, Map<String, List<String>> map) throws MalformedURLException {
        this(str, str2, map, TapjoyConstants.TJC_PLACEMENT_RESPONSE_TIMEOUT, TapjoyConstants.TJC_PLACEMENT_RESPONSE_TIMEOUT);
    }

    public WebRequest(String str, String str2, Map<String, List<String>> map, int i, int i2) throws MalformedURLException {
        this._requestType = RequestType.GET.name();
        this._responseCode = -1;
        this._contentLength = -1;
        this._canceled = false;
        this._url = new URL(str);
        this._requestType = str2;
        this._headers = map;
        this._connectTimeout = i;
        this._readTimeout = i2;
    }

    public void cancel() {
        this._canceled = true;
    }

    public boolean isCanceled() {
        return this._canceled;
    }

    public URL getUrl() {
        return this._url;
    }

    public String getRequestType() {
        return this._requestType;
    }

    public String getBody() {
        return this._body;
    }

    public void setBody(String str) {
        this._body = str;
    }

    public String getQuery() {
        URL url = this._url;
        if (url != null) {
            return url.getQuery();
        }
        return null;
    }

    public Map<String, List<String>> getResponseHeaders() {
        return this._responseHeaders;
    }

    public Map<String, List<String>> getHeaders() {
        return this._headers;
    }

    public int getResponseCode() {
        return this._responseCode;
    }

    public long getContentLength() {
        return this._contentLength;
    }

    public int getConnectTimeout() {
        return this._connectTimeout;
    }

    public void setConnectTimeout(int i) {
        this._connectTimeout = i;
    }

    public int getReadTimeout() {
        return this._readTimeout;
    }

    public void setReadTimeout(int i) {
        this._readTimeout = i;
    }

    public void setProgressListener(IWebRequestProgressListener iWebRequestProgressListener) {
        this._progressListener = iWebRequestProgressListener;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x007d A[SYNTHETIC, Splitter:B:27:0x007d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long makeStreamRequest(java.io.OutputStream r18) throws com.unity3d.services.core.request.NetworkIOException, java.io.IOException, java.lang.IllegalStateException {
        /*
            r17 = this;
            r1 = r17
            java.lang.String r2 = "Error closing writer"
            java.net.HttpURLConnection r3 = r17.getHttpUrlConnectionWithHeaders()
            r0 = 1
            r3.setDoInput(r0)
            java.lang.String r4 = r17.getRequestType()
            com.unity3d.services.core.request.WebRequest$RequestType r5 = com.unity3d.services.core.request.WebRequest.RequestType.POST
            java.lang.String r5 = r5.name()
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0088
            r3.setDoOutput(r0)
            r4 = 0
            java.io.PrintWriter r5 = new java.io.PrintWriter     // Catch:{ IOException -> 0x005a }
            java.io.OutputStreamWriter r6 = new java.io.OutputStreamWriter     // Catch:{ IOException -> 0x005a }
            java.io.OutputStream r7 = r3.getOutputStream()     // Catch:{ IOException -> 0x005a }
            java.lang.String r8 = "UTF-8"
            r6.<init>(r7, r8)     // Catch:{ IOException -> 0x005a }
            r5.<init>(r6, r0)     // Catch:{ IOException -> 0x005a }
            java.lang.String r0 = r17.getBody()     // Catch:{ IOException -> 0x0055, all -> 0x0052 }
            if (r0 != 0) goto L_0x003e
            java.lang.String r0 = r17.getQuery()     // Catch:{ IOException -> 0x0055, all -> 0x0052 }
            r5.print(r0)     // Catch:{ IOException -> 0x0055, all -> 0x0052 }
            goto L_0x0045
        L_0x003e:
            java.lang.String r0 = r17.getBody()     // Catch:{ IOException -> 0x0055, all -> 0x0052 }
            r5.print(r0)     // Catch:{ IOException -> 0x0055, all -> 0x0052 }
        L_0x0045:
            r5.flush()     // Catch:{ IOException -> 0x0055, all -> 0x0052 }
            r5.close()     // Catch:{ Exception -> 0x004c }
            goto L_0x0088
        L_0x004c:
            r0 = move-exception
            r3 = r0
            com.unity3d.services.core.log.DeviceLog.exception(r2, r3)
            throw r3
        L_0x0052:
            r0 = move-exception
            r4 = r5
            goto L_0x007b
        L_0x0055:
            r0 = move-exception
            r4 = r5
            goto L_0x005b
        L_0x0058:
            r0 = move-exception
            goto L_0x007b
        L_0x005a:
            r0 = move-exception
        L_0x005b:
            java.lang.String r3 = "Error while writing POST params"
            com.unity3d.services.core.log.DeviceLog.exception(r3, r0)     // Catch:{ all -> 0x0058 }
            com.unity3d.services.core.request.NetworkIOException r3 = new com.unity3d.services.core.request.NetworkIOException     // Catch:{ all -> 0x0058 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0058 }
            r5.<init>()     // Catch:{ all -> 0x0058 }
            java.lang.String r6 = "Error writing POST params: "
            r5.append(r6)     // Catch:{ all -> 0x0058 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0058 }
            r5.append(r0)     // Catch:{ all -> 0x0058 }
            java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x0058 }
            r3.<init>(r0)     // Catch:{ all -> 0x0058 }
            throw r3     // Catch:{ all -> 0x0058 }
        L_0x007b:
            if (r4 == 0) goto L_0x0087
            r4.close()     // Catch:{ Exception -> 0x0081 }
            goto L_0x0087
        L_0x0081:
            r0 = move-exception
            r3 = r0
            com.unity3d.services.core.log.DeviceLog.exception(r2, r3)
            throw r3
        L_0x0087:
            throw r0
        L_0x0088:
            int r0 = r3.getResponseCode()     // Catch:{ IOException -> 0x0141, RuntimeException -> 0x013f }
            r1._responseCode = r0     // Catch:{ IOException -> 0x0141, RuntimeException -> 0x013f }
            int r0 = r3.getContentLength()
            long r4 = (long) r0
            r1._contentLength = r4
            java.util.Map r0 = r3.getHeaderFields()
            if (r0 == 0) goto L_0x00a1
            java.util.Map r0 = r3.getHeaderFields()
            r1._responseHeaders = r0
        L_0x00a1:
            java.io.InputStream r0 = r3.getInputStream()     // Catch:{ IOException -> 0x00a6 }
            goto L_0x00ae
        L_0x00a6:
            r0 = move-exception
            r2 = r0
            java.io.InputStream r0 = r3.getErrorStream()
            if (r0 == 0) goto L_0x0124
        L_0x00ae:
            com.unity3d.services.core.request.IWebRequestProgressListener r4 = r1._progressListener
            if (r4 == 0) goto L_0x00c3
            java.net.URL r2 = r17.getUrl()
            java.lang.String r5 = r2.toString()
            long r6 = r1._contentLength
            int r8 = r1._responseCode
            java.util.Map<java.lang.String, java.util.List<java.lang.String>> r9 = r1._responseHeaders
            r4.onRequestStart(r5, r6, r8, r9)
        L_0x00c3:
            java.io.BufferedInputStream r2 = new java.io.BufferedInputStream
            r2.<init>(r0)
            r4 = 0
            r0 = 4096(0x1000, float:5.74E-42)
            byte[] r0 = new byte[r0]
            r6 = 0
            r7 = r4
            r4 = 0
        L_0x00d1:
            boolean r5 = r17.isCanceled()
            if (r5 != 0) goto L_0x011b
            r5 = -1
            if (r4 == r5) goto L_0x011b
            int r4 = r2.read(r0)     // Catch:{ IOException -> 0x00fe }
            if (r4 <= 0) goto L_0x00fb
            r5 = r18
            r5.write(r0, r6, r4)
            long r9 = (long) r4
            long r7 = r7 + r9
            com.unity3d.services.core.request.IWebRequestProgressListener r11 = r1._progressListener
            if (r11 == 0) goto L_0x00d1
            java.net.URL r9 = r17.getUrl()
            java.lang.String r12 = r9.toString()
            long r9 = r1._contentLength
            r13 = r7
            r15 = r9
            r11.onRequestProgress(r12, r13, r15)
            goto L_0x00d1
        L_0x00fb:
            r5 = r18
            goto L_0x00d1
        L_0x00fe:
            r0 = move-exception
            r2 = r0
            com.unity3d.services.core.request.NetworkIOException r0 = new com.unity3d.services.core.request.NetworkIOException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Network exception: "
            r3.append(r4)
            java.lang.String r2 = r2.getMessage()
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r0.<init>(r2)
            throw r0
        L_0x011b:
            r5 = r18
            r3.disconnect()
            r18.flush()
            return r7
        L_0x0124:
            com.unity3d.services.core.request.NetworkIOException r0 = new com.unity3d.services.core.request.NetworkIOException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Can't open error stream: "
            r3.append(r4)
            java.lang.String r2 = r2.getMessage()
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r0.<init>(r2)
            throw r0
        L_0x013f:
            r0 = move-exception
            goto L_0x0142
        L_0x0141:
            r0 = move-exception
        L_0x0142:
            com.unity3d.services.core.request.NetworkIOException r2 = new com.unity3d.services.core.request.NetworkIOException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Response code: "
            r3.append(r4)
            java.lang.String r0 = r0.getMessage()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.request.WebRequest.makeStreamRequest(java.io.OutputStream):long");
    }

    public String makeRequest() throws NetworkIOException, IOException, IllegalStateException, IllegalArgumentException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        makeStreamRequest(byteArrayOutputStream);
        return byteArrayOutputStream.toString("UTF-8");
    }

    private HttpURLConnection getHttpUrlConnectionWithHeaders() throws NetworkIOException, IllegalArgumentException {
        HttpURLConnection httpURLConnection;
        if (getUrl().toString().startsWith("https://")) {
            try {
                httpURLConnection = (HttpsURLConnection) getUrl().openConnection();
            } catch (IOException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Open HTTPS connection: ");
                sb.append(e.getMessage());
                throw new NetworkIOException(sb.toString());
            }
        } else if (getUrl().toString().startsWith("http://")) {
            try {
                httpURLConnection = (HttpURLConnection) getUrl().openConnection();
            } catch (IOException e2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Open HTTP connection: ");
                sb2.append(e2.getMessage());
                throw new NetworkIOException(sb2.toString());
            }
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Invalid url-protocol in url: ");
            sb3.append(getUrl().toString());
            throw new IllegalArgumentException(sb3.toString());
        }
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setConnectTimeout(getConnectTimeout());
        httpURLConnection.setReadTimeout(getReadTimeout());
        try {
            httpURLConnection.setRequestMethod(getRequestType());
            if (getHeaders() != null && getHeaders().size() > 0) {
                for (String str : getHeaders().keySet()) {
                    for (String str2 : (List) getHeaders().get(str)) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("Setting header: ");
                        sb4.append(str);
                        sb4.append("=");
                        sb4.append(str2);
                        DeviceLog.debug(sb4.toString());
                        httpURLConnection.setRequestProperty(str, str2);
                    }
                }
            }
            return httpURLConnection;
        } catch (ProtocolException e3) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Set Request Method: ");
            sb5.append(getRequestType());
            sb5.append(", ");
            sb5.append(e3.getMessage());
            throw new NetworkIOException(sb5.toString());
        }
    }
}
