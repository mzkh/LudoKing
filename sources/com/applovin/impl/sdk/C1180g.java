package com.applovin.impl.sdk;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import com.applovin.impl.sdk.p019b.C1096c;
import com.applovin.impl.sdk.utils.C1246g;
import com.applovin.impl.sdk.utils.C1278m;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.applovin.impl.sdk.g */
class C1180g extends BroadcastReceiver {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static AlertDialog f2882b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final AtomicBoolean f2883c = new AtomicBoolean();
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C1186h f2884a;

    /* renamed from: d */
    private C1278m f2885d;

    /* renamed from: com.applovin.impl.sdk.g$a */
    public interface C1185a {
        /* renamed from: a */
        void mo10167a();

        /* renamed from: b */
        void mo10168b();
    }

    C1180g(C1186h hVar, C1192i iVar) {
        this.f2884a = hVar;
        iVar.mo10220ad().registerReceiver(this, new IntentFilter("com.applovin.application_paused"));
        iVar.mo10220ad().registerReceiver(this, new IntentFilter("com.applovin.application_resumed"));
    }

    /* renamed from: a */
    public void mo10161a(long j, final C1192i iVar, final C1185a aVar) {
        if (j > 0) {
            AlertDialog alertDialog = f2882b;
            if (alertDialog == null || !alertDialog.isShowing()) {
                String str = " milliseconds";
                String str2 = "ConsentAlertManager";
                if (f2883c.getAndSet(true)) {
                    if (j < this.f2885d.mo10438a()) {
                        C1227o v = iVar.mo10249v();
                        StringBuilder sb = new StringBuilder();
                        sb.append("Scheduling consent alert earlier (");
                        sb.append(j);
                        sb.append("ms) than remaining scheduled time (");
                        sb.append(this.f2885d.mo10438a());
                        sb.append("ms)");
                        v.mo10378b(str2, sb.toString());
                        this.f2885d.mo10441d();
                    } else {
                        C1227o v2 = iVar.mo10249v();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Skip scheduling consent alert - one scheduled already with remaining time of ");
                        sb2.append(this.f2885d.mo10438a());
                        sb2.append(str);
                        v2.mo10381d(str2, sb2.toString());
                        return;
                    }
                }
                C1227o v3 = iVar.mo10249v();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Scheduling consent alert for ");
                sb3.append(j);
                sb3.append(str);
                v3.mo10378b(str2, sb3.toString());
                this.f2885d = C1278m.m3045a(j, iVar, new Runnable() {
                    public void run() {
                        String str;
                        C1227o oVar;
                        String str2 = "ConsentAlertManager";
                        if (C1180g.this.f2884a.mo10171c()) {
                            iVar.mo10249v().mo10382e(str2, "Consent dialog already showing, skip showing of consent alert");
                            return;
                        }
                        Activity a = iVar.mo10217aa().mo9735a();
                        if (a == null || !C1246g.m2947a(iVar.mo10179D())) {
                            if (a == null) {
                                oVar = iVar.mo10249v();
                                str = "No parent Activity found - rescheduling consent alert...";
                            } else {
                                oVar = iVar.mo10249v();
                                str = "No internet available - rescheduling consent alert...";
                            }
                            oVar.mo10382e(str2, str);
                            C1180g.f2883c.set(false);
                            C1180g.this.mo10161a(((Long) iVar.mo10202a(C1096c.f2336ay)).longValue(), iVar, aVar);
                            return;
                        }
                        AppLovinSdkUtils.runOnUiThread(new Runnable() {
                            public void run() {
                                C1180g.f2882b = new Builder(iVar.mo10217aa().mo9735a()).setTitle((CharSequence) iVar.mo10202a(C1096c.f2337az)).setMessage((CharSequence) iVar.mo10202a(C1096c.f2286aA)).setCancelable(false).setPositiveButton((CharSequence) iVar.mo10202a(C1096c.f2287aB), new OnClickListener() {
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        aVar.mo10167a();
                                        dialogInterface.dismiss();
                                        C1180g.f2883c.set(false);
                                    }
                                }).setNegativeButton((CharSequence) iVar.mo10202a(C1096c.f2288aC), new OnClickListener() {
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        aVar.mo10168b();
                                        dialogInterface.dismiss();
                                        C1180g.f2883c.set(false);
                                        C1180g.this.mo10161a(((Long) iVar.mo10202a(C1096c.f2335ax)).longValue(), iVar, aVar);
                                    }
                                }).create();
                                C1180g.f2882b.show();
                            }
                        });
                    }
                });
            }
        }
    }

    public void onReceive(Context context, Intent intent) {
        if (this.f2885d != null) {
            String action = intent.getAction();
            if ("com.applovin.application_paused".equals(action)) {
                this.f2885d.mo10439b();
            } else if ("com.applovin.application_resumed".equals(action)) {
                this.f2885d.mo10440c();
            }
        }
    }
}
