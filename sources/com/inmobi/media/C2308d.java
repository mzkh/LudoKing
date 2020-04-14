package com.inmobi.media;

import android.content.ComponentName;
import android.content.Context;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;

/* renamed from: com.inmobi.media.d */
/* compiled from: CustomTabHelper */
public class C2308d {
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static final String f4868d = "d";

    /* renamed from: a */
    public CustomTabsClient f4869a;

    /* renamed from: b */
    public CustomTabsServiceConnection f4870b;

    /* renamed from: c */
    public C2311a f4871c = this;

    /* renamed from: com.inmobi.media.d$a */
    /* compiled from: CustomTabHelper */
    public interface C2311a {
        /* renamed from: a */
        void mo27986a();

        /* renamed from: a */
        void mo27987a(int i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        com.inmobi.media.C2513gg.m5340b(r2, r4.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0025, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001e */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m4726a(@androidx.annotation.NonNull android.content.Context r2, @androidx.annotation.NonNull androidx.browser.customtabs.CustomTabsIntent r3, @androidx.annotation.NonNull android.net.Uri r4, @androidx.annotation.NonNull com.inmobi.media.C2452f r5) {
        /*
            java.lang.String r0 = com.inmobi.media.C2361e.m4920a(r2)
            if (r0 != 0) goto L_0x000e
            java.lang.String r3 = r4.toString()     // Catch:{ Exception -> 0x001e }
            r5.mo28359a(r3)     // Catch:{ Exception -> 0x001e }
            return
        L_0x000e:
            android.content.Intent r5 = r3.intent     // Catch:{ Exception -> 0x001e }
            r1 = 268435456(0x10000000, float:2.5243549E-29)
            r5.setFlags(r1)     // Catch:{ Exception -> 0x001e }
            android.content.Intent r5 = r3.intent     // Catch:{ Exception -> 0x001e }
            r5.setPackage(r0)     // Catch:{ Exception -> 0x001e }
            r3.launchUrl(r2, r4)     // Catch:{ Exception -> 0x001e }
            return
        L_0x001e:
            java.lang.String r3 = r4.toString()     // Catch:{ Exception -> 0x0025 }
            com.inmobi.media.C2513gg.m5340b(r2, r3)     // Catch:{ Exception -> 0x0025 }
        L_0x0025:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2308d.m4726a(android.content.Context, androidx.browser.customtabs.CustomTabsIntent, android.net.Uri, com.inmobi.media.f):void");
    }

    /* renamed from: a */
    public final void mo28162a(Context context) {
        if (this.f4869a == null && context != null) {
            String a = C2361e.m4920a(context);
            if (a != null) {
                this.f4870b = new CustomTabsServiceConnection() {
                    public final void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
                        C2308d.this.f4869a = customTabsClient;
                        if (C2308d.this.f4871c != null) {
                            C2308d.this.f4871c.mo27986a();
                        }
                    }

                    public final void onServiceDisconnected(ComponentName componentName) {
                        C2308d.this.f4869a = null;
                        if (C2308d.this.f4871c != null) {
                            C2308d.this.f4871c;
                        }
                    }

                    public final void onBindingDied(ComponentName componentName) {
                        C2308d.this.f4869a = null;
                        if (C2308d.this.f4871c != null) {
                            C2308d.this.f4871c;
                        }
                    }
                };
                CustomTabsClient.bindCustomTabsService(context, a, this.f4870b);
            }
        }
    }
}
