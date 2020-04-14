package com.tapjoy;

import com.appsflyer.share.Constants;
import com.tapjoy.TJAdUnitConstants.String;
import com.tapjoy.internal.C3066fj;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Map.Entry;

public class TapjoyURLConnection {
    public static final int TYPE_GET = 0;
    public static final int TYPE_POST = 1;

    /* renamed from: a */
    private final int f6599a = 15000;

    /* renamed from: b */
    private HttpURLConnection f6600b;

    public TapjoyHttpURLResponse getRedirectFromURL(String str) {
        return getResponseFromURL(str, "", 0, true, null, null, null);
    }

    public TapjoyHttpURLResponse getResponseFromURL(String str, Map map) {
        return getResponseFromURL(str, TapjoyUtil.convertURLParams(map, false), 0);
    }

    public TapjoyHttpURLResponse getResponseFromURL(String str, Map map, int i) {
        return getResponseFromURL(str, TapjoyUtil.convertURLParams(map, false), i);
    }

    public TapjoyHttpURLResponse getResponseFromURL(String str) {
        return getResponseFromURL(str, "", 0);
    }

    public TapjoyHttpURLResponse getResponseFromURL(String str, String str2) {
        return getResponseFromURL(str, str2, 0);
    }

    public TapjoyHttpURLResponse getResponseFromURL(String str, String str2, int i) {
        return getResponseFromURL(str, str2, i, false, null, null, null);
    }

    public TapjoyHttpURLResponse getResponseFromURL(String str, Map map, Map map2, Map map3) {
        return getResponseFromURL(str, map != null ? TapjoyUtil.convertURLParams(map, false) : "", 1, false, map2, "application/x-www-form-urlencoded", TapjoyUtil.convertURLParams(map3, false));
    }

    public TapjoyHttpURLResponse getResponseFromURL(String str, Map map, Map map2, Map map3, int i) {
        return getResponseFromURL(str, map != null ? TapjoyUtil.convertURLParams(map, false) : "", 1, false, map2, "application/x-www-form-urlencoded", TapjoyUtil.convertURLParams(map3, false), i);
    }

    public TapjoyHttpURLResponse getResponseFromURL(String str, Map map, Map map2, String str2) {
        return getResponseFromURL(str, map != null ? TapjoyUtil.convertURLParams(map, false) : "", 1, false, map2, "application/json;charset=utf-8", str2);
    }

    public TapjoyHttpURLResponse getResponseFromURL(String str, String str2, int i, boolean z, Map map, String str3, String str4) {
        return getResponseFromURL(str, str2, i, z, map, str3, str4, 15000);
    }

