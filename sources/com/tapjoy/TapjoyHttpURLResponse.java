package com.tapjoy;

import java.util.List;
import java.util.Map;

public class TapjoyHttpURLResponse {
    public int contentLength;
    public long date;
    public long expires;
    public Map headerFields;
    public String redirectURL;
    public String response;
    public int statusCode;

    public String getHeaderFieldAsString(String str) {
        Map map = this.headerFields;
        if (map != null) {
            List list = (List) map.get(str);
            if (!(list == null || list.get(0) == null)) {
                return (String) list.get(0);
            }
        }
        return "";
    }
}
