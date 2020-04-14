package bolts;

import android.content.Context;
import android.net.Uri;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.appsflyer.share.Constants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WebViewAppLinkResolver implements AppLinkResolver {
    private static final String KEY_AL_VALUE = "value";
    private static final String KEY_ANDROID = "android";
    private static final String KEY_APP_NAME = "app_name";
    private static final String KEY_CLASS = "class";
    private static final String KEY_PACKAGE = "package";
    private static final String KEY_SHOULD_FALLBACK = "should_fallback";
    private static final String KEY_URL = "url";
    private static final String KEY_WEB = "web";
    private static final String KEY_WEB_URL = "url";
    private static final String META_TAG_PREFIX = "al";
    private static final String PREFER_HEADER = "Prefer-Html-Meta-Tags";
    private static final String TAG_EXTRACTION_JAVASCRIPT = "javascript:boltsWebViewAppLinkResolverResult.setValue((function() {  var metaTags = document.getElementsByTagName('meta');  var results = [];  for (var i = 0; i < metaTags.length; i++) {    var property = metaTags[i].getAttribute('property');    if (property && property.substring(0, 'al:'.length) === 'al:') {      var tag = { \"property\": metaTags[i].getAttribute('property') };      if (metaTags[i].hasAttribute('content')) {        tag['content'] = metaTags[i].getAttribute('content');      }      results.push(tag);    }  }  return JSON.stringify(results);})())";
    /* access modifiers changed from: private */
    public final Context context;

    public WebViewAppLinkResolver(Context context2) {
        this.context = context2;
    }

    public Task<AppLink> getAppLinkFromUrlInBackground(final Uri uri) {
        final Capture capture = new Capture();
        final Capture capture2 = new Capture();
        return Task.callInBackground(new Callable<Void>() {
            public Void call() throws Exception {
                URL url = new URL(uri.toString());
                URLConnection uRLConnection = null;
                while (url != null) {
                    uRLConnection = url.openConnection();
                    boolean z = uRLConnection instanceof HttpURLConnection;
                    if (z) {
                        ((HttpURLConnection) uRLConnection).setInstanceFollowRedirects(true);
                    }
                    uRLConnection.setRequestProperty(WebViewAppLinkResolver.PREFER_HEADER, WebViewAppLinkResolver.META_TAG_PREFIX);
                    uRLConnection.connect();
                    if (z) {
                        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnection;
                        if (httpURLConnection.getResponseCode() >= 300 && httpURLConnection.getResponseCode() < 400) {
                            URL url2 = new URL(httpURLConnection.getHeaderField(Constants.HTTP_REDIRECT_URL_HEADER_FIELD));
                            httpURLConnection.disconnect();
                            url = url2;
                        }
                    }
                    url = null;
                }
                try {
                    capture.set(WebViewAppLinkResolver.readFromConnection(uRLConnection));
                    capture2.set(uRLConnection.getContentType());
                    return null;
                } finally {
                    if (uRLConnection instanceof HttpURLConnection) {
                        ((HttpURLConnection) uRLConnection).disconnect();
                    }
                }
            }
        }).onSuccessTask((Continuation<TResult, Task<TContinuationResult>>) new Continuation<Void, Task<JSONArray>>() {
            public Task<JSONArray> then(Task<Void> task) throws Exception {
                final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
                WebView webView = new WebView(WebViewAppLinkResolver.this.context);
                webView.getSettings().setJavaScriptEnabled(true);
                webView.setNetworkAvailable(false);
                webView.setWebViewClient(new WebViewClient() {
                    private boolean loaded = false;

                    private void runJavaScript(WebView webView) {
                        if (!this.loaded) {
                            this.loaded = true;
                            webView.loadUrl(WebViewAppLinkResolver.TAG_EXTRACTION_JAVASCRIPT);
                        }
                    }

                    public void onPageFinished(WebView webView, String str) {
                        super.onPageFinished(webView, str);
                        runJavaScript(webView);
                    }

                    public void onLoadResource(WebView webView, String str) {
                        super.onLoadResource(webView, str);
                        runJavaScript(webView);
                    }
                });
                webView.addJavascriptInterface(new Object() {
                    @JavascriptInterface
                    public void setValue(String str) {
                        try {
                            taskCompletionSource.trySetResult(new JSONArray(str));
                        } catch (JSONException e) {
                            taskCompletionSource.trySetError(e);
                        }
                    }
                }, "boltsWebViewAppLinkResolverResult");
                webView.loadDataWithBaseURL(uri.toString(), (String) capture.get(), capture2.get() != null ? ((String) capture2.get()).split(";")[0] : null, null, null);
                return taskCompletionSource.getTask();
            }
        }, Task.UI_THREAD_EXECUTOR).onSuccess(new Continuation<JSONArray, AppLink>() {
            public AppLink then(Task<JSONArray> task) throws Exception {
                return WebViewAppLinkResolver.makeAppLinkFromAlData(WebViewAppLinkResolver.parseAlData((JSONArray) task.getResult()), uri);
            }
        });
    }

    /* access modifiers changed from: private */
    public static Map<String, Object> parseAlData(JSONArray jSONArray) throws JSONException {
        Map hashMap = new HashMap();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            String[] split = jSONObject.getString("property").split(":");
            if (split[0].equals(META_TAG_PREFIX)) {
                Map map = hashMap;
                int i2 = 1;
                while (true) {
                    Map map2 = null;
                    if (i2 >= split.length) {
                        break;
                    }
                    List list = (List) map.get(split[i2]);
                    if (list == null) {
                        list = new ArrayList();
                        map.put(split[i2], list);
                    }
                    if (list.size() > 0) {
                        map2 = (Map) list.get(list.size() - 1);
                    }
                    if (map2 == null || i2 == split.length - 1) {
                        map = new HashMap();
                        list.add(map);
                    } else {
                        map = map2;
                    }
                    i2++;
                }
                String str = "content";
                if (jSONObject.has(str)) {
                    String str2 = "value";
                    if (jSONObject.isNull(str)) {
                        map.put(str2, null);
                    } else {
                        map.put(str2, jSONObject.getString(str));
                    }
                }
            }
        }
        return hashMap;
    }

    private static List<Map<String, Object>> getAlList(Map<String, Object> map, String str) {
        List<Map<String, Object>> list = (List) map.get(str);
        return list == null ? Collections.emptyList() : list;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x011b, code lost:
        if (java.util.Arrays.asList(new java.lang.String[]{"no", "false", com.facebook.appevents.AppEventsConstants.EVENT_PARAM_VALUE_NO}).contains(((java.lang.String) ((java.util.Map) r0.get(0)).get(r7)).toLowerCase()) != false) goto L_0x0120;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static bolts.AppLink makeAppLinkFromAlData(java.util.Map<java.lang.String, java.lang.Object> r16, android.net.Uri r17) {
        /*
            r0 = r16
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.lang.String r2 = "android"
            java.lang.Object r2 = r0.get(r2)
            java.util.List r2 = (java.util.List) r2
            if (r2 != 0) goto L_0x0015
            java.util.List r2 = java.util.Collections.emptyList()
        L_0x0015:
            java.util.Iterator r2 = r2.iterator()
        L_0x0019:
            boolean r3 = r2.hasNext()
            java.lang.String r4 = "url"
            r5 = 0
            r6 = 0
            java.lang.String r7 = "value"
            if (r3 == 0) goto L_0x00c6
            java.lang.Object r3 = r2.next()
            java.util.Map r3 = (java.util.Map) r3
            java.util.List r4 = getAlList(r3, r4)
            java.lang.String r8 = "package"
            java.util.List r8 = getAlList(r3, r8)
            java.lang.String r9 = "class"
            java.util.List r9 = getAlList(r3, r9)
            java.lang.String r10 = "app_name"
            java.util.List r3 = getAlList(r3, r10)
            int r10 = r4.size()
            int r11 = r8.size()
            int r12 = r9.size()
            int r13 = r3.size()
            int r12 = java.lang.Math.max(r12, r13)
            int r11 = java.lang.Math.max(r11, r12)
            int r10 = java.lang.Math.max(r10, r11)
        L_0x005d:
            if (r6 >= r10) goto L_0x0019
            int r11 = r4.size()
            if (r11 <= r6) goto L_0x0070
            java.lang.Object r11 = r4.get(r6)
            java.util.Map r11 = (java.util.Map) r11
            java.lang.Object r11 = r11.get(r7)
            goto L_0x0071
        L_0x0070:
            r11 = r5
        L_0x0071:
            java.lang.String r11 = (java.lang.String) r11
            java.lang.String r11 = (java.lang.String) r11
            android.net.Uri r11 = tryCreateUrl(r11)
            int r12 = r8.size()
            if (r12 <= r6) goto L_0x008a
            java.lang.Object r12 = r8.get(r6)
            java.util.Map r12 = (java.util.Map) r12
            java.lang.Object r12 = r12.get(r7)
            goto L_0x008b
        L_0x008a:
            r12 = r5
        L_0x008b:
            java.lang.String r12 = (java.lang.String) r12
            java.lang.String r12 = (java.lang.String) r12
            int r13 = r9.size()
            if (r13 <= r6) goto L_0x00a0
            java.lang.Object r13 = r9.get(r6)
            java.util.Map r13 = (java.util.Map) r13
            java.lang.Object r13 = r13.get(r7)
            goto L_0x00a1
        L_0x00a0:
            r13 = r5
        L_0x00a1:
            java.lang.String r13 = (java.lang.String) r13
            java.lang.String r13 = (java.lang.String) r13
            int r14 = r3.size()
            if (r14 <= r6) goto L_0x00b6
            java.lang.Object r14 = r3.get(r6)
            java.util.Map r14 = (java.util.Map) r14
            java.lang.Object r14 = r14.get(r7)
            goto L_0x00b7
        L_0x00b6:
            r14 = r5
        L_0x00b7:
            java.lang.String r14 = (java.lang.String) r14
            java.lang.String r14 = (java.lang.String) r14
            bolts.AppLink$Target r15 = new bolts.AppLink$Target
            r15.<init>(r12, r13, r11, r14)
            r1.add(r15)
            int r6 = r6 + 1
            goto L_0x005d
        L_0x00c6:
            java.lang.String r2 = "web"
            java.lang.Object r0 = r0.get(r2)
            java.util.List r0 = (java.util.List) r0
            if (r0 == 0) goto L_0x013d
            int r2 = r0.size()
            if (r2 <= 0) goto L_0x013d
            java.lang.Object r0 = r0.get(r6)
            java.util.Map r0 = (java.util.Map) r0
            java.lang.Object r2 = r0.get(r4)
            java.util.List r2 = (java.util.List) r2
            java.lang.String r3 = "should_fallback"
            java.lang.Object r0 = r0.get(r3)
            java.util.List r0 = (java.util.List) r0
            if (r0 == 0) goto L_0x011e
            int r3 = r0.size()
            if (r3 <= 0) goto L_0x011e
            java.lang.Object r0 = r0.get(r6)
            java.util.Map r0 = (java.util.Map) r0
            java.lang.Object r0 = r0.get(r7)
            java.lang.String r0 = (java.lang.String) r0
            r3 = 3
            java.lang.String[] r3 = new java.lang.String[r3]
            java.lang.String r4 = "no"
            r3[r6] = r4
            r4 = 1
            java.lang.String r8 = "false"
            r3[r4] = r8
            r4 = 2
            java.lang.String r8 = "0"
            r3[r4] = r8
            java.util.List r3 = java.util.Arrays.asList(r3)
            java.lang.String r0 = r0.toLowerCase()
            boolean r0 = r3.contains(r0)
            if (r0 == 0) goto L_0x011e
            goto L_0x0120
        L_0x011e:
            r5 = r17
        L_0x0120:
            if (r5 == 0) goto L_0x013b
            if (r2 == 0) goto L_0x013b
            int r0 = r2.size()
            if (r0 <= 0) goto L_0x013b
            java.lang.Object r0 = r2.get(r6)
            java.util.Map r0 = (java.util.Map) r0
            java.lang.Object r0 = r0.get(r7)
            java.lang.String r0 = (java.lang.String) r0
            android.net.Uri r0 = tryCreateUrl(r0)
            goto L_0x013f
        L_0x013b:
            r0 = r5
            goto L_0x013f
        L_0x013d:
            r0 = r17
        L_0x013f:
            bolts.AppLink r2 = new bolts.AppLink
            r3 = r17
            r2.<init>(r3, r1, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: bolts.WebViewAppLinkResolver.makeAppLinkFromAlData(java.util.Map, android.net.Uri):bolts.AppLink");
    }

    private static Uri tryCreateUrl(String str) {
        if (str == null) {
            return null;
        }
        return Uri.parse(str);
    }

    /* access modifiers changed from: private */
    public static String readFromConnection(URLConnection uRLConnection) throws IOException {
        InputStream inputStream;
        int i;
        if (uRLConnection instanceof HttpURLConnection) {
            try {
                inputStream = uRLConnection.getInputStream();
            } catch (Exception unused) {
                inputStream = ((HttpURLConnection) uRLConnection).getErrorStream();
            }
        } else {
            inputStream = uRLConnection.getInputStream();
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                i = 0;
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            String contentEncoding = uRLConnection.getContentEncoding();
            if (contentEncoding == null) {
                String[] split = uRLConnection.getContentType().split(";");
                int length = split.length;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    String trim = split[i].trim();
                    if (trim.startsWith("charset=")) {
                        contentEncoding = trim.substring(8);
                        break;
                    }
                    i++;
                }
                if (contentEncoding == null) {
                    contentEncoding = "UTF-8";
                }
            }
            return new String(byteArrayOutputStream.toByteArray(), contentEncoding);
        } finally {
            inputStream.close();
        }
    }
}
