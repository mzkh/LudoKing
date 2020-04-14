package com.tapjoy.internal;

import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo.Scope;
import androidx.core.app.NotificationCompatExtras;
import java.util.ArrayList;

/* renamed from: com.tapjoy.internal.ji */
public final class C3215ji {

    /* renamed from: com.tapjoy.internal.ji$a */
    public static class C3216a {

        /* renamed from: a */
        final Bundle f7662a;

        /* renamed from: b */
        final C3222jl[] f7663b;

        /* renamed from: c */
        final C3222jl[] f7664c;

        /* renamed from: d */
        boolean f7665d;

        /* renamed from: e */
        public int f7666e;

        /* renamed from: f */
        public CharSequence f7667f;

        /* renamed from: g */
        public PendingIntent f7668g;
    }

    /* renamed from: com.tapjoy.internal.ji$b */
    public static class C3217b extends C3219d {

        /* renamed from: e */
        private CharSequence f7669e;

        /* renamed from: a */
        public final C3217b mo30324a(CharSequence charSequence) {
            this.f7711b = C3218c.m7478d(charSequence);
            return this;
        }

        /* renamed from: b */
        public final C3217b mo30326b(CharSequence charSequence) {
            this.f7669e = C3218c.m7478d(charSequence);
            return this;
        }

        @RestrictTo({Scope.LIBRARY_GROUP})
        /* renamed from: a */
        public final void mo30325a(C3214jh jhVar) {
            if (VERSION.SDK_INT >= 16) {
                BigTextStyle bigText = new BigTextStyle(jhVar.mo30323a()).setBigContentTitle(this.f7711b).bigText(this.f7669e);
                if (this.f7713d) {
                    bigText.setSummaryText(this.f7712c);
                }
            }
        }
    }

    /* renamed from: com.tapjoy.internal.ji$c */
    public static class C3218c {

        /* renamed from: A */
        Bundle f7670A;

        /* renamed from: B */
        int f7671B = 0;

        /* renamed from: C */
        int f7672C = 0;

        /* renamed from: D */
        Notification f7673D;

        /* renamed from: E */
        RemoteViews f7674E;

        /* renamed from: F */
        RemoteViews f7675F;

        /* renamed from: G */
        RemoteViews f7676G;

        /* renamed from: H */
        String f7677H;

        /* renamed from: I */
        int f7678I = 0;

        /* renamed from: J */
        String f7679J;

        /* renamed from: K */
        long f7680K;

        /* renamed from: L */
        int f7681L = 0;

        /* renamed from: M */
        Notification f7682M = new Notification();
        @Deprecated

        /* renamed from: N */
        public ArrayList f7683N;
        @RestrictTo({Scope.LIBRARY_GROUP})

        /* renamed from: a */
        public Context f7684a;
        @RestrictTo({Scope.LIBRARY_GROUP})

        /* renamed from: b */
        public ArrayList f7685b = new ArrayList();

        /* renamed from: c */
        CharSequence f7686c;

        /* renamed from: d */
        CharSequence f7687d;

        /* renamed from: e */
        PendingIntent f7688e;

        /* renamed from: f */
        PendingIntent f7689f;

        /* renamed from: g */
        RemoteViews f7690g;

        /* renamed from: h */
        Bitmap f7691h;

        /* renamed from: i */
        CharSequence f7692i;

        /* renamed from: j */
        int f7693j;

        /* renamed from: k */
        int f7694k;

        /* renamed from: l */
        boolean f7695l = true;

        /* renamed from: m */
        boolean f7696m;

        /* renamed from: n */
        C3219d f7697n;

        /* renamed from: o */
        CharSequence f7698o;

        /* renamed from: p */
        CharSequence[] f7699p;

        /* renamed from: q */
        int f7700q;

        /* renamed from: r */
        int f7701r;

        /* renamed from: s */
        boolean f7702s;

        /* renamed from: t */
        String f7703t;

        /* renamed from: u */
        boolean f7704u;

        /* renamed from: v */
        String f7705v;

