package com.tapjoy.internal;

import android.app.Notification;
import android.app.Notification.Action;
import android.app.Notification.Builder;
import android.app.RemoteInput;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo.Scope;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationCompatExtras;
import androidx.core.app.NotificationManagerCompat;
import com.tapjoy.internal.C3215ji.C3216a;
import com.tapjoy.internal.C3215ji.C3218c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestrictTo({Scope.LIBRARY_GROUP})
/* renamed from: com.tapjoy.internal.jj */
final class C3220jj implements C3214jh {

    /* renamed from: a */
    final Builder f7714a;

    /* renamed from: b */
    final C3218c f7715b;

    /* renamed from: c */
    RemoteViews f7716c;

    /* renamed from: d */
    RemoteViews f7717d;

    /* renamed from: e */
    final List f7718e = new ArrayList();

    /* renamed from: f */
    final Bundle f7719f = new Bundle();

    /* renamed from: g */
    int f7720g;

    /* renamed from: h */
    RemoteViews f7721h;

    C3220jj(C3218c cVar) {
        this.f7715b = cVar;
        if (VERSION.SDK_INT >= 26) {
            this.f7714a = new Builder(cVar.f7684a, cVar.f7677H);
        } else {
            this.f7714a = new Builder(cVar.f7684a);
        }
        Notification notification = cVar.f7682M;
        this.f7714a.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, cVar.f7690g).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(cVar.f7686c).setContentText(cVar.f7687d).setContentInfo(cVar.f7692i).setContentIntent(cVar.f7688e).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(cVar.f7689f, (notification.flags & 128) != 0).setLargeIcon(cVar.f7691h).setNumber(cVar.f7693j).setProgress(cVar.f7700q, cVar.f7701r, cVar.f7702s);
        if (VERSION.SDK_INT < 21) {
            this.f7714a.setSound(notification.sound, notification.audioStreamType);
        }
        if (VERSION.SDK_INT >= 16) {
            this.f7714a.setSubText(cVar.f7698o).setUsesChronometer(cVar.f7696m).setPriority(cVar.f7694k);
            Iterator it = cVar.f7685b.iterator();
            while (it.hasNext()) {
                m7493a((C3216a) it.next());
            }
            if (cVar.f7670A != null) {
                this.f7719f.putAll(cVar.f7670A);
            }
            if (VERSION.SDK_INT < 20) {
                if (cVar.f7706w) {
                    this.f7719f.putBoolean(NotificationCompatExtras.EXTRA_LOCAL_ONLY, true);
                }
                if (cVar.f7703t != null) {
                    this.f7719f.putString(NotificationCompatExtras.EXTRA_GROUP_KEY, cVar.f7703t);
                    if (cVar.f7704u) {
                        this.f7719f.putBoolean(NotificationCompatExtras.EXTRA_GROUP_SUMMARY, true);
                    } else {
                        this.f7719f.putBoolean(NotificationManagerCompat.EXTRA_USE_SIDE_CHANNEL, true);
                    }
                }
                if (cVar.f7705v != null) {
                    this.f7719f.putString(NotificationCompatExtras.EXTRA_SORT_KEY, cVar.f7705v);
                }
            }
            this.f7716c = cVar.f7674E;
            this.f7717d = cVar.f7675F;
        }
        if (VERSION.SDK_INT >= 19) {
            this.f7714a.setShowWhen(cVar.f7695l);
            if (VERSION.SDK_INT < 21 && cVar.f7683N != null && !cVar.f7683N.isEmpty()) {
                this.f7719f.putStringArray(NotificationCompat.EXTRA_PEOPLE, (String[]) cVar.f7683N.toArray(new String[cVar.f7683N.size()]));
            }
        }
        if (VERSION.SDK_INT >= 20) {
            this.f7714a.setLocalOnly(cVar.f7706w).setGroup(cVar.f7703t).setGroupSummary(cVar.f7704u).setSortKey(cVar.f7705v);
            this.f7720g = cVar.f7681L;
        }
        if (VERSION.SDK_INT >= 21) {
            this.f7714a.setCategory(cVar.f7709z).setColor(cVar.f7671B).setVisibility(cVar.f7672C).setPublicVersion(cVar.f7673D).setSound(notification.sound, notification.audioAttributes);
            Iterator it2 = cVar.f7683N.iterator();
            while (it2.hasNext()) {
                this.f7714a.addPerson((String) it2.next());
            }
            this.f7721h = cVar.f7676G;
        }
        if (VERSION.SDK_INT >= 24) {
            this.f7714a.setExtras(cVar.f7670A).setRemoteInputHistory(cVar.f7699p);
            if (cVar.f7674E != null) {
                this.f7714a.setCustomContentView(cVar.f7674E);
            }
            if (cVar.f7675F != null) {
                this.f7714a.setCustomBigContentView(cVar.f7675F);
            }
            if (cVar.f7676G != null) {
                this.f7714a.setCustomHeadsUpContentView(cVar.f7676G);
            }
        }
        if (VERSION.SDK_INT >= 26) {
            this.f7714a.setBadgeIconType(cVar.f7678I).setShortcutId(cVar.f7679J).setTimeoutAfter(cVar.f7680K).setGroupAlertBehavior(cVar.f7681L);
            if (cVar.f7708y) {
                this.f7714a.setColorized(cVar.f7707x);
            }
            if (!TextUtils.isEmpty(cVar.f7677H)) {
                this.f7714a.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
    }

    /* renamed from: a */
    public final Builder mo30323a() {
        return this.f7714a;
    }

    /* renamed from: a */
    private void m7493a(C3216a aVar) {
        Bundle bundle;
        if (VERSION.SDK_INT >= 20) {
            Action.Builder builder = new Action.Builder(aVar.f7666e, aVar.f7667f, aVar.f7668g);
            if (aVar.f7663b != null) {
                for (RemoteInput addRemoteInput : C3222jl.m7499a(aVar.f7663b)) {
                    builder.addRemoteInput(addRemoteInput);
                }
            }
            if (aVar.f7662a != null) {
                bundle = new Bundle(aVar.f7662a);
            } else {
                bundle = new Bundle();
            }
            bundle.putBoolean("android.support.allowGeneratedReplies", aVar.f7665d);
            if (VERSION.SDK_INT >= 24) {
                builder.setAllowGeneratedReplies(aVar.f7665d);
            }
            builder.addExtras(bundle);
            this.f7714a.addAction(builder.build());
            return;
        }
        if (VERSION.SDK_INT >= 16) {
            this.f7718e.add(C3221jk.m7495a(this.f7714a, aVar));
        }
    }

    /* renamed from: a */
    static void m7492a(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults &= -2;
        notification.defaults &= -3;
    }
}
