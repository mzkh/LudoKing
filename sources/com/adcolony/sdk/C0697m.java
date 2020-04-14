package com.adcolony.sdk;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import org.json.JSONObject;

/* renamed from: com.adcolony.sdk.m */
class C0697m {

    /* renamed from: a */
    static AlertDialog f1029a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C0480ab f1030b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public AlertDialog f1031c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f1032d;

    C0697m() {
        C0476a.m81a("Alert.show", (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                if (!C0476a.m86d() || !(C0476a.m85c() instanceof Activity)) {
                    new C0749a().mo8726a("Missing Activity reference, can't build AlertDialog.").mo8728a(C0748w.f1171g);
                    return;
                }
                if (C0746u.m918d(abVar.mo8220c(), "on_resume")) {
                    C0697m.this.f1030b = abVar;
                } else {
                    C0697m.this.mo8659a(abVar);
                }
            }
        });
    }

    /* access modifiers changed from: 0000 */
    @SuppressLint({"InlinedApi"})
    /* renamed from: a */
    public void mo8659a(final C0480ab abVar) {
        Context c = C0476a.m85c();
        if (c != null) {
            final Builder builder = VERSION.SDK_INT >= 21 ? new Builder(c, 16974374) : new Builder(c, 16974126);
            JSONObject c2 = abVar.mo8220c();
            String b = C0746u.m908b(c2, "message");
            String b2 = C0746u.m908b(c2, "title");
            String b3 = C0746u.m908b(c2, "positive");
            String b4 = C0746u.m908b(c2, "negative");
            builder.setMessage(b);
            builder.setTitle(b2);
            builder.setPositiveButton(b3, new OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    C0697m.this.f1031c = null;
                    dialogInterface.dismiss();
                    JSONObject a = C0746u.m892a();
                    C0746u.m913b(a, "positive", true);
                    C0697m.this.f1032d = false;
                    abVar.mo8216a(a).mo8217b();
                }
            });
            if (!b4.equals("")) {
                builder.setNegativeButton(b4, new OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        C0697m.this.f1031c = null;
                        dialogInterface.dismiss();
                        JSONObject a = C0746u.m892a();
                        C0746u.m913b(a, "positive", false);
                        C0697m.this.f1032d = false;
                        abVar.mo8216a(a).mo8217b();
                    }
                });
            }
            builder.setOnCancelListener(new OnCancelListener() {
                public void onCancel(DialogInterface dialogInterface) {
                    C0697m.this.f1031c = null;
                    C0697m.this.f1032d = false;
                    JSONObject a = C0746u.m892a();
                    C0746u.m913b(a, "positive", false);
                    abVar.mo8216a(a).mo8217b();
                }
            });
            C0543at.m309a((Runnable) new Runnable() {
                public void run() {
                    C0697m.this.f1032d = true;
                    C0697m.this.f1031c = builder.show();
                }
            });
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8657a() {
        C0480ab abVar = this.f1030b;
        if (abVar != null) {
            mo8659a(abVar);
            this.f1030b = null;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public AlertDialog mo8660b() {
        return this.f1031c;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8658a(AlertDialog alertDialog) {
        this.f1031c = alertDialog;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public boolean mo8661c() {
        return this.f1032d;
    }
}
