package com.adcolony.sdk;

import com.appsflyer.share.Constants;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* renamed from: com.adcolony.sdk.x */
class C0750x {

    /* renamed from: l */
    static final SimpleDateFormat f1176l = new SimpleDateFormat("yyyyMMdd'T'HHmmss.SSSZ", Locale.US);

    /* renamed from: m */
    static final String f1177m = "message";

    /* renamed from: n */
    static final String f1178n = "timestamp";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Date f1179a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f1180b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C0745t f1181c;

    /* renamed from: o */
    protected String f1182o;

    /* renamed from: com.adcolony.sdk.x$a */
    static class C0751a {

        /* renamed from: b */
        protected C0750x f1183b = new C0750x();

        C0751a() {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C0751a mo8737a(int i) {
            this.f1183b.f1180b = i;
            return this;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C0751a mo8738a(C0745t tVar) {
            this.f1183b.f1181c = tVar;
            return this;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C0751a mo8739a(String str) {
            this.f1183b.f1182o = str;
            return this;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C0751a mo8690a(Date date) {
            this.f1183b.f1179a = date;
            return this;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C0750x mo8740a() {
            if (this.f1183b.f1179a == null) {
                this.f1183b.f1179a = new Date(System.currentTimeMillis());
            }
            return this.f1183b;
        }
    }

    C0750x() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8730a(C0745t tVar) {
        this.f1181c = tVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8729a(int i) {
        this.f1180b = i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public String mo8731b() {
        int i = this.f1180b;
        if (i == -1) {
            return "Fatal";
        }
        if (i == 0) {
            return "Error";
        }
        if (i == 1) {
            return "Warn";
        }
        if (i != 2) {
            return i != 3 ? "UNKNOWN LOG LEVEL" : "Debug";
        }
        return "Info";
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public int mo8732c() {
        return this.f1180b;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public String mo8733d() {
        return this.f1182o;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public String mo8734e() {
        return f1176l.format(this.f1179a);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public C0745t mo8735f() {
        return this.f1181c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(mo8734e());
        sb.append(" ");
        sb.append(mo8731b());
        sb.append(Constants.URL_PATH_DELIMITER);
        sb.append(mo8735f().mo8720d());
        sb.append(": ");
        sb.append(mo8733d());
        return sb.toString();
    }
}
