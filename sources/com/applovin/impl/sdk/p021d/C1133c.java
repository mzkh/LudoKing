package com.applovin.impl.sdk.p021d;

import android.net.Uri;
import com.applovin.impl.mediation.C1041k.C1042a;
import com.applovin.impl.mediation.p014b.C0958a;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.C1206m;
import com.applovin.impl.sdk.network.C1211a.C1212a;
import com.applovin.impl.sdk.network.C1211a.C1214c;
import com.applovin.impl.sdk.network.C1215b;
import com.applovin.impl.sdk.p018ad.C1084f;
import com.applovin.impl.sdk.p019b.C1096c;
import com.applovin.impl.sdk.p020c.C1108d;
import com.applovin.impl.sdk.p020c.C1109e;
import com.applovin.impl.sdk.utils.C1277l;
import com.applovin.impl.sdk.utils.C1281o;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinErrorCodes;
import com.appsflyer.share.Constants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.applovin.impl.sdk.d.c */
abstract class C1133c extends C1122a implements C1042a {

    /* renamed from: a */
    protected final C1084f f2759a;

    /* renamed from: c */
    private AppLovinAdLoadListener f2760c;

    /* renamed from: d */
    private final C1206m f2761d;

    /* renamed from: e */
    private final Collection<Character> f2762e;

    /* renamed from: f */
    private final C1109e f2763f;

    /* renamed from: g */
    private boolean f2764g;

    C1133c(String str, C1084f fVar, C1192i iVar, AppLovinAdLoadListener appLovinAdLoadListener) {
        super(str, iVar);
        if (fVar != null) {
            this.f2759a = fVar;
            this.f2760c = appLovinAdLoadListener;
            this.f2761d = iVar.mo10196V();
            this.f2762e = m2345j();
            this.f2763f = new C1109e();
            return;
        }
        throw new IllegalArgumentException("No ad specified.");
    }