        /* renamed from: w */
        boolean f7706w = false;

        /* renamed from: x */
        boolean f7707x;

        /* renamed from: y */
        boolean f7708y;

        /* renamed from: z */
        String f7709z;

        public C3218c(@NonNull Context context, @NonNull String str) {
            this.f7684a = context;
            this.f7677H = str;
            this.f7682M.when = System.currentTimeMillis();
            this.f7682M.audioStreamType = -1;
            this.f7694k = 0;
            this.f7683N = new ArrayList();
        }

        /* renamed from: a */
        public final C3218c mo30328a(int i) {
            this.f7682M.icon = i;
            return this;
        }

        /* renamed from: a */
        public final C3218c mo30332a(CharSequence charSequence) {
            this.f7686c = m7478d(charSequence);
            return this;
        }

        /* renamed from: b */
        public final C3218c mo30334b(CharSequence charSequence) {
            this.f7687d = m7478d(charSequence);
            return this;
        }

        /* renamed from: a */
        public final C3218c mo30329a(PendingIntent pendingIntent) {
            this.f7688e = pendingIntent;
            return this;
        }

        /* renamed from: c */
        public final C3218c mo30336c(CharSequence charSequence) {
            this.f7682M.tickerText = m7478d(charSequence);
            return this;
        }

        /* renamed from: a */
        public final C3218c mo30330a(Bitmap bitmap) {
            this.f7691h = bitmap;
            return this;
        }

        /* renamed from: b */
        public final C3218c mo30333b() {
            this.f7682M.defaults = 1;
            return this;
        }

        /* renamed from: c */
        public final C3218c mo30335c() {
            this.f7694k = 0;
            return this;
        }

        /* renamed from: a */
        public final C3218c mo30331a(C3219d dVar) {
            if (this.f7697n != dVar) {
                this.f7697n = dVar;
                C3219d dVar2 = this.f7697n;
                if (dVar2 != null) {
                    dVar2.mo30338a(this);
                }
            }
            return this;
        }