    public TapjoyHttpURLResponse getResponseFromURL(String str, String str2, int i, boolean z, Map map, String str3, String str4, int i2) {
        String str5 = "Exception: ";
        String str6 = "TapjoyURLConnection";
        TapjoyHttpURLResponse tapjoyHttpURLResponse = new TapjoyHttpURLResponse();
        this.f6600b = null;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(str2);
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder("http ");
            sb3.append(i == 0 ? "get" : "post");
            sb3.append(": ");
            sb3.append(sb2);
            TapjoyLog.m6553i(str6, sb3.toString());
            this.f6600b = (HttpURLConnection) C3066fj.m7086a(new URL(sb2));
            if (z) {
                this.f6600b.setInstanceFollowRedirects(false);
            }
            this.f6600b.setConnectTimeout(i2);
            this.f6600b.setReadTimeout(TapjoyConstants.TJC_PLACEMENT_RESPONSE_TIMEOUT);
            if (map != null) {
                for (Entry entry : map.entrySet()) {
                    this.f6600b.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
            }
            if (i == 1) {
                this.f6600b.setRequestMethod("POST");
                if (str4 != null) {
                    StringBuilder sb4 = new StringBuilder("Content-Type: ");
                    sb4.append(str3);
                    TapjoyLog.m6553i(str6, sb4.toString());
                    TapjoyLog.m6553i(str6, "Content:");
                    TapjoyLog.m6553i(str6, str4);
                    this.f6600b.setRequestProperty("Content-Type", str3);
                    this.f6600b.setRequestProperty("Connection", String.CLOSE);
                    this.f6600b.setDoOutput(true);
                    this.f6600b.setFixedLengthStreamingMode(str4.length());
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(this.f6600b.getOutputStream());
                    outputStreamWriter.write(str4);
                    outputStreamWriter.close();
                }
            }
            this.f6600b.connect();
            tapjoyHttpURLResponse.statusCode = this.f6600b.getResponseCode();
            tapjoyHttpURLResponse.headerFields = this.f6600b.getHeaderFields();
            tapjoyHttpURLResponse.date = this.f6600b.getDate();
            tapjoyHttpURLResponse.expires = this.f6600b.getExpiration();
            BufferedReader bufferedReader = !z ? new BufferedReader(new InputStreamReader(this.f6600b.getInputStream())) : null;
            if (!z) {
                StringBuilder sb5 = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(readLine);
                    sb6.append(10);
                    sb5.append(sb6.toString());
                }
                tapjoyHttpURLResponse.response = sb5.toString();
            }
            if (tapjoyHttpURLResponse.statusCode == 302) {
                tapjoyHttpURLResponse.redirectURL = this.f6600b.getHeaderField(Constants.HTTP_REDIRECT_URL_HEADER_FIELD);
            }
            String headerField = this.f6600b.getHeaderField("content-length");
            if (headerField != null) {
                try {
                    tapjoyHttpURLResponse.contentLength = Integer.valueOf(headerField).intValue();
                } catch (Exception e) {
                    StringBuilder sb7 = new StringBuilder(str5);
                    sb7.append(e.toString());
                    TapjoyLog.m6552e(str6, sb7.toString());
                }
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            this.f6600b = null;
        } catch (Exception e2) {
            StringBuilder sb8 = new StringBuilder(str5);
            sb8.append(e2.toString());
            TapjoyLog.m6552e(str6, sb8.toString());
            tapjoyHttpURLResponse.statusCode = 0;
            try {
                if (this.f6600b != null && tapjoyHttpURLResponse.response == null) {
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(this.f6600b.getErrorStream()));
                    StringBuilder sb9 = new StringBuilder();
                    while (true) {
                        String readLine2 = bufferedReader2.readLine();
                        if (readLine2 == null) {
                            break;
                        }
                        StringBuilder sb10 = new StringBuilder();
                        sb10.append(readLine2);
                        sb10.append(10);
                        sb9.append(sb10.toString());
                    }
                    tapjoyHttpURLResponse.response = sb9.toString();
                }
            } catch (Exception e3) {
                StringBuilder sb11 = new StringBuilder("Exception trying to get error code/content: ");
                sb11.append(e3.toString());
                TapjoyLog.m6552e(str6, sb11.toString());
            }
        }
        String str7 = "--------------------";
        TapjoyLog.m6553i(str6, str7);
        StringBuilder sb12 = new StringBuilder("response status: ");
        sb12.append(tapjoyHttpURLResponse.statusCode);
        TapjoyLog.m6553i(str6, sb12.toString());
        StringBuilder sb13 = new StringBuilder("response size: ");
        sb13.append(tapjoyHttpURLResponse.contentLength);
        TapjoyLog.m6553i(str6, sb13.toString());
        if (tapjoyHttpURLResponse.redirectURL != null && tapjoyHttpURLResponse.redirectURL.length() > 0) {
            StringBuilder sb14 = new StringBuilder("redirectURL: ");
            sb14.append(tapjoyHttpURLResponse.redirectURL);
            TapjoyLog.m6553i(str6, sb14.toString());
        }
        TapjoyLog.m6553i(str6, str7);
        return tapjoyHttpURLResponse;
    }

    public String getContentLength(String str) {
        String str2;
        String str3 = "TapjoyURLConnection";
        try {
            String replaceAll = str.replaceAll(" ", "%20");
            StringBuilder sb = new StringBuilder("requestURL: ");
            sb.append(replaceAll);
            TapjoyLog.m6550d(str3, sb.toString());
            HttpURLConnection httpURLConnection = (HttpURLConnection) C3066fj.m7086a(new URL(replaceAll));
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setReadTimeout(TapjoyConstants.TJC_PLACEMENT_RESPONSE_TIMEOUT);
            str2 = httpURLConnection.getHeaderField("content-length");
        } catch (Exception e) {
            StringBuilder sb2 = new StringBuilder("Exception: ");
            sb2.append(e.toString());
            TapjoyLog.m6552e(str3, sb2.toString());
            str2 = null;
        }
        StringBuilder sb3 = new StringBuilder("content-length: ");
        sb3.append(str2);
        TapjoyLog.m6550d(str3, sb3.toString());
        return str2;
    }

    public void disconnect() {
        HttpURLConnection httpURLConnection = this.f6600b;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
            this.f6600b = null;
        }
    }
}
