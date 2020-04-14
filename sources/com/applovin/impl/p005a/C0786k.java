package com.applovin.impl.p005a;

import android.net.Uri;
import android.webkit.URLUtil;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.utils.C1277l;
import com.applovin.impl.sdk.utils.C1283q;
import java.util.Locale;

/* renamed from: com.applovin.impl.a.k */
public class C0786k {

    /* renamed from: a */
    private Uri f1307a;

    /* renamed from: b */
    private Uri f1308b;

    /* renamed from: c */
    private C0787a f1309c;

    /* renamed from: d */
    private String f1310d;

    /* renamed from: e */
    private int f1311e;

    /* renamed from: f */
    private int f1312f;

    /* renamed from: g */
    private int f1313g;

    /* renamed from: com.applovin.impl.a.k$a */
    public enum C0787a {
        Progressive,
        Streaming
    }

    private C0786k() {
    }

    /* renamed from: a */
    private static C0787a m1101a(String str) {
        if (C1277l.m3042b(str)) {
            if ("progressive".equalsIgnoreCase(str)) {
                return C0787a.Progressive;
            }
            if ("streaming".equalsIgnoreCase(str)) {
                return C0787a.Streaming;
            }
        }
        return C0787a.Progressive;
    }

    /* renamed from: a */
    public static C0786k m1102a(C1283q qVar, C1192i iVar) {
        String str = "VastVideoFile";
        if (qVar == null) {
            throw new IllegalArgumentException("No node specified.");
        } else if (iVar != null) {
            try {
                String c = qVar.mo10452c();
                if (URLUtil.isValidUrl(c)) {
                    Uri parse = Uri.parse(c);
                    C0786k kVar = new C0786k();
                    kVar.f1307a = parse;
                    kVar.f1308b = parse;
                    kVar.f1313g = C1277l.m3031a((String) qVar.mo10450b().get("bitrate"));
                    kVar.f1309c = m1101a((String) qVar.mo10450b().get("delivery"));
                    kVar.f1312f = C1277l.m3031a((String) qVar.mo10450b().get("height"));
                    kVar.f1311e = C1277l.m3031a((String) qVar.mo10450b().get("width"));
                    kVar.f1310d = ((String) qVar.mo10450b().get("type")).toLowerCase(Locale.ENGLISH);
                    return kVar;
                }
                iVar.mo10249v().mo10382e(str, "Unable to create video file. Could not find URL.");
                return null;
            } catch (Throwable th) {
                iVar.mo10249v().mo10379b(str, "Error occurred while initializing", th);
            }
        } else {
            throw new IllegalArgumentException("No sdk specified.");
        }
    }

    /* renamed from: a */
    public Uri mo8958a() {
        return this.f1307a;
    }

    /* renamed from: a */
    public void mo8959a(Uri uri) {
        this.f1308b = uri;
    }

    /* renamed from: b */
    public Uri mo8960b() {
        return this.f1308b;
    }

    /* renamed from: c */
    public boolean mo8961c() {
        return this.f1309c == C0787a.Streaming;
    }

    /* renamed from: d */
    public String mo8962d() {
        return this.f1310d;
    }

    /* renamed from: e */
    public int mo8963e() {
        return this.f1313g;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0786k)) {
            return false;
        }
        C0786k kVar = (C0786k) obj;
        if (this.f1311e != kVar.f1311e || this.f1312f != kVar.f1312f || this.f1313g != kVar.f1313g) {
            return false;
        }
        Uri uri = this.f1307a;
        if (uri == null ? kVar.f1307a != null : !uri.equals(kVar.f1307a)) {
            return false;
        }
        Uri uri2 = this.f1308b;
        if (uri2 == null ? kVar.f1308b != null : !uri2.equals(kVar.f1308b)) {
            return false;
        }
        if (this.f1309c != kVar.f1309c) {
            return false;
        }
        String str = this.f1310d;
        if (str != null) {
            z = str.equals(kVar.f1310d);
        } else if (kVar.f1310d != null) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        Uri uri = this.f1307a;
        int i = 0;
        int hashCode = (uri != null ? uri.hashCode() : 0) * 31;
        Uri uri2 = this.f1308b;
        int hashCode2 = (hashCode + (uri2 != null ? uri2.hashCode() : 0)) * 31;
        C0787a aVar = this.f1309c;
        int hashCode3 = (hashCode2 + (aVar != null ? aVar.hashCode() : 0)) * 31;
        String str = this.f1310d;
        if (str != null) {
            i = str.hashCode();
        }
        return ((((((hashCode3 + i) * 31) + this.f1311e) * 31) + this.f1312f) * 31) + this.f1313g;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VastVideoFile{sourceVideoUri=");
        sb.append(this.f1307a);
        sb.append(", videoUri=");
        sb.append(this.f1308b);
        sb.append(", deliveryType=");
        sb.append(this.f1309c);
        sb.append(", fileType='");
        sb.append(this.f1310d);
        sb.append('\'');
        sb.append(", width=");
        sb.append(this.f1311e);
        sb.append(", height=");
        sb.append(this.f1312f);
        sb.append(", bitrate=");
        sb.append(this.f1313g);
        sb.append('}');
        return sb.toString();
    }
}
