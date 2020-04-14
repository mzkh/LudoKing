package com.tapjoy.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import com.google.firebase.messaging.MessageForwardingService;
import com.google.firebase.messaging.cpp.ListenerService;
import com.tapjoy.TapjoyConstants;
import java.sql.Timestamp;

/* renamed from: com.tapjoy.internal.p */
public abstract class C1858p extends C1859q {

    /* renamed from: a */
    public final Context f3909a;

    /* renamed from: b */
    public final C3251r f3910b;

    /* renamed from: c */
    private boolean f3911c = false;

    public C1858p(Context context, C3251r rVar) {
        this.f3909a = context.getApplicationContext();
        this.f3910b = rVar;
    }

    /* renamed from: b */
    private boolean m3680b() {
        boolean e = this.f3910b.mo18154e(this.f3909a);
        if (e) {
            long f = this.f3910b.mo18155f(this.f3909a);
            if (f != 0 && System.currentTimeMillis() > f) {
                new Object[1][0] = new Timestamp(f);
                return false;
            }
        }
        return e;
    }

    /* renamed from: a */
    public final boolean mo18210a() {
        String a = this.f3910b.mo18143a(this.f3909a);
        if (C1852jq.m3669c(a)) {
            return false;
        }
        mo18209a(a);
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo18209a(String str) {
        String b = this.f3910b.mo18148b(this.f3909a);
        if (b.length() == 0) {
            mo18142e(str);
            return;
        }
        String a = this.f3910b.mo18143a(this.f3909a);
        if (!str.equals(a)) {
            Object[] objArr = {a, str, b};
            mo18142e(str);
            return;
        }
        int d = this.f3910b.mo18153d(this.f3909a);
        int a2 = C1862z.m3700a(this.f3909a);
        if (d != Integer.MIN_VALUE && d != a2) {
            Object[] objArr2 = {Integer.valueOf(d), Integer.valueOf(a2), b};
            mo18142e(str);
        } else if (this.f3910b.mo18152c(this.f3909a)) {
            new Object[1][0] = b;
            mo18142e(str);
        } else if (!m3680b()) {
            Object[] objArr3 = {str, b};
            mo18137a(this.f3909a, b);
        } else {
            Object[] objArr4 = {str, b};
        }
    }

    /* renamed from: e */
    private void mo18142e(String str) {
        this.f3910b.mo18146a(this.f3909a, str);
        this.f3910b.mo18147a(this.f3909a, true);
        if ((this.f3911c || !m3681b(this.f3909a, str)) && m3682c(this.f3909a, str)) {
        }
    }

    /* renamed from: b */
    private static boolean m3681b(Context context, String str) {
        String str2 = "com.google.android.gms";
        try {
            int b = C1862z.m3702b(context.getPackageManager(), str2);
            if (b >= 3159130) {
                Object[] objArr = {Integer.valueOf(b), str};
                Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
                intent.setPackage(str2);
                m3679b(context, intent);
                intent.putExtra("sender", str);
                return context.startService(intent) != null;
            }
            new Object[1][0] = Integer.valueOf(b);
            return false;
        } catch (RuntimeException unused) {
        }
    }

    /* renamed from: c */
    private static boolean m3682c(Context context, String str) {
        String str2 = "com.google.android.gsf";
        try {
            Object[] objArr = {Integer.valueOf(C1862z.m3702b(context.getPackageManager(), str2)), str};
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage(str2);
            m3679b(context, intent);
            intent.putExtra("sender", str);
            if (context.startService(intent) != null) {
                return true;
            }
            return false;
        } catch (RuntimeException unused) {
        }
    }

    /* renamed from: b */
    private static void m3679b(Context context, Intent intent) {
        intent.putExtra(TapjoyConstants.TJC_APP_PLACEMENT, PendingIntent.getBroadcast(context, 0, new Intent(), 0));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo18208a(Context context) {
        this.f3910b.mo18149b(context, 3000);
    }

    /* renamed from: a */
    public final boolean mo18211a(Intent intent) {
        boolean z;
        String action = intent.getAction();
        String str = "com.google.android.gcm.intent.RETRY";
        if ("com.google.android.c2dm.intent.REGISTRATION".equals(action)) {
            String stringExtra = intent.getStringExtra("registration_id");
            String stringExtra2 = intent.getStringExtra("unregistered");
            String stringExtra3 = intent.getStringExtra("error");
            if (stringExtra != null) {
                if (stringExtra.length() > 0) {
                    if (stringExtra.startsWith("|")) {
                        return false;
                    }
                    m3684f(stringExtra);
                    return false;
                } else if (stringExtra2 == null && stringExtra3 == null && !this.f3911c) {
                    this.f3911c = true;
                    mo18210a();
                    return true;
                }
            }
            if (stringExtra2 != null) {
                String b = this.f3910b.mo18148b(this.f3909a);
                mo18208a(this.f3909a);
                this.f3910b.mo18151b(this.f3909a, false);
                this.f3910b.mo18150b(this.f3909a, "");
                this.f3910b.mo18147a(this.f3909a, true);
                mo18139b(b);
                return false;
            } else if (stringExtra3 == null) {
                return false;
            } else {
                if ("SERVICE_NOT_AVAILABLE".equals(stringExtra3)) {
                    z = mo18140c(stringExtra3);
                } else if (!this.f3911c) {
                    mo18140c(stringExtra3);
                    this.f3911c = true;
                    mo18210a();
                    return true;
                } else {
                    z = mo18141d(stringExtra3);
                }
                if (z) {
                    int g = this.f3910b.mo18156g(this.f3909a);
                    new Object[1][0] = Integer.valueOf(g);
                    Intent intent2 = new Intent(str);
                    intent2.setPackage(this.f3909a.getPackageName());
                    ((AlarmManager) this.f3909a.getSystemService(NotificationCompat.CATEGORY_ALARM)).set(3, SystemClock.elapsedRealtime() + ((long) g), PendingIntent.getBroadcast(this.f3909a, 0, intent2, 0));
                    if (g < 3600000) {
                        this.f3910b.mo18149b(this.f3909a, g * 2);
                    }
                }
                return true;
            }
        } else if (MessageForwardingService.ACTION_REMOTE_INTENT.equals(action)) {
            String stringExtra4 = intent.getStringExtra("message_type");
            if (stringExtra4 == null) {
                return mo18138a(this.f3909a, intent);
            }
            if (ListenerService.MESSAGE_TYPE_DELETED.equals(stringExtra4)) {
                String stringExtra5 = intent.getStringExtra("total_deleted");
                if (stringExtra5 != null) {
                    try {
                        int parseInt = Integer.parseInt(stringExtra5);
                        new Object[1][0] = Integer.valueOf(parseInt);
                        mo18136a(parseInt);
                    } catch (NumberFormatException unused) {
                        new Object[1][0] = stringExtra5;
                    }
                }
            } else {
                new Object[1][0] = stringExtra4;
            }
            return false;
        } else if (str.equals(action)) {
            String str2 = intent.getPackage();
            if (str2 == null || !str2.equals(this.f3909a.getPackageName())) {
                new Object[1][0] = str2;
                return false;
            }
            mo18210a();
            return true;
        } else {
            new Object[1][0] = action;
            return false;
        }
    }

    /* renamed from: f */
    private synchronized void m3684f(String str) {
        mo18208a(this.f3909a);
        this.f3910b.mo18147a(this.f3909a, false);
        this.f3910b.mo18144a(this.f3909a, C1862z.m3700a(this.f3909a));
        if (!str.equals(this.f3910b.mo18148b(this.f3909a))) {
            new Object[1][0] = str;
            this.f3910b.mo18151b(this.f3909a, false);
            this.f3910b.mo18150b(this.f3909a, str);
            mo18137a(this.f3909a, str);
        } else if (!m3680b()) {
            new Object[1][0] = str;
            mo18137a(this.f3909a, str);
        } else {
            new Object[1][0] = str;
        }
    }
}