        /* renamed from: d */
        public final Notification mo30337d() {
            Notification notification;
            C3220jj jjVar = new C3220jj(this);
            C3219d dVar = jjVar.f7715b.f7697n;
            if (dVar != null) {
                dVar.mo30325a((C3214jh) jjVar);
            }
            if (VERSION.SDK_INT >= 26) {
                notification = jjVar.f7714a.build();
            } else if (VERSION.SDK_INT >= 24) {
                notification = jjVar.f7714a.build();
                if (jjVar.f7720g != 0) {
                    if (!(notification.getGroup() == null || (notification.flags & 512) == 0 || jjVar.f7720g != 2)) {
                        C3220jj.m7492a(notification);
                    }
                    if (notification.getGroup() != null && (notification.flags & 512) == 0 && jjVar.f7720g == 1) {
                        C3220jj.m7492a(notification);
                    }
                }
            } else if (VERSION.SDK_INT >= 21) {
                jjVar.f7714a.setExtras(jjVar.f7719f);
                notification = jjVar.f7714a.build();
                if (jjVar.f7716c != null) {
                    notification.contentView = jjVar.f7716c;
                }
                if (jjVar.f7717d != null) {
                    notification.bigContentView = jjVar.f7717d;
                }
                if (jjVar.f7721h != null) {
                    notification.headsUpContentView = jjVar.f7721h;
                }
                if (jjVar.f7720g != 0) {
                    if (!(notification.getGroup() == null || (notification.flags & 512) == 0 || jjVar.f7720g != 2)) {
                        C3220jj.m7492a(notification);
                    }
                    if (notification.getGroup() != null && (notification.flags & 512) == 0 && jjVar.f7720g == 1) {
                        C3220jj.m7492a(notification);
                    }
                }
            } else if (VERSION.SDK_INT >= 20) {
                jjVar.f7714a.setExtras(jjVar.f7719f);
                notification = jjVar.f7714a.build();
                if (jjVar.f7716c != null) {
                    notification.contentView = jjVar.f7716c;
                }
                if (jjVar.f7717d != null) {
                    notification.bigContentView = jjVar.f7717d;
                }
                if (jjVar.f7720g != 0) {
                    if (!(notification.getGroup() == null || (notification.flags & 512) == 0 || jjVar.f7720g != 2)) {
                        C3220jj.m7492a(notification);
                    }
                    if (notification.getGroup() != null && (notification.flags & 512) == 0 && jjVar.f7720g == 1) {
                        C3220jj.m7492a(notification);
                    }
                }
            } else {
                int i = VERSION.SDK_INT;
                String str = NotificationCompatExtras.EXTRA_ACTION_EXTRAS;
                if (i >= 19) {
                    SparseArray a = C3221jk.m7497a(jjVar.f7718e);
                    if (a != null) {
                        jjVar.f7719f.putSparseParcelableArray(str, a);
                    }
                    jjVar.f7714a.setExtras(jjVar.f7719f);
                    notification = jjVar.f7714a.build();
                    if (jjVar.f7716c != null) {
                        notification.contentView = jjVar.f7716c;
                    }
                    if (jjVar.f7717d != null) {
                        notification.bigContentView = jjVar.f7717d;
                    }
                } else if (VERSION.SDK_INT >= 16) {
                    notification = jjVar.f7714a.build();
                    Bundle a2 = C3215ji.m7474a(notification);
                    Bundle bundle = new Bundle(jjVar.f7719f);
                    for (String str2 : jjVar.f7719f.keySet()) {
                        if (a2.containsKey(str2)) {
                            bundle.remove(str2);
                        }
                    }
                    a2.putAll(bundle);
                    SparseArray a3 = C3221jk.m7497a(jjVar.f7718e);
                    if (a3 != null) {
                        C3215ji.m7474a(notification).putSparseParcelableArray(str, a3);
                    }
                    if (jjVar.f7716c != null) {
                        notification.contentView = jjVar.f7716c;
                    }
                    if (jjVar.f7717d != null) {
                        notification.bigContentView = jjVar.f7717d;
                    }
                } else {
                    notification = jjVar.f7714a.getNotification();
                }
            }
            if (jjVar.f7715b.f7674E != null) {
                notification.contentView = jjVar.f7715b.f7674E;
            }
            int i2 = VERSION.SDK_INT;
            int i3 = VERSION.SDK_INT;
            if (VERSION.SDK_INT >= 16 && dVar != null) {
                C3215ji.m7474a(notification);
            }
            return notification;
        }

        /* renamed from: d */
        protected static CharSequence m7478d(CharSequence charSequence) {
            if (charSequence == null) {
                return charSequence;
            }
            if (charSequence.length() > 5120) {
                charSequence = charSequence.subSequence(0, 5120);
            }
            return charSequence;
        }

        /* renamed from: a */
        public final C3218c mo30327a() {
            this.f7682M.flags |= 16;
            return this;
        }
    }

    /* renamed from: com.tapjoy.internal.ji$d */
    public static abstract class C3219d {
        @RestrictTo({Scope.LIBRARY_GROUP})

        /* renamed from: a */
        protected C3218c f7710a;

        /* renamed from: b */
        CharSequence f7711b;

        /* renamed from: c */
        CharSequence f7712c;

        /* renamed from: d */
        boolean f7713d = false;

        @RestrictTo({Scope.LIBRARY_GROUP})
        /* renamed from: a */
        public void mo30325a(C3214jh jhVar) {
        }

        /* renamed from: a */
        public final void mo30338a(C3218c cVar) {
            if (this.f7710a != cVar) {
                this.f7710a = cVar;
                C3218c cVar2 = this.f7710a;
                if (cVar2 != null) {
                    cVar2.mo30331a(this);
                }
            }
        }
    }

    /* renamed from: a */
    public static Bundle m7474a(Notification notification) {
        if (VERSION.SDK_INT >= 19) {
            return notification.extras;
        }
        if (VERSION.SDK_INT >= 16) {
            return C3221jk.m7496a(notification);
        }
        return null;
    }
}