    /* renamed from: a */
    private Uri m2342a(Uri uri, String str) {
        String str2;
        StringBuilder sb;
        if (uri != null) {
            String uri2 = uri.toString();
            if (C1277l.m3042b(uri2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Caching ");
                sb2.append(str);
                sb2.append(" image...");
                mo10068a(sb2.toString());
                return m2344g(uri2);
            }
            sb = new StringBuilder();
            sb.append("Failed to cache ");
            sb.append(str);
            str2 = " image";
        } else {
            sb = new StringBuilder();
            sb.append("No ");
            sb.append(str);
            str2 = " image to cache";
        }
        sb.append(str2);
        mo10068a(sb.toString());
        return null;
    }

    /* renamed from: a */
    private String m2343a(String str, String str2) {
        StringBuilder sb;
        String replace = str2.replace(Constants.URL_PATH_DELIMITER, "_");
        String G = this.f2759a.mo9869G();
        if (C1277l.m3042b(G)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(G);
            sb2.append(replace);
            replace = sb2.toString();
        }
        File a = this.f2761d.mo10273a(replace, this.f2745b.mo10179D());
        if (a == null) {
            return null;
        }
        String str3 = "file://";
        if (a.exists()) {
            this.f2763f.mo10021b(a.length());
            sb = new StringBuilder();
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            sb3.append(str2);
            if (!this.f2761d.mo10278a(a, sb3.toString(), Arrays.asList(new String[]{str}), this.f2763f)) {
                return null;
            }
            sb = new StringBuilder();
        }
        sb.append(str3);
        sb.append(a.getAbsolutePath());
        return sb.toString();
    }

    /* renamed from: g */
    private Uri m2344g(String str) {
        return mo10091b(str, this.f2759a.mo9868F(), true);
    }

    /* renamed from: j */
    private Collection<Character> m2345j() {
        HashSet hashSet = new HashSet();
        for (char valueOf : ((String) this.f2745b.mo10202a(C1096c.f2346bH)).toCharArray()) {
            hashSet.add(Character.valueOf(valueOf));
        }
        hashSet.add(Character.valueOf('\"'));
        return hashSet;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Uri mo10087a(String str, List<String> list, boolean z) {
        String str2;
        try {
            if (C1277l.m3042b(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Caching video ");
                sb.append(str);
                sb.append("...");
                mo10068a(sb.toString());
                String a = this.f2761d.mo10274a(mo10075g(), str, this.f2759a.mo9869G(), list, z, this.f2763f);
                if (C1277l.m3042b(a)) {
                    File a2 = this.f2761d.mo10273a(a, mo10075g());
                    if (a2 != null) {
                        Uri fromFile = Uri.fromFile(a2);
                        if (fromFile != null) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Finish caching video for ad #");
                            sb2.append(this.f2759a.getAdIdNumber());
                            sb2.append(". Updating ad with cachedVideoFilename = ");
                            sb2.append(a);
                            mo10068a(sb2.toString());
                            return fromFile;
                        }
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Unable to create URI from cached video file = ");
                        sb3.append(a2);
                        str2 = sb3.toString();
                    } else {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("Unable to cache video = ");
                        sb4.append(str);
                        sb4.append("Video file was missing or null - please make sure your app has the WRITE_EXTERNAL_STORAGE permission!");
                        str2 = sb4.toString();
                    }
                } else if (((Boolean) this.f2745b.mo10202a(C1096c.f2349bK)).booleanValue()) {
                    mo10072d("Failed to cache video");
                    C1281o.m3082a(this.f2760c, this.f2759a.getAdZone(), AppLovinErrorCodes.UNABLE_TO_PRECACHE_VIDEO_RESOURCES, this.f2745b);
                    this.f2760c = null;
                } else {
                    str2 = "Failed to cache video, but not failing ad load";
                }
                mo10072d(str2);
            }
        } catch (Exception e) {
            mo10069a("Encountered exception while attempting to cache video.", e);
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo10088a(String str, List<String> list) {
        if (C1277l.m3042b(str)) {
            Uri parse = Uri.parse(str);
            if (parse == null) {
                mo10068a("Nothing to cache, skipping...");
                return null;
            }
            String lastPathSegment = parse.getLastPathSegment();
            if (C1277l.m3042b(this.f2759a.mo9869G())) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.f2759a.mo9869G());
                sb.append(lastPathSegment);
                lastPathSegment = sb.toString();
            }
            File a = this.f2761d.mo10273a(lastPathSegment, mo10075g());
            ByteArrayOutputStream a2 = (a == null || !a.exists()) ? null : this.f2761d.mo10271a(a);
            if (a2 == null) {
                a2 = this.f2761d.mo10272a(str, list, true);
                if (a2 != null) {
                    this.f2761d.mo10277a(a2, a);
                    this.f2763f.mo10020a((long) a2.size());
                }
            } else {
                this.f2763f.mo10021b((long) a2.size());
            }
            try {
                return a2.toString("UTF-8");
            } catch (UnsupportedEncodingException e) {
                mo10069a("UTF-8 encoding not supported.", e);
            } catch (Throwable th) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("String resource at ");
                sb2.append(str);
                sb2.append(" failed to load.");
                mo10069a(sb2.toString(), th);
                return null;
            }
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo10089a(String str, List<String> list, C1084f fVar) {
        if (!C1277l.m3042b(str)) {
            return str;
        }
        if (!((Boolean) this.f2745b.mo10202a(C1096c.f2348bJ)).booleanValue()) {
            mo10068a("Resource caching is disabled, skipping cache...");
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        boolean shouldCancelHtmlCachingIfShown = fVar.shouldCancelHtmlCachingIfShown();
        for (String str2 : list) {
            int i = 0;
            int i2 = 0;
            while (i < sb.length()) {
                if (mo10093c()) {
                    return str;
                }
                i = sb.indexOf(str2, i2);
                if (i == -1) {
                    continue;
                    break;
                }
                int length = sb.length();
                int i3 = i;
                while (!this.f2762e.contains(Character.valueOf(sb.charAt(i3))) && i3 < length) {
                    i3++;
                }
                if (i3 <= i || i3 == length) {
                    mo10072d("Unable to cache resource; ad HTML is invalid.");
                    return str;
                }
                String substring = sb.substring(str2.length() + i, i3);
                if (!C1277l.m3042b(substring)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Skip caching of non-resource ");
                    sb2.append(substring);
                    mo10068a(sb2.toString());
                } else if (!shouldCancelHtmlCachingIfShown || !fVar.hasShown()) {
                    String a = m2343a(str2, substring);
                    if (a != null) {
                        sb.replace(i, i3, a);
                        this.f2763f.mo10025e();
                    } else {
                        this.f2763f.mo10026f();
                    }
                } else {
                    mo10068a("Cancelling HTML caching due to ad being shown already");
                    this.f2763f.mo10019a();
                    return str;
                }
                i2 = i3;
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    public void mo9631a(C0958a aVar) {
        if (aVar.mo9427b().equalsIgnoreCase(this.f2759a.mo9873K())) {
            mo10072d("Updating flag for timeout...");
            this.f2764g = true;
        }
        this.f2745b.mo10176A().mo9630b(this);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo10090a(AppLovinAdBase appLovinAdBase) {
        C1108d.m2214a(this.f2763f, appLovinAdBase, this.f2745b);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public Uri mo10091b(String str, List<String> list, boolean z) {
        String sb;
        try {
            String a = this.f2761d.mo10274a(mo10075g(), str, this.f2759a.mo9869G(), list, z, this.f2763f);
            if (C1277l.m3042b(a)) {
                File a2 = this.f2761d.mo10273a(a, mo10075g());
                if (a2 != null) {
                    Uri fromFile = Uri.fromFile(a2);
                    if (fromFile != null) {
                        return fromFile;
                    }
                    sb = "Unable to extract Uri from image file";
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Unable to retrieve File from cached image filename = ");
                    sb2.append(a);
                    sb = sb2.toString();
                }
                mo10072d(sb);
            }
        } catch (Throwable th) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Failed to cache image at url = ");
            sb3.append(str);
            mo10069a(sb3.toString(), th);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo10092b() {
        this.f2745b.mo10176A().mo9630b(this);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public boolean mo10093c() {
        return this.f2764g;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo10094d() {
        mo10068a("Caching mute images...");
        Uri a = m2342a(this.f2759a.mo9919ay(), "mute");
        if (a != null) {
            this.f2759a.mo9922b(a);
        }
        Uri a2 = m2342a(this.f2759a.mo9920az(), "unmute");
        if (a2 != null) {
            this.f2759a.mo9923c(a2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Ad updated with muteImageFilename = ");
        sb.append(this.f2759a.mo9919ay());
        sb.append(", unmuteImageFilename = ");
        sb.append(this.f2759a.mo9920az());
        mo10068a(sb.toString());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public Uri mo10095e(String str) {
        return mo10087a(str, this.f2759a.mo9868F(), true);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public String mo10096f(final String str) {
        if (!C1277l.m3042b(str)) {
            return null;
        }
        C1215b a = C1215b.m2733a(this.f2745b).mo10324a(str).mo10330b("GET").mo10323a("").mo10322a(0).mo10328a();
        final AtomicReference atomicReference = new AtomicReference(null);
        this.f2745b.mo10184J().mo10294a(a, new C1212a(), new C1214c<String>() {
            /* renamed from: a */
            public void mo9301a(int i) {
                C1133c cVar = C1133c.this;
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to load resource from '");
                sb.append(str);
                sb.append("'");
                cVar.mo10072d(sb.toString());
            }

            /* renamed from: a */
            public void mo9302a(String str, int i) {
                atomicReference.set(str);
            }
        });
        String str2 = (String) atomicReference.get();
        if (str2 != null) {
            this.f2763f.mo10020a((long) str2.length());
        }
        return str2;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public void mo10097i() {
        if (this.f2760c != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Rendered new ad:");
            sb.append(this.f2759a);
            mo10068a(sb.toString());
            this.f2760c.adReceived(this.f2759a);
            this.f2760c = null;
        }
    }

    public void run() {
        if (this.f2759a.mo9872J()) {
            mo10068a("Subscribing to timeout events...");
            this.f2745b.mo10176A().mo9629a((C1042a) this);
        }
    }
}
