package com.tapjoy.internal;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources.NotFoundException;
import android.os.Bundle;
import com.facebook.share.internal.MessengerShareContentUtility;

/* renamed from: com.tapjoy.internal.hb */
public final class C1833hb extends C1858p {

    /* renamed from: c */
    private static C1833hb f3839c;

    /* renamed from: b */
    public static synchronized C1833hb m3584b(Context context) {
        C1833hb hbVar;
        synchronized (C1833hb.class) {
            if (f3839c == null) {
                f3839c = new C1833hb(context);
            }
            hbVar = f3839c;
        }
        return hbVar;
    }

    private C1833hb(Context context) {
        super(context, new C3251r() {
            /* renamed from: a */
            public final String mo18143a(Context context) {
                return C3144hj.m7269a(context).f7429b.getString("gcm.senderIds", "");
            }

            /* renamed from: a */
            public final void mo18146a(Context context, String str) {
                C3249n.m7541a(C3144hj.m7269a(context).f7429b, "gcm.senderIds", str);
            }

            /* renamed from: b */
            public final String mo18148b(Context context) {
                return C3144hj.m7269a(context).f7429b.getString("gcm.regId", "");
            }

            /* renamed from: b */
            public final void mo18150b(Context context, String str) {
                C3249n.m7541a(C3144hj.m7269a(context).f7429b, "gcm.regId", str);
            }

            /* renamed from: c */
            public final boolean mo18152c(Context context) {
                return C3144hj.m7269a(context).f7429b.getBoolean("gcm.stale", true);
            }

            /* renamed from: a */
            public final void mo18147a(Context context, boolean z) {
                C3249n.m7542a(C3144hj.m7269a(context).f7429b, "gcm.stale", z);
            }

            /* renamed from: d */
            public final int mo18153d(Context context) {
                return C3144hj.m7269a(context).f7429b.getInt("gcm.appVersion", Integer.MIN_VALUE);
            }

            /* renamed from: a */
            public final void mo18144a(Context context, int i) {
                C3249n.m7540a(C3144hj.m7269a(context).f7429b, "gcm.appVersion", i);
            }

            /* renamed from: e */
            public final boolean mo18154e(Context context) {
                return C3144hj.m7269a(context).f7429b.getBoolean("gcm.onServer", false);
            }

            /* renamed from: b */
            public final void mo18151b(Context context, boolean z) {
                C3144hj.m7269a(context).mo30218a(z);
            }

            /* renamed from: f */
            public final long mo18155f(Context context) {
                return C3144hj.m7269a(context).f7429b.getLong("gcm.onServerExpirationTime", 0);
            }

            /* renamed from: a */
            public final void mo18145a(Context context, long j) {
                Editor edit = C3144hj.m7269a(context).f7429b.edit();
                edit.putLong("gcm.onServerExpirationTime", j);
                edit.apply();
            }

            /* renamed from: g */
            public final int mo18156g(Context context) {
                return C3144hj.m7269a(context).f7429b.getInt("gcm.backoff", 0);
            }

            /* renamed from: b */
            public final void mo18149b(Context context, int i) {
                C3249n.m7540a(C3144hj.m7269a(context).f7429b, "gcm.backoff", i);
            }
        });
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public final void mo18142e(String str) {
        if (str != null && str.length() > 0) {
            String[] strArr = {str};
            super.mo18208a(this.f3909a);
            super.mo18209a(strArr[0]);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo18137a(Context context, String str) {
        new Object[1][0] = str;
        C1831gz.m3555a(context).mo18120a(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo18139b(String str) {
        new Object[1][0] = str;
        mo18210a();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo18138a(Context context, Intent intent) {
        Context context2 = context;
        Intent intent2 = intent;
        Object[] objArr = {intent2, intent.getExtras()};
        String stringExtra = intent2.getStringExtra("fiverocks");
        if (stringExtra == null) {
            return false;
        }
        if (C1835hc.m3607a(context).mo18170f()) {
            C1831gz.m3555a(context).mo18128b(stringExtra);
            return true;
        }
        String stringExtra2 = intent2.getStringExtra("title");
        String stringExtra3 = intent2.getStringExtra("message");
        if (stringExtra3 != null) {
            Bundle extras = intent.getExtras();
            Object obj = extras.get("rich");
            Object obj2 = extras.get("sound");
            String string = extras.getString(MessengerShareContentUtility.ATTACHMENT_PAYLOAD);
            Object obj3 = extras.get("always");
            String str = "true";
            boolean z = str.equals(obj3) || Boolean.TRUE.equals(obj3);
            Object obj4 = extras.get("repeatable");
            boolean z2 = str.equals(obj4) || Boolean.TRUE.equals(obj4);
            String string2 = extras.getString("placement");
            int b = m3583b(extras.get("nid"));
            String string3 = extras.getString("channel_id");
            if (z || !C1831gz.m3555a(context).mo18131d()) {
                Notification a = m3580a(context, stringExtra, C1852jq.m3667a(stringExtra2), stringExtra3, m3582a(obj), m3582a(obj2), string, string2, b, string3);
                if (C1831gz.m3555a(context).mo18125a(context2, stringExtra, z2)) {
                    m3581a(context2, b, a);
                }
            }
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m3582a(Object obj) {
        return Boolean.TRUE.equals(obj) || "true".equals(obj);
    }

    /* renamed from: b */
    public static int m3583b(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).intValue();
        }
        if (obj instanceof String) {
            try {
                return Integer.parseInt((String) obj);
            } catch (NumberFormatException unused) {
            }
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo18136a(int i) {
        new Object[1][0] = Integer.valueOf(i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final boolean mo18140c(String str) {
        new Object[1][0] = str;
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public final boolean mo18141d(String str) {
        new Object[1][0] = str;
        return false;
    }

    /* renamed from: a */
    public static void m3581a(Context context, int i, Notification notification) {
        ((NotificationManager) context.getSystemService("notification")).notify(i, notification);
    }

    /* renamed from: a */
    private static int m3579a(Bundle bundle, String str, Context context) {
        if (bundle != null) {
            Object obj = bundle.get(str);
            if (obj instanceof Integer) {
                int intValue = ((Integer) obj).intValue();
                try {
                    if ("drawable".equals(context.getResources().getResourceTypeName(intValue))) {
                        return intValue;
                    }
                } catch (NotFoundException unused) {
                }
            }
            if (obj != null) {
                Object[] objArr = {str};
                if (C3124gw.f7370a) {
                    C1861x.m3698a(4, "Tapjoy", "meta-data of {} invalid", objArr);
                }
            }
        }
        return 0;
    }

    /* JADX WARNING: type inference failed for: r5v1, types: [java.lang.CharSequence] */
    /* JADX WARNING: type inference failed for: r6v1, types: [java.lang.CharSequence] */
    /* JADX WARNING: type inference failed for: r6v2, types: [android.text.Spanned] */
    /* JADX WARNING: type inference failed for: r5v2, types: [android.text.Spanned] */
    /* JADX WARNING: type inference failed for: r5v3, types: [java.lang.CharSequence] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 3 */
    @javax.annotation.Nullable
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.app.Notification m3580a(android.content.Context r3, java.lang.String r4, java.lang.String r5, java.lang.String r6, boolean r7, boolean r8, java.lang.String r9, java.lang.String r10, int r11, java.lang.String r12) {
        /*
            android.content.Intent r0 = new android.content.Intent
            android.content.Context r1 = r3.getApplicationContext()
            java.lang.Class<com.tapjoy.TapjoyReceiver> r2 = com.tapjoy.TapjoyReceiver.class
            r0.<init>(r1, r2)
            java.lang.String r1 = "com.tapjoy.PUSH_CLICK"
            r0.setAction(r1)
            java.lang.String r1 = "com.tapjoy.PUSH_ID"
            r0.putExtra(r1, r4)
            if (r9 == 0) goto L_0x001c
            java.lang.String r4 = "com.tapjoy.PUSH_PAYLOAD"
            r0.putExtra(r4, r9)
        L_0x001c:
            if (r10 == 0) goto L_0x0023
            java.lang.String r4 = "com.tapjoy.PUSH_PLACEMENT"
            r0.putExtra(r4, r10)
        L_0x0023:
            r4 = 134217728(0x8000000, float:3.85186E-34)
            int r9 = android.os.Build.VERSION.SDK_INT
            r10 = 19
            if (r9 != r10) goto L_0x002d
            r4 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x002d:
            android.content.Context r9 = r3.getApplicationContext()
            android.app.PendingIntent r4 = android.app.PendingIntent.getBroadcast(r9, r11, r0, r4)
            r9 = 0
            if (r4 != 0) goto L_0x0039
            return r9
        L_0x0039:
            android.content.pm.PackageManager r10 = r3.getPackageManager()
            java.lang.String r11 = r3.getPackageName()
            r0 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r11 = r10.getApplicationInfo(r11, r0)     // Catch:{ NameNotFoundException -> 0x00fc }
            int r0 = r5.length()
            if (r0 != 0) goto L_0x0052
            java.lang.CharSequence r5 = r10.getApplicationLabel(r11)
            goto L_0x0058
        L_0x0052:
            if (r7 == 0) goto L_0x0058
            android.text.Spanned r5 = android.text.Html.fromHtml(r5)
        L_0x0058:
            if (r7 == 0) goto L_0x005e
            android.text.Spanned r6 = android.text.Html.fromHtml(r6)
        L_0x005e:
            android.os.Bundle r7 = r11.metaData
            java.lang.String r10 = "com.tapjoy.notification.icon"
            int r7 = m3579a(r7, r10, r3)
            if (r7 != 0) goto L_0x0072
            int r7 = r11.icon
            if (r7 == 0) goto L_0x006f
            int r7 = r11.icon
            goto L_0x0072
        L_0x006f:
            r7 = 17301651(0x1080093, float:2.4979667E-38)
        L_0x0072:
            android.os.Bundle r10 = r11.metaData
            java.lang.String r0 = "com.tapjoy.notification.icon.large"
            int r10 = m3579a(r10, r0, r3)
            if (r10 == 0) goto L_0x0085
            android.content.res.Resources r0 = r3.getResources()
            android.graphics.Bitmap r10 = android.graphics.BitmapFactory.decodeResource(r0, r10)
            goto L_0x0086
        L_0x0085:
            r10 = r9
        L_0x0086:
            java.lang.String r0 = "tapjoy"
            if (r12 != 0) goto L_0x0096
            android.os.Bundle r1 = r11.metaData
            if (r1 == 0) goto L_0x0096
            android.os.Bundle r11 = r11.metaData
            java.lang.String r12 = "com.tapjoy.notification.default_channel_id"
            java.lang.String r12 = r11.getString(r12, r0)
        L_0x0096:
            int r11 = android.os.Build.VERSION.SDK_INT
            r1 = 26
            if (r11 < r1) goto L_0x00bb
            java.lang.String r9 = "notification"
            java.lang.Object r9 = r3.getSystemService(r9)
            android.app.NotificationManager r9 = (android.app.NotificationManager) r9
            if (r12 == 0) goto L_0x00af
            android.app.NotificationChannel r11 = r9.getNotificationChannel(r12)
            if (r11 != 0) goto L_0x00ad
            goto L_0x00af
        L_0x00ad:
            r9 = r12
            goto L_0x00bb
        L_0x00af:
            android.app.NotificationChannel r11 = new android.app.NotificationChannel
            r12 = 3
            java.lang.String r1 = "Tapjoy"
            r11.<init>(r0, r1, r12)
            r9.createNotificationChannel(r11)
            r9 = r0
        L_0x00bb:
            com.tapjoy.internal.ji$c r11 = new com.tapjoy.internal.ji$c
            r11.<init>(r3, r9)
            com.tapjoy.internal.ji$c r3 = r11.mo30328a(r7)
            com.tapjoy.internal.ji$c r3 = r3.mo30336c(r5)
            com.tapjoy.internal.ji$c r3 = r3.mo30332a(r5)
            com.tapjoy.internal.ji$c r3 = r3.mo30334b(r6)
            com.tapjoy.internal.ji$c r3 = r3.mo30329a(r4)
            com.tapjoy.internal.ji$c r3 = r3.mo30327a()
            com.tapjoy.internal.ji$c r3 = r3.mo30335c()
            com.tapjoy.internal.ji$b r4 = new com.tapjoy.internal.ji$b
            r4.<init>()
            com.tapjoy.internal.ji$b r4 = r4.mo30324a(r5)
            com.tapjoy.internal.ji$b r4 = r4.mo30326b(r6)
            com.tapjoy.internal.ji$c r3 = r3.mo30331a(r4)
            if (r8 == 0) goto L_0x00f2
            r3.mo30333b()
        L_0x00f2:
            if (r10 == 0) goto L_0x00f7
            r3.mo30330a(r10)
        L_0x00f7:
            android.app.Notification r3 = r3.mo30337d()
            return r3
        L_0x00fc:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C1833hb.m3580a(android.content.Context, java.lang.String, java.lang.String, java.lang.String, boolean, boolean, java.lang.String, java.lang.String, int, java.lang.String):android.app.Notification");
    }
}
