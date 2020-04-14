package com.adcolony.sdk;

public abstract class AdColonyAdViewListener {

    /* renamed from: a */
    String f94a = "";

    /* renamed from: b */
    AdColonyAdSize f95b;

    /* renamed from: c */
    C0487ag f96c;

    public void onClicked(AdColonyAdView adColonyAdView) {
    }

    public void onClosed(AdColonyAdView adColonyAdView) {
    }

    public void onLeftApplication(AdColonyAdView adColonyAdView) {
    }

    public void onOpened(AdColonyAdView adColonyAdView) {
    }

    public abstract void onRequestFilled(AdColonyAdView adColonyAdView);

    public void onRequestNotFilled(AdColonyZone adColonyZone) {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo8069a() {
        return this.f94a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public AdColonyAdSize mo8073b() {
        return this.f95b;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public C0487ag mo8074c() {
        return this.f96c;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8071a(C0487ag agVar) {
        this.f96c = agVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8072a(String str) {
        this.f94a = str;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8070a(AdColonyAdSize adColonyAdSize) {
        this.f95b = adColonyAdSize;
    }
}
