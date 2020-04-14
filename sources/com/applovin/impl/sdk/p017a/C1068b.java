package com.applovin.impl.sdk.p017a;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.applovin.impl.adview.C0842m;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.p019b.C1096c;

/* renamed from: com.applovin.impl.sdk.a.b */
public class C1068b {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C1192i f2122a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C0842m f2123b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public AlertDialog f2124c;

    public C1068b(C0842m mVar, C1192i iVar) {
        this.f2122a = iVar;
        this.f2123b = mVar;
    }

    /* renamed from: a */
    public void mo9760a() {
        this.f2123b.runOnUiThread(new Runnable() {
            public void run() {
                if (C1068b.this.f2124c != null) {
                    C1068b.this.f2124c.dismiss();
                }
            }
        });
    }

    /* renamed from: b */
    public void mo9761b() {
        this.f2123b.runOnUiThread(new Runnable() {
            public void run() {
                Builder builder = new Builder(C1068b.this.f2123b);
                builder.setTitle((CharSequence) C1068b.this.f2122a.mo10202a(C1096c.f2354bP));
                builder.setMessage((CharSequence) C1068b.this.f2122a.mo10202a(C1096c.f2355bQ));
                builder.setCancelable(false);
                builder.setPositiveButton((CharSequence) C1068b.this.f2122a.mo10202a(C1096c.f2357bS), new OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        C1068b.this.f2123b.continueVideo();
                        C1068b.this.f2123b.resumeReportRewardTask();
                    }
                });
                builder.setNegativeButton((CharSequence) C1068b.this.f2122a.mo10202a(C1096c.f2356bR), new OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        C1068b.this.f2123b.skipVideo();
                        C1068b.this.f2123b.resumeReportRewardTask();
                    }
                });
                C1068b.this.f2124c = builder.show();
            }
        });
    }

    /* renamed from: c */
    public void mo9762c() {
        this.f2123b.runOnUiThread(new Runnable() {
            public void run() {
                Builder builder = new Builder(C1068b.this.f2123b);
                builder.setTitle((CharSequence) C1068b.this.f2122a.mo10202a(C1096c.f2359bU));
                builder.setMessage((CharSequence) C1068b.this.f2122a.mo10202a(C1096c.f2360bV));
                builder.setCancelable(false);
                builder.setPositiveButton((CharSequence) C1068b.this.f2122a.mo10202a(C1096c.f2362bX), null);
                builder.setNegativeButton((CharSequence) C1068b.this.f2122a.mo10202a(C1096c.f2361bW), new OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        C1068b.this.f2123b.dismiss();
                    }
                });
                C1068b.this.f2124c = builder.show();
            }
        });
    }

    /* renamed from: d */
    public boolean mo9763d() {
        AlertDialog alertDialog = this.f2124c;
        if (alertDialog != null) {
            return alertDialog.isShowing();
        }
        return false;
    }
}
