package com.inmobi.media;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import com.facebook.internal.ServerProtocol;

@SuppressLint({"ClickableViewAccessibility"})
/* renamed from: com.inmobi.media.cb */
/* compiled from: MraidMediaProcessor */
public final class C2265cb {
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static final String f4745f = "cb";

    /* renamed from: a */
    public C2600j f4746a;

    /* renamed from: b */
    public C2257by f4747b;

    /* renamed from: c */
    public C2270b f4748c;

    /* renamed from: d */
    public C2271c f4749d;

    /* renamed from: e */
    public C2269a f4750e;

    /* renamed from: com.inmobi.media.cb$a */
    /* compiled from: MraidMediaProcessor */
    public final class C2269a extends BroadcastReceiver {

        /* renamed from: b */
        private String f4755b;

        public C2269a(String str) {
            this.f4755b = str;
        }

        public final void onReceive(Context context, Intent intent) {
            if (intent != null) {
                if ("android.intent.action.HEADSET_PLUG".equals(intent.getAction())) {
                    boolean z = false;
                    int intExtra = intent.getIntExtra(ServerProtocol.DIALOG_PARAM_STATE, 0);
                    C2265cb.f4745f;
                    C2265cb cbVar = C2265cb.this;
                    String str = this.f4755b;
                    if (1 == intExtra) {
                        z = true;
                    }
                    C2265cb.m4595b(cbVar, str, z);
                }
            }
        }
    }

    /* renamed from: com.inmobi.media.cb$b */
    /* compiled from: MraidMediaProcessor */
    public final class C2270b extends BroadcastReceiver {

        /* renamed from: b */
        private String f4757b;

        public C2270b(String str) {
            this.f4757b = str;
        }

        public final void onReceive(Context context, Intent intent) {
            if (intent != null) {
                if ("android.media.RINGER_MODE_CHANGED".equals(intent.getAction())) {
                    int intExtra = intent.getIntExtra("android.media.EXTRA_RINGER_MODE", 2);
                    C2265cb.f4745f;
                    C2265cb.m4592a(C2265cb.this, this.f4757b, 2 != intExtra);
                }
            }
        }
    }

    /* renamed from: com.inmobi.media.cb$c */
    /* compiled from: MraidMediaProcessor */
    public final class C2271c extends ContentObserver {

        /* renamed from: b */
        private Context f4759b;

        /* renamed from: c */
        private int f4760c = -1;

        /* renamed from: d */
        private String f4761d;

        public C2271c(String str, Context context, Handler handler) {
            super(handler);
            this.f4761d = str;
            this.f4759b = context;
        }

        public final void onChange(boolean z) {
            super.onChange(z);
            Context context = this.f4759b;
            if (context != null) {
                int streamVolume = ((AudioManager) context.getSystemService("audio")).getStreamVolume(3);
                if (streamVolume != this.f4760c) {
                    this.f4760c = streamVolume;
                    C2265cb.m4591a(C2265cb.this, this.f4761d, streamVolume);
                }
            }
        }
    }

    public C2265cb(C2600j jVar) {
        this.f4746a = jVar;
    }

    /* renamed from: a */
    public static boolean m4593a() {
        Context c = C2505gd.m5298c();
        if (c == null || 2 == ((AudioManager) c.getSystemService("audio")).getRingerMode()) {
            return false;
        }
        return true;
    }

    /* renamed from: b */
    public final void mo28096b() {
        Context c = C2505gd.m5298c();
        if (c != null) {
            C2270b bVar = this.f4748c;
            if (bVar != null) {
                c.unregisterReceiver(bVar);
                this.f4748c = null;
            }
        }
    }

    /* renamed from: c */
    public final void mo28097c() {
        Context c = C2505gd.m5298c();
        if (!(c == null || this.f4749d == null)) {
            c.getContentResolver().unregisterContentObserver(this.f4749d);
            this.f4749d = null;
        }
    }

    /* renamed from: d */
    public static boolean m4596d() {
        Context c = C2505gd.m5298c();
        if (c == null) {
            return false;
        }
        return ((AudioManager) c.getSystemService("audio")).isWiredHeadsetOn();
    }

    /* renamed from: e */
    public final void mo28098e() {
        Context c = C2505gd.m5298c();
        if (c != null) {
            C2269a aVar = this.f4750e;
            if (aVar != null) {
                c.unregisterReceiver(aVar);
                this.f4750e = null;
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m4592a(C2265cb cbVar, String str, boolean z) {
        C2600j jVar = cbVar.f4746a;
        if (jVar != null) {
            StringBuilder sb = new StringBuilder("fireDeviceMuteChangeEvent(");
            sb.append(z);
            sb.append(");");
            jVar.mo28624a(str, sb.toString());
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m4595b(C2265cb cbVar, String str, boolean z) {
        C2600j jVar = cbVar.f4746a;
        if (jVar != null) {
            StringBuilder sb = new StringBuilder("fireHeadphonePluggedEvent(");
            sb.append(z);
            sb.append(");");
            jVar.mo28624a(str, sb.toString());
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m4591a(C2265cb cbVar, String str, int i) {
        C2600j jVar = cbVar.f4746a;
        if (jVar != null) {
            StringBuilder sb = new StringBuilder("fireDeviceVolumeChangeEvent(");
            sb.append(i);
            sb.append(");");
            jVar.mo28624a(str, sb.toString());
        }
    }
}
