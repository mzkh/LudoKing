package com.tapjoy;

import com.tapjoy.internal.C1852jq;
import java.io.Serializable;

public class TJPlacementData implements Serializable {

    /* renamed from: a */
    private String f6377a;

    /* renamed from: b */
    private String f6378b;

    /* renamed from: c */
    private String f6379c;

    /* renamed from: d */
    private String f6380d;

    /* renamed from: e */
    private String f6381e;

    /* renamed from: f */
    private String f6382f;

    /* renamed from: g */
    private int f6383g;

    /* renamed from: h */
    private String f6384h;

    /* renamed from: i */
    private String f6385i;

    /* renamed from: j */
    private int f6386j;

    /* renamed from: k */
    private boolean f6387k;

    /* renamed from: l */
    private String f6388l;

    /* renamed from: m */
    private boolean f6389m;

    /* renamed from: n */
    private String f6390n;

    /* renamed from: o */
    private String f6391o;

    /* renamed from: p */
    private boolean f6392p = true;

    /* renamed from: q */
    private boolean f6393q = false;

    public TJPlacementData(String str, String str2) {
        setKey(str);
        updateUrl(str2);
        setPlacementType(TapjoyConstants.TJC_APP_PLACEMENT);
    }

    public TJPlacementData(String str, String str2, String str3) {
        setBaseURL(str);
        setHttpResponse(str2);
        this.f6390n = str3;
        this.f6392p = false;
        setPlacementType(TapjoyConstants.TJC_APP_PLACEMENT);
    }

    public void resetPlacementRequestData() {
        setHttpResponse(null);
        setHttpStatusCode(0);
        setRedirectURL(null);
        setHasProgressSpinner(false);
        setPrerenderingRequested(false);
        setPreloadDisabled(false);
        setContentViewId(null);
    }

    public String getCallbackID() {
        return this.f6390n;
    }

    public boolean isBaseActivity() {
        return this.f6392p;
    }

    public void setKey(String str) {
        this.f6377a = str;
    }

    public void setBaseURL(String str) {
        this.f6379c = str;
    }

    public void setMediationURL(String str) {
        this.f6380d = str;
    }

    public void setAuctionMediationURL(String str) {
        this.f6381e = str;
    }

    public void setHttpResponse(String str) {
        this.f6382f = str;
    }

    public void setHttpStatusCode(int i) {
        this.f6383g = i;
    }

    public void setPlacementName(String str) {
        this.f6384h = str;
    }

    public void setPlacementType(String str) {
        this.f6385i = str;
    }

    public void setViewType(int i) {
        this.f6386j = i;
    }

    public void setRedirectURL(String str) {
        this.f6388l = str;
    }

    public void setHasProgressSpinner(boolean z) {
        this.f6387k = z;
    }

    public void setContentViewId(String str) {
        this.f6391o = str;
    }

    public String getUrl() {
        return this.f6378b;
    }

    public String getKey() {
        return this.f6377a;
    }

    public String getBaseURL() {
        return this.f6379c;
    }

    public String getMediationURL() {
        return this.f6380d;
    }

    public String getAuctionMediationURL() {
        return this.f6381e;
    }

    public String getHttpResponse() {
        return this.f6382f;
    }

    public int getHttpStatusCode() {
        return this.f6383g;
    }

    public String getPlacementName() {
        return this.f6384h;
    }

    public String getPlacementType() {
        return this.f6385i;
    }

    public int getViewType() {
        return this.f6386j;
    }

    public String getRedirectURL() {
        return this.f6388l;
    }

    public String getContentViewId() {
        return this.f6391o;
    }

    public boolean hasProgressSpinner() {
        return this.f6387k;
    }

    public void setPreloadDisabled(boolean z) {
        this.f6393q = z;
    }

    public boolean isPreloadDisabled() {
        return this.f6393q;
    }

    public boolean isPrerenderingRequested() {
        return this.f6389m;
    }

    public void setPrerenderingRequested(boolean z) {
        this.f6389m = z;
    }

    public void updateUrl(String str) {
        this.f6378b = str;
        if (!C1852jq.m3669c(str)) {
            setBaseURL(str.substring(0, str.indexOf(47, str.indexOf("//") + 3)));
        }
    }
}
